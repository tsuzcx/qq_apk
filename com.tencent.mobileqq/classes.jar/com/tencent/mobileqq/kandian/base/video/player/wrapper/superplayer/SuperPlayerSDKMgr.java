package com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKEventListener;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerSDKMgr
  implements IPlayerSDKMgr, SDKInitListener
{
  public static final SuperPlayerSDKMgr a = new SuperPlayerSDKMgr();
  private static IPlayerSDKEventListener b;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull IPlayerSDKEventListener paramIPlayerSDKEventListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayerSDKEventListener, "listener");
    b = paramIPlayerSDKEventListener;
    QQVideoPlaySDKManager.initSDKAsync((Context)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean b()
  {
    return QQVideoPlaySDKManager.isSDKReady();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    IPlayerSDKEventListener localIPlayerSDKEventListener;
    if (paramBoolean)
    {
      localIPlayerSDKEventListener = b;
      if (localIPlayerSDKEventListener != null) {
        localIPlayerSDKEventListener.a();
      }
    }
    else
    {
      localIPlayerSDKEventListener = b;
      if (localIPlayerSDKEventListener != null) {
        localIPlayerSDKEventListener.a(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */