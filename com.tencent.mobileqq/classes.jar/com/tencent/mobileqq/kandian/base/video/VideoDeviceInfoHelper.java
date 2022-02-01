package com.tencent.mobileqq.kandian.base.video;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class VideoDeviceInfoHelper
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  public static final String a;
  private static volatile JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video");
    localStringBuilder.append(VideoDeviceInfoHelper.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = -1;
  }
  
  public static float a()
  {
    float f = jdField_a_of_type_Float;
    if (f > 0.0F) {
      return f;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName("android.media.MediaCodecList");
        j = 0;
        localObject3 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject2 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject2).getDeclaredMethod("getSupportedTypes", new Class[0]);
        ((Class)localObject2).getDeclaredMethod("getName", new Class[0]);
        Method localMethod2 = ((Class)localObject2).getDeclaredMethod("isEncoder", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        localField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
        int i2 = ((Integer)((Method)localObject3).invoke(null, new Object[0])).intValue();
        k = 0;
        i = -1;
        if (k >= i2) {
          continue;
        }
        localObject3 = new Object[1];
        localObject3[j] = Integer.valueOf(k);
        localObject3 = ((Method)localObject1).invoke(null, (Object[])localObject3);
        if (((Boolean)localMethod2.invoke(localObject3, new Object[j])).booleanValue())
        {
          n = i;
          continue;
        }
        String[] arrayOfString = (String[])localMethod1.invoke(localObject3, new Object[j]);
        i1 = arrayOfString.length;
        m = 0;
        n = i;
        if (m >= i1) {
          continue;
        }
        if (!arrayOfString[m].equalsIgnoreCase("video/hevc")) {
          continue;
        }
        n = 0;
        localObject3 = (Object[])localField1.get(((Method)localObject2).invoke(localObject3, new Object[] { "video/hevc" }));
        i3 = localObject3.length;
        j = 0;
      }
      catch (Exception localException)
      {
        int j;
        Object localObject3;
        Field localField2;
        int k;
        int n;
        int i1;
        int m;
        int i3;
        continue;
        j += 1;
        int i = m;
        continue;
      }
      if (j < i3)
      {
        i1 = ((Integer)localField2.get(localObject3[j])).intValue();
        m = i;
        if (i1 <= i) {
          continue;
        }
        m = i1;
        continue;
      }
      jdField_a_of_type_Float = a(i);
      j = n;
      n = i;
      continue;
      j = 0;
      m += 1;
      continue;
      k += 1;
      i = n;
    }
    jdField_a_of_type_Float = 0.0F;
    return jdField_a_of_type_Float;
  }
  
  private static float a(int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("HEVCHighTierLevel1", Float.valueOf(1.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel2", Float.valueOf(2.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel21", Float.valueOf(2.1F));
      ((HashMap)localObject1).put("HEVCHighTierLevel3", Float.valueOf(3.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel31", Float.valueOf(3.1F));
      ((HashMap)localObject1).put("HEVCHighTierLevel4", Float.valueOf(4.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel41", Float.valueOf(4.1F));
      ((HashMap)localObject1).put("HEVCHighTierLevel5", Float.valueOf(5.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel51", Float.valueOf(5.1F));
      ((HashMap)localObject1).put("HEVCHighTierLevel52", Float.valueOf(5.2F));
      ((HashMap)localObject1).put("HEVCHighTierLevel6", Float.valueOf(6.0F));
      ((HashMap)localObject1).put("HEVCHighTierLevel61", Float.valueOf(6.1F));
      ((HashMap)localObject1).put("HEVCHighTierLevel62", Float.valueOf(6.2F));
      ((HashMap)localObject1).put("HEVCMainTierLevel1", Float.valueOf(1.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel2", Float.valueOf(2.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel21", Float.valueOf(2.1F));
      ((HashMap)localObject1).put("HEVCMainTierLevel3", Float.valueOf(3.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel31", Float.valueOf(3.1F));
      ((HashMap)localObject1).put("HEVCMainTierLevel4", Float.valueOf(4.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel41", Float.valueOf(4.1F));
      ((HashMap)localObject1).put("HEVCMainTierLevel5", Float.valueOf(5.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel51", Float.valueOf(5.1F));
      ((HashMap)localObject1).put("HEVCMainTierLevel52", Float.valueOf(5.2F));
      ((HashMap)localObject1).put("HEVCMainTierLevel6", Float.valueOf(6.0F));
      ((HashMap)localObject1).put("HEVCMainTierLevel61", Float.valueOf(6.1F));
      ((HashMap)localObject1).put("HEVCMainTierLevel62", Float.valueOf(6.2F));
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (paramInt == ((Integer)localClass.getField((String)((Map.Entry)localObject2).getKey()).get(null)).intValue())
        {
          float f = ((Float)((Map.Entry)localObject2).getValue()).floatValue();
          return f;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("innerCalculateRealLevel ERROR = ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    return 0.0F;
  }
  
  public static String a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject != null)
    {
      try
      {
        jdField_a_of_type_OrgJsonJSONObject.put("Bandwith", BandwidthPredictor.from().getCurrentPrediction());
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
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
      try
      {
        jdField_a_of_type_OrgJsonJSONObject.put("Bandwith", BandwidthPredictor.from().getCurrentPrediction());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
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
          break label146;
        }
        if ((paramString.contains("msm")) || (paramString.contains("apq")) || (paramString.contains("qsd"))) {
          break label142;
        }
        if (paramString.contains("mt6")) {
          return "CPU_MTK";
        }
      }
      else
      {
        return "CPU_SUMSUNG";
      }
    }
    catch (Throwable paramString)
    {
      return "CPU_OTHER";
    }
    return "CPU_OTHER";
    label142:
    return "CPU_QUALCOMM";
    label146:
    return "CPU_HISI";
  }
  
  private static void a()
  {
    if (TMSManager.a().a())
    {
      if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0)
      {
        TMSManager.a().a(new VideoDeviceInfoHelper.1(), false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "queryKingCardType(), can only query in mobile connection");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "queryKingCardType(), so not ready");
    }
  }
  
  /* Error */
  private static String b()
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: new 361	java/io/InputStreamReader
    //   9: dup
    //   10: new 363	java/io/FileInputStream
    //   13: dup
    //   14: ldc_w 365
    //   17: invokespecial 368	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 370
    //   23: invokespecial 373	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   26: astore 6
    //   28: new 375	java/io/BufferedReader
    //   31: dup
    //   32: aload 6
    //   34: invokespecial 378	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 381	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnonnull +6 -> 54
    //   51: goto +63 -> 114
    //   54: aload 5
    //   56: ldc_w 383
    //   59: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifeq -23 -> 39
    //   65: aload 5
    //   67: bipush 58
    //   69: invokevirtual 389	java/lang/String:indexOf	(I)I
    //   72: istore_0
    //   73: iload_0
    //   74: iconst_1
    //   75: if_icmple -36 -> 39
    //   78: aload 5
    //   80: iload_0
    //   81: iconst_1
    //   82: iadd
    //   83: invokevirtual 393	java/lang/String:substring	(I)Ljava/lang/String;
    //   86: invokevirtual 396	java/lang/String:trim	()Ljava/lang/String;
    //   89: ldc_w 398
    //   92: ldc_w 400
    //   95: invokevirtual 404	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: astore_2
    //   103: aload 5
    //   105: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne -69 -> 39
    //   111: aload 5
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: istore_1
    //   119: iload_1
    //   120: ifeq +8 -> 128
    //   123: aload_3
    //   124: astore_2
    //   125: goto +3 -> 128
    //   128: aload_2
    //   129: astore 5
    //   131: aload 6
    //   133: invokevirtual 407	java/io/InputStreamReader:close	()V
    //   136: aload_2
    //   137: astore_3
    //   138: aload_3
    //   139: astore 5
    //   141: aload 4
    //   143: invokevirtual 408	java/io/BufferedReader:close	()V
    //   146: aload_3
    //   147: areturn
    //   148: aload 6
    //   150: ifnull +11 -> 161
    //   153: aload_3
    //   154: astore 5
    //   156: aload 6
    //   158: invokevirtual 407	java/io/InputStreamReader:close	()V
    //   161: aload_2
    //   162: ifnull +9 -> 171
    //   165: aload_2
    //   166: astore 4
    //   168: goto -30 -> 138
    //   171: ldc_w 359
    //   174: areturn
    //   175: aload 6
    //   177: ifnull +8 -> 185
    //   180: aload 6
    //   182: invokevirtual 407	java/io/InputStreamReader:close	()V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 408	java/io/BufferedReader:close	()V
    //   195: goto +5 -> 200
    //   198: aload_2
    //   199: athrow
    //   200: goto -2 -> 198
    //   203: astore_2
    //   204: goto +49 -> 253
    //   207: astore_2
    //   208: goto +29 -> 237
    //   211: astore_2
    //   212: aload 4
    //   214: astore_2
    //   215: goto -67 -> 148
    //   218: astore_2
    //   219: aload 5
    //   221: areturn
    //   222: astore_3
    //   223: goto -28 -> 195
    //   226: astore_2
    //   227: goto -52 -> 175
    //   230: astore_2
    //   231: aconst_null
    //   232: astore 4
    //   234: goto -59 -> 175
    //   237: aconst_null
    //   238: astore_2
    //   239: goto -91 -> 148
    //   242: astore_2
    //   243: aconst_null
    //   244: astore 6
    //   246: aload 6
    //   248: astore 4
    //   250: goto -75 -> 175
    //   253: aconst_null
    //   254: astore 6
    //   256: aload 6
    //   258: astore_2
    //   259: goto -111 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	11	0	i	int
    //   118	2	1	bool	boolean
    //   5	194	2	localObject1	Object
    //   203	1	2	localThrowable1	Throwable
    //   207	1	2	localThrowable2	Throwable
    //   211	1	2	localThrowable3	Throwable
    //   214	1	2	localObject2	Object
    //   218	1	2	localIOException1	java.io.IOException
    //   226	1	2	localObject3	Object
    //   230	1	2	localObject4	Object
    //   238	1	2	localObject5	Object
    //   242	1	2	localObject6	Object
    //   258	1	2	localObject7	Object
    //   3	151	3	localObject8	Object
    //   222	1	3	localIOException2	java.io.IOException
    //   37	212	4	localObject9	Object
    //   44	176	5	localObject10	Object
    //   26	231	6	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   6	28	203	java/lang/Throwable
    //   28	39	207	java/lang/Throwable
    //   39	46	211	java/lang/Throwable
    //   54	73	211	java/lang/Throwable
    //   78	100	211	java/lang/Throwable
    //   103	111	211	java/lang/Throwable
    //   114	119	211	java/lang/Throwable
    //   131	136	218	java/io/IOException
    //   141	146	218	java/io/IOException
    //   156	161	218	java/io/IOException
    //   180	185	222	java/io/IOException
    //   190	195	222	java/io/IOException
    //   39	46	226	finally
    //   54	73	226	finally
    //   78	100	226	finally
    //   103	111	226	finally
    //   114	119	226	finally
    //   28	39	230	finally
    //   6	28	242	finally
  }
  
  /* Error */
  private static JSONObject b()
  {
    // Byte code:
    //   0: new 265	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 409	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_1
    //   11: ldc_w 411
    //   14: invokestatic 415	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   17: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ldc_w 420
    //   27: invokestatic 422	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()Ljava/lang/String;
    //   30: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: ldc_w 424
    //   40: invokestatic 426	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()J
    //   43: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: ldc_w 428
    //   53: invokestatic 430	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()I
    //   56: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_1
    //   61: astore_2
    //   62: aload_1
    //   63: ldc_w 435
    //   66: invokestatic 437	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()I
    //   69: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: ldc_w 439
    //   79: invokestatic 442	com/tencent/mobileqq/utils/DeviceInfoUtil:d	()Ljava/lang/String;
    //   82: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: ldc_w 444
    //   92: invokestatic 446	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()Ljava/lang/String;
    //   95: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_1
    //   100: astore_2
    //   101: aload_1
    //   102: ldc_w 448
    //   105: invokestatic 451	com/tencent/mobileqq/utils/DeviceInfoUtil:h	()Ljava/lang/String;
    //   108: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_1
    //   113: astore_2
    //   114: aload_1
    //   115: ldc_w 453
    //   118: getstatic 458	android/os/Build$VERSION:SDK_INT	I
    //   121: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_1
    //   126: astore_2
    //   127: aload_1
    //   128: ldc_w 460
    //   131: invokestatic 463	com/tencent/mobileqq/utils/DeviceInfoUtil:c	()Ljava/lang/String;
    //   134: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: ldc_w 465
    //   144: invokestatic 467	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   147: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_1
    //   152: astore_2
    //   153: aload_1
    //   154: ldc_w 469
    //   157: invokestatic 471	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()J
    //   160: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: astore_2
    //   166: invokestatic 474	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()[J
    //   169: astore_3
    //   170: iconst_0
    //   171: istore_0
    //   172: aload_1
    //   173: astore_2
    //   174: aload_1
    //   175: ldc_w 476
    //   178: aload_3
    //   179: iconst_0
    //   180: laload
    //   181: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   184: pop
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: ldc_w 478
    //   191: aload_3
    //   192: iconst_1
    //   193: laload
    //   194: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_1
    //   199: astore_2
    //   200: aload_1
    //   201: ldc_w 480
    //   204: iconst_1
    //   205: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_1
    //   210: astore_2
    //   211: invokestatic 481	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:b	()Ljava/lang/String;
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload_1
    //   218: ldc_w 483
    //   221: aload_3
    //   222: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload_1
    //   227: astore_2
    //   228: aload_1
    //   229: ldc_w 485
    //   232: aload_3
    //   233: invokestatic 487	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload_1
    //   241: astore_2
    //   242: getstatic 35	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:jdField_a_of_type_Int	I
    //   245: iconst_m1
    //   246: if_icmpne +6 -> 252
    //   249: goto +9 -> 258
    //   252: aload_1
    //   253: astore_2
    //   254: getstatic 35	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:jdField_a_of_type_Int	I
    //   257: istore_0
    //   258: aload_1
    //   259: astore_2
    //   260: aload_1
    //   261: ldc_w 489
    //   264: iload_0
    //   265: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: astore_2
    //   271: aload_1
    //   272: ldc_w 491
    //   275: invokestatic 493	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:a	()F
    //   278: invokestatic 496	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   281: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   284: pop
    //   285: aload_1
    //   286: areturn
    //   287: astore_3
    //   288: goto +8 -> 296
    //   291: aconst_null
    //   292: areturn
    //   293: astore_3
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_1
    //   297: astore_2
    //   298: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +57 -> 358
    //   304: aload_1
    //   305: astore_2
    //   306: getstatic 33	com/tencent/mobileqq/kandian/base/video/VideoDeviceInfoHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   309: astore 4
    //   311: aload_1
    //   312: astore_2
    //   313: new 13	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   320: astore 5
    //   322: aload_1
    //   323: astore_2
    //   324: aload 5
    //   326: ldc_w 498
    //   329: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_1
    //   334: astore_2
    //   335: aload 5
    //   337: aload_3
    //   338: invokevirtual 499	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   341: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: astore_2
    //   347: aload 4
    //   349: iconst_2
    //   350: aload 5
    //   352: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 501	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload_1
    //   359: areturn
    //   360: astore_1
    //   361: goto -70 -> 291
    //   364: astore_1
    //   365: aload_2
    //   366: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   171	94	0	i	int
    //   7	352	1	localJSONObject1	JSONObject
    //   360	1	1	localObject1	Object
    //   364	1	1	localObject2	Object
    //   9	357	2	localJSONObject2	JSONObject
    //   169	64	3	localObject3	Object
    //   287	1	3	localThrowable1	Throwable
    //   293	45	3	localThrowable2	Throwable
    //   309	39	4	str	String
    //   320	31	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	21	287	java/lang/Throwable
    //   23	34	287	java/lang/Throwable
    //   36	47	287	java/lang/Throwable
    //   49	60	287	java/lang/Throwable
    //   62	73	287	java/lang/Throwable
    //   75	86	287	java/lang/Throwable
    //   88	99	287	java/lang/Throwable
    //   101	112	287	java/lang/Throwable
    //   114	125	287	java/lang/Throwable
    //   127	138	287	java/lang/Throwable
    //   140	151	287	java/lang/Throwable
    //   153	164	287	java/lang/Throwable
    //   166	170	287	java/lang/Throwable
    //   174	185	287	java/lang/Throwable
    //   187	198	287	java/lang/Throwable
    //   200	209	287	java/lang/Throwable
    //   211	215	287	java/lang/Throwable
    //   217	226	287	java/lang/Throwable
    //   228	240	287	java/lang/Throwable
    //   242	249	287	java/lang/Throwable
    //   254	258	287	java/lang/Throwable
    //   260	269	287	java/lang/Throwable
    //   271	285	287	java/lang/Throwable
    //   0	8	293	java/lang/Throwable
    //   0	8	360	finally
    //   10	21	364	finally
    //   23	34	364	finally
    //   36	47	364	finally
    //   49	60	364	finally
    //   62	73	364	finally
    //   75	86	364	finally
    //   88	99	364	finally
    //   101	112	364	finally
    //   114	125	364	finally
    //   127	138	364	finally
    //   140	151	364	finally
    //   153	164	364	finally
    //   166	170	364	finally
    //   174	185	364	finally
    //   187	198	364	finally
    //   200	209	364	finally
    //   211	215	364	finally
    //   217	226	364	finally
    //   228	240	364	finally
    //   242	249	364	finally
    //   254	258	364	finally
    //   260	269	364	finally
    //   271	285	364	finally
    //   298	304	364	finally
    //   306	311	364	finally
    //   313	322	364	finally
    //   324	333	364	finally
    //   335	345	364	finally
    //   347	358	364	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */