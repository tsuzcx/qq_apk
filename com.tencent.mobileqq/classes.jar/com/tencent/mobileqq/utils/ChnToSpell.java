package com.tencent.mobileqq.utils;

import android.support.v4.util.LruCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChnToSpell
{
  private static LruCache<String, ChnToSpell.ChnSpelling> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private static Map<String, String[]> jdField_a_of_type_JavaUtilMap;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final String[] a;
  private static short[] jdField_a_of_type_ArrayOfShort;
  private static LruCache<String, ChnToSpell.ChnSpelling> b;
  public static final String[] b;
  private static LruCache<String, ChnToSpell.ChnSpellingAll> jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "b-a", "b-ai", "b-an", "b-ang", "b-ao", "b-ei", "b-en", "b-eng", "b-i", "b-ian", "b-iao", "b-ie", "b-in", "b-ing", "b-o", "b-u", "c-a", "c-ai", "c-an", "c-ang", "c-ao", "c-e", "c-eng", "ch-a", "ch-ai", "ch-an", "ch-ang", "ch-ao", "ch-e", "ch-en", "ch-eng", "ch-i", "ch-ong", "ch-ou", "ch-u", "ch-uai", "ch-uan", "ch-uang", "ch-ui", "ch-un", "ch-uo", "c-i", "c-ong", "c-ou", "c-u", "c-uan", "c-ui", "c-un", "c-uo", "d-a", "d-ai", "d-an", "d-ang", "d-ao", "d-e", "d-eng", "d-i", "d-ian", "d-iao", "d-ie", "d-ing", "d-iu", "d-ong", "d-ou", "d-u", "d-uan", "d-ui", "d-un", "d-uo", "e", "en", "er", "f-a", "f-an", "f-ang", "f-ei", "f-en", "f-eng", "f-u", "f-ou", "g-a", "g-ai", "g-an", "g-ang", "g-ao", "g-e", "j-i", "g-en", "g-eng", "g-ong", "g-ou", "g-u", "g-ua", "g-uai", "g-uan", "g-uang", "g-ui", "g-un", "g-uo", "h-a", "h-ai", "h-an", "h-ang", "h-ao", "h-e", "h-ei", "h-en", "h-eng", "h-ong", "h-ou", "h-u", "h-ua", "h-uai", "h-uan", "h-uang", "h-ui", "h-un", "h-uo", "j-ia", "j-ian", "j-iang", "q-iao", "j-iao", "j-ie", "j-in", "j-ing", "j-iong", "j-iu", "j-u", "j-uan", "j-ue", "j-un", "k-a", "k-ai", "k-an", "k-ang", "k-ao", "k-e", "k-en", "k-eng", "k-ong", "k-ou", "k-u", "k-ua", "k-uai", "k-uan", "k-uang", "k-ui", "k-un", "k-uo", "l-a", "l-ai", "l-an", "l-ang", "l-ao", "l-e", "l-ei", "l-eng", "l-i", "l-ia", "l-ian", "l-iang", "l-iao", "l-ie", "l-in", "l-ing", "l-iu", "l-ong", "l-ou", "l-u", "l-uan", "l-ue", "l-un", "l-uo", "m-a", "m-ai", "m-an", "m-ang", "m-ao", "m-e", "m-ei", "m-en", "m-eng", "m-i", "m-ian", "m-iao", "m-ie", "m-in", "m-ing", "m-iu", "m-o", "m-ou", "m-u", "n-a", "n-ai", "n-an", "n-ang", "n-ao", "n-e", "n-ei", "n-en", "n-eng", "n-i", "n-ian", "n-iang", "n-iao", "n-ie", "n-in", "n-ing", "n-iu", "n-ong", "n-u", "n-uan", "n-ue", "y-ao", "n-uo", "o", "ou", "p-a", "p-ai", "p-an", "p-ang", "p-ao", "p-ei", "p-en", "p-eng", "p-i", "p-ian", "p-iao", "p-ie", "p-in", "p-ing", "p-o", "p-ou", "p-u", "q-i", "q-ia", "q-ian", "q-iang", "q-ie", "q-in", "q-ing", "q-iong", "q-iu", "q-u", "q-uan", "q-ue", "q-un", "r-an", "r-ang", "r-ao", "r-e", "r-en", "r-eng", "r-i", "r-ong", "r-ou", "r-u", "r-uan", "r-ui", "r-un", "r-uo", "s-a", "s-ai", "s-an", "s-ang", "s-ao", "s-e", "s-en", "s-eng", "sh-a", "sh-ai", "sh-an", "sh-ang", "sh-ao", "sh-e", "sh-en", "sh-eng", "sh-i", "sh-ou", "sh-u", "sh-ua", "sh-uai", "sh-uan", "sh-uang", "sh-ui", "sh-un", "sh-uo", "s-i", "s-ong", "s-ou", "s-u", "s-uan", "s-ui", "s-un", "s-uo", "t-a", "t-ai", "t-an", "t-ang", "t-ao", "t-e", "t-eng", "t-i", "t-ian", "t-iao", "t-ie", "t-ing", "t-ong", "t-ou", "t-u", "t-uan", "t-ui", "t-un", "t-uo", "w-a", "w-ai", "w-an", "w-ang", "w-ei", "w-en", "w-eng", "w-o", "w-u", "x-i", "x-ia", "x-ian", "x-iang", "x-iao", "x-ie", "x-in", "x-ing", "x-iong", "x-iu", "x-u", "x-uan", "x-ue", "x-un", "y-a", "y-an", "y-ang", "y-e", "y-i", "y-in", "y-ing", "y-o", "y-ong", "y-ou", "y-u", "y-uan", "y-ue", "y-un", "z-a", "z-ai", "z-an", "z-ang", "z-ao", "z-e", "z-ei", "z-en", "z-eng", "zh-a", "zh-ai", "zh-an", "zh-ang", "zh-ao", "zh-e", "zh-en", "zh-eng", "zh-i", "zh-ong", "zh-ou", "zh-u", "zh-ua", "zh-uai", "zh-uan", "zh-uang", "zh-ui", "zh-un", "zh-uo", "z-i", "z-ong", "z-ou", "z-u", "z-uan", "z-ui", "z-un", "z-uo", "ei", "m", "n", "d-ia", "c-en", "n-ou", "j-v", "q-v", "x-v", "l-v", "n-v" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 47, 58, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, 2147483647 };
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
    jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
  }
  
  public static ChnToSpell.CharSpelling a(char paramChar)
  {
    ChnToSpell.CharSpelling localCharSpelling = new ChnToSpell.CharSpelling();
    int i = Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, paramChar);
    if (i != -14)
    {
      if (i != -12)
      {
        if (i != -7)
        {
          if (i != -5)
          {
            if (i != -3)
            {
              localCharSpelling.jdField_a_of_type_Int = 6;
              localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
              return localCharSpelling;
            }
            localCharSpelling.jdField_a_of_type_Int = 4;
            localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
            return localCharSpelling;
          }
          localCharSpelling.jdField_a_of_type_Int = 2;
          localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
          return localCharSpelling;
        }
        localCharSpelling.jdField_a_of_type_Int = 3;
        localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
        return localCharSpelling;
      }
      localCharSpelling.jdField_a_of_type_Int = 1;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
      return localCharSpelling;
    }
    localCharSpelling.jdField_a_of_type_Int = 5;
    localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
    return localCharSpelling;
  }
  
  public static ChnToSpell.CharSpelling a(char paramChar, int paramInt)
  {
    ChnToSpell.CharSpelling localCharSpelling = new ChnToSpell.CharSpelling();
    if (paramInt == 0)
    {
      if (paramChar == '单')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "shan";
        return localCharSpelling;
      }
      if (paramChar == '仇')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "qiu";
        return localCharSpelling;
      }
      if (paramChar == '曾')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "zeng";
        return localCharSpelling;
      }
    }
    paramInt = Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, paramChar);
    if (paramInt != -14)
    {
      if (paramInt != -12)
      {
        if (paramInt != -9)
        {
          if (paramInt != -7)
          {
            if (paramInt != -5)
            {
              if (paramInt != 7)
              {
                if (Character.isHighSurrogate(paramChar))
                {
                  localCharSpelling.jdField_a_of_type_Int = 0;
                  localCharSpelling.jdField_a_of_type_JavaLangString = "??";
                  return localCharSpelling;
                }
                localCharSpelling.jdField_a_of_type_Int = 0;
                localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
                return localCharSpelling;
              }
              localCharSpelling.jdField_a_of_type_Int = 2;
              localCharSpelling.jdField_a_of_type_JavaLangString = "ling";
              return localCharSpelling;
            }
            localCharSpelling.jdField_a_of_type_Int = 4;
            localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
            return localCharSpelling;
          }
          localCharSpelling.jdField_a_of_type_Int = 3;
          localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
          return localCharSpelling;
        }
        int i = paramChar - 'Ⅰ';
        String[] arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
        paramInt = i;
        if (i >= arrayOfString.length) {
          paramInt = i - arrayOfString.length;
        }
        localCharSpelling.jdField_a_of_type_Int = 1;
        localCharSpelling.jdField_a_of_type_JavaLangString = jdField_c_of_type_ArrayOfJavaLangString[paramInt];
        return localCharSpelling;
      }
      localCharSpelling.jdField_a_of_type_Int = 5;
      localCharSpelling.jdField_a_of_type_JavaLangString = jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(paramChar - '一')]];
      return localCharSpelling;
    }
    localCharSpelling.jdField_a_of_type_Int = 6;
    localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
    return localCharSpelling;
  }
  
  public static ChnToSpell.ChnSpelling a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramInt == 1)
      {
        localChnSpelling = (ChnToSpell.ChnSpelling)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localChnSpelling != null) {
          return localChnSpelling;
        }
      }
      else if (paramInt == 2)
      {
        localChnSpelling = (ChnToSpell.ChnSpelling)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localChnSpelling != null) {
          return localChnSpelling;
        }
      }
      ChnToSpell.ChnSpelling localChnSpelling = new ChnToSpell.ChnSpelling();
      localChnSpelling.jdField_a_of_type_Int = paramInt;
      localChnSpelling.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (jdField_a_of_type_ArrayOfShort == null) {
        b();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int n = paramString.length();
      int j = paramString.charAt(0);
      if (j == 21333)
      {
        if (paramInt == 1) {
          localStringBuilder.append("shan");
        } else if (paramInt == 2) {
          localStringBuilder.append('s');
        }
        localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      for (;;)
      {
        j = 1;
        break label664;
        if (j == 20167)
        {
          if (paramInt == 1) {
            localStringBuilder.append("qiu");
          } else if (paramInt == 2) {
            localStringBuilder.append('q');
          }
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
        }
        else
        {
          if (j != 26366) {
            break;
          }
          if (paramInt == 1) {
            localStringBuilder.append("zeng");
          } else if (paramInt == 2) {
            localStringBuilder.append('z');
          }
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
        }
      }
      if (j == 19975)
      {
        if ((paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
          break label662;
        }
        if (paramInt == 1)
        {
          localStringBuilder.append("moqi");
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
        }
        else if (paramInt == 2)
        {
          localStringBuilder.append("mq");
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
        }
      }
      else
      {
        if (j != 37325) {
          break label542;
        }
        if (paramString.length() <= 1) {
          break label662;
        }
        if (paramString.charAt(1) == '庆')
        {
          if (paramInt == 1)
          {
            localStringBuilder.append("chongqing");
            localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
            localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(5));
          }
          else if (paramInt == 2)
          {
            localStringBuilder.append("cq");
            localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
            localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
          }
        }
        else {
          localStringBuilder.append("z");
        }
      }
      for (;;)
      {
        j = 2;
        break label664;
        label542:
        if ((j != 38271) || (paramString.length() <= 1) || (paramString.charAt(1) != '沙')) {
          break;
        }
        if (paramInt == 1)
        {
          localStringBuilder.append("changsha");
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(5));
        }
        else if (paramInt == 2)
        {
          localStringBuilder.append("cs");
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
        }
      }
      label662:
      j = 0;
      label664:
      while (j < n)
      {
        int i = paramString.charAt(j);
        localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder.length()));
        int k = Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i);
        if (k != -14)
        {
          if (k != -12)
          {
            if (k != -9)
            {
              if (k != -7)
              {
                if (k != -5)
                {
                  if (k != 7)
                  {
                    if (Character.isHighSurrogate(i))
                    {
                      localStringBuilder.append('?');
                      localChnSpelling.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder.length()));
                      localStringBuilder.append('?');
                      j += 1;
                    }
                    else
                    {
                      localStringBuilder.append(i);
                    }
                  }
                  else if (paramInt == 1) {
                    localStringBuilder.append("ling");
                  } else {
                    localStringBuilder.append('l');
                  }
                }
                else {
                  localStringBuilder.append(Character.toLowerCase(i));
                }
              }
              else {
                localStringBuilder.append(i);
              }
            }
            else
            {
              int m = i - 8544;
              String[] arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
              k = m;
              if (m >= arrayOfString.length) {
                k = m - arrayOfString.length;
              }
              localStringBuilder.append(jdField_c_of_type_ArrayOfJavaLangString[k]);
            }
          }
          else if (paramInt == 1) {
            localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]]);
          } else {
            localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]].charAt(0));
          }
        }
        else {
          localStringBuilder.append(Character.toLowerCase((char)(i - 65248)));
        }
        j += 1;
      }
      localChnSpelling.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      if (paramInt == 1)
      {
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localChnSpelling);
        return localChnSpelling;
      }
      if (paramInt == 2) {
        jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localChnSpelling);
      }
      return localChnSpelling;
    }
    paramString = new ChnToSpell.ChnSpelling();
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramString.jdField_a_of_type_JavaLangString = "";
    return paramString;
  }
  
  public static ChnToSpell.ChnSpellingAll a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      ChnToSpell.ChnSpellingAll localChnSpellingAll = (ChnToSpell.ChnSpellingAll)jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localChnSpellingAll != null) {
        return localChnSpellingAll;
      }
      localChnSpellingAll = new ChnToSpell.ChnSpellingAll();
      localChnSpellingAll.jdField_a_of_type_JavaUtilList = new ArrayList();
      localChnSpellingAll.jdField_b_of_type_JavaUtilList = new ArrayList();
      localChnSpellingAll.jdField_c_of_type_JavaUtilList = new ArrayList();
      localChnSpellingAll.jdField_d_of_type_JavaUtilList = new ArrayList();
      if (jdField_a_of_type_ArrayOfShort == null) {
        b();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder3 = new StringBuilder();
      int n = paramString.length();
      int j = paramString.charAt(0);
      if (j == 21333)
      {
        localStringBuilder1.append("shan");
        localStringBuilder2.append('s');
        localStringBuilder3.append("sh-an");
        localStringBuilder3.append("#");
        localChnSpellingAll.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
        localChnSpellingAll.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
        localChnSpellingAll.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      for (;;)
      {
        j = 1;
        break label413;
        if (j == 20167)
        {
          localStringBuilder1.append("qiu");
          localStringBuilder2.append('q');
          localStringBuilder3.append("q-iu");
          localStringBuilder3.append("#");
          localChnSpellingAll.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpellingAll.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpellingAll.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
        }
        else
        {
          if (j != 26366) {
            break;
          }
          localStringBuilder1.append("zeng");
          localStringBuilder2.append('z');
          localStringBuilder3.append("z-eng");
          localStringBuilder3.append("#");
          localChnSpellingAll.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpellingAll.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
          localChnSpellingAll.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
        }
      }
      j = 0;
      label413:
      while (j < n)
      {
        int i = paramString.charAt(j);
        localChnSpellingAll.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder1.length()));
        localChnSpellingAll.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder2.length()));
        localChnSpellingAll.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder3.length()));
        char c1;
        if ((i != 45) && (i != 35))
        {
          int k = Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i);
          if (k != -14)
          {
            String[] arrayOfString;
            if (k != -12)
            {
              if (k != -9)
              {
                if (k != -7)
                {
                  if (k != -5)
                  {
                    if (k != 7)
                    {
                      if (Character.isHighSurrogate(i))
                      {
                        localStringBuilder1.append('?');
                        localStringBuilder2.append('?');
                        localStringBuilder3.append('?');
                        localStringBuilder3.append("#");
                        localChnSpellingAll.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder1.length()));
                        localChnSpellingAll.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder2.length()));
                        localChnSpellingAll.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder3.length()));
                        localStringBuilder1.append('?');
                        localStringBuilder2.append('?');
                        localStringBuilder3.append('?');
                        localStringBuilder3.append("#");
                        j += 1;
                      }
                      else
                      {
                        localStringBuilder1.append('?');
                        localStringBuilder2.append('?');
                        localStringBuilder3.append('?');
                        localStringBuilder3.append("#");
                      }
                    }
                    else
                    {
                      localStringBuilder1.append("ling");
                      localStringBuilder2.append('l');
                      localStringBuilder3.append("l-ing");
                      localStringBuilder3.append("#");
                    }
                  }
                  else
                  {
                    localStringBuilder1.append(Character.toLowerCase(i));
                    localStringBuilder2.append(Character.toLowerCase(i));
                    localStringBuilder3.append(Character.toLowerCase(i));
                    localStringBuilder3.append("#");
                  }
                }
                else
                {
                  localStringBuilder1.append(i);
                  localStringBuilder2.append(i);
                  localStringBuilder3.append(i);
                  localStringBuilder3.append("#");
                }
              }
              else
              {
                int m = i - 8544;
                arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
                k = m;
                if (m >= arrayOfString.length) {
                  k = m - arrayOfString.length;
                }
                localStringBuilder1.append(jdField_c_of_type_ArrayOfJavaLangString[k]);
                localStringBuilder2.append(jdField_c_of_type_ArrayOfJavaLangString[k]);
                localStringBuilder3.append(jdField_c_of_type_ArrayOfJavaLangString[k]);
                localStringBuilder3.append("#");
              }
            }
            else
            {
              arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
              short[] arrayOfShort = jdField_a_of_type_ArrayOfShort;
              k = i - 19968;
              localStringBuilder1.append(arrayOfString[arrayOfShort[k]]);
              localStringBuilder2.append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[k]].charAt(0));
              localStringBuilder3.append(jdField_b_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[k]]);
              localStringBuilder3.append("#");
            }
          }
          else
          {
            c1 = (char)(i - 65248);
            localStringBuilder1.append(Character.toLowerCase(c1));
            localStringBuilder2.append(Character.toLowerCase(c1));
            localStringBuilder3.append(Character.toLowerCase(c1));
            localStringBuilder3.append("#");
          }
        }
        else
        {
          localStringBuilder1.append(c1);
          localStringBuilder2.append(c1);
          localStringBuilder3.append('0');
          localStringBuilder3.append("#");
        }
        j += 1;
      }
      if (localStringBuilder3.length() > 0) {
        localStringBuilder3.deleteCharAt(localStringBuilder3.length() - 1);
      }
      localChnSpellingAll.jdField_a_of_type_JavaLangString = localStringBuilder1.toString();
      localChnSpellingAll.jdField_a_of_type_JavaUtilList = localChnSpellingAll.jdField_b_of_type_JavaUtilList;
      localChnSpellingAll.jdField_b_of_type_JavaLangString = localStringBuilder1.toString();
      localChnSpellingAll.jdField_c_of_type_JavaLangString = localStringBuilder2.toString();
      localChnSpellingAll.jdField_d_of_type_JavaLangString = localStringBuilder3.toString();
      jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString, localChnSpellingAll);
      return localChnSpellingAll;
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt).jdField_a_of_type_JavaLangString;
  }
  
  private static void a()
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      jdField_a_of_type_JavaUtilMap.put("单", new String[] { "shan", "dan", "chan" });
      jdField_a_of_type_JavaUtilMap.put("折", new String[] { "zhe", "she" });
      jdField_a_of_type_JavaUtilMap.put("着", new String[] { "zhao", "zhuo", "zhe" });
      jdField_a_of_type_JavaUtilMap.put("蕃", new String[] { "bo", "fan" });
      jdField_a_of_type_JavaUtilMap.put("沓", new String[] { "da", "ta" });
      jdField_a_of_type_JavaUtilMap.put("曝", new String[] { "pu", "bao" });
      jdField_a_of_type_JavaUtilMap.put("和", new String[] { "he", "huo", "hu" });
      jdField_a_of_type_JavaUtilMap.put("省", new String[] { "sheng", "xing" });
      jdField_a_of_type_JavaUtilMap.put("拗", new String[] { "niu", "ao" });
      jdField_a_of_type_JavaUtilMap.put("臭", new String[] { "chou", "xiu" });
      jdField_a_of_type_JavaUtilMap.put("度", new String[] { "du", "duo" });
      jdField_a_of_type_JavaUtilMap.put("差", new String[] { "cha", "chai" });
      jdField_a_of_type_JavaUtilMap.put("扎", new String[] { "zha", "za" });
      jdField_a_of_type_JavaUtilMap.put("埋", new String[] { "man", "mai" });
      jdField_a_of_type_JavaUtilMap.put("盛", new String[] { "sheng", "cheng" });
      jdField_a_of_type_JavaUtilMap.put("伧", new String[] { "chen", "cang" });
      jdField_a_of_type_JavaUtilMap.put("伯", new String[] { "bo", "bai" });
      jdField_a_of_type_JavaUtilMap.put("疟", new String[] { "yao", "nue" });
      jdField_a_of_type_JavaUtilMap.put("行", new String[] { "hang", "xing" });
      jdField_a_of_type_JavaUtilMap.put("艾", new String[] { "ai", "yi" });
      jdField_a_of_type_JavaUtilMap.put("传", new String[] { "chuan", "zhuan" });
      jdField_a_of_type_JavaUtilMap.put("奇", new String[] { "ji", "qi" });
      jdField_a_of_type_JavaUtilMap.put("炮", new String[] { "pao", "bao" });
      jdField_a_of_type_JavaUtilMap.put("给", new String[] { "gei", "ji" });
      jdField_a_of_type_JavaUtilMap.put("巷", new String[] { "hang", "xiang" });
      jdField_a_of_type_JavaUtilMap.put("薄", new String[] { "bo", "bao" });
      jdField_a_of_type_JavaUtilMap.put("簿", new String[] { "bo", "bu" });
      jdField_a_of_type_JavaUtilMap.put("拓", new String[] { "ta", "tuo" });
      jdField_a_of_type_JavaUtilMap.put("恶", new String[] { "e", "wu" });
      jdField_a_of_type_JavaUtilMap.put("便", new String[] { "pian", "bian" });
      jdField_a_of_type_JavaUtilMap.put("宿", new String[] { "xiu", "su" });
      jdField_a_of_type_JavaUtilMap.put("藏", new String[] { "zang", "cang" });
      jdField_a_of_type_JavaUtilMap.put("轧", new String[] { "zha", "ya" });
      jdField_a_of_type_JavaUtilMap.put("卡", new String[] { "ka", "qia" });
      jdField_a_of_type_JavaUtilMap.put("调", new String[] { "tiao", "diao" });
      jdField_a_of_type_JavaUtilMap.put("模", new String[] { "mo", "mu" });
      jdField_a_of_type_JavaUtilMap.put("没", new String[] { "mei", "mo" });
      jdField_a_of_type_JavaUtilMap.put("殷", new String[] { "yan", "yin" });
      jdField_a_of_type_JavaUtilMap.put("还", new String[] { "huan", "hai" });
      jdField_a_of_type_JavaUtilMap.put("系", new String[] { "xi", "ji" });
      jdField_a_of_type_JavaUtilMap.put("降", new String[] { "xiang", "jiang" });
      jdField_a_of_type_JavaUtilMap.put("脯", new String[] { "pu", "fu" });
      jdField_a_of_type_JavaUtilMap.put("石", new String[] { "dan", "shi" });
      jdField_a_of_type_JavaUtilMap.put("劲", new String[] { "jing", "jin" });
      jdField_a_of_type_JavaUtilMap.put("茄", new String[] { "jia", "qie" });
      jdField_a_of_type_JavaUtilMap.put("刨", new String[] { "bao", "pao" });
      jdField_a_of_type_JavaUtilMap.put("弹", new String[] { "dan", "tan" });
      jdField_a_of_type_JavaUtilMap.put("颤", new String[] { "zhan", "chan" });
      jdField_a_of_type_JavaUtilMap.put("扒", new String[] { "ba", "pa" });
      jdField_a_of_type_JavaUtilMap.put("数", new String[] { "shu", "shuo" });
      jdField_a_of_type_JavaUtilMap.put("参", new String[] { "cen", "shen", "can" });
      jdField_a_of_type_JavaUtilMap.put("会", new String[] { "hui", "kuai" });
      jdField_a_of_type_JavaUtilMap.put("吓", new String[] { "xia", "he" });
      jdField_a_of_type_JavaUtilMap.put("胖", new String[] { "pang", "pan" });
      jdField_a_of_type_JavaUtilMap.put("耙", new String[] { "ba", "pa" });
      jdField_a_of_type_JavaUtilMap.put("伺", new String[] { "si", "ci" });
      jdField_a_of_type_JavaUtilMap.put("咳", new String[] { "hai", "ke" });
      jdField_a_of_type_JavaUtilMap.put("囤", new String[] { "dun", "tun" });
      jdField_a_of_type_JavaUtilMap.put("澄", new String[] { "deng", "cheng" });
      jdField_a_of_type_JavaUtilMap.put("得", new String[] { "de", "dei" });
      jdField_a_of_type_JavaUtilMap.put("屏", new String[] { "ping", "bing" });
      jdField_a_of_type_JavaUtilMap.put("乐", new String[] { "yue", "le" });
      jdField_a_of_type_JavaUtilMap.put("了", new String[] { "liao", "le" });
      jdField_a_of_type_JavaUtilMap.put("吭", new String[] { "keng", "hang" });
      jdField_a_of_type_JavaUtilMap.put("粘", new String[] { "nian", "zhan" });
      jdField_a_of_type_JavaUtilMap.put("畜", new String[] { "xu", "chu" });
      jdField_a_of_type_JavaUtilMap.put("称", new String[] { "chen", "cheng" });
      jdField_a_of_type_JavaUtilMap.put("弄", new String[] { "long", "nong" });
      jdField_a_of_type_JavaUtilMap.put("俩", new String[] { "lia", "liang" });
      jdField_a_of_type_JavaUtilMap.put("露", new String[] { "lu", "lou" });
      jdField_a_of_type_JavaUtilMap.put("重", new String[] { "zhong", "chong" });
      jdField_a_of_type_JavaUtilMap.put("率", new String[] { "shuai", "lu" });
      jdField_a_of_type_JavaUtilMap.put("泊", new String[] { "bo", "po" });
      jdField_a_of_type_JavaUtilMap.put("朝", new String[] { "chao", "zhao" });
      jdField_a_of_type_JavaUtilMap.put("校", new String[] { "xiao", "jiao" });
      jdField_a_of_type_JavaUtilMap.put("强", new String[] { "qiang", "jiang" });
      jdField_a_of_type_JavaUtilMap.put("塞", new String[] { "se", "sai" });
      jdField_a_of_type_JavaUtilMap.put("辟", new String[] { "bi", "pi" });
      jdField_a_of_type_JavaUtilMap.put("都", new String[] { "du", "dou" });
      jdField_a_of_type_JavaUtilMap.put("匙", new String[] { "chi", "shi" });
      jdField_a_of_type_JavaUtilMap.put("查", new String[] { "zha", "cha" });
      jdField_a_of_type_JavaUtilMap.put("曾", new String[] { "zeng", "ceng" });
      jdField_a_of_type_JavaUtilMap.put("解", new String[] { "xie", "jie" });
      jdField_a_of_type_JavaUtilMap.put("颉", new String[] { "xie", "jie", "jia" });
      jdField_a_of_type_JavaUtilMap.put("莘", new String[] { "shen", "xin" });
      jdField_a_of_type_JavaUtilMap.put("召", new String[] { "shao", "zhao" });
      jdField_a_of_type_JavaUtilMap.put("仇", new String[] { "qiu", "chou" });
      jdField_a_of_type_JavaUtilMap.put("区", new String[] { "ou", "qu" });
      jdField_a_of_type_JavaUtilMap.put("圈", new String[] { "juan", "quan" });
      jdField_a_of_type_JavaUtilMap.put("炅", new String[] { "gui", "jiong" });
      jdField_a_of_type_JavaUtilMap.put("秘", new String[] { "bi", "mi", "bei" });
      jdField_a_of_type_JavaUtilMap.put("尉", new String[] { "wei" });
      jdField_a_of_type_JavaUtilMap.put("万", new String[] { "wan", "mo" });
      jdField_a_of_type_JavaUtilMap.put("覃", new String[] { "qin", "tan", "xun" });
      jdField_a_of_type_JavaUtilMap.put("隗", new String[] { "kui", "wei", "yu" });
      jdField_a_of_type_JavaUtilMap.put("宓", new String[] { "fu", "mi" });
      jdField_a_of_type_JavaUtilMap.put("郇", new String[] { "huan", "xun" });
      jdField_a_of_type_JavaUtilMap.put("种", new String[] { "zhong", "chong" });
      jdField_a_of_type_JavaUtilMap.put("嚼", new String[] { "jiao", "jue" });
      jdField_a_of_type_JavaUtilMap.put("咽", new String[] { "yan", "ye" });
      jdField_a_of_type_JavaUtilMap.put("落", new String[] { "la", "luo" });
      jdField_a_of_type_JavaUtilMap.put("乘", new String[] { "cheng", "sheng" });
      jdField_a_of_type_JavaUtilMap.put("佛", new String[] { "fo", "fu" });
      jdField_a_of_type_JavaUtilMap.put("长", new String[] { "chang", "zhang" });
      jdField_a_of_type_JavaUtilMap.put("提", new String[] { "ti", "di" });
      jdField_a_of_type_JavaUtilMap.put("攒", new String[] { "cuan", "zan" });
      jdField_a_of_type_JavaUtilMap.put("大", new String[] { "dai", "da" });
      jdField_a_of_type_JavaUtilMap.put("厦", new String[] { "sha", "xia" });
      jdField_a_of_type_JavaUtilMap.put("觉", new String[] { "jiao", "jue" });
      jdField_a_of_type_JavaUtilMap.put("车", new String[] { "che", "ju" });
      jdField_a_of_type_JavaUtilMap.put("禅", new String[] { "chan", "shan" });
      jdField_a_of_type_JavaUtilMap.put("刹", new String[] { "cha", "sha" });
      jdField_a_of_type_JavaUtilMap.put("膀", new String[] { "bang", "pang" });
      jdField_a_of_type_JavaUtilMap.put("剥", new String[] { "bao", "pu" });
      jdField_a_of_type_JavaUtilMap.put("骠", new String[] { "biao", "piao" });
      jdField_a_of_type_JavaUtilMap.put("堡", new String[] { "bao", "pu" });
      jdField_a_of_type_JavaUtilMap.put("爪", new String[] { "zhua", "zhao" });
    }
  }
  
  public static String[] a(String paramString)
  {
    
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String[])jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return new String[] { a(paramString, 1) };
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 1710	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   6: ifnull +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: sipush 20902
    //   16: newarray short
    //   18: putstatic 1710	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   21: sipush 2048
    //   24: newarray byte
    //   26: astore 9
    //   28: iconst_0
    //   29: istore_0
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 8
    //   39: invokestatic 2079	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: invokevirtual 2083	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   45: invokevirtual 2089	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc_w 2091
    //   51: invokevirtual 2097	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 4
    //   56: aload 7
    //   58: astore 5
    //   60: aload 4
    //   62: astore 6
    //   64: aload 9
    //   66: invokestatic 2103	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   69: astore 10
    //   71: aload 7
    //   73: astore 5
    //   75: aload 4
    //   77: astore 6
    //   79: new 2105	java/io/BufferedInputStream
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 2108	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore 7
    //   90: aload 7
    //   92: aload 9
    //   94: iconst_0
    //   95: sipush 2048
    //   98: invokevirtual 2112	java/io/BufferedInputStream:read	([BII)I
    //   101: iconst_2
    //   102: idiv
    //   103: istore_1
    //   104: iconst_0
    //   105: istore_2
    //   106: iload_1
    //   107: ifeq +62 -> 169
    //   110: iload_2
    //   111: iload_1
    //   112: iadd
    //   113: istore_3
    //   114: iload_3
    //   115: sipush 20902
    //   118: if_icmpgt +51 -> 169
    //   121: aload 10
    //   123: iconst_0
    //   124: invokevirtual 2116	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 10
    //   130: invokevirtual 2120	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   133: getstatic 1710	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   136: iload_2
    //   137: iload_1
    //   138: sipush 20902
    //   141: iload_2
    //   142: isub
    //   143: invokestatic 2125	java/lang/Math:min	(II)I
    //   146: invokevirtual 2130	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   149: pop
    //   150: aload 7
    //   152: aload 9
    //   154: iconst_0
    //   155: sipush 2048
    //   158: invokevirtual 2112	java/io/BufferedInputStream:read	([BII)I
    //   161: iconst_2
    //   162: idiv
    //   163: istore_1
    //   164: iload_3
    //   165: istore_2
    //   166: goto -60 -> 106
    //   169: aload 7
    //   171: invokevirtual 2133	java/io/BufferedInputStream:close	()V
    //   174: goto +10 -> 184
    //   177: astore 5
    //   179: aload 5
    //   181: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   184: aload 4
    //   186: ifnull +18 -> 204
    //   189: aload 4
    //   191: invokevirtual 2139	java/io/InputStream:close	()V
    //   194: goto +10 -> 204
    //   197: astore 4
    //   199: aload 4
    //   201: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   204: iconst_3
    //   205: istore_1
    //   206: goto +109 -> 315
    //   209: astore 5
    //   211: aload 7
    //   213: astore 6
    //   215: goto +129 -> 344
    //   218: astore 5
    //   220: aload 7
    //   222: astore 8
    //   224: aload 5
    //   226: astore 7
    //   228: goto +21 -> 249
    //   231: astore 7
    //   233: goto +16 -> 249
    //   236: astore 5
    //   238: aconst_null
    //   239: astore 4
    //   241: goto +103 -> 344
    //   244: astore 7
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 8
    //   251: astore 5
    //   253: aload 4
    //   255: astore 6
    //   257: ldc_w 2141
    //   260: iconst_1
    //   261: ldc_w 1784
    //   264: aload 7
    //   266: invokestatic 2146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload 8
    //   271: ifnull +18 -> 289
    //   274: aload 8
    //   276: invokevirtual 2133	java/io/BufferedInputStream:close	()V
    //   279: goto +10 -> 289
    //   282: astore 5
    //   284: aload 5
    //   286: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   289: iload_0
    //   290: istore_1
    //   291: aload 4
    //   293: ifnull +22 -> 315
    //   296: aload 4
    //   298: invokevirtual 2139	java/io/InputStream:close	()V
    //   301: iload_0
    //   302: istore_1
    //   303: goto +12 -> 315
    //   306: astore 4
    //   308: aload 4
    //   310: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   313: iload_0
    //   314: istore_1
    //   315: iload_1
    //   316: iconst_1
    //   317: iadd
    //   318: istore_1
    //   319: iload_1
    //   320: istore_0
    //   321: iload_1
    //   322: iconst_3
    //   323: if_icmplt -293 -> 30
    //   326: ldc 2
    //   328: monitorexit
    //   329: return
    //   330: astore 7
    //   332: aload 6
    //   334: astore 4
    //   336: aload 5
    //   338: astore 6
    //   340: aload 7
    //   342: astore 5
    //   344: aload 6
    //   346: ifnull +18 -> 364
    //   349: aload 6
    //   351: invokevirtual 2133	java/io/BufferedInputStream:close	()V
    //   354: goto +10 -> 364
    //   357: astore 6
    //   359: aload 6
    //   361: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   364: aload 4
    //   366: ifnull +18 -> 384
    //   369: aload 4
    //   371: invokevirtual 2139	java/io/InputStream:close	()V
    //   374: goto +10 -> 384
    //   377: astore 4
    //   379: aload 4
    //   381: invokevirtual 2136	java/io/IOException:printStackTrace	()V
    //   384: aload 5
    //   386: athrow
    //   387: astore 4
    //   389: ldc 2
    //   391: monitorexit
    //   392: goto +6 -> 398
    //   395: aload 4
    //   397: athrow
    //   398: goto -3 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	292	0	i	int
    //   103	221	1	j	int
    //   105	61	2	k	int
    //   113	52	3	m	int
    //   54	136	4	localInputStream	java.io.InputStream
    //   197	3	4	localIOException1	java.io.IOException
    //   239	58	4	localObject1	Object
    //   306	3	4	localIOException2	java.io.IOException
    //   334	36	4	localObject2	Object
    //   377	3	4	localIOException3	java.io.IOException
    //   387	9	4	localObject3	Object
    //   58	16	5	localObject4	Object
    //   177	3	5	localIOException4	java.io.IOException
    //   209	1	5	localObject5	Object
    //   218	7	5	localException1	java.lang.Exception
    //   236	1	5	localObject6	Object
    //   251	1	5	localObject7	Object
    //   282	55	5	localIOException5	java.io.IOException
    //   342	43	5	localObject8	Object
    //   34	316	6	localObject9	Object
    //   357	3	6	localIOException6	java.io.IOException
    //   31	196	7	localObject10	Object
    //   231	1	7	localException2	java.lang.Exception
    //   244	21	7	localException3	java.lang.Exception
    //   330	11	7	localObject11	Object
    //   37	238	8	localObject12	Object
    //   26	127	9	arrayOfByte	byte[]
    //   69	60	10	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   169	174	177	java/io/IOException
    //   189	194	197	java/io/IOException
    //   90	104	209	finally
    //   121	164	209	finally
    //   90	104	218	java/lang/Exception
    //   121	164	218	java/lang/Exception
    //   64	71	231	java/lang/Exception
    //   79	90	231	java/lang/Exception
    //   39	56	236	finally
    //   39	56	244	java/lang/Exception
    //   274	279	282	java/io/IOException
    //   296	301	306	java/io/IOException
    //   64	71	330	finally
    //   79	90	330	finally
    //   257	269	330	finally
    //   349	354	357	java/io/IOException
    //   369	374	377	java/io/IOException
    //   3	12	387	finally
    //   13	28	387	finally
    //   169	174	387	finally
    //   179	184	387	finally
    //   189	194	387	finally
    //   199	204	387	finally
    //   274	279	387	finally
    //   284	289	387	finally
    //   296	301	387	finally
    //   308	313	387	finally
    //   326	329	387	finally
    //   349	354	387	finally
    //   359	364	387	finally
    //   369	374	387	finally
    //   379	384	387	finally
    //   384	387	387	finally
    //   389	392	387	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ChnToSpell
 * JD-Core Version:    0.7.0.1
 */