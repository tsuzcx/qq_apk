import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class sap
  extends sif
{
  sap(sab paramsab) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null)
    {
      rha.b(sab.a(this.a), paramVideoInfo.g, 1);
      return;
    }
    QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sap
 * JD-Core Version:    0.7.0.1
 */