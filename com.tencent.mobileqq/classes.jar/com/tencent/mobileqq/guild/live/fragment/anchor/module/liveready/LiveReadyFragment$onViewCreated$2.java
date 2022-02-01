package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils.Function3;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "thirdPushChecked", "", "protocolChecked", "fillName", "onValue", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class LiveReadyFragment$onViewCreated$2<R, S, T, U>
  implements GulidLiveDataUtils.Function3<R, S, T, U>
{
  LiveReadyFragment$onViewCreated$2(LiveReadyFragment paramLiveReadyFragment) {}
  
  public final void a(@Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable Boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildLiveDataUtils 1. ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" + 2. ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" 3. ");
    localStringBuilder.append(paramBoolean3);
    QLog.d("QGL.LiveReadyFragment", 2, localStringBuilder.toString());
    if (paramBoolean1 == null) {
      Intrinsics.throwNpe();
    }
    if (paramBoolean1.booleanValue()) {
      LiveReadyFragment.h(this.a).setVisibility(8);
    } else {
      LiveReadyFragment.h(this.a).setVisibility(0);
    }
    if (paramBoolean1.booleanValue())
    {
      if (paramBoolean2 == null) {
        Intrinsics.throwNpe();
      }
      if (paramBoolean2.booleanValue())
      {
        if (paramBoolean3 == null) {
          Intrinsics.throwNpe();
        }
        if (paramBoolean3.booleanValue())
        {
          LiveReadyFragment.i(this.a).setVisibility(0);
          LiveReadyFragment.j(this.a).setVisibility(8);
          return;
        }
      }
    }
    LiveReadyFragment.i(this.a).setVisibility(8);
    LiveReadyFragment.j(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.onViewCreated.2
 * JD-Core Version:    0.7.0.1
 */