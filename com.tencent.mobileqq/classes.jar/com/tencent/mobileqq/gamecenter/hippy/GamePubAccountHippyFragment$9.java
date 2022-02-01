package com.tencent.mobileqq.gamecenter.hippy;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;

class GamePubAccountHippyFragment$9
  implements Runnable
{
  GamePubAccountHippyFragment$9(GamePubAccountHippyFragment paramGamePubAccountHippyFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.isAdded())) {
      QQGameHelper.a(GamePubAccountHippyFragment.a(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.9
 * JD-Core Version:    0.7.0.1
 */