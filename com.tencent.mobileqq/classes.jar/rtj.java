import android.content.res.Resources;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class rtj
  extends sbh
{
  rtj(rsx paramrsx) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (rsx.a(this.a) != null)
    {
      if (rsx.a(this.a).b())
      {
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ：add colorNote");
        rsx.a(this.a).e();
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690746), 5000).a();
      }
    }
    else {
      return;
    }
    rsx.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtj
 * JD-Core Version:    0.7.0.1
 */