package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "btnSwitchOn", "Landroid/widget/Button;", "getBtnSwitchOn", "()Landroid/widget/Button;", "btnSwitchOn$delegate", "Lkotlin/Lazy;", "ivClose", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose$delegate", "loadingDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "manager", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "getManager", "()Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "manager$delegate", "initView", "", "onModeChangeComplete", "isSuccess", "", "targetType", "", "oldType", "message", "", "onModeChangeStart", "onModeSwitching", "onSelectModeRecover", "onSwitchClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class StudyModeSwitchDialog
  extends ReportDialog
  implements ModeSwitchManager.OnModeChangeResultCallback
{
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private final Lazy jdField_a_of_type_KotlinLazy;
  private final Lazy b;
  private final Lazy c;
  
  public StudyModeSwitchDialog(@NotNull BaseActivity paramBaseActivity)
  {
    super((Context)paramBaseActivity, 2131755340);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new StudyModeSwitchDialog.ivClose.2(this));
    this.b = LazyKt.lazy((Function0)new StudyModeSwitchDialog.btnSwitchOn.2(this));
    this.c = LazyKt.lazy((Function0)new StudyModeSwitchDialog.manager.2(this));
    paramBaseActivity = getWindow();
    if (paramBaseActivity != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramBaseActivity.addFlags(67108864);
      }
      ImmersiveUtils.clearCoverForStatus(paramBaseActivity, true);
    }
    setContentView(2131558908);
    a();
    a().a((ModeSwitchManager.OnModeChangeResultCallback)this);
    ReportController.b((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD4", "0X800ADD4", 0, 0, "", "", "", "");
  }
  
  private final Button a()
  {
    return (Button)this.b.getValue();
  }
  
  private final ImageView a()
  {
    return (ImageView)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final ModeSwitchManager a()
  {
    return (ModeSwitchManager)this.c.getValue();
  }
  
  private final void a()
  {
    a().setOnClickListener((View.OnClickListener)new StudyModeSwitchDialog.initView.1(this));
    a().setOnClickListener((View.OnClickListener)new StudyModeSwitchDialog.initView.2(this));
    setOnDismissListener((DialogInterface.OnDismissListener)new StudyModeSwitchDialog.initView.3(this));
  }
  
  private final void b()
  {
    if (a().a())
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131718855, 0).a();
      return;
    }
    if (ModeConstantsKt.a() == 2)
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719268, 0).a();
      dismiss();
      return;
    }
    int i = SimpleUIUtil.f();
    ModeSwitchManager.SwitchingStatus localSwitchingStatus = a().a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, i, true);
    if ((!localSwitchingStatus.a()) && (localSwitchingStatus.a() == localSwitchingStatus.b()))
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719268, 0).a();
      dismiss();
    }
    ReportController.b((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD5", "0X800ADD5", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    paramString = (CharSequence)paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Context localContext = (Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (paramBoolean) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
      QQToast.a(localContext, paramInt1, paramString, 0).a();
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    dismiss();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    ModeSwitchManager.OnModeChangeResultCallback.DefaultImpls.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    ModeSwitchManager.OnModeChangeResultCallback.DefaultImpls.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing() == true))
    {
      localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null) {
        localQQProgressDialog.dismiss();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog == null) {
      Intrinsics.throwNpe();
    }
    Window localWindow = localQQProgressDialog.getWindow();
    if (localWindow != null) {
      localWindow.setDimAmount(0.0F);
    }
    localQQProgressDialog.show();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131718855, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialog
 * JD-Core Version:    0.7.0.1
 */