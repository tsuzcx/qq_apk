import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public final class ley
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static boolean jdField_a_of_type_Boolean;
  private static Boolean b;
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 19
    //   2: fstore_0
    //   3: iconst_1
    //   4: istore 8
    //   6: getstatic 21	ley:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   9: ifnonnull +133 -> 142
    //   12: invokestatic 26	babp:b	()I
    //   15: istore 7
    //   17: invokestatic 32	mhr:d	()Ljava/lang/String;
    //   20: astore 9
    //   22: ldc 33
    //   24: fstore_2
    //   25: ldc 34
    //   27: fstore 5
    //   29: aload 9
    //   31: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +224 -> 258
    //   37: aload 9
    //   39: ldc 42
    //   41: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   44: astore 9
    //   46: aload 9
    //   48: arraylength
    //   49: iconst_4
    //   50: if_icmplt +208 -> 258
    //   53: aload 9
    //   55: iconst_0
    //   56: aaload
    //   57: invokestatic 54	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   60: fstore_1
    //   61: fload_0
    //   62: fstore_3
    //   63: aload 9
    //   65: iconst_1
    //   66: aaload
    //   67: invokestatic 54	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   70: fstore 4
    //   72: fload_0
    //   73: fstore_3
    //   74: fload 4
    //   76: fstore_2
    //   77: aload 9
    //   79: iconst_2
    //   80: aaload
    //   81: invokestatic 54	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   84: fstore_0
    //   85: fload_0
    //   86: fstore_3
    //   87: fload 4
    //   89: fstore_2
    //   90: aload 9
    //   92: iconst_3
    //   93: aaload
    //   94: invokestatic 54	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   97: fstore 6
    //   99: fload 6
    //   101: fstore_3
    //   102: fload 4
    //   104: fstore_2
    //   105: invokestatic 57	babp:d	()J
    //   108: l2f
    //   109: fconst_1
    //   110: fmul
    //   111: ldc 58
    //   113: fdiv
    //   114: fstore 4
    //   116: invokestatic 63	lbk:c	()J
    //   119: l2f
    //   120: ldc 64
    //   122: fdiv
    //   123: fstore 5
    //   125: iload 7
    //   127: iconst_4
    //   128: if_icmpge +37 -> 165
    //   131: new 66	java/lang/Boolean
    //   134: dup
    //   135: iconst_0
    //   136: invokespecial 70	java/lang/Boolean:<init>	(Z)V
    //   139: putstatic 21	ley:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   142: getstatic 21	ley:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   145: invokevirtual 73	java/lang/Boolean:booleanValue	()Z
    //   148: ireturn
    //   149: astore 9
    //   151: ldc 19
    //   153: fstore_1
    //   154: aload 9
    //   156: invokevirtual 76	java/lang/NumberFormatException:printStackTrace	()V
    //   159: fload 5
    //   161: fstore_3
    //   162: goto -57 -> 105
    //   165: iload 7
    //   167: iconst_4
    //   168: if_icmplt +48 -> 216
    //   171: iload 7
    //   173: bipush 8
    //   175: if_icmpge +41 -> 216
    //   178: fload 4
    //   180: fload_1
    //   181: fcmpl
    //   182: iflt +28 -> 210
    //   185: fload 5
    //   187: fload_2
    //   188: fcmpl
    //   189: iflt +21 -> 210
    //   192: iconst_1
    //   193: istore 8
    //   195: new 66	java/lang/Boolean
    //   198: dup
    //   199: iload 8
    //   201: invokespecial 70	java/lang/Boolean:<init>	(Z)V
    //   204: putstatic 21	ley:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   207: goto -65 -> 142
    //   210: iconst_0
    //   211: istore 8
    //   213: goto -18 -> 195
    //   216: fload 4
    //   218: fload_0
    //   219: fcmpl
    //   220: iflt +25 -> 245
    //   223: fload 5
    //   225: fload_3
    //   226: fcmpl
    //   227: iflt +18 -> 245
    //   230: new 66	java/lang/Boolean
    //   233: dup
    //   234: iload 8
    //   236: invokespecial 70	java/lang/Boolean:<init>	(Z)V
    //   239: putstatic 21	ley:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   242: goto -100 -> 142
    //   245: iconst_0
    //   246: istore 8
    //   248: goto -18 -> 230
    //   251: astore 9
    //   253: fload_3
    //   254: fstore_0
    //   255: goto -101 -> 154
    //   258: ldc 19
    //   260: fstore_1
    //   261: fload 5
    //   263: fstore_3
    //   264: goto -159 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   2	253	0	f1	float
    //   60	201	1	f2	float
    //   24	164	2	f3	float
    //   62	202	3	f4	float
    //   70	147	4	f5	float
    //   27	235	5	f6	float
    //   97	3	6	f7	float
    //   15	161	7	i	int
    //   4	243	8	bool	boolean
    //   20	71	9	localObject	Object
    //   149	6	9	localNumberFormatException1	NumberFormatException
    //   251	1	9	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   53	61	149	java/lang/NumberFormatException
    //   63	72	251	java/lang/NumberFormatException
    //   77	85	251	java/lang/NumberFormatException
    //   90	99	251	java/lang/NumberFormatException
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if (!jdField_a_of_type_Boolean)
    {
      i = awex.a(BaseApplicationImpl.getContext());
      if (i != 2) {
        break label26;
      }
      jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return jdField_a_of_type_Boolean;
      label26:
      if (i == 1) {
        jdField_a_of_type_Boolean = true;
      } else if (i == 0) {
        jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public static boolean b()
  {
    Object localObject;
    float f1;
    if (b == null)
    {
      localObject = mhr.c();
      f3 = 3.0F;
      j = 4;
      f4 = 1.1F;
      f2 = f4;
      i = j;
      f1 = f3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(";");
        f2 = f4;
        i = j;
        f1 = f3;
        if (localObject.length >= 3)
        {
          i = j;
          f1 = f3;
        }
      }
    }
    try
    {
      f2 = Float.parseFloat(localObject[0]);
      i = j;
      f1 = f2;
      j = Integer.parseInt(localObject[1]);
      i = j;
      f1 = f2;
      f3 = Float.parseFloat(localObject[2]);
      f1 = f2;
      i = j;
      f2 = f3;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int k;
        localNumberFormatException.printStackTrace();
        f2 = f4;
        continue;
        b = new Boolean(false);
        continue;
        i = 0;
        continue;
        boolean bool = false;
      }
    }
    float f3 = (float)babp.d() * 1.0F / 1.073742E+009F;
    int j = babp.b();
    f4 = (float)lbk.c() / 1048576.0F;
    if ((f1 <= f3) && (i <= j) && (f2 <= f4))
    {
      b = new Boolean(true);
      k = b.booleanValue();
      if (awex.a(BaseApplicationImpl.getContext()) == 0) {
        break label244;
      }
      i = 1;
      if (((i & k) == 0) || (Build.VERSION.SDK_INT < 21)) {
        break label250;
      }
      bool = true;
      b = Boolean.valueOf(bool);
      return b.booleanValue();
    }
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if (!jdField_a_of_type_Boolean)
    {
      i = awex.a(BaseApplicationImpl.getContext());
      if (i != 2) {
        break label123;
      }
      long l1 = System.currentTimeMillis();
      if (l1 <= jdField_a_of_type_Long) {
        break label106;
      }
      long l2 = AudioHelper.c();
      paramVideoAppInterface.h();
      long l3 = AudioHelper.c();
      QLog.w("AEKitAbilityInfo", 1, "checkAEKitPagSoReady, getEffectLibPagSoLoadIsOk[" + jdField_a_of_type_Boolean + "], cost[" + (l3 - l2) + "]");
      jdField_a_of_type_Long = l1 + 30000L;
      jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return jdField_a_of_type_Boolean;
      label106:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("AEKitAbilityInfo", 1, "tryDownloadPTULibPagSo, 频繁调用");
      break;
      label123:
      if (i == 1) {
        jdField_a_of_type_Boolean = true;
      } else if (i == 0) {
        jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public static boolean c(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = true;
    if (!b())
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess machine power not support");
      return false;
    }
    if (jdField_a_of_type_Int != -1)
    {
      if (jdField_a_of_type_Int == 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    if (!b(paramVideoAppInterface))
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess machine so not ready");
      return false;
    }
    long l = AudioHelper.c();
    bool = FeatureManager.Features.PAG.init();
    QLog.w("AEKitAbilityInfo", 1, "loadLibPag[" + jdField_a_of_type_Boolean + "], cost[" + (AudioHelper.c() - l) + "]");
    if (!bool) {}
    for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess result:=" + jdField_a_of_type_Int);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */