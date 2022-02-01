import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URL;
import java.util.HashSet;

class skj
  extends skd
{
  skj(ske paramske) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!bgnt.g(ske.a(this.a)))
    {
      QQToast.a(ske.a(this.a), 0, anni.a(2131715038), 0).a();
      return;
    }
    ryx.a(ske.a(this.a), ske.a(this.a));
    String str1 = paramString + "&sourcefrom=6";
    paramString = ryx.a(paramBaseArticleInfo);
    paramActionSheetItem = ryx.a(paramBaseArticleInfo);
    Bundle localBundle = new Bundle();
    localBundle.putInt("videoDuration", paramBaseArticleInfo.getVideoDuration());
    localBundle.putLong("publishAccountUin", paramActionSheetItem.longValue());
    localBundle.putString("publishAccountName", paramString);
    localBundle.putLong("feedsId", paramBaseArticleInfo.mFeedId);
    localBundle.putInt("feedsType", paramBaseArticleInfo.mFeedType);
    label182:
    pvl localpvl;
    Activity localActivity;
    String str2;
    String str3;
    String str4;
    if (paramBaseArticleInfo.busiType == 6)
    {
      paramInt = 1;
      localBundle.putInt("videoType", paramInt);
      paramString = ske.a(this.a);
      if (paramString == null) {
        break label267;
      }
      paramString = paramString.c();
      localpvl = pvl.a();
      localActivity = ske.a(this.a);
      str2 = paramBaseArticleInfo.getInnerUniqueID();
      str3 = paramBaseArticleInfo.mTitle;
      str4 = paramBaseArticleInfo.mSummary;
      if (paramBaseArticleInfo.getVideoCoverURL() != null) {
        break label273;
      }
    }
    label267:
    label273:
    for (paramActionSheetItem = "";; paramActionSheetItem = paramBaseArticleInfo.getVideoCoverURL().getPath())
    {
      localpvl.a(localActivity, paramString, 2, str2, str3, str4, paramActionSheetItem, str1, localBundle);
      ske.a(this.a).add(paramBaseArticleInfo.getInnerUniqueID());
      return;
      paramInt = 2;
      break;
      paramString = "";
      break label182;
    }
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skj
 * JD-Core Version:    0.7.0.1
 */