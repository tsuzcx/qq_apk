import android.os.Bundle;
import com.tencent.av.utils.VideoMsgTools.4;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class kie
  implements Runnable
{
  public kie(VideoMsgTools.4 param4, int paramInt, String paramString) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Int == 3000) {}
    for (int i = 1;; i = 10)
    {
      localBundle.putInt("MultiAVType", i);
      if (this.jdField_a_of_type_ComTencentAvUtilsVideoMsgTools$4.jdField_a_of_type_Boolean) {
        localBundle.putBoolean("isVideo", true);
      }
      localBundle.putBoolean("forceShowInviteBox", true);
      localBundle.putBoolean("enableInvite", true);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvUtilsVideoMsgTools$4.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentAvUtilsVideoMsgTools$4.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kie
 * JD-Core Version:    0.7.0.1
 */