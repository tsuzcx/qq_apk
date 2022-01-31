import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class swt
  implements auoq
{
  swt(sws paramsws) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    if (paramauor.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramauor.jdField_b_of_type_JavaLangString;
      this.a.b();
      sws.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauor.jdField_b_of_type_Int == ayvp.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      sws.a(this.a);
      ved.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramauor = new ErrorMessage(paramauor.jdField_b_of_type_Int, paramauor.a);
    paramauor.extraMsg = "upload";
    sws.a(this.a, paramauor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swt
 * JD-Core Version:    0.7.0.1
 */