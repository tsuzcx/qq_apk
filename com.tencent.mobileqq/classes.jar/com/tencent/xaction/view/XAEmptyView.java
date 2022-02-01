package com.tencent.xaction.view;

import android.content.Context;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAEmptyView;", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAEmptyView
  implements IView
{
  public static final XAEmptyView.Companion a = new XAEmptyView.Companion(null);
  @NotNull
  private DecorView b = new DecorView((IView)this);
  
  public XAEmptyView(@NotNull Context paramContext) {}
  
  @NotNull
  public DecorView a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView
 * JD-Core Version:    0.7.0.1
 */