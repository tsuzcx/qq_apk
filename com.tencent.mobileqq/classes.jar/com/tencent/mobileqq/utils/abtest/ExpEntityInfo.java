package com.tencent.mobileqq.utils.abtest;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import java.util.Map;

public final class ExpEntityInfo
{
  private int a = 0;
  private boolean b = true;
  private volatile ExpEntity c;
  
  public ExpEntityInfo(String paramString1, String paramString2, int paramInt)
  {
    this.c = new ExpEntity(paramString1);
    this.c.setExpName(paramString1);
    this.c.setAssignment(paramString2);
    this.b = true;
    this.a = paramInt;
  }
  
  public Map<String, String> a()
  {
    if (this.c != null) {
      return this.c.getParams();
    }
    return null;
  }
  
  protected void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    if (this.c != null)
    {
      if (this.c.isDefaultRomaExp()) {
        return;
      }
      ABTestController.a().a(c(), this.c.getGrayId(), paramInt, paramString);
    }
  }
  
  protected void a(ExpEntityInfo paramExpEntityInfo)
  {
    if (paramExpEntityInfo != null)
    {
      if (!c().equalsIgnoreCase(paramExpEntityInfo.c())) {
        return;
      }
      if (paramExpEntityInfo.c != null) {
        this.c = paramExpEntityInfo.c;
      }
      this.a = paramExpEntityInfo.a;
      this.b = paramExpEntityInfo.b;
    }
  }
  
  protected void a(ExpEntity paramExpEntity)
  {
    if (paramExpEntity != null) {
      this.c = paramExpEntity;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null) && (!this.c.isDefaultRomaExp())) {
      return paramString.equalsIgnoreCase(d());
    }
    return false;
  }
  
  public <T> T b()
  {
    if ((this.a != 0) && (!TextUtils.isEmpty(c()))) {
      return QConfigManager.b().b(this.a);
    }
    ABTestUtil.a("ExpNewEntityInfo", "getManageParams when manageTypeId=0 or expName null");
    return null;
  }
  
  public boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null) && (!this.c.isDefaultRomaExp())) {
      return paramString.equalsIgnoreCase(d());
    }
    return false;
  }
  
  public String c()
  {
    if (this.c != null) {
      return this.c.getExpName();
    }
    return null;
  }
  
  @Deprecated
  public void c(String paramString)
  {
    if (this.c != null)
    {
      if (this.c.isDefaultRomaExp()) {
        return;
      }
      ABTestApi.reportExpExpose(this.c);
      a(0, paramString);
    }
  }
  
  public String d()
  {
    if (this.c != null) {
      return this.c.getAssignment();
    }
    return null;
  }
  
  public boolean d(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null) && (!this.c.isDefaultRomaExp())) {
      return paramString.equalsIgnoreCase(d());
    }
    return false;
  }
  
  public String e()
  {
    if (this.c != null) {
      return this.c.getGrayId();
    }
    return null;
  }
  
  public boolean f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("_B");
    return a(localStringBuilder.toString());
  }
  
  public boolean g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("_A");
    return b(localStringBuilder.toString());
  }
  
  public void h()
  {
    if ((ABTestController.a().b()) && (i())) {
      ABTestApi.reportExpExpose(this.c);
    }
  }
  
  public boolean i()
  {
    if ((this.c != null) && (!this.c.isDefaultRomaExp())) {
      return this.b;
    }
    return false;
  }
  
  public void j()
  {
    this.b = false;
    if (this.c != null)
    {
      this.c.setAssignment("default");
      this.c.setLayerCode("default");
      this.c.setGrayId("-1");
    }
  }
  
  public String k()
  {
    Object localObject = a();
    String str = super.toString();
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = "";
    }
    return String.format("%s  params:%s", new Object[] { str, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ExpEntityInfo
 * JD-Core Version:    0.7.0.1
 */