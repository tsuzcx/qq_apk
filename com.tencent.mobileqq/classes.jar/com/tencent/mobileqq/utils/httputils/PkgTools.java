package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.qphone.base.util.BaseApplication;
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
  
  public static void DWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void DWordTo2Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }
  
  public static String Decodecgi(String paramString)
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
      if (paramString[i] == '%')
      {
        String str = String.valueOf(paramString, i + 1, 2);
        try
        {
          int k = Integer.parseInt(str, 16);
          c = (char)k;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            char c = ' ';
          }
        }
        localStringBuffer.append(c);
        i += 3;
        continue;
      }
      localStringBuffer.append(paramString[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String Encodecgi(String paramString)
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
    if (i < j)
    {
      if ((paramString[i] == ' ') || (paramString[i] == '&') || (paramString[i] == ',') || (paramString[i] == '\r') || (paramString[i] == '\t') || (paramString[i] == '\n') || (paramString[i] == '%') || (paramString[i] == '=')) {
        localStringBuffer.append(toUrlCode(paramString[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramString[i] == '\024') {
          localStringBuffer.append(toUrlCode(paramString[i]));
        } else if ((i > 0) && (paramString[(i - 1)] == '\024')) {
          localStringBuffer.append(toUrlCode(paramString[i]));
        } else {
          localStringBuffer.append(paramString[i]);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String GetLastParaVal(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return "";
    }
    paramString1 = paramString1 + "=";
    int m = paramString1.length();
    if (paramString2.length() == 0) {
      return "";
    }
    if (m == 0) {
      return "";
    }
    int j = paramString2.indexOf(paramString1);
    if (j == -1) {
      return "";
    }
    for (;;)
    {
      int i;
      if (i != -1)
      {
        int k = paramString2.indexOf(paramString1, i + 1);
        j = i;
        i = k;
      }
      else
      {
        i = paramString2.indexOf('&', j);
        if (i == -1) {
          return paramString2.substring(j + m);
        }
        return paramString2.substring(j + m, i);
        i = j;
      }
    }
  }
  
  public static int GetMultiPara(String[] paramArrayOfString, String paramString)
  {
    int j = 1;
    int i = 1;
    if ((paramArrayOfString == null) || (paramString == null)) {
      i = -1;
    }
    int k;
    do
    {
      return i;
      if (paramString.length() >= 2560) {
        return -1;
      }
      k = paramString.indexOf(',');
      if (k == -1)
      {
        paramArrayOfString[0] = paramString;
        return 1;
      }
      paramArrayOfString[0] = paramString.substring(0, k);
    } while (1 == paramArrayOfString.length);
    for (paramString = paramString.substring(k + 1);; paramString = paramString.substring(k + 1))
    {
      k = paramString.indexOf(',');
      if (k == -1) {
        break label121;
      }
      paramArrayOfString[j] = paramString.substring(0, k);
      j += 1;
      i = j;
      if (j == paramArrayOfString.length) {
        break;
      }
    }
    label121:
    paramArrayOfString[j] = paramString;
    return j + 1;
  }
  
  public static String GetParaVal(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {
      return "";
    }
    int i = paramString1.length();
    int j = paramString2.indexOf(paramString1 + "=");
    int k = paramString2.indexOf("&" + paramString1 + "=");
    boolean bool = paramString2.startsWith(paramString1 + "=");
    if (j != -1) {
      i = i + j + 1;
    }
    for (;;)
    {
      j = paramString2.indexOf('&', i);
      if (j != -1) {
        break label172;
      }
      return paramString2.substring(i);
      if (k != -1)
      {
        i = i + (k + 1) + 1;
      }
      else
      {
        if (!bool) {
          break;
        }
        i += 1;
      }
    }
    return "";
    label172:
    return paramString2.substring(i, j);
  }
  
  public static Vector GetParas(String paramString)
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
  
  public static byte[] Unicode2Byte(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k << 1];
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
  
  public static void Word2Byte(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
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
  
  public static String byte2Unicode(byte[] paramArrayOfByte)
  {
    return byte2Unicode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String byte2Unicode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt2 % 2 != 0)) {
      throw new IllegalArgumentException();
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt2 / 2 + paramInt1)
    {
      localStringBuffer.append((char)(paramArrayOfByte[((i - paramInt1) * 2 + paramInt1)] << 8 | paramArrayOfByte[((i - paramInt1) * 2 + paramInt1 + 1)] & 0xFF));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String[] byteArray2StringArray(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    try
    {
      for (;;)
      {
        if (localDataInputStream.available() > 0)
        {
          int i = localDataInputStream.readInt();
          if (i > localDataInputStream.available()) {
            return null;
          }
          byte[] arrayOfByte = new byte[i];
          localDataInputStream.read(arrayOfByte);
          try
          {
            paramArrayOfByte = new String(arrayOfByte, "utf-8");
            localArrayList.add(paramArrayOfByte);
          }
          catch (UnsupportedEncodingException paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte = new String(arrayOfByte);
            }
          }
        }
      }
      paramArrayOfByte = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return null;
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  public static byte[] convertUnicode2UTF8Byte(String paramString)
  {
    int k = 0;
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    int n = paramString.length();
    byte[] arrayOfByte2 = new byte[n << 2];
    int j = 0;
    int i = 0;
    label28:
    int i1;
    int m;
    if (j < n)
    {
      i1 = paramString.charAt(j);
      if (i1 < 128)
      {
        m = i + 1;
        arrayOfByte2[i] = ((byte)i1);
        i = m;
      }
    }
    for (;;)
    {
      j += 1;
      break label28;
      if (i1 < 2048)
      {
        m = i + 1;
        arrayOfByte2[i] = ((byte)(i1 >> 6 & 0x1F | 0xC0));
        i = m + 1;
        arrayOfByte2[m] = ((byte)(i1 & 0x3F | 0x80));
      }
      else if (i1 < 65536)
      {
        m = i + 1;
        arrayOfByte2[i] = ((byte)(i1 >> 12 & 0xF | 0xE0));
        int i2 = m + 1;
        arrayOfByte2[m] = ((byte)(i1 >> 6 & 0x3F | 0x80));
        i = i2 + 1;
        arrayOfByte2[i2] = ((byte)(i1 & 0x3F | 0x80));
      }
      else if (i1 < 2097152)
      {
        m = i + 1;
        arrayOfByte2[i] = ((byte)(i1 >> 18 & 0x7 | 0xF0));
        i = m + 1;
        arrayOfByte2[m] = ((byte)(i1 >> 12 & 0x3F | 0x80));
        m = i + 1;
        arrayOfByte2[i] = ((byte)(i1 >> 6 & 0x3F | 0x80));
        i = m + 1;
        arrayOfByte2[m] = ((byte)(i1 & 0x3F | 0x80));
        continue;
        byte[] arrayOfByte1 = new byte[i];
        j = k;
        for (;;)
        {
          paramString = arrayOfByte1;
          if (j >= i) {
            break;
          }
          arrayOfByte1[j] = arrayOfByte2[j];
          j += 1;
        }
      }
    }
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    copyData(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static String dealString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes("utf-8");
      i = 0;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        int i;
        paramString = null;
        continue;
        i += 1;
      }
    }
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
  
  public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayOfByte1 == null);
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
    return memcmp(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte1.length);
  }
  
  public static boolean equalsIgnoreCase(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() != paramString2.length())) {}
    int i;
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    do
    {
      return false;
      i = paramString1.length();
      arrayOfChar1 = paramString1.toCharArray();
      arrayOfChar2 = paramString2.toCharArray();
    } while ((0 > paramString1.length() - i) || (0 > paramString2.length() - i));
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (i <= 0) {
        return true;
      }
      char c2 = arrayOfChar1[j];
      char c1 = arrayOfChar2[k];
      if (c2 != c1)
      {
        c2 = Character.toUpperCase(c2);
        c1 = Character.toUpperCase(c1);
        if ((c2 != c1) && (Character.toLowerCase(c2) != Character.toLowerCase(c1))) {
          break;
        }
      }
      k += 1;
      j += 1;
      i -= 1;
    }
  }
  
  /* Error */
  public static String getApnType(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 331	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 43	com/tencent/mobileqq/utils/httputils/PkgTools:PREFERRED_APN_URI	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 337	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +17 -> 33
    //   19: aload_1
    //   20: ifnull +9 -> 29
    //   23: aload_1
    //   24: invokeinterface 342 1 0
    //   29: ldc_w 344
    //   32: areturn
    //   33: aload_1
    //   34: invokeinterface 348 1 0
    //   39: pop
    //   40: aload_1
    //   41: aload_1
    //   42: ldc_w 350
    //   45: invokeinterface 353 2 0
    //   50: invokeinterface 356 2 0
    //   55: invokevirtual 358	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   58: astore_0
    //   59: aload_0
    //   60: getstatic 47	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTNET	Ljava/lang/String;
    //   63: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +23 -> 89
    //   69: getstatic 47	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTNET	Ljava/lang/String;
    //   72: astore_0
    //   73: aload_0
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +11 -> 87
    //   79: aload_1
    //   80: invokeinterface 342 1 0
    //   85: aload_0
    //   86: astore_2
    //   87: aload_2
    //   88: areturn
    //   89: aload_0
    //   90: getstatic 51	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   93: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   96: ifeq +10 -> 106
    //   99: getstatic 51	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CTWAP	Ljava/lang/String;
    //   102: astore_0
    //   103: goto -30 -> 73
    //   106: aload_0
    //   107: getstatic 55	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMNET	Ljava/lang/String;
    //   110: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   113: ifeq +10 -> 123
    //   116: getstatic 55	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMNET	Ljava/lang/String;
    //   119: astore_0
    //   120: goto -47 -> 73
    //   123: aload_0
    //   124: getstatic 59	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   127: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   130: ifeq +10 -> 140
    //   133: getstatic 59	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_CMWAP	Ljava/lang/String;
    //   136: astore_0
    //   137: goto -64 -> 73
    //   140: aload_0
    //   141: getstatic 63	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNINET	Ljava/lang/String;
    //   144: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   147: ifeq +10 -> 157
    //   150: getstatic 63	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNINET	Ljava/lang/String;
    //   153: astore_0
    //   154: goto -81 -> 73
    //   157: aload_0
    //   158: getstatic 67	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   161: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   164: ifeq +62 -> 226
    //   167: getstatic 67	com/tencent/mobileqq/utils/httputils/PkgTools:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   170: astore_0
    //   171: goto -98 -> 73
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +41 -> 219
    //   181: aload_0
    //   182: invokeinterface 342 1 0
    //   187: ldc_w 344
    //   190: astore_2
    //   191: goto -104 -> 87
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +9 -> 207
    //   201: aload_1
    //   202: invokeinterface 342 1 0
    //   207: aload_0
    //   208: athrow
    //   209: astore_0
    //   210: goto -13 -> 197
    //   213: astore_0
    //   214: aload_1
    //   215: astore_0
    //   216: goto -39 -> 177
    //   219: ldc_w 344
    //   222: astore_2
    //   223: goto -136 -> 87
    //   226: ldc_w 344
    //   229: astore_0
    //   230: goto -157 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramContext	android.content.Context
    //   14	201	1	localCursor	android.database.Cursor
    //   74	149	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	174	java/lang/Exception
    //   0	15	194	finally
    //   33	73	209	finally
    //   89	103	209	finally
    //   106	120	209	finally
    //   123	137	209	finally
    //   140	154	209	finally
    //   157	171	209	finally
    //   33	73	213	java/lang/Exception
    //   89	103	213	java/lang/Exception
    //   106	120	213	java/lang/Exception
    //   123	137	213	java/lang/Exception
    //   140	154	213	java/lang/Exception
    //   157	171	213	java/lang/Exception
  }
  
  public static String getApnType(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return "nomatch";
      try
      {
        if (paramString.startsWith(APN_TYPE_CTNET)) {
          return APN_TYPE_CTNET;
        }
        if (paramString.startsWith(APN_TYPE_CTWAP)) {
          return APN_TYPE_CTWAP;
        }
        if (paramString.startsWith(APN_TYPE_CMNET)) {
          return APN_TYPE_CMNET;
        }
        if (paramString.startsWith(APN_TYPE_CMWAP)) {
          return APN_TYPE_CMWAP;
        }
        if (paramString.startsWith(APN_TYPE_UNINET)) {
          return APN_TYPE_UNINET;
        }
        if (paramString.startsWith(APN_TYPE_UNIWAP)) {
          return APN_TYPE_UNIWAP;
        }
        if (paramString.startsWith(APN_TYPE_3GNET)) {
          return APN_TYPE_3GNET;
        }
        if (paramString.startsWith(APN_TYPE_3GWAP))
        {
          paramString = APN_TYPE_3GWAP;
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "nomatch";
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
  
  public static HttpURLConnection getConnectionWithXOnlineHost(String paramString1, String paramString2, int paramInt)
  {
    return BdhUtils.getConnectionWithXOnlineHost(paramString1, paramString2, paramInt);
  }
  
  public static short getHShortData(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[paramInt] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
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
  
  public static NetworkInfo getNetWorkInfo()
  {
    if (conMgr == null) {
      conMgr = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
    return conMgr.getActiveNetworkInfo();
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
    if ((i % 2 != 0) || (i == 0)) {
      return null;
    }
    int k = i / 2;
    byte[] arrayOfByte = new byte[k];
    i = 0;
    if (i < k)
    {
      int j = paramString.charAt(i * 2);
      int m = paramString.charAt(i * 2 + 1);
      if ((j >= 48) && (j <= 57))
      {
        j = (j - 48 << 4) + 0;
        label84:
        if ((m < 48) || (m > 57)) {
          break label148;
        }
        j += m - 48;
      }
      for (;;)
      {
        arrayOfByte[i] = ((byte)j);
        i += 1;
        break;
        if ((j >= 65) && (j <= 70))
        {
          j = (j - 65 + 10 << 4) + 0;
          break label84;
        }
        return null;
        label148:
        if ((m < 65) || (m > 70)) {
          break label176;
        }
        j += m - 65 + 10;
      }
      label176:
      return null;
    }
    return arrayOfByte;
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
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int isNext(String paramString)
  {
    int j = 0;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int k = 0;
    for (;;)
    {
      int i = j;
      if (k < m)
      {
        i = j;
        if (paramString[k] == '下')
        {
          i = j;
          if (k + 2 <= m) {
            switch (paramString[(k + 1)])
            {
            default: 
              i = j;
            }
          }
        }
      }
      while (i > 0)
      {
        return i;
        i = 3;
        continue;
        i = 1;
        continue;
        i = j;
        if (k + 3 <= m) {
          switch (paramString[(k + 2)])
          {
          default: 
            i = j;
            break;
          case '章': 
            i = 2;
            break;
          case '页': 
            i = 4;
          }
        }
      }
      k += 1;
      j = i;
    }
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
    int i = 0;
    try
    {
      byte[] arrayOfByte1 = new byte[paramInt2];
      byte[] arrayOfByte2 = (paramLong + "").getBytes(paramString);
      while (i < arrayOfByte1.length)
      {
        arrayOfByte1[i] = " ".getBytes(paramString)[0];
        i += 1;
      }
      copyData(arrayOfByte1, paramInt2 - arrayOfByte2.length, arrayOfByte2, arrayOfByte2.length);
      copyData(paramArrayOfByte, paramInt1, arrayOfByte1, arrayOfByte1.length);
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static boolean memcmp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    boolean bool = false;
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {}
    do
    {
      return true;
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
        return false;
      }
    } while (paramArrayOfByte1 == paramArrayOfByte2);
    int i = 0;
    if ((i < paramArrayOfByte1.length) && (i < paramArrayOfByte2.length) && (i < paramInt)) {
      if (paramArrayOfByte1[i] == paramArrayOfByte2[i]) {}
    }
    for (;;)
    {
      return bool;
      i += 1;
      break;
      bool = true;
    }
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
    localStringBuffer.append(paramString1.substring(paramInt, i)).append(paramString3).append(replace(paramString1, i + j, paramString2, paramString3));
    return localStringBuffer.toString();
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int k = paramString2.length();
    int m = paramString3.length();
    StringBuffer localStringBuffer = new StringBuffer(paramString1);
    int i = 0;
    for (;;)
    {
      int n = paramString1.indexOf(paramString2, j);
      if (n == -1) {
        break;
      }
      j = n + k;
      localStringBuffer.delete(n + i, j + i);
      localStringBuffer.insert(n + i, paramString3);
      i += m - k;
    }
    return localStringBuffer.toString();
  }
  
  public static String short2Port(byte[] paramArrayOfByte)
  {
    getShortData(paramArrayOfByte, 0);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 2)) {
      return "";
    }
    byte[] arrayOfByte = new byte[4];
    copyData(arrayOfByte, 2, paramArrayOfByte, 2);
    long l = getLongData(arrayOfByte, 0);
    return l + "";
  }
  
  public static byte[] shortToHL(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)(paramShort >> 8 & 0xFF), i };
  }
  
  public static String[] split(String paramString1, String paramString2)
  {
    int j = 0;
    Vector localVector = new Vector();
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
    try
    {
      for (;;)
      {
        int j = paramArrayOfString.length;
        if (i < j) {
          try
          {
            byte[] arrayOfByte1 = paramArrayOfString[i].getBytes("utf-8");
            localDataOutputStream.writeInt(arrayOfByte1.length);
            localDataOutputStream.write(arrayOfByte1);
            i += 1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              byte[] arrayOfByte2 = paramArrayOfString[i].getBytes();
            }
          }
        }
      }
      localDataOutputStream.flush();
      paramArrayOfString = localByteArrayOutputStream.toByteArray();
      localDataOutputStream.close();
      localByteArrayOutputStream.close();
      return paramArrayOfString;
    }
    catch (IOException paramArrayOfString) {}
    return null;
  }
  
  public static String toHexStr(byte paramByte)
  {
    int i = (paramByte & 0xF0) >>> 4;
    paramByte &= 0xF;
    char c1;
    if (i > 9)
    {
      c1 = (char)(i - 10 + 65);
      if (paramByte <= 9) {
        break label77;
      }
    }
    label77:
    for (char c2 = (char)(paramByte - 10 + 65);; c2 = (char)(paramByte + 48))
    {
      return String.valueOf(c1) + String.valueOf(c2);
      c1 = (char)(i + 48);
      break;
    }
  }
  
  public static String toHexStr(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = (k & 0xF0) >>> 4;
      k &= 0xF;
      char c1;
      if (j > 9)
      {
        c1 = (char)(j - 10 + 65);
        label66:
        if (k <= 9) {
          break label111;
        }
      }
      label111:
      for (char c2 = (char)(k - 10 + 65);; c2 = (char)(k + 48))
      {
        localStringBuffer.append(c1).append(c2);
        i += 1;
        break;
        c1 = (char)(j + 48);
        break label66;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String toUrlCode(char paramChar)
  {
    String str = Integer.toHexString(paramChar);
    if (str.length() == 1) {
      return "%0" + str;
    }
    return "%" + str;
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
    int i = 0;
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k << 1];
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
  
  /* Error */
  public static String utf8Byte2String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: ldc 92
    //   10: astore 4
    //   12: iload_2
    //   13: iconst_2
    //   14: iadd
    //   15: newarray byte
    //   17: astore 7
    //   19: aload 7
    //   21: iconst_0
    //   22: iload_2
    //   23: bipush 8
    //   25: ishr
    //   26: i2b
    //   27: bastore
    //   28: aload 7
    //   30: iconst_1
    //   31: iload_2
    //   32: i2b
    //   33: bastore
    //   34: aload_0
    //   35: iload_1
    //   36: aload 7
    //   38: iconst_2
    //   39: iload_2
    //   40: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   43: new 241	java/io/ByteArrayInputStream
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 244	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore_0
    //   53: new 239	java/io/DataInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 247	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 555	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 556	java/io/DataInputStream:close	()V
    //   80: aload 4
    //   82: astore_3
    //   83: aload_0
    //   84: ifnull +10 -> 94
    //   87: aload_0
    //   88: invokevirtual 557	java/io/ByteArrayInputStream:close	()V
    //   91: aload 4
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 5
    //   100: aload_3
    //   101: astore_0
    //   102: aload 5
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 556	java/io/DataInputStream:close	()V
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: ifnull -23 -> 94
    //   120: aload_0
    //   121: invokevirtual 557	java/io/ByteArrayInputStream:close	()V
    //   124: ldc 92
    //   126: areturn
    //   127: astore_0
    //   128: ldc 92
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aload 6
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 556	java/io/DataInputStream:close	()V
    //   145: aload 4
    //   147: astore_3
    //   148: aload_0
    //   149: ifnull -55 -> 94
    //   152: aload_0
    //   153: invokevirtual 557	java/io/ByteArrayInputStream:close	()V
    //   156: ldc 92
    //   158: areturn
    //   159: astore_0
    //   160: ldc 92
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload 5
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 556	java/io/DataInputStream:close	()V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 557	java/io/ByteArrayInputStream:close	()V
    //   188: aload_3
    //   189: athrow
    //   190: astore_3
    //   191: goto -111 -> 80
    //   194: astore_0
    //   195: aload 4
    //   197: areturn
    //   198: astore_3
    //   199: goto -86 -> 113
    //   202: astore_3
    //   203: goto -58 -> 145
    //   206: astore 4
    //   208: goto -28 -> 180
    //   211: astore_0
    //   212: goto -24 -> 188
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: goto -50 -> 170
    //   223: astore 5
    //   225: aload_3
    //   226: astore 4
    //   228: aload 5
    //   230: astore_3
    //   231: goto -61 -> 170
    //   234: astore_3
    //   235: aload 6
    //   237: astore_3
    //   238: goto -101 -> 137
    //   241: astore 5
    //   243: goto -106 -> 137
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_3
    //   249: goto -144 -> 105
    //   252: astore 5
    //   254: goto -149 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramArrayOfByte	byte[]
    //   0	257	1	paramInt1	int
    //   0	257	2	paramInt2	int
    //   7	141	3	localObject1	Object
    //   163	26	3	localObject2	Object
    //   190	1	3	localIOException1	IOException
    //   198	1	3	localIOException2	IOException
    //   202	1	3	localIOException3	IOException
    //   215	11	3	localObject3	Object
    //   230	1	3	localObject4	Object
    //   234	1	3	localException1	Exception
    //   237	1	3	localObject5	Object
    //   246	1	3	localIOException4	IOException
    //   248	1	3	localObject6	Object
    //   10	186	4	str1	String
    //   206	1	4	localIOException5	IOException
    //   218	9	4	localObject7	Object
    //   4	213	5	str2	String
    //   223	6	5	localObject8	Object
    //   241	1	5	localException2	Exception
    //   252	1	5	localIOException6	IOException
    //   1	235	6	localObject9	Object
    //   17	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	19	96	java/io/IOException
    //   34	53	96	java/io/IOException
    //   120	124	127	java/io/IOException
    //   12	19	131	java/lang/Exception
    //   34	53	131	java/lang/Exception
    //   152	156	159	java/io/IOException
    //   12	19	163	finally
    //   34	53	163	finally
    //   76	80	190	java/io/IOException
    //   87	91	194	java/io/IOException
    //   109	113	198	java/io/IOException
    //   141	145	202	java/io/IOException
    //   175	180	206	java/io/IOException
    //   184	188	211	java/io/IOException
    //   53	62	215	finally
    //   62	68	223	finally
    //   53	62	234	java/lang/Exception
    //   62	68	241	java/lang/Exception
    //   53	62	246	java/io/IOException
    //   62	68	252	java/io/IOException
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
  
  public static void writeUCS2(String paramString, OutputStream paramOutputStream)
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramString = Unicode2Byte(paramString);
    paramOutputStream.writeShort(paramString.length);
    paramOutputStream.write(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.PkgTools
 * JD-Core Version:    0.7.0.1
 */