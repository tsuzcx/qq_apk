import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.DisplayUtils;

public class owb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public owb(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.c.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - DisplayUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.b.setMaxWidth(i);
    this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owb
 * JD-Core Version:    0.7.0.1
 */