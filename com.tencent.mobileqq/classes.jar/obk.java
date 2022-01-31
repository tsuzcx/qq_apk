import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;

public class obk
  implements AdapterView.OnItemClickListener
{
  obk(obj paramobj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    obj.a(this.a, paramInt);
    obj.a(this.a).notifyDataSetChanged();
    obj.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obk
 * JD-Core Version:    0.7.0.1
 */