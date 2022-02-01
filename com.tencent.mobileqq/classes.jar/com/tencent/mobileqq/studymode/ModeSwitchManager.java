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
  private final String a;
  private final List<ModeSwitchManager.OnModeChangeResultCallback> b;
  private QQCustomDialog c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private final SimpleUIObserver k;
  private final QQAppInterface l;
  
  public ModeSwitchManager(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.l = paramQQAppInterface;
    this.a = "GeneralModeSwitcherManager";
    this.b = ((List)new ArrayList());
    this.d = -1;
    this.e = -1;
    this.f = -1;
    this.h = true;
    this.k = ((SimpleUIObserver)new ModeSwitchManager.simpleUIObserver.1(this));
    this.l.addObserver((BusinessObserver)this.k);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.g = true;
    Object localObject = this.l.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
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
      if (!((SimpleUIHandler)localObject).b(bool1, paramInt1, paramBoolean, bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "doChangeMode switching");
        }
        QQToast.makeText((Context)BaseApplication.getContext(), 0, 2131916388, 0).show();
        localObject = ((Iterable)this.b).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ModeSwitchManager.OnModeChangeResultCallback)((Iterator)localObject).next()).d(this.d, this.e);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "doChangeMode switch start");
      }
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt1;
      localObject = ((Iterable)this.b).iterator();
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
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext()) {
      ((ModeSwitchManager.OnModeChangeResultCallback)localIterator.next()).a(paramBoolean, this.d, this.e, paramString);
    }
    if ((paramBoolean) && ((this.d == 2) || (this.e == 2))) {
      SharedPreUtils.a((Context)BaseApplicationImpl.context, this.l.getCurrentAccountUin(), true, "study_mode_has_change", Boolean.valueOf(true));
    }
  }
  
  private final void d(boolean paramBoolean)
  {
    int m = this.d;
    if (m != 1)
    {
      if (m != 2) {
        m = 2131889984;
      } else {
        m = 2131889991;
      }
    }
    else {
      m = 2131889988;
    }
    String str = HardCodeUtil.a(m);
    if (paramBoolean) {
      str = BaseApplicationImpl.getContext().getString(2131891830, new Object[] { str });
    } else {
      str = BaseApplicationImpl.getContext().getString(2131891832, new Object[] { str });
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "message");
    a(paramBoolean, str);
  }
  
  private final void e()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndReportStockStudyMode -> studyModePullStatus : ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(", studentFlagPullStatus : ");
      localStringBuilder.append(this.j);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.i == 1) && (this.j != 0))
    {
      boolean bool1 = StudyModeManager.i();
      boolean bool2 = f();
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndReportStockStudyMode -> configSwitch : ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", isSameDay ： ");
        localStringBuilder.append(bool2);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if ((bool1) && (!bool2))
      {
        int m;
        if (this.j == 1) {
          m = 1;
        } else {
          m = 2;
        }
        if (QLog.isColorLevel())
        {
          localObject = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAndReportStockStudyMode ReportController 0X800AD6C ， identity ： ");
          localStringBuilder.append(m);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
        SharedPreUtils.a((Context)BaseApplicationImpl.context, this.l.getCurrentAccountUin(), true, "study_mode_last_report_time", ((SimpleDateFormat)localObject).format(new Date()));
        ReportController.b((AppRuntime)this.l, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, m, "", "", "", "");
      }
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = BaseApplicationImpl.getContext().getString(2131891831);
      Intrinsics.checkExpressionValueIsNotNull(str, "BaseApplicationImpl.getC…mode_operation_open_fail)");
      a(false, str);
      return;
    }
    a(true, "");
  }
  
  private final boolean f()
  {
    Object localObject1 = (String)SharedPreUtils.b((Context)BaseApplicationImpl.context, this.l.getCurrentAccountUin(), "study_mode_last_report_time", "");
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
  
  public final int a()
  {
    return this.d;
  }
  
  @NotNull
  public final ModeSwitchManager.SwitchingStatus a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("changeMode targetType: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", bPref : ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int m = ModeConstantsKt.a();
    if ((!this.g) && ((m != paramInt1) || (paramInt2 != this.f)))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.makeText((Context)BaseApplication.getContext(), 1, 2131892157, 0).show();
        paramActivity = ((Iterable)this.b).iterator();
        while (paramActivity.hasNext()) {
          ((ModeSwitchManager.OnModeChangeResultCallback)paramActivity.next()).c(paramInt1, m);
        }
        return new ModeSwitchManager.SwitchingStatus(false, paramInt1, m);
      }
      if (paramInt1 == 1)
      {
        localObject1 = ThemeUtil.getUinThemePreferences((AppRuntime)this.l);
        if (((SharedPreferences)localObject1).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject1).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject1 = (DialogInterface.OnClickListener)new ModeSwitchManager.changeMode.doSwitchLis.1(this, paramInt2, paramInt1, m, paramBoolean);
          localObject2 = this.c;
          if (localObject2 != null) {
            ((QQCustomDialog)localObject2).dismiss();
          }
          this.c = DialogUtil.a(paramActivity, BaseApplicationImpl.getContext().getString(2131916383), 0, 2131916381, (DialogInterface.OnClickListener)localObject1, null);
          paramActivity = this.c;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.setOnDismissListener((DialogInterface.OnDismissListener)new ModeSwitchManager.changeMode.2(this, paramInt1, m));
          paramActivity = this.c;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.show();
        }
        else
        {
          a(paramInt2, paramInt1, m, paramBoolean);
        }
      }
      else
      {
        a(paramInt2, paramInt1, m, paramBoolean);
      }
      return new ModeSwitchManager.SwitchingStatus(true, paramInt1, m);
    }
    return new ModeSwitchManager.SwitchingStatus(this.g, paramInt1, m);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt2;
    this.f = paramInt1;
    this.g = false;
  }
  
  public final void a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showModeSwitchDialog studyModePullStatus : ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" , studentFlagPullStatus : ");
      localStringBuilder.append(this.j);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.h)
    {
      boolean bool;
      if ((this.i != 0) && (this.j != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      this.h = bool;
      if ((this.i == 2) && (this.j == 1) && (StudyModeManager.j()))
      {
        localObject = (Context)paramBaseActivity;
        if ((!((Boolean)SharedPreUtils.b((Context)localObject, this.l.getCurrentAccountUin(), "study_mode_has_change", Boolean.valueOf(false))).booleanValue()) && (!((Boolean)SharedPreUtils.b((Context)localObject, this.l.getCurrentAccountUin(), "study_mode_change_dialog_has_show", Boolean.valueOf(false))).booleanValue()))
        {
          new StudyModeSwitchDialog(paramBaseActivity).show();
          SharedPreUtils.a((Context)BaseApplicationImpl.context, this.l.getCurrentAccountUin(), true, "study_mode_change_dialog_has_show", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public final void a(@Nullable ModeSwitchManager.OnModeChangeResultCallback paramOnModeChangeResultCallback)
  {
    if (paramOnModeChangeResultCallback != null) {
      this.b.add(paramOnModeChangeResultCallback);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchUICallBack targetType : ");
      localStringBuilder.append(this.d);
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
  
  public final int b()
  {
    return this.f;
  }
  
  public final void b(@Nullable ModeSwitchManager.OnModeChangeResultCallback paramOnModeChangeResultCallback)
  {
    if ((paramOnModeChangeResultCallback != null) && (this.b.contains(paramOnModeChangeResultCallback))) {
      this.b.remove(paramOnModeChangeResultCallback);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int m = 2;
    if (bool)
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStudyModePullComplete isStudy : ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    KidModeUtils.a("INIT", this.l);
    if (paramBoolean) {
      m = 1;
    }
    this.i = m;
    e();
    StudyModeManager.l();
    Object localObject = this.l.getRuntimeService(IOnlineStatusManagerService.class, "");
    if (localObject != null)
    {
      ((IOnlineStatusDataManager)((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class)).a(paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService");
  }
  
  public final void c(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int m = 2;
    if (bool)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStudentFlagPullComplete isStudent : ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      m = 1;
    }
    this.j = m;
    e();
  }
  
  public final boolean c()
  {
    return this.g;
  }
  
  public final void d()
  {
    QQCustomDialog localQQCustomDialog = this.c;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.setOnDismissListener(null);
    }
    localQQCustomDialog = this.c;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.c = ((QQCustomDialog)null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onDestroy");
    }
    this.l.removeObserver((BusinessObserver)this.k);
    d();
    this.b.clear();
    this.d = -1;
    this.e = -1;
    this.g = false;
    this.h = false;
    this.i = 0;
    this.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeSwitchManager
 * JD-Core Version:    0.7.0.1
 */