import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class swx
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public swy a;
  
  public swx()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(swy paramswy)
  {
    this.jdField_a_of_type_Swy = paramswy;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Swy != null) {
      this.jdField_a_of_type_Swy.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swx
 * JD-Core Version:    0.7.0.1
 */