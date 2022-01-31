package com.tencent.mobileqq.utils;

import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MusicCacheManager
{
  private static long jdField_a_of_type_Long = 157286400L;
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/qqmusic/";
  
  public static void a()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isFile()) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static void a(File paramFile)
  {
    // Byte code:
    //   0: new 65	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 67
    //   7: invokespecial 70	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: aload_2
    //   14: invokevirtual 74	java/io/RandomAccessFile:readByte	()B
    //   17: istore_1
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: lconst_0
    //   22: invokevirtual 78	java/io/RandomAccessFile:seek	(J)V
    //   25: aload_2
    //   26: astore_0
    //   27: aload_2
    //   28: iload_1
    //   29: invokevirtual 82	java/io/RandomAccessFile:write	(I)V
    //   32: aload_2
    //   33: ifnull +7 -> 40
    //   36: aload_2
    //   37: invokevirtual 85	java/io/RandomAccessFile:close	()V
    //   40: return
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: aload_3
    //   47: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   50: aload_2
    //   51: ifnull -11 -> 40
    //   54: aload_2
    //   55: invokevirtual 85	java/io/RandomAccessFile:close	()V
    //   58: return
    //   59: astore_0
    //   60: return
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 85	java/io/RandomAccessFile:close	()V
    //   72: aload_2
    //   73: athrow
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: goto -5 -> 72
    //   80: astore_2
    //   81: goto -17 -> 64
    //   84: astore_3
    //   85: goto -41 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	File
    //   17	12	1	i	int
    //   10	45	2	localRandomAccessFile	java.io.RandomAccessFile
    //   61	12	2	localObject1	Object
    //   80	1	2	localObject2	Object
    //   41	6	3	localIOException1	java.io.IOException
    //   84	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	11	41	java/io/IOException
    //   54	58	59	java/io/IOException
    //   0	11	61	finally
    //   36	40	74	java/io/IOException
    //   68	72	76	java/io/IOException
    //   13	18	80	finally
    //   20	25	80	finally
    //   27	32	80	finally
    //   46	50	80	finally
    //   13	18	84	java/io/IOException
    //   20	25	84	java/io/IOException
    //   27	32	84	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    paramString = new File(jdField_a_of_type_JavaLangString + paramString + ".cfg");
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "delCfgFile");
    }
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 22	java/io/File
    //   5: dup
    //   6: getstatic 37	com/tencent/mobileqq/utils/MusicCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 50	java/io/File:exists	()Z
    //   19: ifne +9 -> 28
    //   22: aload 4
    //   24: invokevirtual 111	java/io/File:mkdir	()Z
    //   27: pop
    //   28: new 22	java/io/File
    //   31: dup
    //   32: new 11	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   39: getstatic 37	com/tencent/mobileqq/utils/MusicCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 90
    //   51: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 50	java/io/File:exists	()Z
    //   65: ifne +8 -> 73
    //   68: aload_0
    //   69: invokevirtual 114	java/io/File:createNewFile	()Z
    //   72: pop
    //   73: new 116	java/io/FileOutputStream
    //   76: dup
    //   77: aload_0
    //   78: iconst_0
    //   79: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   82: astore_0
    //   83: aload_0
    //   84: astore_3
    //   85: new 11	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   92: ldc 121
    //   94: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_1
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 126
    //   103: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 4
    //   115: aload_0
    //   116: astore_3
    //   117: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +31 -> 151
    //   123: aload_0
    //   124: astore_3
    //   125: ldc 97
    //   127: iconst_2
    //   128: new 11	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   135: ldc 128
    //   137: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: astore_3
    //   153: aload_0
    //   154: aload 4
    //   156: invokevirtual 134	java/lang/String:getBytes	()[B
    //   159: invokevirtual 137	java/io/FileOutputStream:write	([B)V
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   170: return
    //   171: astore_0
    //   172: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -5 -> 170
    //   178: ldc 97
    //   180: iconst_2
    //   181: new 11	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   188: ldc 140
    //   190: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: aload_0
    //   204: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: return
    //   208: astore 4
    //   210: aload_3
    //   211: astore_0
    //   212: aload 4
    //   214: astore_3
    //   215: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +32 -> 250
    //   221: ldc 97
    //   223: iconst_2
    //   224: new 11	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   231: ldc 148
    //   233: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_3
    //   237: invokevirtual 149	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: aload_3
    //   247: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_0
    //   251: ifnull -81 -> 170
    //   254: aload_0
    //   255: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   258: return
    //   259: astore_0
    //   260: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -93 -> 170
    //   266: ldc 97
    //   268: iconst_2
    //   269: new 11	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   276: ldc 140
    //   278: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: aload_0
    //   292: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: return
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_0
    //   300: aload_0
    //   301: astore_3
    //   302: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +36 -> 341
    //   308: aload_0
    //   309: astore_3
    //   310: ldc 97
    //   312: iconst_2
    //   313: new 11	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   320: ldc 140
    //   322: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 4
    //   327: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload 4
    //   338: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: aload_0
    //   342: ifnull -172 -> 170
    //   345: aload_0
    //   346: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   349: return
    //   350: astore_0
    //   351: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq -184 -> 170
    //   357: ldc 97
    //   359: iconst_2
    //   360: new 11	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   367: ldc 140
    //   369: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   376: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aload_0
    //   383: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   386: return
    //   387: astore_0
    //   388: aconst_null
    //   389: astore_3
    //   390: aload_3
    //   391: ifnull +7 -> 398
    //   394: aload_3
    //   395: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   398: aload_0
    //   399: athrow
    //   400: astore_3
    //   401: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq -6 -> 398
    //   407: ldc 97
    //   409: iconst_2
    //   410: new 11	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   417: ldc 140
    //   419: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_3
    //   423: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: aload_3
    //   433: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   436: goto -38 -> 398
    //   439: astore_0
    //   440: goto -50 -> 390
    //   443: astore 4
    //   445: aload_0
    //   446: astore_3
    //   447: aload 4
    //   449: astore_0
    //   450: goto -60 -> 390
    //   453: astore 4
    //   455: goto -155 -> 300
    //   458: astore_3
    //   459: goto -244 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramString	String
    //   0	462	1	paramInt1	int
    //   0	462	2	paramInt2	int
    //   1	394	3	localObject1	Object
    //   400	33	3	localException	Exception
    //   446	1	3	str	String
    //   458	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   12	143	4	localObject2	Object
    //   208	5	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   296	41	4	localIOException1	java.io.IOException
    //   443	5	4	localObject3	Object
    //   453	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   166	170	171	java/lang/Exception
    //   2	28	208	java/io/FileNotFoundException
    //   28	73	208	java/io/FileNotFoundException
    //   73	83	208	java/io/FileNotFoundException
    //   254	258	259	java/lang/Exception
    //   2	28	296	java/io/IOException
    //   28	73	296	java/io/IOException
    //   73	83	296	java/io/IOException
    //   345	349	350	java/lang/Exception
    //   2	28	387	finally
    //   28	73	387	finally
    //   73	83	387	finally
    //   394	398	400	java/lang/Exception
    //   85	115	439	finally
    //   117	123	439	finally
    //   125	151	439	finally
    //   153	162	439	finally
    //   302	308	439	finally
    //   310	341	439	finally
    //   215	250	443	finally
    //   85	115	453	java/io/IOException
    //   117	123	453	java/io/IOException
    //   125	151	453	java/io/IOException
    //   153	162	453	java/io/IOException
    //   85	115	458	java/io/FileNotFoundException
    //   117	123	458	java/io/FileNotFoundException
    //   125	151	458	java/io/FileNotFoundException
    //   153	162	458	java/io/FileNotFoundException
  }
  
  private static boolean a(File paramFile)
  {
    if (!paramFile.getName().endsWith(".cfg")) {
      new File(paramFile.getAbsolutePath() + ".cfg").delete();
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 22	java/io/File
    //   6: dup
    //   7: new 11	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   14: getstatic 37	com/tencent/mobileqq/utils/MusicCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 90
    //   26: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 8
    //   37: aload 8
    //   39: invokevirtual 50	java/io/File:exists	()Z
    //   42: ifne +5 -> 47
    //   45: iconst_1
    //   46: ireturn
    //   47: new 161	java/io/FileInputStream
    //   50: dup
    //   51: aload 8
    //   53: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_0
    //   57: sipush 4096
    //   60: newarray byte
    //   62: astore 7
    //   64: new 165	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 166	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: astore 6
    //   77: aload_0
    //   78: astore 5
    //   80: aload_0
    //   81: aload 7
    //   83: invokevirtual 170	java/io/FileInputStream:read	([B)I
    //   86: istore_2
    //   87: iload_2
    //   88: iconst_m1
    //   89: if_icmpeq +88 -> 177
    //   92: aload 4
    //   94: astore 6
    //   96: aload_0
    //   97: astore 5
    //   99: aload 4
    //   101: aload 7
    //   103: iconst_0
    //   104: iload_2
    //   105: invokevirtual 173	java/io/ByteArrayOutputStream:write	([BII)V
    //   108: goto -35 -> 73
    //   111: astore 5
    //   113: aload_0
    //   114: astore_1
    //   115: aload 4
    //   117: astore_0
    //   118: aload 5
    //   120: astore 4
    //   122: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +34 -> 159
    //   128: ldc 97
    //   130: iconst_2
    //   131: new 11	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   138: ldc 175
    //   140: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 149	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload 4
    //   156: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 177	java/io/FileInputStream:close	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: aload 4
    //   179: astore 6
    //   181: aload_0
    //   182: astore 5
    //   184: aload 4
    //   186: invokevirtual 178	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   189: ldc 180
    //   191: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   194: astore 7
    //   196: aload 7
    //   198: ifnull +17 -> 215
    //   201: aload 4
    //   203: astore 6
    //   205: aload_0
    //   206: astore 5
    //   208: aload 7
    //   210: arraylength
    //   211: iconst_4
    //   212: if_icmpge +137 -> 349
    //   215: aload 4
    //   217: astore 6
    //   219: aload_0
    //   220: astore 5
    //   222: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +18 -> 243
    //   228: aload 4
    //   230: astore 6
    //   232: aload_0
    //   233: astore 5
    //   235: ldc 97
    //   237: iconst_2
    //   238: ldc 186
    //   240: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_1
    //   244: iconst_0
    //   245: iconst_0
    //   246: iastore
    //   247: aload_1
    //   248: iconst_1
    //   249: iconst_0
    //   250: iastore
    //   251: aload 4
    //   253: ifnull +8 -> 261
    //   256: aload 4
    //   258: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 177	java/io/FileInputStream:close	()V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_1
    //   272: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq -14 -> 261
    //   278: ldc 97
    //   280: iconst_2
    //   281: new 11	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   288: ldc 188
    //   290: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aload_1
    //   304: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -46 -> 261
    //   310: astore_0
    //   311: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq -45 -> 269
    //   317: ldc 97
    //   319: iconst_2
    //   320: new 11	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   327: ldc 188
    //   329: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: aload_0
    //   343: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto -77 -> 269
    //   349: aload 4
    //   351: astore 6
    //   353: aload_0
    //   354: astore 5
    //   356: aload 7
    //   358: iconst_1
    //   359: aaload
    //   360: invokestatic 194	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   363: istore_2
    //   364: aload 4
    //   366: astore 6
    //   368: aload_0
    //   369: astore 5
    //   371: aload 7
    //   373: iconst_3
    //   374: aaload
    //   375: invokestatic 194	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   378: istore_3
    //   379: iload_2
    //   380: iload_3
    //   381: if_icmpne +100 -> 481
    //   384: aload 4
    //   386: ifnull +8 -> 394
    //   389: aload 4
    //   391: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   394: aload_0
    //   395: ifnull -350 -> 45
    //   398: aload_0
    //   399: invokevirtual 177	java/io/FileInputStream:close	()V
    //   402: iconst_1
    //   403: ireturn
    //   404: astore_0
    //   405: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -363 -> 45
    //   411: ldc 97
    //   413: iconst_2
    //   414: new 11	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   421: ldc 188
    //   423: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   430: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: aload_0
    //   437: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   440: iconst_1
    //   441: ireturn
    //   442: astore_1
    //   443: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq -52 -> 394
    //   449: ldc 97
    //   451: iconst_2
    //   452: new 11	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   459: ldc 188
    //   461: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_1
    //   465: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: aload_1
    //   475: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   478: goto -84 -> 394
    //   481: aload_1
    //   482: iconst_0
    //   483: iload_2
    //   484: iastore
    //   485: aload_1
    //   486: iconst_1
    //   487: iload_3
    //   488: iastore
    //   489: aload 4
    //   491: ifnull +8 -> 499
    //   494: aload 4
    //   496: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   499: aload_0
    //   500: ifnull +7 -> 507
    //   503: aload_0
    //   504: invokevirtual 177	java/io/FileInputStream:close	()V
    //   507: iconst_0
    //   508: ireturn
    //   509: astore_1
    //   510: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -14 -> 499
    //   516: ldc 97
    //   518: iconst_2
    //   519: new 11	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   526: ldc 188
    //   528: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: aload_1
    //   542: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -46 -> 499
    //   548: astore_0
    //   549: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq -45 -> 507
    //   555: ldc 97
    //   557: iconst_2
    //   558: new 11	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   565: ldc 188
    //   567: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_0
    //   571: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   574: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: aload_0
    //   581: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   584: goto -77 -> 507
    //   587: astore_0
    //   588: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq -424 -> 167
    //   594: ldc 97
    //   596: iconst_2
    //   597: new 11	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   604: ldc 188
    //   606: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload_0
    //   610: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   613: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: aload_0
    //   620: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   623: goto -456 -> 167
    //   626: astore_0
    //   627: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq -455 -> 175
    //   633: ldc 97
    //   635: iconst_2
    //   636: new 11	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   643: ldc 188
    //   645: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   652: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: aload_0
    //   659: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   662: goto -487 -> 175
    //   665: astore 7
    //   667: aconst_null
    //   668: astore_1
    //   669: aconst_null
    //   670: astore_0
    //   671: aload_1
    //   672: astore 6
    //   674: aload_0
    //   675: astore 5
    //   677: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +40 -> 720
    //   683: aload_1
    //   684: astore 6
    //   686: aload_0
    //   687: astore 5
    //   689: ldc 97
    //   691: iconst_2
    //   692: new 11	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   699: ldc 188
    //   701: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 7
    //   706: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   709: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: aload 7
    //   717: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   720: aload_1
    //   721: astore 6
    //   723: aload_0
    //   724: astore 5
    //   726: aload 8
    //   728: invokevirtual 60	java/io/File:delete	()Z
    //   731: pop
    //   732: aload_1
    //   733: ifnull +7 -> 740
    //   736: aload_1
    //   737: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   740: aload_0
    //   741: ifnull +7 -> 748
    //   744: aload_0
    //   745: invokevirtual 177	java/io/FileInputStream:close	()V
    //   748: iconst_0
    //   749: ireturn
    //   750: astore_1
    //   751: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -14 -> 740
    //   757: ldc 97
    //   759: iconst_2
    //   760: new 11	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   767: ldc 188
    //   769: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload_1
    //   773: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   776: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: aload_1
    //   783: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   786: goto -46 -> 740
    //   789: astore_0
    //   790: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq -45 -> 748
    //   796: ldc 97
    //   798: iconst_2
    //   799: new 11	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   806: ldc 188
    //   808: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload_0
    //   812: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   815: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: aload_0
    //   822: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   825: goto -77 -> 748
    //   828: astore_1
    //   829: aconst_null
    //   830: astore 4
    //   832: aconst_null
    //   833: astore_0
    //   834: aload 4
    //   836: ifnull +8 -> 844
    //   839: aload 4
    //   841: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   844: aload_0
    //   845: ifnull +7 -> 852
    //   848: aload_0
    //   849: invokevirtual 177	java/io/FileInputStream:close	()V
    //   852: aload_1
    //   853: athrow
    //   854: astore 4
    //   856: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   859: ifeq -15 -> 844
    //   862: ldc 97
    //   864: iconst_2
    //   865: new 11	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   872: ldc 188
    //   874: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload 4
    //   879: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   882: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: aload 4
    //   890: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   893: goto -49 -> 844
    //   896: astore_0
    //   897: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq -48 -> 852
    //   903: ldc 97
    //   905: iconst_2
    //   906: new 11	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   913: ldc 188
    //   915: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_0
    //   919: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   922: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: aload_0
    //   929: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   932: goto -80 -> 852
    //   935: astore_1
    //   936: aconst_null
    //   937: astore 4
    //   939: goto -105 -> 834
    //   942: astore_1
    //   943: aload 6
    //   945: astore 4
    //   947: aload 5
    //   949: astore_0
    //   950: goto -116 -> 834
    //   953: astore 4
    //   955: aload_1
    //   956: astore 5
    //   958: aload 4
    //   960: astore_1
    //   961: aload_0
    //   962: astore 4
    //   964: aload 5
    //   966: astore_0
    //   967: goto -133 -> 834
    //   970: astore 7
    //   972: aconst_null
    //   973: astore_1
    //   974: goto -303 -> 671
    //   977: astore 7
    //   979: aload 4
    //   981: astore_1
    //   982: goto -311 -> 671
    //   985: astore 4
    //   987: aconst_null
    //   988: astore_0
    //   989: aload 5
    //   991: astore_1
    //   992: goto -870 -> 122
    //   995: astore 4
    //   997: aconst_null
    //   998: astore 5
    //   1000: aload_0
    //   1001: astore_1
    //   1002: aload 5
    //   1004: astore_0
    //   1005: goto -883 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1008	0	paramString	String
    //   0	1008	1	paramArrayOfInt	int[]
    //   86	398	2	i	int
    //   378	110	3	j	int
    //   71	769	4	localObject1	Object
    //   854	35	4	localIOException1	java.io.IOException
    //   937	9	4	localObject2	Object
    //   953	6	4	localObject3	Object
    //   962	18	4	str1	String
    //   985	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   995	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	97	5	str2	String
    //   111	8	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   182	821	5	localObject4	Object
    //   75	869	6	localObject5	Object
    //   62	310	7	localObject6	Object
    //   665	51	7	localIOException2	java.io.IOException
    //   970	1	7	localIOException3	java.io.IOException
    //   977	1	7	localIOException4	java.io.IOException
    //   35	692	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   80	87	111	java/io/FileNotFoundException
    //   99	108	111	java/io/FileNotFoundException
    //   184	196	111	java/io/FileNotFoundException
    //   208	215	111	java/io/FileNotFoundException
    //   222	228	111	java/io/FileNotFoundException
    //   235	243	111	java/io/FileNotFoundException
    //   356	364	111	java/io/FileNotFoundException
    //   371	379	111	java/io/FileNotFoundException
    //   256	261	271	java/io/IOException
    //   265	269	310	java/io/IOException
    //   398	402	404	java/io/IOException
    //   389	394	442	java/io/IOException
    //   494	499	509	java/io/IOException
    //   503	507	548	java/io/IOException
    //   163	167	587	java/io/IOException
    //   171	175	626	java/io/IOException
    //   47	57	665	java/io/IOException
    //   736	740	750	java/io/IOException
    //   744	748	789	java/io/IOException
    //   47	57	828	finally
    //   839	844	854	java/io/IOException
    //   848	852	896	java/io/IOException
    //   57	73	935	finally
    //   80	87	942	finally
    //   99	108	942	finally
    //   184	196	942	finally
    //   208	215	942	finally
    //   222	228	942	finally
    //   235	243	942	finally
    //   356	364	942	finally
    //   371	379	942	finally
    //   677	683	942	finally
    //   689	720	942	finally
    //   726	732	942	finally
    //   122	159	953	finally
    //   57	73	970	java/io/IOException
    //   80	87	977	java/io/IOException
    //   99	108	977	java/io/IOException
    //   184	196	977	java/io/IOException
    //   208	215	977	java/io/IOException
    //   222	228	977	java/io/IOException
    //   235	243	977	java/io/IOException
    //   356	364	977	java/io/IOException
    //   371	379	977	java/io/IOException
    //   47	57	985	java/io/FileNotFoundException
    //   57	73	995	java/io/FileNotFoundException
  }
  
  public static void b()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(5, -15);
    ((Calendar)localObject2).set(11, 0);
    ((Calendar)localObject2).set(12, 0);
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l3 = ((Calendar)localObject2).getTimeInMillis();
    if (((File)localObject1).exists())
    {
      localObject2 = ((File)localObject1).listFiles();
      if (localObject2 != null) {}
    }
    else
    {
      return;
      break label182;
    }
    label84:
    localObject1 = new TreeMap();
    int j = localObject2.length;
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      File localFile;
      long l2;
      if (i < j)
      {
        localFile = localObject2[i];
        l2 = l1;
        if (!localFile.isFile()) {}
      }
      else
      {
        try
        {
          if (localFile.lastModified() < l3)
          {
            a(localFile);
            l2 = l1;
          }
          else
          {
            ((TreeMap)localObject1).put(Long.valueOf(localFile.lastModified()), localFile);
            l2 = localFile.length();
            l2 = l1 + l2;
          }
        }
        catch (Exception localException)
        {
          label182:
          l2 = l1;
        }
        l2 = l1;
        if (l2 <= jdField_a_of_type_Long) {
          break label84;
        }
        localObject2 = ((TreeMap)localObject1).entrySet().iterator();
        l1 = l2;
        l2 = l1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFile = (File)((Map.Entry)((Iterator)localObject2).next()).getValue();
        l2 = localFile.length();
        if (a(localFile)) {
          l1 -= l2;
        }
        for (;;)
        {
          break;
        }
      }
      i += 1;
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MusicCacheManager
 * JD-Core Version:    0.7.0.1
 */