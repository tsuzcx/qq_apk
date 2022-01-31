import android.content.res.Resources;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class lzf
  extends ReadInJoyObserver
{
  public lzf(ComponentHeaderPolymeric paramComponentHeaderPolymeric) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderPolymeric", 2, "onUpdateAfterSmallVideoTopicFollow topicId = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = (ArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    } while ((localArticleInfo == null) || (localArticleInfo.mPolymericInfo == null) || (localArticleInfo.mPolymericInfo.f != paramLong));
    ComponentHeaderPolymeric.a(this.a).setVisibility(0);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.a).setText("已关注");
      ComponentHeaderPolymeric.a(this.a).setTextColor(-4473925);
      if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null)) {
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 1;
      }
      if (localArticleInfo.mPolymericInfo != null)
      {
        localArticleInfo.mPolymericInfo.e = 2;
        return;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "articleInfo mPolymericInfo == null articleInfo.mArticleID = " + localArticleInfo.mArticleID);
      return;
    }
    ComponentHeaderPolymeric.a(this.a).setText("关注");
    ComponentHeaderPolymeric.a(this.a).setTextColor(this.a.getResources().getColor(2131493399));
    if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null)) {
      ((TopicRecommendFeedsInfo.TopicRecommendInfo)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 0;
    }
    if (localArticleInfo.mPolymericInfo != null)
    {
      localArticleInfo.mPolymericInfo.e = 1;
      return;
    }
    QLog.e("ComponentHeaderPolymeric", 2, "articleInfo mPolymericInfo == null articleInfo.mArticleID = " + localArticleInfo.mArticleID);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderPolymeric", 2, "onUpdateAfterSmallVideoAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = (ArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    } while ((localArticleInfo == null) || (localArticleInfo.mPolymericInfo == null) || (localArticleInfo.mPolymericInfo.b != paramLong));
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    ComponentHeaderPolymeric.a(this.a).setVisibility(0);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.a).setText("已关注");
      ComponentHeaderPolymeric.a(this.a).setTextColor(-4473925);
      if (localSocializeFeedsInfo != null) {
        localSocializeFeedsInfo.h = 2;
      }
      localArticleInfo.mPolymericInfo.e = 2;
      return;
    }
    ComponentHeaderPolymeric.a(this.a).setText("关注");
    ComponentHeaderPolymeric.a(this.a).setTextColor(this.a.getResources().getColor(2131493399));
    if (localSocializeFeedsInfo != null) {
      localSocializeFeedsInfo.h = 1;
    }
    localArticleInfo.mPolymericInfo.e = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzf
 * JD-Core Version:    0.7.0.1
 */