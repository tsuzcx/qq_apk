package com.tencent.xaction.apng;

import android.content.Context;
import android.view.View;
import com.tencent.image.ApngImage;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/XAApngView;", "Landroid/view/View;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IAnim;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "doFrame", "", "frameTimeNanos", "", "end", "play", "preStart", "view", "Companion", "XAApng_release"}, k=1, mv={1, 1, 16})
public final class XAApngView
  extends View
  implements IAnim, IView
{
  public static final XAApngView.Companion a = new XAApngView.Companion(null);
  @NotNull
  private DecorView b = (DecorView)new XAApngView.decor.1(this, (IView)this);
  
  public XAApngView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public void doFrame(long paramLong) {}
  
  public void end()
  {
    ViewData localViewData = getDecor().e();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    ApngImage.pauseByTag(localViewData.getId());
  }
  
  @NotNull
  public DecorView getDecor()
  {
    return this.b;
  }
  
  public void play()
  {
    ViewData localViewData = getDecor().e();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    ApngImage.playByTag(localViewData.getId());
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.b = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView
 * JD-Core Version:    0.7.0.1
 */