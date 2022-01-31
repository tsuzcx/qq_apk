import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

public class njl
  implements Runnable
{
  public njl(FeedsPlayModeBase paramFeedsPlayModeBase, AnimationDrawable paramAnimationDrawable, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njl
 * JD-Core Version:    0.7.0.1
 */