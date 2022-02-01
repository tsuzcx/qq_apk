package com.tencent.mobileqq.troop.api.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class TroopInfoSorter
{
  public static Comparator<Entity> a = new TroopInfoSorter.1();
  
  public static int a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return str.compareTo(paramString1);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122)))
    {
      i = 65536;
      if (paramString1.charAt(0) < 'ÿ') {
        break label89;
      }
    }
    label89:
    for (int j = 1;; j = 0)
    {
      return j | k << 8 | i | 0x0;
      if ((k >= 48) && (k <= 57))
      {
        i = 262144;
        break;
      }
      i = 131072;
      break;
    }
  }
  
  public static String a(TroopInfo paramTroopInfo)
  {
    if (TextUtils.isEmpty(paramTroopInfo.troopRemark)) {
      return paramTroopInfo.troopRemark + "-" + paramTroopInfo.troopcode;
    }
    if ((paramTroopInfo.hasSetTroopName()) || (TextUtils.isEmpty(paramTroopInfo.newTroopName))) {
      return paramTroopInfo.troopname + "-" + paramTroopInfo.troopcode;
    }
    return paramTroopInfo.getTroopDisplayName() + "-" + paramTroopInfo.troopcode;
  }
  
  public static void a(TroopInfo paramTroopInfo)
  {
    String str = a(paramTroopInfo);
    paramTroopInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramTroopInfo.mComparePartInt = a(str, paramTroopInfo.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopInfoSorter
 * JD-Core Version:    0.7.0.1
 */