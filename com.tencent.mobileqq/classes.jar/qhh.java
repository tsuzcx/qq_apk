import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;

public class qhh
  implements AdapterView.OnItemClickListener
{
  public qhh(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a.remove(paramInt);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhh
 * JD-Core Version:    0.7.0.1
 */