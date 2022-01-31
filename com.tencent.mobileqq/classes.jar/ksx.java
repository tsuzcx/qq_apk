import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class ksx
  extends kti
{
  public ksx(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    krx.d(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onCloseDoubleVideoMeeting");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().J)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, l, 85);
      this.jdField_a_of_type_ComTencentAvVideoController.a().J = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().I = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      return;
      krx.e(VideoController.jdField_a_of_type_JavaLangString, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ksx
 * JD-Core Version:    0.7.0.1
 */