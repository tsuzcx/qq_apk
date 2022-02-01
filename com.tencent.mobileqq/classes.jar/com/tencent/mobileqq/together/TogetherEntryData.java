package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class TogetherEntryData
{
  static int[] a = { 1001, 1003, 1002, 1005, 1004 };
  static int[] b = { -8293377, -35897, -42646, -3243777, -16725252 };
  static int[] c = { 2131891216, 2131916687, 2131917984, 2131897447, 2131897449 };
  static int[] d = { 2130847836, 2130847838, 2130847839, 2130846272, 2130847837 };
  static int[] e = { 2131897446, 2131897462, 2131897480, 2131897448, 2131897450 };
  static int f = 2131897466;
  public int g;
  public int h;
  public String i;
  public String j;
  public int k;
  public String l;
  public int m;
  public boolean n = false;
  public int o = 0;
  public ArrayList<String> p;
  
  public static Drawable a(Context paramContext, TogetherEntryData paramTogetherEntryData)
  {
    switch (paramTogetherEntryData.g)
    {
    default: 
      return null;
    case 1005: 
      return paramContext.getResources().getDrawable(2130846272);
    case 1004: 
      return paramContext.getResources().getDrawable(2130847837);
    case 1003: 
      return paramContext.getResources().getDrawable(2130847838);
    case 1002: 
      return paramContext.getResources().getDrawable(2130847839);
    }
    return paramContext.getResources().getDrawable(2130847836);
  }
  
  public static ArrayList<TogetherEntryData> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i1 = 0;
    while (i1 < 4)
    {
      TogetherEntryData localTogetherEntryData = new TogetherEntryData();
      localTogetherEntryData.g = a[i1];
      localTogetherEntryData.h = i1;
      localTogetherEntryData.k = b[i1];
      localTogetherEntryData.i = HardCodeUtil.a(c[i1]);
      localTogetherEntryData.m = d[i1];
      localTogetherEntryData.j = HardCodeUtil.a(e[i1]);
      localArrayList.add(localTogetherEntryData);
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void a(@Nullable TogetherEntryData paramTogetherEntryData)
  {
    if (paramTogetherEntryData == null) {
      return;
    }
    this.n = paramTogetherEntryData.n;
    this.o = paramTogetherEntryData.o;
    this.p = paramTogetherEntryData.p;
  }
  
  public String b()
  {
    if (this.n)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.o);
      localStringBuilder.append(HardCodeUtil.a(f));
      return localStringBuilder.toString();
    }
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherEntryData
 * JD-Core Version:    0.7.0.1
 */