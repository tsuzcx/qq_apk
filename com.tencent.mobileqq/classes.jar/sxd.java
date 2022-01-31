import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tribe.async.reactive.SimpleObserver;

public class sxd
  extends SimpleObserver<ErrorMessage>
{
  private sxd(BasePublishTask paramBasePublishTask) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      this.a.a(new ErrorMessage());
      return;
    }
    this.a.a(paramErrorMessage);
  }
  
  public void onCancel() {}
  
  public void onComplete() {}
  
  public void onError(@NonNull Error paramError)
  {
    if ((paramError instanceof ErrorMessage))
    {
      this.a.a((ErrorMessage)paramError);
      return;
    }
    this.a.a(new ErrorMessage(940005, "upload file fail:" + paramError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxd
 * JD-Core Version:    0.7.0.1
 */