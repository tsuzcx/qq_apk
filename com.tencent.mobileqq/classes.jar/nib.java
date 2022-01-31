import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class nib
  implements View.OnClickListener
{
  nib(nia paramnia) {}
  
  public void onClick(View paramView)
  {
    if (odi.a())
    {
      nia.a(this.a).a();
      return;
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nia.a(this.a).getCurrentItem());
    PublicTransFragmentActivity.b(nia.a(this.a), paramView, ReadInJoyChannelPanelFragment.class);
    try
    {
      ReadInJoyChannelPanelFragment.a("0X8009497", new ocg().b().c(this.a.a()).a());
      nia.a(this.a, false);
      nia.a(this.a).setVisibility(8);
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
 * Qualified Name:     nib
 * JD-Core Version:    0.7.0.1
 */