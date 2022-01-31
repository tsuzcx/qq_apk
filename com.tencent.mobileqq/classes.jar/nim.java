import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playmode.child.MyMemoryPlayMode;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class nim
  implements View.OnClickListener
{
  public nim(MyMemoryPlayMode paramMyMemoryPlayMode) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nim
 * JD-Core Version:    0.7.0.1
 */