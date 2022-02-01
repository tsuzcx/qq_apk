package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class KidModeVerifyFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener
{
  public static int a = 1;
  public static long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new KidModeVerifyFragment.3(this));
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private KidModeObserver jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver = new KidModeVerifyFragment.1(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private Runnable jdField_a_of_type_JavaLangRunnable = new KidModeVerifyFragment.2(this);
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131693558));
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      KidModeUtils.a(getBaseActivity(), getString(2131692183), 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, "Set Face Data startGetVerifyCode.begin");
    }
    KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380055));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.mContentView.findViewById(2131372044));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131693551);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131365086));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693547);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131693536, new Object[] { StudyModeManager.a() }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364036));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((paramInt != 0) && (paramInt != 84)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131693556));
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131693558));
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131694583));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693558));
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramActivity instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    int i = localIntent.getIntExtra("RESULT_CODE", -1);
    if (i == -1)
    {
      PublicFragmentActivity.a(paramActivity, localIntent, KidModeVerifyFragment.class);
      return;
    }
    PublicFragmentActivity.a(paramActivity, localIntent, KidModeVerifyFragment.class, i);
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      KidModeUtils.a(getBaseActivity(), getString(2131692183), 1);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
    if (localObject != null) {
      localObject = localObject.toString().trim();
    } else {
      localObject = "";
    }
    if (((String)localObject).length() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set face data commitSmsCode.begin to check smsCode=");
        localStringBuilder.append((String)localObject);
        QLog.d("IphoneTitleBarFragment", 2, localStringBuilder.toString());
      }
      KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
      return;
    }
    KidModeUtils.a(getBaseActivity(), HardCodeUtil.a(2131716570), 0);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramInt));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    KidModeAdvanceSettingFragment.a(getBaseActivity().getBaseContext());
    getBaseActivity().finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramLayoutInflater = getBaseActivity().getIntent();
      int i = paramLayoutInflater.getIntExtra("FIRST_TIME_RES", 0);
      a(i);
      if ((i == 0) || (i == 84)) {
        b(paramLayoutInflater.getIntExtra("COUNT_TIME", 0));
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561056;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364036)
    {
      if (i == 2131365086) {
        b();
      }
    }
    else if (jdField_a_of_type_Int <= 1) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("target", 0);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
    }
    long l1 = ((Long)SharedPreUtils.a("sp_key_count_time", Long.valueOf(-1L))).longValue();
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 != -1L)
    {
      l1 = l2 - l1;
      if (l1 < 60L)
      {
        jdField_a_of_type_Int = 60 - (int)l1;
        paramBundle.putExtra("COUNT_TIME", jdField_a_of_type_Int);
        paramBundle.putExtra("FIRST_TIME_RES", 84);
        break label144;
      }
    }
    jdField_a_of_type_Int = 0;
    label144:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B3D3", "0X800B3D3", 0, 0, "", "", "", "");
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131693560));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new KidModeVerifyFragment.4(this), 100L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment
 * JD-Core Version:    0.7.0.1
 */