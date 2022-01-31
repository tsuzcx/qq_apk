import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class swz
  implements auoo
{
  swz(swy paramswy) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void b(auop paramauop)
  {
    if (paramauop.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Swe.c = paramauop.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Swe.a = paramauop.c;
      this.a.b();
      swy.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauop.jdField_b_of_type_Int == ayvn.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      swy.a(this.a);
      veg.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramauop = new ErrorMessage(paramauop.jdField_b_of_type_Int, paramauop.a);
    paramauop.extraMsg = "upload";
    swy.a(this.a, paramauop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swz
 * JD-Core Version:    0.7.0.1
 */