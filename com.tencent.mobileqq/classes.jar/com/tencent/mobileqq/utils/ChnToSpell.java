package com.tencent.mobileqq.utils;

import android.support.v4.util.LruCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChnToSpell
{
  public static final String[] a = { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
  public static final String[] b = { "?", "a", "ai", "an", "ang", "ao", "b-a", "b-ai", "b-an", "b-ang", "b-ao", "b-ei", "b-en", "b-eng", "b-i", "b-ian", "b-iao", "b-ie", "b-in", "b-ing", "b-o", "b-u", "c-a", "c-ai", "c-an", "c-ang", "c-ao", "c-e", "c-eng", "ch-a", "ch-ai", "ch-an", "ch-ang", "ch-ao", "ch-e", "ch-en", "ch-eng", "ch-i", "ch-ong", "ch-ou", "ch-u", "ch-uai", "ch-uan", "ch-uang", "ch-ui", "ch-un", "ch-uo", "c-i", "c-ong", "c-ou", "c-u", "c-uan", "c-ui", "c-un", "c-uo", "d-a", "d-ai", "d-an", "d-ang", "d-ao", "d-e", "d-eng", "d-i", "d-ian", "d-iao", "d-ie", "d-ing", "d-iu", "d-ong", "d-ou", "d-u", "d-uan", "d-ui", "d-un", "d-uo", "e", "en", "er", "f-a", "f-an", "f-ang", "f-ei", "f-en", "f-eng", "f-u", "f-ou", "g-a", "g-ai", "g-an", "g-ang", "g-ao", "g-e", "j-i", "g-en", "g-eng", "g-ong", "g-ou", "g-u", "g-ua", "g-uai", "g-uan", "g-uang", "g-ui", "g-un", "g-uo", "h-a", "h-ai", "h-an", "h-ang", "h-ao", "h-e", "h-ei", "h-en", "h-eng", "h-ong", "h-ou", "h-u", "h-ua", "h-uai", "h-uan", "h-uang", "h-ui", "h-un", "h-uo", "j-ia", "j-ian", "j-iang", "q-iao", "j-iao", "j-ie", "j-in", "j-ing", "j-iong", "j-iu", "j-u", "j-uan", "j-ue", "j-un", "k-a", "k-ai", "k-an", "k-ang", "k-ao", "k-e", "k-en", "k-eng", "k-ong", "k-ou", "k-u", "k-ua", "k-uai", "k-uan", "k-uang", "k-ui", "k-un", "k-uo", "l-a", "l-ai", "l-an", "l-ang", "l-ao", "l-e", "l-ei", "l-eng", "l-i", "l-ia", "l-ian", "l-iang", "l-iao", "l-ie", "l-in", "l-ing", "l-iu", "l-ong", "l-ou", "l-u", "l-uan", "l-ue", "l-un", "l-uo", "m-a", "m-ai", "m-an", "m-ang", "m-ao", "m-e", "m-ei", "m-en", "m-eng", "m-i", "m-ian", "m-iao", "m-ie", "m-in", "m-ing", "m-iu", "m-o", "m-ou", "m-u", "n-a", "n-ai", "n-an", "n-ang", "n-ao", "n-e", "n-ei", "n-en", "n-eng", "n-i", "n-ian", "n-iang", "n-iao", "n-ie", "n-in", "n-ing", "n-iu", "n-ong", "n-u", "n-uan", "n-ue", "y-ao", "n-uo", "o", "ou", "p-a", "p-ai", "p-an", "p-ang", "p-ao", "p-ei", "p-en", "p-eng", "p-i", "p-ian", "p-iao", "p-ie", "p-in", "p-ing", "p-o", "p-ou", "p-u", "q-i", "q-ia", "q-ian", "q-iang", "q-ie", "q-in", "q-ing", "q-iong", "q-iu", "q-u", "q-uan", "q-ue", "q-un", "r-an", "r-ang", "r-ao", "r-e", "r-en", "r-eng", "r-i", "r-ong", "r-ou", "r-u", "r-uan", "r-ui", "r-un", "r-uo", "s-a", "s-ai", "s-an", "s-ang", "s-ao", "s-e", "s-en", "s-eng", "sh-a", "sh-ai", "sh-an", "sh-ang", "sh-ao", "sh-e", "sh-en", "sh-eng", "sh-i", "sh-ou", "sh-u", "sh-ua", "sh-uai", "sh-uan", "sh-uang", "sh-ui", "sh-un", "sh-uo", "s-i", "s-ong", "s-ou", "s-u", "s-uan", "s-ui", "s-un", "s-uo", "t-a", "t-ai", "t-an", "t-ang", "t-ao", "t-e", "t-eng", "t-i", "t-ian", "t-iao", "t-ie", "t-ing", "t-ong", "t-ou", "t-u", "t-uan", "t-ui", "t-un", "t-uo", "w-a", "w-ai", "w-an", "w-ang", "w-ei", "w-en", "w-eng", "w-o", "w-u", "x-i", "x-ia", "x-ian", "x-iang", "x-iao", "x-ie", "x-in", "x-ing", "x-iong", "x-iu", "x-u", "x-uan", "x-ue", "x-un", "y-a", "y-an", "y-ang", "y-e", "y-i", "y-in", "y-ing", "y-o", "y-ong", "y-ou", "y-u", "y-uan", "y-ue", "y-un", "z-a", "z-ai", "z-an", "z-ang", "z-ao", "z-e", "z-ei", "z-en", "z-eng", "zh-a", "zh-ai", "zh-an", "zh-ang", "zh-ao", "zh-e", "zh-en", "zh-eng", "zh-i", "zh-ong", "zh-ou", "zh-u", "zh-ua", "zh-uai", "zh-uan", "zh-uang", "zh-ui", "zh-un", "zh-uo", "z-i", "z-ong", "z-ou", "z-u", "z-uan", "z-ui", "z-un", "z-uo", "ei", "m", "n", "d-ia", "c-en", "n-ou", "j-v", "q-v", "x-v", "l-v", "n-v" };
  private static final String[] c = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
  private static Map<String, String[]> d = new HashMap();
  private static short[] e;
  private static final int[] f = { 0, 47, 58, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, 2147483647 };
  private static LruCache<String, ChnToSpell.ChnSpelling> g = new LruCache(1024);
  private static LruCache<String, ChnToSpell.ChnSpelling> h = new LruCache(1024);
  private static LruCache<String, ChnToSpell.ChnSpellingAll> i = new LruCache(1024);
  
  public static ChnToSpell.CharSpelling a(char paramChar)
  {
    ChnToSpell.CharSpelling localCharSpelling = new ChnToSpell.CharSpelling();
    int j = Arrays.binarySearch(f, paramChar);
    if (j != -14)
    {
      if (j != -12)
      {
        if (j != -7)
        {
          if (j != -5)
          {
            if (j != -3)
            {
              localCharSpelling.a = 6;
              localCharSpelling.b = String.valueOf(paramChar);
              return localCharSpelling;
            }
            localCharSpelling.a = 4;
            localCharSpelling.b = String.valueOf(paramChar);
            return localCharSpelling;
          }
          localCharSpelling.a = 2;
          localCharSpelling.b = String.valueOf(paramChar);
          return localCharSpelling;
        }
        localCharSpelling.a = 3;
        localCharSpelling.b = String.valueOf(paramChar);
        return localCharSpelling;
      }
      localCharSpelling.a = 1;
      localCharSpelling.b = String.valueOf(paramChar);
      return localCharSpelling;
    }
    localCharSpelling.a = 5;
    localCharSpelling.b = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
    return localCharSpelling;
  }
  
  public static ChnToSpell.CharSpelling a(char paramChar, int paramInt)
  {
    ChnToSpell.CharSpelling localCharSpelling = new ChnToSpell.CharSpelling();
    if (paramInt == 0)
    {
      if (paramChar == '单')
      {
        localCharSpelling.a = 5;
        localCharSpelling.b = "shan";
        return localCharSpelling;
      }
      if (paramChar == '仇')
      {
        localCharSpelling.a = 5;
        localCharSpelling.b = "qiu";
        return localCharSpelling;
      }
      if (paramChar == '曾')
      {
        localCharSpelling.a = 5;
        localCharSpelling.b = "zeng";
        return localCharSpelling;
      }
    }
    paramInt = Arrays.binarySearch(f, paramChar);
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
                  localCharSpelling.a = 0;
                  localCharSpelling.b = "??";
                  return localCharSpelling;
                }
                localCharSpelling.a = 0;
                localCharSpelling.b = String.valueOf(paramChar);
                return localCharSpelling;
              }
              localCharSpelling.a = 2;
              localCharSpelling.b = "ling";
              return localCharSpelling;
            }
            localCharSpelling.a = 4;
            localCharSpelling.b = String.valueOf(paramChar);
            return localCharSpelling;
          }
          localCharSpelling.a = 3;
          localCharSpelling.b = String.valueOf(paramChar);
          return localCharSpelling;
        }
        int j = paramChar - 'Ⅰ';
        String[] arrayOfString = c;
        paramInt = j;
        if (j >= arrayOfString.length) {
          paramInt = j - arrayOfString.length;
        }
        localCharSpelling.a = 1;
        localCharSpelling.b = c[paramInt];
        return localCharSpelling;
      }
      localCharSpelling.a = 5;
      localCharSpelling.b = a[e[(paramChar - '一')]];
      return localCharSpelling;
    }
    localCharSpelling.a = 6;
    localCharSpelling.b = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
    return localCharSpelling;
  }
  
  public static ChnToSpell.ChnSpelling a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramInt == 1)
      {
        localChnSpelling = (ChnToSpell.ChnSpelling)g.get(paramString);
        if (localChnSpelling != null) {
          return localChnSpelling;
        }
      }
      else if (paramInt == 2)
      {
        localChnSpelling = (ChnToSpell.ChnSpelling)h.get(paramString);
        if (localChnSpelling != null) {
          return localChnSpelling;
        }
      }
      ChnToSpell.ChnSpelling localChnSpelling = new ChnToSpell.ChnSpelling();
      localChnSpelling.a = paramInt;
      localChnSpelling.c = new ArrayList();
      if (e == null) {
        b();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = paramString.length();
      int k = paramString.charAt(0);
      if (k == 21333)
      {
        if (paramInt == 1) {
          localStringBuilder.append("shan");
        } else if (paramInt == 2) {
          localStringBuilder.append('s');
        }
        localChnSpelling.c.add(Integer.valueOf(0));
      }
      for (;;)
      {
        k = 1;
        break label664;
        if (k == 20167)
        {
          if (paramInt == 1) {
            localStringBuilder.append("qiu");
          } else if (paramInt == 2) {
            localStringBuilder.append('q');
          }
          localChnSpelling.c.add(Integer.valueOf(0));
        }
        else
        {
          if (k != 26366) {
            break;
          }
          if (paramInt == 1) {
            localStringBuilder.append("zeng");
          } else if (paramInt == 2) {
            localStringBuilder.append('z');
          }
          localChnSpelling.c.add(Integer.valueOf(0));
        }
      }
      if (k == 19975)
      {
        if ((paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
          break label662;
        }
        if (paramInt == 1)
        {
          localStringBuilder.append("moqi");
          localChnSpelling.c.add(Integer.valueOf(0));
          localChnSpelling.c.add(Integer.valueOf(2));
        }
        else if (paramInt == 2)
        {
          localStringBuilder.append("mq");
          localChnSpelling.c.add(Integer.valueOf(0));
          localChnSpelling.c.add(Integer.valueOf(1));
        }
      }
      else
      {
        if (k != 37325) {
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
            localChnSpelling.c.add(Integer.valueOf(0));
            localChnSpelling.c.add(Integer.valueOf(5));
          }
          else if (paramInt == 2)
          {
            localStringBuilder.append("cq");
            localChnSpelling.c.add(Integer.valueOf(0));
            localChnSpelling.c.add(Integer.valueOf(1));
          }
        }
        else {
          localStringBuilder.append("z");
        }
      }
      for (;;)
      {
        k = 2;
        break label664;
        label542:
        if ((k != 38271) || (paramString.length() <= 1) || (paramString.charAt(1) != '沙')) {
          break;
        }
        if (paramInt == 1)
        {
          localStringBuilder.append("changsha");
          localChnSpelling.c.add(Integer.valueOf(0));
          localChnSpelling.c.add(Integer.valueOf(5));
        }
        else if (paramInt == 2)
        {
          localStringBuilder.append("cs");
          localChnSpelling.c.add(Integer.valueOf(0));
          localChnSpelling.c.add(Integer.valueOf(1));
        }
      }
      label662:
      k = 0;
      label664:
      while (k < i1)
      {
        int j = paramString.charAt(k);
        localChnSpelling.c.add(Integer.valueOf(localStringBuilder.length()));
        int m = Arrays.binarySearch(f, j);
        if (m != -14)
        {
          if (m != -12)
          {
            if (m != -9)
            {
              if (m != -7)
              {
                if (m != -5)
                {
                  if (m != 7)
                  {
                    if (Character.isHighSurrogate(j))
                    {
                      localStringBuilder.append('?');
                      localChnSpelling.c.add(Integer.valueOf(localStringBuilder.length()));
                      localStringBuilder.append('?');
                      k += 1;
                    }
                    else
                    {
                      localStringBuilder.append(j);
                    }
                  }
                  else if (paramInt == 1) {
                    localStringBuilder.append("ling");
                  } else {
                    localStringBuilder.append('l');
                  }
                }
                else {
                  localStringBuilder.append(Character.toLowerCase(j));
                }
              }
              else {
                localStringBuilder.append(j);
              }
            }
            else
            {
              int n = j - 8544;
              String[] arrayOfString = c;
              m = n;
              if (n >= arrayOfString.length) {
                m = n - arrayOfString.length;
              }
              localStringBuilder.append(c[m]);
            }
          }
          else if (paramInt == 1) {
            localStringBuilder.append(a[e[(j - 19968)]]);
          } else {
            localStringBuilder.append(a[e[(j - 19968)]].charAt(0));
          }
        }
        else {
          localStringBuilder.append(Character.toLowerCase((char)(j - 65248)));
        }
        k += 1;
      }
      localChnSpelling.b = localStringBuilder.toString();
      if (paramInt == 1)
      {
        g.put(paramString, localChnSpelling);
        return localChnSpelling;
      }
      if (paramInt == 2) {
        h.put(paramString, localChnSpelling);
      }
      return localChnSpelling;
    }
    paramString = new ChnToSpell.ChnSpelling();
    paramString.a = paramInt;
    paramString.c = new ArrayList();
    paramString.b = "";
    return paramString;
  }
  
  public static ChnToSpell.ChnSpellingAll a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      ChnToSpell.ChnSpellingAll localChnSpellingAll = (ChnToSpell.ChnSpellingAll)i.get(paramString);
      if (localChnSpellingAll != null) {
        return localChnSpellingAll;
      }
      localChnSpellingAll = new ChnToSpell.ChnSpellingAll();
      localChnSpellingAll.c = new ArrayList();
      localChnSpellingAll.g = new ArrayList();
      localChnSpellingAll.h = new ArrayList();
      localChnSpellingAll.i = new ArrayList();
      if (e == null) {
        b();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder3 = new StringBuilder();
      int i1 = paramString.length();
      int k = paramString.charAt(0);
      if (k == 21333)
      {
        localStringBuilder1.append("shan");
        localStringBuilder2.append('s');
        localStringBuilder3.append("sh-an");
        localStringBuilder3.append("#");
        localChnSpellingAll.g.add(Integer.valueOf(0));
        localChnSpellingAll.h.add(Integer.valueOf(0));
        localChnSpellingAll.i.add(Integer.valueOf(0));
      }
      for (;;)
      {
        k = 1;
        break label413;
        if (k == 20167)
        {
          localStringBuilder1.append("qiu");
          localStringBuilder2.append('q');
          localStringBuilder3.append("q-iu");
          localStringBuilder3.append("#");
          localChnSpellingAll.g.add(Integer.valueOf(0));
          localChnSpellingAll.h.add(Integer.valueOf(0));
          localChnSpellingAll.i.add(Integer.valueOf(0));
        }
        else
        {
          if (k != 26366) {
            break;
          }
          localStringBuilder1.append("zeng");
          localStringBuilder2.append('z');
          localStringBuilder3.append("z-eng");
          localStringBuilder3.append("#");
          localChnSpellingAll.g.add(Integer.valueOf(0));
          localChnSpellingAll.h.add(Integer.valueOf(0));
          localChnSpellingAll.i.add(Integer.valueOf(0));
        }
      }
      k = 0;
      label413:
      while (k < i1)
      {
        int j = paramString.charAt(k);
        localChnSpellingAll.g.add(Integer.valueOf(localStringBuilder1.length()));
        localChnSpellingAll.h.add(Integer.valueOf(localStringBuilder2.length()));
        localChnSpellingAll.i.add(Integer.valueOf(localStringBuilder3.length()));
        char c1;
        if ((j != 45) && (j != 35))
        {
          int m = Arrays.binarySearch(f, j);
          if (m != -14)
          {
            String[] arrayOfString;
            if (m != -12)
            {
              if (m != -9)
              {
                if (m != -7)
                {
                  if (m != -5)
                  {
                    if (m != 7)
                    {
                      if (Character.isHighSurrogate(j))
                      {
                        localStringBuilder1.append('?');
                        localStringBuilder2.append('?');
                        localStringBuilder3.append('?');
                        localStringBuilder3.append("#");
                        localChnSpellingAll.g.add(Integer.valueOf(localStringBuilder1.length()));
                        localChnSpellingAll.h.add(Integer.valueOf(localStringBuilder2.length()));
                        localChnSpellingAll.i.add(Integer.valueOf(localStringBuilder3.length()));
                        localStringBuilder1.append('?');
                        localStringBuilder2.append('?');
                        localStringBuilder3.append('?');
                        localStringBuilder3.append("#");
                        k += 1;
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
                    localStringBuilder1.append(Character.toLowerCase(j));
                    localStringBuilder2.append(Character.toLowerCase(j));
                    localStringBuilder3.append(Character.toLowerCase(j));
                    localStringBuilder3.append("#");
                  }
                }
                else
                {
                  localStringBuilder1.append(j);
                  localStringBuilder2.append(j);
                  localStringBuilder3.append(j);
                  localStringBuilder3.append("#");
                }
              }
              else
              {
                int n = j - 8544;
                arrayOfString = c;
                m = n;
                if (n >= arrayOfString.length) {
                  m = n - arrayOfString.length;
                }
                localStringBuilder1.append(c[m]);
                localStringBuilder2.append(c[m]);
                localStringBuilder3.append(c[m]);
                localStringBuilder3.append("#");
              }
            }
            else
            {
              arrayOfString = a;
              short[] arrayOfShort = e;
              m = j - 19968;
              localStringBuilder1.append(arrayOfString[arrayOfShort[m]]);
              localStringBuilder2.append(a[e[m]].charAt(0));
              localStringBuilder3.append(b[e[m]]);
              localStringBuilder3.append("#");
            }
          }
          else
          {
            c1 = (char)(j - 65248);
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
        k += 1;
      }
      if (localStringBuilder3.length() > 0) {
        localStringBuilder3.deleteCharAt(localStringBuilder3.length() - 1);
      }
      localChnSpellingAll.b = localStringBuilder1.toString();
      localChnSpellingAll.c = localChnSpellingAll.g;
      localChnSpellingAll.d = localStringBuilder1.toString();
      localChnSpellingAll.e = localStringBuilder2.toString();
      localChnSpellingAll.f = localStringBuilder3.toString();
      i.put(paramString, localChnSpellingAll);
      return localChnSpellingAll;
    }
    return null;
  }
  
  private static void a()
  {
    if (d.isEmpty())
    {
      d.put("单", new String[] { "shan", "dan", "chan" });
      d.put("折", new String[] { "zhe", "she" });
      d.put("着", new String[] { "zhao", "zhuo", "zhe" });
      d.put("蕃", new String[] { "bo", "fan" });
      d.put("沓", new String[] { "da", "ta" });
      d.put("曝", new String[] { "pu", "bao" });
      d.put("和", new String[] { "he", "huo", "hu" });
      d.put("省", new String[] { "sheng", "xing" });
      d.put("拗", new String[] { "niu", "ao" });
      d.put("臭", new String[] { "chou", "xiu" });
      d.put("度", new String[] { "du", "duo" });
      d.put("差", new String[] { "cha", "chai" });
      d.put("扎", new String[] { "zha", "za" });
      d.put("埋", new String[] { "man", "mai" });
      d.put("盛", new String[] { "sheng", "cheng" });
      d.put("伧", new String[] { "chen", "cang" });
      d.put("伯", new String[] { "bo", "bai" });
      d.put("疟", new String[] { "yao", "nue" });
      d.put("行", new String[] { "hang", "xing" });
      d.put("艾", new String[] { "ai", "yi" });
      d.put("传", new String[] { "chuan", "zhuan" });
      d.put("奇", new String[] { "ji", "qi" });
      d.put("炮", new String[] { "pao", "bao" });
      d.put("给", new String[] { "gei", "ji" });
      d.put("巷", new String[] { "hang", "xiang" });
      d.put("薄", new String[] { "bo", "bao" });
      d.put("簿", new String[] { "bo", "bu" });
      d.put("拓", new String[] { "ta", "tuo" });
      d.put("恶", new String[] { "e", "wu" });
      d.put("便", new String[] { "pian", "bian" });
      d.put("宿", new String[] { "xiu", "su" });
      d.put("藏", new String[] { "zang", "cang" });
      d.put("轧", new String[] { "zha", "ya" });
      d.put("卡", new String[] { "ka", "qia" });
      d.put("调", new String[] { "tiao", "diao" });
      d.put("模", new String[] { "mo", "mu" });
      d.put("没", new String[] { "mei", "mo" });
      d.put("殷", new String[] { "yan", "yin" });
      d.put("还", new String[] { "huan", "hai" });
      d.put("系", new String[] { "xi", "ji" });
      d.put("降", new String[] { "xiang", "jiang" });
      d.put("脯", new String[] { "pu", "fu" });
      d.put("石", new String[] { "dan", "shi" });
      d.put("劲", new String[] { "jing", "jin" });
      d.put("茄", new String[] { "jia", "qie" });
      d.put("刨", new String[] { "bao", "pao" });
      d.put("弹", new String[] { "dan", "tan" });
      d.put("颤", new String[] { "zhan", "chan" });
      d.put("扒", new String[] { "ba", "pa" });
      d.put("数", new String[] { "shu", "shuo" });
      d.put("参", new String[] { "cen", "shen", "can" });
      d.put("会", new String[] { "hui", "kuai" });
      d.put("吓", new String[] { "xia", "he" });
      d.put("胖", new String[] { "pang", "pan" });
      d.put("耙", new String[] { "ba", "pa" });
      d.put("伺", new String[] { "si", "ci" });
      d.put("咳", new String[] { "hai", "ke" });
      d.put("囤", new String[] { "dun", "tun" });
      d.put("澄", new String[] { "deng", "cheng" });
      d.put("得", new String[] { "de", "dei" });
      d.put("屏", new String[] { "ping", "bing" });
      d.put("乐", new String[] { "yue", "le" });
      d.put("了", new String[] { "liao", "le" });
      d.put("吭", new String[] { "keng", "hang" });
      d.put("粘", new String[] { "nian", "zhan" });
      d.put("畜", new String[] { "xu", "chu" });
      d.put("称", new String[] { "chen", "cheng" });
      d.put("弄", new String[] { "long", "nong" });
      d.put("俩", new String[] { "lia", "liang" });
      d.put("露", new String[] { "lu", "lou" });
      d.put("重", new String[] { "zhong", "chong" });
      d.put("率", new String[] { "shuai", "lu" });
      d.put("泊", new String[] { "bo", "po" });
      d.put("朝", new String[] { "chao", "zhao" });
      d.put("校", new String[] { "xiao", "jiao" });
      d.put("强", new String[] { "qiang", "jiang" });
      d.put("塞", new String[] { "se", "sai" });
      d.put("辟", new String[] { "bi", "pi" });
      d.put("都", new String[] { "du", "dou" });
      d.put("匙", new String[] { "chi", "shi" });
      d.put("查", new String[] { "zha", "cha" });
      d.put("曾", new String[] { "zeng", "ceng" });
      d.put("解", new String[] { "xie", "jie" });
      d.put("颉", new String[] { "xie", "jie", "jia" });
      d.put("莘", new String[] { "shen", "xin" });
      d.put("召", new String[] { "shao", "zhao" });
      d.put("仇", new String[] { "qiu", "chou" });
      d.put("区", new String[] { "ou", "qu" });
      d.put("圈", new String[] { "juan", "quan" });
      d.put("炅", new String[] { "gui", "jiong" });
      d.put("秘", new String[] { "bi", "mi", "bei" });
      d.put("尉", new String[] { "wei" });
      d.put("万", new String[] { "wan", "mo" });
      d.put("覃", new String[] { "qin", "tan", "xun" });
      d.put("隗", new String[] { "kui", "wei", "yu" });
      d.put("宓", new String[] { "fu", "mi" });
      d.put("郇", new String[] { "huan", "xun" });
      d.put("种", new String[] { "zhong", "chong" });
      d.put("嚼", new String[] { "jiao", "jue" });
      d.put("咽", new String[] { "yan", "ye" });
      d.put("落", new String[] { "la", "luo" });
      d.put("乘", new String[] { "cheng", "sheng" });
      d.put("佛", new String[] { "fo", "fu" });
      d.put("长", new String[] { "chang", "zhang" });
      d.put("提", new String[] { "ti", "di" });
      d.put("攒", new String[] { "cuan", "zan" });
      d.put("大", new String[] { "dai", "da" });
      d.put("厦", new String[] { "sha", "xia" });
      d.put("觉", new String[] { "jiao", "jue" });
      d.put("车", new String[] { "che", "ju" });
      d.put("禅", new String[] { "chan", "shan" });
      d.put("刹", new String[] { "cha", "sha" });
      d.put("膀", new String[] { "bang", "pang" });
      d.put("剥", new String[] { "bao", "pu" });
      d.put("骠", new String[] { "biao", "piao" });
      d.put("堡", new String[] { "bao", "pu" });
      d.put("爪", new String[] { "zhua", "zhao" });
    }
  }
  
  public static String b(String paramString, int paramInt)
  {
    return a(paramString, paramInt).b;
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 1715	com/tencent/mobileqq/utils/ChnToSpell:e	[S
    //   6: ifnull +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: sipush 20902
    //   16: newarray short
    //   18: putstatic 1715	com/tencent/mobileqq/utils/ChnToSpell:e	[S
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
    //   39: invokestatic 2073	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: invokevirtual 2077	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   45: invokevirtual 2083	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc_w 2085
    //   51: invokevirtual 2091	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 4
    //   56: aload 7
    //   58: astore 5
    //   60: aload 4
    //   62: astore 6
    //   64: aload 9
    //   66: invokestatic 2097	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   69: astore 10
    //   71: aload 7
    //   73: astore 5
    //   75: aload 4
    //   77: astore 6
    //   79: new 2099	java/io/BufferedInputStream
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 2102	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore 7
    //   90: aload 7
    //   92: aload 9
    //   94: iconst_0
    //   95: sipush 2048
    //   98: invokevirtual 2106	java/io/BufferedInputStream:read	([BII)I
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
    //   124: invokevirtual 2110	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 10
    //   130: invokevirtual 2114	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   133: getstatic 1715	com/tencent/mobileqq/utils/ChnToSpell:e	[S
    //   136: iload_2
    //   137: iload_1
    //   138: sipush 20902
    //   141: iload_2
    //   142: isub
    //   143: invokestatic 2119	java/lang/Math:min	(II)I
    //   146: invokevirtual 2124	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   149: pop
    //   150: aload 7
    //   152: aload 9
    //   154: iconst_0
    //   155: sipush 2048
    //   158: invokevirtual 2106	java/io/BufferedInputStream:read	([BII)I
    //   161: iconst_2
    //   162: idiv
    //   163: istore_1
    //   164: iload_3
    //   165: istore_2
    //   166: goto -60 -> 106
    //   169: aload 7
    //   171: invokevirtual 2127	java/io/BufferedInputStream:close	()V
    //   174: goto +10 -> 184
    //   177: astore 5
    //   179: aload 5
    //   181: invokevirtual 2130	java/io/IOException:printStackTrace	()V
    //   184: aload 4
    //   186: ifnull +18 -> 204
    //   189: aload 4
    //   191: invokevirtual 2133	java/io/InputStream:close	()V
    //   194: goto +10 -> 204
    //   197: astore 4
    //   199: aload 4
    //   201: invokevirtual 2130	java/io/IOException:printStackTrace	()V
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
    //   257: ldc_w 2135
    //   260: iconst_1
    //   261: ldc_w 1789
    //   264: aload 7
    //   266: invokestatic 2140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload 8
    //   271: ifnull +18 -> 289
    //   274: aload 8
    //   276: invokevirtual 2127	java/io/BufferedInputStream:close	()V
    //   279: goto +10 -> 289
    //   282: astore 5
    //   284: aload 5
    //   286: invokevirtual 2130	java/io/IOException:printStackTrace	()V
    //   289: iload_0
    //   290: istore_1
    //   291: aload 4
    //   293: ifnull +22 -> 315
    //   296: aload 4
    //   298: invokevirtual 2133	java/io/InputStream:close	()V
    //   301: iload_0
    //   302: istore_1
    //   303: goto +12 -> 315
    //   306: astore 4
    //   308: aload 4
    //   310: invokevirtual 2130	java/io/IOException:printStackTrace	()V
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
    //   351: invokevirtual 2127	java/io/BufferedInputStream:close	()V
    //   354: goto +10 -> 364
    //   357: astore 6
    //   359: aload 6
    //   361: invokevirtual 2130	java/io/IOException:printStackTrace	()V
    //   364: aload 4
    //   366: ifnull +18 -> 384
    //   369: aload 4
    //   371: invokevirtual 2133	java/io/InputStream:close	()V
    //   374: goto +10 -> 384
    //   377: astore 4
    //   379: aload 4
    //   381: invokevirtual 2130	java/io/IOException:printStackTrace	()V
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
    //   29	292	0	j	int
    //   103	221	1	k	int
    //   105	61	2	m	int
    //   113	52	3	n	int
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
  
  public static String[] b(String paramString)
  {
    
    if (d.containsKey(paramString)) {
      return (String[])d.get(paramString);
    }
    return new String[] { b(paramString, 1) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ChnToSpell
 * JD-Core Version:    0.7.0.1
 */