import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

public class ofq
  extends ChildViewClickListener
{
  public ofq(NewMyStorySegment paramNewMyStorySegment, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView == paramBaseViewHolder.a()) {
      NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment, paramInt, (StoryVideoItem)NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramBaseViewHolder.a(2131372026))
      {
        paramView = (StoryCoverView)paramBaseViewHolder.a(2131372019);
        if (this.jdField_a_of_type_Boolean)
        {
          NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment, paramInt, (StoryVideoItem)NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).a().get(paramInt), paramView);
          return;
        }
        NewMyStorySegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment, paramInt, (StoryVideoItem)NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramBaseViewHolder.a(2131372030)) || (paramView == paramBaseViewHolder.a(2131372021)))
      {
        NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment, paramInt, (StoryVideoItem)NewMyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment).a().get(paramInt));
        return;
      }
    } while (paramView != paramBaseViewHolder.a(2131372031));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment.a(paramBaseViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofq
 * JD-Core Version:    0.7.0.1
 */