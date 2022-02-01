package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape;
import com.tencent.mobileqq.dinifly.model.content.PolystarShape.Type;

class PolystarShapeParser
{
  static PolystarShape parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    Object localObject1 = str1;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    Object localObject6 = localObject5;
    Object localObject7 = localObject6;
    Object localObject8 = localObject7;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = str2.hashCode();
      if (i != 112)
      {
        if (i != 114)
        {
          if (i != 3324)
          {
            if (i != 3519)
            {
              if (i != 3588)
              {
                if (i != 3686)
                {
                  if (i != 3369)
                  {
                    if (i != 3370)
                    {
                      if (i != 3555)
                      {
                        if ((i == 3556) && (str2.equals("os")))
                        {
                          i = 6;
                          break label283;
                        }
                      }
                      else if (str2.equals("or"))
                      {
                        i = 5;
                        break label283;
                      }
                    }
                    else if (str2.equals("is"))
                    {
                      i = 8;
                      break label283;
                    }
                  }
                  else if (str2.equals("ir"))
                  {
                    i = 7;
                    break label283;
                  }
                }
                else if (str2.equals("sy"))
                {
                  i = 1;
                  break label283;
                }
              }
              else if (str2.equals("pt"))
              {
                i = 2;
                break label283;
              }
            }
            else if (str2.equals("nm"))
            {
              i = 0;
              break label283;
            }
          }
          else if (str2.equals("hd"))
          {
            i = 9;
            break label283;
          }
        }
        else if (str2.equals("r"))
        {
          i = 4;
          break label283;
        }
      }
      else if (str2.equals("p"))
      {
        i = 3;
        break label283;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 9: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 8: 
        localObject7 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 7: 
        localObject5 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 6: 
        localObject8 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 5: 
        localObject6 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localObject4 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 3: 
        localObject3 = AnimatablePathValueParser.parseSplitPath(paramJsonReader, paramLottieComposition);
        break;
      case 2: 
        localObject2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition, false);
        break;
      case 1: 
        localObject1 = PolystarShape.Type.forValue(paramJsonReader.nextInt());
        break;
      case 0: 
        label283:
        str1 = paramJsonReader.nextString();
      }
    }
    return new PolystarShape(str1, (PolystarShape.Type)localObject1, (AnimatableFloatValue)localObject2, (AnimatableValue)localObject3, (AnimatableFloatValue)localObject4, (AnimatableFloatValue)localObject5, (AnimatableFloatValue)localObject6, (AnimatableFloatValue)localObject7, (AnimatableFloatValue)localObject8, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PolystarShapeParser
 * JD-Core Version:    0.7.0.1
 */