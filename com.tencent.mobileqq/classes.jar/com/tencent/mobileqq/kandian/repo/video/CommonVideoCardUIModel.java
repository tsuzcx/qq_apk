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
  protected URL b;
  
  public CommonVideoCardUIModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
  }
  
  protected Pair<Integer, Integer> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ReadInJoyDisplayUtils.h();
    }
    return ReadInJoyDisplayUtils.g();
  }
  
  public int getCommentCount()
  {
    return this.a.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return this.a.innerUniqueID;
  }
  
  public String getShareUrl()
  {
    return this.a.mArticleContentUrl;
  }
  
  public String getSubscribeName()
  {
    return this.a.mSubscribeName;
  }
  
  public String getSubscribeUin()
  {
    return this.a.mSubscribeID;
  }
  
  public URL getVideoCoverURL()
  {
    if (this.a.mVideoCoverUrl != null) {
      return this.a.mVideoCoverUrl;
    }
    if (this.a.mSinglePicture != null) {
      return this.a.mSinglePicture;
    }
    return RIJConvertString2URL.b(this.a.mFirstPagePicUrl);
  }
  
  public URL getVideoCoverUrlWithSmartCut(boolean paramBoolean)
  {
    if (this.b == null)
    {
      Pair localPair = a(paramBoolean);
      this.b = getVideoCoverWithSmartCut(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    }
    return this.b;
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
      return RIJConvertString2URL.b(RIJSmartCropUtils.a(str1, paramInt1, paramInt2));
    }
    return this.a.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.mVideoDuration;
    }
    return 0;
  }
  
  public int getVideoHeight()
  {
    return this.a.mVideoJsonHeight;
  }
  
  public String getVideoVid()
  {
    return this.a.mVideoVid;
  }
  
  public int getVideoWidth()
  {
    return this.a.mVideoJsonWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.CommonVideoCardUIModel
 * JD-Core Version:    0.7.0.1
 */