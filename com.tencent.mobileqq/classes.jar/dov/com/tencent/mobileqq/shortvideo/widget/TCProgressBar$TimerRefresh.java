package dov.com.tencent.mobileqq.shortvideo.widget;

import android.os.Handler;

class TCProgressBar$TimerRefresh
  implements Runnable
{
  TCProgressBar$TimerRefresh(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    TCProgressBar.BlinkBlock localBlinkBlock;
    if (this.this$0.jdField_a_of_type_Int == 3)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TimerRefresh(this.this$0), this.this$0.d);
      localBlinkBlock = this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$BlinkBlock;
      if (this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$BlinkBlock.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localBlinkBlock.e = bool;
      this.this$0.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar.TimerRefresh
 * JD-Core Version:    0.7.0.1
 */