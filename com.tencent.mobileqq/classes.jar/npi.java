import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class npi
{
  protected static String a;
  private static char[] a;
  private static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  }
  
  public static String a(BufferedInputStream paramBufferedInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 41	java/io/BufferedInputStream
    //   3: dup
    //   4: new 75	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 90	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +28 -> 62
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 93	java/security/MessageDigest:update	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 96	java/io/InputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 96	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 100	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 103	npi:a	([B)Ljava/lang/String;
    //   77: areturn
    //   78: astore_0
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -37 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   32	9	2	i	int
    //   21	18	3	arrayOfByte	byte[]
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   66	70	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   0	16	86	finally
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(jdField_a_of_type_JavaLangString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label14:
      break label14;
    }
    bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("offlneSecurity", 2, "report:" + paramInt);
    }
  }
  
  private static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    jdField_a_of_type_JavaLangString = str;
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 149
    //   10: iconst_2
    //   11: ldc 169
    //   13: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 174	java/io/File
    //   19: dup
    //   20: new 105	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   27: aload_0
    //   28: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 176
    //   33: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 180	java/io/File:exists	()Z
    //   47: ifne +19 -> 66
    //   50: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +11 -> 64
    //   56: ldc 149
    //   58: iconst_2
    //   59: ldc 182
    //   61: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: new 41	java/io/BufferedInputStream
    //   69: dup
    //   70: new 75	java/io/FileInputStream
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_3
    //   82: aload_3
    //   83: invokestatic 188	npi:a	(Ljava/io/BufferedInputStream;)[B
    //   86: astore 4
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   96: new 174	java/io/File
    //   99: dup
    //   100: new 105	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   107: aload_0
    //   108: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 191
    //   113: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 180	java/io/File:exists	()Z
    //   127: ifne +82 -> 209
    //   130: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -69 -> 64
    //   136: ldc 149
    //   138: iconst_2
    //   139: ldc 193
    //   141: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +11 -> 161
    //   153: ldc 149
    //   155: iconst_2
    //   156: ldc 195
    //   158: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: iconst_1
    //   162: invokestatic 197	npi:a	(I)V
    //   165: aload_0
    //   166: invokevirtual 198	java/io/FileNotFoundException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_2
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +11 -> 199
    //   191: ldc 149
    //   193: iconst_2
    //   194: ldc 200
    //   196: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_2
    //   200: invokestatic 197	npi:a	(I)V
    //   203: aload_0
    //   204: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: new 41	java/io/BufferedInputStream
    //   212: dup
    //   213: new 75	java/io/FileInputStream
    //   216: dup
    //   217: aload_0
    //   218: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   221: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   224: astore_0
    //   225: aload_0
    //   226: invokestatic 188	npi:a	(Ljava/io/BufferedInputStream;)[B
    //   229: astore_2
    //   230: aload_0
    //   231: ifnull +7 -> 238
    //   234: aload_0
    //   235: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   238: getstatic 14	npi:b	Ljava/lang/String;
    //   241: aload 4
    //   243: aload_2
    //   244: invokestatic 204	npi:a	(Ljava/lang/String;[B[B)Z
    //   247: istore_1
    //   248: iload_1
    //   249: ireturn
    //   250: astore_0
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   259: aload_0
    //   260: athrow
    //   261: astore_3
    //   262: goto -166 -> 96
    //   265: astore_2
    //   266: goto -84 -> 182
    //   269: astore_0
    //   270: goto -32 -> 238
    //   273: astore_2
    //   274: goto -15 -> 259
    //   277: astore_3
    //   278: aload_0
    //   279: astore_2
    //   280: aload_3
    //   281: astore_0
    //   282: goto -31 -> 251
    //   285: astore_0
    //   286: aload_3
    //   287: astore_2
    //   288: goto -114 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramString	String
    //   247	2	1	bool	boolean
    //   1	255	2	arrayOfByte1	byte[]
    //   265	1	2	localIOException1	java.io.IOException
    //   273	1	2	localIOException2	java.io.IOException
    //   279	9	2	localObject1	Object
    //   42	51	3	localObject2	Object
    //   261	1	3	localIOException3	java.io.IOException
    //   277	10	3	localObject3	Object
    //   86	156	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	64	146	java/io/FileNotFoundException
    //   92	96	146	java/io/FileNotFoundException
    //   96	144	146	java/io/FileNotFoundException
    //   178	182	146	java/io/FileNotFoundException
    //   182	184	146	java/io/FileNotFoundException
    //   234	238	146	java/io/FileNotFoundException
    //   238	248	146	java/io/FileNotFoundException
    //   255	259	146	java/io/FileNotFoundException
    //   259	261	146	java/io/FileNotFoundException
    //   66	82	171	finally
    //   16	64	184	java/io/IOException
    //   96	144	184	java/io/IOException
    //   182	184	184	java/io/IOException
    //   238	248	184	java/io/IOException
    //   259	261	184	java/io/IOException
    //   209	225	250	finally
    //   92	96	261	java/io/IOException
    //   178	182	265	java/io/IOException
    //   234	238	269	java/io/IOException
    //   255	259	273	java/io/IOException
    //   225	230	277	finally
    //   82	88	285	finally
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verify");
    }
    a(paramString2);
    if (a(paramString1)) {
      return b(paramString1);
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString3);
    if (a(paramString1)) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify");
      }
      paramString = bfuc.decode(paramString.getBytes("UTF-8"), 0);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localKeyFactory.generatePublic(new X509EncodedKeySpec(paramString)));
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify error:" + paramString.toString());
      }
      paramString.printStackTrace();
      a(4);
    }
    return false;
  }
  
  public static byte[] a(BufferedInputStream paramBufferedInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramBufferedInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramBufferedInputStream;
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 149
    //   8: iconst_2
    //   9: ldc_w 279
    //   12: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_3
    //   22: new 41	java/io/BufferedInputStream
    //   25: dup
    //   26: new 75	java/io/FileInputStream
    //   29: dup
    //   30: new 105	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 176
    //   43: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   52: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: new 281	org/json/JSONObject
    //   61: dup
    //   62: aload_1
    //   63: invokestatic 283	npi:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   66: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   78: aload_3
    //   79: invokevirtual 288	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   82: astore_1
    //   83: aload_1
    //   84: invokeinterface 293 1 0
    //   89: ifeq +289 -> 378
    //   92: aload_1
    //   93: invokeinterface 297 1 0
    //   98: invokevirtual 298	java/lang/Object:toString	()Ljava/lang/String;
    //   101: astore_2
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 301	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: new 105	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   114: aload_0
    //   115: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   121: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 306	npi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifne -54 -> 83
    //   140: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +29 -> 172
    //   146: ldc 149
    //   148: iconst_2
    //   149: new 105	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 312
    //   159: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: bipush 6
    //   174: invokestatic 197	npi:a	(I)V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: astore_2
    //   184: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +14 -> 201
    //   190: aload_1
    //   191: astore_2
    //   192: ldc 149
    //   194: iconst_2
    //   195: ldc_w 314
    //   198: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_1
    //   202: astore_2
    //   203: iconst_1
    //   204: invokestatic 197	npi:a	(I)V
    //   207: aload_1
    //   208: astore_2
    //   209: aload_0
    //   210: invokevirtual 198	java/io/FileNotFoundException:printStackTrace	()V
    //   213: aload_1
    //   214: ifnull -37 -> 177
    //   217: aload_1
    //   218: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_0
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aload_3
    //   228: astore_0
    //   229: aload_0
    //   230: astore_2
    //   231: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +14 -> 248
    //   237: aload_0
    //   238: astore_2
    //   239: ldc 149
    //   241: iconst_2
    //   242: ldc_w 316
    //   245: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_0
    //   249: astore_2
    //   250: iconst_3
    //   251: invokestatic 197	npi:a	(I)V
    //   254: aload_0
    //   255: astore_2
    //   256: aload_1
    //   257: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   260: aload_0
    //   261: ifnull -84 -> 177
    //   264: aload_0
    //   265: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: aload 4
    //   276: astore_0
    //   277: aload_0
    //   278: astore_2
    //   279: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +14 -> 296
    //   285: aload_0
    //   286: astore_2
    //   287: ldc 149
    //   289: iconst_2
    //   290: ldc_w 319
    //   293: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: astore_2
    //   298: iconst_2
    //   299: invokestatic 197	npi:a	(I)V
    //   302: aload_0
    //   303: astore_2
    //   304: aload_1
    //   305: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   308: aload_0
    //   309: ifnull -132 -> 177
    //   312: aload_0
    //   313: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   316: iconst_0
    //   317: ireturn
    //   318: astore_0
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_0
    //   322: aload_2
    //   323: ifnull +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   330: aload_0
    //   331: athrow
    //   332: astore 4
    //   334: aload 4
    //   336: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   339: iconst_5
    //   340: invokestatic 197	npi:a	(I)V
    //   343: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -263 -> 83
    //   349: ldc 149
    //   351: iconst_2
    //   352: new 105	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 321
    //   362: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_2
    //   366: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -292 -> 83
    //   378: iconst_1
    //   379: ireturn
    //   380: astore_1
    //   381: goto -303 -> 78
    //   384: astore_1
    //   385: goto -55 -> 330
    //   388: astore_0
    //   389: goto -67 -> 322
    //   392: astore_2
    //   393: aload_1
    //   394: astore_0
    //   395: aload_2
    //   396: astore_1
    //   397: goto -120 -> 277
    //   400: astore_2
    //   401: aload_1
    //   402: astore_0
    //   403: aload_2
    //   404: astore_1
    //   405: goto -176 -> 229
    //   408: astore_0
    //   409: goto -227 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramString	String
    //   55	163	1	localObject1	Object
    //   226	31	1	localJSONException1	org.json.JSONException
    //   273	32	1	localIOException1	java.io.IOException
    //   380	1	1	localIOException2	java.io.IOException
    //   384	10	1	localIOException3	java.io.IOException
    //   396	9	1	localObject2	Object
    //   19	347	2	localObject3	Object
    //   392	4	2	localIOException4	java.io.IOException
    //   400	4	2	localJSONException2	org.json.JSONException
    //   21	207	3	localJSONObject	org.json.JSONObject
    //   16	259	4	localObject4	Object
    //   332	3	4	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   22	56	179	java/io/FileNotFoundException
    //   217	221	223	java/io/IOException
    //   22	56	226	org/json/JSONException
    //   264	268	270	java/io/IOException
    //   22	56	273	java/io/IOException
    //   312	316	318	java/io/IOException
    //   22	56	321	finally
    //   231	237	321	finally
    //   239	248	321	finally
    //   250	254	321	finally
    //   256	260	321	finally
    //   279	285	321	finally
    //   287	296	321	finally
    //   298	302	321	finally
    //   304	308	321	finally
    //   102	172	332	org/json/JSONException
    //   172	177	332	org/json/JSONException
    //   74	78	380	java/io/IOException
    //   326	330	384	java/io/IOException
    //   58	70	388	finally
    //   184	190	388	finally
    //   192	201	388	finally
    //   203	207	388	finally
    //   209	213	388	finally
    //   58	70	392	java/io/IOException
    //   58	70	400	org/json/JSONException
    //   58	70	408	java/io/FileNotFoundException
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    a(paramString2);
    return a(paramString1);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
    }
    a(paramString3);
    if (a(paramString2)) {
      return c(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +39 -> 53
    //   17: ldc 149
    //   19: iconst_2
    //   20: new 105	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 329
    //   30: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 331
    //   40: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +10 -> 67
    //   60: aload_1
    //   61: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +5 -> 69
    //   67: iconst_0
    //   68: ireturn
    //   69: new 174	java/io/File
    //   72: dup
    //   73: new 105	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   80: aload_0
    //   81: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: invokevirtual 180	java/io/File:exists	()Z
    //   103: ifeq -36 -> 67
    //   106: new 41	java/io/BufferedInputStream
    //   109: dup
    //   110: new 75	java/io/FileInputStream
    //   113: dup
    //   114: new 105	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   121: aload_0
    //   122: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 339
    //   134: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   143: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   146: astore 4
    //   148: new 281	org/json/JSONObject
    //   151: dup
    //   152: aload 4
    //   154: invokestatic 283	npi:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   157: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload 4
    //   163: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   166: aload_3
    //   167: ldc_w 341
    //   170: invokevirtual 345	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 5
    //   175: aload_3
    //   176: ldc_w 347
    //   179: invokevirtual 345	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   182: astore 6
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   194: new 349	java/util/HashMap
    //   197: dup
    //   198: invokespecial 350	java/util/HashMap:<init>	()V
    //   201: astore 4
    //   203: aload 5
    //   205: ifnull +234 -> 439
    //   208: aload 5
    //   210: invokevirtual 288	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   213: astore 7
    //   215: aload 7
    //   217: invokeinterface 293 1 0
    //   222: ifeq +217 -> 439
    //   225: aload 7
    //   227: invokeinterface 297 1 0
    //   232: invokevirtual 298	java/lang/Object:toString	()Ljava/lang/String;
    //   235: astore 8
    //   237: aload 5
    //   239: aload 8
    //   241: invokevirtual 301	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore_3
    //   245: aload_3
    //   246: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne -34 -> 215
    //   252: aload 4
    //   254: aload 8
    //   256: aload_3
    //   257: invokeinterface 356 3 0
    //   262: pop
    //   263: goto -48 -> 215
    //   266: astore_3
    //   267: aload_3
    //   268: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   271: goto -77 -> 194
    //   274: astore_1
    //   275: aload 5
    //   277: astore_0
    //   278: aload_0
    //   279: astore_3
    //   280: iconst_1
    //   281: invokestatic 197	npi:a	(I)V
    //   284: aload_0
    //   285: astore_3
    //   286: aload_1
    //   287: invokevirtual 198	java/io/FileNotFoundException:printStackTrace	()V
    //   290: aload_0
    //   291: ifnull -224 -> 67
    //   294: aload_0
    //   295: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   305: iconst_0
    //   306: ireturn
    //   307: astore_1
    //   308: aload 6
    //   310: astore_0
    //   311: aload_0
    //   312: astore_3
    //   313: iconst_3
    //   314: invokestatic 197	npi:a	(I)V
    //   317: aload_0
    //   318: astore_3
    //   319: aload_1
    //   320: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   323: aload_0
    //   324: ifnull -257 -> 67
    //   327: aload_0
    //   328: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: aload_0
    //   335: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   338: iconst_0
    //   339: ireturn
    //   340: astore_1
    //   341: aload 7
    //   343: astore_0
    //   344: aload_0
    //   345: astore_3
    //   346: iconst_2
    //   347: invokestatic 197	npi:a	(I)V
    //   350: aload_0
    //   351: astore_3
    //   352: aload_1
    //   353: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   356: aload_0
    //   357: ifnull -290 -> 67
    //   360: aload_0
    //   361: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   371: iconst_0
    //   372: ireturn
    //   373: astore_0
    //   374: aload_3
    //   375: ifnull +7 -> 382
    //   378: aload_3
    //   379: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   382: aload_0
    //   383: athrow
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   389: goto -7 -> 382
    //   392: astore_3
    //   393: aload_3
    //   394: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   397: iconst_5
    //   398: invokestatic 197	npi:a	(I)V
    //   401: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +30 -> 434
    //   407: ldc 149
    //   409: iconst_2
    //   410: new 105	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 358
    //   420: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 8
    //   425: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aconst_null
    //   435: astore_3
    //   436: goto -191 -> 245
    //   439: aload 6
    //   441: ifnull +541 -> 982
    //   444: aload 6
    //   446: invokevirtual 288	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   449: astore_3
    //   450: aload_3
    //   451: invokeinterface 293 1 0
    //   456: ifeq +526 -> 982
    //   459: aload_3
    //   460: invokeinterface 297 1 0
    //   465: invokevirtual 298	java/lang/Object:toString	()Ljava/lang/String;
    //   468: astore 5
    //   470: aload 5
    //   472: ifnull -22 -> 450
    //   475: aload_1
    //   476: aload 5
    //   478: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   481: ifeq -31 -> 450
    //   484: aload 4
    //   486: aload_1
    //   487: invokeinterface 362 2 0
    //   492: checkcast 47	java/lang/String
    //   495: astore_3
    //   496: new 105	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   503: aload_0
    //   504: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   510: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 306	npi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore_1
    //   524: aload_3
    //   525: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifne +11 -> 539
    //   531: aload_3
    //   532: aload_1
    //   533: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   536: ifne +58 -> 594
    //   539: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq -475 -> 67
    //   545: ldc 149
    //   547: iconst_2
    //   548: new 105	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 364
    //   558: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 5
    //   563: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc_w 366
    //   569: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_3
    //   573: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 368
    //   579: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_1
    //   583: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: iconst_0
    //   593: ireturn
    //   594: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +36 -> 633
    //   600: ldc 149
    //   602: iconst_2
    //   603: new 105	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 370
    //   613: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 5
    //   618: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc_w 372
    //   624: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload 6
    //   635: aload 5
    //   637: invokevirtual 376	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   640: astore_3
    //   641: aload_3
    //   642: ifnull +340 -> 982
    //   645: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +43 -> 691
    //   651: ldc 149
    //   653: iconst_2
    //   654: new 105	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 370
    //   664: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 5
    //   669: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc_w 378
    //   675: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_3
    //   679: invokevirtual 381	org/json/JSONArray:toString	()Ljava/lang/String;
    //   682: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: iconst_0
    //   692: istore_2
    //   693: iload_2
    //   694: aload_3
    //   695: invokevirtual 384	org/json/JSONArray:length	()I
    //   698: if_icmpge +284 -> 982
    //   701: aload_3
    //   702: iload_2
    //   703: invokevirtual 387	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   706: astore_1
    //   707: aload_1
    //   708: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   711: ifne +206 -> 917
    //   714: aload 4
    //   716: aload_1
    //   717: invokeinterface 362 2 0
    //   722: checkcast 47	java/lang/String
    //   725: astore 6
    //   727: new 105	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   734: aload_0
    //   735: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   741: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_1
    //   745: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 306	npi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   754: astore 7
    //   756: aload 6
    //   758: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   761: ifne +13 -> 774
    //   764: aload 6
    //   766: aload 7
    //   768: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   771: ifne +146 -> 917
    //   774: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq -710 -> 67
    //   780: ldc 149
    //   782: iconst_2
    //   783: new 105	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   790: ldc_w 389
    //   793: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload 5
    //   798: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: ldc_w 391
    //   804: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload_1
    //   808: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 393
    //   814: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 6
    //   819: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: ldc_w 395
    //   825: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 7
    //   830: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: iconst_0
    //   840: ireturn
    //   841: astore_1
    //   842: aload_1
    //   843: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   846: iconst_5
    //   847: invokestatic 197	npi:a	(I)V
    //   850: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +30 -> 883
    //   856: ldc 149
    //   858: iconst_2
    //   859: new 105	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 358
    //   869: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 5
    //   874: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: aconst_null
    //   884: astore_3
    //   885: goto -244 -> 641
    //   888: astore_1
    //   889: aload_1
    //   890: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   893: iconst_5
    //   894: invokestatic 197	npi:a	(I)V
    //   897: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +12 -> 912
    //   903: ldc 149
    //   905: iconst_2
    //   906: ldc_w 397
    //   909: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aconst_null
    //   913: astore_1
    //   914: goto -207 -> 707
    //   917: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +48 -> 968
    //   923: new 105	java/lang/StringBuilder
    //   926: dup
    //   927: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   930: ldc_w 399
    //   933: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 5
    //   938: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: ldc_w 401
    //   944: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: astore 6
    //   949: aload_1
    //   950: ifnull +25 -> 975
    //   953: ldc 149
    //   955: iconst_2
    //   956: aload 6
    //   958: aload_1
    //   959: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: iload_2
    //   969: iconst_1
    //   970: iadd
    //   971: istore_2
    //   972: goto -279 -> 693
    //   975: ldc_w 403
    //   978: astore_1
    //   979: goto -26 -> 953
    //   982: iconst_1
    //   983: ireturn
    //   984: astore_0
    //   985: aload 4
    //   987: astore_3
    //   988: goto -614 -> 374
    //   991: astore_1
    //   992: aload 4
    //   994: astore_0
    //   995: goto -651 -> 344
    //   998: astore_1
    //   999: aload 4
    //   1001: astore_0
    //   1002: goto -691 -> 311
    //   1005: astore_1
    //   1006: aload 4
    //   1008: astore_0
    //   1009: goto -731 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1012	0	paramString1	String
    //   0	1012	1	paramString2	String
    //   692	280	2	i	int
    //   7	250	3	localObject1	Object
    //   266	2	3	localIOException	java.io.IOException
    //   279	100	3	str1	String
    //   392	2	3	localJSONException	org.json.JSONException
    //   435	553	3	localObject2	Object
    //   146	861	4	localObject3	Object
    //   9	928	5	localObject4	Object
    //   1	956	6	localObject5	Object
    //   4	825	7	localObject6	Object
    //   235	189	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   189	194	266	java/io/IOException
    //   106	148	274	java/io/FileNotFoundException
    //   294	298	300	java/io/IOException
    //   106	148	307	org/json/JSONException
    //   327	331	333	java/io/IOException
    //   106	148	340	java/io/IOException
    //   360	364	366	java/io/IOException
    //   106	148	373	finally
    //   280	284	373	finally
    //   286	290	373	finally
    //   313	317	373	finally
    //   319	323	373	finally
    //   346	350	373	finally
    //   352	356	373	finally
    //   378	382	384	java/io/IOException
    //   237	245	392	org/json/JSONException
    //   633	641	841	org/json/JSONException
    //   701	707	888	org/json/JSONException
    //   148	184	984	finally
    //   148	184	991	java/io/IOException
    //   148	184	998	org/json/JSONException
    //   148	184	1005	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 323
    //   9: iconst_2
    //   10: ldc_w 405
    //   13: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokestatic 209	npi:a	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +17 -> 41
    //   27: aload_1
    //   28: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +10 -> 41
    //   34: aload_2
    //   35: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 9
    //   49: aconst_null
    //   50: astore 10
    //   52: aconst_null
    //   53: astore 11
    //   55: aconst_null
    //   56: astore 4
    //   58: aload 8
    //   60: astore 5
    //   62: aload 9
    //   64: astore 6
    //   66: aload 10
    //   68: astore 7
    //   70: aload 11
    //   72: astore_3
    //   73: getstatic 410	nny:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +123 -> 199
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: astore 6
    //   87: aload 10
    //   89: astore 7
    //   91: aload 11
    //   93: astore_3
    //   94: getstatic 410	nny:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: invokevirtual 415	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq +98 -> 199
    //   104: aload 8
    //   106: astore 5
    //   108: aload 9
    //   110: astore 6
    //   112: aload 10
    //   114: astore 7
    //   116: aload 11
    //   118: astore_3
    //   119: getstatic 410	nny:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: aload_2
    //   123: invokevirtual 416	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 47	java/lang/String
    //   129: astore 8
    //   131: aload 4
    //   133: astore_2
    //   134: aload 8
    //   136: astore 4
    //   138: aload_2
    //   139: astore 5
    //   141: aload_2
    //   142: astore 6
    //   144: aload_2
    //   145: astore 7
    //   147: aload_2
    //   148: astore_3
    //   149: new 281	org/json/JSONObject
    //   152: dup
    //   153: aload 4
    //   155: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   158: astore 4
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   168: aload 4
    //   170: aload_0
    //   171: invokevirtual 419	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: aload_2
    //   176: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +328 -> 507
    //   182: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 149
    //   190: iconst_2
    //   191: ldc_w 421
    //   194: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: aload 8
    //   201: astore 5
    //   203: aload 9
    //   205: astore 6
    //   207: aload 10
    //   209: astore 7
    //   211: aload 11
    //   213: astore_3
    //   214: new 41	java/io/BufferedInputStream
    //   217: dup
    //   218: new 75	java/io/FileInputStream
    //   221: dup
    //   222: new 105	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   229: aload_1
    //   230: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 176
    //   235: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   244: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   247: astore 4
    //   249: aload 4
    //   251: invokestatic 283	npi:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   254: astore_3
    //   255: getstatic 410	nny:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   258: ifnull +12 -> 270
    //   261: getstatic 410	nny:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   264: aload_2
    //   265: aload_3
    //   266: invokevirtual 422	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: aload 4
    //   272: astore_2
    //   273: aload_3
    //   274: astore 4
    //   276: goto -138 -> 138
    //   279: astore_2
    //   280: ldc 149
    //   282: iconst_1
    //   283: ldc_w 424
    //   286: aload_2
    //   287: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: goto -122 -> 168
    //   293: astore_0
    //   294: aload 5
    //   296: astore_3
    //   297: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +16 -> 316
    //   303: aload 5
    //   305: astore_3
    //   306: ldc_w 323
    //   309: iconst_2
    //   310: ldc_w 430
    //   313: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 5
    //   318: astore_3
    //   319: iconst_1
    //   320: invokestatic 197	npi:a	(I)V
    //   323: aload 5
    //   325: astore_3
    //   326: aload_0
    //   327: invokevirtual 198	java/io/FileNotFoundException:printStackTrace	()V
    //   330: aload 5
    //   332: ifnull +8 -> 340
    //   335: aload 5
    //   337: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   340: iconst_0
    //   341: ireturn
    //   342: astore_0
    //   343: ldc 149
    //   345: iconst_1
    //   346: ldc_w 424
    //   349: aload_0
    //   350: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: goto -13 -> 340
    //   356: astore_0
    //   357: aload 6
    //   359: astore_3
    //   360: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +16 -> 379
    //   366: aload 6
    //   368: astore_3
    //   369: ldc_w 323
    //   372: iconst_2
    //   373: ldc_w 432
    //   376: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload 6
    //   381: astore_3
    //   382: iconst_3
    //   383: invokestatic 197	npi:a	(I)V
    //   386: aload 6
    //   388: astore_3
    //   389: aload_0
    //   390: invokevirtual 317	org/json/JSONException:printStackTrace	()V
    //   393: aload 6
    //   395: ifnull +8 -> 403
    //   398: aload 6
    //   400: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_0
    //   406: ldc 149
    //   408: iconst_1
    //   409: ldc_w 424
    //   412: aload_0
    //   413: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -13 -> 403
    //   419: astore_0
    //   420: aload 7
    //   422: astore_3
    //   423: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +16 -> 442
    //   429: aload 7
    //   431: astore_3
    //   432: ldc_w 323
    //   435: iconst_2
    //   436: ldc_w 434
    //   439: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload 7
    //   444: astore_3
    //   445: iconst_2
    //   446: invokestatic 197	npi:a	(I)V
    //   449: aload 7
    //   451: astore_3
    //   452: aload_0
    //   453: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   456: aload 7
    //   458: ifnull +8 -> 466
    //   461: aload 7
    //   463: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   466: iconst_0
    //   467: ireturn
    //   468: astore_0
    //   469: ldc 149
    //   471: iconst_1
    //   472: ldc_w 424
    //   475: aload_0
    //   476: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   479: goto -13 -> 466
    //   482: astore_0
    //   483: aload_3
    //   484: ifnull +7 -> 491
    //   487: aload_3
    //   488: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   491: aload_0
    //   492: athrow
    //   493: astore_1
    //   494: ldc 149
    //   496: iconst_1
    //   497: ldc_w 424
    //   500: aload_1
    //   501: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: goto -13 -> 491
    //   507: aload_2
    //   508: new 105	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   515: aload_1
    //   516: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   522: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_0
    //   526: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 306	npi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   535: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifne +42 -> 580
    //   541: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +29 -> 573
    //   547: ldc 149
    //   549: iconst_2
    //   550: new 105	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 436
    //   560: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_0
    //   564: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: bipush 6
    //   575: invokestatic 197	npi:a	(I)V
    //   578: iconst_0
    //   579: ireturn
    //   580: iconst_1
    //   581: ireturn
    //   582: astore_0
    //   583: aload 4
    //   585: astore_3
    //   586: goto -103 -> 483
    //   589: astore_0
    //   590: aload 4
    //   592: astore 7
    //   594: goto -174 -> 420
    //   597: astore_0
    //   598: aload 4
    //   600: astore 6
    //   602: goto -245 -> 357
    //   605: astore_0
    //   606: aload 4
    //   608: astore 5
    //   610: goto -316 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	paramString1	String
    //   0	613	1	paramString2	String
    //   0	613	2	paramString3	String
    //   72	514	3	localObject1	Object
    //   56	551	4	localObject2	Object
    //   60	549	5	localObject3	Object
    //   64	537	6	localObject4	Object
    //   68	525	7	localObject5	Object
    //   44	156	8	str	String
    //   47	157	9	localObject6	Object
    //   50	158	10	localObject7	Object
    //   53	159	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   164	168	279	java/lang/Exception
    //   73	79	293	java/io/FileNotFoundException
    //   94	104	293	java/io/FileNotFoundException
    //   119	131	293	java/io/FileNotFoundException
    //   149	160	293	java/io/FileNotFoundException
    //   214	249	293	java/io/FileNotFoundException
    //   335	340	342	java/lang/Exception
    //   73	79	356	org/json/JSONException
    //   94	104	356	org/json/JSONException
    //   119	131	356	org/json/JSONException
    //   149	160	356	org/json/JSONException
    //   214	249	356	org/json/JSONException
    //   398	403	405	java/lang/Exception
    //   73	79	419	java/io/IOException
    //   94	104	419	java/io/IOException
    //   119	131	419	java/io/IOException
    //   149	160	419	java/io/IOException
    //   214	249	419	java/io/IOException
    //   461	466	468	java/lang/Exception
    //   73	79	482	finally
    //   94	104	482	finally
    //   119	131	482	finally
    //   149	160	482	finally
    //   214	249	482	finally
    //   297	303	482	finally
    //   306	316	482	finally
    //   319	323	482	finally
    //   326	330	482	finally
    //   360	366	482	finally
    //   369	379	482	finally
    //   382	386	482	finally
    //   389	393	482	finally
    //   423	429	482	finally
    //   432	442	482	finally
    //   445	449	482	finally
    //   452	456	482	finally
    //   487	491	493	java/lang/Exception
    //   249	270	582	finally
    //   249	270	589	java/io/IOException
    //   249	270	597	org/json/JSONException
    //   249	270	605	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npi
 * JD-Core Version:    0.7.0.1
 */