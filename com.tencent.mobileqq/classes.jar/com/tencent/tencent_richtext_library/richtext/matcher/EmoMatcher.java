package com.tencent.tencent_richtext_library.richtext.matcher;

import com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser;
import java.util.HashMap;
import java.util.regex.Pattern;

public class EmoMatcher
  extends TextMatcher
{
  public EmoMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static String a(String paramString)
  {
    return "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1".replace("$id", paramString);
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramCharSequence = new HashMap();
    try
    {
      paramCharSequence.put("emojiUrl", a(this.a.substring(4, this.a.indexOf("[/em]"))));
      paramCharSequence.put("nodeType", Integer.valueOf(QcircleFlutterTextCellParser.d));
      paramCharSequence.put("displayWidth", Double.valueOf(20.0D));
      paramCharSequence.put("displayHeight", Double.valueOf(20.0D));
      return paramCharSequence;
    }
    catch (Exception localException) {}
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.EmoMatcher
 * JD-Core Version:    0.7.0.1
 */