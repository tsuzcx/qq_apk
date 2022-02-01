package com.tencent.timi.game.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.utils.StatusBarUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/EmptyDialog;", "Lcom/tencent/timi/game/ui/widget/BaseCommonDialog;", "Lcom/tencent/timi/game/ui/widget/IDialogLoading;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backPressEnable", "", "acquireBgView", "Landroid/view/View;", "acquireContentView", "hideLoadingView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoadingView", "loadingTextResId", "", "text", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class EmptyDialog
  extends BaseCommonDialog
  implements IDialogLoading
{
  private boolean a;
  
  public EmptyDialog(@NotNull Context paramContext)
  {
    super(paramContext);
    setContentView(View.inflate(paramContext, 2131629512, null));
    paramContext = (ConstraintLayout)findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "contentView");
    paramContext.setVisibility(8);
    paramContext = findViewById(2131429401);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "bgView");
    paramContext.setVisibility(8);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = this.e.getString(2131917232);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "context.getString(R.stri…ame_loading_hint_default)");
    }
    ((TimiGamePageLoadingView)findViewById(2131437626)).setHintText(paramString);
    ((TimiGamePageLoadingView)findViewById(2131437626)).a();
  }
  
  public void onBackPressed()
  {
    if (this.a) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    StatusBarUtil.b(getWindow());
  }
  
  @NotNull
  public View p()
  {
    ConstraintLayout localConstraintLayout = (ConstraintLayout)findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localConstraintLayout, "contentView");
    return (View)localConstraintLayout;
  }
  
  @NotNull
  public View q()
  {
    View localView = findViewById(2131429401);
    Intrinsics.checkExpressionValueIsNotNull(localView, "bgView");
    return localView;
  }
  
  public void r()
  {
    if ((TimiGamePageLoadingView)findViewById(2131437626) != null) {
      ((TimiGamePageLoadingView)findViewById(2131437626)).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.EmptyDialog
 * JD-Core Version:    0.7.0.1
 */