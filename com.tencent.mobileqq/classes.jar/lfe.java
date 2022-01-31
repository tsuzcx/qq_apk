import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;

public class lfe
  implements Runnable
{
  public lfe(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    if (ReadInJoyVideoSubChannelActivity.a(this.a) != null) {
      ReadInJoyVideoSubChannelActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */