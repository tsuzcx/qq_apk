package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.AnimationCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/BaseCommonDialog;", "Lcom/tencent/timi/game/ui/widget/FullScreenDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIsAnimatingDismiss", "", "mNeedDismissAni", "acquireBgView", "Landroid/view/View;", "acquireContentView", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "realDismiss", "show", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseCommonDialog
  extends FullScreenDialog
{
  private boolean a;
  private boolean b = true;
  
  public BaseCommonDialog(@NotNull Context paramContext)
  {
    super(paramContext, 2131952976);
  }
  
  private final void a()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      Logger.a("CommonDialog", "onAnimationFinish dismiss error", (Throwable)localException);
    }
  }
  
  public void dismiss()
  {
    if (this.a) {
      return;
    }
    if (!this.b)
    {
      a();
      return;
    }
    this.a = true;
    CommonAnimationUtil.c(q());
    CommonAnimationUtil.a(p(), (CommonAnimationUtil.AnimationCallback)new BaseCommonDialog.dismiss.1(this));
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 22)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(-2147483648);
      }
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setStatusBarColor(Color.parseColor("#4C000000"));
      }
    }
  }
  
  @NotNull
  public abstract View p();
  
  @NotNull
  public abstract View q();
  
  public void show()
  {
    super.show();
    CommonAnimationUtil.a(p());
    CommonAnimationUtil.b(q());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseCommonDialog
 * JD-Core Version:    0.7.0.1
 */