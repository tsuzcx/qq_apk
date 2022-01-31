import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mlb
  implements Runnable
{
  public mlb(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlb
 * JD-Core Version:    0.7.0.1
 */