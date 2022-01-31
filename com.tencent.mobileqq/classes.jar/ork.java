import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import friendlist.GetOnlineInfoResp;
import mqq.os.MqqHandler;

public class ork
  extends FriendListObserver
{
  public ork(StoryQIMBadgeView paramStoryQIMBadgeView) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    super.onGetOnlineInfoByUinOrMobile(paramBoolean, paramLong, paramString, paramGetOnlineInfoResp);
    if ((StoryQIMBadgeView.a(this.a) == null) || (paramGetOnlineInfoResp == null) || (TextUtils.isEmpty(StoryQIMBadgeView.a(this.a).qq))) {}
    while ((!paramBoolean) || (!Utils.a(StoryQIMBadgeView.a(this.a).qq, paramString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new orl(this, paramGetOnlineInfoResp, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */