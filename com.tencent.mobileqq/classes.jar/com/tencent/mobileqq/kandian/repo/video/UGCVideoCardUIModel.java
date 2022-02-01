package com.tencent.mobileqq.kandian.repo.video;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class UGCVideoCardUIModel
  extends CommonVideoCardUIModel
{
  private String c = null;
  
  public UGCVideoCardUIModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramAbsBaseArticleInfo);
  }
  
  public int getCommentCount()
  {
    if (((this.a instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(this.a))) {
      return this.a.mSocialFeedInfo.j;
    }
    return this.a.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return ((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).l;
  }
  
  public String getShareUrl()
  {
    if (((this.a instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(this.a))) {
      return ((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).n;
    }
    return super.getShareUrl();
  }
  
  public String getSubscribeName()
  {
    if (TextUtils.isEmpty(this.c))
    {
      Object localObject = null;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localObject = (QQAppInterface)localAppRuntime;
      }
      if (localObject != null) {
        localObject = ContactUtils.a((AppRuntime)localObject, getSubscribeUin(), true);
      } else {
        localObject = "";
      }
      this.c = ((String)localObject);
    }
    return this.c;
  }
  
  public String getSubscribeUin()
  {
    if (this.a.mSocialFeedInfo.c != null) {
      return String.valueOf(this.a.mSocialFeedInfo.c.a);
    }
    return "";
  }
  
  public URL getVideoCoverURL()
  {
    if ((this.a.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.s != null) && (this.a.mSocialFeedInfo.s.c.size() > 0)) {
      return RIJPreParseData.a(((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).d, true, true);
    }
    return this.a.mVideoCoverUrl;
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    if ((this.a.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.s != null) && (this.a.mSocialFeedInfo.s.c.size() > 0)) {
      return RIJConvertString2URL.b(RIJSmartCropUtils.a(((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).d, paramInt1, paramInt2));
    }
    return this.a.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    if (((this.a instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(this.a))) {
      return (int)(((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).g / 1000L);
    }
    return super.getVideoDuration();
  }
  
  public int getVideoHeight()
  {
    return ((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).i;
  }
  
  public String getVideoVid()
  {
    return ((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).p;
  }
  
  public int getVideoWidth()
  {
    return ((UGCVideoInfo)this.a.mSocialFeedInfo.s.c.get(0)).h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.UGCVideoCardUIModel
 * JD-Core Version:    0.7.0.1
 */