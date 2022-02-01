package com.tencent.mobileqq.leba.entity;

import java.util.Iterator;
import java.util.List;

public class LebaViewItem
{
  public long a;
  public LebaPluginInfo b;
  public String c;
  public String d;
  public int e;
  public byte f;
  public long g;
  public int h = 1;
  
  public static String a(List<LebaViewItem> paramList)
  {
    if (paramList == null) {
      return " print lebaData == null";
    }
    if (paramList.isEmpty()) {
      return " print lebaData.isEmpty()";
    }
    StringBuilder localStringBuilder = new StringBuilder(" print lebaData size = ");
    localStringBuilder.append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (LebaViewItem)paramList.next();
      if (localObject == null)
      {
        localStringBuilder.append("|item = null");
      }
      else
      {
        localStringBuilder.append("|item = ");
        localStringBuilder.append(((LebaViewItem)localObject).a);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).h);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).d);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).e);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).f);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).g);
        localObject = ((LebaViewItem)localObject).b;
        if (localObject == null) {
          localStringBuilder.append("info=null");
        } else {
          localStringBuilder.append(((LebaPluginInfo)localObject).toString());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.f = 0;
  }
  
  public void b()
  {
    this.f = 1;
  }
  
  public boolean c()
  {
    LebaPluginInfo localLebaPluginInfo = this.b;
    if (localLebaPluginInfo != null) {
      return localLebaPluginInfo.getAllowModify();
    }
    return true;
  }
  
  public String d()
  {
    LebaPluginInfo localLebaPluginInfo = this.b;
    if (localLebaPluginInfo != null) {
      return localLebaPluginInfo.getSimpleIcon();
    }
    return "";
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      long l = this.a;
      if (l == 0L) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      if (((paramObject instanceof LebaViewItem)) && (l == ((LebaViewItem)paramObject).a)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.a).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaViewItem
 * JD-Core Version:    0.7.0.1
 */