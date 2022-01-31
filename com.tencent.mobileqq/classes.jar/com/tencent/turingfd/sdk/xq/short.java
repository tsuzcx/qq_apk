package com.tencent.turingfd.sdk.xq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class short
{
  public static String[] Gb = { else.get(else.ca), else.get(else.da), else.get(else.ea), else.get(else.fa), else.get(else.ga), else.get(else.ha), else.get(else.ia), else.get(else.ja), else.get(else.ka), else.get(else.la), else.get(else.ma), else.get(else.na), else.get(else.oa), else.get(else.pa), else.get(else.qa), else.get(else.ra), else.get(else.sa), else.get(else.ta) };
  
  public static Set<String> b(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = Gb;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (Pattern.compile(arrayOfString[i]).matcher(str).find()) {
          localHashSet.add(str);
        }
        i += 1;
      }
    }
    paramSet.removeAll(localHashSet);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.short
 * JD-Core Version:    0.7.0.1
 */