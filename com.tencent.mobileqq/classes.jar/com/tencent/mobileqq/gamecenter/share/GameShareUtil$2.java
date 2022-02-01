package com.tencent.mobileqq.gamecenter.share;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qwallet.plugin.IQWalletPicHelper.OnDecodeListener;
import mqq.util.WeakReference;

final class GameShareUtil$2
  implements IQWalletPicHelper.OnDecodeListener
{
  GameShareUtil$2(WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2) {}
  
  public void onDecodeFinished(boolean paramBoolean, Drawable paramDrawable)
  {
    ThreadManager.getUIHandlerV2().post(new GameShareUtil.2.1(this, paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareUtil.2
 * JD-Core Version:    0.7.0.1
 */