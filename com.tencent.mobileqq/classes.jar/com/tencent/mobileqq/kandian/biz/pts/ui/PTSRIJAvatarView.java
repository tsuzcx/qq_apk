package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSRIJAvatarView;", "Lcom/tencent/mobileqq/kandian/biz/pts/view/impl/NativeAvatarView;", "Lcom/tencent/pts/ui/view/IView;", "ptsNodeRijAvatar", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeRIJAvatar;", "(Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeRIJAvatar;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onBindNodeInfo", "", "p0", "Lcom/tencent/pts/ui/PTSNodeInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSRIJAvatarView
  extends NativeAvatarView
  implements IView
{
  public static final PTSRIJAvatarView.Companion Companion = new PTSRIJAvatarView.Companion(null);
  @NotNull
  public static final String TAG = "PTSRIJAvatarView";
  
  public PTSRIJAvatarView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSRIJAvatarView(@NotNull PTSNodeRIJAvatar paramPTSNodeRIJAvatar)
  {
    this(paramPTSNodeRIJAvatar);
  }
  
  public void onBindNodeInfo(@Nullable PTSNodeInfo paramPTSNodeInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSRIJAvatarView
 * JD-Core Version:    0.7.0.1
 */