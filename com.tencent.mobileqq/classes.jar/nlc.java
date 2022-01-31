import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.SelectVideosPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import java.util.ArrayList;

public class nlc
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public nlc(SelectVideosPlayMode paramSelectVideosPlayMode, BatchGetVideoInfo paramBatchGetVideoInfo, Bundle paramBundle) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nlf(this));
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_AndroidOsHandler.post(new nld(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlc
 * JD-Core Version:    0.7.0.1
 */