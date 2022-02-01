import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class oqz
  implements View.OnClickListener
{
  oqz(oqy paramoqy) {}
  
  public void onClick(View paramView)
  {
    if (pli.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("currentIndex", oqy.a(this.a).getCurrentItem());
      PublicTransFragmentActivity.b(oqy.a(this.a), localIntent, ReadInJoyChannelPanelFragment.class);
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009497", new pqg().b().c(this.a.a()).a());
        oqy.a(this.a, false);
        oqy.a(this.a).setVisibility(8);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoyChannelViewPagerController", 1, QLog.getStackTraceString(localJSONException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqz
 * JD-Core Version:    0.7.0.1
 */