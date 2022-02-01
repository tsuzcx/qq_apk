package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.BusinessObserver;

public class MiniAppEntryObserver
  implements BusinessObserver
{
  public void onMiniAppEntryChanged() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onMiniAppEntryChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryObserver
 * JD-Core Version:    0.7.0.1
 */