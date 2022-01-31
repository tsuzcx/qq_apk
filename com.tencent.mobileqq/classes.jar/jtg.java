import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.BeautyToolbar.DataReport;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;

public class jtg
  implements QavInOutAnimation.QavOutAnimationListener
{
  public jtg(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, String paramString) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.l = true;
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.ah();
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    if (localEffectOperateManager != null) {
      localEffectOperateManager.a(false);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.aj();
  }
  
  public void b()
  {
    TraeHelper.a().a("DoubleVideoCtrlUI.onOutAnimationEnd");
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().b = false;
    if ((!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().Q) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.ad();
    }
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().z != -1) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().o = true;
      DataReport.d(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController);
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.b) {
        DataReport.s(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) && (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().f)) {
        DataReport.e();
      }
      AVLog.c(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_c_of_type_JavaLangString, "DataReport onClose: ");
      EffectPendantTools.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectZimuManager.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectFilterTools.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      BeautyToolbar.DataReport.b(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      VoiceChangeDataReport.b(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a());
      String str = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) + "";
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.b(237);
      MagicDataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
      MagicDataReport.a(2, str);
      MagicDataReport.a(2);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().z);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.l = false;
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().z = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtg
 * JD-Core Version:    0.7.0.1
 */