import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import java.lang.ref.WeakReference;

public class nnl
  implements DialogInterface.OnDismissListener
{
  private final WeakReference a;
  private final WeakReference b;
  
  public nnl(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    this.a = new WeakReference(paramVideoPlayModeBase);
    this.b = new WeakReference(paramVideoViewHolder);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (VideoPlayModeBase)this.a.get();
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.b.get();
    if ((paramDialogInterface != null) && (localVideoViewHolder != null))
    {
      paramDialogInterface.s();
      if (localVideoViewHolder.a != null)
      {
        localVideoViewHolder.a.b();
        paramDialogInterface.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.l(paramDialogInterface.b);
        paramDialogInterface.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.c();
      }
      paramDialogInterface.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnl
 * JD-Core Version:    0.7.0.1
 */