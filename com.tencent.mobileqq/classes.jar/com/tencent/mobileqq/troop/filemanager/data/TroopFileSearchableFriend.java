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
    boolean bool = TextUtils.isEmpty(paramString2);
    int j = 0;
    int k;
    int i;
    if (!bool)
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
    if (paramInt == 5) {
      return paramTroopFileSearchableFriend.f.indexOf(paramString);
    }
    if (paramInt == 6) {
      return paramTroopFileSearchableFriend.g.indexOf(paramString);
    }
    if (paramInt == 2) {
      return paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString.indexOf(paramString);
    }
    if (paramInt == 3) {
      return paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString.indexOf(paramString);
    }
    return -1;
  }
  
  protected static int a(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      HanziPinyin localHanziPinyin = (HanziPinyin)paramArrayList.get(i);
      if (localHanziPinyin.jdField_a_of_type_Int + j > paramInt) {
        return j;
      }
      j += localHanziPinyin.jdField_a_of_type_Int;
      i += 1;
    }
    return j;
  }
  
  protected static final int a(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    String str = paramTroopFileSearchableFriend.f;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 5;
    }
    str = paramTroopFileSearchableFriend.g;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 6;
    }
    str = paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString;
    if ((str != null) && (str.indexOf(paramString) > -1)) {
      return 2;
    }
    paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString;
    if ((paramTroopFileSearchableFriend != null) && (paramTroopFileSearchableFriend.indexOf(paramString) > -1)) {
      return 3;
    }
    return 0;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_c_of_type_JavaUtilArrayList;
    } else if (paramInt1 == 6) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_d_of_type_JavaUtilArrayList;
    } else if (paramInt1 == 2) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_a_of_type_JavaUtilArrayList;
    } else if (paramInt1 == 3) {
      paramTroopFileSearchableFriend = paramTroopFileSearchableFriend.jdField_b_of_type_JavaUtilArrayList;
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
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m)
    {
      HanziPinyin localHanziPinyin = (HanziPinyin)paramArrayList.get(i);
      if (j == paramInt1) {
        k = 1;
      }
      if (j == paramInt2) {
        break;
      }
      if (k != 0) {
        localStringBuilder.append(localHanziPinyin.jdField_a_of_type_JavaLangString);
      }
      j += localHanziPinyin.jdField_a_of_type_Int;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString, TroopFileSearchableFriend paramTroopFileSearchableFriend)
  {
    int i = a(paramString, paramTroopFileSearchableFriend);
    int j = a(i, paramString, paramTroopFileSearchableFriend);
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.f))) || ((i == 6) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.g)))) {
      return paramTroopFileSearchableFriend.e;
    }
    if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(paramTroopFileSearchableFriend.jdField_d_of_type_JavaLangString)))) {
      return paramTroopFileSearchableFriend.jdField_b_of_type_JavaLangString;
    }
    if (j > -1) {
      return a(i, j, paramString, paramTroopFileSearchableFriend);
    }
    return null;
  }
  
  protected static int b(int paramInt, ArrayList<HanziPinyin> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((HanziPinyin)paramArrayList.get(i)).jdField_a_of_type_Int;
      if (j >= paramInt) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("uin = ");
      localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", name = ");
      localStringBuilder2.append(this.jdField_b_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchableFriend
 * JD-Core Version:    0.7.0.1
 */