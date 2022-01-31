import com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class nlj
  implements Runnable
{
  nlj(nlg paramnlg) {}
  
  public void run()
  {
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.a.a.a.jdField_a_of_type_Int = 1;
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nlk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlj
 * JD-Core Version:    0.7.0.1
 */