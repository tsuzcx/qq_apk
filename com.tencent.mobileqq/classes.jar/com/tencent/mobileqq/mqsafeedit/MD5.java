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
    byte[] arrayOfByte2 = (byte[])null;
    byte[] arrayOfByte1;
    if ((paramString == null) || (paramString.length() == 0)) {
      arrayOfByte1 = null;
    }
    for (;;)
    {
      return arrayOfByte1;
      try
      {
        File localFile = new File(paramString);
        arrayOfByte1 = arrayOfByte2;
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
    }
    return arrayOfByte2;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: invokevirtual 58	java/lang/String:length	()I
    //   8: ifeq +9 -> 17
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aconst_null
    //   20: checkcast 54	[B
    //   23: astore 10
    //   25: new 81	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   33: astore 8
    //   35: aload 8
    //   37: astore 7
    //   39: new 60	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload 8
    //   50: astore 7
    //   52: aload_0
    //   53: invokevirtual 67	java/io/File:exists	()Z
    //   56: ifeq +61 -> 117
    //   59: aload 8
    //   61: astore 7
    //   63: aload_0
    //   64: invokevirtual 70	java/io/File:length	()J
    //   67: lstore 5
    //   69: lload_1
    //   70: lconst_0
    //   71: lcmp
    //   72: ifeq +158 -> 230
    //   75: lload_1
    //   76: lstore_3
    //   77: lload 5
    //   79: lload_1
    //   80: lcmp
    //   81: ifge +6 -> 87
    //   84: goto +146 -> 230
    //   87: aload 8
    //   89: astore 7
    //   91: aload 8
    //   93: lload_3
    //   94: invokestatic 86	com/tencent/mobileqq/mqsafeedit/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   97: astore_0
    //   98: aload_0
    //   99: astore 7
    //   101: aload 8
    //   103: ifnull +11 -> 114
    //   106: aload 8
    //   108: invokevirtual 89	java/io/FileInputStream:close	()V
    //   111: aload_0
    //   112: astore 7
    //   114: aload 7
    //   116: areturn
    //   117: aload 8
    //   119: ifnull -102 -> 17
    //   122: aload 8
    //   124: invokevirtual 89	java/io/FileInputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore 9
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore 7
    //   143: aload 9
    //   145: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   148: aload 10
    //   150: astore 7
    //   152: aload_0
    //   153: ifnull -39 -> 114
    //   156: aload_0
    //   157: invokevirtual 89	java/io/FileInputStream:close	()V
    //   160: aload 10
    //   162: astore 7
    //   164: goto -50 -> 114
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   172: aload 10
    //   174: astore 7
    //   176: goto -62 -> 114
    //   179: astore_0
    //   180: aconst_null
    //   181: astore 7
    //   183: aload 7
    //   185: ifnull +8 -> 193
    //   188: aload 7
    //   190: invokevirtual 89	java/io/FileInputStream:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore 7
    //   197: aload 7
    //   199: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   202: goto -9 -> 193
    //   205: astore 7
    //   207: aload 7
    //   209: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   212: aload_0
    //   213: astore 7
    //   215: goto -101 -> 114
    //   218: astore_0
    //   219: goto -36 -> 183
    //   222: astore 9
    //   224: aload 8
    //   226: astore_0
    //   227: goto -87 -> 140
    //   230: lload 5
    //   232: lstore_3
    //   233: goto -146 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   0	236	1	paramLong	long
    //   76	157	3	l1	long
    //   67	164	5	l2	long
    //   37	152	7	localObject	Object
    //   195	3	7	localIOException1	IOException
    //   205	3	7	localIOException2	IOException
    //   213	1	7	str	String
    //   33	192	8	localFileInputStream	java.io.FileInputStream
    //   136	8	9	localException1	Exception
    //   222	1	9	localException2	Exception
    //   23	150	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   122	127	129	java/io/IOException
    //   25	35	136	java/lang/Exception
    //   156	160	167	java/io/IOException
    //   25	35	179	finally
    //   188	193	195	java/io/IOException
    //   106	111	205	java/io/IOException
    //   39	48	218	finally
    //   52	59	218	finally
    //   63	69	218	finally
    //   91	98	218	finally
    //   143	148	218	finally
    //   39	48	222	java/lang/Exception
    //   52	59	222	java/lang/Exception
    //   63	69	222	java/lang/Exception
    //   91	98	222	java/lang/Exception
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
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
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: ifnull +9 -> 13
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
    //   77: iflt -64 -> 13
    //   80: aload 6
    //   82: aload 7
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   89: lload 4
    //   91: iload_3
    //   92: i2l
    //   93: ladd
    //   94: lstore 4
    //   96: goto -64 -> 32
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 110	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: goto -71 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramInputStream	InputStream
    //   0	117	1	paramLong	long
    //   31	61	3	i	int
    //   1	94	4	l	long
    //   20	61	6	localMessageDigest	MessageDigest
    //   26	57	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	32	99	java/security/NoSuchAlgorithmException
    //   39	43	99	java/security/NoSuchAlgorithmException
    //   43	49	99	java/security/NoSuchAlgorithmException
    //   49	61	99	java/security/NoSuchAlgorithmException
    //   67	76	99	java/security/NoSuchAlgorithmException
    //   80	89	99	java/security/NoSuchAlgorithmException
    //   15	32	106	java/io/IOException
    //   39	43	106	java/io/IOException
    //   43	49	106	java/io/IOException
    //   49	61	106	java/io/IOException
    //   67	76	106	java/io/IOException
    //   80	89	106	java/io/IOException
    //   39	43	113	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject = null;
    byte[] arrayOfByte = (byte[])null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    do
    {
      return paramString;
      try
      {
        localObject = paramString.getBytes("ISO8859_1");
        paramString = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          int i;
          paramString = paramString.getBytes();
        }
      }
      arrayOfByte = new MD5().getMD5(paramString, 0, paramString.length);
      localObject = "";
      paramString = (String)localObject;
    } while (arrayOfByte == null);
    i = 0;
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= 16) {
        break;
      }
      localObject = localObject + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      localObject = null;
      return localObject;
    }
    byte[] arrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (i >= 16) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
      i += 1;
    }
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
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
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
    if ((paramInputStream == null) || (paramLong < 0L)) {}
    long l1;
    do
    {
      for (;;)
      {
        return null;
        try
        {
          long l2 = paramInputStream.available();
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
          if (l1 != 0L)
          {
            byte[] arrayOfByte1 = (byte[])null;
            arrayOfByte1 = sysGetStremMd5(paramInputStream, l1);
            if (arrayOfByte1 == null) {
              break label120;
            }
            this.digest = arrayOfByte1;
            return this.digest;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    try
    {
      label120:
      byte[] arrayOfByte2 = getStremMd5(paramInputStream, l1);
      localObject = arrayOfByte2;
      paramInputStream.close();
      localObject = arrayOfByte2;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        Object localObject;
        paramInputStream.printStackTrace();
      }
    }
    if (localObject != null)
    {
      this.digest = localObject;
      return this.digest;
    }
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
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
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
    return this.digest;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.MD5
 * JD-Core Version:    0.7.0.1
 */