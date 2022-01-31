import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ske
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public skf a;
  
  public ske()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(skf paramskf)
  {
    this.jdField_a_of_type_Skf = paramskf;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Skf != null) {
      this.jdField_a_of_type_Skf.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ske
 * JD-Core Version:    0.7.0.1
 */