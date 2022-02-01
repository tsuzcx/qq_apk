package com.tencent.mobileqq.troop.troopcatalog;

import java.util.ArrayList;

public class GroupCatalogBean
{
  public int a;
  public String b;
  public String c;
  public ArrayList<GroupCatalogBean> d;
  public GroupCatalogBean e;
  
  private GroupCatalogBean() {}
  
  public GroupCatalogBean(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.c = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    String str = this.b;
    GroupCatalogBean localGroupCatalogBean = this;
    for (;;)
    {
      localGroupCatalogBean = localGroupCatalogBean.e;
      if (localGroupCatalogBean == null) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localGroupCatalogBean.b);
      localStringBuilder.append("-");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  public boolean a(GroupCatalogBean paramGroupCatalogBean)
  {
    if ((paramGroupCatalogBean != null) && (paramGroupCatalogBean.a + 1 == this.a))
    {
      this.e = paramGroupCatalogBean;
      return true;
    }
    return false;
  }
  
  public void b(GroupCatalogBean paramGroupCatalogBean)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramGroupCatalogBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean
 * JD-Core Version:    0.7.0.1
 */