import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class sww
  implements auoo
{
  sww(swv paramswv) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void b(auop paramauop)
  {
    if (paramauop.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramauop.jdField_b_of_type_JavaLangString;
      this.a.b();
      swv.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauop.jdField_b_of_type_Int == ayvn.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      swv.a(this.a);
      veg.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramauop = new ErrorMessage(paramauop.jdField_b_of_type_Int, paramauop.a);
    paramauop.extraMsg = "upload";
    swv.a(this.a, paramauop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sww
 * JD-Core Version:    0.7.0.1
 */