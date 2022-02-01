import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.net.URL;
import java.util.ArrayList;

class scc
  extends sbh
{
  scc(sbi paramsbi) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    sbi.a(this.a, false);
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putString("title", paramBaseArticleInfo.mTitle);
    paramActionSheetItem.putString("desc", paramBaseArticleInfo.mSummary);
    if ((paramBaseArticleInfo.qzoneShareUrl != null) && (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
    {
      paramActionSheetItem.putString("detail_url", paramBaseArticleInfo.qzoneShareUrl);
      paramString = new ArrayList(1);
      if (paramBaseArticleInfo.getVideoCoverURL() != null) {
        break label164;
      }
    }
    label164:
    for (paramBaseArticleInfo = null;; paramBaseArticleInfo = paramBaseArticleInfo.getVideoCoverURL().getFile())
    {
      paramString.add(paramBaseArticleInfo);
      paramActionSheetItem.putStringArrayList("image_url", paramString);
      paramActionSheetItem.putLong("req_share_id", 0L);
      bmud.a(sbi.a(this.a), sbi.a(this.a), paramActionSheetItem, null, 19202);
      return;
      paramActionSheetItem.putString("detail_url", paramString + "&sourcefrom=1");
      break;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scc
 * JD-Core Version:    0.7.0.1
 */