package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class C2CShortcutBarConfBean
{
  @Alias(a="isShowAssistantEntrance")
  public int a = 0;
  @Alias(a="kuolieAIOEnable")
  public int b = 0;
  
  public static C2CShortcutBarConfBean a(String paramString)
  {
    C2CShortcutBarConfBean localC2CShortcutBarConfBean = (C2CShortcutBarConfBean)JSONConverter.a(paramString, C2CShortcutBarConfBean.class);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("parse: ");
      paramString.append(localC2CShortcutBarConfBean);
      if (paramString.toString() != null) {
        paramString = localC2CShortcutBarConfBean.toString();
      } else {
        paramString = " C2CShortcutBarConfBean is null";
      }
      QLog.d("C2CShortcutBarConfBean", 2, paramString);
    }
    return localC2CShortcutBarConfBean;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CShortcutBarConfBean{isShowAssistantEntrance = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("kuolieAIOEnable = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarConfBean
 * JD-Core Version:    0.7.0.1
 */