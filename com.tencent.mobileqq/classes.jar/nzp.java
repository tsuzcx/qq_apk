import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep.ReceiveDataListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;

class nzp
  implements GetMyStoryDesFromVidListStep.ReceiveDataListener
{
  nzp(nzo paramnzo) {}
  
  public void a(MyStorys paramMyStorys)
  {
    NewMyStorySegment.a(this.a.a).sendMessage(NewMyStorySegment.a(this.a.a).obtainMessage(0, paramMyStorys));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzp
 * JD-Core Version:    0.7.0.1
 */