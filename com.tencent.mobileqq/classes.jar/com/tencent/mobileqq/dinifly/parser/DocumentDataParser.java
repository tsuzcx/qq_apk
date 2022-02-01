package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.DocumentData.Justification;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

public class DocumentDataParser
  implements ValueParser<DocumentData>
{
  public static final DocumentDataParser INSTANCE = new DocumentDataParser();
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of" });
  
  public DocumentData parse(JsonReader paramJsonReader, float paramFloat)
  {
    DocumentData.Justification localJustification = DocumentData.Justification.CENTER;
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = str2;
    float f3 = 0.0F;
    int k = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    int j = 0;
    int i = 0;
    paramFloat = 0.0F;
    boolean bool = true;
    while (paramJsonReader.hasNext()) {
      switch (paramJsonReader.selectName(NAMES))
      {
      default: 
        paramJsonReader.skipName();
        paramJsonReader.skipValue();
        break;
      case 10: 
        bool = paramJsonReader.nextBoolean();
        break;
      case 9: 
        paramFloat = (float)paramJsonReader.nextDouble();
        break;
      case 8: 
        i = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 7: 
        j = JsonUtils.jsonToColor(paramJsonReader);
        break;
      case 6: 
        f1 = (float)paramJsonReader.nextDouble();
        break;
      case 5: 
        f2 = (float)paramJsonReader.nextDouble();
        break;
      case 4: 
        k = paramJsonReader.nextInt();
        break;
      case 3: 
        int m = paramJsonReader.nextInt();
        if ((m <= DocumentData.Justification.CENTER.ordinal()) && (m >= 0)) {
          localJustification = DocumentData.Justification.values()[m];
        } else {
          localJustification = DocumentData.Justification.CENTER;
        }
        break;
      case 2: 
        f3 = (float)paramJsonReader.nextDouble();
        break;
      case 1: 
        str1 = paramJsonReader.nextString();
        break;
      case 0: 
        str2 = paramJsonReader.nextString();
      }
    }
    paramJsonReader.endObject();
    return new DocumentData(str2, str1, f3, localJustification, k, f2, f1, j, i, paramFloat, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.DocumentDataParser
 * JD-Core Version:    0.7.0.1
 */