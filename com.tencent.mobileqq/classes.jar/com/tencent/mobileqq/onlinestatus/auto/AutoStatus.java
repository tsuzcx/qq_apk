package com.tencent.mobileqq.onlinestatus.auto;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AutoStatus
{
  public int a;
  private long a;
  
  public AutoStatus(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > Constant.O;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 40001;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = a();
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
      return this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int;
    }
    return false;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoStatus{status=");
    localStringBuilder.append(Constant.a(this.jdField_a_of_type_Int));
    localStringBuilder.append(", updateTime=");
    localStringBuilder.append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Long)));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatus
 * JD-Core Version:    0.7.0.1
 */