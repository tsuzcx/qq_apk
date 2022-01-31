import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pxi
  extends osp
{
  public pxi(ComponentHeaderPolymeric paramComponentHeaderPolymeric) {}
  
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
      ComponentHeaderPolymeric.a(this.a, true);
      if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null)) {
        ((qdv)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 1;
      }
      if (localArticleInfo.mPolymericInfo != null)
      {
        localArticleInfo.mPolymericInfo.e = 2;
        return;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "articleInfo mPolymericInfo == null articleInfo.mArticleID = " + localArticleInfo.mArticleID);
      return;
    }
    ComponentHeaderPolymeric.a(this.a, false);
    if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null)) {
      ((qdv)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = 0;
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
        QLog.d("ComponentHeaderPolymeric", 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = (ArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    } while ((localArticleInfo == null) || (localArticleInfo.mPolymericInfo == null) || (localArticleInfo.mPolymericInfo.b != paramLong));
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    ComponentHeaderPolymeric.a(this.a).setVisibility(0);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.a, true);
      if (localSocializeFeedsInfo != null) {
        localSocializeFeedsInfo.h = 2;
      }
      localArticleInfo.mPolymericInfo.e = 2;
      return;
    }
    ComponentHeaderPolymeric.a(this.a, false);
    if (localSocializeFeedsInfo != null) {
      localSocializeFeedsInfo.h = 1;
    }
    localArticleInfo.mPolymericInfo.e = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxi
 * JD-Core Version:    0.7.0.1
 */