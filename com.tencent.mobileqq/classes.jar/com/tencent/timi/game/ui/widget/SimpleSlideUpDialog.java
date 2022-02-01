package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.utils.StatusBarUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/SimpleSlideUpDialog;", "Lcom/tencent/timi/game/ui/widget/FullScreenDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "contentView", "Landroid/view/View;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "post", "action", "Ljava/lang/Runnable;", "shadowBgView", "show", "superDismiss", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class SimpleSlideUpDialog
  extends FullScreenDialog
{
  private long a = 200L;
  
  public SimpleSlideUpDialog(@NotNull Context paramContext)
  {
    super(paramContext, 2131953004);
  }
  
  private final void a()
  {
    super.dismiss();
  }
  
  private final void a(Runnable paramRunnable)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new SimpleSlideUpDialog.post.1(paramRunnable));
  }
  
  @NotNull
  public abstract View b();
  
  @NotNull
  public abstract View c();
  
  public final long d()
  {
    return this.a;
  }
  
  public void dismiss()
  {
    View localView = b();
    a((Runnable)new SimpleSlideUpDialog.dismiss.1(this, c(), localView));
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
    }
    StatusBarUtil.b(getWindow());
  }
  
  public void show()
  {
    super.show();
    a((Runnable)new SimpleSlideUpDialog.show.1(this, b(), c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.SimpleSlideUpDialog
 * JD-Core Version:    0.7.0.1
 */