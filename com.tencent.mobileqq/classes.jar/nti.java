import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class nti
  implements View.OnClickListener
{
  nti(nth paramnth) {}
  
  public void onClick(View paramView)
  {
    if (ooq.a())
    {
      nth.a(this.a).a();
      return;
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nth.a(this.a).getCurrentItem());
    PublicTransFragmentActivity.b(nth.a(this.a), paramView, ReadInJoyChannelPanelFragment.class);
    try
    {
      ReadInJoyChannelPanelFragment.a("0X8009497", new ono().b().c(this.a.a()).a());
      nth.a(this.a, false);
      nth.a(this.a).setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nti
 * JD-Core Version:    0.7.0.1
 */