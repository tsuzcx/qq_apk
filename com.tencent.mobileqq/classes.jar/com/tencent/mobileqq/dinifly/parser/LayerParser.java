package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.LayerType;
import com.tencent.mobileqq.dinifly.model.layer.Layer.MatteType;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser
{
  private static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.of(new String[] { "nm" });
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd" });
  private static final JsonReader.Options TEXT_NAMES = JsonReader.Options.of(new String[] { "d", "a" });
  
  public static Layer parse(LottieComposition paramLottieComposition)
  {
    Rect localRect = paramLottieComposition.getBounds();
    return new Layer(Collections.emptyList(), paramLottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
  }
  
  public static Layer parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    Object localObject10 = Layer.MatteType.NONE;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramJsonReader.beginObject();
    Float localFloat1 = Float.valueOf(1.0F);
    Float localFloat2 = Float.valueOf(0.0F);
    Object localObject9 = null;
    Object localObject1 = localObject9;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    long l1 = -1L;
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f2 = 1.0F;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    float f1 = 0.0F;
    boolean bool = false;
    long l2 = 0L;
    Object localObject8 = localObject5;
    Object localObject11 = "UNSET";
    Object localObject7 = localObject4;
    Object localObject6 = localObject3;
    localObject3 = localObject10;
    localObject4 = localObject1;
    localObject1 = localObject9;
    localObject9 = localObject11;
    while (paramJsonReader.hasNext())
    {
      int i1;
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 22: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 21: 
        localObject8 = paramJsonReader.nextString();
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
        i = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 16: 
        j = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 15: 
        f1 = (float)paramJsonReader.nextDouble();
        break;
      case 14: 
        f2 = (float)paramJsonReader.nextDouble();
        break;
      case 13: 
        paramJsonReader.beginArray();
        localObject10 = new ArrayList();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          while (paramJsonReader.hasNext()) {
            if (paramJsonReader.selectName(EFFECTS_NAMES) != 0)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
              ((List)localObject10).add(paramJsonReader.nextString());
            }
          }
          paramJsonReader.endObject();
        }
        paramJsonReader.endArray();
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
        ((StringBuilder)localObject11).append(localObject10);
        paramLottieComposition.addWarning(((StringBuilder)localObject11).toString());
        break;
      case 12: 
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
        {
          i1 = paramJsonReader.selectName(TEXT_NAMES);
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
              paramJsonReader.beginArray();
              if (paramJsonReader.hasNext()) {
                localObject7 = AnimatableTextPropertiesParser.parse(paramJsonReader, paramLottieComposition);
              }
              while (paramJsonReader.hasNext()) {
                paramJsonReader.skipValue();
              }
              paramJsonReader.endArray();
            }
          }
          else {
            localObject6 = AnimatableValueParser.parseDocumentData(paramJsonReader, paramLottieComposition);
          }
        }
        paramJsonReader.endObject();
        break;
      case 11: 
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          localObject10 = ContentModelParser.parse(paramJsonReader, paramLottieComposition);
          if (localObject10 != null) {
            localArrayList2.add(localObject10);
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
        i1 = paramJsonReader.nextInt();
        if (i1 >= Layer.MatteType.values().length)
        {
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("Unsupported matte type: ");
          ((StringBuilder)localObject10).append(i1);
          paramLottieComposition.addWarning(((StringBuilder)localObject10).toString());
        }
        else
        {
          localObject3 = Layer.MatteType.values()[i1];
          i1 = LayerParser.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$layer$Layer$MatteType[localObject3.ordinal()];
          if (i1 != 1)
          {
            if (i1 == 2) {
              paramLottieComposition.addWarning("Unsupported matte type: Luma Inverted");
            }
          }
          else {
            paramLottieComposition.addWarning("Unsupported matte type: Luma");
          }
          paramLottieComposition.incrementMatteOrMaskCount(1);
        }
        break;
      case 8: 
        localObject2 = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
        break;
      case 7: 
        k = Color.parseColor(paramJsonReader.nextString());
        break;
      case 6: 
        m = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 5: 
        n = (int)(paramJsonReader.nextInt() * Utils.dpScale());
        break;
      case 4: 
        l1 = paramJsonReader.nextInt();
        break;
      case 3: 
        i1 = paramJsonReader.nextInt();
        if (i1 < Layer.LayerType.UNKNOWN.ordinal()) {
          localObject1 = Layer.LayerType.values()[i1];
        } else {
          localObject1 = Layer.LayerType.UNKNOWN;
        }
        break;
      case 2: 
        localObject4 = paramJsonReader.nextString();
        break;
      case 1: 
        l2 = paramJsonReader.nextInt();
        break;
      case 0: 
        localObject9 = paramJsonReader.nextString();
      }
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
    if ((((String)localObject9).endsWith(".ai")) || ("ai".equals(localObject8))) {
      paramLottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
    }
    return new Layer(localArrayList2, paramLottieComposition, (String)localObject9, l2, (Layer.LayerType)localObject1, l1, (String)localObject4, localArrayList1, (AnimatableTransform)localObject2, n, m, k, f2, f1, j, i, (AnimatableTextFrame)localObject6, (AnimatableTextProperties)localObject7, paramJsonReader, (Layer.MatteType)localObject3, (AnimatableFloatValue)localObject5, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LayerParser
 * JD-Core Version:    0.7.0.1
 */