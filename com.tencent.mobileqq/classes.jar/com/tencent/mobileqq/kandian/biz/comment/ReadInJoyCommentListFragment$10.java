package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ReadInJoyCommentListFragment$10
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  ReadInJoyCommentListFragment$10(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBiuAndCommentSend fragment");
    Object localObject;
    if (paramRIJBiuAndCommentRespData == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramRIJBiuAndCommentRespData.a());
    }
    localStringBuilder.append(localObject);
    QLog.d("ReadInJoyCommentListFragment", 1, localStringBuilder.toString());
    if ((paramRIJBiuAndCommentRespData != null) && (paramRIJBiuAndCommentRespData.a() == 0))
    {
      RIJBiuAndCommentMixDataManager.a(paramRIJBiuAndCommentRespData.g(), paramRIJBiuAndCommentRespData.b(), paramRIJBiuAndCommentRespData.h(), paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.i(), paramRIJBiuAndCommentRespData.j(), paramRIJBiuAndCommentRespData.k(), paramRIJBiuAndCommentRespData.f());
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910403), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.10
 * JD-Core Version:    0.7.0.1
 */