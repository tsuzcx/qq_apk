package com.tencent.tencent_richtext_library.richtext.matcher;

import com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Pattern;

public class TagMatcher
  extends TextMatcher
{
  public static int a = -16777216;
  
  public TagMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static HashMap<String, Object> a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {}
    for (paramString1 = new HashMap();; paramString1 = new HashMap())
    {
      paramString1.put("text", "");
      return paramString1;
      i += paramString2.length();
      if (i <= paramString1.length() - 1) {
        break;
      }
    }
    paramString1 = paramString1.substring(i, paramString1.length() - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label79:
      break label79;
    }
    paramString2 = new HashMap();
    paramString2.put("nodeType", Integer.valueOf(QcircleFlutterTextCellParser.h));
    paramString2.put("text", paramString1);
    paramString2.put("textColor", Integer.valueOf(jdField_a_of_type_Int));
    return paramString2;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return a(this.jdField_a_of_type_JavaLangString, "tagName=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.TagMatcher
 * JD-Core Version:    0.7.0.1
 */