package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.Uri;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PkgTools
{
  public static String APN_TYPE_3GNET = "3gnet";
  public static String APN_TYPE_3GWAP = "3gwap";
  public static String APN_TYPE_CMNET;
  public static String APN_TYPE_CMWAP;
  public static String APN_TYPE_CTNET;
  public static String APN_TYPE_CTWAP;
  public static String APN_TYPE_UNINET;
  public static String APN_TYPE_UNIWAP;
  public static final char EMO_HEAD_CODE = '\024';
  private static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  public static final int PREREAD_LEVEL_NEXTPAGE_HIGH = 4;
  public static final int PREREAD_LEVEL_NEXTPAGE_LOW = 3;
  public static final int PREREAD_LEVEL_NEXTSECTION_HIGH = 2;
  public static final int PREREAD_LEVEL_NEXTSECTION_LOW = 1;
  public static final int PREREAD_LEVEL_NONE = 0;
  private static ConnectivityManager conMgr;
  
  static
  {
    APN_TYPE_CTNET = "ctnet";
    APN_TYPE_CTWAP = "ctwap";
    APN_TYPE_CMNET = "cmnet";
    APN_TYPE_CMWAP = "cmwap";
    APN_TYPE_UNINET = "uninet";
    APN_TYPE_UNIWAP = "uniwap";
  }
  
  public static Long ascByteToLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt2)
    {
      localStringBuffer.append((char)paramArrayOfByte[(paramInt1 + i)]);
      i += 1;
    }
    return Long.valueOf(Long.parseLong(localStringBuffer.toString().trim()));
  }
  
  public static long ascStringToInt(String paramString1, String paramString2)
  {
    paramString1.replace(" ", "");
    return Integer.valueOf(paramString1).intValue();
  }
  
  public static long ascStringToLong(String paramString1, String paramString2)
  {
    paramString1.replace(" ", "");
    return Long.valueOf(paramString1).longValue();
  }
  
  public static String byte2Unicode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 <= paramArrayOfByte.length) && (paramInt2 % 2 == 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = paramInt1;
      while (i < paramInt2 / 2 + paramInt1)
      {
        int j = (i - paramInt1) * 2 + paramInt1;
        int k = paramArrayOfByte[j];
        localStringBuffer.append((char)(paramArrayOfByte[(j + 1)] & 0xFF | k << 8));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    paramArrayOfByte = new IllegalArgumentException();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static String[] byteArray2StringArray(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    for (;;)
    {
      try
      {
        if (localDataInputStream.available() > 0)
        {
          int i = localDataInputStream.readInt();
          if (i > localDataInputStream.available()) {
            return null;
          }
          arrayOfByte = new byte[i];
          localDataInputStream.read(arrayOfByte);
        }
      }
      catch (IOException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        return null;
      }
      try
      {
        paramArrayOfByte = new String(arrayOfByte, "utf-8");
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        continue;
      }
      paramArrayOfByte = new String(arrayOfByte);
      localArrayList.add(paramArrayOfByte);
    }
    paramArrayOfByte = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return paramArrayOfByte;
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static byte[] convertUnicode2UTF8Byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int n = paramString.length();
    byte[] arrayOfByte = new byte[n << 2];
    int m = 0;
    int j = 0;
    for (int k = 0; j < n; k = i)
    {
      int i1 = paramString.charAt(j);
      if (i1 < 128)
      {
        arrayOfByte[k] = ((byte)i1);
        i = k + 1;
      }
      else
      {
        int i2;
        if (i1 < 2048)
        {
          i2 = k + 1;
          arrayOfByte[k] = ((byte)(i1 >> 6 & 0x1F | 0xC0));
          i = i2 + 1;
          arrayOfByte[i2] = ((byte)(i1 & 0x3F | 0x80));
        }
        else if (i1 < 65536)
        {
          i = k + 1;
          arrayOfByte[k] = ((byte)(i1 >> 12 & 0xF | 0xE0));
          k = i + 1;
          arrayOfByte[i] = ((byte)(i1 >> 6 & 0x3F | 0x80));
          arrayOfByte[k] = ((byte)(i1 & 0x3F | 0x80));
          i = k + 1;
        }
        else
        {
          i = k;
          if (i1 < 2097152)
          {
            i = k + 1;
            arrayOfByte[k] = ((byte)(i1 >> 18 & 0x7 | 0xF0));
            k = i + 1;
            arrayOfByte[i] = ((byte)(i1 >> 12 & 0x3F | 0x80));
            i2 = k + 1;
            arrayOfByte[k] = ((byte)(i1 >> 6 & 0x3F | 0x80));
            i = i2 + 1;
            arrayOfByte[i2] = ((byte)(i1 & 0x3F | 0x80));
          }
        }
      }
      j += 1;
    }
    paramString = new byte[k];
    int i = m;
    while (i < k)
    {
      paramString[i] = arrayOfByte[i];
      i += 1;
    }
    return paramString;
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    copyData(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static void dWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void dWordTo2Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }
  
  public static String dealString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.getBytes("utf-8");
        i = 0;
        if (i < paramString.length)
        {
          if (paramString[i] == 13) {
            paramString[i] = 32;
          }
        }
        else
        {
          paramString = new String(paramString, "utf-8");
          return paramString;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        return null;
      }
      i += 1;
    }
  }
  
  public static String decodeCgi(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString == null) {
      return "";
    }
    paramString = paramString.toCharArray();
    int j = paramString.length;
    if (j == 0) {
      return "";
    }
    int i = 0;
    while (i < j)
    {
      String str;
      if (paramString[i] == '%') {
        str = String.valueOf(paramString, i + 1, 2);
      }
      try
      {
        int k = Integer.parseInt(str, 16);
        c = (char)k;
      }
      catch (Exception localException)
      {
        char c;
        label72:
        break label72;
      }
      c = ' ';
      localStringBuffer.append(c);
      i += 3;
      continue;
      localStringBuffer.append(paramString[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String deleteReturn(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = 0;
    paramString = new StringBuffer(paramString);
    while ((i < paramString.length()) && (paramString.length() > 0)) {
      if (paramString.charAt(i) < ' ') {
        paramString.deleteCharAt(i);
      } else {
        i += 1;
      }
    }
    return paramString.toString();
  }
  
  public static String encodeCgi(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString == null) {
      return "";
    }
    paramString = paramString.toCharArray();
    int j = paramString.length;
    if (j == 0) {
      return "";
    }
    int i = 0;
    while (i < j)
    {
      if ((paramString[i] != ' ') && (paramString[i] != '&') && (paramString[i] != ',') && (paramString[i] != '\r') && (paramString[i] != '\t') && (paramString[i] != '\n') && (paramString[i] != '%') && (paramString[i] != '='))
      {
        if (paramString[i] == '\024') {
          localStringBuffer.append(toUrlCode(paramString[i]));
        } else if ((i > 0) && (paramString[(i - 1)] == '\024')) {
          localStringBuffer.append(toUrlCode(paramString[i]));
        } else {
          localStringBuffer.append(paramString[i]);
        }
      }
      else {
        localStringBuffer.append(toUrlCode(paramString[i]));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      return true;
    }
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      return memcmp(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte1.length);
    }
    return false;
  }
  
  public static boolean equalsIgnoreCase(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString1.length() != paramString2.length()) {
        return false;
      }
      int j = paramString1.length();
      char[] arrayOfChar1 = paramString1.toCharArray();
      char[] arrayOfChar2 = paramString2.toCharArray();
      long l1 = 0;
      long l2 = paramString1.length();
      long l3 = j;
      if (l1 <= l2 - l3)
      {
        if (l1 > paramString2.length() - l3) {
          return false;
        }
        int k = 0;
        int i = 0;
        for (;;)
        {
          if (j <= 0) {
            return true;
          }
          char c2 = arrayOfChar1[k];
          char c1 = arrayOfChar2[i];
          if (c2 != c1)
          {
            c2 = Character.toUpperCase(c2);
            c1 = Character.toUpperCase(c1);
            if ((c2 != c1) && (Character.toLowerCase(c2) != Character.toLowerCase(c1))) {
              return false;
            }
          }
          k += 1;
          j -= 1;
          i += 1;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static String getApnType(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 273
    //   3: astore_1
    //   4: aconst_null
    //   5: astore_2
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 279	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 43	com/tencent/mobileqq/utils/httputils/PkgTools:PREFERRED_APN_URI	Landroid/net/Uri;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnonnull +17 -> 42
    //   28: aload_3
    //   29: ifnull +9 -> 38
    //   32: aload_3
    //   33: invokeinterface 290 1 0
    //   38: ldc_w 273
    //   41: areturn
    //   42: aload_3
    //   43: astore 4
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: invokeinterface 294 1 0
    //   53: pop
    //   54: aload_3
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: aload_3
    //   61: ldc_w 296
    //   64: invokeinterface 300 2 0
    //   69: invokeinterface 304 2 0
    //   74: invokevirtual 306	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   77: astore 5
    //   79: aload_3
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 5
    //   86: getstatic 47	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTNET	Ljava/lang/String;
    //   89: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   92: ifeq +15 -> 107
    //   95: aload_3
    //   96: astore 4
    //   98: aload_3
    //   99: astore_2
    //   100: getstatic 47	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTNET	Ljava/lang/String;
    //   103: astore_0
    //   104: goto +196 -> 300
    //   107: aload_3
    //   108: astore 4
    //   110: aload_3
    //   111: astore_2
    //   112: aload 5
    //   114: getstatic 51	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   117: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   120: ifeq +15 -> 135
    //   123: aload_3
    //   124: astore 4
    //   126: aload_3
    //   127: astore_2
    //   128: getstatic 51	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   131: astore_0
    //   132: goto +168 -> 300
    //   135: aload_3
    //   136: astore 4
    //   138: aload_3
    //   139: astore_2
    //   140: aload 5
    //   142: getstatic 55	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMNET	Ljava/lang/String;
    //   145: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   148: ifeq +15 -> 163
    //   151: aload_3
    //   152: astore 4
    //   154: aload_3
    //   155: astore_2
    //   156: getstatic 55	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMNET	Ljava/lang/String;
    //   159: astore_0
    //   160: goto +140 -> 300
    //   163: aload_3
    //   164: astore 4
    //   166: aload_3
    //   167: astore_2
    //   168: aload 5
    //   170: getstatic 59	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   173: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   176: ifeq +15 -> 191
    //   179: aload_3
    //   180: astore 4
    //   182: aload_3
    //   183: astore_2
    //   184: getstatic 59	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   187: astore_0
    //   188: goto +112 -> 300
    //   191: aload_3
    //   192: astore 4
    //   194: aload_3
    //   195: astore_2
    //   196: aload 5
    //   198: getstatic 63	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNINET	Ljava/lang/String;
    //   201: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifeq +15 -> 219
    //   207: aload_3
    //   208: astore 4
    //   210: aload_3
    //   211: astore_2
    //   212: getstatic 63	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNINET	Ljava/lang/String;
    //   215: astore_0
    //   216: goto +84 -> 300
    //   219: aload_1
    //   220: astore_0
    //   221: aload_3
    //   222: astore 4
    //   224: aload_3
    //   225: astore_2
    //   226: aload 5
    //   228: getstatic 67	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   231: invokevirtual 310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   234: ifeq +15 -> 249
    //   237: aload_3
    //   238: astore 4
    //   240: aload_3
    //   241: astore_2
    //   242: getstatic 67	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   245: astore_0
    //   246: goto +54 -> 300
    //   249: aload_0
    //   250: astore 4
    //   252: aload_3
    //   253: ifnull +40 -> 293
    //   256: aload_3
    //   257: astore_2
    //   258: aload_2
    //   259: invokeinterface 290 1 0
    //   264: aload_0
    //   265: areturn
    //   266: astore_0
    //   267: aload 4
    //   269: ifnull +10 -> 279
    //   272: aload 4
    //   274: invokeinterface 290 1 0
    //   279: aload_0
    //   280: athrow
    //   281: aload_1
    //   282: astore 4
    //   284: aload_2
    //   285: ifnull +8 -> 293
    //   288: aload_1
    //   289: astore_0
    //   290: goto -32 -> 258
    //   293: aload 4
    //   295: areturn
    //   296: astore_0
    //   297: goto -16 -> 281
    //   300: goto -51 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	android.content.Context
    //   3	286	1	str1	String
    //   5	280	2	localObject1	Object
    //   23	234	3	localCursor	android.database.Cursor
    //   7	287	4	localObject2	Object
    //   77	150	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   9	24	266	finally
    //   47	54	266	finally
    //   59	79	266	finally
    //   84	95	266	finally
    //   100	104	266	finally
    //   112	123	266	finally
    //   128	132	266	finally
    //   140	151	266	finally
    //   156	160	266	finally
    //   168	179	266	finally
    //   184	188	266	finally
    //   196	207	266	finally
    //   212	216	266	finally
    //   226	237	266	finally
    //   242	246	266	finally
    //   9	24	296	java/lang/Exception
    //   47	54	296	java/lang/Exception
    //   59	79	296	java/lang/Exception
    //   84	95	296	java/lang/Exception
    //   100	104	296	java/lang/Exception
    //   112	123	296	java/lang/Exception
    //   128	132	296	java/lang/Exception
    //   140	151	296	java/lang/Exception
    //   156	160	296	java/lang/Exception
    //   168	179	296	java/lang/Exception
    //   184	188	296	java/lang/Exception
    //   196	207	296	java/lang/Exception
    //   212	216	296	java/lang/Exception
    //   226	237	296	java/lang/Exception
    //   242	246	296	java/lang/Exception
  }
  
  public static String getApnType(String paramString)
  {
    if (paramString == null) {
      return "nomatch";
    }
    try
    {
      if (paramString.startsWith(APN_TYPE_CTNET)) {
        paramString = APN_TYPE_CTNET;
      } else if (paramString.startsWith(APN_TYPE_CTWAP)) {
        paramString = APN_TYPE_CTWAP;
      } else if (paramString.startsWith(APN_TYPE_CMNET)) {
        paramString = APN_TYPE_CMNET;
      } else if (paramString.startsWith(APN_TYPE_CMWAP)) {
        paramString = APN_TYPE_CMWAP;
      } else if (paramString.startsWith(APN_TYPE_UNINET)) {
        paramString = APN_TYPE_UNINET;
      } else if (paramString.startsWith(APN_TYPE_UNIWAP)) {
        paramString = APN_TYPE_UNIWAP;
      } else if (paramString.startsWith(APN_TYPE_3GNET)) {
        paramString = APN_TYPE_3GNET;
      } else if (paramString.startsWith(APN_TYPE_3GWAP)) {
        paramString = APN_TYPE_3GWAP;
      } else {
        return "nomatch";
      }
    }
    catch (Exception paramString)
    {
      return "nomatch";
    }
    return paramString;
  }
  
  public static void getBytesData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    copyData(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static HttpURLConnection getConnectionWithDefaultProxy(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString2, paramInt));
    return (HttpURLConnection)new URL(paramString1).openConnection(paramString2);
  }
  
  @Deprecated
  public static HttpURLConnection getConnectionWithXOnlineHost(String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.indexOf('/', 7);
    String str;
    Object localObject;
    if (i < 0)
    {
      paramString1 = paramString1.substring(7);
      str = "";
    }
    else
    {
      localObject = paramString1.substring(7, i);
      str = paramString1.substring(i);
      paramString1 = (String)localObject;
    }
    if (paramInt != 80)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(str);
      paramString2 = new URL(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(str);
      paramString2 = new URL(((StringBuilder)localObject).toString());
    }
    paramString2 = (HttpURLConnection)paramString2.openConnection();
    paramString2.setRequestProperty("X-Online-Host", paramString1);
    return paramString2;
  }
  
  public static short getHShortData(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)(((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((i & 0xFF) << 0));
  }
  
  public static String getLastParaVal(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      paramString1 = localStringBuilder.toString();
      int m = paramString1.length();
      if (paramString2.length() == 0) {
        return "";
      }
      if (m == 0) {
        return "";
      }
      int i = paramString2.indexOf(paramString1);
      if (i == -1) {
        return "";
      }
      int j = i;
      while (i != -1)
      {
        int k = paramString2.indexOf(paramString1, i + 1);
        j = i;
        i = k;
      }
      i = paramString2.indexOf('&', j);
      if (i == -1) {
        return paramString2.substring(j + m);
      }
      return paramString2.substring(j + m, i);
    }
    return "";
  }
  
  public static long getLittleIndianData(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24);
  }
  
  public static long getLongData(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static long getLongLongData(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 4)] & 0xFF) << 56) + ((paramArrayOfByte[(paramInt + 5)] & 0xFF) << 48) + ((paramArrayOfByte[(paramInt + 6)] & 0xFF) << 40) + ((paramArrayOfByte[(paramInt + 7)] & 0xFF) << 32) + ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
  
  public static int getMultiPara(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString != null)
    {
      if (paramString == null) {
        return -1;
      }
      if (paramString.length() >= 2560) {
        return -1;
      }
      int i = paramString.indexOf(',');
      if (i == -1)
      {
        paramArrayOfString[0] = paramString;
        return 1;
      }
      paramArrayOfString[0] = paramString.substring(0, i);
      if (1 == paramArrayOfString.length) {
        return 1;
      }
      paramString = paramString.substring(i + 1);
      i = 1;
      for (;;)
      {
        int j = paramString.indexOf(',');
        if (j == -1) {
          break;
        }
        paramArrayOfString[i] = paramString.substring(0, j);
        i += 1;
        if (i == paramArrayOfString.length) {
          return i;
        }
        paramString = paramString.substring(j + 1);
      }
      paramArrayOfString[i] = paramString;
      return i + 1;
    }
    return -1;
  }
  
  public static String getParaVal(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() != 0))
    {
      if (paramString2.length() == 0) {
        return "";
      }
      int i = paramString1.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      int j = paramString2.indexOf(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("&");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      int k = paramString2.indexOf(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      boolean bool = paramString2.startsWith(localStringBuilder.toString());
      if (j != -1)
      {
        i = j + i + 1;
      }
      else if (k != -1)
      {
        i = k + 1 + i + 1;
      }
      else
      {
        if (!bool) {
          break label213;
        }
        i += 1;
      }
      j = paramString2.indexOf('&', i);
      if (j == -1) {
        return paramString2.substring(i);
      }
      return paramString2.substring(i, j);
    }
    label213:
    return "";
  }
  
  public static Vector getParas(String paramString)
  {
    Vector localVector = new Vector();
    if (paramString == null) {
      return localVector;
    }
    int i = paramString.indexOf('&');
    if (i == -1)
    {
      localVector.addElement(paramString);
      return localVector;
    }
    localVector.addElement(paramString.substring(0, i));
    for (paramString = paramString.substring(i + 1);; paramString = paramString.substring(i + 1))
    {
      i = paramString.indexOf('&');
      if (i == -1) {
        break;
      }
      localVector.addElement(paramString.substring(0, i));
    }
    localVector.addElement(paramString);
    return localVector;
  }
  
  public static short getShortData(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return (short)(((paramArrayOfByte[paramInt] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 0));
  }
  
  public static String getUTFString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return utf8Byte2String(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int getUnsignedByte(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static byte[] hexToBytes(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    paramString = paramString.toUpperCase();
    if (i % 2 == 0)
    {
      if (i == 0) {
        return null;
      }
      int m = i / 2;
      byte[] arrayOfByte = new byte[m];
      i = 0;
      while (i < m)
      {
        int k = i * 2;
        int j = paramString.charAt(k);
        k = paramString.charAt(k + 1);
        if ((j >= 48) && (j <= 57)) {
          j -= 48;
        }
        for (;;)
        {
          break;
          if ((j < 65) || (j > 70)) {
            break label170;
          }
          j = j - 65 + 10;
        }
        if ((k >= 48) && (k <= 57)) {
          k -= 48;
        }
        for (;;)
        {
          break;
          if ((k < 65) || (k > 70)) {
            break label170;
          }
          k = k - 65 + 10;
        }
        arrayOfByte[i] = ((byte)((j << 4) + 0 + k));
        i += 1;
        continue;
        label170:
        return null;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static String int2IP(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer(16);
    int i = 3;
    while (i >= 0)
    {
      localStringBuffer = localStringBuffer.insert(0, 0xFF & paramLong % 256L);
      paramLong /= 256L;
      if (i != 0) {
        localStringBuffer.insert(0, '.');
      }
      i -= 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String int2IPNet(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer(16);
    int i = 3;
    while (i >= 0)
    {
      localStringBuffer.append(0xFF & paramLong % 256L);
      paramLong /= 256L;
      if (i != 0) {
        localStringBuffer.append('.');
      }
      i -= 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void intToAscString(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    longToAscString(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramString);
  }
  
  public static byte[] intToBytes(int paramInt)
  {
    int i = (byte)(paramInt >> 24 & 0xFF);
    int j = (byte)(paramInt >> 16 & 0xFF);
    int k = (byte)(paramInt >> 8 & 0xFF);
    return new byte[] { (byte)(paramInt & 0xFF), k, j, i };
  }
  
  public static byte[] intToBytes2(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] intToHL(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
  
  public static int ipToInt(String paramString)
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000 | m << 24 & 0xFF000000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int isNext(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      i = k;
      if (paramString[j] == '下')
      {
        int n = j + 2;
        i = k;
        if (n <= m)
        {
          i = paramString[(j + 1)];
          if (i != 19968)
          {
            if (i != 31456)
            {
              if (i != 39029) {
                i = k;
              } else {
                i = 3;
              }
            }
            else {
              i = 1;
            }
          }
          else
          {
            i = k;
            if (j + 3 <= m)
            {
              i = paramString[n];
              if (i != 31456)
              {
                if (i != 39029) {
                  i = k;
                } else {
                  i = 4;
                }
              }
              else {
                i = 2;
              }
            }
          }
        }
      }
      if (i > 0) {
        return i;
      }
      j += 1;
    }
    return k;
  }
  
  public static void littleIndianDw2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)paramLong);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 24));
  }
  
  public static void longToAscString(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt2];
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString().getBytes(paramString);
      int i = 0;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = " ".getBytes(paramString)[0];
        i += 1;
      }
      copyData(arrayOfByte, paramInt2 - localObject.length, (byte[])localObject, localObject.length);
      copyData(paramArrayOfByte, paramInt1, arrayOfByte, arrayOfByte.length);
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static boolean memcmp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      return true;
    }
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1 == paramArrayOfByte2) {
        return true;
      }
      int i = 0;
      while ((i < paramArrayOfByte1.length) && (i < paramArrayOfByte2.length) && (i < paramInt))
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static String readUCS2(InputStream paramInputStream)
  {
    paramInputStream = new DataInputStream(paramInputStream);
    byte[] arrayOfByte = new byte[paramInputStream.readShort()];
    paramInputStream.readFully(arrayOfByte);
    return byte2Unicode(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public static String replace(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2, paramInt);
    if (i == -1) {
      return paramString1.substring(paramInt);
    }
    int j = paramString2.length();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1.substring(paramInt, i));
    localStringBuffer.append(paramString3);
    localStringBuffer.append(replace(paramString1, i + j, paramString2, paramString3));
    return localStringBuffer.toString();
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    int k = paramString2.length();
    int m = paramString3.length();
    StringBuffer localStringBuffer = new StringBuffer(paramString1);
    int j = 0;
    int i = 0;
    for (;;)
    {
      int n = paramString1.indexOf(paramString2, j);
      if (n == -1) {
        break;
      }
      j = n + k;
      n += i;
      localStringBuffer.delete(n, j + i);
      localStringBuffer.insert(n, paramString3);
      i += m - k;
    }
    return localStringBuffer.toString();
  }
  
  public static String short2Port(byte[] paramArrayOfByte)
  {
    getShortData(paramArrayOfByte, 0);
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 2) {
        return "";
      }
      byte[] arrayOfByte = new byte[4];
      copyData(arrayOfByte, 2, paramArrayOfByte, 2);
      long l = getLongData(arrayOfByte, 0);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(l);
      paramArrayOfByte.append("");
      return paramArrayOfByte.toString();
    }
    return "";
  }
  
  public static byte[] shortToHL(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)(paramShort >> 8 & 0xFF), i };
  }
  
  public static String[] split(String paramString1, String paramString2)
  {
    Vector localVector = new Vector();
    int j = 0;
    int k;
    for (int i = 0;; i = paramString2.length() + k)
    {
      k = paramString1.indexOf(paramString2, i);
      if (k == -1) {
        break;
      }
      localVector.addElement(paramString1.substring(i, k));
    }
    localVector.addElement(paramString1.substring(i, paramString1.length()));
    paramString1 = new String[localVector.size()];
    i = j;
    while (i < paramString1.length)
    {
      paramString1[i] = ((String)localVector.elementAt(i));
      i += 1;
    }
    return paramString1;
  }
  
  public static byte[] stringArray2byteArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    int i = 0;
    for (;;)
    {
      try
      {
        int j = paramArrayOfString.length;
        if (i >= j) {
          break;
        }
      }
      catch (IOException paramArrayOfString)
      {
        byte[] arrayOfByte;
        return null;
      }
      try
      {
        arrayOfByte = paramArrayOfString[i].getBytes("utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        continue;
      }
      arrayOfByte = paramArrayOfString[i].getBytes();
      localDataOutputStream.writeInt(arrayOfByte.length);
      localDataOutputStream.write(arrayOfByte);
      i += 1;
    }
    localDataOutputStream.flush();
    paramArrayOfString = localByteArrayOutputStream.toByteArray();
    localDataOutputStream.close();
    localByteArrayOutputStream.close();
    return paramArrayOfString;
  }
  
  public static String toHexStr(byte paramByte)
  {
    int j = (paramByte & 0xF0) >>> 4;
    int i = paramByte & 0xF;
    if (j > 9) {
      paramByte = j - 10 + 65;
    } else {
      paramByte = j + 48;
    }
    char c1 = (char)paramByte;
    if (i > 9) {
      paramByte = i - 10 + 65;
    } else {
      paramByte = i + 48;
    }
    char c2 = (char)paramByte;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(c1));
    localStringBuilder.append(String.valueOf(c2));
    return localStringBuilder.toString();
  }
  
  public static String toHexStr(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = (k & 0xF0) >>> 4;
      k &= 0xF;
      if (j > 9) {
        j = j - 10 + 65;
      } else {
        j += 48;
      }
      char c1 = (char)j;
      if (k > 9) {
        j = k - 10 + 65;
      } else {
        j = k + 48;
      }
      char c2 = (char)j;
      localStringBuffer.append(c1);
      localStringBuffer.append(c2);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String toUrlCode(char paramChar)
  {
    String str = Integer.toHexString(paramChar);
    if (str.length() == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("%0");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String trim(String paramString)
  {
    int k = paramString.length();
    Object localObject = paramString.toCharArray();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= k) {
        break;
      }
      j = k;
      if (localObject[(0 + i)] > ' ') {
        break;
      }
      i += 1;
    }
    while ((i < j) && (localObject[(0 + j - 1)] <= ' ')) {
      j -= 1;
    }
    if (i <= 0)
    {
      localObject = paramString;
      if (j >= paramString.length()) {}
    }
    else
    {
      localObject = paramString.substring(i, j);
    }
    return localObject;
  }
  
  public static byte[] u2b(String paramString)
  {
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString.charAt(i);
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] unicode2Byte(String paramString)
  {
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString.charAt(i);
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m >> 8));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public static String utf8Byte2String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: iload_2
    //   10: iconst_2
    //   11: iadd
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_3
    //   16: iconst_0
    //   17: iload_2
    //   18: bipush 8
    //   20: ishr
    //   21: i2b
    //   22: bastore
    //   23: aload_3
    //   24: iconst_1
    //   25: iload_2
    //   26: i2b
    //   27: bastore
    //   28: aload_0
    //   29: iload_1
    //   30: aload_3
    //   31: iconst_2
    //   32: iload_2
    //   33: invokestatic 211	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   36: new 152	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 155	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore_0
    //   45: new 150	java/io/DataInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 158	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 547	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   58: astore 4
    //   60: aload_3
    //   61: invokevirtual 548	java/io/DataInputStream:close	()V
    //   64: aload_0
    //   65: invokevirtual 549	java/io/ByteArrayInputStream:close	()V
    //   68: aload 4
    //   70: areturn
    //   71: astore 5
    //   73: aload_3
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: aload 5
    //   80: astore_0
    //   81: goto +34 -> 115
    //   84: goto +59 -> 143
    //   87: goto +83 -> 170
    //   90: astore 5
    //   92: aload_0
    //   93: astore_3
    //   94: aload 5
    //   96: astore_0
    //   97: goto +18 -> 115
    //   100: aload 5
    //   102: astore_3
    //   103: goto +40 -> 143
    //   106: aload 6
    //   108: astore_3
    //   109: goto +61 -> 170
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_3
    //   115: aload 4
    //   117: ifnull +11 -> 128
    //   120: aload 4
    //   122: invokevirtual 548	java/io/DataInputStream:close	()V
    //   125: goto +3 -> 128
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 549	java/io/ByteArrayInputStream:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: aconst_null
    //   139: astore_0
    //   140: aload 5
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull +10 -> 154
    //   147: aload_3
    //   148: invokevirtual 548	java/io/DataInputStream:close	()V
    //   151: goto +3 -> 154
    //   154: aload_0
    //   155: ifnull +33 -> 188
    //   158: aload_0
    //   159: invokevirtual 549	java/io/ByteArrayInputStream:close	()V
    //   162: goto +26 -> 188
    //   165: aconst_null
    //   166: astore_0
    //   167: aload 6
    //   169: astore_3
    //   170: aload_3
    //   171: ifnull +10 -> 181
    //   174: aload_3
    //   175: invokevirtual 548	java/io/DataInputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_0
    //   182: ifnull +6 -> 188
    //   185: goto -27 -> 158
    //   188: ldc 113
    //   190: areturn
    //   191: astore_0
    //   192: goto -27 -> 165
    //   195: astore_0
    //   196: goto -58 -> 138
    //   199: astore_3
    //   200: goto -94 -> 106
    //   203: astore_3
    //   204: goto -104 -> 100
    //   207: astore 4
    //   209: goto -122 -> 87
    //   212: astore 4
    //   214: goto -130 -> 84
    //   217: astore_3
    //   218: goto -154 -> 64
    //   221: astore_0
    //   222: aload 4
    //   224: areturn
    //   225: astore 4
    //   227: goto -99 -> 128
    //   230: astore_3
    //   231: goto -95 -> 136
    //   234: astore_3
    //   235: goto -81 -> 154
    //   238: astore_0
    //   239: goto -51 -> 188
    //   242: astore_3
    //   243: goto -62 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramArrayOfByte	byte[]
    //   0	246	1	paramInt1	int
    //   0	246	2	paramInt2	int
    //   14	161	3	localObject1	Object
    //   199	1	3	localIOException1	IOException
    //   203	1	3	localException1	Exception
    //   217	1	3	localIOException2	IOException
    //   230	1	3	localIOException3	IOException
    //   234	1	3	localIOException4	IOException
    //   242	1	3	localIOException5	IOException
    //   7	114	4	localObject2	Object
    //   207	1	4	localIOException6	IOException
    //   212	11	4	localException2	Exception
    //   225	1	4	localIOException7	IOException
    //   1	1	5	localObject3	Object
    //   71	8	5	localObject4	Object
    //   90	51	5	localObject5	Object
    //   4	164	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   54	60	71	finally
    //   45	54	90	finally
    //   9	15	112	finally
    //   28	45	112	finally
    //   9	15	191	java/io/IOException
    //   28	45	191	java/io/IOException
    //   9	15	195	java/lang/Exception
    //   28	45	195	java/lang/Exception
    //   45	54	199	java/io/IOException
    //   45	54	203	java/lang/Exception
    //   54	60	207	java/io/IOException
    //   54	60	212	java/lang/Exception
    //   60	64	217	java/io/IOException
    //   64	68	221	java/io/IOException
    //   120	125	225	java/io/IOException
    //   132	136	230	java/io/IOException
    //   147	151	234	java/io/IOException
    //   158	162	238	java/io/IOException
    //   174	178	242	java/io/IOException
  }
  
  public static byte[] vectorString2byteArray(List paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    return stringArray2byteArray(arrayOfString);
  }
  
  public static void word2Byte(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
  }
  
  public static void writeUCS2(String paramString, OutputStream paramOutputStream)
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramString = unicode2Byte(paramString);
    paramOutputStream.writeShort(paramString.length);
    paramOutputStream.write(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.PkgTools
 * JD-Core Version:    0.7.0.1
 */