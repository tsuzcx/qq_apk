import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class nxl
  implements TopGestureLayout.OnGestureListener
{
  public nxl(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void flingLToR()
  {
    ReadInJoyVideoSubChannelActivity.a(this.a, true);
    this.a.finish();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxl
 * JD-Core Version:    0.7.0.1
 */