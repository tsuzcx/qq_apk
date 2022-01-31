package dov.com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anyb;
import anzj;
import anzk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import java.io.File;
import java.util.ArrayList;

public class PendantVersionManager
{
  private static final String[] a = { "art_res_cache", "other_res_cache" };
  private static final String[] b = { "libimage_filter_common.so", "libimage_filter_gpu.so", "libpitu_tools.so", "libimage_filter_cpu.so", "libalgo_youtu_jni.so", "libformat_convert.so" };
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).getString("pendant_sv_md5_version_soname_key", "Pendant000_0");
    boolean bool = a(str, 2);
    VideoEnvironment.a("PendantVersionManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Pendant000_0";
  }
  
  /* Error */
  private static ArrayList a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: new 92	java/util/ArrayList
    //   7: dup
    //   8: iconst_1
    //   9: invokespecial 95	java/util/ArrayList:<init>	(I)V
    //   12: astore 4
    //   14: new 97	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 100	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: new 102	java/io/BufferedReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +18 -> 56
    //   41: aload 4
    //   43: aload_1
    //   44: invokevirtual 112	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_1
    //   53: goto -16 -> 37
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 115	java/io/BufferedReader:close	()V
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 116	java/io/FileReader:close	()V
    //   72: aload 4
    //   74: areturn
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   80: goto -16 -> 64
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   88: aload 4
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_0
    //   95: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   98: ldc 63
    //   100: ldc 122
    //   102: aload_0
    //   103: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 115	java/io/BufferedReader:close	()V
    //   114: aload_1
    //   115: ifnull -43 -> 72
    //   118: aload_1
    //   119: invokevirtual 116	java/io/FileReader:close	()V
    //   122: aload 4
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   130: aload 4
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   138: goto -24 -> 114
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_2
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 115	java/io/BufferedReader:close	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 116	java/io/FileReader:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   171: goto -15 -> 156
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   179: goto -15 -> 164
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_0
    //   186: astore_1
    //   187: aload_3
    //   188: astore_0
    //   189: goto -41 -> 148
    //   192: astore_3
    //   193: aload_0
    //   194: astore_1
    //   195: aload_3
    //   196: astore_0
    //   197: goto -49 -> 148
    //   200: astore_0
    //   201: goto -53 -> 148
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_0
    //   208: astore_1
    //   209: aload_3
    //   210: astore_0
    //   211: goto -117 -> 94
    //   214: astore_3
    //   215: aload_0
    //   216: astore_1
    //   217: aload_3
    //   218: astore_0
    //   219: goto -125 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramFile	File
    //   3	50	1	str	String
    //   75	44	1	localIOException1	java.io.IOException
    //   145	16	1	localObject1	Object
    //   174	2	1	localIOException2	java.io.IOException
    //   186	31	1	localFile	File
    //   1	152	2	localObject2	Object
    //   166	2	2	localIOException3	java.io.IOException
    //   184	23	2	localObject3	Object
    //   143	4	3	localObject4	Object
    //   182	6	3	localObject5	Object
    //   192	4	3	localObject6	Object
    //   204	6	3	localException1	java.lang.Exception
    //   214	4	3	localException2	java.lang.Exception
    //   12	119	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   60	64	75	java/io/IOException
    //   68	72	83	java/io/IOException
    //   14	23	91	java/lang/Exception
    //   118	122	125	java/io/IOException
    //   110	114	133	java/io/IOException
    //   14	23	141	finally
    //   152	156	166	java/io/IOException
    //   160	164	174	java/io/IOException
    //   23	32	182	finally
    //   32	37	192	finally
    //   41	53	192	finally
    //   94	106	200	finally
    //   23	32	204	java/lang/Exception
    //   32	37	214	java/lang/Exception
    //   41	53	214	java/lang/Exception
  }
  
  private static void a()
  {
    ThreadManager.post(new anyb(), 5, null, false);
  }
  
  public static void a(boolean paramBoolean) {}
  
  public static boolean a(String paramString, int paramInt)
  {
    String str = paramString.trim();
    VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = anzj.a(str);
    int i = paramString.a();
    VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    if (i == 0)
    {
      paramString = paramString.a().trim();
      VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      if (i >= paramInt) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: invokestatic 176	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   10: invokestatic 181	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:a	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 5
    //   15: new 65	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   22: aload 5
    //   24: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 187	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 5
    //   42: new 183	java/io/File
    //   45: dup
    //   46: aload 5
    //   48: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 194	java/io/File:exists	()Z
    //   58: ifeq +67 -> 125
    //   61: invokestatic 195	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:a	()Ljava/lang/String;
    //   64: aload_0
    //   65: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +26 -> 94
    //   71: aload 5
    //   73: ldc 200
    //   75: invokestatic 202	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   78: ifeq +16 -> 94
    //   81: ldc 63
    //   83: ldc 204
    //   85: aconst_null
    //   86: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: ldc 2
    //   91: monitorexit
    //   92: iload_2
    //   93: ireturn
    //   94: aload 5
    //   96: invokestatic 208	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   99: ldc 63
    //   101: new 65	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   108: ldc 210
    //   110: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload 6
    //   127: invokevirtual 213	java/io/File:mkdirs	()Z
    //   130: istore_2
    //   131: ldc 63
    //   133: new 65	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   140: ldc 215
    //   142: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_2
    //   146: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aconst_null
    //   153: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload_1
    //   157: aload 5
    //   159: iconst_0
    //   160: invokestatic 218	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   163: aload 5
    //   165: ldc 200
    //   167: invokestatic 202	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   170: istore_2
    //   171: ldc 63
    //   173: new 65	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   180: ldc 220
    //   182: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_2
    //   186: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   189: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aconst_null
    //   193: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: iload_2
    //   197: ifeq +147 -> 344
    //   200: aload_0
    //   201: invokestatic 222	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:b	(Ljava/lang/String;)Z
    //   204: istore 4
    //   206: ldc 63
    //   208: new 65	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   215: ldc 224
    //   217: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload 4
    //   222: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   225: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aconst_null
    //   229: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: iload_3
    //   233: istore_2
    //   234: iload 4
    //   236: ifne +92 -> 328
    //   239: aload_0
    //   240: invokestatic 222	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:b	(Ljava/lang/String;)Z
    //   243: istore 4
    //   245: ldc 63
    //   247: new 65	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   254: ldc 226
    //   256: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload 4
    //   261: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   264: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: aconst_null
    //   268: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: iload_3
    //   272: istore_2
    //   273: iload 4
    //   275: ifne +53 -> 328
    //   278: ldc 63
    //   280: ldc 228
    //   282: aconst_null
    //   283: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   286: ldc 52
    //   288: invokestatic 222	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:b	(Ljava/lang/String;)Z
    //   291: istore_2
    //   292: ldc 63
    //   294: new 65	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   301: ldc 230
    //   303: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload_2
    //   307: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: ldc 232
    //   312: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: aconst_null
    //   323: invokestatic 85	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: iconst_1
    //   327: istore_2
    //   328: invokestatic 234	dov/com/tencent/mobileqq/shortvideo/PendantVersionManager:a	()V
    //   331: goto -242 -> 89
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   339: iconst_1
    //   340: istore_2
    //   341: goto -252 -> 89
    //   344: iconst_1
    //   345: istore_2
    //   346: goto -257 -> 89
    //   349: astore_0
    //   350: ldc 2
    //   352: monitorexit
    //   353: aload_0
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramString1	String
    //   0	355	1	paramString2	String
    //   3	343	2	bool1	boolean
    //   1	271	3	bool2	boolean
    //   204	70	4	bool3	boolean
    //   13	151	5	str	String
    //   51	75	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   156	196	334	java/lang/Exception
    //   200	232	334	java/lang/Exception
    //   239	271	334	java/lang/Exception
    //   278	326	334	java/lang/Exception
    //   328	331	334	java/lang/Exception
    //   7	89	349	finally
    //   94	125	349	finally
    //   125	156	349	finally
    //   156	196	349	finally
    //   200	232	349	finally
    //   239	271	349	finally
    //   278	326	349	finally
    //   328	331	349	finally
    //   335	339	349	finally
  }
  
  private static boolean b(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).edit();
    localEditor.putString("pendant_sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.a("PendantVersionManager", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + paramString2, null);
    Object localObject = new File(paramString2);
    if (!((File)localObject).exists())
    {
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + paramString2 + ",exists=false", null);
      return false;
    }
    paramString2 = a((File)localObject);
    if (paramString2.size() <= 0)
    {
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK configData.size()=" + paramString2.size(), null);
      return false;
    }
    int i = 0;
    if (i < paramString2.size())
    {
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK itemLineValue=" + (String)paramString2.get(i), null);
      if (TextUtils.isEmpty((CharSequence)paramString2.get(i))) {}
      String str;
      int j;
      long l;
      do
      {
        do
        {
          i += 1;
          break;
          str = ((String)paramString2.get(i)).trim();
        } while (TextUtils.isEmpty(str));
        VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK trimValue=" + str, null);
        localObject = anzj.a(str);
        j = ((anzk)localObject).a('|');
        if (j != 0) {
          break label405;
        }
        str = paramString1 + ((anzk)localObject).b();
        File localFile = new File(str);
        if (!localFile.exists())
        {
          VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK[exists=false] fileName=" + str, null);
          return false;
        }
        j = Integer.parseInt(((anzk)localObject).c());
        l = localFile.length();
      } while (j == l);
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK sizeConfig=" + j + ",fileSize=" + l, null);
      return false;
      label405:
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK[CfgParser] errCode=" + j + ",trimValue=" + str, null);
      return false;
    }
    VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK[OK]", null);
    return true;
  }
  
  private static boolean c(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < a.length)
      {
        if (paramString.equals(a[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    if (!PtvFilterSoLoad.a(paramString1))
    {
      VideoEnvironment.a("PendantVersionManager", "checkUnzipFileListSizeIsOK[isFilterSoExist] exists=false", null);
      return false;
    }
    return b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PendantVersionManager
 * JD-Core Version:    0.7.0.1
 */