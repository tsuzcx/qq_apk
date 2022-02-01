import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class smu
  extends suv
{
  smu(smg paramsmg) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null)
    {
      rth.b(smg.a(this.a), paramVideoInfo.g, 1);
      return;
    }
    QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */