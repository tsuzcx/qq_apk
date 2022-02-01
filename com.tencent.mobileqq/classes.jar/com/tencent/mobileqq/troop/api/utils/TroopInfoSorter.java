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
    String str2 = "";
    String str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    if (paramString2 == null) {
      paramString2 = str2;
    }
    return str1.compareTo(paramString2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int j = 0;
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122))) {
      i = 65536;
    } else if ((k >= 48) && (k <= 57)) {
      i = 262144;
    } else {
      i = 131072;
    }
    if (paramString1.charAt(0) >= 'ÿ') {
      j = 1;
    }
    return k << 8 | i | 0x0 | j;
  }
  
  public static void a(TroopInfo paramTroopInfo)
  {
    String str = b(paramTroopInfo);
    paramTroopInfo.mCompareSpell = ChnToSpell.b(str, 1);
    paramTroopInfo.mComparePartInt = a(str, paramTroopInfo.mCompareSpell);
  }
  
  public static String b(TroopInfo paramTroopInfo)
  {
    if (TextUtils.isEmpty(paramTroopInfo.troopRemark))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTroopInfo.troopRemark);
      localStringBuilder.append("-");
      localStringBuilder.append(paramTroopInfo.troopcode);
      return localStringBuilder.toString();
    }
    if ((!paramTroopInfo.hasSetTroopName()) && (!TextUtils.isEmpty(paramTroopInfo.newTroopName)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTroopInfo.getTroopDisplayName());
      localStringBuilder.append("-");
      localStringBuilder.append(paramTroopInfo.troopcode);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTroopInfo.troopname);
    localStringBuilder.append("-");
    localStringBuilder.append(paramTroopInfo.troopcode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopInfoSorter
 * JD-Core Version:    0.7.0.1
 */