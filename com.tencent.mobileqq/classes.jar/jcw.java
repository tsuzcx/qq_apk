import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class jcw
  implements MediaPlayer.OnCompletionListener
{
  public jcw(VideoController paramVideoController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AVLog.d(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onCloseDoubleVideoMeeting");
    if (this.a.a().H)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.a.a().f;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.a.a(3, l, 85);
      this.a.a().H = false;
      this.a.a().G = false;
      return;
    }
    AVLog.e(VideoController.jdField_a_of_type_JavaLangString, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jcw
 * JD-Core Version:    0.7.0.1
 */