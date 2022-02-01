import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class sim
  extends sif
{
  sim(sig paramsig) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramBaseArticleInfo = sig.a(this.a);
    if (paramBaseArticleInfo != null)
    {
      rha.b(sig.a(this.a), paramBaseArticleInfo.innerUniqueID, 3);
      return;
    }
    QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sim
 * JD-Core Version:    0.7.0.1
 */