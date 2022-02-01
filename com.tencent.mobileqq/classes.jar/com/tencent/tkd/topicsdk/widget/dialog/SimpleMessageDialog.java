package com.tencent.tkd.topicsdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.content.ContextCompat;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.style;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/SimpleMessageDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearIconView", "Landroid/widget/ImageView;", "contentView", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "value", "", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countLimitView", "Landroid/widget/TextView;", "", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "lastContent", "getLastContent", "setLastContent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "type", "", "onDismissListener", "getOnDismissListener", "()Lkotlin/jvm/functions/Function2;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function2;)V", "publishTextView", "rootView", "Landroid/view/View;", "onAttachedToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "updatePublishLayoutStyle", "isValid", "", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SimpleMessageDialog
  extends Dialog
{
  public static final SimpleMessageDialog.Companion a;
  private int jdField_a_of_type_Int = 14;
  private final View jdField_a_of_type_AndroidViewView;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final RichEditText jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private Function2<? super String, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_b_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog$Companion = new SimpleMessageDialog.Companion(null);
  }
  
  public SimpleMessageDialog(@NotNull Context paramContext)
  {
    super(paramContext, R.style.b);
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.e, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…log_simple_message, null)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidViewView;
    View localView = paramContext.findViewById(R.id.v);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.et_content)");
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText = ((RichEditText)localView);
    localView = paramContext.findViewById(R.id.X);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.iv_clear)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramContext.findViewById(R.id.aW);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.tv_count_limit)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    paramContext = paramContext.findViewById(R.id.bd);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_publish)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setCountChangeListener((Function1)new SimpleMessageDialog..special..inlined.with.lambda.1(this));
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setNeedTextTruncation(true);
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setOnEditorActionListener((TextView.OnEditorActionListener)new SimpleMessageDialog..special..inlined.with.lambda.2(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new SimpleMessageDialog..special..inlined.with.lambda.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  private final void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = R.color.h;
    } else {
      i = R.color.g;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(ContextCompat.getColor(getContext(), i));
    if (paramBoolean) {
      i = R.color.f;
    } else {
      i = R.color.e;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(ContextCompat.getColor(getContext(), i));
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setCountLimit(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)String.valueOf(paramInt - this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.getText().length()));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setHint((CharSequence)paramString);
  }
  
  public final void a(@Nullable Function2<? super String, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)new SimpleMessageDialog.onDismissListener.1(this, paramFunction2));
    setOnCancelListener((DialogInterface.OnCancelListener)new SimpleMessageDialog.onDismissListener.2(this, paramFunction2));
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.setText((CharSequence)this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.postDelayed((Runnable)new SimpleMessageDialog.onAttachedToWindow.1(this), 300L);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    }
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAttributes();
      if (paramBundle != null)
      {
        paramBundle.width = -1;
        paramBundle.height = -2;
        paramBundle.gravity = 80;
        break label62;
      }
    }
    paramBundle = null;
    label62:
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setAttributes(paramBundle);
    }
    setCanceledOnTouchOutside(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog
 * JD-Core Version:    0.7.0.1
 */