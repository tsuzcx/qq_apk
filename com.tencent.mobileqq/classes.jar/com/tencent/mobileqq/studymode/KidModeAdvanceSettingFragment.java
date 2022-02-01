package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class KidModeAdvanceSettingFragment
  extends IphoneTitleBarFragment
{
  private QQAppInterface a;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormMultiLineSwitchItem e;
  private boolean f = false;
  private boolean g = false;
  private KidModeObserver h = new KidModeAdvanceSettingFragment.1(this);
  private CompoundButton.OnCheckedChangeListener i = new KidModeAdvanceSettingFragment.2(this);
  private CompoundButton.OnCheckedChangeListener j = new KidModeAdvanceSettingFragment.8(this);
  private CompoundButton.OnCheckedChangeListener k = new KidModeAdvanceSettingFragment.9(this);
  private CompoundButton.OnCheckedChangeListener l = new KidModeAdvanceSettingFragment.10(this);
  
  private void a()
  {
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131436794));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131436795));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131436796));
    this.e = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131436793));
    b();
    c();
  }
  
  private void a(int paramInt)
  {
    if (this.g)
    {
      this.g = false;
      KidModeServlet.a(this.a, 1);
      return;
    }
    int m = StudyModeManager.e();
    boolean bool;
    if (m == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 1, new Object[] { "isBindPhoneStatus: ", Integer.valueOf(m), ", setUrl: ", StudyModeManager.g() });
    }
    if (this.f)
    {
      if (this.e.a())
      {
        c(paramInt);
        return;
      }
      b(paramInt);
      return;
    }
    d();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAdvanceSettingSwitch mask: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", isChecked: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener;
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 32)
          {
            localOnCheckedChangeListener = null;
          }
          else
          {
            localObject = this.c;
            localOnCheckedChangeListener = this.k;
          }
        }
        else
        {
          localObject = this.b;
          localOnCheckedChangeListener = this.j;
        }
      }
      else
      {
        localObject = this.d;
        localOnCheckedChangeListener = this.l;
      }
    }
    else
    {
      localObject = this.e;
      localOnCheckedChangeListener = this.i;
    }
    if (localObject != null)
    {
      ((FormSwitchItem)localObject).setEnabled(true);
      if (((FormSwitchItem)localObject).a() != paramBoolean) {
        a((FormSwitchItem)localObject, paramBoolean, localOnCheckedChangeListener);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.a(paramContext, localIntent, KidModeAdvanceSettingFragment.class);
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
  }
  
  private void b()
  {
    e();
  }
  
  private void b(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c()
  {
    this.e.setOnCheckedChangeListener(this.i);
    this.b.setOnCheckedChangeListener(this.j);
    this.c.setOnCheckedChangeListener(this.k);
    this.d.setOnCheckedChangeListener(this.l);
  }
  
  private void c(int paramInt)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 230).setTitle(HardCodeUtil.a(2131891104)).setMessage(getString(2131891103, new Object[] { StudyModeManager.f() })).setNegativeButton(HardCodeUtil.a(2131891126), new KidModeAdvanceSettingFragment.6(this)).setPositiveButton(HardCodeUtil.a(2131891117), new KidModeAdvanceSettingFragment.5(this, paramInt));
    localQQCustomDialog.setOnCancelListener(new KidModeAdvanceSettingFragment.7(this));
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void d()
  {
    this.g = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 230).setTitle(HardCodeUtil.a(2131892441)).setMessage(HardCodeUtil.a(2131891107)).setNegativeButton(HardCodeUtil.a(2131887626), new KidModeAdvanceSettingFragment.4(this)).setPositiveButton(HardCodeUtil.a(2131891106), new KidModeAdvanceSettingFragment.3(this));
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void e()
  {
    boolean bool1 = StudyModeManager.d(16);
    boolean bool2 = StudyModeManager.d(32);
    boolean bool3 = StudyModeManager.d(8);
    a(16, bool1);
    a(32, bool2);
    a(8, bool3);
    int m = StudyModeManager.b();
    bool1 = true;
    if ((m != 1) || (StudyModeManager.e() != 0)) {
      bool1 = false;
    }
    a(4, bool1);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((this.a != null) && ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)))
    {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
      a();
      KidModeServlet.a(this.a);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627477;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.a.registObserver(this.h);
    boolean bool;
    if (StudyModeManager.e() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131891101));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.unRegistObserver(this.h);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment
 * JD-Core Version:    0.7.0.1
 */