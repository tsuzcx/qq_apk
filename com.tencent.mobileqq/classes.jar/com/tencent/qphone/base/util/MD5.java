package com.tencent.qphone.base.util;

import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  static final char[] Digit = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final String TAG = "MD5";
  public static boolean isLoaded;
  public static int soLoadResultCode;
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static
  {
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo("MD5", "msfbootV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    QLog.e("MD5", 1, "loadso msfbootV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - l));
  }
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  public static String byteHEX(byte paramByte)
  {
    return new String(new char[] { Digit[(paramByte >>> 4 & 0xF)], Digit[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
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
    //   4: astore 11
    //   6: aload 11
    //   8: astore 7
    //   10: aload_0
    //   11: ifnull +24 -> 35
    //   14: aload 11
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 117	java/lang/String:length	()I
    //   22: ifeq +13 -> 35
    //   25: lload_1
    //   26: lconst_0
    //   27: lcmp
    //   28: ifge +10 -> 38
    //   31: aload 11
    //   33: astore 7
    //   35: aload 7
    //   37: areturn
    //   38: new 139	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 7
    //   52: new 119	java/io/File
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload 8
    //   63: astore 7
    //   65: aload_0
    //   66: invokevirtual 126	java/io/File:exists	()Z
    //   69: ifeq +126 -> 195
    //   72: aload 8
    //   74: astore 7
    //   76: aload_0
    //   77: invokevirtual 128	java/io/File:length	()J
    //   80: lstore 5
    //   82: lload_1
    //   83: lconst_0
    //   84: lcmp
    //   85: ifeq +146 -> 231
    //   88: lload_1
    //   89: lstore_3
    //   90: lload 5
    //   92: lload_1
    //   93: lcmp
    //   94: ifge +6 -> 100
    //   97: goto +134 -> 231
    //   100: aload 8
    //   102: astore 7
    //   104: aload 8
    //   106: lload_3
    //   107: invokestatic 144	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   110: astore_0
    //   111: aload_0
    //   112: astore 7
    //   114: aload 8
    //   116: ifnull -81 -> 35
    //   119: aload 8
    //   121: invokevirtual 147	java/io/FileInputStream:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore 7
    //   128: aload 7
    //   130: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore 9
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: astore 7
    //   142: aload 9
    //   144: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   147: aload 11
    //   149: astore 7
    //   151: aload_0
    //   152: ifnull -117 -> 35
    //   155: aload_0
    //   156: invokevirtual 147	java/io/FileInputStream:close	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore 7
    //   163: aload 10
    //   165: astore_0
    //   166: goto -38 -> 128
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 7
    //   173: aload 7
    //   175: ifnull +8 -> 183
    //   178: aload 7
    //   180: invokevirtual 147	java/io/FileInputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore 7
    //   187: aload 7
    //   189: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   192: goto -9 -> 183
    //   195: aload 11
    //   197: astore 7
    //   199: aload 8
    //   201: ifnull -166 -> 35
    //   204: aload 8
    //   206: invokevirtual 147	java/io/FileInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore 7
    //   213: aload 10
    //   215: astore_0
    //   216: goto -88 -> 128
    //   219: astore_0
    //   220: goto -47 -> 173
    //   223: astore 9
    //   225: aload 8
    //   227: astore_0
    //   228: goto -89 -> 139
    //   231: lload 5
    //   233: lstore_3
    //   234: goto -134 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   0	237	1	paramLong	long
    //   89	145	3	l1	long
    //   80	152	5	l2	long
    //   8	105	7	localObject1	Object
    //   126	3	7	localIOException1	IOException
    //   140	10	7	localObject2	Object
    //   161	1	7	localIOException2	IOException
    //   171	8	7	localObject3	Object
    //   185	3	7	localIOException3	IOException
    //   197	1	7	localObject4	Object
    //   211	1	7	localIOException4	IOException
    //   46	180	8	localFileInputStream	java.io.FileInputStream
    //   135	8	9	localException1	Exception
    //   223	1	9	localException2	Exception
    //   1	213	10	localObject5	Object
    //   4	192	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   119	124	126	java/io/IOException
    //   38	48	135	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   38	48	169	finally
    //   178	183	185	java/io/IOException
    //   204	209	211	java/io/IOException
    //   52	61	219	finally
    //   65	72	219	finally
    //   76	82	219	finally
    //   104	111	219	finally
    //   142	147	219	finally
    //   52	61	223	java/lang/Exception
    //   65	72	223	java/lang/Exception
    //   76	82	223	java/lang/Exception
    //   104	111	223	java/lang/Exception
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
    //   15: ldc 10
    //   17: invokestatic 158	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 6
    //   22: sipush 16384
    //   25: newarray byte
    //   27: astore 7
    //   29: aload 7
    //   31: arraylength
    //   32: istore_3
    //   33: lload 4
    //   35: lload_1
    //   36: lcmp
    //   37: ifge +53 -> 90
    //   40: aload 7
    //   42: arraylength
    //   43: i2l
    //   44: lload 4
    //   46: ladd
    //   47: lload_1
    //   48: lcmp
    //   49: ifle +9 -> 58
    //   52: lload_1
    //   53: lload 4
    //   55: lsub
    //   56: l2i
    //   57: istore_3
    //   58: aload_0
    //   59: aload 7
    //   61: iconst_0
    //   62: iload_3
    //   63: invokevirtual 173	java/io/InputStream:read	([BII)I
    //   66: istore_3
    //   67: iload_3
    //   68: iflt -55 -> 13
    //   71: aload 6
    //   73: aload 7
    //   75: iconst_0
    //   76: iload_3
    //   77: invokevirtual 162	java/security/MessageDigest:update	([BII)V
    //   80: lload 4
    //   82: iload_3
    //   83: i2l
    //   84: ladd
    //   85: lstore 4
    //   87: goto -54 -> 33
    //   90: aload_0
    //   91: invokevirtual 174	java/io/InputStream:close	()V
    //   94: aload 6
    //   96: invokevirtual 165	java/security/MessageDigest:digest	()[B
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 166	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: goto -23 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramInputStream	InputStream
    //   0	120	1	paramLong	long
    //   32	51	3	i	int
    //   1	85	4	l	long
    //   20	75	6	localMessageDigest	MessageDigest
    //   27	47	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	33	102	java/security/NoSuchAlgorithmException
    //   40	52	102	java/security/NoSuchAlgorithmException
    //   58	67	102	java/security/NoSuchAlgorithmException
    //   71	80	102	java/security/NoSuchAlgorithmException
    //   90	94	102	java/security/NoSuchAlgorithmException
    //   94	100	102	java/security/NoSuchAlgorithmException
    //   15	33	109	java/io/IOException
    //   40	52	109	java/io/IOException
    //   58	67	109	java/io/IOException
    //   71	80	109	java/io/IOException
    //   90	94	109	java/io/IOException
    //   94	100	109	java/io/IOException
    //   90	94	116	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
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
      for (;;)
      {
        Object localObject;
        paramString = paramString.getBytes();
      }
      int i = 0;
      while (i < 16)
      {
        localUnsupportedEncodingException.append(Digit[(paramString[i] >>> 4 & 0xF)]);
        localUnsupportedEncodingException.append(Digit[(paramString[i] & 0xF)]);
        i += 1;
      }
      return localUnsupportedEncodingException.toString();
    }
    paramString = new MD5().getMD5(paramString, 0, paramString.length);
    localObject = new StringBuilder(32);
    if (paramString == null) {
      return "";
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    paramArrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    StringBuilder localStringBuilder = new StringBuilder(32);
    while (i < 16)
    {
      localStringBuilder.append(Digit[(paramArrayOfByte[i] >>> 4 & 0xF)]);
      localStringBuilder.append(Digit[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
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
    Object localObject2;
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
            localObject2 = sysGetStremMd5(paramInputStream, l1);
            if (localObject2 == null) {
              break label114;
            }
            this.digest = ((byte[])localObject2);
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
    label114:
    Object localObject1 = localObject2;
    try
    {
      byte[] arrayOfByte = getStremMd5(paramInputStream, l1);
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      paramInputStream.close();
      localObject1 = arrayOfByte;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", paramInputStream);
      }
    }
    catch (UnsatisfiedLinkError paramInputStream)
    {
      for (;;)
      {
        QLog.d("MD5", 1, "getStremMd5 UnsatisfiedLinkError", paramInputStream);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      this.digest = localObject1;
      return this.digest;
    }
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    byte[] arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
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
        QLog.d("MD5", 1, "getBufferMd5 Exception", paramArrayOfByte);
        paramArrayOfByte = arrayOfByte;
      }
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", paramArrayOfByte);
        paramArrayOfByte = arrayOfByte;
      }
    }
    return this.digest;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.MD5
 * JD-Core Version:    0.7.0.1
 */