package dov.com.tencent.mobileqq.shortvideo.widget;

import android.os.Handler;
import brlk;

class TCProgressBar$TimerRefresh
  implements Runnable
{
  TCProgressBar$TimerRefresh(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    brlk localbrlk;
    if (this.this$0.jdField_a_of_type_Int == 3)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TimerRefresh(this.this$0), this.this$0.d);
      localbrlk = this.this$0.jdField_a_of_type_Brlk;
      if (this.this$0.jdField_a_of_type_Brlk.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localbrlk.e = bool;
      this.this$0.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar.TimerRefresh
 * JD-Core Version:    0.7.0.1
 */