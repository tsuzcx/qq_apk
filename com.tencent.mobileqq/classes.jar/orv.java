import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class orv
  implements AdapterView.OnItemClickListener
{
  orv(oru paramoru) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    oru.a(this.a, paramInt);
    oru.a(this.a).notifyDataSetChanged();
    oru.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orv
 * JD-Core Version:    0.7.0.1
 */