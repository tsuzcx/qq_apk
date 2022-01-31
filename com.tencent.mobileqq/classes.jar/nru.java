import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class nru
  implements View.OnClickListener
{
  public nru(CustomTabView paramCustomTabView, nrr paramnrr, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    nrh.a(null, "gouwu.tab.click", this.jdField_a_of_type_Nrr.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    if (this.jdField_a_of_type_AndroidWidgetImageView.getTag() == null) {}
    for (int i = 0;; i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue())
    {
      paramView = Integer.valueOf(i);
      if (paramView.intValue() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        nrh.a(this.jdField_a_of_type_Nrr.a, paramView.intValue());
      }
      if (this.jdField_a_of_type_Nrr.a != this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a = this.jdField_a_of_type_Nrr.a;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_Nrr.f));
    if ((CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView) != null) && (!bbkk.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView)))) {
      CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView).setTextColor(Color.parseColor(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView)));
    }
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_AndroidWidgetTextView);
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Nrr.e);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzl.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzl.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
    paramView = URLDrawable.getDrawable(this.jdField_a_of_type_Nrr.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramView != null) {
      this.b.setImageDrawable(paramView);
    }
    if ((CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView) != null) && (!bbkk.a(CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView))))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzl.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzl.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
      localObject = URLDrawable.getDrawable(CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), localURLDrawableOptions);
      if (paramView != null) {
        CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView).setImageDrawable((Drawable)localObject);
      }
    }
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.b);
    CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Nrr.c);
    if (bbkk.a(this.jdField_a_of_type_Nrr.b))
    {
      nrh.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), "3046055438", "QQ购物");
      return;
    }
    nrh.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a, this.jdField_a_of_type_Nrr.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nru
 * JD-Core Version:    0.7.0.1
 */