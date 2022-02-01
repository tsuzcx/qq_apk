package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import afez;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.TextView;
import anzj;
import bjbs;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SubMsgPermissionSettingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String KEY_APPID = "key_appid";
  private static final String TAG = SubMsgPermissionSettingFragment.class.getName();
  public static boolean hasCancel;
  private SubMsgPermissionListAdapter adapter;
  String appId;
  AuthorizeCenter authorizeCenter;
  private boolean autoReSet;
  TextView leftBtnView;
  private bjbs mProgress;
  MiniAppInterface miniAppInterface;
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
          QLog.e(TAG, 1, "handleOnceSubscribeResponse settingItem is no 'setting.onceMsgSubscribed'!");
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
              break label238;
            }
            ((List)localObject).add(localStSubscribeMessage);
            break label238;
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
        QLog.e(TAG, 1, "handleOnceSubscribeResponse InvalidProtocolBufferMicroException:" + paramJSONObject);
      }
      return;
      label238:
      i += 1;
    }
  }
  
  private void initSettingUI()
  {
    boolean bool = true;
    int i = this.authorizeCenter.getAuthFlagFromAuthorize("setting.appMsgSubscribed");
    if (1 != i)
    {
      this.subMsgTips.setText(anzj.a(2131693703));
      this.subMsgSwitcher.setOnCheckedChangeListener(this.subMsgCheckListener);
      this.subMsgSwitcher.a().setTag("setting.appMsgSubscribed");
      this.subMsgSwitcher.setText(anzj.a(2131693702));
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
        this.mProgress = new bjbs(getActivity());
      }
      this.mProgress.a(super.getResources().getString(2131694153));
      this.mProgress.show();
      MiniAppCmdUtil.getInstance().getUserSetting(this.appId, "", "setting.onceMsgSubscribed", null, new SubMsgPermissionSettingFragment.3(this));
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
    afez.a(paramContext, localIntent, PublicFragmentActivityForMini.class, SubMsgPermissionSettingFragment.class);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369042) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559414, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
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
    paramBundle = getActivity().getAppInterface();
    if ((paramBundle instanceof MiniAppInterface)) {
      this.miniAppInterface = ((MiniAppInterface)paramBundle);
    }
    this.appId = getActivity().getIntent().getStringExtra("key_appid");
    if ((TextUtils.isEmpty(this.appId)) || (this.miniAppInterface == null))
    {
      getActivity().finish();
      return;
    }
    this.leftBtnView = ((TextView)paramView.findViewById(2131369042));
    this.titleView = ((TextView)paramView.findViewById(2131369088));
    this.leftBtnView.setText(anzj.a(2131706802));
    this.titleView.setText(anzj.a(2131706816));
    this.leftBtnView.setOnClickListener(this);
    this.subMsgTips = ((TextView)paramView.findViewById(2131378160));
    this.subMsgSwitcher = ((FormSwitchItem)paramView.findViewById(2131378159));
    this.onceSubMsgTips = ((TextView)paramView.findViewById(2131372048));
    this.onceSubMsgList = ((ListView)paramView.findViewById(2131372047));
    this.authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
    if (this.authorizeCenter == null)
    {
      QLog.e(TAG, 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
      return;
    }
    initSettingUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */