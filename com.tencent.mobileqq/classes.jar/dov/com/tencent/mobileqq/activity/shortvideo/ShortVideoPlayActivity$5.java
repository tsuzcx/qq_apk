package dov.com.tencent.mobileqq.activity.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$5
  implements Runnable
{
  ShortVideoPlayActivity$5(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (this.this$0.b())
    {
      if (this.this$0.b <= 0L) {
        this.this$0.h();
      }
      ShortVideoPlayActivity.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (ShortVideoPlayActivity.a(this.this$0) != 0L)
      {
        ShortVideoPlayActivity.a(this.this$0, (int)(ShortVideoPlayActivity.a(this.this$0) * 10000L / this.this$0.b + 0.5D));
        if (!ShortVideoPlayActivity.a(this.this$0))
        {
          this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(ShortVideoPlayActivity.a(this.this$0));
          this.this$0.b(ShortVideoPlayActivity.a(this.this$0));
        }
      }
    }
    if ((this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.this$0.g != 0L))
    {
      if (!this.this$0.jdField_f_of_type_Boolean) {
        break label352;
      }
      ShortVideoPlayActivity.b(this.this$0, (int)(this.this$0.jdField_f_of_type_Long * 10000L / this.this$0.g));
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.this$0)) {
        this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.this$0));
      }
      if ((this.this$0.c()) && (ShortVideoPlayActivity.c(this.this$0) > 0) && (ShortVideoPlayActivity.a(this.this$0) != null) && (ShortVideoPlayActivity.a(this.this$0).getVisibility() == 0))
      {
        String str = ShortVideoUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.c(this.this$0) * 1024);
        ShortVideoPlayActivity.a(this.this$0).setText(str + "/s");
      }
      if (!this.this$0.isFinishing()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
      }
      return;
      label352:
      ShortVideoPlayActivity.b(this.this$0, 10000);
    }
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */