package com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine;

import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/gifvideo/base/video/statemachine/InstallingState$installVideoPlugin$1", "Lcom/tencent/mobileqq/kandian/base/video/plugin/OnVideoPluginInstallListener;", "onInstallComplete", "", "success", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class InstallingState$installVideoPlugin$1
  implements OnVideoPluginInstallListener
{
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a().get() < 2)) {
      this.a.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.InstallingState.installVideoPlugin.1
 * JD-Core Version:    0.7.0.1
 */