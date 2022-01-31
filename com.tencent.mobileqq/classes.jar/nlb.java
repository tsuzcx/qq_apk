import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.OutSingleSharePlayMode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.app.FriendListObserver;
import java.util.ArrayList;

public class nlb
  extends FriendListObserver
{
  public nlb(OutSingleSharePlayMode paramOutSingleSharePlayMode) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    String str;
    if ((paramBoolean) && (paramString != null))
    {
      str = QQStoryContext.a().a(paramString);
      if (!TextUtils.equals(str, paramString)) {
        break label27;
      }
    }
    label137:
    for (;;)
    {
      return;
      label27:
      int i = 0;
      for (;;)
      {
        if (i >= this.a.a.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break label137;
        }
        VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.a.a.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if (localVideoViewHolder == null) {
          break;
        }
        if (TextUtils.equals(paramString, String.valueOf(((StoryVideoItem)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(localVideoViewHolder.c)).mOwnerUid)))
        {
          this.a.d();
          SLog.d("Q.qqstory.player.NewFriendsPlayMode", "update nickname=%s, uin=%s", new Object[] { str, paramString });
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlb
 * JD-Core Version:    0.7.0.1
 */