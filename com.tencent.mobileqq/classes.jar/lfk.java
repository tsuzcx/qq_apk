import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class lfk
  extends lfv
{
  public lfk(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.c != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController.c);
      this.jdField_a_of_type_ComTencentAvVideoController.c = null;
    }
    lek.d(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onCloseDoubleVideoMeeting");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, l, 85);
      this.jdField_a_of_type_ComTencentAvVideoController.a().c("OnCloseDoubleVideoMeetingListener", false);
      this.jdField_a_of_type_ComTencentAvVideoController.a().d("OnCloseDoubleVideoMeetingListener", false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      return;
      lek.e(VideoController.jdField_a_of_type_JavaLangString, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */