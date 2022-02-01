import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class svc
  extends suv
{
  svc(suw paramsuw) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramBaseArticleInfo = suw.a(this.a);
    if (paramBaseArticleInfo != null)
    {
      rth.b(suw.a(this.a), paramBaseArticleInfo.innerUniqueID, 3);
      return;
    }
    QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svc
 * JD-Core Version:    0.7.0.1
 */