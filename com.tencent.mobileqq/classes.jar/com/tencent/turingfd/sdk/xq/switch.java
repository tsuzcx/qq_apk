package com.tencent.turingfd.sdk.xq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class switch
{
  public static String[] Qf = { const.get(const.Ud), const.get(const.Vd), const.get(const.Wd), const.get(const.Xd), const.get(const.Yd), const.get(const.Zd), const.get(const._d), const.get(const.ae), const.get(const.be), const.get(const.ce), const.get(const.de), const.get(const.ee), const.get(const.fe), const.get(const.ge), const.get(const.he), const.get(const.ie), const.get(const.je), const.get(const.ke), const.get(const.le), const.get(const.me), const.get(const.ne) };
  
  public static Set<String> a(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = Qf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.switch
 * JD-Core Version:    0.7.0.1
 */