import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyMsgManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.concurrent.atomic.AtomicInteger;

public class lfr
  extends PublicAccountObserver
{
  public lfr(ReadinjoyMsgManagerActivity paramReadinjoyMsgManagerActivity) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (ReadinjoyMsgManagerActivity.a(this.a).isShowing()) {
      ReadinjoyMsgManagerActivity.a(this.a).dismiss();
    }
    if (paramInt != ReadinjoyMsgManagerActivity.a(this.a).get()) {
      return;
    }
    if (paramBoolean)
    {
      boolean bool = ReadinjoyMsgManagerActivity.a(this.a).isChecked();
      ReadinjoyMsgManagerActivity localReadinjoyMsgManagerActivity = this.a;
      if (!bool)
      {
        paramBoolean = true;
        ReadinjoyMsgManagerActivity.a(localReadinjoyMsgManagerActivity, paramBoolean);
        if (bool) {
          break label127;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB6", "0X8007DB6", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      }
      for (;;)
      {
        ((KandianMergeManager)this.a.app.getManager(161)).a(bool);
        return;
        paramBoolean = false;
        break;
        label127:
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      }
    }
    QQToast.a(this.a.getApplicationContext(), 2131428474, 0).a();
    QLog.d("ReadinjoyMsgManagerActivity", 1, "handle setkandian recomm failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */