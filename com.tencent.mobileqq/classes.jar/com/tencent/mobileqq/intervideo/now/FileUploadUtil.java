package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class FileUploadUtil
{
  private static String a;
  private static char[] b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  
  private static String a(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = new BufferedReader(new InputStreamReader(paramInputStream, paramString));
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char[256];
      for (;;)
      {
        int i = paramString.read(arrayOfChar);
        if (i <= 0) {
          break;
        }
        localStringWriter.write(arrayOfChar, 0, i);
      }
      paramString = localStringWriter.toString();
      if (paramInputStream != null) {
        paramInputStream.close();
      }
      return paramString;
    }
    finally
    {
      if (paramInputStream != null) {
        paramInputStream.close();
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection.getResponseCode() == 200) {
      return b(paramHttpURLConnection);
    }
    throw new IOException(HardCodeUtil.a(2131902584));
  }
  
  /* Error */
  private static void a(DataOutputStream paramDataOutputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 91	java/io/File:getName	()Ljava/lang/String;
    //   9: astore_3
    //   10: new 93	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: ldc 96
    //   23: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: getstatic 60	com/tencent/mobileqq/intervideo/now/FileUploadUtil:a	Ljava/lang/String;
    //   32: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: ldc 108
    //   48: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   51: new 93	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   58: astore 4
    //   60: aload 4
    //   62: ldc 110
    //   64: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 4
    //   70: aload_3
    //   71: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 4
    //   77: ldc 112
    //   79: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: ldc 108
    //   95: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   98: new 93	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   105: astore 4
    //   107: aload 4
    //   109: ldc 114
    //   111: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload_3
    //   118: invokestatic 119	java/net/URLConnection:guessContentTypeFromName	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_0
    //   126: aload 4
    //   128: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   134: aload_0
    //   135: ldc 108
    //   137: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: ldc 108
    //   143: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   146: new 121	java/io/FileInputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: astore_1
    //   155: sipush 4096
    //   158: newarray byte
    //   160: astore_3
    //   161: aload_1
    //   162: aload_3
    //   163: invokevirtual 127	java/io/InputStream:read	([B)I
    //   166: istore_2
    //   167: iload_2
    //   168: iconst_m1
    //   169: if_icmpeq +13 -> 182
    //   172: aload_0
    //   173: aload_3
    //   174: iconst_0
    //   175: iload_2
    //   176: invokevirtual 130	java/io/DataOutputStream:write	([BII)V
    //   179: goto -18 -> 161
    //   182: aload_1
    //   183: invokevirtual 57	java/io/InputStream:close	()V
    //   186: aload_0
    //   187: ldc 108
    //   189: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: invokevirtual 133	java/io/DataOutputStream:flush	()V
    //   196: aload_1
    //   197: invokevirtual 57	java/io/InputStream:close	()V
    //   200: return
    //   201: astore_0
    //   202: goto +6 -> 208
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 57	java/io/InputStream:close	()V
    //   216: aload_0
    //   217: athrow
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: ifnull +6 -> 227
    //   224: goto -28 -> 196
    //   227: return
    //   228: astore_0
    //   229: goto -11 -> 218
    //   232: astore_0
    //   233: goto -13 -> 220
    //   236: astore_0
    //   237: return
    //   238: astore_1
    //   239: goto -23 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramDataOutputStream	DataOutputStream
    //   0	242	1	paramFile	java.io.File
    //   166	10	2	i	int
    //   9	165	3	localObject	Object
    //   17	110	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   155	161	201	finally
    //   161	167	201	finally
    //   172	179	201	finally
    //   182	196	201	finally
    //   146	155	205	finally
    //   146	155	228	java/io/IOException
    //   155	161	232	java/io/IOException
    //   161	167	232	java/io/IOException
    //   172	179	232	java/io/IOException
    //   182	196	232	java/io/IOException
    //   196	200	236	java/lang/Exception
    //   212	216	238	java/lang/Exception
  }
  
  private static void a(DataOutputStream paramDataOutputStream, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--");
        localStringBuilder.append(a);
        paramDataOutputStream.writeBytes(localStringBuilder.toString());
        paramDataOutputStream.writeBytes("\r\n");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Content-Disposition: form-data; name=\"");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("\"");
        paramDataOutputStream.writeBytes(localStringBuilder.toString());
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        paramDataOutputStream.writeBytes("\r\n");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      ThreadManagerV2.excute(new FileUploadUtil.1(paramString1, paramString2), 128, null, false);
      return;
    }
    Log.e("HttpUtil", "uin null or file path null");
  }
  
  private static String b()
  {
    Object localObject = new Random();
    char[] arrayOfChar1 = new char[((Random)localObject).nextInt(9) + 12];
    int i = 0;
    while (i < arrayOfChar1.length)
    {
      char[] arrayOfChar2 = b;
      arrayOfChar1[i] = arrayOfChar2[localObject.nextInt(arrayOfChar2.length)];
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("===AndroidFormBoundary");
    ((StringBuilder)localObject).append(new String(arrayOfChar1));
    return ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  private static String b(String paramString, Map<String, String> paramMap, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 215	com/tencent/mobileqq/intervideo/now/FileUploadUtil:b	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   4: astore_3
    //   5: new 103	java/io/DataOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokevirtual 219	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   13: invokespecial 222	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 224	com/tencent/mobileqq/intervideo/now/FileUploadUtil:a	(Ljava/io/DataOutputStream;Ljava/util/Map;)V
    //   22: aload_0
    //   23: aload_2
    //   24: invokestatic 226	com/tencent/mobileqq/intervideo/now/FileUploadUtil:a	(Ljava/io/DataOutputStream;Ljava/io/File;)V
    //   27: aload_0
    //   28: ldc 108
    //   30: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   33: new 93	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc 96
    //   44: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: getstatic 60	com/tencent/mobileqq/intervideo/now/FileUploadUtil:a	Ljava/lang/String;
    //   52: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: ldc 96
    //   59: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: ldc 108
    //   74: invokevirtual 106	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: invokevirtual 227	java/io/DataOutputStream:close	()V
    //   81: aload_3
    //   82: invokestatic 229	com/tencent/mobileqq/intervideo/now/FileUploadUtil:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   85: astore_1
    //   86: ldc 192
    //   88: aload_1
    //   89: invokestatic 232	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 235	java/net/HttpURLConnection:disconnect	()V
    //   101: aload_0
    //   102: invokevirtual 227	java/io/DataOutputStream:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: aload_3
    //   116: astore_2
    //   117: goto +16 -> 133
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_3
    //   124: astore_2
    //   125: goto +8 -> 133
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_0
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 235	java/net/HttpURLConnection:disconnect	()V
    //   141: aload_0
    //   142: ifnull +15 -> 157
    //   145: aload_0
    //   146: invokevirtual 227	java/io/DataOutputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   0	159	1	paramMap	Map<String, String>
    //   0	159	2	paramFile	java.io.File
    //   4	120	3	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   101	105	107	java/lang/Exception
    //   17	93	114	finally
    //   5	17	120	finally
    //   0	5	128	finally
    //   145	149	152	java/lang/Exception
  }
  
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    String str = c(paramHttpURLConnection.getContentType());
    InputStream localInputStream = paramHttpURLConnection.getErrorStream();
    if (localInputStream == null) {
      return a(paramHttpURLConnection.getInputStream(), str);
    }
    return a(localInputStream, str);
  }
  
  private static HttpURLConnection b(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setDoInput(true);
    paramString.setUseCaches(false);
    paramString.setDoOutput(true);
    paramString.setRequestMethod("POST");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(a);
    paramString.setRequestProperty("Content-Type", localStringBuilder.toString());
    paramString.setRequestProperty("User-Agent", "Android Client Agent");
    return paramString;
  }
  
  private static String c(String paramString)
  {
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i].trim();
      if (str.startsWith("charset"))
      {
        paramString = str.split("=", 2);
        if (paramString.length != 2) {
          break;
        }
        return paramString[1].trim();
      }
      i += 1;
    }
    return "UTF-8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.FileUploadUtil
 * JD-Core Version:    0.7.0.1
 */