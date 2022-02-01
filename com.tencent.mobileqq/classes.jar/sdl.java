import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class sdl
  extends MqqHandler
{
  private sdl(sce paramsce) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(sce.a(this.a), 2131718072, 0).a();
      return;
      String str = sce.a(this.a).getString(2131718073);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(sce.a(this.a), 2, str + paramMessage, 0).a();
      bgmo.a(sce.a(this.a), paramMessage);
      return;
    } while ((sce.a(this.a) == null) || (sce.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.a(sce.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    bglp.a(sce.a(this.a), 232, sce.a(this.a).getResources().getString(2131718104), sce.a(this.a).getResources().getString(2131718103), 2131718087, 2131717317, new sdm(this, paramMessage), new sdn(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */