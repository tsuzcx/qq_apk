import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ohs
  implements View.OnClickListener
{
  public ohs(CustomTabView paramCustomTabView, ohi paramohi, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ohq.a(null, "gouwu.tab.click", this.jdField_a_of_type_Ohi.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        ohq.b(null, "gouwu_tab_click", this.jdField_a_of_type_Ohi.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        if (this.jdField_a_of_type_AndroidWidgetImageView.getTag() != null) {
          continue;
        }
        i = 0;
        Integer localInteger = Integer.valueOf(i);
        if (localInteger.intValue() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          oho.a(this.jdField_a_of_type_Ohi.a, localInteger.intValue());
        }
        i = this.jdField_a_of_type_Ohi.a;
        int j = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a;
        if (i != j) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localThrowable));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue();
      continue;
      CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Ohi, this.jdField_a_of_type_AndroidWidgetTextView, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohs
 * JD-Core Version:    0.7.0.1
 */