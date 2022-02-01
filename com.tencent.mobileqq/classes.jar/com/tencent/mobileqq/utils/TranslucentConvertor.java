package com.tencent.mobileqq.utils;

import android.app.Activity;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranslucentConvertor
  implements InvocationHandler
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<TranslucentConvertor.OnTranslucentConversionListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public TranslucentConvertor(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if (!this.b)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (localActivity != null)
      {
        this.b = true;
        SwipeLayoutUtils.a(localActivity, this);
      }
    }
  }
  
  public void a(TranslucentConvertor.OnTranslucentConversionListener paramOnTranslucentConversionListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnTranslucentConversionListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramMethod.getName().equalsIgnoreCase("onTranslucentConversionComplete")) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      paramMethod = paramArrayOfObject[0];
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onTranslucentConversionComplete: ");
        paramObject.append(paramMethod);
        QLog.d("TranslucentConvertor", 2, paramObject.toString());
      }
      paramObject = Boolean.valueOf(false);
      if ((paramMethod instanceof Boolean)) {
        paramObject = (Boolean)paramMethod;
      }
      paramMethod = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMethod.hasNext()) {
        ((TranslucentConvertor.OnTranslucentConversionListener)paramMethod.next()).onTranslucentConversionComplete(paramObject.booleanValue());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TranslucentConvertor
 * JD-Core Version:    0.7.0.1
 */