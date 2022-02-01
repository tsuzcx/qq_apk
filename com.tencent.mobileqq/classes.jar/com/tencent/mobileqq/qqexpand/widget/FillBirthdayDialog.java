package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.BirthdayPickHelper;
import com.tencent.mobileqq.activity.BirthdayPickHelper.BirthdayChangeListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/widget/FillBirthdayDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initBirthday", "", "listener", "Lcom/tencent/mobileqq/qqexpand/widget/FillBirthdayDialog$OnConfirmListener;", "(Landroid/content/Context;ILcom/tencent/mobileqq/qqexpand/widget/FillBirthdayDialog$OnConfirmListener;)V", "birthdayPickHelper", "Lcom/tencent/mobileqq/activity/BirthdayPickHelper;", "confirmListener", "newBirthdayDay", "newBirthdayMonth", "newBirthdayUnion", "newBirthdayYear", "init", "", "Companion", "OnConfirmListener", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class FillBirthdayDialog
  extends DialogFromBottom
{
  public static final FillBirthdayDialog.Companion a = new FillBirthdayDialog.Companion(null);
  private BirthdayPickHelper b;
  private int c;
  private int d;
  private int e;
  private int f;
  private FillBirthdayDialog.OnConfirmListener g;
  
  public FillBirthdayDialog(@NotNull Context paramContext, int paramInt, @Nullable FillBirthdayDialog.OnConfirmListener paramOnConfirmListener)
  {
    super(paramContext);
    this.g = paramOnConfirmListener;
    this.f = paramInt;
    a(paramContext, paramInt);
  }
  
  private final void a(Context paramContext, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(1912995840, null);
    if (localObject1 != null)
    {
      localObject1 = (LinearLayout)localObject1;
      this.b = new BirthdayPickHelper(paramContext, paramInt, true);
      Object localObject2 = this.b;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((BirthdayPickHelper)localObject2).a((BirthdayPickHelper.BirthdayChangeListener)new FillBirthdayDialog.init.1(this));
      localObject2 = this.b;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((BirthdayPickHelper)localObject2).a();
      ((IphonePickerView)localObject2).setBackgroundColor(paramContext.getResources().getColor(1912733702));
      ((LinearLayout)localObject1).addView((View)localObject2, 2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "pickerView");
      paramContext = ((IphonePickerView)localObject2).getLayoutParams();
      if (paramContext != null)
      {
        paramContext = (LinearLayout.LayoutParams)paramContext;
        paramContext.topMargin = ViewUtils.dpToPx(-2.0F);
        ((IphonePickerView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramContext);
        setContentView((View)localObject1);
        ((ImageView)((LinearLayout)localObject1).findViewById(1912930308)).setOnClickListener((View.OnClickListener)new FillBirthdayDialog.init.2(this));
        setOnCancelListener((DialogInterface.OnCancelListener)new FillBirthdayDialog.init.3(this));
        ((Button)((LinearLayout)localObject1).findViewById(1912930322)).setOnClickListener((View.OnClickListener)new FillBirthdayDialog.init.4(this));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog
 * JD-Core Version:    0.7.0.1
 */