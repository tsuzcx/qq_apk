package com.tencent.mobileqq.utils.abtest;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import java.util.Map;

public final class ExpEntityInfo
  extends ExpEntity
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ExpEntityInfo(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    setExpName(paramString1);
    setAssignment(paramString2);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public <T> T a()
  {
    if ((this.jdField_a_of_type_Int != 0) && (!TextUtils.isEmpty(getExpName()))) {
      return QConfigManager.a().a(this.jdField_a_of_type_Int);
    }
    ABTestUtil.a("ExpNewEntityInfo", "getManageParams when manageTypeId=0 or expName null");
    return null;
  }
  
  public String a()
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
  
  public Map<String, String> a()
  {
    return super.getParams();
  }
  
  public void a()
  {
    if (isDefaultRomaExp()) {
      return;
    }
    if (ABTestController.a().a()) {
      ABTestApi.reportExpExpose(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    if (isDefaultRomaExp()) {
      return;
    }
    ABTestController.a().a(getExpName(), getGrayId(), paramInt, paramString);
  }
  
  public void a(ExpEntity paramExpEntity)
  {
    if (paramExpEntity != null)
    {
      if (!getExpName().equalsIgnoreCase(paramExpEntity.getExpName())) {
        return;
      }
      setAssignment(paramExpEntity.getAssignment());
      setPercentage(paramExpEntity.getPercentage());
      setBucket(paramExpEntity.getBucket());
      setGrayId(paramExpEntity.getGrayId());
      setParams(paramExpEntity.getParams());
      setEndTime(paramExpEntity.getEndTime());
      setExpName(paramExpEntity.getExpName());
      setLayerCode(paramExpEntity.getLayerCode());
    }
  }
  
  @Deprecated
  public void a(String paramString)
  {
    if (isDefaultRomaExp()) {
      return;
    }
    ABTestApi.reportExpExpose(this);
    a(0, paramString);
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getExpName());
    localStringBuilder.append("_B");
    return a(localStringBuilder.toString());
  }
  
  public boolean a(String paramString)
  {
    if ((!isDefaultRomaExp()) && (!TextUtils.isEmpty(paramString))) {
      return paramString.equalsIgnoreCase(getAssignment());
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    setAssignment("default");
    setLayerCode("default");
    setGrayId("-1");
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getExpName());
    localStringBuilder.append("_A");
    return b(localStringBuilder.toString());
  }
  
  public boolean b(String paramString)
  {
    if ((!isDefaultRomaExp()) && (!TextUtils.isEmpty(paramString))) {
      return paramString.equalsIgnoreCase(getAssignment());
    }
    return false;
  }
  
  public boolean c()
  {
    return (!isDefaultRomaExp()) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!isDefaultRomaExp())) {
      return paramString.equalsIgnoreCase(getAssignment());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ExpEntityInfo
 * JD-Core Version:    0.7.0.1
 */