import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class rvu
  implements AdapterView.OnItemClickListener
{
  public rvu(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof TagInfo)))
    {
      if (ReadInJoyVideoTagSelectionFragment.a(this.a).a()) {
        break label72;
      }
      if ((!ReadInJoyVideoTagSelectionFragment.a(this.a).a((TagInfo)paramAdapterView)) && (!ReadInJoyVideoTagSelectionFragment.a(this.a).c())) {
        ReadInJoyVideoTagSelectionFragment.a(this.a).a();
      }
    }
    label72:
    while (ReadInJoyVideoTagSelectionFragment.b(this.a).c()) {
      return;
    }
    ReadInJoyVideoTagSelectionFragment.b(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvu
 * JD-Core Version:    0.7.0.1
 */