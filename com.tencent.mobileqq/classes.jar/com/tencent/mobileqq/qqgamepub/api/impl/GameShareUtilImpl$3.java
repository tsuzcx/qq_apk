package com.tencent.mobileqq.qqgamepub.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.qwallet.temp.IQWalletApiProxy.OnDecodeListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.util.WeakReference;

class GameShareUtilImpl$3
  implements IQWalletApiProxy.OnDecodeListener
{
  GameShareUtilImpl$3(GameShareUtilImpl paramGameShareUtilImpl, WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, Drawable paramDrawable)
  {
    ThreadManager.getUIHandlerV2().post(new GameShareUtilImpl.3.1(this, paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.3
 * JD-Core Version:    0.7.0.1
 */