package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;

public class UploadPhotoTask
{
  private static final String S_UPLOAD_HOST = "ilive.qq.com";
  private static final String S_UPLOAD_HOST_TESTEW = "test.ilive.qq.com";
  private static final String S_UPLOAD_REFER = "https://ilive.qq.com";
  private static final String S_UPLOAD_REFER_TESTEW = "https://test.ilive.qq.com";
  private static final String S_UPLOAD_URL64 = "https://ilive.qq.com/cgi-bin/now/web/user/upload_room_pic_base64";
  private static final String S_UPLOAD_URL64_TESTENV = "https://test.ilive.qq.com/cgi-bin/now/web/user/upload_room_pic_base64";
  private static final String TAG = "UploadPhotoTask";
  
  /* Error */
  private String encodeFileToBase64Binary(String paramString)
  {
    // Byte code:
    //   0: new 37	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: new 42	java/io/FileInputStream
    //   13: dup
    //   14: aload 7
    //   16: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 6
    //   21: aload 6
    //   23: astore_1
    //   24: aload 7
    //   26: invokevirtual 49	java/io/File:length	()J
    //   29: lstore 4
    //   31: lload 4
    //   33: ldc2_w 50
    //   36: lcmp
    //   37: ifgt +135 -> 172
    //   40: aload 6
    //   42: astore_1
    //   43: lload 4
    //   45: l2i
    //   46: newarray byte
    //   48: astore 8
    //   50: iconst_0
    //   51: istore_2
    //   52: aload 6
    //   54: astore_1
    //   55: iload_2
    //   56: aload 8
    //   58: arraylength
    //   59: if_icmpge +31 -> 90
    //   62: aload 6
    //   64: astore_1
    //   65: aload 6
    //   67: aload 8
    //   69: iload_2
    //   70: aload 8
    //   72: arraylength
    //   73: iload_2
    //   74: isub
    //   75: invokevirtual 57	java/io/InputStream:read	([BII)I
    //   78: istore_3
    //   79: iload_3
    //   80: iflt +10 -> 90
    //   83: iload_2
    //   84: iload_3
    //   85: iadd
    //   86: istore_2
    //   87: goto -35 -> 52
    //   90: aload 6
    //   92: astore_1
    //   93: iload_2
    //   94: aload 8
    //   96: arraylength
    //   97: if_icmplt +22 -> 119
    //   100: aload 6
    //   102: astore_1
    //   103: aload 8
    //   105: iconst_0
    //   106: invokestatic 63	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   109: astore 7
    //   111: aload 6
    //   113: invokestatic 69	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   116: aload 7
    //   118: areturn
    //   119: aload 6
    //   121: astore_1
    //   122: new 71	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   129: astore 8
    //   131: aload 6
    //   133: astore_1
    //   134: aload 8
    //   136: ldc 74
    //   138: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 6
    //   144: astore_1
    //   145: aload 8
    //   147: aload 7
    //   149: invokevirtual 82	java/io/File:getName	()Ljava/lang/String;
    //   152: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: astore_1
    //   159: new 84	java/io/IOException
    //   162: dup
    //   163: aload 8
    //   165: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 88	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: aload 6
    //   174: astore_1
    //   175: new 71	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   182: astore 7
    //   184: aload 6
    //   186: astore_1
    //   187: aload 7
    //   189: ldc 90
    //   191: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: astore_1
    //   198: aload 7
    //   200: lload 4
    //   202: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: astore_1
    //   209: new 84	java/io/IOException
    //   212: dup
    //   213: aload 7
    //   215: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokespecial 88	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   221: athrow
    //   222: astore 7
    //   224: goto +15 -> 239
    //   227: astore_1
    //   228: aconst_null
    //   229: astore 6
    //   231: goto +72 -> 303
    //   234: astore 7
    //   236: aconst_null
    //   237: astore 6
    //   239: aload 6
    //   241: astore_1
    //   242: new 71	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   249: astore 8
    //   251: aload 6
    //   253: astore_1
    //   254: aload 8
    //   256: ldc 95
    //   258: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: astore_1
    //   265: aload 8
    //   267: aload 7
    //   269: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: astore_1
    //   276: ldc 26
    //   278: iconst_1
    //   279: aload 8
    //   281: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 6
    //   289: invokestatic 69	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   292: ldc 106
    //   294: areturn
    //   295: astore 7
    //   297: aload_1
    //   298: astore 6
    //   300: aload 7
    //   302: astore_1
    //   303: aload 6
    //   305: invokestatic 69	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   308: goto +5 -> 313
    //   311: aload_1
    //   312: athrow
    //   313: goto -2 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	UploadPhotoTask
    //   0	316	1	paramString	String
    //   51	47	2	i	int
    //   78	8	3	j	int
    //   29	172	4	l	long
    //   19	285	6	localObject1	Object
    //   8	206	7	localObject2	Object
    //   222	1	7	localThrowable1	Throwable
    //   234	34	7	localThrowable2	Throwable
    //   295	6	7	localObject3	Object
    //   48	232	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	222	java/lang/Throwable
    //   43	50	222	java/lang/Throwable
    //   55	62	222	java/lang/Throwable
    //   65	79	222	java/lang/Throwable
    //   93	100	222	java/lang/Throwable
    //   103	111	222	java/lang/Throwable
    //   122	131	222	java/lang/Throwable
    //   134	142	222	java/lang/Throwable
    //   145	156	222	java/lang/Throwable
    //   159	172	222	java/lang/Throwable
    //   175	184	222	java/lang/Throwable
    //   187	195	222	java/lang/Throwable
    //   198	206	222	java/lang/Throwable
    //   209	222	222	java/lang/Throwable
    //   0	21	227	finally
    //   0	21	234	java/lang/Throwable
    //   24	31	295	finally
    //   43	50	295	finally
    //   55	62	295	finally
    //   65	79	295	finally
    //   93	100	295	finally
    //   103	111	295	finally
    //   122	131	295	finally
    //   134	142	295	finally
    //   145	156	295	finally
    //   159	172	295	finally
    //   175	184	295	finally
    //   187	195	295	finally
    //   198	206	295	finally
    //   209	222	295	finally
    //   242	251	295	finally
    //   254	262	295	finally
    //   265	273	295	finally
    //   276	287	295	finally
  }
  
