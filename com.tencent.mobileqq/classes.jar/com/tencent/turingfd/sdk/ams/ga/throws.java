package com.tencent.turingfd.sdk.ams.ga;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class throws
{
  public static String[] Qc = { const.get(const.Fa), const.get(const.Ga), const.get(const.Ha), const.get(const.Ia), const.get(const.Ja), const.get(const.Ka), const.get(const.La), const.get(const.Ma), const.get(const.Na), const.get(const.Oa), const.get(const.Pa), const.get(const.Qa), const.get(const.Ra), const.get(const.Sa), const.get(const.Ta), const.get(const.Ua), const.get(const.Va), const.get(const.Wa), const.get(const.Xa), const.get(const.Ya), const.get(const.Za) };
  
  public static Set<String> a(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = Qc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.throws
 * JD-Core Version:    0.7.0.1
 */