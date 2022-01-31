package com.tencent.proxyinner.utility;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class FileUploadUtil
{
  private static final String CHARSET_ENCODING = "UTF-8";
  private static final String LINE_FEED = "\r\n";
  private static char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final String TAG = "HttpUtil";
  private static final String UPLOAD_URL = "http://upload.huayang.qq.com/cgi-bin/uploadfile";
  private static String multipartBoundary;
  
  /* Error */
  private static void _doAddFilePart(DataOutputStream paramDataOutputStream, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 50	java/io/File:getName	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_0
    //   11: new 52	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   18: ldc 55
    //   20: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 61	com/tencent/proxyinner/utility/FileUploadUtil:multipartBoundary	Ljava/lang/String;
    //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: ldc 13
    //   38: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 52	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   49: ldc 72
    //   51: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 74
    //   60: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: ldc 13
    //   72: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: new 52	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   83: ldc 76
    //   85: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokestatic 82	java/net/URLConnection:guessContentTypeFromName	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: ldc 13
    //   104: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc 13
    //   110: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   113: aconst_null
    //   114: astore_3
    //   115: aconst_null
    //   116: astore 4
    //   118: new 84	java/io/FileInputStream
    //   121: dup
    //   122: aload_1
    //   123: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore_1
    //   127: sipush 4096
    //   130: newarray byte
    //   132: astore_3
    //   133: aload_1
    //   134: aload_3
    //   135: invokevirtual 93	java/io/InputStream:read	([B)I
    //   138: istore_2
    //   139: iload_2
    //   140: iconst_m1
    //   141: if_icmpeq +25 -> 166
    //   144: aload_0
    //   145: aload_3
    //   146: iconst_0
    //   147: iload_2
    //   148: invokevirtual 97	java/io/DataOutputStream:write	([BII)V
    //   151: goto -18 -> 133
    //   154: astore_0
    //   155: aload_1
    //   156: ifnull -152 -> 4
    //   159: aload_1
    //   160: invokevirtual 100	java/io/InputStream:close	()V
    //   163: return
    //   164: astore_0
    //   165: return
    //   166: aload_1
    //   167: invokevirtual 100	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: ldc 13
    //   173: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: invokevirtual 103	java/io/DataOutputStream:flush	()V
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 100	java/io/InputStream:close	()V
    //   188: return
    //   189: astore_0
    //   190: return
    //   191: astore_0
    //   192: aload_3
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 100	java/io/InputStream:close	()V
    //   202: aload_0
    //   203: athrow
    //   204: astore_1
    //   205: goto -3 -> 202
    //   208: astore_0
    //   209: goto -15 -> 194
    //   212: astore_0
    //   213: aload 4
    //   215: astore_1
    //   216: goto -61 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramDataOutputStream	DataOutputStream
    //   0	219	1	paramFile	File
    //   138	10	2	i	int
    //   9	184	3	localObject1	Object
    //   116	98	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   127	133	154	java/io/IOException
    //   133	139	154	java/io/IOException
    //   144	151	154	java/io/IOException
    //   166	180	154	java/io/IOException
    //   159	163	164	java/lang/Exception
    //   184	188	189	java/lang/Exception
    //   118	127	191	finally
    //   198	202	204	java/lang/Exception
    //   127	133	208	finally
    //   133	139	208	finally
    //   144	151	208	finally
    //   166	180	208	finally
    //   118	127	212	java/io/IOException
  }
  
  private static void _doAddFormFields(DataOutputStream paramDataOutputStream, Map<String, String> paramMap)
    throws IOException
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramDataOutputStream.writeBytes("--" + multipartBoundary);
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + (String)localEntry.getKey() + "\"");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        paramDataOutputStream.writeBytes("\r\n");
      }
    }
  }
  
  private static String _generateMultipartBoundary()
  {
    Random localRandom = new Random();
    char[] arrayOfChar = new char[localRandom.nextInt(9) + 12];
    int i = 0;
    while (i < arrayOfChar.length)
    {
      arrayOfChar[i] = MULTIPART_CHARS[localRandom.nextInt(MULTIPART_CHARS.length)];
      i += 1;
    }
    return "===AndroidFormBoundary" + new String(arrayOfChar);
  }
  
  private static HttpURLConnection _openPostConnection(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setDoInput(true);
    paramString.setUseCaches(false);
    paramString.setDoOutput(true);
    paramString.setRequestMethod("POST");
    paramString.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + multipartBoundary);
    paramString.setRequestProperty("User-Agent", "Android Client Agent");
    return paramString;
  }
  
  /* Error */
  private static String doPost(String paramString, Map<String, String> paramMap, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokestatic 212	com/tencent/proxyinner/utility/FileUploadUtil:_openPostConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   9: astore_0
    //   10: aload_0
    //   11: astore_3
    //   12: new 66	java/io/DataOutputStream
    //   15: dup
    //   16: aload_0
    //   17: invokevirtual 216	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   20: invokespecial 219	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore 5
    //   25: aload 5
    //   27: aload_1
    //   28: invokestatic 221	com/tencent/proxyinner/utility/FileUploadUtil:_doAddFormFields	(Ljava/io/DataOutputStream;Ljava/util/Map;)V
    //   31: aload 5
    //   33: aload_2
    //   34: invokestatic 223	com/tencent/proxyinner/utility/FileUploadUtil:_doAddFilePart	(Ljava/io/DataOutputStream;Ljava/io/File;)V
    //   37: aload 5
    //   39: ldc 13
    //   41: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   44: aload 5
    //   46: new 52	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   53: ldc 55
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 61	com/tencent/proxyinner/utility/FileUploadUtil:multipartBoundary	Ljava/lang/String;
    //   61: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 55
    //   66: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   75: aload 5
    //   77: ldc 13
    //   79: invokevirtual 70	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   82: aload 5
    //   84: invokevirtual 224	java/io/DataOutputStream:close	()V
    //   87: aload_0
    //   88: invokestatic 228	com/tencent/proxyinner/utility/FileUploadUtil:getResponse	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   91: astore_1
    //   92: ldc 18
    //   94: aload_1
    //   95: invokestatic 234	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 237	java/net/HttpURLConnection:disconnect	()V
    //   107: aload 5
    //   109: ifnull +8 -> 117
    //   112: aload 5
    //   114: invokevirtual 224	java/io/DataOutputStream:close	()V
    //   117: aload_1
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_0
    //   127: aload 4
    //   129: astore_1
    //   130: aload_3
    //   131: ifnull +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 237	java/net/HttpURLConnection:disconnect	()V
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 224	java/io/DataOutputStream:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   153: goto -7 -> 146
    //   156: astore_2
    //   157: aload 5
    //   159: astore_1
    //   160: aload_0
    //   161: astore_3
    //   162: aload_2
    //   163: astore_0
    //   164: goto -34 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString	String
    //   0	167	1	paramMap	Map<String, String>
    //   0	167	2	paramFile	File
    //   1	161	3	str	String
    //   3	125	4	localObject	Object
    //   23	135	5	localDataOutputStream	DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   112	117	119	java/lang/Exception
    //   5	10	126	finally
    //   12	25	126	finally
    //   142	146	148	java/lang/Exception
    //   25	99	156	finally
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if (paramHttpURLConnection.getResponseCode() != 200) {
      throw new IOException("服务器返回状态非正常响应状态.");
    }
    return getResponseAsString(paramHttpURLConnection);
  }
  
  private static String getResponseAsString(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    String str = getResponseCharset(paramHttpURLConnection.getContentType());
    InputStream localInputStream = paramHttpURLConnection.getErrorStream();
    if (localInputStream == null) {
      return getStreamAsString(paramHttpURLConnection.getInputStream(), str);
    }
    return getStreamAsString(localInputStream, str);
  }
  
  private static String getResponseCharset(String paramString)
  {
    String str = "UTF-8";
    String[] arrayOfString = paramString.split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = str;
      if (i < j)
      {
        paramString = arrayOfString[i].trim();
        if (!paramString.startsWith("charset")) {
          break label72;
        }
        arrayOfString = paramString.split("=", 2);
        paramString = str;
        if (arrayOfString.length == 2) {
          paramString = arrayOfString[1].trim();
        }
      }
      return paramString;
      label72:
      i += 1;
    }
  }
  
  private static String getStreamAsString(InputStream paramInputStream, String paramString)
    throws IOException
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
    }
    finally
    {
      if (paramInputStream != null) {
        paramInputStream.close();
      }
    }
    if (paramInputStream != null) {
      paramInputStream.close();
    }
    return paramString;
  }
  
  public static void upload(String paramString1, final String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.e("HttpUtil", "uin null or file path null");
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        FileUploadUtil.access$002(FileUploadUtil.access$100());
        HashMap localHashMap = new HashMap();
        String str = "qiqi" + UUID.randomUUID().toString().replace("-", "");
        Log.i("upload", str);
        localHashMap.put("taskUuid", str);
        localHashMap.put("taskType", "0");
        localHashMap.put("taskBusinessType", "2");
        localHashMap.put("taskTargetId", this.val$uin);
        try
        {
          FileUploadUtil.doPost("http://upload.huayang.qq.com/cgi-bin/uploadfile", localHashMap, new File(paramString2));
          return;
        }
        catch (Exception localException)
        {
          Log.e("HttpUtil", localException.getLocalizedMessage());
        }
      }
    }).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.FileUploadUtil
 * JD-Core Version:    0.7.0.1
 */