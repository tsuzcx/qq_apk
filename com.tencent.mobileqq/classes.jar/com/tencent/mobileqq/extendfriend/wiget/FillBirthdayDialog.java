package com.tencent.mobileqq.extendfriend.wiget;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initBirthday", "", "listener", "Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;", "(Landroid/content/Context;ILcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;)V", "birthdayPickHelper", "Lcom/tencent/mobileqq/activity/BirthdayPickHelper;", "confirmListener", "newBirthdayDay", "newBirthdayMonth", "newBirthdayUnion", "newBirthdayYear", "init", "", "Companion", "OnConfirmListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FillBirthdayDialog
  extends DialogFromBottom
{
  public static final FillBirthdayDialog.Companion a;
  private int jdField_a_of_type_Int;
  private BirthdayPickHelper jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper;
  private FillBirthdayDialog.OnConfirmListener jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog$OnConfirmListener;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog$Companion = new FillBirthdayDialog.Companion(null);
  }
  
  public FillBirthdayDialog(@NotNull Context paramContext, int paramInt, @Nullable FillBirthdayDialog.OnConfirmListener paramOnConfirmListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog$OnConfirmListener = paramOnConfirmListener;
    this.d = paramInt;
    a(paramContext, paramInt);
  }
  
  private final void a(Context paramContext, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561200, null);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
    localObject1 = (LinearLayout)localObject1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper = new BirthdayPickHelper(paramContext, paramInt, true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((BirthdayPickHelper)localObject2).a((BirthdayPickHelper.BirthdayChangeListener)new FillBirthdayDialog.init.1(this));
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((BirthdayPickHelper)localObject2).a();
    ((IphonePickerView)localObject2).setBackgroundColor(paramContext.getResources().getColor(2131165559));
    ((LinearLayout)localObject1).addView((View)localObject2, 2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "pickerView");
    paramContext = ((IphonePickerView)localObject2).getLayoutParams();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    paramContext.topMargin = ViewUtils.b(-2.0F);
    ((IphonePickerView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramContext);
    setContentView((View)localObject1);
    ((ImageView)((LinearLayout)localObject1).findViewById(2131363027)).setOnClickListener((View.OnClickListener)new FillBirthdayDialog.init.2(this));
    setOnCancelListener((DialogInterface.OnCancelListener)new FillBirthdayDialog.init.3(this));
    ((Button)((LinearLayout)localObject1).findViewById(2131365202)).setOnClickListener((View.OnClickListener)new FillBirthdayDialog.init.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog
 * JD-Core Version:    0.7.0.1
 */