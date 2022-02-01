package com.tencent.qqmini.sdk.launcher.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MD5Utils
{
  private static final char[] Digit;
  static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  static final int S11 = 7;
  static final int S12 = 12;
  static final int S13 = 17;
  static final int S14 = 22;
  static final int S21 = 5;
  static final int S22 = 9;
  static final int S23 = 14;
  static final int S24 = 20;
  static final int S31 = 4;
  static final int S32 = 11;
  static final int S33 = 16;
  static final int S34 = 23;
  static final int S41 = 6;
  static final int S42 = 10;
  static final int S43 = 15;
  static final int S44 = 21;
  protected static Comparator<File> fileComparator = new MD5Utils.FileComparator();
  protected static List<String> md5List = new ArrayList();
  protected static Comparator strComparator;
  private byte[] buffer = new byte[64];
  private long[] count = new long[2];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  private long[] state = new long[4];
  
  static
  {
    Digit = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    strComparator = new MD5Utils.StringComparator();
  }
  
  public MD5Utils()
  {
    md5Init();
  }
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  private void decode(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[j] = (b2iu(paramArrayOfByte[i]) | b2iu(paramArrayOfByte[(i + 1)]) << 8 | b2iu(paramArrayOfByte[(i + 2)]) << 16 | b2iu(paramArrayOfByte[(i + 3)]) << 24);
      j += 1;
      i += 4;
    }
  }
  
  private void encode(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  protected static byte[] encode(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  protected static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 124
    //   2: invokestatic 130	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 147	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 154	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 156	java/io/BufferedInputStream
    //   27: dup
    //   28: new 158	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 161	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: sipush 4096
    //   43: newarray byte
    //   45: astore_0
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual 168	java/io/BufferedInputStream:read	([B)I
    //   51: istore_1
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +26 -> 80
    //   57: aload_3
    //   58: aload_0
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 171	java/security/MessageDigest:update	([BII)V
    //   64: goto -18 -> 46
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   72: aload_2
    //   73: invokevirtual 177	java/io/BufferedInputStream:close	()V
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_3
    //   81: invokevirtual 137	java/security/MessageDigest:digest	()[B
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 177	java/io/BufferedInputStream:close	()V
    //   89: goto -11 -> 78
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   97: goto -19 -> 78
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 178	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -36 -> 78
    //   117: astore_0
    //   118: aload_2
    //   119: invokevirtual 177	java/io/BufferedInputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 179	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   136: goto -14 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   51	10	1	i	int
    //   39	47	2	localBufferedInputStream	java.io.BufferedInputStream
    //   92	27	2	localIOException1	java.io.IOException
    //   131	2	2	localIOException2	java.io.IOException
    //   5	76	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   46	52	67	java/io/IOException
    //   57	64	67	java/io/IOException
    //   80	85	67	java/io/IOException
    //   85	89	92	java/io/IOException
    //   0	22	100	java/io/FileNotFoundException
    //   24	46	100	java/io/FileNotFoundException
    //   72	76	100	java/io/FileNotFoundException
    //   85	89	100	java/io/FileNotFoundException
    //   93	97	100	java/io/FileNotFoundException
    //   108	112	100	java/io/FileNotFoundException
    //   118	122	100	java/io/FileNotFoundException
    //   122	124	100	java/io/FileNotFoundException
    //   132	136	100	java/io/FileNotFoundException
    //   72	76	107	java/io/IOException
    //   46	52	117	finally
    //   57	64	117	finally
    //   68	72	117	finally
    //   80	85	117	finally
    //   0	22	124	java/security/NoSuchAlgorithmException
    //   24	46	124	java/security/NoSuchAlgorithmException
    //   72	76	124	java/security/NoSuchAlgorithmException
    //   85	89	124	java/security/NoSuchAlgorithmException
    //   93	97	124	java/security/NoSuchAlgorithmException
    //   108	112	124	java/security/NoSuchAlgorithmException
    //   118	122	124	java/security/NoSuchAlgorithmException
    //   122	124	124	java/security/NoSuchAlgorithmException
    //   132	136	124	java/security/NoSuchAlgorithmException
    //   118	122	131	java/io/IOException
  }
  
  public static String encodeFileHexStr(String paramString)
  {
    return HexUtil.bytes2HexStr(encodeFile(paramString));
  }
  
  public static String encodeFolder(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return "";
    }
    for (;;)
    {
      int i;
      try
      {
        Arrays.sort(paramString, fileComparator);
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          localIterator = paramString[i];
          if (localIterator.isFile()) {
            md5List.add(encodeFileHexStr(localIterator.getAbsolutePath()));
          } else {
            encodeFolder(localIterator.getAbsolutePath());
          }
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
      Collections.sort(md5List, strComparator);
      paramString = new StringBuilder();
      Iterator localIterator = md5List.iterator();
      while (localIterator.hasNext()) {
        paramString.append((String)localIterator.next());
      }
      md5List.clear();
      paramString = encodeHexStr(paramString.toString());
      return paramString;
      i += 1;
    }
  }
  
  public static String encodeHexStr(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(encode(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String encodeHexStr(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(encode(paramArrayOfByte));
  }
  
  private long func_F(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long func_FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = func_F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long func_G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long func_GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = func_G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long func_H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long func_HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = func_H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long func_I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long func_II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = func_I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private void md5Final()
  {
    byte[] arrayOfByte = new byte[8];
    encode(arrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      md5Update(PADDING, i);
      md5Update(arrayOfByte, 8);
      encode(this.digest, this.state, 16);
      return;
    }
  }
  
  private void md5Init()
  {
    this.count[0] = 0L;
    this.count[1] = 0L;
    this.state[0] = 1732584193L;
    this.state[1] = 4023233417L;
    this.state[2] = 2562383102L;
    this.state[3] = 271733878L;
  }
  
  private void md5Memcpy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void md5Transform(byte[] paramArrayOfByte)
  {
    long l2 = this.state[0];
    long l1 = this.state[1];
    long l4 = this.state[2];
    long l3 = this.state[3];
    long[] arrayOfLong = new long[16];
    decode(arrayOfLong, paramArrayOfByte, 64);
    l2 = func_FF(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = func_FF(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = func_FF(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = func_FF(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = func_FF(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = func_FF(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = func_FF(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = func_FF(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = func_FF(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = func_FF(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = func_FF(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = func_FF(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = func_FF(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = func_FF(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = func_FF(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = func_FF(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = func_GG(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = func_GG(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = func_GG(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = func_GG(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = func_GG(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = func_GG(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = func_GG(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = func_GG(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = func_GG(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = func_GG(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = func_GG(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = func_GG(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = func_GG(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = func_GG(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = func_GG(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = func_GG(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = func_HH(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = func_HH(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = func_HH(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = func_HH(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = func_HH(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = func_HH(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = func_HH(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = func_HH(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = func_HH(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = func_HH(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = func_HH(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = func_HH(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = func_HH(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = func_HH(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = func_HH(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = func_HH(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = func_II(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = func_II(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = func_II(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = func_II(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = func_II(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = func_II(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = func_II(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = func_II(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = func_II(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = func_II(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = func_II(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = func_II(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = func_II(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = func_II(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = func_II(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = func_II(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.state;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.state;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.state;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.state;
    paramArrayOfByte[3] += l3;
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[64];
    int k = (int)(this.count[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.count;
    long l = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l;
    if (l < paramInt << 3)
    {
      arrayOfLong = this.count;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.count;
    arrayOfLong[1] += (paramInt >>> 29);
    int m = 64 - k;
    int i = k;
    if (paramInt >= m)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, k, 0, m);
      md5Transform(this.buffer);
      i = m;
      while (i + 63 < paramInt)
      {
        md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
        md5Transform(arrayOfByte);
        i += 64;
      }
      k = 0;
      j = i;
      i = k;
    }
    md5Memcpy(this.buffer, paramArrayOfByte, i, j, paramInt - j);
  }
  
  private boolean md5Update(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.count[0] >>> 3) & 0x3F;
    Object localObject = this.count;
    long l = localObject[0] + (paramLong << 3);
    localObject[0] = l;
    if (l < paramLong << 3)
    {
      localObject = this.count;
      localObject[1] += 1L;
    }
    localObject = this.count;
    localObject[1] += (paramLong >>> 29);
    int i = 64 - j;
    if (paramLong >= i)
    {
      localObject = new byte[i];
      try
      {
        paramInputStream.read((byte[])localObject, 0, i);
        md5Memcpy(this.buffer, (byte[])localObject, j, 0, i);
        md5Transform(this.buffer);
      }
      catch (Exception paramInputStream)
      {
        try
        {
          paramInputStream.read(arrayOfByte);
          md5Transform(arrayOfByte);
          i += 64;
        }
        catch (Exception paramInputStream)
        {
          paramInputStream.printStackTrace();
          return false;
        }
        paramInputStream = paramInputStream;
        paramInputStream.printStackTrace();
        return false;
      }
      if (i + 63 < paramLong) {}
      j = 0;
    }
    for (;;)
    {
      arrayOfByte = new byte[(int)(paramLong - i)];
      try
      {
        paramInputStream.read(arrayOfByte);
        md5Memcpy(this.buffer, arrayOfByte, j, 0, arrayOfByte.length);
        return true;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
      i = 0;
    }
    return false;
  }
  
  public static String toMD5(String paramString)
  {
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
        int i;
        paramString = paramString.getBytes();
      }
      return localUnsupportedEncodingException.toString();
    }
    paramString = new MD5Utils().getMD5(paramString);
    localObject = new StringBuilder(32);
    i = 0;
    while (i < 16)
    {
      ((StringBuilder)localObject).append(Digit[(paramString[i] >>> 4 & 0xF)]);
      ((StringBuilder)localObject).append(Digit[(paramString[i] & 0xF)]);
      i += 1;
    }
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte)
  {
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    md5Final();
    return this.digest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.MD5Utils
 * JD-Core Version:    0.7.0.1
 */