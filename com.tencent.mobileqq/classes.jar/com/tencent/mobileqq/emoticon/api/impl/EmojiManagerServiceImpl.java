package com.tencent.mobileqq.emoticon.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiManagerServiceImpl
  implements IEmojiManagerService
{
  static final String COLUMN_NAME_FILE_LIST = "fileList";
  private static String JSON_PREFIX = "json_";
  private static int PACKAGE_TYPE_AUDIO = 0;
  private static int PACKAGE_TYPE_VIDEO = 1;
  private static final String TAG = "EmojiManagerServiceImpl";
  public static EmojiListenerManager listenerManager;
  public static int sCurPlayTimes = 0;
  public static long sRecordBeginTime = 0L;
  public static boolean sStartRecord = false;
  DownloadListener coverDownloadListener = new EmojiManagerServiceImpl.2(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public JobQueue emoQueue = new JobQueue(3);
  public DownloadListener emotionDownloadListener = new EmojiManagerServiceImpl.3(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  Map<String, String> encryptKeyMap = new HashMap();
  public boolean haveInitFav = false;
  public boolean haveInitFavWeb = false;
  public boolean haveInitSmallAndNormal = false;
  DownloadListener jsonDownloadListener = new EmojiManagerServiceImpl.1(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  int limitSize = 3000000;
  int localGetKeySeq = 0;
  BaseQQAppInterface mApp = null;
  LRULinkedHashMap<String, ArrayList<String>> mH5MagicFileListCache = new LRULinkedHashMap(20);
  public HashMap<String, String> mapParams = new HashMap();
  public ConcurrentHashMap<String, TaskStatus> statusMap = new ConcurrentHashMap();
  
  private boolean checkH5Resource(String paramString)
  {
    ??? = null;
    for (;;)
    {
      try
      {
        int i;
        synchronized (this.mH5MagicFileListCache)
        {
          if (this.mH5MagicFileListCache.containsKey(paramString)) {
            ??? = (ArrayList)this.mH5MagicFileListCache.get(paramString);
          }
          ??? = ???;
          if (??? == null)
          {
            ??? = new File(EmotionPanelConstans.H5MagicFileListPath.replace("[epId]", paramString));
            if (!((File)???).exists()) {
              return false;
            }
            ??? = new JSONObject(FileUtils.readFileToString((File)???));
            ??? = new ArrayList();
            ??? = ((JSONObject)???).getJSONArray("fileList");
            int j = ((JSONArray)???).length();
            i = 0;
            if (i < j)
            {
              String str = ((JSONArray)???).getString(i);
              if (!TextUtils.isEmpty(str)) {
                ((ArrayList)???).add(str);
              }
            }
            else
            {
              synchronized (this.mH5MagicFileListCache)
              {
                this.mH5MagicFileListCache.put(paramString, ???);
              }
            }
          }
          else
          {
            if (??? != null)
            {
              ??? = ((ArrayList)???).iterator();
              if (((Iterator)???).hasNext())
              {
                paramString = new File((String)((Iterator)???).next());
                if (paramString.exists()) {
                  continue;
                }
                if (QLog.isColorLevel())
                {
                  ??? = TAG;
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("checkH5MagicFacePackageIntact, file miss: ");
                  ((StringBuilder)???).append(paramString);
                  QLog.e((String)???, 2, ((StringBuilder)???).toString());
                }
                return false;
              }
            }
            return true;
          }
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          ??? = TAG;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("checkH5MagicFacePackageIntact, error=");
          ((StringBuilder)???).append(MsfSdkUtils.getStackTraceString(paramString));
          QLog.e((String)???, 2, ((StringBuilder)???).toString());
        }
        return false;
      }
    }
  }
  
  private boolean checkMagicPackage(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramFile = FileUtils.readFileContent(paramFile);
    int j;
    int i;
    Object localObject;
    if (paramFile != null)
    {
      paramFile = paramFile.split("&");
      j = paramFile.length;
      i = 0;
      while (i < j)
      {
        localObject = paramFile[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString3);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject);
        if (!new File(localStringBuilder.toString()).exists()) {
          return false;
        }
        i += 1;
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString3);
    paramString2.append("audio");
    paramString2.append(File.separator);
    paramString2.append("audio.ini");
    paramString2 = new File(paramString2.toString());
    if (!paramString2.exists()) {
      return false;
    }
    paramString2 = FileUtils.readFileContent(paramString2);
    if (paramString2 != null)
    {
      paramString2 = paramString2.split("&");
      j = paramString2.length;
      i = 0;
      while (i < j)
      {
        paramFile = paramString2[i];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append("audio");
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramFile);
        if (!new File(((StringBuilder)localObject).toString()).exists()) {
          return false;
        }
        i += 1;
      }
    }
    if (!checkPackageIntact(paramString1, PACKAGE_TYPE_VIDEO)) {
      return false;
    }
    return checkMagicFileExist(paramString1);
  }
  
  private boolean checkSDCardNoAvailable(Emoticon paramEmoticon)
  {
    if (Utils.b())
    {
      if (Utils.c() < 1048576L)
      {
        QLog.d(TAG, 1, "sdcard check, sdcard full .return.");
        VasReportUtils.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return true;
      }
      return false;
    }
    QLog.d(TAG, 1, "sdcard check, has sdcard FALSE .return.");
    VasReportUtils.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
    return true;
  }
  
  private Emoticon downloadAndGetKey(Emoticon paramEmoticon)
  {
    String str = paramEmoticon.epId;
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class);
    Object localObject1 = localIEmoticonManagerService.syncFindEmoticonPackageById(str);
    Object localObject2 = localIEmoticonManagerService.syncFindEmoticonById(str, paramEmoticon.eId);
    if (localObject1 != null)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = new Object();
      localObject2 = new EmojiManagerServiceImpl.7(this, str, localObject1);
      EmojiListenerManager.a().addEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject2);
      startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
    }
    try
    {
      try
      {
        localObject1.wait(35000L);
      }
      finally
      {
        break label316;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label107:
      break label107;
    }
    EmojiListenerManager.a().removeEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject2);
    localObject1 = localIEmoticonManagerService.syncFindEmoticonPackageById(str);
    paramEmoticon = localIEmoticonManagerService.syncFindEmoticonById(str, paramEmoticon.eId);
    if (localObject1 != null)
    {
      localObject1 = paramEmoticon;
      if (paramEmoticon != null)
      {
        if (((((Emoticon)localObject1).jobType == 0) || (((Emoticon)localObject1).jobType == 2) || (((Emoticon)localObject1).jobType == 4)) && (!((Emoticon)localObject1).hasEncryptKey()))
        {
          paramEmoticon = new ArrayList(1);
          paramEmoticon.add(localObject1);
          localObject2 = new ReqInfo();
          fetchEmoticonEncryptKeys(str, paramEmoticon, (ReqInfo)localObject2);
          if (!((ReqInfo)localObject2).encryptKeysSuccess)
          {
            paramEmoticon = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("downloadAndGetKey fail to getKey, epId: ");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(" eId: ");
            ((StringBuilder)localObject2).append(((Emoticon)localObject1).eId);
            QLog.e(paramEmoticon, 1, ((StringBuilder)localObject2).toString());
            return null;
          }
        }
        return localObject1;
      }
    }
    paramEmoticon = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadAndGetKey fail to download package, epId: ");
    ((StringBuilder)localObject1).append(str);
    QLog.e(paramEmoticon, 1, ((StringBuilder)localObject1).toString());
    return null;
    label316:
    throw paramEmoticon;
  }
  
  private Bundle getPackageBundle(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, EmoticonPackage paramEmoticonPackage)
  {
    int i = paramInt2;
    label164:
    label167:
    label211:
    label217:
    label223:
    StringBuilder localStringBuilder;
    if (i == -1)
    {
      int k = 4;
      paramInt2 = 100;
      int j = 3;
      if (paramInt1 != 1) {
        if (paramInt1 != 3) {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              if (paramInt1 == 6) {
                break label167;
              }
              break label217;
            }
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.status != 2)) {
              break label217;
            }
            if (isSmallEmoticonPackageIntact(paramString))
            {
              if (EmoticonPanelUtils.a(paramEmoticonPackage.updateFlag))
              {
                paramInt1 = k;
              }
              else
              {
                paramInt1 = 3;
                break label211;
              }
            }
            else {
              paramInt1 = 0;
            }
          }
        }
      }
      for (;;)
      {
        paramInt2 = 0;
        break label211;
        if ((paramEmoticonPackage == null) || (paramEmoticonPackage.status != 2)) {
          break label217;
        }
        if (isH5MagicFacePackageIntact(paramString, true, true))
        {
          paramInt1 = j;
          break label164;
          if ((paramEmoticonPackage == null) || (paramEmoticonPackage.status != 2)) {
            break label217;
          }
          if (isMagicFacePackageIntact(paramString, Boolean.valueOf(true)))
          {
            paramInt1 = j;
            break label164;
          }
        }
        paramInt2 = 0;
        paramInt1 = 0;
        break label211;
        if ((paramEmoticonPackage == null) || (paramEmoticonPackage.status != 2)) {
          break label217;
        }
        if (isEmoticonPackageIntact(paramString))
        {
          if (!EmoticonPanelUtils.a(paramEmoticonPackage.updateFlag)) {
            break;
          }
          paramInt1 = k;
          continue;
        }
        paramInt1 = 0;
      }
      i = 0;
      break label223;
      paramInt1 = paramInt4;
      paramInt2 = paramInt6;
      if (QLog.isColorLevel())
      {
        paramEmoticonPackage = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPackageStatus| query result in DB or not DB, epId:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",result=");
        localStringBuilder.append(i);
        localStringBuilder.append(" status=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" progress=");
        localStringBuilder.append(paramInt2);
        QLog.d(paramEmoticonPackage, 2, localStringBuilder.toString());
      }
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
    }
    else if (QLog.isColorLevel())
    {
      paramEmoticonPackage = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPackageStatus| query result in running... result=");
      localStringBuilder.append(i);
      localStringBuilder.append(" status=");
      paramInt2 = paramInt4;
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" progress=");
      paramInt1 = paramInt6;
      localStringBuilder.append(paramInt1);
      QLog.d(paramEmoticonPackage, 2, localStringBuilder.toString());
    }
    else
    {
      paramInt2 = paramInt4;
      paramInt1 = paramInt6;
    }
    paramInt4 = i;
    if (i == -1)
    {
      paramInt4 = 0;
      paramInt1 = 0;
      paramInt2 = 0;
    }
    paramEmoticonPackage = new Bundle();
    paramEmoticonPackage.putString("id", paramString);
    paramEmoticonPackage.putInt("result", paramInt4);
    paramEmoticonPackage.putInt("status", paramInt2);
    paramEmoticonPackage.putInt("pluginStatus", paramInt5);
    paramEmoticonPackage.putLong("pluginSize", paramLong);
    paramEmoticonPackage.putInt("progress", paramInt1);
    paramEmoticonPackage.putInt("dEmojiId", paramInt7);
    paramEmoticonPackage.putInt("flag", paramInt3);
    paramEmoticonPackage.putStringArrayList("srcList", paramArrayList1);
    paramEmoticonPackage.putStringArrayList("urlParamsList", paramArrayList2);
    return paramEmoticonPackage;
  }
  
  private boolean handleDowloadPreviewStaticTask(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramInt & 0x1) == 1)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=");
        ((StringBuilder)localObject2).append(paramEmoticon.epId);
        ((StringBuilder)localObject2).append(" eid=");
        ((StringBuilder)localObject2).append(paramEmoticon.eId);
        ((StringBuilder)localObject2).append(" type=");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = getImgPreviewStaticTask(paramEmoticon);
      if (!FileUtils.fileExists(localObject1[1]))
      {
        localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
        ((DownloadTask)localObject1).J = true;
        ((DownloadTask)localObject1).v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
        paramInt = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, this.mApp);
        if (paramInt != 0)
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("task aio static down fail :epid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.epId);
          ((StringBuilder)localObject2).append(";eid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.eId);
          ((StringBuilder)localObject2).append(";ret = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          localObject1 = paramEmoticon.epId;
          paramEmoticon = paramEmoticon.eId;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramInt);
          localStringBuilder.append("");
          VasReportUtils.a("emotionType", "emotionActionAIO", "9", (String)localObject1, paramEmoticon, (String)localObject2, localStringBuilder.toString(), "", "", "");
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean handleDownloadGifApngTask(Emoticon paramEmoticon, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadAIOEmoticon| Emoticon download emo gif.pid=");
        ((StringBuilder)localObject2).append(paramEmoticon.epId);
        ((StringBuilder)localObject2).append(" eid=");
        ((StringBuilder)localObject2).append(paramEmoticon.eId);
        ((StringBuilder)localObject2).append(" type=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" time:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      int i = paramEmoticon.jobType;
      localObject2 = null;
      if (i != 1)
      {
        if ((paramInt & 0x20) == 32) {
          paramInt = 2;
        } else {
          paramInt = 0;
        }
        localObject3 = handleImgGif(paramEmoticon, paramInt);
        localObject4 = new ReqInfo();
        localObject1 = localObject3;
        if (paramEmoticon.jobType != 3)
        {
          localObject1 = localObject3;
          if (TextUtils.isEmpty(paramEmoticon.encryptKey))
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramEmoticon);
            fetchEmoticonEncryptKeys(paramEmoticon.epId, (ArrayList)localObject1, (ReqInfo)localObject4);
            localObject1 = localObject3;
            if (TextUtils.isEmpty(paramEmoticon.encryptKey))
            {
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Emoticon don't have encryptKey,epId=");
              ((StringBuilder)localObject2).append(paramEmoticon.epId);
              ((StringBuilder)localObject2).append(", eid=");
              ((StringBuilder)localObject2).append(paramEmoticon.eId);
              ((StringBuilder)localObject2).append(" type=");
              ((StringBuilder)localObject2).append(4);
              QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
              VasReportUtils.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return true;
            }
          }
        }
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return true;
      }
      boolean bool = FileUtils.fileExists(localObject1[1]);
      if (!bool)
      {
        localObject2 = new File(localObject1[1]);
        localObject1 = new DownloadTask(localObject1[0], (File)localObject2);
        ((DownloadTask)localObject1).J = true;
        ((DownloadTask)localObject1).v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
        paramInt = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, this.mApp);
        if (paramInt != 0)
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("task gif down fail :epid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.epId);
          ((StringBuilder)localObject2).append(";eid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.eId);
          ((StringBuilder)localObject2).append(":ret = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          localObject1 = paramEmoticon.epId;
          paramEmoticon = paramEmoticon.eId;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append("");
          VasReportUtils.a("emotionType", "emotionActionAIO", "5", (String)localObject1, paramEmoticon, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "", "");
          return true;
        }
      }
      else
      {
        localObject1 = null;
      }
      if ((bool) || (paramEmoticon.jobType == 1)) {}
    }
    for (;;)
    {
      try
      {
        localObject3 = FileUtils.fileToBytes((File)localObject2);
        localObject4 = ((File)localObject2).getAbsolutePath();
        ((File)localObject2).delete();
        if (localObject3 == null)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("task gif 2 fail :epid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.epId);
          ((StringBuilder)localObject3).append(";eid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.eId);
          QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          VasReportUtils.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
          return true;
        }
        if (paramEmoticon.jobType != 3)
        {
          paramInt = EmosmUtils.a((byte[])localObject3, paramEmoticon.encryptKey, (String)localObject4);
        }
        else
        {
          if (paramEmoticon.jobType != 3) {
            break label1359;
          }
          paramInt = EmosmUtils.a((byte[])localObject3, (String)localObject4);
        }
        if (paramInt != 0)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onProgress download encrypt exception, url=");
            localStringBuilder.append(((DownloadTask)localObject1).h);
            QLog.d((String)localObject4, 2, localStringBuilder.toString());
          }
          if ((Utils.b()) && (Utils.c() > 1048576L))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(AppConstants.SDCARD_PATH);
            ((StringBuilder)localObject4).append("err");
            ((StringBuilder)localObject4).append(File.separator);
            ((StringBuilder)localObject4).append(String.valueOf(paramEmoticon.epId));
            ((StringBuilder)localObject4).append("_");
            ((StringBuilder)localObject4).append(paramEmoticon.encryptKey);
            ((StringBuilder)localObject4).append("_");
            ((StringBuilder)localObject4).append(((File)localObject2).getName());
            FileUtils.pushData2File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject4).toString()), (byte[])localObject3, false);
          }
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("task gif save fail :epid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.epId);
          ((StringBuilder)localObject3).append(";eid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.eId);
          ((StringBuilder)localObject3).append(";emosmCode = ");
          ((StringBuilder)localObject3).append(paramInt);
          QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          localObject2 = paramEmoticon.epId;
          localObject3 = paramEmoticon.eId;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject4).append("");
          VasReportUtils.a("emotionType", "emotionActionAIO", "7", (String)localObject2, (String)localObject3, "", ((StringBuilder)localObject4).toString(), "", "", "");
          return true;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onProgress| Emotiocon encode resource done.result=");
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append(" time:");
          ((StringBuilder)localObject3).append(System.currentTimeMillis());
          ((StringBuilder)localObject3).append(" url=");
          ((StringBuilder)localObject3).append(((DownloadTask)localObject1).h);
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject3 = TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onProgress Emotiocon encode resource fail .EXCEPTION:");
          ((StringBuilder)localObject4).append(localThrowable.toString());
          ((StringBuilder)localObject4).append(" time:");
          ((StringBuilder)localObject4).append(System.currentTimeMillis());
          ((StringBuilder)localObject4).append(" url=");
          ((StringBuilder)localObject4).append(((DownloadTask)localObject1).h);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
        }
        VasReportUtils.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return true;
      }
      return false;
      label1359:
      paramInt = 0;
    }
  }
  
  private boolean handleDownloadPreviewTask(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadAIOEmoticon| Emoticon download emo imgPreview.pid=");
        ((StringBuilder)localObject2).append(paramEmoticon.epId);
        ((StringBuilder)localObject2).append(" eid=");
        ((StringBuilder)localObject2).append(paramEmoticon.eId);
        ((StringBuilder)localObject2).append(" type=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" time:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((StringBuilder)localObject2).append(",jobType:");
        ((StringBuilder)localObject2).append(paramEmoticon.jobType);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = getImgPreviewTask(paramEmoticon);
      if (!FileUtils.fileExists(localObject1[1]))
      {
        localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
        ((DownloadTask)localObject1).J = true;
        ((DownloadTask)localObject1).v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
        paramInt = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, this.mApp);
        if (paramInt != 0)
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("task preview down fail :epid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.epId);
          ((StringBuilder)localObject2).append(";eid = ");
          ((StringBuilder)localObject2).append(paramEmoticon.eId);
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          localObject1 = paramEmoticon.epId;
          paramEmoticon = paramEmoticon.eId;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramInt);
          localStringBuilder.append("");
          VasReportUtils.a("emotionType", "emotionActionAIO", "3", (String)localObject1, paramEmoticon, (String)localObject2, localStringBuilder.toString(), "", "", "");
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramEmoticon = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ret:");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d(paramEmoticon, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return false;
  }
  
  private boolean handleDownloadSoundTask(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadAIOEmoticon| Emoticon download emo sound.pid=");
        ((StringBuilder)localObject2).append(paramEmoticon.epId);
        ((StringBuilder)localObject2).append(" eid=");
        ((StringBuilder)localObject2).append(paramEmoticon.eId);
        ((StringBuilder)localObject2).append(" type=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" time:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = getSoundTask(paramEmoticon);
      if (!FileUtils.fileExists(localObject1[1]))
      {
        localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
        ((DownloadTask)localObject1).J = true;
        ((DownloadTask)localObject1).v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
        paramInt = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, this.mApp);
        if (paramInt != 0)
        {
          localObject2 = TAG;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("task sound down fail :epid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.epId);
          ((StringBuilder)localObject3).append(";eid = ");
          ((StringBuilder)localObject3).append(paramEmoticon.eId);
          ((StringBuilder)localObject3).append(";ret = ");
          ((StringBuilder)localObject3).append(paramInt);
          QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          localObject2 = paramEmoticon.epId;
          localObject3 = paramEmoticon.eId;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramInt);
          localStringBuilder.append("");
          VasReportUtils.a("emotionType", "emotionActionAIO", "10", (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString(), "", "", "");
          if (paramEmoticon.isNewSoundEmoticon()) {
            reportSoundEmoticonDownload(paramEmoticon.epId, paramEmoticon.eId, ((DownloadTask)localObject1).c);
          }
          return false;
        }
        if (paramEmoticon.isNewSoundEmoticon()) {
          reportSoundEmoticonDownload(paramEmoticon.epId, paramEmoticon.eId, 0);
        }
      }
    }
    return true;
  }
  
  private void handleImgPreviewStaticTask(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addEmoticonsTask| Emoticon download emo AIO preview static.pid=");
        localStringBuilder.append(paramEmoticon.epId);
        localStringBuilder.append(" eid=");
        localStringBuilder.append(paramEmoticon.eId);
        localStringBuilder.append(" type=");
        localStringBuilder.append(paramInt);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      Object localObject = getImgPreviewStaticTask(paramEmoticon);
      if (!FileUtils.fileExists(localObject[1]))
      {
        paramList.add(localObject[0]);
        paramMap.put(localObject[0], new File(localObject[1]));
        paramList = localObject[0];
        if (paramEmoticon.jobType == 1) {
          paramInt = 15;
        } else {
          paramInt = 8;
        }
        paramBundle.putInt(paramList, paramInt);
      }
    }
  }
  
  private void handleRscGifTask(EmoticonPackage arg1, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, Emoticon paramEmoticon, String[] paramArrayOfString)
  {
    boolean bool;
    if (???.rscType == 1) {
      bool = PngFrameUtil.d(EmotionPanelConstans.pngFramePath.replace("[epId]", paramEmoticon.epId));
    } else {
      bool = FileUtils.fileExists(paramArrayOfString[1]);
    }
    if (!bool)
    {
      paramList.add(paramArrayOfString[0]);
      paramMap.put(paramArrayOfString[0], new File(paramArrayOfString[1]));
      if (???.rscType == 1)
      {
        paramBundle.putInt(paramArrayOfString[0], 16);
        return;
      }
      if (???.jobType != 1)
      {
        paramBundle.putInt(paramArrayOfString[0], 7);
        synchronized (this.encryptKeyMap)
        {
          this.encryptKeyMap.put(paramArrayOfString[0], paramEmoticon.encryptKey);
          return;
        }
      }
    }
  }
  
  private void handleSoundFileTask(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
    {
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addEmoticonsTask| Emoticon download emo sound.pid=");
        localStringBuilder.append(paramEmoticon.epId);
        localStringBuilder.append(" eid=");
        localStringBuilder.append(paramEmoticon.eId);
        localStringBuilder.append(" type=");
        localStringBuilder.append(paramInt);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      Object localObject = getSoundTask(paramEmoticon);
      if (!FileUtils.fileExists(localObject[1]))
      {
        paramList.add(localObject[0]);
        paramMap.put(localObject[0], new File(localObject[1]));
        paramBundle.putInt(localObject[0], 9);
        if (paramEmoticon.isNewSoundEmoticon())
        {
          paramList = new StringBuilder();
          paramList.append(localObject[0]);
          paramList.append("emoticonId");
          paramBundle.putString(paramList.toString(), paramEmoticon.eId);
        }
      }
    }
  }
  
  private boolean isValidEmoPackage(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 == 1)) {
      return true;
    }
    if ((paramInt1 == 3) && (paramInt2 == 3)) {
      return true;
    }
    if ((paramInt1 == 4) && (paramInt2 == 5)) {
      return true;
    }
    if ((paramInt1 == 5) && (paramInt2 == 4)) {
      return true;
    }
    return (paramInt1 == 1) && (paramInt2 == 0);
  }
  
  private void reportSoundEmoticonDownload(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoResID", paramString2);
    localHashMap.put("emoPackageID", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramInt);
    paramString1.append("");
    localHashMap.put("result", paramString1.toString());
    paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
    paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString1.collectPerformance(paramString2, "NewAudioEmoticonVoiceDownload", bool, 0L, 0L, localHashMap, null);
  }
  
  void addAudioTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!checkPackageIntact(paramEmoticonPackage.epId, PACKAGE_TYPE_AUDIO))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmotionPanelConstans.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  void addColorGrayTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int i;
    int j;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      i = 13;
      j = 14;
    }
    else if (paramEmoticonPackage.jobType == 4)
    {
      str1 = paramEmoticonPackage.epId;
      i = 17;
      j = 18;
    }
    else
    {
      i = 3;
      j = 4;
    }
    String str2 = EmosmUtils.c(i, str1);
    String str3 = EmosmUtils.b(3, paramEmoticonPackage.epId);
    if (!FileUtils.fileExists(str3))
    {
      paramList.add(str2);
      paramMap.put(str2, new File(str3));
      paramBundle.putInt(str2, 3);
    }
    str1 = EmosmUtils.c(j, str1);
    paramEmoticonPackage = EmosmUtils.b(4, paramEmoticonPackage.epId);
    if (!FileUtils.fileExists(paramEmoticonPackage))
    {
      paramList.add(str1);
      paramMap.put(str1, new File(paramEmoticonPackage));
      paramBundle.putInt(str1, 4);
    }
  }
  
  public int addEmotionTaskByList(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(i);
      Object localObject;
      StringBuilder localStringBuilder;
      int j;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addEmoticonsTask| Emoticon download emo imgPreview.pid=");
          localStringBuilder.append(localEmoticon.epId);
          localStringBuilder.append(" eid=");
          localStringBuilder.append(localEmoticon.eId);
          localStringBuilder.append(" type=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" time:");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = getImgPreviewTask(localEmoticon);
        if (!FileUtils.fileExists(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType == 1) {
            j = 15;
          } else {
            j = 6;
          }
          paramBundle.putInt((String)localObject, j);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel())
        {
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addEmoticonsTask| Emoticon download emo gif.pid=");
          localStringBuilder.append(localEmoticon.epId);
          localStringBuilder.append(" eid=");
          localStringBuilder.append(localEmoticon.eId);
          localStringBuilder.append(" type=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" time:");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = null;
        if (paramEmoticonPackage.jobType != 1) {
          if (localEmoticon.hasEncryptKey())
          {
            j = paramEmoticonPackage.rscType;
            if ((paramInt & 0x20) == 32) {
              j = 2;
            }
            localObject = handleImgGif(localEmoticon, j);
          }
          else
          {
            return 11009;
          }
        }
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            paramEmoticonPackage = TAG;
            paramArrayList = new StringBuilder();
            paramArrayList.append("addEmoticonsTask| fail Emoticon download emo gif.pid=");
            paramArrayList.append(localEmoticon.epId);
            paramArrayList.append(" eid=");
            paramArrayList.append(localEmoticon.eId);
            QLog.d(paramEmoticonPackage, 2, paramArrayList.toString());
          }
          return 11030;
        }
        handleRscGifTask(paramEmoticonPackage, paramList, paramMap, paramBundle, localEmoticon, (String[])localObject);
      }
      handleImgPreviewStaticTask(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      handleSoundFileTask(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      i += 1;
    }
    return 0;
  }
  
  int addEmotionsTask(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    Object localObject;
    if (paramFile != null) {
      try
      {
        if (paramFile.exists()) {
          paramFile = FileUtils.fileToBytes(paramFile);
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OutOfMemoryError e = ");
        localStringBuilder.append(paramFile.getMessage());
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        paramFile = null;
      }
    }
    paramFile = null;
    if (paramEmoticonPackage.jobType == 4) {
      paramFile = EmotionJsonUtils.parseSmallJson(this.mApp, paramEmoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, paramFile, localArrayList);
    } else {
      paramFile = EmotionJsonUtils.parseJson(this.mApp, paramEmoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, paramFile, localArrayList, localReqInfo);
    }
    if (paramEmoticonPackage.isAPNG == 2) {
      paramInt |= 0x20;
    }
    if (paramFile != null)
    {
      QLog.e(TAG, 1, "addEmotionsTask| parse json error");
      VasReportUtils.a("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
      return 11008;
    }
    if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!IndividuationConfigInfo.a(paramEmoticonPackage.minQQVersion, "8.8.17")))
    {
      paramFile = TAG;
      paramList = new StringBuilder();
      paramList.append("unavailable in current version, min version=");
      paramList.append(paramEmoticonPackage.minQQVersion);
      QLog.e(paramFile, 1, paramList.toString());
      return 11011;
    }
    paramBundle.putBoolean("isUpdate", paramBoolean);
    paramBundle.putSerializable("emoticonList", localArrayList);
    if ((!localReqInfo.encryptKeysSuccess) && (paramEmoticonPackage.jobType != 4))
    {
      int i = 0;
      int j;
      do
      {
        localReqInfo.strGetKeySeq = null;
        if (QLog.isColorLevel())
        {
          paramFile = TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addEmoticonsTask| fetchEncryptKeys count=");
          ((StringBuilder)localObject).append(i);
          QLog.d(paramFile, 2, ((StringBuilder)localObject).toString());
        }
        fetchEmoticonEncryptKeys(paramEmoticonPackage.epId, localArrayList, localReqInfo);
        j = i + 1;
        if (localReqInfo.encryptKeysSuccess) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel())
      {
        paramFile = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addEmoticonsTask| fetchEncryptKeys count=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" encryptKeysSuccess=");
        ((StringBuilder)localObject).append(localReqInfo.encryptKeysSuccess);
        QLog.d(paramFile, 2, ((StringBuilder)localObject).toString());
      }
      if (!localReqInfo.encryptKeysSuccess)
      {
        paramFile = TAG;
        paramList = new StringBuilder();
        paramList.append("addEmoticonsTask| fetchEncryptKeys fail epId=");
        paramList.append(paramEmoticonPackage.epId);
        paramList.append(" encryptGetKeySeq=");
        paramList.append(localReqInfo.strGetKeySeq);
        paramList.append(" encryptKeysResultCode");
        paramList.append(localReqInfo.encryptKeysResultCode);
        QLog.e(paramFile, 1, paramList.toString());
        return 11009;
      }
    }
    if (paramEmoticonPackage.jobType == 4) {
      return addSmallEmoticonTaskByList(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt, paramBoolean);
    }
    return addEmotionTaskByList(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt);
  }
  
  public void addH5MagicChildDownloadTask(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramEmoticonPackage.childEpId)) && (!"0".equals(paramEmoticonPackage.childEpId)))
    {
      if (this.mApp == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleEmotionPackage| handle h5magic chiled emotion and childEpId = ");
        ((StringBuilder)localObject2).append(paramEmoticonPackage.childEpId);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (paramBoolean)
      {
        localObject1 = (EmoticonHandler)this.mApp.getBusinessHandler(EmoticonHandler.a);
        if (localObject1 != null) {
          ((EmoticonHandler)localObject1).a(paramEmoticonPackage.childEpId, 0);
        }
      }
      Object localObject2 = getEmoticonManager().syncFindTabEmoticonPackageById(paramEmoticonPackage.childEpId, 0);
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleEmotionPackage| old childEp = ");
        localStringBuilder.append(localObject2);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleEmotionPackage| childEpId = ");
          ((StringBuilder)localObject2).append(paramEmoticonPackage.childEpId);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).epId = paramEmoticonPackage.childEpId;
        ((EmoticonPackage)localObject1).wordingId = -1L;
        ((EmoticonPackage)localObject1).jobType = 5;
      }
      if (QLog.isColorLevel())
      {
        paramEmoticonPackage = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleEmotionPackage| auto download childEp = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d(paramEmoticonPackage, 2, ((StringBuilder)localObject2).toString());
      }
      pullEmoticonPackage((EmoticonPackage)localObject1, paramBoolean);
    }
  }
  
  void addH5MagicDownloadTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!isH5MagicFacePackageIntact(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = EmosmUtils.f(paramEmoticonPackage.epId);
      paramEmoticonPackage = EmosmUtils.g(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  void addMagicDownloadTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleEmotionPackage|add magic task ");
    }
    addVideoTask(paramList, paramMap, paramEmoticonPackage, paramBundle);
    addAudioTask(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  int addSmallEmoticonTaskByList(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int i = paramArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject1 = (Emoticon)paramArrayList.get(j);
      Object localObject2;
      StringBuilder localStringBuilder;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addEmoticonsTask| Emoticon download emo imgPreview.pid=");
          localStringBuilder.append(((Emoticon)localObject1).epId);
          localStringBuilder.append(" eid=");
          localStringBuilder.append(((Emoticon)localObject1).eId);
          localStringBuilder.append(" type=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" time:");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        localObject2 = getImgPreviewTask((Emoticon)localObject1);
        if ((!FileUtils.fileExists(localObject2[1])) || (paramBoolean))
        {
          paramList.add(localObject2[0]);
          paramMap.put(localObject2[0], new File(localObject2[1]));
          paramBundle.putInt(localObject2[0], 6);
        }
      }
      if (((paramInt & 0x4) != 4) && ((paramInt & 0x20) != 32)) {
        break label420;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addEmoticonsTask| Emoticon download emo gif.pid=");
        localStringBuilder.append(((Emoticon)localObject1).epId);
        localStringBuilder.append(" eid=");
        localStringBuilder.append(((Emoticon)localObject1).eId);
        localStringBuilder.append(" type=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" time:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      localObject1 = handleImgGif((Emoticon)localObject1, paramEmoticonPackage.rscType);
      if ((FileUtils.fileExists(localObject1[1])) && (!paramBoolean)) {
        break label386;
      }
      paramList.add(localObject1[0]);
      label386:
      paramMap.put(localObject1[0], new File(localObject1[1]));
      paramBundle.putInt(localObject1[0], 7);
      label420:
      j += 1;
    }
    return 0;
  }
  
  public void addThumbTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    int i;
    if (paramEmoticonPackage.jobType == 4) {
      i = 19;
    } else {
      i = 2;
    }
    if (paramEmoticonPackage.jobType == 2) {
      str = paramEmoticonPackage.kinId;
    } else {
      str = paramEmoticonPackage.epId;
    }
    String str = EmosmUtils.c(i, str);
    paramEmoticonPackage = EmosmUtils.b(2, paramEmoticonPackage.epId);
    if (!FileUtils.fileExists(paramEmoticonPackage))
    {
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 2);
    }
  }
  
  void addVideoTask(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!checkPackageIntact(paramEmoticonPackage.epId, PACKAGE_TYPE_VIDEO))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmotionPanelConstans.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean canPlayH5Magic()
  {
    Object localObject = this.mApp.getApplication().getSharedPreferences("h5magic_sp_name", 4);
    boolean bool2 = false;
    boolean bool3 = ((SharedPreferences)localObject).getBoolean("h5magic_sp_isplay_key", false);
    boolean bool4 = isDPCSupportH5Magic();
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canPlayH5Magic isPlay = ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(";isDPCSupport = ");
      localStringBuilder.append(bool4);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean checkEmoticonPackageIntact(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1 = EmosmUtils.b(2, paramString);
    Object localObject2;
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cover_pkg_thumb isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = EmosmUtils.b(3, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cover_pkg_color isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = EmosmUtils.b(4, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cover_pkg_gray isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = (ArrayList)getEmoticonManager().syncGetSubEmoticonsByPackageId(paramString, true);
    if (localObject1 != null)
    {
      Object localObject3 = getEmoticonManager().syncFindEmoticonPackageById(paramString, -1);
      int i;
      if (localObject3 != null) {
        i = ((EmoticonPackage)localObject3).rscType;
      } else {
        i = 0;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Emoticon)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("one of encrypts is null!");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          return false;
        }
        if ((((Emoticon)localObject2).jobType == 0) && ((((Emoticon)localObject2).encryptKey == null) || (((Emoticon)localObject2).encryptKey.length() == 0)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("encrypt isn't exist.epId=");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" eId=");
            ((StringBuilder)localObject3).append(((Emoticon)localObject2).eId);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          return false;
        }
        if (!new File(EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId)).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("emo img preview do not be exist! epId=");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" eId=");
            ((StringBuilder)localObject3).append(((Emoticon)localObject2).eId);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          return false;
        }
        if (1 == i) {
          return PngFrameUtil.d(EmotionPanelConstans.pngFramePath.replace("[epId]", paramString));
        }
        if ((localObject3 != null) && (((EmoticonPackage)localObject3).isAPNG == 2)) {
          localObject1 = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId);
        } else {
          localObject1 = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId);
        }
      } while (new File((String)localObject1).exists());
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("emo img encrypt file do not be exist! epId=");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" eId=");
        ((StringBuilder)localObject3).append(((Emoticon)localObject2).eId);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("emoticons do not be exist.epId=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return true;
  }
  
  boolean checkH5MagicFacePackageIntact(String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = (ArrayList)getEmoticonManager().syncGetSubEmoticonsByPackageId(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject1 = (Emoticon)((Iterator)localObject1).next();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkH5MagicFacePackageIntact, one of encrypts is null!");
              ((StringBuilder)localObject2).append(paramString);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            return false;
          }
          StringBuilder localStringBuilder;
          if ((((Emoticon)localObject1).jobType == 4) && ((((Emoticon)localObject1).encryptKey == null) || (((Emoticon)localObject1).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkH5MagicFacePackageIntact, encrypt isn't exist.epId=");
              localStringBuilder.append(paramString);
              localStringBuilder.append(" eId=");
              localStringBuilder.append(((Emoticon)localObject1).eId);
              QLog.d((String)localObject2, 2, localStringBuilder.toString());
            }
            return false;
          }
          if (!new File(EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject1).eId)).exists())
          {
            if (QLog.isColorLevel())
            {
              localObject2 = TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=");
              localStringBuilder.append(paramString);
              localStringBuilder.append(" eId=");
              localStringBuilder.append(((Emoticon)localObject1).eId);
              QLog.d((String)localObject2, 2, localStringBuilder.toString());
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkH5MagicFacePackageIntact, emoticons do not be exist.epId=");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return false;
      }
    }
    Object localObject1 = new File(EmotionPanelConstans.H5MagicRootPath.replace("[epId]", paramString));
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkH5MagicFacePackageIntact, no root path: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    return checkH5Resource(paramString);
  }
  
  boolean checkMagicFacePackageIntact(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)getEmoticonManager().syncGetSubEmoticonsByPackageId(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel())
            {
              paramBoolean = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("one of encrypts is null!");
              ((StringBuilder)localObject1).append(paramString);
              QLog.d(paramBoolean, 2, ((StringBuilder)localObject1).toString());
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("encrypt isn't exist.epId=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(" eId=");
              ((StringBuilder)localObject2).append(paramBoolean.eId);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            return false;
          }
          if (!new File(EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel())
            {
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("emo img preview do not be exist! epId=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(" eId=");
              ((StringBuilder)localObject2).append(paramBoolean.eId);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramBoolean = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("emoticons do not be exist.epId=");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d(paramBoolean, 2, ((StringBuilder)localObject1).toString());
        }
        return false;
      }
    }
    Object localObject2 = MagicfaceResLoader.a();
    String str = EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString);
    paramBoolean = new StringBuilder();
    paramBoolean.append(str);
    paramBoolean.append((String)localObject2);
    paramBoolean.append(File.separator);
    paramBoolean.append("video.ini");
    paramBoolean = paramBoolean.toString();
    Object localObject3 = new File(paramBoolean);
    Object localObject1 = localObject3;
    if (!((File)localObject3).exists())
    {
      localObject2 = "big";
      paramBoolean = new StringBuilder();
      paramBoolean.append(str);
      paramBoolean.append("big");
      paramBoolean.append(File.separator);
      paramBoolean.append("video.ini");
      paramBoolean = paramBoolean.toString();
      localObject3 = new File(paramBoolean);
      localObject1 = localObject3;
      if (!((File)localObject3).exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoConfigPath ==");
      localStringBuilder.append(paramBoolean);
      QLog.i((String)localObject3, 2, localStringBuilder.toString());
    }
    return checkMagicPackage(paramString, (String)localObject2, str, (File)localObject1);
  }
  
  protected boolean checkMagicFileExist(String paramString)
  {
    Object localObject = getEmoticonManager().syncFindEmoticonPackageById(paramString);
    int i;
    if (localObject != null) {
      i = ((EmoticonPackage)localObject).rscType;
    } else {
      i = 0;
    }
    if (1 == i) {
      return PngFrameUtil.d(EmotionPanelConstans.pngFramePath.replace("[epId]", paramString));
    }
    localObject = (ArrayList)getEmoticonManager().syncGetSubEmoticonsByPackageId(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!new File(EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)((ArrayList)localObject).get(0)).eId)).exists()))
    {
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("emo img encrypt file do not be exist! epId=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" eId=");
        localStringBuilder.append(((Emoticon)((ArrayList)localObject).get(0)).eId);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  public boolean checkPackageIntact(String paramString, int paramInt)
  {
    String str = EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString);
    Object localObject1;
    Object localObject2;
    int i;
    if (paramInt == PACKAGE_TYPE_VIDEO)
    {
      paramString = MagicfaceResLoader.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("video.ini");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new File((String)localObject1);
      localObject2 = localObject3;
      if (!((File)localObject3).exists())
      {
        paramString = "big";
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("big");
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("video.ini");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = new File((String)localObject1);
        localObject2 = localObject3;
        if (!((File)localObject3).exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("videoConfigPath ==");
        localStringBuilder.append((String)localObject1);
        QLog.i((String)localObject3, 2, localStringBuilder.toString());
      }
      localObject1 = FileUtils.readFileContent((File)localObject2).split("&");
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = localObject1[paramInt];
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append((String)localObject2);
        if (!new File(((StringBuilder)localObject3).toString()).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == PACKAGE_TYPE_AUDIO)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("audio");
      paramString.append(File.separator);
      paramString.append("audio.ini");
      paramString = new File(paramString.toString());
      if (!paramString.exists()) {
        return false;
      }
      paramString = FileUtils.readFileContent(paramString);
      if (paramString == null) {
        return false;
      }
      paramString = paramString.split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = paramString[paramInt];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("audio");
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        if (!new File(((StringBuilder)localObject2).toString()).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public boolean checkSmallEmoticonPackageIntact(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1 = EmosmUtils.b(2, paramString);
    Object localObject2;
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = EmosmUtils.b(3, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = EmosmUtils.b(4, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject1 = (ArrayList)getEmoticonManager().syncGetSubEmoticonsByPackageId(paramString);
    if (localObject1 != null)
    {
      Object localObject3 = ((ArrayList)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (Emoticon)((Iterator)localObject3).next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("one of encrypts is null!");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          return false;
        }
        if (!new File(EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId)).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" eId=");
            ((StringBuilder)localObject3).append(((Emoticon)localObject2).eId);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          return false;
        }
        localObject1 = getEmoticonManager().syncFindEmoticonPackageById(paramString, -1);
        if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) {
          localObject1 = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId);
        } else {
          localObject1 = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId);
        }
      } while (new File((String)localObject1).exists());
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" eId=");
        ((StringBuilder)localObject3).append(((Emoticon)localObject2).eId);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return true;
  }
  
  public int collectEmoji(Emoticon paramEmoticon)
  {
    paramEmoticon = downloadAndGetKey(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(TAG, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return ((IEmosmService)QRoute.api(IEmosmService.class)).addEmotionToFavorite(null, this.mApp, paramEmoticon, null);
  }
  
  public boolean downloadAIOEmoticon(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadAIOEmoticon|taskvalue:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("，epid:");
      localStringBuilder.append(paramEmoticon.epId);
      localStringBuilder.append("，eid=");
      localStringBuilder.append(paramEmoticon.eId);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (checkSDCardNoAvailable(paramEmoticon)) {
      return false;
    }
    if (handleDownloadPreviewTask(paramEmoticon, paramInt)) {
      return false;
    }
    if (handleDownloadGifApngTask(paramEmoticon, paramInt)) {
      return false;
    }
    if (handleDowloadPreviewStaticTask(paramEmoticon, paramInt)) {
      return false;
    }
    return handleDownloadSoundTask(paramEmoticon, paramInt);
  }
  
  public void fetchEmoticonEncryptKeys(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    int i = EmoticonPanelUtils.b(paramString);
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (i == -1) {
        return;
      }
      int j = this.localGetKeySeq;
      this.localGetKeySeq = (j + 1);
      paramString = Integer.toString(j);
      ((EmoticonHandler)this.mApp.getBusinessHandler(EmoticonHandler.a)).a(i, paramArrayList, paramString);
    }
  }
  
  public void fetchEmoticonEncryptKeys(String paramString, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    int i = EmoticonPanelUtils.b(paramString);
    if ((paramArrayList != null) && (paramArrayList.size() != 0) && (paramReqInfo != null))
    {
      if (i == -1) {
        return;
      }
      paramString = new Object();
      EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.mApp.getBusinessHandler(EmoticonHandler.a);
      localEmoticonHandler.a(new EmojiManagerServiceImpl.6(this, localEmoticonHandler, paramReqInfo, paramString));
      int j = this.localGetKeySeq;
      this.localGetKeySeq = (j + 1);
      String str = Integer.toString(j);
      paramReqInfo.strGetKeySeq = str;
      paramReqInfo.encryptKeysResultCode = 11022;
      localEmoticonHandler.a(i, paramArrayList, str);
      try
      {
        try
        {
          paramString.wait(35000L);
          return;
        }
        finally {}
        return;
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void generateFileList(String paramString1, String arg2)
  {
    Object localObject = FileUtils.getChildFiles(???);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      synchronized (this.mH5MagicFileListCache)
      {
        this.mH5MagicFileListCache.put(paramString1, localObject);
        ??? = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            ???.put(str);
          }
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("fileList", ???);
          FileUtils.writeFile(EmotionPanelConstans.H5MagicFileListPath.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
          return;
        }
        catch (JSONException paramString1)
        {
          QLog.e(TAG, 1, "", paramString1);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
    }
  }
  
  public Bundle getAllDownloadProgress(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)getEmoticonManager().syncGetTabEmoticonPackages(paramInt);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(getPackageStatus(localEmoticonPackage.epId, 1, paramInt));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(getPackageStatus(localEmoticonPackage.epId, 3, paramInt));
        } else if (localEmoticonPackage.jobType == 5) {
          localArrayList.add(getPackageStatus(localEmoticonPackage.epId, 4, paramInt));
        } else if (localEmoticonPackage.jobType == 4) {
          localArrayList.add(getPackageStatus(localEmoticonPackage.epId, 5, paramInt));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle getDownloadProgress(Bundle paramBundle)
  {
    int j;
    int i;
    int k;
    if (paramBundle == null)
    {
      paramBundle = "";
      j = 0;
      i = -1;
      k = 0;
    }
    else
    {
      localObject = paramBundle.getString("id");
      i = paramBundle.getInt("businessType");
      j = paramBundle.getInt("sceneType");
      if (((String)localObject).length() == 0) {}
      while (EmoticonPanelUtils.b((String)localObject) == -1)
      {
        paramBundle = (Bundle)localObject;
        break;
      }
      k = 1;
      paramBundle = (Bundle)localObject;
    }
    Object localObject = new Bundle();
    if (k != 0)
    {
      paramBundle = getPackageStatus(paramBundle, i, j);
      ((Bundle)localObject).putInt("result", paramBundle.getInt("result"));
      ((Bundle)localObject).putString("messge", "");
      ((Bundle)localObject).putInt("id", -1);
      ((Bundle)localObject).putInt("status", paramBundle.getInt("status"));
      ((Bundle)localObject).putInt("pluginStatus", paramBundle.getInt("pluginStatus"));
      ((Bundle)localObject).putLong("pluginSize", paramBundle.getLong("pluginSize"));
      ((Bundle)localObject).putInt("progress", paramBundle.getInt("progress"));
      ((Bundle)localObject).putInt("dynamicEmojiId", paramBundle.getInt("dEmojiId"));
      ((Bundle)localObject).putStringArrayList("dynamicEmojiList", paramBundle.getStringArrayList("srcList"));
      ((Bundle)localObject).putStringArrayList("urlParamsList", paramBundle.getStringArrayList("urlParamsList"));
      return localObject;
    }
    ((Bundle)localObject).putInt("result", 0);
    ((Bundle)localObject).putString("messge", "");
    ((Bundle)localObject).putInt("id", -1);
    ((Bundle)localObject).putInt("status", 0);
    ((Bundle)localObject).putInt("pluginStatus", 0);
    ((Bundle)localObject).putLong("pluginSize", 0L);
    ((Bundle)localObject).putInt("progress", 0);
    ((Bundle)localObject).putInt("dynamicEmojiId", -1);
    ((Bundle)localObject).putStringArrayList("dynamicEmojiList", null);
    ((Bundle)localObject).putStringArrayList("urlParamsList", null);
    return localObject;
  }
  
  public DownloaderInterface getDownloader()
  {
    return ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
  }
  
  public JobQueue getEmoQueue()
  {
    return this.emoQueue;
  }
  
  public IEmojiListenerManager getEmojiListenerManager()
  {
    return listenerManager;
  }
  
  public boolean getEmoticonJsonLodingStatus(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = EmoticonPanelUtils.c(paramString);
      paramString = getDownloader().getTask(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (!paramString.f()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public IEmoticonManagerService getEmoticonManager()
  {
    return (IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class);
  }
  
  public float getEmoticonPackageLoadingProgress(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return -1.0F;
      }
      paramString = (TaskStatus)this.statusMap.get(paramString);
      if (paramString != null) {
        return paramString.getPercent();
      }
    }
    return -1.0F;
  }
  
  public boolean getHaveInitFav()
  {
    return this.haveInitFav;
  }
  
  public boolean getHaveInitSmallAndNormal()
  {
    return this.haveInitSmallAndNormal;
  }
  
  String[] getImgPreviewStaticTask(Emoticon paramEmoticon)
  {
    int i = paramEmoticon.jobType;
    String str2 = null;
    String str1;
    if (i != 1)
    {
      boolean bool = supportExtensionDisplay(paramEmoticon);
      String str3 = EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      str2 = "200";
      if (bool) {
        str1 = String.valueOf(paramEmoticon.extensionWidth);
      } else {
        str1 = "200";
      }
      str3 = str3.replace("[width]", str1);
      str1 = str2;
      if (bool) {
        str1 = String.valueOf(paramEmoticon.extensionHeight);
      }
      str1 = str3.replace("[height]", str1);
      str2 = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      paramEmoticon = str1;
      str1 = str2;
    }
    else
    {
      str1 = null;
      paramEmoticon = str2;
    }
    return new String[] { paramEmoticon, str1 };
  }
  
  String[] getImgPreviewTask(Emoticon paramEmoticon)
  {
    String str1 = paramEmoticon.epId;
    String str2 = paramEmoticon.eId;
    boolean bool;
    if (paramEmoticon.jobType == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return getImgPreviewTask(str1, str2, bool);
  }
  
  public String[] getImgPreviewTask(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = EmotionPanelConstans.smallEmoticonThumbUrl.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString2 = str;
    }
    else
    {
      str = EmotionPanelConstans.emoticonPreviewUrl.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString2 = str;
    }
    return new String[] { paramString2, paramString1 };
  }
  
  public boolean getMagicFaceSendAccessControl()
  {
    int i = sCurPlayTimes;
    if (i == 4)
    {
      if (System.currentTimeMillis() - sRecordBeginTime > 15000L)
      {
        sCurPlayTimes = 0;
        sStartRecord = false;
        return true;
      }
      return false;
    }
    sCurPlayTimes = i + 1;
    if ((sCurPlayTimes == 4) && (!sStartRecord))
    {
      sStartRecord = true;
      sRecordBeginTime = System.currentTimeMillis();
    }
    return true;
  }
  
  Bundle getPackageStatus(String paramString, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  String[] getSoundTask(Emoticon paramEmoticon)
  {
    return new String[] { EmotionPanelConstans.emoticonSoundUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  public ConcurrentHashMap<String, TaskStatus> getStatusMap()
  {
    return this.statusMap;
  }
  
  public void handleEmoticonPackageDownload(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("package download epId:");
      ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramEmoticonPackage != null) && (this.mApp != null))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramDownloadListener = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("netUnSupport epId=");
        ((StringBuilder)localObject1).append(paramEmoticonPackage.epId);
        QLog.e(paramDownloadListener, 1, ((StringBuilder)localObject1).toString());
        listenerManager.a(paramEmoticonPackage, 11003, this.mApp);
        VasReportUtils.a("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("businessType", paramInt);
      ((Bundle)localObject2).putSerializable("emoticonPackage", paramEmoticonPackage);
      ((Bundle)localObject2).putBoolean("newPkgAdd", paramBoolean1);
      ((Bundle)localObject2).putBoolean("wifiAutoDownload", paramBoolean2);
      if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("vipEmoticonKey_auto_");
        ((StringBuilder)localObject1).append(paramEmoticonPackage.epId);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        if (paramEmoticonPackage.jobType == 5)
        {
          ((VasEmojiManager)((IEmosmService)QRoute.api(IEmosmService.class)).getVasEmojiManager(this.mApp)).a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("vipEmoticonKey_");
        ((StringBuilder)localObject1).append(paramEmoticonPackage.epId);
        localObject3 = ((StringBuilder)localObject1).toString();
        localObject1 = EmoticonPanelUtils.c(paramEmoticonPackage.epId);
        if (paramEmoticonPackage.jobType == 4) {
          localObject1 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", paramEmoticonPackage.epId);
        }
        File localFile = new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
        localObject1 = new DownloadTask((String)localObject1, localFile);
        Object localObject4 = new TaskStatus(paramEmoticonPackage.epId, (DownloadTask)localObject1);
        ConcurrentHashMap localConcurrentHashMap = this.statusMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(JSON_PREFIX);
        localStringBuilder.append(paramEmoticonPackage.epId);
        localConcurrentHashMap.put(localStringBuilder.toString(), localObject4);
        ((DownloadTask)localObject1).w = EmojiManagerServiceConstant.EMOTION_TRY_DOWNLOAD;
        ((DownloadTask)localObject1).D = true;
        ((DownloadTask)localObject1).J = true;
        paramInt = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, this.mApp);
        localObject1 = this.statusMap;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(JSON_PREFIX);
        ((StringBuilder)localObject4).append(paramEmoticonPackage.epId);
        ((ConcurrentHashMap)localObject1).remove(((StringBuilder)localObject4).toString());
        listenerManager.a(paramEmoticonPackage, paramInt);
        if (paramInt != 0)
        {
          paramDownloadListener = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("json download faile : resultCode = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.e(paramDownloadListener, 1, ((StringBuilder)localObject1).toString());
          paramInt = EmosmUtils.a(paramInt);
          listenerManager.a(paramEmoticonPackage, paramInt, this.mApp);
          paramEmoticonPackage = paramEmoticonPackage.epId;
          paramDownloadListener = new StringBuilder();
          paramDownloadListener.append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
          paramDownloadListener.append("");
          paramDownloadListener = paramDownloadListener.toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("");
          VasReportUtils.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage, "", paramDownloadListener, ((StringBuilder)localObject1).toString(), "", "", "");
          return;
        }
        paramBoolean2 = EmoticonPanelUtils.a(paramEmoticonPackage);
        if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
          addColorGrayTask(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
        }
        addThumbTask(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
        if (paramEmoticonPackage.isAPNG == 2) {
          paramInt = 42;
        } else {
          paramInt = 14;
        }
        int i;
        if (paramEmoticonPackage.jobType == 5)
        {
          i = 6;
        }
        else
        {
          i = paramInt;
          if (paramEmoticonPackage.jobType == 3) {
            i = paramInt | 0x1;
          }
        }
        paramInt = addEmotionsTask(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, (Bundle)localObject2, i);
        if (paramInt != 0)
        {
          paramDownloadListener = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleEmotionPackage|addEmotionsTask fail : resultCode = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.e(paramDownloadListener, 1, ((StringBuilder)localObject1).toString());
          listenerManager.a(paramEmoticonPackage, paramInt, this.mApp);
          paramEmoticonPackage = paramEmoticonPackage.epId;
          paramDownloadListener = new StringBuilder();
          paramDownloadListener.append(paramInt);
          paramDownloadListener.append("");
          VasReportUtils.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage, "", "", paramDownloadListener.toString(), "", "", "");
          return;
        }
        localObject1 = localObject3;
      }
      if (paramEmoticonPackage.jobType == 3) {
        addMagicDownloadTask(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
      } else if (paramEmoticonPackage.jobType == 5) {
        addH5MagicDownloadTask(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
      }
      Object localObject3 = new DownloadTask(localArrayList, localHashMap, (String)localObject1);
      if (!((String)localObject1).contains("auto")) {
        this.statusMap.put(paramEmoticonPackage.epId, new TaskStatus(paramEmoticonPackage.epId, (DownloadTask)localObject3));
      }
      ((DownloadTask)localObject3).J = true;
      if (localArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleEmotionPackage| urlList is empty");
        }
        ((DownloadTask)localObject3).a((Bundle)localObject2);
        ((DownloadTask)localObject3).a(3);
        paramDownloadListener.onDone((DownloadTask)localObject3);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleEmotionPackage| startDownload");
        }
        getDownloader().startDownload((DownloadTask)localObject3, paramDownloadListener, (Bundle)localObject2);
      }
      if (paramEmoticonPackage.jobType == 5) {
        addH5MagicChildDownloadTask(paramEmoticonPackage, paramBoolean1);
      }
      return;
    }
    QLog.e(TAG, 1, "ep or mApp = null");
  }
  
  public void handleEmoticonPackageDownloaded(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    boolean bool1 = paramBundle.getBoolean("newPkgAdd", false);
    boolean bool2 = paramBundle.getBoolean("isUpdate", false);
    boolean bool3 = paramBundle.getBoolean("wifiAutoDownload", true);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    int i = localEmoticonPackage.jobType;
    int j = 5;
    if ((i != 3) && (localEmoticonPackage.jobType != 5)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDone:epId=");
      localStringBuilder.append(localEmoticonPackage.epId);
      localStringBuilder.append(" task:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" localVersion=");
      localStringBuilder.append(localEmoticonPackage.localVersion);
      localStringBuilder.append(",latestVersion=");
      localStringBuilder.append(localEmoticonPackage.latestVersion);
      localStringBuilder.append(",updateFlag=");
      localStringBuilder.append(localEmoticonPackage.updateFlag);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramInt2 = EmosmUtils.a(paramInt1);
        paramBundle = TAG;
        paramObject = new StringBuilder();
        paramObject.append("handleEmoticonPackageDownloaded : download error ,reportCode = ");
        paramObject.append(paramInt1);
        QLog.e(paramBundle, 1, paramObject.toString());
        listenerManager.a(localEmoticonPackage, paramInt2, this.mApp);
        paramBundle = localEmoticonPackage.epId;
        paramObject = new StringBuilder();
        paramObject.append(paramInt1);
        paramObject.append("");
        VasReportUtils.a("emotionType", "emotionActionDownload", "11", paramBundle, "", "", paramObject.toString(), "", "", "");
        reportEmoticonDownData(localEmoticonPackage, paramInt2, 0L, paramString);
        if (!bool1) {
          continue;
        }
        if (localEmoticonPackage.type != 1) {
          continue;
        }
        paramInt1 = j;
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(String.valueOf(paramInt2), paramInt1);
        return;
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      if ((bool2) && (i == 0))
      {
        paramBundle = (ArrayList)paramBundle.getSerializable("emoticonList");
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          getEmoticonManager().reconstructEmoticonPackage(localEmoticonPackage.epId, paramBundle);
          if (QLog.isColorLevel())
          {
            paramObject = TAG;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("update package:");
            ((StringBuilder)localObject).append(localEmoticonPackage.epId);
            ((StringBuilder)localObject).append(",newEmoticons:");
            ((StringBuilder)localObject).append(paramBundle.size());
            QLog.d(paramObject, 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        if (localEmoticonPackage.latestVersion > localEmoticonPackage.localVersion) {
          localEmoticonPackage.localVersion = localEmoticonPackage.latestVersion;
        }
        localEmoticonPackage.hasReadUpdatePage = false;
      }
      localEmoticonPackage.updateFlag &= 0xFFFFFFFE;
      localEmoticonPackage.status = 2;
      localEmoticonPackage.valid = true;
      paramBundle = getEmoticonManager();
      paramBundle.saveEmoticonPackage(localEmoticonPackage);
      if (localEmoticonPackage.jobType == 5)
      {
        paramObject = this.mApp.getEntityManagerFactory().createEntityManager();
        localObject = paramObject.query(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            isH5MagicFacePackageIntact(((EmoticonPackage)((Iterator)localObject).next()).epId, true, true);
            continue;
          }
        }
        paramObject.close();
      }
      if (bool1) {
        try
        {
          paramBundle.addTabEmoticonPackage(localEmoticonPackage.epId, paramInt2);
          listenerManager.a(localEmoticonPackage, this.mApp);
        }
        finally {}
      }
      if (!bool3) {
        localEmoticonPackage.extraFlags |= 0x2;
      }
      listenerManager.c(localEmoticonPackage);
      reportEmoticonDownData(localEmoticonPackage, 0, paramLong, paramString);
      return;
      QLog.e(TAG, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
      return;
      paramInt1 = 4;
    }
  }
  
  public void handleEmotionEncryptKey(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.b().getSerializable("emoticonPackage");
    File localFile = (File)paramDownloadTask.g.get(paramDownloadTask.h);
    Object localObject4;
    try
    {
      boolean bool = this.encryptKeyMap.containsKey(paramDownloadTask.h);
      Object localObject1 = null;
      if (!bool) {
        break label763;
      }
      synchronized (this.encryptKeyMap)
      {
        localObject4 = (String)this.encryptKeyMap.get(paramDownloadTask.h);
        this.encryptKeyMap.remove(paramDownloadTask.h);
      }
      if (localFile == null) {
        break label769;
      }
      localObject3 = FileUtils.fileToBytes(localFile);
      ??? = localFile.getAbsolutePath();
      localFile.delete();
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      label142:
      int i;
      localThrowable.printStackTrace();
      localObject4 = TAG;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("emotionDownloadListener | onDoneFile onProgress Emotion encode resource fail .EXCEPTION:");
      ((StringBuilder)???).append(localThrowable.toString());
      ((StringBuilder)???).append(" time:");
      ((StringBuilder)???).append(System.currentTimeMillis());
      ((StringBuilder)???).append(" url=");
      ((StringBuilder)???).append(paramDownloadTask.h);
      QLog.e((String)localObject4, 2, ((StringBuilder)???).toString());
      paramDownloadTask.a = true;
      listenerManager.a(localEmoticonPackage, 11020, this.mApp);
      VasReportUtils.a("emotionType", "emotionActionDownload", "9", localEmoticonPackage.epId, "", "", "", "", "", "");
    }
    if ((localEmoticonPackage.jobType != 4) && (localObject4 == null))
    {
      paramDownloadTask.a = true;
      QLog.e(TAG, 1, "emotionDownloadListener | onDoneFile encryptKey loss");
      listenerManager.a(localEmoticonPackage, 11009, this.mApp);
      VasReportUtils.a("emotionType", "emotionActionDownload", "7", localEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (localEmoticonPackage.jobType == 4) {
      i = EmosmUtils.a((byte[])localObject3, (String)???);
    } else {
      i = EmosmUtils.a((byte[])localObject3, (String)localObject4, (String)???);
    }
    if (i != 0)
    {
      localObject4 = TAG;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("emotionDownloadListener | onDoneFile onProgress download encrypt exception, url=");
      ((StringBuilder)???).append(paramDownloadTask.h);
      QLog.e((String)localObject4, 2, ((StringBuilder)???).toString());
      localObject4 = localEmoticonPackage.epId;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(i);
      ((StringBuilder)???).append("");
      VasReportUtils.a("emotionType", "emotionActionDownload", "8", (String)localObject4, "", "", ((StringBuilder)???).toString(), "", "", "");
      if ((Utils.b()) && (Utils.c() > 1048576L))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject4).append("err");
        ((StringBuilder)localObject4).append(File.separator);
        ((StringBuilder)localObject4).append(String.valueOf(localEmoticonPackage.epId));
        ((StringBuilder)localObject4).append("_");
        ((StringBuilder)localObject4).append(localFile.getName());
        FileUtils.pushData2File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject4).toString()), (byte[])localObject3, false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = TAG;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("emotionDownloadListener | onDoneFile Emotion encode resource done.result=");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(" time:");
      ((StringBuilder)localObject4).append(System.currentTimeMillis());
      ((StringBuilder)localObject4).append(" url=");
      ((StringBuilder)localObject4).append(paramDownloadTask.h);
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      return;
    }
    for (;;)
    {
      paramDownloadTask.a = true;
      QLog.e(TAG, 1, "emotionDownloadListener | onDoneFile srcData or filePath = null");
      listenerManager.a(localEmoticonPackage, 11013, this.mApp);
      VasReportUtils.a("emotionType", "emotionActionDownload", "6", localEmoticonPackage.epId, "", "", "", "", "", "");
      return;
      return;
      label763:
      localObject4 = null;
      break;
      label769:
      ??? = null;
      if (localThrowable != null) {
        if (??? != null) {
          break label142;
        }
      }
    }
  }
  
  String[] handleImgGif(Emoticon paramEmoticon, int paramInt)
  {
    String str1;
    if (paramEmoticon.jobType == 3)
    {
      str1 = EmotionPanelConstans.smallGifUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str1 = EmotionPanelConstans.smallApngUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    else
    {
      boolean bool = supportExtensionDisplay(paramEmoticon);
      if (1 == paramInt)
      {
        str1 = EmotionPanelConstans.emoticonPNGZIPUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      }
      else
      {
        str1 = "200";
        String str3;
        if (paramInt == 2)
        {
          str3 = EmotionPanelConstans.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
          if (bool) {
            str2 = String.valueOf(paramEmoticon.extensionWidth);
          } else {
            str2 = "200";
          }
          str2 = str3.replace("[width]", str2);
          if (bool) {
            str1 = String.valueOf(paramEmoticon.extensionHeight);
          }
          str1 = str2.replace("[height]", str1);
        }
        else
        {
          str3 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
          if (bool) {
            str2 = String.valueOf(paramEmoticon.extensionWidth);
          } else {
            str2 = "200";
          }
          str2 = str3.replace("[width]", str2);
          if (bool) {
            str1 = String.valueOf(paramEmoticon.extensionHeight);
          }
          str1 = str2.replace("[height]", str1);
        }
      }
    }
    String str2 = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
    if (paramInt == 2) {
      str2 = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
    }
    paramEmoticon = str2;
    if (1 == paramInt)
    {
      paramEmoticon = str2;
      if (!TextUtils.isEmpty(str2))
      {
        paramEmoticon = new StringBuilder();
        paramEmoticon.append(str2);
        paramEmoticon.append(".zip");
        paramEmoticon = paramEmoticon.toString();
      }
    }
    return new String[] { str1, paramEmoticon };
  }
  
  public void handleMagicOrH5MagicDownloadOnDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject = paramDownloadTask.b();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.h);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    localObject = (File)paramDownloadTask.g.get(paramDownloadTask.h);
    if (i != 2)
    {
      if (i != 16)
      {
        if (i != 21) {
          return;
        }
        try
        {
          FileUtils.uncompressZip(((File)localObject).getAbsolutePath(), EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", localEmoticonPackage.epId), false);
        }
        catch (IOException localIOException1)
        {
          paramDownloadTask.a = true;
          localIOException1.printStackTrace();
        }
        ((File)localObject).delete();
        return;
      }
      try
      {
        FileUtils.uncompressZip(((File)localObject).getAbsolutePath(), EmotionPanelConstans.pngFramePath.replace("[epId]", localIOException1.epId), false);
        ((IEmosmService)QRoute.api(IEmosmService.class)).reparse(this.mApp, localIOException1.epId);
      }
      catch (IOException localIOException2)
      {
        paramDownloadTask.a = true;
        localIOException2.printStackTrace();
      }
      ((File)localObject).delete();
      return;
    }
    listenerManager.notifyEmoticonCoverListener(localIOException2, 2, 0, 0);
  }
  
  public boolean isDPCSupportH5Magic()
  {
    return ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.h5magic_support.name());
  }
  
  public boolean isEmojiCollected(Emoticon paramEmoticon)
  {
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
    Object localObject2 = localIFavroamingDBManagerService.getEmoticonDataList();
    if (((IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId) == null) {
      startDownloadEmosmJson(paramEmoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
    }
    Object localObject1 = localObject2;
    if (!this.haveInitFavWeb) {
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((List)localObject2).isEmpty()) {}
      }
      else
      {
        this.haveInitFavWeb = true;
        if (!NetworkUtil.isNetSupport(MobileQQ.getContext())) {
          return false;
        }
        IFavroamingManagerService localIFavroamingManagerService = (IFavroamingManagerService)this.mApp.getRuntimeService(IFavroamingManagerService.class);
        localObject1 = localObject2;
        if (localIFavroamingManagerService.isInSyncing())
        {
          localObject1 = new Object();
          localObject2 = new EmojiManagerServiceImpl.8(this, localObject1);
          this.mApp.addObserver((BusinessObserver)localObject2);
          localIFavroamingManagerService.syncLocalDel();
        }
      }
    }
    try
    {
      try
      {
        localObject1.wait(35000L);
      }
      finally
      {
        break label205;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label183:
      label205:
      label209:
      int i;
      break label183;
    }
    this.mApp.removeObserver((BusinessObserver)localObject2);
    localObject1 = localIFavroamingDBManagerService.getEmoticonDataList();
    break label209;
    throw paramEmoticon;
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (CustomEmotionData)((List)localObject1).get(i);
        if ((((CustomEmotionData)localObject2).isMarkFace) && (((CustomEmotionData)localObject2).emoPath.equals(paramEmoticon.epId)) && (((CustomEmotionData)localObject2).eId.equals(paramEmoticon.eId))) {
          return "needDel".equals(((CustomEmotionData)localObject2).RomaingType) ^ true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isEmoticonPackageIntact(String paramString)
  {
    boolean bool = checkEmoticonPackageIntact(paramString);
    updatePackageStatus(paramString, bool);
    return bool;
  }
  
  public boolean isH5MagicFacePackageIntact(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isH5MagicFacePackageIntact, epId = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", needKey = ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", needCheckChild = ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = checkH5MagicFacePackageIntact(paramString, paramBoolean1);
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isH5MagicFacePackageIntact, result = ");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = getEmoticonManager().syncFindEmoticonPackageById(paramString);
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      if ((paramBoolean2) && (!TextUtils.isEmpty(((EmoticonPackage)localObject1).childEpId)))
      {
        paramBoolean1 = checkH5MagicFacePackageIntact(((EmoticonPackage)localObject1).childEpId, paramBoolean1);
        if (QLog.isColorLevel())
        {
          localObject2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isH5MagicFacePackageIntact, childEpId = ");
          localStringBuilder.append(((EmoticonPackage)localObject1).childEpId);
          localStringBuilder.append(", childResult = ");
          localStringBuilder.append(paramBoolean1);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        updatePackageStatus(((EmoticonPackage)localObject1).childEpId, paramBoolean1);
      }
      else
      {
        paramBoolean1 = true;
      }
      if ((bool2) && (paramBoolean1)) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      updatePackageStatus(paramString, paramBoolean1);
      bool1 = paramBoolean1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isH5MagicFacePackageIntact, epId=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", result=");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public boolean isH5MagicIntact(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (getEmoticonManager().syncFindEmoticonPackageById(paramString) != null) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (isH5MagicFacePackageIntact(paramString, paramBoolean1, paramBoolean2));
  }
  
  public boolean isMagicFacePackageIntact(String paramString, Boolean paramBoolean)
  {
    boolean bool = checkMagicFacePackageIntact(paramString, paramBoolean);
    updatePackageStatus(paramString, bool);
    return bool;
  }
  
  public boolean isSmallEmoticonPackageIntact(String paramString)
  {
    boolean bool = checkSmallEmoticonPackageIntact(paramString);
    updatePackageStatus(paramString, bool);
    return bool;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    listenerManager = EmojiListenerManager.a();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      ??? = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear History. uin:");
      localStringBuilder.append(this.mApp.getAccount());
      localStringBuilder.append(" app=");
      localStringBuilder.append(String.valueOf(this.mApp));
      QLog.d((String)???, 2, localStringBuilder.toString());
    }
    listenerManager.b();
    if ((this.mApp.getAccount() != null) && (getEmoticonManager() != null)) {
      getEmoticonManager().clearCache();
    }
    synchronized (this.encryptKeyMap)
    {
      this.encryptKeyMap.clear();
      return;
    }
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    pullEmoticonPackage(paramEmoticonPackage, paramBoolean, true, 0);
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    pullEmoticonPackage(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId != null))
    {
      if (this.mApp == null) {
        return;
      }
      if (paramInt == 0) {
        paramEmoticonPackage.aio = true;
      } else if (paramInt == 1) {
        paramEmoticonPackage.kandian = true;
      }
      Object localObject1 = (TaskStatus)this.statusMap.get(paramEmoticonPackage.epId);
      Object localObject2 = this.statusMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(JSON_PREFIX);
      localStringBuilder.append(paramEmoticonPackage.epId);
      localObject2 = (TaskStatus)((ConcurrentHashMap)localObject2).get(localStringBuilder.toString());
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pullEmoticonPackage task exist epId = ");
          ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      if (localObject2 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pullEmoticonPackage jsonTask exist epId = ");
          ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("try to pullEmoticonPackage ep:");
        ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (!EmosmUtils.a(paramEmoticonPackage.epId))
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ep.epId=");
        ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
        ((StringBuilder)localObject2).append(" isNumeral false.");
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        VasReportUtils.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
        return;
      }
      if (!paramEmoticonPackage.isMagicFaceDownloading)
      {
        if ((paramEmoticonPackage.status != 2) || (!EmoticonPanelUtils.a(paramEmoticonPackage.updateFlag))) {
          paramEmoticonPackage.status = 0;
        }
        paramEmoticonPackage.valid = true;
        getEmoticonManager().saveEmoticonPackage(paramEmoticonPackage);
      }
      localObject1 = new File(AppConstants.SDCARD_EMOTICON_SAVE);
      if (!((File)localObject1).exists())
      {
        boolean bool = ((File)localObject1).mkdirs();
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mkdirs success:");
          ((StringBuilder)localObject2).append(bool);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      ThreadManager.excute(new EmojiManagerServiceImpl.5(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 128, null, true);
    }
  }
  
  public void reportEmoticonDownData(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download emoji report actionResult=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",epId=");
      localStringBuilder.append(paramEmoticonPackage.epId);
      localStringBuilder.append(",downloadTime=");
      localStringBuilder.append(paramLong);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = NetworkUtil.getSystemNetwork(this.mApp.getApp().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    Object localObject = this.mApp;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEmoticonPackage.epId);
    localStringBuilder.append("");
    paramEmoticonPackage = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, paramInt, paramEmoticonPackage, localStringBuilder.toString(), paramString, String.valueOf(paramLong));
  }
  
  public boolean sendEmojiToAio(Emoticon paramEmoticon)
  {
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.mApp.getCurrentAccountUin());
    localPicEmoticonInfo.type = 6;
    localPicEmoticonInfo.isAPNG = paramEmoticon.isAPNG;
    paramEmoticon = downloadAndGetKey(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(TAG, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localPicEmoticonInfo.emoticon = paramEmoticon;
    ((IEmosmService)QRoute.api(IEmosmService.class)).updateMarketFaceItemBuilderEmoticonInfo(localPicEmoticonInfo);
    return true;
  }
  
  public void setHaveInitFav(boolean paramBoolean)
  {
    this.haveInitFav = paramBoolean;
  }
  
  public void setHaveInitSmallAndNormal(boolean paramBoolean)
  {
    this.haveInitSmallAndNormal = paramBoolean;
  }
  
  public void setStatusMap(ConcurrentHashMap<String, TaskStatus> paramConcurrentHashMap)
  {
    this.statusMap = paramConcurrentHashMap;
  }
  
  public void startCoverDownload(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    addColorGrayTask(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    addThumbTask(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vipEmoticonKey_cover_");
    localStringBuilder.append(paramEmoticonPackage.epId);
    paramEmoticonPackage = new DownloadTask(localArrayList, localHashMap, localStringBuilder.toString());
    paramEmoticonPackage.y = this.limitSize;
    paramEmoticonPackage.J = true;
    getDownloader().startDownload(paramEmoticonPackage, this.coverDownloadListener, localBundle);
  }
  
  public Bundle startDownloadEmoji(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = String.valueOf(paramBundle.getInt("id"));
    int k = paramBundle.getInt("businessType");
    int j = paramBundle.getInt("sceneType");
    if (EmojiManagerServiceConstant.getStatus(this.mApp, (String)localObject1) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
    }
    paramBundle = getEmoticonManager().syncFindTabEmoticonPackageById((String)localObject1, -1);
    int i = 4;
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      k = paramBundle.status;
      if (k != 2)
      {
        if (k != 3) {
          i = 1;
        }
      }
      else
      {
        pullEmoticonPackage(paramBundle, true, j);
        i = 0;
      }
      if (paramBundle != null)
      {
        localObject1 = this.mApp;
        if (localObject1 != null)
        {
          String str = paramBundle.epId;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramBundle.localVersion);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramBundle.latestVersion);
          ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, str, (String)localObject2, localStringBuilder.toString(), "");
        }
      }
      localBundle.putInt("result", i);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
    }
    paramBundle = getEmoticonManager().syncFindEmoticonPackageById((String)localObject1, -1);
    if ((paramBundle != null) && (!isValidEmoPackage(k, paramBundle.jobType)))
    {
      getEmoticonManager().removeEmoticonPackage(paramBundle);
      paramBundle = null;
    }
    if (paramBundle == null)
    {
      paramBundle = new EmoticonPackage();
      paramBundle.epId = ((String)localObject1);
      paramBundle.wordingId = -1L;
      if (k == 2) {
        paramBundle.jobType = 1;
      }
      for (;;)
      {
        break;
        if (k == 3) {
          paramBundle.jobType = 3;
        } else if (k == 4) {
          paramBundle.jobType = 5;
        } else if (k == 5) {
          paramBundle.jobType = 4;
        } else {
          paramBundle.jobType = 0;
        }
      }
    }
    paramBundle.isMagicFaceDownloading = false;
    if (k == 4) {
      paramBundle.jobType = 5;
    }
    pullEmoticonPackage(paramBundle, true, j);
    localBundle.putInt("result", 0);
    localBundle.putString("messge", "");
    localBundle.putInt("sceneType", j);
    return localBundle;
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt)
  {
    startDownloadEmosmJson(paramString, paramInt, null, false, 0);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt1, int paramInt2)
  {
    startDownloadEmosmJson(paramString, paramInt1, null, false, paramInt2);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    startDownloadEmosmJson(paramString, paramInt, paramBundle, paramBoolean, 0);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      this.emoQueue.excuteOnNetThread(new EmojiManagerServiceImpl.4(this, paramBoolean, paramString, paramInt2, paramInt1, paramBundle), true);
    }
  }
  
  public Bundle stopDownloadPacket(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (TaskStatus)this.statusMap.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramString.getParams(this.mApp);
      paramString.cancel(this.mApp);
      if (localBundle != null)
      {
        paramString = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        if (paramString != null) {
          listenerManager.a(paramString, 11007, this.mApp);
        }
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    paramString.putInt("sceneType", paramInt);
    return paramString;
  }
  
  public void stopEmoticonPackageDownload(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = (TaskStatus)this.statusMap.get(paramString);
    if (paramString != null) {
      paramString.cancel(this.mApp);
    }
  }
  
  public boolean supportExtensionDisplay(Emoticon paramEmoticon)
  {
    return (paramEmoticon != null) && (paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0);
  }
  
  public boolean tasksFileExists(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null) {
      return true;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt & 0x1) == 1)
    {
      if (paramEmoticon.jobType != 1) {
        localObject1 = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool2 = FileUtils.fileExists((String)localObject1);
    }
    else
    {
      bool2 = true;
      localObject1 = localObject2;
    }
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if ((paramInt & 0x4) == 4)
      {
        if (paramEmoticon.jobType != 1) {
          localObject1 = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
        bool1 = FileUtils.fileExists((String)localObject1);
      }
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if ((paramInt & 0x2) == 2) {
        bool2 = FileUtils.fileExists(EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
    }
    bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramEmoticon.isSound)
      {
        bool1 = bool2;
        if ((paramInt & 0x8) == 8) {
          bool1 = FileUtils.fileExists(EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
        }
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if ((paramInt & 0x20) == 32) {
        bool2 = FileUtils.fileExists(EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
    }
    return bool2;
  }
  
  void updatePackageStatus(String paramString, boolean paramBoolean)
  {
    paramString = getEmoticonManager().syncFindEmoticonPackageById(paramString);
    if (paramString != null) {
      if (paramBoolean)
      {
        if (paramString.status != 2)
        {
          paramString.status = 2;
          getEmoticonManager().saveEmoticonPackage(paramString);
        }
      }
      else if (paramString.status != 0)
      {
        paramString.status = 0;
        getEmoticonManager().saveEmoticonPackage(paramString);
      }
    }
  }
  
  public boolean verifyMagicFacePackageIntact(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString));
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio.ini");
    return new File(localStringBuilder.toString()).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */