package cooperation.plugin;

import android.app.Application;
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
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
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
  public static String b = Build.FINGERPRINT;
  private boolean c;
  private Context d;
  private String e;
  private HashMap<String, PluginInfo> f;
  private BuiltinPluginManager g;
  private Handler h;
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    this.d = paramContext;
    this.f = new HashMap();
    this.h = new Handler(a().getLooper(), this);
    this.e = paramString;
    this.g = BuiltinPluginManager.a(this.d);
    b();
  }
  
  public static HandlerThread a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = ThreadManager.newFreeHandlerThread("QQ_PLUGIN", 0);
          a.start();
        }
      }
      finally {}
    }
    return a;
  }
  
  static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  /* Error */
  private static boolean a(File paramFile, QZipFile paramQZipFile, ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   17: astore 4
    //   19: aload 6
    //   21: astore_2
    //   22: aload 7
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 104	java/io/File:exists	()Z
    //   29: ifne +41 -> 70
    //   32: aload 6
    //   34: astore_2
    //   35: aload 7
    //   37: astore_1
    //   38: aload_0
    //   39: invokevirtual 108	java/io/File:getParentFile	()Ljava/io/File;
    //   42: astore 5
    //   44: aload 6
    //   46: astore_2
    //   47: aload 7
    //   49: astore_1
    //   50: aload 5
    //   52: invokevirtual 104	java/io/File:exists	()Z
    //   55: ifne +15 -> 70
    //   58: aload 6
    //   60: astore_2
    //   61: aload 7
    //   63: astore_1
    //   64: aload 5
    //   66: invokevirtual 111	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: aload 6
    //   72: astore_2
    //   73: aload 7
    //   75: astore_1
    //   76: new 113	java/io/BufferedOutputStream
    //   79: dup
    //   80: new 115	java/io/FileOutputStream
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: invokespecial 121	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: invokestatic 127	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   94: astore_0
    //   95: aload_0
    //   96: astore_2
    //   97: aload_0
    //   98: astore_1
    //   99: sipush 8192
    //   102: newarray byte
    //   104: astore 5
    //   106: aload_0
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload 4
    //   112: aload 5
    //   114: invokevirtual 133	java/io/InputStream:read	([B)I
    //   117: istore_3
    //   118: iload_3
    //   119: ifle +18 -> 137
    //   122: aload_0
    //   123: astore_2
    //   124: aload_0
    //   125: astore_1
    //   126: aload_0
    //   127: aload 5
    //   129: iconst_0
    //   130: iload_3
    //   131: invokevirtual 139	java/io/OutputStream:write	([BII)V
    //   134: goto -28 -> 106
    //   137: aload 4
    //   139: ifnull +11 -> 150
    //   142: aload 4
    //   144: invokevirtual 142	java/io/InputStream:close	()V
    //   147: goto +3 -> 150
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 143	java/io/OutputStream:close	()V
    //   158: iconst_1
    //   159: ireturn
    //   160: astore_0
    //   161: aload 4
    //   163: astore_1
    //   164: goto +66 -> 230
    //   167: astore_2
    //   168: aload 4
    //   170: astore_0
    //   171: goto +18 -> 189
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: aload 8
    //   179: astore_2
    //   180: goto +50 -> 230
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_1
    //   186: aload 5
    //   188: astore_0
    //   189: ldc 145
    //   191: iconst_1
    //   192: aload_2
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   200: aload_0
    //   201: ifnull +10 -> 211
    //   204: aload_0
    //   205: invokevirtual 142	java/io/InputStream:close	()V
    //   208: goto +3 -> 211
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 143	java/io/OutputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore 4
    //   223: aload_1
    //   224: astore_2
    //   225: aload_0
    //   226: astore_1
    //   227: aload 4
    //   229: astore_0
    //   230: aload_1
    //   231: ifnull +10 -> 241
    //   234: aload_1
    //   235: invokevirtual 142	java/io/InputStream:close	()V
    //   238: goto +3 -> 241
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 143	java/io/OutputStream:close	()V
    //   249: goto +5 -> 254
    //   252: aload_0
    //   253: athrow
    //   254: goto -2 -> 252
    //   257: astore_1
    //   258: goto -108 -> 150
    //   261: astore_0
    //   262: iconst_1
    //   263: ireturn
    //   264: astore_0
    //   265: goto -54 -> 211
    //   268: astore_0
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_1
    //   272: goto -31 -> 241
    //   275: astore_1
    //   276: goto -27 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramFile	File
    //   0	279	1	paramQZipFile	QZipFile
    //   0	279	2	paramZipEntry	ZipEntry
    //   117	14	3	i	int
    //   17	152	4	localInputStream	java.io.InputStream
    //   221	7	4	localObject1	Object
    //   4	183	5	localObject2	Object
    //   10	61	6	localObject3	Object
    //   1	73	7	localObject4	Object
    //   7	171	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   25	32	160	finally
    //   38	44	160	finally
    //   50	58	160	finally
    //   64	70	160	finally
    //   76	95	160	finally
    //   99	106	160	finally
    //   110	118	160	finally
    //   126	134	160	finally
    //   25	32	167	java/io/IOException
    //   38	44	167	java/io/IOException
    //   50	58	167	java/io/IOException
    //   64	70	167	java/io/IOException
    //   76	95	167	java/io/IOException
    //   99	106	167	java/io/IOException
    //   110	118	167	java/io/IOException
    //   126	134	167	java/io/IOException
    //   12	19	174	finally
    //   12	19	183	java/io/IOException
    //   189	200	221	finally
    //   142	147	257	java/io/IOException
    //   154	158	261	java/io/IOException
    //   204	208	264	java/io/IOException
    //   215	219	268	java/io/IOException
    //   234	238	271	java/io/IOException
    //   245	249	275	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = PluginUtils.isOsNeedReleaseDex();
    boolean bool1 = true;
    boolean bool2 = true;
    if (!bool3) {
      return true;
    }
    int k = PluginAdapterImpl.a(paramString1);
    if (k > 1)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = new DexReleasor(paramString2, ((StringBuilder)localObject1).toString());
      int j;
      for (int i = 1;; i = j)
      {
        bool1 = bool2;
        if (i >= k) {
          break;
        }
        j = i + 1;
        Object localObject2 = String.format("classes%d.dex", new Object[] { Integer.valueOf(j) });
        Object localObject3 = PluginUtils.getMultiDexName(paramString1, j);
        if (-1L == ((DexReleasor)localObject1).getEntryCrcCode((String)localObject2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("releaseMultiDexIfNeeded noDex ");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append(paramString1);
          QLog.d("plugin_tag", 1, ((StringBuilder)localObject3).toString());
        }
        else
        {
          localObject3 = new File(PluginUtils.getPluginInstallDir(localBaseApplicationImpl).getAbsolutePath(), (String)localObject3);
          if (((File)localObject3).exists())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("releaseMultiDexIfNeeded  ");
            localStringBuilder.append(((File)localObject3).getAbsolutePath());
            localStringBuilder.append(" exsit,delete first");
            QLog.d("plugin_tag", 1, localStringBuilder.toString());
            ((File)localObject3).delete();
          }
          a(paramString2, (String)localObject2, (File)localObject3);
          if (!((File)localObject3).exists())
          {
            paramString1 = new StringBuilder();
            paramString1.append("releaseMultiDexIfNeeded failed ");
            paramString1.append(i);
            paramString1.append(" ");
            paramString1.append(((File)localObject3).getAbsolutePath());
            QLog.d("plugin_tag", 1, paramString1.toString());
            bool1 = false;
            break;
          }
          localObject2 = new StringBuilder(256);
          ((StringBuilder)localObject2).append("releaseMultiDexIfNeeded ");
          ((StringBuilder)localObject2).append(true);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((File)localObject3).getAbsolutePath());
          QLog.d("plugin_tag", 1, ((StringBuilder)localObject2).toString());
        }
      }
      ((DexReleasor)localObject1).destroy();
    }
    return bool1;
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
      QLog.e("plugin_tag", 1, localIOException, new Object[0]);
    }
    if (localObject == null)
    {
      QLog.e("plugin_tag", 1, String.format("unzip %s error", new Object[] { paramString1 }));
      return false;
    }
    paramString1 = localObject.entries();
    while (paramString1.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)paramString1.nextElement();
      if ((!localZipEntry.getName().contains("..")) && (localZipEntry.getName().equals(paramString2))) {
        if (a(paramFile, localObject, localZipEntry)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static String c()
  {
    String str2 = b;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  private boolean c(PluginInfo paramPluginInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    if ((paramPluginInfo != null) && (paramPluginInfo.mType == 0) && (paramPluginInfo.mSubType == 1)) {
      return paramPluginInfo.mState == 4;
    }
    boolean bool2 = bool1;
    if (paramPluginInfo != null)
    {
      bool2 = bool1;
      if (paramPluginInfo.mInstalledPath != null)
      {
        Object localObject = new File(paramPluginInfo.mInstalledPath);
        bool1 = bool3;
        if (((File)localObject).exists())
        {
          bool1 = bool3;
          if (((File)localObject).isFile()) {
            if (PluginInfoUtil.a(paramPluginInfo, (File)localObject))
            {
              paramPluginInfo.mState = 4;
              paramPluginInfo.mInstalledPath = ((File)localObject).getAbsolutePath();
              bool1 = true;
            }
            else
            {
              e(paramPluginInfo.mID);
              paramPluginInfo.mState = 0;
              bool1 = bool3;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("verifyInstalledPlugin :");
          ((StringBuilder)localObject).append(paramPluginInfo.mID);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private boolean d()
  {
    boolean bool;
    if ((TextUtils.isEmpty(this.e)) || (!new File(this.e).exists())) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyDownloadPath.");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append(bool);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean d(String paramString)
  {
    boolean bool1 = d();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramString = new File(this.e).list(new PluginInstaller.1(this, paramString));
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void e(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doSetupPlugin.");
    localStringBuilder.append(str);
    QLog.d("plugin_tag", 1, localStringBuilder.toString());
    if (PluginInfoUtil.a(paramPluginInfo, this.d))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str);
      }
      return;
    }
    if ((d(str) ^ true))
    {
      a(str, paramOnPluginSetupListener);
      return;
    }
    b(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean e(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.f.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.f.remove(paramString);
    f(paramString);
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
  
  private void f(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.d));
  }
  
  void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.d));
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.h.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public void a(String paramString, File paramFile, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile);
    boolean bool = PluginUtils.isOsNeedReleaseDex();
    int i = 1;
    if ((bool) && (PluginAdapterImpl.a(paramString) > 1)) {
      localArrayList.add(PluginUtils.getMultiDexSecondDex(this.d, paramString));
    }
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramFile = Dex2Oat.b();
        bool = QLog.isColorLevel();
        Object localObject;
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dex2Oat targetISA = ");
          ((StringBuilder)localObject).append(paramFile);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(localArrayList.size());
          QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramFile))
        {
          localObject = new File(PluginUtils.getOptimizedDexPath(this.d).getCanonicalPath());
          l2 = System.currentTimeMillis();
          bool = Dex2Oat.a(localArrayList, (File)localObject, true, paramFile, new PluginInstaller.2(this));
          l2 = System.currentTimeMillis() - l2;
          paramFile = new StringBuilder("dex2Oat ");
          paramFile.append(l2);
          paramFile.append(", ");
          paramFile.append(bool);
          paramFile.append(", ");
          paramFile.append(paramString);
          QLog.w("plugin_tag", 1, paramFile.toString());
          if (!bool) {
            break label349;
          }
          PluginStatisticsCollector.a(paramString, i, l2);
        }
        else
        {
          PluginStatisticsCollector.a(paramString, 3, 0L);
        }
        long l2 = System.currentTimeMillis();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.a(paramString, "pluginOatCost", l2 - l1);
        }
        if (QLog.isColorLevel())
        {
          paramFile = new StringBuilder();
          paramFile.append("install finish ");
          paramFile.append(paramString);
          QLog.d("plugin_tag", 2, paramFile.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label349:
      i = 2;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = this.c;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramString = (PluginInfo)this.f.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.mState == 4) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isPluginInstalled installed = ");
      paramString.append(bool1);
      QLog.d("plugin_tag", 2, paramString.toString());
    }
    return bool1;
  }
  
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("installBuiltinPlugin.");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.c)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(paramString);
      }
      return false;
    }
    if (!this.g.b(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not built in plugin.");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(paramString);
      }
      return false;
    }
    Object localObject1 = new File(PluginUtils.getPluginInstallDir(this.d), paramString);
    PluginInfo localPluginInfo2 = (PluginInfo)this.f.get(paramString);
    Object localObject5 = this.g.a(paramString);
    if (localObject5 == null)
    {
      QLog.d("plugin_tag", 1, "plugin not builtin");
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(false, paramString);
      }
      return false;
    }
    if ((localObject5 != null) && (localPluginInfo2 != null) && (!((PluginInfo)localObject5).mMD5.equals(localPluginInfo2.mMD5))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2;
    if (((File)localObject1).exists()) {
      bool2 = c(localPluginInfo2);
    } else {
      bool2 = false;
    }
    if ((bool2) && (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin already installed.");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, paramString);
      }
      return true;
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.g(paramString);
    }
    PluginInfo localPluginInfo1 = ((PluginInfo)localObject5).a();
    localPluginInfo1.mState = 3;
    this.f.put(paramString, localPluginInfo1);
    int i = ((PluginInfo)localObject5).mSubType;
    Object localObject3 = "";
    long l1;
    Object localObject9;
    if (i == 1)
    {
      localObject1 = PluginIdUtil.convertQPluginId2QShadowId(((PluginInfo)localObject5).mID);
      l1 = System.currentTimeMillis();
      bool2 = QShadow.getInstance().installPlugin((String)localObject1);
      localPluginInfo1.costDex2Oat = (System.currentTimeMillis() - l1);
      if (!bool2)
      {
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, paramString);
        }
        this.f.put(paramString, localPluginInfo2);
        return false;
      }
      String str1 = QShadowRepository.getInstalledPlugin(this.d, (String)localObject1, "");
      localObject5 = new File(Constant.getPluginInstalledPath(this.d, (String)localObject1));
    }
    else if (((PluginInfo)localObject5).mSubType == 2)
    {
      localObject5 = localObject3;
      try
      {
        l1 = System.currentTimeMillis();
        localObject5 = localObject3;
        localObject3 = PluginUtils.extractPluginAndGetMd5Code(this.d, paramString, (File)localObject1);
        localObject5 = localObject3;
        bool2 = LoadCompactDynamicFeature.a().a(paramString, (Application)this.d.getApplicationContext());
        try
        {
          localPluginInfo1.costDex2Oat = (System.currentTimeMillis() - l1);
        }
        catch (Exception localException3) {}
        QLog.e("plugin_tag", 1, "install df plugin failed ", (Throwable)localObject6);
      }
      catch (Exception localException5)
      {
        bool2 = false;
        localObject3 = localException3;
        localObject6 = localException5;
      }
      localObject6 = localObject1;
      localObject9 = localObject3;
      if (!bool2)
      {
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, paramString);
        }
        this.f.put(paramString, localPluginInfo2);
        return false;
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
    }
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".apk"));
      localObject9 = SoLoadCore.getReleasedSoFilePath(this.d, str2);
      localObject6 = localObject9;
      if (localObject9 == null) {
        localObject6 = SoLoadCore.releaseSo(this.d, str2);
      }
      if (localObject6 != null) {
        localObject6 = new File((String)localObject6);
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        label641:
        Object localObject4;
        long l2;
        int j;
        boolean bool1;
        Object localObject7;
        localObject8 = localObject4;
      }
    }
    try
    {
      localObject1 = localPluginInfo1.mMD5;
      localObject3 = localObject1;
      localObject1 = localObject6;
    }
    catch (Exception localException1)
    {
      Object localObject2 = localObject8;
      break label641;
    }
    Object localObject6 = localObject3;
    localObject3 = localObject6;
    if (TextUtils.isEmpty((CharSequence)localObject6)) {
      try
      {
        localObject3 = PluginUtils.extractPluginAndGetMd5Code(this.d, paramString, (File)localObject1);
      }
      catch (Exception localException2)
      {
        float f1 = FileUtils.getAvailableInnernalMemorySize();
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("extractPluginAndGetMd5Code failed installPath = ");
        ((StringBuilder)localObject9).append(localObject1);
        ((StringBuilder)localObject9).append(", leftSpace = ");
        ((StringBuilder)localObject9).append(f1);
        QLog.d("plugin_tag", 1, ((StringBuilder)localObject9).toString(), localException2);
        localObject4 = localObject6;
      }
    }
    localObject6 = localPluginInfo1.mMD5;
    if (QLog.isColorLevel())
    {
      localObject9 = new StringBuilder();
      ((StringBuilder)localObject9).append("md5:");
      ((StringBuilder)localObject9).append((String)localObject6);
      ((StringBuilder)localObject9).append(" vs ");
      ((StringBuilder)localObject9).append(localObject4);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject9).toString());
    }
    if (localObject4.equals(localObject6))
    {
      l2 = System.currentTimeMillis();
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.a(paramString, "pluginApkCost", l2 - l1);
      }
      try
      {
        localObject6 = PluginUtils.getPluginLibPath(this.d, paramString).getCanonicalPath();
        l1 = System.currentTimeMillis();
        localObject6 = PluginUtils.extractLibs(((File)localObject1).getCanonicalPath(), (String)localObject6);
        l2 = System.currentTimeMillis();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.a(paramString, "pluginLibCost", l2 - l1);
        }
        if (localObject6 != null)
        {
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append("extractLibs ");
          ((StringBuilder)localObject9).append((String)localObject6);
          QLog.d("plugin_tag", 1, ((StringBuilder)localObject9).toString());
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
        i = 1;
      }
      j = i;
      if (i == 0) {
        bool1 = a(paramString, ((File)localObject1).getAbsolutePath()) ^ true;
      }
      if (bool1)
      {
        ((File)localObject1).delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, paramString);
        }
        this.f.put(paramString, localPluginInfo2);
        return false;
      }
      localObject7 = localObject1;
      localObject9 = localObject4;
      if (PluginManagerV2.e())
      {
        a(paramString, (File)localObject1, paramOnPluginSetupListener);
        localObject9 = localObject4;
        localObject7 = localObject1;
      }
      localPluginInfo1.mLength = localObject7.length();
      localPluginInfo1.mState = 4;
      localPluginInfo1.mInstalledPath = localObject7.getAbsolutePath();
      localPluginInfo1.mMD5 = ((String)localObject9);
      localPluginInfo1.mFingerPrint = c();
      this.f.put(paramString, localPluginInfo1);
      a(localPluginInfo1);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "install finish");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, paramString);
      }
      return true;
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.b(false, paramString);
    }
    this.f.put(paramString, localPluginInfo2);
    return false;
  }
  
  public void b()
  {
    Object localObject1 = a(this.d);
    boolean bool = PluginInfoUtil.a((File)localObject1);
    File[] arrayOfFile = PluginInfoUtil.c((File)localObject1);
    if (arrayOfFile != null)
    {
      int k = arrayOfFile.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = arrayOfFile[i];
        if (((File)localObject2).isFile())
        {
          Object localObject3;
          if (bool)
          {
            localObject3 = UpdatePluginVersion.a;
            int m = localObject3.length;
            int j = 0;
            while (j < m)
            {
              String str1 = localObject3[j];
              if (!InstallPlugins.a(str1))
              {
                String str2 = ((File)localObject2).getName();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(".cfg");
                if (str2.equals(localStringBuilder.toString()))
                {
                  e(str1);
                  j = 1;
                  break label157;
                }
              }
              j += 1;
            }
            j = 0;
            label157:
            if (j != 0) {}
          }
          else
          {
            localObject3 = PluginInfoUtil.d((File)localObject2);
            if (localObject3 != null)
            {
              if ((c((PluginInfo)localObject3)) || ((("expand.apk".equals(((PluginInfo)localObject3).mID)) || (!TripleGraySwitchUtil.b(this.d, "KEY_DISABLE_SAVE_PLUGIN_INFO", true))) && (((PluginInfo)localObject3).mState == 2)))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("put ");
                ((StringBuilder)localObject2).append(((PluginInfo)localObject3).mID);
                ((StringBuilder)localObject2).append(" in to mInstalledPlugins, state: ");
                ((StringBuilder)localObject2).append(((PluginInfo)localObject3).mState);
                QLog.d("plugin_tag", 1, ((StringBuilder)localObject2).toString());
                this.f.put(((PluginInfo)localObject3).mID, localObject3);
              }
            }
            else {
              ((File)localObject2).delete();
            }
          }
        }
        i += 1;
      }
    }
    if (bool) {
      PluginInfoUtil.b((File)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load installed plugin info. size:");
      ((StringBuilder)localObject1).append(this.f.size());
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    this.c = true;
  }
  
  void b(PluginInfo paramPluginInfo)
  {
    this.f.put(paramPluginInfo.mID, paramPluginInfo);
    a(paramPluginInfo);
  }
  
  public boolean b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("installDownLoadPlugin.");
      ((StringBuilder)localObject1).append(str1);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.c)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      return false;
    }
    Object localObject1 = new File(PluginUtils.getPluginInstallDir(this.d), str1);
    Object localObject2 = (PluginInfo)this.f.get(str1);
    boolean bool1;
    if ((localObject2 != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject2).mMD5))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3;
    if (((File)localObject1).exists()) {
      bool3 = c((PluginInfo)localObject2);
    } else {
      bool3 = false;
    }
    if ((bool3) && (!bool1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin installed.");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      return false;
    }
    if (!d())
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      return false;
    }
    localObject2 = new File(new File(this.e), str1);
    if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "install fail. download file invalid.");
      }
      ((File)localObject2).delete();
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      return false;
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.g(str1);
    }
    paramPluginInfo.mState = 3;
    this.f.put(str1, paramPluginInfo);
    FileUtils.copyFile((File)localObject2, (File)localObject1);
    if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
      }
      ((File)localObject1).delete();
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(false, str1);
      }
      this.f.put(str1, paramPluginInfo);
      return false;
    }
    String str2;
    long l;
    if (paramPluginInfo.mSubType == 1)
    {
      str2 = PluginIdUtil.convertQPluginId2QShadowId(paramPluginInfo.mID);
      l = System.currentTimeMillis();
      if ((QShadow.getInstance().preInstall(str2, (File)localObject1)) && (QShadow.getInstance().installPlugin(str2))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramPluginInfo.costDex2Oat = (System.currentTimeMillis() - l);
      if (!bool1)
      {
        ((File)localObject1).delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.f.put(str1, paramPluginInfo);
        return false;
      }
    }
    else if (paramPluginInfo.mSubType == 2)
    {
      l = System.currentTimeMillis();
      bool3 = LoadCompactDynamicFeature.a().a(str1, (Application)this.d.getApplicationContext());
      paramPluginInfo.costDex2Oat = (System.currentTimeMillis() - l);
      if (!bool3)
      {
        ((File)localObject1).delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.f.put(str1, paramPluginInfo);
        return false;
      }
    }
    else
    {
      try
      {
        str2 = PluginUtils.getPluginLibPath(this.d, str1).getCanonicalPath();
        str2 = PluginUtils.extractLibs(((File)localObject1).getCanonicalPath(), str2);
        if (str2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("extractLibs ");
          localStringBuilder.append(str2);
          QLog.d("plugin_tag", 1, localStringBuilder.toString());
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
        bool1 = true;
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = a(str1, ((File)localObject1).getAbsolutePath()) ^ true;
      }
      if (bool2)
      {
        ((File)localObject1).delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.f.put(str1, paramPluginInfo);
        return false;
      }
      if (PluginManagerV2.e()) {
        a(str1, (File)localObject1, paramOnPluginSetupListener);
      }
    }
    paramPluginInfo.mState = 4;
    paramPluginInfo.mInstalledPath = ((File)localObject1).getAbsolutePath();
    paramPluginInfo.mFingerPrint = c();
    this.f.put(str1, paramPluginInfo);
    a(paramPluginInfo);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "install finish.");
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.b(true, str1);
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uninstallPlugin.");
      localStringBuilder.append(paramString);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (!this.c) {
      return false;
    }
    return e(paramString);
  }
  
  public PluginInfo c(String paramString)
  {
    if (!this.c) {
      return null;
    }
    return (PluginInfo)this.f.get(paramString);
  }
  
  public void c(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.h.obtainMessage(67072, paramPluginInfo).sendToTarget();
  }
  
  public boolean d(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDex2OatPlugin.");
      ((StringBuilder)localObject).append(str);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = c(str);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 4))
    {
      paramPluginInfo = new StringBuilder();
      paramPluginInfo.append("doDex2OatPlugin. already ");
      paramPluginInfo.append(str);
      QLog.d("plugin_tag", 1, paramPluginInfo.toString());
    }
    else if (PluginInfoUtil.a(paramPluginInfo, this.d))
    {
      paramPluginInfo = new StringBuilder();
      paramPluginInfo.append("doDex2OatPlugin. isPluginRunning ");
      paramPluginInfo.append(str);
      QLog.d("plugin_tag", 1, paramPluginInfo.toString());
    }
    else
    {
      a(str, new File(PluginUtils.getPluginInstallDir(this.d), str), paramOnPluginSetupListener);
      paramPluginInfo.mState = 4;
      paramPluginInfo.mFingerPrint = c();
      a(paramPluginInfo);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doDex2OatPlugin finish");
      }
    }
    if (paramOnPluginSetupListener != null) {
      paramOnPluginSetupListener.b(true, str);
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 66816)
    {
      if (i != 67072) {
        return false;
      }
      paramMessage = (Pair)paramMessage.obj;
      d((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
      return true;
    }
    paramMessage = (Pair)paramMessage.obj;
    e((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */