import android.app.Activity;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.callback.OnPrepareShareListener;
import com.tencent.biz.qqstory.newshare.callback.OnShareListener;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.ui.ShareUI;
import com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils;

public class nel
  implements OnPrepareShareListener
{
  public nel(StoryShare paramStoryShare) {}
  
  public void a(ShareData paramShareData)
  {
    StoryShare.a(this.a).c();
    Activity localActivity = StoryShare.a(this.a).a();
    if (localActivity == null)
    {
      c(paramShareData);
      return;
    }
    StoryBasicShareUtils.a(localActivity, paramShareData, StoryShare.a(this.a));
  }
  
  public void b(ShareData paramShareData)
  {
    StoryShare.a(this.a).c();
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).c(paramShareData.a);
    }
  }
  
  public void c(ShareData paramShareData)
  {
    StoryShare.a(this.a).c();
    if (StoryShare.a(this.a) != null) {
      StoryShare.a(this.a).d(paramShareData.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nel
 * JD-Core Version:    0.7.0.1
 */