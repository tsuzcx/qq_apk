import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class sbk
  extends MqqHandler
{
  private sbk(sab paramsab) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(sab.a(this.a), 2131718446, 0).a();
      return;
      String str = sab.a(this.a).getString(2131718447);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(sab.a(this.a), 2, str + paramMessage, 0).a();
      bfvo.a(sab.a(this.a), paramMessage);
      return;
    } while ((sab.a(this.a) == null) || (sab.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.getShortVideoSavePath(sab.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bfur.a(sab.a(this.a), 232, sab.a(this.a).getResources().getString(2131718478), sab.a(this.a).getResources().getString(2131718477), 2131718461, 2131717677, new sbl(this, paramMessage), new sbm(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbk
 * JD-Core Version:    0.7.0.1
 */