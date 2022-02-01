package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class TroopFileSearchableFriend
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public ArrayList<HanziPinyin> h = null;
  public ArrayList<HanziPinyin> i = null;
  public ArrayList<HanziPinyin> j = null;
  public ArrayList<HanziPinyin> k = null;
  
  public TroopFileSearchableFriend(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramString3;
    this.c = ChnToSpell.b(paramString2, 1).toLowerCase();
    this.d = ChnToSpell.b(paramString2, 2).toLowerCase();
    this.f = ChnToSpell.b(paramString3, 1).toLowerCase();
    this.g = ChnToSpell.b(paramString3, 2).toLowerCase();
    boolean bool = TextUtils.isEmpty(paramString2);
    int n = 0;
    int i1;
    int m;
    if (!bool)
    {
      paramString1 = paramString2.trim();
      i1 = paramString1.length();
      this.h = new ArrayList(i1);
      this.i = new ArrayList(i1);
      m = 0;
      while (m < i1)
      {
        int i2 = paramString1.charAt(m);
        if ((i2 >= 19968) && (i2 <= 40869))
        {
          paramString2 = paramString1.substring(m, m + 1);
          this.h.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.b(paramString2, 1).toLowerCase()));
          this.i.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.b(paramString2, 2).toLowerCase()));
        }
        m += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString3.trim();
      i1 = paramString1.length();
      this.j = new ArrayList(i1);
      this.k = new ArrayList(i1);
      m = n;
      while (m < i1)
      {
        n = paramString1.charAt(m);
        if ((n >= 19968) && (n <= 40869))
        {
          paramString2 = paramString1.substring(m, m + 1);
          this.j.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.b(paramString2, 1).toLowerCase()));
          this.k.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.b(paramString2, 2).toLowerCase()));
        }
        m += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    if (paramInt == 5) {
      return paramTroopFileSearchableFriend.f.indexOf(paramString);
    }
    if (paramInt == 6) {
      return paramTroopFileSearchableFriend.g.indexOf(paramString);
    }
    if (paramInt == 2) {
      return paramTroopFileSearchableFriend.c.indexOf(paramString);
    }
    if (paramInt == 3) {
      return paramTroopFileSearchableFriend.d.indexOf(paramString);
    }
    return -1;
  }
  
  protected static int a(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int i1 = paramArrayList.size();
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      HanziPinyin localHanziPinyin = (HanziPinyin)paramArrayList.get(m);
      if (localHanziPinyin.c + n > paramInt) {
        return n;
      }
      n += localHanziPinyin.c;
      m += 1;
    }
    return n;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.j;
    } else if (paramInt1 == 6) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.k;
    } else if (paramInt1 == 2) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.h;
    } else if (paramInt1 == 3) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.i;
    } else {
      paramTroopFileSearchableFriend = null;
    }
    if (paramTroopFileSearchableFriend != null)
    {
      paramInt1 = paramString.length();
      str = a(a(paramInt2, paramTroopFileSearchableFriend), b(paramInt1 + paramInt2, paramTroopFileSearchableFriend), paramTroopFileSearchableFriend);
    }
    return str;
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<HanziPinyin> paramArrayList)
  {
    int i2 = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (m < i2)
    {
      HanziPinyin localHanziPinyin = (HanziPinyin)paramArrayList.get(m);
      if (n == paramInt1) {
        i1 = 1;
      }
      if (n == paramInt2) {
        break;
      }
      if (i1 != 0) {
        localStringBuilder.append(localHanziPinyin.a);
      }
      n += localHanziPinyin.c;
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    int m = b(paramString, paramTroopFileSearchableFriend);
    int n = a(m, paramString, paramTroopFileSearchableFriend);
    if (((n == 0) && (m == 5) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.f))) || ((m == 6) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.g)))) {
      return paramTroopFileSearchableFriend.e;
    }
    if (((n == 0) && (m == 2) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.c))) || ((m == 3) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.d)))) {
      return paramTroopFileSearchableFriend.b;
    }
    if (n > -1) {
      return a(m, n, paramString, paramTroopFileSearchableFriend);
    }
    return null;
  }
  
  protected static int b(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int i1 = paramArrayList.size();
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      n += ((HanziPinyin)paramArrayList.get(m)).c;
      if (n >= paramInt) {
        return n;
      }
      m += 1;
    }
    return n;
  }
  
  protected static final int b(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    String str = paramTroopFileSearchableFriend.f;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 5;
    }
    str = paramTroopFileSearchableFriend.g;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 6;
    }
    str = paramTroopFileSearchableFriend.c;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 2;
    }
    paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.d;
    if ((paramTroopFileSearchableFriend != null) && (paramTroopFileSearchableFriend.indexOf(paramString) > -1)) {
      return 3;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (this.a != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("uin = ");
      localStringBuilder2.append(this.a);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.b != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", name = ");
      localStringBuilder2.append(this.b);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.e != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", remark = ");
      localStringBuilder2.append(this.e);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchableFriend
 * JD-Core Version:    0.7.0.1
 */