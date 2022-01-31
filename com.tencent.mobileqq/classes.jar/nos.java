import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class nos
  implements Runnable
{
  public nos(NewFriendsPlayMode paramNewFriendsPlayMode, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.c);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localVideoListFeedItem != null)
    {
      localObject1 = localObject2;
      if (localVideoListFeedItem.getOwner() != null)
      {
        localObject1 = localObject2;
        if ((localVideoListFeedItem.getOwner() instanceof QQUserUIItem)) {
          localObject1 = ((QQUserUIItem)localVideoListFeedItem.getOwner()).qq;
        }
      }
    }
    ThreadManager.getUIHandler().post(new not(this, (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nos
 * JD-Core Version:    0.7.0.1
 */