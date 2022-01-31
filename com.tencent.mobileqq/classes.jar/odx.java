import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.RequestCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import java.lang.ref.WeakReference;

public final class odx
  implements Step.FinishCallBack
{
  public odx(WeakReference paramWeakReference) {}
  
  public void a(String paramString)
  {
    paramString = (QQStoryNetReqUtils.RequestCallBack)this.a.get();
    if (paramString != null) {
      paramString.a(Integer.valueOf(((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odx
 * JD-Core Version:    0.7.0.1
 */