package com.tencent.mobileqq.gamecenter.web;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;

class QQGameFeedWebFragment$19
  implements Runnable
{
  QQGameFeedWebFragment$19(QQGameFeedWebFragment paramQQGameFeedWebFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.isAdded())) {
      QQGameHelper.a(this.this$0.a, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.19
 * JD-Core Version:    0.7.0.1
 */