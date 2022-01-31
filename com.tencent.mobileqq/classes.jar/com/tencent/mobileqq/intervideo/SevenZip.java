package com.tencent.mobileqq.intervideo;

import android.content.Context;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;

public class SevenZip
{
  public static int a;
  public static String a;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = true;
    if (!a(paramString1, paramString2, "lib/armeabi", "7z"))
    {
      QLog.i("XProxy", 1, "从apk中解压.7z文件出现异常");
      jdField_a_of_type_Int = 5001;
      return false;
    }
    int i = LzmaUtils.a(paramContext, paramString2 + "lib/armeabi/armeabi.7z", paramString2);
    QLog.i("XProxy", 1, "unZipSoFile res = " + i);
    jdField_a_of_type_Int = i;
    if (i == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 59
    //   3: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifeq +278 -> 284
    //   9: aload_1
    //   10: astore 6
    //   12: sipush 8192
    //   15: newarray byte
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 5
    //   25: aload 7
    //   27: astore_1
    //   28: new 67	com/tencent/commonsdk/zip/QZipFile
    //   31: dup
    //   32: new 69	java/io/File
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 75	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   43: astore 9
    //   45: aload 7
    //   47: astore_1
    //   48: aload 9
    //   50: invokevirtual 79	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 7
    //   55: aload 5
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload 7
    //   62: invokeinterface 85 1 0
    //   67: ifeq +252 -> 319
    //   70: aload_0
    //   71: astore_1
    //   72: aload 7
    //   74: invokeinterface 89 1 0
    //   79: checkcast 91	java/util/zip/ZipEntry
    //   82: astore 10
    //   84: aload_2
    //   85: ifnull +17 -> 102
    //   88: aload_0
    //   89: astore_1
    //   90: aload 10
    //   92: invokevirtual 94	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: aload_2
    //   96: invokevirtual 97	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifeq -41 -> 58
    //   102: aload_3
    //   103: ifnull +17 -> 120
    //   106: aload_0
    //   107: astore_1
    //   108: aload 10
    //   110: invokevirtual 94	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   113: aload_3
    //   114: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   117: ifeq -59 -> 58
    //   120: aload_0
    //   121: astore_1
    //   122: new 69	java/io/File
    //   125: dup
    //   126: new 34	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   133: aload 6
    //   135: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 10
    //   140: invokevirtual 94	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   143: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore 5
    //   154: aload_0
    //   155: astore_1
    //   156: aload 5
    //   158: invokevirtual 101	java/io/File:getParentFile	()Ljava/io/File;
    //   161: invokevirtual 104	java/io/File:exists	()Z
    //   164: ifne +14 -> 178
    //   167: aload_0
    //   168: astore_1
    //   169: aload 5
    //   171: invokevirtual 101	java/io/File:getParentFile	()Ljava/io/File;
    //   174: invokevirtual 107	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: aload_0
    //   179: astore_1
    //   180: new 109	java/io/FileOutputStream
    //   183: dup
    //   184: aload 5
    //   186: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   189: astore 5
    //   191: aload 9
    //   193: aload 10
    //   195: invokevirtual 114	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   198: astore_0
    //   199: aload_0
    //   200: aload 8
    //   202: invokevirtual 120	java/io/InputStream:read	([B)I
    //   205: istore 4
    //   207: iload 4
    //   209: ifle +99 -> 308
    //   212: aload 5
    //   214: aload 8
    //   216: iconst_0
    //   217: iload 4
    //   219: invokevirtual 126	java/io/OutputStream:write	([BII)V
    //   222: goto -23 -> 199
    //   225: astore_1
    //   226: aload 5
    //   228: astore_0
    //   229: aload_1
    //   230: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   233: ldc 22
    //   235: iconst_1
    //   236: new 34	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   243: ldc 131
    //   245: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 134	java/io/IOException:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 30	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: sipush -1000
    //   264: putstatic 32	com/tencent/mobileqq/intervideo/SevenZip:jdField_a_of_type_Int	I
    //   267: aload_1
    //   268: invokevirtual 134	java/io/IOException:getMessage	()Ljava/lang/String;
    //   271: putstatic 136	com/tencent/mobileqq/intervideo/SevenZip:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   274: aload_0
    //   275: ifnull +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 139	java/io/OutputStream:close	()V
    //   282: iconst_0
    //   283: ireturn
    //   284: new 34	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   291: aload_1
    //   292: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 59
    //   297: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 6
    //   305: goto -293 -> 12
    //   308: aload 5
    //   310: invokevirtual 142	java/io/OutputStream:flush	()V
    //   313: aload 5
    //   315: astore_0
    //   316: goto -258 -> 58
    //   319: aload_0
    //   320: ifnull +7 -> 327
    //   323: aload_0
    //   324: invokevirtual 139	java/io/OutputStream:close	()V
    //   327: iconst_1
    //   328: ireturn
    //   329: astore_0
    //   330: aload_0
    //   331: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   334: goto -7 -> 327
    //   337: astore_0
    //   338: aload_0
    //   339: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   342: goto -60 -> 282
    //   345: astore_0
    //   346: aload_1
    //   347: ifnull +7 -> 354
    //   350: aload_1
    //   351: invokevirtual 139	java/io/OutputStream:close	()V
    //   354: aload_0
    //   355: athrow
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   361: goto -7 -> 354
    //   364: astore_0
    //   365: aload 5
    //   367: astore_1
    //   368: goto -22 -> 346
    //   371: astore_2
    //   372: aload_0
    //   373: astore_1
    //   374: aload_2
    //   375: astore_0
    //   376: goto -30 -> 346
    //   379: astore_1
    //   380: aconst_null
    //   381: astore_0
    //   382: goto -153 -> 229
    //   385: astore_1
    //   386: goto -157 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString1	String
    //   0	389	1	paramString2	String
    //   0	389	2	paramString3	String
    //   0	389	3	paramString4	String
    //   205	13	4	i	int
    //   23	343	5	localObject	Object
    //   10	294	6	str	String
    //   20	53	7	localEnumeration	java.util.Enumeration
    //   17	198	8	arrayOfByte	byte[]
    //   43	149	9	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   82	112	10	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   191	199	225	java/io/IOException
    //   199	207	225	java/io/IOException
    //   212	222	225	java/io/IOException
    //   308	313	225	java/io/IOException
    //   323	327	329	java/io/IOException
    //   278	282	337	java/io/IOException
    //   28	45	345	finally
    //   48	55	345	finally
    //   60	70	345	finally
    //   72	84	345	finally
    //   90	102	345	finally
    //   108	120	345	finally
    //   122	154	345	finally
    //   156	167	345	finally
    //   169	178	345	finally
    //   180	191	345	finally
    //   350	354	356	java/io/IOException
    //   191	199	364	finally
    //   199	207	364	finally
    //   212	222	364	finally
    //   308	313	364	finally
    //   229	274	371	finally
    //   28	45	379	java/io/IOException
    //   48	55	379	java/io/IOException
    //   60	70	385	java/io/IOException
    //   72	84	385	java/io/IOException
    //   90	102	385	java/io/IOException
    //   108	120	385	java/io/IOException
    //   122	154	385	java/io/IOException
    //   156	167	385	java/io/IOException
    //   169	178	385	java/io/IOException
    //   180	191	385	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.SevenZip
 * JD-Core Version:    0.7.0.1
 */