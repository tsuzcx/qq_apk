import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lfr
  extends lfv
{
  public lfr(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.w(VideoController.jdField_a_of_type_JavaLangString, 1, "onCompletion, request, mainSession[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().n())
    {
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    paramMediaPlayer = this.jdField_a_of_type_ComTencentAvVideoController;
    long l = this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 2L) {}
    for (int i = 4;; i = 1)
    {
      paramMediaPlayer.a(l, 2131230741, i, this.jdField_a_of_type_ComTencentAvVideoController.b);
      this.jdField_a_of_type_ComTencentAvVideoController.a().a("OnCompletionListener", 6);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().y), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
      this.jdField_a_of_type_Long = 0L;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */