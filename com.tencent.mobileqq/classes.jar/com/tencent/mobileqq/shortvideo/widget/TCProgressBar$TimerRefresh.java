package com.tencent.mobileqq.shortvideo.widget;

import android.os.Handler;
import azhr;

class TCProgressBar$TimerRefresh
  implements Runnable
{
  TCProgressBar$TimerRefresh(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    azhr localazhr;
    if (this.this$0.jdField_a_of_type_Int == 3)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TimerRefresh(this.this$0), this.this$0.d);
      localazhr = this.this$0.jdField_a_of_type_Azhr;
      if (this.this$0.jdField_a_of_type_Azhr.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localazhr.e = bool;
      this.this$0.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.TimerRefresh
 * JD-Core Version:    0.7.0.1
 */