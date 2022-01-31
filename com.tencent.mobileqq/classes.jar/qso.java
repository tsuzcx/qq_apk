import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

class qso
  extends MqqHandler
{
  private qso(qrw paramqrw) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      bcpw.a(qrw.a(this.a), 2131719554, 0).a();
      return;
      String str = qrw.a(this.a).getString(2131719555);
      paramMessage = (String)paramMessage.obj;
      bcpw.a(qrw.a(this.a), 2, str + paramMessage, 0).a();
      bbdr.a(qrw.a(this.a), paramMessage);
      return;
    } while ((qrw.a(this.a) == null) || (qrw.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(qrw.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bbcv.a(qrw.a(this.a), 232, qrw.a(this.a).getResources().getString(2131719587), qrw.a(this.a).getResources().getString(2131719586), 2131719569, 2131718713, new qsp(this, paramMessage), new qsq(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qso
 * JD-Core Version:    0.7.0.1
 */