import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import java.util.ArrayList;
import java.util.List;

public class lvs
  extends ReadInJoyObserver
{
  public lvs(ComponentHeaderPolymeric paramComponentHeaderPolymeric) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    if (localArticleInfo.businessId == paramLong)
    {
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.a(this.a).setEnabled(false);
        ComponentHeaderPolymeric.a(this.a).setText("已关注");
        ComponentHeaderPolymeric.a(this.a).setTextColor(-4473925);
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 1;
      }
    }
    else
    {
      return;
    }
    ComponentHeaderPolymeric.a(this.a).setEnabled(true);
    ComponentHeaderPolymeric.a(this.a).setText("关注");
    ComponentHeaderPolymeric.a(this.a).setTextColor(this.a.getResources().getColor(2131493399));
    ((TopicRecommendFeedsInfo.TopicRecommendInfo)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 0;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = ((ArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if ((localSocializeFeedsInfo != null) && (localSocializeFeedsInfo.a.a == paramLong))
    {
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.a(this.a).setEnabled(false);
        ComponentHeaderPolymeric.a(this.a).setText("已关注");
        ComponentHeaderPolymeric.a(this.a).setTextColor(-4473925);
        localSocializeFeedsInfo.h = 2;
      }
    }
    else
    {
      return;
    }
    ComponentHeaderPolymeric.a(this.a).setEnabled(true);
    ComponentHeaderPolymeric.a(this.a).setText("关注");
    ComponentHeaderPolymeric.a(this.a).setTextColor(this.a.getResources().getColor(2131493399));
    localSocializeFeedsInfo.h = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */