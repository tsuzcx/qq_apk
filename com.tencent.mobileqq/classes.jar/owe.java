import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.DisplayUtils;

public class owe
  implements URLDrawable.URLDrawableListener
{
  public owe(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, DisplayMetrics paramDisplayMetrics) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.c = false;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.c = false;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    float f1 = paramURLDrawable.getIntrinsicHeight();
    float f2 = paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = 0;
    if (f2 != 0.0F) {
      if (f1 <= DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F)) {
        break label109;
      }
    }
    label109:
    for (i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);; i = (int)((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F)) * (f1 / f2)))
    {
      if (i > 0)
      {
        paramURLDrawable.height = i;
        this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramURLDrawable);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owe
 * JD-Core Version:    0.7.0.1
 */