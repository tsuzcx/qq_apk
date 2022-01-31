package com.tencent.turingfd.sdk.xq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class const
{
  public static final Set<String> Ab = new HashSet();
  public static final String[] Bb = new String[0];
  public static List<import> Cb = null;
  public static final Set<String> Db;
  
  static
  {
    Ab.add(else.get(else.xa));
    Ab.add(else.get(else.ya));
    Ab.add(else.get(else.za));
    Ab.add(else.get(else.Aa));
    Ab.add(else.get(else.Ba));
    Ab.add(else.get(else.Ca));
    Ab.add(else.get(else.Da));
    Ab.add(else.get(else.Ea));
    Ab.add(else.get(else.Fa));
    Ab.add(else.get(else.Ga));
    Ab.add(else.get(else.Ha));
    Ab.add(else.get(else.Ia));
    Db = new HashSet();
    Db.add(else.get(else.wa));
  }
  
  public static String a(Set<String> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localStringBuilder.append((String)paramSet.next());
      if (paramSet.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Set<String> a(List<double> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      double localdouble = (double)paramList.next();
      if ((localdouble.uid == 2000) && (!localdouble.name.contains("logcat")) && (!localdouble.name.contains("sh")) && (!localdouble.name.contains("adbd")) && (!localdouble.name.contains("su")) && (!localdouble.name.contains("grep")) && (!localdouble.name.startsWith("/system/bin")) && (!localdouble.name.startsWith("/sbin"))) {
        localHashSet.add(localdouble.name);
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.const
 * JD-Core Version:    0.7.0.1
 */