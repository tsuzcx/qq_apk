package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AddPhoneNumberFragment
  extends PublicBaseFragment
{
  public static final int SECOND = 1000;
  public static final String TAG = "AddPhoneNumberFragment";
  public static int mSecond = 1;
  private int intervalTime = 60;
  private boolean isSave = false;
  private String mAppId = null;
  private Button mCommitBtn;
  private Handler mHandler = null;
  private ImageView mLeftBtnView;
  private String mPhoneNumber = null;
  private EditText mPhoneNumberEditText;
  private RelativeLayout mPhoneNumberLayout;
  private Switch mSaveSwitch;
  private Button mSendSmsCodeBtn;
  private String mSmsCode = null;
  private EditText mSmsCodeEditText;
  private RelativeLayout mSmsCodeLayout;
  private Runnable runnableCountdown = new AddPhoneNumberFragment.9(this);
  
  private void restartTimer(int paramInt)
  {
    this.mSendSmsCodeBtn.setEnabled(false);
    this.mSendSmsCodeBtn.setClickable(false);
    this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
    mSecond = paramInt;
    Button localButton = this.mSendSmsCodeBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("有效期(");
    localStringBuilder.append(mSecond);
    localStringBuilder.append(")");
    localButton.setText(localStringBuilder.toString());
    this.mHandler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      localBaseActivity.setResult(0);
      localBaseActivity.finish();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new Handler(Looper.getMainLooper());
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.mAppId = paramBundle.getString("appId", null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131559368, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getBaseActivity().getWindow().clearFlags(67108864);
      getBaseActivity().getWindow().addFlags(-2147483648);
      getBaseActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mLeftBtnView = ((ImageView)paramView.findViewById(2131371168));
    this.mSendSmsCodeBtn = ((Button)paramView.findViewById(2131371049));
    this.mSendSmsCodeBtn.setText("获取验证码");
    this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
    this.mSendSmsCodeBtn.setEnabled(false);
    this.mSendSmsCodeBtn.setClickable(false);
    this.mPhoneNumberLayout = ((RelativeLayout)paramView.findViewById(2131371048));
    this.mPhoneNumberEditText = ((EditText)paramView.findViewById(2131371051));
    this.mSmsCodeLayout = ((RelativeLayout)paramView.findViewById(2131371059));
    this.mSmsCodeEditText = ((EditText)paramView.findViewById(2131371060));
    this.mSaveSwitch = ((Switch)paramView.findViewById(2131371057));
    this.mSaveSwitch.setChecked(false);
    this.mCommitBtn = ((Button)paramView.findViewById(2131371050));
    this.mCommitBtn.setEnabled(false);
    this.mCommitBtn.setClickable(false);
    this.mCommitBtn.setTextColor(Color.parseColor("#3303081A"));
    this.mLeftBtnView.setOnClickListener(new AddPhoneNumberFragment.1(this));
    this.mSendSmsCodeBtn.setOnClickListener(new AddPhoneNumberFragment.2(this));
    this.mPhoneNumberLayout.setOnClickListener(new AddPhoneNumberFragment.3(this));
    this.mPhoneNumberEditText.addTextChangedListener(new AddPhoneNumberFragment.4(this));
    this.mSaveSwitch.setOnClickListener(new AddPhoneNumberFragment.5(this));
    this.mSmsCodeLayout.setOnClickListener(new AddPhoneNumberFragment.6(this));
    this.mSmsCodeEditText.addTextChangedListener(new AddPhoneNumberFragment.7(this));
    this.mCommitBtn.setOnClickListener(new AddPhoneNumberFragment.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment
 * JD-Core Version:    0.7.0.1
 */