package com.tencent.tencent_richtext_library.richtext.matcher;

import com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Pattern;

public class AtUserMatcher
  extends TextMatcher
{
  public static int a = -16777216;
  
  public AtUserMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static HashMap<String, Object> a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("uin:");
    int j = "uin:".length();
    int k = paramString1.indexOf(paramString2);
    if (k == -1)
    {
      paramString1 = new HashMap();
      paramString1.put("text", "");
      return paramString1;
    }
    String str = paramString1.substring(i + j, k);
    j = paramString1.indexOf(",who:", k);
    i = j;
    if (j == -1) {
      i = paramString1.length() - 1;
    }
    j = paramString1.indexOf(",superLike:");
    if (j != -1) {
      i = j;
    }
    j = i;
    if (i == -1) {
      j = paramString1.length() - 1;
    }
    paramString1 = paramString1.substring(paramString2.length() + k, j);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label129:
      break label129;
    }
    paramString2 = new HashMap();
    paramString2.put("nodeType", Integer.valueOf(QcircleFlutterTextCellParser.b));
    paramString2.put("text", paramString1);
    paramString2.put("uinStr", str);
    paramString2.put("textColor", Integer.valueOf(jdField_a_of_type_Int));
    return paramString2;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    return a(this.jdField_a_of_type_JavaLangString, ",nick:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.AtUserMatcher
 * JD-Core Version:    0.7.0.1
 */