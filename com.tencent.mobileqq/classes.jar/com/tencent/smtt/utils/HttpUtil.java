package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public class HttpUtil
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  
  private static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static String httpPost(HttpURLConnection paramHttpURLConnection, HttpUtil.HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 35	java/net/HttpURLConnection:getResponseCode	()I
    //   10: istore_3
    //   11: aload_1
    //   12: ifnull +10 -> 22
    //   15: aload_1
    //   16: iload_3
    //   17: invokeinterface 41 2 0
    //   22: iload_3
    //   23: sipush 200
    //   26: if_icmpne +256 -> 282
    //   29: aload_0
    //   30: invokevirtual 45	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 49	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +88 -> 128
    //   43: aload_0
    //   44: ldc 51
    //   46: invokevirtual 57	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   49: ifeq +79 -> 128
    //   52: new 59	java/util/zip/GZIPInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 62	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_0
    //   61: new 64	java/io/ByteArrayOutputStream
    //   64: dup
    //   65: invokespecial 65	java/io/ByteArrayOutputStream:<init>	()V
    //   68: astore_1
    //   69: sipush 128
    //   72: newarray byte
    //   74: astore 4
    //   76: aload_0
    //   77: aload 4
    //   79: invokevirtual 71	java/io/InputStream:read	([B)I
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpeq +90 -> 175
    //   88: aload_1
    //   89: aload 4
    //   91: iconst_0
    //   92: iload_3
    //   93: invokevirtual 75	java/io/ByteArrayOutputStream:write	([BII)V
    //   96: goto -20 -> 76
    //   99: astore 5
    //   101: aload_1
    //   102: astore 4
    //   104: aload_0
    //   105: astore_1
    //   106: aload 4
    //   108: astore_0
    //   109: aload 5
    //   111: astore 4
    //   113: aload 4
    //   115: invokevirtual 78	java/lang/Throwable:printStackTrace	()V
    //   118: aload_1
    //   119: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   122: aload_0
    //   123: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   126: aconst_null
    //   127: areturn
    //   128: aload_0
    //   129: ifnull +41 -> 170
    //   132: aload_0
    //   133: ldc 82
    //   135: invokevirtual 57	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   138: ifeq +32 -> 170
    //   141: new 84	java/util/zip/InflaterInputStream
    //   144: dup
    //   145: aload_1
    //   146: new 86	java/util/zip/Inflater
    //   149: dup
    //   150: iconst_1
    //   151: invokespecial 89	java/util/zip/Inflater:<init>	(Z)V
    //   154: invokespecial 92	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   157: astore_0
    //   158: goto -97 -> 61
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -54 -> 113
    //   170: aload_1
    //   171: astore_0
    //   172: goto -111 -> 61
    //   175: iload_2
    //   176: ifeq +29 -> 205
    //   179: new 53	java/lang/String
    //   182: dup
    //   183: aload_1
    //   184: invokevirtual 96	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   187: ldc 8
    //   189: invokespecial 99	java/lang/String:<init>	([BLjava/lang/String;)V
    //   192: astore 4
    //   194: aload_0
    //   195: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   198: aload_1
    //   199: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   202: aload 4
    //   204: areturn
    //   205: new 53	java/lang/String
    //   208: dup
    //   209: invokestatic 105	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   212: aload_1
    //   213: invokevirtual 96	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   216: invokevirtual 109	com/tencent/smtt/utils/Post3DESEncryption:DesDecrypt	([B)[B
    //   219: invokespecial 112	java/lang/String:<init>	([B)V
    //   222: astore 4
    //   224: goto -30 -> 194
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_0
    //   231: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   234: aload 4
    //   236: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: goto -12 -> 230
    //   245: astore 5
    //   247: aload_1
    //   248: astore 4
    //   250: aload 5
    //   252: astore_1
    //   253: goto -23 -> 230
    //   256: astore 4
    //   258: aload_1
    //   259: astore 5
    //   261: aload 4
    //   263: astore_1
    //   264: aload_0
    //   265: astore 4
    //   267: aload 5
    //   269: astore_0
    //   270: goto -40 -> 230
    //   273: astore 4
    //   275: aload_0
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -166 -> 113
    //   282: aconst_null
    //   283: astore_1
    //   284: aconst_null
    //   285: astore 4
    //   287: aload 5
    //   289: astore_0
    //   290: goto -96 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramHttpURLConnection	HttpURLConnection
    //   0	293	1	paramHttpResponseListener	HttpUtil.HttpResponseListener
    //   0	293	2	paramBoolean	boolean
    //   10	83	3	i	int
    //   1	113	4	localObject1	Object
    //   161	1	4	localThrowable1	java.lang.Throwable
    //   192	57	4	localObject2	Object
    //   256	6	4	localObject3	Object
    //   265	1	4	localHttpURLConnection	HttpURLConnection
    //   273	1	4	localThrowable2	java.lang.Throwable
    //   285	1	4	localObject4	Object
    //   4	1	5	localObject5	Object
    //   99	11	5	localThrowable3	java.lang.Throwable
    //   245	6	5	localObject6	Object
    //   259	29	5	localHttpResponseListener	HttpUtil.HttpResponseListener
    // Exception table:
    //   from	to	target	type
    //   69	76	99	java/lang/Throwable
    //   76	83	99	java/lang/Throwable
    //   88	96	99	java/lang/Throwable
    //   179	194	99	java/lang/Throwable
    //   205	224	99	java/lang/Throwable
    //   6	11	161	java/lang/Throwable
    //   15	22	161	java/lang/Throwable
    //   29	39	161	java/lang/Throwable
    //   43	61	161	java/lang/Throwable
    //   132	158	161	java/lang/Throwable
    //   6	11	227	finally
    //   15	22	227	finally
    //   29	39	227	finally
    //   43	61	227	finally
    //   132	158	227	finally
    //   61	69	241	finally
    //   69	76	245	finally
    //   76	83	245	finally
    //   88	96	245	finally
    //   179	194	245	finally
    //   205	224	245	finally
    //   113	118	256	finally
    //   61	69	273	java/lang/Throwable
  }
  
  /* Error */
  private static HttpURLConnection initHttpPostURLConnection(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 116	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 123	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 31	java/net/HttpURLConnection
    //   14: astore_0
    //   15: aload_0
    //   16: ldc 125
    //   18: invokevirtual 128	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: invokevirtual 131	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 134	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_0
    //   32: iconst_0
    //   33: invokevirtual 137	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   36: aload_0
    //   37: sipush 20000
    //   40: invokevirtual 140	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   43: getstatic 145	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 13
    //   48: if_icmple +80 -> 128
    //   51: aload_0
    //   52: ldc 147
    //   54: ldc 148
    //   56: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokeinterface 158 1 0
    //   65: invokeinterface 164 1 0
    //   70: astore_2
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: invokeinterface 170 1 0
    //   79: ifeq +47 -> 126
    //   82: aload_2
    //   83: invokeinterface 174 1 0
    //   88: checkcast 176	java/util/Map$Entry
    //   91: astore_1
    //   92: aload_0
    //   93: aload_1
    //   94: invokeinterface 179 1 0
    //   99: checkcast 53	java/lang/String
    //   102: aload_1
    //   103: invokeinterface 182 1 0
    //   108: checkcast 53	java/lang/String
    //   111: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto -43 -> 71
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: astore_1
    //   126: aload_1
    //   127: areturn
    //   128: aload_0
    //   129: ldc 185
    //   131: ldc 187
    //   133: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -77 -> 59
    //   139: astore_1
    //   140: goto -20 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramMap	Map<String, String>
    //   70	13	2	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   0	15	117	java/lang/Exception
    //   15	21	139	java/lang/Exception
  }
  
  public static String postData(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, HttpUtil.HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramString = initHttpPostURLConnection(paramString, paramMap);
    } while (paramString == null);
    if (paramBoolean) {
      writeZipPostData(paramString, paramArrayOfByte);
    }
    for (;;)
    {
      return httpPost(paramString, paramHttpResponseListener, false);
      writePostData(paramString, paramArrayOfByte);
    }
  }
  
  /* Error */
  public static String postData(String paramString, byte[] paramArrayOfByte, HttpUtil.HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +50 -> 51
    //   4: invokestatic 209	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   7: invokevirtual 212	com/tencent/smtt/utils/PostEncryption:initRSAKey	()Ljava/lang/String;
    //   10: astore 4
    //   12: new 214	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 4
    //   25: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: iload_3
    //   34: ifeq +35 -> 69
    //   37: invokestatic 209	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   40: aload_1
    //   41: invokevirtual 225	com/tencent/smtt/utils/PostEncryption:DESEncrypt	([B)[B
    //   44: astore_0
    //   45: aload_0
    //   46: ifnonnull +44 -> 90
    //   49: aconst_null
    //   50: areturn
    //   51: invokestatic 105	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   54: invokevirtual 228	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   57: astore 4
    //   59: goto -47 -> 12
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 105	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   72: aload_1
    //   73: invokevirtual 229	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   76: astore_0
    //   77: goto -32 -> 45
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: astore_0
    //   87: goto -42 -> 45
    //   90: new 231	java/util/HashMap
    //   93: dup
    //   94: invokespecial 232	java/util/HashMap:<init>	()V
    //   97: astore_1
    //   98: aload_1
    //   99: ldc 234
    //   101: ldc 236
    //   103: invokeinterface 240 3 0
    //   108: pop
    //   109: aload_1
    //   110: ldc 242
    //   112: aload_0
    //   113: arraylength
    //   114: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   117: invokeinterface 240 3 0
    //   122: pop
    //   123: aload 4
    //   125: aload_1
    //   126: invokestatic 193	com/tencent/smtt/utils/HttpUtil:initHttpPostURLConnection	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +17 -> 148
    //   134: aload_1
    //   135: aload_0
    //   136: invokestatic 202	com/tencent/smtt/utils/HttpUtil:writePostData	(Ljava/net/HttpURLConnection;[B)V
    //   139: aload_1
    //   140: aload_2
    //   141: iload_3
    //   142: invokestatic 199	com/tencent/smtt/utils/HttpUtil:httpPost	(Ljava/net/HttpURLConnection;Lcom/tencent/smtt/utils/HttpUtil$HttpResponseListener;Z)Ljava/lang/String;
    //   145: astore_0
    //   146: aload_0
    //   147: areturn
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -4 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   0	153	1	paramArrayOfByte	byte[]
    //   0	153	2	paramHttpResponseListener	HttpUtil.HttpResponseListener
    //   0	153	3	paramBoolean	boolean
    //   10	114	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	12	62	java/lang/Exception
    //   12	33	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
    //   37	45	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
  }
  
  private static void writePostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      localHttpURLConnection = paramHttpURLConnection;
      localObject = paramHttpURLConnection;
      paramHttpURLConnection.write(paramArrayOfByte);
      localHttpURLConnection = paramHttpURLConnection;
      localObject = paramHttpURLConnection;
      paramHttpURLConnection.flush();
      closeStream(paramHttpURLConnection);
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      localObject = localHttpURLConnection;
      paramHttpURLConnection.printStackTrace();
      closeStream(localHttpURLConnection);
      return;
    }
    finally
    {
      closeStream((Closeable)localObject);
    }
  }
  
  /* Error */
  private static void writeZipPostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 259	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: new 261	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 250	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: ldc_w 262
    //   15: invokespecial 265	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   18: invokespecial 268	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: astore_0
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 254	java/io/OutputStream:write	([B)V
    //   29: aload_2
    //   30: astore_0
    //   31: aload_2
    //   32: invokevirtual 257	java/io/OutputStream:flush	()V
    //   35: aconst_null
    //   36: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   39: aload_2
    //   40: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   43: return
    //   44: astore_3
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: aload_3
    //   50: invokevirtual 183	java/lang/Exception:printStackTrace	()V
    //   53: aconst_null
    //   54: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   57: aload_1
    //   58: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   61: return
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_0
    //   65: aconst_null
    //   66: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: invokestatic 80	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: goto -11 -> 65
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: goto -35 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramHttpURLConnection	HttpURLConnection
    //   0	85	1	paramArrayOfByte	byte[]
    //   21	60	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   44	6	3	localException1	Exception
    //   79	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	44	java/lang/Exception
    //   0	22	62	finally
    //   24	29	75	finally
    //   31	35	75	finally
    //   49	53	75	finally
    //   24	29	79	java/lang/Exception
    //   31	35	79	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.HttpUtil
 * JD-Core Version:    0.7.0.1
 */