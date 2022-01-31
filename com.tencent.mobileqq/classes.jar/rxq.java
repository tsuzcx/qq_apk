import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.OnDownloadAsyncTaskListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public final class rxq
  implements ChatActivityUtils.OnDownloadAsyncTaskListener
{
  public rxq(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    AudioHelper.b("发起音视频_获取会议id_rsp");
    Bundle localBundle2 = this.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putInt("ConfAppID", paramInt1);
    localBundle1.putInt("MeetingConfID", paramInt2);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, localBundle1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxq
 * JD-Core Version:    0.7.0.1
 */