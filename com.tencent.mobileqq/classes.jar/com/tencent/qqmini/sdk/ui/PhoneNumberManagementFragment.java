package com.tencent.qqmini.sdk.ui;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import org.json.JSONArray;
import org.json.JSONObject;

@MiniKeep
public class PhoneNumberManagementFragment
  extends MiniBaseFragment
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
      MiniCustomDialog localMiniCustomDialog = new MiniCustomDialog(getActivity(), R.style.mini_sdk_MiniAppInputDialog);
      localMiniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_for_delphonenumber);
      localMiniCustomDialog.setTitle("确认删除此号码？").setMessage("").setPositiveButton("确定", new PhoneNumberManagementFragment.3(this, paramInt)).setNegativeButton("取消", new PhoneNumberManagementFragment.2(this));
      localMiniCustomDialog.show();
    }
  }
  
  private void setActivityResultListener()
  {
    ActivityResultManager.g().addActivityResultListener(new PhoneNumberManagementFragment.1(this));
  }
  
  private void updateView()
  {
    Object localObject = this.mPhoneNumberArray;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i = this.mPhoneNumberArray.length();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          localObject = this.mPhoneNumberArray.optJSONObject(0);
          localJSONObject1 = this.mPhoneNumberArray.optJSONObject(1);
          JSONObject localJSONObject2 = this.mPhoneNumberArray.optJSONObject(2);
          this.mPhoneNumberLayout1.setVisibility(0);
          this.mPhoneNumberLayout2.setVisibility(0);
          this.mPhoneNumberLayout3.setVisibility(0);
          this.mPhoneNumberText1.setText(((JSONObject)localObject).optString("purePhoneNumber"));
          this.mPhoneNumberText2.setText(localJSONObject1.optString("purePhoneNumber"));
          this.mPhoneNumberText3.setText(localJSONObject2.optString("purePhoneNumber"));
          this.mOperatePhoneNumberLayout.setVisibility(8);
          this.mPhoneNumberMaxInfo.setVisibility(0);
          return;
        }
        localObject = this.mPhoneNumberArray.optJSONObject(0);
        JSONObject localJSONObject1 = this.mPhoneNumberArray.optJSONObject(1);
        this.mPhoneNumberLayout1.setVisibility(0);
        this.mPhoneNumberLayout2.setVisibility(0);
        this.mPhoneNumberLayout3.setVisibility(8);
        this.mPhoneNumberText1.setText(((JSONObject)localObject).optString("purePhoneNumber"));
        this.mPhoneNumberText2.setText(localJSONObject1.optString("purePhoneNumber"));
        this.mOperatePhoneNumberLayout.setVisibility(0);
        this.mPhoneNumberMaxInfo.setVisibility(8);
        return;
      }
      localObject = this.mPhoneNumberArray.optJSONObject(0);
      this.mPhoneNumberLayout1.setVisibility(0);
      this.mPhoneNumberLayout2.setVisibility(8);
      this.mPhoneNumberLayout3.setVisibility(8);
      this.mPhoneNumberText1.setText(((JSONObject)localObject).optString("purePhoneNumber"));
      this.mOperatePhoneNumberLayout.setVisibility(0);
      this.mPhoneNumberMaxInfo.setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      Intent localIntent = new Intent();
      JSONArray localJSONArray = this.mPhoneNumberArray;
      if (localJSONArray != null) {
        localIntent.putExtra("phoneNumberArray", localJSONArray.toString());
      }
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Intent localIntent;
    Object localObject;
    if (i == R.id.mini_app_phone_number_manager_title_back)
    {
      if ((getActivity() != null) && (!getActivity().isFinishing()))
      {
        localIntent = new Intent();
        localObject = this.mPhoneNumberArray;
        if (localObject != null) {
          localIntent.putExtra("phoneNumberArray", ((JSONArray)localObject).toString());
        }
        getActivity().setResult(-1, localIntent);
        getActivity().finish();
      }
    }
    else if (i == R.id.mini_app_phone_number_manager_number_del2)
    {
      sendDelRequest(1);
    }
    else if (i == R.id.mini_app_phone_number_manager_number_del3)
    {
      sendDelRequest(2);
    }
    else if (i == R.id.mini_app_phone_number_manager_operate)
    {
      localIntent = new Intent();
      localIntent.putExtra("appId", this.mAppId);
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null) {
        ((ChannelProxy)localObject).launchAddPhoneNumberFragment(getActivity(), localIntent, 1090);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      QMLog.e("PhoneNumberManagementFragment", "parse getArguments error,", paramBundle);
    }
    setActivityResultListener();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_phone_number_manager, null);
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
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mLeftBtnView = ((ImageView)paramView.findViewById(R.id.mini_app_phone_number_manager_title_back));
    this.mLeftBtnView.setOnClickListener(this);
    this.mPhoneNumberLayout1 = ((RelativeLayout)paramView.findViewById(R.id.mini_app_phone_number_manager_number_1));
    this.mPhoneNumberText1 = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_number_text1));
    this.mPhoneNumberLayout2 = ((RelativeLayout)paramView.findViewById(R.id.mini_app_phone_number_manager_number_2));
    this.mPhoneNumberText2 = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_number_text2));
    this.mDelPhoneNmber2 = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_number_del2));
    this.mDelPhoneNmber2.setOnClickListener(this);
    this.mPhoneNumberLayout3 = ((RelativeLayout)paramView.findViewById(R.id.mini_app_phone_number_manager_number_3));
    this.mPhoneNumberText3 = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_number_text3));
    this.mDelPhoneNmber3 = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_number_del3));
    this.mDelPhoneNmber3.setOnClickListener(this);
    this.mOperatePhoneNumberLayout = ((RelativeLayout)paramView.findViewById(R.id.mini_app_phone_number_manager_operate));
    this.mOperatePhoneNumberLayout.setOnClickListener(this);
    this.mPhoneNumberMaxInfo = ((TextView)paramView.findViewById(R.id.mini_app_phone_number_manager_max_info));
    updateView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment
 * JD-Core Version:    0.7.0.1
 */