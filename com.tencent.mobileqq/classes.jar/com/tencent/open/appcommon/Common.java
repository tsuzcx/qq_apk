package com.tencent.open.appcommon;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Common
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///android_asset");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Page/system");
    a = localStringBuilder.toString();
  }
  
  public static int a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getInt("appTabVersionCode", -1);
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(d());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public static long a(java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 82	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 85	java/io/File:mkdir	()Z
    //   20: pop
    //   21: new 21	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 88	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_1
    //   37: new 90	java/io/FileOutputStream
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore_1
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 99	java/io/InputStream:read	([B)I
    //   58: istore_3
    //   59: iconst_m1
    //   60: iload_3
    //   61: if_icmpeq +13 -> 74
    //   64: aload_2
    //   65: aload_1
    //   66: iconst_0
    //   67: iload_3
    //   68: invokevirtual 103	java/io/FileOutputStream:write	([BII)V
    //   71: goto -18 -> 53
    //   74: aload_2
    //   75: invokevirtual 106	java/io/FileOutputStream:flush	()V
    //   78: aload_2
    //   79: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   82: aload 5
    //   84: invokevirtual 112	java/io/File:length	()J
    //   87: lreturn
    //   88: astore_0
    //   89: goto +21 -> 110
    //   92: astore_0
    //   93: aload_2
    //   94: astore_1
    //   95: goto +13 -> 108
    //   98: astore_0
    //   99: aload_1
    //   100: astore_2
    //   101: goto +9 -> 110
    //   104: astore_0
    //   105: aload 4
    //   107: astore_1
    //   108: aload_0
    //   109: athrow
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   118: goto +5 -> 123
    //   121: aload_0
    //   122: athrow
    //   123: goto -2 -> 121
    //   126: astore_0
    //   127: goto -45 -> 82
    //   130: astore_1
    //   131: goto -13 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	java.io.InputStream
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   58	10	3	i	int
    //   33	73	4	localObject	Object
    //   30	53	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	53	88	finally
    //   53	59	88	finally
    //   64	71	88	finally
    //   74	78	88	finally
    //   47	53	92	java/lang/Exception
    //   53	59	92	java/lang/Exception
    //   64	71	92	java/lang/Exception
    //   74	78	92	java/lang/Exception
    //   37	47	98	finally
    //   108	110	98	finally
    //   37	47	104	java/lang/Exception
    //   78	82	126	java/lang/Exception
    //   114	118	130	java/lang/Exception
  }
  
  public static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (String)paramMap.get(str);
      StringBuilder localStringBuilder2;
      if (i != 0)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append("=");
        localStringBuilder2.append(URLEncoder.encode((String)localObject, "utf-8"));
        localStringBuilder1.append(localStringBuilder2.toString());
        i = 0;
      }
      else if (localObject != null)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("&");
        localStringBuilder2.append(str);
        localStringBuilder2.append("=");
        localStringBuilder2.append(URLEncoder.encode((String)localObject, "utf-8"));
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("=");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
      }
    }
    return localStringBuilder1.toString();
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      Object localObject;
      if (!paramString.startsWith("?"))
      {
        localObject = paramString;
        if (!paramString.startsWith("&")) {}
      }
      else
      {
        localObject = paramString.substring(1);
      }
      paramString = ((String)localObject).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramString[i].split("=");
        if (localObject.length > 1)
        {
          String str = URLDecoder.decode(localObject[1]);
          localHashMap.put(localObject[0], str);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    try
    {
      LogUtility.b("Common", "<initSystemFolder> begin to init system file... ");
      File localFile = new File(c());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a(true);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putInt("appTabVersionCode", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putLong("remaxage", paramLong1);
    localEditor.putLong("relasttime", paramLong2);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setResourceMD5=");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("Common", ((StringBuilder)localObject).toString());
    localObject = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    ((SharedPreferences.Editor)localObject).putString("relastmd5", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Common.1 local1 = new Common.1();
        if (paramBoolean)
        {
          l = 10L;
          localScheduledExecutorService.schedule(local1, l, TimeUnit.SECONDS);
          return;
        }
      }
      finally {}
      long l = 0L;
    }
  }
  
  public static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return true;
    }
    return new File("/mnt/sdcard-ext").isDirectory();
  }
  
  public static long[] a()
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4);
    return new long[] { localSharedPreferences.getLong("remaxage", 0L), localSharedPreferences.getLong("relasttime", 0L) };
  }
  
  public static String[] a(String paramString)
  {
    boolean bool = paramString.toLowerCase().startsWith("sd://");
    String str = "";
    Object localObject2 = str;
    Object localObject1 = paramString;
    if (bool)
    {
      localObject2 = paramString.substring(5);
      int i = ((String)localObject2).indexOf("?");
      paramString = str;
      localObject1 = localObject2;
      if (i != -1)
      {
        localObject1 = ((String)localObject2).substring(0, i);
        paramString = ((String)localObject2).substring(i + 1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(g());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      if (new File(((StringBuilder)localObject2).toString()).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file:///");
        ((StringBuilder)localObject2).append(g());
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = paramString;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file:///android_asset/Page/system/");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = paramString;
      }
    }
    paramString = (String)localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = new StringBuilder();
      paramString.append("&");
      paramString.append((String)localObject2);
      paramString = paramString.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("url params= ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtility.c("Common", ((StringBuilder)localObject2).toString());
    return new String[] { localObject1, paramString };
  }
  
  public static void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLastResourceZipMd5=");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("Common", ((StringBuilder)localObject).toString());
    localObject = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    ((SharedPreferences.Editor)localObject).putString("lastresourcezipmd5", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putBoolean("appstoreclearcache", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getBoolean("appstoreclearcache", false);
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".AppCenterWebBuffer_QQ");
    return localStringBuilder.toString();
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
    localEditor.putString("appstoreagentversion", paramString);
    localEditor.commit();
  }
  
  public static String d()
  {
    String str = ".";
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      if (bool) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      bool = new File("/mnt/sdcard-ext").isDirectory();
      if (bool) {
        str = "/mnt/sdcard-ext";
      }
      return str;
    }
    catch (Exception localException) {}
    return ".";
  }
  
  public static void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).edit();
      localEditor.putString("sdhtmldir", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String e()
  {
    String str = VFSRegisterProxy.a().a();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return ".";
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qapp_center_index.htm");
    return localStringBuilder.toString();
  }
  
  public static String g()
  {
    String str = q();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getSDResDir> getSDResDir=");
    localStringBuilder.append(str);
    LogUtility.b("Common", localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tmp");
    return localStringBuilder.toString();
  }
  
  public static String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("system_old_");
    return localStringBuilder.toString();
  }
  
  public static String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("resource.zip");
    return localStringBuilder.toString();
  }
  
  public static String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("resource.diff");
    return localStringBuilder.toString();
  }
  
  public static String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("resource_merged.zip");
    return localStringBuilder.toString();
  }
  
  public static String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///android_asset");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Page/system");
    return localStringBuilder.toString();
  }
  
  public static String n()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getString("relastmd5", "");
  }
  
  public static String o()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getString("lastresourcezipmd5", "");
  }
  
  public static String p()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getString("appstoreagentversion", "");
  }
  
  public static String q()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 4).getString("sdhtmldir", "");
  }
  
  public static String r()
  {
    String str = "";
    int i = Process.myPid();
    try
    {
      Object localObject2 = CommonDataAdapter.a().a();
      Object localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = ((ActivityManager)((Context)localObject2).getSystemService("activity")).getRunningAppProcesses().iterator();
        do
        {
          localObject1 = str;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        } while (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i);
        localObject1 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      label76:
      break label76;
    }
    LogUtility.c("Common", "exception happened!");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.Common
 * JD-Core Version:    0.7.0.1
 */