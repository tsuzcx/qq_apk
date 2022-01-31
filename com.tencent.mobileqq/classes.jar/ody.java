import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.RequestCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.ErrorCallBack;
import java.lang.ref.WeakReference;

public final class ody
  implements Step.ErrorCallBack
{
  public ody(WeakReference paramWeakReference) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    QQStoryNetReqUtils.RequestCallBack localRequestCallBack = (QQStoryNetReqUtils.RequestCallBack)this.a.get();
    if (localRequestCallBack != null) {
      localRequestCallBack.a(paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */