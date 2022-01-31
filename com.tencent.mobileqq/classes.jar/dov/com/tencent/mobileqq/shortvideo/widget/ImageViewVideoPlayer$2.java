package dov.com.tencent.mobileqq.shortvideo.widget;

import bldn;
import com.tencent.image.VideoDrawable;
import com.tencent.qphone.base.util.QLog;

class ImageViewVideoPlayer$2
  implements Runnable
{
  ImageViewVideoPlayer$2(ImageViewVideoPlayer paramImageViewVideoPlayer, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      long l = System.currentTimeMillis();
      this.this$0.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      if (QLog.isColorLevel()) {
        QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes = " + this.a + ", costTime = " + (System.currentTimeMillis() - l));
      }
      if (this.this$0.jdField_a_of_type_Bldn != null) {
        this.this$0.jdField_a_of_type_Bldn.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */