import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class jsm
  implements ActionSheet.OnButtonClickListener
{
  public jsm(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, VideoActionSheet paramVideoActionSheet, String paramString, Context paramContext, Intent paramIntent) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().w == 1) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().w == 2))
      {
        paramView = new Intent();
        paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        paramView.setAction("tencent.av.v2q.ip2Pstn");
        paramView.putExtra("uinType", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().i);
        paramView.putExtra("toUin", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().c);
        paramView.putExtra("nickName", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().d);
        paramView.putExtra("peerPhone", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().g);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.b(234);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_JavaLangString, 0);
        TraeHelper.a().a("DoubleVideoCtrlUI.pstncall");
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
        return;
      }
      PstnUtils.a(null, this.jdField_a_of_type_AndroidContentContext, 1, 4);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      paramView = new Intent("tencent.video.v2q.insertSystemCall");
      paramView.putExtra("phoneNumber", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().g);
      paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.b(235);
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_JavaLangString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsm
 * JD-Core Version:    0.7.0.1
 */