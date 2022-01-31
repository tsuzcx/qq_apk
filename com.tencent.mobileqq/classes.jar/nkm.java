import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.qphone.base.util.QLog;

public class nkm
  extends CmdTaskManger.UIThreadCallback
{
  public nkm(EncryptUrlJob paramEncryptUrlJob, String[] paramArrayOfString) {}
  
  public void a(@NonNull StoryShareTranslateTokenRequest paramStoryShareTranslateTokenRequest, @Nullable StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramStoryShareTranslateTokenResponse == null) || (paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int != 0))
    {
      if (paramStoryShareTranslateTokenResponse != null) {}
      for (int i = paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        EncryptUrlJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob, false);
        return;
      }
    }
    if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramStoryShareTranslateTokenRequest = ShareUtils.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], EncryptUrlJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob));; paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramStoryShareTranslateTokenResponse.jdField_a_of_type_JavaLangString + "&" + paramStoryShareTranslateTokenRequest;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramStoryShareTranslateTokenRequest });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob.a("EncryptUrlJob_coverUrl", paramStoryShareTranslateTokenResponse.c);
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob.a("EncryptUrlJob_encryptedUrl", paramStoryShareTranslateTokenRequest);
      EncryptUrlJob.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkm
 * JD-Core Version:    0.7.0.1
 */