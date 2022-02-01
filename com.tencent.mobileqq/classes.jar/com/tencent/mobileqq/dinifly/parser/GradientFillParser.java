package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientFill;
import com.tencent.mobileqq.dinifly.model.content.GradientType;

class GradientFillParser
{
  static GradientFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    Object localObject6 = Path.FillType.WINDING;
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    boolean bool = false;
    Object localObject7 = localObject1;
    while (paramJsonReader.hasNext())
    {
      localObject1 = paramJsonReader.nextName();
      int i = ((String)localObject1).hashCode();
      if (i != 101)
      {
        if (i != 103)
        {
          if (i != 111)
          {
            if (i != 3324)
            {
              if (i != 3519)
              {
                switch (i)
                {
                default: 
                  break;
                case 116: 
                  if (!((String)localObject1).equals("t")) {
                    break;
                  }
                  i = 3;
                  break;
                case 115: 
                  if (!((String)localObject1).equals("s")) {
                    break;
                  }
                  i = 4;
                  break;
                case 114: 
                  if (!((String)localObject1).equals("r")) {
                    break;
                  }
                  i = 6;
                  break;
                }
              }
              else if (((String)localObject1).equals("nm"))
              {
                i = 0;
                break label239;
              }
            }
            else if (((String)localObject1).equals("hd"))
            {
              i = 7;
              break label239;
            }
          }
          else if (((String)localObject1).equals("o"))
          {
            i = 2;
            break label239;
          }
        }
        else if (((String)localObject1).equals("g"))
        {
          i = 1;
          break label239;
        }
      }
      else if (((String)localObject1).equals("e"))
      {
        i = 5;
        break label239;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 7: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 6: 
        if (paramJsonReader.nextInt() == 1) {
          localObject1 = Path.FillType.WINDING;
        } else {
          localObject1 = Path.FillType.EVEN_ODD;
        }
        localObject6 = localObject1;
        break;
      case 5: 
        localObject5 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 4: 
        localObject4 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        break;
      case 3: 
        if (paramJsonReader.nextInt() == 1) {
          localObject1 = GradientType.LINEAR;
        } else {
          localObject1 = GradientType.RADIAL;
        }
        localObject7 = localObject1;
        break;
      case 2: 
        localObject3 = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
        break;
      case 1: 
        paramJsonReader.beginObject();
        int j = -1;
        while (paramJsonReader.hasNext())
        {
          localObject1 = paramJsonReader.nextName();
          i = ((String)localObject1).hashCode();
          if (i != 107)
          {
            if ((i == 112) && (((String)localObject1).equals("p")))
            {
              i = 0;
              break label462;
            }
          }
          else if (((String)localObject1).equals("k"))
          {
            i = 1;
            break label462;
          }
          i = -1;
          label462:
          if (i != 0)
          {
            if (i != 1) {
              paramJsonReader.skipValue();
            } else {
              localObject2 = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, j);
            }
          }
          else {
            j = paramJsonReader.nextInt();
          }
        }
        paramJsonReader.endObject();
        break;
      case 0: 
        label239:
        str = paramJsonReader.nextString();
      }
    }
    return new GradientFill(str, localObject7, (Path.FillType)localObject6, (AnimatableGradientColorValue)localObject2, (AnimatableIntegerValue)localObject3, (AnimatablePointValue)localObject4, (AnimatablePointValue)localObject5, null, null, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientFillParser
 * JD-Core Version:    0.7.0.1
 */