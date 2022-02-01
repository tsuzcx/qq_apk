package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeRIJAvatar$Builder;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual$IBuilder;", "()V", "buildNativeView", "Landroid/view/View;", "context", "Landroid/content/Context;", "ptsNodeVirtual", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "buildNodeVirtual", "ptsAppInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeRIJAvatar$Builder
  implements PTSNodeVirtual.IBuilder
{
  @NotNull
  public View buildNativeView(@Nullable Context paramContext, @Nullable PTSNodeVirtual paramPTSNodeVirtual)
  {
    return (View)new PTSRIJAvatarView(paramContext);
  }
  
  @NotNull
  public PTSNodeVirtual buildNodeVirtual(@Nullable PTSAppInstance paramPTSAppInstance)
  {
    return (PTSNodeVirtual)new PTSNodeRIJAvatar(paramPTSAppInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRIJAvatar.Builder
 * JD-Core Version:    0.7.0.1
 */