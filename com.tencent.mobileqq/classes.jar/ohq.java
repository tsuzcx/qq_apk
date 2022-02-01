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

class ohq
  implements View.OnClickListener
{
  ohq(ohp paramohp) {}
  
  public void onClick(View paramView)
  {
    if (paz.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("currentIndex", ohp.a(this.a).getCurrentItem());
      PublicTransFragmentActivity.b(ohp.a(this.a), localIntent, ReadInJoyChannelPanelFragment.class);
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009497", new paa().b().c(this.a.a()).a());
        ohp.a(this.a, false);
        ohp.a(this.a).setVisibility(8);
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
 * Qualified Name:     ohq
 * JD-Core Version:    0.7.0.1
 */