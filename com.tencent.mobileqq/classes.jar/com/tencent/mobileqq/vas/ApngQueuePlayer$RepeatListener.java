package com.tencent.mobileqq.vas;

import android.os.Handler;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;

class ApngQueuePlayer$RepeatListener
  implements ApngDrawable.OnPlayRepeatListener
{
  private int jdField_a_of_type_Int;
  
  ApngQueuePlayer$RepeatListener(ApngQueuePlayer paramApngQueuePlayer) {}
  
  public void a(ApngImage paramApngImage)
  {
    this.jdField_a_of_type_Int = paramApngImage.apngLoop;
    paramApngImage.setOnPlayRepeatListener(this);
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      ThreadManagerV2.getUIHandlerV2().post(new ApngQueuePlayer.RepeatListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ApngQueuePlayer.RepeatListener
 * JD-Core Version:    0.7.0.1
 */