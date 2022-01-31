package com.tencent.mobileqq.troop.filemanager.upload;

import ajnb;
import android.os.Handler;
import android.os.Looper;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class TroopFileUploadMgr$FileUploadMgrObserver
  implements Observer
{
  private final void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    paramObject = (Object[])paramObject[1];
    switch (i)
    {
    default: 
      return;
    }
    a((Set)paramObject[0]);
  }
  
  public void a(Set paramSet) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new ajnb(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver
 * JD-Core Version:    0.7.0.1
 */