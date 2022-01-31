package dov.com.tencent.biz.qqstory.takevideo;

import anfn;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

public class EditWebVideoPartManager
  extends EditVideoPartManager
{
  public int a;
  private EncodeVideoTask.ResultListener a;
  
  protected SimpleObserver a()
  {
    return new anfn(this);
  }
  
  public void a(EncodeVideoTask.ResultListener paramResultListener)
  {
    if (paramResultListener != null) {
      this.a = paramResultListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager
 * JD-Core Version:    0.7.0.1
 */