import android.content.res.Resources;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class san
  extends sif
{
  san(sab paramsab) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (sab.a(this.a) != null)
    {
      if (sab.a(this.a).b())
      {
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ：add colorNote");
        sab.a(this.a).e();
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690786), 5000).a();
      }
    }
    else {
      return;
    }
    sab.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     san
 * JD-Core Version:    0.7.0.1
 */