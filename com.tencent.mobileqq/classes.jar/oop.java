import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class oop
  implements Handler.Callback
{
  public oop(SegmentList paramSegmentList) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return SegmentList.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oop
 * JD-Core Version:    0.7.0.1
 */