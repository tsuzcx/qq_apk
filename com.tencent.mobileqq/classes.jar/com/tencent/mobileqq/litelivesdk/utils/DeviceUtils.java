package com.tencent.mobileqq.litelivesdk.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class DeviceUtils
{
  static int jdField_a_of_type_Int = 0;
  static String jdField_a_of_type_JavaLangString = null;
  public static String b = null;
  private static String c = null;
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {}
    try
    {
      jdField_a_of_type_Int = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(BaseApplicationImpl.getContext().getPackageName(), 0).versionCode;
      label28:
      return jdField_a_of_type_Int;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label28;
    }
  }
  
  public static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {}
    try
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(BaseApplicationImpl.getContext().getPackageName(), 0).versionName;
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_JavaLangString = "unknown";
      }
    }
  }
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/mobileqq/litelivesdk/utils/DeviceUtils:c	Ljava/lang/String;
    //   3: ifnonnull +218 -> 221
    //   6: new 63	com/tencent/mobileqq/litelivesdk/utils/SharePreferenceUtil
    //   9: dup
    //   10: aload_0
    //   11: ldc 65
    //   13: invokespecial 68	com/tencent/mobileqq/litelivesdk/utils/SharePreferenceUtil:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   16: astore 5
    //   18: aload 5
    //   20: invokevirtual 71	com/tencent/mobileqq/litelivesdk/utils/SharePreferenceUtil:a	()Landroid/content/SharedPreferences;
    //   23: ldc 73
    //   25: ldc 75
    //   27: invokeinterface 81 3 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +9 -> 46
    //   40: aload_1
    //   41: putstatic 19	com/tencent/mobileqq/litelivesdk/utils/DeviceUtils:c	Ljava/lang/String;
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: ldc 89
    //   49: invokevirtual 95	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 97	android/telephony/TelephonyManager
    //   55: astore 4
    //   57: ldc 75
    //   59: astore_1
    //   60: ldc 75
    //   62: astore_2
    //   63: new 99	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   70: ldc 75
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokestatic 108	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_3
    //   85: aload_3
    //   86: astore_1
    //   87: new 99	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   94: ldc 75
    //   96: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 4
    //   101: invokevirtual 114	android/telephony/TelephonyManager:getSimSerialNumber	()Ljava/lang/String;
    //   104: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 4
    //   112: aload 4
    //   114: astore_2
    //   115: aload_3
    //   116: astore_1
    //   117: new 99	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   124: ldc 75
    //   126: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: invokevirtual 118	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   133: ldc 120
    //   135: invokestatic 125	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_0
    //   145: new 127	java/util/UUID
    //   148: dup
    //   149: aload_0
    //   150: invokevirtual 132	java/lang/String:hashCode	()I
    //   153: i2l
    //   154: aload_1
    //   155: invokevirtual 132	java/lang/String:hashCode	()I
    //   158: i2l
    //   159: bipush 32
    //   161: lshl
    //   162: aload_2
    //   163: invokevirtual 132	java/lang/String:hashCode	()I
    //   166: i2l
    //   167: lor
    //   168: invokespecial 135	java/util/UUID:<init>	(JJ)V
    //   171: invokevirtual 136	java/util/UUID:toString	()Ljava/lang/String;
    //   174: ldc 138
    //   176: ldc 75
    //   178: invokevirtual 141	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: astore_0
    //   182: aload 5
    //   184: invokevirtual 71	com/tencent/mobileqq/litelivesdk/utils/SharePreferenceUtil:a	()Landroid/content/SharedPreferences;
    //   187: invokeinterface 145 1 0
    //   192: ldc 73
    //   194: aload_0
    //   195: invokeinterface 151 3 0
    //   200: pop
    //   201: aload 5
    //   203: invokevirtual 71	com/tencent/mobileqq/litelivesdk/utils/SharePreferenceUtil:a	()Landroid/content/SharedPreferences;
    //   206: invokeinterface 145 1 0
    //   211: invokeinterface 155 1 0
    //   216: pop
    //   217: aload_0
    //   218: putstatic 19	com/tencent/mobileqq/litelivesdk/utils/DeviceUtils:c	Ljava/lang/String;
    //   221: getstatic 19	com/tencent/mobileqq/litelivesdk/utils/DeviceUtils:c	Ljava/lang/String;
    //   224: areturn
    //   225: astore_3
    //   226: aload_3
    //   227: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   230: goto -113 -> 117
    //   233: astore_0
    //   234: aload_1
    //   235: astore_0
    //   236: goto -91 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	android.content.Context
    //   32	203	1	localObject1	Object
    //   62	101	2	localObject2	Object
    //   84	32	3	str	String
    //   225	2	3	localException	Exception
    //   55	58	4	localObject3	Object
    //   16	186	5	localSharePreferenceUtil	SharePreferenceUtil
    // Exception table:
    //   from	to	target	type
    //   63	85	225	java/lang/Exception
    //   87	112	225	java/lang/Exception
    //   117	145	233	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */