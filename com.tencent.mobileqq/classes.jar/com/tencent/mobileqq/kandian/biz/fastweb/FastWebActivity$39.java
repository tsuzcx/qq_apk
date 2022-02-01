package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebAnimationUtils;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$39
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  FastWebActivity$39(FastWebActivity paramFastWebActivity) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onBiuAndCommentSend fastWeb");
    Object localObject1;
    if (paramRIJBiuAndCommentRespData == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramRIJBiuAndCommentRespData.a());
    }
    ((StringBuilder)localObject2).append(localObject1);
    QLog.d("FastWebActivity", 1, ((StringBuilder)localObject2).toString());
    if ((paramRIJBiuAndCommentRespData != null) && (paramRIJBiuAndCommentRespData.a() == 0))
    {
      if (FastWebActivity.a(this.a) != null)
      {
        localObject1 = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject1).b += 1L;
        localObject1 = FastWebActivity.a(this.a);
        localObject2 = this.a;
        ((ReadInJoyFastWebBottomSocialViewNew)localObject1).a((Context)localObject2, FastWebActivity.a((FastWebActivity)localObject2), this.a.a);
      }
      RIJBiuAndCommentMixDataManager.a(paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.b(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.d(), paramRIJBiuAndCommentRespData.e(), paramRIJBiuAndCommentRespData.a());
      if ((paramRIJBiuAndCommentRespData.c() == 1) && (!FastWebActivity.h(this.a)))
      {
        FastWebActivity.e(this.a, true);
        FastWebAnimationUtils.a(this.a);
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712831), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.39
 * JD-Core Version:    0.7.0.1
 */