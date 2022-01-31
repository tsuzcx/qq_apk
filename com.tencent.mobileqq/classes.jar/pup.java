import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import com.tencent.widget.AdapterView;

public class pup
  implements behi
{
  public pup(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TagInfo)ReadInJoyVideoTagSelectionFragment.a(this.a).getItem(paramInt);
    ReadInJoyVideoTagSelectionFragment.a(this.a).b(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pup
 * JD-Core Version:    0.7.0.1
 */