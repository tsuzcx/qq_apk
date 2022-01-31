package com.tencent.mobileqq.lovelanguage;

import android.text.TextUtils;

public class LoveLanguageConfig
{
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "asshole", "bitch", "damn you", "fuck", "go to hell", "shit", "爆菊", "碧莲", "婊子", "草泥马", "尼玛", "丢你老母", "法克鱿", "狗屁", "滚蛋", "绿茶婊", "去你大爷", "去你妈的", "我去你妹", "死胖子", "日你妈", "弱智", "他妈的", "王八蛋", "我靠", "猪一样", "fatty", "idiot", "菊花残", "没屁眼", "臭婊砸", "贱逼", "该死的", "操你", "去死吧", "白痴", "傻瓜", "痴线", "傻屌", "傻逼", "吃屎", "捅你菊花", "插你菊花", "屁眼交易", "卧槽", "我操", "丢雷老母", "狗屎", "混蛋", "操蛋", "妈蛋", "老不死", "你妈逼", "干你妹的", "操你妹的", "表要脸", "去他喵的", "龟儿子", "老王八", "龟孙", "我日", "狗日的", "猪脑", "猪头", "心机婊", "我草", "脑残" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130839304, 2130839305, 2130839316, 2130839323, 2130839324, 2130839325, 2130839326, 2130839327, 2130839328, 2130839329, 2130839329, 2130839307, 2130839308, 2130839309, 2130839310, 2130839311, 2130839312, 2130839313, 2130839314, 2130839315, 2130839317, 2130839318, 2130839319, 2130839320, 2130839321, 2130839322, 2130839315, 2130839318, 2130839304, 2130839304, 2130839305, 2130839305, 2130839316, 2130839323, 2130839324, 2130839318, 2130839318, 2130839318, 2130839318, 2130839318, 2130839325, 2130839326, 2130839326, 2130839326, 2130839306, 2130839306, 2130839307, 2130839309, 2130839310, 2130839310, 2130839310, 2130839312, 2130839313, 2130839314, 2130839314, 2130839328, 2130839319, 2130839320, 2130839320, 2130839320, 2130839317, 2130839317, 2130839322, 2130839322, 2130839311, 2130839306, 2130839318 };
  }
  
  public static int a(char paramChar)
  {
    return paramChar - '\036';
  }
  
  public static int a(int paramInt)
  {
    return paramInt + 30;
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt >= jdField_a_of_type_ArrayOfInt.length)) {
      throw new IllegalArgumentException("love language invalid index: " + paramInt);
    }
    int n;
    int m;
    if (((paramInt >= 0) && (paramInt <= 5)) || (paramInt == 26) || (paramInt == 27))
    {
      int j = 64;
      int i = 64;
      int k = 0;
      n = j;
      m = i;
      if (k < paramString.length())
      {
        m = j;
        n = i;
        if (Character.isUpperCase(paramString.charAt(k)))
        {
          if (k >= 6) {
            break label140;
          }
          n = i | 1 << 6 - k - 1;
          m = j;
        }
        for (;;)
        {
          k += 1;
          j = m;
          i = n;
          break;
          label140:
          m = j | 1 << 12 - k - 1;
          n = i;
        }
      }
    }
    else
    {
      n = 64;
      m = 64;
    }
    return String.valueOf(new char[] { '\021', (char)a(paramInt), (char)m, (char)n });
  }
  
  public static String a(String paramString)
  {
    int i = a(paramString.charAt(1));
    String str = jdField_a_of_type_ArrayOfJavaLangString[i];
    int k = paramString.charAt(2);
    int m = paramString.charAt(3);
    paramString = new StringBuilder(10);
    if (((i >= 0) && (i <= 5)) || (i == 26) || (i == 27))
    {
      i = 0;
      if (i < str.length())
      {
        int j;
        if (i < 6)
        {
          j = 6 - i - 1;
          j = (1 << j & k) >> j;
          label94:
          if (j != 1) {
            break label142;
          }
        }
        label142:
        for (char c = (char)(str.charAt(i) - ' ');; c = str.charAt(i))
        {
          paramString.append(c);
          i += 1;
          break;
          j = 12 - i - 1;
          j = (1 << j & m) >> j;
          break label94;
        }
      }
      return paramString.toString();
    }
    return str;
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= '\036') && (paramChar < jdField_a_of_type_ArrayOfJavaLangString.length + 30);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\021')) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.lovelanguage.LoveLanguageConfig
 * JD-Core Version:    0.7.0.1
 */