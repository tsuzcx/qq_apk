import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mjf
  extends mck
{
  public mjf(VideoControlUI paramVideoControlUI, long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this);
      }
    }
    do
    {
      do
      {
        return;
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c, 1, "onNotify_ScreenShot_Finish, flag[" + this.jdField_a_of_type_Long + "], _flag[" + paramLong + "], path[" + paramString + "], ret[" + paramBoolean + "], seq[" + this.b + "]");
      } while (this.jdField_a_of_type_Long != paramLong);
      if (paramBoolean) {
        awgq.a((Context)this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */