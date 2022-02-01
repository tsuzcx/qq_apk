package com.tencent.tkd.topicsdk.framework;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BaseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "themeRes", "", "(Landroid/content/Context;I)V", "isNightMode", "", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract class BaseDialog
  extends Dialog
{
  public BaseDialog(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.requestFeature(1);
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 19) {
        paramBundle.addFlags(67108864);
      }
      paramBundle.setLayout(-1, -1);
      if ((a()) && ((paramBundle.getDecorView() instanceof FrameLayout)))
      {
        Object localObject1 = paramBundle.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "decorView");
        localObject1 = new LinearLayout(((View)localObject1).getContext());
        Object localObject2 = paramBundle.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "decorView");
        localObject2 = ((View)localObject2).getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "decorView.context");
        ((LinearLayout)localObject1).setBackgroundColor(((Context)localObject2).getResources().getColor(R.color.a));
        paramBundle = paramBundle.getDecorView();
        if (paramBundle == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        ((FrameLayout)paramBundle).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BaseDialog
 * JD-Core Version:    0.7.0.1
 */