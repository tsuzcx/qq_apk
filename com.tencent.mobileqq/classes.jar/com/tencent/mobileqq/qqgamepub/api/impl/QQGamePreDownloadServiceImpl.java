package com.tencent.mobileqq.qqgamepub.api.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigBean;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigProcessor;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qqgamepub.data.QQGameFlowControlConfig;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.DSLPermitReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGamePreDownloadServiceImpl
  implements IQQGamePreDownloadService
{
  public static final String CMD_DSL_FLOW_CONTROL = "/v1/82";
  public static final String QQGAME_BIDS_KEY = "bids";
  public static final String QQGAME_PRELOAD_BUSINESSCODE = "qqgame_pubaccount";
  public static final String QQGAME_PRELOAD_FIELDS_KEY = "__preloadFields";
  public static final String QQGAME_PRELOAD_KEY = "preload";
  public static final String QQGAME_PRELOAD_RES_KEY = "__preloadRes";
  private static final String TAG = "QQGamePub_QQGamePreDownloadServiceImpl";
  private AsyncBack mBidCallback;
  private final WadlTrpcListener mDSLFlowControlListener = new QQGamePreDownloadServiceImpl.8(this);
  private DownloaderFactory mDownloaderFactory;
  private DownloaderInterface mDownloaderInterface;
  private final WadlTrpcListener mFlowControlListener = new QQGamePreDownloadServiceImpl.7(this);
  
  public QQGamePreDownloadServiceImpl()
  {
    if (this.mDownloaderFactory == null)
    {
      this.mDownloaderFactory = new DownloaderFactory(null);
      this.mDownloaderInterface = this.mDownloaderFactory.a(1);
    }
  }
  
  private boolean addToPreDownloadSchedule(DownloadParam paramDownloadParam, QQAppInterface paramQQAppInterface, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    return ((IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10098, "sed", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 3, 0, true, paramAbsPreDownloadTask);
  }
  
  private boolean checkCopyOriginalFile(String paramString1, String paramString2, String paramString3)
  {
    String str1 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getResRecordMd5(paramString2, "", 0);
    String str2 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getResRealMd5(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadPubPushArkRes res checkCopyOriginalFile...originalFileMd5:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",currentFileMd5:");
      localStringBuilder.append(str2);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, localStringBuilder.toString());
    }
    if ((str1 != null) && (str1.equalsIgnoreCase(str2)))
    {
      paramString3 = ((IArkHelper)QRoute.api(IArkHelper.class)).CopyFileToCache(paramString1, paramString3);
      ((IQQGameResService)QRoute.api(IQQGameResService.class)).saveArkResPreloadName(paramString1, paramString2, paramString3);
      return true;
    }
    ((IQQGameResService)QRoute.api(IQQGameResService.class)).deleteFile(paramString3);
    ((IQQGameResService)QRoute.api(IQQGameResService.class)).removeResInfo(paramString2, 0);
    return false;
  }
  
  private void decodeAndPreloadArkRes(String paramString, JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("__preloadFields");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        String str = paramJSONObject.optString(localObject1[i]);
        Object localObject2 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getResPathByUrl(str, 0);
        Object localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("preDownloadPubPushArkRes isAlreadyDownload...url:");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(",filePath:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getArkResRecordName(paramString, str);
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new File(((IQQGameResService)QRoute.api(IQQGameResService.class)).getArkResRecordPath(paramString, str)).exists()))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("preDownloadPubPushArkRes res isAlready exits...url:");
              localStringBuilder.append(str);
              localStringBuilder.append(",filePath:");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(",resName:");
              localStringBuilder.append((String)localObject3);
              localStringBuilder.append(",just return");
              QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, localStringBuilder.toString());
            }
          }
          else if (checkCopyOriginalFile(paramString, str, (String)localObject2)) {}
        }
        else
        {
          localObject2 = ((IQQGameFlowControlService)QRoute.api(IQQGameFlowControlService.class)).getFlowControlConfig(str);
          if ((localObject2 != null) && (((QQGameFlowControlConfig)localObject2).jdField_a_of_type_Int == 2) && (((QQGameFlowControlConfig)localObject2).jdField_a_of_type_Long > NetConnInfoCenter.getServerTime()))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("preDownloadPubPushArkRes ResourceInvalid...url:");
              ((StringBuilder)localObject3).append(str);
              ((StringBuilder)localObject3).append(",flowConfig:");
              ((StringBuilder)localObject3).append(localObject2);
              ((StringBuilder)localObject3).append(",just return");
              QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else {
            ((IQQGameFlowControlService)QRoute.api(IQQGameFlowControlService.class)).checkResFlowControl(str, paramString, this.mFlowControlListener);
          }
        }
        i += 1;
      }
    }
  }
  
  private void decodeAndPreloadFields(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString2);
    if (paramJSONObject == null)
    {
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, "preDownloadPubPushArkRes contentJson is null");
      return;
    }
    tryPreloadArkRes(paramString1, paramJSONObject);
    updateActivityDSL(paramJSONObject);
  }
  
  private void doDownloadDSL(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://youxi.gamecenter.qq.com/dsl/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".json");
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDownloadActivityDSL...dslUrl:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new DownloadParam();
    ((DownloadParam)localObject).url = paramString;
    ((DownloadParam)localObject).filePath = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getFilePath(paramString, 0);
    startDownload((DownloadParam)localObject, new QQGamePreDownloadServiceImpl.5(this, (DownloadParam)localObject, paramString), null);
  }
  
  private void handleOnFileDone(DownloadTask paramDownloadTask, DownloadParam paramDownloadParam)
  {
    if (paramDownloadTask != null) {}
    try
    {
      if ((paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
      {
        Object localObject1 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject2 != null)
          {
            localObject2 = (IPreDownloadController)((QQAppInterface)localObject2).getRuntimeService(IPreDownloadController.class);
            String str = paramDownloadTask.jdField_a_of_type_JavaLangString;
            int i = paramDownloadTask.jdField_a_of_type_Int;
            long l2 = -1L;
            long l1 = l2;
            if (i == 0)
            {
              l1 = l2;
              if (((File)localObject1).exists()) {
                l1 = ((File)localObject1).length();
              }
            }
            ((IPreDownloadController)localObject2).preDownloadSuccess(str, l1);
          }
          if (((File)localObject1).exists())
          {
            localObject1 = MD5Coding.encodeFile2HexStr(((File)localObject1).getAbsolutePath());
            ((IQQGameResService)QRoute.api(IQQGameResService.class)).updateResInfo(paramDownloadTask.jdField_a_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), paramDownloadParam.filePos);
          }
        }
      }
      if (paramDownloadTask == null) {
        break label200;
      }
      reportPreDownloadResult(paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramDownloadTask)
    {
      label189:
      label200:
      break label189;
    }
    QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramDownloadTask, new Object[0]);
  }
  
  public static void reportPreDownloadResult(String paramString, int paramInt)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    paramString = localWadlReportBuilder.a("dc00087").h("769").c("208518").b("").d("104705").e("1").f("160").a(25, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    paramString.a(26, localStringBuilder.toString());
    localWadlReportBuilder.a();
  }
  
  public static void reportPreDownloadSchedule(String paramString, int paramInt)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    paramString = localWadlReportBuilder.a("dc00087").h("769").c("208517").b("").d("104705").e("1").f("160").a(25, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    paramString.a(26, localStringBuilder.toString());
    localWadlReportBuilder.a();
  }
  
  public static void reportSceneDownloadResult(String paramString, int paramInt1, int paramInt2)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    paramString = localWadlReportBuilder.a("dc00087").h("769").c("208518").b("").d("104705").e("1").f("160").a(25, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    paramString = paramString.a(26, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    paramString.a(29, localStringBuilder.toString());
    localWadlReportBuilder.a();
  }
  
  private int transType2Int(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("WiFi")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("4G")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("3G")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("2G")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("5G")) {
      return 6;
    }
    return 0;
  }
  
  public void checkAndCleanExpireCache()
  {
    if (!((IQQGameResService)QRoute.api(IQQGameResService.class)).IsOnlySupportInnerFilePos()) {
      ((IQQGameResService)QRoute.api(IQQGameResService.class)).checkAndCleanExpireCache(0);
    }
    ((IQQGameResService)QRoute.api(IQQGameResService.class)).checkAndCleanExpireCache(1);
  }
  
  protected void checkAndDownloadDSL(Set<String> paramSet)
  {
    if (paramSet == null) {
      return;
    }
    Object localObject1 = getConfig();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkAndDownloadDSL mDownOfflineSwitch:");
      ((StringBuilder)localObject2).append(((QQGamePreDownloadConfigBean)localObject1).b);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject2).toString());
    }
    if (((QQGamePreDownloadConfigBean)localObject1).b == 0) {
      return;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (String)paramSet.next();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkAndDownloadDSL actId:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new QQGameResFlowControl.DSLPermitReq();
        ((QQGameResFlowControl.DSLPermitReq)localObject2).active_id.set((String)localObject1);
        localObject2 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/82", false, ((QQGameResFlowControl.DSLPermitReq)localObject2).toByteArray());
        Bundle localBundle = new Bundle();
        localBundle.putString("activityId", (String)localObject1);
        localObject1 = new TrpcProxy.TrpcListReq();
        ((TrpcProxy.TrpcListReq)localObject1).list.add((MessageMicro)localObject2);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.mDSLFlowControlListener);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject1, localBundle);
      }
    }
  }
  
  protected String getActivityId(String paramString)
  {
    String str = getActivityUrl(paramString);
    boolean bool = HttpUtil.isValidUrl(str);
    paramString = "";
    if (bool)
    {
      try
      {
        Object localObject = Uri.parse(str).getQueryParameter("__mie_dsl");
        paramString = (String)localObject;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label112;
          }
          paramString = ((String)localObject).replace("_hippy", "").replace("_h5", "");
        }
        catch (Exception localException2)
        {
          paramString = (String)localObject;
          localObject = localException2;
        }
        localStringBuilder2 = new StringBuilder();
      }
      catch (Exception localException1)
      {
        paramString = "";
      }
      StringBuilder localStringBuilder2;
      localStringBuilder2.append("updateActivityDSL error=");
      localStringBuilder2.append(localException1);
      QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, localStringBuilder2.toString());
    }
    label112:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("activityId:");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(",activityUrl:");
      localStringBuilder1.append(str);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, localStringBuilder1.toString());
    }
    return paramString;
  }
  
  public String getActivityUrl(String paramString)
  {
    Object localObject3 = "";
    Object localObject2;
    try
    {
      Object localObject1 = URLDecoder.decode(paramString, "UTF-8");
      Uri localUri = Uri.parse((String)localObject1);
      if (TextUtils.isEmpty(localUri.getQueryParameter("__mie_dsl")))
      {
        Iterator localIterator = localUri.getQueryParameterNames().iterator();
        boolean bool;
        do
        {
          do
          {
            do
            {
              localObject1 = localObject3;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (String)localIterator.next();
            } while (TextUtils.isEmpty((CharSequence)localObject1));
            localObject1 = localUri.getQueryParameter((String)localObject1);
          } while (!HttpUtil.isValidUrl((String)localObject1));
          localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
          bool = TextUtils.isEmpty(Uri.parse((String)localObject1).getQueryParameter("__mie_dsl"));
        } while (bool);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, localThrowable, new Object[0]);
      localObject2 = localObject3;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getActivityUrl...msgUrl:");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(",activityUrl:");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject3).toString());
    }
    return localObject2;
  }
  
  public QQGamePreDownloadConfigBean getConfig()
  {
    return QQGamePreDownloadConfigProcessor.a();
  }
  
  public boolean interceptJumpHippy(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    String str2 = ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).getActivityUrl(paramString);
    boolean bool3 = HttpUtil.isValidUrl(str2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (str2.contains("__bundleName")) {
        try
        {
          Object localObject = Uri.parse(str2).getQueryParameter("__bundleName");
          String str1 = Uri.parse(str2).getQueryParameter("__mie_dsl");
          bool1 = bool2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(str1))
            {
              bool3 = str1.endsWith("_hippy");
              bool1 = bool2;
              if (bool3) {
                try
                {
                  localHippyMap.pushString("bundleName", (String)localObject);
                  localHippyMap.pushString("domain", "gamecenter.qq.com");
                  localHippyMap.pushString("errorUrl", paramString);
                  JSONObject localJSONObject = new JSONObject();
                  str1 = getActivityId(paramString);
                  localObject = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getActivityDSL(str1, 0);
                  paramString = str1;
                  if (str1 == null) {
                    paramString = "";
                  }
                  localJSONObject.put("dslId", paramString);
                  paramString = (String)localObject;
                  if (localObject == null) {
                    paramString = "";
                  }
                  localJSONObject.put("dsl", paramString);
                  localHippyMap.pushString("url", localJSONObject.toString());
                  bool1 = new OpenHippyInfo(localHippyMap).openHippy(MobileQQ.sMobileQQ);
                }
                catch (Exception paramString)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("interceptJumpHippy...");
                  ((StringBuilder)localObject).append(paramString);
                  QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
                  bool1 = bool2;
                }
              }
            }
          }
          if (!QLog.isColorLevel()) {
            return bool1;
          }
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("interceptJumpHippy get activityId error=");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("shouldInterceptJumpHippy...url:");
    paramString.append(str2);
    paramString.append(",result:");
    paramString.append(localHippyMap);
    QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, paramString.toString());
    return bool1;
  }
  
  public boolean isNetValidToDownload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      if (transType2Int(paramString[i]) == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void preDownloadPubPushRes(List<QQGameMsgInfo> paramList)
  {
    ThreadManagerV2.excute(new QQGamePreDownloadServiceImpl.4(this, paramList), 64, null, false);
  }
  
  protected void preloadH5Res(JSONArray paramJSONArray)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadH5Res:");
      ((StringBuilder)localObject).append(paramJSONArray);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    if (paramJSONArray != null)
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        ((ArrayList)localObject).add(paramJSONArray.optString(i));
        i += 1;
      }
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramJSONArray = new QQGamePreDownloadServiceImpl.6(this, paramJSONArray);
      this.mBidCallback = paramJSONArray;
      HtmlOffline.a((ArrayList)localObject, localAppRuntime, paramJSONArray, true, true);
    }
  }
  
  public void setArkResNameToMeta(String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        if (getConfig().jdField_a_of_type_Int == 0)
        {
          if (!QLog.isColorLevel()) {
            break label402;
          }
          QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, "setArkResNameToMeta...mPreDownloadSwitch == 0 ,just return");
          return;
        }
        Object localObject1 = paramJSONObject.optString("__preloadFields");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          JSONObject localJSONObject = new JSONObject();
          localObject1 = ((String)localObject1).split(",");
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            String str3 = paramJSONObject.optString((String)localObject2);
            String str4 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getArkResRecordName(paramString, str3);
            if (TextUtils.isEmpty(str4)) {
              break label403;
            }
            long l = System.currentTimeMillis();
            String str5 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getArkResRecordPath(paramString, str3);
            String str1 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getResRecordMd5(str3, "", 0);
            String str2 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getResRealMd5(str5);
            boolean bool = new File(str5).exists();
            if ((bool) && (str1 != null) && (str1.equalsIgnoreCase(str2)))
            {
              localJSONObject.put((String)localObject2, str4);
            }
            else
            {
              ((IQQGameResService)QRoute.api(IQQGameResService.class)).saveArkResPreloadName(paramString, str3, "");
              if (bool) {
                ((IQQGameResService)QRoute.api(IQQGameResService.class)).deleteFile(str5);
              }
            }
            if (!QLog.isColorLevel()) {
              break label403;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("setArkResNameToMeta res checkCopyOriginalFile...originalFileMd5:");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(",currentFileMd5:");
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(",cost:");
            ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
            QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject2).toString());
            break label403;
          }
          paramJSONObject.put("__preloadRes", localJSONObject);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setArkResPreDownloadFileName...retJson:");
          paramString.append(paramJSONObject);
          QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramString.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramString, new Object[0]);
      }
      return;
      label402:
      return;
      label403:
      i += 1;
    }
  }
  
  public void startDownload(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle)
  {
    if (paramDownloadParam == null) {
      return;
    }
    paramDownloadParam.standardlize();
    ThreadManager.post(new QQGamePreDownloadServiceImpl.3(this, paramDownloadParam, paramDownloadListener, paramBundle), 8, null, true);
  }
  
  public void startPreDownload(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadParam:");
          ((StringBuilder)localObject).append(paramDownloadParam);
          ((StringBuilder)localObject).append(",Thread:");
          ((StringBuilder)localObject).append(Thread.currentThread());
          QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
        }
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject != null) && (paramDownloadParam != null) && (!TextUtils.isEmpty(paramDownloadParam.url)))
        {
          if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
            return;
          }
          paramDownloadParam.standardlize();
          checkAndCleanExpireCache();
          paramDownloadListener = new QQGamePreDownloadServiceImpl.1(this, paramDownloadListener, paramDownloadParam);
          boolean bool = addToPreDownloadSchedule(paramDownloadParam, (QQAppInterface)localObject, new QQGamePreDownloadServiceImpl.2(this, (BaseQQAppInterface)localObject, paramDownloadParam.url, paramDownloadParam, paramDownloadListener, paramBundle));
          paramDownloadParam = paramDownloadParam.url;
          if (bool)
          {
            i = 1;
            reportPreDownloadSchedule(paramDownloadParam, i);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramDownloadParam)
      {
        QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramDownloadParam, new Object[0]);
        return;
      }
      int i = 0;
    }
  }
  
  protected void tryPreloadArkRes(String paramString, JSONObject paramJSONObject)
  {
    QQGamePreDownloadConfigBean localQQGamePreDownloadConfigBean = getConfig();
    if (localQQGamePreDownloadConfigBean.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, "preloadArkRes...mPreDownloadSwitch == 0 ,just return");
      }
      return;
    }
    if (!isNetValidToDownload(localQQGamePreDownloadConfigBean.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("preloadArkRes...netValidToDownload is false ,just return -- mPreDownloadNetType：");
        paramString.append(localQQGamePreDownloadConfigBean.jdField_a_of_type_JavaLangString);
        paramString.append(",curNetType:");
        paramString.append(NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ));
        QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, paramString.toString());
      }
      return;
    }
    decodeAndPreloadArkRes(paramString, paramJSONObject);
  }
  
  protected void updateActivityDSL(JSONObject paramJSONObject)
  {
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      HashSet localHashSet = new HashSet();
      while (localIterator.hasNext())
      {
        Object localObject = paramJSONObject.opt((String)localIterator.next());
        if ((localObject instanceof String))
        {
          localObject = getActivityId((String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localHashSet.add(localObject);
          }
        }
      }
      checkAndDownloadDSL(localHashSet);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramJSONObject, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */