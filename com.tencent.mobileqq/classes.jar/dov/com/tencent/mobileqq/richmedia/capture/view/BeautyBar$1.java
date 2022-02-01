package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import android.widget.TextView;

class BeautyBar$1
  extends Handler
{
  BeautyBar$1(BeautyBar paramBeautyBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (BeautyBar.a(this.a) != null) {
        BeautyBar.a(this.a).startAnimation(BeautyBar.a(this.a));
      }
    } while (BeautyBar.a(this.a) == null);
    BeautyBar.a(this.a).startAnimation(BeautyBar.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.1
 * JD-Core Version:    0.7.0.1
 */