package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$Companion;", "", "()V", "AUTO_PLAYMODE_ALLPLAY", "", "getAUTO_PLAYMODE_ALLPLAY", "()I", "setAUTO_PLAYMODE_ALLPLAY", "(I)V", "AUTO_PLAYMODE_ALL_CLICK_PLAY", "getAUTO_PLAYMODE_ALL_CLICK_PLAY", "setAUTO_PLAYMODE_ALL_CLICK_PLAY", "AUTO_PLAYMODE_WIFI_ONLY", "getAUTO_PLAYMODE_WIFI_ONLY", "setAUTO_PLAYMODE_WIFI_ONLY", "autoPlayMode", "getAutoPlayMode", "setAutoPlayMode", "autoPlay", "", "updatePlayConfig", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayController$Companion
{
  public final int a()
  {
    return VideoPlayController.d();
  }
  
  public final void a()
  {
    Companion localCompanion = (Companion)this;
    localCompanion.a(Aladdin.getConfig(406).getIntegerFromString("play_config", localCompanion.b()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("auto play mode: ");
    localStringBuilder.append(localCompanion.d());
    QLog.d("VideoPlayController", 1, localStringBuilder.toString());
  }
  
  public final void a(int paramInt)
  {
    VideoPlayController.f(paramInt);
  }
  
  public final boolean a()
  {
    Companion localCompanion = (Companion)this;
    int i = localCompanion.d();
    if (i == localCompanion.b())
    {
      if (NetworkUtil.getNetworkType((Context)BaseApplication.getContext()) != 1) {
        if (RIJCUKingCardUtils.a() != 1) {
          break label56;
        }
      }
    }
    else {
      if (i != localCompanion.a()) {
        break label51;
      }
    }
    return true;
    label51:
    localCompanion.c();
    label56:
    return false;
  }
  
  public final int b()
  {
    return VideoPlayController.e();
  }
  
  public final int c()
  {
    return VideoPlayController.f();
  }
  
  public final int d()
  {
    return VideoPlayController.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.Companion
 * JD-Core Version:    0.7.0.1
 */