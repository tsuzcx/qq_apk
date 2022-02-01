package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class TroopFileDownloadMgr$FileDownloadMgrObserver
  implements Observer
{
  private final void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    paramObject = (Object[])paramObject[1];
    if (i != 1) {
      return;
    }
    a((Set)paramObject[0]);
  }
  
  protected void a(Set<Long> paramSet) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new TroopFileDownloadMgr.FileDownloadMgrObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver
 * JD-Core Version:    0.7.0.1
 */