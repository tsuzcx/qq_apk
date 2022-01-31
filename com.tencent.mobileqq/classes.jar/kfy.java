import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.ResultData;
import com.tencent.av.ui.redbag.ResultUI;
import com.tencent.qphone.base.util.QLog;

public class kfy
  implements Runnable
{
  public kfy(ResultUI paramResultUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      QLog.w(this.a.i, 1, "innerShow 已经显示了");
      return;
    }
    this.a.b();
    AVActivity localAVActivity = this.a.a();
    if (localAVActivity == null)
    {
      QLog.w(this.a.i, 1, "innerShow avActivity为空");
      return;
    }
    if (!localAVActivity.d())
    {
      QLog.w(this.a.i, 1, "innerShow avActivity不在top, avActivity[" + localAVActivity + "]");
      return;
    }
    QLog.w(this.a.i, 1, "innerShow, avActivity[" + localAVActivity + "]");
    this.a.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b())
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b)
      {
        this.a.b(localAVActivity);
        return;
      }
      this.a.c(localAVActivity);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.a())
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b)
      {
        this.a.b(localAVActivity);
        return;
      }
      this.a.a(localAVActivity);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.f == 3)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b) {
        localAVActivity.a("网络异常，无法开始游戏，红包金额将在24小时后退回。", 3000, null);
      }
      for (;;)
      {
        this.a.a("EXCEPTION_BEFORE_GAME");
        return;
        localAVActivity.a("网络异常，无法开始游戏。", 3000, null);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.f == 4)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b)
      {
        this.a.b(localAVActivity);
        return;
      }
      this.a.c(localAVActivity);
      this.a.a(localAVActivity, this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.f == 6)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b) {
        localAVActivity.a("网络异常，无法开始游戏，24小时后退回金额。", 5000, null);
      }
      this.a.a("EXCEPTION_NOT_RECEIVE_REDBAG");
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.f == 7)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.b) {
        localAVActivity.a("网络异常，请到消息窗口点击红包查看领取详情。", 5000, null);
      }
      this.a.a("EXCEPTION_GAME_TIMEOUT");
      return;
    }
    QLog.w(this.a.i, 1, "innerShow, 不展示, mHitScore[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.a + "], mExceptionType[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagResultData.f + "]");
    this.a.a("other");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfy
 * JD-Core Version:    0.7.0.1
 */