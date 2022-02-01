import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class qmz
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_1
    //   3: new 14	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   10: ldc 20
    //   12: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +8 -> 37
    //   32: ldc 42
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: new 44	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_1
    //   54: astore_0
    //   55: aload 4
    //   57: invokevirtual 51	java/io/File:exists	()Z
    //   60: ifne +57 -> 117
    //   63: aload_1
    //   64: astore_0
    //   65: ldc 12
    //   67: iconst_1
    //   68: ldc 53
    //   70: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: ldc 42
    //   75: astore_0
    //   76: iconst_0
    //   77: ifeq -42 -> 35
    //   80: new 55	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 56	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: astore_0
    //   89: ldc 12
    //   91: iconst_1
    //   92: new 14	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   99: ldc 58
    //   101: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: ldc 42
    //   116: areturn
    //   117: aload_1
    //   118: astore_0
    //   119: new 66	java/io/FileInputStream
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 75	java/io/InputStream:available	()I
    //   133: newarray byte
    //   135: astore_0
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 79	java/io/InputStream:read	([B)I
    //   141: pop
    //   142: new 81	java/lang/String
    //   145: dup
    //   146: aload_0
    //   147: invokespecial 84	java/lang/String:<init>	([B)V
    //   150: astore_2
    //   151: aload_2
    //   152: astore_0
    //   153: aload_1
    //   154: ifnull -119 -> 35
    //   157: aload_1
    //   158: invokevirtual 87	java/io/InputStream:close	()V
    //   161: aload_2
    //   162: areturn
    //   163: astore_0
    //   164: ldc 12
    //   166: iconst_1
    //   167: new 14	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   174: ldc 58
    //   176: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_2
    //   190: areturn
    //   191: astore_0
    //   192: aload_2
    //   193: astore_1
    //   194: aload_0
    //   195: astore_2
    //   196: aload_1
    //   197: astore_0
    //   198: ldc 12
    //   200: iconst_1
    //   201: new 14	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   208: ldc 58
    //   210: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 87	java/io/InputStream:close	()V
    //   231: ldc 42
    //   233: areturn
    //   234: astore_0
    //   235: ldc 12
    //   237: iconst_1
    //   238: new 14	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   245: ldc 58
    //   247: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: goto -29 -> 231
    //   263: astore_2
    //   264: aload_3
    //   265: astore_1
    //   266: aload_1
    //   267: astore_0
    //   268: ldc 12
    //   270: iconst_1
    //   271: new 14	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   278: ldc 89
    //   280: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_2
    //   284: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_1
    //   294: ifnull -63 -> 231
    //   297: aload_1
    //   298: invokevirtual 87	java/io/InputStream:close	()V
    //   301: goto -70 -> 231
    //   304: astore_0
    //   305: ldc 12
    //   307: iconst_1
    //   308: new 14	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   315: ldc 58
    //   317: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_0
    //   321: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto -99 -> 231
    //   333: astore_2
    //   334: aload_0
    //   335: astore_1
    //   336: aload_2
    //   337: astore_0
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 87	java/io/InputStream:close	()V
    //   346: aload_0
    //   347: athrow
    //   348: astore_1
    //   349: ldc 12
    //   351: iconst_1
    //   352: new 14	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   359: ldc 58
    //   361: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_1
    //   365: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: goto -28 -> 346
    //   377: astore_0
    //   378: goto -40 -> 338
    //   381: astore_2
    //   382: goto -116 -> 266
    //   385: astore_2
    //   386: goto -190 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString	String
    //   50	293	1	localObject1	Object
    //   348	17	1	localIOException1	java.io.IOException
    //   52	162	2	str	String
    //   263	21	2	localThrowable1	Throwable
    //   333	4	2	localObject2	Object
    //   381	1	2	localThrowable2	Throwable
    //   385	1	2	localIOException2	java.io.IOException
    //   48	217	3	localObject3	Object
    //   45	79	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   80	88	88	java/io/IOException
    //   157	161	163	java/io/IOException
    //   55	63	191	java/io/IOException
    //   65	73	191	java/io/IOException
    //   119	129	191	java/io/IOException
    //   227	231	234	java/io/IOException
    //   55	63	263	java/lang/Throwable
    //   65	73	263	java/lang/Throwable
    //   119	129	263	java/lang/Throwable
    //   297	301	304	java/io/IOException
    //   55	63	333	finally
    //   65	73	333	finally
    //   119	129	333	finally
    //   198	223	333	finally
    //   268	293	333	finally
    //   342	346	348	java/io/IOException
    //   129	151	377	finally
    //   129	151	381	java/lang/Throwable
    //   129	151	385	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], configStr = " + (String)localObject);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      bool1 = szr.a(((JSONObject)localObject).optString("min_version", null), ((JSONObject)localObject).optString("max_version", null), ((JSONObject)localObject).optString("min_android_build", null), ((JSONObject)localObject).optString("max_android_build", null));
      QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], res = " + bool1 + ", configPath = " + paramString);
      return bool1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], e = " + localJSONException);
        bool1 = bool2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], t = " + localThrowable);
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = npi.a(paramString1, paramString2);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], t = " + localThrowable);
      }
    }
    QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], res = " + bool1 + ", bid = " + paramString2 + ", dir = " + paramString1);
    return bool1;
  }
  
  public static String b(String paramString)
  {
    String str4 = "no version";
    String str1 = str4;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], configStr = " + str1);
      }
    }
    try
    {
      str1 = new JSONObject(str1).optString("pts_version", "no version");
      QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], res = " + str1 + ", configPath = " + paramString);
      return str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], e = " + localJSONException);
        String str2 = str4;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], t = " + localThrowable);
        String str3 = str4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmz
 * JD-Core Version:    0.7.0.1
 */