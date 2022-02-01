package com.tencent.timi.game.trtc.tools;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class GenerateTestUserSig
{
  private static String a(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TLS.identifier:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\nTLS.sdkappid:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("\nTLS.time:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("\nTLS.expire:");
    ((StringBuilder)localObject).append(paramLong3);
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = (String)localObject;
    if (paramString3 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append("TLS.userbuf:");
      paramString1.append(paramString3);
      paramString1.append("\n");
      paramString1 = paramString1.toString();
    }
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      paramString3 = Mac.getInstance("HmacSHA256");
      paramString3.init(new SecretKeySpec(paramString2, "HmacSHA256"));
      paramString1 = new String(Base64.encode(paramString3.doFinal(paramString1.getBytes("UTF-8")), 2));
      return paramString1;
    }
    catch (UnsupportedEncodingException|NoSuchAlgorithmException|InvalidKeyException paramString1) {}
    return "";
  }
  
  /* Error */
  private static String a(long paramLong1, String paramString1, long paramLong2, byte[] paramArrayOfByte, String paramString2)
  {
    // Byte code:
    //   0: aload 6
    //   2: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5: ifeq +6 -> 11
    //   8: ldc 83
    //   10: areturn
    //   11: invokestatic 98	java/lang/System:currentTimeMillis	()J
    //   14: ldc2_w 99
    //   17: ldiv
    //   18: lstore 8
    //   20: new 102	org/json/JSONObject
    //   23: dup
    //   24: invokespecial 103	org/json/JSONObject:<init>	()V
    //   27: astore 11
    //   29: aload 11
    //   31: ldc 105
    //   33: ldc 107
    //   35: invokevirtual 111	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   38: pop
    //   39: aload 11
    //   41: ldc 113
    //   43: aload_2
    //   44: invokevirtual 111	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload 11
    //   50: ldc 115
    //   52: lload_0
    //   53: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   56: pop
    //   57: aload 11
    //   59: ldc 120
    //   61: lload_3
    //   62: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   65: pop
    //   66: aload 11
    //   68: ldc 122
    //   70: lload 8
    //   72: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   75: pop
    //   76: goto +25 -> 101
    //   79: astore 10
    //   81: goto +15 -> 96
    //   84: astore 10
    //   86: goto +10 -> 96
    //   89: astore 10
    //   91: goto +5 -> 96
    //   94: astore 10
    //   96: aload 10
    //   98: invokevirtual 125	org/json/JSONException:printStackTrace	()V
    //   101: aload 5
    //   103: ifnull +34 -> 137
    //   106: aload 5
    //   108: iconst_2
    //   109: invokestatic 129	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   112: astore 5
    //   114: aload 11
    //   116: ldc 131
    //   118: aload 5
    //   120: invokevirtual 111	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: goto +10 -> 134
    //   127: astore 10
    //   129: aload 10
    //   131: invokevirtual 125	org/json/JSONException:printStackTrace	()V
    //   134: goto +6 -> 140
    //   137: aconst_null
    //   138: astore 5
    //   140: lload_0
    //   141: aload_2
    //   142: lload 8
    //   144: lload_3
    //   145: aload 6
    //   147: aload 5
    //   149: invokestatic 133	com/tencent/timi/game/trtc/tools/GenerateTestUserSig:a	(JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 137	java/lang/String:length	()I
    //   157: ifne +6 -> 163
    //   160: ldc 83
    //   162: areturn
    //   163: aload 11
    //   165: ldc 139
    //   167: aload_2
    //   168: invokevirtual 111	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: goto +8 -> 180
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 125	org/json/JSONException:printStackTrace	()V
    //   180: new 141	java/util/zip/Deflater
    //   183: dup
    //   184: invokespecial 142	java/util/zip/Deflater:<init>	()V
    //   187: astore_2
    //   188: aload_2
    //   189: aload 11
    //   191: invokevirtual 143	org/json/JSONObject:toString	()Ljava/lang/String;
    //   194: ldc 45
    //   196: invokestatic 149	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   199: invokevirtual 152	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   202: invokevirtual 155	java/util/zip/Deflater:setInput	([B)V
    //   205: aload_2
    //   206: invokevirtual 158	java/util/zip/Deflater:finish	()V
    //   209: sipush 2048
    //   212: newarray byte
    //   214: astore 5
    //   216: aload_2
    //   217: aload 5
    //   219: invokevirtual 162	java/util/zip/Deflater:deflate	([B)I
    //   222: istore 7
    //   224: aload_2
    //   225: invokevirtual 165	java/util/zip/Deflater:end	()V
    //   228: new 47	java/lang/String
    //   231: dup
    //   232: aload 5
    //   234: iconst_0
    //   235: iload 7
    //   237: invokestatic 171	java/util/Arrays:copyOfRange	([BII)[B
    //   240: invokestatic 173	com/tencent/timi/game/trtc/tools/GenerateTestUserSig:a	([B)[B
    //   243: invokespecial 81	java/lang/String:<init>	([B)V
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramLong1	long
    //   0	247	2	paramString1	String
    //   0	247	3	paramLong2	long
    //   0	247	5	paramArrayOfByte	byte[]
    //   0	247	6	paramString2	String
    //   222	14	7	i	int
    //   18	125	8	l	long
    //   79	1	10	localJSONException1	org.json.JSONException
    //   84	1	10	localJSONException2	org.json.JSONException
    //   89	1	10	localJSONException3	org.json.JSONException
    //   94	3	10	localJSONException4	org.json.JSONException
    //   127	3	10	localJSONException5	org.json.JSONException
    //   27	163	11	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   57	76	79	org/json/JSONException
    //   48	57	84	org/json/JSONException
    //   39	48	89	org/json/JSONException
    //   29	39	94	org/json/JSONException
    //   114	124	127	org/json/JSONException
    //   163	172	175	org/json/JSONException
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt, paramString1, 604800L, null, paramString2);
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 2)).getBytes();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if (j != 43)
      {
        if (j != 47)
        {
          if (j == 61) {
            paramArrayOfByte[i] = 95;
          }
        }
        else {
          paramArrayOfByte[i] = 45;
        }
      }
      else {
        paramArrayOfByte[i] = 42;
      }
      i += 1;
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.GenerateTestUserSig
 * JD-Core Version:    0.7.0.1
 */