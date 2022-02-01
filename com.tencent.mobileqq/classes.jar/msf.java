import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class msf
{
  static Boolean a = Boolean.valueOf(true);
  static Boolean b = Boolean.valueOf(true);
  static Boolean c = Boolean.valueOf(true);
  static Boolean d = Boolean.valueOf(true);
  static Boolean e = Boolean.valueOf(true);
  static Boolean f = Boolean.valueOf(true);
  
  public static int a(Context paramContext)
  {
    int i = 1;
    int j = bgnt.a(paramContext);
    if (j == 1) {
      i = 0;
    }
    while (j == 4) {
      return i;
    }
    if (j == 3) {
      return 2;
    }
    if (j == 2) {
      return 3;
    }
    return -1;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 88
    //   3: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 94	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +140 -> 151
    //   14: aload_3
    //   15: ldc 96
    //   17: iconst_2
    //   18: anewarray 67	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 98
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   31: aastore
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload_2
    //   43: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: ldc 114
    //   54: iconst_3
    //   55: anewarray 67	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 98
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_3
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload_2
    //   93: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 114
    //   104: iconst_3
    //   105: anewarray 67	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 98
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: ldc 116
    //   154: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: checkcast 94	android/telephony/TelephonyManager
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +140 -> 302
    //   165: aload_0
    //   166: ldc 96
    //   168: iconst_2
    //   169: anewarray 67	java/lang/Class
    //   172: dup
    //   173: iconst_0
    //   174: ldc 98
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   182: aastore
    //   183: iconst_2
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_2
    //   194: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: ldc 114
    //   205: iconst_3
    //   206: anewarray 67	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: ldc 98
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: iconst_0
    //   233: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_1
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: iload_2
    //   244: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_0
    //   253: ldc 114
    //   255: iconst_3
    //   256: anewarray 67	java/lang/Class
    //   259: dup
    //   260: iconst_0
    //   261: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 98
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: iconst_1
    //   283: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_1
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload_2
    //   294: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: ldc 118
    //   304: ldc 120
    //   306: aconst_null
    //   307: aconst_null
    //   308: invokestatic 123	bgvk:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   311: ldc 96
    //   313: iconst_2
    //   314: anewarray 67	java/lang/Class
    //   317: dup
    //   318: iconst_0
    //   319: ldc 98
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   327: aastore
    //   328: iconst_2
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload_1
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: iload_2
    //   339: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: return
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -190 -> 161
    //   354: astore_0
    //   355: return
    //   356: astore_0
    //   357: return
    //   358: astore_0
    //   359: goto -57 -> 302
    //   362: astore_3
    //   363: goto -212 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramContext	Context
    //   0	366	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	366	2	paramInt	int
    //   9	93	3	localTelephonyManager	TelephonyManager
    //   362	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   151	161	348	java/lang/Exception
    //   0	10	354	java/lang/Exception
    //   302	347	356	java/lang/Exception
    //   165	302	358	java/lang/Exception
    //   14	151	362	java/lang/Exception
  }
  
  public static boolean a()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("SM-T230"));
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    if ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
      if (!"SM-T805C".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (!"SM-T800".equalsIgnoreCase(str)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
  }
  
  public static boolean c()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.equalsIgnoreCase("ZTE")) && (str2.equalsIgnoreCase("ZTE U950"));
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  /* Error */
  public static boolean d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: ldc 168
    //   6: iconst_1
    //   7: ldc 170
    //   9: invokestatic 176	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: ldc 88
    //   17: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 94	android/telephony/TelephonyManager
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +224 -> 249
    //   28: aload_3
    //   29: invokevirtual 179	android/telephony/TelephonyManager:getCallState	()I
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +45 -> 79
    //   37: iconst_1
    //   38: istore_2
    //   39: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +28 -> 70
    //   45: ldc 168
    //   47: iconst_2
    //   48: new 184	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   55: ldc 188
    //   57: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_2
    //   61: invokevirtual 195	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iload_2
    //   71: ireturn
    //   72: astore 4
    //   74: iconst_0
    //   75: istore_1
    //   76: goto -43 -> 33
    //   79: getstatic 21	msf:a	Ljava/lang/Boolean;
    //   82: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   85: ifeq +69 -> 154
    //   88: aload_3
    //   89: ldc 206
    //   91: iconst_1
    //   92: anewarray 67	java/lang/Class
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   100: aastore
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iconst_0
    //   108: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 100	java/lang/Integer
    //   118: invokevirtual 209	java/lang/Integer:intValue	()I
    //   121: istore_1
    //   122: iload_1
    //   123: ifeq +31 -> 154
    //   126: iconst_1
    //   127: istore_2
    //   128: goto -89 -> 39
    //   131: astore 4
    //   133: iconst_0
    //   134: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: putstatic 21	msf:a	Ljava/lang/Boolean;
    //   140: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +11 -> 154
    //   146: ldc 168
    //   148: iconst_2
    //   149: ldc 211
    //   151: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: getstatic 23	msf:b	Ljava/lang/Boolean;
    //   157: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   160: ifeq +89 -> 249
    //   163: aload_3
    //   164: ldc 206
    //   166: iconst_1
    //   167: anewarray 67	java/lang/Class
    //   170: dup
    //   171: iconst_0
    //   172: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   175: aastore
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iconst_1
    //   183: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 112	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   190: checkcast 100	java/lang/Integer
    //   193: invokevirtual 209	java/lang/Integer:intValue	()I
    //   196: istore_1
    //   197: iload_1
    //   198: ifeq +51 -> 249
    //   201: iconst_1
    //   202: istore_2
    //   203: goto -164 -> 39
    //   206: astore 4
    //   208: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -57 -> 154
    //   214: ldc 168
    //   216: iconst_2
    //   217: ldc 213
    //   219: aload 4
    //   221: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -70 -> 154
    //   227: astore_3
    //   228: iconst_0
    //   229: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   232: putstatic 23	msf:b	Ljava/lang/Boolean;
    //   235: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +11 -> 249
    //   241: ldc 168
    //   243: iconst_2
    //   244: ldc 218
    //   246: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: ldc 116
    //   252: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   255: checkcast 94	android/telephony/TelephonyManager
    //   258: astore_0
    //   259: aload_0
    //   260: ifnull +195 -> 455
    //   263: aload_0
    //   264: invokevirtual 179	android/telephony/TelephonyManager:getCallState	()I
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +39 -> 308
    //   272: iconst_1
    //   273: istore_2
    //   274: goto -235 -> 39
    //   277: astore_3
    //   278: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq -32 -> 249
    //   284: ldc 168
    //   286: iconst_2
    //   287: ldc 220
    //   289: aload_3
    //   290: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -44 -> 249
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_0
    //   299: goto -40 -> 259
    //   302: astore_3
    //   303: iconst_0
    //   304: istore_1
    //   305: goto -37 -> 268
    //   308: getstatic 25	msf:c	Ljava/lang/Boolean;
    //   311: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   314: ifeq +58 -> 372
    //   317: aload_0
    //   318: ldc 206
    //   320: iconst_1
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: iconst_0
    //   327: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: invokestatic 223	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   334: checkcast 100	java/lang/Integer
    //   337: invokevirtual 209	java/lang/Integer:intValue	()I
    //   340: istore_1
    //   341: iload_1
    //   342: ifeq +30 -> 372
    //   345: iconst_1
    //   346: istore_2
    //   347: goto -308 -> 39
    //   350: astore_3
    //   351: iconst_0
    //   352: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   355: putstatic 25	msf:c	Ljava/lang/Boolean;
    //   358: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +11 -> 372
    //   364: ldc 168
    //   366: iconst_2
    //   367: ldc 225
    //   369: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: getstatic 27	msf:d	Ljava/lang/Boolean;
    //   375: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   378: ifeq +77 -> 455
    //   381: aload_0
    //   382: ldc 206
    //   384: iconst_1
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: iconst_1
    //   391: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: invokestatic 223	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 100	java/lang/Integer
    //   401: invokevirtual 209	java/lang/Integer:intValue	()I
    //   404: istore_1
    //   405: iload_1
    //   406: ifeq +49 -> 455
    //   409: iconst_1
    //   410: istore_2
    //   411: goto -372 -> 39
    //   414: astore_3
    //   415: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq -46 -> 372
    //   421: ldc 168
    //   423: iconst_2
    //   424: ldc 227
    //   426: aload_3
    //   427: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -58 -> 372
    //   433: astore_0
    //   434: iconst_0
    //   435: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   438: putstatic 27	msf:d	Ljava/lang/Boolean;
    //   441: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq +11 -> 455
    //   447: ldc 168
    //   449: iconst_2
    //   450: ldc 229
    //   452: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: getstatic 29	msf:e	Ljava/lang/Boolean;
    //   458: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   461: ifeq +85 -> 546
    //   464: ldc 118
    //   466: ldc 120
    //   468: aconst_null
    //   469: aconst_null
    //   470: invokestatic 123	bgvk:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   473: ldc 230
    //   475: iconst_1
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: iconst_0
    //   482: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: invokestatic 223	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   489: checkcast 100	java/lang/Integer
    //   492: invokevirtual 209	java/lang/Integer:intValue	()I
    //   495: istore_1
    //   496: iload_1
    //   497: ifeq +49 -> 546
    //   500: iconst_1
    //   501: istore_2
    //   502: goto -463 -> 39
    //   505: astore_0
    //   506: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -54 -> 455
    //   512: ldc 168
    //   514: iconst_2
    //   515: ldc 232
    //   517: aload_0
    //   518: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: goto -66 -> 455
    //   524: astore_0
    //   525: iconst_0
    //   526: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   529: putstatic 29	msf:e	Ljava/lang/Boolean;
    //   532: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +11 -> 546
    //   538: ldc 168
    //   540: iconst_2
    //   541: ldc 234
    //   543: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: getstatic 31	msf:f	Ljava/lang/Boolean;
    //   549: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   552: ifeq +86 -> 638
    //   555: ldc 118
    //   557: ldc 120
    //   559: aconst_null
    //   560: aconst_null
    //   561: invokestatic 123	bgvk:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   564: ldc 230
    //   566: iconst_1
    //   567: anewarray 4	java/lang/Object
    //   570: dup
    //   571: iconst_0
    //   572: iconst_1
    //   573: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: aastore
    //   577: invokestatic 223	bgvk:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   580: checkcast 100	java/lang/Integer
    //   583: invokevirtual 209	java/lang/Integer:intValue	()I
    //   586: istore_1
    //   587: iload_1
    //   588: ifeq +8 -> 596
    //   591: iconst_1
    //   592: istore_2
    //   593: goto -554 -> 39
    //   596: iconst_0
    //   597: istore_2
    //   598: goto -559 -> 39
    //   601: astore_0
    //   602: iconst_0
    //   603: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   606: putstatic 31	msf:f	Ljava/lang/Boolean;
    //   609: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +11 -> 623
    //   615: ldc 168
    //   617: iconst_2
    //   618: ldc 236
    //   620: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: iconst_0
    //   624: istore_2
    //   625: goto -586 -> 39
    //   628: astore_0
    //   629: iconst_0
    //   630: istore_2
    //   631: goto -592 -> 39
    //   634: astore_0
    //   635: goto -89 -> 546
    //   638: iconst_0
    //   639: istore_2
    //   640: goto -601 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	paramContext	Context
    //   32	556	1	i	int
    //   38	602	2	bool	boolean
    //   23	141	3	localTelephonyManager	TelephonyManager
    //   227	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   277	13	3	localException1	Exception
    //   302	1	3	localThrowable1	Throwable
    //   350	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   414	13	3	localException2	Exception
    //   72	1	4	localThrowable2	Throwable
    //   131	1	4	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   206	14	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   28	33	72	java/lang/Throwable
    //   88	122	131	java/lang/NoSuchMethodException
    //   88	122	206	java/lang/Exception
    //   163	197	227	java/lang/NoSuchMethodException
    //   163	197	277	java/lang/Exception
    //   249	259	296	java/lang/Exception
    //   263	268	302	java/lang/Throwable
    //   317	341	350	java/lang/NoSuchMethodException
    //   317	341	414	java/lang/Exception
    //   381	405	433	java/lang/NoSuchMethodException
    //   381	405	505	java/lang/Exception
    //   464	496	524	java/lang/NoSuchMethodException
    //   555	587	601	java/lang/NoSuchMethodException
    //   555	587	628	java/lang/Exception
    //   464	496	634	java/lang/Exception
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool3 = true;
    boolean bool1;
    if (a()) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool3;
      if (b()) {
        continue;
      }
      bool1 = bool3;
      if (a(paramContext, "ro.qq.istablet").equalsIgnoreCase("true")) {
        continue;
      }
      bool1 = bool3;
      if (a(paramContext, "ro.lenovo.device").equalsIgnoreCase("tablet")) {
        continue;
      }
      try
      {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d1 = Math.pow(f1, 2.0D);
        d1 = Math.sqrt(Math.pow(f2, 2.0D) + d1);
        try
        {
          int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
          if (i != 0) {
            break label218;
          }
          bool2 = false;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            boolean bool2 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 2, "device size : " + d1 + ", hasTelephone : " + bool2);
        }
        if (d1 > 6.5D)
        {
          bool1 = bool3;
          if (!bool2) {
            continue;
          }
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          double d1 = 0.0D;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf
 * JD-Core Version:    0.7.0.1
 */