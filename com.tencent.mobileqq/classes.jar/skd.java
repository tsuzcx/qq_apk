import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class skd
  implements atqq
{
  skd(skc paramskc) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    if (paramatqr.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Sji.c = paramatqr.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Sji.a = paramatqr.c;
      this.a.b();
      skc.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramatqr.jdField_b_of_type_Int == axvg.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      skc.a(this.a);
      urk.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramatqr = new ErrorMessage(paramatqr.jdField_b_of_type_Int, paramatqr.a);
    paramatqr.extraMsg = "upload";
    skc.a(this.a, paramatqr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */