import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;

public class rez
  implements rfm
{
  protected BaseArticleInfo a;
  protected URL a;
  
  public rez(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  protected Pair<Integer, Integer> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return pgk.g();
    }
    return pgk.f();
  }
  
  public int getCommentCount()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
  }
  
  public String getShareUrl()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleContentUrl;
  }
  
  public String getSubscribeName()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeName;
  }
  
  public String getSubscribeUin()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID;
  }
  
  public URL getVideoCoverURL()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSinglePicture != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSinglePicture;
    }
    return pha.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFirstPagePicUrl);
  }
  
  public URL getVideoCoverUrlWithSmartCut(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaNetURL == null)
    {
      Pair localPair = a(paramBoolean);
      this.jdField_a_of_type_JavaNetURL = getVideoCoverWithSmartCut(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    }
    return this.jdField_a_of_type_JavaNetURL;
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    if (getVideoCoverURL() != null)
    {
      String str2 = getVideoCoverURL().toString();
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (str2.startsWith("pubaccountimage:")) {
          str1 = str2.replaceFirst("pubaccountimage:", "");
        }
      }
      return pha.a(pha.a(str1, paramInt1, paramInt2));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDuration;
    }
    return 0;
  }
  
  public int getVideoHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoJsonHeight;
  }
  
  public String getVideoVid()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid;
  }
  
  public int getVideoWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoJsonWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rez
 * JD-Core Version:    0.7.0.1
 */