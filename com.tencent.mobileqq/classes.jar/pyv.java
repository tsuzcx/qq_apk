import android.view.View;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class pyv
  implements ActionSheet.OnButtonClickListener
{
  public pyv(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if ((NetworkUtil.d(BaseApplication.getContext())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setFailedIconVisable(false, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder);
        DevShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, 10), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pyv
 * JD-Core Version:    0.7.0.1
 */