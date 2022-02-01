package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;

public class JumpShareUtils
{
  public static volatile boolean a = false;
  
  public static int a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = 0;
    if (localBaseApplication == null) {
      return 0;
    }
    if (a(localBaseApplication, 1)) {
      i = 1;
    }
    int j = i;
    if (a(localBaseApplication, 2)) {
      j = i | 0x2;
    }
    return j;
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Context paramContext, File paramFile)
  {
    if (a) {
      return null;
    }
    a = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramFile.getAbsolutePath());
    paramFile = Uri.parse(localStringBuilder.toString());
    paramContext = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQRCodeFromFile(paramFile, paramContext);
    a = false;
    return paramContext;
  }
  
  public static Pair<Integer, Integer> a(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getImgFileWH ");
        paramString.append(i);
        paramString.append(" | ");
        paramString.append(j);
        QLog.d("CheckForward.JumpShareUtils", 2, paramString.toString());
      }
      paramString = new Pair(Integer.valueOf(i), Integer.valueOf(j));
      return paramString;
    }
    catch (Throwable paramString)
    {
      label97:
      break label97;
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 126	java/io/BufferedInputStream
    //   3: dup
    //   4: new 128	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 10240
    //   19: newarray byte
    //   21: astore_3
    //   22: ldc 136
    //   24: invokestatic 142	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore_2
    //   28: goto +10 -> 38
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 145	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_0
    //   39: aload_3
    //   40: invokevirtual 151	java/io/InputStream:read	([B)I
    //   43: istore_1
    //   44: iload_1
    //   45: ifle +13 -> 58
    //   48: aload_2
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 155	java/security/MessageDigest:update	([BII)V
    //   55: goto -17 -> 38
    //   58: aload_0
    //   59: invokevirtual 158	java/io/InputStream:close	()V
    //   62: aload_2
    //   63: ifnull +54 -> 117
    //   66: aload_2
    //   67: invokevirtual 162	java/security/MessageDigest:digest	()[B
    //   70: invokestatic 168	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   73: astore_2
    //   74: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +34 -> 111
    //   80: new 28	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: ldc 170
    //   91: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: aload_2
    //   97: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 101
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 158	java/io/InputStream:close	()V
    //   115: aload_2
    //   116: areturn
    //   117: aload_0
    //   118: invokevirtual 158	java/io/InputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_3
    //   124: aload_0
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: goto +6 -> 134
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 158	java/io/InputStream:close	()V
    //   142: aload_0
    //   143: athrow
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +18 -> 165
    //   150: aload_0
    //   151: invokevirtual 158	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +6 -> 165
    //   162: goto -12 -> 150
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto -12 -> 156
    //   171: astore_0
    //   172: goto -28 -> 144
    //   175: astore_2
    //   176: goto -18 -> 158
    //   179: astore_2
    //   180: goto -34 -> 146
    //   183: astore_3
    //   184: goto -122 -> 62
    //   187: astore_0
    //   188: aload_2
    //   189: areturn
    //   190: astore_0
    //   191: aconst_null
    //   192: areturn
    //   193: astore_2
    //   194: goto -52 -> 142
    //   197: astore_0
    //   198: aconst_null
    //   199: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString	String
    //   43	9	1	i	int
    //   27	1	2	localMessageDigest	java.security.MessageDigest
    //   31	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   37	102	2	str	String
    //   175	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   179	10	2	localThrowable	Throwable
    //   193	1	2	localIOException1	java.io.IOException
    //   21	84	3	localObject1	Object
    //   123	4	3	localObject2	Object
    //   183	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   22	28	31	java/security/NoSuchAlgorithmException
    //   16	22	123	finally
    //   22	28	123	finally
    //   32	36	123	finally
    //   38	44	123	finally
    //   48	55	123	finally
    //   58	62	123	finally
    //   66	111	123	finally
    //   0	16	131	finally
    //   0	16	167	java/io/FileNotFoundException
    //   0	16	171	java/lang/Throwable
    //   16	22	175	java/io/FileNotFoundException
    //   22	28	175	java/io/FileNotFoundException
    //   32	36	175	java/io/FileNotFoundException
    //   38	44	175	java/io/FileNotFoundException
    //   48	55	175	java/io/FileNotFoundException
    //   58	62	175	java/io/FileNotFoundException
    //   66	111	175	java/io/FileNotFoundException
    //   16	22	179	java/lang/Throwable
    //   22	28	179	java/lang/Throwable
    //   32	36	179	java/lang/Throwable
    //   38	44	179	java/lang/Throwable
    //   48	55	179	java/lang/Throwable
    //   58	62	179	java/lang/Throwable
    //   66	111	179	java/lang/Throwable
    //   58	62	183	java/io/IOException
    //   111	115	187	java/io/IOException
    //   117	121	190	java/io/IOException
    //   138	142	193	java/io/IOException
    //   150	154	197	java/io/IOException
  }
  
  private static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      i = paramString.getBytes("UTF-8").length;
      if (i < paramInt) {
        return paramString;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i < paramInt)
        {
          char c = paramString.charAt(i);
          localStringBuffer.append(c);
          try
          {
            int k = String.valueOf(c).getBytes("UTF-8").length;
            j += k;
            if (j > paramInt) {
              localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
            } else {
              i += 1;
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      return localStringBuffer.toString();
    }
  }
  
  /* Error */
  public static msg_ctrl.MsgCtrl a(String paramString)
  {
    // Byte code:
    //   0: new 214	java/util/HashMap
    //   3: dup
    //   4: invokespecial 215	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 217	msf/msgsvc/msg_ctrl$MsgCtrl
    //   12: dup
    //   13: invokespecial 218	msf/msgsvc/msg_ctrl$MsgCtrl:<init>	()V
    //   16: astore 11
    //   18: new 220	msf/msgsvc/msg_ctrl$ResvResvInfo
    //   21: dup
    //   22: invokespecial 221	msf/msgsvc/msg_ctrl$ResvResvInfo:<init>	()V
    //   25: astore 13
    //   27: invokestatic 226	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   30: invokevirtual 229	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:f	()Z
    //   33: ifeq +324 -> 357
    //   36: aload_0
    //   37: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +317 -> 357
    //   43: aload 12
    //   45: ldc 231
    //   47: ldc 233
    //   49: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload 12
    //   55: ldc 239
    //   57: ldc 241
    //   59: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: new 37	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 242	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 245	java/io/File:exists	()Z
    //   74: ifeq +265 -> 339
    //   77: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   80: lstore_2
    //   81: invokestatic 20	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   84: new 37	java/io/File
    //   87: dup
    //   88: aload_0
    //   89: invokespecial 242	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokestatic 253	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	(Landroid/content/Context;Ljava/io/File;)Landroid/util/Pair;
    //   95: astore 9
    //   97: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   100: lload_2
    //   101: lsub
    //   102: lstore_2
    //   103: aload 12
    //   105: ldc 255
    //   107: lload_2
    //   108: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +39 -> 157
    //   121: new 28	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   128: astore 10
    //   130: aload 10
    //   132: ldc_w 260
    //   135: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 10
    //   141: lload_2
    //   142: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 101
    //   148: iconst_2
    //   149: aload 10
    //   151: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload 9
    //   159: ifnull +19 -> 178
    //   162: aload 9
    //   164: getfield 267	android/util/Pair:first	Ljava/lang/Object;
    //   167: checkcast 28	java/lang/StringBuilder
    //   170: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 9
    //   175: goto +6 -> 181
    //   178: aconst_null
    //   179: astore 9
    //   181: aload 9
    //   183: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +135 -> 321
    //   189: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +40 -> 232
    //   195: new 28	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   202: astore 10
    //   204: aload 10
    //   206: ldc_w 269
    //   209: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 10
    //   215: aload 9
    //   217: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 101
    //   223: iconst_2
    //   224: aload 10
    //   226: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload 9
    //   234: sipush 128
    //   237: invokestatic 271	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   240: astore 9
    //   242: aload 13
    //   244: getfield 275	msf/msgsvc/msg_ctrl$ResvResvInfo:bytes_reserv1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   247: aload 9
    //   249: invokestatic 281	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 287	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   255: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +40 -> 298
    //   261: new 28	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   268: astore 10
    //   270: aload 10
    //   272: ldc_w 289
    //   275: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 10
    //   281: aload 9
    //   283: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: ldc 101
    //   289: iconst_2
    //   290: aload 10
    //   292: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload 12
    //   300: ldc 239
    //   302: ldc 233
    //   304: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   307: pop
    //   308: goto +59 -> 367
    //   311: astore 9
    //   313: aload 9
    //   315: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   318: goto +49 -> 367
    //   321: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +43 -> 367
    //   327: ldc 101
    //   329: iconst_2
    //   330: ldc_w 292
    //   333: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: goto +31 -> 367
    //   339: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +25 -> 367
    //   345: ldc 101
    //   347: iconst_1
    //   348: ldc_w 294
    //   351: invokestatic 297	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto +13 -> 367
    //   357: aload 12
    //   359: ldc 231
    //   361: ldc 241
    //   363: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: invokestatic 226	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   370: invokevirtual 300	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:h	()Z
    //   373: ifeq +189 -> 562
    //   376: invokestatic 302	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	()Z
    //   379: ifeq +183 -> 562
    //   382: aload 12
    //   384: ldc_w 304
    //   387: ldc 233
    //   389: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: pop
    //   393: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   396: lstore_2
    //   397: invokestatic 306	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	()I
    //   400: istore_1
    //   401: aload 13
    //   403: getfield 310	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   406: iconst_1
    //   407: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   410: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +12 -> 425
    //   416: ldc 101
    //   418: iconst_2
    //   419: ldc_w 317
    //   422: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 13
    //   427: getfield 321	msf/msgsvc/msg_ctrl$ResvResvInfo:uint64_reserv2	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   430: iload_1
    //   431: i2l
    //   432: invokevirtual 326	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   435: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +39 -> 477
    //   441: new 28	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   448: astore 9
    //   450: aload 9
    //   452: ldc_w 328
    //   455: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 9
    //   461: iload_1
    //   462: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: ldc 101
    //   468: iconst_2
    //   469: aload 9
    //   471: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   480: lstore 4
    //   482: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +45 -> 530
    //   488: new 28	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   495: astore 9
    //   497: aload 9
    //   499: ldc_w 330
    //   502: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 9
    //   508: lload 4
    //   510: lload_2
    //   511: lsub
    //   512: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: ldc 101
    //   518: iconst_2
    //   519: aload 9
    //   521: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: goto +3 -> 530
    //   530: aload 12
    //   532: ldc_w 332
    //   535: lload 4
    //   537: lload_2
    //   538: lsub
    //   539: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   542: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   545: pop
    //   546: aload 12
    //   548: ldc_w 334
    //   551: iload_1
    //   552: invokestatic 337	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   555: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   558: pop
    //   559: goto +14 -> 573
    //   562: aload 12
    //   564: ldc_w 304
    //   567: ldc 241
    //   569: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   572: pop
    //   573: invokestatic 226	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   576: invokevirtual 340	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:g	()Z
    //   579: ifeq +928 -> 1507
    //   582: aload 12
    //   584: ldc_w 342
    //   587: ldc 233
    //   589: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   596: lstore 6
    //   598: aload_0
    //   599: invokestatic 348	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   602: ifne +841 -> 1443
    //   605: aload_0
    //   606: invokestatic 353	com/tencent/mobileqq/activity/photo/PhotoUtils:isJPEGImage	(Ljava/lang/String;)Z
    //   609: ifeq +834 -> 1443
    //   612: new 355	android/media/ExifInterface
    //   615: dup
    //   616: aload_0
    //   617: invokespecial 356	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   620: astore 14
    //   622: lconst_0
    //   623: lstore_2
    //   624: aload 14
    //   626: ldc_w 358
    //   629: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   635: ifne +5 -> 640
    //   638: lconst_1
    //   639: lstore_2
    //   640: aload 14
    //   642: ldc_w 363
    //   645: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore_0
    //   649: lload_2
    //   650: lstore 4
    //   652: aload_0
    //   653: ifnull +20 -> 673
    //   656: lload_2
    //   657: lstore 4
    //   659: aload_0
    //   660: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   663: ifne +10 -> 673
    //   666: lload_2
    //   667: ldc2_w 364
    //   670: lor
    //   671: lstore 4
    //   673: aload 13
    //   675: getfield 368	msf/msgsvc/msg_ctrl$ResvResvInfo:uint64_reserv3	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   678: lload 4
    //   680: invokevirtual 326	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   683: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +36 -> 722
    //   689: new 28	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   696: astore_0
    //   697: aload_0
    //   698: ldc_w 370
    //   701: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_0
    //   706: lload 4
    //   708: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: ldc 101
    //   714: iconst_2
    //   715: aload_0
    //   716: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: aload 12
    //   724: ldc_w 372
    //   727: lload 4
    //   729: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   732: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: pop
    //   736: aload 14
    //   738: ldc_w 374
    //   741: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   744: astore_0
    //   745: aload_0
    //   746: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   749: istore 8
    //   751: iload 8
    //   753: ifne +87 -> 840
    //   756: new 376	java/text/SimpleDateFormat
    //   759: dup
    //   760: ldc_w 378
    //   763: invokespecial 379	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   766: aload_0
    //   767: invokevirtual 382	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   770: invokevirtual 387	java/util/Date:getTime	()J
    //   773: ldc2_w 388
    //   776: ldiv
    //   777: l2i
    //   778: istore_1
    //   779: aload 13
    //   781: getfield 392	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   784: iload_1
    //   785: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   788: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +35 -> 826
    //   794: new 28	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   801: astore_0
    //   802: aload_0
    //   803: ldc_w 394
    //   806: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload_0
    //   811: iload_1
    //   812: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: ldc 101
    //   818: iconst_2
    //   819: aload_0
    //   820: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   826: aload 12
    //   828: ldc_w 396
    //   831: ldc 233
    //   833: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   836: pop
    //   837: goto +22 -> 859
    //   840: aload 12
    //   842: ldc_w 396
    //   845: ldc 241
    //   847: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   850: pop
    //   851: goto +8 -> 859
    //   854: astore_0
    //   855: aload_0
    //   856: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   859: aload 14
    //   861: ldc_w 398
    //   864: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   867: astore_0
    //   868: aload_0
    //   869: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   872: ifne +299 -> 1171
    //   875: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +39 -> 917
    //   881: new 28	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   888: astore 9
    //   890: aload 9
    //   892: ldc_w 400
    //   895: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 9
    //   901: aload_0
    //   902: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: ldc 101
    //   908: iconst_2
    //   909: aload 9
    //   911: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: new 402	org/json/JSONObject
    //   920: dup
    //   921: aload_0
    //   922: invokespecial 403	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   925: astore 9
    //   927: aload 9
    //   929: ldc_w 405
    //   932: invokevirtual 408	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   935: astore_0
    //   936: aload 9
    //   938: ldc_w 410
    //   941: invokevirtual 408	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   944: astore 10
    //   946: aload_0
    //   947: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   950: ifne +89 -> 1039
    //   953: aload 13
    //   955: getfield 413	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   958: aload_0
    //   959: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   962: invokevirtual 419	java/lang/Integer:intValue	()I
    //   965: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   968: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   971: istore 8
    //   973: iload 8
    //   975: ifeq +50 -> 1025
    //   978: new 28	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   985: astore 9
    //   987: aload 9
    //   989: ldc_w 421
    //   992: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 9
    //   998: aload_0
    //   999: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1002: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: ldc 101
    //   1008: iconst_2
    //   1009: aload 9
    //   1011: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1017: goto +8 -> 1025
    //   1020: astore 9
    //   1022: goto +164 -> 1186
    //   1025: aload 12
    //   1027: ldc_w 426
    //   1030: ldc 233
    //   1032: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1035: pop
    //   1036: goto +14 -> 1050
    //   1039: aload 12
    //   1041: ldc_w 426
    //   1044: ldc 241
    //   1046: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1049: pop
    //   1050: aload 10
    //   1052: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1055: ifne +79 -> 1134
    //   1058: aload 13
    //   1060: getfield 429	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1063: aload 10
    //   1065: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1068: invokevirtual 419	java/lang/Integer:intValue	()I
    //   1071: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1074: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1077: ifeq +43 -> 1120
    //   1080: new 28	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1087: astore 9
    //   1089: aload 9
    //   1091: ldc_w 431
    //   1094: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 9
    //   1100: aload 10
    //   1102: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1105: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: ldc 101
    //   1111: iconst_2
    //   1112: aload 9
    //   1114: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: aload 12
    //   1122: ldc_w 433
    //   1125: ldc 233
    //   1127: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1130: pop
    //   1131: goto +14 -> 1145
    //   1134: aload 12
    //   1136: ldc_w 433
    //   1139: ldc 241
    //   1141: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1144: pop
    //   1145: goto +46 -> 1191
    //   1148: astore 9
    //   1150: goto +5 -> 1155
    //   1153: astore 9
    //   1155: goto +31 -> 1186
    //   1158: astore 9
    //   1160: aconst_null
    //   1161: astore 10
    //   1163: goto +23 -> 1186
    //   1166: astore 9
    //   1168: goto +13 -> 1181
    //   1171: aconst_null
    //   1172: astore 10
    //   1174: aconst_null
    //   1175: astore_0
    //   1176: goto +15 -> 1191
    //   1179: astore 9
    //   1181: aconst_null
    //   1182: astore 10
    //   1184: aconst_null
    //   1185: astore_0
    //   1186: aload 9
    //   1188: invokevirtual 434	java/lang/Throwable:printStackTrace	()V
    //   1191: ldc_w 426
    //   1194: astore 9
    //   1196: aload_0
    //   1197: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1200: istore 8
    //   1202: iload 8
    //   1204: ifeq +110 -> 1314
    //   1207: aload 14
    //   1209: ldc_w 405
    //   1212: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1215: astore_0
    //   1216: aload_0
    //   1217: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1220: ifne +76 -> 1296
    //   1223: aload 13
    //   1225: getfield 413	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1228: aload_0
    //   1229: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1232: invokevirtual 419	java/lang/Integer:intValue	()I
    //   1235: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1238: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1241: ifeq +42 -> 1283
    //   1244: new 28	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1251: astore 15
    //   1253: aload 15
    //   1255: ldc_w 436
    //   1258: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 15
    //   1264: aload_0
    //   1265: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1268: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: ldc 101
    //   1274: iconst_2
    //   1275: aload 15
    //   1277: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1283: aload 12
    //   1285: aload 9
    //   1287: ldc 233
    //   1289: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1292: pop
    //   1293: goto +21 -> 1314
    //   1296: aload 12
    //   1298: aload 9
    //   1300: ldc 241
    //   1302: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1305: pop
    //   1306: goto +8 -> 1314
    //   1309: astore_0
    //   1310: aload_0
    //   1311: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   1314: aload 10
    //   1316: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1319: istore 8
    //   1321: iload 8
    //   1323: ifeq +120 -> 1443
    //   1326: aload 14
    //   1328: ldc_w 410
    //   1331: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1334: astore_0
    //   1335: aload_0
    //   1336: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1339: ifne +77 -> 1416
    //   1342: aload 13
    //   1344: getfield 429	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1347: aload_0
    //   1348: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1351: invokevirtual 419	java/lang/Integer:intValue	()I
    //   1354: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1357: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq +42 -> 1402
    //   1363: new 28	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1370: astore 9
    //   1372: aload 9
    //   1374: ldc_w 438
    //   1377: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: pop
    //   1381: aload 9
    //   1383: aload_0
    //   1384: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1387: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: ldc 101
    //   1393: iconst_2
    //   1394: aload 9
    //   1396: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: aload 12
    //   1404: ldc_w 433
    //   1407: ldc 233
    //   1409: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1412: pop
    //   1413: goto +30 -> 1443
    //   1416: aload 12
    //   1418: ldc_w 433
    //   1421: ldc 241
    //   1423: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1426: pop
    //   1427: goto +16 -> 1443
    //   1430: astore_0
    //   1431: aload_0
    //   1432: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   1435: goto +8 -> 1443
    //   1438: astore_0
    //   1439: aload_0
    //   1440: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   1443: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   1446: lstore_2
    //   1447: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1450: ifeq +38 -> 1488
    //   1453: new 28	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1460: astore_0
    //   1461: aload_0
    //   1462: ldc_w 440
    //   1465: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload_0
    //   1470: lload_2
    //   1471: lload 6
    //   1473: lsub
    //   1474: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1477: pop
    //   1478: ldc 101
    //   1480: iconst_2
    //   1481: aload_0
    //   1482: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: aload 12
    //   1490: ldc_w 442
    //   1493: lload_2
    //   1494: lload 6
    //   1496: lsub
    //   1497: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1500: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1503: pop
    //   1504: goto +14 -> 1518
    //   1507: aload 12
    //   1509: ldc_w 342
    //   1512: ldc 241
    //   1514: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1517: pop
    //   1518: aload 11
    //   1520: getfield 446	msf/msgsvc/msg_ctrl$MsgCtrl:resv_resv_info	Lmsf/msgsvc/msg_ctrl$ResvResvInfo;
    //   1523: aload 13
    //   1525: invokevirtual 449	msf/msgsvc/msg_ctrl$ResvResvInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1528: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +12 -> 1543
    //   1534: ldc 101
    //   1536: iconst_2
    //   1537: ldc_w 451
    //   1540: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1543: invokestatic 20	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1546: invokestatic 456	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1549: aconst_null
    //   1550: ldc_w 458
    //   1553: iconst_1
    //   1554: lconst_0
    //   1555: lconst_0
    //   1556: aload 12
    //   1558: ldc_w 460
    //   1561: invokevirtual 464	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1564: aload 11
    //   1566: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1567	0	paramString	String
    //   400	412	1	i	int
    //   80	1414	2	l1	long
    //   480	248	4	l2	long
    //   596	899	6	l3	long
    //   749	573	8	bool	boolean
    //   95	187	9	localObject1	Object
    //   311	3	9	localException	Exception
    //   448	562	9	localObject2	Object
    //   1020	1	9	localThrowable1	Throwable
    //   1087	26	9	localStringBuilder1	StringBuilder
    //   1148	1	9	localThrowable2	Throwable
    //   1153	1	9	localThrowable3	Throwable
    //   1158	1	9	localThrowable4	Throwable
    //   1166	1	9	localThrowable5	Throwable
    //   1179	8	9	localThrowable6	Throwable
    //   1194	201	9	localObject3	Object
    //   128	1187	10	localObject4	Object
    //   16	1549	11	localMsgCtrl	msg_ctrl.MsgCtrl
    //   7	1550	12	localHashMap	java.util.HashMap
    //   25	1499	13	localResvResvInfo	msg_ctrl.ResvResvInfo
    //   620	707	14	localExifInterface	android.media.ExifInterface
    //   1251	25	15	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   232	298	311	java/lang/Exception
    //   298	308	311	java/lang/Exception
    //   736	751	854	java/lang/Exception
    //   756	826	854	java/lang/Exception
    //   826	837	854	java/lang/Exception
    //   840	851	854	java/lang/Exception
    //   978	1017	1020	java/lang/Throwable
    //   1025	1036	1148	java/lang/Throwable
    //   1039	1050	1148	java/lang/Throwable
    //   1050	1120	1148	java/lang/Throwable
    //   1120	1131	1148	java/lang/Throwable
    //   1134	1145	1148	java/lang/Throwable
    //   946	973	1153	java/lang/Throwable
    //   936	946	1158	java/lang/Throwable
    //   927	936	1166	java/lang/Throwable
    //   859	917	1179	java/lang/Throwable
    //   917	927	1179	java/lang/Throwable
    //   1207	1283	1309	java/lang/Exception
    //   1283	1293	1309	java/lang/Exception
    //   1296	1306	1309	java/lang/Exception
    //   1326	1402	1430	java/lang/Exception
    //   1402	1413	1430	java/lang/Exception
    //   1416	1427	1430	java/lang/Exception
    //   612	622	1438	java/lang/Exception
    //   624	638	1438	java/lang/Exception
    //   640	649	1438	java/lang/Exception
    //   659	666	1438	java/lang/Exception
    //   673	722	1438	java/lang/Exception
    //   722	736	1438	java/lang/Exception
    //   855	859	1438	java/lang/Exception
    //   859	917	1438	java/lang/Exception
    //   917	927	1438	java/lang/Exception
    //   927	936	1438	java/lang/Exception
    //   936	946	1438	java/lang/Exception
    //   946	973	1438	java/lang/Exception
    //   978	1017	1438	java/lang/Exception
    //   1025	1036	1438	java/lang/Exception
    //   1039	1050	1438	java/lang/Exception
    //   1050	1120	1438	java/lang/Exception
    //   1120	1131	1438	java/lang/Exception
    //   1134	1145	1438	java/lang/Exception
    //   1186	1191	1438	java/lang/Exception
    //   1196	1202	1438	java/lang/Exception
    //   1310	1314	1438	java/lang/Exception
    //   1314	1321	1438	java/lang/Exception
    //   1431	1435	1438	java/lang/Exception
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject = paramString2;
    if (paramString2 == null)
    {
      if (!TextUtils.isEmpty(paramString1)) {
        localObject = new File(paramString1);
      } else {
        localObject = null;
      }
      if ((localObject != null) && (((File)localObject).exists()))
      {
        if (ZhuoXusManager.a().i())
        {
          localObject = a(BaseApplicationImpl.getContext(), (File)localObject);
          if (localObject == null)
          {
            localObject = paramString2;
            if (!QLog.isColorLevel()) {
              break label177;
            }
            QLog.w("CheckForward.JumpShareUtils", 1, "calc file faild!");
            localObject = paramString2;
            break label177;
          }
          if (((Pair)localObject).first != null)
          {
            localObject = ((StringBuilder)((Pair)localObject).first).toString();
            break label177;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
        }
        localObject = "";
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
        }
        return null;
      }
    }
    label177:
    paramString2 = a((String)localObject, 128);
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(paramString2));
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i;
    if ((ZhuoXusManager.a().k()) && (a()))
    {
      localResvResvInfo.uint32_flag.set(1);
      localResvResvInfo.uint64_reserv2.set(a());
      i = 1;
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
        i = j;
      }
    }
    if (ZhuoXusManager.a().j())
    {
      paramString2 = b(paramString1);
      if (paramString2 != null)
      {
        localResvResvInfo.uint64_reserv3.set(((Integer)paramString2.first).intValue());
        localResvResvInfo.uint32_create_time.set(((Integer)paramString2.second).intValue());
      }
      if (paramInt1 != 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 != 0) {}
      }
      else
      {
        paramString1 = a(paramString1);
        j = paramInt1;
        i = paramInt2;
        if (paramString1 != null)
        {
          j = ((Integer)paramString1.first).intValue();
          i = ((Integer)paramString1.second).intValue();
        }
      }
      localResvResvInfo.uint32_pic_width.set(j);
      localResvResvInfo.uint32_pic_height.set(i);
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = i;
      if (QLog.isColorLevel())
      {
        QLog.i("IMG_FILE_QR", 1, "ZhuoXusManager exif switch is false!");
        paramInt1 = i;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    localMsgCtrl.resv_resv_info.set(localResvResvInfo);
    return localMsgCtrl;
  }
  
  public static boolean a()
  {
    Object localObject = ZhuoXusManager.a();
    if (!((ZhuoXusManager)localObject).e()) {
      return false;
    }
    String str = ((ZhuoXusManager)localObject).a();
    localObject = ((ZhuoXusManager)localObject).b();
    if (!TextUtils.isEmpty(str)) {
      return !TextUtils.isEmpty((CharSequence)localObject);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    ZhuoXusManager localZhuoXusManager = ZhuoXusManager.a();
    if (!localZhuoXusManager.e()) {
      return false;
    }
    String str = null;
    if (paramInt == 1) {
      str = localZhuoXusManager.a();
    } else if (paramInt == 2) {
      str = localZhuoXusManager.b();
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 256);
      return paramContext != null;
    }
    catch (PackageManager.NameNotFoundException|Exception paramContext) {}
    return false;
  }
  
  /* Error */
  private static Pair<Integer, Integer> b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 348	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 353	com/tencent/mobileqq/activity/photo/PhotoUtils:isJPEGImage	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: iconst_0
    //   19: istore 5
    //   21: new 355	android/media/ExifInterface
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 356	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc_w 358
    //   34: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: istore 6
    //   42: iload 6
    //   44: iconst_1
    //   45: ixor
    //   46: istore_3
    //   47: iload_3
    //   48: istore_1
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: ldc_w 363
    //   55: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +7 -> 68
    //   64: iload_3
    //   65: iconst_2
    //   66: ior
    //   67: istore_1
    //   68: iload_1
    //   69: istore_2
    //   70: aload_0
    //   71: ldc_w 374
    //   74: invokevirtual 361	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_0
    //   78: iload_1
    //   79: istore_2
    //   80: iload 5
    //   82: istore_3
    //   83: iload_1
    //   84: istore 4
    //   86: aload_0
    //   87: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +75 -> 165
    //   93: iload_1
    //   94: istore_2
    //   95: new 376	java/text/SimpleDateFormat
    //   98: dup
    //   99: ldc_w 378
    //   102: invokespecial 379	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   105: astore 9
    //   107: aload 9
    //   109: aload_0
    //   110: invokevirtual 382	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   113: invokevirtual 387	java/util/Date:getTime	()J
    //   116: ldc2_w 388
    //   119: ldiv
    //   120: lstore 7
    //   122: lload 7
    //   124: l2i
    //   125: istore_3
    //   126: iload_1
    //   127: istore 4
    //   129: goto +36 -> 165
    //   132: astore_0
    //   133: iload_1
    //   134: istore_2
    //   135: aload_0
    //   136: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   139: iload 5
    //   141: istore_3
    //   142: iload_1
    //   143: istore 4
    //   145: goto +20 -> 165
    //   148: astore_0
    //   149: goto +6 -> 155
    //   152: astore_0
    //   153: iconst_0
    //   154: istore_2
    //   155: aload_0
    //   156: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   159: iload_2
    //   160: istore 4
    //   162: iload 5
    //   164: istore_3
    //   165: new 107	android/util/Pair
    //   168: dup
    //   169: iload 4
    //   171: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: iload_3
    //   175: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: invokespecial 116	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   48	95	1	i	int
    //   50	110	2	j	int
    //   46	129	3	k	int
    //   84	86	4	m	int
    //   19	144	5	n	int
    //   40	6	6	bool	boolean
    //   120	3	7	l	long
    //   105	3	9	localSimpleDateFormat	java.text.SimpleDateFormat
    // Exception table:
    //   from	to	target	type
    //   107	122	132	java/lang/Exception
    //   51	64	148	java/lang/Exception
    //   70	78	148	java/lang/Exception
    //   86	93	148	java/lang/Exception
    //   95	107	148	java/lang/Exception
    //   135	139	148	java/lang/Exception
    //   21	42	152	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpShareUtils
 * JD-Core Version:    0.7.0.1
 */