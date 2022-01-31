import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;

public class nqc
  implements AdapterView.OnItemClickListener
{
  nqc(nqb paramnqb) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    nqb.a(this.a, paramInt);
    nqb.a(this.a).notifyDataSetChanged();
    nqb.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */