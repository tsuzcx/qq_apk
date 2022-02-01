import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class rtl
  extends sbh
{
  rtl(rsx paramrsx) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null)
    {
      rab.b(rsx.a(this.a), paramVideoInfo.g, 1);
      return;
    }
    QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtl
 * JD-Core Version:    0.7.0.1
 */