import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class rug
  extends MqqHandler
{
  private rug(rsx paramrsx) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(rsx.a(this.a), 2131718205, 0).a();
      return;
      String str = rsx.a(this.a).getString(2131718206);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(rsx.a(this.a), 2, str + paramMessage, 0).a();
      bhmq.a(rsx.a(this.a), paramMessage);
      return;
    } while ((rsx.a(this.a) == null) || (rsx.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(rsx.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bhlq.a(rsx.a(this.a), 232, rsx.a(this.a).getResources().getString(2131718237), rsx.a(this.a).getResources().getString(2131718236), 2131718220, 2131717445, new ruh(this, paramMessage), new rui(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */