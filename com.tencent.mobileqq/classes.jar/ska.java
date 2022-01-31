import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class ska
  implements atqq
{
  ska(sjz paramsjz) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    if (paramatqr.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramatqr.jdField_b_of_type_JavaLangString;
      this.a.b();
      sjz.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramatqr.jdField_b_of_type_Int == axvg.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      sjz.a(this.a);
      urk.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramatqr = new ErrorMessage(paramatqr.jdField_b_of_type_Int, paramatqr.a);
    paramatqr.extraMsg = "upload";
    sjz.a(this.a, paramatqr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ska
 * JD-Core Version:    0.7.0.1
 */