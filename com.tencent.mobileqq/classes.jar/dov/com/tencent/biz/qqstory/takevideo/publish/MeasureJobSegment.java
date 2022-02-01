package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class MeasureJobSegment<IN, OUT>
  extends JobSegment<IN, OUT>
{
  protected long a;
  private final String a;
  private long b = 0L;
  
  public MeasureJobSegment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.publish.edit." + getClass().getSimpleName());
  }
  
  public void call(IN paramIN)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.call(paramIN);
  }
  
  public void notifyError(Error paramError)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  public void notifyResult(OUT paramOUT)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyResult(paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.MeasureJobSegment
 * JD-Core Version:    0.7.0.1
 */