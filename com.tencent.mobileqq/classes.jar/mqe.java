import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mqe
  implements Runnable
{
  public mqe(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqe
 * JD-Core Version:    0.7.0.1
 */