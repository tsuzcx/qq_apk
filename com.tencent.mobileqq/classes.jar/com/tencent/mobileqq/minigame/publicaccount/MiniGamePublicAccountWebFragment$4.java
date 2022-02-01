package com.tencent.mobileqq.minigame.publicaccount;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class MiniGamePublicAccountWebFragment$4
  implements IPreloadService.OnGetPathListener
{
  MiniGamePublicAccountWebFragment$4(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, View paramView) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new MiniGamePublicAccountWebFragment.4.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4
 * JD-Core Version:    0.7.0.1
 */