import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.utils.UIUtils;

public class obo
  implements Runnable
{
  public obo(NewMyStorySegment paramNewMyStorySegment, TextView paramTextView, View paramView, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment, NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment), this.jdField_a_of_type_AndroidViewView.getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - UIUtils.a(NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment), 70.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaint()));
    if (NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).f > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(NewMyStorySegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).getResources().getColor(2131494277));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obo
 * JD-Core Version:    0.7.0.1
 */