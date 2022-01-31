import android.util.SparseArray;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

class ngv
  implements Runnable
{
  ngv(ngu paramngu) {}
  
  public void run()
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.a.get(this.a.jdField_a_of_type_Int);
    if ((localVideoViewHolder != null) && (localVideoViewHolder.c == this.a.jdField_a_of_type_Int)) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngv
 * JD-Core Version:    0.7.0.1
 */