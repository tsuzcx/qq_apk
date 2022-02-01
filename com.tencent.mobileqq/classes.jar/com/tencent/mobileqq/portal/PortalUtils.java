package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortalUtils
{
  protected static MessageDigest a;
  private static final int[] b = { 1, 2, 3 };
  
  public static String a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
  }
  
  public static String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject4 = MD5.getPartfileMd5(paramString, 0L);
      Object localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = MD5FileUtil.b((byte[])localObject4);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("error ........ error getFileMD5String filePath: ");
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append(", error=");
      ((StringBuilder)localObject4).append(localException.getMessage());
      QLog.e("PortalManager.PortalUtils", 2, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("getFileMD5String md5: ");
      paramString.append(localObject2);
      QLog.e("PortalManager.PortalUtils", 2, paramString.toString());
    }
    return localObject2;
  }
  
  public static String a(String paramString, long paramLong)
  {
    try
    {
      Long.valueOf(paramString);
      int j = Integer.valueOf(paramString.substring(0, 1)).intValue() % 4;
      i = j;
      if (j != 0) {
        break label36;
      }
      i = 1;
    }
    catch (Exception paramString)
    {
      int i;
      label34:
      label36:
      Object localObject;
      break label34;
    }
    i = 2;
    paramString = new StringBuilder();
    paramString.append("factorIndex");
    paramString.append("=");
    paramString.append(i);
    paramString.append(",");
    paramLong <<= i;
    paramString.append("value1");
    paramString.append("=");
    paramString.append(paramLong);
    paramString.append(",");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    paramString.append("value2");
    paramString.append("=");
    paramString.append((String)localObject);
    paramString.append(",");
    localObject = Base64Util.encodeToString(((String)localObject).getBytes(), 2);
    paramString.append("value3");
    paramString.append("=");
    paramString.append((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PortalUtils", 2, paramString.toString());
    }
    return localObject;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (a == null) {
      try
      {
        a = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    a.update(paramArrayOfByte);
    return MD5FileUtil.b(a.digest());
  }
  
  /* Error */
  public static String b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 170	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 172	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 19	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore 4
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore_0
    //   30: new 174	java/util/zip/GZIPInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 177	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: aload_0
    //   41: iconst_0
    //   42: sipush 1024
    //   45: invokevirtual 181	java/util/zip/GZIPInputStream:read	([BII)I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_m1
    //   51: if_icmpeq +14 -> 65
    //   54: aload 4
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_1
    //   59: invokevirtual 185	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -23 -> 39
    //   65: aload_2
    //   66: invokevirtual 188	java/util/zip/GZIPInputStream:close	()V
    //   69: aload 4
    //   71: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   74: astore_0
    //   75: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +35 -> 113
    //   81: new 61	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: ldc 190
    //   92: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_2
    //   97: aload_0
    //   98: arraylength
    //   99: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 76
    //   105: iconst_2
    //   106: aload_2
    //   107: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 4
    //   115: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   118: aload_3
    //   119: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   122: aload_0
    //   123: astore_2
    //   124: goto +225 -> 349
    //   127: astore_3
    //   128: aload_0
    //   129: astore_2
    //   130: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +216 -> 349
    //   136: new 61	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   143: astore_2
    //   144: aload_2
    //   145: ldc 194
    //   147: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: aload_3
    //   153: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc 76
    //   162: iconst_2
    //   163: aload_2
    //   164: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: astore_2
    //   172: goto +177 -> 349
    //   175: astore_2
    //   176: goto +14 -> 190
    //   179: astore_2
    //   180: goto +91 -> 271
    //   183: astore_0
    //   184: goto +196 -> 380
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_0
    //   190: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +41 -> 234
    //   196: new 61	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   203: astore 5
    //   205: aload 5
    //   207: ldc 197
    //   209: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 5
    //   215: aload_2
    //   216: invokevirtual 198	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 76
    //   225: iconst_2
    //   226: aload 5
    //   228: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 4
    //   236: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_3
    //   240: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   243: aload_0
    //   244: astore_2
    //   245: goto +104 -> 349
    //   248: astore_3
    //   249: aload_0
    //   250: astore_2
    //   251: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +95 -> 349
    //   257: new 61	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   264: astore_2
    //   265: goto -121 -> 144
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_0
    //   271: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +41 -> 315
    //   277: new 61	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   284: astore 5
    //   286: aload 5
    //   288: ldc 197
    //   290: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 5
    //   296: aload_2
    //   297: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: ldc 76
    //   306: iconst_2
    //   307: aload 5
    //   309: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 4
    //   317: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   320: aload_3
    //   321: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   324: aload_0
    //   325: astore_2
    //   326: goto +23 -> 349
    //   329: astore_3
    //   330: aload_0
    //   331: astore_2
    //   332: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +14 -> 349
    //   338: new 61	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   345: astore_2
    //   346: goto -202 -> 144
    //   349: aload_2
    //   350: ifnull +28 -> 378
    //   353: new 100	java/lang/String
    //   356: dup
    //   357: aload_2
    //   358: ldc 200
    //   360: invokespecial 203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   363: astore_0
    //   364: aload_0
    //   365: areturn
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   371: aconst_null
    //   372: areturn
    //   373: astore_0
    //   374: aload_0
    //   375: invokevirtual 204	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   378: aconst_null
    //   379: areturn
    //   380: aload 4
    //   382: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   385: aload_3
    //   386: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   389: goto +44 -> 433
    //   392: astore_2
    //   393: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +37 -> 433
    //   399: new 61	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   406: astore_3
    //   407: aload_3
    //   408: ldc 194
    //   410: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload_3
    //   415: aload_2
    //   416: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
    //   419: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: ldc 76
    //   425: iconst_2
    //   426: aload_3
    //   427: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto +5 -> 438
    //   436: aload_0
    //   437: athrow
    //   438: goto -2 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	paramArrayOfByte	byte[]
    //   48	11	1	i	int
    //   38	134	2	localObject1	Object
    //   175	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   179	1	2	localException1	Exception
    //   187	29	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   244	21	2	localObject2	Object
    //   268	29	2	localException2	Exception
    //   325	33	2	localObject3	Object
    //   392	24	2	localIOException1	java.io.IOException
    //   14	105	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   127	113	3	localIOException2	java.io.IOException
    //   248	73	3	localIOException3	java.io.IOException
    //   329	57	3	localIOException4	java.io.IOException
    //   406	21	3	localStringBuilder1	StringBuilder
    //   22	359	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   203	105	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   113	122	127	java/io/IOException
    //   75	113	175	java/lang/OutOfMemoryError
    //   75	113	179	java/lang/Exception
    //   24	39	183	finally
    //   39	49	183	finally
    //   54	62	183	finally
    //   65	75	183	finally
    //   75	113	183	finally
    //   190	234	183	finally
    //   271	315	183	finally
    //   24	39	187	java/lang/OutOfMemoryError
    //   39	49	187	java/lang/OutOfMemoryError
    //   54	62	187	java/lang/OutOfMemoryError
    //   65	75	187	java/lang/OutOfMemoryError
    //   234	243	248	java/io/IOException
    //   24	39	268	java/lang/Exception
    //   39	49	268	java/lang/Exception
    //   54	62	268	java/lang/Exception
    //   65	75	268	java/lang/Exception
    //   315	324	329	java/io/IOException
    //   353	364	366	java/lang/Exception
    //   353	364	373	java/io/UnsupportedEncodingException
    //   380	389	392	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 231
    //   9: areturn
    //   10: new 61	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   17: astore 8
    //   19: lconst_0
    //   20: lstore 4
    //   22: lload 4
    //   24: lstore_2
    //   25: aload_0
    //   26: invokevirtual 132	java/lang/String:getBytes	()[B
    //   29: iconst_2
    //   30: invokestatic 235	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   33: astore_0
    //   34: lload 4
    //   36: lstore_2
    //   37: new 100	java/lang/String
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 236	java/lang/String:<init>	([B)V
    //   45: astore 9
    //   47: lload 4
    //   49: lstore_2
    //   50: aload 8
    //   52: ldc 238
    //   54: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: lload 4
    //   60: lstore_2
    //   61: aload 8
    //   63: ldc 117
    //   65: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: lload 4
    //   71: lstore_2
    //   72: aload 8
    //   74: aload_0
    //   75: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: lload 4
    //   81: lstore_2
    //   82: aload 8
    //   84: ldc 122
    //   86: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: lload 4
    //   92: lstore_2
    //   93: aload 9
    //   95: iconst_0
    //   96: iconst_1
    //   97: invokevirtual 104	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: invokestatic 109	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 113	java/lang/Integer:intValue	()I
    //   106: istore_1
    //   107: lload 4
    //   109: lstore_2
    //   110: aload 8
    //   112: ldc 243
    //   114: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: lload 4
    //   120: lstore_2
    //   121: aload 8
    //   123: ldc 117
    //   125: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: lload 4
    //   131: lstore_2
    //   132: aload 8
    //   134: iload_1
    //   135: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: lload 4
    //   141: lstore_2
    //   142: aload 8
    //   144: ldc 122
    //   146: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: lload 4
    //   152: lstore_2
    //   153: aload 9
    //   155: iconst_1
    //   156: invokevirtual 246	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: invokestatic 98	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   162: invokevirtual 250	java/lang/Long:longValue	()J
    //   165: iload_1
    //   166: lshr
    //   167: lstore 4
    //   169: lload 4
    //   171: lstore_2
    //   172: aload 8
    //   174: ldc 252
    //   176: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: lload 4
    //   182: lstore_2
    //   183: aload 8
    //   185: ldc 117
    //   187: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: lload 4
    //   193: lstore_2
    //   194: aload 8
    //   196: lload 4
    //   198: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: lload 4
    //   204: lstore 6
    //   206: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +55 -> 264
    //   212: lload 4
    //   214: lstore_2
    //   215: ldc 139
    //   217: iconst_2
    //   218: aload 8
    //   220: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: lload_2
    //   227: lstore 6
    //   229: goto +35 -> 264
    //   232: astore_0
    //   233: goto +37 -> 270
    //   236: astore_0
    //   237: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +12 -> 252
    //   243: ldc 139
    //   245: iconst_2
    //   246: ldc 231
    //   248: aload_0
    //   249: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: lload_2
    //   253: lstore 6
    //   255: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +6 -> 264
    //   261: goto -46 -> 215
    //   264: lload 6
    //   266: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   269: areturn
    //   270: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +14 -> 287
    //   276: ldc 139
    //   278: iconst_2
    //   279: aload 8
    //   281: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: goto +5 -> 292
    //   290: aload_0
    //   291: athrow
    //   292: goto -2 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramString	String
    //   106	61	1	i	int
    //   24	229	2	l1	long
    //   20	193	4	l2	long
    //   204	61	6	l3	long
    //   17	263	8	localStringBuilder	StringBuilder
    //   45	109	9	str	String
    // Exception table:
    //   from	to	target	type
    //   25	34	232	finally
    //   37	47	232	finally
    //   50	58	232	finally
    //   61	69	232	finally
    //   72	79	232	finally
    //   82	90	232	finally
    //   93	107	232	finally
    //   110	118	232	finally
    //   121	129	232	finally
    //   132	139	232	finally
    //   142	150	232	finally
    //   153	169	232	finally
    //   172	180	232	finally
    //   183	191	232	finally
    //   194	202	232	finally
    //   237	252	232	finally
    //   25	34	236	java/lang/Exception
    //   37	47	236	java/lang/Exception
    //   50	58	236	java/lang/Exception
    //   61	69	236	java/lang/Exception
    //   72	79	236	java/lang/Exception
    //   82	90	236	java/lang/Exception
    //   93	107	236	java/lang/Exception
    //   110	118	236	java/lang/Exception
    //   121	129	236	java/lang/Exception
    //   132	139	236	java/lang/Exception
    //   142	150	236	java/lang/Exception
    //   153	169	236	java/lang/Exception
    //   172	180	236	java/lang/Exception
    //   183	191	236	java/lang/Exception
    //   194	202	236	java/lang/Exception
  }
  
  /* Error */
  public static byte[] d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: iload_2
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +35 -> 55
    //   23: new 61	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: ldc_w 261
    //   35: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: aload_0
    //   41: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 76
    //   47: iconst_2
    //   48: aload_3
    //   49: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: ldc 200
    //   58: invokevirtual 263	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   61: astore_0
    //   62: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +36 -> 101
    //   68: new 61	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   75: astore_3
    //   76: aload_3
    //   77: ldc_w 265
    //   80: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: aload_0
    //   86: arraylength
    //   87: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: ldc 76
    //   93: iconst_2
    //   94: aload_3
    //   95: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: new 170	java/io/ByteArrayInputStream
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 172	java/io/ByteArrayInputStream:<init>	([B)V
    //   109: astore 6
    //   111: new 19	java/io/ByteArrayOutputStream
    //   114: dup
    //   115: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   118: astore 7
    //   120: aload 4
    //   122: astore_0
    //   123: aload 5
    //   125: astore_3
    //   126: sipush 1024
    //   129: newarray byte
    //   131: astore 8
    //   133: aload 4
    //   135: astore_0
    //   136: aload 5
    //   138: astore_3
    //   139: new 267	java/util/zip/GZIPOutputStream
    //   142: dup
    //   143: aload 7
    //   145: invokespecial 270	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   148: astore 9
    //   150: aload 4
    //   152: astore_0
    //   153: aload 5
    //   155: astore_3
    //   156: aload 6
    //   158: aload 8
    //   160: iconst_0
    //   161: sipush 1024
    //   164: invokevirtual 271	java/io/ByteArrayInputStream:read	([BII)I
    //   167: istore_1
    //   168: iload_1
    //   169: iconst_m1
    //   170: if_icmpeq +21 -> 191
    //   173: aload 4
    //   175: astore_0
    //   176: aload 5
    //   178: astore_3
    //   179: aload 9
    //   181: aload 8
    //   183: iconst_0
    //   184: iload_1
    //   185: invokevirtual 272	java/util/zip/GZIPOutputStream:write	([BII)V
    //   188: goto -38 -> 150
    //   191: aload 4
    //   193: astore_0
    //   194: aload 5
    //   196: astore_3
    //   197: aload 9
    //   199: invokevirtual 275	java/util/zip/GZIPOutputStream:flush	()V
    //   202: aload 4
    //   204: astore_0
    //   205: aload 5
    //   207: astore_3
    //   208: aload 9
    //   210: invokevirtual 276	java/util/zip/GZIPOutputStream:close	()V
    //   213: aload 4
    //   215: astore_0
    //   216: aload 5
    //   218: astore_3
    //   219: aload 7
    //   221: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   224: astore 4
    //   226: aload 4
    //   228: astore_0
    //   229: aload 4
    //   231: astore_3
    //   232: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +65 -> 300
    //   238: aload 4
    //   240: astore_0
    //   241: aload 4
    //   243: astore_3
    //   244: new 61	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   251: astore 5
    //   253: aload 4
    //   255: astore_0
    //   256: aload 4
    //   258: astore_3
    //   259: aload 5
    //   261: ldc_w 278
    //   264: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: astore_0
    //   271: aload 4
    //   273: astore_3
    //   274: aload 5
    //   276: aload 4
    //   278: arraylength
    //   279: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 4
    //   285: astore_0
    //   286: aload 4
    //   288: astore_3
    //   289: ldc 76
    //   291: iconst_2
    //   292: aload 5
    //   294: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 7
    //   302: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   305: aload 6
    //   307: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   310: aload 4
    //   312: areturn
    //   313: astore_3
    //   314: aload 4
    //   316: astore 5
    //   318: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +221 -> 542
    //   324: new 61	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   331: astore 5
    //   333: aload 4
    //   335: astore_0
    //   336: aload 5
    //   338: astore 4
    //   340: aload 4
    //   342: ldc_w 280
    //   345: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 4
    //   351: aload_3
    //   352: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
    //   355: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 76
    //   361: iconst_2
    //   362: aload 4
    //   364: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: areturn
    //   372: astore_0
    //   373: goto +172 -> 545
    //   376: astore_3
    //   377: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +42 -> 422
    //   383: new 61	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   390: astore 4
    //   392: aload 4
    //   394: ldc_w 282
    //   397: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 4
    //   403: aload_3
    //   404: invokevirtual 198	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   407: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 76
    //   413: iconst_2
    //   414: aload 4
    //   416: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload 7
    //   424: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   427: aload 6
    //   429: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   432: aload_0
    //   433: areturn
    //   434: astore_3
    //   435: aload_0
    //   436: astore 5
    //   438: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +101 -> 542
    //   444: new 61	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   451: astore 4
    //   453: goto -113 -> 340
    //   456: astore_0
    //   457: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +42 -> 502
    //   463: new 61	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   470: astore 4
    //   472: aload 4
    //   474: ldc_w 284
    //   477: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 4
    //   483: aload_0
    //   484: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   487: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 76
    //   493: iconst_2
    //   494: aload 4
    //   496: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload 7
    //   504: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   507: aload 6
    //   509: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   512: aload_3
    //   513: areturn
    //   514: astore 6
    //   516: aload_3
    //   517: astore 5
    //   519: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +20 -> 542
    //   525: new 61	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   532: astore 4
    //   534: aload_3
    //   535: astore_0
    //   536: aload 6
    //   538: astore_3
    //   539: goto -199 -> 340
    //   542: aload 5
    //   544: areturn
    //   545: aload 7
    //   547: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   550: aload 6
    //   552: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   555: goto +49 -> 604
    //   558: astore_3
    //   559: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +42 -> 604
    //   565: new 61	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   572: astore 4
    //   574: aload 4
    //   576: ldc_w 280
    //   579: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 4
    //   585: aload_3
    //   586: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
    //   589: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: ldc 76
    //   595: iconst_2
    //   596: aload 4
    //   598: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_0
    //   605: athrow
    //   606: astore_0
    //   607: aload_0
    //   608: invokevirtual 204	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   611: aconst_null
    //   612: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	paramString	String
    //   167	18	1	i	int
    //   4	8	2	bool	boolean
    //   30	259	3	localObject1	Object
    //   313	39	3	localIOException1	java.io.IOException
    //   376	28	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   434	101	3	localIOException2	java.io.IOException
    //   538	1	3	localObject2	Object
    //   558	28	3	localIOException3	java.io.IOException
    //   9	588	4	localObject3	Object
    //   6	537	5	localObject4	Object
    //   109	399	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   514	37	6	localIOException4	java.io.IOException
    //   118	428	7	localByteArrayOutputStream	ByteArrayOutputStream
    //   131	51	8	arrayOfByte	byte[]
    //   148	61	9	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   300	310	313	java/io/IOException
    //   126	133	372	finally
    //   139	150	372	finally
    //   156	168	372	finally
    //   179	188	372	finally
    //   197	202	372	finally
    //   208	213	372	finally
    //   219	226	372	finally
    //   232	238	372	finally
    //   244	253	372	finally
    //   259	268	372	finally
    //   274	283	372	finally
    //   289	300	372	finally
    //   377	422	372	finally
    //   457	502	372	finally
    //   126	133	376	java/lang/OutOfMemoryError
    //   139	150	376	java/lang/OutOfMemoryError
    //   156	168	376	java/lang/OutOfMemoryError
    //   179	188	376	java/lang/OutOfMemoryError
    //   197	202	376	java/lang/OutOfMemoryError
    //   208	213	376	java/lang/OutOfMemoryError
    //   219	226	376	java/lang/OutOfMemoryError
    //   232	238	376	java/lang/OutOfMemoryError
    //   244	253	376	java/lang/OutOfMemoryError
    //   259	268	376	java/lang/OutOfMemoryError
    //   274	283	376	java/lang/OutOfMemoryError
    //   289	300	376	java/lang/OutOfMemoryError
    //   422	432	434	java/io/IOException
    //   126	133	456	java/lang/Exception
    //   139	150	456	java/lang/Exception
    //   156	168	456	java/lang/Exception
    //   179	188	456	java/lang/Exception
    //   197	202	456	java/lang/Exception
    //   208	213	456	java/lang/Exception
    //   219	226	456	java/lang/Exception
    //   232	238	456	java/lang/Exception
    //   244	253	456	java/lang/Exception
    //   259	268	456	java/lang/Exception
    //   274	283	456	java/lang/Exception
    //   289	300	456	java/lang/Exception
    //   502	512	514	java/io/IOException
    //   545	555	558	java/io/IOException
    //   55	62	606	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalUtils
 * JD-Core Version:    0.7.0.1
 */