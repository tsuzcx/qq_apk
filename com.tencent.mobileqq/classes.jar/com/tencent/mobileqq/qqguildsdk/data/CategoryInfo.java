package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CategoryInfo
  implements ICategoryInfo
{
  String a;
  long b;
  Vector<GProChannelInfo> c;
  
  public CategoryInfo(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = new Vector();
  }
  
  public static Vector<CategoryInfo> a(String paramString, long paramLong)
  {
    Vector localVector = new Vector();
    localVector.add(new CategoryInfo(paramString, paramLong));
    return localVector;
  }
  
  public static Vector<CategoryInfo> d()
  {
    return new Vector();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(GProChannelInfo paramGProChannelInfo)
  {
    this.c.add(paramGProChannelInfo);
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(GProChannelInfo paramGProChannelInfo)
  {
    this.c.remove(paramGProChannelInfo);
  }
  
  public List<IGProChannelInfo> c()
  {
    return new ArrayList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.CategoryInfo
 * JD-Core Version:    0.7.0.1
 */