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
    if (paramIOException.contains("EACCES")) {
      return 9039;
    }
    if (paramIOException.contains("ENOSPC")) {
      return 9040;
    }
    if (paramIOException.contains("Read-only")) {
      return 9039;
    }
    if (!"mounted".equals(str)) {
      return 9039;
    }
    return 9303;
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        int k = i * 2;
        char[] arrayOfChar2 = digits;
        arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
        arrayOfChar1[(k + 0)] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return "";
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
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  /* Error */
  public static String getApnType(Context paramContext)
  {
    // Byte code:
    //   0: ldc 164
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: invokevirtual 170	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 56	com/tencent/mobileqq/highway/utils/BdhUtils:PREFERRED_APN_URI	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 176	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +16 -> 40
    //   27: aload_3
    //   28: ifnull +9 -> 37
    //   31: aload_3
    //   32: invokeinterface 181 1 0
    //   37: ldc 164
    //   39: areturn
    //   40: aload_3
    //   41: astore 4
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: invokeinterface 185 1 0
    //   51: pop
    //   52: aload_3
    //   53: astore 4
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: aload_3
    //   59: ldc 187
    //   61: invokeinterface 191 2 0
    //   66: invokeinterface 195 2 0
    //   71: invokevirtual 198	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   74: astore 5
    //   76: aload_3
    //   77: astore 4
    //   79: aload_3
    //   80: astore_2
    //   81: aload 5
    //   83: getstatic 60	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTNET	Ljava/lang/String;
    //   86: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   89: ifeq +15 -> 104
    //   92: aload_3
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: getstatic 60	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTNET	Ljava/lang/String;
    //   100: astore_0
    //   101: goto +196 -> 297
    //   104: aload_3
    //   105: astore 4
    //   107: aload_3
    //   108: astore_2
    //   109: aload 5
    //   111: getstatic 64	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTWAP	Ljava/lang/String;
    //   114: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   117: ifeq +15 -> 132
    //   120: aload_3
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: getstatic 64	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CTWAP	Ljava/lang/String;
    //   128: astore_0
    //   129: goto +168 -> 297
    //   132: aload_3
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: aload 5
    //   139: getstatic 68	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMNET	Ljava/lang/String;
    //   142: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   145: ifeq +15 -> 160
    //   148: aload_3
    //   149: astore 4
    //   151: aload_3
    //   152: astore_2
    //   153: getstatic 68	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMNET	Ljava/lang/String;
    //   156: astore_0
    //   157: goto +140 -> 297
    //   160: aload_3
    //   161: astore 4
    //   163: aload_3
    //   164: astore_2
    //   165: aload 5
    //   167: getstatic 72	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMWAP	Ljava/lang/String;
    //   170: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   173: ifeq +15 -> 188
    //   176: aload_3
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: getstatic 72	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_CMWAP	Ljava/lang/String;
    //   184: astore_0
    //   185: goto +112 -> 297
    //   188: aload_3
    //   189: astore 4
    //   191: aload_3
    //   192: astore_2
    //   193: aload 5
    //   195: getstatic 76	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNINET	Ljava/lang/String;
    //   198: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   201: ifeq +15 -> 216
    //   204: aload_3
    //   205: astore 4
    //   207: aload_3
    //   208: astore_2
    //   209: getstatic 76	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNINET	Ljava/lang/String;
    //   212: astore_0
    //   213: goto +84 -> 297
    //   216: aload_1
    //   217: astore_0
    //   218: aload_3
    //   219: astore 4
    //   221: aload_3
    //   222: astore_2
    //   223: aload 5
    //   225: getstatic 80	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   228: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   231: ifeq +15 -> 246
    //   234: aload_3
    //   235: astore 4
    //   237: aload_3
    //   238: astore_2
    //   239: getstatic 80	com/tencent/mobileqq/highway/utils/BdhUtils:APN_TYPE_UNIWAP	Ljava/lang/String;
    //   242: astore_0
    //   243: goto +54 -> 297
    //   246: aload_0
    //   247: astore 4
    //   249: aload_3
    //   250: ifnull +40 -> 290
    //   253: aload_3
    //   254: astore_2
    //   255: aload_2
    //   256: invokeinterface 181 1 0
    //   261: aload_0
    //   262: areturn
    //   263: astore_0
    //   264: aload 4
    //   266: ifnull +10 -> 276
    //   269: aload 4
    //   271: invokeinterface 181 1 0
    //   276: aload_0
    //   277: athrow
    //   278: aload_1
    //   279: astore 4
    //   281: aload_2
    //   282: ifnull +8 -> 290
    //   285: aload_1
    //   286: astore_0
    //   287: goto -32 -> 255
    //   290: aload 4
    //   292: areturn
    //   293: astore_0
    //   294: goto -16 -> 278
    //   297: goto -51 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramContext	Context
    //   2	284	1	str1	String
    //   4	278	2	localObject1	Object
    //   22	232	3	localCursor	android.database.Cursor
    //   6	285	4	localObject2	Object
    //   74	150	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   8	23	263	finally
    //   45	52	263	finally
    //   57	76	263	finally
    //   81	92	263	finally
    //   97	101	263	finally
    //   109	120	263	finally
    //   125	129	263	finally
    //   137	148	263	finally
    //   153	157	263	finally
    //   165	176	263	finally
    //   181	185	263	finally
    //   193	204	263	finally
    //   209	213	263	finally
    //   223	234	263	finally
    //   239	243	263	finally
    //   8	23	293	java/lang/Exception
    //   45	52	293	java/lang/Exception
    //   57	76	293	java/lang/Exception
    //   81	92	293	java/lang/Exception
    //   97	101	293	java/lang/Exception
    //   109	120	293	java/lang/Exception
    //   125	129	293	java/lang/Exception
    //   137	148	293	java/lang/Exception
    //   153	157	293	java/lang/Exception
    //   165	176	293	java/lang/Exception
    //   181	185	293	java/lang/Exception
    //   193	204	293	java/lang/Exception
    //   209	213	293	java/lang/Exception
    //   223	234	293	java/lang/Exception
    //   239	243	293	java/lang/Exception
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
  
  public static HttpURLConnection getConnectionWithDefaultProxy(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString2, paramInt));
    return (HttpURLConnection)new URL(paramString1).openConnection(paramString2);
  }
  
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
  
  public static ArrayList<String> getCurNetKey(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = HwNetworkUtil.getSystemNetwork(paramContext);
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4)) {
        return localArrayList;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("APN_");
      localStringBuilder.append(HwNetworkUtil.getCurrentApn(paramContext));
      localArrayList.add(localStringBuilder.toString());
      return localArrayList;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BSSID_");
    localStringBuilder.append(HwNetworkUtil.getCurrentWifiBSSID(paramContext));
    localArrayList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SSID_");
    localStringBuilder.append(HwNetworkUtil.getCurrentWifiSSID(paramContext));
    localArrayList.add(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhUtils
 * JD-Core Version:    0.7.0.1
 */