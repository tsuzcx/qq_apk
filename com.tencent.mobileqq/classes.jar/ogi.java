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

class ogi
  implements View.OnClickListener
{
  ogi(ogh paramogh) {}
  
  public void onClick(View paramView)
  {
    if (pih.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("currentIndex", ogh.a(this.a).getCurrentItem());
      PublicTransFragmentActivity.b(ogh.a(this.a), localIntent, ReadInJoyChannelPanelFragment.class);
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009497", new phi().b().c(this.a.a()).a());
        ogh.a(this.a, false);
        ogh.a(this.a).setVisibility(8);
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
 * Qualified Name:     ogi
 * JD-Core Version:    0.7.0.1
 */