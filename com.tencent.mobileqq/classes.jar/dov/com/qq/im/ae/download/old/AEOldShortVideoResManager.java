package dov.com.qq.im.ae.download.old;

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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
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
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;

public class AEOldShortVideoResManager
  implements INetEngineListener, AEOldShortVideoResStatus.ISVConfig, Manager
{
  public static long a;
  private static AEOldShortVideoResManager.ConfigSession jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession = new AEOldShortVideoResManager.ConfigSession();
  private static final Object jdField_a_of_type_JavaLangObject;
  protected static final String a;
  private static ArrayList<AEOldShortVideoResStatus.ISVConfig> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected static final String b;
  public static final String c;
  public static final String d;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new AEOldShortVideoResManager.1(this);
  private HashMap<String, AEOldShortVideoResManager.HttpEngineSession> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    int i;
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();
    }
    else
    {
      jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getPath();
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getCacheDir().getPath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEOldShortVideoResManager.BASE.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sv_config_resources");
    localStringBuilder.append(File.separator);
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEOldShortVideoResManager.BASE.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tmp");
    d = localStringBuilder.toString();
    f();
  }
  
  public AEOldShortVideoResManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getInt("short_video_resource_version", 0);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNoNeedDownload: signature=");
      localStringBuilder.append(str2);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        AEOldShortVideoResStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        a(str1);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("doNoNeedDownload: errCode=");
        paramQQAppInterface.append(i);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
        return i;
      }
      AEOldShortVideoResStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    if (paramQQAppInterface == null) {
      return -101;
    }
    int j = a(paramISVConfig);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=");
    localStringBuilder.append(j);
    AEQLog.b("AEOldShortVideoResManager", localStringBuilder.toString());
    int i = j;
    if (j == -115)
    {
      a(paramQQAppInterface, paramISVConfig);
      i = 0;
    }
    return i;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[userUncompressZipResource]needRestore=");
    paramQQAppInterface.append(bool);
    paramQQAppInterface.append(",keyName=");
    paramQQAppInterface.append(paramString1);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
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
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    int i = a();
    paramQQAppInterface = a();
    if ((i != 0) && (!TextUtils.isEmpty(paramQQAppInterface)))
    {
      i = a(paramQQAppInterface, paramList);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkConfigResourceIsOK]parseConfigData_errCode=");
      localStringBuilder.append(i);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      if (i != 0)
      {
        paramList.clear();
        bool = a("", 0);
        paramList = new StringBuilder();
        paramList.append("[doUserDownloadResource]parseConfigData:errCode=");
        paramList.append(i);
        paramList.append(", successReset=");
        paramList.append(bool);
        paramList.append(", config_content=");
        paramList.append(paramQQAppInterface);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramList.toString(), null);
        return i;
      }
      i = a(paramList);
      if (i != 0)
      {
        paramList.clear();
        bool = a("", 0);
        paramList = new StringBuilder();
        paramList.append("[doUserDownloadResource]checkResourceVersion:errCode=");
        paramList.append(i);
        paramList.append(", successReset=");
        paramList.append(bool);
        paramList.append(", config_content=");
        paramList.append(paramQQAppInterface);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramList.toString(), null);
      }
      return i;
    }
    boolean bool = a("", 0);
    paramList = new StringBuilder();
    paramList.append("[checkConfigResourceIsOK]:version=");
    paramList.append(i);
    paramList.append(", successReset=");
    paramList.append(bool);
    paramList.append(", config_content=");
    paramList.append(paramQQAppInterface);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramList.toString(), null);
    return -101;
  }
  
  private static int a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramSVConfigItem.name);
    str = localStringBuilder.toString();
    if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
      return a(paramSVConfigItem.name, paramSVConfigItem.arm64v8a_md5, paramSVConfigItem.armv7a_md5, str);
    }
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, paramSVConfigItem.arm64v8a_md5, str);
  }
  
  private static int a(AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 0)
        {
          i = -115;
          continue;
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramISVConfig);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addConfigCallBack contains=");
          localStringBuilder.append(bool);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
          i = j;
          if (!bool)
          {
            jdField_a_of_type_JavaUtilArrayList.add(paramISVConfig);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "addConfigCallBack: add callBack OK...", null);
            i = j;
          }
          return i;
        }
      }
      finally {}
      if (paramISVConfig == null) {
        i = -116;
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
      QLog.d("AEOldShortVideoResManager", 2, localStringBuilder.toString());
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
        QLog.e("AEOldShortVideoResManager", 2, paramString2.toString());
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
      QLog.d("AEOldShortVideoResManager", 2, localStringBuilder.toString());
    }
    if (paramString2.equalsIgnoreCase(paramString4)) {
      return 0;
    }
    if ((!StringUtil.a(paramString3)) && (!paramString3.equalsIgnoreCase(paramString4))) {
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
        QLog.e("AEOldShortVideoResManager", 1, "report fail, ", paramString1);
      }
    } else {
      return -108;
    }
  }
  
  public static int a(String paramString, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    int j = -100;
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        k = paramString.length();
        if (k > 0) {
          break label234;
        }
        paramString = new StringBuilder();
        paramString.append("parseConfigData: arrayLength=");
        paramString.append(k);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramString.toString(), null);
        return -100;
      }
      catch (OutOfMemoryError paramString)
      {
        int k;
        AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[OutOfMemoryError]", paramString);
        paramList.clear();
        i = j;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[JSONException]", paramString);
        paramList.clear();
        i = j;
      }
      if (i < k)
      {
        localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)JSONUtils.a(paramString.getJSONObject(i), AEOldShortVideoResManager.SVConfigItem.class);
        if (localSVConfigItem == null)
        {
          paramString = new StringBuilder();
          paramString.append("parseConfigData:item=null i=");
          paramString.append(i);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramString.toString(), null);
          paramList.clear();
          return -100;
        }
        paramList.add(localSVConfigItem);
        i += 1;
      }
      else
      {
        i = 0;
        paramString = new StringBuilder();
        paramString.append("parseConfigData:errCode=");
        paramString.append(i);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramString.toString(), null);
        return i;
        label234:
        i = 0;
      }
    }
  }
  
  private static int a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    int j = 0;
    int i = 0;
    while (j < paramList.size())
    {
      i = AEOldShortVideoBusinessProcess.a((AEOldShortVideoResManager.SVConfigItem)paramList.get(j));
      if (i != 0) {
        break;
      }
      j += 1;
    }
    j = i;
    if (i == 0) {
      j = b(paramList);
    }
    return j;
  }
  
  public static AEOldShortVideoResManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return (AEOldShortVideoResManager)paramQQAppInterface.getManager(QQManagerFactory.OLD_SHORT_VIDEO_RES_MANAGER);
    }
    return null;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
  }
  
  public static String a(String paramString)
  {
    String str = b();
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
      localStringBuilder.append(c());
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 1)
      {
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 2;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onConfigCmdSend] mConfigStatus=");
        localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 0)
        {
          int i = jdField_a_of_type_JavaUtilArrayList.size();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onConfigCmdSend[Error status] size=");
          localStringBuilder.append(i);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
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
      localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
      localStringBuilder.append(" mGetConfigType");
      localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b);
      localStringBuilder.append(",serverResult=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",LogSignature=");
      localStringBuilder.append(c());
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int != 2) {
        break label221;
      }
      jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
      if (paramInt == 0)
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_NO_DATA]", null);
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 1;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = 0;
      }
      else
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_FAILED]", null);
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = -1;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = paramInt;
      }
      paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
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
      if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) != null) {
        ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d);
      }
    }
    else
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      break label258;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShortVideoResourceManager[onReceiveFailed] mConfigStatus=");
      localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    
    if (paramInt != 3)
    {
      a(paramQQAppInterface, paramInt, a(paramQQAppInterface));
      return;
    }
    throw new Error("preDownloadShortVideoConfigData: call user type...");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    try
    {
      if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 0)
      {
        if (paramInt == 3)
        {
          i = b();
          if (i == 0)
          {
            if (paramISVConfig != null) {
              paramISVConfig.a(1, i);
            }
            return;
          }
        }
        int i = a();
        Object localObject = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doUserDownload[Begin download print]:version=");
        localStringBuilder.append(i);
        localStringBuilder.append(" config_content");
        localStringBuilder.append((String)localObject);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadShortVideoConfigData LogSignature=");
        ((StringBuilder)localObject).append(c());
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 1;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b = paramInt;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 0;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = 0;
        ConfigServlet.b(paramQQAppInterface, paramInt);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortvideoConfigData[request started]:status=");
        paramQQAppInterface.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
        paramQQAppInterface.append(" mGetConfigType");
        paramQQAppInterface.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortvideoConfigData[request pending]:status=");
        paramQQAppInterface.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
        paramQQAppInterface.append(" mGetConfigType");
        paramQQAppInterface.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
      }
      if (paramISVConfig != null)
      {
        boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramISVConfig);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("downloadShortVideoConfigData contains=");
        paramQQAppInterface.append(bool);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
        if (!bool)
        {
          if (paramInt != 3) {
            jdField_a_of_type_JavaUtilArrayList.add(0, paramISVConfig);
          } else {
            jdField_a_of_type_JavaUtilArrayList.add(paramISVConfig);
          }
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortVideoConfigData: add callBack OK...", null);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void a(QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    a(paramQQAppInterface, 3, paramISVConfig);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.2(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.3(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          AEOldShortVideoResManager.SVConfigItem localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            continue;
          }
          if (paramQQAppInterface == null)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
            if (paramINet_ShortVideoResource != null) {
              paramINet_ShortVideoResource.a(localSVConfigItem.name, -1501, "");
            }
          }
          else
          {
            boolean bool = a(paramQQAppInterface, localSVConfigItem);
            paramList = new StringBuilder();
            paramList.append("doUserDownloadResourceWithNamePrefix: needDownload=");
            paramList.append(bool);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramList.toString(), null);
            if (bool)
            {
              paramQQAppInterface = a(paramQQAppInterface);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.a(localSVConfigItem, paramINet_ShortVideoResource);
              }
            }
            else
            {
              paramList = a(localSVConfigItem.name);
              i = a(paramQQAppInterface, localSVConfigItem);
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = ");
              paramQQAppInterface.append(localSVConfigItem.name);
              paramQQAppInterface.append(", errCode=");
              paramQQAppInterface.append(i);
              VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
              if (paramINet_ShortVideoResource != null) {
                paramINet_ShortVideoResource.a(localSVConfigItem.name, i, paramList);
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
        i += 1;
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
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject3).toString(), null);
    localObject1 = (String)((NetReq)localObject1).getUserData();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      localObject3 = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      Object localObject6 = ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaLangString;
      int k = ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_Int;
      String str = b();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append((String)localObject1);
      ??? = ((StringBuilder)???).toString();
      int i = ???.mResult;
      int j = 0;
      if (i == 0)
      {
        i = a((String)localObject1, (String)localObject6, (String)localObject5);
        ??? = new StringBuilder();
        ???.append("[onResp]verifyResource keyName=");
        ???.append((String)localObject1);
        ???.append(",errCode=");
        ???.append(i);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ???.toString(), null);
        if (i != 0)
        {
          if (i == -108)
          {
            ??? = new StringBuilder();
            ???.append(str);
            ???.append((String)localObject1);
            ???.append("error");
            boolean bool = a(???.toString(), (String)localObject5);
            ??? = new StringBuilder();
            ???.append("[onResp]renameResourceZip, save error file, success=");
            ???.append(bool);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ???.toString(), null);
          }
          a((String)localObject5);
          ??? = new StringBuilder();
          ???.append("[onResp]verifyResource clearDownloadTempFile errCode=");
          ???.append(i);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ???.toString(), null);
        }
        else if (a((String)???, (String)localObject5))
        {
          ??? = new StringBuilder();
          ???.append((String)localObject6);
          ???.append('_');
          ???.append(k);
          ??? = ???.toString();
          i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, ???, (String)???, k);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("[onRespAsync]signature=");
          ((StringBuilder)localObject5).append(???);
          ((StringBuilder)localObject5).append(",errCode=");
          ((StringBuilder)localObject5).append(i);
          ((StringBuilder)localObject5).append(",key=");
          ((StringBuilder)localObject5).append((String)localObject1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject5).toString(), null);
        }
        else
        {
          i = -3;
          a((String)???);
          a((String)localObject5);
        }
        AEOldShortVideoResStatus.a((String)localObject1, k, 0, i);
      }
      else
      {
        AEOldShortVideoResStatus.a((String)localObject1, k, 1, -117);
        a((String)localObject5);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("[onResp]filePath=");
        ((StringBuilder)localObject6).append((String)localObject5);
        ((StringBuilder)localObject6).append(",resp.mResult=");
        ((StringBuilder)localObject6).append(???.mResult);
        ((StringBuilder)localObject6).append(",mErrDesc=");
        ((StringBuilder)localObject6).append(???.mErrDesc);
        ((StringBuilder)localObject6).append(",mErrDesc=");
        ((StringBuilder)localObject6).append(???.mErrDesc);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject6).toString(), null);
        i = -117;
      }
      ??? = new StringBuilder();
      ???.append("[onRespAsync]errCode=");
      ???.append(i);
      ???.append(",saveFilePath=");
      ???.append((String)???);
      ???.append(",key=");
      ???.append((String)localObject1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ???.toString(), null);
      for (;;)
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject3).b = 3;
          k = ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.size();
          if (j >= k) {
            break;
          }
        }
        try
        {
          if ((((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.get(j) != null) && (localObject1 != null)) {
            ((AEOldShortVideoResManager.INet_ShortVideoResource)((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          label805:
          break label805;
        }
        j += 1;
      }
      ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.6(this, paramList), 128, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkResourceItemNeedDownload:name=");
    ((StringBuilder)localObject).append(paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
    localObject = AEOldShortVideoResStatus.a(paramSVConfigItem.name);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkResourceItemNeedDownload:versionCode=");
    localStringBuilder.append(paramSVConfigItem.versionCode);
    localStringBuilder.append(" status.version");
    localStringBuilder.append(((AEOldShortVideoResStatus.ResStatus)localObject).jdField_a_of_type_Int);
    localStringBuilder.append(",status.lastErr=");
    localStringBuilder.append(((AEOldShortVideoResStatus.ResStatus)localObject).c);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
    boolean bool2 = AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem);
    boolean bool1 = false;
    if (!bool2)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:userDownload=false", null);
      return false;
    }
    int i;
    if (paramSVConfigItem.versionCode > ((AEOldShortVideoResStatus.ResStatus)localObject).jdField_a_of_type_Int)
    {
      if (((AEOldShortVideoResStatus.ResStatus)localObject).jdField_a_of_type_Int == 0)
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:status.version=0", null);
        if (new File(str).exists())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("checkResourceItemNeedDownload:[exists]filePath=");
          paramQQAppInterface.append(str);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
          i = a(paramSVConfigItem);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("checkResourceItemNeedDownload[zipVerifyMd5]:errCode=");
          paramQQAppInterface.append(i);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
          if (i != 0) {
            a(str);
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      a(str);
      return true;
    }
    if (paramSVConfigItem.versionCode == ((AEOldShortVideoResStatus.ResStatus)localObject).jdField_a_of_type_Int)
    {
      if (((AEOldShortVideoResStatus.ResStatus)localObject).b != 0)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkResourceItemNeedDownload[No equal]:status=");
        paramQQAppInterface.append(((AEOldShortVideoResStatus.ResStatus)localObject).b);
        paramQQAppInterface.append(",version");
        paramQQAppInterface.append(((AEOldShortVideoResStatus.ResStatus)localObject).jdField_a_of_type_Int);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
        a(str);
        return true;
      }
      bool1 = a(paramSVConfigItem.name);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:exist=");
      paramQQAppInterface.append(bool1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
      if (!bool1) {
        return true;
      }
      i = a(paramSVConfigItem);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:errCode=");
      paramQQAppInterface.append(i);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
      if (i != 0)
      {
        a(str);
        return true;
      }
      if (((AEOldShortVideoResStatus.ResStatus)localObject).c != 0)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkResourceItemNeedDownload[equal]:status=");
        paramQQAppInterface.append(((AEOldShortVideoResStatus.ResStatus)localObject).b);
        paramQQAppInterface.append(",lastErr");
        paramQQAppInterface.append(((AEOldShortVideoResStatus.ResStatus)localObject).c);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
      }
    }
    return false;
  }
  
  private boolean a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = AEOldShortVideoBusinessProcess.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRealSendRequest:alreadyExists=");
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramINet_ShortVideoResource != null) {
        paramINet_ShortVideoResource.a(paramSVConfigItem.name, 0, str);
      }
      paramINet_ShortVideoResource = new StringBuilder();
      paramINet_ShortVideoResource.append("doRealSendRequest:itemConfig.versionCode=");
      paramINet_ShortVideoResource.append(paramSVConfigItem.versionCode);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramINet_ShortVideoResource.toString(), null);
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
      if (!bool)
      {
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
        paramSVConfigItem = new StringBuilder();
        paramSVConfigItem.append("doRealSendRequest:doNoNeedDownload_errCode=");
        paramSVConfigItem.append(i);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramSVConfigItem.toString(), null);
      }
      return bool;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return FileUtils.fileExists(localStringBuilder.toString());
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
    localEditor.putString("short_video_res_config_key", paramString);
    localEditor.putInt("short_video_resource_version", paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShortVideoResConfigContent| saveContentOK，config_content = ");
      localStringBuilder.append(paramString);
      QLog.d("AEOldShortVideoResManager", 2, localStringBuilder.toString());
    }
    return localEditor.commit();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onResp]renameResourceZip destPath=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",outPath=");
      localStringBuilder.append(paramString2);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        paramString1.delete();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
      }
      paramString2 = new File(paramString2);
      long l1 = paramString2.length();
      boolean bool = paramString2.renameTo(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append("[onResp]renameResourceZip orgLength=");
      paramString2.append(l1);
      paramString2.append(",success=");
      paramString2.append(bool);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramString2.toString(), null);
      if (bool)
      {
        bool = paramString1.exists();
        long l2 = paramString1.length();
        paramString1 = new StringBuilder();
        paramString1.append("[onResp]renameResourceZip destExists=");
        paramString1.append(bool);
        paramString1.append(",destLength=");
        paramString1.append(l2);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramString1.toString(), null);
        if ((bool) && (l2 == l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  private static int b()
  {
    int i = a();
    Object localObject1 = a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkLocalConfigIsOK:version=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" config_content");
    ((StringBuilder)localObject2).append((String)localObject1);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject2).toString(), null);
    if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = new ArrayList();
      int j = a((String)localObject1, (List)localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkLocalConfigIsOK:parseConfigData_errCode=");
      ((StringBuilder)localObject1).append(j);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
      i = j;
      if (j == 0) {
        i = a((List)localObject2);
      }
      return i;
    }
    return -101;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    f();
    int j = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUserDownloadConfig[checkLocalConfigIsOK]:errCode=");
    localStringBuilder.append(j);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
    int i;
    if (j != 0)
    {
      boolean bool = NetworkUtil.isNetworkAvailable(null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUserDownloadConfig:netUsable=");
      localStringBuilder.append(bool);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      i = c(paramQQAppInterface, paramISVConfig);
    }
    else
    {
      i = j;
      if (paramISVConfig != null)
      {
        paramISVConfig.a(1, 0);
        i = j;
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("startUserDownloadConfig[end]:errCode=");
    paramQQAppInterface.append(i);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramQQAppInterface.toString(), null);
    return i;
  }
  
  private static int b(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (AEOldShortVideoResManager.SVConfigItem)((Iterator)localObject).next();
        if (paramList.name.startsWith("new_qq_android_native_short_new_other_"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("new_qq_android_native_short_new_other_");
          ((StringBuilder)localObject).append(paramList.versionCode);
          localObject = ((StringBuilder)localObject).toString();
          if (!paramList.name.equalsIgnoreCase((String)localObject))
          {
            QLog.e("AEOldShortVideoResManager", 1, new Object[] { "checkFaceIdentityResVersion: check name ignore error, itemName: ", paramList.name, " validName : ", localObject });
            return -4;
          }
          if (paramList.versionCode < 3)
          {
            QLog.e("AEOldShortVideoResManager", 1, new Object[] { "checkFaceIdentityResVersion:item.versionCode=", Integer.valueOf(paramList.versionCode), " buildInOther=", Integer.valueOf(3) });
            return -2;
          }
          return 0;
        }
      }
      return -2;
    }
    QLog.e("AEOldShortVideoResManager", 1, "checkFaceIdentityResVersion: error: listItem is null or empty");
    return -125;
  }
  
  public static String b()
  {
    return c;
  }
  
  public static void b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveNoDataUpdate LogSignature=");
      localStringBuilder.append(c());
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 2)
      {
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 1;
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          if (jdField_a_of_type_JavaUtilArrayList.get(i) == null) {
            break label171;
          }
          ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, 0);
          break label171;
        }
        jdField_a_of_type_JavaUtilArrayList.clear();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=");
        localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw localObject;
        }
        label171:
        i -= 1;
      }
    }
  }
  
  public static void b(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveSuccess LogSignature=");
      localStringBuilder.append(c());
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 2)
      {
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
        jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 0;
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          if (jdField_a_of_type_JavaUtilArrayList.get(i) == null) {
            break label171;
          }
          ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, paramInt);
          break label171;
        }
        jdField_a_of_type_JavaUtilArrayList.clear();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=");
        localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a());
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", localStringBuilder.toString(), null);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw localObject;
        }
        label171:
        i -= 1;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.5(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private void b(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    Object localObject1 = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          Object localObject2 = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
          if (!((AEOldShortVideoResManager.SVConfigItem)localObject2).predownload)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "preDownloadResource:parseConfigData predownload=false", null);
          }
          else if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AEOldShortVideoResManager.SVConfigItem)localObject2))
          {
            a((AEOldShortVideoResManager.SVConfigItem)localObject2, null);
          }
          else
          {
            int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AEOldShortVideoResManager.SVConfigItem)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=");
            ((StringBuilder)localObject2).append(j);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject2).toString(), null);
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
        i += 1;
      }
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    int j = a(paramISVConfig);
    int i = j;
    if (j == -115)
    {
      a(paramQQAppInterface, paramISVConfig);
      i = 0;
    }
    return i;
  }
  
  private static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashCode=");
    localStringBuilder.append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.hashCode());
    localStringBuilder.append(" ,pid=");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(",tid");
    localStringBuilder.append(Process.myTid());
    return localStringBuilder.toString();
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        AEOldShortVideoResManager.HttpEngineSession localHttpEngineSession = (AEOldShortVideoResManager.HttpEngineSession)localIterator.next();
        if ((localHttpEngineSession != null) && (localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((AEOldShortVideoResManager.INet_ShortVideoResource)localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
            i += 1;
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
  
  private static void f()
  {
    File localFile = new File(b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(d());
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
      QLog.d("AEOldShortVideoResManager", 2, paramContext.toString());
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      i = -101;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateShortVideoResConfigContent| version: ");
        paramContext.append(paramInt);
        paramContext.append(",config_content: ");
        paramContext.append(paramString);
        QLog.d("AEOldShortVideoResManager", 2, paramContext.toString());
        return -101;
      }
    }
    else
    {
      boolean bool = a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateShortVideoResConfigContent| saveContentOK: ");
        paramContext.append(bool);
        QLog.d("AEOldShortVideoResManager", 2, paramContext.toString());
      }
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = -128;
      }
      if (bool)
      {
        bool = AEOldShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("updateShortVideoResConfigContent| downloadState: ");
          paramContext.append(bool);
          QLog.d("AEOldShortVideoResManager", 2, paramContext.toString());
        }
      }
      i = paramInt;
    }
    return i;
  }
  
  public int a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateShortVideoOtherConfigOnly|received save version: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", config_content: ");
    localStringBuilder.append(paramString);
    QLog.d("AEOldShortVideoResManager", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShortVideoOtherConfigOnly| version: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",config_content: ");
      localStringBuilder.append(paramString);
      QLog.d("AEOldShortVideoResManager", 1, localStringBuilder.toString());
      return -101;
    }
    boolean bool = a(paramString, paramInt);
    paramString = new StringBuilder();
    paramString.append("updateShortVideoOtherConfigOnly| saveContentOK: ");
    paramString.append(bool);
    QLog.d("AEOldShortVideoResManager", 1, paramString.toString());
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:result=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",serverError");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",getType=");
    ((StringBuilder)localObject1).append(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:RESULT_OK,saveError=");
        ((StringBuilder)localObject1).append(paramInt2);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
        return;
      }
      paramInt1 = a();
      localObject1 = a();
      if ((paramInt1 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = new ArrayList(1);
        paramInt1 = a((String)localObject1, (List)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:parseConfigData_errCode=");
        ((StringBuilder)localObject1).append(paramInt1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
        if (paramInt1 == -100)
        {
          bool = a("", 0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:parseConfigData_errCode=");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(",successReset=");
          ((StringBuilder)localObject1).append(bool);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
          return;
        }
        if (paramInt1 == 0)
        {
          paramInt1 = a((List)localObject2);
          if (paramInt1 != 0)
          {
            bool = a("", 0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[PreDownload]onConfigResult:checkResourceVersion errCode=");
            ((StringBuilder)localObject1).append(paramInt1);
            ((StringBuilder)localObject1).append(",successReset=");
            ((StringBuilder)localObject1).append(bool);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject1).toString(), null);
            return;
          }
          a((List)localObject2);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
          return;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
        return;
      }
      boolean bool = a("", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[PreDownload]onConfigResult:version=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",successReset=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(",config_content=");
      ((StringBuilder)localObject2).append((String)localObject1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject2).toString(), null);
    }
  }
  
  public void a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
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
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject2).toString(), null);
        if (bool)
        {
          localObject2 = b();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(paramSVConfigItem.name);
          a(((StringBuilder)localObject3).toString());
          localObject2 = d();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(paramSVConfigItem.name);
          a(((StringBuilder)localObject3).toString());
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
          localObject2 = new AEOldShortVideoResManager.HttpEngineSession(this, (HttpNetReq)localObject3);
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;
          } else {
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
          }
          if (paramINet_ShortVideoResource != null)
          {
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[session][new]add callBack ok...", null);
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).a();
        }
      }
      else if (((AEOldShortVideoResManager.HttpEngineSession)localObject2).b == 0)
      {
        ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
        if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;
        } else {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
        }
        if (paramINet_ShortVideoResource != null)
        {
          bool = ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
          paramSVConfigItem = new StringBuilder();
          paramSVConfigItem.append("sendRequest[oldSession][start]contains=");
          paramSVConfigItem.append(bool);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramSVConfigItem.toString(), null);
          if (!bool)
          {
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][start]add callBack ok...", null);
          }
        }
        ((AEOldShortVideoResManager.HttpEngineSession)localObject2).a();
      }
      else if (paramINet_ShortVideoResource != null)
      {
        bool = ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
        paramSVConfigItem = new StringBuilder();
        paramSVConfigItem.append("sendRequest[oldSession][pending]contains=");
        paramSVConfigItem.append(bool);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramSVConfigItem.toString(), null);
        if (!bool)
        {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
      return;
    }
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void d()
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
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        localObject3 = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 != null) {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      jdField_a_of_type_JavaUtilArrayList.clear();
      QLog.d("AEOldShortVideoResManager", 1, new Object[] { "onDestroy sizeCallBack = ", Integer.valueOf(i) });
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      AEOldShortVideoResDownload.a();
      d();
      return;
    }
    finally {}
  }
  
  public final void onResp(NetResp paramNetResp)
  {
    ThreadManager.post(new AEOldShortVideoResManager.7(this, paramNetResp), 5, null, false);
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
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)???).toString(), null);
    int i;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      AEOldShortVideoResManager.HttpEngineSession localHttpEngineSession = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramNetReq);
      localHttpEngineSession.b = 2;
      int j = localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i < j)
      {
        if ((localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (paramNetReq != null)) {
          ((AEOldShortVideoResManager.INet_ShortVideoResource)localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramNetReq, paramLong1, paramLong2);
        }
      }
      else
      {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[onUpdateProgeress]downloadProgress=");
        ((StringBuilder)???).append(i);
        ((StringBuilder)???).append(",key=");
        ((StringBuilder)???).append(paramNetReq);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)???).toString(), null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager
 * JD-Core Version:    0.7.0.1
 */