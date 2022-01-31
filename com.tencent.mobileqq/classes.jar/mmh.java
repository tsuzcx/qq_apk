import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mmh
  implements Runnable
{
  public mmh(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmh
 * JD-Core Version:    0.7.0.1
 */