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
  private Activity a;
  private boolean b;
  private List<TranslucentConvertor.OnTranslucentConversionListener> c = new ArrayList();
  private boolean d;
  
  public TranslucentConvertor(Activity paramActivity, boolean paramBoolean)
  {
    this.a = paramActivity;
    this.b = paramBoolean;
  }
  
  public void a(TranslucentConvertor.OnTranslucentConversionListener paramOnTranslucentConversionListener)
  {
    this.c.add(paramOnTranslucentConversionListener);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (!this.d)
    {
      Activity localActivity = this.a;
      if (localActivity != null)
      {
        this.d = true;
        SwipeLayoutUtils.a(localActivity, this);
      }
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramMethod.getName().equalsIgnoreCase("onTranslucentConversionComplete")) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      this.b = true;
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
      paramMethod = this.c.iterator();
      while (paramMethod.hasNext()) {
        ((TranslucentConvertor.OnTranslucentConversionListener)paramMethod.next()).onTranslucentConversionComplete(paramObject.booleanValue());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TranslucentConvertor
 * JD-Core Version:    0.7.0.1
 */