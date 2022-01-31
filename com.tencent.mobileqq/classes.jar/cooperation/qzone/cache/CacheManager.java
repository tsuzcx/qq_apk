package cooperation.qzone.cache;

import anbg;
import anbh;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class CacheManager
{
  private static long jdField_a_of_type_Long;
  private static FileStorageHandler jdField_a_of_type_CooperationQzoneCacheFileStorageHandler;
  private static Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString = "";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap jdField_b_of_type_JavaUtilHashMap;
  private static boolean jdField_b_of_type_Boolean = true;
  private static HashMap c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
  }
  
  public static final long a()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = m();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static FileCacheService a()
  {
    return a("audio", 104857600, 41943040);
  }
  
  public static FileCacheService a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      AssertUtil.a(bool);
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        FileCacheService localFileCacheService2 = (FileCacheService)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        FileCacheService localFileCacheService1 = localFileCacheService2;
        if (localFileCacheService2 == null)
        {
          localFileCacheService1 = new FileCacheService(paramString, 1, paramInt1, paramInt2);
          localFileCacheService1.a(a());
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localFileCacheService1);
        }
        return localFileCacheService1;
      }
      bool = false;
    }
  }
  
  public static FileStorageHandler a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneCacheFileStorageHandler == null) {
        jdField_a_of_type_CooperationQzoneCacheFileStorageHandler = new FileStorageHandler(new anbg());
      }
      return jdField_a_of_type_CooperationQzoneCacheFileStorageHandler;
    }
  }
  
  public static final String a()
  {
    return d().a();
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  private static final String a(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + a(paramInt);
    }
    return a(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static final String a(long paramLong)
  {
    return a(0, (float)paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = c(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i = paramString.hashCode();
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "imageV2";
        if (paramContext != null) {
          break label166;
        }
      }
      label166:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i))
      {
        return paramContext;
        paramContext = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "image";
        break;
      }
      paramString = str;
    }
  }
  
  public static String a(String paramString)
  {
    String str = m();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString);
  }
  
  public static void a()
  {
    c.clear();
    jdField_a_of_type_Boolean = false;
    d();
    a(false, false);
  }
  
  public static void a(long paramLong)
  {
    b(paramLong);
    ThreadManager.postImmediately(new anbh(), null, false);
  }
  
  public static void a(Context paramContext)
  {
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "imageV2";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    FileUtil.c(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "image_sr");
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "video";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "paster";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    FileUtil.c(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "cache" + File.separator + "video_cache");
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "file";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = m();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = k();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
  }
  
  /* Error */
  private static void a(String paramString)
  {
    // Byte code:
    //   0: new 189	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 229	java/io/File:exists	()Z
    //   13: ifeq +164 -> 177
    //   16: new 283	java/io/BufferedReader
    //   19: dup
    //   20: new 285	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 287	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 290	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 293	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +138 -> 178
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 295
    //   49: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 300
    //   61: invokevirtual 304	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_3
    //   68: arraylength
    //   69: iconst_3
    //   70: if_icmplt -38 -> 32
    //   73: aload_3
    //   74: iconst_2
    //   75: aaload
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_1
    //   79: aaload
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: new 189	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 229	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 27	cooperation/qzone/cache/CacheManager:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 106	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_1
    //   109: astore_0
    //   110: invokestatic 307	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   113: ifeq -81 -> 32
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 62
    //   120: iconst_4
    //   121: new 138	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 309
    //   131: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 311
    //   141: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -122 -> 32
    //   157: astore_2
    //   158: aload_1
    //   159: astore_0
    //   160: ldc 62
    //   162: iconst_1
    //   163: ldc 31
    //   165: aload_2
    //   166: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 317	java/io/BufferedReader:close	()V
    //   177: return
    //   178: aload_1
    //   179: astore_0
    //   180: aload_1
    //   181: invokevirtual 317	java/io/BufferedReader:close	()V
    //   184: aload_1
    //   185: ifnull -8 -> 177
    //   188: aload_1
    //   189: invokevirtual 317	java/io/BufferedReader:close	()V
    //   192: return
    //   193: astore_0
    //   194: ldc 62
    //   196: iconst_1
    //   197: ldc 31
    //   199: aload_0
    //   200: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: return
    //   204: astore_0
    //   205: ldc 62
    //   207: iconst_1
    //   208: ldc 31
    //   210: aload_0
    //   211: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: return
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_0
    //   219: ifnull +7 -> 226
    //   222: aload_0
    //   223: invokevirtual 317	java/io/BufferedReader:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_0
    //   229: ldc 62
    //   231: iconst_1
    //   232: ldc 31
    //   234: aload_0
    //   235: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -12 -> 226
    //   241: astore_1
    //   242: goto -24 -> 218
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -90 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramString	String
    //   31	158	1	localBufferedReader	java.io.BufferedReader
    //   215	12	1	localObject1	Object
    //   241	1	1	localObject2	Object
    //   247	1	1	localObject3	Object
    //   38	107	2	str	String
    //   157	9	2	localException1	Exception
    //   245	1	2	localException2	Exception
    //   64	71	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	157	java/lang/Exception
    //   45	55	157	java/lang/Exception
    //   57	65	157	java/lang/Exception
    //   67	73	157	java/lang/Exception
    //   83	97	157	java/lang/Exception
    //   99	108	157	java/lang/Exception
    //   110	116	157	java/lang/Exception
    //   118	154	157	java/lang/Exception
    //   180	184	157	java/lang/Exception
    //   188	192	193	java/io/IOException
    //   173	177	204	java/io/IOException
    //   16	32	215	finally
    //   222	226	228	java/io/IOException
    //   34	39	241	finally
    //   45	55	241	finally
    //   57	65	241	finally
    //   67	73	241	finally
    //   83	97	241	finally
    //   99	108	241	finally
    //   110	116	241	finally
    //   118	154	241	finally
    //   160	169	241	finally
    //   180	184	241	finally
    //   16	32	245	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        localObject = Environment.getExternalStorageState();
        jdField_b_of_type_Boolean = false;
        if ((!paramBoolean1) && ("mounted".equals(localObject)))
        {
          if ((paramBoolean2 != true) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
            continue;
          }
          jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
          jdField_b_of_type_Boolean = true;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("CacheManager", 1, "", localException);
        continue;
      }
      if (!jdField_b_of_type_Boolean) {
        jdField_b_of_type_JavaLangString = k();
      }
      localObject = new File(jdField_b_of_type_JavaLangString);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()) && (QLog.isColorLevel())) {
        QLog.w("CacheManager", 2, "Unable to create external cache directory");
      }
      if (((File)localObject).exists()) {}
      try
      {
        localObject = new File(jdField_b_of_type_JavaLangString, ".nomedia");
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        return;
      }
      catch (IOException localIOException)
      {
        QLog.e("CacheManager", 1, "", localIOException);
      }
      if (Environment.getExternalStorageDirectory().canWrite())
      {
        jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
        jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public static boolean a()
  {
    return SDCardMountMonitorReceiver.a().a();
  }
  
  public static boolean a(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
  
  public static final long b()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = m();
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      QLog.e("CacheManager", 1, "", localException);
    }
    return -1L;
  }
  
  public static FileCacheService b()
  {
    return a("offline", 104857600, 20971520);
  }
  
  public static String b()
  {
    return a("video");
  }
  
  public static String b(String paramString)
  {
    String str = k();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static void b()
  {
    a();
    f();
    b();
    d();
    a().a();
  }
  
  private static void b(long paramLong)
  {
    String str1 = LocalMultiProcConfig.getString("qua", "");
    String str2 = QUA.a();
    if (!str1.equals(str2))
    {
      LocalMultiProcConfig.putString4Uin("getMapLastGetTime", "", paramLong);
      LocalMultiProcConfig.putString("qua", str2);
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (!URLUtil.isNetworkUrl(paramString));
    return true;
  }
  
  public static FileCacheService c()
  {
    return a("zip_cache", 104857600, 20971520);
  }
  
  public static String c()
  {
    int i = 1;
    int j = 0;
    for (;;)
    {
      try
      {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          String str;
          if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
          {
            str = jdField_a_of_type_JavaLangString + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
            if (str != null)
            {
              localObject = new File(str);
              if (((File)localObject).isFile()) {
                FileUtils.delete((File)localObject);
              }
              if (!((File)localObject).exists()) {
                ((File)localObject).mkdirs();
              }
            }
            if ((i != 0) && (!TextUtils.isEmpty(str)))
            {
              localObject = str;
              if (!d(str)) {}
            }
            else
            {
              localObject = k();
            }
            if (localObject == null) {
              return null;
            }
          }
          else
          {
            if (!Environment.getExternalStorageDirectory().canWrite()) {
              break label308;
            }
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("CacheManager", 1, "", localException);
        localFile = null;
        i = j;
        continue;
        localFile = new File((String)localObject + File.separator + "video_cache");
        if (localFile.isFile()) {
          FileUtils.delete(localFile);
        }
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        return localFile.getAbsolutePath();
      }
      label308:
      i = 0;
      File localFile = null;
    }
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (b(paramString))
    {
      int k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      int i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      str = paramString.substring(k + 1, i);
    }
    return str;
  }
  
  public static boolean c(String paramString)
  {
    localObject = (Boolean)c.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CacheManager", 1, "", localThrowable);
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      c.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  public static FileCacheService d()
  {
    return a("personalise_font", 104857600, 41943040);
  }
  
  public static String d()
  {
    return a("rapid_comment");
  }
  
  private static void d()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    synchronized (jdField_b_of_type_JavaUtilHashMap)
    {
      jdField_b_of_type_JavaUtilHashMap.clear();
      jdField_a_of_type_JavaLangString = "";
      jdField_a_of_type_Long = 0L;
      a("/etc/vold.fstab");
      a("/etc/internal_sd.fstab");
      a("/etc/external_sd.fstab");
      Iterator localIterator = jdField_b_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            Object localObject2 = new File(str);
            if ((((File)localObject2).exists()) && (((File)localObject2).canWrite()) && (c(str)))
            {
              localObject2 = new StatFs(str);
              long l = ((StatFs)localObject2).getAvailableBlocks() * ((StatFs)localObject2).getBlockSize();
              if ((l > 0L) && (jdField_a_of_type_Long < l))
              {
                jdField_a_of_type_Long = l;
                jdField_a_of_type_JavaLangString = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("CacheManager", 1, "", localThrowable);
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("CacheManager", 4, "max sdcard name:" + jdField_a_of_type_JavaLangString + " size:" + jdField_a_of_type_Long / 1024L / 1024L / 1024L + "G");
    }
  }
  
  private static boolean d(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < 5242880L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("CacheManager", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", external=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("CacheManager", 1, "", paramString);
    }
  }
  
  public static FileCacheService e()
  {
    return a("qzone_widgetai", 104857600, 20971520);
  }
  
  public static String e()
  {
    return a("gift_fullscreen");
  }
  
  public static FileCacheService f()
  {
    return a("avatar", 52428800, 20971520);
  }
  
  public static String f()
  {
    return a("passive_praise");
  }
  
  public static String g()
  {
    return a("dehaze_pic");
  }
  
  public static String h()
  {
    return a("plus_operation");
  }
  
  public static String i()
  {
    return a("head_drop_operaion");
  }
  
  public static String j()
  {
    return a("surprise");
  }
  
  public static String k()
  {
    File localFile = BaseApplicationImpl.getContext().getCacheDir();
    if (localFile != null) {
      return localFile.getAbsolutePath() + File.separator + "qzone";
    }
    return null;
  }
  
  public static String l()
  {
    return AppConstants.aQ + UUID.randomUUID().toString() + ".jpg";
  }
  
  public static String m()
  {
    if (jdField_b_of_type_JavaLangString == null) {}
    try
    {
      if (jdField_b_of_type_JavaLangString == null) {
        a(false, false);
      }
      return jdField_b_of_type_JavaLangString;
    }
    finally {}
  }
  
  public static final String n()
  {
    long l = a();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
  
  public static final String o()
  {
    long l = b();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */