import android.content.res.Resources;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class rtp
  extends sbh
{
  rtp(rsx paramrsx) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((rsx.a(this.a) != null) && (rsx.a(this.a).c()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690750), 5000).a();
      rsx.a(this.a).f();
      QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： delete colorNote");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtp
 * JD-Core Version:    0.7.0.1
 */