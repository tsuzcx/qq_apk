package com.tencent.mobileqq.gamecenter.hippy;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import java.util.ArrayList;
import java.util.List;

class GamePAHippyBaseFragment$1
  extends GamePubAccountMsgObserver
{
  GamePAHippyBaseFragment$1(GamePAHippyBaseFragment paramGamePAHippyBaseFragment) {}
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    super.a(paramArrayList);
    if ((this.a.a != null) && (this.a.a.size() < 5)) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePAHippyBaseFragment.1.1(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */