import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class nve
  implements View.OnClickListener
{
  public nve(CustomTabView paramCustomTabView, nvb paramnvb, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      nur.a(null, "gouwu.tab.click", this.jdField_a_of_type_Nvb.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
      if (this.jdField_a_of_type_AndroidWidgetImageView.getTag() == null) {}
      for (int i = 0;; i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue())
      {
        paramView = Integer.valueOf(i);
        if (paramView.intValue() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          nur.a(this.jdField_a_of_type_Nvb.a, paramView.intValue());
        }
        if (this.jdField_a_of_type_Nvb.a != this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a) {
          break;
        }
        return;
      }
      CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Nvb, this.jdField_a_of_type_AndroidWidgetTextView, this.b);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nve
 * JD-Core Version:    0.7.0.1
 */