import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class jdt
  implements MediaPlayer.OnCompletionListener
{
  public jdt(VideoController paramVideoController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AVLog.d(VideoController.jdField_a_of_type_JavaLangString, "onCompletion request");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.a().g()) {
      return;
    }
    paramMediaPlayer = this.a;
    if (this.a.a().jdField_c_of_type_Long == 2L) {}
    for (int i = 4;; i = 1)
    {
      paramMediaPlayer.a("OnCompletionListener", 2131230740, i, this.a.b);
      this.a.a().a("OnCompletionListener", 6);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.a.a().z), this.a.a().jdField_c_of_type_JavaLangString });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdt
 * JD-Core Version:    0.7.0.1
 */