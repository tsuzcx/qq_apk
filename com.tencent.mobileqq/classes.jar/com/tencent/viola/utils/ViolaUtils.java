package com.tencent.viola.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaUtils
{
  public static final String DEFAULT_CHARSET = Charset.defaultCharset().name();
  private static final int HUNDRED = 100;
  public static final char PERCENT = '%';
  private static final String TAG = "ViolaUtils";
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  
  public static void addViewParentToView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    if ((paramViewGroup == null) || (paramView == null)) {}
    while (!(paramView.getParent() instanceof ViewGroup)) {
      return;
    }
    paramView = (ViewGroup)paramView.getParent();
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    paramViewGroup.addView(paramView, paramInt);
  }
  
  /* Error */
  public static String bitmapToBase64(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +237 -> 242
    //   8: new 66	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 67	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 73	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: aload_2
    //   25: invokevirtual 79	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   28: pop
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 89	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: iconst_0
    //   48: invokestatic 95	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   51: astore_0
    //   52: aload_0
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +13 -> 68
    //   58: aload_2
    //   59: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   62: aload_2
    //   63: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   66: aload_0
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: astore_1
    //   71: ldc 15
    //   73: bipush 6
    //   75: new 97	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   82: ldc 100
    //   84: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: ldc 15
    //   109: bipush 6
    //   111: new 97	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   118: ldc 116
    //   120: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_3
    //   137: astore_1
    //   138: aload_2
    //   139: ifnull -71 -> 68
    //   142: aload_2
    //   143: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   146: aload_2
    //   147: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: ldc 15
    //   155: bipush 6
    //   157: new 97	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   164: ldc 100
    //   166: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +11 -> 199
    //   191: aload_1
    //   192: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   195: aload_1
    //   196: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   199: aload_0
    //   200: athrow
    //   201: astore_1
    //   202: ldc 15
    //   204: bipush 6
    //   206: new 97	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   213: ldc 100
    //   215: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   222: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: goto -32 -> 199
    //   234: astore_0
    //   235: goto -48 -> 187
    //   238: astore_0
    //   239: goto -134 -> 105
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_1
    //   245: astore_0
    //   246: goto -194 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramBitmap	Bitmap
    //   3	66	1	localObject1	Object
    //   70	18	1	localException1	Exception
    //   106	90	1	localObject2	Object
    //   201	44	1	localException2	Exception
    //   15	229	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	136	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   58	66	70	java/lang/Exception
    //   8	16	102	java/lang/Exception
    //   142	150	152	java/lang/Exception
    //   8	16	184	finally
    //   191	199	201	java/lang/Exception
    //   18	29	234	finally
    //   31	35	234	finally
    //   37	41	234	finally
    //   43	52	234	finally
    //   107	136	234	finally
    //   18	29	238	java/lang/Exception
    //   31	35	238	java/lang/Exception
    //   37	41	238	java/lang/Exception
    //   43	52	238	java/lang/Exception
  }
  
  public static HashMap<String, String> copyMap(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  public static JSONObject deepMergeJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        Iterator localIterator = paramJSONObject1.keys();
        localObject1 = paramJSONObject2;
        if (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          localObject2 = paramJSONObject1.get((String)localObject1);
          if (!paramJSONObject2.has((String)localObject1)) {
            paramJSONObject2.put((String)localObject1, localObject2);
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (JSONException paramJSONObject1)
      {
        ViolaLogUtils.e("ViolaUtils", "deepMergeJSON e :" + paramJSONObject1.getMessage());
        localObject1 = null;
      }
      if ((localObject2 instanceof JSONObject)) {
        deepMergeJSON((JSONObject)localObject2, paramJSONObject2.getJSONObject((String)localObject1));
      } else {
        paramJSONObject2.put((String)localObject1, localObject2);
      }
    }
  }
  
  public static String encode(char[] paramArrayOfChar)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayOfChar.length;
    int k = 0;
    if (k < m)
    {
      int i = paramArrayOfChar[k];
      if (i < 256)
      {
        localStringBuilder.append(i);
        j += 1;
      }
      for (;;)
      {
        k += 1;
        break;
        localStringBuilder.append("\\u");
        localStringBuilder.append(Character.forDigit(i >>> 12 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i >>> 8 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i >>> 4 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i & 0xF, 16));
        j += 5;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static float fastGetFloat(String paramString)
  {
    return fastGetFloat(paramString, 2147483647);
  }
  
  public static float fastGetFloat(String paramString, int paramInt)
  {
    int j = 1;
    int m = 0;
    String str;
    float f1;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.endsWith("%"))
      {
        str = paramString.substring(0, paramString.indexOf("%"));
        try
        {
          f1 = Float.parseFloat(str);
          f1 /= 100.0F;
          return f1;
        }
        catch (NumberFormatException paramString)
        {
          ViolaLogUtils.e("ViolaUtils", "fastGetFloat NumberFormatException  % e:" + paramString.getMessage());
        }
      }
      if (str.charAt(0) == '-') {
        i = 0;
      }
    }
    for (;;)
    {
      f1 = 0.0F;
      int k;
      for (;;)
      {
        if (j < str.length())
        {
          k = str.charAt(j);
          if ((k >= 48) && (k <= 57))
          {
            f1 = f1 * 10.0F + k - 48.0F;
            j += 1;
            continue;
            if (str.charAt(0) != '+') {
              break label318;
            }
            i = 1;
            break;
          }
        }
      }
      float f2 = f1;
      if (j < str.length())
      {
        if (str.charAt(j) == '.')
        {
          k = j + 1;
          int n = 10;
          j = m;
          m = n;
          while ((k < str.length()) && (j < paramInt))
          {
            n = str.charAt(k);
            if ((n < 48) || (n > 57)) {
              break;
            }
            f1 += (n - 48) / m;
            m *= 10;
            k += 1;
            j += 1;
          }
          f2 = f1;
        }
      }
      else
      {
        f1 = f2;
        if (i != 0) {
          break;
        }
        return f2 * -1.0F;
      }
      throw new NumberFormatException("Illegal separator");
      throw new NumberFormatException("NullNumber");
      label318:
      i = 1;
      j = 0;
    }
  }
  
  public static void fastblur(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    int i12 = paramBitmap.getWidth();
    int i13 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i12 * i13];
    paramBitmap.getPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
    int i11 = i12 - 1;
    int i14 = i13 - 1;
    int i = i12 * i13;
    int i15 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i12, i13)];
    i = i15 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    int i17 = arrayOfInt6.length;
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i15, 3 });
    int i16 = paramInt + 1;
    int i7 = 0;
    i = 0;
    int i6 = 0;
    int i8;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int k;
    int i9;
    int[] arrayOfInt7;
    int i10;
    for (;;)
    {
      if (i6 >= i13) {
        break label743;
      }
      j = 0;
      i8 = -paramInt;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i11, Math.max(i8, 0)) + i)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i16 - Math.abs(i8);
        i5 += arrayOfInt7[0] * i9;
        i4 += arrayOfInt7[1] * i9;
        i3 += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i8 = i4;
      i10 = 0;
      i4 = paramInt;
      i9 = i5;
      i5 = i3;
      i3 = i10;
      for (;;)
      {
        if (i3 >= i12) {
          break label727;
        }
        if ((i9 >= i17) || (i8 >= i17) || (i5 >= i17)) {
          break;
        }
        arrayOfInt2[i] = arrayOfInt6[i9];
        arrayOfInt3[i] = arrayOfInt6[i8];
        arrayOfInt4[i] = arrayOfInt6[i5];
        arrayOfInt7 = arrayOfInt[((i4 - paramInt + i15) % i15)];
        int i19 = arrayOfInt7[0];
        int i18 = arrayOfInt7[1];
        i10 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[i3] = Math.min(i3 + paramInt + 1, i11);
        }
        int i20 = arrayOfInt1[(arrayOfInt5[i3] + i7)];
        arrayOfInt7[0] = ((0xFF0000 & i20) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i20) >> 8);
        arrayOfInt7[2] = (i20 & 0xFF);
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i9 = i9 - i2 + m;
        i8 = i8 - i1 + k;
        i5 = i5 - n + j;
        i4 = (i4 + 1) % i15;
        arrayOfInt7 = arrayOfInt[(i4 % i15)];
        i2 = i2 - i19 + arrayOfInt7[0];
        i1 = i1 - i18 + arrayOfInt7[1];
        n = n - i10 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i += 1;
        i3 += 1;
      }
      label727:
      i7 += i12;
      i6 += 1;
    }
    label743:
    i = 0;
    while (i < i12)
    {
      i5 = 0;
      i7 = -paramInt * i12;
      i6 = -paramInt;
      i3 = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      j = 0;
      m = 0;
      k = 0;
      i4 = 0;
      if (i6 <= paramInt)
      {
        i8 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i8];
        arrayOfInt7[1] = arrayOfInt3[i8];
        arrayOfInt7[2] = arrayOfInt4[i8];
        i9 = i16 - Math.abs(i6);
        i10 = arrayOfInt2[i8];
        i11 = arrayOfInt3[i8];
        i17 = arrayOfInt4[i8];
        if (i6 > 0)
        {
          i3 += arrayOfInt7[0];
          i4 += arrayOfInt7[1];
          i5 += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 = i7;
          if (i6 < i14) {
            i8 = i7 + i12;
          }
          i6 += 1;
          j = i17 * i9 + j;
          m = i11 * i9 + m;
          k = i10 * i9 + k;
          i7 = i8;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i9 = m;
      i10 = k;
      i11 = 0;
      k = i;
      i6 = i5;
      i7 = i4;
      i8 = i3;
      m = n;
      n = i1;
      i1 = i2;
      i2 = paramInt;
      i5 = i10;
      i4 = i9;
      i3 = j;
      j = i11;
      while (j < i13)
      {
        arrayOfInt1[k] = (0xFF000000 | arrayOfInt6[i5] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i2 - paramInt + i15) % i15)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[j] = (Math.min(j + i16, i14) * i12);
        }
        i17 = arrayOfInt5[j] + i;
        arrayOfInt7[0] = arrayOfInt2[i17];
        arrayOfInt7[1] = arrayOfInt3[i17];
        arrayOfInt7[2] = arrayOfInt4[i17];
        i8 += arrayOfInt7[0];
        i7 += arrayOfInt7[1];
        i6 += arrayOfInt7[2];
        i5 = i5 - i1 + i8;
        i4 = i4 - n + i7;
        i3 = i3 - m + i6;
        i2 = (i2 + 1) % i15;
        arrayOfInt7 = arrayOfInt[i2];
        i1 = i1 - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        m = m - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i7 -= arrayOfInt7[1];
        i6 -= arrayOfInt7[2];
        k += i12;
        j += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
  }
  
  public static int fetchFromSparseArray(@Nullable SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    if (paramSparseIntArray == null) {
      return paramInt2;
    }
    return paramSparseIntArray.get(paramInt1, paramSparseIntArray.get(0));
  }
  
  public static VComponent findComponent(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      paramString1 = ViolaSDKManager.getInstance().getDomManager().getDomContext(paramString1);
    } while (paramString1 == null);
    return paramString1.getComponent(paramString2);
  }
  
  public static DomObject findDomObject(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      paramString1 = ViolaSDKManager.getInstance().getDomManager().getDomContext(paramString1);
    } while (paramString1 == null);
    return paramString1.getDomByRef(paramString2);
  }
  
  public static void fireContentSizeChange(DomObject paramDomObject, float paramFloat1, float paramFloat2)
  {
    if (paramDomObject == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject2.put("width", FlexConvertUtils.px2dip(paramFloat1) + "dp");
      localJSONObject2.put("height", FlexConvertUtils.px2dip(paramFloat2) + "dp");
      localJSONObject1.put("contentSize", localJSONObject2);
      localJSONObject3.put("width", FlexConvertUtils.px2dip(paramDomObject.getLayoutWidth()) + "dp");
      localJSONObject3.put("height", FlexConvertUtils.px2dip(paramDomObject.getLayoutHeight()) + "dp");
      localJSONObject3.put("x", FlexConvertUtils.px2dip(paramDomObject.getLayoutX()) + "dp");
      localJSONObject3.put("y", FlexConvertUtils.px2dip(paramDomObject.getLayoutX()) + "dp");
      localJSONObject1.put("frame", localJSONObject3);
      paramDomObject.fireEvent("contentSizeChanged", localJSONObject1);
      return;
    }
    catch (JSONException paramDomObject)
    {
      ViolaLogUtils.d("ViolaUtils", "fireContentSizeChange error: " + paramDomObject.getMessage());
    }
  }
  
  public static boolean getBoolean(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject instanceof Boolean)) {
      bool1 = ((Boolean)paramObject).booleanValue();
    }
    do
    {
      do
      {
        return bool1;
        if (!(paramObject instanceof String)) {
          break;
        }
        bool1 = bool2;
      } while ("true".equals(paramObject));
      bool1 = bool2;
    } while (getInt(paramObject, 0) != 0);
    return false;
  }
  
  @Nullable
  public static BorderDrawable getBorderDrawable(@NonNull View paramView)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof BorderDrawable)) {
      return (BorderDrawable)paramView;
    }
    if (((paramView instanceof LayerDrawable)) && (((LayerDrawable)paramView).getNumberOfLayers() > 1))
    {
      paramView = ((LayerDrawable)paramView).getDrawable(0);
      if ((paramView instanceof BorderDrawable)) {
        return (BorderDrawable)paramView;
      }
    }
    return null;
  }
  
  @Nullable
  public static BorderDrawable getBorderDrawable(@NonNull VComponent paramVComponent)
  {
    Object localObject = getBorderDrawable(paramVComponent.getHostView());
    if (localObject != null) {}
    BorderDrawable localBorderDrawable;
    do
    {
      return localObject;
      localBorderDrawable = paramVComponent.getOrCreateBorder();
      localObject = localBorderDrawable;
    } while (localBorderDrawable == null);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramVComponent.getHostView().setBackground(localBorderDrawable);
      return localBorderDrawable;
    }
    paramVComponent.getHostView().setBackgroundDrawable(localBorderDrawable);
    return localBorderDrawable;
  }
  
  public static int getColor(String paramString)
  {
    return ColorParseUtils.parseColor(paramString);
  }
  
  public static DOMActionContext getDomActionContext(String paramString)
  {
    return ViolaSDKManager.getInstance().getDomManager().getDomContext(paramString);
  }
  
  public static double getDouble(Object paramObject)
  {
    if (paramObject == null) {
      return 0.0D;
    }
    String str = paramObject.toString().trim();
    double d;
    if (str.endsWith("px")) {
      try
      {
        d = Double.parseDouble(str);
        return d;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return 0.0D;
      }
      catch (Exception localException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return 0.0D;
      }
    }
    if (localException1.endsWith("px")) {
      try
      {
        d = Double.parseDouble(localException1.substring(0, localException1.indexOf("px")));
        return d;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return 0.0D;
      }
      catch (Exception localException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return 0.0D;
      }
    }
    try
    {
      d = Double.parseDouble(localException2);
      return d;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
      return 0.0D;
    }
    catch (Exception localException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
    }
    return 0.0D;
  }
  
  public static String getFileWithExtensionFromUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('#');
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      i = str.lastIndexOf('?');
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      i = paramString.lastIndexOf('/');
      str = paramString;
      if (i >= 0) {
        str = paramString.substring(i + 1);
      }
      if (!str.isEmpty()) {
        return str;
      }
    }
    return "";
  }
  
  public static float getFloat(Object paramObject)
  {
    return getFloat(paramObject, Float.valueOf((0.0F / 0.0F)));
  }
  
  public static float getFloat(Object paramObject, @NonNull Float paramFloat)
  {
    if (paramObject == null) {
      return paramFloat.floatValue();
    }
    String str = paramObject.toString().trim();
    if (("auto".equals(str)) || ("undefined".equals(str)) || (TextUtils.isEmpty(str))) {
      return paramFloat.floatValue();
    }
    if (str.endsWith("px")) {}
    for (;;)
    {
      float f;
      try
      {
        f = Float.parseFloat(str.substring(0, str.indexOf("px")));
        return f;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return paramFloat.floatValue();
      }
      catch (Exception localException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        continue;
      }
      if (localException1.endsWith("dp")) {
        try
        {
          int i = FlexConvertUtils.dip2px(Float.parseFloat(localException1.substring(0, localException1.indexOf("dp"))));
          return i;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        }
        catch (Exception localException2)
        {
          ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        }
      } else {
        try
        {
          f = Float.parseFloat(localException2);
          return f;
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        }
        catch (Exception localException3)
        {
          ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        }
      }
    }
  }
  
  public static float getFloatCompactWithPercent(Object paramObject, float paramFloat)
  {
    if (paramObject == null) {
      return (int)paramFloat;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject.endsWith("%")) {
        return (int)(fastGetFloat(paramObject) * paramFloat);
      }
      return (int)getFloat(paramObject);
    }
    return (int)getFloat(paramObject);
  }
  
  public static float getFloatSafely(float paramFloat)
  {
    float f = paramFloat;
    if (Float.isNaN(paramFloat)) {
      f = 0.0F;
    }
    return f;
  }
  
  public static int getInt(Object paramObject)
  {
    return getInt(paramObject, 0);
  }
  
  public static int getInt(Object paramObject, @Nullable int paramInt)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return paramInt;
      str = paramObject.toString().trim();
    } while (("auto".equals(str)) || ("undefined".equals(str)) || (TextUtils.isEmpty(str)));
    int i;
    if (str.endsWith("px")) {
      try
      {
        i = Integer.parseInt(str.substring(0, str.indexOf("px")));
        return i;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return paramInt;
      }
      catch (Exception localException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return paramInt;
      }
    }
    if (localException1.endsWith("dp")) {
      try
      {
        i = FlexConvertUtils.dip2px(Integer.parseInt(localException1.substring(0, localException1.indexOf("dp"))));
        return i;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return paramInt;
      }
    }
    try
    {
      i = Integer.parseInt(localException2);
      return i;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
      return paramInt;
    }
    catch (Exception localException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
    }
    return paramInt;
  }
  
  public static float getLayoutPositionInList(String paramString1, String paramString2, boolean paramBoolean)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    paramString1 = findDomObject(paramString1, paramString2);
    if (paramString1 == null) {
      f1 = f2;
    }
    do
    {
      return f1;
      f2 = 0.0F;
      if ((paramString1 != null) && (!paramString1.getType().equals("list")))
      {
        if (paramBoolean) {
          f1 += paramString1.getLayoutY();
        }
        for (;;)
        {
          paramString1 = paramString1.getDomParent();
          break;
          f2 += paramString1.getLayoutX();
        }
      }
    } while (paramBoolean);
    return f2;
  }
  
  public static float getLayoutXInList(String paramString1, String paramString2)
  {
    return getLayoutPositionInList(paramString1, paramString2, false);
  }
  
  public static float getLayoutYInList(String paramString1, String paramString2)
  {
    return getLayoutPositionInList(paramString1, paramString2, true);
  }
  
  public static float getListContentHeight(DomObject paramDomObject)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramDomObject == null) {
      return f2;
    }
    if ("horizontal".equals(paramDomObject.getAttributes().get("direction"))) {
      return paramDomObject.getLayoutHeight();
    }
    int j = paramDomObject.getDomChildCount();
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= j) {
        break;
      }
      DomObject localDomObject = paramDomObject.getChild(i);
      f2 = f1;
      if (localDomObject == null) {
        break;
      }
      f2 = localDomObject.getLayoutHeight();
      i += 1;
      f1 = f2 + f1;
    }
  }
  
  public static float getListContentWidth(DomObject paramDomObject)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramDomObject == null) {
      return f2;
    }
    if (!"horizontal".equals(paramDomObject.getAttributes().get("direction"))) {
      return paramDomObject.getLayoutWidth();
    }
    int j = paramDomObject.getDomChildCount();
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= j) {
        break;
      }
      DomObject localDomObject = paramDomObject.getChild(i);
      f2 = f1;
      if (localDomObject == null) {
        break;
      }
      f2 = localDomObject.getLayoutWidth();
      i += 1;
      f1 = f2 + f1;
    }
  }
  
  public static long getLong(Object paramObject)
  {
    if (paramObject == null) {
      return 0L;
    }
    String str = paramObject.toString().trim();
    long l;
    if (str.endsWith("px")) {
      try
      {
        l = Long.parseLong(str);
        return l;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return 0L;
      }
      catch (Exception localException1)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return 0L;
      }
    }
    if (localException1.endsWith("dp")) {
      try
      {
        int i = FlexConvertUtils.dip2px((float)Long.parseLong(localException1.substring(0, localException1.indexOf("dp"))));
        return i;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
        return 0L;
      }
      catch (Exception localException2)
      {
        ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(localException2);
      return l;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument format error! value is " + paramObject);
      return 0L;
    }
    catch (Exception localException3)
    {
      ViolaLogUtils.e("ViolaUtils", "Argument error! value is " + paramObject);
    }
    return 0L;
  }
  
  public static int getOpacityFromColor(int paramInt)
  {
    paramInt >>>= 24;
    if (paramInt == 255) {
      return -1;
    }
    if (paramInt == 0) {
      return -2;
    }
    return -3;
  }
  
  public static String getPageName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.contains("v_tid")) && (paramString.contains("v_bundleName")))
      {
        String str = Uri.parse(paramString).getQueryParameter("v_tid");
        paramString = Uri.parse(paramString).getQueryParameter("v_bundleName");
        return str + "_" + paramString;
      }
      if (paramString.indexOf(".js") != -1)
      {
        paramString = paramString.split("\\.js")[0].split("/");
        if ((paramString != null) && (paramString.length >= 1)) {
          return paramString[(paramString.length - 1)];
        }
      }
    }
    return null;
  }
  
  public static int getScreenOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  public static String getString(@Nullable Object paramObject, @Nullable String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    if ((paramObject instanceof String)) {}
    for (paramObject = (String)paramObject;; paramObject = paramObject.toString()) {
      return paramObject;
    }
  }
  
  public static boolean isSystemAutoRotateOpen(Context paramContext)
  {
    boolean bool = true;
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (i == 0) {
        bool = false;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      ViolaLogUtils.e("ViolaUtils", "initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=" + paramContext.getMessage());
    }
    return true;
  }
  
  public static boolean isUTF8(String paramString)
  {
    try
    {
      paramString.getBytes("utf-8");
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isUiThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static boolean isUndefined(float paramFloat)
  {
    return Float.isNaN(paramFloat);
  }
  
  public static Map json2HashMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramJSONObject.keys();
        Object localObject;
        for (;;)
        {
          localObject = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next().toString();
          localHashMap.put(localObject, paramJSONObject.get((String)localObject));
        }
        return localObject;
      }
      catch (JSONException paramJSONObject)
      {
        localObject = null;
      }
    }
    return null;
  }
  
  public static void log(String paramString1, int paramInt, String paramString2)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      Log.d(paramString1, paramString2);
      return;
    case 6: 
      Log.e(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static int multiplyColorAlpha(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255) {
      return paramInt1;
    }
    if (paramInt2 == 0) {
      return paramInt1 & 0xFFFFFF;
    }
    return ((paramInt2 >> 7) + paramInt2) * (paramInt1 >>> 24) >> 8 << 24 | paramInt1 & 0xFFFFFF;
  }
  
  private static int parsePercent(String paramString, int paramInt)
  {
    return (int)(Float.parseFloat(paramString) / 100.0F * paramInt);
  }
  
  public static int parseUnitOrPercent(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf('%');
    if (i != -1) {
      return parsePercent(paramString.substring(0, i), paramInt);
    }
    return Integer.parseInt(paramString);
  }
  
  /* Error */
  public static String readAssetsFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokevirtual 689	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 695	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: new 697	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 700	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore_3
    //   23: new 702	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 703	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 6
    //   33: aload_3
    //   34: astore 5
    //   36: aload 6
    //   38: astore 4
    //   40: aload_0
    //   41: invokevirtual 708	java/io/InputStream:available	()I
    //   44: istore_2
    //   45: iload_2
    //   46: sipush 12288
    //   49: if_icmple +234 -> 283
    //   52: aload_3
    //   53: astore 5
    //   55: aload 6
    //   57: astore 4
    //   59: sipush 4096
    //   62: newarray char
    //   64: astore_0
    //   65: aload_3
    //   66: astore 5
    //   68: aload 6
    //   70: astore 4
    //   72: new 97	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 12288
    //   79: invokespecial 711	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 8
    //   84: aload_3
    //   85: astore 5
    //   87: aload 6
    //   89: astore 4
    //   91: aload_3
    //   92: aload_0
    //   93: invokevirtual 715	java/io/InputStreamReader:read	([C)I
    //   96: istore_2
    //   97: iconst_m1
    //   98: iload_2
    //   99: if_icmpeq +105 -> 204
    //   102: aload_3
    //   103: astore 5
    //   105: aload 6
    //   107: astore 4
    //   109: aload 8
    //   111: aload_0
    //   112: iconst_0
    //   113: iload_2
    //   114: invokevirtual 718	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: goto -34 -> 84
    //   121: astore 4
    //   123: aload 6
    //   125: astore_0
    //   126: aload 4
    //   128: astore 6
    //   130: aload_3
    //   131: astore 5
    //   133: aload_0
    //   134: astore 4
    //   136: ldc 15
    //   138: bipush 6
    //   140: new 97	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 720
    //   150: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 722
    //   160: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 6
    //   165: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_0
    //   178: ifnull +7 -> 185
    //   181: aload_0
    //   182: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   185: aload 7
    //   187: astore 4
    //   189: aload_3
    //   190: ifnull +11 -> 201
    //   193: aload_3
    //   194: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   197: aload 7
    //   199: astore 4
    //   201: aload 4
    //   203: areturn
    //   204: aload_3
    //   205: astore 5
    //   207: aload 6
    //   209: astore 4
    //   211: aload 8
    //   213: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore_0
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   227: aload_0
    //   228: astore 4
    //   230: aload_3
    //   231: ifnull -30 -> 201
    //   234: aload_3
    //   235: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   238: aload_0
    //   239: areturn
    //   240: astore_3
    //   241: ldc 15
    //   243: bipush 6
    //   245: new 97	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 726
    //   255: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_1
    //   259: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 722
    //   265: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_3
    //   269: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: areturn
    //   283: aload_3
    //   284: astore 5
    //   286: aload 6
    //   288: astore 4
    //   290: iload_2
    //   291: newarray char
    //   293: astore_0
    //   294: aload_3
    //   295: astore 5
    //   297: aload 6
    //   299: astore 4
    //   301: new 169	java/lang/String
    //   304: dup
    //   305: aload_0
    //   306: iconst_0
    //   307: aload_3
    //   308: aload_0
    //   309: invokevirtual 715	java/io/InputStreamReader:read	([C)I
    //   312: invokespecial 729	java/lang/String:<init>	([CII)V
    //   315: astore_0
    //   316: goto -99 -> 217
    //   319: astore 4
    //   321: ldc 15
    //   323: bipush 6
    //   325: new 97	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 726
    //   335: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 722
    //   345: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 4
    //   350: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: goto -135 -> 227
    //   365: astore_0
    //   366: ldc 15
    //   368: bipush 6
    //   370: new 97	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 726
    //   380: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_1
    //   384: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 722
    //   390: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: goto -221 -> 185
    //   409: astore_0
    //   410: ldc 15
    //   412: bipush 6
    //   414: new 97	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 726
    //   424: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 722
    //   434: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_0
    //   438: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   441: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aconst_null
    //   451: areturn
    //   452: astore_0
    //   453: aconst_null
    //   454: astore_3
    //   455: aconst_null
    //   456: astore 4
    //   458: aload 4
    //   460: ifnull +8 -> 468
    //   463: aload 4
    //   465: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   468: aload_3
    //   469: ifnull +7 -> 476
    //   472: aload_3
    //   473: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   476: aload_0
    //   477: athrow
    //   478: astore 4
    //   480: ldc 15
    //   482: bipush 6
    //   484: new 97	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 726
    //   494: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_1
    //   498: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc_w 722
    //   504: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 4
    //   509: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   512: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto -53 -> 468
    //   524: astore_3
    //   525: ldc 15
    //   527: bipush 6
    //   529: new 97	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 726
    //   539: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 722
    //   549: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_3
    //   553: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   556: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: goto -89 -> 476
    //   568: astore_0
    //   569: aconst_null
    //   570: astore 4
    //   572: goto -114 -> 458
    //   575: astore_0
    //   576: aload 5
    //   578: astore_3
    //   579: goto -121 -> 458
    //   582: astore 6
    //   584: aconst_null
    //   585: astore_3
    //   586: aconst_null
    //   587: astore_0
    //   588: goto -458 -> 130
    //   591: astore 6
    //   593: aconst_null
    //   594: astore_0
    //   595: goto -465 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	paramContext	Context
    //   0	598	1	paramString	String
    //   44	247	2	i	int
    //   22	213	3	localInputStreamReader	java.io.InputStreamReader
    //   240	68	3	localException1	Exception
    //   454	19	3	localObject1	Object
    //   524	29	3	localException2	Exception
    //   578	8	3	localObject2	Object
    //   38	70	4	localObject3	Object
    //   121	6	4	localException3	Exception
    //   134	166	4	localObject4	Object
    //   319	30	4	localException4	Exception
    //   456	8	4	localObject5	Object
    //   478	30	4	localException5	Exception
    //   570	1	4	localObject6	Object
    //   34	543	5	localObject7	Object
    //   31	267	6	localObject8	Object
    //   582	1	6	localException6	Exception
    //   591	1	6	localException7	Exception
    //   1	197	7	localObject9	Object
    //   82	130	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	45	121	java/lang/Exception
    //   59	65	121	java/lang/Exception
    //   72	84	121	java/lang/Exception
    //   91	97	121	java/lang/Exception
    //   109	118	121	java/lang/Exception
    //   211	217	121	java/lang/Exception
    //   290	294	121	java/lang/Exception
    //   301	316	121	java/lang/Exception
    //   234	238	240	java/lang/Exception
    //   222	227	319	java/lang/Exception
    //   181	185	365	java/lang/Exception
    //   193	197	409	java/lang/Exception
    //   8	23	452	finally
    //   463	468	478	java/lang/Exception
    //   472	476	524	java/lang/Exception
    //   23	33	568	finally
    //   40	45	575	finally
    //   59	65	575	finally
    //   72	84	575	finally
    //   91	97	575	finally
    //   109	118	575	finally
    //   136	177	575	finally
    //   211	217	575	finally
    //   290	294	575	finally
    //   301	316	575	finally
    //   8	23	582	java/lang/Exception
    //   23	33	591	java/lang/Exception
  }
  
  /* Error */
  public static String readFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload 7
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +23 -> 30
    //   10: aload 7
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 736	java/io/File:exists	()Z
    //   17: ifeq +13 -> 30
    //   20: aload_0
    //   21: invokevirtual 739	java/io/File:canRead	()Z
    //   24: ifne +8 -> 32
    //   27: aload 7
    //   29: astore_3
    //   30: aload_3
    //   31: areturn
    //   32: new 702	java/io/BufferedInputStream
    //   35: dup
    //   36: new 741	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 744	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 703	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_3
    //   48: new 697	java/io/InputStreamReader
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 700	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: astore 6
    //   58: aload 6
    //   60: astore 5
    //   62: aload_3
    //   63: astore 4
    //   65: aload_0
    //   66: invokevirtual 746	java/io/File:length	()J
    //   69: l2i
    //   70: istore_1
    //   71: iload_1
    //   72: sipush 12288
    //   75: if_icmple +280 -> 355
    //   78: aload 6
    //   80: astore 5
    //   82: aload_3
    //   83: astore 4
    //   85: sipush 4096
    //   88: newarray char
    //   90: astore_2
    //   91: aload 6
    //   93: astore 5
    //   95: aload_3
    //   96: astore 4
    //   98: new 97	java/lang/StringBuilder
    //   101: dup
    //   102: sipush 12288
    //   105: invokespecial 711	java/lang/StringBuilder:<init>	(I)V
    //   108: astore 8
    //   110: aload 6
    //   112: astore 5
    //   114: aload_3
    //   115: astore 4
    //   117: aload 6
    //   119: aload_2
    //   120: invokevirtual 715	java/io/InputStreamReader:read	([C)I
    //   123: istore_1
    //   124: iconst_m1
    //   125: iload_1
    //   126: if_icmpeq +148 -> 274
    //   129: aload 6
    //   131: astore 5
    //   133: aload_3
    //   134: astore 4
    //   136: aload 8
    //   138: aload_2
    //   139: iconst_0
    //   140: iload_1
    //   141: invokevirtual 718	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: goto -35 -> 110
    //   148: astore 4
    //   150: aload 6
    //   152: astore_2
    //   153: aload 4
    //   155: astore 6
    //   157: aload_2
    //   158: astore 5
    //   160: aload_3
    //   161: astore 4
    //   163: ldc 15
    //   165: bipush 6
    //   167: new 97	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 720
    //   177: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   184: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 722
    //   190: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 6
    //   195: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   215: aload 7
    //   217: astore_3
    //   218: aload_2
    //   219: ifnull -189 -> 30
    //   222: aload_2
    //   223: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_2
    //   229: ldc 15
    //   231: bipush 6
    //   233: new 97	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 726
    //   243: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   250: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 722
    //   256: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_2
    //   260: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 6
    //   276: astore 5
    //   278: aload_3
    //   279: astore 4
    //   281: aload 8
    //   283: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   295: aload_2
    //   296: astore_3
    //   297: aload 6
    //   299: ifnull -269 -> 30
    //   302: aload 6
    //   304: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   307: aload_2
    //   308: areturn
    //   309: astore_3
    //   310: ldc 15
    //   312: bipush 6
    //   314: new 97	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 726
    //   324: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   331: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 722
    //   337: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_3
    //   341: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload_2
    //   354: areturn
    //   355: aload 6
    //   357: astore 5
    //   359: aload_3
    //   360: astore 4
    //   362: iload_1
    //   363: newarray char
    //   365: astore_2
    //   366: aload 6
    //   368: astore 5
    //   370: aload_3
    //   371: astore 4
    //   373: new 169	java/lang/String
    //   376: dup
    //   377: aload_2
    //   378: iconst_0
    //   379: aload 6
    //   381: aload_2
    //   382: invokevirtual 715	java/io/InputStreamReader:read	([C)I
    //   385: invokespecial 729	java/lang/String:<init>	([CII)V
    //   388: astore_2
    //   389: goto -102 -> 287
    //   392: astore_3
    //   393: ldc 15
    //   395: bipush 6
    //   397: new 97	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 726
    //   407: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   414: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w 722
    //   420: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_3
    //   424: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   427: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: goto -141 -> 295
    //   439: astore_3
    //   440: ldc 15
    //   442: bipush 6
    //   444: new 97	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 726
    //   454: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   461: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 722
    //   467: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_3
    //   471: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: goto -268 -> 215
    //   486: astore_2
    //   487: aconst_null
    //   488: astore 5
    //   490: aconst_null
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokevirtual 723	java/io/BufferedInputStream:close	()V
    //   500: aload 5
    //   502: ifnull +8 -> 510
    //   505: aload 5
    //   507: invokevirtual 724	java/io/InputStreamReader:close	()V
    //   510: aload_2
    //   511: athrow
    //   512: astore_3
    //   513: ldc 15
    //   515: bipush 6
    //   517: new 97	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 726
    //   527: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   534: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 722
    //   540: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_3
    //   544: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: goto -56 -> 500
    //   559: astore_3
    //   560: ldc 15
    //   562: bipush 6
    //   564: new 97	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 726
    //   574: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_0
    //   578: invokevirtual 749	java/io/File:getName	()Ljava/lang/String;
    //   581: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 722
    //   587: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_3
    //   591: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: goto -93 -> 510
    //   606: astore_2
    //   607: aconst_null
    //   608: astore 5
    //   610: goto -118 -> 492
    //   613: astore_2
    //   614: aload 4
    //   616: astore_3
    //   617: goto -125 -> 492
    //   620: astore 6
    //   622: aconst_null
    //   623: astore_2
    //   624: aconst_null
    //   625: astore_3
    //   626: goto -469 -> 157
    //   629: astore 6
    //   631: aconst_null
    //   632: astore_2
    //   633: goto -476 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramFile	java.io.File
    //   70	293	1	i	int
    //   90	133	2	localObject1	Object
    //   228	32	2	localException1	Exception
    //   286	103	2	localObject2	Object
    //   486	25	2	localObject3	Object
    //   606	1	2	localObject4	Object
    //   613	1	2	localObject5	Object
    //   623	10	2	localObject6	Object
    //   5	292	3	localObject7	Object
    //   309	62	3	localException2	Exception
    //   392	32	3	localException3	Exception
    //   439	32	3	localException4	Exception
    //   491	6	3	localObject8	Object
    //   512	32	3	localException5	Exception
    //   559	32	3	localException6	Exception
    //   616	10	3	localObject9	Object
    //   63	72	4	localObject10	Object
    //   148	6	4	localException7	Exception
    //   161	454	4	localObject11	Object
    //   60	549	5	localObject12	Object
    //   56	324	6	localObject13	Object
    //   620	1	6	localException8	Exception
    //   629	1	6	localException9	Exception
    //   1	215	7	localObject14	Object
    //   108	174	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	71	148	java/lang/Exception
    //   85	91	148	java/lang/Exception
    //   98	110	148	java/lang/Exception
    //   117	124	148	java/lang/Exception
    //   136	145	148	java/lang/Exception
    //   281	287	148	java/lang/Exception
    //   362	366	148	java/lang/Exception
    //   373	389	148	java/lang/Exception
    //   222	226	228	java/lang/Exception
    //   302	307	309	java/lang/Exception
    //   291	295	392	java/lang/Exception
    //   211	215	439	java/lang/Exception
    //   32	48	486	finally
    //   496	500	512	java/lang/Exception
    //   505	510	559	java/lang/Exception
    //   48	58	606	finally
    //   65	71	613	finally
    //   85	91	613	finally
    //   98	110	613	finally
    //   117	124	613	finally
    //   136	145	613	finally
    //   163	207	613	finally
    //   281	287	613	finally
    //   362	366	613	finally
    //   373	389	613	finally
    //   32	48	620	java/lang/Exception
    //   48	58	629	java/lang/Exception
  }
  
  public static String splittBodyEncodeUrl(JSONObject paramJSONObject)
  {
    Object localObject2;
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      StringBuffer localStringBuffer = null;
      localObject2 = localStringBuffer;
      if (localIterator.hasNext())
      {
        localObject2 = localStringBuffer;
        for (;;)
        {
          Object localObject1;
          try
          {
            String str1 = (String)localIterator.next();
            localObject2 = localStringBuffer;
            String str2 = paramJSONObject.getString(str1);
            if (localStringBuffer != null) {
              break label126;
            }
            localObject2 = localStringBuffer;
            localStringBuffer = new StringBuffer();
            localObject2 = localStringBuffer;
            localStringBuffer.append(str1);
            localObject2 = localStringBuffer;
            localStringBuffer.append("=");
            localObject2 = localStringBuffer;
            localStringBuffer.append(str2);
          }
          catch (JSONException localJSONException)
          {
            log("ViolaUtils", 6, "splittBodyEncodeUrl error : " + localJSONException.getMessage());
            localObject1 = localObject2;
          }
          break;
          label126:
          localObject2 = localObject1;
          localObject1.append("&");
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    if (localObject2 != null) {
      return ((StringBuffer)localObject2).toString();
    }
    return "";
  }
  
  public static String splittUrlForHttpGet(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = paramString;
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      Object localObject1 = null;
      if (localIterator.hasNext())
      {
        localObject2 = localObject1;
        for (;;)
        {
          try
          {
            str1 = (String)localIterator.next();
            localObject2 = localObject1;
            str2 = paramJSONObject.getString(str1);
            if (localObject1 != null) {
              break label169;
            }
            localObject2 = localObject1;
            localObject1 = new StringBuffer();
          }
          catch (JSONException localJSONException2)
          {
            try
            {
              String str1;
              String str2;
              if ((TextUtils.isEmpty(paramString)) || (paramString.contains("?"))) {
                break label158;
              }
              ((StringBuffer)localObject1).append("?");
              localObject2 = localObject1;
              ((StringBuffer)localObject1).append(str1);
              localObject2 = localObject1;
              ((StringBuffer)localObject1).append("=");
              localObject2 = localObject1;
              ((StringBuffer)localObject1).append(str2);
            }
            catch (JSONException localJSONException1)
            {
              break label125;
            }
            localJSONException2 = localJSONException2;
            localObject1 = localObject2;
            localObject2 = localJSONException2;
          }
          label125:
          log("ViolaUtils", 6, "splittUrlForHttpGet error : " + ((JSONException)localObject2).getMessage());
          break;
          label158:
          ((StringBuffer)localObject1).append("&");
          continue;
          label169:
          localObject2 = localObject1;
          ((StringBuffer)localObject1).append("&");
        }
      }
      localObject2 = paramString;
      if (localObject1 != null) {
        localObject2 = paramString + ((StringBuffer)localObject1).toString();
      }
    }
    return localObject2;
  }
  
  public static void updateSparseArray(@NonNull SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      paramSparseIntArray.put(0, paramInt2);
      paramSparseIntArray.put(2, paramInt2);
      paramSparseIntArray.put(1, paramInt2);
      paramSparseIntArray.put(3, paramInt2);
      paramSparseIntArray.put(4, paramInt2);
      return;
    }
    paramSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat = 8.0F * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * sViscousFluidNormalize;
    }
  }
  
  /* Error */
  public static boolean writeFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 733	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 788	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 6
    //   18: aload 5
    //   20: astore 4
    //   22: aload 7
    //   24: invokevirtual 736	java/io/File:exists	()Z
    //   27: ifne +74 -> 101
    //   30: aload 5
    //   32: astore 4
    //   34: aload 7
    //   36: invokevirtual 791	java/io/File:createNewFile	()Z
    //   39: istore_3
    //   40: iload_3
    //   41: ifne +60 -> 101
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 793	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 794	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: iload_2
    //   57: ireturn
    //   58: astore_0
    //   59: ldc 15
    //   61: bipush 6
    //   63: new 97	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 796
    //   73: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 722
    //   83: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 797	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 5
    //   103: astore 4
    //   105: new 799	java/io/FileOutputStream
    //   108: dup
    //   109: aload 7
    //   111: invokespecial 800	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   114: astore 5
    //   116: aload 5
    //   118: aload_0
    //   119: invokevirtual 802	java/lang/String:getBytes	()[B
    //   122: invokevirtual 806	java/io/FileOutputStream:write	([B)V
    //   125: aload 5
    //   127: invokevirtual 807	java/io/FileOutputStream:flush	()V
    //   130: iconst_1
    //   131: istore_2
    //   132: aload 5
    //   134: ifnull -78 -> 56
    //   137: aload 5
    //   139: invokevirtual 808	java/io/FileOutputStream:close	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_0
    //   145: ldc 15
    //   147: bipush 6
    //   149: new 97	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 796
    //   159: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 722
    //   169: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 797	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iconst_1
    //   186: ireturn
    //   187: astore 5
    //   189: aload 6
    //   191: astore_0
    //   192: aload_0
    //   193: astore 4
    //   195: ldc 15
    //   197: bipush 6
    //   199: new 97	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 810
    //   209: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_1
    //   213: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 722
    //   219: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 5
    //   224: invokevirtual 797	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: ifnull -181 -> 56
    //   240: aload_0
    //   241: invokevirtual 808	java/io/FileOutputStream:close	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: ldc 15
    //   249: bipush 6
    //   251: new 97	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 796
    //   261: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 722
    //   271: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: invokevirtual 797	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: iconst_0
    //   288: ireturn
    //   289: astore_0
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 808	java/io/FileOutputStream:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore 4
    //   304: ldc 15
    //   306: bipush 6
    //   308: new 97	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 796
    //   318: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 722
    //   328: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 4
    //   333: invokevirtual 797	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -45 -> 300
    //   348: astore_0
    //   349: aload 5
    //   351: astore 4
    //   353: goto -63 -> 290
    //   356: astore 4
    //   358: aload 5
    //   360: astore_0
    //   361: aload 4
    //   363: astore 5
    //   365: goto -173 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramString1	String
    //   0	368	1	paramString2	String
    //   1	131	2	bool1	boolean
    //   39	2	3	bool2	boolean
    //   20	276	4	localObject1	Object
    //   302	30	4	localThrowable1	java.lang.Throwable
    //   351	1	4	localThrowable2	java.lang.Throwable
    //   356	6	4	localThrowable3	java.lang.Throwable
    //   13	125	5	localFileOutputStream	java.io.FileOutputStream
    //   187	172	5	localThrowable4	java.lang.Throwable
    //   363	1	5	localObject2	Object
    //   16	174	6	localObject3	Object
    //   10	100	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   48	56	58	java/lang/Throwable
    //   137	142	144	java/lang/Throwable
    //   22	30	187	java/lang/Throwable
    //   34	40	187	java/lang/Throwable
    //   105	116	187	java/lang/Throwable
    //   240	244	246	java/lang/Throwable
    //   22	30	289	finally
    //   34	40	289	finally
    //   105	116	289	finally
    //   195	236	289	finally
    //   295	300	302	java/lang/Throwable
    //   116	130	348	finally
    //   116	130	356	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaUtils
 * JD-Core Version:    0.7.0.1
 */