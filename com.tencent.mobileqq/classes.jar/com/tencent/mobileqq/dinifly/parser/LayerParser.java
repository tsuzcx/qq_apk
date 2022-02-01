package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.LayerType;
import com.tencent.mobileqq.dinifly.model.layer.Layer.MatteType;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser
{
  public static Layer parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    Layer.MatteType localMatteType = Layer.MatteType.NONE;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramJsonReader.beginObject();
    Float localFloat1 = Float.valueOf(1.0F);
    Float localFloat2 = Float.valueOf(0.0F);
    Object localObject9 = null;
    Object localObject3 = localObject9;
    Object localObject4 = localObject3;
    Object localObject1 = localObject4;
    Object localObject2 = localObject1;
    Object localObject5 = localObject2;
    long l2 = 0L;
    long l1 = -1L;
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f2 = 1.0F;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    float f1 = 0.0F;
    boolean bool = false;
    Object localObject8 = localObject5;
    Object localObject10 = "UNSET";
    Object localObject6 = localObject4;
    Object localObject7 = localObject3;
    localObject4 = localObject9;
    localObject3 = localObject8;
    localObject8 = localObject10;
    while (paramJsonReader.hasNext())
    {
      localObject9 = paramJsonReader.nextName();
      switch (((String)localObject9).hashCode())
      {
      default: 
        break;
      case 1441620890: 
        if (((String)localObject9).equals("masksProperties")) {
          i = 10;
        }
        break;
      case 108390670: 
        if (((String)localObject9).equals("refId")) {
          i = 2;
        }
        break;
      case 104415: 
        if (((String)localObject9).equals("ind")) {
          i = 1;
        }
        break;
      case 3717: 
        if (((String)localObject9).equals("ty")) {
          i = 3;
        }
        break;
      case 3712: 
        if (((String)localObject9).equals("tt")) {
          i = 9;
        }
        break;
      case 3705: 
        if (((String)localObject9).equals("tm")) {
          i = 20;
        }
        break;
      case 3684: 
        if (((String)localObject9).equals("sw")) {
          i = 5;
        }
        break;
      case 3681: 
        if (((String)localObject9).equals("st")) {
          i = 15;
        }
        break;
      case 3679: 
        if (((String)localObject9).equals("sr")) {
          i = 14;
        }
        break;
      case 3669: 
        if (((String)localObject9).equals("sh")) {
          i = 6;
        }
        break;
      case 3664: 
        if (((String)localObject9).equals("sc")) {
          i = 7;
        }
        break;
      case 3553: 
        if (((String)localObject9).equals("op")) {
          i = 19;
        }
        break;
      case 3519: 
        if (((String)localObject9).equals("nm")) {
          i = 0;
        }
        break;
      case 3432: 
        if (((String)localObject9).equals("ks")) {
          i = 8;
        }
        break;
      case 3367: 
        if (((String)localObject9).equals("ip")) {
          i = 18;
        }
        break;
      case 3324: 
        if (((String)localObject9).equals("hd")) {
          i = 22;
        }
        break;
      case 3233: 
        if (((String)localObject9).equals("ef")) {
          i = 13;
        }
        break;
      case 3177: 
        if (((String)localObject9).equals("cl")) {
          i = 21;
        }
        break;
      case 119: 
        if (((String)localObject9).equals("w")) {
          i = 16;
        }
        break;
      case 116: 
        if (((String)localObject9).equals("t")) {
          i = 12;
        }
        break;
      case 104: 
        if (((String)localObject9).equals("h")) {
          i = 17;
        }
        break;
      case -903568142: 
        if (((String)localObject9).equals("shapes")) {
          i = 11;
        }
        break;
      case -995424086: 
        if (((String)localObject9).equals("parent")) {
          i = 4;
        }
        break;
      }
      int i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 22: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 21: 
        localObject3 = paramJsonReader.nextString();
        break;
      case 20: 
        localObject5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 19: 
        f3 = (float)paramJsonReader.nextDouble();
        break;
      case 18: 
        f4 = (float)paramJsonReader.nextDouble();
        break;
      case 17: 
        j = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 16: 
        k = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 15: 
        f1 = (float)paramJsonReader.nextDouble();
        break;
      case 14: 
        f2 = (float)paramJsonReader.nextDouble();
        break;
      case 13: 
        paramJsonReader.beginArray();
        localObject9 = new ArrayList();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          while (paramJsonReader.hasNext())
          {
            localObject10 = paramJsonReader.nextName();
            if ((((String)localObject10).hashCode() == 3519) && (((String)localObject10).equals("nm"))) {
              i = 0;
            } else {
              i = -1;
            }
            if (i != 0) {
              paramJsonReader.skipValue();
            } else {
              ((List)localObject9).add(paramJsonReader.nextString());
            }
          }
          paramJsonReader.endObject();
        }
        paramJsonReader.endArray();
        localObject10 = new StringBuilder();
        ((StringBuilder)localObject10).append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
        ((StringBuilder)localObject10).append(localObject9);
        paramLottieComposition.addWarning(((StringBuilder)localObject10).toString());
        break;
      case 12: 
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
        {
          localObject9 = paramJsonReader.nextName();
          i = ((String)localObject9).hashCode();
          if (i != 97)
          {
            if ((i == 100) && (((String)localObject9).equals("d")))
            {
              i = 0;
              break label1165;
            }
          }
          else if (((String)localObject9).equals("a"))
          {
            i = 1;
            break label1165;
          }
          i = -1;
          if (i != 0)
          {
            if (i != 1)
            {
              paramJsonReader.skipValue();
            }
            else
            {
              paramJsonReader.beginArray();
              if (paramJsonReader.hasNext()) {
                localObject2 = AnimatableTextPropertiesParser.parse(paramJsonReader, paramLottieComposition);
              }
              while (paramJsonReader.hasNext()) {
                paramJsonReader.skipValue();
              }
              paramJsonReader.endArray();
            }
          }
          else {
            localObject1 = AnimatableValueParser.parseDocumentData(paramJsonReader, paramLottieComposition);
          }
        }
        paramJsonReader.endObject();
        break;
      case 11: 
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          localObject9 = ContentModelParser.parse(paramJsonReader, paramLottieComposition);
          if (localObject9 != null) {
            localArrayList2.add(localObject9);
          }
        }
        paramJsonReader.endArray();
        break;
      case 10: 
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext()) {
          localArrayList1.add(MaskParser.parse(paramJsonReader, paramLottieComposition));
        }
        paramLottieComposition.incrementMatteOrMaskCount(localArrayList1.size());
        paramJsonReader.endArray();
        break;
      case 9: 
        localMatteType = Layer.MatteType.values()[paramJsonReader.nextInt()];
        paramLottieComposition.incrementMatteOrMaskCount(1);
        break;
      case 8: 
        localObject6 = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
        break;
      case 7: 
        m = Color.parseColor(paramJsonReader.nextString());
        break;
      case 6: 
        n = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 5: 
        i1 = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 4: 
        l1 = paramJsonReader.nextInt();
        break;
      case 3: 
        i = paramJsonReader.nextInt();
        if (i < Layer.LayerType.UNKNOWN.ordinal()) {
          localObject4 = Layer.LayerType.values()[i];
        } else {
          localObject4 = Layer.LayerType.UNKNOWN;
        }
        break;
      case 2: 
        localObject7 = paramJsonReader.nextString();
        break;
      case 1: 
        label1165:
        l2 = paramJsonReader.nextInt();
        break;
      }
      localObject8 = paramJsonReader.nextString();
    }
    paramJsonReader.endObject();
    f4 /= f2;
    f3 /= f2;
    paramJsonReader = new ArrayList();
    if (f4 > 0.0F) {
      paramJsonReader.add(new Keyframe(paramLottieComposition, localFloat2, localFloat2, null, 0.0F, Float.valueOf(f4)));
    }
    if (f3 <= 0.0F) {
      f3 = paramLottieComposition.getEndFrame();
    }
    paramJsonReader.add(new Keyframe(paramLottieComposition, localFloat1, localFloat1, null, f4, Float.valueOf(f3)));
    paramJsonReader.add(new Keyframe(paramLottieComposition, localFloat2, localFloat2, null, f3, Float.valueOf(3.4028235E+38F)));
    if ((((String)localObject8).endsWith(".ai")) || ("ai".equals(localObject3))) {
      paramLottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
    }
    return new Layer(localArrayList2, paramLottieComposition, (String)localObject8, l2, (Layer.LayerType)localObject4, l1, (String)localObject7, localArrayList1, (AnimatableTransform)localObject6, i1, n, m, f2, f1, k, j, (AnimatableTextFrame)localObject1, (AnimatableTextProperties)localObject2, paramJsonReader, localMatteType, (AnimatableFloatValue)localObject5, bool);
  }
  
  public static Layer parse(LottieComposition paramLottieComposition)
  {
    Rect localRect = paramLottieComposition.getBounds();
    return new Layer(Collections.emptyList(), paramLottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LayerParser
 * JD-Core Version:    0.7.0.1
 */