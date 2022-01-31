import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoEnterPageMembersControlUI;

public class jzz
  implements Runnable
{
  public jzz(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int i = 0;
      while (i < j)
      {
        arrayOfMultiVideoEnterPageMembersControlUI[i].c();
        i += 1;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jzz
 * JD-Core Version:    0.7.0.1
 */