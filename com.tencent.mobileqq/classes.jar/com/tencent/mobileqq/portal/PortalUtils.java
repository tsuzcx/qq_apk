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
  private static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3 };
  }
  
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
    if (jdField_a_of_type_JavaSecurityMessageDigest == null) {
      try
      {
        jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
    return MD5FileUtil.b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   20: ifeq +34 -> 54
    //   23: new 61	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: ldc 195
    //   34: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: aload_0
    //   40: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 76
    //   46: iconst_2
    //   47: aload_3
    //   48: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: ldc 197
    //   57: invokevirtual 199	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   60: astore_0
    //   61: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +35 -> 99
    //   67: new 61	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: ldc 201
    //   78: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: aload_0
    //   84: arraylength
    //   85: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 76
    //   91: iconst_2
    //   92: aload_3
    //   93: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: new 203	java/io/ByteArrayInputStream
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 205	java/io/ByteArrayInputStream:<init>	([B)V
    //   107: astore 6
    //   109: new 18	java/io/ByteArrayOutputStream
    //   112: dup
    //   113: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
    //   116: astore 7
    //   118: aload 4
    //   120: astore_0
    //   121: aload 5
    //   123: astore_3
    //   124: sipush 1024
    //   127: newarray byte
    //   129: astore 8
    //   131: aload 4
    //   133: astore_0
    //   134: aload 5
    //   136: astore_3
    //   137: new 207	java/util/zip/GZIPOutputStream
    //   140: dup
    //   141: aload 7
    //   143: invokespecial 210	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore 9
    //   148: aload 4
    //   150: astore_0
    //   151: aload 5
    //   153: astore_3
    //   154: aload 6
    //   156: aload 8
    //   158: iconst_0
    //   159: sipush 1024
    //   162: invokevirtual 214	java/io/ByteArrayInputStream:read	([BII)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +21 -> 189
    //   171: aload 4
    //   173: astore_0
    //   174: aload 5
    //   176: astore_3
    //   177: aload 9
    //   179: aload 8
    //   181: iconst_0
    //   182: iload_1
    //   183: invokevirtual 218	java/util/zip/GZIPOutputStream:write	([BII)V
    //   186: goto -38 -> 148
    //   189: aload 4
    //   191: astore_0
    //   192: aload 5
    //   194: astore_3
    //   195: aload 9
    //   197: invokevirtual 221	java/util/zip/GZIPOutputStream:flush	()V
    //   200: aload 4
    //   202: astore_0
    //   203: aload 5
    //   205: astore_3
    //   206: aload 9
    //   208: invokevirtual 224	java/util/zip/GZIPOutputStream:close	()V
    //   211: aload 4
    //   213: astore_0
    //   214: aload 5
    //   216: astore_3
    //   217: aload 7
    //   219: invokevirtual 35	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: astore 4
    //   224: aload 4
    //   226: astore_0
    //   227: aload 4
    //   229: astore_3
    //   230: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +64 -> 297
    //   236: aload 4
    //   238: astore_0
    //   239: aload 4
    //   241: astore_3
    //   242: new 61	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   249: astore 5
    //   251: aload 4
    //   253: astore_0
    //   254: aload 4
    //   256: astore_3
    //   257: aload 5
    //   259: ldc 226
    //   261: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 4
    //   267: astore_0
    //   268: aload 4
    //   270: astore_3
    //   271: aload 5
    //   273: aload 4
    //   275: arraylength
    //   276: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 4
    //   282: astore_0
    //   283: aload 4
    //   285: astore_3
    //   286: ldc 76
    //   288: iconst_2
    //   289: aload 5
    //   291: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload 7
    //   299: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   302: aload 6
    //   304: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   307: aload 4
    //   309: areturn
    //   310: astore_3
    //   311: aload 4
    //   313: astore 5
    //   315: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +218 -> 536
    //   321: new 61	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   328: astore 5
    //   330: aload 4
    //   332: astore_0
    //   333: aload 5
    //   335: astore 4
    //   337: aload 4
    //   339: ldc 230
    //   341: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 4
    //   347: aload_3
    //   348: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   351: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: ldc 76
    //   357: iconst_2
    //   358: aload 4
    //   360: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: areturn
    //   368: astore_0
    //   369: goto +170 -> 539
    //   372: astore_3
    //   373: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +41 -> 417
    //   379: new 61	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   386: astore 4
    //   388: aload 4
    //   390: ldc 233
    //   392: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: aload_3
    //   399: invokevirtual 234	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   402: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 76
    //   408: iconst_2
    //   409: aload 4
    //   411: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload 7
    //   419: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   422: aload 6
    //   424: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   427: aload_0
    //   428: areturn
    //   429: astore_3
    //   430: aload_0
    //   431: astore 5
    //   433: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +100 -> 536
    //   439: new 61	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   446: astore 4
    //   448: goto -111 -> 337
    //   451: astore_0
    //   452: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +41 -> 496
    //   458: new 61	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   465: astore 4
    //   467: aload 4
    //   469: ldc 236
    //   471: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 4
    //   477: aload_0
    //   478: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: ldc 76
    //   487: iconst_2
    //   488: aload 4
    //   490: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 7
    //   498: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   501: aload 6
    //   503: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   506: aload_3
    //   507: areturn
    //   508: astore 6
    //   510: aload_3
    //   511: astore 5
    //   513: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +20 -> 536
    //   519: new 61	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   526: astore 4
    //   528: aload_3
    //   529: astore_0
    //   530: aload 6
    //   532: astore_3
    //   533: goto -196 -> 337
    //   536: aload 5
    //   538: areturn
    //   539: aload 7
    //   541: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   544: aload 6
    //   546: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   549: goto +48 -> 597
    //   552: astore_3
    //   553: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +41 -> 597
    //   559: new 61	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   566: astore 4
    //   568: aload 4
    //   570: ldc 230
    //   572: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 4
    //   578: aload_3
    //   579: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   582: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: ldc 76
    //   588: iconst_2
    //   589: aload 4
    //   591: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_0
    //   598: athrow
    //   599: astore_0
    //   600: aload_0
    //   601: invokevirtual 237	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   604: aconst_null
    //   605: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	paramString	String
    //   165	18	1	i	int
    //   4	8	2	bool	boolean
    //   30	256	3	localObject1	Object
    //   310	38	3	localIOException1	java.io.IOException
    //   372	27	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   429	100	3	localIOException2	java.io.IOException
    //   532	1	3	localObject2	Object
    //   552	27	3	localIOException3	java.io.IOException
    //   9	581	4	localObject3	Object
    //   6	531	5	localObject4	Object
    //   107	395	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   508	37	6	localIOException4	java.io.IOException
    //   116	424	7	localByteArrayOutputStream	ByteArrayOutputStream
    //   129	51	8	arrayOfByte	byte[]
    //   146	61	9	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   297	307	310	java/io/IOException
    //   124	131	368	finally
    //   137	148	368	finally
    //   154	166	368	finally
    //   177	186	368	finally
    //   195	200	368	finally
    //   206	211	368	finally
    //   217	224	368	finally
    //   230	236	368	finally
    //   242	251	368	finally
    //   257	265	368	finally
    //   271	280	368	finally
    //   286	297	368	finally
    //   373	417	368	finally
    //   452	496	368	finally
    //   124	131	372	java/lang/OutOfMemoryError
    //   137	148	372	java/lang/OutOfMemoryError
    //   154	166	372	java/lang/OutOfMemoryError
    //   177	186	372	java/lang/OutOfMemoryError
    //   195	200	372	java/lang/OutOfMemoryError
    //   206	211	372	java/lang/OutOfMemoryError
    //   217	224	372	java/lang/OutOfMemoryError
    //   230	236	372	java/lang/OutOfMemoryError
    //   242	251	372	java/lang/OutOfMemoryError
    //   257	265	372	java/lang/OutOfMemoryError
    //   271	280	372	java/lang/OutOfMemoryError
    //   286	297	372	java/lang/OutOfMemoryError
    //   417	427	429	java/io/IOException
    //   124	131	451	java/lang/Exception
    //   137	148	451	java/lang/Exception
    //   154	166	451	java/lang/Exception
    //   177	186	451	java/lang/Exception
    //   195	200	451	java/lang/Exception
    //   206	211	451	java/lang/Exception
    //   217	224	451	java/lang/Exception
    //   230	236	451	java/lang/Exception
    //   242	251	451	java/lang/Exception
    //   257	265	451	java/lang/Exception
    //   271	280	451	java/lang/Exception
    //   286	297	451	java/lang/Exception
    //   496	506	508	java/io/IOException
    //   539	549	552	java/io/IOException
    //   54	61	599	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 239
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
    //   30: invokestatic 243	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   33: astore_0
    //   34: lload 4
    //   36: lstore_2
    //   37: new 100	java/lang/String
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 244	java/lang/String:<init>	([B)V
    //   45: astore 9
    //   47: lload 4
    //   49: lstore_2
    //   50: aload 8
    //   52: ldc 246
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
    //   75: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   112: ldc 251
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
    //   156: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: invokestatic 98	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   162: invokevirtual 258	java/lang/Long:longValue	()J
    //   165: iload_1
    //   166: lshr
    //   167: lstore 4
    //   169: lload 4
    //   171: lstore_2
    //   172: aload 8
    //   174: ldc_w 260
    //   177: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: lload 4
    //   183: lstore_2
    //   184: aload 8
    //   186: ldc 117
    //   188: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: lload 4
    //   194: lstore_2
    //   195: aload 8
    //   197: lload 4
    //   199: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: lload 4
    //   205: lstore 6
    //   207: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +55 -> 265
    //   213: lload 4
    //   215: lstore_2
    //   216: ldc 139
    //   218: iconst_2
    //   219: aload 8
    //   221: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: lload_2
    //   228: lstore 6
    //   230: goto +35 -> 265
    //   233: astore_0
    //   234: goto +37 -> 271
    //   237: astore_0
    //   238: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +12 -> 253
    //   244: ldc 139
    //   246: iconst_2
    //   247: ldc 239
    //   249: aload_0
    //   250: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: lload_2
    //   254: lstore 6
    //   256: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +6 -> 265
    //   262: goto -46 -> 216
    //   265: lload 6
    //   267: invokestatic 266	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   270: areturn
    //   271: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +14 -> 288
    //   277: ldc 139
    //   279: iconst_2
    //   280: aload 8
    //   282: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: goto +5 -> 293
    //   291: aload_0
    //   292: athrow
    //   293: goto -2 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString	String
    //   106	61	1	i	int
    //   24	230	2	l1	long
    //   20	194	4	l2	long
    //   205	61	6	l3	long
    //   17	264	8	localStringBuilder	StringBuilder
    //   45	109	9	str	String
    // Exception table:
    //   from	to	target	type
    //   25	34	233	finally
    //   37	47	233	finally
    //   50	58	233	finally
    //   61	69	233	finally
    //   72	79	233	finally
    //   82	90	233	finally
    //   93	107	233	finally
    //   110	118	233	finally
    //   121	129	233	finally
    //   132	139	233	finally
    //   142	150	233	finally
    //   153	169	233	finally
    //   172	181	233	finally
    //   184	192	233	finally
    //   195	203	233	finally
    //   238	253	233	finally
    //   25	34	237	java/lang/Exception
    //   37	47	237	java/lang/Exception
    //   50	58	237	java/lang/Exception
    //   61	69	237	java/lang/Exception
    //   72	79	237	java/lang/Exception
    //   82	90	237	java/lang/Exception
    //   93	107	237	java/lang/Exception
    //   110	118	237	java/lang/Exception
    //   121	129	237	java/lang/Exception
    //   132	139	237	java/lang/Exception
    //   142	150	237	java/lang/Exception
    //   153	169	237	java/lang/Exception
    //   172	181	237	java/lang/Exception
    //   184	192	237	java/lang/Exception
    //   195	203	237	java/lang/Exception
  }
  
  /* Error */
  public static String b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 203	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 205	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 18	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore 4
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore_0
    //   30: new 268	java/util/zip/GZIPInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 271	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: aload_0
    //   41: iconst_0
    //   42: sipush 1024
    //   45: invokevirtual 272	java/util/zip/GZIPInputStream:read	([BII)I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_m1
    //   51: if_icmpeq +14 -> 65
    //   54: aload 4
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_1
    //   59: invokevirtual 273	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -23 -> 39
    //   65: aload_2
    //   66: invokevirtual 274	java/util/zip/GZIPInputStream:close	()V
    //   69: aload 4
    //   71: invokevirtual 35	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   74: astore_0
    //   75: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +36 -> 114
    //   81: new 61	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: ldc_w 276
    //   93: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: aload_0
    //   99: arraylength
    //   100: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 76
    //   106: iconst_2
    //   107: aload_2
    //   108: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   119: aload_3
    //   120: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   123: aload_0
    //   124: astore_2
    //   125: goto +228 -> 353
    //   128: astore_3
    //   129: aload_0
    //   130: astore_2
    //   131: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +219 -> 353
    //   137: new 61	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   144: astore_2
    //   145: aload_2
    //   146: ldc_w 278
    //   149: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: ldc 76
    //   164: iconst_2
    //   165: aload_2
    //   166: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: astore_2
    //   174: goto +179 -> 353
    //   177: astore_2
    //   178: goto +14 -> 192
    //   181: astore_2
    //   182: goto +92 -> 274
    //   185: astore_0
    //   186: goto +198 -> 384
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_0
    //   192: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +42 -> 237
    //   198: new 61	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   205: astore 5
    //   207: aload 5
    //   209: ldc_w 280
    //   212: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: aload_2
    //   219: invokevirtual 234	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   222: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 76
    //   228: iconst_2
    //   229: aload 5
    //   231: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload 4
    //   239: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   242: aload_3
    //   243: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   246: aload_0
    //   247: astore_2
    //   248: goto +105 -> 353
    //   251: astore_3
    //   252: aload_0
    //   253: astore_2
    //   254: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +96 -> 353
    //   260: new 61	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   267: astore_2
    //   268: goto -123 -> 145
    //   271: astore_2
    //   272: aconst_null
    //   273: astore_0
    //   274: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +42 -> 319
    //   280: new 61	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   287: astore 5
    //   289: aload 5
    //   291: ldc_w 280
    //   294: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 5
    //   300: aload_2
    //   301: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 76
    //   310: iconst_2
    //   311: aload 5
    //   313: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   324: aload_3
    //   325: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   328: aload_0
    //   329: astore_2
    //   330: goto +23 -> 353
    //   333: astore_3
    //   334: aload_0
    //   335: astore_2
    //   336: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +14 -> 353
    //   342: new 61	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   349: astore_2
    //   350: goto -205 -> 145
    //   353: aload_2
    //   354: ifnull +28 -> 382
    //   357: new 100	java/lang/String
    //   360: dup
    //   361: aload_2
    //   362: ldc 197
    //   364: invokespecial 283	java/lang/String:<init>	([BLjava/lang/String;)V
    //   367: astore_0
    //   368: aload_0
    //   369: areturn
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore_0
    //   378: aload_0
    //   379: invokevirtual 237	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   382: aconst_null
    //   383: areturn
    //   384: aload 4
    //   386: invokevirtual 227	java/io/ByteArrayOutputStream:close	()V
    //   389: aload_3
    //   390: invokevirtual 228	java/io/ByteArrayInputStream:close	()V
    //   393: goto +45 -> 438
    //   396: astore_2
    //   397: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +38 -> 438
    //   403: new 61	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   410: astore_3
    //   411: aload_3
    //   412: ldc_w 278
    //   415: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_3
    //   420: aload_2
    //   421: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   424: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: ldc 76
    //   430: iconst_2
    //   431: aload_3
    //   432: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: goto +5 -> 443
    //   441: aload_0
    //   442: athrow
    //   443: goto -2 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramArrayOfByte	byte[]
    //   48	11	1	i	int
    //   38	136	2	localObject1	Object
    //   177	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   181	1	2	localException1	Exception
    //   189	30	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   247	21	2	localObject2	Object
    //   271	30	2	localException2	Exception
    //   329	33	2	localObject3	Object
    //   396	25	2	localIOException1	java.io.IOException
    //   14	106	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   128	115	3	localIOException2	java.io.IOException
    //   251	74	3	localIOException3	java.io.IOException
    //   333	57	3	localIOException4	java.io.IOException
    //   410	22	3	localStringBuilder1	StringBuilder
    //   22	363	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   205	107	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   114	123	128	java/io/IOException
    //   75	114	177	java/lang/OutOfMemoryError
    //   75	114	181	java/lang/Exception
    //   24	39	185	finally
    //   39	49	185	finally
    //   54	62	185	finally
    //   65	75	185	finally
    //   75	114	185	finally
    //   192	237	185	finally
    //   274	319	185	finally
    //   24	39	189	java/lang/OutOfMemoryError
    //   39	49	189	java/lang/OutOfMemoryError
    //   54	62	189	java/lang/OutOfMemoryError
    //   65	75	189	java/lang/OutOfMemoryError
    //   237	246	251	java/io/IOException
    //   24	39	271	java/lang/Exception
    //   39	49	271	java/lang/Exception
    //   54	62	271	java/lang/Exception
    //   65	75	271	java/lang/Exception
    //   319	328	333	java/io/IOException
    //   357	368	370	java/lang/Exception
    //   357	368	377	java/io/UnsupportedEncodingException
    //   384	393	396	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalUtils
 * JD-Core Version:    0.7.0.1
 */