package com.tencent.mobileqq.flashshow.api.helper;

import com.tencent.mobileqq.app.BusinessObserver;

public class FSObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1000) {
      return;
    }
    onUpdateRedPoint();
  }
  
  protected void onUpdateRedPoint() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.helper.FSObserver
 * JD-Core Version:    0.7.0.1
 */