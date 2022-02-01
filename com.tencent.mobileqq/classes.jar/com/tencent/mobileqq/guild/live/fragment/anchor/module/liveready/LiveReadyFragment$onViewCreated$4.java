package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPublishStream;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class LiveReadyFragment$onViewCreated$4<T>
  implements Observer<QQLiveAnchorDataPublishStream>
{
  LiveReadyFragment$onViewCreated$4(LiveReadyFragment paramLiveReadyFragment) {}
  
  public final void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    if ((paramQQLiveAnchorDataPublishStream != null) && (paramQQLiveAnchorDataPublishStream.isSuccess)) {
      LiveReadyFragment.k(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.onViewCreated.4
 * JD-Core Version:    0.7.0.1
 */