import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnDownloadListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.ArrayList;

public class nir
  implements IVideoView.OnDownloadListener
{
  public nir(VideoPlayModeBase paramVideoPlayModeBase, String paramString, StoryVideoItem paramStoryVideoItem, DownloadUrlManager paramDownloadUrlManager, int paramInt) {}
  
  public void a(String paramString, File paramFile, int paramInt)
  {
    SLog.a("Q.qqstory.player.YPlayModeUtils", "setOnDownloadListener onProgress=%d, url=%s", Integer.valueOf(paramInt), paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "setOnDownloadListener onError=%d, vid=%s, url=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(109), "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.post(new nit(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "setOnDownloadListener onSuccess vid=%s, url=%s", new Object[] { paramString1, paramString2 });
    paramString2 = FileCacheUtils.a(new File(this.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(paramString2))
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label168;
      }
      ThreadManager.post(new nis(this, paramString2), 8, null, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.b(paramString1, 0);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.a(paramString1, 0);
      paramString1 = new String[2];
      int j = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size();
      int i = 0;
      while (i < 2)
      {
        if (this.jdField_a_of_type_Int + i + 1 < j) {
          paramString1[i] = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_Int + i + 1)).mVid;
        }
        i += 1;
      }
      label168:
      FileCacheUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramString2, 0, StoryReportor.a(BaseApplicationImpl.getContext()));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nir
 * JD-Core Version:    0.7.0.1
 */