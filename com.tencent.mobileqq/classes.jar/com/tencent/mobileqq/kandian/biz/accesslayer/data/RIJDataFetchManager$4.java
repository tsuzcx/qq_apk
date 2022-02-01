package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class RIJDataFetchManager$4
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  RIJDataFetchManager$4(RIJDataFetchManager paramRIJDataFetchManager, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if (paramRIJBiuAndCommentRespData.a() == 0)
    {
      ReadInJoyCommentUtils.a(this.a, new CommentInfo(), false);
      QQToast.makeText(RIJDataFetchManager.a(this.b).q(), 2, RIJDataFetchManager.a(this.b).q().getString(2131915297), 0).show();
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910403), 0).show();
    }
    RIJDataFetchManager.b(this.b);
    RIJDataFetchManager.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.4
 * JD-Core Version:    0.7.0.1
 */