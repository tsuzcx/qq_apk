package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class ShortVideoResourceManager
  implements ShortVideoResourceStatus.ISVConfig, INetEngineListener, Manager
{
  public static long a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  private static ShortVideoResourceManager.ConfigSession f = new ShortVideoResourceManager.ConfigSession();
  private static ArrayList<ShortVideoResourceStatus.ISVConfig> g = new ArrayList();
  private static final Object h = new Object();
  private HashMap<String, ShortVideoResourceManager.HttpEngineSession> i = new HashMap();
  private final Object j = new Object();
  private QQAppInterface k;
  private INetInfoHandler l = new ShortVideoResourceManager.1(this);
  
  static
  {
    int m;
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      c = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
      b = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();
    }
    else
    {
      c = BaseApplicationImpl.getContext().getFilesDir().getPath();
      b = BaseApplicationImpl.getContext().getCacheDir().getPath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoResourceManager.BASE.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sv_config_resources");
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoResourceManager.BASE.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tmp");
    e = localStringBuilder.toString();
    m();
  }
  
  public ShortVideoResourceManager(QQAppInterface paramQQAppInterface)
  {
    this.k = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.l);
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    if (paramQQAppInterface == null) {
      return -101;
    }
    int n = a(paramISVConfig);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=");
    localStringBuilder.append(n);
    AEQLog.b("ShortVideoResourceManager", localStringBuilder.toString());
    int m = n;
    if (n == -115)
    {
      c(paramQQAppInterface, paramISVConfig);
      m = 0;
    }
    return m;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = ShortVideoBusinessProcess.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[userUncompressZipResource]needRestore=");
    paramQQAppInterface.append(bool);
    paramQQAppInterface.append(",keyName=");
    paramQQAppInterface.append(paramString1);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
    if (bool) {
      paramInt = -118;
    } else {
      paramInt = 0;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[userUncompressZipResource]errCode=");
    paramQQAppInterface.append(paramInt);
    paramQQAppInterface.append(",keyName=");
    paramQQAppInterface.append(paramString1);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    int m = e();
    paramQQAppInterface = d();
    if ((m != 0) && (!TextUtils.isEmpty(paramQQAppInterface)))
    {
      m = a(paramQQAppInterface, paramList);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkConfigResourceIsOK]parseConfigData_errCode=");
      localStringBuilder.append(m);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      if (m != 0)
      {
        paramList.clear();
        bool = b("", 0);
        paramList = new StringBuilder();
        paramList.append("[doUserDownloadResource]parseConfigData:errCode=");
        paramList.append(m);
        paramList.append(", successReset=");
        paramList.append(bool);
        paramList.append(", config_content=");
        paramList.append(paramQQAppInterface);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramList.toString(), null);
        return m;
      }
      m = a(paramList);
      if (m != 0)
      {
        paramList.clear();
        bool = b("", 0);
        paramList = new StringBuilder();
        paramList.append("[doUserDownloadResource]checkResourceVersion:errCode=");
        paramList.append(m);
        paramList.append(", successReset=");
        paramList.append(bool);
        paramList.append(", config_content=");
        paramList.append(paramQQAppInterface);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramList.toString(), null);
      }
      return m;
    }
    boolean bool = b("", 0);
    paramList = new StringBuilder();
    paramList.append("[checkConfigResourceIsOK]:version=");
    paramList.append(m);
    paramList.append(", successReset=");
    paramList.append(bool);
    paramList.append(", config_content=");
    paramList.append(paramQQAppInterface);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramList.toString(), null);
    return -101;
  }
  
  private static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramSVConfigItem.name);
    str = localStringBuilder.toString();
    if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
      return a(paramSVConfigItem.name, paramSVConfigItem.arm64v8a_md5, paramSVConfigItem.armv7a_md5, str);
    }
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, paramSVConfigItem.arm64v8a_md5, str);
  }
  
  private static int a(ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    int n = 0;
    for (;;)
    {
      int m;
      try
      {
        if (f.a == 0)
        {
          m = -115;
          continue;
          boolean bool = g.contains(paramISVConfig);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addConfigCallBack contains=");
          localStringBuilder.append(bool);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
          m = n;
          if (!bool)
          {
            g.add(paramISVConfig);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "addConfigCallBack: add callBack OK...", null);
            m = n;
          }
          return m;
        }
      }
      finally {}
      if (paramISVConfig == null) {
        m = -116;
      }
    }
  }
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, "", paramString3);
  }
  
  private static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|verifyResource() lResMd5=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", filepath=");
      localStringBuilder.append(paramString4);
      QLog.d("ShortVideoResourceManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString4)) {
      return -105;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return -106;
    }
    File localFile = new File(paramString4);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("|verifyResource() file[");
        paramString2.append(paramString4);
        paramString2.append("] not exist..");
        QLog.e("ShortVideoResourceManager", 2, paramString2.toString());
      }
      return -107;
    }
    localStringBuilder = null;
    try
    {
      paramString4 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString4));
    }
    catch (UnsatisfiedLinkError paramString4)
    {
      label172:
      label181:
      break label172;
    }
    try
    {
      paramString4 = MD5FileUtil.a(localFile);
    }
    catch (Exception paramString4)
    {
      paramString4 = localStringBuilder;
      break label181;
      paramString4 = "";
      break label304;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|verifyResource  lResMd5=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",md5=");
      localStringBuilder.append(paramString4);
      QLog.d("ShortVideoResourceManager", 2, localStringBuilder.toString());
    }
    if (paramString2.equalsIgnoreCase(paramString4)) {
      return 0;
    }
    if ((!StringUtil.isEmpty(paramString3)) && (!paramString3.equalsIgnoreCase(paramString4))) {
      try
      {
        paramString3 = new HashMap();
        paramString3.put("keyName", paramString1);
        paramString3.put("resMd5", paramString2);
        if (paramString4 == null) {
          break label377;
        }
        label304:
        paramString3.put("fileMd5", paramString4);
        paramString3.put("fileLen", String.valueOf(localFile.length()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ShortVideoResMd5Error", true, 0L, 0L, paramString3, "");
      }
      catch (Exception paramString1)
      {
        QLog.e("ShortVideoResourceManager", 1, "report fail, ", paramString1);
      }
    } else {
      return -108;
    }
  }
  
  public static int a(String paramString, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    int n = -100;
    for (;;)
    {
      int m;
      try
      {
        paramString = new JSONArray(paramString);
        i1 = paramString.length();
        if (i1 > 0) {
          break label234;
        }
        paramString = new StringBuilder();
        paramString.append("parseConfigData: arrayLength=");
        paramString.append(i1);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramString.toString(), null);
        return -100;
      }
      catch (OutOfMemoryError paramString)
      {
        int i1;
        ShortVideoResourceManager.SVConfigItem localSVConfigItem;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ShortVideoResourceManager", 2, "parseConfigData[OutOfMemoryError]", paramString);
        paramList.clear();
        m = n;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ShortVideoResourceManager", 2, "parseConfigData[JSONException]", paramString);
        paramList.clear();
        m = n;
      }
      if (m < i1)
      {
        localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)JSONUtils.a(paramString.getJSONObject(m), ShortVideoResourceManager.SVConfigItem.class);
        if (localSVConfigItem == null)
        {
          paramString = new StringBuilder();
          paramString.append("parseConfigData:item=null i=");
          paramString.append(m);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramString.toString(), null);
          paramList.clear();
          return -100;
        }
        paramList.add(localSVConfigItem);
        m += 1;
      }
      else
      {
        m = 0;
        paramString = new StringBuilder();
        paramString.append("parseConfigData:errCode=");
        paramString.append(m);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramString.toString(), null);
        return m;
        label234:
        m = 0;
      }
    }
  }
  
  private static int a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    int m = 0;
    int n = 0;
    while (m < paramList.size())
    {
      n = ShortVideoBusinessProcess.a((ShortVideoResourceManager.SVConfigItem)paramList.get(m));
      if (n != 0) {
        return n;
      }
      m += 1;
    }
    return n;
  }
  
  public static String a(String paramString)
  {
    String str = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfigCmdSend LogSignature=");
      localStringBuilder.append(i());
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      if (f.a == 1)
      {
        f.a = 2;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onConfigCmdSend] mConfigStatus=");
        localStringBuilder.append(f.a());
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
        if (f.a == 0)
        {
          int m = g.size();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onConfigCmdSend[Error status] size=");
          localStringBuilder.append(m);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveFailed:status=");
      localStringBuilder.append(f.a());
      localStringBuilder.append(" mGetConfigType");
      localStringBuilder.append(f.b);
      localStringBuilder.append(",serverResult=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",LogSignature=");
      localStringBuilder.append(i());
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      if (f.a != 2) {
        break label221;
      }
      f.a = 0;
      if (paramInt == 0)
      {
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
        f.c = 1;
        f.d = 0;
      }
      else
      {
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
        f.c = -1;
        f.d = paramInt;
      }
      paramInt = g.size() - 1;
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        label258:
        for (;;)
        {
          label221:
          throw localObject;
        }
        paramInt -= 1;
      }
    }
    if (paramInt >= 0)
    {
      if (g.get(paramInt) != null) {
        ((ShortVideoResourceStatus.ISVConfig)g.get(paramInt)).onConfigResult(f.c, f.d);
      }
    }
    else
    {
      g.clear();
      break label258;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShortVideoResourceManager[onReceiveFailed] mConfigStatus=");
      localStringBuilder.append(f.a());
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    
    if (paramInt != 3)
    {
      a(paramQQAppInterface, paramInt, paramQQAppInterface.getShortVideoResourceManager());
      return;
    }
    throw new Error("preDownloadShortVideoConfigData: call user type...");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    try
    {
      if (f.a == 0)
      {
        if (paramInt == 3)
        {
          m = j();
          if (m == 0)
          {
            if (paramISVConfig != null) {
              paramISVConfig.onConfigResult(1, m);
            }
            return;
          }
        }
        int m = e();
        Object localObject = d();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doUserDownload[Begin download print]:version=");
        localStringBuilder.append(m);
        localStringBuilder.append(" config_content");
        localStringBuilder.append((String)localObject);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadShortVideoConfigData LogSignature=");
        ((StringBuilder)localObject).append(i());
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject).toString(), null);
        f.a = 1;
        f.b = paramInt;
        f.c = 0;
        f.d = 0;
        ConfigServlet.c(paramQQAppInterface, paramInt);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortvideoConfigData[request started]:status=");
        paramQQAppInterface.append(f.a());
        paramQQAppInterface.append(" mGetConfigType");
        paramQQAppInterface.append(f.b);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortvideoConfigData[request pending]:status=");
        paramQQAppInterface.append(f.a());
        paramQQAppInterface.append(" mGetConfigType");
        paramQQAppInterface.append(f.b);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
      }
      if (paramISVConfig != null)
      {
        boolean bool = g.contains(paramISVConfig);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortVideoConfigData contains=");
        paramQQAppInterface.append(bool);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
        if (!bool)
        {
          if (paramInt != 3) {
            g.add(0, paramISVConfig);
          } else {
            g.add(paramISVConfig);
          }
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new ShortVideoResourceManager.3(paramQQAppInterface, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramINet_ShortVideoResource != null) {
        paramQQAppInterface.getShortVideoResourceManager().a(paramINet_ShortVideoResource, paramString);
      }
    }
    else {
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new ShortVideoResourceManager.4(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    Object localObject = h;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < paramList.size())
        {
          ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)paramList.get(m);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            continue;
          }
          if (paramQQAppInterface == null)
          {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
            if (paramINet_ShortVideoResource != null) {
              paramINet_ShortVideoResource.onDownloadFinish(localSVConfigItem.name, -1501, "");
            }
          }
          else
          {
            boolean bool = a(paramQQAppInterface, localSVConfigItem);
            paramList = new StringBuilder();
            paramList.append("doUserDownloadResourceWithNamePrefix: needDownload=");
            paramList.append(bool);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramList.toString(), null);
            if (bool)
            {
              paramQQAppInterface = paramQQAppInterface.getShortVideoResourceManager();
              if (paramQQAppInterface != null) {
                paramQQAppInterface.a(localSVConfigItem, paramINet_ShortVideoResource);
              }
            }
            else
            {
              paramList = a(localSVConfigItem.name);
              m = b(paramQQAppInterface, localSVConfigItem);
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = ");
              paramQQAppInterface.append(localSVConfigItem.name);
              paramQQAppInterface.append(", errCode=");
              paramQQAppInterface.append(m);
              VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
              if (paramINet_ShortVideoResource != null) {
                paramINet_ShortVideoResource.onDownloadFinish(localSVConfigItem.name, m, paramList);
              }
            }
          }
        }
        return;
      }
      finally
      {
        continue;
        throw paramQQAppInterface;
        continue;
        m += 1;
      }
    }
  }
  
  private void a(NetResp arg1)
  {
    Object localObject1 = ???.mReq;
    Object localObject5 = ((NetReq)localObject1).mOutPath;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[onResp]filePath=");
    ((StringBuilder)localObject3).append((String)localObject5);
    ((StringBuilder)localObject3).append(",resp.mResult=");
    ((StringBuilder)localObject3).append(???.mResult);
    ((StringBuilder)localObject3).append(",mHttpCode=");
    ((StringBuilder)localObject3).append(???.mHttpCode);
    ((StringBuilder)localObject3).append(",mErrCode=");
    ((StringBuilder)localObject3).append(???.mErrCode);
    ((StringBuilder)localObject3).append(",mErrDesc=");
    ((StringBuilder)localObject3).append(???.mErrDesc);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject3).toString(), null);
    localObject1 = (String)((NetReq)localObject1).getUserData();
    synchronized (this.j)
    {
      localObject3 = (ShortVideoResourceManager.HttpEngineSession)this.i.get(localObject1);
      Object localObject6 = ((ShortVideoResourceManager.HttpEngineSession)localObject3).c;
      int i1 = ((ShortVideoResourceManager.HttpEngineSession)localObject3).d;
      String str = h();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append((String)localObject1);
      ??? = ((StringBuilder)???).toString();
      int m = ???.mResult;
      int n = 0;
      if (m == 0)
      {
        m = a((String)localObject1, (String)localObject6, (String)localObject5);
        ??? = new StringBuilder();
        ???.append("[onResp]verifyResource keyName=");
        ???.append((String)localObject1);
        ???.append(",errCode=");
        ???.append(m);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ???.toString(), null);
        if (m != 0)
        {
          if (m == -108)
          {
            ??? = new StringBuilder();
            ???.append(str);
            ???.append((String)localObject1);
            ???.append("error");
            boolean bool = a(???.toString(), (String)localObject5);
            ??? = new StringBuilder();
            ???.append("[onResp]renameResourceZip, save error file, success=");
            ???.append(bool);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ???.toString(), null);
          }
          c((String)localObject5);
          ??? = new StringBuilder();
          ???.append("[onResp]verifyResource clearDownloadTempFile errCode=");
          ???.append(m);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ???.toString(), null);
        }
        else if (a((String)???, (String)localObject5))
        {
          ??? = new StringBuilder();
          ???.append((String)localObject6);
          ???.append('_');
          ???.append(i1);
          ??? = ???.toString();
          m = a(this.k, (String)localObject1, ???, (String)???, i1);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("[onRespAsync]signature=");
          ((StringBuilder)localObject5).append(???);
          ((StringBuilder)localObject5).append(",errCode=");
          ((StringBuilder)localObject5).append(m);
          ((StringBuilder)localObject5).append(",key=");
          ((StringBuilder)localObject5).append((String)localObject1);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject5).toString(), null);
        }
        else
        {
          m = -3;
          c((String)???);
          c((String)localObject5);
        }
        ShortVideoResourceStatus.a((String)localObject1, i1, 0, m);
      }
      else
      {
        ShortVideoResourceStatus.a((String)localObject1, i1, 1, -117);
        c((String)localObject5);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("[onResp]filePath=");
        ((StringBuilder)localObject6).append((String)localObject5);
        ((StringBuilder)localObject6).append(",resp.mResult=");
        ((StringBuilder)localObject6).append(???.mResult);
        ((StringBuilder)localObject6).append(",mErrDesc=");
        ((StringBuilder)localObject6).append(???.mErrDesc);
        ((StringBuilder)localObject6).append(",mErrDesc=");
        ((StringBuilder)localObject6).append(???.mErrDesc);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject6).toString(), null);
        m = -117;
      }
      ??? = new StringBuilder();
      ???.append("[onRespAsync]errCode=");
      ???.append(m);
      ???.append(",saveFilePath=");
      ???.append((String)???);
      ???.append(",key=");
      ???.append((String)localObject1);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ???.toString(), null);
      for (;;)
      {
        synchronized (this.j)
        {
          ((ShortVideoResourceManager.HttpEngineSession)localObject3).e = 3;
          i1 = ((ShortVideoResourceManager.HttpEngineSession)localObject3).b.size();
          if (n >= i1) {
            break;
          }
        }
        try
        {
          if ((((ShortVideoResourceManager.HttpEngineSession)localObject3).b.get(n) != null) && (localObject1 != null)) {
            ((ShortVideoResourceManager.INet_ShortVideoResource)((ShortVideoResourceManager.HttpEngineSession)localObject3).b.get(n)).onDownloadFinish((String)localObject1, m, (String)???);
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          label805:
          break label805;
        }
        n += 1;
      }
      ((ShortVideoResourceManager.HttpEngineSession)localObject3).b.clear();
      this.i.remove(localObject1);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkResourceItemNeedDownload:name=");
    ((StringBuilder)localObject).append(paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject).toString(), null);
    localObject = ShortVideoResourceStatus.a(paramSVConfigItem.name);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkResourceItemNeedDownload:versionCode=");
    localStringBuilder.append(paramSVConfigItem.versionCode);
    localStringBuilder.append(" status.version");
    localStringBuilder.append(((ShortVideoResourceStatus.ResStatus)localObject).a);
    localStringBuilder.append(",status.lastErr=");
    localStringBuilder.append(((ShortVideoResourceStatus.ResStatus)localObject).c);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
    boolean bool2 = ShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem);
    boolean bool1 = false;
    if (!bool2)
    {
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:userDownload=false", null);
      return false;
    }
    int m;
    if (paramSVConfigItem.versionCode > ((ShortVideoResourceStatus.ResStatus)localObject).a)
    {
      if (((ShortVideoResourceStatus.ResStatus)localObject).a == 0)
      {
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:status.version=0", null);
        if (new File(str).exists())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("checkResourceItemNeedDownload:[exists]filePath=");
          paramQQAppInterface.append(str);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
          m = a(paramSVConfigItem);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("checkResourceItemNeedDownload[zipVerifyMd5]:errCode=");
          paramQQAppInterface.append(m);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
          if (m != 0) {
            c(str);
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      c(str);
      return true;
    }
    if (paramSVConfigItem.versionCode == ((ShortVideoResourceStatus.ResStatus)localObject).a)
    {
      if (((ShortVideoResourceStatus.ResStatus)localObject).b != 0)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkResourceItemNeedDownload[No equal]:status=");
        paramQQAppInterface.append(((ShortVideoResourceStatus.ResStatus)localObject).b);
        paramQQAppInterface.append(",version");
        paramQQAppInterface.append(((ShortVideoResourceStatus.ResStatus)localObject).a);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
        c(str);
        return true;
      }
      bool1 = d(paramSVConfigItem.name);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:exist=");
      paramQQAppInterface.append(bool1);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
      if (!bool1) {
        return true;
      }
      m = a(paramSVConfigItem);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:errCode=");
      paramQQAppInterface.append(m);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
      if (m != 0)
      {
        c(str);
        return true;
      }
      if (((ShortVideoResourceStatus.ResStatus)localObject).c != 0)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:status=");
        paramQQAppInterface.append(((ShortVideoResourceStatus.ResStatus)localObject).b);
        paramQQAppInterface.append(",lastErr");
        paramQQAppInterface.append(((ShortVideoResourceStatus.ResStatus)localObject).c);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
      }
    }
    return false;
  }
  
  private boolean a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = ShortVideoBusinessProcess.a(this.k, paramSVConfigItem.name);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRealSendRequest:alreadyExists=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramINet_ShortVideoResource != null) {
        paramINet_ShortVideoResource.onDownloadFinish(paramSVConfigItem.name, 0, str);
      }
      paramINet_ShortVideoResource = new StringBuilder();
      paramINet_ShortVideoResource.append("doRealSendRequest:itemConfig.versionCode=");
      paramINet_ShortVideoResource.append(paramSVConfigItem.versionCode);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramINet_ShortVideoResource.toString(), null);
      bool = a(this.k, paramSVConfigItem);
      if (!bool)
      {
        int m = b(this.k, paramSVConfigItem);
        paramSVConfigItem = new StringBuilder();
        paramSVConfigItem.append("doRealSendRequest:doNoNeedDownload_errCode=");
        paramSVConfigItem.append(m);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramSVConfigItem.toString(), null);
      }
      return bool;
    }
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    synchronized (h)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onResp]renameResourceZip destPath=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",outPath=");
      localStringBuilder.append(paramString2);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        paramString1.delete();
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
      }
      paramString2 = new File(paramString2);
      long l1 = paramString2.length();
      boolean bool = paramString2.renameTo(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append("[onResp]renameResourceZip orgLength=");
      paramString2.append(l1);
      paramString2.append(",success=");
      paramString2.append(bool);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramString2.toString(), null);
      if (bool)
      {
        bool = paramString1.exists();
        long l2 = paramString1.length();
        paramString1 = new StringBuilder();
        paramString1.append("[onResp]renameResourceZip destExists=");
        paramString1.append(bool);
        paramString1.append(",destLength=");
        paramString1.append(l2);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramString1.toString(), null);
        if ((bool) && (l2 == l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  private static int b(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (ShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNoNeedDownload: signature=");
      localStringBuilder.append(str2);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      int m = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (m != 0)
      {
        ShortVideoResourceStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, m);
        c(str1);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("doNoNeedDownload: errCode=");
        paramQQAppInterface.append(m);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
        return m;
      }
      ShortVideoResourceStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, m);
      return m;
    }
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    m();
    int n = j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUserDownloadConfig[checkLocalConfigIsOK]:errCode=");
    localStringBuilder.append(n);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
    int m;
    if (n != 0)
    {
      boolean bool = NetworkUtil.isNetworkAvailable(null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUserDownloadConfig:netUsable=");
      localStringBuilder.append(bool);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      n = a(paramISVConfig);
      m = n;
      if (n == -115)
      {
        c(paramQQAppInterface, paramISVConfig);
        m = 0;
      }
    }
    else
    {
      m = n;
      if (paramISVConfig != null)
      {
        paramISVConfig.onConfigResult(1, 0);
        m = n;
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("startUserDownloadConfig[end]:errCode=");
    paramQQAppInterface.append(m);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramQQAppInterface.toString(), null);
    return m;
  }
  
  public static void b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveNoDataUpdate LogSignature=");
      localStringBuilder.append(i());
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      if (f.a == 2)
      {
        f.a = 0;
        f.c = 1;
        m = g.size() - 1;
        if (m >= 0)
        {
          if (g.get(m) == null) {
            break label171;
          }
          ((ShortVideoResourceStatus.ISVConfig)g.get(m)).onConfigResult(f.c, 0);
          break label171;
        }
        g.clear();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=");
        localStringBuilder.append(f.a());
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        int m;
        for (;;)
        {
          throw localObject;
        }
        label171:
        m -= 1;
      }
    }
  }
  
  public static void b(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveSuccess LogSignature=");
      localStringBuilder.append(i());
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      if (f.a == 2)
      {
        f.a = 0;
        f.c = 0;
        m = g.size() - 1;
        if (m >= 0)
        {
          if (g.get(m) == null) {
            break label171;
          }
          ((ShortVideoResourceStatus.ISVConfig)g.get(m)).onConfigResult(f.c, paramInt);
          break label171;
        }
        g.clear();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=");
        localStringBuilder.append(f.a());
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", localStringBuilder.toString(), null);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        int m;
        for (;;)
        {
          throw localObject;
        }
        label171:
        m -= 1;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    a(paramQQAppInterface, paramINet_ShortVideoResource, "new_qq_android_native_short_video_");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.2(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new ShortVideoResourceManager.6(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  public static void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new ShortVideoResourceManager.10(paramString));
  }
  
  private void b(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.8(this, paramList), 128, null, false);
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).edit();
    localEditor.putString("new_short_video_res_config_key", paramString);
    localEditor.putInt("new_short_video_resource_version", paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShortVideoResConfigContent| saveContentOK，config_content = ");
      localStringBuilder.append(paramString);
      QLog.d("ShortVideoResourceManager", 2, localStringBuilder.toString());
    }
    return localEditor.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    a(paramQQAppInterface, paramINet_ShortVideoResource, "new_qq_android_native_art_filter_");
  }
  
  private static void c(QQAppInterface paramQQAppInterface, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    a(paramQQAppInterface, 3, paramISVConfig);
  }
  
  private static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void c(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    Object localObject1 = h;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < paramList.size())
        {
          Object localObject2 = (ShortVideoResourceManager.SVConfigItem)paramList.get(m);
          if (!((ShortVideoResourceManager.SVConfigItem)localObject2).predownload)
          {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "preDownloadResource:parseConfigData predownload=false", null);
          }
          else if (a(this.k, (ShortVideoResourceManager.SVConfigItem)localObject2))
          {
            a((ShortVideoResourceManager.SVConfigItem)localObject2, null);
          }
          else
          {
            int n = b(this.k, (ShortVideoResourceManager.SVConfigItem)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=");
            ((StringBuilder)localObject2).append(n);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject2).toString(), null);
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw paramList;
        continue;
        m += 1;
      }
    }
  }
  
  public static String d()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).getString("new_short_video_res_config_key", "");
  }
  
  private static boolean d(String paramString)
  {
    String str = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return FileUtils.fileExists(localStringBuilder.toString());
  }
  
  public static int e()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).getInt("new_short_video_resource_version", 0);
  }
  
  public static List<ShortVideoResourceManager.SVConfigItem> g()
  {
    LinkedList localLinkedList = new LinkedList();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
    localSVConfigItem.name = "new_qq_android_native_short_video_66";
    localSVConfigItem.arm_url = "https://downv6.qq.com/qqAVCodecLib/version_66/new_qq_android_native_short_video_66_test.zip";
    localSVConfigItem.armv7a_url = "https://downv6.qq.com/qqAVCodecLib/version_66/new_qq_android_native_short_video_66_test.zip";
    localSVConfigItem.x86_url = "https://downv6.qq.com/qqAVCodecLib/version_66/new_qq_android_native_short_video_66_test.zip";
    localSVConfigItem.arm64v8a_url = "https://downv6.qq.com/qqAVCodecLib/version_66/new_qq_android_native_short_video_for64bit_66_test_1.zip";
    localSVConfigItem.arm_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    localSVConfigItem.armv7a_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    localSVConfigItem.x86_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    localSVConfigItem.arm64v8a_md5 = "480b96a75193cee3979c62fea8018768";
    localSVConfigItem.versionCode = 66;
    localSVConfigItem.predownload = false;
    localLinkedList.add(localSVConfigItem);
    return localLinkedList;
  }
  
  public static String h()
  {
    return d;
  }
  
  private static String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashCode=");
    localStringBuilder.append(f.hashCode());
    localStringBuilder.append(" ,pid=");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(",tid");
    localStringBuilder.append(Process.myTid());
    return localStringBuilder.toString();
  }
  
  private static int j()
  {
    int m = e();
    Object localObject1 = d();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkLocalConfigIsOK:version=");
    ((StringBuilder)localObject2).append(m);
    ((StringBuilder)localObject2).append(" config_content");
    ((StringBuilder)localObject2).append((String)localObject1);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject2).toString(), null);
    if ((m != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = new ArrayList();
      int n = a((String)localObject1, (List)localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkLocalConfigIsOK:parseConfigData_errCode=");
      ((StringBuilder)localObject1).append(n);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
      m = n;
      if (n == 0) {
        m = a((List)localObject2);
      }
      return m;
    }
    return -101;
  }
  
  private void k()
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.i.values().iterator();
      while (localIterator.hasNext())
      {
        ShortVideoResourceManager.HttpEngineSession localHttpEngineSession = (ShortVideoResourceManager.HttpEngineSession)localIterator.next();
        if ((localHttpEngineSession != null) && (localHttpEngineSession.b != null))
        {
          int m = 0;
          while (m < localHttpEngineSession.b.size())
          {
            ((ShortVideoResourceManager.INet_ShortVideoResource)localHttpEngineSession.b.get(m)).onNetWorkNone();
            m += 1;
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static void m()
  {
    File localFile = new File(h());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(l());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public int a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("updateShortVideoResConfigContent|received save version: ");
      paramContext.append(paramInt);
      paramContext.append(", config_content: ");
      paramContext.append(paramString);
      QLog.d("ShortVideoResourceManager", 2, paramContext.toString());
    }
    int m;
    if (TextUtils.isEmpty(paramString))
    {
      m = -101;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateShortVideoResConfigContent| version: ");
        paramContext.append(paramInt);
        paramContext.append(",config_content: ");
        paramContext.append(paramString);
        QLog.d("ShortVideoResourceManager", 2, paramContext.toString());
        return -101;
      }
    }
    else
    {
      boolean bool = b(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateShortVideoResConfigContent| saveContentOK: ");
        paramContext.append(bool);
        QLog.d("ShortVideoResourceManager", 2, paramContext.toString());
      }
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = -128;
      }
      if (bool)
      {
        bool = ShortVideoResDownload.a(this.k, false);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("updateShortVideoResConfigContent| downloadState: ");
          paramContext.append(bool);
          QLog.d("ShortVideoResourceManager", 2, paramContext.toString());
        }
      }
      m = paramInt;
    }
    return m;
  }
  
  public int a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateShortVideoOtherConfigOnly|received save version: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", config_content: ");
    localStringBuilder.append(paramString);
    QLog.d("ShortVideoResourceManager", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShortVideoOtherConfigOnly| version: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",config_content: ");
      localStringBuilder.append(paramString);
      QLog.d("ShortVideoResourceManager", 1, localStringBuilder.toString());
      return -101;
    }
    boolean bool = b(paramString, paramInt);
    paramString = new StringBuilder();
    paramString.append("updateShortVideoOtherConfigOnly| saveContentOK: ");
    paramString.append(bool);
    QLog.d("ShortVideoResourceManager", 1, paramString.toString());
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void a(ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.i.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (ShortVideoResourceManager.HttpEngineSession)this.i.get(localObject2);
          if ((localObject2 != null) && (paramINet_ShortVideoResource != null)) {
            ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.remove(paramINet_ShortVideoResource);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramINet_ShortVideoResource;
    }
  }
  
  public void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    synchronized (this.j)
    {
      Object localObject2 = (ShortVideoResourceManager.HttpEngineSession)this.i.get(paramSVConfigItem.name);
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new boolean[1];
        bool = a(paramSVConfigItem, paramINet_ShortVideoResource, (boolean[])localObject2);
        if (localObject2[0] != 0) {
          paramINet_ShortVideoResource = null;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doRealSendRequest:doDownload=");
        ((StringBuilder)localObject2).append(bool);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject2).toString(), null);
        if (bool)
        {
          localObject2 = h();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(paramSVConfigItem.name);
          c(((StringBuilder)localObject3).toString());
          localObject2 = l();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(paramSVConfigItem.name);
          c(((StringBuilder)localObject3).toString());
          localObject3 = new HttpNetReq();
          ((HttpNetReq)localObject3).mCallback = this;
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
            ((HttpNetReq)localObject3).mReqUrl = paramSVConfigItem.arm64v8a_url;
          } else {
            ((HttpNetReq)localObject3).mReqUrl = paramSVConfigItem.armv7a_url;
          }
          ((HttpNetReq)localObject3).mHttpMethod = 0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(paramSVConfigItem.name);
          ((HttpNetReq)localObject3).mOutPath = localStringBuilder.toString();
          ((HttpNetReq)localObject3).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
          ((HttpNetReq)localObject3).bAcceptNegativeContentLength = true;
          ((HttpNetReq)localObject3).setUserData(paramSVConfigItem.name);
          localObject2 = new ShortVideoResourceManager.HttpEngineSession(this, (HttpNetReq)localObject3);
          ((ShortVideoResourceManager.HttpEngineSession)localObject2).d = paramSVConfigItem.versionCode;
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
            ((ShortVideoResourceManager.HttpEngineSession)localObject2).c = paramSVConfigItem.arm64v8a_md5;
          } else {
            ((ShortVideoResourceManager.HttpEngineSession)localObject2).c = paramSVConfigItem.armv7a_md5;
          }
          if (paramINet_ShortVideoResource != null)
          {
            ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.add(paramINet_ShortVideoResource);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
          }
          this.i.put(paramSVConfigItem.name, localObject2);
          ((ShortVideoResourceManager.HttpEngineSession)localObject2).a();
        }
      }
      else if (((ShortVideoResourceManager.HttpEngineSession)localObject2).e == 0)
      {
        ((ShortVideoResourceManager.HttpEngineSession)localObject2).d = paramSVConfigItem.versionCode;
        if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
          ((ShortVideoResourceManager.HttpEngineSession)localObject2).c = paramSVConfigItem.arm64v8a_md5;
        } else {
          ((ShortVideoResourceManager.HttpEngineSession)localObject2).c = paramSVConfigItem.armv7a_md5;
        }
        if (paramINet_ShortVideoResource != null)
        {
          bool = ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.contains(paramINet_ShortVideoResource);
          paramSVConfigItem = new StringBuilder();
          paramSVConfigItem.append("sendRequest[oldSession][start]contains=");
          paramSVConfigItem.append(bool);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramSVConfigItem.toString(), null);
          if (!bool)
          {
            ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.add(paramINet_ShortVideoResource);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
          }
        }
        ((ShortVideoResourceManager.HttpEngineSession)localObject2).a();
      }
      else if (paramINet_ShortVideoResource != null)
      {
        bool = ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.contains(paramINet_ShortVideoResource);
        paramSVConfigItem = new StringBuilder();
        paramSVConfigItem.append("sendRequest[oldSession][pending]contains=");
        paramSVConfigItem.append(bool);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", paramSVConfigItem.toString(), null);
        if (!bool)
        {
          ((ShortVideoResourceManager.HttpEngineSession)localObject2).b.add(paramINet_ShortVideoResource);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
      return;
    }
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.l);
  }
  
  public void f()
  {
    ??? = new ArrayList();
    ((List)???).add("new_qq_android_native_short_video_");
    ((List)???).add("new_qq_android_native_art_filter_");
    ((List)???).add("new_qq_android_native_portrait_filter_");
    ((List)???).add("new_qq_android_native_short_other_");
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      synchronized (this.j)
      {
        localObject3 = (ShortVideoResourceManager.HttpEngineSession)this.i.get(localObject3);
        if (localObject3 != null) {
          ((ShortVideoResourceManager.HttpEngineSession)localObject3).b.clear();
        }
      }
    }
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:result=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",serverError");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",getType=");
    ((StringBuilder)localObject1).append(f.b);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:RESULT_OK,saveError=");
        ((StringBuilder)localObject1).append(paramInt2);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
        return;
      }
      paramInt1 = e();
      localObject1 = d();
      if ((paramInt1 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = new ArrayList(1);
        paramInt1 = a((String)localObject1, (List)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:parseConfigData_errCode=");
        ((StringBuilder)localObject1).append(paramInt1);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
        if (paramInt1 == -100)
        {
          bool = b("", 0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:parseConfigData_errCode=");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(",successReset=");
          ((StringBuilder)localObject1).append(bool);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
          return;
        }
        if (paramInt1 == 0)
        {
          paramInt1 = a((List)localObject2);
          if (paramInt1 != 0)
          {
            bool = b("", 0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:checkResourceVersion errCode=");
            ((StringBuilder)localObject1).append(paramInt1);
            ((StringBuilder)localObject1).append(",successReset=");
            ((StringBuilder)localObject1).append(bool);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject1).toString(), null);
            return;
          }
          b((List)localObject2);
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
          return;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
        return;
      }
      boolean bool = b("", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[PreDownload]onConfigResult:version=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",successReset=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(",config_content=");
      ((StringBuilder)localObject2).append((String)localObject1);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)localObject2).toString(), null);
    }
  }
  
  public void onDestroy()
  {
    try
    {
      int m = g.size();
      g.clear();
      QLog.d("ShortVideoResourceManager", 1, new Object[] { "onDestroy sizeCallBack = ", Integer.valueOf(m) });
      AppNetConnInfo.unregisterNetInfoHandler(this.l);
      ShortVideoResDownload.a();
      f();
      return;
    }
    finally {}
  }
  
  public final void onResp(NetResp paramNetResp)
  {
    ThreadManager.post(new ShortVideoResourceManager.9(this, paramNetResp), 5, null, false);
  }
  
  public final void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (String)paramNetReq.getUserData();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("[onUpdateProgeress]curOffset=");
    ((StringBuilder)???).append(paramLong1);
    ((StringBuilder)???).append(",totalLen=");
    ((StringBuilder)???).append(paramLong2);
    ((StringBuilder)???).append(",key=");
    ((StringBuilder)???).append(paramNetReq);
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)???).toString(), null);
    int m;
    synchronized (this.j)
    {
      ShortVideoResourceManager.HttpEngineSession localHttpEngineSession = (ShortVideoResourceManager.HttpEngineSession)this.i.get(paramNetReq);
      localHttpEngineSession.e = 2;
      int n = localHttpEngineSession.b.size();
      m = 0;
      if (m < n)
      {
        if ((localHttpEngineSession.b.get(m) != null) && (paramNetReq != null)) {
          ((ShortVideoResourceManager.INet_ShortVideoResource)localHttpEngineSession.b.get(m)).onUpdateProgress(paramNetReq, paramLong1, paramLong2);
        }
      }
      else
      {
        m = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[onUpdateProgeress]downloadProgress=");
        ((StringBuilder)???).append(m);
        ((StringBuilder)???).append(",key=");
        ((StringBuilder)???).append(paramNetReq);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", ((StringBuilder)???).toString(), null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */