package com.tencent.xaction.view;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAViewGroup
  extends FrameLayout
  implements IView
{
  @NotNull
  private DecorView a = new DecorView((IView)this);
  
  public XAViewGroup(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  @NotNull
  public DecorView a()
  {
    return this.a;
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.a = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.view.XAViewGroup
 * JD-Core Version:    0.7.0.1
 */