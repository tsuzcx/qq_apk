package com.tencent.mobileqq.onlinestatus.auto;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AutoStatus
{
  public int a;
  private long b;
  
  public AutoStatus(int paramInt)
  {
    this.a = paramInt;
    this.b = System.currentTimeMillis();
  }
  
  private boolean b()
  {
    return System.currentTimeMillis() - this.b > Constant.R;
  }
  
  public void a()
  {
    this.a = 40001;
    this.b = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    this.b = System.currentTimeMillis();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = b();
    if ((QLog.isColorLevel()) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status] resetIfDead from: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" hasDead: ");
      localStringBuilder.append(true);
      localStringBuilder.append(" status: ");
      localStringBuilder.append(toString());
      QLog.d("AutoStatus", 2, localStringBuilder.toString());
    }
    if (bool) {
      a();
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (AutoStatus)paramObject;
      return this.a == paramObject.a;
    }
    return false;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoStatus{status=");
    localStringBuilder.append(Constant.c(this.a));
    localStringBuilder.append(", updateTime=");
    localStringBuilder.append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.b)));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatus
 * JD-Core Version:    0.7.0.1
 */