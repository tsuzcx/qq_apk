package com.tencent.tkd.topicsdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.style;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.common.ActivityLeakSolution;
import com.tencent.tkd.topicsdk.framework.BaseDialog;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/CommonProgressDialog;", "Lcom/tencent/tkd/topicsdk/framework/BaseDialog;", "context", "Landroid/content/Context;", "dialogStyle", "", "(Landroid/content/Context;I)V", "background", "Landroid/widget/RelativeLayout;", "frameAnimation", "Landroid/graphics/drawable/Animatable;", "isNightMode", "", "()Z", "value", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "msgTextView", "Landroid/widget/TextView;", "progressImg", "Landroid/widget/ImageView;", "rootView", "Landroid/view/View;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "showProgress", "show", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CommonProgressDialog
  extends BaseDialog
{
  public static final CommonProgressDialog.Companion a;
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private final View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog$Companion = new CommonProgressDialog.Companion(null);
  }
  
  public CommonProgressDialog(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext, R.style.a);
    if (paramInt == 2)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(R.layout.d, null);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…on_progress_center, null)");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = paramContext;
      paramContext = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.o);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.background)");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
      paramContext = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.bA);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.tv_content)");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
      paramContext = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ar);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "rootView.findViewById(R.id.iv_progress)");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
      paramContext = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if (paramContext != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Animatable");
      paramContext = LayoutInflater.from(paramContext).inflate(R.layout.c, null);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…og_common_progress, null)");
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)paramContext);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramString);
  }
  
  public boolean a()
  {
    return TopicSDK.a.a().a().a().a();
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      TLog.d("CommonProgressDialog", "dismiss exception = " + localException);
      return;
    }
    finally
    {
      ActivityLeakSolution.a.a((Dialog)this);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getAttributes();; paramBundle = null)
    {
      if (paramBundle != null) {
        paramBundle.width = -1;
      }
      if (paramBundle != null) {
        paramBundle.height = -1;
      }
      if (paramBundle != null) {
        paramBundle.gravity = 48;
      }
      Window localWindow = getWindow();
      if (localWindow != null) {
        localWindow.setAttributes(paramBundle);
      }
      setCanceledOnTouchOutside(false);
      return;
    }
  }
  
  protected void onStart()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed((Runnable)new CommonProgressDialog.onStart.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.CommonProgressDialog
 * JD-Core Version:    0.7.0.1
 */