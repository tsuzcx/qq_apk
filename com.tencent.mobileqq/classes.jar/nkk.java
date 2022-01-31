import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.MainPageChangeEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class nkk
  extends QQStoryObserver
{
  public nkk(NewFriendsPlayMode paramNewFriendsPlayMode) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject2 = ((UserManager)localObject1).a(paramString, false);
    QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(paramString);
    QQStoryApiPlugin.a(PlayModeUtils.a(), paramBoolean2, (String)localObject2, QQStoryContext.a().a());
    if (paramBoolean1)
    {
      label159:
      int j;
      if (paramBoolean2)
      {
        paramInt = 1;
        localQQUserUIItem.isSubscribe = paramInt;
        ThreadManager.post(new nkl(this, (UserManager)localObject1, localQQUserUIItem), 5, null, false);
        if (paramBoolean2)
        {
          localObject1 = (QQStoryManager)PlayModeUtils.a().getManager(180);
          if (!((QQStoryManager)localObject1).h())
          {
            ((QQStoryManager)localObject1).c();
            QQToast.a(PlayModeUtils.a(), 2, "已关注，可随时查看对方的最新日迹", 0).a();
          }
          localObject1 = new MainPageChangeEvent(2);
          Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
        }
        int i = this.a.a.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = 0;
        if (paramInt >= i) {
          break label454;
        }
        j = this.a.a.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
        localObject1 = (VideoPlayerPagerAdapter.VideoViewHolder)this.a.a.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
        if (localObject1 != null) {
          break label217;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break label159;
        paramInt = 0;
        break;
        label217:
        if ((Math.abs(this.a.b - j) <= 2) && (j < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject2 = (StoryVideoItem)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localObject2 != null) && (((StoryVideoItem)localObject2).mStoryType == 1) && (((StoryVideoItem)localObject2).mOwnerUid.equals(localQQUserUIItem.uid))) {
            if (paramString.equals(((StoryVideoItem)localObject2).mOwnerUid))
            {
              if (paramBoolean2) {
                ((View)((VideoPlayerPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidUtilSparseArray.get(2131371695)).setVisibility(8);
              } else {
                ((View)((VideoPlayerPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidUtilSparseArray.get(2131371695)).setVisibility(0);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("VipCardPlayMode", 2, "他人视频, 不刷新关注按钮");
            }
          }
        }
      }
    }
    else
    {
      if (!paramBoolean2) {
        break label455;
      }
      paramString = "取消";
      if (paramInt != 1) {
        break label462;
      }
      QQToast.a(PlayModeUtils.a(), 1, paramString + "关注失败，请稍后重试", 0).a();
      StoryReportor.a("play_video", "follow_fail", 0, 0, new String[] { "1" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipCardPlayMode", 2, "onSetPGCSubscribeStatus failed.");
      }
      label454:
      return;
      label455:
      paramString = "";
      break;
      label462:
      if (paramInt == 0)
      {
        QQToast.a(PlayModeUtils.a(), 1, paramString + "订阅失败，请稍后重试", 0).a();
        StoryReportor.a("play_video", "follow_fail", 0, 0, new String[] { "2" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkk
 * JD-Core Version:    0.7.0.1
 */