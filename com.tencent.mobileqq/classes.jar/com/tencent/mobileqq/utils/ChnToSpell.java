package com.tencent.mobileqq.utils;

import android.support.v4.util.LruCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChnToSpell
{
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final String[] a;
  private static short[] jdField_a_of_type_ArrayOfShort;
  private static LruCache b;
  public static final String[] b;
  private static LruCache jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "b-a", "b-ai", "b-an", "b-ang", "b-ao", "b-ei", "b-en", "b-eng", "b-i", "b-ian", "b-iao", "b-ie", "b-in", "b-ing", "b-o", "b-u", "c-a", "c-ai", "c-an", "c-ang", "c-ao", "c-e", "c-eng", "ch-a", "ch-ai", "ch-an", "ch-ang", "ch-ao", "ch-e", "ch-en", "ch-eng", "ch-i", "ch-ong", "ch-ou", "ch-u", "ch-uai", "ch-uan", "ch-uang", "ch-ui", "ch-un", "ch-uo", "c-i", "c-ong", "c-ou", "c-u", "c-uan", "c-ui", "c-un", "c-uo", "d-a", "d-ai", "d-an", "d-ang", "d-ao", "d-e", "d-eng", "d-i", "d-ian", "d-iao", "d-ie", "d-ing", "d-iu", "d-ong", "d-ou", "d-u", "d-uan", "d-ui", "d-un", "d-uo", "e", "en", "er", "f-a", "f-an", "f-ang", "f-ei", "f-en", "f-eng", "f-u", "f-ou", "g-a", "g-ai", "g-an", "g-ang", "g-ao", "g-e", "j-i", "g-en", "g-eng", "g-ong", "g-ou", "g-u", "g-ua", "g-uai", "g-uan", "g-uang", "g-ui", "g-un", "g-uo", "h-a", "h-ai", "h-an", "h-ang", "h-ao", "h-e", "h-ei", "h-en", "h-eng", "h-ong", "h-ou", "h-u", "h-ua", "h-uai", "h-uan", "h-uang", "h-ui", "h-un", "h-uo", "j-ia", "j-ian", "j-iang", "q-iao", "j-iao", "j-ie", "j-in", "j-ing", "j-iong", "j-iu", "j-u", "j-uan", "j-ue", "j-un", "k-a", "k-ai", "k-an", "k-ang", "k-ao", "k-e", "k-en", "k-eng", "k-ong", "k-ou", "k-u", "k-ua", "k-uai", "k-uan", "k-uang", "k-ui", "k-un", "k-uo", "l-a", "l-ai", "l-an", "l-ang", "l-ao", "l-e", "l-ei", "l-eng", "l-i", "l-ia", "l-ian", "l-iang", "l-iao", "l-ie", "l-in", "l-ing", "l-iu", "l-ong", "l-ou", "l-u", "l-uan", "l-ue", "l-un", "l-uo", "m-a", "m-ai", "m-an", "m-ang", "m-ao", "m-e", "m-ei", "m-en", "m-eng", "m-i", "m-ian", "m-iao", "m-ie", "m-in", "m-ing", "m-iu", "m-o", "m-ou", "m-u", "n-a", "n-ai", "n-an", "n-ang", "n-ao", "n-e", "n-ei", "n-en", "n-eng", "n-i", "n-ian", "n-iang", "n-iao", "n-ie", "n-in", "n-ing", "n-iu", "n-ong", "n-u", "n-uan", "n-ue", "y-ao", "n-uo", "o", "ou", "p-a", "p-ai", "p-an", "p-ang", "p-ao", "p-ei", "p-en", "p-eng", "p-i", "p-ian", "p-iao", "p-ie", "p-in", "p-ing", "p-o", "p-ou", "p-u", "q-i", "q-ia", "q-ian", "q-iang", "q-ie", "q-in", "q-ing", "q-iong", "q-iu", "q-u", "q-uan", "q-ue", "q-un", "r-an", "r-ang", "r-ao", "r-e", "r-en", "r-eng", "r-i", "r-ong", "r-ou", "r-u", "r-uan", "r-ui", "r-un", "r-uo", "s-a", "s-ai", "s-an", "s-ang", "s-ao", "s-e", "s-en", "s-eng", "sh-a", "sh-ai", "sh-an", "sh-ang", "sh-ao", "sh-e", "sh-en", "sh-eng", "sh-i", "sh-ou", "sh-u", "sh-ua", "sh-uai", "sh-uan", "sh-uang", "sh-ui", "sh-un", "sh-uo", "s-i", "s-ong", "s-ou", "s-u", "s-uan", "s-ui", "s-un", "s-uo", "t-a", "t-ai", "t-an", "t-ang", "t-ao", "t-e", "t-eng", "t-i", "t-ian", "t-iao", "t-ie", "t-ing", "t-ong", "t-ou", "t-u", "t-uan", "t-ui", "t-un", "t-uo", "w-a", "w-ai", "w-an", "w-ang", "w-ei", "w-en", "w-eng", "w-o", "w-u", "x-i", "x-ia", "x-ian", "x-iang", "x-iao", "x-ie", "x-in", "x-ing", "x-iong", "x-iu", "x-u", "x-uan", "x-ue", "x-un", "y-a", "y-an", "y-ang", "y-e", "y-i", "y-in", "y-ing", "y-o", "y-ong", "y-ou", "y-u", "y-uan", "y-ue", "y-un", "z-a", "z-ai", "z-an", "z-ang", "z-ao", "z-e", "z-ei", "z-en", "z-eng", "zh-a", "zh-ai", "zh-an", "zh-ang", "zh-ao", "zh-e", "zh-en", "zh-eng", "zh-i", "zh-ong", "zh-ou", "zh-u", "zh-ua", "zh-uai", "zh-uan", "zh-uang", "zh-ui", "zh-un", "zh-uo", "z-i", "z-ong", "z-ou", "z-u", "z-uan", "z-ui", "z-un", "z-uo", "ei", "m", "n", "d-ia", "c-en", "n-ou", "j-v", "q-v", "x-v", "l-v", "n-v" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, 2147483647 };
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
    jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
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
    switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, paramChar))
    {
    default: 
      if (Character.isHighSurrogate(paramChar))
      {
        localCharSpelling.jdField_a_of_type_Int = 0;
        localCharSpelling.jdField_a_of_type_JavaLangString = "??";
      }
      break;
    }
    for (;;)
    {
      return localCharSpelling;
      int i = paramChar - 'Ⅰ';
      paramInt = i;
      if (i >= jdField_c_of_type_ArrayOfJavaLangString.length) {
        paramInt = i - jdField_c_of_type_ArrayOfJavaLangString.length;
      }
      localCharSpelling.jdField_a_of_type_Int = 1;
      localCharSpelling.jdField_a_of_type_JavaLangString = jdField_c_of_type_ArrayOfJavaLangString[paramInt];
      continue;
      localCharSpelling.jdField_a_of_type_Int = 2;
      localCharSpelling.jdField_a_of_type_JavaLangString = "ling";
      continue;
      localCharSpelling.jdField_a_of_type_Int = 4;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
      continue;
      localCharSpelling.jdField_a_of_type_Int = 3;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
      continue;
      localCharSpelling.jdField_a_of_type_Int = 5;
      localCharSpelling.jdField_a_of_type_JavaLangString = jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(paramChar - '一')]];
      continue;
      localCharSpelling.jdField_a_of_type_Int = 6;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
      continue;
      localCharSpelling.jdField_a_of_type_Int = 0;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
    }
  }
  
  public static ChnToSpell.ChnSpelling a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject1 = new ChnToSpell.ChnSpelling();
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_Int = paramInt;
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaLangString = "";
    }
    do
    {
      return localObject1;
      if (paramInt != 1) {
        break;
      }
      localObject2 = (ChnToSpell.ChnSpelling)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = new ChnToSpell.ChnSpelling();
    ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_Int = paramInt;
    ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
    if (jdField_a_of_type_ArrayOfShort == null) {
      a();
    }
    Object localObject2 = new StringBuilder();
    int n = paramString.length();
    int j = paramString.charAt(0);
    if (j == 21333) {
      if (paramInt == 1)
      {
        ((StringBuilder)localObject2).append("shan");
        label153:
        ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
        j = 1;
      }
    }
    for (;;)
    {
      label170:
      if (j < n)
      {
        int i = paramString.charAt(j);
        ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
        switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i))
        {
        default: 
          if (Character.isHighSurrogate(i))
          {
            ((StringBuilder)localObject2).append('?');
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
            ((StringBuilder)localObject2).append('?');
            j += 1;
          }
          break;
        }
        for (;;)
        {
          j += 1;
          break label170;
          if (paramInt != 2) {
            break;
          }
          localObject1 = (ChnToSpell.ChnSpelling)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
          if (localObject1 == null) {
            break;
          }
          return localObject1;
          if (paramInt != 2) {
            break label153;
          }
          ((StringBuilder)localObject2).append('s');
          break label153;
          if (j == 20167)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("qiu");
            }
            for (;;)
            {
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              j = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('1');
              }
            }
          }
          if (j == 26366)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("zeng");
            }
            for (;;)
            {
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              j = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('z');
              }
            }
          }
          if (j == 19975)
          {
            if ((paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
              break label942;
            }
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append("moqi");
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
            }
            for (;;)
            {
              j = 2;
              break;
              if (paramInt == 2)
              {
                ((StringBuilder)localObject2).append("mq");
                ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
                ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
              }
            }
          }
          if ((j != 37325) || (paramString.length() <= 1)) {
            break label942;
          }
          if (paramString.charAt(1) == '庆')
          {
            if (paramInt != 1) {
              break label673;
            }
            ((StringBuilder)localObject2).append("chongqing");
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(5));
          }
          for (;;)
          {
            j = 2;
            break;
            if (paramInt == 2)
            {
              ((StringBuilder)localObject2).append("cq");
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
            }
          }
          int m = i - 8544;
          int k = m;
          if (m >= jdField_c_of_type_ArrayOfJavaLangString.length) {
            k = m - jdField_c_of_type_ArrayOfJavaLangString.length;
          }
          ((StringBuilder)localObject2).append(jdField_c_of_type_ArrayOfJavaLangString[k]);
          continue;
          if (paramInt == 1)
          {
            ((StringBuilder)localObject2).append("ling");
          }
          else
          {
            ((StringBuilder)localObject2).append('l');
            continue;
            ((StringBuilder)localObject2).append(Character.toLowerCase(i));
            continue;
            ((StringBuilder)localObject2).append(i);
            continue;
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]]);
            }
            else
            {
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]].charAt(0));
              continue;
              ((StringBuilder)localObject2).append(Character.toLowerCase((char)(i - 65248)));
              continue;
              ((StringBuilder)localObject2).append(i);
            }
          }
        }
      }
      label673:
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      if (paramInt == 1) {
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
      }
      for (;;)
      {
        return localObject1;
        if (paramInt == 2) {
          jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
        }
      }
      label942:
      j = 0;
    }
  }
  
  public static ChnToSpell.ChnSpellingAll a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = (ChnToSpell.ChnSpellingAll)jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = new ChnToSpell.ChnSpellingAll();
    ((ChnToSpell.ChnSpellingAll)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
    ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
    ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList = new ArrayList();
    ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList = new ArrayList();
    if (jdField_a_of_type_ArrayOfShort == null) {
      a();
    }
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int n = paramString.length();
    int j = paramString.charAt(0);
    if (j == 21333)
    {
      ((StringBuilder)localObject2).append("shan");
      localStringBuilder1.append('s');
      localStringBuilder2.append("sh-an").append("#");
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
      j = 1;
    }
    for (;;)
    {
      if (j < n)
      {
        int i = paramString.charAt(j);
        ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
        ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder1.length()));
        ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder2.length()));
        if ((i == 45) || (i == 35))
        {
          ((StringBuilder)localObject2).append(i);
          localStringBuilder1.append(i);
          localStringBuilder2.append('0').append("#");
        }
        for (;;)
        {
          j += 1;
          break;
          if (j == 20167)
          {
            ((StringBuilder)localObject2).append("qiu");
            localStringBuilder1.append('q');
            localStringBuilder2.append("q-iu").append("#");
            ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
            ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
            ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
            j = 1;
            break;
          }
          if (j != 26366) {
            break label1133;
          }
          ((StringBuilder)localObject2).append("zeng");
          localStringBuilder1.append('z');
          localStringBuilder2.append("z-eng").append("#");
          ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
          ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
          ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
          j = 1;
          break;
          switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i))
          {
          default: 
            if (Character.isHighSurrogate(i))
            {
              ((StringBuilder)localObject2).append('?');
              localStringBuilder1.append('?');
              localStringBuilder2.append('?').append("#");
              ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
              ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder1.length()));
              ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaUtilList.add(Integer.valueOf(localStringBuilder2.length()));
              ((StringBuilder)localObject2).append('?');
              localStringBuilder1.append('?');
              localStringBuilder2.append('?').append("#");
              j += 1;
            }
            break;
          case -7: 
            int m = i - 8544;
            int k = m;
            if (m >= jdField_c_of_type_ArrayOfJavaLangString.length) {
              k = m - jdField_c_of_type_ArrayOfJavaLangString.length;
            }
            ((StringBuilder)localObject2).append(jdField_c_of_type_ArrayOfJavaLangString[k]);
            localStringBuilder1.append(jdField_c_of_type_ArrayOfJavaLangString[k]);
            localStringBuilder2.append(jdField_c_of_type_ArrayOfJavaLangString[k]).append("#");
            break;
          case 5: 
            ((StringBuilder)localObject2).append("ling");
            localStringBuilder1.append('l');
            localStringBuilder2.append("l-ing").append("#");
            break;
          case -3: 
            ((StringBuilder)localObject2).append(Character.toLowerCase(i));
            localStringBuilder1.append(Character.toLowerCase(i));
            localStringBuilder2.append(Character.toLowerCase(i)).append("#");
            break;
          case -5: 
            ((StringBuilder)localObject2).append(i);
            localStringBuilder1.append(i);
            localStringBuilder2.append(i).append("#");
            break;
          case -10: 
            ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]]);
            localStringBuilder1.append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]].charAt(0));
            localStringBuilder2.append(jdField_b_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i - 19968)]]).append("#");
            break;
          case -12: 
            ((StringBuilder)localObject2).append(Character.toLowerCase((char)(i - 65248)));
            localStringBuilder1.append(Character.toLowerCase((char)(i - 65248)));
            localStringBuilder2.append(Character.toLowerCase((char)(i - 65248))).append("#");
            continue;
            ((StringBuilder)localObject2).append('?');
            localStringBuilder1.append('?');
            localStringBuilder2.append('?').append("#");
          }
        }
      }
      if (localStringBuilder2.length() > 0) {
        localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
      }
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_a_of_type_JavaUtilList = ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaUtilList;
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_c_of_type_JavaLangString = localStringBuilder1.toString();
      ((ChnToSpell.ChnSpellingAll)localObject1).jdField_d_of_type_JavaLangString = localStringBuilder2.toString();
      jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
      return localObject1;
      label1133:
      j = 0;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt).jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 1701	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   6: ifnull +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: sipush 20902
    //   16: newarray short
    //   18: putstatic 1701	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   21: sipush 2048
    //   24: newarray byte
    //   26: astore 8
    //   28: iconst_0
    //   29: istore_1
    //   30: getstatic 1811	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   33: invokevirtual 1815	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   36: invokevirtual 1821	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   39: ldc_w 1823
    //   42: invokevirtual 1829	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_3
    //   46: aload 8
    //   48: invokestatic 1835	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   51: astore 7
    //   53: new 1837	java/io/BufferedInputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 1840	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 4
    //   63: aload 4
    //   65: astore 6
    //   67: aload_3
    //   68: astore 5
    //   70: aload 4
    //   72: aload 8
    //   74: iconst_0
    //   75: sipush 2048
    //   78: invokevirtual 1844	java/io/BufferedInputStream:read	([BII)I
    //   81: iconst_2
    //   82: idiv
    //   83: istore_2
    //   84: iconst_0
    //   85: istore_0
    //   86: iload_2
    //   87: ifeq +83 -> 170
    //   90: iload_0
    //   91: iload_2
    //   92: iadd
    //   93: sipush 20902
    //   96: if_icmpgt +74 -> 170
    //   99: aload 4
    //   101: astore 6
    //   103: aload_3
    //   104: astore 5
    //   106: aload 7
    //   108: iconst_0
    //   109: invokevirtual 1848	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   112: pop
    //   113: aload 4
    //   115: astore 6
    //   117: aload_3
    //   118: astore 5
    //   120: aload 7
    //   122: invokevirtual 1852	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   125: getstatic 1701	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   128: iload_0
    //   129: iload_2
    //   130: sipush 20902
    //   133: iload_0
    //   134: isub
    //   135: invokestatic 1857	java/lang/Math:min	(II)I
    //   138: invokevirtual 1862	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   141: pop
    //   142: iload_0
    //   143: iload_2
    //   144: iadd
    //   145: istore_0
    //   146: aload 4
    //   148: astore 6
    //   150: aload_3
    //   151: astore 5
    //   153: aload 4
    //   155: aload 8
    //   157: iconst_0
    //   158: sipush 2048
    //   161: invokevirtual 1844	java/io/BufferedInputStream:read	([BII)I
    //   164: iconst_2
    //   165: idiv
    //   166: istore_2
    //   167: goto -81 -> 86
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 1865	java/io/BufferedInputStream:close	()V
    //   180: aload_3
    //   181: ifnull +194 -> 375
    //   184: aload_3
    //   185: invokevirtual 1868	java/io/InputStream:close	()V
    //   188: iconst_3
    //   189: istore_0
    //   190: iload_0
    //   191: iconst_1
    //   192: iadd
    //   193: istore_0
    //   194: iload_0
    //   195: istore_1
    //   196: iload_0
    //   197: iconst_3
    //   198: if_icmplt -168 -> 30
    //   201: ldc 2
    //   203: monitorexit
    //   204: return
    //   205: astore_3
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_3
    //   210: athrow
    //   211: astore 4
    //   213: aload 4
    //   215: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   218: goto -38 -> 180
    //   221: astore_3
    //   222: aload_3
    //   223: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   226: iconst_3
    //   227: istore_0
    //   228: goto -38 -> 190
    //   231: astore 7
    //   233: aconst_null
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_3
    //   238: aload 4
    //   240: astore 6
    //   242: aload_3
    //   243: astore 5
    //   245: ldc_w 1873
    //   248: iconst_1
    //   249: aconst_null
    //   250: aload 7
    //   252: invokestatic 1878	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload 4
    //   257: ifnull +8 -> 265
    //   260: aload 4
    //   262: invokevirtual 1865	java/io/BufferedInputStream:close	()V
    //   265: iload_1
    //   266: istore_0
    //   267: aload_3
    //   268: ifnull -78 -> 190
    //   271: aload_3
    //   272: invokevirtual 1868	java/io/InputStream:close	()V
    //   275: iload_1
    //   276: istore_0
    //   277: goto -87 -> 190
    //   280: astore_3
    //   281: aload_3
    //   282: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   285: iload_1
    //   286: istore_0
    //   287: goto -97 -> 190
    //   290: astore 4
    //   292: aload 4
    //   294: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   297: goto -32 -> 265
    //   300: astore 4
    //   302: aconst_null
    //   303: astore 6
    //   305: aconst_null
    //   306: astore_3
    //   307: aload 6
    //   309: ifnull +8 -> 317
    //   312: aload 6
    //   314: invokevirtual 1865	java/io/BufferedInputStream:close	()V
    //   317: aload_3
    //   318: ifnull +7 -> 325
    //   321: aload_3
    //   322: invokevirtual 1868	java/io/InputStream:close	()V
    //   325: aload 4
    //   327: athrow
    //   328: astore 5
    //   330: aload 5
    //   332: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   335: goto -18 -> 317
    //   338: astore_3
    //   339: aload_3
    //   340: invokevirtual 1871	java/io/IOException:printStackTrace	()V
    //   343: goto -18 -> 325
    //   346: astore 4
    //   348: aconst_null
    //   349: astore 6
    //   351: goto -44 -> 307
    //   354: astore 4
    //   356: aload 5
    //   358: astore_3
    //   359: goto -52 -> 307
    //   362: astore 7
    //   364: aconst_null
    //   365: astore 4
    //   367: goto -129 -> 238
    //   370: astore 7
    //   372: goto -134 -> 238
    //   375: iconst_3
    //   376: istore_0
    //   377: goto -187 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   85	292	0	i	int
    //   29	257	1	j	int
    //   83	84	2	k	int
    //   45	140	3	localInputStream	java.io.InputStream
    //   205	5	3	localObject1	Object
    //   221	2	3	localIOException1	java.io.IOException
    //   237	35	3	localObject2	Object
    //   280	2	3	localIOException2	java.io.IOException
    //   306	16	3	localObject3	Object
    //   338	2	3	localIOException3	java.io.IOException
    //   358	1	3	localObject4	Object
    //   61	115	4	localBufferedInputStream	java.io.BufferedInputStream
    //   211	3	4	localIOException4	java.io.IOException
    //   234	27	4	localObject5	Object
    //   290	3	4	localIOException5	java.io.IOException
    //   300	26	4	localObject6	Object
    //   346	1	4	localObject7	Object
    //   354	1	4	localObject8	Object
    //   365	1	4	localObject9	Object
    //   68	176	5	localObject10	Object
    //   328	29	5	localIOException6	java.io.IOException
    //   65	285	6	localObject11	Object
    //   51	70	7	localByteBuffer	java.nio.ByteBuffer
    //   231	20	7	localException1	java.lang.Exception
    //   362	1	7	localException2	java.lang.Exception
    //   370	1	7	localException3	java.lang.Exception
    //   26	130	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	12	205	finally
    //   13	28	205	finally
    //   175	180	205	finally
    //   184	188	205	finally
    //   201	204	205	finally
    //   206	209	205	finally
    //   213	218	205	finally
    //   222	226	205	finally
    //   260	265	205	finally
    //   271	275	205	finally
    //   281	285	205	finally
    //   292	297	205	finally
    //   312	317	205	finally
    //   321	325	205	finally
    //   325	328	205	finally
    //   330	335	205	finally
    //   339	343	205	finally
    //   175	180	211	java/io/IOException
    //   184	188	221	java/io/IOException
    //   30	46	231	java/lang/Exception
    //   271	275	280	java/io/IOException
    //   260	265	290	java/io/IOException
    //   30	46	300	finally
    //   312	317	328	java/io/IOException
    //   321	325	338	java/io/IOException
    //   46	63	346	finally
    //   70	84	354	finally
    //   106	113	354	finally
    //   120	142	354	finally
    //   153	167	354	finally
    //   245	255	354	finally
    //   46	63	362	java/lang/Exception
    //   70	84	370	java/lang/Exception
    //   106	113	370	java/lang/Exception
    //   120	142	370	java/lang/Exception
    //   153	167	370	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ChnToSpell
 * JD-Core Version:    0.7.0.1
 */