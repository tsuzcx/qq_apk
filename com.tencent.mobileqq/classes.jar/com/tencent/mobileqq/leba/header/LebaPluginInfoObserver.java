package com.tencent.mobileqq.leba.header;

import com.tencent.mobileqq.app.BusinessObserver;

public class LebaPluginInfoObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
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
      b(paramBoolean, paramObject);
      return;
    }
    c(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaPluginInfoObserver
 * JD-Core Version:    0.7.0.1
 */