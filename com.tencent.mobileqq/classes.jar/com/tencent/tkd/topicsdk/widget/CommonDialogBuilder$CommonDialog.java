package com.tencent.tkd.topicsdk.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$CommonDialog;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSplitLine", "Landroid/view/View;", "customContentView", "getCustomContentView", "()Landroid/view/View;", "setCustomContentView", "(Landroid/view/View;)V", "isForbidBackPress", "", "()Z", "setForbidBackPress", "(Z)V", "mContentLayout", "Landroid/widget/RelativeLayout;", "mMessage", "", "mMessageView", "Landroid/widget/TextView;", "mNegativeButton", "mPositiveButton", "mTitleView", "messageTextClickAction", "Lkotlin/Function0;", "", "getMessageTextClickAction", "()Lkotlin/jvm/functions/Function0;", "setMessageTextClickAction", "(Lkotlin/jvm/functions/Function0;)V", "messageViewGravity", "", "getMessageViewGravity", "()Ljava/lang/Integer;", "setMessageViewGravity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "negativeButtonCallback", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "getNegativeButtonCallback", "()Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "setNegativeButtonCallback", "(Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;)V", "negativeButtonMessage", "", "getNegativeButtonMessage", "()Ljava/lang/String;", "setNegativeButtonMessage", "(Ljava/lang/String;)V", "negativeButtonTextColor", "getNegativeButtonTextColor", "setNegativeButtonTextColor", "positiveButtonCallback", "getPositiveButtonCallback", "setPositiveButtonCallback", "positiveButtonMessage", "getPositiveButtonMessage", "setPositiveButtonMessage", "positiveButtonTextColor", "getPositiveButtonTextColor", "setPositiveButtonTextColor", "title", "getTitle", "setTitle", "titleTextColor", "getTitleTextColor", "setTitleTextColor", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "message", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class CommonDialogBuilder$CommonDialog
  extends AlertDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private CommonDialogBuilder.ICommonDialogListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  @Nullable
  private Integer jdField_a_of_type_JavaLangInteger;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private CommonDialogBuilder.ICommonDialogListener jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  @Nullable
  private Integer jdField_b_of_type_JavaLangInteger;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  @Nullable
  private Integer jdField_c_of_type_JavaLangInteger;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  @Nullable
  private Integer jdField_d_of_type_JavaLangInteger;
  
  public CommonDialogBuilder$CommonDialog(@NotNull Context paramContext)
  {
    super(paramContext, R.style.a);
  }
  
  @Nullable
  public final CommonDialogBuilder.ICommonDialogListener a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  }
  
  public final void a(@Nullable View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public final void a(@Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener = paramICommonDialogListener;
  }
  
  public final void a(@Nullable Integer paramInteger)
  {
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @Nullable
  public final CommonDialogBuilder.ICommonDialogListener b()
  {
    return this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  }
  
  public final void b(@Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener = paramICommonDialogListener;
  }
  
  public final void b(@Nullable Integer paramInteger)
  {
    this.jdField_b_of_type_JavaLangInteger = paramInteger;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void c(@Nullable Integer paramInteger)
  {
    this.jdField_c_of_type_JavaLangInteger = paramInteger;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void d(@Nullable Integer paramInteger)
  {
    this.jdField_d_of_type_JavaLangInteger = paramInteger;
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.a);
    paramBundle = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.contentLayout)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.f));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.c));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.e));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.d));
    paramBundle = findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.bottomSplitLine)");
    this.jdField_a_of_type_AndroidViewView = paramBundle;
    int i;
    label247:
    Object localObject;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
    {
      paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)this.jdField_a_of_type_JavaLangString);
      }
      paramBundle = this.jdField_a_of_type_JavaLangInteger;
      if (paramBundle != null)
      {
        i = ((Number)paramBundle).intValue();
        paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramBundle != null) {
          paramBundle.setTextColor(i);
        }
      }
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
      }
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setHighlightColor(0);
      }
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break label464;
      }
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
      }
      paramBundle.addView(this.jdField_b_of_type_AndroidViewView);
      paramBundle = this.jdField_b_of_type_JavaLangString;
      if (paramBundle == null) {
        break label584;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label579;
      }
      i = 1;
      label270:
      if (i == 0) {
        break label584;
      }
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramBundle);
      }
      paramBundle = this.jdField_c_of_type_JavaLangInteger;
      if (paramBundle != null)
      {
        i = ((Number)paramBundle).intValue();
        paramBundle = this.jdField_d_of_type_AndroidWidgetTextView;
        if (paramBundle != null) {
          paramBundle.setTextColor(i);
        }
      }
      label322:
      paramBundle = this.jdField_d_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new CommonDialogBuilder.CommonDialog.onCreate.3(this));
      }
      paramBundle = this.jdField_c_of_type_JavaLangString;
      if (paramBundle == null) {
        break label632;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label627;
      }
      i = 1;
      label369:
      if (i == 0) {
        break label632;
      }
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramBundle);
      }
      paramBundle = this.jdField_b_of_type_JavaLangInteger;
      if (paramBundle != null)
      {
        i = ((Number)paramBundle).intValue();
        paramBundle = this.jdField_c_of_type_AndroidWidgetTextView;
        if (paramBundle != null) {
          paramBundle.setTextColor(i);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new CommonDialogBuilder.CommonDialog.onCreate.5(this));
      }
      return;
      paramBundle = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label464:
      paramBundle = this.jdField_a_of_type_JavaLangCharSequence;
      if ((paramBundle == null) || (paramBundle.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label511;
        }
        paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
        if (paramBundle == null) {
          break;
        }
        paramBundle.setVisibility(8);
        break;
      }
      label511:
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      paramBundle = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramBundle == null) {
        break label247;
      }
      localObject = this.jdField_d_of_type_JavaLangInteger;
      if (localObject != null) {}
      for (i = ((Integer)localObject).intValue();; i = 17)
      {
        paramBundle.setGravity(i);
        break;
      }
      label579:
      i = 0;
      break label270;
      label584:
      paramBundle = this.jdField_d_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)"");
      }
      paramBundle = this.jdField_a_of_type_AndroidViewView;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSplitLine");
      }
      paramBundle.setVisibility(8);
      break label322;
      label627:
      i = 0;
      break label369;
      label632:
      paramBundle = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.jdField_a_of_type_AndroidViewView;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomSplitLine");
      }
      paramBundle.setVisibility(8);
    }
  }
  
  public void setMessage(@Nullable CharSequence paramCharSequence)
  {
    super.setMessage(paramCharSequence);
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.CommonDialog
 * JD-Core Version:    0.7.0.1
 */