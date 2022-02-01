package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import antu;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class EmoticonPanelController$3
  implements Runnable
{
  EmoticonPanelController$3(EmoticonPanelController paramEmoticonPanelController, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    ((antu)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).b();
    this.val$sp.edit().putLong("lastRequestTime", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.3
 * JD-Core Version:    0.7.0.1
 */