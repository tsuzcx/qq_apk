package com.tencent.timi.game.liveroom.impl.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.timi.game.ui.widget.BaseCommonDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/LiveDialog;", "Lcom/tencent/timi/game/ui/widget/BaseCommonDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "negativeButtonClickListener", "Landroid/content/DialogInterface$OnClickListener;", "positiveButtonClickListener", "rootView", "Landroid/view/View;", "acquireBgView", "acquireContentView", "massage", "content", "", "listener", "negativeButtonText", "text", "onBackPressed", "", "positiveButtonText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveDialog
  extends BaseCommonDialog
{
  private final View a;
  private DialogInterface.OnClickListener b;
  private DialogInterface.OnClickListener c;
  
  public LiveDialog(@NotNull Context paramContext)
  {
    super(paramContext);
    paramContext = View.inflate(paramContext, 2131629442, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "View.inflate(context, R.…out.tg_live_dialog, null)");
    this.a = paramContext;
    setContentView(this.a);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    ((TextView)findViewById(2131439179)).setOnClickListener((View.OnClickListener)new LiveDialog.1(this));
    ((TextView)findViewById(2131440535)).setOnClickListener((View.OnClickListener)new LiveDialog.2(this));
  }
  
  @NotNull
  public final LiveDialog a(@Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
    return this;
  }
  
  @NotNull
  public final LiveDialog a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      TextView localTextView = (TextView)findViewById(2131431336);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "contentText");
      localTextView.setText((CharSequence)paramString);
    }
    return this;
  }
  
  @NotNull
  public final LiveDialog b(@Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
    return this;
  }
  
  @NotNull
  public final LiveDialog b(@Nullable String paramString)
  {
    if (paramString != null)
    {
      TextView localTextView = (TextView)findViewById(2131440535);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "positiveButton");
      localTextView.setText((CharSequence)paramString);
    }
    return this;
  }
  
  @NotNull
  public final LiveDialog c(@Nullable String paramString)
  {
    if (paramString != null)
    {
      TextView localTextView = (TextView)findViewById(2131439179);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "negativeButton");
      localTextView.setText((CharSequence)paramString);
    }
    return this;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  @NotNull
  public View p()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentView");
    return (View)localLinearLayout;
  }
  
  @NotNull
  public View q()
  {
    View localView = findViewById(2131429401);
    Intrinsics.checkExpressionValueIsNotNull(localView, "bgView");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.LiveDialog
 * JD-Core Version:    0.7.0.1
 */