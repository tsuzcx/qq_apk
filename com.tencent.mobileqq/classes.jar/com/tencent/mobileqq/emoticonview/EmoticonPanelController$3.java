package com.tencent.mobileqq.emoticonview;

import alrp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class EmoticonPanelController$3
  implements Runnable
{
  EmoticonPanelController$3(EmoticonPanelController paramEmoticonPanelController, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    ((alrp)this.this$0.a.a(12)).b();
    this.a.edit().putLong("lastRequestTime", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.3
 * JD-Core Version:    0.7.0.1
 */