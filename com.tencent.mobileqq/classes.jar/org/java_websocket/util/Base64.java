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
  private static final byte[] _ORDERED_ALPHABET = { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final byte[] _ORDERED_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] _STANDARD_ALPHABET = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] _STANDARD_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] _URL_SAFE_ALPHABET = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] _URL_SAFE_DECODABET = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramInt1 >= 0)
        {
          int j = paramInt1 + 3;
          if (j < paramArrayOfByte1.length)
          {
            if (paramInt2 >= 0)
            {
              int i = paramInt2 + 2;
              if (i < paramArrayOfByte2.length)
              {
                byte[] arrayOfByte = getDecodabet(paramInt3);
                paramInt3 = paramInt1 + 2;
                if (paramArrayOfByte1[paramInt3] == 61)
                {
                  paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt1]];
                  paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (paramInt3 & 0xFF) << 18) >>> 16));
                  return 1;
                }
                if (paramArrayOfByte1[j] == 61)
                {
                  i = arrayOfByte[paramArrayOfByte1[paramInt1]];
                  paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
                  paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt3]] & 0xFF) << 6 | (paramInt1 & 0xFF) << 12 | (i & 0xFF) << 18;
                  paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
                  paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
                  return 2;
                }
                int k = arrayOfByte[paramArrayOfByte1[paramInt1]];
                paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
                paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt3]];
                paramInt1 = arrayOfByte[paramArrayOfByte1[j]] & 0xFF | (paramInt1 & 0xFF) << 12 | (k & 0xFF) << 18 | (paramInt3 & 0xFF) << 6;
                paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
                paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
                paramArrayOfByte2[i] = ((byte)paramInt1);
                return 3;
              }
            }
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
          }
        }
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
      }
      throw new IllegalArgumentException("Destination array was null.");
    }
    throw new IllegalArgumentException("Source array was null.");
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = getAlphabet(paramInt4);
    int j = 0;
    if (paramInt2 > 0) {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
    } else {
      paramInt4 = 0;
    }
    int i;
    if (paramInt2 > 1) {
      i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;
    } else {
      i = 0;
    }
    if (paramInt2 > 2) {
      j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
    }
    paramInt1 = paramInt4 | i | j;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          return paramArrayOfByte2;
        }
        paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
        paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
        return paramArrayOfByte2;
      }
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
    }
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
    try
    {
      paramArrayOfByte = encodeBytes(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = encodeBytesToBytes(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label23:
      break label23;
    }
    return new String(paramArrayOfByte);
  }
  
  /* Error */
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +570 -> 571
    //   4: iload_1
    //   5: iflt +532 -> 537
    //   8: iload_2
    //   9: iflt +494 -> 503
    //   12: iload_1
    //   13: iload_2
    //   14: iadd
    //   15: aload_0
    //   16: arraylength
    //   17: if_icmpgt +446 -> 463
    //   20: iload_3
    //   21: iconst_2
    //   22: iand
    //   23: ifeq +220 -> 243
    //   26: aconst_null
    //   27: astore 12
    //   29: aconst_null
    //   30: astore 8
    //   32: new 236	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 237	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore 9
    //   41: new 239	org/java_websocket/util/Base64$OutputStream
    //   44: dup
    //   45: aload 9
    //   47: iload_3
    //   48: iconst_1
    //   49: ior
    //   50: invokespecial 242	org/java_websocket/util/Base64$OutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   53: astore 10
    //   55: new 244	java/util/zip/GZIPOutputStream
    //   58: dup
    //   59: aload 10
    //   61: invokespecial 247	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 11
    //   66: aload 11
    //   68: aload_0
    //   69: iload_1
    //   70: iload_2
    //   71: invokevirtual 251	java/util/zip/GZIPOutputStream:write	([BII)V
    //   74: aload 11
    //   76: invokevirtual 254	java/util/zip/GZIPOutputStream:close	()V
    //   79: aload 11
    //   81: invokevirtual 254	java/util/zip/GZIPOutputStream:close	()V
    //   84: aload 10
    //   86: invokevirtual 255	org/java_websocket/util/Base64$OutputStream:close	()V
    //   89: aload 9
    //   91: invokevirtual 256	java/io/ByteArrayOutputStream:close	()V
    //   94: aload 9
    //   96: invokevirtual 260	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   99: areturn
    //   100: astore_0
    //   101: aload 10
    //   103: astore 8
    //   105: goto +106 -> 211
    //   108: astore 8
    //   110: aload 11
    //   112: astore_0
    //   113: goto +41 -> 154
    //   116: astore_0
    //   117: aload 12
    //   119: astore 11
    //   121: aload 10
    //   123: astore 8
    //   125: goto +86 -> 211
    //   128: astore 8
    //   130: aconst_null
    //   131: astore_0
    //   132: goto +22 -> 154
    //   135: astore_0
    //   136: aconst_null
    //   137: astore 8
    //   139: aload 12
    //   141: astore 11
    //   143: goto +68 -> 211
    //   146: astore 8
    //   148: aconst_null
    //   149: astore 10
    //   151: aload 10
    //   153: astore_0
    //   154: aload 9
    //   156: astore 11
    //   158: aload 8
    //   160: astore 9
    //   162: aload 11
    //   164: astore 8
    //   166: goto +26 -> 192
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 9
    //   173: aload 9
    //   175: astore 8
    //   177: aload 12
    //   179: astore 11
    //   181: goto +30 -> 211
    //   184: astore 9
    //   186: aconst_null
    //   187: astore 10
    //   189: aload 10
    //   191: astore_0
    //   192: aload 9
    //   194: athrow
    //   195: astore 12
    //   197: aload 8
    //   199: astore 9
    //   201: aload_0
    //   202: astore 11
    //   204: aload 10
    //   206: astore 8
    //   208: aload 12
    //   210: astore_0
    //   211: aload 11
    //   213: ifnull +8 -> 221
    //   216: aload 11
    //   218: invokevirtual 254	java/util/zip/GZIPOutputStream:close	()V
    //   221: aload 8
    //   223: ifnull +8 -> 231
    //   226: aload 8
    //   228: invokevirtual 255	org/java_websocket/util/Base64$OutputStream:close	()V
    //   231: aload 9
    //   233: ifnull +8 -> 241
    //   236: aload 9
    //   238: invokevirtual 256	java/io/ByteArrayOutputStream:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: iload_3
    //   244: bipush 8
    //   246: iand
    //   247: ifeq +9 -> 256
    //   250: iconst_1
    //   251: istore 6
    //   253: goto +6 -> 259
    //   256: iconst_0
    //   257: istore 6
    //   259: iload_2
    //   260: iconst_3
    //   261: idiv
    //   262: istore 5
    //   264: iload_2
    //   265: iconst_3
    //   266: irem
    //   267: ifle +9 -> 276
    //   270: iconst_4
    //   271: istore 4
    //   273: goto +6 -> 279
    //   276: iconst_0
    //   277: istore 4
    //   279: iload 5
    //   281: iconst_4
    //   282: imul
    //   283: iload 4
    //   285: iadd
    //   286: istore 5
    //   288: iload 5
    //   290: istore 4
    //   292: iload 6
    //   294: ifeq +13 -> 307
    //   297: iload 5
    //   299: iload 5
    //   301: bipush 76
    //   303: idiv
    //   304: iadd
    //   305: istore 4
    //   307: iload 4
    //   309: newarray byte
    //   311: astore 8
    //   313: iconst_0
    //   314: istore 7
    //   316: iconst_0
    //   317: istore 4
    //   319: iconst_0
    //   320: istore 5
    //   322: iload 7
    //   324: iload_2
    //   325: iconst_2
    //   326: isub
    //   327: if_icmpge +72 -> 399
    //   330: aload_0
    //   331: iload 7
    //   333: iload_1
    //   334: iadd
    //   335: iconst_3
    //   336: aload 8
    //   338: iload 4
    //   340: iload_3
    //   341: invokestatic 213	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   344: pop
    //   345: iload 5
    //   347: iconst_4
    //   348: iadd
    //   349: istore 5
    //   351: iload 6
    //   353: ifeq +31 -> 384
    //   356: iload 5
    //   358: bipush 76
    //   360: if_icmplt +24 -> 384
    //   363: aload 8
    //   365: iload 4
    //   367: iconst_4
    //   368: iadd
    //   369: bipush 10
    //   371: bastore
    //   372: iload 4
    //   374: iconst_1
    //   375: iadd
    //   376: istore 4
    //   378: iconst_0
    //   379: istore 5
    //   381: goto +3 -> 384
    //   384: iload 7
    //   386: iconst_3
    //   387: iadd
    //   388: istore 7
    //   390: iload 4
    //   392: iconst_4
    //   393: iadd
    //   394: istore 4
    //   396: goto -74 -> 322
    //   399: iload 4
    //   401: istore 5
    //   403: iload 7
    //   405: iload_2
    //   406: if_icmpge +27 -> 433
    //   409: aload_0
    //   410: iload 7
    //   412: iload_1
    //   413: iadd
    //   414: iload_2
    //   415: iload 7
    //   417: isub
    //   418: aload 8
    //   420: iload 4
    //   422: iload_3
    //   423: invokestatic 213	org/java_websocket/util/Base64:encode3to4	([BII[BII)[B
    //   426: pop
    //   427: iload 4
    //   429: iconst_4
    //   430: iadd
    //   431: istore 5
    //   433: iload 5
    //   435: aload 8
    //   437: arraylength
    //   438: iconst_1
    //   439: isub
    //   440: if_icmpgt +20 -> 460
    //   443: iload 5
    //   445: newarray byte
    //   447: astore_0
    //   448: aload 8
    //   450: iconst_0
    //   451: aload_0
    //   452: iconst_0
    //   453: iload 5
    //   455: invokestatic 266	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   458: aload_0
    //   459: areturn
    //   460: aload 8
    //   462: areturn
    //   463: new 184	java/lang/IllegalArgumentException
    //   466: dup
    //   467: ldc_w 268
    //   470: iconst_3
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: iload_1
    //   477: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: aastore
    //   481: dup
    //   482: iconst_1
    //   483: iload_2
    //   484: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: dup
    //   489: iconst_2
    //   490: aload_0
    //   491: arraylength
    //   492: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aastore
    //   496: invokestatic 198	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   499: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   502: athrow
    //   503: new 270	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   510: astore_0
    //   511: aload_0
    //   512: ldc_w 273
    //   515: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_0
    //   520: iload_2
    //   521: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: new 184	java/lang/IllegalArgumentException
    //   528: dup
    //   529: aload_0
    //   530: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   536: athrow
    //   537: new 270	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   544: astore_0
    //   545: aload_0
    //   546: ldc_w 286
    //   549: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload_0
    //   554: iload_1
    //   555: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: new 184	java/lang/IllegalArgumentException
    //   562: dup
    //   563: aload_0
    //   564: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   570: athrow
    //   571: new 184	java/lang/IllegalArgumentException
    //   574: dup
    //   575: ldc_w 288
    //   578: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   581: astore_0
    //   582: goto +5 -> 587
    //   585: aload_0
    //   586: athrow
    //   587: goto -2 -> 585
    //   590: astore_0
    //   591: goto -507 -> 84
    //   594: astore_0
    //   595: goto -506 -> 89
    //   598: astore_0
    //   599: goto -505 -> 94
    //   602: astore 10
    //   604: goto -383 -> 221
    //   607: astore 8
    //   609: goto -378 -> 231
    //   612: astore 8
    //   614: goto -373 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramArrayOfByte	byte[]
    //   0	617	1	paramInt1	int
    //   0	617	2	paramInt2	int
    //   0	617	3	paramInt3	int
    //   271	160	4	i	int
    //   262	192	5	j	int
    //   251	101	6	k	int
    //   314	104	7	m	int
    //   30	74	8	localObject1	Object
    //   108	1	8	localIOException1	IOException
    //   123	1	8	localObject2	Object
    //   128	1	8	localIOException2	IOException
    //   137	1	8	localObject3	Object
    //   146	13	8	localIOException3	IOException
    //   164	297	8	localObject4	Object
    //   607	1	8	localException1	java.lang.Exception
    //   612	1	8	localException2	java.lang.Exception
    //   39	135	9	localObject5	Object
    //   184	9	9	localIOException4	IOException
    //   199	38	9	localObject6	Object
    //   53	152	10	localOutputStream	Base64.OutputStream
    //   602	1	10	localException3	java.lang.Exception
    //   64	153	11	localObject7	Object
    //   27	151	12	localObject8	Object
    //   195	14	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   66	79	100	finally
    //   66	79	108	java/io/IOException
    //   55	66	116	finally
    //   55	66	128	java/io/IOException
    //   41	55	135	finally
    //   41	55	146	java/io/IOException
    //   32	41	169	finally
    //   32	41	184	java/io/IOException
    //   192	195	195	finally
    //   79	84	590	java/lang/Exception
    //   84	89	594	java/lang/Exception
    //   89	94	598	java/lang/Exception
    //   216	221	602	java/lang/Exception
    //   226	231	607	java/lang/Exception
    //   236	241	612	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.util.Base64
 * JD-Core Version:    0.7.0.1
 */