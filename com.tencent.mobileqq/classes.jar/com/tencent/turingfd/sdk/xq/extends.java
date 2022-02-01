package com.tencent.turingfd.sdk.xq;

import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extends
{
  public static final Set<String> a;
  public static final String[] b;
  public static final Set<String> c;
  
  static
  {
    HashSet localHashSet = new HashSet();
    a = localHashSet;
    b = new String[0];
    localHashSet.add(import.a(import.M));
    localHashSet.add(import.a(import.N));
    localHashSet.add(import.a(import.O));
    localHashSet.add(import.a(import.P));
    localHashSet.add(import.a(import.Q));
    localHashSet.add(import.a(import.R));
    localHashSet.add(import.a(import.S));
    localHashSet.add(import.a(import.T));
    localHashSet.add(import.a(import.U));
    localHashSet.add(import.a(import.V));
    localHashSet.add(import.a(import.W));
    localHashSet.add(import.a(import.X));
    localHashSet = new HashSet();
    c = localHashSet;
    localHashSet.add(import.a(import.L));
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString1 = new String(instanceof.a(paramString1));
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = b;
      }
      else
      {
        localObject1 = paramString1.split("\n");
        if (localObject1 != null)
        {
          paramString1 = (String)localObject1;
          if (localObject1.length != 0) {}
        }
        else
        {
          paramString1 = b;
        }
      }
    }
    finally
    {
      Object localObject1;
      label64:
      int j;
      int i;
      break label64;
    }
    paramString1 = null;
    if (paramString1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(";-1");
      localStringBuffer.append(paramString1.toString());
      return localStringBuffer.toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString3);
    ((StringBuilder)localObject1).append(";0");
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    new HashMap();
    paramString3 = new HashMap();
    paramString2 = Pattern.compile(paramString2);
    j = paramString1.length;
    i = 0;
    while (i < j)
    {
      Object localObject2 = paramString2.matcher(paramString1[i]);
      if (((Matcher)localObject2).find())
      {
        localObject1 = ((Matcher)localObject2).group(4).trim();
        if ("0A".equals(((Matcher)localObject2).group(3)))
        {
          localObject2 = ((Matcher)localObject2).group(1).split(":");
          if ((localObject2 != null) && (localObject2.length >= 2)) {
            paramString3.put(localObject2[1], localObject1);
          }
        }
      }
      i += 1;
    }
    if (!paramString3.isEmpty())
    {
      localStringBuffer.append(";");
      paramString1 = paramString3.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localStringBuffer.append((String)paramString3.get(paramString2));
        localStringBuffer.append(":");
        localStringBuffer.append(paramString2);
        if (paramString1.hasNext()) {
          localStringBuffer.append(",");
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static List<Lynx> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = const.h();
    Object localObject3 = new ArrayList();
    int j = Process.myPid();
    Object localObject2 = (ArrayList)localObject1;
    localObject1 = ((ArrayList)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Aquila)((Iterator)localObject1).next();
      if (j == ((Aquila)localObject4).a) {
        i = ((Aquila)localObject4).e;
      }
    }
    Object localObject5;
    if ((i != 0) && (j != i))
    {
      localObject4 = ((ArrayList)localObject2).iterator();
      localObject1 = "";
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Aquila)((Iterator)localObject4).next();
        if (i == ((Aquila)localObject5).a) {
          localObject1 = ((Aquila)localObject5).d;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new Lynx();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(return.a);
        ((StringBuilder)localObject5).append(return.e);
        ((Lynx)localObject4).a = ((StringBuilder)localObject5).toString();
        ((Lynx)localObject4).b = ((String)localObject1);
        ((ArrayList)localObject3).add(localObject4);
      }
    }
    localArrayList.addAll((Collection)localObject3);
    localObject3 = new StringBuilder();
    localObject1 = new ArrayList();
    Object localObject4 = ((ArrayList)localObject2).iterator();
    Iterator localIterator;
    String str;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Aquila)((Iterator)localObject4).next();
      localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((Aquila)localObject5).d.contains(str))
        {
          ((StringBuilder)localObject3).append(((Aquila)localObject5).d);
          ((StringBuilder)localObject3).append("_");
        }
      }
    }
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject4 = new Lynx();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(return.a);
      ((StringBuilder)localObject5).append(return.c);
      ((Lynx)localObject4).a = ((StringBuilder)localObject5).toString();
      ((Lynx)localObject4).b = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
      ((ArrayList)localObject1).add(localObject4);
    }
    localArrayList.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    localObject3 = new StringBuilder();
    localObject4 = new HashSet();
    localObject2 = ((ArrayList)localObject2).iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (Aquila)((Iterator)localObject2).next();
      label768:
      if ((((Aquila)localObject5).c == 0) && (((Aquila)localObject5).d.startsWith("/")) && (!((Aquila)localObject5).d.startsWith("/system")) && (!((Aquila)localObject5).d.startsWith("/dev")) && (!((Aquila)localObject5).d.startsWith("/sbin")) && (!((Aquila)localObject5).d.startsWith("/init")) && (!((Aquila)localObject5).d.startsWith("/vendor")) && (!((Aquila)localObject5).d.startsWith("/bin")) && (!((Aquila)localObject5).d.startsWith("/usr")) && (!((Aquila)localObject5).d.contains("kinguser")) && (!((Aquila)localObject5).d.endsWith("so")))
      {
        localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (((Aquila)localObject5).d.contains(str))
          {
            j = 1;
            break label709;
          }
        }
        j = 0;
        label709:
        if (j == 0)
        {
          localIterator = c.iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (((Aquila)localObject5).d.contains(str))
            {
              j = 1;
              break label768;
            }
          }
          j = 0;
          if (j == 0)
          {
            ((HashSet)localObject4).add(((Aquila)localObject5).d);
            if (i >= 8) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    if (((HashSet)localObject4).size() > 0)
    {
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject3).append((String)((Iterator)localObject2).next());
        ((StringBuilder)localObject3).append("%3B");
      }
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new Lynx();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(return.a);
      ((StringBuilder)localObject4).append(return.d);
      ((Lynx)localObject3).a = ((StringBuilder)localObject4).toString();
      ((Lynx)localObject3).b = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      ((ArrayList)localObject1).add(localObject3);
    }
    localArrayList.addAll((Collection)localObject1);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.extends
 * JD-Core Version:    0.7.0.1
 */