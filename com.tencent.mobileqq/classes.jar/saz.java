import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class saz
  extends sif
{
  saz(sab paramsab) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g)))
    {
      shq.a(sab.a(this.a), rsl.a(paramVideoInfo), sab.a(this.a).a(paramVideoInfo.g), 2, 0);
      shq.a(paramVideoInfo.g, 2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saz
 * JD-Core Version:    0.7.0.1
 */