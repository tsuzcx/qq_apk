package com.tencent.mobileqq.kandian.repo.biu;

import com.tencent.mobileqq.kandian.repo.common.RIJUserApproveModule.UserApproveCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;

class RIJNewBiuCardTransformManager$1
  implements RIJUserApproveModule.UserApproveCallback
{
  RIJNewBiuCardTransformManager$1(RIJNewBiuCardTransformManager paramRIJNewBiuCardTransformManager) {}
  
  public void a(int paramInt)
  {
    if ((RIJNewBiuCardTransformManager.a(this.a) != null) && (RIJNewBiuCardTransformManager.a(this.a).e != null))
    {
      if (RIJNewBiuCardTransformManager.a(this.a).e.mSocialFeedInfo == null) {
        RIJNewBiuCardTransformManager.a(this.a).e.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      RIJNewBiuCardTransformManager.a(this.a).e.mSocialFeedInfo.c.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager.1
 * JD-Core Version:    0.7.0.1
 */