import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.LayoutModifier.FactoryMerger;
import com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureFragment;
import com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureView;

public class oqw
  extends LayoutModifier.FactoryMerger
{
  public oqw(StoryEffectsCameraCaptureFragment paramStoryEffectsCameraCaptureFragment, LayoutInflater paramLayoutInflater)
  {
    super(paramLayoutInflater);
  }
  
  protected View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842960 });
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (i == 2131366943)
    {
      SLog.a("story.publish.CaptureFragment", "create view for R.id.camera_capture_view : StoryEffectsCameraCaptureView, name=%s", paramString);
      return new StoryEffectsCameraCaptureView(paramContext, paramAttributeSet);
    }
    return super.a(paramView, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqw
 * JD-Core Version:    0.7.0.1
 */