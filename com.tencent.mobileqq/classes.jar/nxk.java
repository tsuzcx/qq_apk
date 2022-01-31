import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class nxk
  extends QQStoryObserver
{
  public nxk(QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramInt = 1;
    if ((this.a.a == null) || (!TextUtils.equals(paramString, this.a.a.uid))) {
      return;
    }
    if (paramBoolean1)
    {
      paramString = this.a.a;
      if (paramBoolean2)
      {
        paramString.isSubscribe = paramInt;
        paramString = (QQStoryManager)PlayModeUtils.a().getManager(180);
        if (!paramBoolean2) {
          break label125;
        }
        if (!paramString.i()) {
          paramString.b();
        }
        QQToast.a(PlayModeUtils.a(), 2, "已关注", 0).a();
      }
      for (;;)
      {
        QQStoryMemoriesPresenter.a(this.a).d();
        QQStoryMemoriesPresenter.a(this.a).b();
        return;
        paramInt = 0;
        break;
        label125:
        QQToast.a(PlayModeUtils.a(), 2, "已取消关注", 0).a();
      }
    }
    QQToast.a(PlayModeUtils.a(), 1, "操作失败，请稍后重试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxk
 * JD-Core Version:    0.7.0.1
 */