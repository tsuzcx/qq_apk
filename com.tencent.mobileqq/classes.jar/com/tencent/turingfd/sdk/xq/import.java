package com.tencent.turingfd.sdk.xq;

import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class import
{
  public static final Set<String> Of = new HashSet();
  public static List<Hydra> Pf = null;
  public static final Set<String> Qf;
  
  static
  {
    Of.add(final.get(final.ze));
    Of.add(final.get(final.Ae));
    Of.add(final.get(final.Be));
    Of.add(final.get(final.Ce));
    Of.add(final.get(final.De));
    Of.add(final.get(final.Ee));
    Of.add(final.get(final.Fe));
    Of.add(final.get(final.Ge));
    Of.add(final.get(final.He));
    Of.add(final.get(final.Ie));
    Of.add(final.get(final.Je));
    Of.add(final.get(final.Ke));
    Qf = new HashSet();
    Qf.add(final.get(final.ye));
  }
  
  public static List<Hydra> F()
  {
    List localList = Pf;
    if (localList != null) {
      return localList;
    }
    return I();
  }
  
  public static List<Hydra> I()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = void.n();
    Object localObject3 = new ArrayList();
    int j = Process.myPid();
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (strictfp)((Iterator)localObject1).next();
      if (j == ((strictfp)localObject4).pid) {
        i = ((strictfp)localObject4).sg;
      }
    }
    Object localObject5;
    if ((i != 0) && (j != i))
    {
      localObject4 = ((List)localObject2).iterator();
      localObject1 = "";
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (strictfp)((Iterator)localObject4).next();
        if (i == ((strictfp)localObject5).pid) {
          localObject1 = ((strictfp)localObject5).name;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new Hydra();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(super.vf);
        ((StringBuilder)localObject5).append(super.Ef);
        ((Hydra)localObject4).G = ((StringBuilder)localObject5).toString();
        ((Hydra)localObject4).H = ((String)localObject1);
        ((List)localObject3).add(localObject4);
      }
    }
    localArrayList.addAll((Collection)localObject3);
    localObject3 = new StringBuilder();
    localObject1 = new ArrayList();
    Object localObject4 = ((List)localObject2).iterator();
    Iterator localIterator;
    String str;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (strictfp)((Iterator)localObject4).next();
      localIterator = Of.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((strictfp)localObject5).name.contains(str))
        {
          ((StringBuilder)localObject3).append(((strictfp)localObject5).name);
          ((StringBuilder)localObject3).append("_");
        }
      }
    }
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject4 = new Hydra();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(super.vf);
      ((StringBuilder)localObject5).append(super.Af);
      ((Hydra)localObject4).G = ((StringBuilder)localObject5).toString();
      ((Hydra)localObject4).H = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
      ((List)localObject1).add(localObject4);
    }
    localArrayList.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    localObject3 = new StringBuilder();
    localObject4 = new HashSet();
    localObject2 = ((List)localObject2).iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (strictfp)((Iterator)localObject2).next();
      label771:
      if ((((strictfp)localObject5).uid == 0) && (((strictfp)localObject5).name.startsWith("/")) && (!((strictfp)localObject5).name.startsWith("/system")) && (!((strictfp)localObject5).name.startsWith("/dev")) && (!((strictfp)localObject5).name.startsWith("/sbin")) && (!((strictfp)localObject5).name.startsWith("/init")) && (!((strictfp)localObject5).name.startsWith("/vendor")) && (!((strictfp)localObject5).name.startsWith("/bin")) && (!((strictfp)localObject5).name.startsWith("/usr")) && (!((strictfp)localObject5).name.contains("kinguser")) && (!((strictfp)localObject5).name.endsWith("so")))
      {
        localIterator = Of.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (((strictfp)localObject5).name.contains(str))
          {
            j = 1;
            break label712;
          }
        }
        j = 0;
        label712:
        if (j == 0)
        {
          localIterator = Qf.iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (((strictfp)localObject5).name.contains(str))
            {
              j = 1;
              break label771;
            }
          }
          j = 0;
          if (j == 0)
          {
            ((Set)localObject4).add(((strictfp)localObject5).name);
            if (i >= 8) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    if (((Set)localObject4).size() > 0)
    {
      localObject2 = ((Set)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject3).append((String)((Iterator)localObject2).next());
        ((StringBuilder)localObject3).append("_");
      }
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new Hydra();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(super.vf);
      ((StringBuilder)localObject4).append(super.Bf);
      ((Hydra)localObject3).G = ((StringBuilder)localObject4).toString();
      ((Hydra)localObject3).H = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      ((List)localObject1).add(localObject3);
    }
    localArrayList.addAll((Collection)localObject1);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.import
 * JD-Core Version:    0.7.0.1
 */