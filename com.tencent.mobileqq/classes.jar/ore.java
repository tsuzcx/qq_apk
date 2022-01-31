import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo2.StoryLocalPublishPart;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;

public class ore
  implements View.OnClickListener
{
  public ore(StoryLocalPublishPart paramStoryLocalPublishPart) {}
  
  public void onClick(View paramView)
  {
    SLog.d("story.publish.StoryLocalPublishPart", "onClick %s", new Object[] { paramView });
    switch (paramView.getId())
    {
    default: 
      return;
    }
    StoryReportor.a("video_edit", "clk_local", 0, 0, new String[0]);
    paramView = StoryPublishLauncher.a();
    if (paramView.a())
    {
      paramView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment, this.a.a(), this.a.jdField_a_of_type_Int);
      return;
    }
    throw new AndroidRuntimeException("StoryPublishLauncher is not support");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ore
 * JD-Core Version:    0.7.0.1
 */