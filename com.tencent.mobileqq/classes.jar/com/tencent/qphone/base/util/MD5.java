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
  public static boolean isLoaded = false;
  public static int soLoadResultCode = 0;
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static
  {
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo("MD5", "msfbootV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadso msfbootV2 ");
    localStringBuilder.append(isLoaded);
    localStringBuilder.append(" resultCode=");
    localStringBuilder.append(soLoadResultCode);
    localStringBuilder.append(" cost=");
    localStringBuilder.append(SystemClock.elapsedRealtime() - l);
    QLog.e("MD5", 1, localStringBuilder.toString());
  }
  
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
    char[] arrayOfChar = Digit;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
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
    }
    return null;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: ifnull +191 -> 195
    //   7: aload_0
    //   8: invokevirtual 117	java/lang/String:length	()I
    //   11: ifeq +184 -> 195
    //   14: lload_1
    //   15: lconst_0
    //   16: lcmp
    //   17: ifge +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 139	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 8
    //   34: astore 7
    //   36: new 119	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload 8
    //   47: astore 7
    //   49: aload_0
    //   50: invokevirtual 126	java/io/File:exists	()Z
    //   53: ifeq +60 -> 113
    //   56: aload 8
    //   58: astore 7
    //   60: aload_0
    //   61: invokevirtual 128	java/io/File:length	()J
    //   64: lstore 5
    //   66: lload_1
    //   67: lconst_0
    //   68: lcmp
    //   69: ifeq +128 -> 197
    //   72: lload_1
    //   73: lstore_3
    //   74: lload 5
    //   76: lload_1
    //   77: lcmp
    //   78: ifge +6 -> 84
    //   81: goto +116 -> 197
    //   84: aload 8
    //   86: astore 7
    //   88: aload 8
    //   90: lload_3
    //   91: invokestatic 144	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   94: astore_0
    //   95: aload_0
    //   96: astore 7
    //   98: aload 8
    //   100: invokevirtual 147	java/io/FileInputStream:close	()V
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   110: aload 7
    //   112: areturn
    //   113: aload 8
    //   115: invokevirtual 147	java/io/FileInputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore 7
    //   129: aload 8
    //   131: astore_0
    //   132: aload 7
    //   134: astore 8
    //   136: goto +14 -> 150
    //   139: astore_0
    //   140: aconst_null
    //   141: astore 7
    //   143: goto +30 -> 173
    //   146: astore 8
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: astore 7
    //   153: aload 8
    //   155: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +11 -> 170
    //   162: aload 9
    //   164: astore 7
    //   166: aload_0
    //   167: invokevirtual 147	java/io/FileInputStream:close	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_0
    //   173: aload 7
    //   175: ifnull +18 -> 193
    //   178: aload 7
    //   180: invokevirtual 147	java/io/FileInputStream:close	()V
    //   183: goto +10 -> 193
    //   186: astore 7
    //   188: aload 7
    //   190: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   193: aload_0
    //   194: athrow
    //   195: aconst_null
    //   196: areturn
    //   197: lload 5
    //   199: lstore_3
    //   200: goto -116 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   0	203	1	paramLong	long
    //   73	127	3	l1	long
    //   64	134	5	l2	long
    //   34	77	7	localObject1	Object
    //   127	6	7	localException1	Exception
    //   141	38	7	localObject2	Object
    //   186	3	7	localIOException	IOException
    //   30	105	8	localObject3	Object
    //   146	8	8	localException2	Exception
    //   1	162	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   98	103	105	java/io/IOException
    //   166	170	105	java/io/IOException
    //   113	118	120	java/io/IOException
    //   36	45	127	java/lang/Exception
    //   49	56	127	java/lang/Exception
    //   60	66	127	java/lang/Exception
    //   88	95	127	java/lang/Exception
    //   22	32	139	finally
    //   22	32	146	java/lang/Exception
    //   36	45	172	finally
    //   49	56	172	finally
    //   60	66	172	finally
    //   88	95	172	finally
    //   153	158	172	finally
    //   178	183	186	java/io/IOException
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
    //   1: ifnull +115 -> 116
    //   4: lconst_0
    //   5: lstore 4
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
    //   37: ifge +55 -> 92
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
    //   68: ifge +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: aload 6
    //   75: aload 7
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 162	java/security/MessageDigest:update	([BII)V
    //   82: lload 4
    //   84: iload_3
    //   85: i2l
    //   86: ladd
    //   87: lstore 4
    //   89: goto -56 -> 33
    //   92: aload_0
    //   93: invokevirtual 174	java/io/InputStream:close	()V
    //   96: aload 6
    //   98: invokevirtual 165	java/security/MessageDigest:digest	()[B
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 166	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: goto -23 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramInputStream	InputStream
    //   0	122	1	paramLong	long
    //   32	53	3	i	int
    //   5	83	4	l	long
    //   20	77	6	localMessageDigest	MessageDigest
    //   27	49	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	33	104	java/io/IOException
    //   40	52	104	java/io/IOException
    //   58	67	104	java/io/IOException
    //   73	82	104	java/io/IOException
    //   92	96	104	java/io/IOException
    //   96	102	104	java/io/IOException
    //   15	33	111	java/security/NoSuchAlgorithmException
    //   40	52	111	java/security/NoSuchAlgorithmException
    //   58	67	111	java/security/NoSuchAlgorithmException
    //   73	82	111	java/security/NoSuchAlgorithmException
    //   92	96	111	java/security/NoSuchAlgorithmException
    //   96	102	111	java/security/NoSuchAlgorithmException
    //   92	96	118	java/lang/Exception
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
      Object localObject;
      label18:
      int j;
      int i;
      break label18;
    }
    paramString = paramString.getBytes();
    localObject = new MD5();
    j = paramString.length;
    i = 0;
    paramString = ((MD5)localObject).getMD5(paramString, 0, j);
    localObject = new StringBuilder(32);
    if (paramString == null) {
      return "";
    }
    while (i < 16)
    {
      ((StringBuilder)localObject).append(Digit[(paramString[i] >>> 4 & 0xF)]);
      ((StringBuilder)localObject).append(Digit[(paramString[i] & 0xF)]);
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new MD5();
      int j = paramArrayOfByte.length;
      int i = 0;
      paramArrayOfByte = ((MD5)localObject).getMD5(paramArrayOfByte, 0, j);
      localObject = new StringBuilder(32);
      while (i < 16)
      {
        ((StringBuilder)localObject).append(Digit[(paramArrayOfByte[i] >>> 4 & 0xF)]);
        ((StringBuilder)localObject).append(Digit[(paramArrayOfByte[i] & 0xF)]);
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return null;
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
      label18:
      break label18;
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
        Object localObject2 = sysGetStremMd5(paramInputStream, l1);
        if (localObject2 != null)
        {
          this.digest = ((byte[])localObject2);
          return this.digest;
        }
        Object localObject1 = localObject2;
        try
        {
          byte[] arrayOfByte = getStremMd5(paramInputStream, l1);
          localObject1 = arrayOfByte;
          localObject2 = arrayOfByte;
          paramInputStream.close();
          localObject1 = arrayOfByte;
        }
        catch (UnsatisfiedLinkError paramInputStream)
        {
          QLog.d("MD5", 1, "getStremMd5 UnsatisfiedLinkError", paramInputStream);
        }
        catch (Exception paramInputStream)
        {
          QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", paramInputStream);
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          this.digest = localObject1;
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
    if ((paramArrayOfByte != null) && (paramInt2 != 0) && (paramInt1 >= 0))
    {
      byte[] arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
      if (arrayOfByte != null)
      {
        this.digest = arrayOfByte;
        return this.digest;
      }
      try
      {
        paramArrayOfByte = getBufferMd5(paramArrayOfByte);
      }
      catch (UnsatisfiedLinkError paramArrayOfByte)
      {
        QLog.d("MD5", 1, "getBufferMd5 UnsatisfiedLinkError", paramArrayOfByte);
        paramArrayOfByte = arrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MD5", 1, "getBufferMd5 Exception", paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.MD5
 * JD-Core Version:    0.7.0.1
 */