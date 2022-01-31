import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public final class lku
  implements ActionSheet.OnButtonClickListener
{
  public lku(Context paramContext, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (Boolean.valueOf(ReadInJoyCameraCaptureHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_AndroidContentContext)).booleanValue())
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoyCameraCaptureActivity.class);
        paramView.putExtra("OPEN_ACTIVITY_KEY_VID", "");
        paramView.putExtra("OPEN_ACTIVITY_KEY_MODE", 2);
        paramView.putExtra("is_from_dian_dian", true);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(ReadInJoyUtils.a().getAccount(), "actReadInJoyASClickCapture", true, 0L, 0L, null, "");
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131438870, 0).a();
        continue;
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PhotoListActivity.class);
        paramView.putExtra("is_from_dian_dian", true);
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000));
        paramView.putExtra("readinjoy_video", true);
        paramView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "ReadInjoyNewFeedsActivity");
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(ReadInJoyUtils.a().getAccount(), "actReadInJoyASClickUpload", true, 0L, 0L, null, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lku
 * JD-Core Version:    0.7.0.1
 */