import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class scd
  extends sbh
{
  scd(sbi paramsbi) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramString = new Intent(sbi.a(this.a), ReadInJoyDeliverBiuActivity.class);
    if (paramBaseArticleInfo.busiType == 6) {
      paramString.putExtra("feedsType", sbi.a(this.a).mFeedType);
    }
    paramString.putExtra("ARG_VIDEO_ARTICLE_ID", sbi.a(this.a).mArticleID);
    paramString.putExtra("biu_src", 2);
    paramString.putExtra("arg_from_type", 8);
    paramString.putExtra("arg_article_info", (ArticleInfo)paramBaseArticleInfo);
    sbi.a(this.a).startActivityForResult(paramString, 102);
    sbi.a(this.a).overridePendingTransition(0, 0);
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scd
 * JD-Core Version:    0.7.0.1
 */