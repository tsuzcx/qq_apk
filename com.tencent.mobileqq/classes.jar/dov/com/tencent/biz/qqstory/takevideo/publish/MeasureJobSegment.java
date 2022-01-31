package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class MeasureJobSegment
  extends JobSegment
{
  protected long a;
  private final String a;
  private long b;
  
  public MeasureJobSegment()
  {
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.publish.edit." + getClass().getSimpleName());
  }
  
  protected void call(Object paramObject)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.call(paramObject);
  }
  
  protected void notifyError(Error paramError)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  protected void notifyResult(Object paramObject)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyResult(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.MeasureJobSegment
 * JD-Core Version:    0.7.0.1
 */