  private String getCookieStr(String paramString, UploadParms paramUploadParms)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Domain=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("; Path=/; ");
    paramString = new StringBuilder();
    paramString.append("ilive_uin=");
    paramString.append(paramUploadParms.loginInfo.uid);
    paramString.append(";");
    localStringBuilder.append(paramString.toString());
    paramString = new StringBuilder();
    paramString.append("ilive_tinyid=");
    paramString.append(paramUploadParms.loginInfo.tinyid);
    paramString.append(";");
    localStringBuilder.append(paramString.toString());
    paramString = new StringBuilder();
    paramString.append("ilive_a2=");
    paramString.append(paramUploadParms.loginInfo.a2);
    paramString.append(";");
    localStringBuilder.append(paramString.toString());
    return localStringBuilder.toString();
  }
  
  private String getbkn(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return String.valueOf(0x7FFFFFFF & j);
  }
  
  private void httpUplod(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, UploadCallback paramUploadCallback)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient.Builder().connectTimeout(15000L, TimeUnit.SECONDS).readTimeout(15000L, TimeUnit.SECONDS).writeTimeout(15000L, TimeUnit.SECONDS).build();
    Request.Builder localBuilder = new Request.Builder().url(paramString);
    Iterator localIterator;
    String str1;
    String str2;
    if (paramMap1 != null)
    {
      localIterator = paramMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        str2 = (String)paramMap1.get(str1);
        if (str2 != null) {
          localBuilder.addHeader(str1, str2);
        }
      }
    }
    paramMap1 = new FormBody.Builder();
    if (paramMap2 != null)
    {
      localIterator = paramMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        str2 = (String)paramMap2.get(str1);
        if (str2 != null) {
          paramMap1.add(str1, str2);
        }
      }
    }
    localOkHttpClient.newCall(localBuilder.post(paramMap1.build()).build()).enqueue(new UploadPhotoTask.1(this, paramString, paramUploadCallback));
  }
  
  public void upload(UploadParms paramUploadParms, UploadCallback paramUploadCallback)
  {
    for (;;)
    {
      try
      {
        if (paramUploadParms.useTestEnv)
        {
          localObject1 = "https://test.ilive.qq.com/cgi-bin/now/web/user/upload_room_pic_base64";
          if (!paramUploadParms.useTestEnv) {
            break label251;
          }
          localObject2 = "https://test.ilive.qq.com";
          if (!paramUploadParms.useTestEnv) {
            break label258;
          }
          str = "test.ilive.qq.com";
          HashMap localHashMap = new HashMap();
          localHashMap.put("Content-Type", "application/x-www-form-urlencoded");
          localHashMap.put("Referer", localObject2);
          localHashMap.put("Host", str);
          localHashMap.put("Cookie", getCookieStr("qq.com", paramUploadParms));
          localObject2 = new HashMap();
          ((Map)localObject2).put("roomid", paramUploadParms.roomId);
          ((Map)localObject2).put("pic", encodeFileToBase64Binary(paramUploadParms.localPhotoPath));
          ((Map)localObject2).put("bkn", getbkn(paramUploadParms.loginInfo.a2));
          ((Map)localObject2).put("format", paramUploadParms.format);
          httpUplod((String)localObject1, localHashMap, (Map)localObject2, paramUploadCallback);
          return;
        }
      }
      catch (Throwable paramUploadParms)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("upload Throwable ");
        ((StringBuilder)localObject1).append(paramUploadParms);
        QLog.e("UploadPhotoTask", 1, ((StringBuilder)localObject1).toString());
        if (paramUploadCallback != null) {
          paramUploadCallback.onResponse(-1, null);
        }
        return;
      }
      Object localObject1 = "https://ilive.qq.com/cgi-bin/now/web/user/upload_room_pic_base64";
      continue;
      label251:
      Object localObject2 = "https://ilive.qq.com";
      continue;
      label258:
      String str = "ilive.qq.com";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadPhotoTask
 * JD-Core Version:    0.7.0.1
 */