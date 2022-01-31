import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.job.UploadImageJob;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

public class net
  implements UpCallBack
{
  public net(UploadImageJob paramUploadImageJob) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramSendResult.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramSendResult.jdField_b_of_type_JavaLangString);
      UploadImageJob.a(this.a, true);
      return;
    }
    paramSendResult = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramSendResult, new Object[0]);
    }
    UploadImageJob.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     net
 * JD-Core Version:    0.7.0.1
 */