package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b = false;
  private static String c;
  private static String d;
  private static int e = 0;
  private static String f;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static String j;
  private static boolean k = false;
  private static boolean l = false;
  public static boolean mHasQueryed = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return e;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      localObject = new TbsLinuxToolsJni(paramContext);
      a(paramContext, (TbsLinuxToolsJni)localObject, p.a().r(paramContext));
      paramContext = p.a().s(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareTbsCore tbsShareDir is ");
      localStringBuilder.append(paramContext.getAbsolutePath());
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      ((TbsLinuxToolsJni)localObject).a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareTbsCore tbsShareDir error is ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      ((StringBuilder)localObject).append(" ## ");
      ((StringBuilder)localObject).append(paramContext.getCause());
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (!TbsPVConfig.getInstance(a).isDisableHostBackupCore())
    {
      if (p.a().u(paramContext))
      {
        Object localObject3 = new String[5];
        localObject3[0] = "com.tencent.tbs";
        localObject3[1] = "com.tencent.mm";
        localObject3[2] = "com.tencent.mobileqq";
        localObject3[3] = "com.qzone";
        localObject3[4] = paramContext.getPackageName();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("find host backup core to unzip #1");
        ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
        int m = localObject3.length;
        int n = 0;
        while (n < m)
        {
          String str = localObject3[n];
          int i1 = getBackupCoreVersion(paramContext, str);
          localObject1 = "";
          Object localObject4;
          if (paramInt == i1)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("installCoreWithUnzip getBackupCoreVersion ok, packageName is ");
            ((StringBuilder)localObject4).append(str);
            ((StringBuilder)localObject4).append(" result version is ");
            ((StringBuilder)localObject4).append(i1);
            TbsLog.i("TbsShareManager", ((StringBuilder)localObject4).toString());
            localObject4 = getPackageContext(paramContext, str, false);
            if (!p.a().g((Context)localObject4))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("find host backup core to unzip,verify app failed,pkgName=");
              ((StringBuilder)localObject1).append(str);
              TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
            }
          }
          for (;;)
          {
            break;
            localObject4 = getBackupCoreFile(paramContext, str);
            if (!a.a(paramContext, (File)localObject4, 0L, paramInt))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("find host backup core to unzip,verify apk failed,pkgName=");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(";apk=");
              ((StringBuilder)localObject1).append(((File)localObject4).getAbsolutePath());
              TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("find host backup core to unzip normal coreVersion is ");
              ((StringBuilder)localObject3).append(paramInt);
              ((StringBuilder)localObject3).append(" packageName is ");
              ((StringBuilder)localObject3).append(str);
              TbsLog.i("TbsShareManager", ((StringBuilder)localObject3).toString());
              try
              {
                str = str.substring(str.length() - 2);
                localObject1 = str;
              }
              catch (Throwable localThrowable1)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("throwable is ");
                ((StringBuilder)localObject3).append(Log.getStackTraceString(localThrowable1));
                TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
              }
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("7is");
              ((StringBuilder)localObject2).append(paramInt);
              ((StringBuilder)localObject2).append((String)localObject1);
              q.a(((StringBuilder)localObject2).toString());
              p.a().a(paramContext, (File)localObject4, paramInt);
              break label870;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("installCoreWithUnzip getBackupCoreVersion fail, packageName is ");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(" result version is ");
              ((StringBuilder)localObject4).append(i1);
              TbsLog.i("TbsShareManager", ((StringBuilder)localObject4).toString());
              i1 = getBackupDecoupleCoreVersion(paramContext, (String)localObject2);
              StringBuilder localStringBuilder;
              if (paramInt == i1)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("installCoreWithUnzip getBackupDecoupleCoreVersion ok, packageName is ");
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append(" result version is ");
                ((StringBuilder)localObject4).append(i1);
                TbsLog.i("TbsShareManager", ((StringBuilder)localObject4).toString());
                localObject4 = getPackageContext(paramContext, (String)localObject2, false);
                if (p.a().g((Context)localObject4))
                {
                  do
                  {
                    localObject4 = getBackupDecoupleCoreFile(paramContext, (String)localObject2);
                  } while (!a.a(paramContext, (File)localObject4, 0L, paramInt));
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("find host backup core to unzip decouple coreVersion is ");
                  ((StringBuilder)localObject3).append(paramInt);
                  ((StringBuilder)localObject3).append(" packageName is ");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  TbsLog.i("TbsShareManager", ((StringBuilder)localObject3).toString());
                  try
                  {
                    localObject2 = ((String)localObject2).substring(((String)localObject2).length() - 2);
                    localObject1 = localObject2;
                  }
                  catch (Throwable localThrowable2)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("throwable is ");
                    ((StringBuilder)localObject3).append(Log.getStackTraceString(localThrowable2));
                    TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
                  }
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("7is");
                  localStringBuilder.append(paramInt);
                  localStringBuilder.append((String)localObject1);
                  q.a(localStringBuilder.toString());
                  p.a().a(paramContext, (File)localObject4, paramInt);
                  break label870;
                }
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("installCoreWithUnzip getBackupDecoupleCoreVersion fail, packageName is ");
                ((StringBuilder)localObject1).append(localStringBuilder);
                ((StringBuilder)localObject1).append(" result version is ");
                ((StringBuilder)localObject1).append(i1);
                TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
              }
            }
          }
          n += 1;
        }
        label870:
        p.a().b();
        return;
      }
      paramContext = "installCoreWithUnzip do nothing #2";
    }
    else
    {
      paramContext = "installCoreWithUnzip do nothing #1";
    }
    TbsLog.i("TbsShareManager", paramContext);
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareAllDirsAndFiles dir is ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
      paramFile = paramFile.listFiles();
      int n = paramFile.length;
      int m = 0;
      while (m < n)
      {
        localStringBuilder = paramFile[m];
        if (localStringBuilder.isFile())
        {
          if (localStringBuilder.getAbsolutePath().indexOf(".so") > 0) {
            paramTbsLinuxToolsJni.a(localStringBuilder.getAbsolutePath(), "755");
          } else {
            paramTbsLinuxToolsJni.a(localStringBuilder.getAbsolutePath(), "644");
          }
        }
        else if (localStringBuilder.isDirectory()) {
          a(paramContext, paramTbsLinuxToolsJni, localStringBuilder);
        } else {
          TbsLog.e("TbsShareManager", "unknown file type.", true);
        }
        m += 1;
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), p.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (i(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static String c(Context paramContext)
  {
    j(paramContext);
    return d;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc_w 278
    //   10: invokestatic 281	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 6
    //   15: aload 6
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 283	java/io/BufferedInputStream
    //   24: dup
    //   25: new 285	java/io/FileInputStream
    //   28: dup
    //   29: aload 6
    //   31: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_3
    //   38: new 293	java/util/Properties
    //   41: dup
    //   42: invokespecial 294	java/util/Properties:<init>	()V
    //   45: astore 5
    //   47: aload 5
    //   49: aload_3
    //   50: invokevirtual 297	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: aload 5
    //   55: ldc_w 299
    //   58: iconst_0
    //   59: invokestatic 303	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   62: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   65: pop
    //   66: iload_1
    //   67: ifeq +64 -> 131
    //   70: invokestatic 58	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   73: aload_0
    //   74: invokevirtual 62	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   77: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: astore 7
    //   82: aload_0
    //   83: invokevirtual 311	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   86: invokevirtual 139	android/content/Context:getPackageName	()Ljava/lang/String;
    //   89: astore 8
    //   91: aload_0
    //   92: invokestatic 316	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   95: istore_2
    //   96: aload 5
    //   98: ldc_w 318
    //   101: aload 8
    //   103: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   106: pop
    //   107: aload 5
    //   109: ldc_w 320
    //   112: aload 7
    //   114: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 5
    //   120: ldc_w 322
    //   123: iload_2
    //   124: invokestatic 324	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   127: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   130: pop
    //   131: new 326	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 328	java/io/FileOutputStream
    //   138: dup
    //   139: aload 6
    //   141: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: invokespecial 332	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   147: astore_0
    //   148: aload 5
    //   150: aload_0
    //   151: aconst_null
    //   152: invokevirtual 336	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   155: aload_3
    //   156: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   159: aload_0
    //   160: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   163: return
    //   164: astore 4
    //   166: goto +55 -> 221
    //   169: astore 4
    //   171: goto +11 -> 182
    //   174: astore_0
    //   175: goto +56 -> 231
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_0
    //   182: goto +16 -> 198
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_3
    //   188: goto +43 -> 231
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_0
    //   195: aload 5
    //   197: astore_3
    //   198: aload 4
    //   200: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   211: aload_0
    //   212: ifnull +6 -> 218
    //   215: goto -56 -> 159
    //   218: return
    //   219: astore 4
    //   221: aload_0
    //   222: astore 5
    //   224: aload 4
    //   226: astore_0
    //   227: aload 5
    //   229: astore 4
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   249: goto +5 -> 254
    //   252: aload_0
    //   253: athrow
    //   254: goto -2 -> 252
    //   257: astore_3
    //   258: goto -99 -> 159
    //   261: astore_0
    //   262: return
    //   263: astore_3
    //   264: goto -53 -> 211
    //   267: astore_3
    //   268: goto -29 -> 239
    //   271: astore_3
    //   272: goto -23 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramContext	Context
    //   0	275	1	paramBoolean	boolean
    //   95	29	2	m	int
    //   37	199	3	localObject1	Object
    //   257	1	3	localException1	Exception
    //   263	1	3	localException2	Exception
    //   267	1	3	localException3	Exception
    //   271	1	3	localException4	Exception
    //   1	1	4	localObject2	Object
    //   164	1	4	localObject3	Object
    //   169	1	4	localThrowable1	Throwable
    //   178	1	4	localThrowable2	Throwable
    //   191	8	4	localThrowable3	Throwable
    //   219	6	4	localObject4	Object
    //   229	16	4	localObject5	Object
    //   4	224	5	localObject6	Object
    //   13	127	6	localFile	File
    //   80	33	7	str1	String
    //   89	13	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   148	155	164	finally
    //   148	155	169	java/lang/Throwable
    //   38	66	174	finally
    //   70	131	174	finally
    //   131	148	174	finally
    //   38	66	178	java/lang/Throwable
    //   70	131	178	java/lang/Throwable
    //   131	148	178	java/lang/Throwable
    //   6	15	185	finally
    //   21	38	185	finally
    //   6	15	191	java/lang/Throwable
    //   21	38	191	java/lang/Throwable
    //   198	203	219	finally
    //   155	159	257	java/lang/Exception
    //   159	163	261	java/lang/Exception
    //   207	211	263	java/lang/Exception
    //   235	239	267	java/lang/Exception
    //   244	249	271	java/lang/Exception
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { paramContext.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString = getCoreProviderAppList();
    if (paramBoolean) {
      return new String[] { paramContext.getApplicationContext().getPackageName() };
    }
    return arrayOfString;
  }
  
  static Context e(Context paramContext)
  {
    j(paramContext);
    String str = f;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = getPackageContext(paramContext, str, true);
      if (!p.a().g((Context)localObject1)) {
        localObject1 = localObject2;
      }
    }
    if (c != null) {
      return a;
    }
    return localObject1;
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 278
    //   7: invokestatic 281	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +8 -> 20
    //   15: ldc 2
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 283	java/io/BufferedInputStream
    //   23: dup
    //   24: new 285	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_0
    //   38: new 293	java/util/Properties
    //   41: dup
    //   42: invokespecial 294	java/util/Properties:<init>	()V
    //   45: astore_3
    //   46: aload_2
    //   47: astore_0
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 297	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: aload_2
    //   54: astore_0
    //   55: aload_3
    //   56: ldc_w 318
    //   59: ldc 154
    //   61: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: ldc 154
    //   69: aload_3
    //   70: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: istore_1
    //   74: iload_1
    //   75: ifne +12 -> 87
    //   78: aload_2
    //   79: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_3
    //   86: areturn
    //   87: aload_2
    //   88: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   91: ldc 2
    //   93: monitorexit
    //   94: aconst_null
    //   95: areturn
    //   96: astore_3
    //   97: goto +12 -> 109
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_2
    //   103: goto +37 -> 140
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_0
    //   111: aload_3
    //   112: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   115: aload_2
    //   116: ifnull +14 -> 130
    //   119: aload_2
    //   120: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   123: goto +7 -> 130
    //   126: astore_0
    //   127: goto +23 -> 150
    //   130: ldc 2
    //   132: monitorexit
    //   133: aconst_null
    //   134: areturn
    //   135: astore_3
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   148: aload_0
    //   149: athrow
    //   150: ldc 2
    //   152: monitorexit
    //   153: aload_0
    //   154: athrow
    //   155: astore_0
    //   156: goto -74 -> 82
    //   159: astore_0
    //   160: goto -69 -> 91
    //   163: astore_0
    //   164: goto -34 -> 130
    //   167: astore_2
    //   168: goto -20 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	Context
    //   73	2	1	bool	boolean
    //   35	110	2	localObject1	Object
    //   167	1	2	localException	Exception
    //   45	41	3	localObject2	Object
    //   96	1	3	localThrowable1	Throwable
    //   106	6	3	localThrowable2	Throwable
    //   135	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	96	java/lang/Throwable
    //   48	53	96	java/lang/Throwable
    //   55	65	96	java/lang/Throwable
    //   67	74	96	java/lang/Throwable
    //   3	11	100	finally
    //   20	36	100	finally
    //   3	11	106	java/lang/Throwable
    //   20	36	106	java/lang/Throwable
    //   78	82	126	finally
    //   87	91	126	finally
    //   119	123	126	finally
    //   144	148	126	finally
    //   148	150	126	finally
    //   38	46	135	finally
    //   48	53	135	finally
    //   55	65	135	finally
    //   67	74	135	finally
    //   111	115	135	finally
    //   78	82	155	java/lang/Exception
    //   87	91	159	java/lang/Exception
    //   119	123	163	java/lang/Exception
    //   144	148	167	java/lang/Exception
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("core_info mAvailableCoreVersion is ");
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(" mAvailableCorePath is ");
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(" mSrcPackageName is ");
    ((StringBuilder)localObject).append(f);
    TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    localObject = f;
    if ((localObject != null) && (((String)localObject).equals("AppDefined")))
    {
      if (e == p.a().a(c)) {
        break label218;
      }
      e = 0;
      d = null;
      f = null;
      paramContext = new StringBuilder();
      paramContext.append("check AppDefined core is error src is ");
      paramContext.append(e);
      paramContext.append(" dest is ");
      paramContext.append(p.a().a(c));
      paramContext = paramContext.toString();
    }
    else
    {
      if ((k(paramContext)) || (l(paramContext))) {
        break label218;
      }
      e = 0;
      d = null;
      f = null;
      paramContext = "core_info error checkCoreInfo is false and checkCoreInOthers is false ";
    }
    TbsLog.i("TbsShareManager", paramContext);
    label218:
    if ((e > 0) && (g))
    {
      e = 0;
      d = null;
      f = null;
      TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
    }
    return e;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String g(Context paramContext)
  {
    try
    {
      n(paramContext);
      if (d != null)
      {
        if (TextUtils.isEmpty(d)) {
          return null;
        }
        paramContext = new StringBuilder(d);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTbsResourcesPath exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      Log.e("", localStringBuilder.toString());
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists())
      {
        boolean bool = paramContext.canRead();
        if (bool) {
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label47:
      break label47;
    }
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if ((paramContext.exists()) && (paramContext.canRead())) {
        return a.b(paramContext);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApkVersionByReadFile,coreBackup not exist");
      localStringBuilder.append(paramContext);
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      return 0;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBackupCoreVersion exception,pkg=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      if ((paramContext.exists()) && (paramContext.canRead()))
      {
        int m = a.b(paramContext);
        return m;
      }
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBackupDecoupleCoreVersion exception,pkg=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return g;
  }
  
  public static boolean getCoreFormOwn()
  {
    return k;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return c;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    long l1 = 0L;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      long l2;
      long l3;
      if (str.equalsIgnoreCase("com.tencent.mm"))
      {
        l2 = getSharedTbsCoreVersion(paramContext, str);
        l3 = 10000000000L;
      }
      for (l2 *= l3;; l2 = getSharedTbsCoreVersion(paramContext, str))
      {
        l2 = l1 + l2;
        break label116;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l2 = getSharedTbsCoreVersion(paramContext, str);
          l3 = 100000L;
          break;
        }
        l2 = l1;
        if (!str.equalsIgnoreCase("com.qzone")) {
          break label116;
        }
      }
      label116:
      m += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (!"com.tencent.tbs".equals(paramString)) && ((TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()) || (Build.VERSION.SDK_INT >= 29)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPackageContext,ctx=");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(";pkgName=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(";isShare=");
        localStringBuilder.append(paramBoolean);
        TbsLog.i("TbsShareManager", localStringBuilder.toString());
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      paramString = new StringBuilder();
      paramString.append("getPackageContext context is ");
      paramString.append(paramContext);
      Log.d("TbsDownload", paramString.toString());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getPackageContext stack is ");
      paramString.append(Log.getStackTraceString(paramContext));
      Log.d("TbsDownload", paramString.toString());
    }
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null) {
      return p.a().j(paramContext);
    }
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = p.a().s(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static int getTbsStableCoreVersion(Context paramContext, int paramInt)
  {
    try
    {
      localObject = getPackageContext(paramContext, "com.tencent.mm", false);
      if (localObject == null) {
        localObject = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
      } else {
        localObject = new File(FileUtil.a((Context)localObject, 4));
      }
      localObject = new File((File)localObject, TbsDownloader.getBackupFileName(false, paramInt));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTbsStableCoreVersion, coreStable is ");
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      if ((((File)localObject).exists()) && (((File)localObject).canRead()))
      {
        paramInt = a.b((File)localObject);
        if (paramInt <= 0) {
          return a.a(paramContext, (File)localObject);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("getTbsStableCoreVersion,core stable not exist");
        paramContext.append(localObject);
        TbsLog.i("TbsDownload", paramContext.toString());
        return 0;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTbsStableCoreVersion stack is ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
      return 0;
    }
    return paramInt;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 42
    //   5: ldc_w 515
    //   8: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: ldc_w 278
    //   15: invokestatic 281	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +16 -> 36
    //   23: ldc 42
    //   25: ldc_w 517
    //   28: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: iconst_0
    //   35: ireturn
    //   36: new 283	java/io/BufferedInputStream
    //   39: dup
    //   40: new 285	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: new 293	java/util/Properties
    //   57: dup
    //   58: invokespecial 294	java/util/Properties:<init>	()V
    //   61: astore_3
    //   62: aload_2
    //   63: astore_0
    //   64: aload_3
    //   65: aload_2
    //   66: invokevirtual 297	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload_2
    //   70: astore_0
    //   71: aload_3
    //   72: ldc_w 519
    //   75: ldc 154
    //   77: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: ldc 154
    //   85: aload_3
    //   86: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +41 -> 130
    //   92: aload_2
    //   93: astore_0
    //   94: ldc 42
    //   96: ldc_w 521
    //   99: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_2
    //   103: astore_0
    //   104: aload_3
    //   105: invokestatic 526	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: iconst_0
    //   109: invokestatic 532	java/lang/Math:max	(II)I
    //   112: istore_1
    //   113: aload_2
    //   114: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   117: goto +8 -> 125
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   125: ldc 2
    //   127: monitorexit
    //   128: iload_1
    //   129: ireturn
    //   130: aload_2
    //   131: astore_0
    //   132: ldc 42
    //   134: ldc_w 535
    //   137: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   152: ldc 2
    //   154: monitorexit
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_3
    //   158: goto +12 -> 170
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_2
    //   164: goto +47 -> 211
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: astore_0
    //   172: aload_3
    //   173: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   176: aload_2
    //   177: ifnull +15 -> 192
    //   180: aload_2
    //   181: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   184: goto +8 -> 192
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   192: ldc 42
    //   194: ldc_w 537
    //   197: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: ldc 2
    //   202: monitorexit
    //   203: bipush 254
    //   205: ireturn
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: aload_2
    //   212: ifnull +15 -> 227
    //   215: aload_2
    //   216: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   219: goto +8 -> 227
    //   222: astore_2
    //   223: aload_2
    //   224: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   227: aload_0
    //   228: athrow
    //   229: astore_0
    //   230: ldc 2
    //   232: monitorexit
    //   233: aload_0
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramContext	Context
    //   112	17	1	m	int
    //   51	165	2	localObject1	Object
    //   222	2	2	localException	Exception
    //   61	44	3	localObject2	Object
    //   157	1	3	localThrowable1	Throwable
    //   167	6	3	localThrowable2	Throwable
    //   206	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   113	117	120	java/lang/Exception
    //   140	144	147	java/lang/Exception
    //   54	62	157	java/lang/Throwable
    //   64	69	157	java/lang/Throwable
    //   71	81	157	java/lang/Throwable
    //   83	92	157	java/lang/Throwable
    //   94	102	157	java/lang/Throwable
    //   104	113	157	java/lang/Throwable
    //   132	140	157	java/lang/Throwable
    //   11	19	161	finally
    //   23	31	161	finally
    //   36	52	161	finally
    //   11	19	167	java/lang/Throwable
    //   23	31	167	java/lang/Throwable
    //   36	52	167	java/lang/Throwable
    //   180	184	187	java/lang/Exception
    //   54	62	206	finally
    //   64	69	206	finally
    //   71	81	206	finally
    //   83	92	206	finally
    //   94	102	206	finally
    //   104	113	206	finally
    //   132	140	206	finally
    //   172	176	206	finally
    //   215	219	222	java/lang/Exception
    //   3	11	229	finally
    //   113	117	229	finally
    //   121	125	229	finally
    //   140	144	229	finally
    //   148	152	229	finally
    //   180	184	229	finally
    //   188	192	229	finally
    //   192	200	229	finally
    //   215	219	229	finally
    //   223	227	229	finally
    //   227	229	229	finally
  }
  
  static boolean i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if (c == null)
      {
        if ((e != 0) && (getSharedTbsCoreVersion(paramContext, f) == e)) {
          return true;
        }
      }
      else if ((e != 0) && (p.a().a(c) == e)) {
        return true;
      }
      if (l(paramContext)) {
        return true;
      }
      TbsCoreLoadStat localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAvailableCoreVersion=");
      localStringBuilder.append(e);
      localStringBuilder.append("; mSrcPackageName=");
      localStringBuilder.append(f);
      localStringBuilder.append("; getSharedTbsCoreVersion(ctx, mSrcPackageName) is ");
      localStringBuilder.append(getSharedTbsCoreVersion(paramContext, f));
      localStringBuilder.append("; getHostCoreVersions is ");
      localStringBuilder.append(getHostCoreVersions(paramContext));
      localTbsCoreLoadStat.a(paramContext, 418, new Throwable(localStringBuilder.toString()));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    try
    {
      if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
        return b;
      }
      a = paramContext.getApplicationContext();
      paramContext = a.getPackageName();
      String[] arrayOfString = getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramContext.equals(arrayOfString[m]))
        {
          b = false;
          return false;
        }
        m += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      b = true;
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    String str = f;
    if (str == null) {
      return false;
    }
    return e == getSharedTbsCoreVersion(paramContext, str);
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {
      return false;
    }
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      int i1 = e;
      if ((i1 > 0) && (i1 == getSharedTbsCoreVersion(paramContext, str)))
      {
        Context localContext = getPackageContext(paramContext, str, true);
        if (p.a().g(paramContext))
        {
          d = p.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          return true;
        }
      }
      m += 1;
    }
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 583	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: ldc 2
    //   9: monitorenter
    //   10: getstatic 583	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   13: ifeq +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: ldc_w 278
    //   24: invokestatic 281	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   27: astore_0
    //   28: aload_0
    //   29: ifnonnull +7 -> 36
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: new 283	java/io/BufferedInputStream
    //   39: dup
    //   40: new 285	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: new 293	java/util/Properties
    //   57: dup
    //   58: invokespecial 294	java/util/Properties:<init>	()V
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: aload_1
    //   66: invokevirtual 297	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: ldc_w 519
    //   75: ldc 154
    //   77: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 154
    //   85: aload_3
    //   86: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +87 -> 176
    //   92: aload_1
    //   93: astore_0
    //   94: aload_3
    //   95: invokestatic 526	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: iconst_0
    //   99: invokestatic 532	java/lang/Math:max	(II)I
    //   102: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   105: aload_1
    //   106: astore_0
    //   107: new 70	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   114: astore_3
    //   115: aload_1
    //   116: astore_0
    //   117: aload_3
    //   118: ldc_w 585
    //   121: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: astore_0
    //   127: aload_3
    //   128: getstatic 34	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   131: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: astore_0
    //   137: aload_3
    //   138: ldc_w 587
    //   141: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: astore_0
    //   147: aload_3
    //   148: new 40	java/lang/Throwable
    //   151: dup
    //   152: ldc_w 589
    //   155: invokespecial 562	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   158: invokestatic 148	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   161: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: astore_0
    //   167: ldc 42
    //   169: aload_3
    //   170: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_1
    //   177: astore_0
    //   178: aload_2
    //   179: ldc_w 318
    //   182: ldc 154
    //   184: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore_3
    //   188: aload_1
    //   189: astore_0
    //   190: ldc 154
    //   192: aload_3
    //   193: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifne +9 -> 205
    //   199: aload_1
    //   200: astore_0
    //   201: aload_3
    //   202: putstatic 353	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   205: aload_1
    //   206: astore_0
    //   207: getstatic 353	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   210: ifnull +43 -> 253
    //   213: aload_1
    //   214: astore_0
    //   215: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   218: ifnull +35 -> 253
    //   221: aload_1
    //   222: astore_0
    //   223: getstatic 353	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   226: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   229: invokevirtual 139	android/content/Context:getPackageName	()Ljava/lang/String;
    //   232: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifeq +12 -> 247
    //   238: aload_1
    //   239: astore_0
    //   240: iconst_1
    //   241: putstatic 444	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   244: goto +9 -> 253
    //   247: aload_1
    //   248: astore_0
    //   249: iconst_0
    //   250: putstatic 444	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   253: aload_1
    //   254: astore_0
    //   255: aload_2
    //   256: ldc_w 320
    //   259: ldc 154
    //   261: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   264: astore_3
    //   265: aload_1
    //   266: astore_0
    //   267: ldc 154
    //   269: aload_3
    //   270: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: ifne +9 -> 282
    //   276: aload_1
    //   277: astore_0
    //   278: aload_3
    //   279: putstatic 37	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   282: aload_1
    //   283: astore_0
    //   284: aload_2
    //   285: ldc_w 322
    //   288: ldc 154
    //   290: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   293: astore_3
    //   294: aload_1
    //   295: astore_0
    //   296: ldc 154
    //   298: aload_3
    //   299: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifne +9 -> 311
    //   305: aload_1
    //   306: astore_0
    //   307: aload_3
    //   308: putstatic 591	com/tencent/smtt/sdk/TbsShareManager:j	Ljava/lang/String;
    //   311: aload_1
    //   312: astore_0
    //   313: aload_2
    //   314: ldc_w 299
    //   317: ldc_w 593
    //   320: invokevirtual 359	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   323: invokestatic 598	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   326: putstatic 393	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   329: aload_1
    //   330: astore_0
    //   331: iconst_1
    //   332: putstatic 583	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   335: aload_1
    //   336: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   339: goto +45 -> 384
    //   342: astore_0
    //   343: aload_0
    //   344: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   347: goto +37 -> 384
    //   350: astore_2
    //   351: goto +12 -> 363
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_1
    //   357: goto +36 -> 393
    //   360: astore_2
    //   361: aconst_null
    //   362: astore_1
    //   363: aload_1
    //   364: astore_0
    //   365: aload_2
    //   366: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   369: aload_1
    //   370: ifnull +14 -> 384
    //   373: aload_1
    //   374: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   377: goto +7 -> 384
    //   380: astore_0
    //   381: goto -38 -> 343
    //   384: ldc 2
    //   386: monitorexit
    //   387: return
    //   388: astore_2
    //   389: aload_0
    //   390: astore_1
    //   391: aload_2
    //   392: astore_0
    //   393: aload_1
    //   394: ifnull +15 -> 409
    //   397: aload_1
    //   398: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   401: goto +8 -> 409
    //   404: astore_1
    //   405: aload_1
    //   406: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   409: aload_0
    //   410: athrow
    //   411: astore_0
    //   412: ldc 2
    //   414: monitorexit
    //   415: goto +5 -> 420
    //   418: aload_0
    //   419: athrow
    //   420: goto -2 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramContext	Context
    //   51	347	1	localObject1	Object
    //   404	2	1	localException	Exception
    //   61	253	2	localProperties	java.util.Properties
    //   350	1	2	localThrowable1	Throwable
    //   360	6	2	localThrowable2	Throwable
    //   388	4	2	localObject2	Object
    //   80	228	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   335	339	342	java/lang/Exception
    //   54	62	350	java/lang/Throwable
    //   64	69	350	java/lang/Throwable
    //   71	81	350	java/lang/Throwable
    //   83	92	350	java/lang/Throwable
    //   94	105	350	java/lang/Throwable
    //   107	115	350	java/lang/Throwable
    //   117	125	350	java/lang/Throwable
    //   127	135	350	java/lang/Throwable
    //   137	145	350	java/lang/Throwable
    //   147	165	350	java/lang/Throwable
    //   167	176	350	java/lang/Throwable
    //   178	188	350	java/lang/Throwable
    //   190	199	350	java/lang/Throwable
    //   201	205	350	java/lang/Throwable
    //   207	213	350	java/lang/Throwable
    //   215	221	350	java/lang/Throwable
    //   223	238	350	java/lang/Throwable
    //   240	244	350	java/lang/Throwable
    //   249	253	350	java/lang/Throwable
    //   255	265	350	java/lang/Throwable
    //   267	276	350	java/lang/Throwable
    //   278	282	350	java/lang/Throwable
    //   284	294	350	java/lang/Throwable
    //   296	305	350	java/lang/Throwable
    //   307	311	350	java/lang/Throwable
    //   313	329	350	java/lang/Throwable
    //   331	335	350	java/lang/Throwable
    //   20	28	354	finally
    //   36	52	354	finally
    //   20	28	360	java/lang/Throwable
    //   36	52	360	java/lang/Throwable
    //   373	377	380	java/lang/Exception
    //   54	62	388	finally
    //   64	69	388	finally
    //   71	81	388	finally
    //   83	92	388	finally
    //   94	105	388	finally
    //   107	115	388	finally
    //   117	125	388	finally
    //   127	135	388	finally
    //   137	145	388	finally
    //   147	165	388	finally
    //   167	176	388	finally
    //   178	188	388	finally
    //   190	199	388	finally
    //   201	205	388	finally
    //   207	213	388	finally
    //   215	221	388	finally
    //   223	238	388	finally
    //   240	244	388	finally
    //   249	253	388	finally
    //   255	265	388	finally
    //   267	276	388	finally
    //   278	282	388	finally
    //   284	294	388	finally
    //   296	305	388	finally
    //   307	311	388	finally
    //   313	329	388	finally
    //   331	335	388	finally
    //   365	369	388	finally
    //   397	401	404	java/lang/Exception
    //   10	19	411	finally
    //   32	35	411	finally
    //   335	339	411	finally
    //   343	347	411	finally
    //   373	377	411	finally
    //   384	387	411	finally
    //   397	401	411	finally
    //   405	409	411	finally
    //   409	411	411	finally
    //   412	415	411	finally
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersion is ");
      ((StringBuilder)localObject1).append(paramInt);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (paramInt == 0)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
        return;
      }
      m = h(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromConfig is ");
      ((StringBuilder)localObject1).append(m);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (m < 0)
      {
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
        return;
      }
      if (paramInt == m)
      {
        if ((d(paramContext) == 0) && (!paramBoolean)) {
          a(paramContext, paramInt);
        }
        c(paramContext, paramBoolean);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
        return;
      }
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        return;
      }
      m = p.a().j(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ");
      ((StringBuilder)localObject1).append(m);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        return;
      }
      localObject4 = d(paramContext, paramBoolean);
      localObject1 = c;
      i1 = 0;
      if (localObject1 != null)
      {
        if (paramInt == p.a().a(c))
        {
          writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
          try
          {
            localObject1 = getTbsShareFile(paramContext, "core_info");
            if ((!i) && (localObject1 != null))
            {
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(p.a().s(paramContext).getAbsolutePath(), "755");
              i = true;
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
          }
          return;
        }
        if (paramInt > p.a().a(c))
        {
          n = localObject4.length;
          m = 0;
          while (m < n)
          {
            localObject1 = localObject4[m];
            if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject1))
            {
              localObject2 = getPackageContext(paramContext, (String)localObject1, true);
              localObject1 = p.a().r((Context)localObject2).getAbsolutePath();
              b.e(paramContext);
              if (p.a().g((Context)localObject2))
              {
                localObject2 = new File(c);
                localObject1 = new File((String)localObject1);
                localObject4 = new TbsShareManager.1();
                try
                {
                  FileUtil.a((File)localObject1, (File)localObject2, (FileFilter)localObject4);
                  writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
                  localObject1 = getTbsShareFile(paramContext, "core_info");
                  if ((!i) && (localObject1 != null))
                  {
                    localObject2 = new TbsLinuxToolsJni(a);
                    ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                    ((TbsLinuxToolsJni)localObject2).a(p.a().s(paramContext).getAbsolutePath(), "755");
                    i = true;
                  }
                }
                catch (Throwable paramContext)
                {
                  paramContext.printStackTrace();
                }
                return;
              }
            }
            m += 1;
          }
        }
      }
      i2 = localObject4.length;
      m = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int m;
        Object localObject4;
        int i1;
        Object localObject2;
        int i2;
        for (;;)
        {
          throw paramContext;
        }
        label1126:
        int n = 1;
        continue;
        label1132:
        m += 1;
      }
    }
    n = i1;
    if (m < i2)
    {
      localObject2 = localObject4[m];
      try
      {
        n = getSharedTbsCoreVersion(paramContext, (String)localObject2);
        Object localObject3;
        if (paramInt == n)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion ok,  packageName is ");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(" result version is ");
          ((StringBuilder)localObject1).append(paramInt);
          TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
          Object localObject5 = getPackageContext(paramContext, (String)localObject2, true);
          if (localObject5 == null) {
            break label1132;
          }
          localObject1 = p.a().r((Context)localObject5).getAbsolutePath();
          n = b.e(paramContext);
          if (!p.a().g((Context)localObject5)) {
            break label1132;
          }
          if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("thirdAPP pre--> delete old core_share Directory:");
            ((StringBuilder)localObject5).append(paramInt);
            TbsLog.i("TbsShareManager", ((StringBuilder)localObject5).toString());
            m.a(a).a("remove_old_core", 1);
          }
          writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject1, Integer.toString(n));
          localObject1 = "";
          try
          {
            localObject2 = ((String)localObject2).substring(((String)localObject2).length() - 2);
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable2)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("throwable is ");
            ((StringBuilder)localObject5).append(Log.getStackTraceString(localThrowable2));
            TbsLog.i("TbsDownload", ((StringBuilder)localObject5).toString());
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("9is");
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append((String)localObject1);
          q.a(((StringBuilder)localObject3).toString());
          try
          {
            localObject1 = getTbsShareFile(paramContext, "core_info");
            if ((i) || (localObject1 == null)) {
              break label1126;
            }
            localObject3 = new TbsLinuxToolsJni(a);
            ((TbsLinuxToolsJni)localObject3).a(((File)localObject1).getAbsolutePath(), "644");
            ((TbsLinuxToolsJni)localObject3).a(p.a().s(paramContext).getAbsolutePath(), "755");
            i = true;
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("writeCoreInfoForThirdPartyApp getSharedTbsCoreVersion fail,  packageName is ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" result version is ");
        localStringBuilder.append(n);
        TbsLog.i("TbsShareManager", localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        TbsLog.i(localException);
      }
    }
    else
    {
      if ((n == 0) && (!paramBoolean))
      {
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp ready to installCoreWithUnzip ");
        a(paramContext, paramInt);
      }
      return;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: new 70	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 661
    //   14: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 663
    //   30: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 665
    //   46: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: aload_3
    //   53: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 42
    //   59: aload 6
    //   61: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 70	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   74: astore 6
    //   76: aload 6
    //   78: ldc_w 667
    //   81: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: new 40	java/lang/Throwable
    //   90: dup
    //   91: ldc_w 589
    //   94: invokespecial 562	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   97: invokestatic 148	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 42
    //   106: aload 6
    //   108: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aconst_null
    //   115: astore 6
    //   117: aconst_null
    //   118: astore 7
    //   120: aload_0
    //   121: ldc_w 278
    //   124: invokestatic 281	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   127: astore 8
    //   129: aload 8
    //   131: ifnonnull +16 -> 147
    //   134: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   137: invokestatic 610	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   140: sipush -405
    //   143: invokevirtual 614	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   146: return
    //   147: new 283	java/io/BufferedInputStream
    //   150: dup
    //   151: new 285	java/io/FileInputStream
    //   154: dup
    //   155: aload 8
    //   157: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   163: astore_0
    //   164: new 293	java/util/Properties
    //   167: dup
    //   168: invokespecial 294	java/util/Properties:<init>	()V
    //   171: astore 7
    //   173: aload 7
    //   175: aload_0
    //   176: invokevirtual 297	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   179: aload_1
    //   180: invokestatic 526	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   183: istore 5
    //   185: goto +6 -> 191
    //   188: iconst_0
    //   189: istore 5
    //   191: iload 5
    //   193: ifeq +60 -> 253
    //   196: aload 7
    //   198: ldc_w 519
    //   201: aload_1
    //   202: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 7
    //   208: ldc_w 299
    //   211: iconst_0
    //   212: invokestatic 303	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   215: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   218: pop
    //   219: aload 7
    //   221: ldc_w 318
    //   224: aload_2
    //   225: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   228: pop
    //   229: aload 7
    //   231: ldc_w 320
    //   234: aload_3
    //   235: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   238: pop
    //   239: aload 7
    //   241: ldc_w 322
    //   244: aload 4
    //   246: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   249: pop
    //   250: goto +16 -> 266
    //   253: aload 7
    //   255: ldc_w 299
    //   258: iconst_1
    //   259: invokestatic 303	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   262: invokevirtual 307	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   265: pop
    //   266: new 326	java/io/BufferedOutputStream
    //   269: dup
    //   270: new 328	java/io/FileOutputStream
    //   273: dup
    //   274: aload 8
    //   276: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   279: invokespecial 332	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   282: astore_1
    //   283: aload 7
    //   285: aload_1
    //   286: aconst_null
    //   287: invokevirtual 336	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   290: iconst_0
    //   291: putstatic 583	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   294: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   297: invokestatic 610	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   300: sipush -406
    //   303: invokevirtual 614	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   306: aload_0
    //   307: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   310: goto +8 -> 318
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   318: aload_1
    //   319: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   322: return
    //   323: astore_3
    //   324: aload_0
    //   325: astore_2
    //   326: aload_3
    //   327: astore_0
    //   328: goto +79 -> 407
    //   331: astore_2
    //   332: goto +35 -> 367
    //   335: astore_3
    //   336: aload 6
    //   338: astore_1
    //   339: aload_0
    //   340: astore_2
    //   341: aload_3
    //   342: astore_0
    //   343: goto +64 -> 407
    //   346: astore_2
    //   347: aconst_null
    //   348: astore_1
    //   349: goto +18 -> 367
    //   352: astore_0
    //   353: aconst_null
    //   354: astore_2
    //   355: aload 6
    //   357: astore_1
    //   358: goto +49 -> 407
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_1
    //   364: aload 7
    //   366: astore_0
    //   367: aload_2
    //   368: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   371: aload_0
    //   372: ifnull +15 -> 387
    //   375: aload_0
    //   376: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   379: goto +8 -> 387
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   387: aload_1
    //   388: ifnull +13 -> 401
    //   391: aload_1
    //   392: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   395: return
    //   396: astore_0
    //   397: aload_0
    //   398: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   401: return
    //   402: astore_3
    //   403: aload_0
    //   404: astore_2
    //   405: aload_3
    //   406: astore_0
    //   407: aload_2
    //   408: ifnull +15 -> 423
    //   411: aload_2
    //   412: invokevirtual 339	java/io/BufferedInputStream:close	()V
    //   415: goto +8 -> 423
    //   418: astore_2
    //   419: aload_2
    //   420: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   423: aload_1
    //   424: ifnull +15 -> 439
    //   427: aload_1
    //   428: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   431: goto +8 -> 439
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   439: aload_0
    //   440: athrow
    //   441: astore 9
    //   443: goto -255 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramContext	Context
    //   0	446	1	paramString1	String
    //   0	446	2	paramString2	String
    //   0	446	3	paramString3	String
    //   0	446	4	paramString4	String
    //   183	9	5	m	int
    //   7	349	6	localStringBuilder	StringBuilder
    //   118	247	7	localProperties	java.util.Properties
    //   127	148	8	localFile	File
    //   441	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   306	310	313	java/lang/Exception
    //   283	306	323	finally
    //   283	306	331	java/lang/Throwable
    //   164	179	335	finally
    //   179	185	335	finally
    //   196	250	335	finally
    //   253	266	335	finally
    //   266	283	335	finally
    //   164	179	346	java/lang/Throwable
    //   179	185	346	java/lang/Throwable
    //   196	250	346	java/lang/Throwable
    //   253	266	346	java/lang/Throwable
    //   266	283	346	java/lang/Throwable
    //   120	129	352	finally
    //   134	146	352	finally
    //   147	164	352	finally
    //   120	129	361	java/lang/Throwable
    //   134	146	361	java/lang/Throwable
    //   147	164	361	java/lang/Throwable
    //   375	379	382	java/lang/Exception
    //   318	322	396	java/lang/Exception
    //   391	395	396	java/lang/Exception
    //   367	371	402	finally
    //   411	415	418	java/lang/Exception
    //   427	431	434	java/lang/Exception
    //   179	185	441	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */