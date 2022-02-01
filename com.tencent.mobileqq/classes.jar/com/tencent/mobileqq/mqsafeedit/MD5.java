package com.tencent.mobileqq.mqsafeedit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static {}
  
  public static long b2iu(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
  }
  
  public static String byteHEX(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          paramString = getPartfileMd5(paramString, localFile.length());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return arrayOfByte;
    }
    return null;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: ifnull +187 -> 194
    //   10: aload_0
    //   11: invokevirtual 58	java/lang/String:length	()I
    //   14: ifeq +180 -> 194
    //   17: lload_1
    //   18: lconst_0
    //   19: lcmp
    //   20: ifge +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aconst_null
    //   26: checkcast 54	[B
    //   29: astore 9
    //   31: new 81	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: astore 8
    //   41: new 60	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 67	java/io/File:exists	()Z
    //   54: ifeq +52 -> 106
    //   57: aload_0
    //   58: invokevirtual 70	java/io/File:length	()J
    //   61: lstore 5
    //   63: lload_1
    //   64: lconst_0
    //   65: lcmp
    //   66: ifeq +130 -> 196
    //   69: lload_1
    //   70: lstore_3
    //   71: lload 5
    //   73: lload_1
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: goto +118 -> 196
    //   81: aload 8
    //   83: lload_3
    //   84: invokestatic 86	com/tencent/mobileqq/mqsafeedit/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   87: astore_0
    //   88: aload_0
    //   89: astore 7
    //   91: aload 8
    //   93: invokevirtual 89	java/io/FileInputStream:close	()V
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   103: aload 7
    //   105: areturn
    //   106: aload 8
    //   108: invokevirtual 89	java/io/FileInputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: goto +51 -> 172
    //   124: astore 7
    //   126: aload 8
    //   128: astore_0
    //   129: aload 7
    //   131: astore 8
    //   133: goto +16 -> 149
    //   136: astore_0
    //   137: aload 7
    //   139: astore 8
    //   141: goto +31 -> 172
    //   144: astore 8
    //   146: aload 10
    //   148: astore_0
    //   149: aload_0
    //   150: astore 7
    //   152: aload 8
    //   154: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   157: aload_0
    //   158: ifnull +11 -> 169
    //   161: aload 9
    //   163: astore 7
    //   165: aload_0
    //   166: invokevirtual 89	java/io/FileInputStream:close	()V
    //   169: aload 9
    //   171: areturn
    //   172: aload 8
    //   174: ifnull +18 -> 192
    //   177: aload 8
    //   179: invokevirtual 89	java/io/FileInputStream:close	()V
    //   182: goto +10 -> 192
    //   185: astore 7
    //   187: aload 7
    //   189: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   192: aload_0
    //   193: athrow
    //   194: aconst_null
    //   195: areturn
    //   196: lload 5
    //   198: lstore_3
    //   199: goto -118 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString	String
    //   0	202	1	paramLong	long
    //   70	129	3	l1	long
    //   61	136	5	l2	long
    //   4	100	7	str	String
    //   124	14	7	localException1	Exception
    //   150	14	7	localObject1	Object
    //   185	3	7	localIOException	IOException
    //   39	101	8	localObject2	Object
    //   144	34	8	localException2	Exception
    //   29	141	9	arrayOfByte	byte[]
    //   1	146	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   91	96	98	java/io/IOException
    //   165	169	98	java/io/IOException
    //   106	111	113	java/io/IOException
    //   41	63	120	finally
    //   81	88	120	finally
    //   41	63	124	java/lang/Exception
    //   81	88	124	java/lang/Exception
    //   31	41	136	finally
    //   152	157	136	finally
    //   31	41	144	java/lang/Exception
    //   177	182	185	java/io/IOException
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt2 == 0) {
        return null;
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
        paramArrayOfByte = localMessageDigest.digest();
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +112 -> 113
    //   4: lconst_0
    //   5: lstore 4
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 96
    //   17: invokestatic 102	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 6
    //   22: ldc 112
    //   24: newarray byte
    //   26: astore 7
    //   28: aload 7
    //   30: arraylength
    //   31: istore_3
    //   32: lload 4
    //   34: lload_1
    //   35: lcmp
    //   36: iflt +13 -> 49
    //   39: aload_0
    //   40: invokevirtual 115	java/io/InputStream:close	()V
    //   43: aload 6
    //   45: invokevirtual 109	java/security/MessageDigest:digest	()[B
    //   48: areturn
    //   49: aload 7
    //   51: arraylength
    //   52: i2l
    //   53: lload 4
    //   55: ladd
    //   56: lload_1
    //   57: lcmp
    //   58: ifle +9 -> 67
    //   61: lload_1
    //   62: lload 4
    //   64: lsub
    //   65: l2i
    //   66: istore_3
    //   67: aload_0
    //   68: aload 7
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 119	java/io/InputStream:read	([BII)I
    //   75: istore_3
    //   76: iload_3
    //   77: ifge +5 -> 82
    //   80: aconst_null
    //   81: areturn
    //   82: aload 6
    //   84: aload 7
    //   86: iconst_0
    //   87: iload_3
    //   88: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   91: lload 4
    //   93: iload_3
    //   94: i2l
    //   95: ladd
    //   96: lstore 4
    //   98: goto -66 -> 32
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 110	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: goto -73 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramInputStream	InputStream
    //   0	119	1	paramLong	long
    //   31	63	3	i	int
    //   5	92	4	l	long
    //   20	63	6	localMessageDigest	MessageDigest
    //   26	59	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	32	101	java/io/IOException
    //   39	43	101	java/io/IOException
    //   43	49	101	java/io/IOException
    //   49	61	101	java/io/IOException
    //   67	76	101	java/io/IOException
    //   82	91	101	java/io/IOException
    //   15	32	108	java/security/NoSuchAlgorithmException
    //   39	43	108	java/security/NoSuchAlgorithmException
    //   43	49	108	java/security/NoSuchAlgorithmException
    //   49	61	108	java/security/NoSuchAlgorithmException
    //   67	76	108	java/security/NoSuchAlgorithmException
    //   82	91	108	java/security/NoSuchAlgorithmException
    //   39	43	115	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject = (byte[])null;
    if (paramString == null) {
      return null;
    }
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label23:
      int j;
      int i;
      break label23;
    }
    paramString = paramString.getBytes();
    localObject = new MD5();
    j = paramString.length;
    i = 0;
    localObject = ((MD5)localObject).getMD5(paramString, 0, j);
    paramString = "";
    if (localObject == null) {
      return "";
    }
    for (;;)
    {
      if (i >= 16) {
        return paramString;
      }
      paramString = new StringBuilder(String.valueOf(paramString));
      paramString.append(byteHEX(localObject[i]));
      paramString = paramString.toString();
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new MD5();
      int j = paramArrayOfByte.length;
      int i = 0;
      localObject = ((MD5)localObject).getMD5(paramArrayOfByte, 0, j);
      paramArrayOfByte = "";
      for (;;)
      {
        if (i >= 16) {
          return paramArrayOfByte;
        }
        paramArrayOfByte = new StringBuilder(String.valueOf(paramArrayOfByte));
        paramArrayOfByte.append(byteHEX(localObject[i]));
        paramArrayOfByte = paramArrayOfByte.toString();
        i += 1;
      }
    }
    return null;
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    if (paramString == null) {
      return null;
    }
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label23:
      break label23;
    }
    paramString = paramString.getBytes();
    return new MD5().getMD5(paramString, 0, paramString.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new MD5().getMD5(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  native byte[] getBufferMd5(byte[] paramArrayOfByte);
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    if (paramInputStream != null)
    {
      if (paramLong < 0L) {
        return null;
      }
      try
      {
        long l2 = paramInputStream.available();
        long l1;
        if (paramLong != 0L)
        {
          l1 = paramLong;
          if (l2 != 0L)
          {
            l1 = paramLong;
            if (paramInputStream.available() >= paramLong) {}
          }
        }
        else
        {
          int i = paramInputStream.available();
          l1 = i;
        }
        if (l1 == 0L) {
          return null;
        }
        Object localObject = (byte[])null;
        localObject = sysGetStremMd5(paramInputStream, l1);
        if (localObject != null)
        {
          this.digest = ((byte[])localObject);
          return this.digest;
        }
        try
        {
          byte[] arrayOfByte = getStremMd5(paramInputStream, l1);
          localObject = arrayOfByte;
          paramInputStream.close();
          localObject = arrayOfByte;
        }
        catch (Exception paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        if (localObject != null)
        {
          this.digest = ((byte[])localObject);
          return this.digest;
        }
        return this.digest;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (paramInputStream != null) {
          try
          {
            paramInputStream.close();
            return null;
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 != 0))
    {
      if (paramInt1 < 0) {
        return null;
      }
      byte[] arrayOfByte = (byte[])null;
      arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
      if (arrayOfByte != null)
      {
        this.digest = arrayOfByte;
        return this.digest;
      }
      try
      {
        paramArrayOfByte = getBufferMd5(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
      return this.digest;
    }
    return null;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.MD5
 * JD-Core Version:    0.7.0.1
 */