package com.tencent.open.base;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
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
  private static final char[] Digit = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final byte[] PADDING;
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
  protected static Comparator<File> fileComparator;
  protected static List<String> md5List;
  protected static Comparator strComparator = new MD5Utils.StringComparator();
  private byte[] buffer = new byte[64];
  private long[] count = new long[2];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  private long[] state = new long[4];
  
  static
  {
    fileComparator = new MD5Utils.FileComparator();
    md5List = new ArrayList();
    PADDING = new byte[] { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public MD5Utils()
  {
    md5Init();
  }
  
  private void Decode(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
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
  
  private void Encode(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(0xFF & paramArrayOfLong[j] >>> 24));
      j += 1;
      i += 4;
    }
  }
  
  private long F(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 ^ 0xFFFFFFFF) & paramLong3 | paramLong2 & paramLong1;
  }
  
  private long FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | paramLong2 & (paramLong3 ^ 0xFFFFFFFF);
  }
  
  private long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 | paramLong3 ^ 0xFFFFFFFF) ^ paramLong2;
  }
  
  private long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static long b2iu(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
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
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  /* Error */
  protected static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 146
    //   2: invokestatic 152	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: new 169	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 176	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 178	java/io/BufferedInputStream
    //   27: dup
    //   28: new 180	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 186	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_0
    //   40: sipush 4096
    //   43: newarray byte
    //   45: astore_3
    //   46: aload_0
    //   47: aload_3
    //   48: invokevirtual 190	java/io/BufferedInputStream:read	([B)I
    //   51: istore_1
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +13 -> 67
    //   57: aload_2
    //   58: aload_3
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 193	java/security/MessageDigest:update	([BII)V
    //   64: goto -18 -> 46
    //   67: aload_2
    //   68: invokevirtual 159	java/security/MessageDigest:digest	()[B
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 196	java/io/BufferedInputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: goto +21 -> 108
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   95: aload_0
    //   96: invokevirtual 196	java/io/BufferedInputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: aload_0
    //   109: invokevirtual 196	java/io/BufferedInputStream:close	()V
    //   112: goto +8 -> 120
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   120: aload_2
    //   121: athrow
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 200	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 201	java/io/FileNotFoundException:printStackTrace	()V
    //   134: aconst_null
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   51	10	1	i	int
    //   5	80	2	localObject1	Object
    //   86	1	2	localObject2	Object
    //   90	31	2	localIOException	java.io.IOException
    //   45	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	76	79	java/io/IOException
    //   46	52	86	finally
    //   57	64	86	finally
    //   67	72	86	finally
    //   91	95	86	finally
    //   46	52	90	java/io/IOException
    //   57	64	90	java/io/IOException
    //   67	72	90	java/io/IOException
    //   95	99	101	java/io/IOException
    //   108	112	115	java/io/IOException
    //   0	22	122	java/security/NoSuchAlgorithmException
    //   24	46	122	java/security/NoSuchAlgorithmException
    //   72	76	122	java/security/NoSuchAlgorithmException
    //   80	84	122	java/security/NoSuchAlgorithmException
    //   95	99	122	java/security/NoSuchAlgorithmException
    //   102	106	122	java/security/NoSuchAlgorithmException
    //   108	112	122	java/security/NoSuchAlgorithmException
    //   116	120	122	java/security/NoSuchAlgorithmException
    //   120	122	122	java/security/NoSuchAlgorithmException
    //   0	22	129	java/io/FileNotFoundException
    //   24	46	129	java/io/FileNotFoundException
    //   72	76	129	java/io/FileNotFoundException
    //   80	84	129	java/io/FileNotFoundException
    //   95	99	129	java/io/FileNotFoundException
    //   102	106	129	java/io/FileNotFoundException
    //   108	112	129	java/io/FileNotFoundException
    //   116	120	129	java/io/FileNotFoundException
    //   120	122	129	java/io/FileNotFoundException
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
        Iterator localIterator;
        if (i < j)
        {
          localIterator = paramString[i];
          if (localIterator.isFile()) {
            md5List.add(encodeFileHexStr(localIterator.getAbsolutePath()));
          } else {
            encodeFolder(localIterator.getAbsolutePath());
          }
        }
        else
        {
          Collections.sort(md5List, strComparator);
          paramString = new StringBuilder();
          localIterator = md5List.iterator();
          if (localIterator.hasNext())
          {
            paramString.append((String)localIterator.next());
            continue;
          }
          md5List.clear();
          paramString = encodeHexStr(paramString.toString());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
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
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String encodeHexStr(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(encode(paramArrayOfByte));
  }
  
  private void md5Final()
  {
    byte[] arrayOfByte = new byte[8];
    Encode(arrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {
      i = 56 - i;
    } else {
      i = 120 - i;
    }
    md5Update(PADDING, i);
    md5Update(arrayOfByte, 8);
    Encode(this.digest, this.state, 16);
  }
  
  private void md5Init()
  {
    long[] arrayOfLong = this.count;
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = 0L;
    arrayOfLong = this.state;
    arrayOfLong[0] = 1732584193L;
    arrayOfLong[1] = 4023233417L;
    arrayOfLong[2] = 2562383102L;
    arrayOfLong[3] = 271733878L;
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
    long[] arrayOfLong = this.state;
    long l2 = arrayOfLong[0];
    long l1 = arrayOfLong[1];
    long l4 = arrayOfLong[2];
    long l3 = arrayOfLong[3];
    arrayOfLong = new long[16];
    Decode(arrayOfLong, paramArrayOfByte, 64);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.state;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte[3] += l3;
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    long[] arrayOfLong = this.count;
    int j = (int)(arrayOfLong[0] >>> 3) & 0x3F;
    long l2 = arrayOfLong[0];
    long l1 = paramInt << 3;
    l2 += l1;
    arrayOfLong[0] = l2;
    if (l2 < l1) {
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.count;
    arrayOfLong[1] += (paramInt >>> 29);
    int i = 64 - j;
    if (paramInt >= i)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, j, 0, i);
      md5Transform(this.buffer);
      while (i + 63 < paramInt)
      {
        md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
        md5Transform(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    else
    {
      i = 0;
    }
    md5Memcpy(this.buffer, paramArrayOfByte, j, i, paramInt - i);
  }
  
  private boolean md5Update(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    Object localObject = this.count;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramLong << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
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
        while (i + 63 < paramLong) {
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
        }
        j = 0;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
    }
    else
    {
      i = 0;
    }
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
      Object localObject;
      label13:
      int i;
      break label13;
    }
    paramString = paramString.getBytes();
    paramString = new MD5Utils().getMD5(paramString);
    localObject = new StringBuilder(32);
    i = 0;
    while (i < 16)
    {
      ((StringBuilder)localObject).append(Digit[(paramString[i] >>> 4 & 0xF)]);
      ((StringBuilder)localObject).append(Digit[(paramString[i] & 0xF)]);
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte)
  {
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    md5Final();
    return this.digest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.MD5Utils
 * JD-Core Version:    0.7.0.1
 */