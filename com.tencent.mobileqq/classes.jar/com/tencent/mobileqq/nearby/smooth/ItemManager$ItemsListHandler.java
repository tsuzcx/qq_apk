package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Message;

class ItemManager$ItemsListHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ((ItemManager)paramMessage.obj).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager.ItemsListHandler
 * JD-Core Version:    0.7.0.1
 */