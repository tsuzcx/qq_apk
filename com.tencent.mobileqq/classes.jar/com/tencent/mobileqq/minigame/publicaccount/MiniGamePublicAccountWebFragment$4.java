package com.tencent.mobileqq.minigame.publicaccount;

import aldq;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.app.ThreadManagerV2;

class MiniGamePublicAccountWebFragment$4
  implements aldq
{
  MiniGamePublicAccountWebFragment$4(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, View paramView) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new MiniGamePublicAccountWebFragment.4.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4
 * JD-Core Version:    0.7.0.1
 */