package com.tencent.mobileqq.mini.mainpage;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
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
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131756189);
      localQQCustomDialog.setContentView(2131558958);
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
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      Intent localIntent = new Intent();
      JSONArray localJSONArray = this.mPhoneNumberArray;
      if (localJSONArray != null) {
        localIntent.putExtra("phoneNumberArray", localJSONArray.toString());
      }
      getBaseActivity().setResult(-1, localIntent);
      getBaseActivity().finish();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371168: 
      if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
      {
        paramView = new Intent();
        JSONArray localJSONArray = this.mPhoneNumberArray;
        if (localJSONArray != null) {
          paramView.putExtra("phoneNumberArray", localJSONArray.toString());
        }
        getBaseActivity().setResult(-1, paramView);
        getBaseActivity().finish();
        return;
      }
      break;
    case 2131371165: 
      paramView = new Intent();
      paramView.putExtra("appId", this.mAppId);
      PublicFragmentActivity.Launcher.a(getBaseActivity(), paramView, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1090);
      return;
    case 2131371159: 
      sendDelRequest(2);
      return;
    case 2131371158: 
      sendDelRequest(1);
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
      QLog.e("PhoneNumberManagementFragment", 1, "parse getArguments error,", paramBundle);
    }
    setActivityResultListener();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131559389, null);
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
    this.mLeftBtnView.setOnClickListener(this);
    this.mPhoneNumberLayout1 = ((RelativeLayout)paramView.findViewById(2131371155));
    this.mPhoneNumberText1 = ((TextView)paramView.findViewById(2131371162));
    this.mPhoneNumberLayout2 = ((RelativeLayout)paramView.findViewById(2131371156));
    this.mPhoneNumberText2 = ((TextView)paramView.findViewById(2131371163));
    this.mDelPhoneNmber2 = ((TextView)paramView.findViewById(2131371158));
    this.mDelPhoneNmber2.setOnClickListener(this);
    this.mPhoneNumberLayout3 = ((RelativeLayout)paramView.findViewById(2131371157));
    this.mPhoneNumberText3 = ((TextView)paramView.findViewById(2131371164));
    this.mDelPhoneNmber3 = ((TextView)paramView.findViewById(2131371159));
    this.mDelPhoneNmber3.setOnClickListener(this);
    this.mOperatePhoneNumberLayout = ((RelativeLayout)paramView.findViewById(2131371165));
    this.mOperatePhoneNumberLayout.setOnClickListener(this);
    this.mPhoneNumberMaxInfo = ((TextView)paramView.findViewById(2131371154));
    updateView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment
 * JD-Core Version:    0.7.0.1
 */