package com.tencent.tmassistantbase.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class n
{
  static final byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  protected final long[] b = new long[4];
  protected final long[] c = new long[2];
  protected final byte[] d = new byte[64];
  protected final byte[] e = new byte[16];
  
  public n()
  {
    a();
  }
  
  public static long a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 ^ 0xFFFFFFFF) & paramLong3 | paramLong2 & paramLong1;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(a(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      byte[] arrayOfByte;
      label12:
      int i;
      break label12;
    }
    paramString = paramString.getBytes();
    arrayOfByte = new n().a(paramString);
    i = 0;
    paramString = "";
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(b(arrayOfByte[i]));
      paramString = localStringBuilder.toString();
      i += 1;
    }
    return paramString;
  }
  
  private void a()
  {
    long[] arrayOfLong = this.c;
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = 0L;
    arrayOfLong = this.b;
    arrayOfLong[0] = 1732584193L;
    arrayOfLong[1] = 4023233417L;
    arrayOfLong[2] = 2562383102L;
    arrayOfLong[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    long[] arrayOfLong = this.c;
    int j = (int)(arrayOfLong[0] >>> 3) & 0x3F;
    long l2 = arrayOfLong[0];
    long l1 = paramInt << 3;
    l2 += l1;
    arrayOfLong[0] = l2;
    if (l2 < l1) {
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.c;
    arrayOfLong[1] += (paramInt >>> 29);
    int i = 64 - j;
    if (paramInt >= i)
    {
      a(this.d, paramArrayOfByte, j, 0, i);
      d(this.d);
      while (i + 63 < paramInt)
      {
        a(arrayOfByte, paramArrayOfByte, 0, i, 64);
        d(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    else
    {
      i = 0;
    }
    a(this.d, paramArrayOfByte, j, i, paramInt - i);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
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
  
  private void a(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[j] = (a(paramArrayOfByte[i]) | a(paramArrayOfByte[(i + 1)]) << 8 | a(paramArrayOfByte[(i + 2)]) << 16 | a(paramArrayOfByte[(i + 3)]) << 24);
      j += 1;
      i += 4;
    }
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore 10
    //   6: aload_0
    //   7: getfield 25	com/tencent/tmassistantbase/util/n:c	[J
    //   10: astore 11
    //   12: aload 11
    //   14: iconst_0
    //   15: laload
    //   16: iconst_3
    //   17: lushr
    //   18: l2i
    //   19: bipush 63
    //   21: iand
    //   22: istore 5
    //   24: aload 11
    //   26: iconst_0
    //   27: laload
    //   28: lstore 8
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: lstore 6
    //   35: lload 8
    //   37: lload 6
    //   39: ladd
    //   40: lstore 8
    //   42: aload 11
    //   44: iconst_0
    //   45: lload 8
    //   47: lastore
    //   48: lload 8
    //   50: lload 6
    //   52: lcmp
    //   53: ifge +13 -> 66
    //   56: aload 11
    //   58: iconst_1
    //   59: aload 11
    //   61: iconst_1
    //   62: laload
    //   63: lconst_1
    //   64: ladd
    //   65: lastore
    //   66: aload_0
    //   67: getfield 25	com/tencent/tmassistantbase/util/n:c	[J
    //   70: astore 11
    //   72: aload 11
    //   74: iconst_1
    //   75: aload 11
    //   77: iconst_1
    //   78: laload
    //   79: lload_2
    //   80: bipush 29
    //   82: lushr
    //   83: ladd
    //   84: lastore
    //   85: bipush 64
    //   87: iload 5
    //   89: isub
    //   90: istore 4
    //   92: lload_2
    //   93: iload 4
    //   95: i2l
    //   96: lcmp
    //   97: iflt +82 -> 179
    //   100: iload 4
    //   102: newarray byte
    //   104: astore 11
    //   106: aload_1
    //   107: aload 11
    //   109: iconst_0
    //   110: iload 4
    //   112: invokevirtual 104	java/io/InputStream:read	([BII)I
    //   115: pop
    //   116: aload_0
    //   117: aload_0
    //   118: getfield 27	com/tencent/tmassistantbase/util/n:d	[B
    //   121: aload 11
    //   123: iload 5
    //   125: iconst_0
    //   126: iload 4
    //   128: invokespecial 86	com/tencent/tmassistantbase/util/n:a	([B[BIII)V
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 27	com/tencent/tmassistantbase/util/n:d	[B
    //   136: invokespecial 89	com/tencent/tmassistantbase/util/n:d	([B)V
    //   139: iload 4
    //   141: bipush 63
    //   143: iadd
    //   144: i2l
    //   145: lload_2
    //   146: lcmp
    //   147: ifge +26 -> 173
    //   150: aload_1
    //   151: aload 10
    //   153: invokevirtual 107	java/io/InputStream:read	([B)I
    //   156: pop
    //   157: aload_0
    //   158: aload 10
    //   160: invokespecial 89	com/tencent/tmassistantbase/util/n:d	([B)V
    //   163: iload 4
    //   165: bipush 64
    //   167: iadd
    //   168: istore 4
    //   170: goto -31 -> 139
    //   173: iconst_0
    //   174: istore 5
    //   176: goto +6 -> 182
    //   179: iconst_0
    //   180: istore 4
    //   182: lload_2
    //   183: iload 4
    //   185: i2l
    //   186: lsub
    //   187: l2i
    //   188: newarray byte
    //   190: astore 10
    //   192: aload_1
    //   193: aload 10
    //   195: invokevirtual 107	java/io/InputStream:read	([B)I
    //   198: pop
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 27	com/tencent/tmassistantbase/util/n:d	[B
    //   204: aload 10
    //   206: iload 5
    //   208: iconst_0
    //   209: aload 10
    //   211: arraylength
    //   212: invokespecial 86	com/tencent/tmassistantbase/util/n:a	([B[BIII)V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_1
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_1
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_1
    //   224: iconst_0
    //   225: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	n
    //   0	226	1	paramInputStream	java.io.InputStream
    //   0	226	2	paramLong	long
    //   90	94	4	i	int
    //   22	185	5	j	int
    //   33	18	6	l1	long
    //   28	21	8	l2	long
    //   4	206	10	arrayOfByte	byte[]
    //   10	112	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   106	116	217	java/lang/Exception
    //   150	157	220	java/lang/Exception
    //   192	199	223	java/lang/Exception
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | paramLong2 & (paramLong3 ^ 0xFFFFFFFF);
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(b(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String b(byte paramByte)
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
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 130	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_3
    //   15: ldc 135
    //   17: invokestatic 141	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 4
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +28 -> 54
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 107	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: istore_1
    //   37: iload_2
    //   38: ifle -14 -> 24
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 145	java/security/MessageDigest:update	([BII)V
    //   49: iload_2
    //   50: istore_1
    //   51: goto -27 -> 24
    //   54: aload 4
    //   56: invokevirtual 148	java/security/MessageDigest:digest	()[B
    //   59: invokestatic 151	com/tencent/tmassistantbase/util/n:b	([B)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_0
    //   64: invokevirtual 154	java/io/InputStream:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: astore_0
    //   76: goto +9 -> 85
    //   79: goto +18 -> 97
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 154	java/io/InputStream:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 154	java/io/InputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: goto -13 -> 95
    //   111: astore_3
    //   112: goto -33 -> 79
    //   115: astore_0
    //   116: aload_3
    //   117: areturn
    //   118: astore_3
    //   119: goto -26 -> 93
    //   122: astore_0
    //   123: aconst_null
    //   124: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   23	28	1	i	int
    //   34	16	2	j	int
    //   14	76	3	localObject1	Object
    //   111	6	3	localException1	java.lang.Exception
    //   118	1	3	localException2	java.lang.Exception
    //   20	35	4	localMessageDigest	MessageDigest
    //   69	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	69	finally
    //   29	35	69	finally
    //   41	49	69	finally
    //   54	63	69	finally
    //   0	9	82	finally
    //   0	9	107	java/lang/Exception
    //   9	22	111	java/lang/Exception
    //   29	35	111	java/lang/Exception
    //   41	49	111	java/lang/Exception
    //   54	63	111	java/lang/Exception
    //   63	67	115	java/lang/Exception
    //   89	93	118	java/lang/Exception
    //   101	105	122	java/lang/Exception
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str.toUpperCase();
  }
  
  private void b()
  {
    byte[] arrayOfByte = new byte[8];
    a(arrayOfByte, this.c, 8);
    int i = (int)(this.c[0] >>> 3) & 0x3F;
    if (i < 56) {
      i = 56 - i;
    } else {
      i = 120 - i;
    }
    a(a, i);
    a(arrayOfByte, 8);
    a(this.e, this.b, 16);
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(c(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localObject = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (((String)localObject).length() == 1) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append((String)localObject);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 | paramLong3 ^ 0xFFFFFFFF) ^ paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(d(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = this.b;
    long l2 = arrayOfLong[0];
    long l1 = arrayOfLong[1];
    long l4 = arrayOfLong[2];
    long l3 = arrayOfLong[3];
    arrayOfLong = new long[16];
    a(arrayOfLong, paramArrayOfByte, 64);
    l2 = a(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte[3] += l3;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    b();
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.n
 * JD-Core Version:    0.7.0.1
 */