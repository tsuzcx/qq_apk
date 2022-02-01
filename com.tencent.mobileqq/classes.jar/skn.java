import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class skn
  extends skd
{
  skn(ske paramske) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    ske.a(this.a, false);
    paramActionSheetItem = paramString + "&sourcefrom=6";
    paramString = paramActionSheetItem;
    if (paramBaseArticleInfo.qzoneShareUrl != null)
    {
      paramString = paramActionSheetItem;
      if (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        paramString = paramBaseArticleInfo.qzoneShareUrl;
      }
    }
    paramBaseArticleInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramBaseArticleInfo.putExtra("big_brother_source_key", pha.f(0));
    paramBaseArticleInfo.putExtra("normal", true);
    try
    {
      ske.a(this.a).startActivity(paramBaseArticleInfo);
      return;
    }
    catch (ActivityNotFoundException paramBaseArticleInfo)
    {
      zvc.a(1, 2131694621);
    }
  }
  
  public int c()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skn
 * JD-Core Version:    0.7.0.1
 */