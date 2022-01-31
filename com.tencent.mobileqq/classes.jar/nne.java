import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DebugInfo;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnPreparedListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;

public class nne
  implements IVideoView.OnPreparedListener
{
  public nne(VideoPlayModeBase paramVideoPlayModeBase, StoryVideoItem paramStoryVideoItem, QQStoryLoadingView paramQQStoryLoadingView) {}
  
  public void a(IVideoView paramIVideoView)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "[7] onPrepared");
    PlayModeUtils.DebugInfo localDebugInfo = PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity));
    localDebugInfo.g = SystemClock.uptimeMillis();
    paramIVideoView.b();
    int i = localDebugInfo.jdField_a_of_type_Int;
    Object localObject;
    int j;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 0L)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d = System.currentTimeMillis();
      localObject = (StoryPlayVideoActivity)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity;
      i = (int)(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d - ((StoryPlayVideoActivity)localObject).jdField_a_of_type_Long);
      String str1 = StoryReportor.a(VideoPlayModeBase.a());
      j = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a();
      if (VideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase) == 0L)
      {
        localObject = "0";
        StoryReportor.b("play_video", "first_spend_time", i, j, new String[] { localObject, str1, "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        i = localDebugInfo.jdField_a_of_type_Int;
        j = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a();
        String str2 = localDebugInfo.a();
        if (VideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase) != 0L) {
          break label767;
        }
        localObject = "0";
        label204:
        StoryReportor.b("play_video", "all_spend_time", i, j, new String[] { str2, localObject, str1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.f != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.f.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid)))
        {
          i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a();
          j = (int)(System.currentTimeMillis() - ((StoryPlayVideoActivity)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity).jdField_a_of_type_Long);
          if (VideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase) != 0L) {
            break label775;
          }
          localObject = "0";
          label318:
          StoryReportor.b("play_video", "video_prepare_time", i, j, new String[] { "0", localObject, str1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
          if (localDebugInfo.jdField_a_of_type_Int != 1) {
            break label783;
          }
          localObject = "11";
          label369:
          StoryReportor.b("play_video", "start_wait_time", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(), (int)(SystemClock.uptimeMillis() - localDebugInfo.jdField_a_of_type_Long), new String[] { localObject, localDebugInfo.a(), str1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        }
        label425:
        SLog.b("Q.qqstory.player.YPlayModeUtils", "onPrepared set progress bar GONE");
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b), this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e, paramIVideoView.b(), paramIVideoView);
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayModeBase", 2, "video duration:" + paramIVideoView.b() + ", index=" + this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b + ", vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)) || (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))) {
          break label1028;
        }
        VideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(), false, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayModeBase", 2, "Do play video. vid = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + " localPath = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$HideProgressBarRunnable.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b;
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$HideProgressBarRunnable, 20L);
      return;
      localObject = "1";
      break;
      label767:
      localObject = "1";
      break label204;
      label775:
      localObject = "1";
      break label318;
      label783:
      if (localDebugInfo.jdField_a_of_type_Int == 4)
      {
        localObject = "10";
        break label369;
      }
      localObject = "12";
      break label369;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.f == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.f.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))) {
        break label425;
      }
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a();
      j = (int)(SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.h);
      if (VideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase) == 0L)
      {
        localObject = "0";
        label875:
        StoryReportor.b("play_video", "video_prepare_time", i, j, new String[] { "1", localObject, StoryReportor.a(VideoPlayModeBase.a()), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (localDebugInfo.jdField_a_of_type_Int != 1) {
          break label1003;
        }
        localObject = "21";
      }
      for (;;)
      {
        StoryReportor.b("play_video", "start_wait_time", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(), (int)(SystemClock.uptimeMillis() - localDebugInfo.d), new String[] { localObject, localDebugInfo.a(), StoryReportor.a(VideoPlayModeBase.a()), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        break;
        localObject = "1";
        break label875;
        label1003:
        if (localDebugInfo.jdField_a_of_type_Int == 4) {
          localObject = "20";
        } else {
          localObject = "22";
        }
      }
      label1028:
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayModeBase", 2, "not report play, vid = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + " mOwnerUid:" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid + ", myUin:" + QQStoryContext.a().b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nne
 * JD-Core Version:    0.7.0.1
 */