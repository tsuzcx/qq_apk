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

public class njs
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public njs(SelectVideosPlayMode paramSelectVideosPlayMode, BatchGetVideoInfo paramBatchGetVideoInfo, Bundle paramBundle) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new njv(this));
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildSelectVideosPlayMode.jdField_a_of_type_AndroidOsHandler.post(new njt(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njs
 * JD-Core Version:    0.7.0.1
 */