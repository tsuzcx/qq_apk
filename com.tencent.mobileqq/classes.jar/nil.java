import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;

class nil
  implements Runnable
{
  nil(nik paramnik, ArrayList paramArrayList) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if (localStoryVideoItem.equals(this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
      this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.copy(localStoryVideoItem);
    }
    if (MsgTabPlayMode.a(this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode) != 0) {
      this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.c(0);
    }
    this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.e = this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.equals(this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.b));
    this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.e = false;
    this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_a_of_type_Nik.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nil
 * JD-Core Version:    0.7.0.1
 */