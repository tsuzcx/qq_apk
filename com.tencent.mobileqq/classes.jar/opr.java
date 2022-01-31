import android.os.Bundle;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.OnFetchUserInfoCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class opr
  implements PlayModeUtils.OnFetchUserInfoCallback
{
  public opr(StoryVideoPlayer paramStoryVideoPlayer, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, QQUserUIItem paramQQUserUIItem, boolean paramBoolean2)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "StoryPlayVideoActivity.fetchUserInfo, success==%s, unionId==%s, uin==%s, userUIItem==%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_JavaLangString, this.b, paramQQUserUIItem });
    if (!paramBoolean1) {
      QLog.e("Q.qqstory.player.StoryVideoPlayer", 2, "读取用户信息失败了, 赶紧查一下");
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ops(this));
      return;
      if (paramQQUserUIItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.d = paramQQUserUIItem.qq;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.b = paramQQUserUIItem.uid;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opr
 * JD-Core Version:    0.7.0.1
 */