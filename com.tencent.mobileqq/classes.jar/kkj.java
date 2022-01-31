import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;

public class kkj
  implements ViewPager.OnPageChangeListener
{
  public kkj(TroopCardBanner paramTroopCardBanner) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 1))
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837575);
      }
      paramInt %= this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size();
      ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).setImageResource(2130837574);
      this.a.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkj
 * JD-Core Version:    0.7.0.1
 */