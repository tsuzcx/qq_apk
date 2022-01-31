import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController;
import java.util.List;

public class mot
  extends ReadInJoyObserver
{
  public mot(ReadInJoyFeedsHeaderViewController paramReadInJoyFeedsHeaderViewController) {}
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramBoolean) {
      ReadInJoyFeedsHeaderViewController.a(this.a, ReadInJoyFeedsHeaderViewController.a(this.a, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */