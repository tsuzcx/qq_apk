import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;

public class obn
  implements AdapterView.OnItemClickListener
{
  obn(obm paramobm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    obm.a(this.a, paramInt);
    obm.a(this.a).notifyDataSetChanged();
    obm.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obn
 * JD-Core Version:    0.7.0.1
 */