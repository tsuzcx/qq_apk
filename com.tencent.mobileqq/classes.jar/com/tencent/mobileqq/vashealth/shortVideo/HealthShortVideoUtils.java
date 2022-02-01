package com.tencent.mobileqq.vashealth.shortVideo;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HealthShortVideoUtils
{
  public static int a(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  /* Error */
  public static long a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, long paramLong1, java.io.RandomAccessFile paramRandomAccessFile, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 31	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadReqBody
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: lload_3
    //   12: lload 6
    //   14: iload 8
    //   16: i2l
    //   17: lconst_0
    //   18: lconst_0
    //   19: invokespecial 34	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadReqBody:<init>	([B[BJJJJJ)V
    //   22: astore_1
    //   23: new 36	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader
    //   26: dup
    //   27: iload 8
    //   29: sipush 348
    //   32: iadd
    //   33: i2l
    //   34: invokespecial 39	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader:<init>	(J)V
    //   37: astore 12
    //   39: iload 8
    //   41: sipush 364
    //   44: iadd
    //   45: invokestatic 45	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   48: astore_0
    //   49: aload 12
    //   51: aload_0
    //   52: invokevirtual 48	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader:a	(Ljava/nio/ByteBuffer;)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 49	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadReqBody:a	(Ljava/nio/ByteBuffer;)V
    //   60: aload 5
    //   62: lload 6
    //   64: invokevirtual 54	java/io/RandomAccessFile:seek	(J)V
    //   67: iload 8
    //   69: newarray byte
    //   71: astore_1
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 58	java/io/RandomAccessFile:read	([B)I
    //   78: pop
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 62	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   84: pop
    //   85: new 64	java/net/URL
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 67	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 71	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 73	java/net/HttpURLConnection
    //   99: astore 5
    //   101: aload 5
    //   103: ldc 75
    //   105: invokevirtual 78	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 5
    //   110: iconst_1
    //   111: invokevirtual 82	java/net/HttpURLConnection:setDoInput	(Z)V
    //   114: aload 5
    //   116: iconst_1
    //   117: invokevirtual 85	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   120: aload 5
    //   122: invokevirtual 89	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   125: astore_2
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 93	java/nio/ByteBuffer:array	()[B
    //   131: invokevirtual 99	java/io/OutputStream:write	([B)V
    //   134: aload_2
    //   135: invokevirtual 102	java/io/OutputStream:flush	()V
    //   138: aload 5
    //   140: invokevirtual 105	java/net/HttpURLConnection:connect	()V
    //   143: aload 5
    //   145: invokevirtual 109	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   148: astore_1
    //   149: new 111	java/io/ByteArrayOutputStream
    //   152: dup
    //   153: invokespecial 112	java/io/ByteArrayOutputStream:<init>	()V
    //   156: astore 13
    //   158: bipush 25
    //   160: newarray byte
    //   162: astore_0
    //   163: aload_1
    //   164: aload_0
    //   165: invokevirtual 115	java/io/InputStream:read	([B)I
    //   168: istore 9
    //   170: iload 9
    //   172: iconst_m1
    //   173: if_icmpeq +15 -> 188
    //   176: aload 13
    //   178: aload_0
    //   179: iconst_0
    //   180: iload 9
    //   182: invokevirtual 118	java/io/ByteArrayOutputStream:write	([BII)V
    //   185: goto -22 -> 163
    //   188: aload 13
    //   190: invokevirtual 121	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: invokestatic 124	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   196: astore 12
    //   198: new 36	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader
    //   201: dup
    //   202: aload 12
    //   204: invokespecial 126	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader:<init>	(Ljava/nio/ByteBuffer;)V
    //   207: astore_0
    //   208: new 128	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadRspBody
    //   211: dup
    //   212: aload 12
    //   214: invokespecial 129	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadRspBody:<init>	(Ljava/nio/ByteBuffer;)V
    //   217: astore 12
    //   219: aload_0
    //   220: getfield 133	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadHeader:b	J
    //   223: lconst_0
    //   224: lcmp
    //   225: ifne +24 -> 249
    //   228: aload 12
    //   230: getfield 136	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadRspBody:jdField_a_of_type_Int	I
    //   233: iconst_1
    //   234: if_icmpne +6 -> 240
    //   237: goto +16 -> 253
    //   240: aload 12
    //   242: getfield 138	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$UploadRspBody:jdField_a_of_type_Long	J
    //   245: lstore_3
    //   246: goto +7 -> 253
    //   249: ldc2_w 139
    //   252: lstore_3
    //   253: aload_2
    //   254: ifnull +11 -> 265
    //   257: aload_2
    //   258: invokevirtual 102	java/io/OutputStream:flush	()V
    //   261: aload_2
    //   262: invokevirtual 143	java/io/OutputStream:close	()V
    //   265: aload 13
    //   267: invokevirtual 144	java/io/ByteArrayOutputStream:flush	()V
    //   270: aload 13
    //   272: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 146	java/io/InputStream:close	()V
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   293: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +66 -> 362
    //   299: new 157	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   306: astore_0
    //   307: aload_0
    //   308: ldc 160
    //   310: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_0
    //   315: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   318: lload 10
    //   320: lsub
    //   321: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_0
    //   326: ldc 169
    //   328: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_0
    //   333: lload_3
    //   334: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_0
    //   339: ldc 171
    //   341: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: iload 8
    //   348: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 176
    //   354: iconst_2
    //   355: aload_0
    //   356: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: lload_3
    //   363: lreturn
    //   364: astore_0
    //   365: aload_2
    //   366: astore 12
    //   368: aload 13
    //   370: astore_2
    //   371: goto +33 -> 404
    //   374: astore_0
    //   375: goto +6 -> 381
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_1
    //   381: aload_2
    //   382: astore 12
    //   384: aconst_null
    //   385: astore_2
    //   386: goto +18 -> 404
    //   389: astore_0
    //   390: goto +7 -> 397
    //   393: astore_0
    //   394: aconst_null
    //   395: astore 5
    //   397: aconst_null
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_2
    //   401: aconst_null
    //   402: astore 12
    //   404: aload 12
    //   406: ifnull +13 -> 419
    //   409: aload 12
    //   411: invokevirtual 102	java/io/OutputStream:flush	()V
    //   414: aload 12
    //   416: invokevirtual 143	java/io/OutputStream:close	()V
    //   419: aload_2
    //   420: ifnull +11 -> 431
    //   423: aload_2
    //   424: invokevirtual 144	java/io/ByteArrayOutputStream:flush	()V
    //   427: aload_2
    //   428: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 146	java/io/InputStream:close	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   449: goto +5 -> 454
    //   452: aload_0
    //   453: athrow
    //   454: goto -2 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramArrayOfByte1	byte[]
    //   0	457	1	paramArrayOfByte2	byte[]
    //   0	457	2	paramString	String
    //   0	457	3	paramLong1	long
    //   0	457	5	paramRandomAccessFile	java.io.RandomAccessFile
    //   0	457	6	paramLong2	long
    //   0	457	8	paramInt	int
    //   168	13	9	i	int
    //   3	316	10	l	long
    //   37	378	12	localObject	Object
    //   156	213	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   158	163	364	finally
    //   163	170	364	finally
    //   176	185	364	finally
    //   188	237	364	finally
    //   240	246	364	finally
    //   149	158	374	finally
    //   126	149	378	finally
    //   101	126	389	finally
    //   5	101	393	finally
  }
  
  public static HealthShortVideoUtils.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3)
  {
    return a(paramBundle, paramString1, paramString2, paramString3, "https://c.v.qq.com/openfvupready?g_tk=");
  }
  
  public static HealthShortVideoUtils.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = System.currentTimeMillis();
    String str2 = paramBundle.getString("title");
    String str3 = paramBundle.getString("tags");
    String str4 = paramBundle.getString("cat");
    String str1 = paramBundle.getString("file_path");
    paramBundle = paramBundle.getString("vid");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyUpload title = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", tags = ");
      localStringBuilder.append(str3);
      localStringBuilder.append(", cat = ");
      localStringBuilder.append(str4);
      localStringBuilder.append(", filePath = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(FileUtils.getFileSizes(str1));
      QLog.d("HealthShortVideoUtils", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(str1)) && (FileUtils.fileExists(str1)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString4);
      localStringBuilder.append(String.valueOf(a(paramString2)));
      paramString4 = new HttpPost(localStringBuilder.toString());
      paramString4.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramString4.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramString4.setHeader("Accept-Encoding", "gzip, deflate");
      paramString4.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramString4.setHeader("Connection", "close");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(";uin=");
      localStringBuilder.append(paramString1);
      paramString4.setHeader("Cookie", localStringBuilder.toString());
      paramString4.setHeader("Referer", "https://c.v.qq.com");
      paramString1 = new ArrayList();
      paramString1.add(new BasicNameValuePair("bid", paramString3));
      paramString1.add(new BasicNameValuePair("title", str2));
      paramString1.add(new BasicNameValuePair("tags", str3));
      paramString1.add(new BasicNameValuePair("cat", str4));
      paramString1.add(new BasicNameValuePair("size", String.valueOf(FileUtils.getFileSizes(str1))));
      paramString1.add(new BasicNameValuePair("sha", HexUtil.bytes2HexStr(QQFileManagerUtil.d(str1))));
      paramString1.add(new BasicNameValuePair("md5", HexUtil.bytes2HexStr(QQFileManagerUtil.e(str1))));
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("applyUpload() getMessageDigest time = ");
        paramString3.append(System.currentTimeMillis() - l);
        QLog.d("HealthShortVideoUtils", 2, paramString3.toString());
      }
      paramString1.add(new BasicNameValuePair("platform", "android"));
      paramString1.add(new BasicNameValuePair("g_tk", String.valueOf(a(paramString2))));
      paramString1.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(paramBundle))
      {
        paramString1.add(new BasicNameValuePair("vid", paramBundle));
        paramString1.add(new BasicNameValuePair("continue", "1"));
      }
      try
      {
        paramString4.setEntity(new UrlEncodedFormEntity(paramString1, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramString4);
        if (paramBundle.getStatusLine().getStatusCode() == 200)
        {
          paramBundle = EntityUtils.toString(paramBundle.getEntity());
          paramBundle = paramBundle.substring(paramBundle.indexOf("{"), paramBundle.lastIndexOf("}") + 1);
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("applyUpload result = ");
            paramString1.append(paramBundle);
            QLog.d("HealthShortVideoUtils", 2, paramString1.toString());
          }
          paramBundle = new JSONObject(paramBundle);
          if (paramBundle.optString("s", "f").equals("o")) {
            paramBundle = new HealthShortVideoUtils.ApplyUploadRsp(paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HealthShortVideoUtils", 2, QLog.getStackTraceString(paramBundle));
        }
        paramBundle = null;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("applyUpload time: ");
        paramString1.append(System.currentTimeMillis() - l);
        QLog.d("HealthShortVideoUtils", 2, paramString1.toString());
      }
      return paramBundle;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("!!!!!!!applyUpload filePath = ");
      paramBundle.append(str1);
      QLog.e("HealthShortVideoUtils", 2, paramBundle.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.shortVideo.HealthShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */