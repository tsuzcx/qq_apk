package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class CategoryChannelSortInfo
{
  private String a;
  private long b;
  private List<String> c;
  
  public CategoryChannelSortInfo(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = new ArrayList();
  }
  
  public CategoryChannelSortInfo(String paramString, long paramLong, List<String> paramList)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramList;
  }
  
  private boolean f()
  {
    return this.a != null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.c.add(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!f())) {
      return false;
    }
    return (!paramBoolean) || (d());
  }
  
  public long b()
  {
    return this.b;
  }
  
  public List<String> c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (!TextUtils.isEmpty(this.a)) && (this.b != 0L);
  }
  
  public boolean e()
  {
    List localList = this.c;
    return (localList != null) && (localList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo
 * JD-Core Version:    0.7.0.1
 */