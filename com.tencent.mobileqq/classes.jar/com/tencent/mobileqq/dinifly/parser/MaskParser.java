package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.model.content.Mask.MaskMode;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.utils.Logger;

class MaskParser
{
  static Mask parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    paramJsonReader.beginObject();
    Object localObject1 = null;
    AnimatableShapeValue localAnimatableShapeValue = null;
    Object localObject2 = localAnimatableShapeValue;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = str.hashCode();
      int j = -1;
      if (i != 111)
      {
        if (i != 3588)
        {
          if (i != 104433)
          {
            if ((i == 3357091) && (str.equals("mode")))
            {
              i = 0;
              break label128;
            }
          }
          else if (str.equals("inv"))
          {
            i = 3;
            break label128;
          }
        }
        else if (str.equals("pt"))
        {
          i = 1;
          break label128;
        }
      }
      else if (str.equals("o"))
      {
        i = 2;
        break label128;
      }
      i = -1;
      label128:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
              bool = paramJsonReader.nextBoolean();
            }
          }
          else {
            localObject2 = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
          }
        }
        else {
          localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
        }
      }
      else
      {
        localObject1 = paramJsonReader.nextString();
        i = ((String)localObject1).hashCode();
        if (i != 97)
        {
          if (i != 105)
          {
            if (i != 110)
            {
              if (i != 115)
              {
                i = j;
              }
              else
              {
                i = j;
                if (((String)localObject1).equals("s")) {
                  i = 1;
                }
              }
            }
            else
            {
              i = j;
              if (((String)localObject1).equals("n")) {
                i = 2;
              }
            }
          }
          else
          {
            i = j;
            if (((String)localObject1).equals("i")) {
              i = 3;
            }
          }
        }
        else
        {
          i = j;
          if (((String)localObject1).equals("a")) {
            i = 0;
          }
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Unknown mask mode ");
                ((StringBuilder)localObject1).append(str);
                ((StringBuilder)localObject1).append(". Defaulting to Add.");
                Logger.warning(((StringBuilder)localObject1).toString());
                localObject1 = Mask.MaskMode.MASK_MODE_ADD;
              }
              else
              {
                paramLottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                localObject1 = Mask.MaskMode.MASK_MODE_INTERSECT;
              }
            }
            else {
              localObject1 = Mask.MaskMode.MASK_MODE_NONE;
            }
          }
          else {
            localObject1 = Mask.MaskMode.MASK_MODE_SUBTRACT;
          }
        }
        else {
          localObject1 = Mask.MaskMode.MASK_MODE_ADD;
        }
      }
    }
    paramJsonReader.endObject();
    return new Mask((Mask.MaskMode)localObject1, localAnimatableShapeValue, (AnimatableIntegerValue)localObject2, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.MaskParser
 * JD-Core Version:    0.7.0.1
 */