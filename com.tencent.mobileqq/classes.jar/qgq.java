import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

class qgq
  extends MqqHandler
{
  private qgq(qfy paramqfy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      bbmy.a(qfy.a(this.a), 2131653670, 0).a();
      return;
      String str = qfy.a(this.a).getString(2131653671);
      paramMessage = (String)paramMessage.obj;
      bbmy.a(qfy.a(this.a), 2, str + paramMessage, 0).a();
      bacm.a(qfy.a(this.a), paramMessage);
      return;
    } while ((qfy.a(this.a) == null) || (qfy.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(qfy.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    babr.a(qfy.a(this.a), 232, qfy.a(this.a).getResources().getString(2131653703), qfy.a(this.a).getResources().getString(2131653702), 2131653685, 2131652888, new qgr(this, paramMessage), new qgs(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgq
 * JD-Core Version:    0.7.0.1
 */