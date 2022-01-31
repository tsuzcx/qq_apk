import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class sxa
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public sxb a;
  
  public sxa()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(sxb paramsxb)
  {
    this.jdField_a_of_type_Sxb = paramsxb;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Sxb != null) {
      this.jdField_a_of_type_Sxb.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxa
 * JD-Core Version:    0.7.0.1
 */