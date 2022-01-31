package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;

public class BdhUtils
{
  public static String APN_TYPE_3GNET = "3gnet";
  public static String APN_TYPE_3GWAP = "3gwap";
  public static String APN_TYPE_CMNET;
  public static String APN_TYPE_CMWAP;
  public static String APN_TYPE_CTNET;
  public static String APN_TYPE_CTWAP;
  public static String APN_TYPE_UNINET;
  public static String APN_TYPE_UNIWAP;
  private static final String KEY_PRE_APN = "APN_";
  private static final String KEY_PRE_BSSID = "BSSID_";
  private static final String KEY_PRE_SSID = "SSID_";
  private static Uri PREFERRED_APN_URI;
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  static
  {
    PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
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
  
  public static int analysisIOProblem(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {}
    do
    {
      return 9039;
      if (paramIOException.contains("ENOSPC")) {
        return 9040;
      }
    } while ((paramIOException.contains("Read-only")) || (!"mounted".equals(str)));
    return 9303;
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
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
  public static String getApnType(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 168	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 56	com/tencent/mobileqq/highway/utils/BdhUtils:PREFERRED_APN_URI	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 174	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +16 -> 32
    //   19: aload_1
    //   20: ifnull +9 -> 29
    //   23: aload_1
    //   24: invokeinterface 179 1 0
    //   29: ldc 181
    //   31: areturn
    //   32: aload_1
    //   33: invokeinterface 185 1 0
    //   38: pop
    //   39: aload_1
    //   40: aload_1
    //   41: ldc 187
    //   43: invokeinterface 191 2 0
    //   48: invokeinterface 195 2 0
    //   53: invokevirtual 198	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: getstatic 60	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTNET	Ljava/lang/String;
    //   61: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +23 -> 87
    //   67: getstatic 60	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTNET	Ljava/lang/String;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aload_1
    //   74: ifnull +11 -> 85
    //   77: aload_1
    //   78: invokeinterface 179 1 0
    //   83: aload_0
    //   84: astore_2
    //   85: aload_2
    //   86: areturn
    //   87: aload_0
    //   88: getstatic 64	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTWAP	Ljava/lang/String;
    //   91: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   94: ifeq +10 -> 104
    //   97: getstatic 64	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTWAP	Ljava/lang/String;
    //   100: astore_0
    //   101: goto -30 -> 71
    //   104: aload_0
    //   105: getstatic 68	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMNET	Ljava/lang/String;
    //   108: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   111: ifeq +10 -> 121
    //   114: getstatic 68	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMNET	Ljava/lang/String;
    //   117: astore_0
    //   118: goto -47 -> 71
    //   121: aload_0
    //   122: getstatic 72	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMWAP	Ljava/lang/String;
    //   125: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   128: ifeq +10 -> 138
    //   131: getstatic 72	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMWAP	Ljava/lang/String;
    //   134: astore_0
    //   135: goto -64 -> 71
    //   138: aload_0
    //   139: getstatic 76	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNINET	Ljava/lang/String;
    //   142: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   145: ifeq +10 -> 155
    //   148: getstatic 76	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNINET	Ljava/lang/String;
    //   151: astore_0
    //   152: goto -81 -> 71
    //   155: aload_0
    //   156: getstatic 80	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   159: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +60 -> 222
    //   165: getstatic 80	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   168: astore_0
    //   169: goto -98 -> 71
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull +40 -> 216
    //   179: aload_0
    //   180: invokeinterface 179 1 0
    //   185: ldc 181
    //   187: astore_2
    //   188: goto -103 -> 85
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +9 -> 204
    //   198: aload_1
    //   199: invokeinterface 179 1 0
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: goto -13 -> 194
    //   210: astore_0
    //   211: aload_1
    //   212: astore_0
    //   213: goto -38 -> 175
    //   216: ldc 181
    //   218: astore_2
    //   219: goto -134 -> 85
    //   222: ldc 181
    //   224: astore_0
    //   225: goto -154 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramContext	Context
    //   14	198	1	localCursor	android.database.Cursor
    //   72	147	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	172	java/lang/Exception
    //   0	15	191	finally
    //   32	71	206	finally
    //   87	101	206	finally
    //   104	118	206	finally
    //   121	135	206	finally
    //   138	152	206	finally
    //   155	169	206	finally
    //   32	71	210	java/lang/Exception
    //   87	101	210	java/lang/Exception
    //   104	118	210	java/lang/Exception
    //   121	135	210	java/lang/Exception
    //   138	152	210	java/lang/Exception
    //   155	169	210	java/lang/Exception
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
  
  public static HttpURLConnection getConnectionWithDefaultProxy(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString2, paramInt));
    return (HttpURLConnection)new URL(paramString1).openConnection(paramString2);
  }
  
  public static HttpURLConnection getConnectionWithXOnlineHost(String paramString1, String paramString2, int paramInt)
  {
    int i = "http://".length();
    int j = paramString1.indexOf('/', i);
    Object localObject;
    if (j < 0)
    {
      paramString1 = paramString1.substring(i);
      localObject = "";
      if (paramInt == 80) {
        break label122;
      }
    }
    label122:
    for (paramString2 = new URL("http://" + paramString2 + ":" + paramInt + (String)localObject);; paramString2 = new URL("http://" + paramString2 + (String)localObject))
    {
      paramString2 = (HttpURLConnection)paramString2.openConnection();
      paramString2.setRequestProperty("X-Online-Host", paramString1);
      return paramString2;
      localObject = paramString1.substring(i, j);
      String str = paramString1.substring(j);
      paramString1 = (String)localObject;
      localObject = str;
      break;
    }
  }
  
  public static ArrayList<String> getCurNetKey(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    switch (HwNetworkUtil.getSystemNetwork(paramContext))
    {
    default: 
      return localArrayList;
    case 1: 
      localArrayList.add("BSSID_" + HwNetworkUtil.getCurrentWifiBSSID(paramContext));
      localArrayList.add("SSID_" + HwNetworkUtil.getCurrentWifiSSID(paramContext));
      return localArrayList;
    }
    localArrayList.add("APN_" + HwNetworkUtil.getCurrentApn(paramContext));
    return localArrayList;
  }
  
  public static long getLongData(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static boolean isBdhNetConnected(Context paramContext)
  {
    return HwNetworkUtil.isNetworkConnected(paramContext);
  }
  
  public static boolean isNetWorkProb(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 8) || (paramInt == 14) || (paramInt == 7) || (paramInt == 9) || (paramInt == 2) || (paramInt == 5) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhUtils
 * JD-Core Version:    0.7.0.1
 */