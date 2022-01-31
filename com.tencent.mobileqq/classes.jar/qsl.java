import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

class qsl
  extends MqqHandler
{
  private qsl(qrt paramqrt) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      bcql.a(qrt.a(this.a), 2131719565, 0).a();
      return;
      String str = qrt.a(this.a).getString(2131719566);
      paramMessage = (String)paramMessage.obj;
      bcql.a(qrt.a(this.a), 2, str + paramMessage, 0).a();
      bbef.a(qrt.a(this.a), paramMessage);
      return;
    } while ((qrt.a(this.a) == null) || (qrt.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(qrt.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bbdj.a(qrt.a(this.a), 232, qrt.a(this.a).getResources().getString(2131719598), qrt.a(this.a).getResources().getString(2131719597), 2131719580, 2131718724, new qsm(this, paramMessage), new qsn(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsl
 * JD-Core Version:    0.7.0.1
 */