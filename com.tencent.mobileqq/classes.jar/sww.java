import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class sww
  implements auoq
{
  sww(swv paramswv) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    if (paramauor.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Swb.c = paramauor.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Swb.a = paramauor.c;
      this.a.b();
      swv.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauor.jdField_b_of_type_Int == ayvp.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      swv.a(this.a);
      ved.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramauor = new ErrorMessage(paramauor.jdField_b_of_type_Int, paramauor.a);
    paramauor.extraMsg = "upload";
    swv.a(this.a, paramauor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sww
 * JD-Core Version:    0.7.0.1
 */