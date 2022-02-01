import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class oli
  implements TopGestureLayout.OnGestureListener
{
  public oli(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void flingLToR()
  {
    ReadInJoyChannelActivity.a(this.a, true);
    this.a.finish();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oli
 * JD-Core Version:    0.7.0.1
 */