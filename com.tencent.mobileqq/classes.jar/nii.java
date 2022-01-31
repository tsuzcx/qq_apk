import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class nii
  implements PlayingListPreloader.OnVideoDownloadListener
{
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public nii(VideoPlayModeBase paramVideoPlayModeBase) {}
  
  public void a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(i);
        if (!paramString.equals(localStoryVideoItem.mVid)) {
          break label93;
        }
        if (StoryVideoItem.isPlayable(localStoryVideoItem.mVid, true)) {
          break label72;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramString, localStoryVideoItem.getVideoUrl());
      }
      label72:
      while (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b != i) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(i);
      return;
      label93:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayModeBase", 2, "get video download finish,vid=" + paramString1);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.post(new nij(this, paramString1));
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoPlayModeBase", 2, "Download video failed,vid=" + paramString1);
    }
    if (this.jdField_a_of_type_JavaUtilSet.add(paramString1)) {
      if (paramInt != 1) {
        break label111;
      }
    }
    label111:
    for (paramInt = 107;; paramInt = 108)
    {
      StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(paramInt), "", paramString1 });
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.post(new nik(this, paramString1, paramString2));
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nii
 * JD-Core Version:    0.7.0.1
 */