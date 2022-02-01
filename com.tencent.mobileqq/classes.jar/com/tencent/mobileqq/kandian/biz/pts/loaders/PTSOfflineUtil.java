package com.tencent.mobileqq.kandian.biz.pts.loaders;

import android.text.TextUtils;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSOfflineUtil
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 17	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 20
    //   11: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 26
    //   23: iconst_1
    //   24: aload_1
    //   25: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +6 -> 41
    //   38: ldc 44
    //   40: areturn
    //   41: new 46	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 4
    //   51: aconst_null
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload 4
    //   61: invokevirtual 53	java/io/File:exists	()Z
    //   64: ifne +16 -> 80
    //   67: aload_1
    //   68: astore_0
    //   69: ldc 26
    //   71: iconst_1
    //   72: ldc 55
    //   74: invokestatic 36	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: ldc 44
    //   79: areturn
    //   80: aload_1
    //   81: astore_0
    //   82: new 57	java/io/FileInputStream
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 66	java/io/InputStream:available	()I
    //   96: newarray byte
    //   98: astore_0
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 70	java/io/InputStream:read	([B)I
    //   104: pop
    //   105: new 72	java/lang/String
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 75	java/lang/String:<init>	([B)V
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 78	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_1
    //   121: new 17	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   128: astore_2
    //   129: aload_2
    //   130: ldc 80
    //   132: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 26
    //   144: iconst_1
    //   145: aload_2
    //   146: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: areturn
    //   154: astore_2
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: goto +170 -> 329
    //   162: astore_2
    //   163: goto +16 -> 179
    //   166: astore_2
    //   167: goto +77 -> 244
    //   170: astore_1
    //   171: goto +158 -> 329
    //   174: astore_0
    //   175: aload_2
    //   176: astore_1
    //   177: aload_0
    //   178: astore_2
    //   179: aload_1
    //   180: astore_0
    //   181: new 17	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   188: astore_3
    //   189: aload_1
    //   190: astore_0
    //   191: aload_3
    //   192: ldc 88
    //   194: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: astore_0
    //   200: aload_3
    //   201: aload_2
    //   202: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: astore_0
    //   208: ldc 26
    //   210: iconst_1
    //   211: aload_3
    //   212: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_1
    //   219: ifnull +107 -> 326
    //   222: aload_1
    //   223: invokevirtual 78	java/io/InputStream:close	()V
    //   226: ldc 44
    //   228: areturn
    //   229: astore_1
    //   230: new 17	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   237: astore_0
    //   238: goto +65 -> 303
    //   241: astore_2
    //   242: aload_3
    //   243: astore_1
    //   244: aload_1
    //   245: astore_0
    //   246: new 17	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   253: astore_3
    //   254: aload_1
    //   255: astore_0
    //   256: aload_3
    //   257: ldc 80
    //   259: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: astore_0
    //   265: aload_3
    //   266: aload_2
    //   267: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_1
    //   272: astore_0
    //   273: ldc 26
    //   275: iconst_1
    //   276: aload_3
    //   277: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_1
    //   284: ifnull +42 -> 326
    //   287: aload_1
    //   288: invokevirtual 78	java/io/InputStream:close	()V
    //   291: ldc 44
    //   293: areturn
    //   294: astore_1
    //   295: new 17	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   302: astore_0
    //   303: aload_0
    //   304: ldc 80
    //   306: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_0
    //   311: aload_1
    //   312: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 26
    //   318: iconst_1
    //   319: aload_0
    //   320: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: ldc 44
    //   328: areturn
    //   329: aload_0
    //   330: ifnull +42 -> 372
    //   333: aload_0
    //   334: invokevirtual 78	java/io/InputStream:close	()V
    //   337: goto +35 -> 372
    //   340: astore_0
    //   341: new 17	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   348: astore_2
    //   349: aload_2
    //   350: ldc 80
    //   352: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_2
    //   357: aload_0
    //   358: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: ldc 26
    //   364: iconst_1
    //   365: aload_2
    //   366: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_1
    //   373: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString	String
    //   7	108	1	localObject1	Object
    //   120	36	1	localIOException1	java.io.IOException
    //   158	1	1	localObject2	Object
    //   170	1	1	localObject3	Object
    //   176	47	1	localObject4	Object
    //   229	1	1	localIOException2	java.io.IOException
    //   243	45	1	localObject5	Object
    //   294	79	1	localIOException3	java.io.IOException
    //   52	94	2	localStringBuilder1	StringBuilder
    //   154	4	2	localObject6	Object
    //   162	1	2	localThrowable	Throwable
    //   166	10	2	localIOException4	java.io.IOException
    //   178	24	2	str	String
    //   241	26	2	localIOException5	java.io.IOException
    //   348	18	2	localStringBuilder2	StringBuilder
    //   54	223	3	localStringBuilder3	StringBuilder
    //   49	38	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   114	118	120	java/io/IOException
    //   92	114	154	finally
    //   92	114	162	java/lang/Throwable
    //   92	114	166	java/io/IOException
    //   59	67	170	finally
    //   69	77	170	finally
    //   82	92	170	finally
    //   181	189	170	finally
    //   191	198	170	finally
    //   200	206	170	finally
    //   208	218	170	finally
    //   246	254	170	finally
    //   256	263	170	finally
    //   265	271	170	finally
    //   273	283	170	finally
    //   59	67	174	java/lang/Throwable
    //   69	77	174	java/lang/Throwable
    //   82	92	174	java/lang/Throwable
    //   222	226	229	java/io/IOException
    //   59	67	241	java/io/IOException
    //   69	77	241	java/io/IOException
    //   82	92	241	java/io/IOException
    //   287	291	294	java/io/IOException
    //   333	337	340	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    try
    {
      bool = OfflineSecurity.a(paramString1, paramString2);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[checkOfflineDirIsValid], t = ");
      localStringBuilder2.append(localThrowable);
      QLog.i("PTSOfflineUtil", 1, localStringBuilder2.toString());
      bool = false;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[checkOfflineDirIsValid], res = ");
    localStringBuilder1.append(bool);
    localStringBuilder1.append(", bid = ");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(", dir = ");
    localStringBuilder1.append(paramString1);
    QLog.i("PTSOfflineUtil", 1, localStringBuilder1.toString());
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = a(paramString);
      StringBuilder localStringBuilder2;
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[checkOfflineVersionIsValid], configStr = ");
        localStringBuilder2.append((String)localObject);
        QLog.d("PTSOfflineUtil", 1, localStringBuilder2.toString());
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        bool = OfflineUtils.a(((JSONObject)localObject).optString("min_version", null), ((JSONObject)localObject).optString("max_version", null), ((JSONObject)localObject).optString("min_android_build", null), ((JSONObject)localObject).optString("max_android_build", null));
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[checkOfflineVersionIsValid], t = ");
        localStringBuilder2.append(localThrowable);
        QLog.i("PTSOfflineUtil", 1, localStringBuilder2.toString());
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[checkOfflineVersionIsValid], e = ");
        localStringBuilder2.append(localJSONException);
        QLog.i("PTSOfflineUtil", 1, localStringBuilder2.toString());
      }
    }
    else
    {
      bool = false;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[checkOfflineVersionIsValid], res = ");
    localStringBuilder1.append(bool);
    localStringBuilder1.append(", configPath = ");
    localStringBuilder1.append(paramString);
    QLog.i("PTSOfflineUtil", 1, localStringBuilder1.toString());
    return bool;
  }
  
  public static String c(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject4 = "no version";
    Object localObject1 = localObject4;
    Object localObject3;
    if (!bool)
    {
      localObject1 = a(paramString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getOfflineCurrentVersion], configStr = ");
        localStringBuilder.append((String)localObject1);
        QLog.d("PTSOfflineUtil", 1, localStringBuilder.toString());
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("pts_version", "no version");
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getOfflineCurrentVersion], t = ");
        localStringBuilder.append(localThrowable);
        QLog.i("PTSOfflineUtil", 1, localStringBuilder.toString());
        Object localObject2 = localObject4;
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getOfflineCurrentVersion], e = ");
        localStringBuilder.append(localJSONException);
        QLog.i("PTSOfflineUtil", 1, localStringBuilder.toString());
        localObject3 = localObject4;
      }
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("[getOfflineCurrentVersion], res = ");
    ((StringBuilder)localObject4).append(localObject3);
    ((StringBuilder)localObject4).append(", configPath = ");
    ((StringBuilder)localObject4).append(paramString);
    QLog.i("PTSOfflineUtil", 1, ((StringBuilder)localObject4).toString());
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSOfflineUtil
 * JD-Core Version:    0.7.0.1
 */