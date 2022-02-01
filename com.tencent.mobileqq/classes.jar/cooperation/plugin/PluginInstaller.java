package cooperation.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qshadow.constant.Constant;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;

public class PluginInstaller
  implements Handler.Callback
{
  public static HandlerThread a;
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private HashMap<String, PluginInfo> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread = null;
    jdField_a_of_type_JavaLangString = Build.FINGERPRINT;
  }
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(a().getLooper(), this);
    this.b = paramString;
    this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext);
    a();
  }
  
  public static HandlerThread a()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null) {}
    try
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QQ_PLUGIN", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
      }
      return jdField_a_of_type_AndroidOsHandlerThread;
    }
    finally {}
  }
  
  static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return "";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (TextUtils.isEmpty(this.b)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.b + ", " + bool);
      }
      return bool;
      if (new File(this.b).exists()) {
        bool = true;
      }
    }
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramPluginInfo != null) && (paramPluginInfo.mType == 0) && (paramPluginInfo.mSubType == 1)) {
      return bool2;
    }
    if ((paramPluginInfo != null) && (paramPluginInfo.mInstalledPath != null))
    {
      File localFile = new File(paramPluginInfo.mInstalledPath);
      if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
        if (PluginInfoUtil.a(paramPluginInfo, localFile))
        {
          paramPluginInfo.mState = 4;
          paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginInfo.mID + "," + bool1);
        return bool1;
        d(paramPluginInfo.mID);
        paramPluginInfo.mState = 0;
        bool1 = false;
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean a(File paramFile, QZipFile paramQZipFile, ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: iconst_1
    //   13: istore 4
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 180	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   20: astore_1
    //   21: aload_1
    //   22: astore 6
    //   24: aload 7
    //   26: astore 5
    //   28: aload 8
    //   30: astore_1
    //   31: aload 6
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 136	java/io/File:exists	()Z
    //   38: ifne +53 -> 91
    //   41: aload 7
    //   43: astore 5
    //   45: aload 8
    //   47: astore_1
    //   48: aload 6
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 184	java/io/File:getParentFile	()Ljava/io/File;
    //   55: astore 9
    //   57: aload 7
    //   59: astore 5
    //   61: aload 8
    //   63: astore_1
    //   64: aload 6
    //   66: astore_2
    //   67: aload 9
    //   69: invokevirtual 136	java/io/File:exists	()Z
    //   72: ifne +19 -> 91
    //   75: aload 7
    //   77: astore 5
    //   79: aload 8
    //   81: astore_1
    //   82: aload 6
    //   84: astore_2
    //   85: aload 9
    //   87: invokevirtual 187	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload 7
    //   93: astore 5
    //   95: aload 8
    //   97: astore_1
    //   98: aload 6
    //   100: astore_2
    //   101: new 189	java/io/BufferedOutputStream
    //   104: dup
    //   105: new 191	java/io/FileOutputStream
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: invokespecial 197	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   116: invokestatic 203	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   119: astore_0
    //   120: aload_0
    //   121: astore 5
    //   123: aload_0
    //   124: astore_1
    //   125: aload 6
    //   127: astore_2
    //   128: sipush 8192
    //   131: newarray byte
    //   133: astore 7
    //   135: aload_0
    //   136: astore 5
    //   138: aload_0
    //   139: astore_1
    //   140: aload 6
    //   142: astore_2
    //   143: aload 6
    //   145: aload 7
    //   147: invokevirtual 209	java/io/InputStream:read	([B)I
    //   150: istore_3
    //   151: iload_3
    //   152: ifle +66 -> 218
    //   155: aload_0
    //   156: astore 5
    //   158: aload_0
    //   159: astore_1
    //   160: aload 6
    //   162: astore_2
    //   163: aload_0
    //   164: aload 7
    //   166: iconst_0
    //   167: iload_3
    //   168: invokevirtual 215	java/io/OutputStream:write	([BII)V
    //   171: goto -36 -> 135
    //   174: astore_0
    //   175: aload 5
    //   177: astore_1
    //   178: aload 6
    //   180: astore_2
    //   181: ldc 108
    //   183: iconst_1
    //   184: aload_0
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   192: aload 6
    //   194: ifnull +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 222	java/io/InputStream:close	()V
    //   202: aload 5
    //   204: ifnull +8 -> 212
    //   207: aload 5
    //   209: invokevirtual 223	java/io/OutputStream:close	()V
    //   212: iconst_0
    //   213: istore 4
    //   215: iload 4
    //   217: ireturn
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 222	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: ifnull -14 -> 215
    //   232: aload_0
    //   233: invokevirtual 223	java/io/OutputStream:close	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_0
    //   239: iconst_1
    //   240: ireturn
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_2
    //   244: aload 6
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 222	java/io/InputStream:close	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 223	java/io/OutputStream:close	()V
    //   263: aload_0
    //   264: athrow
    //   265: astore_1
    //   266: goto -38 -> 228
    //   269: astore_0
    //   270: goto -68 -> 202
    //   273: astore_0
    //   274: goto -62 -> 212
    //   277: astore_2
    //   278: goto -23 -> 255
    //   281: astore_1
    //   282: goto -19 -> 263
    //   285: astore_0
    //   286: goto -39 -> 247
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 6
    //   293: goto -118 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramFile	File
    //   0	296	1	paramQZipFile	QZipFile
    //   0	296	2	paramZipEntry	ZipEntry
    //   150	18	3	i	int
    //   13	203	4	bool	boolean
    //   1	207	5	localObject1	Object
    //   4	288	6	localQZipFile	QZipFile
    //   10	155	7	arrayOfByte	byte[]
    //   7	89	8	localObject2	Object
    //   55	31	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   34	41	174	java/io/IOException
    //   51	57	174	java/io/IOException
    //   67	75	174	java/io/IOException
    //   85	91	174	java/io/IOException
    //   101	120	174	java/io/IOException
    //   128	135	174	java/io/IOException
    //   143	151	174	java/io/IOException
    //   163	171	174	java/io/IOException
    //   232	236	238	java/io/IOException
    //   15	21	241	finally
    //   223	228	265	java/io/IOException
    //   197	202	269	java/io/IOException
    //   207	212	273	java/io/IOException
    //   251	255	277	java/io/IOException
    //   259	263	281	java/io/IOException
    //   34	41	285	finally
    //   51	57	285	finally
    //   67	75	285	finally
    //   85	91	285	finally
    //   101	120	285	finally
    //   128	135	285	finally
    //   143	151	285	finally
    //   163	171	285	finally
    //   181	192	285	finally
    //   15	21	289	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!PluginUtils.isOsNeedReleaseDex()) {
      return true;
    }
    int j = PluginAdapterImpl.a(paramString1);
    Object localObject2;
    Object localObject1;
    label280:
    boolean bool;
    if (j > 1)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      DexReleasor localDexReleasor = new DexReleasor(paramString2, PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath() + File.separator);
      int i = 1;
      for (;;)
      {
        if (i < j)
        {
          localObject2 = String.format("classes%d.dex", new Object[] { Integer.valueOf(i + 1) });
          localObject1 = PluginUtils.getMultiDexName(paramString1, i + 1);
          if (-1L == localDexReleasor.getEntryCrcCode((String)localObject2))
          {
            QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded noDex " + (String)localObject2 + " " + paramString1);
            i += 1;
          }
          else
          {
            localObject1 = new File(PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath(), (String)localObject1);
            if (((File)localObject1).exists())
            {
              QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded  " + ((File)localObject1).getAbsolutePath() + " exsit,delete first");
              ((File)localObject1).delete();
            }
            a(paramString2, (String)localObject2, (File)localObject1);
            if ((localObject1 == null) || (!((File)localObject1).exists()))
            {
              paramString2 = new StringBuilder().append("releaseMultiDexIfNeeded failed ").append(i).append(" ");
              if (localObject1 != null)
              {
                paramString1 = ((File)localObject1).getAbsolutePath();
                QLog.d("plugin_tag", 1, paramString1);
                bool = false;
                label297:
                localDexReleasor.destroy();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return bool;
      paramString1 = " ";
      break label280;
      localObject2 = new StringBuilder(256);
      ((StringBuilder)localObject2).append("releaseMultiDexIfNeeded ");
      ((StringBuilder)localObject2).append(true);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject2).toString());
      break;
      bool = true;
      break label297;
      bool = true;
    }
  }
  
  private static boolean a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, String.format("unzip %s of file %s  into %s ", new Object[] { paramString2, paramString1, String.valueOf(paramFile) }));
    }
    Object localObject = null;
    try
    {
      QZipFile localQZipFile = new QZipFile(paramString1);
      localObject = localQZipFile;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("plugin_tag", 1, localIOException, new Object[0]);
      }
      paramString1 = localObject.entries();
      ZipEntry localZipEntry;
      do
      {
        if (!paramString1.hasMoreElements()) {
          break;
        }
        localZipEntry = (ZipEntry)paramString1.nextElement();
      } while ((localZipEntry.getName().contains("..")) || (!localZipEntry.getName().equals(paramString2)));
      return a(paramFile, localObject, localZipEntry);
    }
    if (localObject == null)
    {
      QLog.e("plugin_tag", 1, String.format("unzip %s error", new Object[] { paramString1 }));
      return false;
    }
    return false;
  }
  
  private void c(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    int i = 1;
    String str = paramPluginInfo.mID;
    QLog.d("plugin_tag", 1, "doSetupPlugin." + str);
    if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str);
      }
      return;
    }
    if (!c(str)) {}
    while (i != 0)
    {
      a(str, paramOnPluginSetupListener);
      return;
      i = 0;
    }
    a(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean c(String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      paramString = new File(this.b).list(new PluginInstaller.1(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean d(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    a(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
    {
      File localFile = new File(localPluginInfo.mInstalledPath);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    if ((localPluginInfo != null) && (localPluginInfo.mSubType == 1)) {
      return QShadow.getInstance().uninstallPlugin(PluginIdUtil.convertQPluginId2QShadowId(paramString));
    }
    return true;
  }
  
  public PluginInfo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    File localFile1 = a(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = PluginInfoUtil.a(localFile1);
    File[] arrayOfFile = PluginInfoUtil.a(localFile1);
    if (arrayOfFile != null)
    {
      int n = arrayOfFile.length;
      int i = 0;
      if (i < n)
      {
        File localFile2 = arrayOfFile[i];
        Object localObject;
        int j;
        if (localFile2.isFile())
        {
          if (!bool) {
            break label157;
          }
          int m = 0;
          localObject = UpdatePluginVersion.a;
          int i1 = localObject.length;
          j = 0;
          label75:
          int k = m;
          if (j < i1)
          {
            String str = localObject[j];
            if ((InstallPlugins.a(str)) || (!localFile2.getName().equals(str + ".cfg"))) {
              break label150;
            }
            d(str);
            k = 1;
          }
          if (k == 0) {
            break label157;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label150:
          j += 1;
          break label75;
          label157:
          localObject = PluginInfoUtil.a(localFile2);
          if (localObject != null)
          {
            if ((a((PluginInfo)localObject)) || ((("expand.apk".equals(((PluginInfo)localObject).mID)) || (!TripleGraySwitchUtil.b(this.jdField_a_of_type_AndroidContentContext, "KEY_DISABLE_SAVE_PLUGIN_INFO", true))) && (((PluginInfo)localObject).mState == 2)))
            {
              QLog.d("plugin_tag", 1, "put " + ((PluginInfo)localObject).mID + " in to mInstalledPlugins, state: " + ((PluginInfo)localObject).mState);
              this.jdField_a_of_type_JavaUtilHashMap.put(((PluginInfo)localObject).mID, localObject);
            }
          }
          else {
            localFile2.delete();
          }
        }
      }
    }
    if (bool) {
      PluginInfoUtil.a(localFile1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public void a(String paramString, File paramFile, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    int i = 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile);
    if ((PluginUtils.isOsNeedReleaseDex()) && (PluginAdapterImpl.a(paramString) > 1)) {
      localArrayList.add(PluginUtils.getMultiDexSecondDex(this.jdField_a_of_type_AndroidContentContext, paramString));
    }
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramFile = Dex2Oat.a();
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "dex2Oat targetISA = " + paramFile + " " + paramString + " " + localArrayList.size());
        }
        if (!TextUtils.isEmpty(paramFile))
        {
          File localFile = new File(PluginUtils.getOptimizedDexPath(this.jdField_a_of_type_AndroidContentContext).getCanonicalPath());
          long l2 = System.currentTimeMillis();
          boolean bool = Dex2Oat.a(localArrayList, localFile, true, paramFile, new PluginInstaller.2(this));
          l2 = System.currentTimeMillis() - l2;
          paramFile = new StringBuilder("dex2Oat ");
          paramFile.append(l2);
          paramFile.append(", ");
          paramFile.append(bool);
          paramFile.append(", ");
          paramFile.append(paramString);
          QLog.w("plugin_tag", 1, paramFile.toString());
          if (!bool) {
            break label310;
          }
          PluginStatisticsCollector.a(paramString, i, l2);
          l2 = System.currentTimeMillis();
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.a(paramString, "pluginOatCost", l2 - l1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "install finish " + paramString);
          }
        }
        else
        {
          PluginStatisticsCollector.a(paramString, 3, 0L);
          continue;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label310:
      i = 2;
    }
  }
  
  public boolean a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str1);
      }
      return false;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str1);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label144:
      if (!localFile.exists()) {
        break label711;
      }
    }
    label706:
    label711:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
        i = 0;
        break label144;
      }
      if (!a())
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      localObject = new File(new File(this.b), str1);
      if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      paramPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
      FileUtils.a((File)localObject, localFile);
      if (!PluginInfoUtil.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        return false;
      }
      String str2;
      if (paramPluginInfo.mSubType == 1)
      {
        str2 = PluginIdUtil.convertQPluginId2QShadowId(paramPluginInfo.mID);
        if ((QShadow.getInstance().preInstall(str2, localFile)) && (QShadow.getInstance().installPlugin(str2))) {}
        for (i = 1; i == 0; i = 0)
        {
          localFile.delete();
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.b(false, str1);
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
          return false;
        }
      }
      for (;;)
      {
        try
        {
          str2 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, str1).getCanonicalPath();
          str2 = PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
          if (str2 == null) {
            break label706;
          }
          QLog.d("plugin_tag", 1, "extractLibs " + str2);
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
          i = 1;
          continue;
          int j = 0;
          continue;
          if (!PluginManagerV2.a()) {
            break label625;
          }
          a(str1, localFile, paramOnPluginSetupListener);
        }
        j = i;
        if (i == 0)
        {
          if (!a(str1, localFile.getAbsolutePath())) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            continue;
          }
          localFile.delete();
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.b(false, str1);
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
          return false;
        }
        label625:
        paramPluginInfo.mState = 4;
        paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
        paramPluginInfo.mFingerPrint = a();
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        a(paramPluginInfo);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install finish.");
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(true, str1);
        }
        return true;
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (paramString.mState == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "isPluginInstalled installed = " + bool);
      }
      return bool;
    }
  }
  
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installBuiltinPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(paramString);
      }
      return false;
    }
    if (!this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not built in plugin.");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(paramString);
      }
      return false;
    }
    Object localObject1 = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), paramString);
    PluginInfo localPluginInfo2 = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    boolean bool = false;
    Object localObject3 = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    if (localObject3 == null)
    {
      QLog.d("plugin_tag", 1, "plugin not builtin");
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(false, paramString);
      }
      return false;
    }
    if ((localObject3 != null) && (localPluginInfo2 != null) && (!((PluginInfo)localObject3).mMD5.equals(localPluginInfo2.mMD5))) {}
    for (int i = 1;; i = 0)
    {
      if (((File)localObject1).exists()) {
        bool = a(localPluginInfo2);
      }
      if ((!bool) || (i != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin already installed.");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, paramString);
      }
      return true;
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.f(paramString);
    }
    PluginInfo localPluginInfo1 = ((PluginInfo)localObject3).a();
    localPluginInfo1.mState = 3;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo1);
    Object localObject5 = "";
    Object localObject7;
    if (((PluginInfo)localObject3).mSubType == 1)
    {
      localObject1 = PluginIdUtil.convertQPluginId2QShadowId(((PluginInfo)localObject3).mID);
      if (!QShadow.getInstance().installPlugin((String)localObject1))
      {
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, paramString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo2);
        return false;
      }
      localObject7 = QShadowRepository.getInstalledPlugin(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, "");
      localObject5 = new File(Constant.getPluginInstalledPath(this.jdField_a_of_type_AndroidContentContext, (String)localObject1));
    }
    for (;;)
    {
      localPluginInfo1.mLength = ((File)localObject5).length();
      localPluginInfo1.mState = 4;
      localPluginInfo1.mInstalledPath = ((File)localObject5).getAbsolutePath();
      localPluginInfo1.mMD5 = ((String)localObject7);
      localPluginInfo1.mFingerPrint = a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo1);
      a(localPluginInfo1);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "install finish");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, paramString);
      }
      return true;
      long l1 = System.currentTimeMillis();
      try
      {
        localObject7 = paramString.substring(0, paramString.indexOf(".apk"));
        localObject3 = SoLoadCore.getReleasedSoFilePath(this.jdField_a_of_type_AndroidContentContext, (String)localObject7);
        if (localObject3 != null) {
          break label962;
        }
        localObject3 = SoLoadCore.releaseSo(this.jdField_a_of_type_AndroidContentContext, (String)localObject7);
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          continue;
        }
      }
      if (localObject3 == null) {
        break label959;
      }
      localObject3 = new File((String)localObject3);
      try
      {
        localObject7 = localPluginInfo1.mMD5;
        localObject1 = localObject3;
        localObject5 = localObject7;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject4;
          Object localObject6;
          Object localObject2 = localException3;
        }
      }
      localObject3 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {}
      try
      {
        localObject3 = PluginUtils.extractPluginAndGetMd5Code(this.jdField_a_of_type_AndroidContentContext, paramString, (File)localObject1);
        localObject5 = localPluginInfo1.mMD5;
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "md5:" + (String)localObject5 + " vs " + (String)localObject3);
        }
        bool = ((String)localObject3).equals(localObject5);
        if ((0 == 0) && (bool))
        {
          long l2 = System.currentTimeMillis();
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.a(paramString, "pluginApkCost", l2 - l1);
          }
          i = 0;
          try
          {
            localObject5 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, paramString).getCanonicalPath();
            l1 = System.currentTimeMillis();
            localObject5 = PluginUtils.extractLibs(((File)localObject1).getCanonicalPath(), (String)localObject5);
            l2 = System.currentTimeMillis();
            if (paramOnPluginSetupListener != null) {
              paramOnPluginSetupListener.a(paramString, "pluginLibCost", l2 - l1);
            }
            if (localObject5 != null)
            {
              QLog.d("plugin_tag", 1, "extractLibs " + (String)localObject5);
              i = 1;
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              float f;
              QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
              i = 1;
              continue;
              int j = 0;
            }
          }
          j = i;
          if (i == 0)
          {
            if (!a(paramString, ((File)localObject1).getAbsolutePath())) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break label912;
            }
            ((File)localObject1).delete();
            if (paramOnPluginSetupListener != null) {
              paramOnPluginSetupListener.b(false, paramString);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo2);
            return false;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          f = FileUtils.a();
          QLog.d("plugin_tag", 1, "extractPluginAndGetMd5Code failed installPath = " + localObject1 + ", leftSpace = " + f, localException2);
          localObject4 = localObject5;
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, paramString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo2);
        return false;
      }
      label912:
      localObject7 = localObject4;
      localObject6 = localObject1;
      if (PluginManagerV2.a())
      {
        a(paramString, (File)localObject1, paramOnPluginSetupListener);
        localObject7 = localObject4;
        localObject6 = localObject1;
      }
    }
  }
  
  void b(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramPluginInfo.mID, paramPluginInfo);
    a(paramPluginInfo);
  }
  
  public void b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(67072, paramPluginInfo).sendToTarget();
  }
  
  public boolean b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDex2OatPlugin." + str);
    }
    PluginInfo localPluginInfo = a(str);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 4)) {
      QLog.d("plugin_tag", 1, "doDex2OatPlugin. already " + str);
    }
    for (;;)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, str);
      }
      return true;
      if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
      {
        QLog.d("plugin_tag", 1, "doDex2OatPlugin. isPluginRunning " + str);
      }
      else
      {
        a(str, new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str), paramOnPluginSetupListener);
        paramPluginInfo.mState = 4;
        paramPluginInfo.mFingerPrint = a();
        a(paramPluginInfo);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doDex2OatPlugin finish");
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return d(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 66816: 
      paramMessage = (Pair)paramMessage.obj;
      c((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
      return true;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */