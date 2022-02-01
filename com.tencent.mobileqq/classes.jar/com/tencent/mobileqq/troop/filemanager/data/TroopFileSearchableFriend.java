package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class TroopFileSearchableFriend
{
  public String a;
  public ArrayList<HanziPinyin> a;
  public String b;
  public ArrayList<HanziPinyin> b;
  public String c;
  public ArrayList<HanziPinyin> c;
  public String d;
  public ArrayList<HanziPinyin> d;
  public String e;
  public String f;
  public String g;
  
  public TroopFileSearchableFriend(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_d_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.e = paramString3;
    this.jdField_c_of_type_JavaLangString = ChnToSpell.a(paramString2, 1).toLowerCase();
    this.jdField_d_of_type_JavaLangString = ChnToSpell.a(paramString2, 2).toLowerCase();
    this.f = ChnToSpell.a(paramString3, 1).toLowerCase();
    this.g = ChnToSpell.a(paramString3, 2).toLowerCase();
    int k;
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.trim();
      k = paramString1.length();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(k);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(k);
      i = 0;
      while (i < k)
      {
        int m = paramString1.charAt(i);
        if ((m >= 19968) && (m <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.jdField_a_of_type_JavaUtilArrayList.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_b_of_type_JavaUtilArrayList.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString3.trim();
      k = paramString1.length();
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(k);
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(k);
      i = j;
      while (i < k)
      {
        j = paramString1.charAt(i);
        if ((j >= 19968) && (j <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.jdField_c_of_type_JavaUtilArrayList.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_d_of_type_JavaUtilArrayList.add(new HanziPinyin(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    int i = -1;
    if (paramInt == 5) {
      i = paramTroopFileSearchableFriend.f.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return paramTroopFileSearchableFriend.g.indexOf(paramString);
      }
      if (paramInt == 2) {
        return paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString.indexOf(paramString);
      }
    } while (paramInt != 3);
    return paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      HanziPinyin localHanziPinyin;
      if (i < k)
      {
        localHanziPinyin = (HanziPinyin)paramArrayList.get(i);
        if (localHanziPinyin.jdField_a_of_type_Int + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localHanziPinyin.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    int j = 0;
    int i;
    if ((paramTroopFileSearchableFriend.f != null) && (paramTroopFileSearchableFriend.f.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((paramTroopFileSearchableFriend.g != null) && (paramTroopFileSearchableFriend.g.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString != null) && (paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString == null);
      i = j;
    } while (paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_c_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      if (paramTroopFileSearchableFriend != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, paramTroopFileSearchableFriend), b(paramInt1 + paramInt2, paramTroopFileSearchableFriend), paramTroopFileSearchableFriend);
      }
      return str;
      if (paramInt1 == 6) {
        paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_d_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 2) {
        paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_a_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 3) {
        paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_b_of_type_JavaUtilArrayList;
      } else {
        paramTroopFileSearchableFriend = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<HanziPinyin> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      HanziPinyin localHanziPinyin;
      if (i < m)
      {
        localHanziPinyin = (HanziPinyin)paramArrayList.get(i);
        if (j == paramInt1) {
          k = 1;
        }
        if (j != paramInt2) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
      if (k != 0) {
        localStringBuilder.append(localHanziPinyin.jdField_a_of_type_JavaLangString);
      }
      j += localHanziPinyin.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public static final String a(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    int i = a(paramString, paramTroopFileSearchableFriend);
    int j = a(i, paramString, paramTroopFileSearchableFriend);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.f))) || ((i == 6) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.g)))) {
      str = paramTroopFileSearchableFriend.e;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString)))) {
        return paramTroopFileSearchableFriend.jdField_b_of_type_JavaLangString;
      }
    } while (j <= -1);
    return a(i, j, paramString, paramTroopFileSearchableFriend);
  }
  
  protected static int b(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((HanziPinyin)paramArrayList.get(i)).jdField_a_of_type_Int + j;
      if (j >= paramInt) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaLangString != null) {
      localStringBuilder.append("uin = " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      localStringBuilder.append(", name = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.e != null) {
      localStringBuilder.append(", remark = " + this.e);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchableFriend
 * JD-Core Version:    0.7.0.1
 */