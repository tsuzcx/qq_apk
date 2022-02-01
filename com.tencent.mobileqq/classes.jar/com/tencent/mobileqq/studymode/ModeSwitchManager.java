package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "Lmqq/manager/Manager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "bPref", "", "getBPref", "()I", "setBPref", "(I)V", "isSwitching", "", "()Z", "setSwitching", "(Z)V", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "needCheckShowModeSwitchDialog", "oldType", "getOldType", "setOldType", "onModeChangeResultCallbacks", "", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "simpleUIObserver", "Lcom/tencent/mobileqq/simpleui/SimpleUIObserver;", "studentFlagPullStatus", "studyModePullStatus", "tag", "", "targetType", "getTargetType", "setTargetType", "addCallback", "", "onModeChangeResultCallback", "changeMode", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$SwitchingStatus;", "activity", "Landroid/app/Activity;", "bSwitchElsePref", "checkAndReportStockStudyMode", "doChangeMode", "endChangebPref", "isSameDayWithLastReport", "onChangeStudyModeComplete", "isSuc", "message", "onColorfulChangeResult", "onDestroy", "onModeChangeResult", "onStudentFlagPullComplete", "isStudent", "onStudyModePullComplete", "isStudy", "onSwitchUICallBackInManager", "bChangeTheme", "statusCode", "releaseDialog", "removeCallback", "showModeSwitchDialog", "Lcom/tencent/mobileqq/app/BaseActivity;", "OnModeChangeResultCallback", "SwitchingStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ModeSwitchManager
  implements Manager
{
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final SimpleUIObserver jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final String jdField_a_of_type_JavaLangString;
  private final List<ModeSwitchManager.OnModeChangeResultCallback> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public ModeSwitchManager(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = "GeneralModeSwitcherManager";
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver = ((SimpleUIObserver)new ModeSwitchManager.simpleUIObserver.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
    if (localObject != null)
    {
      localObject = (SimpleUIHandler)localObject;
      boolean bool1;
      if (paramInt2 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramInt2 != 2) {
        bool2 = false;
      }
      if (!((SimpleUIHandler)localObject).a(bool1, paramInt1, paramBoolean, bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doChangeMode switching");
        }
        QQToast.a((Context)BaseApplication.getContext(), 0, 2131718856, 0).a();
        localObject = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ModeSwitchManager.OnModeChangeResultCallback)((Iterator)localObject).next()).d(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doChangeMode switch start");
      }
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_b_of_type_Int = paramInt3;
      this.c = paramInt1;
      localObject = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ModeSwitchManager.OnModeChangeResultCallback)((Iterator)localObject).next()).b(paramInt2, paramInt3);
      }
      return;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((ModeSwitchManager.OnModeChangeResultCallback)localIterator.next()).a(paramBoolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramString);
    }
    if ((paramBoolean) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_b_of_type_Int == 2))) {
      SharedPreUtils.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_has_change", Boolean.valueOf(true));
    }
  }
  
  private final void b()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndReportStockStudyMode -> studyModePullStatus : ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", studentFlagPullStatus : ");
      localStringBuilder.append(this.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.d == 1) && (this.e != 0))
    {
      boolean bool1 = StudyModeManager.b();
      boolean bool2 = b();
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndReportStockStudyMode -> configSwitch : ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", isSameDay ： ");
        localStringBuilder.append(bool2);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if ((bool1) && (!bool2))
      {
        int i;
        if (this.e == 1) {
          i = 1;
        } else {
          i = 2;
        }
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAndReportStockStudyMode ReportController 0X800AD6C ， identity ： ");
          localStringBuilder.append(i);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
        SharedPreUtils.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_last_report_time", ((SimpleDateFormat)localObject).format(new Date()));
        ReportController.b((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, i, "", "", "", "");
      }
    }
  }
  
  private final boolean b()
  {
    Object localObject1 = (String)SharedPreUtils.b((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_last_report_time", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject1);
      localObject1 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "calendarLast");
      ((Calendar)localObject1).setTime((Date)localObject2);
      localObject2 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "calendarNow");
      ((Calendar)localObject2).setTime(new Date());
      if ((((Calendar)localObject1).get(0) == ((Calendar)localObject2).get(0)) && (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1)) && (((Calendar)localObject1).get(6) == ((Calendar)localObject2).get(6))) {
        return true;
      }
    }
    return false;
  }
  
  private final void d(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2) {
        i = 2131692873;
      } else {
        i = 2131692880;
      }
    }
    else {
      i = 2131692877;
    }
    String str = HardCodeUtil.a(i);
    if (paramBoolean) {
      str = BaseApplicationImpl.getContext().getString(2131694192, new Object[] { str });
    } else {
      str = BaseApplicationImpl.getContext().getString(2131694194, new Object[] { str });
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "message");
    a(paramBoolean, str);
  }
  
  private final void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = BaseApplicationImpl.getContext().getString(2131694193);
      Intrinsics.checkExpressionValueIsNotNull(str, "BaseApplicationImpl.getC…mode_operation_open_fail)");
      a(false, str);
      return;
    }
    a(true, "");
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final ModeSwitchManager.SwitchingStatus a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("changeMode targetType: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", bPref : ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i = ModeConstantsKt.a();
    if ((!this.jdField_a_of_type_Boolean) && ((i != paramInt1) || (paramInt2 != this.c)))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.a((Context)BaseApplication.getContext(), 1, 2131694475, 0).a();
        paramActivity = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
        while (paramActivity.hasNext()) {
          ((ModeSwitchManager.OnModeChangeResultCallback)paramActivity.next()).c(paramInt1, i);
        }
        return new ModeSwitchManager.SwitchingStatus(false, paramInt1, i);
      }
      if (paramInt1 == 1)
      {
        localObject1 = ThemeUtil.getUinThemePreferences((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((SharedPreferences)localObject1).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject1).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject1 = (DialogInterface.OnClickListener)new ModeSwitchManager.changeMode.doSwitchLis.1(this, paramInt2, paramInt1, i, paramBoolean);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (localObject2 != null) {
            ((QQCustomDialog)localObject2).dismiss();
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, BaseApplicationImpl.getContext().getString(2131718851), 0, 2131718849, (DialogInterface.OnClickListener)localObject1, null);
          paramActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.setOnDismissListener((DialogInterface.OnDismissListener)new ModeSwitchManager.changeMode.2(this, paramInt1, i));
          paramActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.show();
        }
        else
        {
          a(paramInt2, paramInt1, i, paramBoolean);
        }
      }
      else
      {
        a(paramInt2, paramInt1, i, paramBoolean);
      }
      return new ModeSwitchManager.SwitchingStatus(true, paramInt1, i);
    }
    return new ModeSwitchManager.SwitchingStatus(this.jdField_a_of_type_Boolean, paramInt1, i);
  }
  
  public final void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.setOnDismissListener(null);
    }
    localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)null);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.c = paramInt1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showModeSwitchDialog studyModePullStatus : ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" , studentFlagPullStatus : ");
      localStringBuilder.append(this.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      boolean bool;
      if ((this.d != 0) && (this.e != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
      if ((this.d == 2) && (this.e == 1) && (StudyModeManager.c()))
      {
        localObject = (Context)paramBaseActivity;
        if ((!((Boolean)SharedPreUtils.b((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_has_change", Boolean.valueOf(false))).booleanValue()) && (!((Boolean)SharedPreUtils.b((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_change_dialog_has_show", Boolean.valueOf(false))).booleanValue()))
        {
          new StudyModeSwitchDialog(paramBaseActivity).show();
          SharedPreUtils.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_change_dialog_has_show", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public final void a(@Nullable ModeSwitchManager.OnModeChangeResultCallback paramOnModeChangeResultCallback)
  {
    if (paramOnModeChangeResultCallback != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnModeChangeResultCallback);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchUICallBack targetType : ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", isSuc : ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" , bChangeTheme : ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", bSwitchElsePref : ");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(" , statusCode : ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean3)
    {
      d(paramBoolean1);
      return;
    }
    e(paramBoolean1);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(@Nullable ModeSwitchManager.OnModeChangeResultCallback paramOnModeChangeResultCallback)
  {
    if ((paramOnModeChangeResultCallback != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramOnModeChangeResultCallback))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnModeChangeResultCallback);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStudyModePullComplete isStudy : ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    KidModeUtils.a("INIT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean) {
      i = 1;
    }
    this.d = i;
    b();
    StudyModeManager.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "");
    if (localObject != null)
    {
      ((IOnlineStatusDataManager)((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class)).b(paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService");
  }
  
  public final void c(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStudentFlagPullComplete isStudent : ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      i = 1;
    }
    this.e = i;
    b();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
    a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.d = 0;
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeSwitchManager
 * JD-Core Version:    0.7.0.1
 */