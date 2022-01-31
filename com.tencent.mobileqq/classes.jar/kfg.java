import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CEffectEntrancePreClickInfo;
import com.tencent.av.ui.ControlUIObserver.CPreChangButtonStyleInfo;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.GameSink;
import com.tencent.av.ui.redbag.OtherBtnController;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.ResultData;

public class kfg
  extends ControlUIObserver
{
  String jdField_a_of_type_JavaLangString = "AVRedbag_GameMode";
  
  public kfg(OtherBtnController paramOtherBtnController) {}
  
  protected void a(ControlUIObserver.CEffectEntrancePreClickInfo paramCEffectEntrancePreClickInfo)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localAVActivity == null) {
      return;
    }
    if (paramCEffectEntrancePreClickInfo.jdField_a_of_type_Int == 1) {
      localAVActivity.a("正在表情游戏中，不能关闭使用变声。", 3000, null);
    }
    for (;;)
    {
      paramCEffectEntrancePreClickInfo.b = true;
      paramCEffectEntrancePreClickInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      return;
      if (paramCEffectEntrancePreClickInfo.jdField_a_of_type_Int == 2) {
        localAVActivity.a("正在表情游戏中，不能使用其他特效互动。", 3000, null);
      }
    }
  }
  
  protected void a(ControlUIObserver.CPreChangButtonStyleInfo paramCPreChangButtonStyleInfo)
  {
    AVRedBagMgr localAVRedBagMgr = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localAVRedBagMgr == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!localAVRedBagMgr.a());
      i = paramCPreChangButtonStyleInfo.a().getId();
    } while ((i != 2131365403) && (i != 2131365391));
    if (i == 2131365403) {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_Int = paramCPreChangButtonStyleInfo.jdField_a_of_type_Int;
    }
    paramCPreChangButtonStyleInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramCPreChangButtonStyleInfo.jdField_a_of_type_Boolean = false;
  }
  
  protected void c(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localAVActivity == null) {
      return;
    }
    localAVActivity.a("正在表情游戏中，不能邀请成员抢红包。", 3000, null);
    paramCPreEventInfo.b = true;
    paramCPreEventInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  protected void d(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((((AVRedBagMgr)localObject).a == null) || (((AVRedBagMgr)localObject).a.a == null) || (((AVRedBagMgr)localObject).a.a.b) || (!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().f));
      localObject = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    } while (localObject == null);
    ((AVActivity)localObject).a("正在表情游戏中，不能关闭摄像头。", 3000, null);
    paramCPreEventInfo.b = true;
    paramCPreEventInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  protected void e(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    paramCPreEventInfo = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if ((paramCPreEventInfo != null) && (paramCPreEventInfo.a())) {
      RedBagReport.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfg
 * JD-Core Version:    0.7.0.1
 */