import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.widget.AdapterView;
import java.util.List;

public class ovp
  implements bfpc
{
  public ovp(ReadInJoySelectPositionFragment paramReadInJoySelectPositionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      paramAdapterView = (pcp)ReadInJoySelectPositionFragment.a(this.a).get(paramInt - 1);
    } while (paramAdapterView.a != 2);
    this.a.a(new SelectPositionModule.PositionData(paramAdapterView.d, paramAdapterView.c, paramAdapterView.b, paramAdapterView.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovp
 * JD-Core Version:    0.7.0.1
 */