import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class rtv
  extends sbh
{
  rtv(rsx paramrsx) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g)))
    {
      sas.a(rsx.a(this.a), rll.a(paramVideoInfo), rsx.a(this.a).a(paramVideoInfo.g), 2, 0);
      sas.a(paramVideoInfo.g, 2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtv
 * JD-Core Version:    0.7.0.1
 */