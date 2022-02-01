import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.net.URL;
import java.util.ArrayList;

public class rsk
  extends rox
{
  private String a;
  
  public rsk(BaseArticleInfo paramBaseArticleInfo)
  {
    super(paramBaseArticleInfo);
  }
  
  public int getCommentCount()
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && (!ppe.q((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.d;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).g;
  }
  
  public String getShareUrl()
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && (!ppe.q((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
      return ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).h;
    }
    return super.getShareUrl();
  }
  
  public String getSubscribeName()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label59;
      }
    }
    label59:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = ContactUtils.getBuddyName((QQAppInterface)localObject, getSubscribeUin(), true);; localObject = "")
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        return this.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public String getSubscribeUin()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
      return String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
    }
    return "";
  }
  
  public URL getVideoCoverURL()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.size() > 0)) {
      return pqa.a(((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).d, true, true);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl;
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.size() > 0)) {
      return pqa.a(pre.a(((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).d, paramInt1, paramInt2));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && (!ppe.q((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
      return (int)(((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_a_of_type_Long / 1000L);
    }
    return super.getVideoDuration();
  }
  
  public int getVideoHeight()
  {
    return ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).b;
  }
  
  public String getVideoVid()
  {
    return ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).i;
  }
  
  public int getVideoWidth()
  {
    return ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsk
 * JD-Core Version:    0.7.0.1
 */