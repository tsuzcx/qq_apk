package com.tencent.mobileqq.kandian.biz.pts.view;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RspBody;

class ReadInJoySocializeRecommendFollowView$9
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoySocializeRecommendFollowView$9(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("requestRecommendList onResult, errorCode = ");
      paramBundle.append(paramInt);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_0xc2f.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        ReadInJoySocializeRecommendFollowView.g(this.b).mRecommendFollowInfos = RecommendFollowInfos.a((oidb_0xc2f.GetFollowUserRecommendListRsp)paramBundle.msg_get_follow_user_recommend_list_rsp.get());
        if ((ReadInJoySocializeRecommendFollowView.g(this.b).mRecommendFollowInfos.c != null) && (ReadInJoySocializeRecommendFollowView.g(this.b).mRecommendFollowInfos.c.size() >= 3))
        {
          ReadInJoySocializeRecommendFollowView.c(this.b).a(ReadInJoySocializeRecommendFollowView.g(this.b).mRecommendFollowInfos.c);
          ReadInJoySocializeRecommendFollowView.g(this.b).isShowRecommendList = true;
          ReadInJoySocializeRecommendFollowView.a(this.b);
          ReadInJoySocializeRecommendFollowView.b(this.b).post(new ReadInJoySocializeRecommendFollowView.9.1(this));
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList onResult, size < 3");
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("requestRecommendList onResult(), exception = ");
        paramBundle.append(paramArrayOfByte.toString());
        QLog.e("ReadInJoySocializeRecommendFollowView", 1, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.9
 * JD-Core Version:    0.7.0.1
 */