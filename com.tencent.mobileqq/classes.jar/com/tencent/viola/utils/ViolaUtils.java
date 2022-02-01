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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.viola.commons.AssocioationEvents;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.experiment.IExperimentConfigManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import java.io.File;
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
    if (paramViewGroup != null)
    {
      if (paramView == null) {
        return;
      }
      if ((paramView.getParent() instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView.getParent();
        if ((paramView.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramView.getParent()).removeView(paramView);
        }
        paramViewGroup.addView(paramView, paramInt);
      }
    }
  }
  
  /* Error */
  public static String bitmapToBase64(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +218 -> 221
    //   6: new 66	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 67	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 73	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: aload_2
    //   23: invokevirtual 79	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 89	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: iconst_0
    //   46: invokestatic 95	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto +171 -> 223
    //   55: astore_0
    //   56: goto +112 -> 168
    //   59: astore_0
    //   60: goto +12 -> 72
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: goto +102 -> 168
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_1
    //   74: new 97	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   81: astore_3
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: ldc 100
    //   87: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: aload_0
    //   95: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: astore_1
    //   104: ldc 15
    //   106: bipush 6
    //   108: aload_3
    //   109: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_2
    //   116: ifnull +50 -> 166
    //   119: aload_2
    //   120: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   123: aload_2
    //   124: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   127: goto +39 -> 166
    //   130: astore_0
    //   131: new 97	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   138: astore_1
    //   139: aload_1
    //   140: ldc 116
    //   142: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: aload_0
    //   148: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 15
    //   157: bipush 6
    //   159: aload_1
    //   160: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: aload_1
    //   169: ifnull +50 -> 219
    //   172: aload_1
    //   173: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   176: aload_1
    //   177: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +39 -> 219
    //   183: astore_1
    //   184: new 97	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   191: astore_2
    //   192: aload_2
    //   193: ldc 116
    //   195: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 15
    //   210: bipush 6
    //   212: aload_2
    //   213: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: athrow
    //   221: aconst_null
    //   222: astore_0
    //   223: aload_1
    //   224: ifnull +49 -> 273
    //   227: aload_1
    //   228: invokevirtual 82	java/io/ByteArrayOutputStream:flush	()V
    //   231: aload_1
    //   232: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   235: aload_0
    //   236: areturn
    //   237: astore_1
    //   238: new 97	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   245: astore_2
    //   246: aload_2
    //   247: ldc 116
    //   249: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_2
    //   254: aload_1
    //   255: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: ldc 15
    //   264: bipush 6
    //   266: aload_2
    //   267: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_0
    //   274: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramBitmap	Bitmap
    //   1	176	1	localObject1	Object
    //   183	49	1	localException1	Exception
    //   237	18	1	localException2	Exception
    //   13	254	2	localObject2	Object
    //   81	28	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	27	55	finally
    //   29	33	55	finally
    //   35	39	55	finally
    //   41	50	55	finally
    //   74	82	55	finally
    //   84	91	55	finally
    //   93	102	55	finally
    //   104	115	55	finally
    //   16	27	59	java/lang/Exception
    //   29	33	59	java/lang/Exception
    //   35	39	59	java/lang/Exception
    //   41	50	59	java/lang/Exception
    //   6	14	63	finally
    //   6	14	69	java/lang/Exception
    //   119	127	130	java/lang/Exception
    //   172	180	183	java/lang/Exception
    //   227	235	237	java/lang/Exception
  }
  
  public static void bringIndexToRootView(VComponent paramVComponent, VComponentContainer paramVComponentContainer)
  {
    if ((paramVComponent != null) && (paramVComponentContainer != null) && (paramVComponent.mHost != null))
    {
      if (paramVComponentContainer.mHost == null) {
        return;
      }
      if (paramVComponent.mDomObj == null) {
        return;
      }
      if (paramVComponentContainer.mDomObj == null) {
        return;
      }
      Object localObject1 = new int[2];
      paramVComponentContainer.mHost.getLocationInWindow((int[])localObject1);
      Object localObject2 = new int[2];
      paramVComponent.mHost.getLocationInWindow((int[])localObject2);
      float f1 = localObject2[0] - localObject1[0];
      float f2 = localObject2[1] - localObject1[1];
      localObject1 = paramVComponent.mHost.getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)f1);
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)f2);
      }
      localObject2 = paramVComponent.getParent();
      if (localObject2 != null) {
        ((VComponentContainer)localObject2).remove(paramVComponent, false, true);
      }
      paramVComponent.mHost.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramVComponentContainer.addComponentView(paramVComponent, -1);
    }
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
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  public static JSONObject deepMergeJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      Iterator localIterator = paramJSONObject1.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject1.get(str);
        if (!paramJSONObject2.has(str)) {
          paramJSONObject2.put(str, localObject);
        } else if ((localObject instanceof JSONObject)) {
          deepMergeJSON((JSONObject)localObject, paramJSONObject2.getJSONObject(str));
        } else {
          paramJSONObject2.put(str, localObject);
        }
      }
      return paramJSONObject2;
    }
    catch (JSONException paramJSONObject1)
    {
      paramJSONObject2 = new StringBuilder();
      paramJSONObject2.append("deepMergeJSON e :");
      paramJSONObject2.append(paramJSONObject1.getMessage());
      ViolaLogUtils.e("ViolaUtils", paramJSONObject2.toString());
    }
    return null;
  }
  
  public static String encode(char[] paramArrayOfChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfChar.length;
    int j = 0;
    while (j < k)
    {
      int i = paramArrayOfChar[j];
      if (i < 256)
      {
        localStringBuilder.append(i);
      }
      else
      {
        localStringBuilder.append("\\u");
        localStringBuilder.append(Character.forDigit(i >>> 12 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i >>> 8 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i >>> 4 & 0xF, 16));
        localStringBuilder.append(Character.forDigit(i & 0xF, 16));
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static float fastGetFloat(String paramString)
  {
    return fastGetFloat(paramString, 2147483647);
  }
  
  public static float fastGetFloat(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = paramString.endsWith("%");
      int k = 0;
      String str = paramString;
      if (bool)
      {
        str = paramString.substring(0, paramString.indexOf("%"));
        try
        {
          f1 = Float.parseFloat(str);
          return f1 / 100.0F;
        }
        catch (NumberFormatException paramString)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fastGetFloat NumberFormatException  % e:");
          localStringBuilder.append(paramString.getMessage());
          ViolaLogUtils.e("ViolaUtils", localStringBuilder.toString());
        }
      }
      int i;
      int j;
      if (str.charAt(0) == '-')
      {
        i = 1;
        j = 0;
      }
      else
      {
        if (str.charAt(0) == '+') {
          i = 1;
        } else {
          i = 0;
        }
        j = 1;
      }
      float f1 = 0.0F;
      int m;
      while (i < str.length())
      {
        m = str.charAt(i);
        if ((m < 48) || (m > 57)) {
          break;
        }
        f1 = f1 * 10.0F + m - 48.0F;
        i += 1;
      }
      float f2 = f1;
      if (i < str.length())
      {
        if (str.charAt(i) == '.')
        {
          int n = i + 1;
          m = 10;
          i = k;
          k = n;
          for (;;)
          {
            f2 = f1;
            if (k >= str.length()) {
              break;
            }
            f2 = f1;
            if (i >= paramInt) {
              break;
            }
            n = str.charAt(k);
            f2 = f1;
            if (n < 48) {
              break;
            }
            f2 = f1;
            if (n > 57) {
              break;
            }
            f1 += (n - 48) / m;
            m *= 10;
            k += 1;
            i += 1;
          }
        }
        throw new NumberFormatException("Illegal separator");
      }
      f1 = f2;
      if (j == 0) {
        f1 = f2 * -1.0F;
      }
      return f1;
    }
    paramString = new NumberFormatException("NullNumber");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void fastblur(Bitmap paramBitmap, int paramInt)
  {
    int i7 = paramInt;
    if (i7 < 1) {
      return;
    }
    int i19 = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int i = i19 * j;
    int[] arrayOfInt2 = new int[i];
    paramBitmap.getPixels(arrayOfInt2, 0, i19, 0, 0, i19, j);
    int i20 = i19 - 1;
    int k = j - 1;
    int i17 = i7 + i7 + 1;
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    int[] arrayOfInt1 = new int[Math.max(i19, j)];
    i = i17 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    int[] arrayOfInt6 = new int[n];
    int i11 = arrayOfInt6.length;
    i = 0;
    while (i < n)
    {
      arrayOfInt6[i] = (i / m);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i8 = i7 + 1;
    int i10 = 0;
    int i12 = 0;
    int i9 = 0;
    i = k;
    int i13;
    int i6;
    int i5;
    int i4;
    int i1;
    int i2;
    int i3;
    int i14;
    int[] arrayOfInt7;
    int i15;
    int i16;
    while (i10 < j)
    {
      i13 = -i7;
      i6 = 0;
      i5 = 0;
      i4 = 0;
      n = 0;
      m = 0;
      k = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      while (i13 <= i7)
      {
        i14 = arrayOfInt2[(i12 + Math.min(i20, Math.max(i13, 0)))];
        arrayOfInt7 = arrayOfInt[(i13 + i7)];
        arrayOfInt7[0] = ((i14 & 0xFF0000) >> 16);
        arrayOfInt7[1] = ((i14 & 0xFF00) >> 8);
        arrayOfInt7[2] = (i14 & 0xFF);
        i14 = i8 - Math.abs(i13);
        i6 += arrayOfInt7[0] * i14;
        i5 += arrayOfInt7[1] * i14;
        i4 += arrayOfInt7[2] * i14;
        if (i13 > 0)
        {
          i1 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          i3 += arrayOfInt7[2];
        }
        else
        {
          n += arrayOfInt7[0];
          m += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
        i13 += 1;
      }
      i15 = i6;
      int i18 = 0;
      i16 = i7;
      i6 = i3;
      i13 = i2;
      i14 = i1;
      i1 = i16;
      i3 = i5;
      i2 = i4;
      i5 = i15;
      i4 = i18;
      while (i4 < i19) {
        if ((i5 < i11) && (i3 < i11))
        {
          if (i2 >= i11) {
            return;
          }
          arrayOfInt3[i12] = arrayOfInt6[i5];
          arrayOfInt4[i12] = arrayOfInt6[i3];
          arrayOfInt5[i12] = arrayOfInt6[i2];
          arrayOfInt7 = arrayOfInt[((i1 - i7 + i17) % i17)];
          i18 = arrayOfInt7[0];
          i16 = arrayOfInt7[1];
          i15 = arrayOfInt7[2];
          if (i10 == 0) {
            arrayOfInt1[i4] = Math.min(i4 + i7 + 1, i20);
          }
          int i21 = arrayOfInt2[(i9 + arrayOfInt1[i4])];
          arrayOfInt7[0] = ((i21 & 0xFF0000) >> 16);
          arrayOfInt7[1] = ((i21 & 0xFF00) >> 8);
          arrayOfInt7[2] = (i21 & 0xFF);
          i14 += arrayOfInt7[0];
          i13 += arrayOfInt7[1];
          i6 += arrayOfInt7[2];
          i5 = i5 - n + i14;
          i3 = i3 - m + i13;
          i2 = i2 - k + i6;
          i1 = (i1 + 1) % i17;
          arrayOfInt7 = arrayOfInt[(i1 % i17)];
          n = n - i18 + arrayOfInt7[0];
          m = m - i16 + arrayOfInt7[1];
          k = k - i15 + arrayOfInt7[2];
          i14 -= arrayOfInt7[0];
          i13 -= arrayOfInt7[1];
          i6 -= arrayOfInt7[2];
          i12 += 1;
          i4 += 1;
        }
        else
        {
          return;
        }
      }
      i9 += i19;
      i10 += 1;
    }
    i9 = j;
    m = 0;
    j = i;
    k = i17;
    i = m;
    for (;;)
    {
      i10 = paramInt;
      if (i >= i19) {
        break;
      }
      i11 = -i10;
      i12 = i11 * i19;
      i7 = 0;
      i4 = 0;
      i5 = 0;
      i3 = 0;
      i2 = 0;
      i1 = 0;
      i6 = 0;
      m = 0;
      n = 0;
      while (i11 <= i10)
      {
        i14 = Math.max(0, i12) + i;
        arrayOfInt7 = arrayOfInt[(i11 + i10)];
        arrayOfInt7[0] = arrayOfInt3[i14];
        arrayOfInt7[1] = arrayOfInt4[i14];
        arrayOfInt7[2] = arrayOfInt5[i14];
        i15 = i8 - Math.abs(i11);
        i7 += arrayOfInt3[i14] * i15;
        i13 = i4 + arrayOfInt4[i14] * i15;
        i5 += arrayOfInt5[i14] * i15;
        if (i11 > 0)
        {
          i6 += arrayOfInt7[0];
          m += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
        else
        {
          i3 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
        i4 = i12;
        if (i11 < j) {
          i4 = i12 + i19;
        }
        i11 += 1;
        i12 = i4;
        i4 = i13;
      }
      i11 = i;
      i12 = i6;
      i15 = 0;
      i13 = i10;
      i6 = i7;
      i14 = i2;
      i7 = n;
      i10 = m;
      i2 = i13;
      m = i1;
      n = i14;
      i1 = i3;
      i3 = i5;
      i5 = i15;
      while (i5 < i9)
      {
        arrayOfInt2[i11] = (arrayOfInt6[i6] << 16 | 0xFF000000 | arrayOfInt6[i4] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i2 - paramInt + k) % k)];
        i15 = arrayOfInt7[0];
        i14 = arrayOfInt7[1];
        i13 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt1[i5] = (Math.min(i5 + i8, j) * i19);
        }
        i16 = arrayOfInt1[i5] + i;
        arrayOfInt7[0] = arrayOfInt3[i16];
        arrayOfInt7[1] = arrayOfInt4[i16];
        arrayOfInt7[2] = arrayOfInt5[i16];
        i12 += arrayOfInt7[0];
        i10 += arrayOfInt7[1];
        i7 += arrayOfInt7[2];
        i6 = i6 - i1 + i12;
        i4 = i4 - n + i10;
        i3 = i3 - m + i7;
        i2 = (i2 + 1) % k;
        arrayOfInt7 = arrayOfInt[i2];
        i1 = i1 - i15 + arrayOfInt7[0];
        n = n - i14 + arrayOfInt7[1];
        m = m - i13 + arrayOfInt7[2];
        i12 -= arrayOfInt7[0];
        i10 -= arrayOfInt7[1];
        i7 -= arrayOfInt7[2];
        i11 += i19;
        i5 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt2, 0, i19, 0, 0, i19, i9);
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = ViolaSDKManager.getInstance().getDomManager().getDomContext(paramString1);
      if (paramString1 == null) {
        return null;
      }
      return paramString1.getComponent(paramString2);
    }
    return null;
  }
  
  public static DomObject findDomObject(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = ViolaSDKManager.getInstance().getDomManager().getDomContext(paramString1);
      if (paramString1 == null) {
        return null;
      }
      return paramString1.getDomByRef(paramString2);
    }
    return null;
  }
  
  public static void fireContentSizeChange(DomObject paramDomObject, float paramFloat1, float paramFloat2)
  {
    if (paramDomObject == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramFloat1));
      localStringBuilder.append("dp");
      ((JSONObject)localObject2).put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramFloat2));
      localStringBuilder.append("dp");
      ((JSONObject)localObject2).put("height", localStringBuilder.toString());
      ((JSONObject)localObject1).put("contentSize", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramDomObject.getLayoutWidth()));
      ((StringBuilder)localObject2).append("dp");
      localJSONObject.put("width", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramDomObject.getLayoutHeight()));
      ((StringBuilder)localObject2).append("dp");
      localJSONObject.put("height", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramDomObject.getLayoutX()));
      ((StringBuilder)localObject2).append("dp");
      localJSONObject.put("x", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FlexConvertUtils.px2dip(paramDomObject.getLayoutX()));
      ((StringBuilder)localObject2).append("dp");
      localJSONObject.put("y", ((StringBuilder)localObject2).toString());
      ((JSONObject)localObject1).put("frame", localJSONObject);
      paramDomObject.fireEvent("contentSizeChanged", (JSONObject)localObject1);
      return;
    }
    catch (JSONException paramDomObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fireContentSizeChange error: ");
      ((StringBuilder)localObject1).append(paramDomObject.getMessage());
      ViolaLogUtils.d("ViolaUtils", ((StringBuilder)localObject1).toString());
    }
  }
  
  public static boolean getBoolean(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    if (((paramObject instanceof String)) && ("true".equals(paramObject))) {
      return true;
    }
    boolean bool = false;
    if (getInt(paramObject, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public static BorderDrawable getBorderDrawable(@NonNull View paramView)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof BorderDrawable)) {
      return (BorderDrawable)paramView;
    }
    if ((paramView instanceof LayerDrawable))
    {
      paramView = (LayerDrawable)paramView;
      if (paramView.getNumberOfLayers() > 1)
      {
        paramView = paramView.getDrawable(0);
        if ((paramView instanceof BorderDrawable)) {
          return (BorderDrawable)paramView;
        }
      }
    }
    return null;
  }
  
  @Nullable
  public static BorderDrawable getBorderDrawable(@NonNull VComponent paramVComponent)
  {
    BorderDrawable localBorderDrawable = getBorderDrawable(paramVComponent.getHostView());
    if (localBorderDrawable != null) {
      return localBorderDrawable;
    }
    localBorderDrawable = paramVComponent.getOrCreateBorder();
    if (localBorderDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramVComponent.getHostView().setBackground(localBorderDrawable);
        return localBorderDrawable;
      }
      paramVComponent.getHostView().setBackgroundDrawable(localBorderDrawable);
    }
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
    Object localObject = paramObject.toString().trim();
    if (((String)localObject).endsWith("px")) {}
    try
    {
      d = Double.parseDouble((String)localObject);
      return d;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      double d;
      break label64;
    }
    catch (Exception localException1)
    {
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
    label64:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
    if (((String)localObject).endsWith("px")) {}
    try
    {
      d = Double.parseDouble(((String)localObject).substring(0, ((String)localObject).indexOf("px")));
      return d;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label158;
    }
    catch (Exception localException2)
    {
      label125:
      break label125;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
    label158:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
    try
    {
      d = Double.parseDouble((String)localObject);
      return d;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label231;
    }
    catch (Exception localException3)
    {
      label198:
      break label198;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
    label231:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0.0D;
  }
  
  public static float getFaceSize(Object paramObject, float paramFloat)
  {
    if (paramObject == null) {
      return paramFloat;
    }
    String str = paramObject.toString().trim();
    Object localObject = str;
    try
    {
      if (str.endsWith("dp")) {
        localObject = str.substring(0, str.indexOf("dp"));
      }
      float f = Float.parseFloat((String)localObject);
      return f;
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramFloat;
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
    Object localObject = paramObject.toString().trim();
    if (("auto".equals(localObject)) || ("undefined".equals(localObject)) || (TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).endsWith("px"))) {}
    try
    {
      f = Float.parseFloat(((String)localObject).substring(0, ((String)localObject).indexOf("px")));
      return f;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      float f;
      break label120;
    }
    catch (Exception localException1)
    {
      label82:
      break label82;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    break label350;
    label120:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    break label350;
    if (((String)localObject).endsWith("dp")) {}
    try
    {
      int i = FlexConvertUtils.dip2px(Float.parseFloat(((String)localObject).substring(0, ((String)localObject).indexOf("dp"))));
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label231;
    }
    catch (Exception localException2)
    {
      label193:
      break label193;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    break label350;
    label231:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    try
    {
      f = Float.parseFloat((String)localObject);
      return f;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label315;
    }
    catch (Exception localException3)
    {
      label277:
      break label277;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    break label350;
    label315:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    label350:
    return paramFloat.floatValue();
    return paramFloat.floatValue();
  }
  
  public static float getFloatCompactWithPercent(Object paramObject, float paramFloat)
  {
    int i;
    if (paramObject == null)
    {
      i = (int)paramFloat;
      return i;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject.endsWith("%")) {
        paramFloat = fastGetFloat(paramObject) * paramFloat;
      }
    }
    for (;;)
    {
      i = (int)paramFloat;
      break;
      paramFloat = getFloat(paramObject);
      continue;
      paramFloat = getFloat(paramObject);
    }
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
    if (paramObject == null) {
      return paramInt;
    }
    Object localObject = paramObject.toString().trim();
    if ((!"auto".equals(localObject)) && (!"undefined".equals(localObject)))
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramInt;
      }
      if (!((String)localObject).endsWith("px")) {}
    }
    try
    {
      i = Integer.parseInt(((String)localObject).substring(0, ((String)localObject).indexOf("px")));
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int i;
      break label104;
    }
    catch (Exception localException1)
    {
      label71:
      break label71;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
    label104:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
    if (((String)localObject).endsWith("dp")) {}
    try
    {
      i = FlexConvertUtils.dip2px(Integer.parseInt(((String)localObject).substring(0, ((String)localObject).indexOf("dp"))));
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label201;
    }
    catch (Exception localException2)
    {
      label168:
      break label168;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
    label201:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
    try
    {
      i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label274;
    }
    catch (Exception localException3)
    {
      label241:
      break label241;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
    label274:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return paramInt;
  }
  
  public static float getLayoutPositionInList(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = findDomObject(paramString1, paramString2);
    float f2 = 0.0F;
    if (paramString1 == null) {
      return 0.0F;
    }
    float f1 = 0.0F;
    while ((paramString1 != null) && (!paramString1.getType().equals("list")))
    {
      if (paramBoolean) {
        f2 += paramString1.getLayoutY();
      } else {
        f1 += paramString1.getLayoutX();
      }
      paramString1 = paramString1.getDomParent();
    }
    if (paramBoolean) {
      return f2;
    }
    return f1;
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
    float f = 0.0F;
    if (paramDomObject == null) {
      return 0.0F;
    }
    if ("horizontal".equals(paramDomObject.getAttributes().get("direction"))) {
      return paramDomObject.getLayoutHeight();
    }
    int j = paramDomObject.getDomChildCount();
    int i = 0;
    while (i < j)
    {
      DomObject localDomObject = paramDomObject.getChild(i);
      if (localDomObject == null) {
        return f;
      }
      f += localDomObject.getLayoutHeight();
      i += 1;
    }
    return f;
  }
  
  public static float getListContentWidth(DomObject paramDomObject)
  {
    float f = 0.0F;
    if (paramDomObject == null) {
      return 0.0F;
    }
    if (!"horizontal".equals(paramDomObject.getAttributes().get("direction"))) {
      return paramDomObject.getLayoutWidth();
    }
    int j = paramDomObject.getDomChildCount();
    int i = 0;
    while (i < j)
    {
      DomObject localDomObject = paramDomObject.getChild(i);
      if (localDomObject == null) {
        return f;
      }
      f += localDomObject.getLayoutWidth();
      i += 1;
    }
    return f;
  }
  
  public static long getLong(Object paramObject)
  {
    if (paramObject == null) {
      return 0L;
    }
    Object localObject = paramObject.toString().trim();
    if (((String)localObject).endsWith("px")) {}
    try
    {
      l = Long.parseLong((String)localObject);
      return l;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l;
      break label71;
    }
    catch (Exception localException1)
    {
      label34:
      break label34;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0L;
    label71:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0L;
    if (((String)localObject).endsWith("dp")) {}
    try
    {
      int i = FlexConvertUtils.dip2px((float)Long.parseLong(((String)localObject).substring(0, ((String)localObject).indexOf("dp"))));
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label181;
    }
    catch (Exception localException2)
    {
      label144:
      break label144;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0L;
    label181:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0L;
    try
    {
      l = Long.parseLong((String)localObject);
      return l;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label263;
    }
    catch (Exception localException3)
    {
      label226:
      break label226;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
    return 0L;
    label263:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Argument format error! value is ");
    ((StringBuilder)localObject).append(paramObject);
    ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
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
  
  public static RenderActionContext getRenderActionContext(String paramString)
  {
    return ViolaSDKManager.getInstance().getRenderManager().getRenderContext(paramString);
  }
  
  public static int getRuntimeMode()
  {
    IExperimentConfigManager localIExperimentConfigManager = ViolaSDKManager.getInstance().getExperimentConfigManager();
    if (localIExperimentConfigManager == null) {
      return 1;
    }
    return localIExperimentConfigManager.getRuntimeMode();
  }
  
  public static int getScreenOrientation(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 9) {
        return paramInt;
      }
      return 3;
    }
    return 2;
  }
  
  public static String getString(@Nullable Object paramObject, @Nullable String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.toString();
  }
  
  public static String getVueDomFromJsSource(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      if (!paramString1.contains(paramString2)) {
        return null;
      }
      int j = paramString2.length();
      int k = paramString1.indexOf(paramString2);
      int i = paramString1.lastIndexOf(paramString2);
      if (k != i)
      {
        j = k + j;
        if (j > paramString1.length()) {
          return null;
        }
        return paramString1.substring(j, i);
      }
    }
    return null;
  }
  
  private static boolean internalStyleOrAttrChange(DomObject paramDomObject, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE.equals(paramString)) {
      paramDomObject = paramDomObject.getStyle();
    } else {
      paramDomObject = paramDomObject.getAttributes();
    }
    paramString = paramJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      Object localObject = paramDomObject.get(str);
      if (localObject == null) {
        return true;
      }
      if (!localObject.equals(paramJSONObject.opt(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isBindDataOpmOpen()
  {
    IExperimentConfigManager localIExperimentConfigManager = ViolaSDKManager.getInstance().getExperimentConfigManager();
    if (localIExperimentConfigManager == null) {
      return false;
    }
    return localIExperimentConfigManager.isBindDataOpmOpen();
  }
  
  public static boolean isLayoutOpmOpen()
  {
    IExperimentConfigManager localIExperimentConfigManager = ViolaSDKManager.getInstance().getExperimentConfigManager();
    if (localIExperimentConfigManager == null) {
      return false;
    }
    return localIExperimentConfigManager.isLayoutOpmOpen();
  }
  
  public static boolean isRefresh(DomObject paramDomObject)
  {
    boolean bool = false;
    if (paramDomObject == null)
    {
      ViolaLogUtils.e("ViolaUtils", "judge isRefresh domObject is null");
      return false;
    }
    if (("refresh".equals(paramDomObject.getType())) || ("kdrefresh".equals(paramDomObject.getType())) || ("header-view".equals(paramDomObject.getType())) || ("kbrefresh".equals(paramDomObject.getType()))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isStyleOrAttrChange(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (paramJSONObject == null) {
      return false;
    }
    paramString1 = findDomObject(paramString2, paramString1);
    if (paramString1 == null) {
      return false;
    }
    if ((internalStyleOrAttrChange(paramString1, paramJSONObject.optJSONObject(AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE), AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE)) || (internalStyleOrAttrChange(paramString1, paramJSONObject.optJSONObject(AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR), AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSystemAutoRotateOpen(Context paramContext)
  {
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (i == 0) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=");
      localStringBuilder.append(paramContext.getMessage());
      ViolaLogUtils.e("ViolaUtils", localStringBuilder.toString());
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
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
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
  
  public static Map<String, Object> json2HashMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.get(str));
      }
      return localHashMap;
    }
    catch (JSONException paramJSONObject) {}
    return null;
    return null;
  }
  
  public static void log(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        Log.d(paramString1, paramString2);
        return;
      }
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
    return paramInt1 & 0xFFFFFF | (paramInt1 >>> 24) * (paramInt2 + (paramInt2 >> 7)) >> 8 << 24;
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
    //   0: aload_0
    //   1: invokevirtual 805	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_0
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 811	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore 5
    //   15: new 813	java/io/InputStreamReader
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 816	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: astore_0
    //   25: new 818	java/io/BufferedInputStream
    //   28: dup
    //   29: aload 5
    //   31: invokespecial 819	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 6
    //   36: aload_0
    //   37: astore_3
    //   38: aload 6
    //   40: astore 4
    //   42: aload 5
    //   44: invokevirtual 824	java/io/InputStream:available	()I
    //   47: istore_2
    //   48: iload_2
    //   49: sipush 12288
    //   52: if_icmple +90 -> 142
    //   55: aload_0
    //   56: astore_3
    //   57: aload 6
    //   59: astore 4
    //   61: sipush 4096
    //   64: newarray char
    //   66: astore 5
    //   68: aload_0
    //   69: astore_3
    //   70: aload 6
    //   72: astore 4
    //   74: new 97	java/lang/StringBuilder
    //   77: dup
    //   78: sipush 12288
    //   81: invokespecial 827	java/lang/StringBuilder:<init>	(I)V
    //   84: astore 8
    //   86: aload_0
    //   87: astore_3
    //   88: aload 6
    //   90: astore 4
    //   92: aload_0
    //   93: aload 5
    //   95: invokevirtual 831	java/io/InputStreamReader:read	([C)I
    //   98: istore_2
    //   99: iconst_m1
    //   100: iload_2
    //   101: if_icmpeq +22 -> 123
    //   104: aload_0
    //   105: astore_3
    //   106: aload 6
    //   108: astore 4
    //   110: aload 8
    //   112: aload 5
    //   114: iconst_0
    //   115: iload_2
    //   116: invokevirtual 834	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: goto -34 -> 86
    //   123: aload_0
    //   124: astore_3
    //   125: aload 6
    //   127: astore 4
    //   129: aload 8
    //   131: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: astore_3
    //   139: goto +41 -> 180
    //   142: aload_0
    //   143: astore_3
    //   144: aload 6
    //   146: astore 4
    //   148: iload_2
    //   149: newarray char
    //   151: astore 5
    //   153: aload_0
    //   154: astore_3
    //   155: aload 6
    //   157: astore 4
    //   159: new 198	java/lang/String
    //   162: dup
    //   163: aload 5
    //   165: iconst_0
    //   166: aload_0
    //   167: aload 5
    //   169: invokevirtual 831	java/io/InputStreamReader:read	([C)I
    //   172: invokespecial 837	java/lang/String:<init>	([CII)V
    //   175: astore 5
    //   177: aload 5
    //   179: astore_3
    //   180: aload 6
    //   182: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   185: goto +62 -> 247
    //   188: astore 4
    //   190: new 97	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   197: astore 5
    //   199: aload 5
    //   201: ldc_w 840
    //   204: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: aload_1
    //   211: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: ldc_w 842
    //   220: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 5
    //   226: aload 4
    //   228: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 15
    //   237: bipush 6
    //   239: aload 5
    //   241: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: invokevirtual 843	java/io/InputStreamReader:close	()V
    //   251: aload_3
    //   252: areturn
    //   253: astore 4
    //   255: new 97	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   262: astore_0
    //   263: aload_0
    //   264: ldc_w 840
    //   267: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_0
    //   272: aload_1
    //   273: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_0
    //   278: ldc_w 842
    //   281: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_0
    //   286: aload 4
    //   288: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 15
    //   297: bipush 6
    //   299: aload_0
    //   300: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_3
    //   307: areturn
    //   308: astore_3
    //   309: aload_0
    //   310: astore 5
    //   312: aload 6
    //   314: astore_0
    //   315: aload_3
    //   316: astore 6
    //   318: goto +41 -> 359
    //   321: astore 5
    //   323: aconst_null
    //   324: astore 4
    //   326: goto +222 -> 548
    //   329: astore 6
    //   331: aconst_null
    //   332: astore_3
    //   333: aload_0
    //   334: astore 5
    //   336: aload_3
    //   337: astore_0
    //   338: goto +21 -> 359
    //   341: astore 5
    //   343: aconst_null
    //   344: astore_0
    //   345: aload_0
    //   346: astore 4
    //   348: goto +200 -> 548
    //   351: astore 6
    //   353: aconst_null
    //   354: astore 5
    //   356: aload 5
    //   358: astore_0
    //   359: aload 5
    //   361: astore_3
    //   362: aload_0
    //   363: astore 4
    //   365: new 97	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   372: astore 8
    //   374: aload 5
    //   376: astore_3
    //   377: aload_0
    //   378: astore 4
    //   380: aload 8
    //   382: ldc_w 845
    //   385: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 5
    //   391: astore_3
    //   392: aload_0
    //   393: astore 4
    //   395: aload 8
    //   397: aload_1
    //   398: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 5
    //   404: astore_3
    //   405: aload_0
    //   406: astore 4
    //   408: aload 8
    //   410: ldc_w 842
    //   413: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 5
    //   419: astore_3
    //   420: aload_0
    //   421: astore 4
    //   423: aload 8
    //   425: aload 6
    //   427: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 5
    //   436: astore_3
    //   437: aload_0
    //   438: astore 4
    //   440: ldc 15
    //   442: bipush 6
    //   444: aload 8
    //   446: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: aload_0
    //   453: ifnull +61 -> 514
    //   456: aload_0
    //   457: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   460: goto +54 -> 514
    //   463: astore_0
    //   464: new 97	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   471: astore_3
    //   472: aload_3
    //   473: ldc_w 840
    //   476: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_3
    //   481: aload_1
    //   482: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_3
    //   487: ldc_w 842
    //   490: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: aload_0
    //   496: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   499: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: ldc 15
    //   505: bipush 6
    //   507: aload_3
    //   508: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: aload 5
    //   516: ifnull +26 -> 542
    //   519: aload 5
    //   521: invokevirtual 843	java/io/InputStreamReader:close	()V
    //   524: aconst_null
    //   525: areturn
    //   526: astore 4
    //   528: new 97	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   535: astore_0
    //   536: aload 7
    //   538: astore_3
    //   539: goto -276 -> 263
    //   542: aconst_null
    //   543: areturn
    //   544: astore 5
    //   546: aload_3
    //   547: astore_0
    //   548: aload 4
    //   550: ifnull +68 -> 618
    //   553: aload 4
    //   555: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   558: goto +60 -> 618
    //   561: astore_3
    //   562: new 97	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   569: astore 4
    //   571: aload 4
    //   573: ldc_w 840
    //   576: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 4
    //   582: aload_1
    //   583: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 4
    //   589: ldc_w 842
    //   592: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 4
    //   598: aload_3
    //   599: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   602: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: ldc 15
    //   608: bipush 6
    //   610: aload 4
    //   612: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: ifnull +61 -> 680
    //   622: aload_0
    //   623: invokevirtual 843	java/io/InputStreamReader:close	()V
    //   626: goto +54 -> 680
    //   629: astore_0
    //   630: new 97	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   637: astore_3
    //   638: aload_3
    //   639: ldc_w 840
    //   642: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload_3
    //   647: aload_1
    //   648: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_3
    //   653: ldc_w 842
    //   656: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload_3
    //   661: aload_0
    //   662: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   665: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: ldc 15
    //   671: bipush 6
    //   673: aload_3
    //   674: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: goto +6 -> 686
    //   683: aload 5
    //   685: athrow
    //   686: goto -3 -> 683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	paramContext	Context
    //   0	689	1	paramString	String
    //   47	102	2	i	int
    //   37	270	3	localObject1	Object
    //   308	8	3	localException1	Exception
    //   332	215	3	localObject2	Object
    //   561	38	3	localException2	Exception
    //   637	37	3	localStringBuilder1	StringBuilder
    //   40	118	4	localObject3	Object
    //   188	39	4	localException3	Exception
    //   253	34	4	localException4	Exception
    //   324	115	4	localContext1	Context
    //   526	28	4	localException5	Exception
    //   569	42	4	localStringBuilder2	StringBuilder
    //   13	298	5	localObject4	Object
    //   321	1	5	localObject5	Object
    //   334	1	5	localContext2	Context
    //   341	1	5	localObject6	Object
    //   354	166	5	localObject7	Object
    //   544	140	5	localObject8	Object
    //   34	283	6	localObject9	Object
    //   329	1	6	localException6	Exception
    //   351	75	6	localException7	Exception
    //   6	531	7	localObject10	Object
    //   84	361	8	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	185	188	java/lang/Exception
    //   247	251	253	java/lang/Exception
    //   42	48	308	java/lang/Exception
    //   61	68	308	java/lang/Exception
    //   74	86	308	java/lang/Exception
    //   92	99	308	java/lang/Exception
    //   110	120	308	java/lang/Exception
    //   129	136	308	java/lang/Exception
    //   148	153	308	java/lang/Exception
    //   159	177	308	java/lang/Exception
    //   25	36	321	finally
    //   25	36	329	java/lang/Exception
    //   8	25	341	finally
    //   8	25	351	java/lang/Exception
    //   456	460	463	java/lang/Exception
    //   519	524	526	java/lang/Exception
    //   42	48	544	finally
    //   61	68	544	finally
    //   74	86	544	finally
    //   92	99	544	finally
    //   110	120	544	finally
    //   129	136	544	finally
    //   148	153	544	finally
    //   159	177	544	finally
    //   365	374	544	finally
    //   380	389	544	finally
    //   395	402	544	finally
    //   408	417	544	finally
    //   423	434	544	finally
    //   440	452	544	finally
    //   553	558	561	java/lang/Exception
    //   622	626	629	java/lang/Exception
  }
  
  public static String readFile(File paramFile)
  {
    return readFileToStringEx(paramFile, -1);
  }
  
  /* Error */
  public static String readFileToStringEx(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_0
    //   10: ifnonnull +14 -> 24
    //   13: ldc_w 855
    //   16: ldc_w 857
    //   19: invokestatic 242	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 862	java/io/File:exists	()Z
    //   28: ifeq +601 -> 629
    //   31: aload_0
    //   32: invokevirtual 865	java/io/File:canRead	()Z
    //   35: ifne +6 -> 41
    //   38: goto +591 -> 629
    //   41: new 818	java/io/BufferedInputStream
    //   44: dup
    //   45: new 867	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 870	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 819	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: new 813	java/io/InputStreamReader
    //   61: dup
    //   62: aload 5
    //   64: ldc_w 872
    //   67: invokespecial 875	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   70: astore 8
    //   72: aload 5
    //   74: astore 6
    //   76: aload 8
    //   78: astore 7
    //   80: iload_1
    //   81: istore_3
    //   82: aload_0
    //   83: invokevirtual 877	java/io/File:length	()J
    //   86: l2i
    //   87: istore 4
    //   89: iload 4
    //   91: sipush 12288
    //   94: if_icmple +150 -> 244
    //   97: iload_1
    //   98: istore_2
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpne +32 -> 133
    //   104: aload 5
    //   106: astore 6
    //   108: aload 8
    //   110: astore 7
    //   112: iload_1
    //   113: istore_3
    //   114: iload 4
    //   116: sipush 6144
    //   119: idiv
    //   120: istore_1
    //   121: iload_1
    //   122: bipush 12
    //   124: if_icmpge +620 -> 744
    //   127: bipush 12
    //   129: istore_2
    //   130: goto +3 -> 133
    //   133: aload 5
    //   135: astore 6
    //   137: aload 8
    //   139: astore 7
    //   141: iload_2
    //   142: istore_3
    //   143: sipush 4096
    //   146: newarray char
    //   148: astore 12
    //   150: aload 5
    //   152: astore 6
    //   154: aload 8
    //   156: astore 7
    //   158: iload_2
    //   159: istore_3
    //   160: new 97	java/lang/StringBuilder
    //   163: dup
    //   164: iload_2
    //   165: sipush 1024
    //   168: imul
    //   169: invokespecial 827	java/lang/StringBuilder:<init>	(I)V
    //   172: astore 13
    //   174: aload 5
    //   176: astore 6
    //   178: aload 8
    //   180: astore 7
    //   182: iload_2
    //   183: istore_3
    //   184: aload 8
    //   186: aload 12
    //   188: invokevirtual 831	java/io/InputStreamReader:read	([C)I
    //   191: istore_1
    //   192: iconst_m1
    //   193: iload_1
    //   194: if_icmpeq +26 -> 220
    //   197: aload 5
    //   199: astore 6
    //   201: aload 8
    //   203: astore 7
    //   205: iload_2
    //   206: istore_3
    //   207: aload 13
    //   209: aload 12
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 834	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: goto -43 -> 174
    //   220: aload 5
    //   222: astore 6
    //   224: aload 8
    //   226: astore 7
    //   228: iload_2
    //   229: istore_3
    //   230: aload 13
    //   232: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 12
    //   237: aload 12
    //   239: astore 6
    //   241: goto +52 -> 293
    //   244: aload 5
    //   246: astore 6
    //   248: aload 8
    //   250: astore 7
    //   252: iload_1
    //   253: istore_3
    //   254: iload 4
    //   256: newarray char
    //   258: astore 12
    //   260: aload 5
    //   262: astore 6
    //   264: aload 8
    //   266: astore 7
    //   268: iload_1
    //   269: istore_3
    //   270: new 198	java/lang/String
    //   273: dup
    //   274: aload 12
    //   276: iconst_0
    //   277: aload 8
    //   279: aload 12
    //   281: invokevirtual 831	java/io/InputStreamReader:read	([C)I
    //   284: invokespecial 837	java/lang/String:<init>	([CII)V
    //   287: astore 12
    //   289: aload 12
    //   291: astore 6
    //   293: aload 5
    //   295: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   298: aload 8
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 843	java/io/InputStreamReader:close	()V
    //   305: aload 6
    //   307: areturn
    //   308: astore 6
    //   310: aload 8
    //   312: astore_0
    //   313: aload 6
    //   315: astore 8
    //   317: goto +183 -> 500
    //   320: astore_0
    //   321: aconst_null
    //   322: astore 7
    //   324: goto +280 -> 604
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 5
    //   332: astore 9
    //   334: aload 6
    //   336: astore 5
    //   338: goto +28 -> 366
    //   341: astore 8
    //   343: aconst_null
    //   344: astore_0
    //   345: goto +155 -> 500
    //   348: astore_0
    //   349: aconst_null
    //   350: astore 5
    //   352: aload 5
    //   354: astore 7
    //   356: goto +248 -> 604
    //   359: aconst_null
    //   360: astore 9
    //   362: aload 9
    //   364: astore 5
    //   366: aload 9
    //   368: astore 6
    //   370: aload 5
    //   372: astore 7
    //   374: new 97	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   381: astore 8
    //   383: aload 9
    //   385: astore 6
    //   387: aload 5
    //   389: astore 7
    //   391: aload 8
    //   393: ldc_w 879
    //   396: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 9
    //   402: astore 6
    //   404: aload 5
    //   406: astore 7
    //   408: aload 8
    //   410: aload_0
    //   411: invokevirtual 882	java/io/File:getName	()Ljava/lang/String;
    //   414: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 9
    //   420: astore 6
    //   422: aload 5
    //   424: astore 7
    //   426: ldc_w 855
    //   429: aload 8
    //   431: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 441	com/tencent/viola/utils/ViolaLogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload 11
    //   439: astore 6
    //   441: iload_1
    //   442: iconst_m1
    //   443: if_icmpne +21 -> 464
    //   446: aload 9
    //   448: astore 6
    //   450: aload 5
    //   452: astore 7
    //   454: aload_0
    //   455: bipush 6
    //   457: invokestatic 851	com/tencent/viola/utils/ViolaUtils:readFileToStringEx	(Ljava/io/File;I)Ljava/lang/String;
    //   460: astore_0
    //   461: aload_0
    //   462: astore 6
    //   464: aload 9
    //   466: ifnull +11 -> 477
    //   469: aload 9
    //   471: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   474: goto +3 -> 477
    //   477: aload 6
    //   479: astore 7
    //   481: aload 5
    //   483: ifnull +113 -> 596
    //   486: aload 5
    //   488: astore_0
    //   489: goto -188 -> 301
    //   492: astore 8
    //   494: aconst_null
    //   495: astore 5
    //   497: aload 5
    //   499: astore_0
    //   500: aload 5
    //   502: astore 6
    //   504: aload_0
    //   505: astore 7
    //   507: new 97	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   514: astore 11
    //   516: aload 5
    //   518: astore 6
    //   520: aload_0
    //   521: astore 7
    //   523: aload 11
    //   525: ldc_w 884
    //   528: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 5
    //   534: astore 6
    //   536: aload_0
    //   537: astore 7
    //   539: aload 11
    //   541: aload 8
    //   543: invokevirtual 885	java/lang/Exception:toString	()Ljava/lang/String;
    //   546: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 5
    //   552: astore 6
    //   554: aload_0
    //   555: astore 7
    //   557: ldc_w 855
    //   560: aload 11
    //   562: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 242	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 5
    //   570: ifnull +11 -> 581
    //   573: aload 5
    //   575: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   578: goto +3 -> 581
    //   581: aload 10
    //   583: astore 7
    //   585: aload_0
    //   586: ifnull +10 -> 596
    //   589: aload 9
    //   591: astore 6
    //   593: goto -292 -> 301
    //   596: aload 7
    //   598: areturn
    //   599: astore_0
    //   600: aload 6
    //   602: astore 5
    //   604: aload 5
    //   606: ifnull +11 -> 617
    //   609: aload 5
    //   611: invokevirtual 838	java/io/BufferedInputStream:close	()V
    //   614: goto +3 -> 617
    //   617: aload 7
    //   619: ifnull +8 -> 627
    //   622: aload 7
    //   624: invokevirtual 843	java/io/InputStreamReader:close	()V
    //   627: aload_0
    //   628: athrow
    //   629: new 97	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   636: astore 5
    //   638: aload 5
    //   640: ldc_w 887
    //   643: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 5
    //   649: aload_0
    //   650: invokevirtual 862	java/io/File:exists	()Z
    //   653: invokevirtual 890	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 5
    //   659: ldc_w 892
    //   662: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 5
    //   668: aload_0
    //   669: invokevirtual 865	java/io/File:canRead	()Z
    //   672: invokevirtual 890	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc_w 855
    //   679: aload 5
    //   681: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 242	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: aconst_null
    //   688: areturn
    //   689: astore 5
    //   691: goto -332 -> 359
    //   694: astore 6
    //   696: goto -369 -> 327
    //   699: astore 6
    //   701: aload 5
    //   703: astore 9
    //   705: aload 8
    //   707: astore 5
    //   709: iload_3
    //   710: istore_1
    //   711: goto -345 -> 366
    //   714: astore_0
    //   715: aload 8
    //   717: astore_0
    //   718: goto -417 -> 301
    //   721: astore_0
    //   722: aload 6
    //   724: areturn
    //   725: astore_0
    //   726: goto -249 -> 477
    //   729: astore 5
    //   731: goto -150 -> 581
    //   734: astore 5
    //   736: goto -119 -> 617
    //   739: astore 5
    //   741: goto -114 -> 627
    //   744: iload_1
    //   745: istore_2
    //   746: iload_1
    //   747: bipush 60
    //   749: if_icmple -616 -> 133
    //   752: bipush 60
    //   754: istore_2
    //   755: goto -622 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramFile	File
    //   0	758	1	paramInt	int
    //   98	657	2	i	int
    //   81	629	3	j	int
    //   87	168	4	k	int
    //   56	624	5	localObject1	Object
    //   689	13	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   707	1	5	localObject2	Object
    //   729	1	5	localException1	Exception
    //   734	1	5	localException2	Exception
    //   739	1	5	localException3	Exception
    //   74	232	6	localObject3	Object
    //   308	6	6	localException4	Exception
    //   328	273	6	localObject4	Object
    //   694	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   699	24	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   78	545	7	localObject5	Object
    //   70	246	8	localObject6	Object
    //   341	1	8	localException5	Exception
    //   381	49	8	localStringBuilder1	StringBuilder
    //   492	224	8	localException6	Exception
    //   7	697	9	localObject7	Object
    //   4	578	10	localObject8	Object
    //   1	560	11	localStringBuilder2	StringBuilder
    //   148	142	12	localObject9	Object
    //   172	59	13	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   82	89	308	java/lang/Exception
    //   114	121	308	java/lang/Exception
    //   143	150	308	java/lang/Exception
    //   160	174	308	java/lang/Exception
    //   184	192	308	java/lang/Exception
    //   207	217	308	java/lang/Exception
    //   230	237	308	java/lang/Exception
    //   254	260	308	java/lang/Exception
    //   270	289	308	java/lang/Exception
    //   58	72	320	finally
    //   58	72	341	java/lang/Exception
    //   41	58	348	finally
    //   41	58	492	java/lang/Exception
    //   82	89	599	finally
    //   114	121	599	finally
    //   143	150	599	finally
    //   160	174	599	finally
    //   184	192	599	finally
    //   207	217	599	finally
    //   230	237	599	finally
    //   254	260	599	finally
    //   270	289	599	finally
    //   374	383	599	finally
    //   391	400	599	finally
    //   408	418	599	finally
    //   426	437	599	finally
    //   454	461	599	finally
    //   507	516	599	finally
    //   523	532	599	finally
    //   539	550	599	finally
    //   557	568	599	finally
    //   41	58	689	java/lang/OutOfMemoryError
    //   58	72	694	java/lang/OutOfMemoryError
    //   82	89	699	java/lang/OutOfMemoryError
    //   114	121	699	java/lang/OutOfMemoryError
    //   143	150	699	java/lang/OutOfMemoryError
    //   160	174	699	java/lang/OutOfMemoryError
    //   184	192	699	java/lang/OutOfMemoryError
    //   207	217	699	java/lang/OutOfMemoryError
    //   230	237	699	java/lang/OutOfMemoryError
    //   254	260	699	java/lang/OutOfMemoryError
    //   270	289	699	java/lang/OutOfMemoryError
    //   293	298	714	java/lang/Exception
    //   301	305	721	java/lang/Exception
    //   469	474	725	java/lang/Exception
    //   573	578	729	java/lang/Exception
    //   609	614	734	java/lang/Exception
    //   622	627	739	java/lang/Exception
  }
  
  public static void reportNVCost(long paramLong)
  {
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.addReportData(ViolaEnvironment.TIME_NATIVE_VUE, String.valueOf(paramLong));
    }
  }
  
  public static void reportNVError(String paramString1, String paramString2)
  {
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportNativeVueError(paramString1, paramString2);
    }
  }
  
  public static void reportNVProcess(String paramString1, String paramString2)
  {
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportNVProcess("KEY_NV_PROCESS", paramString1, paramString2);
    }
  }
  
  public static String[] splitTemplateAndData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("template");
        localObject = ((JSONObject)localObject).optString("data");
        if (paramString == null) {
          break label117;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        String[] arrayOfString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getVueDomFromJsSource error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        ViolaLogUtils.e("ViolaUtils", ((StringBuilder)localObject).toString());
        return null;
      }
      arrayOfString = new String[j];
      if (j == 2)
      {
        arrayOfString[0] = paramString;
        arrayOfString[1] = localObject;
        return arrayOfString;
      }
      if (j == 1) {
        arrayOfString[0] = paramString;
      }
      return arrayOfString;
      label117:
      int i = 0;
      int j = i;
      if (localObject != null) {
        j = i + 1;
      }
    }
  }
  
  public static String splittBodyEncodeUrl(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    StringBuffer localStringBuffer = null;
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      for (;;)
      {
        localObject2 = localStringBuffer;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = localStringBuffer;
        try
        {
          localObject3 = (String)localIterator.next();
          localObject2 = localStringBuffer;
          String str = paramJSONObject.getString((String)localObject3);
          if (localStringBuffer == null)
          {
            localObject2 = localStringBuffer;
            localStringBuffer = new StringBuffer();
          }
          else
          {
            localObject2 = localStringBuffer;
            localStringBuffer.append("&");
          }
          localObject2 = localStringBuffer;
          localStringBuffer.append((String)localObject3);
          localObject2 = localStringBuffer;
          localStringBuffer.append("=");
          localObject2 = localStringBuffer;
          localStringBuffer.append(str);
        }
        catch (JSONException localJSONException)
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("splittBodyEncodeUrl error : ");
          ((StringBuilder)localObject3).append(localJSONException.getMessage());
          log("ViolaUtils", 6, ((StringBuilder)localObject3).toString());
          Object localObject1 = localObject2;
        }
      }
    }
    if (localObject2 != null) {
      return localObject2.toString();
    }
    return "";
  }
  
  public static String splittUrlForHttpGet(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = paramString;
    Object localObject3;
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = localObject1;
        try
        {
          Object localObject4 = (String)localIterator.next();
          localObject2 = localObject1;
          String str = paramJSONObject.getString((String)localObject4);
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            localObject1 = new StringBuffer();
            try
            {
              if ((!TextUtils.isEmpty(paramString)) && (!paramString.contains("?"))) {
                ((StringBuffer)localObject1).append("?");
              } else {
                ((StringBuffer)localObject1).append("&");
              }
            }
            catch (JSONException localJSONException1)
            {
              localObject4 = localJSONException1;
              break label153;
            }
          }
          else
          {
            localObject3 = localObject1;
            ((StringBuffer)localObject1).append("&");
          }
          localObject3 = localObject1;
          ((StringBuffer)localObject1).append((String)localObject4);
          localObject3 = localObject1;
          ((StringBuffer)localObject1).append("=");
          localObject3 = localObject1;
          ((StringBuffer)localObject1).append(str);
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localObject3;
          label153:
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("splittUrlForHttpGet error : ");
          ((StringBuilder)localObject3).append(localJSONException2.getMessage());
          log("ViolaUtils", 6, ((StringBuilder)localObject3).toString());
        }
      }
      localObject3 = paramString;
      if (localObject1 != null)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramString);
        paramJSONObject.append(((StringBuffer)localObject1).toString());
        localObject3 = paramJSONObject.toString();
      }
    }
    return localObject3;
  }
  
  public static boolean triggerV8GcWhenDestroy()
  {
    IExperimentConfigManager localIExperimentConfigManager = ViolaSDKManager.getInstance().getExperimentConfigManager();
    if (localIExperimentConfigManager == null) {
      return false;
    }
    return localIExperimentConfigManager.triggerV8GcWhenDestroy();
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
  
  public static boolean useV8Engine()
  {
    IExperimentConfigManager localIExperimentConfigManager = ViolaSDKManager.getInstance().getExperimentConfigManager();
    if (localIExperimentConfigManager == null) {
      return false;
    }
    return localIExperimentConfigManager.useV8Engine();
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat *= 8.0F;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F;
    }
    return paramFloat * sViscousFluidNormalize;
  }
  
  /* Error */
  public static boolean writeFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 859	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 978	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_3
    //   16: astore_2
    //   17: aload 5
    //   19: invokevirtual 862	java/io/File:exists	()Z
    //   22: ifne +15 -> 37
    //   25: aload_3
    //   26: astore_2
    //   27: aload 5
    //   29: invokevirtual 981	java/io/File:createNewFile	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_3
    //   38: astore_2
    //   39: new 983	java/io/FileOutputStream
    //   42: dup
    //   43: aload 5
    //   45: invokespecial 984	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_3
    //   49: aload_3
    //   50: aload_0
    //   51: invokevirtual 986	java/lang/String:getBytes	()[B
    //   54: invokevirtual 990	java/io/FileOutputStream:write	([B)V
    //   57: aload_3
    //   58: invokevirtual 991	java/io/FileOutputStream:flush	()V
    //   61: aload_3
    //   62: invokevirtual 992	java/io/FileOutputStream:close	()V
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_0
    //   68: new 97	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   75: astore_2
    //   76: aload_2
    //   77: ldc_w 994
    //   80: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: aload_1
    //   86: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: ldc_w 842
    //   94: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: aload_0
    //   100: invokevirtual 995	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 15
    //   109: bipush 6
    //   111: aload_2
    //   112: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_0
    //   121: aload_3
    //   122: astore_2
    //   123: goto +150 -> 273
    //   126: astore_2
    //   127: aload_3
    //   128: astore_0
    //   129: aload_2
    //   130: astore_3
    //   131: goto +11 -> 142
    //   134: astore_0
    //   135: goto +138 -> 273
    //   138: astore_3
    //   139: aload 4
    //   141: astore_0
    //   142: aload_0
    //   143: astore_2
    //   144: new 97	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   151: astore 4
    //   153: aload_0
    //   154: astore_2
    //   155: aload 4
    //   157: ldc_w 997
    //   160: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_0
    //   165: astore_2
    //   166: aload 4
    //   168: aload_1
    //   169: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_0
    //   174: astore_2
    //   175: aload 4
    //   177: ldc_w 842
    //   180: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: astore_2
    //   186: aload 4
    //   188: aload_3
    //   189: invokevirtual 995	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: astore_2
    //   198: ldc 15
    //   200: bipush 6
    //   202: aload 4
    //   204: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: ifnull +60 -> 271
    //   214: aload_0
    //   215: invokevirtual 992	java/io/FileOutputStream:close	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_0
    //   221: new 97	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 994
    //   233: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_2
    //   238: aload_1
    //   239: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_2
    //   244: ldc_w 842
    //   247: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_2
    //   252: aload_0
    //   253: invokevirtual 995	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   256: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc 15
    //   262: bipush 6
    //   264: aload_2
    //   265: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: iconst_0
    //   272: ireturn
    //   273: aload_2
    //   274: ifnull +61 -> 335
    //   277: aload_2
    //   278: invokevirtual 992	java/io/FileOutputStream:close	()V
    //   281: goto +54 -> 335
    //   284: astore_2
    //   285: new 97	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   292: astore_3
    //   293: aload_3
    //   294: ldc_w 994
    //   297: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_3
    //   302: aload_1
    //   303: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: ldc_w 842
    //   311: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_3
    //   316: aload_2
    //   317: invokevirtual 995	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc 15
    //   326: bipush 6
    //   328: aload_3
    //   329: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 114	com/tencent/viola/utils/ViolaUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramString1	String
    //   0	337	1	paramString2	String
    //   16	107	2	localObject1	Object
    //   126	4	2	localThrowable1	java.lang.Throwable
    //   143	135	2	localObject2	Object
    //   284	33	2	localThrowable2	java.lang.Throwable
    //   14	117	3	localObject3	Object
    //   138	51	3	localThrowable3	java.lang.Throwable
    //   292	37	3	localStringBuilder1	StringBuilder
    //   11	192	4	localStringBuilder2	StringBuilder
    //   8	36	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/Throwable
    //   49	61	120	finally
    //   49	61	126	java/lang/Throwable
    //   17	25	134	finally
    //   27	35	134	finally
    //   39	49	134	finally
    //   144	153	134	finally
    //   155	164	134	finally
    //   166	173	134	finally
    //   175	184	134	finally
    //   186	196	134	finally
    //   198	210	134	finally
    //   17	25	138	java/lang/Throwable
    //   27	35	138	java/lang/Throwable
    //   39	49	138	java/lang/Throwable
    //   214	218	220	java/lang/Throwable
    //   277	281	284	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaUtils
 * JD-Core Version:    0.7.0.1
 */