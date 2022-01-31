import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class nwn
  implements View.OnClickListener
{
  nwn(nwm paramnwm) {}
  
  public void onClick(View paramView)
  {
    if (otb.a()) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nwm.a(this.a).getCurrentItem());
    PublicTransFragmentActivity.b(nwm.a(this.a), paramView, ReadInJoyChannelPanelFragment.class);
    try
    {
      ReadInJoyChannelPanelFragment.a("0X8009497", new orz().b().c(this.a.a()).a());
      nwm.a(this.a, false);
      nwm.a(this.a).setVisibility(8);
      return;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelViewPagerController", 1, QLog.getStackTraceString(paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwn
 * JD-Core Version:    0.7.0.1
 */