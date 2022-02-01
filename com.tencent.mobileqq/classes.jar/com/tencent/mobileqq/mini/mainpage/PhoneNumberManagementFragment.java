package com.tencent.mobileqq.mini.mainpage;

import adxr;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class PhoneNumberManagementFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static final String TAG = "PhoneNumberManagementFragment";
  private String mAppId;
  private TextView mDelPhoneNmber2;
  private TextView mDelPhoneNmber3;
  private ImageView mLeftBtnView;
  private RelativeLayout mOperatePhoneNumberLayout;
  private JSONArray mPhoneNumberArray = new JSONArray();
  private RelativeLayout mPhoneNumberLayout1;
  private RelativeLayout mPhoneNumberLayout2;
  private RelativeLayout mPhoneNumberLayout3;
  private TextView mPhoneNumberMaxInfo;
  private TextView mPhoneNumberText1;
  private TextView mPhoneNumberText2;
  private TextView mPhoneNumberText3;
  
  private void sendDelRequest(int paramInt)
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755826);
      localQQCustomDialog.setContentView(2131558996);
      localQQCustomDialog.setTitle("确认删除此号码？").setMessage("").setPositiveButton("确定", new PhoneNumberManagementFragment.3(this, paramInt)).setNegativeButton("取消", new PhoneNumberManagementFragment.2(this));
      localQQCustomDialog.show();
    }
  }
  
  private void setActivityResultListener()
  {
    MiniAppController.getInstance().setActivityResultListener(new PhoneNumberManagementFragment.1(this));
  }
  
  private void updateView()
  {
    if ((this.mPhoneNumberArray != null) && (this.mPhoneNumberArray.length() > 0)) {}
    switch (this.mPhoneNumberArray.length())
    {
    default: 
      return;
    case 1: 
      localJSONObject1 = this.mPhoneNumberArray.optJSONObject(0);
      this.mPhoneNumberLayout1.setVisibility(0);
      this.mPhoneNumberLayout2.setVisibility(8);
      this.mPhoneNumberLayout3.setVisibility(8);
      this.mPhoneNumberText1.setText(localJSONObject1.optString("purePhoneNumber"));
      this.mOperatePhoneNumberLayout.setVisibility(0);
      this.mPhoneNumberMaxInfo.setVisibility(8);
      return;
    case 2: 
      localJSONObject1 = this.mPhoneNumberArray.optJSONObject(0);
      localJSONObject2 = this.mPhoneNumberArray.optJSONObject(1);
      this.mPhoneNumberLayout1.setVisibility(0);
      this.mPhoneNumberLayout2.setVisibility(0);
      this.mPhoneNumberLayout3.setVisibility(8);
      this.mPhoneNumberText1.setText(localJSONObject1.optString("purePhoneNumber"));
      this.mPhoneNumberText2.setText(localJSONObject2.optString("purePhoneNumber"));
      this.mOperatePhoneNumberLayout.setVisibility(0);
      this.mPhoneNumberMaxInfo.setVisibility(8);
      return;
    }
    JSONObject localJSONObject1 = this.mPhoneNumberArray.optJSONObject(0);
    JSONObject localJSONObject2 = this.mPhoneNumberArray.optJSONObject(1);
    JSONObject localJSONObject3 = this.mPhoneNumberArray.optJSONObject(2);
    this.mPhoneNumberLayout1.setVisibility(0);
    this.mPhoneNumberLayout2.setVisibility(0);
    this.mPhoneNumberLayout3.setVisibility(0);
    this.mPhoneNumberText1.setText(localJSONObject1.optString("purePhoneNumber"));
    this.mPhoneNumberText2.setText(localJSONObject2.optString("purePhoneNumber"));
    this.mPhoneNumberText3.setText(localJSONObject3.optString("purePhoneNumber"));
    this.mOperatePhoneNumberLayout.setVisibility(8);
    this.mPhoneNumberMaxInfo.setVisibility(0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      Intent localIntent = new Intent();
      if (this.mPhoneNumberArray != null) {
        localIntent.putExtra("phoneNumberArray", this.mPhoneNumberArray.toString());
      }
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((getActivity() != null) && (!getActivity().isFinishing()))
      {
        Intent localIntent = new Intent();
        if (this.mPhoneNumberArray != null) {
          localIntent.putExtra("phoneNumberArray", this.mPhoneNumberArray.toString());
        }
        getActivity().setResult(-1, localIntent);
        getActivity().finish();
        continue;
        sendDelRequest(1);
        continue;
        sendDelRequest(2);
        continue;
        localIntent = new Intent();
        localIntent.putExtra("appId", this.mAppId);
        adxr.a(getActivity(), localIntent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1090);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        this.mAppId = paramBundle.getString("appId", null);
        this.mPhoneNumberArray = new JSONArray(paramBundle.getString("phoneNumberList"));
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("PhoneNumberManagementFragment", 1, "parse getArguments error,", paramBundle);
      }
    }
    setActivityResultListener();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559408, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
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
    this.mLeftBtnView = ((ImageView)paramView.findViewById(2131371076));
    this.mLeftBtnView.setOnClickListener(this);
    this.mPhoneNumberLayout1 = ((RelativeLayout)paramView.findViewById(2131371063));
    this.mPhoneNumberText1 = ((TextView)paramView.findViewById(2131371070));
    this.mPhoneNumberLayout2 = ((RelativeLayout)paramView.findViewById(2131371064));
    this.mPhoneNumberText2 = ((TextView)paramView.findViewById(2131371071));
    this.mDelPhoneNmber2 = ((TextView)paramView.findViewById(2131371066));
    this.mDelPhoneNmber2.setOnClickListener(this);
    this.mPhoneNumberLayout3 = ((RelativeLayout)paramView.findViewById(2131371065));
    this.mPhoneNumberText3 = ((TextView)paramView.findViewById(2131371072));
    this.mDelPhoneNmber3 = ((TextView)paramView.findViewById(2131371067));
    this.mDelPhoneNmber3.setOnClickListener(this);
    this.mOperatePhoneNumberLayout = ((RelativeLayout)paramView.findViewById(2131371073));
    this.mOperatePhoneNumberLayout.setOnClickListener(this);
    this.mPhoneNumberMaxInfo = ((TextView)paramView.findViewById(2131371062));
    updateView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment
 * JD-Core Version:    0.7.0.1
 */