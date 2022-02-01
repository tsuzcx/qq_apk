package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class native
{
  public static Map<String, Set<String>> Rf = new HashMap();
  public static Map<String, Integer> Sf = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    Rf.put(final.get(final.we), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    Rf.put(final.get(final.xe), localHashSet);
    Sf.put(final.get(final.we), Integer.valueOf(105118));
    Sf.put(final.get(final.xe), Integer.valueOf(105178));
  }
  
  public static ArrayList<Hydra> s(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    paramContext = void.c(paramContext, str);
    Hydra localHydra = new Hydra();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.vf);
    localStringBuilder.append(super.zf);
    localHydra.G = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    localHydra.H = localStringBuilder.toString();
    localArrayList.add(localHydra);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.native
 * JD-Core Version:    0.7.0.1
 */