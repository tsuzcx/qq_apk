package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import bifw;
import java.util.HashMap;

class RedTouchWebviewHandler$2
  implements Runnable
{
  RedTouchWebviewHandler$2(RedTouchWebviewHandler paramRedTouchWebviewHandler, long paramLong, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = RedTouchWebviewHandler.parseGetAppInfoList(RedTouchWebviewHandler.access$000(this.this$0), this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    if (this.this$0.mRuntime != null)
    {
      Activity localActivity = this.this$0.mRuntime.a();
      if (localActivity != null) {
        localActivity.runOnUiThread(new RedTouchWebviewHandler.2.1(this, localHashMap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.2
 * JD-Core Version:    0.7.0.1
 */