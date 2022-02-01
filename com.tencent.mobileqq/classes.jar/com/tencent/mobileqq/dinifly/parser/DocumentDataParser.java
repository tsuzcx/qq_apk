package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.DocumentData.Justification;

public class DocumentDataParser
  implements ValueParser<DocumentData>
{
  public static final DocumentDataParser INSTANCE = new DocumentDataParser();
  
  public DocumentData parse(JsonReader paramJsonReader, float paramFloat)
  {
    DocumentData.Justification localJustification = DocumentData.Justification.CENTER;
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = str2;
    double d4 = 0.0D;
    double d1 = d4;
    double d2 = d1;
    double d3 = d2;
    int m = 0;
    int k = 0;
    int j = 0;
    boolean bool = true;
    while (paramJsonReader.hasNext())
    {
      String str3 = paramJsonReader.nextName();
      int i = str3.hashCode();
      if (i != 102)
      {
        if (i != 106)
        {
          if (i != 3261)
          {
            if (i != 3452)
            {
              if (i != 3463)
              {
                if (i != 3543)
                {
                  if (i != 3664)
                  {
                    if (i != 3684)
                    {
                      if (i != 3710)
                      {
                        if (i != 115)
                        {
                          if ((i == 116) && (str3.equals("t")))
                          {
                            i = 0;
                            break label332;
                          }
                        }
                        else if (str3.equals("s"))
                        {
                          i = 2;
                          break label332;
                        }
                      }
                      else if (str3.equals("tr"))
                      {
                        i = 4;
                        break label332;
                      }
                    }
                    else if (str3.equals("sw"))
                    {
                      i = 9;
                      break label332;
                    }
                  }
                  else if (str3.equals("sc"))
                  {
                    i = 8;
                    break label332;
                  }
                }
                else if (str3.equals("of"))
                {
                  i = 10;
                  break label332;
                }
              }
              else if (str3.equals("ls"))
              {
                i = 6;
                break label332;
              }
            }
            else if (str3.equals("lh"))
            {
              i = 5;
              break label332;
            }
          }
          else if (str3.equals("fc"))
          {
            i = 7;
            break label332;
          }
        }
        else if (str3.equals("j"))
        {
          i = 3;
          break label332;
        }
      }
      else if (str3.equals("f"))
      {
        i = 1;
        break label332;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 10: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 9: 
        d3 = paramJsonReader.nextDouble();
        break;
      case 8: 
        j = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 7: 
        k = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 6: 
        d2 = paramJsonReader.nextDouble();
        break;
      case 5: 
        d1 = paramJsonReader.nextDouble();
        break;
      case 4: 
        m = paramJsonReader.nextInt();
        break;
      case 3: 
        i = paramJsonReader.nextInt();
        if ((i <= DocumentData.Justification.CENTER.ordinal()) && (i >= 0)) {
          localJustification = DocumentData.Justification.values()[i];
        } else {
          localJustification = DocumentData.Justification.CENTER;
        }
        break;
      case 2: 
        d4 = paramJsonReader.nextDouble();
        break;
      case 1: 
        str1 = paramJsonReader.nextString();
        break;
      case 0: 
        label332:
        str2 = paramJsonReader.nextString();
      }
    }
    paramJsonReader.endObject();
    return new DocumentData(str2, str1, d4, localJustification, m, d1, d2, k, j, d3, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.DocumentDataParser
 * JD-Core Version:    0.7.0.1
 */