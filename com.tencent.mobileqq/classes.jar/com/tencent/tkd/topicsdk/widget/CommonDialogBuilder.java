package com.tencent.tkd.topicsdk.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mCancelOnTouchOutside", "", "mContentView", "Landroid/view/View;", "mIsForbidBackPress", "mMessage", "", "mMessageTextClickAction", "Lkotlin/Function0;", "", "mMessageViewGravity", "", "Ljava/lang/Integer;", "mNegativeButtonCallback", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "mNegativeButtonMessage", "", "mNegativeButtonTextColor", "mPositiveButtonCallback", "mPositiveButtonMessage", "mPositiveButtonTextColor", "mTitle", "mTitleTextColor", "cancelOnTouchOutside", "cancel", "contentView", "create", "Landroid/app/AlertDialog;", "forbidBackPress", "message", "messageTextClickAction", "block", "messageViewGravity", "gravity", "negativeButtonTextColor", "color", "negativeText", "buttonMessage", "negativeButtonCallback", "positiveButtonTextColor", "positiveText", "positiveButtonCallback", "title", "titleTextColor", "CommonDialog", "ICommonDialogListener", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class CommonDialogBuilder
{
  private int jdField_a_of_type_Int;
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private CommonDialogBuilder.ICommonDialogListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private boolean jdField_a_of_type_Boolean;
  private CommonDialogBuilder.ICommonDialogListener jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener;
  private Integer jdField_b_of_type_JavaLangInteger;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private Integer jdField_c_of_type_JavaLangInteger;
  private String jdField_c_of_type_JavaLangString;
  
  public CommonDialogBuilder(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(R.color.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
  }
  
  @NotNull
  public final AlertDialog a()
  {
    CommonDialogBuilder.CommonDialog localCommonDialog = new CommonDialogBuilder.CommonDialog(this.jdField_a_of_type_AndroidContentContext);
    localCommonDialog.a(this.jdField_a_of_type_JavaLangString);
    localCommonDialog.a(this.jdField_a_of_type_JavaLangInteger);
    localCommonDialog.setMessage(this.jdField_a_of_type_JavaLangCharSequence);
    localCommonDialog.c(this.jdField_b_of_type_JavaLangString);
    localCommonDialog.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener);
    localCommonDialog.b(Integer.valueOf(this.jdField_a_of_type_Int));
    localCommonDialog.b(this.jdField_c_of_type_JavaLangString);
    localCommonDialog.b(this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener);
    localCommonDialog.c(this.jdField_b_of_type_JavaLangInteger);
    localCommonDialog.d(this.jdField_c_of_type_JavaLangInteger);
    localCommonDialog.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction0);
    localCommonDialog.a(this.jdField_a_of_type_AndroidViewView);
    localCommonDialog.setCanceledOnTouchOutside(this.jdField_a_of_type_Boolean);
    localCommonDialog.a(this.jdField_b_of_type_Boolean);
    return (AlertDialog)localCommonDialog;
  }
  
  @NotNull
  public final CommonDialogBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@Nullable String paramString, @Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener = paramICommonDialogListener;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder b(@Nullable String paramString, @Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_ComTencentTkdTopicsdkWidgetCommonDialogBuilder$ICommonDialogListener = paramICommonDialogListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.CommonDialogBuilder
 * JD-Core Version:    0.7.0.1
 */