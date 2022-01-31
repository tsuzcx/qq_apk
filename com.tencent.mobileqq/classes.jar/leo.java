import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;

public class leo
  implements PublicAccountGifListener
{
  public leo(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(HotPicData paramHotPicData)
  {
    if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
      ((ReadInJoyDeliverUGCActivity)this.a).a(paramHotPicData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leo
 * JD-Core Version:    0.7.0.1
 */