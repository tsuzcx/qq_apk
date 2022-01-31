import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class sfj
  extends ShortVideoObserver
{
  public sfj(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.a.h) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "VideoRedbag, onCheckRealNameRsp in conv");
      }
    } while ((!paramBoolean) || (paramInt != RedBagVideoManager.a));
    DialogUtil.b(this.a.a(), 0, null, this.a.a(2131439096), 2131439098, 2131439097, new sfk(this), new sfl(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */