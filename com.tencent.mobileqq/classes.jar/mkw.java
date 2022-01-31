import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class mkw
  implements Runnable
{
  public mkw(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkw
 * JD-Core Version:    0.7.0.1
 */