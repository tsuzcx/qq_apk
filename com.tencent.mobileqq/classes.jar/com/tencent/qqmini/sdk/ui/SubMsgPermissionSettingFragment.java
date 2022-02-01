package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.FormSwitchItem;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@MiniKeep
public class SubMsgPermissionSettingFragment
  extends MiniBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final long NOT_LOGIN_ERR_CODE = -101510007L;
  public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
  public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
  private static final String TAG = SubMsgPermissionSettingFragment.class.getName();
  public static boolean hasCancel = false;
  private SubMsgPermissionListAdapter adapter;
  String appId;
  AuthState authState;
  private boolean autoReSet = false;
  TextView leftBtnView;
  private MiniProgressDialog mProgress;
  private CompoundButton.OnCheckedChangeListener onceSubMsgCheckListener = new SubMsgPermissionSettingFragment.2(this);
  private ListView onceSubMsgList;
  TextView onceSubMsgTips;
  private CompoundButton.OnCheckedChangeListener subMsgCheckListener = new SubMsgPermissionSettingFragment.1(this);
  FormSwitchItem subMsgSwitcher;
  TextView subMsgTips;
  TextView titleView;
  
  private void handleOnceSubscribeResponse(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        if (!"setting.onceMsgSubscribed".equals(paramJSONObject.optString("settingItem")))
        {
          QMLog.e(TAG, "handleOnceSubscribeResponse settingItem is no 'setting.onceMsgSubscribed'!");
          return;
        }
        paramJSONObject = paramJSONObject.opt("originalData");
        Object localObject = new INTERFACE.StGetUserSettingRsp();
        if ((paramJSONObject instanceof byte[]))
        {
          ((INTERFACE.StGetUserSettingRsp)localObject).mergeFrom((byte[])paramJSONObject);
          paramJSONObject = ((INTERFACE.StGetUserSettingRsp)localObject).setting.subItems.get();
          localObject = new ArrayList();
          i = 0;
          if (i < paramJSONObject.size())
          {
            INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramJSONObject.get(i);
            if (localStSubscribeMessage.authState.get() == 0) {
              break label236;
            }
            ((List)localObject).add(localStSubscribeMessage);
            break label236;
          }
          if (((List)localObject).size() > 0)
          {
            this.adapter = new SubMsgPermissionListAdapter(getActivity(), this);
            this.adapter.setSubMsgMaintainAuth((List)localObject);
            this.adapter.setInnerOnClickListener(new SubMsgPermissionSettingFragment.4(this));
            this.adapter.setInnerCheckedChangeListener(this.onceSubMsgCheckListener);
            getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.5(this));
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramJSONObject)
      {
        QMLog.e(TAG, "handleOnceSubscribeResponse InvalidProtocolBufferMicroException:" + paramJSONObject);
      }
      return;
      label236:
      i += 1;
    }
  }
  
  private void initSettingUI()
  {
    boolean bool = true;
    int i = this.authState.getAuthFlag("setting.appMsgSubscribed");
    if (1 != i)
    {
      this.subMsgTips.setText("允许发送内容更新、活动更新等消息");
      this.subMsgSwitcher.setOnCheckedChangeListener(this.subMsgCheckListener);
      this.subMsgSwitcher.getSwitch().setTag("setting.appMsgSubscribed");
      this.subMsgSwitcher.setText("接受订阅消息");
      FormSwitchItem localFormSwitchItem = this.subMsgSwitcher;
      if (i == 2)
      {
        localFormSwitchItem.setChecked(bool);
        this.subMsgTips.setVisibility(0);
        this.subMsgSwitcher.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.mProgress == null) {
        this.mProgress = new MiniProgressDialog(getActivity());
      }
      this.mProgress.setMessage("正在获取权限信息，请稍候...");
      this.mProgress.show();
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(this.appId, "", "setting.onceMsgSubscribed", null, new SubMsgPermissionSettingFragment.3(this));
      return;
      bool = false;
      break;
      this.subMsgTips.setVisibility(8);
      this.subMsgSwitcher.setVisibility(8);
    }
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString);
    MiniFragmentLauncher.start(paramContext, localIntent, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ivTitleBtnLeft) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_submsg_permission_setting_layout, null);
    if (DisplayUtil.isImmersiveSupported)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.appId = getActivity().getIntent().getStringExtra("key_appid");
    if (TextUtils.isEmpty(this.appId))
    {
      getActivity().finish();
      return;
    }
    this.leftBtnView = ((TextView)paramView.findViewById(R.id.ivTitleBtnLeft));
    this.titleView = ((TextView)paramView.findViewById(R.id.ivTitleName));
    this.leftBtnView.setText("返回");
    this.titleView.setText("设置");
    this.leftBtnView.setOnClickListener(this);
    this.subMsgTips = ((TextView)paramView.findViewById(R.id.sub_msg_tips));
    this.subMsgSwitcher = ((FormSwitchItem)paramView.findViewById(R.id.sub_msg_switch));
    this.onceSubMsgTips = ((TextView)paramView.findViewById(R.id.once_sub_msg_tips));
    this.onceSubMsgList = ((ListView)paramView.findViewById(R.id.once_sub_msg_list));
    paramView = LoginManager.getInstance().getAccount();
    this.authState = new AuthState(getContext(), this.appId, paramView);
    if (this.authState == null)
    {
      QMLog.e(TAG, "getAuthorizeCenter(appId), authorizeCenter is null?!");
      return;
    }
    initSettingUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */