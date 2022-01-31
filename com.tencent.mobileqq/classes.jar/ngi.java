import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.DecryptCallback;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class ngi
  extends CmdTaskManger.UIThreadCallback
{
  ngi(ngh paramngh, long paramLong, QQProgressDialog paramQQProgressDialog) {}
  
  public void a(@NonNull StoryShareTranslateTokenRequest paramStoryShareTranslateTokenRequest, @Nullable StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", resp:" + paramStoryShareTranslateTokenResponse);
    }
    StoryReportor.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Ngh.a.a(paramStoryShareTranslateTokenResponse, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngi
 * JD-Core Version:    0.7.0.1
 */