import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.widget.AbsListView;

public class ssi
  implements IScrollReader
{
  public ssi(FastWebActivity paramFastWebActivity) {}
  
  public int readScroll(View paramView)
  {
    if ((paramView instanceof AbsListView)) {
      return ((AbsListView)paramView).getLastVisiblePosition();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssi
 * JD-Core Version:    0.7.0.1
 */