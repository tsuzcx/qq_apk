package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.tencent.open.downloadnew.common.NoticeParam;
import java.io.File;

public class NowUtil
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("now_download_temp_QQ.apk");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    NoticeParam localNoticeParam = new NoticeParam();
    localNoticeParam.d = "com.tencent.now";
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.open.download.pause.com.tencent.mobileqq.tool");
    localIntent.putExtra("processName", "com.tencent.mobileqq:tool");
    localIntent.putExtra("noticeParam", localNoticeParam);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString != null) && (!"".equalsIgnoreCase(paramString))) {
      return new File(paramString).delete();
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!"com.tencent.now".equals(paramString2)) {
      return false;
    }
    return b(b());
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 32
    //   2: aload_2
    //   3: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: iload 4
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: invokestatic 90	com/tencent/mobileqq/intervideo/now/NowUtil:b	(Ljava/lang/String;)Z
    //   22: ifne +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: invokestatic 88	com/tencent/mobileqq/intervideo/now/NowUtil:b	()Ljava/lang/String;
    //   30: invokestatic 90	com/tencent/mobileqq/intervideo/now/NowUtil:b	(Ljava/lang/String;)Z
    //   33: ifeq +5 -> 38
    //   36: iconst_1
    //   37: ireturn
    //   38: invokestatic 97	com/tencent/mobileqq/intervideo/now/NowUtil:a	()Ljava/lang/String;
    //   41: astore 8
    //   43: aload 8
    //   45: invokestatic 90	com/tencent/mobileqq/intervideo/now/NowUtil:b	(Ljava/lang/String;)Z
    //   48: ifeq +9 -> 57
    //   51: aload 8
    //   53: invokestatic 99	com/tencent/mobileqq/intervideo/now/NowUtil:a	(Ljava/lang/String;)Z
    //   56: pop
    //   57: new 73	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: new 73	java/io/File
    //   69: dup
    //   70: aload 8
    //   72: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 102	java/io/File:createNewFile	()Z
    //   80: pop
    //   81: aconst_null
    //   82: astore_2
    //   83: aconst_null
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 6
    //   89: new 104	java/io/FileInputStream
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_0
    //   98: new 109	java/io/FileOutputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore_1
    //   107: sipush 1024
    //   110: newarray byte
    //   112: astore_2
    //   113: aload_0
    //   114: aload_2
    //   115: invokevirtual 116	java/io/InputStream:read	([B)I
    //   118: istore_3
    //   119: iload_3
    //   120: iconst_m1
    //   121: if_icmpeq +13 -> 134
    //   124: aload_1
    //   125: aload_2
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 122	java/io/OutputStream:write	([BII)V
    //   131: goto -18 -> 113
    //   134: aload_1
    //   135: invokevirtual 125	java/io/OutputStream:close	()V
    //   138: aload_0
    //   139: invokevirtual 126	java/io/InputStream:close	()V
    //   142: goto +8 -> 150
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   150: iconst_1
    //   151: istore 4
    //   153: goto +140 -> 293
    //   156: astore 6
    //   158: aload_0
    //   159: astore_2
    //   160: aload 6
    //   162: astore_0
    //   163: goto +28 -> 191
    //   166: goto +57 -> 223
    //   169: goto +100 -> 269
    //   172: astore 7
    //   174: aload 6
    //   176: astore_1
    //   177: aload_0
    //   178: astore_2
    //   179: aload 7
    //   181: astore_0
    //   182: goto +9 -> 191
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_2
    //   188: aload 6
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +10 -> 202
    //   195: aload_1
    //   196: invokevirtual 125	java/io/OutputStream:close	()V
    //   199: goto +3 -> 202
    //   202: aload_2
    //   203: ifnull +14 -> 217
    //   206: aload_2
    //   207: invokevirtual 126	java/io/InputStream:close	()V
    //   210: goto +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   217: aload_0
    //   218: athrow
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_2
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +10 -> 234
    //   227: aload_1
    //   228: invokevirtual 125	java/io/OutputStream:close	()V
    //   231: goto +3 -> 234
    //   234: iload 5
    //   236: istore 4
    //   238: aload_0
    //   239: ifnull +54 -> 293
    //   242: aload_0
    //   243: invokevirtual 126	java/io/InputStream:close	()V
    //   246: iload 5
    //   248: istore 4
    //   250: goto +43 -> 293
    //   253: aload_0
    //   254: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   257: iload 5
    //   259: istore 4
    //   261: goto +32 -> 293
    //   264: aconst_null
    //   265: astore_0
    //   266: aload 7
    //   268: astore_1
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 125	java/io/OutputStream:close	()V
    //   277: iload 5
    //   279: istore 4
    //   281: aload_0
    //   282: ifnull +11 -> 293
    //   285: aload_0
    //   286: invokevirtual 126	java/io/InputStream:close	()V
    //   289: iload 5
    //   291: istore 4
    //   293: iload 4
    //   295: ifne +12 -> 307
    //   298: aload 8
    //   300: invokestatic 99	com/tencent/mobileqq/intervideo/now/NowUtil:a	(Ljava/lang/String;)Z
    //   303: pop
    //   304: iload 4
    //   306: ireturn
    //   307: aload 8
    //   309: invokestatic 88	com/tencent/mobileqq/intervideo/now/NowUtil:b	()Ljava/lang/String;
    //   312: invokestatic 131	com/tencent/mobileqq/intervideo/now/NowUtil:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   315: pop
    //   316: iload 4
    //   318: ireturn
    //   319: astore_0
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_0
    //   323: goto -59 -> 264
    //   326: astore_0
    //   327: goto -108 -> 219
    //   330: astore_1
    //   331: aload 7
    //   333: astore_1
    //   334: goto -65 -> 269
    //   337: astore_1
    //   338: aload_2
    //   339: astore_1
    //   340: goto -117 -> 223
    //   343: astore_2
    //   344: goto -175 -> 169
    //   347: astore_2
    //   348: goto -182 -> 166
    //   351: astore_1
    //   352: goto -139 -> 213
    //   355: astore_0
    //   356: goto -103 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramString1	String
    //   0	359	1	paramString2	String
    //   0	359	2	paramString3	String
    //   118	10	3	i	int
    //   6	311	4	bool1	boolean
    //   9	281	5	bool2	boolean
    //   87	1	6	localObject1	Object
    //   156	33	6	localObject2	Object
    //   84	1	7	localObject3	Object
    //   172	160	7	localObject4	Object
    //   41	267	8	str	String
    // Exception table:
    //   from	to	target	type
    //   134	142	145	java/io/IOException
    //   107	113	156	finally
    //   113	119	156	finally
    //   124	131	156	finally
    //   98	107	172	finally
    //   89	98	185	finally
    //   76	81	319	java/io/IOException
    //   89	98	322	java/io/FileNotFoundException
    //   89	98	326	java/io/IOException
    //   98	107	330	java/io/FileNotFoundException
    //   98	107	337	java/io/IOException
    //   107	113	343	java/io/FileNotFoundException
    //   113	119	343	java/io/FileNotFoundException
    //   124	131	343	java/io/FileNotFoundException
    //   107	113	347	java/io/IOException
    //   113	119	347	java/io/IOException
    //   124	131	347	java/io/IOException
    //   195	199	351	java/io/IOException
    //   206	210	351	java/io/IOException
    //   227	231	355	java/io/IOException
    //   242	246	355	java/io/IOException
    //   273	277	355	java/io/IOException
    //   285	289	355	java/io/IOException
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("now_download_common.apk");
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString != null) && (!"".equalsIgnoreCase(paramString))) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (!b(paramString1)) {
      return false;
    }
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  private static void c(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (!paramString.getParentFile().exists()) {
        c(paramString.getParent());
      }
      paramString.mkdir();
    }
  }
  
  public static boolean c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/now/h5testEnv");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static String d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/now/");
    localObject = ((StringBuilder)localObject).toString();
    c((String)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowUtil
 * JD-Core Version:    0.7.0.1
 */