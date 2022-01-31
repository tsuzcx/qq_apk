import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class tdd
  implements atqq
{
  tdd(tdc paramtdc) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    if ((paramatqr.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramatqr.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramatqr.jdField_b_of_type_JavaLangString);
      tdc.a(this.a, true);
      return;
    }
    paramatqr = new ErrorMessage(paramatqr.jdField_b_of_type_Int, paramatqr.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramatqr, new Object[0]);
    }
    tdc.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdd
 * JD-Core Version:    0.7.0.1
 */