package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.api.INearPeopleFilters;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class NearPeopleFilters
  implements INearPeopleFilters
{
  public static final String[] a = { HardCodeUtil.a(2131905258), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  public static final String[] b = { HardCodeUtil.a(2131905266), HardCodeUtil.a(2131905253), HardCodeUtil.a(2131905262), HardCodeUtil.a(2131905264), HardCodeUtil.a(2131905269), HardCodeUtil.a(2131905255), HardCodeUtil.a(2131905273), HardCodeUtil.a(2131905257) };
  public static final String[] c = { HardCodeUtil.a(2131905270), HardCodeUtil.a(2131905275), HardCodeUtil.a(2131905272), HardCodeUtil.a(2131905259), HardCodeUtil.a(2131905260), HardCodeUtil.a(2131905265), HardCodeUtil.a(2131905274), HardCodeUtil.a(2131905263), HardCodeUtil.a(2131905256), HardCodeUtil.a(2131905261), HardCodeUtil.a(2131905271), HardCodeUtil.a(2131905254), HardCodeUtil.a(2131905268) };
  public static final int[] d = { 0, 2130847206, 2130847202, 2130847201, 2130847207, 2130847204, 2130847205, 2130847203 };
  public static final int[] e = { 0, 1, 2, 3 };
  public boolean f = false;
  public String g = "不限";
  public String h = "不限";
  public String i = "不限";
  public String j = "不限";
  private int k = 0;
  private int l = 4;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private String[] q = { "0", "0", "0", "0" };
  
  public static NearPeopleFilters a(String paramString)
  {
    return a(paramString, "nearpeople_filters");
  }
  
  public static NearPeopleFilters a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    paramString1 = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4);
    if (paramString1 != null)
    {
      paramString2 = new NearPeopleFilters();
      paramString2.a(paramString1.getInt("gender", -1));
      if (paramString2.a() == -1) {
        return null;
      }
      paramString2.f = paramString1.getBoolean("byuser", false);
      paramString2.c(paramString1.getInt("age", 0));
      paramString2.d(paramString1.getInt("interest", 0));
      paramString2.b(paramString1.getInt("time", 3));
      paramString2.e(paramString1.getInt("xingzuo", 0));
      paramString2.f(paramString1.getInt("key_career", 0));
      paramString2.g()[0] = paramString1.getString("key_hometown_country", "0");
      paramString2.g()[1] = paramString1.getString("key_hometown_province", "0");
      paramString2.g()[2] = paramString1.getString("key_hometown_city", "0");
      paramString2.g = paramString1.getString("key_hometown_string", "不限");
      paramString2.h = paramString1.getString("str_country", "不限");
      paramString2.i = paramString1.getString("str_province", "不限");
      paramString2.j = paramString1.getString("str_city", "不限");
      if ("-1".equals(paramString2.g()[0])) {
        paramString2.g()[0] = "0";
      }
      if ("-1".equals(paramString2.g()[1])) {
        paramString2.g()[1] = "0";
      }
      if ("-1".equals(paramString2.g()[2])) {
        paramString2.g()[2] = "0";
      }
      return paramString2;
    }
    return null;
  }
  
  public static void a(String paramString, NearPeopleFilters paramNearPeopleFilters)
  {
    a(paramString, paramNearPeopleFilters, "nearpeople_filters");
  }
  
  public static void a(String paramString1, NearPeopleFilters paramNearPeopleFilters, String paramString2)
  {
    if (paramNearPeopleFilters != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      paramString1 = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4);
      if (paramString1 != null) {
        paramString1.edit().putBoolean("byuser", paramNearPeopleFilters.f).putInt("gender", paramNearPeopleFilters.a()).putInt("time", paramNearPeopleFilters.b()).putInt("age", paramNearPeopleFilters.c()).putInt("xingzuo", paramNearPeopleFilters.e()).putInt("key_career", paramNearPeopleFilters.f()).putString("key_hometown_country", paramNearPeopleFilters.g()[0]).putString("key_hometown_province", paramNearPeopleFilters.g()[1]).putString("key_hometown_city", paramNearPeopleFilters.g()[2]).putString("key_hometown_string", paramNearPeopleFilters.g).putString("str_country", paramNearPeopleFilters.h).putString("str_province", paramNearPeopleFilters.i).putString("str_city", paramNearPeopleFilters.j).putInt("interest", paramNearPeopleFilters.d()).commit();
      }
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int c()
  {
    return this.m;
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  public int d()
  {
    return this.n;
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public int e()
  {
    return this.o;
  }
  
  public void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    int i1 = 0;
    boolean bool2;
    if ((paramObject != null) && ((paramObject instanceof NearPeopleFilters)))
    {
      paramObject = (NearPeopleFilters)paramObject;
      boolean bool1;
      if ((a() == paramObject.a()) && ((b() == paramObject.b()) || (((b() == 4) || (b() == 3)) && ((paramObject.b() == 4) || (paramObject.b() == 3)))) && (c() == paramObject.c()) && (e() == paramObject.e()) && (f() == paramObject.f()) && (d() == paramObject.d())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1) {
        for (;;)
        {
          bool2 = bool1;
          if (i1 >= 3) {
            break;
          }
          bool1 &= g()[i1].equalsIgnoreCase(paramObject.g()[i1]);
          if (!bool1) {
            return bool1;
          }
          i1 += 1;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public int f()
  {
    return this.p;
  }
  
  public void f(int paramInt)
  {
    this.p = paramInt;
  }
  
  public String[] g()
  {
    return this.q;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    int i1 = a();
    if (i1 != 0) {
      if (i1 != 1)
      {
        if (i1 == 2) {
          localStringBuilder.append("女,");
        }
      }
      else {
        localStringBuilder.append("男,");
      }
    }
    if (c() != 0)
    {
      i1 = c();
      localObject = a;
      if (i1 < localObject.length)
      {
        localStringBuilder.append(localObject[c()]);
        localStringBuilder.append(',');
      }
    }
    if (d() != 0)
    {
      i1 = d();
      localObject = b;
      if (i1 < localObject.length)
      {
        localStringBuilder.append(localObject[d()]);
        localStringBuilder.append(',');
      }
    }
    if ((f() != 0) && (f() < NearbyProfileUtil.f.length))
    {
      String str = NearbyProfileUtil.f[f()];
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = HardCodeUtil.a(2131905267);
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(',');
    }
    if ((!TextUtils.isEmpty(this.g)) && (!this.g.equals("不限")))
    {
      i1 = this.g.lastIndexOf("-");
      if (i1 > 0) {
        localObject = this.g.substring(i1 + 1);
      } else {
        localObject = this.g;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(',');
    }
    if (e() != 0)
    {
      i1 = e();
      localObject = c;
      if (i1 < localObject.length)
      {
        localStringBuilder.append(localObject[e()]);
        localStringBuilder.append(',');
      }
    }
    i1 = b();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if ((i1 != 3) && (i1 == 4)) {
            localStringBuilder.append("8小时内,");
          }
        }
        else {
          localStringBuilder.append("4小时内,");
        }
      }
      else {
        localStringBuilder.append("1个小时内,");
      }
    }
    else {
      localStringBuilder.append("30分钟内,");
    }
    Object localObject = localStringBuilder.toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i1 = localStringBuilder.lastIndexOf(",");
      if (i1 > 0) {
        return ((String)localObject).substring(0, i1);
      }
    }
    localStringBuilder.append("全部");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearPeopleFilters
 * JD-Core Version:    0.7.0.1
 */