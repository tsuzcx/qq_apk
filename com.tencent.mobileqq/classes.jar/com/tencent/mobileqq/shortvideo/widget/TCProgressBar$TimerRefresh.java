package com.tencent.mobileqq.shortvideo.widget;

import android.os.Handler;
import axml;

class TCProgressBar$TimerRefresh
  implements Runnable
{
  TCProgressBar$TimerRefresh(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    axml localaxml;
    if (this.this$0.jdField_a_of_type_Int == 3)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TimerRefresh(this.this$0), this.this$0.d);
      localaxml = this.this$0.jdField_a_of_type_Axml;
      if (this.this$0.jdField_a_of_type_Axml.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localaxml.e = bool;
      this.this$0.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.TimerRefresh
 * JD-Core Version:    0.7.0.1
 */