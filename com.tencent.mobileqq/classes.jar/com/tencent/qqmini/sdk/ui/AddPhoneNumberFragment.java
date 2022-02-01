package com.tencent.qqmini.sdk.ui;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;

@MiniKeep
public class AddPhoneNumberFragment
  extends MiniBaseFragment
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
  private Runnable runnableCountdown = new AddPhoneNumberFragment.1(this);
  
  private void restartTimer(int paramInt)
  {
    this.mSendSmsCodeBtn.setEnabled(false);
    this.mSendSmsCodeBtn.setClickable(false);
    this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
    mSecond = paramInt;
    this.mSendSmsCodeBtn.setText("有效期(" + mSecond + ")");
    this.mHandler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  public void onBackPressed()
  {
    QMLog.i("AddPhoneNumberFragment", "onBackPressed");
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    super.onBackPressed();
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
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_add_phone_number, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    if (DisplayUtil.isImmersiveSupported)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mLeftBtnView = ((ImageView)paramView.findViewById(R.id.mini_app_phone_number_manager_title_back));
    this.mSendSmsCodeBtn = ((Button)paramView.findViewById(R.id.mini_app_add_phone_number_btn));
    this.mSendSmsCodeBtn.setText("获取验证码");
    this.mSendSmsCodeBtn.setTextColor(Color.parseColor("#B0B3BF"));
    this.mSendSmsCodeBtn.setEnabled(false);
    this.mSendSmsCodeBtn.setClickable(false);
    this.mPhoneNumberLayout = ((RelativeLayout)paramView.findViewById(R.id.mini_app_add_phone_number));
    this.mPhoneNumberEditText = ((EditText)paramView.findViewById(R.id.mini_app_add_phone_number_edittext));
    this.mSmsCodeLayout = ((RelativeLayout)paramView.findViewById(R.id.mini_app_add_phone_number_smscode));
    this.mSmsCodeEditText = ((EditText)paramView.findViewById(R.id.mini_app_add_phone_number_smscode_edittext));
    this.mSaveSwitch = ((Switch)paramView.findViewById(R.id.mini_app_add_phone_number_save_switch));
    this.mSaveSwitch.setChecked(false);
    this.mCommitBtn = ((Button)paramView.findViewById(R.id.mini_app_add_phone_number_commit_btn));
    this.mCommitBtn.setEnabled(false);
    this.mCommitBtn.setClickable(false);
    this.mCommitBtn.setTextColor(Color.parseColor("#3303081A"));
    this.mLeftBtnView.setOnClickListener(new AddPhoneNumberFragment.2(this));
    this.mSendSmsCodeBtn.setOnClickListener(new AddPhoneNumberFragment.3(this));
    this.mPhoneNumberLayout.setOnClickListener(new AddPhoneNumberFragment.4(this));
    this.mPhoneNumberEditText.addTextChangedListener(new AddPhoneNumberFragment.5(this));
    this.mSaveSwitch.setOnClickListener(new AddPhoneNumberFragment.6(this));
    this.mSmsCodeLayout.setOnClickListener(new AddPhoneNumberFragment.7(this));
    this.mSmsCodeEditText.addTextChangedListener(new AddPhoneNumberFragment.8(this));
    this.mCommitBtn.setOnClickListener(new AddPhoneNumberFragment.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment
 * JD-Core Version:    0.7.0.1
 */