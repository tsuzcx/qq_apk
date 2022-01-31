import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;

public class ofc
  implements AdapterView.OnItemClickListener
{
  ofc(ofb paramofb) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ofb.a(this.a, paramInt);
    ofb.a(this.a).notifyDataSetChanged();
    ofb.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofc
 * JD-Core Version:    0.7.0.1
 */