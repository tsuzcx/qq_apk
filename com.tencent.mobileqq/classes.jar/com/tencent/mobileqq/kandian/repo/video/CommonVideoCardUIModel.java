package com.tencent.mobileqq.kandian.repo.video;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URL;

public class CommonVideoCardUIModel
  implements IVideoCardUIModel
{
  protected AbsBaseArticleInfo a;
  protected URL a;
  
  public CommonVideoCardUIModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  protected Pair<Integer, Integer> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ReadInJoyDisplayUtils.g();
    }
    return ReadInJoyDisplayUtils.f();
  }
  
  public int getCommentCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
  }
  
  public String getShareUrl()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl;
  }
  
  public String getSubscribeName()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
  }
  
  public String getSubscribeUin()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID;
  }
  
  public URL getVideoCoverURL()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoCoverUrl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoCoverUrl;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSinglePicture != null) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSinglePicture;
    }
    return RIJConvertString2URL.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl);
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
      return RIJConvertString2URL.a(RIJSmartCropUtils.a(str1, paramInt1, paramInt2));
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.mVideoDuration;
    }
    return 0;
  }
  
  public int getVideoHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoJsonHeight;
  }
  
  public String getVideoVid()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoVid;
  }
  
  public int getVideoWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoJsonWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.CommonVideoCardUIModel
 * JD-Core Version:    0.7.0.1
 */