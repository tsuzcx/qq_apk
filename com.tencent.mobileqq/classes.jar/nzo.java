import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.utils.UncheckedCallable;

public class nzo
  implements UncheckedCallable
{
  public nzo(NewMyStorySegment paramNewMyStorySegment) {}
  
  public GetMyStoryDesFromVidListStep a()
  {
    return new GetMyStoryDesFromVidListStep(new nzp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzo
 * JD-Core Version:    0.7.0.1
 */