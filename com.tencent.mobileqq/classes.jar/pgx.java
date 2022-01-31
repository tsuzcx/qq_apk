import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

class pgx
  extends ComponentContentPgcShortContentGridImage
{
  pgx(pgw parampgw, Context paramContext, ArticleInfo paramArticleInfo)
  {
    super(paramContext);
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a != null)) {
      return 11;
    }
    return super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgx
 * JD-Core Version:    0.7.0.1
 */