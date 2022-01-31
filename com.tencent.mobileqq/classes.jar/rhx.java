import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class rhx
  extends MqqHandler
{
  private rhx(rhf paramrhf) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(rhf.a(this.a), 2131720109, 0).a();
      return;
      String str = rhf.a(this.a).getString(2131720110);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(rhf.a(this.a), 2, str + paramMessage, 0).a();
      bdhj.a(rhf.a(this.a), paramMessage);
      return;
    } while ((rhf.a(this.a) == null) || (rhf.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(rhf.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bdgm.a(rhf.a(this.a), 232, rhf.a(this.a).getResources().getString(2131720142), rhf.a(this.a).getResources().getString(2131720141), 2131720124, 2131719209, new rhy(this, paramMessage), new rhz(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhx
 * JD-Core Version:    0.7.0.1
 */