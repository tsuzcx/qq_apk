import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class sbo
  extends sbh
{
  sbo(sbi paramsbi) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramBaseArticleInfo = sbi.a(this.a);
    if (paramBaseArticleInfo != null)
    {
      rab.b(sbi.a(this.a), paramBaseArticleInfo.innerUniqueID, 3);
      return;
    }
    QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbo
 * JD-Core Version:    0.7.0.1
 */