import android.view.View;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class qaj
  implements ActionSheet.OnButtonClickListener
{
  public qaj(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    boolean bool;
    label64:
    do
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      bool = NetworkUtil.g(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.getApplication().getApplicationContext());
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      if (!bool) {
        break;
      }
      paramInt = 2002;
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a().a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
    } while (!bool);
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath)) {
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (!FileUtils.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileName))
      {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label235;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.a.setFailedIconVisable(false, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder);
        DevLittleVideoItemBuilder.b(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
        break;
        paramInt = 2005;
        break label64;
      }
      label235:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qaj
 * JD-Core Version:    0.7.0.1
 */