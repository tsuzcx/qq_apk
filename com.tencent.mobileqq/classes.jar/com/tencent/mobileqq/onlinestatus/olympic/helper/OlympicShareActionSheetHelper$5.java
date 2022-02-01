package com.tencent.mobileqq.onlinestatus.olympic.helper;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class OlympicShareActionSheetHelper$5
  implements Runnable
{
  OlympicShareActionSheetHelper$5(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str = OlympicShareHelper.a(this.this$0.c, this.a, this.this$0.d);
    ThreadManager.getUIHandler().post(new OlympicShareActionSheetHelper.5.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.5
 * JD-Core Version:    0.7.0.1
 */