package com.tencent.turingfd.sdk.xq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class boolean
{
  public static String[] ig = { final.get(final.be), final.get(final.ce), final.get(final.de), final.get(final.ee), final.get(final.fe), final.get(final.ge), final.get(final.he), final.get(final.ie), final.get(final.je), final.get(final.ke), final.get(final.le), final.get(final.me), final.get(final.ne), final.get(final.oe), final.get(final.pe), final.get(final.qe), final.get(final.re), final.get(final.se), final.get(final.te), final.get(final.ue), final.get(final.ve) };
  
  public static Set<String> a(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = ig;
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.boolean
 * JD-Core Version:    0.7.0.1
 */