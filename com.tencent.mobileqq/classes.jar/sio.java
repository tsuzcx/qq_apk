import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class sio
  extends sif
{
  sio(sig paramsig) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramBaseArticleInfo.qzoneShareUrl != null) && (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
    {
      sig.a(this.a).a(paramBaseArticleInfo.qzoneShareUrl);
      return;
    }
    sig.a(this.a).a(paramString + "&sourcefrom=6");
  }
  
  public int c()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sio
 * JD-Core Version:    0.7.0.1
 */