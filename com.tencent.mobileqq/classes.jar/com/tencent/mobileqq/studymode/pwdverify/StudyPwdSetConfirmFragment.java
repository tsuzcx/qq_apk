package com.tencent.mobileqq.studymode.pwdverify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.KidModeUtils;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.ModeSwitchManager.OnModeChangeResultCallback;
import com.tencent.mobileqq.studymode.ModeSwitchManager.SwitchingStatus;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class StudyPwdSetConfirmFragment
  extends StudyPwdBaseFragment
  implements ModeSwitchManager.OnModeChangeResultCallback
{
  public boolean b = false;
  private Button c;
  private View d;
  private String e;
  private int f;
  private ModeSwitchManager g;
  private QQAppInterface h;
  private KidModeObserver i = new StudyPwdSetConfirmFragment.2(this);
  
  private void m()
  {
    if (this.h == null)
    {
      QLog.i("StudyPwdSetConfirmFragment", 1, "gotoSetPwd mApp == null");
      return;
    }
    String str1 = d();
    if (str1.length() != 4) {
      return;
    }
    if (str1.equals(this.e))
    {
      if (!g()) {
        return;
      }
      String str2 = StudyModeManager.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNewPassword pwd=");
      localStringBuilder.append(KidModeUtils.a(str1));
      localStringBuilder.append(",salt=");
      localStringBuilder.append(KidModeUtils.a(str2));
      QLog.i("StudyPwdSetConfirmFragment", 1, localStringBuilder.toString());
      KidModeServlet.a(this.h, str1, str2);
      h();
    }
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    if (this.d == null) {
      this.d = getLayoutInflater().inflate(2131627864, paramViewGroup, false);
    }
    if (this.c == null)
    {
      paramViewGroup = this.d;
      if (paramViewGroup != null)
      {
        this.c = ((Button)paramViewGroup.findViewById(2131430116));
        this.c.setOnClickListener(new StudyPwdSetConfirmFragment.1(this));
        this.c.setEnabled(false);
      }
    }
    return this.d;
  }
  
  protected String a()
  {
    return BaseApplicationImpl.getContext().getString(2131897398);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show();
  }
  
  protected void a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_is_jump_to_next", true);
    int j;
    if (paramBoolean) {
      j = -1;
    } else {
      j = 0;
    }
    paramActivity.setResult(j, localIntent);
    paramActivity.finish();
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode mModeSwitchManager == null)");
      i();
      return;
    }
    if (((ModeSwitchManager)localObject).c())
    {
      QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode isSwitching()");
      a(2131916387, 0);
      i();
      return;
    }
    if (StudyModeManager.h())
    {
      QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode getStudyModeSwitch()");
      i();
      a(paramQBaseActivity, true);
      return;
    }
    int j = SimpleUIUtil.i();
    localObject = this.g.a(paramQBaseActivity, 2, j, true);
    if ((!((ModeSwitchManager.SwitchingStatus)localObject).a()) && (((ModeSwitchManager.SwitchingStatus)localObject).b() == ((ModeSwitchManager.SwitchingStatus)localObject).c())) {
      a(paramQBaseActivity, true);
    }
    paramQBaseActivity = new StringBuilder();
    paramQBaseActivity.append("setKidMode isSwitching=");
    paramQBaseActivity.append(((ModeSwitchManager.SwitchingStatus)localObject).a());
    paramQBaseActivity.append(",targetMode=");
    paramQBaseActivity.append(((ModeSwitchManager.SwitchingStatus)localObject).b());
    paramQBaseActivity.append(",oldMode=");
    paramQBaseActivity.append(((ModeSwitchManager.SwitchingStatus)localObject).c());
    QLog.i("StudyPwdSetConfirmFragment", 1, paramQBaseActivity.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("onModeChangeComplete isSuccess : ");
    paramString.append(paramBoolean);
    paramString.append(", curType : ");
    paramString.append(paramInt1);
    paramString.append(", oldType : ");
    paramString.append(paramInt2);
    QLog.i("StudyPwdSetConfirmFragment", 1, paramString.toString());
    paramString = getQBaseActivity();
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      i();
      if (paramBoolean)
      {
        a(paramString, true);
        return;
      }
      a(paramString, false);
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeComplete activity == null || activity.isFinishing()");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.c == null) {
      return;
    }
    if (paramString.length() == 4)
    {
      if (!paramString.equals(this.e))
      {
        a(BaseApplicationImpl.getContext().getString(2131897400));
        ReportController.b(this.h, "dc00898", "", "", "0X800BD44", "0X800BD44", 0, 0, "", "", "", "");
        return;
      }
      this.c.setEnabled(true);
      return;
    }
    this.c.setEnabled(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString) {}
  
  protected String b()
  {
    return BaseApplicationImpl.getContext().getString(2131897397);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onModeChangeStart curType : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", oldType : ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
    localObject = getQBaseActivity();
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing())) {
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeStart activity == null || activity.isFinishing()");
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSelectModeRecover curType : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", oldType : ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
    localObject = getQBaseActivity();
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      i();
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onSelectModeRecover activity == null || activity.isFinishing()");
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onModeSwitching curType : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", oldType : ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
    localObject = getQBaseActivity();
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      a(2131916387, 0);
      i();
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onSelectModeRecover activity == null || activity.isFinishing()");
  }
  
  public void onCreate(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity() != null)
    {
      this.e = getActivity().getIntent().getStringExtra("key_previous_pwd");
      this.f = getActivity().getIntent().getIntExtra("ExtraTargetAction", -1);
    }
    a("0X800BD41", this.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.h != null)
    {
      localObject = this.g;
      if (localObject != null) {
        ((ModeSwitchManager)localObject).b(this);
      }
      this.h.unRegistObserver(this.i);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy mApp=");
    boolean bool;
    if (this.h == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewCreated(@NonNull View paramView, @androidx.annotation.Nullable Bundle paramBundle)
  {
    Object localObject = f();
    if ((localObject instanceof QQAppInterface)) {
      this.h = ((QQAppInterface)localObject);
    }
    localObject = this.h;
    if (localObject != null)
    {
      this.g = ((ModeSwitchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER));
      this.g.a(this);
      this.h.registObserver(this.i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onViewCreated mAction=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(",mApp=");
    boolean bool;
    if (this.h == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetConfirmFragment
 * JD-Core Version:    0.7.0.1
 */