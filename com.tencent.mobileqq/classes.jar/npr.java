import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import java.util.ArrayList;

class npr
  implements Runnable
{
  npr(npq paramnpq, ArrayList paramArrayList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Npq.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.setVisibility(8);
    this.jdField_a_of_type_Npq.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Npq.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Npq.a.jdField_a_of_type_AndroidOsHandler.post(new nps(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npr
 * JD-Core Version:    0.7.0.1
 */