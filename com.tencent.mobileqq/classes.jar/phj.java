import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;

public class phj
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = j;
    if (b(paramBaseArticleInfo))
    {
      i = j;
      if (paramBaseArticleInfo.mSocialFeedInfo.a.b != null) {
        i = paramBaseArticleInfo.mSocialFeedInfo.a.b.intValue();
      }
    }
    return i;
  }
  
  public static void a(Context paramContext, View paramView, RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingBottom();
    if (pha.u()) {
      paramRoundAngleFrameLayout.setRadius(bggq.a(paramContext, 8.0F));
    }
    for (int i = bggq.a(paramContext, 14.0F);; i = bggq.a(paramContext, 6.0F))
    {
      paramView.setPadding(i, j, i, k);
      return;
      paramRoundAngleFrameLayout.setRadius(bggq.a(paramContext, 0.0F));
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 25) || ((paramBaseArticleInfo.mFeedType == 1) && (a(paramBaseArticleInfo) == 25));
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phj
 * JD-Core Version:    0.7.0.1
 */