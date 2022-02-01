package cooperation.qzone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneAlphaConfig;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class UploadSoDownloader
{
  private static final String KEY_UPLOAD_DOWNLOAD_SUCCESS = "upload_so_download_success";
  private static final String KEY_UPLOAD_VER = "upload_so_ver";
  private static int MAX_DOWNLOADER_RETRY_COUNT = 5;
  private static final String PRE_UPLOAD_DOWNLOAD = "qzone_upload_so";
  private static final String TAG = "[upload2]UploadEnv";
  private static boolean isSoDownloading = false;
  private static File mUploadSoDir = MobileQQ.getContext().getDir("qzoneupload", 0);
  private static volatile boolean useDownloadedSo = false;
  
  private boolean checkSoMd5(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("md5.json");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject1).exists()) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(FileUtils.readFileContent((File)localObject1)).getJSONArray("so_lib");
      int i = 0;
      boolean bool = false;
      while (i < localJSONArray.length())
      {
        Object localObject2 = (JSONObject)localJSONArray.get(i);
        localObject1 = ((JSONObject)localObject2).getString("name");
        localObject2 = ((JSONObject)localObject2).getString("md5");
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject3 = new File(((StringBuilder)localObject3).toString());
        if (!((File)localObject3).exists())
        {
          paramString = new StringBuilder();
          paramString.append("so not exists ");
          paramString.append((String)localObject1);
          QLog.d("[upload2]UploadEnv", 1, paramString.toString());
          break;
        }
        String str = MD5.a((File)localObject3);
        QLog.d("[upload2]UploadEnv", 1, new Object[] { "src md5 : ", str, " dst md5 : ", localObject2, " file size :", Long.valueOf(((File)localObject3).length()), " file : ", localObject1 });
        if (!str.equals(localObject2)) {
          break;
        }
        int j = localJSONArray.length();
        if (i == j - 1) {
          bool = true;
        }
        i += 1;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkSoMd5 error : ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private void delLastVersionRetryCnt(String paramString)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("qzone_upload_so", 0);
    String str = "";
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("upload_so_ver", "");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last ver ");
    localStringBuilder.append(str);
    localStringBuilder.append(" curUrl:");
    localStringBuilder.append(paramString);
    QLog.d("[upload2]UploadEnv", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (str.equals(paramString)) {
      return;
    }
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().remove(str);
      localSharedPreferences.edit().remove("upload_so_ver");
    }
  }
  
  private int getRetryCnt()
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null)
    {
      String str = ((SharedPreferences)localObject).getString("upload_so_ver", "");
      int i = ((SharedPreferences)localObject).getInt(str, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRetryCnt ver ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" cnt:");
      ((StringBuilder)localObject).append(i);
      QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
      return i;
    }
    QLog.d("[upload2]UploadEnv", 1, "getRetryCnt 0");
    return 0;
  }
  
  private boolean getSoDownloadState()
  {
    Object localObject = MobileQQ.sMobileQQ;
    boolean bool = false;
    localObject = ((MobileQQ)localObject).getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null) {
      bool = ((SharedPreferences)localObject).getBoolean("upload_so_download_success", false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSoDownloadState ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static boolean isRunningInQzoneProcess()
  {
    boolean bool2 = false;
    try
    {
      String str = MobileQQ.sMobileQQ.getQQProcessName();
      boolean bool1 = bool2;
      if (str != null)
      {
        boolean bool3 = str.endsWith(":qzone");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private void recordRetryCnt(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordRetryCnt ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
    delLastVersionRetryCnt(paramString);
    localObject = MobileQQ.sMobileQQ.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((SharedPreferences)localObject).getString("upload_so_ver", ""))) {
        ((SharedPreferences)localObject).edit().putString("upload_so_ver", paramString).commit();
      }
      int i = ((SharedPreferences)localObject).getInt(paramString, 0);
      ((SharedPreferences)localObject).edit().putInt(paramString, i + 1).commit();
    }
  }
  
  private void saveSoDownloadState(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveSoDownloadState ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
    localObject = MobileQQ.sMobileQQ.getSharedPreferences("qzone_upload_so", 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("upload_so_download_success", paramBoolean).commit();
    }
  }
  
  /* Error */
  public void downloadUploadSo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 269	cooperation/qzone/UploadSoDownloader:isRunningInQzoneProcess	()Z
    //   5: ifne +19 -> 24
    //   8: iconst_0
    //   9: putstatic 45	cooperation/qzone/UploadSoDownloader:useDownloadedSo	Z
    //   12: ldc 20
    //   14: iconst_1
    //   15: ldc_w 271
    //   18: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc_w 273
    //   27: invokestatic 279	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   30: checkcast 273	com/tencent/qzonehub/api/IQzoneModuleManageApi
    //   33: ldc_w 281
    //   36: invokeinterface 284 2 0
    //   41: istore_2
    //   42: aload_0
    //   43: invokespecial 286	cooperation/qzone/UploadSoDownloader:getSoDownloadState	()Z
    //   46: istore_3
    //   47: new 72	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   54: astore 4
    //   56: aload 4
    //   58: ldc_w 288
    //   61: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: iload_2
    //   68: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: ldc_w 290
    //   77: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 4
    //   83: iload_3
    //   84: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: ldc_w 292
    //   93: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: getstatic 47	cooperation/qzone/UploadSoDownloader:isSoDownloading	Z
    //   102: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: ldc_w 294
    //   111: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokestatic 299	android/os/Process:myPid	()I
    //   120: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 20
    //   126: iconst_1
    //   127: aload 4
    //   129: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload_2
    //   136: ifne +37 -> 173
    //   139: iload_3
    //   140: ifeq +33 -> 173
    //   143: ldc 20
    //   145: iconst_1
    //   146: ldc_w 301
    //   149: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: putstatic 45	cooperation/qzone/UploadSoDownloader:useDownloadedSo	Z
    //   156: new 303	cooperation/qzone/UploadSoDownloader$1
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 306	cooperation/qzone/UploadSoDownloader$1:<init>	(Lcooperation/qzone/UploadSoDownloader;)V
    //   164: iconst_5
    //   165: aconst_null
    //   166: iconst_1
    //   167: invokestatic 312	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   170: aload_0
    //   171: monitorexit
    //   172: return
    //   173: getstatic 47	cooperation/qzone/UploadSoDownloader:isSoDownloading	Z
    //   176: istore_2
    //   177: iload_2
    //   178: ifeq +6 -> 184
    //   181: aload_0
    //   182: monitorexit
    //   183: return
    //   184: ldc 20
    //   186: iconst_1
    //   187: ldc_w 314
    //   190: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iconst_1
    //   194: putstatic 47	cooperation/qzone/UploadSoDownloader:isSoDownloading	Z
    //   197: iconst_0
    //   198: putstatic 45	cooperation/qzone/UploadSoDownloader:useDownloadedSo	Z
    //   201: aload_0
    //   202: iconst_0
    //   203: invokespecial 67	cooperation/qzone/UploadSoDownloader:saveSoDownloadState	(Z)V
    //   206: ldc_w 273
    //   209: invokestatic 279	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   212: checkcast 273	com/tencent/qzonehub/api/IQzoneModuleManageApi
    //   215: ldc_w 281
    //   218: invokeinterface 318 2 0
    //   223: astore 4
    //   225: ldc_w 273
    //   228: invokestatic 279	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   231: checkcast 273	com/tencent/qzonehub/api/IQzoneModuleManageApi
    //   234: ldc_w 281
    //   237: invokeinterface 321 2 0
    //   242: astore 5
    //   244: aload 4
    //   246: ifnonnull +14 -> 260
    //   249: iconst_0
    //   250: putstatic 47	cooperation/qzone/UploadSoDownloader:isSoDownloading	Z
    //   253: iconst_0
    //   254: putstatic 45	cooperation/qzone/UploadSoDownloader:useDownloadedSo	Z
    //   257: aload_0
    //   258: monitorexit
    //   259: return
    //   260: aload_0
    //   261: invokespecial 323	cooperation/qzone/UploadSoDownloader:getRetryCnt	()I
    //   264: istore_1
    //   265: iload_1
    //   266: getstatic 325	cooperation/qzone/UploadSoDownloader:MAX_DOWNLOADER_RETRY_COUNT	I
    //   269: iconst_2
    //   270: idiv
    //   271: if_icmple +27 -> 298
    //   274: iload_1
    //   275: getstatic 325	cooperation/qzone/UploadSoDownloader:MAX_DOWNLOADER_RETRY_COUNT	I
    //   278: if_icmpge +20 -> 298
    //   281: new 79	java/io/File
    //   284: dup
    //   285: aload 5
    //   287: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: astore 5
    //   292: aload 5
    //   294: invokevirtual 328	java/io/File:delete	()Z
    //   297: pop
    //   298: iload_1
    //   299: getstatic 325	cooperation/qzone/UploadSoDownloader:MAX_DOWNLOADER_RETRY_COUNT	I
    //   302: if_icmple +49 -> 351
    //   305: new 72	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   312: astore 4
    //   314: aload 4
    //   316: ldc_w 330
    //   319: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 4
    //   325: aload_0
    //   326: invokespecial 323	cooperation/qzone/UploadSoDownloader:getRetryCnt	()I
    //   329: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 20
    //   335: iconst_1
    //   336: aload 4
    //   338: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iconst_0
    //   345: putstatic 47	cooperation/qzone/UploadSoDownloader:isSoDownloading	Z
    //   348: aload_0
    //   349: monitorexit
    //   350: return
    //   351: aload_0
    //   352: aload 4
    //   354: getfield 336	cooperation/qzone/networkedmodule/QzoneModuleRecord:mNewVersion	Lcooperation/qzone/networkedmodule/QzoneModuleRecord;
    //   357: getfield 339	cooperation/qzone/networkedmodule/QzoneModuleRecord:mUrl	Ljava/lang/String;
    //   360: invokespecial 341	cooperation/qzone/UploadSoDownloader:recordRetryCnt	(Ljava/lang/String;)V
    //   363: ldc_w 273
    //   366: invokestatic 279	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   369: checkcast 273	com/tencent/qzonehub/api/IQzoneModuleManageApi
    //   372: ldc_w 281
    //   375: new 343	cooperation/qzone/UploadSoDownloader$2
    //   378: dup
    //   379: aload_0
    //   380: invokespecial 344	cooperation/qzone/UploadSoDownloader$2:<init>	(Lcooperation/qzone/UploadSoDownloader;)V
    //   383: invokeinterface 348 3 0
    //   388: pop
    //   389: aload_0
    //   390: monitorexit
    //   391: return
    //   392: astore 4
    //   394: aload_0
    //   395: monitorexit
    //   396: aload 4
    //   398: athrow
    //   399: astore 5
    //   401: goto -103 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	UploadSoDownloader
    //   264	39	1	i	int
    //   41	137	2	bool1	boolean
    //   46	94	3	bool2	boolean
    //   54	299	4	localObject1	Object
    //   392	5	4	localObject2	Object
    //   242	51	5	localObject3	Object
    //   399	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	21	392	finally
    //   24	135	392	finally
    //   143	170	392	finally
    //   173	177	392	finally
    //   184	244	392	finally
    //   249	257	392	finally
    //   260	292	392	finally
    //   292	298	392	finally
    //   298	348	392	finally
    //   351	389	392	finally
    //   292	298	399	java/lang/Exception
  }
  
  public boolean loadLibrary(String paramString)
  {
    label372:
    try
    {
      int i = QzoneAlphaConfig.a().a("QzoneUploadSetting", "UploadEnableDownloadSo", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upload so enableLoadSo ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" useDownloadedSo ");
      ((StringBuilder)localObject).append(useDownloadedSo);
      QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
      if (i != 1) {
        useDownloadedSo = false;
      }
      bool = getSoDownloadState();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upload so getSoDownloadState ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
      if (!bool) {
        useDownloadedSo = false;
      }
      if (useDownloadedSo)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(mUploadSoDir.getAbsolutePath());
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("lib");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".so");
        localObject = new File(((StringBuilder)localObject).toString());
        bool = ((File)localObject).exists();
        if (bool) {
          try
          {
            System.load(((File)localObject).getAbsolutePath());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("upload so load downloaded so ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
            return true;
          }
          catch (Throwable paramString)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("load downloaded so fail:");
            ((StringBuilder)localObject).append(paramString.getMessage());
            QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
            useDownloadedSo = false;
            saveSoDownloadState(false);
          }
        }
      }
    }
    finally {}
    try
    {
      mUploadSoDir.delete();
    }
    catch (Exception paramString)
    {
      break label372;
    }
    useDownloadedSo = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloaded upload so not exists:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
    saveSoDownloadState(false);
    mUploadSoDir.delete();
    boolean bool = useDownloadedSo;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader
 * JD-Core Version:    0.7.0.1
 */