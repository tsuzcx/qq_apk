package com.tencent.ttpic.baseutils.string;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringUtils
{
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return (paramCharSequence1 != null) && (paramCharSequence1.equals(paramCharSequence2));
  }
  
  public static String removeEmoji(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replaceAll("\\[em\\].*?\\[/em\\]", "");
  }
  
  public static String removeNoisyChar(String paramString)
  {
    return paramString.replaceAll("[/~!@#$%^&*\\(\\)_+\\{\\}:<>?\\[\\],./;'`\\-=\\|／～！＠＃＄％＾＆＊（）＿＋｛｝：＜＞？［］，。．／；＇`－＝｜、]+", "");
  }
  
  public static String removeUTF8Emoji(String paramString)
  {
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramString.length())
    {
      int j = Character.getType(paramString.charAt(i));
      if ((j == 19) || (j == 28)) {
        ((Set)localObject).add(Character.valueOf(paramString.charAt(i)));
      }
      i += 1;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString = paramString.replace(String.valueOf((Character)((Iterator)localObject).next()), "");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.string.StringUtils
 * JD-Core Version:    0.7.0.1
 */