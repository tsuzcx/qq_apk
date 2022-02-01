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
      if (FastWebActivity.p(this.a) != null)
      {
        localObject1 = FastWebActivity.d(this.a);
        ((FastWebArticleInfo)localObject1).d += 1L;
        localObject1 = FastWebActivity.p(this.a);
        localObject2 = this.a;
        ((ReadInJoyFastWebBottomSocialViewNew)localObject1).a((Context)localObject2, FastWebActivity.d((FastWebActivity)localObject2), this.a.g);
      }
      RIJBiuAndCommentMixDataManager.a(paramRIJBiuAndCommentRespData.g(), paramRIJBiuAndCommentRespData.b(), paramRIJBiuAndCommentRespData.h(), paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.i(), paramRIJBiuAndCommentRespData.j(), paramRIJBiuAndCommentRespData.k(), paramRIJBiuAndCommentRespData.f());
      if ((paramRIJBiuAndCommentRespData.h() == 1) && (!FastWebActivity.ad(this.a)))
      {
        FastWebActivity.i(this.a, true);
        FastWebAnimationUtils.a(this.a);
      }
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910403), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.39
 * JD-Core Version:    0.7.0.1
 */