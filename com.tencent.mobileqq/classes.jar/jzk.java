import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class jzk
  implements Runnable
{
  public jzk(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.c();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jzk
 * JD-Core Version:    0.7.0.1
 */