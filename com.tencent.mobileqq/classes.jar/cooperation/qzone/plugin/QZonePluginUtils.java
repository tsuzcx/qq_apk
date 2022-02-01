package cooperation.qzone.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.plugin.PluginInfoUtil;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QZonePluginUtils
{
  public static final String KEY_QZONE_LIVE_PLUGIN_ID = "qzone_live_pluginid";
  private static final String PLUGIN_DOWNLOAED_PATH = "qzone_downloaded_plugins";
  private static final String PLUGIN_INFO_PATH = "qzone_plugin_info";
  private static final String PLUGIN_INSTALL_PATH = "qzone_installed_plugin";
  public static final String[] PTU_SO_LIBRARY = { "image_filter_common", "image_filter_gpu", "format_convert", "ParticleSystem", "pitu_tools", "YTCommon", "YTIllumination", "YTFaceTrackPro", "algo_youtu_jni" };
  public static final String PTU_SO_filter_com = getSoLibraryName(PTU_SO_LIBRARY[0]);
  public static final String PTU_SO_filter_gpu = getSoLibraryName(PTU_SO_LIBRARY[1]);
  public static final String QZONE_LIVE_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
  private static final String SV_SO_FILTER_PITU_TOOLS = "libpitu_tools.so";
  private static final String SV_SO_filter_CONVERT = "libformat_convert.so";
  private static final String TAG = "QZonePluginManger";
  public static String mQzoneLivePluginId;
  
  public static void deleteInstalledPluginInfo(PluginRecord paramPluginRecord)
  {
    try
    {
      paramPluginRecord = getIntalledPluginCfgFile(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((paramPluginRecord.isFile()) && (paramPluginRecord.exists())) {
        paramPluginRecord.delete();
      }
      return;
    }
    catch (Exception paramPluginRecord) {}
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static File getIntalledPluginCfgFile(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("qzone_installed_plugin", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cfg");
    return new File(paramContext, localStringBuilder.toString());
  }
  
  public static String getLoadQZoneLivePluginId()
  {
    if (!TextUtils.isEmpty(mQzoneLivePluginId)) {
      return mQzoneLivePluginId;
    }
    Object localObject2 = "qzone_live_video_plugin_hack.apk";
    Object localObject1 = LocalMultiProcConfig.getString("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
    int k = useLocalLivePlugin();
    int j = 0;
    int i = 0;
    if ((k == 0) && (!"qzone_live_video_plugin_hack.apk".equals(localObject1)))
    {
      List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      while (i < localList.size())
      {
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(i)).processName))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject2).toString());
          }
          return localObject1;
        }
        i += 1;
      }
      LocalMultiProcConfig.putString("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
      localObject1 = localObject2;
    }
    else if ((k == 1) && (!"qzone_live_video_plugin.apk".equals(localObject1)))
    {
      localObject2 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      i = j;
      while (i < ((List)localObject2).size())
      {
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(i)).processName))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject2).toString());
          }
          return localObject1;
        }
        i += 1;
      }
      LocalMultiProcConfig.putString("qzone_live_pluginid", "qzone_live_video_plugin.apk");
      localObject1 = "qzone_live_video_plugin.apk";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLoadQZoneLivePluginId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject2).toString());
    }
    mQzoneLivePluginId = (String)localObject1;
    return localObject1;
  }
  
  public static File getPluginCfgFile(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("qzone_plugin_info", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cfg");
    return new File(paramContext, localStringBuilder.toString());
  }
  
  public static File getPluginDownLoadedPath(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_downloaded_plugins", 0), paramString);
  }
  
  public static File[] getPluginInfoFileList(File paramFile)
  {
    return paramFile.listFiles(new QZonePluginUtils.1());
  }
  
  public static File getPluginInstallDir(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  public static File getPluginInstallFile(Context paramContext, String paramString)
  {
    return new File(getPluginInstallDir(paramContext), paramString);
  }
  
  public static File getPluginLib(Context paramContext, String paramString)
  {
    return PluginUtils.getPluginLibPath(paramContext, paramString);
  }
  
  public static String getQzoneSVFilterSoPath(Context paramContext)
  {
    String str;
    if ("qzone_live_video_plugin.apk".equals(getLoadQZoneLivePluginId())) {
      str = "/app_lib/qzone_live_video_plugin/";
    } else {
      str = "/app_lib/qzone_live_video_plugin_hack/";
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getParent());
      localStringBuilder.append(str);
      localStringBuilder.append("/PTBase/");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static String getSoLibraryName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  static boolean isPluginRunning(PluginRecord paramPluginRecord, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPluginRecord != null)
    {
      if (paramContext == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramPluginRecord.mProcesses)) {
        return false;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        bool1 = bool2;
        if (!paramContext.hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      } while (!paramPluginRecord.mProcesses.equalsIgnoreCase(localRunningAppProcessInfo.processName));
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isProcessExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isQzoneLiveSoExist(Context paramContext)
  {
    paramContext = getQzoneSVFilterSoPath(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(PTU_SO_filter_com);
    boolean bool1 = fileExists(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(PTU_SO_filter_gpu);
    boolean bool2 = fileExists(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("libformat_convert.so");
    boolean bool3 = fileExists(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("libpitu_tools.so");
    boolean bool4 = fileExists(localStringBuilder.toString());
    int i = LocalMultiProcConfig.getInt("QzoneLiveSoVersion", 0);
    int j = QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5);
    return (bool1) && (bool2) && (bool3) && (bool4) && (i == j);
  }
  
  public static void listInstalledPlugininfos(Context paramContext, Map<String, PluginRecord> paramMap, QZonePluginInstaller.OnValidatePluginListner paramOnValidatePluginListner)
  {
    int i = 0;
    paramContext = getPluginInfoFileList(paramContext.getDir("qzone_installed_plugin", 0));
    if (paramContext != null)
    {
      int j = paramContext.length;
      while (i < j)
      {
        File localFile = paramContext[i];
        if (localFile.exists())
        {
          PluginRecord localPluginRecord = readFileCfg(localFile);
          if (localPluginRecord != null)
          {
            boolean bool;
            if (paramOnValidatePluginListner != null) {
              bool = paramOnValidatePluginListner.onValidatePlugin(localPluginRecord, localFile);
            } else {
              bool = true;
            }
            if (bool) {
              paramMap.put(localPluginRecord.id, localPluginRecord);
            } else {
              localFile.delete();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static void listPluginInfos(Context paramContext, Map<String, PluginRecord> paramMap)
  {
    int j = 0;
    int i = 0;
    Object localObject = paramContext.getDir("qzone_plugin_info", 0);
    boolean bool = PluginInfoUtil.a((File)localObject);
    paramContext = getPluginInfoFileList((File)localObject);
    if (paramContext != null)
    {
      if (bool)
      {
        j = paramContext.length;
        while (i < j)
        {
          paramMap = paramContext[i];
          if (paramMap.exists()) {
            paramMap.delete();
          }
          i += 1;
        }
        PluginInfoUtil.b((File)localObject);
        return;
      }
      int k = paramContext.length;
      i = j;
      while (i < k)
      {
        localObject = paramContext[i];
        if (((File)localObject).exists())
        {
          localObject = readFileCfg((File)localObject);
          if (localObject != null) {
            paramMap.put(((PluginRecord)localObject).id, localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static PluginRecord readFileCfg(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_1
    //   8: new 334	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 336	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 340	java/io/File:length	()J
    //   21: l2i
    //   22: newarray byte
    //   24: astore_0
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 344	java/io/FileInputStream:read	([B)I
    //   30: pop
    //   31: new 38	java/lang/String
    //   34: dup
    //   35: aload_0
    //   36: iconst_0
    //   37: invokestatic 350	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   40: invokespecial 353	java/lang/String:<init>	([B)V
    //   43: astore_1
    //   44: new 82	cooperation/qzone/plugin/PluginRecord
    //   47: dup
    //   48: invokespecial 354	cooperation/qzone/plugin/PluginRecord:<init>	()V
    //   51: astore_0
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 357	cooperation/qzone/plugin/PluginRecord:fromJson	(Ljava/lang/String;)V
    //   57: aload_2
    //   58: invokevirtual 360	java/io/FileInputStream:close	()V
    //   61: goto +8 -> 69
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   69: aload_0
    //   70: areturn
    //   71: astore_1
    //   72: goto +14 -> 86
    //   75: astore_1
    //   76: goto +18 -> 94
    //   79: astore_0
    //   80: goto +86 -> 166
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_1
    //   87: astore_3
    //   88: goto +23 -> 111
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_1
    //   95: astore_3
    //   96: goto +48 -> 144
    //   99: astore_0
    //   100: aload_1
    //   101: astore_2
    //   102: goto +64 -> 166
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_0
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: ifnull +44 -> 164
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: invokevirtual 360	java/io/FileInputStream:close	()V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   136: aload_1
    //   137: areturn
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_0
    //   141: aload 5
    //   143: astore_2
    //   144: aload_2
    //   145: astore_1
    //   146: aload_3
    //   147: invokevirtual 364	java/io/FileNotFoundException:printStackTrace	()V
    //   150: aload_0
    //   151: astore_1
    //   152: aload_2
    //   153: ifnull +11 -> 164
    //   156: aload_0
    //   157: astore_1
    //   158: aload_2
    //   159: invokevirtual 360	java/io/FileInputStream:close	()V
    //   162: aload_0
    //   163: astore_1
    //   164: aload_1
    //   165: areturn
    //   166: aload_2
    //   167: ifnull +15 -> 182
    //   170: aload_2
    //   171: invokevirtual 360	java/io/FileInputStream:close	()V
    //   174: goto +8 -> 182
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   182: aload_0
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	File
    //   7	47	1	str	String
    //   64	2	1	localIOException1	java.io.IOException
    //   71	1	1	localIOException2	java.io.IOException
    //   75	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   83	4	1	localIOException3	java.io.IOException
    //   91	10	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   112	53	1	localObject1	Object
    //   177	2	1	localIOException4	java.io.IOException
    //   16	155	2	localObject2	Object
    //   87	9	3	localObject3	Object
    //   105	9	3	localIOException5	java.io.IOException
    //   138	9	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	108	4	localObject4	Object
    //   4	138	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	61	64	java/io/IOException
    //   52	57	71	java/io/IOException
    //   52	57	75	java/io/FileNotFoundException
    //   17	52	79	finally
    //   52	57	79	finally
    //   17	52	83	java/io/IOException
    //   17	52	91	java/io/FileNotFoundException
    //   8	17	99	finally
    //   113	117	99	finally
    //   146	150	99	finally
    //   8	17	105	java/io/IOException
    //   125	129	131	java/io/IOException
    //   158	162	131	java/io/IOException
    //   8	17	138	java/io/FileNotFoundException
    //   170	174	177	java/io/IOException
  }
  
  public static void saveInstalledPluginInfo(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = getIntalledPluginCfgFile(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      saveToFile(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, "saveInstalledPluginInfo", paramPluginRecord);
    }
  }
  
  public static void savePluginInfo(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = getPluginCfgFile(BaseApplicationImpl.getContext(), paramPluginRecord.id);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      saveToFile(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, "savePluginInfo", paramPluginRecord);
    }
  }
  
  /* Error */
  private static boolean saveToFile(File paramFile, PluginRecord paramPluginRecord)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_1
    //   8: invokevirtual 384	cooperation/qzone/plugin/PluginRecord:toJson	()Ljava/lang/String;
    //   11: astore 5
    //   13: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +39 -> 55
    //   19: new 114	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   26: astore 6
    //   28: aload 6
    //   30: ldc_w 386
    //   33: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 6
    //   39: aload_1
    //   40: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 33
    //   46: iconst_2
    //   47: aload 6
    //   49: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload 5
    //   57: invokevirtual 396	java/lang/String:getBytes	()[B
    //   60: iconst_0
    //   61: invokestatic 399	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   64: astore_1
    //   65: new 401	java/io/FileOutputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 402	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_0
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 405	java/io/FileOutputStream:write	([B)V
    //   79: iconst_1
    //   80: istore_2
    //   81: aload_0
    //   82: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_3
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: astore_0
    //   92: goto +9 -> 101
    //   95: goto +16 -> 111
    //   98: astore_0
    //   99: aload_3
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_0
    //   122: aload 4
    //   124: astore_0
    //   125: goto -14 -> 111
    //   128: astore_1
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: iload_2
    //   134: ireturn
    //   135: astore_1
    //   136: goto -27 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramFile	File
    //   0	139	1	paramPluginRecord	PluginRecord
    //   1	133	2	bool	boolean
    //   6	1	3	localObject1	Object
    //   87	13	3	localObject2	Object
    //   3	120	4	localObject3	Object
    //   11	45	5	str	String
    //   26	22	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   74	79	87	finally
    //   7	55	98	finally
    //   55	74	98	finally
    //   7	55	121	java/lang/Exception
    //   55	74	121	java/lang/Exception
    //   74	79	128	java/lang/Exception
    //   81	85	132	java/io/IOException
    //   115	119	132	java/io/IOException
    //   105	109	135	java/io/IOException
  }
  
  public static int useLocalLivePlugin()
  {
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "useQQPluginManager", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[useLocalLivePlugin] value=");
      localStringBuilder.append(i);
      QLog.d("QZonePluginManger", 2, localStringBuilder.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUtils
 * JD-Core Version:    0.7.0.1
 */