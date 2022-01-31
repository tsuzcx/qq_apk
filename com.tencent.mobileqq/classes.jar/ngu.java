import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.OnFetchUserInfoCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;

public class ngu
  implements PlayModeUtils.OnFetchUserInfoCallback
{
  public ngu(VideoPlayModeBase paramVideoPlayModeBase, int paramInt, String paramString1, String paramString2, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(boolean paramBoolean1, QQUserUIItem paramQQUserUIItem, boolean paramBoolean2)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "fetchUserInfo, onFinish, position = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("[az]VideoPlayModeBase.fetchUserInfo: unionId ==>").append(this.jdField_a_of_type_JavaLangString).append("; uin ==> ").append(this.b).append("; \r\nsuccess ==>").append(paramBoolean1).append("; isFromNet ==>").append(paramBoolean2).append("; [important]storyVideoItem.mOwnerUid ==> ").append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid).append("; \r\nuserUIItem ==> ");
      if (paramQQUserUIItem == null) {
        break label207;
      }
    }
    label207:
    for (String str = paramQQUserUIItem.toString();; str = "null")
    {
      QLog.d("VideoPlayModeBase", 2, str);
      if ((paramBoolean1) && (paramQQUserUIItem != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid = paramQQUserUIItem.uid;
        ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      if (Looper.getMainLooper() != Looper.myLooper()) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.post(new ngv(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngu
 * JD-Core Version:    0.7.0.1
 */