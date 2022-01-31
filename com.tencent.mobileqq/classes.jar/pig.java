import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

public class pig
  implements ViewBase.OnClickListener
{
  BaseArticleInfo a;
  
  public pig(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a = paramBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.mSocialFeedInfo.a.a.d;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    rap.a((ArticleInfo)this.a, (int)this.a.mChannelID);
    onk.a(localBaseActivity, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pig
 * JD-Core Version:    0.7.0.1
 */