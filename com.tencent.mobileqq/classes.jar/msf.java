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
    int j = bbfj.a(paramContext);
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
    //   47: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   97: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   147: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   198: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   248: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   298: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: ldc 118
    //   304: ldc 120
    //   306: aconst_null
    //   307: aconst_null
    //   308: invokestatic 123	bbnh:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
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
    //   343: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   4: ldc 166
    //   6: iconst_1
    //   7: ldc 168
    //   9: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: ldc 88
    //   17: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 94	android/telephony/TelephonyManager
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +215 -> 240
    //   28: aload_3
    //   29: invokevirtual 177	android/telephony/TelephonyManager:getCallState	()I
    //   32: ifeq +38 -> 70
    //   35: iconst_1
    //   36: istore_2
    //   37: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +28 -> 68
    //   43: ldc 166
    //   45: iconst_2
    //   46: new 182	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   53: ldc 186
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_2
    //   59: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iload_2
    //   69: ireturn
    //   70: getstatic 21	msf:a	Ljava/lang/Boolean;
    //   73: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   76: ifeq +69 -> 145
    //   79: aload_3
    //   80: ldc 204
    //   82: iconst_1
    //   83: anewarray 67	java/lang/Class
    //   86: dup
    //   87: iconst_0
    //   88: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: iconst_0
    //   99: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 100	java/lang/Integer
    //   109: invokevirtual 207	java/lang/Integer:intValue	()I
    //   112: istore_1
    //   113: iload_1
    //   114: ifeq +31 -> 145
    //   117: iconst_1
    //   118: istore_2
    //   119: goto -82 -> 37
    //   122: astore 4
    //   124: iconst_0
    //   125: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: putstatic 21	msf:a	Ljava/lang/Boolean;
    //   131: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +11 -> 145
    //   137: ldc 166
    //   139: iconst_2
    //   140: ldc 209
    //   142: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: getstatic 23	msf:b	Ljava/lang/Boolean;
    //   148: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   151: ifeq +89 -> 240
    //   154: aload_3
    //   155: ldc 204
    //   157: iconst_1
    //   158: anewarray 67	java/lang/Class
    //   161: dup
    //   162: iconst_0
    //   163: getstatic 104	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   166: aastore
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: iconst_1
    //   174: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: invokestatic 112	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 100	java/lang/Integer
    //   184: invokevirtual 207	java/lang/Integer:intValue	()I
    //   187: istore_1
    //   188: iload_1
    //   189: ifeq +51 -> 240
    //   192: iconst_1
    //   193: istore_2
    //   194: goto -157 -> 37
    //   197: astore 4
    //   199: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -57 -> 145
    //   205: ldc 166
    //   207: iconst_2
    //   208: ldc 211
    //   210: aload 4
    //   212: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -70 -> 145
    //   218: astore_3
    //   219: iconst_0
    //   220: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   223: putstatic 23	msf:b	Ljava/lang/Boolean;
    //   226: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +11 -> 240
    //   232: ldc 166
    //   234: iconst_2
    //   235: ldc 216
    //   237: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: ldc 116
    //   243: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   246: checkcast 94	android/telephony/TelephonyManager
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull +187 -> 438
    //   254: aload_0
    //   255: invokevirtual 177	android/telephony/TelephonyManager:getCallState	()I
    //   258: ifeq +33 -> 291
    //   261: iconst_1
    //   262: istore_2
    //   263: goto -226 -> 37
    //   266: astore_3
    //   267: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -30 -> 240
    //   273: ldc 166
    //   275: iconst_2
    //   276: ldc 218
    //   278: aload_3
    //   279: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -42 -> 240
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_0
    //   288: goto -38 -> 250
    //   291: getstatic 25	msf:c	Ljava/lang/Boolean;
    //   294: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   297: ifeq +58 -> 355
    //   300: aload_0
    //   301: ldc 204
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: iconst_0
    //   310: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic 221	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: checkcast 100	java/lang/Integer
    //   320: invokevirtual 207	java/lang/Integer:intValue	()I
    //   323: istore_1
    //   324: iload_1
    //   325: ifeq +30 -> 355
    //   328: iconst_1
    //   329: istore_2
    //   330: goto -293 -> 37
    //   333: astore_3
    //   334: iconst_0
    //   335: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   338: putstatic 25	msf:c	Ljava/lang/Boolean;
    //   341: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +11 -> 355
    //   347: ldc 166
    //   349: iconst_2
    //   350: ldc 223
    //   352: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: getstatic 27	msf:d	Ljava/lang/Boolean;
    //   358: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   361: ifeq +77 -> 438
    //   364: aload_0
    //   365: ldc 204
    //   367: iconst_1
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: iconst_1
    //   374: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: invokestatic 221	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   381: checkcast 100	java/lang/Integer
    //   384: invokevirtual 207	java/lang/Integer:intValue	()I
    //   387: istore_1
    //   388: iload_1
    //   389: ifeq +49 -> 438
    //   392: iconst_1
    //   393: istore_2
    //   394: goto -357 -> 37
    //   397: astore_3
    //   398: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq -46 -> 355
    //   404: ldc 166
    //   406: iconst_2
    //   407: ldc 225
    //   409: aload_3
    //   410: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -58 -> 355
    //   416: astore_0
    //   417: iconst_0
    //   418: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: putstatic 27	msf:d	Ljava/lang/Boolean;
    //   424: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq +11 -> 438
    //   430: ldc 166
    //   432: iconst_2
    //   433: ldc 227
    //   435: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: getstatic 29	msf:e	Ljava/lang/Boolean;
    //   441: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   444: ifeq +85 -> 529
    //   447: ldc 118
    //   449: ldc 120
    //   451: aconst_null
    //   452: aconst_null
    //   453: invokestatic 123	bbnh:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   456: ldc 228
    //   458: iconst_1
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: iconst_0
    //   465: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: invokestatic 221	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   472: checkcast 100	java/lang/Integer
    //   475: invokevirtual 207	java/lang/Integer:intValue	()I
    //   478: istore_1
    //   479: iload_1
    //   480: ifeq +49 -> 529
    //   483: iconst_1
    //   484: istore_2
    //   485: goto -448 -> 37
    //   488: astore_0
    //   489: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -54 -> 438
    //   495: ldc 166
    //   497: iconst_2
    //   498: ldc 230
    //   500: aload_0
    //   501: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: goto -66 -> 438
    //   507: astore_0
    //   508: iconst_0
    //   509: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   512: putstatic 29	msf:e	Ljava/lang/Boolean;
    //   515: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +11 -> 529
    //   521: ldc 166
    //   523: iconst_2
    //   524: ldc 232
    //   526: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: getstatic 31	msf:f	Ljava/lang/Boolean;
    //   532: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   535: ifeq +86 -> 621
    //   538: ldc 118
    //   540: ldc 120
    //   542: aconst_null
    //   543: aconst_null
    //   544: invokestatic 123	bbnh:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   547: ldc 228
    //   549: iconst_1
    //   550: anewarray 4	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: iconst_1
    //   556: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: aastore
    //   560: invokestatic 221	bbnh:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   563: checkcast 100	java/lang/Integer
    //   566: invokevirtual 207	java/lang/Integer:intValue	()I
    //   569: istore_1
    //   570: iload_1
    //   571: ifeq +8 -> 579
    //   574: iconst_1
    //   575: istore_2
    //   576: goto -539 -> 37
    //   579: iconst_0
    //   580: istore_2
    //   581: goto -544 -> 37
    //   584: astore_0
    //   585: iconst_0
    //   586: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   589: putstatic 31	msf:f	Ljava/lang/Boolean;
    //   592: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +11 -> 606
    //   598: ldc 166
    //   600: iconst_2
    //   601: ldc 234
    //   603: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iconst_0
    //   607: istore_2
    //   608: goto -571 -> 37
    //   611: astore_0
    //   612: iconst_0
    //   613: istore_2
    //   614: goto -577 -> 37
    //   617: astore_0
    //   618: goto -89 -> 529
    //   621: iconst_0
    //   622: istore_2
    //   623: goto -586 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	paramContext	Context
    //   112	459	1	i	int
    //   36	587	2	bool	boolean
    //   23	132	3	localTelephonyManager	TelephonyManager
    //   218	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   266	13	3	localException1	Exception
    //   333	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   397	13	3	localException2	Exception
    //   122	1	4	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   197	14	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   79	113	122	java/lang/NoSuchMethodException
    //   79	113	197	java/lang/Exception
    //   154	188	218	java/lang/NoSuchMethodException
    //   154	188	266	java/lang/Exception
    //   240	250	285	java/lang/Exception
    //   300	324	333	java/lang/NoSuchMethodException
    //   300	324	397	java/lang/Exception
    //   364	388	416	java/lang/NoSuchMethodException
    //   364	388	488	java/lang/Exception
    //   447	479	507	java/lang/NoSuchMethodException
    //   538	570	584	java/lang/NoSuchMethodException
    //   538	570	611	java/lang/Exception
    //   447	479	617	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msf
 * JD-Core Version:    0.7.0.1
 */