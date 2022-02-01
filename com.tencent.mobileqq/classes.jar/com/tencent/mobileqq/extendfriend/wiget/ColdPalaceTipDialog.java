package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/ColdPalaceTipDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "uin", "", "uinType", "", "from", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V", "mContentTv", "Landroid/widget/TextView;", "getMContentTv", "()Landroid/widget/TextView;", "setMContentTv", "(Landroid/widget/TextView;)V", "init", "", "showDialog", "content", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ColdPalaceTipDialog
  extends DialogFromBottom
{
  public static final ColdPalaceTipDialog.Companion a;
  @Nullable
  private TextView a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendWigetColdPalaceTipDialog$Companion = new ColdPalaceTipDialog.Companion(null);
  }
  
  public ColdPalaceTipDialog(@NotNull Context paramContext, @Nullable QQAppInterface paramQQAppInterface, @Nullable String paramString1, int paramInt, @NotNull String paramString2)
  {
    super(paramContext);
    a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2);
  }
  
  public final void a(@NotNull Context paramContext, @Nullable QQAppInterface paramQQAppInterface, @Nullable String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    if (paramQQAppInterface != null)
    {
      Object localObject = LayoutInflater.from(paramContext).inflate(2131561206, null);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
      }
      localObject = (LinearLayout)localObject;
      ((ImageView)((LinearLayout)localObject).findViewById(2131369843)).setOnClickListener((View.OnClickListener)new ColdPalaceTipDialog.init..inlined.let.lambda.1(this, paramContext, paramString1, paramString2, paramQQAppInterface, paramInt));
      setOnCancelListener((DialogInterface.OnCancelListener)ColdPalaceTipDialog.init.1.2.a);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((LinearLayout)localObject).findViewById(2131380283));
      ((Button)((LinearLayout)localObject).findViewById(2131363937)).setOnClickListener((View.OnClickListener)new ColdPalaceTipDialog.init..inlined.let.lambda.2(this, paramContext, paramString1, paramString2, paramQQAppInterface, paramInt));
      paramContext = ((LinearLayout)localObject).findViewById(2131364916);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "contentView.findViewById(R.id.cold_palace)");
      ((URLImageView)paramContext).setImageURL("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png");
      setContentView((View)localObject);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog
 * JD-Core Version:    0.7.0.1
 */