import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class rtj
  extends ShortVideoObserver
{
  public rtj(BaseChatPie paramBaseChatPie) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (((this.a.a() instanceof SplashActivity)) && (SplashActivity.a != 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "VideoRedbag, onCheckRealNameRsp in aio");
      }
    } while ((!paramBoolean) || (paramInt != RedBagVideoManager.a));
    DialogUtil.b(this.a.a(), 0, null, this.a.a().getString(2131439124), 2131439126, 2131439125, new rtk(this), new rtl(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtj
 * JD-Core Version:    0.7.0.1
 */