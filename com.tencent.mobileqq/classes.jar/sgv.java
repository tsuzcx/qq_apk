import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class sgv
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  public static final String a;
  private static volatile JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + sgv.class.getSimpleName();
    jdField_a_of_type_Int = -1;
  }
  
  public static float a()
  {
    if (jdField_a_of_type_Float > 0.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        Object localObject1 = Class.forName("android.media.MediaCodecList");
        Object localObject3 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject2 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject2).getDeclaredMethod("getSupportedTypes", new Class[0]);
        ((Class)localObject2).getDeclaredMethod("getName", new Class[0]);
        Method localMethod2 = ((Class)localObject2).getDeclaredMethod("isEncoder", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        Field localField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
        int n = ((Integer)((Method)localObject3).invoke(null, new Object[0])).intValue();
        i = -1;
        j = 0;
        if (j < n)
        {
          localObject3 = ((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(j) });
          if (((Boolean)localMethod2.invoke(localObject3, new Object[0])).booleanValue())
          {
            k = i;
          }
          else
          {
            String[] arrayOfString = (String[])localMethod1.invoke(localObject3, new Object[0]);
            int i1 = arrayOfString.length;
            m = 0;
            k = i;
            if (m < i1) {
              if (arrayOfString[m].equalsIgnoreCase("video/hevc"))
              {
                localObject3 = (Object[])localField1.get(((Method)localObject2).invoke(localObject3, new Object[] { "video/hevc" }));
                i1 = localObject3.length;
                k = 0;
                if (k < i1)
                {
                  m = ((Integer)localField2.get(localObject3[k])).intValue();
                  if (m <= i) {
                    break label353;
                  }
                  i = m;
                  break label365;
                }
                jdField_a_of_type_Float = a(i);
                k = i;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        jdField_a_of_type_Float = 0.0F;
      }
      return jdField_a_of_type_Float;
      m += 1;
      continue;
      label353:
      break label365;
      j += 1;
      int i = k;
      continue;
      label365:
      k += 1;
    }
  }
  
  private static float a(int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      Object localObject = new HashMap();
      ((HashMap)localObject).put("HEVCHighTierLevel1", Float.valueOf(1.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel2", Float.valueOf(2.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel21", Float.valueOf(2.1F));
      ((HashMap)localObject).put("HEVCHighTierLevel3", Float.valueOf(3.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel31", Float.valueOf(3.1F));
      ((HashMap)localObject).put("HEVCHighTierLevel4", Float.valueOf(4.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel41", Float.valueOf(4.1F));
      ((HashMap)localObject).put("HEVCHighTierLevel5", Float.valueOf(5.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel51", Float.valueOf(5.1F));
      ((HashMap)localObject).put("HEVCHighTierLevel52", Float.valueOf(5.2F));
      ((HashMap)localObject).put("HEVCHighTierLevel6", Float.valueOf(6.0F));
      ((HashMap)localObject).put("HEVCHighTierLevel61", Float.valueOf(6.1F));
      ((HashMap)localObject).put("HEVCHighTierLevel62", Float.valueOf(6.2F));
      ((HashMap)localObject).put("HEVCMainTierLevel1", Float.valueOf(1.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel2", Float.valueOf(2.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel21", Float.valueOf(2.1F));
      ((HashMap)localObject).put("HEVCMainTierLevel3", Float.valueOf(3.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel31", Float.valueOf(3.1F));
      ((HashMap)localObject).put("HEVCMainTierLevel4", Float.valueOf(4.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel41", Float.valueOf(4.1F));
      ((HashMap)localObject).put("HEVCMainTierLevel5", Float.valueOf(5.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel51", Float.valueOf(5.1F));
      ((HashMap)localObject).put("HEVCMainTierLevel52", Float.valueOf(5.2F));
      ((HashMap)localObject).put("HEVCMainTierLevel6", Float.valueOf(6.0F));
      ((HashMap)localObject).put("HEVCMainTierLevel61", Float.valueOf(6.1F));
      ((HashMap)localObject).put("HEVCMainTierLevel62", Float.valueOf(6.2F));
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (paramInt == ((Integer)localClass.getField((String)localEntry.getKey()).get(null)).intValue())
        {
          float f = ((Float)localEntry.getValue()).floatValue();
          return f;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "innerCalculateRealLevel ERROR = " + localException.getMessage());
      }
    }
    return 0.0F;
  }
  
  public static String a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject != null) {
      return jdField_a_of_type_OrgJsonJSONObject.toString();
    }
    try
    {
      if (jdField_a_of_type_OrgJsonJSONObject == null)
      {
        jdField_a_of_type_OrgJsonJSONObject = b();
        if (jdField_a_of_type_Int == -1) {
          a();
        }
      }
      String str = jdField_a_of_type_OrgJsonJSONObject.toString();
      return str;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "CPU_OTHER";
    }
    try
    {
      paramString = paramString.toLowerCase();
      if ((!paramString.contains("exynos")) && (!paramString.contains("smdk")) && (!paramString.contains("s5l8900")) && (!paramString.contains("s5pc100")))
      {
        if ((paramString.contains("kirin")) || (paramString.contains("k3v"))) {
          break label142;
        }
        if ((paramString.contains("msm")) || (paramString.contains("apq")) || (paramString.contains("qsd"))) {
          break label146;
        }
        if (paramString.contains("mt6")) {
          return "CPU_MTK";
        }
        return "CPU_OTHER";
      }
    }
    catch (Throwable paramString)
    {
      return "CPU_OTHER";
    }
    return "CPU_SUMSUNG";
    label142:
    return "CPU_HISI";
    label146:
    return "CPU_QUALCOMM";
  }
  
  private static void a()
  {
    if (bhzh.a().a()) {
      if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0) {
        bhzh.a().a(new sgw(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "queryKingCardType(), can only query in mobile connection");
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "queryKingCardType(), so not ready");
  }
  
  /* Error */
  private static String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 341	java/io/InputStreamReader
    //   5: dup
    //   6: new 343	java/io/FileInputStream
    //   9: dup
    //   10: ldc_w 345
    //   13: invokespecial 348	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: ldc_w 350
    //   19: invokespecial 353	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: astore 4
    //   24: new 355	java/io/BufferedReader
    //   27: dup
    //   28: aload 4
    //   30: invokespecial 358	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 361	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnonnull +44 -> 86
    //   45: aload_2
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +7 -> 60
    //   56: ldc_w 363
    //   59: astore_2
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   70: aload_2
    //   71: astore_3
    //   72: aload 5
    //   74: ifnull +10 -> 84
    //   77: aload 5
    //   79: invokevirtual 367	java/io/BufferedReader:close	()V
    //   82: aload_2
    //   83: astore_3
    //   84: aload_3
    //   85: areturn
    //   86: aload_3
    //   87: ldc_w 369
    //   90: invokevirtual 372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq -58 -> 35
    //   96: aload_3
    //   97: bipush 58
    //   99: invokevirtual 375	java/lang/String:indexOf	(I)I
    //   102: istore_0
    //   103: iload_0
    //   104: iconst_1
    //   105: if_icmple -70 -> 35
    //   108: aload_3
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: invokevirtual 379	java/lang/String:substring	(I)Ljava/lang/String;
    //   115: invokevirtual 382	java/lang/String:trim	()Ljava/lang/String;
    //   118: ldc_w 384
    //   121: ldc_w 386
    //   124: invokevirtual 390	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   127: astore_3
    //   128: aload_3
    //   129: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: istore_1
    //   133: aload_3
    //   134: astore_2
    //   135: iload_1
    //   136: ifne -101 -> 35
    //   139: goto -92 -> 47
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_2
    //   145: aconst_null
    //   146: astore 4
    //   148: ldc_w 363
    //   151: astore_3
    //   152: aload 4
    //   154: ifnull +8 -> 162
    //   157: aload 4
    //   159: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   162: aload_2
    //   163: ifnull -79 -> 84
    //   166: aload_2
    //   167: invokevirtual 367	java/io/BufferedReader:close	()V
    //   170: ldc_w 363
    //   173: areturn
    //   174: astore_2
    //   175: ldc_w 363
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_3
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 367	java/io/BufferedReader:close	()V
    //   203: aload_2
    //   204: athrow
    //   205: astore_3
    //   206: goto -3 -> 203
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_3
    //   212: goto -27 -> 185
    //   215: astore_2
    //   216: aload 5
    //   218: astore_3
    //   219: goto -34 -> 185
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -77 -> 148
    //   228: astore_2
    //   229: aload 5
    //   231: astore_2
    //   232: goto -84 -> 148
    //   235: astore_3
    //   236: aload_2
    //   237: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   102	10	0	i	int
    //   132	4	1	bool	boolean
    //   1	134	2	localObject1	Object
    //   142	1	2	localThrowable1	Throwable
    //   144	23	2	localObject2	Object
    //   174	1	2	localIOException1	java.io.IOException
    //   179	25	2	localObject3	Object
    //   209	1	2	localObject4	Object
    //   215	1	2	localObject5	Object
    //   222	1	2	localThrowable2	Throwable
    //   224	1	2	localObject6	Object
    //   228	1	2	localThrowable3	Throwable
    //   231	6	2	localObject7	Object
    //   40	160	3	localObject8	Object
    //   205	1	3	localIOException2	java.io.IOException
    //   211	8	3	localBufferedReader1	java.io.BufferedReader
    //   235	1	3	localIOException3	java.io.IOException
    //   22	169	4	localInputStreamReader	java.io.InputStreamReader
    //   33	197	5	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   2	24	142	java/lang/Throwable
    //   157	162	174	java/io/IOException
    //   166	170	174	java/io/IOException
    //   2	24	179	finally
    //   190	195	205	java/io/IOException
    //   199	203	205	java/io/IOException
    //   24	35	209	finally
    //   35	41	215	finally
    //   49	56	215	finally
    //   86	103	215	finally
    //   108	133	215	finally
    //   24	35	222	java/lang/Throwable
    //   35	41	228	java/lang/Throwable
    //   49	56	228	java/lang/Throwable
    //   86	103	228	java/lang/Throwable
    //   108	133	228	java/lang/Throwable
    //   65	70	235	java/io/IOException
    //   77	82	235	java/io/IOException
  }
  
  /* Error */
  private static JSONObject b()
  {
    // Byte code:
    //   0: new 253	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 391	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_1
    //   11: ldc_w 393
    //   14: invokestatic 398	com/tencent/mobileqq/utils/DeviceInfoUtil:getIMEI	()Ljava/lang/String;
    //   17: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ldc_w 403
    //   27: invokestatic 406	com/tencent/mobileqq/utils/DeviceInfoUtil:getIMSI	()Ljava/lang/String;
    //   30: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: ldc_w 408
    //   40: invokestatic 412	com/tencent/mobileqq/utils/DeviceInfoUtil:getCpuFrequency	()J
    //   43: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: ldc_w 417
    //   53: invokestatic 420	com/tencent/mobileqq/utils/DeviceInfoUtil:getCpuNumber	()I
    //   56: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_1
    //   61: astore_2
    //   62: aload_1
    //   63: ldc_w 425
    //   66: invokestatic 428	com/tencent/mobileqq/utils/DeviceInfoUtil:getOsVersion	()I
    //   69: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: ldc_w 430
    //   79: invokestatic 433	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceModel	()Ljava/lang/String;
    //   82: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: ldc_w 435
    //   92: invokestatic 438	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceOSVersion	()Ljava/lang/String;
    //   95: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_1
    //   100: astore_2
    //   101: aload_1
    //   102: ldc_w 440
    //   105: invokestatic 443	com/tencent/mobileqq/utils/DeviceInfoUtil:getManufactureInfo	()Ljava/lang/String;
    //   108: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_1
    //   113: astore_2
    //   114: aload_1
    //   115: ldc_w 445
    //   118: getstatic 450	android/os/Build$VERSION:SDK_INT	I
    //   121: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_1
    //   126: astore_2
    //   127: aload_1
    //   128: ldc_w 452
    //   131: invokestatic 455	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   134: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: ldc_w 457
    //   144: invokestatic 460	com/tencent/mobileqq/utils/DeviceInfoUtil:getSystemTotalMemory	()J
    //   147: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_1
    //   152: astore_2
    //   153: aload_1
    //   154: ldc_w 462
    //   157: invokestatic 465	com/tencent/mobileqq/utils/DeviceInfoUtil:getSystemAvaialbeMemory	()J
    //   160: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: astore_2
    //   166: invokestatic 469	com/tencent/mobileqq/utils/DeviceInfoUtil:getRomMemroy	()[J
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_1
    //   173: ldc_w 471
    //   176: aload_3
    //   177: iconst_0
    //   178: laload
    //   179: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload_1
    //   184: astore_2
    //   185: aload_1
    //   186: ldc_w 473
    //   189: aload_3
    //   190: iconst_1
    //   191: laload
    //   192: invokevirtual 415	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_1
    //   197: astore_2
    //   198: aload_1
    //   199: ldc_w 475
    //   202: iconst_1
    //   203: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_1
    //   208: astore_2
    //   209: invokestatic 477	sgv:b	()Ljava/lang/String;
    //   212: astore_3
    //   213: aload_1
    //   214: astore_2
    //   215: aload_1
    //   216: ldc_w 479
    //   219: aload_3
    //   220: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: ldc_w 481
    //   230: aload_3
    //   231: invokestatic 483	sgv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload_1
    //   239: astore_2
    //   240: getstatic 35	sgv:jdField_a_of_type_Int	I
    //   243: iconst_m1
    //   244: if_icmpne +34 -> 278
    //   247: iconst_0
    //   248: istore_0
    //   249: aload_1
    //   250: astore_2
    //   251: aload_1
    //   252: ldc_w 485
    //   255: iload_0
    //   256: invokevirtual 423	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload_1
    //   261: astore_2
    //   262: aload_1
    //   263: ldc_w 487
    //   266: invokestatic 489	sgv:a	()F
    //   269: invokestatic 492	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   272: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   275: pop
    //   276: aload_1
    //   277: areturn
    //   278: aload_1
    //   279: astore_2
    //   280: getstatic 35	sgv:jdField_a_of_type_Int	I
    //   283: istore_0
    //   284: goto -35 -> 249
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_1
    //   290: aload_1
    //   291: astore_2
    //   292: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +47 -> 342
    //   298: aload_1
    //   299: astore_2
    //   300: getstatic 33	sgv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   303: iconst_2
    //   304: new 13	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 494
    //   314: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 495	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   321: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_1
    //   331: areturn
    //   332: astore_1
    //   333: aload_2
    //   334: areturn
    //   335: astore_1
    //   336: aconst_null
    //   337: areturn
    //   338: astore_3
    //   339: goto -49 -> 290
    //   342: aload_1
    //   343: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   248	36	0	i	int
    //   7	324	1	localJSONObject1	JSONObject
    //   332	1	1	localObject1	Object
    //   335	8	1	localJSONObject2	JSONObject
    //   9	325	2	localJSONObject3	JSONObject
    //   169	62	3	localObject2	Object
    //   287	31	3	localThrowable1	Throwable
    //   338	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	287	java/lang/Throwable
    //   10	21	332	finally
    //   23	34	332	finally
    //   36	47	332	finally
    //   49	60	332	finally
    //   62	73	332	finally
    //   75	86	332	finally
    //   88	99	332	finally
    //   101	112	332	finally
    //   114	125	332	finally
    //   127	138	332	finally
    //   140	151	332	finally
    //   153	164	332	finally
    //   166	170	332	finally
    //   172	183	332	finally
    //   185	196	332	finally
    //   198	207	332	finally
    //   209	213	332	finally
    //   215	224	332	finally
    //   226	238	332	finally
    //   240	247	332	finally
    //   251	260	332	finally
    //   262	276	332	finally
    //   280	284	332	finally
    //   292	298	332	finally
    //   300	330	332	finally
    //   0	8	335	finally
    //   10	21	338	java/lang/Throwable
    //   23	34	338	java/lang/Throwable
    //   36	47	338	java/lang/Throwable
    //   49	60	338	java/lang/Throwable
    //   62	73	338	java/lang/Throwable
    //   75	86	338	java/lang/Throwable
    //   88	99	338	java/lang/Throwable
    //   101	112	338	java/lang/Throwable
    //   114	125	338	java/lang/Throwable
    //   127	138	338	java/lang/Throwable
    //   140	151	338	java/lang/Throwable
    //   153	164	338	java/lang/Throwable
    //   166	170	338	java/lang/Throwable
    //   172	183	338	java/lang/Throwable
    //   185	196	338	java/lang/Throwable
    //   198	207	338	java/lang/Throwable
    //   209	213	338	java/lang/Throwable
    //   215	224	338	java/lang/Throwable
    //   226	238	338	java/lang/Throwable
    //   240	247	338	java/lang/Throwable
    //   251	260	338	java/lang/Throwable
    //   262	276	338	java/lang/Throwable
    //   280	284	338	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgv
 * JD-Core Version:    0.7.0.1
 */