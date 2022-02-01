import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class snq
  extends MqqHandler
{
  private snq(smg paramsmg) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(smg.a(this.a), 2131718832, 0).a();
      return;
      String str = smg.a(this.a).getString(2131718833);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(smg.a(this.a), 2, str + paramMessage, 0).a();
      bheg.a(smg.a(this.a), paramMessage);
      return;
    } while ((smg.a(this.a) == null) || (smg.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.getShortVideoSavePath(smg.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bhdj.a(smg.a(this.a), 232, smg.a(this.a).getResources().getString(2131718864), smg.a(this.a).getResources().getString(2131718863), 2131718847, 2131718048, new snr(this, paramMessage), new sns(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snq
 * JD-Core Version:    0.7.0.1
 */