import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class rek
  extends alox
{
  rek(reh paramreh, QQAppInterface paramQQAppInterface) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("VALUE_USER_UIN_TO_GET_NICK_NAME", paramString);
      localBundle.putString("VALUE_USER_NICK_NAME", bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true));
      QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_GET_NICK_NAME_BY_UIN", localBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rek
 * JD-Core Version:    0.7.0.1
 */