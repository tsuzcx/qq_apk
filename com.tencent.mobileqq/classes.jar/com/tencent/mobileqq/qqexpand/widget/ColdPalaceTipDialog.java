package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/widget/ColdPalaceTipDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "uinType", "", "from", "(Landroid/content/Context;Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/String;ILjava/lang/String;)V", "mContentTv", "Landroid/widget/TextView;", "getMContentTv", "()Landroid/widget/TextView;", "setMContentTv", "(Landroid/widget/TextView;)V", "init", "", "showDialog", "content", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ColdPalaceTipDialog
  extends DialogFromBottom
{
  public static final ColdPalaceTipDialog.Companion a;
  @Nullable
  private TextView a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandWidgetColdPalaceTipDialog$Companion = new ColdPalaceTipDialog.Companion(null);
  }
  
  public ColdPalaceTipDialog(@NotNull Context paramContext, @Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt, @NotNull String paramString2)
  {
    super(paramContext);
    a(paramContext, paramBaseQQAppInterface, paramString1, paramInt, paramString2);
  }
  
  public final void a(@NotNull Context paramContext, @Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    if (paramBaseQQAppInterface != null)
    {
      Object localObject = LayoutInflater.from(paramContext).inflate(2131561073, null);
      if (localObject != null)
      {
        localObject = (LinearLayout)localObject;
        ((ImageView)((LinearLayout)localObject).findViewById(2131369528)).setOnClickListener((View.OnClickListener)new ColdPalaceTipDialog.init..inlined.let.lambda.1(this, paramContext, paramString1, paramString2, paramBaseQQAppInterface, paramInt));
        setOnCancelListener((DialogInterface.OnCancelListener)ColdPalaceTipDialog.init.1.2.a);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((LinearLayout)localObject).findViewById(2131379595));
        ((Button)((LinearLayout)localObject).findViewById(2131363863)).setOnClickListener((View.OnClickListener)new ColdPalaceTipDialog.init..inlined.let.lambda.2(this, paramContext, paramString1, paramString2, paramBaseQQAppInterface, paramInt));
        paramContext = ((LinearLayout)localObject).findViewById(2131364801);
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "contentView.findViewById(R.id.cold_palace)");
        ((URLImageView)paramContext).setImageURL("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png");
        setContentView((View)localObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog
 * JD-Core Version:    0.7.0.1
 */