import android.view.View;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class pzb
  implements ActionSheet.OnButtonClickListener
{
  public pzb(DevicePttItemBuilder paramDevicePttItemBuilder, PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.b();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pzb
 * JD-Core Version:    0.7.0.1
 */