package com.tencent.qqmini.sdk.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@MiniKeep
public class PermissionSettingFragment
  extends MiniBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String TAG = "com.tencent.qqmini.sdk.ui.PermissionSettingFragment";
  public static boolean hasCancel = false;
  private PermissionListAdapter adapter;
  String appId;
  AuthState authState;
  TextView leftBtnView;
  private ListView mPermissionListView;
  private TextView mPermissionNoneTextView;
  private ProgressDialog mProgress;
  private TextView miniAppNameDesc;
  private RelativeLayout subMsgPermissionItem;
  TextView titleView;
  
  private void initPermissionParser(Context paramContext)
  {
    LocalPermissionParser localLocalPermissionParser = new LocalPermissionParser(paramContext);
    paramContext = new RemotePermissionParser(paramContext);
    PermissionManager.g().startParse(new PermissionParser[] { localLocalPermissionParser, paramContext });
  }
  
  private void initSettingUI(String paramString)
  {
    Object localObject1 = this.authState;
    StringBuilder localStringBuilder = null;
    if (localObject1 != null) {
      localObject1 = ((AuthState)localObject1).getAuthStateList(6);
    } else {
      localObject1 = null;
    }
    this.adapter = new PermissionListAdapter(getActivity(), this);
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        localObject2 = localStringBuilder;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (AuthStateItem)localIterator.next();
      } while (!"scope.getPhoneNumber".equals(((AuthStateItem)localObject2).scopeName));
      if (localObject2 != null) {
        ((List)localObject1).remove(localObject2);
      }
      localObject1 = new ArrayList((Collection)localObject1);
      if (((List)localObject1).size() > 0)
      {
        this.mPermissionListView.setVisibility(0);
        if (!TextUtils.isEmpty(paramString))
        {
          this.miniAppNameDesc.setVisibility(0);
          localObject2 = this.miniAppNameDesc;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("允许\"");
          localStringBuilder.append(paramString);
          localStringBuilder.append("\"使用我的");
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        this.adapter.setScopeList((List)localObject1);
      }
      else
      {
        localObject1 = this.mPermissionNoneTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("未使用你任何信息");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.mPermissionNoneTextView.setVisibility(0);
      }
      this.mPermissionListView.setAdapter(this.adapter);
      if ((!this.authState.isOnceSubMaintain()) && (!this.authState.isSystemSubscribeMaintain()))
      {
        this.subMsgPermissionItem.setVisibility(8);
        return;
      }
      this.subMsgPermissionItem.setVisibility(0);
      this.subMsgPermissionItem.setOnClickListener(new PermissionSettingFragment.2(this));
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = (String)paramCompoundButton.getTag();
    if (!TextUtils.isEmpty(str)) {
      if ((!paramBoolean) && (!hasCancel))
      {
        hasCancel = true;
        MiniCustomDialog localMiniCustomDialog = new MiniCustomDialog(getActivity(), R.style.mini_sdk_MiniAppInputDialog);
        localMiniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
        localMiniCustomDialog.setTitle("权限设置").setMessage("关闭授权后可能会影响使用小程序的部分功能，请确认").setPositiveButton("关闭授权", Color.parseColor("#5B6B92"), new PermissionSettingFragment.4(this, str, paramBoolean)).setNegativeButton("取消", Color.parseColor("#000000"), new PermissionSettingFragment.3(this, paramCompoundButton));
        localMiniCustomDialog.show();
      }
      else
      {
        this.adapter.changeChecked(str, paramBoolean);
        this.authState.setAuthState(str, paramBoolean);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ivTitleBtnLeft) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initPermissionParser(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_permission_setting_layout, null);
    if (DisplayUtil.IS_IMMERSIVE_SUPPORTED) {
      paramLayoutInflater.setFitsSystemWindows(true);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(Color.parseColor("#EFEFF4"));
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.appId = getActivity().getIntent().getStringExtra("key_appid");
    paramBundle = getActivity().getIntent().getStringExtra("key_name");
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
    this.mPermissionListView = ((ListView)paramView.findViewById(R.id.permission_list));
    this.mPermissionNoneTextView = ((TextView)paramView.findViewById(R.id.permission_none));
    this.miniAppNameDesc = ((TextView)paramView.findViewById(R.id.miniapp_name_text));
    this.subMsgPermissionItem = ((RelativeLayout)paramView.findViewById(R.id.sub_msg_permission_item));
    paramView = LoginManager.getInstance().getAccount();
    this.authState = new AuthState(getContext(), this.appId, paramView);
    paramView = this.authState;
    if (paramView == null)
    {
      QMLog.e(TAG, "getAuthorizeCenter(appId), authState is null?!");
      return;
    }
    if (paramView.isSynchronized())
    {
      initSettingUI(paramBundle);
      return;
    }
    if (this.mProgress == null) {
      this.mProgress = new ReportProgressDialog(getActivity());
    }
    this.mProgress.setMessage("正在获取权限信息，请稍候...");
    this.mProgress.show();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(this.appId, new PermissionSettingFragment.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */