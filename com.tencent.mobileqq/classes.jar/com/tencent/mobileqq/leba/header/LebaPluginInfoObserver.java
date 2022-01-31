package com.tencent.mobileqq.leba.header;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class LebaPluginInfoObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramBoolean, paramObject);
      return;
    case 1: 
      try
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue());
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("LebaPluginInfoObserver", 1, "error of  TYPE_RED_TOUCH_PUSHED :", paramObject);
        return;
      }
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaPluginInfoObserver
 * JD-Core Version:    0.7.0.1
 */