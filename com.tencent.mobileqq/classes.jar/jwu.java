import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GAudioMemberListCtrl;
import com.tencent.av.ui.GAudioMembersCtrlActivity;

public class jwu
  implements Runnable
{
  private jwu(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.a.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jwu
 * JD-Core Version:    0.7.0.1
 */