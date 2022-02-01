package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
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
    Object localObject1 = "UNSET";
    Object localObject3 = null;
    Object localObject7 = null;
    long l1 = 0L;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    long l2 = -1L;
    float f2 = 1.0F;
    float f1 = 0.0F;
    float f4 = 0.0F;
    float f3 = 0.0F;
    Object localObject2 = null;
    boolean bool = false;
    Object localObject5 = Layer.MatteType.NONE;
    Object localObject6 = null;
    AnimatableTextFrame localAnimatableTextFrame = null;
    AnimatableTextProperties localAnimatableTextProperties = null;
    Object localObject4 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramJsonReader.beginObject();
    if (paramJsonReader.hasNext())
    {
      Object localObject8 = paramJsonReader.nextName();
      int i = -1;
      switch (((String)localObject8).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label304:
          paramJsonReader.skipValue();
          localObject8 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject8;
        }
        break;
      }
      for (;;)
      {
        localObject8 = localObject2;
        Object localObject9 = localObject3;
        localObject2 = localObject1;
        localObject3 = localObject8;
        localObject1 = localObject9;
        break;
        if (!((String)localObject8).equals("nm")) {
          break label304;
        }
        i = 0;
        break label304;
        if (!((String)localObject8).equals("ind")) {
          break label304;
        }
        i = 1;
        break label304;
        if (!((String)localObject8).equals("refId")) {
          break label304;
        }
        i = 2;
        break label304;
        if (!((String)localObject8).equals("ty")) {
          break label304;
        }
        i = 3;
        break label304;
        if (!((String)localObject8).equals("parent")) {
          break label304;
        }
        i = 4;
        break label304;
        if (!((String)localObject8).equals("sw")) {
          break label304;
        }
        i = 5;
        break label304;
        if (!((String)localObject8).equals("sh")) {
          break label304;
        }
        i = 6;
        break label304;
        if (!((String)localObject8).equals("sc")) {
          break label304;
        }
        i = 7;
        break label304;
        if (!((String)localObject8).equals("ks")) {
          break label304;
        }
        i = 8;
        break label304;
        if (!((String)localObject8).equals("tt")) {
          break label304;
        }
        i = 9;
        break label304;
        if (!((String)localObject8).equals("masksProperties")) {
          break label304;
        }
        i = 10;
        break label304;
        if (!((String)localObject8).equals("shapes")) {
          break label304;
        }
        i = 11;
        break label304;
        if (!((String)localObject8).equals("t")) {
          break label304;
        }
        i = 12;
        break label304;
        if (!((String)localObject8).equals("ef")) {
          break label304;
        }
        i = 13;
        break label304;
        if (!((String)localObject8).equals("sr")) {
          break label304;
        }
        i = 14;
        break label304;
        if (!((String)localObject8).equals("st")) {
          break label304;
        }
        i = 15;
        break label304;
        if (!((String)localObject8).equals("w")) {
          break label304;
        }
        i = 16;
        break label304;
        if (!((String)localObject8).equals("h")) {
          break label304;
        }
        i = 17;
        break label304;
        if (!((String)localObject8).equals("ip")) {
          break label304;
        }
        i = 18;
        break label304;
        if (!((String)localObject8).equals("op")) {
          break label304;
        }
        i = 19;
        break label304;
        if (!((String)localObject8).equals("tm")) {
          break label304;
        }
        i = 20;
        break label304;
        if (!((String)localObject8).equals("cl")) {
          break label304;
        }
        i = 21;
        break label304;
        if (!((String)localObject8).equals("hd")) {
          break label304;
        }
        i = 22;
        break label304;
        localObject8 = paramJsonReader.nextString();
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject8;
        continue;
        l1 = paramJsonReader.nextInt();
        localObject8 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject8;
        continue;
        localObject8 = paramJsonReader.nextString();
        localObject7 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject7;
        localObject7 = localObject8;
        continue;
        i = paramJsonReader.nextInt();
        if (i < Layer.LayerType.UNKNOWN.ordinal())
        {
          localObject3 = Layer.LayerType.values()[i];
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
        }
        else
        {
          localObject3 = Layer.LayerType.UNKNOWN;
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          l2 = paramJsonReader.nextInt();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          i1 = (int)(paramJsonReader.nextInt() * Utils.dpScale());
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          n = (int)(paramJsonReader.nextInt() * Utils.dpScale());
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          m = Color.parseColor(paramJsonReader.nextString());
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          localObject8 = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
          localObject6 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject8;
          continue;
          localObject8 = Layer.MatteType.values()[paramJsonReader.nextInt()];
          paramLottieComposition.incrementMatteOrMaskCount(1);
          localObject5 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject5;
          localObject5 = localObject8;
          continue;
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext()) {
            localArrayList1.add(MaskParser.parse(paramJsonReader, paramLottieComposition));
          }
          paramLottieComposition.incrementMatteOrMaskCount(localArrayList1.size());
          paramJsonReader.endArray();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext())
          {
            localObject8 = ContentModelParser.parse(paramJsonReader, paramLottieComposition);
            if (localObject8 != null) {
              localArrayList2.add(localObject8);
            }
          }
          paramJsonReader.endArray();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          paramJsonReader.beginObject();
          label1292:
          while (paramJsonReader.hasNext())
          {
            localObject8 = paramJsonReader.nextName();
            int i2 = -1;
            i = i2;
            switch (((String)localObject8).hashCode())
            {
            default: 
              i = i2;
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                paramJsonReader.skipValue();
                break label1292;
                i = i2;
                if (((String)localObject8).equals("d"))
                {
                  i = 0;
                  continue;
                  i = i2;
                  if (((String)localObject8).equals("a")) {
                    i = 1;
                  }
                }
                break;
              }
            }
            localAnimatableTextFrame = AnimatableValueParser.parseDocumentData(paramJsonReader, paramLottieComposition);
            continue;
            paramJsonReader.beginArray();
            if (paramJsonReader.hasNext()) {
              localAnimatableTextProperties = AnimatableTextPropertiesParser.parse(paramJsonReader, paramLottieComposition);
            }
            while (paramJsonReader.hasNext()) {
              paramJsonReader.skipValue();
            }
            paramJsonReader.endArray();
          }
          paramJsonReader.endObject();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          paramJsonReader.beginArray();
          localObject8 = new ArrayList();
          while (paramJsonReader.hasNext())
          {
            paramJsonReader.beginObject();
            label1519:
            while (paramJsonReader.hasNext())
            {
              localObject9 = paramJsonReader.nextName();
              i = -1;
              switch (((String)localObject9).hashCode())
              {
              }
              for (;;)
              {
                switch (i)
                {
                default: 
                  paramJsonReader.skipValue();
                  break label1519;
                  if (((String)localObject9).equals("nm")) {
                    i = 0;
                  }
                  break;
                }
              }
              ((List)localObject8).add(paramJsonReader.nextString());
            }
            paramJsonReader.endObject();
          }
          paramJsonReader.endArray();
          paramLottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + localObject8);
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          f2 = (float)paramJsonReader.nextDouble();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          f1 = (float)paramJsonReader.nextDouble();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          k = (int)(paramJsonReader.nextInt() * Utils.dpScale());
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          j = (int)(paramJsonReader.nextInt() * Utils.dpScale());
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          f4 = (float)paramJsonReader.nextDouble();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          f3 = (float)paramJsonReader.nextDouble();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
          continue;
          localObject8 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject8;
          continue;
          localObject8 = paramJsonReader.nextString();
          localObject2 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject8;
          continue;
          bool = paramJsonReader.nextBoolean();
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject8;
        }
      }
    }
    paramJsonReader.endObject();
    f4 /= f2;
    f3 /= f2;
    paramJsonReader = new ArrayList();
    if (f4 > 0.0F) {
      paramJsonReader.add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(f4)));
    }
    if (f3 > 0.0F) {}
    for (;;)
    {
      paramJsonReader.add(new Keyframe(paramLottieComposition, Float.valueOf(1.0F), Float.valueOf(1.0F), null, f4, Float.valueOf(f3)));
      paramJsonReader.add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, f3, Float.valueOf(3.4028235E+38F)));
      if ((((String)localObject1).endsWith(".ai")) || ("ai".equals(localObject2))) {
        paramLottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
      }
      return new Layer(localArrayList2, paramLottieComposition, (String)localObject1, l1, (Layer.LayerType)localObject3, l2, localObject7, localArrayList1, localObject6, i1, n, m, f2, f1, k, j, localAnimatableTextFrame, localAnimatableTextProperties, paramJsonReader, (Layer.MatteType)localObject5, localObject4, bool);
      f3 = paramLottieComposition.getEndFrame();
    }
  }
  
  public static Layer parse(LottieComposition paramLottieComposition)
  {
    Rect localRect = paramLottieComposition.getBounds();
    return new Layer(Collections.emptyList(), paramLottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.LayerParser
 * JD-Core Version:    0.7.0.1
 */