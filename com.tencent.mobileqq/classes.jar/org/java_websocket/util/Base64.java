package org.java_websocket.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int DO_BREAK_LINES = 8;
  public static final int ENCODE = 1;
  private static final byte EQUALS_SIGN = 61;
  public static final int GZIP = 2;
  private static final int MAX_LINE_LENGTH = 76;
  private static final byte NEW_LINE = 10;
  public static final int NO_OPTIONS = 0;
  public static final int ORDERED = 32;
  private static final String PREFERRED_ENCODING = "US-ASCII";
  public static final int URL_SAFE = 16;
  private static final byte WHITE_SPACE_ENC = -5;
  private static final byte[] _ORDERED_ALPHABET;
  private static final byte[] _ORDERED_DECODABET;
  private static final byte[] _STANDARD_ALPHABET;
  private static final byte[] _STANDARD_DECODABET;
  private static final byte[] _URL_SAFE_ALPHABET;
  private static final byte[] _URL_SAFE_DECODABET;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      _STANDARD_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      _STANDARD_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      _URL_SAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      _URL_SAFE_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      _ORDERED_ALPHABET = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      _ORDERED_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new IllegalArgumentException("Source array was null.");
    }
    if (paramArrayOfByte2 == null) {
      throw new IllegalArgumentException("Destination array was null.");
    }
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length)) {
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = getDecodabet(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6 | arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]] & 0xFF;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = getAlphabet(paramInt4);
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label25:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label25;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    encode3to4(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      if ((!$assertionsDisabled) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = localObject;
      } while ($assertionsDisabled);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = encodeBytesToBytes(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  /* Error */
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aload_0
    //   7: ifnonnull +13 -> 20
    //   10: new 192	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc 254
    //   16: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: iload_1
    //   21: ifge +31 -> 52
    //   24: new 192	java/lang/IllegalArgumentException
    //   27: dup
    //   28: new 256	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 259
    //   38: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_1
    //   42: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: iload_2
    //   53: ifge +31 -> 84
    //   56: new 192	java/lang/IllegalArgumentException
    //   59: dup
    //   60: new 256	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 271
    //   70: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload_2
    //   74: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: iload_1
    //   85: iload_2
    //   86: iadd
    //   87: aload_0
    //   88: arraylength
    //   89: if_icmple +43 -> 132
    //   92: new 192	java/lang/IllegalArgumentException
    //   95: dup
    //   96: ldc_w 273
    //   99: iconst_3
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: iload_1
    //   106: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: iload_2
    //   113: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload_0
    //   120: arraylength
    //   121: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   131: athrow
    //   132: iload_3
    //   133: iconst_2
    //   134: iand
    //   135: ifeq +146 -> 281
    //   138: new 275	java/io/ByteArrayOutputStream
    //   141: dup
    //   142: invokespecial 276	java/io/ByteArrayOutputStream:<init>	()V
    //   145: astore 10
    //   147: new 278	org/java_websocket/util/Base64$OutputStream
    //   150: dup
    //   151: aload 10
    //   153: iload_3
    //   154: iconst_1
    //   155: ior
    //   156: invokespecial 281	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   159: astore 12
    //   161: new 283	java/util/zip/GZIPOutputStream
    //   164: dup
    //   165: aload 12
    //   167: invokespecial 286	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore 11
    //   172: aload 11
    //   174: aload_0
    //   175: iload_1
    //   176: iload_2
    //   177: invokevirtual 290	java/util/zip/GZIPOutputStream:write	([BII)V
    //   180: aload 11
    //   182: invokevirtual 293	java/util/zip/GZIPOutputStream:close	()V
    //   185: aload 11
    //   187: ifnull +8 -> 195
    //   190: aload 11
    //   192: invokevirtual 293	java/util/zip/GZIPOutputStream:close	()V
    //   195: aload 12
    //   197: ifnull +8 -> 205
    //   200: aload 12
    //   202: invokevirtual 294	org/java_websocket/util/Base64$OutputStream:close	()V
    //   205: aload 10
    //   207: ifnull +8 -> 215
    //   210: aload 10
    //   212: invokevirtual 295	java/io/ByteArrayOutputStream:close	()V
    //   215: aload 10
    //   217: invokevirtual 299	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   220: astore_0
    //   221: aload_0
    //   222: areturn
    //   223: astore 11
    //   225: aconst_null
    //   226: astore 10
    //   228: aconst_null
    //   229: astore_0
    //   230: aload 13
    //   232: astore 12
    //   234: aload 11
    //   236: athrow
    //   237: astore 14
    //   239: aload_0
    //   240: astore 13
    //   242: aload 10
    //   244: astore 11
    //   246: aload 14
    //   248: astore_0
    //   249: aload 12
    //   251: ifnull +8 -> 259
    //   254: aload 12
    //   256: invokevirtual 293	java/util/zip/GZIPOutputStream:close	()V
    //   259: aload 11
    //   261: ifnull +8 -> 269
    //   264: aload 11
    //   266: invokevirtual 294	org/java_websocket/util/Base64$OutputStream:close	()V
    //   269: aload 13
    //   271: ifnull +8 -> 279
    //   274: aload 13
    //   276: invokevirtual 295	java/io/ByteArrayOutputStream:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: iload_3
    //   282: bipush 8
    //   284: iand
    //   285: ifeq +153 -> 438
    //   288: iconst_1
    //   289: istore 6
    //   291: iload_2
    //   292: iconst_3
    //   293: idiv
    //   294: istore 5
    //   296: iload_2
    //   297: iconst_3
    //   298: irem
    //   299: ifle +145 -> 444
    //   302: iconst_4
    //   303: istore 4
    //   305: iload 4
    //   307: iload 5
    //   309: iconst_4
    //   310: imul
    //   311: iadd
    //   312: istore 5
    //   314: iload 5
    //   316: istore 4
    //   318: iload 6
    //   320: ifeq +13 -> 333
    //   323: iload 5
    //   325: iload 5
    //   327: bipush 76
    //   329: idiv
    //   330: iadd
    //   331: istore 4
    //   333: iload 4
    //   335: newarray byte
    //   337: astore 10
    //   339: iconst_0
    //   340: istore 5
    //   342: iconst_0
    //   343: istore 4
    //   345: iconst_0
    //   346: istore 7
    //   348: iload 7
    //   350: iload_2
    //   351: iconst_2
    //   352: isub
    //   353: if_icmpge +97 -> 450
    //   356: aload_0
    //   357: iload 7
    //   359: iload_1
    //   360: iadd
    //   361: iconst_3
    //   362: aload 10
    //   364: iload 4
    //   366: iload_3
    //   367: invokestatic 221	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   370: pop
    //   371: iload 5
    //   373: iconst_4
    //   374: iadd
    //   375: istore 9
    //   377: iload 9
    //   379: istore 5
    //   381: iload 4
    //   383: istore 8
    //   385: iload 6
    //   387: ifeq +36 -> 423
    //   390: iload 9
    //   392: istore 5
    //   394: iload 4
    //   396: istore 8
    //   398: iload 9
    //   400: bipush 76
    //   402: if_icmplt +21 -> 423
    //   405: aload 10
    //   407: iload 4
    //   409: iconst_4
    //   410: iadd
    //   411: bipush 10
    //   413: bastore
    //   414: iload 4
    //   416: iconst_1
    //   417: iadd
    //   418: istore 8
    //   420: iconst_0
    //   421: istore 5
    //   423: iload 8
    //   425: iconst_4
    //   426: iadd
    //   427: istore 4
    //   429: iload 7
    //   431: iconst_3
    //   432: iadd
    //   433: istore 7
    //   435: goto -87 -> 348
    //   438: iconst_0
    //   439: istore 6
    //   441: goto -150 -> 291
    //   444: iconst_0
    //   445: istore 4
    //   447: goto -142 -> 305
    //   450: iload 4
    //   452: istore 5
    //   454: iload 7
    //   456: iload_2
    //   457: if_icmpge +27 -> 484
    //   460: aload_0
    //   461: iload 7
    //   463: iload_1
    //   464: iadd
    //   465: iload_2
    //   466: iload 7
    //   468: isub
    //   469: aload 10
    //   471: iload 4
    //   473: iload_3
    //   474: invokestatic 221	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   477: pop
    //   478: iload 4
    //   480: iconst_4
    //   481: iadd
    //   482: istore 5
    //   484: aload 10
    //   486: astore_0
    //   487: iload 5
    //   489: aload 10
    //   491: arraylength
    //   492: iconst_1
    //   493: isub
    //   494: if_icmpgt -273 -> 221
    //   497: iload 5
    //   499: newarray byte
    //   501: astore_0
    //   502: aload 10
    //   504: iconst_0
    //   505: aload_0
    //   506: iconst_0
    //   507: iload 5
    //   509: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   512: aload_0
    //   513: areturn
    //   514: astore_0
    //   515: goto -320 -> 195
    //   518: astore_0
    //   519: goto -314 -> 205
    //   522: astore_0
    //   523: goto -308 -> 215
    //   526: astore 10
    //   528: goto -269 -> 259
    //   531: astore 10
    //   533: goto -264 -> 269
    //   536: astore 10
    //   538: goto -259 -> 279
    //   541: astore_0
    //   542: aconst_null
    //   543: astore 11
    //   545: aconst_null
    //   546: astore 13
    //   548: aload 14
    //   550: astore 12
    //   552: goto -303 -> 249
    //   555: astore_0
    //   556: aconst_null
    //   557: astore 11
    //   559: aload 14
    //   561: astore 12
    //   563: aload 10
    //   565: astore 13
    //   567: goto -318 -> 249
    //   570: astore_0
    //   571: aload 12
    //   573: astore 11
    //   575: aload 14
    //   577: astore 12
    //   579: aload 10
    //   581: astore 13
    //   583: goto -334 -> 249
    //   586: astore_0
    //   587: aload 11
    //   589: astore 13
    //   591: aload 12
    //   593: astore 11
    //   595: aload 13
    //   597: astore 12
    //   599: aload 10
    //   601: astore 13
    //   603: goto -354 -> 249
    //   606: astore 11
    //   608: aconst_null
    //   609: astore 12
    //   611: aload 10
    //   613: astore_0
    //   614: aload 12
    //   616: astore 10
    //   618: aload 13
    //   620: astore 12
    //   622: goto -388 -> 234
    //   625: astore 11
    //   627: aload 10
    //   629: astore_0
    //   630: aload 12
    //   632: astore 10
    //   634: aload 13
    //   636: astore 12
    //   638: goto -404 -> 234
    //   641: astore 14
    //   643: aload 11
    //   645: astore 13
    //   647: aload 10
    //   649: astore_0
    //   650: aload 14
    //   652: astore 11
    //   654: aload 12
    //   656: astore 10
    //   658: aload 13
    //   660: astore 12
    //   662: goto -428 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	paramArrayOfByte	byte[]
    //   0	665	1	paramInt1	int
    //   0	665	2	paramInt2	int
    //   0	665	3	paramInt3	int
    //   303	179	4	i	int
    //   294	214	5	j	int
    //   289	151	6	k	int
    //   346	123	7	m	int
    //   383	44	8	n	int
    //   375	28	9	i1	int
    //   145	358	10	localObject1	Object
    //   526	1	10	localException1	java.lang.Exception
    //   531	1	10	localException2	java.lang.Exception
    //   536	76	10	localException3	java.lang.Exception
    //   616	41	10	localObject2	Object
    //   170	21	11	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   223	12	11	localIOException1	IOException
    //   244	350	11	localObject3	Object
    //   606	1	11	localIOException2	IOException
    //   625	19	11	localIOException3	IOException
    //   652	1	11	localIOException4	IOException
    //   159	502	12	localObject4	Object
    //   4	655	13	localObject5	Object
    //   1	1	14	localObject6	Object
    //   237	339	14	localObject7	Object
    //   641	10	14	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   138	147	223	java/io/IOException
    //   234	237	237	finally
    //   190	195	514	java/lang/Exception
    //   200	205	518	java/lang/Exception
    //   210	215	522	java/lang/Exception
    //   254	259	526	java/lang/Exception
    //   264	269	531	java/lang/Exception
    //   274	279	536	java/lang/Exception
    //   138	147	541	finally
    //   147	161	555	finally
    //   161	172	570	finally
    //   172	185	586	finally
    //   147	161	606	java/io/IOException
    //   161	172	625	java/io/IOException
    //   172	185	641	java/io/IOException
  }
  
  private static final byte[] getAlphabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_ALPHABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_ALPHABET;
    }
    return _STANDARD_ALPHABET;
  }
  
  private static final byte[] getDecodabet(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return _URL_SAFE_DECODABET;
    }
    if ((paramInt & 0x20) == 32) {
      return _ORDERED_DECODABET;
    }
    return _STANDARD_DECODABET;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.util.Base64
 * JD-Core Version:    0.7.0.1
 */