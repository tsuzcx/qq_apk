package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.utils.StringUtil;

public class AutoStatusItem
  extends OnlineStatusItem
{
  public String o;
  public Category p;
  public Sensor q;
  public boolean r = false;
  
  public AutoStatusItem() {}
  
  public AutoStatusItem(long paramLong, String paramString1, String paramString2, Category paramCategory, String paramString3, Sensor paramSensor, String paramString4, boolean paramBoolean)
  {
    this.b = paramLong;
    this.c = paramString1;
    this.o = paramString2;
    this.p = paramCategory;
    this.d = paramString3;
    this.q = paramSensor;
    this.i = paramString4;
    this.r = paramBoolean;
  }
  
  public AutoStatusItem(long paramLong, String paramString1, String paramString2, Category paramCategory, String paramString3, String paramString4, Sensor paramSensor, String paramString5, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramCategory, paramString3, paramSensor, paramString5, paramBoolean);
    if (StringUtil.isEmpty(paramString4))
    {
      this.e = paramString3;
      return;
    }
    this.e = paramString4;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoStatus [id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", category=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", sensor=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", isHide=");
    localStringBuilder.append(this.r);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoStatusItem
 * JD-Core Version:    0.7.0.1
 */