import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class rvt
  implements AdapterView.OnItemClickListener
{
  public rvt(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TagInfo)ReadInJoyVideoTagSelectionFragment.a(this.a).getItem(paramInt);
    ReadInJoyVideoTagSelectionFragment.a(this.a).b(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvt
 * JD-Core Version:    0.7.0.1
 */