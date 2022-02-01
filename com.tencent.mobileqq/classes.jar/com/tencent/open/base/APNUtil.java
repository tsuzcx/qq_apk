package com.tencent.open.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class APNUtil
{
  protected static Uri a;
  protected static final String a = "com.tencent.open.base.APNUtil";
  
  static
  {
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: getstatic 21	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +15 -> 35
    //   23: aload_0
    //   24: ifnull +9 -> 33
    //   27: aload_0
    //   28: invokeinterface 45 1 0
    //   33: iconst_m1
    //   34: ireturn
    //   35: aload_0
    //   36: astore_2
    //   37: aload_0
    //   38: astore_3
    //   39: aload_0
    //   40: invokeinterface 49 1 0
    //   45: pop
    //   46: aload_0
    //   47: astore_2
    //   48: aload_0
    //   49: astore_3
    //   50: aload_0
    //   51: aload_0
    //   52: ldc 51
    //   54: invokeinterface 55 2 0
    //   59: invokeinterface 59 2 0
    //   64: istore_1
    //   65: aload_0
    //   66: ifnull +9 -> 75
    //   69: aload_0
    //   70: invokeinterface 45 1 0
    //   75: iload_1
    //   76: ireturn
    //   77: astore_0
    //   78: goto +22 -> 100
    //   81: astore_0
    //   82: aload_3
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 45 1 0
    //   98: iconst_m1
    //   99: ireturn
    //   100: aload_2
    //   101: ifnull +9 -> 110
    //   104: aload_2
    //   105: invokeinterface 45 1 0
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramContext	Context
    //   64	12	1	i	int
    //   3	102	2	localContext1	Context
    //   1	92	3	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   4	19	77	finally
    //   39	46	77	finally
    //   50	65	77	finally
    //   84	88	77	finally
    //   4	19	81	java/lang/Exception
    //   39	46	81	java/lang/Exception
    //   50	65	81	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    int i = b(paramContext);
    if (i == 2) {
      return "wifi";
    }
    if (i == 1) {
      return "cmwap";
    }
    if (i == 4) {
      return "cmnet";
    }
    if (i == 16) {
      return "uniwap";
    }
    if (i == 8) {
      return "uninet";
    }
    if (i == 64) {
      return "wap";
    }
    if (i == 32) {
      return "net";
    }
    if (i == 512) {
      return "ctwap";
    }
    if (i == 256) {
      return "ctnet";
    }
    if (i == 2048) {
      return "3gnet";
    }
    if (i == 1024) {
      return "3gwap";
    }
    paramContext = b(paramContext);
    if ((paramContext != null) && (paramContext.length() != 0)) {
      return paramContext;
    }
    return "none";
  }
  
  public static boolean a(Context paramContext)
  {
    int i = b(paramContext);
    if ((i != 1) && (i != 16) && (i != 64) && (i != 512)) {
      return i == 1024;
    }
    return true;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return 128;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 128;
      }
      if (((NetworkInfo)localObject).getTypeName().toUpperCase().equals("WIFI")) {
        return 2;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      if (((String)localObject).startsWith("cmwap")) {
        return 1;
      }
      if ((!((String)localObject).startsWith("cmnet")) && (!((String)localObject).startsWith("epc.tmobile.com")))
      {
        if (((String)localObject).startsWith("uniwap")) {
          return 16;
        }
        if (((String)localObject).startsWith("uninet")) {
          return 8;
        }
        if (((String)localObject).startsWith("wap")) {
          return 64;
        }
        if (((String)localObject).startsWith("net")) {
          return 32;
        }
        if (((String)localObject).startsWith("ctwap")) {
          return 512;
        }
        if (((String)localObject).startsWith("ctnet")) {
          return 256;
        }
        if (((String)localObject).startsWith("3gwap")) {
          return 1024;
        }
        if (((String)localObject).startsWith("3gnet")) {
          return 2048;
        }
        if (((String)localObject).startsWith("#777"))
        {
          paramContext = c(paramContext);
          if (paramContext != null)
          {
            int i = paramContext.length();
            if (i > 0) {
              return 512;
            }
          }
          return 256;
        }
      }
      else
      {
        return 4;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 128;
  }
  
  public static String b(Context paramContext)
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 21	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +15 -> 31
    //   19: aload_1
    //   20: ifnull +9 -> 29
    //   23: aload_1
    //   24: invokeinterface 45 1 0
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: invokeinterface 49 1 0
    //   39: pop
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: aload_1
    //   44: ldc 153
    //   46: invokeinterface 55 2 0
    //   51: invokeinterface 157 2 0
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 45 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: goto +12 -> 82
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: goto +30 -> 106
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokeinterface 45 1 0
    //   98: ldc 159
    //   100: areturn
    //   101: astore_2
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: astore_0
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 45 1 0
    //   116: aload_0
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   14	97	1	localObject1	Object
    //   56	12	2	str	String
    //   69	1	2	localException1	Exception
    //   79	6	2	localException2	Exception
    //   101	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	69	java/lang/Exception
    //   42	57	69	java/lang/Exception
    //   0	15	73	finally
    //   0	15	79	java/lang/Exception
    //   33	40	101	finally
    //   42	57	101	finally
    //   84	88	101	finally
  }
  
  public static boolean c(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: ldc 165
    //   2: astore_2
    //   3: aload_0
    //   4: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 21	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +15 -> 34
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 45 1 0
    //   32: aconst_null
    //   33: areturn
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokeinterface 49 1 0
    //   42: pop
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokeinterface 168 1 0
    //   51: ifeq +28 -> 79
    //   54: aload_1
    //   55: ifnull +11 -> 66
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokeinterface 45 1 0
    //   66: aload_1
    //   67: ifnull +9 -> 76
    //   70: aload_1
    //   71: invokeinterface 45 1 0
    //   76: ldc 165
    //   78: areturn
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_1
    //   83: ldc 51
    //   85: invokeinterface 55 2 0
    //   90: invokeinterface 157 2 0
    //   95: astore_3
    //   96: aload_3
    //   97: ifnonnull +8 -> 105
    //   100: aload_2
    //   101: astore_0
    //   102: goto +5 -> 107
    //   105: aload_3
    //   106: astore_0
    //   107: aload_1
    //   108: ifnull +9 -> 117
    //   111: aload_1
    //   112: invokeinterface 45 1 0
    //   117: aload_0
    //   118: areturn
    //   119: astore_2
    //   120: goto +12 -> 132
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_1
    //   126: goto +30 -> 156
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   138: aload_1
    //   139: ifnull +9 -> 148
    //   142: aload_1
    //   143: invokeinterface 45 1 0
    //   148: ldc 165
    //   150: areturn
    //   151: astore_2
    //   152: aload_0
    //   153: astore_1
    //   154: aload_2
    //   155: astore_0
    //   156: aload_1
    //   157: ifnull +9 -> 166
    //   160: aload_1
    //   161: invokeinterface 45 1 0
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   17	144	1	localObject1	Object
    //   2	99	2	str1	String
    //   119	1	2	localException1	Exception
    //   129	6	2	localException2	Exception
    //   151	4	2	localObject2	Object
    //   95	11	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   36	43	119	java/lang/Exception
    //   45	54	119	java/lang/Exception
    //   60	66	119	java/lang/Exception
    //   81	96	119	java/lang/Exception
    //   3	18	123	finally
    //   3	18	129	java/lang/Exception
    //   36	43	151	finally
    //   45	54	151	finally
    //   60	66	151	finally
    //   81	96	151	finally
    //   134	138	151	finally
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return true;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          boolean bool = paramContext[i].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "checkNetWork Exception", paramContext);
    }
  }
  
  public static String e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "MOBILE";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.getTypeName();
    }
    return "MOBILE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.APNUtil
 * JD-Core Version:    0.7.0.1
 */