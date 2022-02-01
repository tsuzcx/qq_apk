package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetCircleSwitchRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class KidModeAdvanceSettingFragment
  extends IphoneTitleBarFragment
{
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new KidModeAdvanceSettingFragment.2(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener = new KidModeAdvanceSettingFragment.5(this);
  private KidModeObserver jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver = new KidModeAdvanceSettingFragment.1(this);
  private FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean = false;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new KidModeAdvanceSettingFragment.12(this);
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = false;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new KidModeAdvanceSettingFragment.13(this);
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener d = new KidModeAdvanceSettingFragment.14(this);
  
  private ILebaHelperService a()
  {
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    if (localILebaHelperService == null) {
      QLog.d("IphoneTitleBarFragment", 1, "getLebaHelperService lebaHelperService == null");
    }
    return localILebaHelperService;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369684));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369685));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369686));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131369682));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131369683);
    b();
    f();
    g();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      return;
    }
    int i = StudyModeManager.b();
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 1, new Object[] { "isBindPhoneStatus: ", Integer.valueOf(i), ", setUrl: ", StudyModeManager.b() });
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.a())
      {
        c(paramInt);
        return;
      }
      b(paramInt);
      return;
    }
    h();
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
            localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            localOnCheckedChangeListener = this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          localOnCheckedChangeListener = this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
        }
      }
      else
      {
        localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        localOnCheckedChangeListener = this.d;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      localOnCheckedChangeListener = this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
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
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374459)).setText(HardCodeUtil.a(2131693549));
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131374460);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131374461)).inflate();
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131377679));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimensionPixelSize(2131296773));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT);
    c();
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
    Object localObject = a();
    int i;
    if (localObject != null) {
      i = ((ILebaHelperService)localObject).getKidModlePluginSize(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(String.format(HardCodeUtil.a(2131693548), new Object[] { String.valueOf(i) }));
    }
  }
  
  private void c(int paramInt)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 230).setTitle(HardCodeUtil.a(2131693540)).setMessage(getString(2131693539, new Object[] { StudyModeManager.a() })).setNegativeButton(HardCodeUtil.a(2131693562), new KidModeAdvanceSettingFragment.10(this)).setPositiveButton(HardCodeUtil.a(2131693553), new KidModeAdvanceSettingFragment.9(this, paramInt));
    localQQCustomDialog.setOnCancelListener(new KidModeAdvanceSettingFragment.11(this));
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void d()
  {
    Object localObject = a();
    if (localObject != null) {
      ((ILebaHelperService)localObject).checkModleAndRefesh();
    }
    if ((QzoneConfig.isQQCircleShowLebaEntrance(StudyModeManager.a())) && (QzoneConfig.isQQCircleShowSwitchButton()))
    {
      localObject = new QCircleGetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable");
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new KidModeAdvanceSettingFragment.3(this));
    }
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new KidModeAdvanceSettingFragment.4(this));
      return;
    }
    c();
  }
  
  private void f()
  {
    b();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new KidModeAdvanceSettingFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.d);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 230).setTitle(HardCodeUtil.a(2131694738)).setMessage(HardCodeUtil.a(2131693543)).setNegativeButton(HardCodeUtil.a(2131690707), new KidModeAdvanceSettingFragment.8(this)).setPositiveButton(HardCodeUtil.a(2131693542), new KidModeAdvanceSettingFragment.7(this));
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localQQCustomDialog.show();
    }
  }
  
  private void i()
  {
    boolean bool1 = StudyModeManager.b(16);
    boolean bool2 = StudyModeManager.b(32);
    boolean bool3 = StudyModeManager.b(8);
    a(16, bool1);
    a(32, bool2);
    a(8, bool3);
    int i = StudyModeManager.a();
    bool1 = true;
    if ((i != 1) || (StudyModeManager.b() != 0)) {
      bool1 = false;
    }
    a(4, bool1);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
      a();
      KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561127;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
    paramBundle = a();
    if (paramBundle != null) {
      paramBundle.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
    }
    boolean bool;
    if (StudyModeManager.b() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131693537));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
    ILebaHelperService localILebaHelperService = a();
    if (localILebaHelperService != null) {
      localILebaHelperService.removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
    }
    KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "86", "", 0, null);
  }
  
  public void onResume()
  {
    super.onResume();
    d();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment
 * JD-Core Version:    0.7.0.1
 */