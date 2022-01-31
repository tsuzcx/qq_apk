package dov.com.tencent.mobileqq.activity.shortvideo;

import android.media.MediaPlayer;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$17
  implements Runnable
{
  ShortVideoPreviewActivity$17(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    Message localMessage;
    if ((this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.this$0.jdField_a_of_type_AndroidViewSurfaceView != null))
    {
      localMessage = Message.obtain();
      localMessage.arg1 = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "此时时间为+" + localMessage.arg1);
      }
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localMessage.arg1);
      if (this.this$0.jdField_a_of_type_MqqOsMqqHandler != null) {}
    }
    else
    {
      return;
    }
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(this.this$0.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.17
 * JD-Core Version:    0.7.0.1
 */