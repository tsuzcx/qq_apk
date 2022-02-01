package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QQFMSettings
{
  QQCustomDialog a;
  Map<String, QQFMSettings.StorageInfo> b = null;
  long c = 0L;
  long d = 0L;
  int e = 0;
  boolean f = false;
  String g = "";
  String h = "";
  boolean i = false;
  long j = System.currentTimeMillis() / 1000L;
  long k = 0L;
  
  public QQFMSettings()
  {
    a(2, "new FMSetting!");
    a();
  }
  
  private long a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString).listFiles();
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return 0L;
      }
      int m = 0;
      for (;;)
      {
        l2 = l1;
        if (m >= paramString.length) {
          break;
        }
        Object localObject = paramString[m];
        if (localObject.isDirectory()) {}
        for (l2 = a(localObject.getPath(), paramList);; l2 = paramString[m].length())
        {
          l1 += l2;
          break;
          if (paramList != null) {
            paramList.add(localObject.getAbsolutePath());
          }
        }
        m += 1;
      }
    }
    return l2;
  }
  
  public static void a(int paramInt, String paramString) {}
  
  /* Error */
  private void a(File paramFile1, File paramFile2, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_1
    //   13: invokevirtual 124	java/io/File:exists	()Z
    //   16: ifeq +201 -> 217
    //   19: aload_1
    //   20: invokevirtual 97	java/io/File:length	()J
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +6 -> 31
    //   28: goto +189 -> 217
    //   31: aload_2
    //   32: invokevirtual 124	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_2
    //   39: invokevirtual 127	java/io/File:delete	()Z
    //   42: pop
    //   43: new 129	java/io/FileOutputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore 5
    //   53: new 134	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 6
    //   63: invokestatic 141	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   66: sipush 4096
    //   69: invokevirtual 145	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   72: astore 7
    //   74: aload 6
    //   76: aload 7
    //   78: invokevirtual 149	java/io/FileInputStream:read	([B)I
    //   81: istore 4
    //   83: iload 4
    //   85: iconst_m1
    //   86: if_icmpeq +38 -> 124
    //   89: aload_0
    //   90: getfield 36	com/tencent/mobileqq/filemanager/settings/QQFMSettings:f	Z
    //   93: ifne +31 -> 124
    //   96: aload 5
    //   98: aload 7
    //   100: iconst_0
    //   101: iload 4
    //   103: invokevirtual 153	java/io/FileOutputStream:write	([BII)V
    //   106: aload 5
    //   108: invokevirtual 156	java/io/FileOutputStream:flush	()V
    //   111: aload_3
    //   112: iload 4
    //   114: i2l
    //   115: lconst_0
    //   116: invokeinterface 161 5 0
    //   121: goto -47 -> 74
    //   124: invokestatic 141	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   127: aload 7
    //   129: invokevirtual 165	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   132: aload 5
    //   134: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   137: aload 6
    //   139: invokevirtual 169	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: aload_1
    //   144: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: aload_2
    //   148: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: invokeinterface 172 3 0
    //   156: aload_3
    //   157: invokeinterface 173 1 0
    //   162: return
    //   163: astore 8
    //   165: aload 6
    //   167: astore 7
    //   169: aload 8
    //   171: astore 6
    //   173: goto +76 -> 249
    //   176: aload 6
    //   178: astore_1
    //   179: goto +122 -> 301
    //   182: aload 6
    //   184: astore_1
    //   185: goto +151 -> 336
    //   188: aload 6
    //   190: astore_1
    //   191: goto +180 -> 371
    //   194: astore 6
    //   196: goto +53 -> 249
    //   199: aload 8
    //   201: astore_1
    //   202: goto +99 -> 301
    //   205: aload 9
    //   207: astore_1
    //   208: goto +128 -> 336
    //   211: aload 10
    //   213: astore_1
    //   214: goto +157 -> 371
    //   217: iconst_1
    //   218: ldc 175
    //   220: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   223: aload_3
    //   224: aload_1
    //   225: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   228: aload_2
    //   229: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokeinterface 172 3 0
    //   237: aload_3
    //   238: invokeinterface 173 1 0
    //   243: return
    //   244: astore 6
    //   246: aconst_null
    //   247: astore 5
    //   249: aload 5
    //   251: ifnull +11 -> 262
    //   254: aload 5
    //   256: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   259: goto +3 -> 262
    //   262: aload 7
    //   264: ifnull +8 -> 272
    //   267: aload 7
    //   269: invokevirtual 169	java/io/FileInputStream:close	()V
    //   272: aload_3
    //   273: aload_1
    //   274: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   277: aload_2
    //   278: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   281: invokeinterface 172 3 0
    //   286: aload_3
    //   287: invokeinterface 173 1 0
    //   292: aload 6
    //   294: athrow
    //   295: aconst_null
    //   296: astore 5
    //   298: aload 8
    //   300: astore_1
    //   301: aload 5
    //   303: ifnull +11 -> 314
    //   306: aload 5
    //   308: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 169	java/io/FileInputStream:close	()V
    //   322: aload_3
    //   323: iconst_m1
    //   324: invokeinterface 178 2 0
    //   329: return
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 9
    //   335: astore_1
    //   336: aload 5
    //   338: ifnull +11 -> 349
    //   341: aload 5
    //   343: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   346: goto +3 -> 349
    //   349: aload_1
    //   350: ifnull +7 -> 357
    //   353: aload_1
    //   354: invokevirtual 169	java/io/FileInputStream:close	()V
    //   357: aload_3
    //   358: iconst_m1
    //   359: invokeinterface 178 2 0
    //   364: return
    //   365: aconst_null
    //   366: astore 5
    //   368: aload 10
    //   370: astore_1
    //   371: aload 5
    //   373: ifnull +11 -> 384
    //   376: aload 5
    //   378: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   381: goto +3 -> 384
    //   384: aload_1
    //   385: ifnull +7 -> 392
    //   388: aload_1
    //   389: invokevirtual 169	java/io/FileInputStream:close	()V
    //   392: aload_3
    //   393: iconst_m1
    //   394: invokeinterface 178 2 0
    //   399: return
    //   400: astore_1
    //   401: goto -36 -> 365
    //   404: astore_1
    //   405: goto -75 -> 330
    //   408: astore_1
    //   409: goto -114 -> 295
    //   412: astore_1
    //   413: goto -202 -> 211
    //   416: astore_1
    //   417: goto -212 -> 205
    //   420: astore_1
    //   421: goto -222 -> 199
    //   424: astore_1
    //   425: goto -237 -> 188
    //   428: astore_1
    //   429: goto -247 -> 182
    //   432: astore_1
    //   433: goto -257 -> 176
    //   436: astore 5
    //   438: goto -301 -> 137
    //   441: astore 5
    //   443: goto -301 -> 142
    //   446: astore 5
    //   448: goto -186 -> 262
    //   451: astore 5
    //   453: goto -181 -> 272
    //   456: astore_2
    //   457: goto -143 -> 314
    //   460: astore_1
    //   461: goto -139 -> 322
    //   464: astore_2
    //   465: goto -116 -> 349
    //   468: astore_1
    //   469: goto -112 -> 357
    //   472: astore_2
    //   473: goto -89 -> 384
    //   476: astore_1
    //   477: goto -85 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	QQFMSettings
    //   0	480	1	paramFile1	File
    //   0	480	2	paramFile2	File
    //   0	480	3	paramMoveFileCallback	FMSettingInterface.MoveFileCallback
    //   81	32	4	m	int
    //   51	326	5	localFileOutputStream	java.io.FileOutputStream
    //   436	1	5	localException1	Exception
    //   441	1	5	localException2	Exception
    //   446	1	5	localException3	Exception
    //   451	1	5	localException4	Exception
    //   61	128	6	localObject1	Object
    //   194	1	6	localObject2	Object
    //   244	49	6	localObject3	Object
    //   10	258	7	localObject4	Object
    //   1	1	8	localObject5	Object
    //   163	136	8	localObject6	Object
    //   4	330	9	localObject7	Object
    //   7	362	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   63	74	163	finally
    //   74	83	163	finally
    //   89	121	163	finally
    //   124	132	163	finally
    //   53	63	194	finally
    //   12	28	244	finally
    //   31	43	244	finally
    //   43	53	244	finally
    //   217	223	244	finally
    //   12	28	400	java/io/IOException
    //   31	43	400	java/io/IOException
    //   43	53	400	java/io/IOException
    //   217	223	400	java/io/IOException
    //   12	28	404	java/lang/OutOfMemoryError
    //   31	43	404	java/lang/OutOfMemoryError
    //   43	53	404	java/lang/OutOfMemoryError
    //   217	223	404	java/lang/OutOfMemoryError
    //   12	28	408	java/lang/Exception
    //   31	43	408	java/lang/Exception
    //   43	53	408	java/lang/Exception
    //   217	223	408	java/lang/Exception
    //   53	63	412	java/io/IOException
    //   53	63	416	java/lang/OutOfMemoryError
    //   53	63	420	java/lang/Exception
    //   63	74	424	java/io/IOException
    //   74	83	424	java/io/IOException
    //   89	121	424	java/io/IOException
    //   124	132	424	java/io/IOException
    //   63	74	428	java/lang/OutOfMemoryError
    //   74	83	428	java/lang/OutOfMemoryError
    //   89	121	428	java/lang/OutOfMemoryError
    //   124	132	428	java/lang/OutOfMemoryError
    //   63	74	432	java/lang/Exception
    //   74	83	432	java/lang/Exception
    //   89	121	432	java/lang/Exception
    //   124	132	432	java/lang/Exception
    //   132	137	436	java/lang/Exception
    //   137	142	441	java/lang/Exception
    //   254	259	446	java/lang/Exception
    //   267	272	451	java/lang/Exception
    //   306	311	456	java/lang/Exception
    //   318	322	460	java/lang/Exception
    //   341	346	464	java/lang/Exception
    //   353	357	468	java/lang/Exception
    //   376	381	472	java/lang/Exception
    //   388	392	476	java/lang/Exception
  }
  
  private void a(List<String> paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    a(1, "moveFileToDefaultPath");
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.c = 0L;
      try
      {
        this.e = 0;
        this.d = 0L;
        Object localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          this.d += FileUtil.f(str1);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveFileToDefaultPath,total size[");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("]");
        a(1, ((StringBuilder)localObject).toString());
        if (this.d == 0L)
        {
          paramMoveFileCallback.a();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(n().c);
        ((StringBuilder)localObject).append(n().d);
        String str1 = ((StringBuilder)localObject).toString();
        int n = paramList.size();
        int m = 0;
        for (;;)
        {
          if (m < n)
          {
            String str2 = (String)paramList.get(m);
            if (str2.contains("/.tmp/"))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(c(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.n(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            else if (str2.contains("/.thumbnails/"))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(d(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.n(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(b(str1));
              ((StringBuilder)localObject).append(QQFileManagerUtilImpl.n(str2));
              localObject = ((StringBuilder)localObject).toString();
            }
            localObject = new File((String)localObject);
            try
            {
              ThreadManager.post(new QQFMSettings.4(this, str2, (File)localObject, n, paramMoveFileCallback), 8, null, false);
              m += 1;
            }
            catch (Exception paramList)
            {
              paramMoveFileCallback = new StringBuilder();
              paramMoveFileCallback.append("copyFile Fail! ");
              paramMoveFileCallback.append(paramList.toString());
              a(1, paramMoveFileCallback.toString());
            }
          }
        }
        return;
      }
      finally {}
    }
    a(1, "moveFileToDefaultPath,lstPath is null or size = 0");
  }
  
  private String b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  private String c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/.tmp/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  private String d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/Tencent/QQfile_recv/.thumbnails/");
    paramString = ((StringBuilder)localObject).toString().replace("//", "/");
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  private boolean e(String paramString)
  {
    Object localObject = new File(paramString);
    boolean bool;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdirs();
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] success!");
      a(2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private QQFMSettings.StorageInfo k()
  {
    return (QQFMSettings.StorageInfo)this.b.get("sdCard");
  }
  
  private QQFMSettings.StorageInfo l()
  {
    if (this.b.size() == 1) {
      return null;
    }
    return (QQFMSettings.StorageInfo)this.b.get("externalSdCard");
  }
  
  private void m()
  {
    QQFMSettings.StorageInfo localStorageInfo = h();
    if (localStorageInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localStorageInfo.c);
    localStringBuilder.append(localStorageInfo.d);
    ThreadManager.post(new QQFMSettings.1(this, c(localStringBuilder.toString())), 8, null, false);
  }
  
  private QQFMSettings.StorageInfo n()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDefaultStorage[");
    ((StringBuilder)localObject1).append(this.b.size());
    ((StringBuilder)localObject1).append("]");
    a(2, ((StringBuilder)localObject1).toString());
    localObject1 = this.b.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (QQFMSettings.StorageInfo)this.b.get(localObject2);
      ((QQFMSettings.StorageInfo)localObject2).a();
      if (((QQFMSettings.StorageInfo)localObject2).a)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDefaultStorage[");
        ((StringBuilder)localObject1).append(((QQFMSettings.StorageInfo)localObject2).c);
        ((StringBuilder)localObject1).append("] + ext[");
        ((StringBuilder)localObject1).append(((QQFMSettings.StorageInfo)localObject2).d);
        ((StringBuilder)localObject1).append("]");
        a(2, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    a(2, "getDefaultStorage nothing is default refresh!");
    Object localObject2 = (QQFMSettings.StorageInfo)this.b.get("sdCard");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new QQFMSettings.StorageInfo(this, null);
      ((QQFMSettings.StorageInfo)localObject1).a = true;
      ((QQFMSettings.StorageInfo)localObject1).b = "SD卡";
      ((QQFMSettings.StorageInfo)localObject1).c = Environment.getExternalStorageDirectory().getPath();
      ((QQFMSettings.StorageInfo)localObject1).d = "";
    }
    ((QQFMSettings.StorageInfo)localObject1).a(BaseApplication.getContext());
    return localObject1;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 36	com/tencent/mobileqq/filemanager/settings/QQFMSettings:f	Z
    //   5: invokestatic 349	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore 7
    //   10: aload 7
    //   12: invokestatic 355	com/tencent/mobileqq/filemanager/util/QQFileManagerUtilImpl:a	(Landroid/content/Context;)Ljava/util/Map;
    //   15: astore 8
    //   17: new 206	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   24: astore 6
    //   26: aload 6
    //   28: ldc_w 357
    //   31: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 6
    //   37: aload 8
    //   39: invokeinterface 302 1 0
    //   44: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: ldc 218
    //   52: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: iconst_1
    //   57: aload 6
    //   59: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   65: aload 7
    //   67: ldc_w 359
    //   70: iconst_4
    //   71: invokevirtual 365	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   74: ldc_w 367
    //   77: getstatic 372	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   80: invokeinterface 378 3 0
    //   85: astore 9
    //   87: new 206	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   94: astore 6
    //   96: aload 6
    //   98: ldc_w 380
    //   101: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: aload 9
    //   109: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: ldc 218
    //   117: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iconst_1
    //   122: aload 6
    //   124: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   130: aload_0
    //   131: new 382	java/util/HashMap
    //   134: dup
    //   135: invokespecial 383	java/util/HashMap:<init>	()V
    //   138: putfield 28	com/tencent/mobileqq/filemanager/settings/QQFMSettings:b	Ljava/util/Map;
    //   141: aload 8
    //   143: invokeinterface 320 1 0
    //   148: invokeinterface 323 1 0
    //   153: astore 10
    //   155: aload 10
    //   157: invokeinterface 193 1 0
    //   162: ifeq +427 -> 589
    //   165: aload 10
    //   167: invokeinterface 197 1 0
    //   172: checkcast 199	java/lang/String
    //   175: astore 6
    //   177: aload 8
    //   179: aload 6
    //   181: invokeinterface 300 2 0
    //   186: checkcast 70	java/io/File
    //   189: invokevirtual 85	java/io/File:getPath	()Ljava/lang/String;
    //   192: astore 12
    //   194: new 227	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo
    //   197: dup
    //   198: aload_0
    //   199: aconst_null
    //   200: invokespecial 333	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:<init>	(Lcom/tencent/mobileqq/filemanager/settings/QQFMSettings;Lcom/tencent/mobileqq/filemanager/settings/QQFMSettings$1;)V
    //   203: astore 11
    //   205: aload 11
    //   207: iconst_0
    //   208: putfield 326	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	Z
    //   211: aload 6
    //   213: ldc_w 295
    //   216: invokevirtual 386	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   219: ifeq +28 -> 247
    //   222: aload 11
    //   224: ldc_w 335
    //   227: putfield 337	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:b	Ljava/lang/String;
    //   230: aload 11
    //   232: aload 12
    //   234: putfield 229	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   237: aload 11
    //   239: ldc 38
    //   241: putfield 231	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:d	Ljava/lang/String;
    //   244: goto +89 -> 333
    //   247: aload 6
    //   249: ldc_w 304
    //   252: invokevirtual 386	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   255: ifeq +78 -> 333
    //   258: aload 11
    //   260: ldc_w 388
    //   263: putfield 337	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:b	Ljava/lang/String;
    //   266: aload 7
    //   268: aconst_null
    //   269: invokevirtual 392	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   272: pop
    //   273: invokestatic 349	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   276: invokevirtual 395	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   279: astore 13
    //   281: aload 11
    //   283: aload 12
    //   285: putfield 229	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   288: new 206	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   295: astore 14
    //   297: aload 14
    //   299: ldc_w 397
    //   302: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 14
    //   308: aload 13
    //   310: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 14
    //   316: ldc_w 274
    //   319: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 11
    //   325: aload 14
    //   327: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: putfield 231	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:d	Ljava/lang/String;
    //   333: new 206	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   340: astore 13
    //   342: aload 13
    //   344: ldc_w 399
    //   347: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 13
    //   353: aload 11
    //   355: getfield 229	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   358: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 13
    //   364: ldc_w 401
    //   367: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 13
    //   373: aload 11
    //   375: getfield 326	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	Z
    //   378: invokevirtual 404	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 13
    //   384: ldc 218
    //   386: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: iconst_1
    //   391: aload 13
    //   393: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   399: new 406	android/os/StatFs
    //   402: dup
    //   403: aload 12
    //   405: invokespecial 407	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   408: astore 12
    //   410: aload 12
    //   412: invokevirtual 410	android/os/StatFs:getAvailableBlocks	()I
    //   415: i2l
    //   416: lstore_2
    //   417: aload 12
    //   419: invokevirtual 413	android/os/StatFs:getBlockSize	()I
    //   422: istore_1
    //   423: iload_1
    //   424: i2l
    //   425: lstore 4
    //   427: aload 11
    //   429: lload_2
    //   430: lload 4
    //   432: lmul
    //   433: putfield 415	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:e	J
    //   436: new 206	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   443: astore 12
    //   445: aload 12
    //   447: ldc_w 417
    //   450: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 12
    //   456: aload 9
    //   458: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 12
    //   464: ldc_w 419
    //   467: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 12
    //   473: aload 11
    //   475: getfield 229	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   478: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 12
    //   484: ldc_w 421
    //   487: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: iconst_4
    //   492: aload 12
    //   494: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   500: aload 8
    //   502: invokeinterface 302 1 0
    //   507: iconst_1
    //   508: if_icmpeq +19 -> 527
    //   511: aload 9
    //   513: aload 11
    //   515: getfield 229	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:c	Ljava/lang/String;
    //   518: invokevirtual 386	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   521: ifeq +69 -> 590
    //   524: goto +3 -> 527
    //   527: iconst_4
    //   528: ldc_w 423
    //   531: invokestatic 61	com/tencent/mobileqq/filemanager/settings/QQFMSettings:a	(ILjava/lang/String;)V
    //   534: aload 11
    //   536: iconst_1
    //   537: putfield 326	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	Z
    //   540: aload 11
    //   542: aload 7
    //   544: invokevirtual 352	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	(Landroid/content/Context;)V
    //   547: aload 11
    //   549: invokevirtual 324	com/tencent/mobileqq/filemanager/settings/QQFMSettings$StorageInfo:a	()V
    //   552: aload_0
    //   553: getfield 28	com/tencent/mobileqq/filemanager/settings/QQFMSettings:b	Ljava/util/Map;
    //   556: aload 6
    //   558: aload 11
    //   560: invokeinterface 427 3 0
    //   565: pop
    //   566: goto +20 -> 586
    //   569: astore 6
    //   571: goto +10 -> 581
    //   574: astore 6
    //   576: goto +5 -> 581
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 430	java/lang/Exception:printStackTrace	()V
    //   586: goto -431 -> 155
    //   589: return
    //   590: goto -43 -> 547
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	QQFMSettings
    //   422	2	1	m	int
    //   416	14	2	l1	long
    //   425	6	4	l2	long
    //   24	533	6	localObject1	Object
    //   569	1	6	localException1	Exception
    //   574	1	6	localException2	Exception
    //   579	3	6	localException3	Exception
    //   8	535	7	localBaseApplication	BaseApplication
    //   15	486	8	localMap	Map
    //   85	427	9	str	String
    //   153	13	10	localIterator	Iterator
    //   203	356	11	localStorageInfo	QQFMSettings.StorageInfo
    //   192	301	12	localObject2	Object
    //   279	113	13	localObject3	Object
    //   295	31	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   540	547	569	java/lang/Exception
    //   547	566	569	java/lang/Exception
    //   427	524	574	java/lang/Exception
    //   527	540	574	java/lang/Exception
    //   177	244	579	java/lang/Exception
    //   247	333	579	java/lang/Exception
    //   333	423	579	java/lang/Exception
  }
  
  public void a(long paramLong, List<String> arg3, Activity paramActivity, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    if (this.i) {
      return;
    }
    synchronized (BaseApplication.getContext())
    {
      this.i = true;
      long l = g();
      if (!i())
      {
        paramMoveFileCallback.a(12);
        synchronized (BaseApplication.getContext())
        {
          this.i = false;
          return;
        }
      }
      if (l < paramLong)
      {
        paramMoveFileCallback.a(16);
        synchronized (BaseApplication.getContext())
        {
          this.i = false;
          return;
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("showChoosePath, callback[");
      ((StringBuilder)???).append(paramMoveFileCallback);
      ((StringBuilder)???).append("]");
      a(1, ((StringBuilder)???).toString());
      ??? = k();
      QQFMSettings.StorageInfo localStorageInfo = l();
      if (((QQFMSettings.StorageInfo)???).a)
      {
        this.g = HardCodeUtil.a(2131902668);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(h().c);
        ((StringBuilder)???).append(h().d);
        ((StringBuilder)???).append("/Tencent/QQfile_recv/");
        this.h = ((StringBuilder)???).toString().replace("//", "/");
      }
      else if ((localStorageInfo != null) && (localStorageInfo.a))
      {
        this.g = HardCodeUtil.a(2131902665);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(h().c);
        ((StringBuilder)???).append(h().d);
        ((StringBuilder)???).append("/Tencent/QQfile_recv/");
        this.h = ((StringBuilder)???).toString().replace("//", "/");
      }
      if (paramActivity == null) {
        return;
      }
      paramActivity.runOnUiThread(new QQFMSettings.5(this, paramActivity, ???, paramMoveFileCallback));
      return;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.b != null)
      {
        if (this.b.size() == 0) {
          return;
        }
        this.f = true;
        if (paramString != null) {
          this.b.remove(paramString);
        }
        if ("externalSdCard".equalsIgnoreCase(paramString)) {
          ((QQFMSettings.StorageInfo)this.b.get("sdCard")).a(BaseApplication.getContext());
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String b()
  {
    QQFMSettings.StorageInfo localStorageInfo = h();
    if (localStorageInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localStorageInfo.c);
    localStringBuilder.append(localStorageInfo.d);
    return b(localStringBuilder.toString());
  }
  
  public String c()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  public String d()
  {
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
  }
  
  public String e()
  {
    return AppConstants.SDCARD_FILE_SAVE_THUMB_PATH;
  }
  
  public long f()
  {
    Object localObject = n().c;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int m = ((StatFs)localObject).getBlockSize();
      return l * m;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public long g()
  {
    Object localObject = h();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((QQFMSettings.StorageInfo)localObject).c;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int m = ((StatFs)localObject).getBlockSize();
      return l * m;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public QQFMSettings.StorageInfo h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getOtherStorage[");
    ((StringBuilder)localObject1).append(this.b.size());
    ((StringBuilder)localObject1).append("]");
    a(2, ((StringBuilder)localObject1).toString());
    localObject1 = n();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      localObject2 = (QQFMSettings.StorageInfo)this.b.get(localObject2);
      if (localObject1 != localObject2) {
        return localObject2;
      }
    }
    a(2, "getOtherStorage nothing is default refresh!");
    return null;
  }
  
  public boolean i()
  {
    if (this.b.size() == 1) {
      return false;
    }
    return l() != null;
  }
  
  public void j()
  {
    try
    {
      a(1, "FMSettings free");
      Field localField = this.a.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(this.a, Boolean.valueOf(true));
      this.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings
 * JD-Core Version:    0.7.0.1
 */