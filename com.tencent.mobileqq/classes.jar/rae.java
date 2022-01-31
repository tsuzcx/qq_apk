import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Range;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class rae
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  public static final String a;
  private static volatile JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rae.class.getSimpleName();
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
      int i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
      int j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
      int k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
      int m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
      int n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
      int i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
      int i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
      int i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
      int i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
      int i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
      int i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
      int i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
      int i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
      int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
      int i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
      int i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
      int i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
      int i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
      int i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
      int i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
      int i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
      int i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
      int i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
      int i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
      int i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
      int i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
      if ((paramInt == i) || (paramInt == i9)) {
        return 1.0F;
      }
      if ((paramInt == j) || (paramInt == i10)) {
        return 2.0F;
      }
      if ((paramInt == k) || (paramInt == i11)) {
        return 2.1F;
      }
      if ((paramInt == m) || (paramInt == i12)) {
        return 3.0F;
      }
      if ((paramInt == n) || (paramInt == i13)) {
        return 3.1F;
      }
      if ((paramInt == i1) || (paramInt == i14)) {
        return 4.0F;
      }
      if ((paramInt == i2) || (paramInt == i15)) {
        return 4.1F;
      }
      if ((paramInt == i3) || (paramInt == i16)) {
        return 5.0F;
      }
      if ((paramInt == i4) || (paramInt == i17)) {
        return 5.1F;
      }
      if ((paramInt == i5) || (paramInt == i18)) {
        return 5.2F;
      }
      if ((paramInt == i6) || (paramInt == i19)) {
        return 6.0F;
      }
      if ((paramInt >= i7) || (paramInt == i20)) {
        return 6.1F;
      }
      if ((paramInt >= i8) || (paramInt == i21)) {
        return 6.2F;
      }
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 199	java/io/InputStreamReader
    //   5: dup
    //   6: new 201	java/io/FileInputStream
    //   9: dup
    //   10: ldc 203
    //   12: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: ldc 208
    //   17: invokespecial 211	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   20: astore 4
    //   22: new 213	java/io/BufferedReader
    //   25: dup
    //   26: aload 4
    //   28: invokespecial 216	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnonnull +43 -> 83
    //   43: aload_2
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +6 -> 57
    //   54: ldc 227
    //   56: astore_2
    //   57: aload 4
    //   59: ifnull +8 -> 67
    //   62: aload 4
    //   64: invokevirtual 230	java/io/InputStreamReader:close	()V
    //   67: aload_2
    //   68: astore_3
    //   69: aload 5
    //   71: ifnull +10 -> 81
    //   74: aload 5
    //   76: invokevirtual 231	java/io/BufferedReader:close	()V
    //   79: aload_2
    //   80: astore_3
    //   81: aload_3
    //   82: areturn
    //   83: aload_3
    //   84: ldc 233
    //   86: invokevirtual 236	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   89: ifeq -56 -> 33
    //   92: aload_3
    //   93: bipush 58
    //   95: invokevirtual 239	java/lang/String:indexOf	(I)I
    //   98: istore_0
    //   99: iload_0
    //   100: iconst_1
    //   101: if_icmple -68 -> 33
    //   104: aload_3
    //   105: iload_0
    //   106: iconst_1
    //   107: iadd
    //   108: aload_3
    //   109: invokevirtual 242	java/lang/String:length	()I
    //   112: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
    //   115: invokevirtual 249	java/lang/String:trim	()Ljava/lang/String;
    //   118: ldc 251
    //   120: ldc 253
    //   122: invokevirtual 257	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: astore_3
    //   126: aload_3
    //   127: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: istore_1
    //   131: aload_3
    //   132: astore_2
    //   133: iload_1
    //   134: ifne -101 -> 33
    //   137: goto -92 -> 45
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 4
    //   146: ldc 227
    //   148: astore_3
    //   149: aload 4
    //   151: ifnull +8 -> 159
    //   154: aload 4
    //   156: invokevirtual 230	java/io/InputStreamReader:close	()V
    //   159: aload_2
    //   160: ifnull -79 -> 81
    //   163: aload_2
    //   164: invokevirtual 231	java/io/BufferedReader:close	()V
    //   167: ldc 227
    //   169: areturn
    //   170: astore_2
    //   171: ldc 227
    //   173: areturn
    //   174: astore_2
    //   175: aconst_null
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_3
    //   180: aload 4
    //   182: ifnull +8 -> 190
    //   185: aload 4
    //   187: invokevirtual 230	java/io/InputStreamReader:close	()V
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 231	java/io/BufferedReader:close	()V
    //   198: aload_2
    //   199: athrow
    //   200: astore_3
    //   201: goto -3 -> 198
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_3
    //   207: goto -27 -> 180
    //   210: astore_2
    //   211: aload 5
    //   213: astore_3
    //   214: goto -34 -> 180
    //   217: astore_2
    //   218: aconst_null
    //   219: astore_2
    //   220: goto -74 -> 146
    //   223: astore_2
    //   224: aload 5
    //   226: astore_2
    //   227: goto -81 -> 146
    //   230: astore_3
    //   231: aload_2
    //   232: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   98	10	0	i	int
    //   130	4	1	bool	boolean
    //   1	132	2	localObject1	Object
    //   140	1	2	localThrowable1	Throwable
    //   142	22	2	localObject2	Object
    //   170	1	2	localIOException1	java.io.IOException
    //   174	25	2	localObject3	Object
    //   204	1	2	localObject4	Object
    //   210	1	2	localObject5	Object
    //   217	1	2	localThrowable2	Throwable
    //   219	1	2	localObject6	Object
    //   223	1	2	localThrowable3	Throwable
    //   226	6	2	localObject7	Object
    //   38	157	3	localObject8	Object
    //   200	1	3	localIOException2	java.io.IOException
    //   206	8	3	localBufferedReader1	java.io.BufferedReader
    //   230	1	3	localIOException3	java.io.IOException
    //   20	166	4	localInputStreamReader	java.io.InputStreamReader
    //   31	194	5	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   2	22	140	java/lang/Throwable
    //   154	159	170	java/io/IOException
    //   163	167	170	java/io/IOException
    //   2	22	174	finally
    //   185	190	200	java/io/IOException
    //   194	198	200	java/io/IOException
    //   22	33	204	finally
    //   33	39	210	finally
    //   47	54	210	finally
    //   83	99	210	finally
    //   104	131	210	finally
    //   22	33	217	java/lang/Throwable
    //   33	39	223	java/lang/Throwable
    //   47	54	223	java/lang/Throwable
    //   83	99	223	java/lang/Throwable
    //   104	131	223	java/lang/Throwable
    //   62	67	230	java/io/IOException
    //   74	79	230	java/io/IOException
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
  
  public static String a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (jdField_a_of_type_OrgJsonJSONObject != null)) {
      return jdField_a_of_type_OrgJsonJSONObject.toString();
    }
    try
    {
      if (jdField_a_of_type_OrgJsonJSONObject == null)
      {
        jdField_a_of_type_OrgJsonJSONObject = c();
        if (jdField_a_of_type_Int == -1) {
          a();
        }
      }
      if (!paramBoolean)
      {
        String str = jdField_a_of_type_OrgJsonJSONObject.toString();
        return str;
      }
    }
    finally {}
    try
    {
      Object localObject2 = new JSONObject(jdField_a_of_type_OrgJsonJSONObject.toString());
      ((JSONObject)localObject2).put("speedsInfo", rag.a());
      localObject2 = ((JSONObject)localObject2).toString();
      return localObject2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static JSONObject a()
  {
    if (!bhtb.j()) {
      return null;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if (localMediaCodecInfo.isEncoder()) {
            break label395;
          }
          Object localObject = localMediaCodecInfo.getSupportedTypes();
          j = 0;
          if (j >= localObject.length) {
            break label395;
          }
          if (!localObject[j].equalsIgnoreCase("video/hevc")) {
            break label388;
          }
          MediaCodecInfo.VideoCapabilities localVideoCapabilities = localMediaCodecInfo.getCapabilitiesForType("video/hevc").getVideoCapabilities();
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("name", localMediaCodecInfo.getName());
            ((JSONObject)localObject).put("br_max", ((Integer)localVideoCapabilities.getBitrateRange().getUpper()).toString());
            ((JSONObject)localObject).put("br_min", ((Integer)localVideoCapabilities.getBitrateRange().getLower()).toString());
            ((JSONObject)localObject).put("h_max", ((Integer)localVideoCapabilities.getSupportedHeights().getUpper()).toString());
            ((JSONObject)localObject).put("h_min", ((Integer)localVideoCapabilities.getSupportedHeights().getLower()).toString());
            ((JSONObject)localObject).put("w_max", ((Integer)localVideoCapabilities.getSupportedWidths().getUpper()).toString());
            ((JSONObject)localObject).put("w_min", ((Integer)localVideoCapabilities.getSupportedWidths().getLower()).toString());
            ((JSONObject)localObject).put("h_align", localVideoCapabilities.getHeightAlignment());
            ((JSONObject)localObject).put("w_align", localVideoCapabilities.getWidthAlignment());
            ((JSONObject)localObject).put("fr_max", ((Integer)localVideoCapabilities.getSupportedFrameRates().getUpper()).toString());
            ((JSONObject)localObject).put("fr_min", ((Integer)localVideoCapabilities.getSupportedFrameRates().getLower()).toString());
            return localObject;
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getMediaCodecCapabilities ERROR = " + localJSONException.getMessage());
            continue;
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getMediaCodecCapabilities ERROR = " + localThrowable.getMessage());
        }
      }
      label388:
      j += 1;
      continue;
      label395:
      i += 1;
    }
  }
  
  private static void a()
  {
    if (beav.a().a()) {
      if (bdin.b(BaseApplicationImpl.getApplication()) == 0) {
        beav.a().a(new raf(), false);
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
  private static JSONObject c()
  {
    // Byte code:
    //   0: new 301	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 352	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_1
    //   11: ldc_w 462
    //   14: invokestatic 466	bdgk:a	()Ljava/lang/String;
    //   17: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ldc_w 468
    //   27: invokestatic 470	bdgk:b	()Ljava/lang/String;
    //   30: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: ldc_w 472
    //   40: invokestatic 475	bdgk:a	()J
    //   43: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: ldc_w 480
    //   53: invokestatic 482	bdgk:b	()I
    //   56: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_1
    //   61: astore_2
    //   62: aload_1
    //   63: ldc_w 484
    //   66: invokestatic 486	bdgk:a	()I
    //   69: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: ldc_w 488
    //   79: invokestatic 490	bdgk:d	()Ljava/lang/String;
    //   82: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: ldc_w 492
    //   92: invokestatic 494	bdgk:e	()Ljava/lang/String;
    //   95: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_1
    //   100: astore_2
    //   101: aload_1
    //   102: ldc_w 496
    //   105: invokestatic 499	bdgk:h	()Ljava/lang/String;
    //   108: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_1
    //   113: astore_2
    //   114: aload_1
    //   115: ldc_w 501
    //   118: getstatic 506	android/os/Build$VERSION:SDK_INT	I
    //   121: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_1
    //   126: astore_2
    //   127: aload_1
    //   128: ldc_w 508
    //   131: invokestatic 510	bdgk:c	()Ljava/lang/String;
    //   134: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: ldc_w 512
    //   144: invokestatic 514	bdgk:d	()J
    //   147: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_1
    //   152: astore_2
    //   153: aload_1
    //   154: ldc_w 516
    //   157: invokestatic 518	bdgk:e	()J
    //   160: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: astore_2
    //   166: invokestatic 521	bdgk:a	()[J
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_1
    //   173: ldc_w 523
    //   176: aload_3
    //   177: iconst_0
    //   178: laload
    //   179: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload_1
    //   184: astore_2
    //   185: aload_1
    //   186: ldc_w 525
    //   189: aload_3
    //   190: iconst_1
    //   191: laload
    //   192: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_1
    //   197: astore_2
    //   198: aload_1
    //   199: ldc_w 527
    //   202: iconst_1
    //   203: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_1
    //   208: astore_2
    //   209: invokestatic 528	rae:a	()Ljava/lang/String;
    //   212: astore_3
    //   213: aload_1
    //   214: astore_2
    //   215: aload_1
    //   216: ldc_w 530
    //   219: aload_3
    //   220: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: ldc_w 532
    //   230: aload_3
    //   231: invokestatic 534	rae:a	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload_1
    //   239: astore_2
    //   240: getstatic 35	rae:jdField_a_of_type_Int	I
    //   243: iconst_m1
    //   244: if_icmpne +47 -> 291
    //   247: iconst_0
    //   248: istore_0
    //   249: aload_1
    //   250: astore_2
    //   251: aload_1
    //   252: ldc_w 536
    //   255: iload_0
    //   256: invokevirtual 398	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload_1
    //   261: astore_2
    //   262: aload_1
    //   263: ldc_w 538
    //   266: invokestatic 540	rae:a	()F
    //   269: invokestatic 543	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   272: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   275: pop
    //   276: aload_1
    //   277: astore_2
    //   278: aload_1
    //   279: ldc_w 545
    //   282: invokestatic 547	rae:a	()Lorg/json/JSONObject;
    //   285: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload_1
    //   290: areturn
    //   291: aload_1
    //   292: astore_2
    //   293: getstatic 35	rae:jdField_a_of_type_Int	I
    //   296: istore_0
    //   297: goto -48 -> 249
    //   300: astore_3
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: astore_2
    //   305: invokestatic 415	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +47 -> 355
    //   311: aload_1
    //   312: astore_2
    //   313: getstatic 33	rae:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   316: iconst_2
    //   317: new 13	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 549
    //   327: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_3
    //   331: invokevirtual 425	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_1
    //   344: areturn
    //   345: astore_1
    //   346: aload_2
    //   347: areturn
    //   348: astore_1
    //   349: aconst_null
    //   350: areturn
    //   351: astore_3
    //   352: goto -49 -> 303
    //   355: aload_1
    //   356: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   248	49	0	i	int
    //   7	337	1	localJSONObject1	JSONObject
    //   345	1	1	localObject1	Object
    //   348	8	1	localJSONObject2	JSONObject
    //   9	338	2	localJSONObject3	JSONObject
    //   169	62	3	localObject2	Object
    //   300	31	3	localThrowable1	Throwable
    //   351	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	300	java/lang/Throwable
    //   10	21	345	finally
    //   23	34	345	finally
    //   36	47	345	finally
    //   49	60	345	finally
    //   62	73	345	finally
    //   75	86	345	finally
    //   88	99	345	finally
    //   101	112	345	finally
    //   114	125	345	finally
    //   127	138	345	finally
    //   140	151	345	finally
    //   153	164	345	finally
    //   166	170	345	finally
    //   172	183	345	finally
    //   185	196	345	finally
    //   198	207	345	finally
    //   209	213	345	finally
    //   215	224	345	finally
    //   226	238	345	finally
    //   240	247	345	finally
    //   251	260	345	finally
    //   262	276	345	finally
    //   278	289	345	finally
    //   293	297	345	finally
    //   305	311	345	finally
    //   313	343	345	finally
    //   0	8	348	finally
    //   10	21	351	java/lang/Throwable
    //   23	34	351	java/lang/Throwable
    //   36	47	351	java/lang/Throwable
    //   49	60	351	java/lang/Throwable
    //   62	73	351	java/lang/Throwable
    //   75	86	351	java/lang/Throwable
    //   88	99	351	java/lang/Throwable
    //   101	112	351	java/lang/Throwable
    //   114	125	351	java/lang/Throwable
    //   127	138	351	java/lang/Throwable
    //   140	151	351	java/lang/Throwable
    //   153	164	351	java/lang/Throwable
    //   166	170	351	java/lang/Throwable
    //   172	183	351	java/lang/Throwable
    //   185	196	351	java/lang/Throwable
    //   198	207	351	java/lang/Throwable
    //   209	213	351	java/lang/Throwable
    //   215	224	351	java/lang/Throwable
    //   226	238	351	java/lang/Throwable
    //   240	247	351	java/lang/Throwable
    //   251	260	351	java/lang/Throwable
    //   262	276	351	java/lang/Throwable
    //   278	289	351	java/lang/Throwable
    //   293	297	351	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rae
 * JD-Core Version:    0.7.0.1
 */