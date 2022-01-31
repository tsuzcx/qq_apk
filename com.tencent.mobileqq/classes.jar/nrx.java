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

public class nrx
  implements View.OnClickListener
{
  public nrx(CustomTabView paramCustomTabView, nru paramnru, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    nrk.a(null, "gouwu.tab.click", this.jdField_a_of_type_Nru.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    if (this.jdField_a_of_type_AndroidWidgetImageView.getTag() == null) {}
    for (int i = 0;; i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue())
    {
      paramView = Integer.valueOf(i);
      if (paramView.intValue() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        nrk.a(this.jdField_a_of_type_Nru.a, paramView.intValue());
      }
      if (this.jdField_a_of_type_Nru.a != this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a = this.jdField_a_of_type_Nru.a;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_Nru.f));
    if ((CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView) != null) && (!bbjw.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView)))) {
      CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView).setTextColor(Color.parseColor(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView)));
    }
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_AndroidWidgetTextView);
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Nru.e);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzo.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzo.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
    paramView = URLDrawable.getDrawable(this.jdField_a_of_type_Nru.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramView != null) {
      this.b.setImageDrawable(paramView);
    }
    if ((CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView) != null) && (!bbjw.a(CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView))))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzo.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzo.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), 28.0F);
      localObject = URLDrawable.getDrawable(CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), localURLDrawableOptions);
      if (paramView != null) {
        CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView).setImageDrawable((Drawable)localObject);
      }
    }
    CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.b);
    CustomTabView.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_Nru.c);
    if (bbjw.a(this.jdField_a_of_type_Nru.b))
    {
      nrk.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), "3046055438", "QQ购物");
      return;
    }
    nrk.a(CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a, this.jdField_a_of_type_Nru.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrx
 * JD-Core Version:    0.7.0.1
 */