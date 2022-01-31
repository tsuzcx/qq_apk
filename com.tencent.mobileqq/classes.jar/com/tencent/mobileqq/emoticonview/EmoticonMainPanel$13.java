package com.tencent.mobileqq.emoticonview;

import ajvp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class EmoticonMainPanel$13
  implements Runnable
{
  EmoticonMainPanel$13(EmoticonMainPanel paramEmoticonMainPanel, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    ((ajvp)this.this$0.a.a(12)).b();
    this.a.edit().putLong("lastRequestTime", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.13
 * JD-Core Version:    0.7.0.1
 */