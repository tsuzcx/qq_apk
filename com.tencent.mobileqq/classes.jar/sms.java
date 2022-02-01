import android.content.res.Resources;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class sms
  extends suv
{
  sms(smg paramsmg) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (smg.a(this.a) != null)
    {
      if (smg.a(this.a).b())
      {
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ：add colorNote");
        smg.a(this.a).e();
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690871), 5000).a();
      }
    }
    else {
      return;
    }
    smg.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */