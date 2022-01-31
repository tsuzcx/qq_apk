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

public class nja
  extends QQStoryObserver
{
  public nja(NewFriendsPlayMode paramNewFriendsPlayMode) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject2 = ((UserManager)localObject1).a(paramString, false);
    QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(paramString);
    QQStoryApiPlugin.a(PlayModeUtils.a(), paramBoolean2, (String)localObject2, QQStoryContext.a().a());
    if (paramBoolean1)
    {
      label159:
      int i;
      if (paramBoolean2)
      {
        paramInt = 1;
        localQQUserUIItem.isSubscribe = paramInt;
        ThreadManager.post(new njb(this, (UserManager)localObject1, localQQUserUIItem), 5, null, false);
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
        int j = this.a.a.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = 0;
        if (paramInt >= j) {
          break label473;
        }
        i = this.a.a.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
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
        if ((Math.abs(this.a.b - i) <= 2) && (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject2 = (StoryVideoItem)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localObject2 != null) && (((StoryVideoItem)localObject2).mStoryType == 1) && (((StoryVideoItem)localObject2).mOwnerUid.equals(localQQUserUIItem.uid))) {
            if (paramString.equals(((StoryVideoItem)localObject2).mOwnerUid))
            {
              if (paramBoolean2)
              {
                ((View)((VideoPlayerPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidUtilSparseArray.get(2131371529)).setVisibility(8);
              }
              else
              {
                localObject1 = (View)((VideoPlayerPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidUtilSparseArray.get(2131371529);
                if (paramBoolean2) {}
                for (i = 8;; i = 0)
                {
                  ((View)localObject1).setVisibility(i);
                  break;
                }
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
        break label474;
      }
      paramString = "取消";
      if (paramInt != 1) {
        break label481;
      }
      QQToast.a(PlayModeUtils.a(), 1, paramString + "关注失败，请稍后重试", 0).a();
      StoryReportor.a("play_video", "follow_fail", 0, 0, new String[] { "1" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipCardPlayMode", 2, "onSetPGCSubscribeStatus failed.");
      }
      label473:
      return;
      label474:
      paramString = "";
      break;
      label481:
      if (paramInt == 0)
      {
        QQToast.a(PlayModeUtils.a(), 1, paramString + "订阅失败，请稍后重试", 0).a();
        StoryReportor.a("play_video", "follow_fail", 0, 0, new String[] { "2" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */