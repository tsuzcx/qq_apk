package com.tencent.qidian.controller;

import java.util.HashMap;

public class QidianBusinessObserverExpose
  extends QidianBusinessObserverBase
{
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1009) {
      return;
    }
    a(paramBoolean, (HashMap)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianBusinessObserverExpose
 * JD-Core Version:    0.7.0.1
 */