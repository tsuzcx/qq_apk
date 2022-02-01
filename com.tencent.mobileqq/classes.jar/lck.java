import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

public class lck
  extends lcv
{
  public lck(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.w(VideoController.a, 1, "onCompletion, onClose, mainSession[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().p())
    {
      lbd.g(VideoController.a, "onCompletion onClose is not Closing2");
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().d, 217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lck
 * JD-Core Version:    0.7.0.1
 */