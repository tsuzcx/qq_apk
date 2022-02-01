package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.model.SubscribeItemModel;
import com.tencent.qqmini.sdk.model.SubscribeItemModel.Builder;
import com.tencent.qqmini.sdk.model.SubscribeItemModel.SubscribeViewType;
import com.tencent.qqmini.sdk.server.R.id;
import com.tencent.qqmini.sdk.server.R.layout;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@MiniKeep
public class SubscribePermissionSettingFragment
  extends MiniBaseFragment
{
  public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
  public static final long NOT_LOGIN_ERR_CODE = -101510007L;
  public static final String TAG = "SubscribePermissionSettingFragment";
  private SubscribePermissionAdapter adapter;
  private String appId;
  AuthState authState;
  private final SubscribePermissionAdapter.InteractiveListener interactiveListener = new SubscribePermissionSettingFragment.2(this);
  private RecyclerView.LayoutManager layoutManager;
  private MiniProgressDialog mProgress;
  private final View.OnClickListener onClickListener = new SubscribePermissionSettingFragment.1(this);
  private List<SubscribeItemModel> subscribeItemList = null;
  private RecyclerView subscribeRecyclerView;
  
  private void dismissProgressDialog()
  {
    getActivity().runOnUiThread(new SubscribePermissionSettingFragment.4(this));
  }
  
  private SubscribeItemModel getLongTermSubscribe(INTERFACE.StUserSettingInfo paramStUserSettingInfo)
  {
    boolean bool = true;
    if (paramStUserSettingInfo.authState.get() != 0)
    {
      SubscribeItemModel.Builder localBuilder = new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE).setContent(paramStUserSettingInfo.desc.get());
      if (paramStUserSettingInfo.authState.get() == 1) {}
      for (;;)
      {
        return localBuilder.setIsChecked(bool).build();
        bool = false;
      }
    }
    return null;
  }
  
  private List<SubscribeItemModel> getOneTimeSubscribeList(INTERFACE.StUserSettingInfo paramStUserSettingInfo, SubscribeItemModel.SubscribeViewType paramSubscribeViewType)
  {
    ArrayList localArrayList = new ArrayList();
    paramStUserSettingInfo = paramStUserSettingInfo.subItems.get();
    int i = 0;
    if (i < paramStUserSettingInfo.size())
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramStUserSettingInfo.get(i);
      SubscribeItemModel.Builder localBuilder;
      if (localStSubscribeMessage.authState.get() != 0)
      {
        localBuilder = new SubscribeItemModel.Builder().setViewType(paramSubscribeViewType).setContent(localStSubscribeMessage.example.title.get());
        if (localStSubscribeMessage.authState.get() != 1) {
          break label124;
        }
      }
      label124:
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(localBuilder.setIsChecked(bool).setStSubscribeMessage(localStSubscribeMessage).build());
        i += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private SubscribeItemModel getTitleSubscribeItemModel(String paramString)
  {
    return new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.TITLE).setContent(paramString).build();
  }
  
  private List<SubscribeItemModel> handleAuthList(boolean paramBoolean, JSONObject paramJSONObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((!paramBoolean) || (paramJSONObject == null))
    {
      QMLog.e("SubscribePermissionSettingFragment", "getSetting-getAuthList failed");
      return localArrayList1;
    }
    QMLog.i("SubscribePermissionSettingFragment", "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
    paramJSONObject = paramJSONObject.opt("authList");
    if (!(paramJSONObject instanceof byte[]))
    {
      QMLog.e("SubscribePermissionSettingFragment", "getSetting-getAuthList failed, obj type error");
      return localArrayList1;
    }
    Object localObject1 = new INTERFACE.StGetAuthListRsp();
    ArrayList localArrayList2;
    try
    {
      ((INTERFACE.StGetAuthListRsp)localObject1).mergeFrom((byte[])paramJSONObject);
      Object localObject2 = ((INTERFACE.StGetAuthListRsp)localObject1).settings.get();
      paramJSONObject = new ArrayList();
      localObject1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        INTERFACE.StUserSettingInfo localStUserSettingInfo = (INTERFACE.StUserSettingInfo)((Iterator)localObject2).next();
        if ("setting.appMsgSubscribed".equals(localStUserSettingInfo.settingItem.get()))
        {
          SubscribeItemModel localSubscribeItemModel = getLongTermSubscribe(localStUserSettingInfo);
          if (localSubscribeItemModel != null) {
            paramJSONObject.add(localSubscribeItemModel);
          }
        }
        if ("setting.onceMsgSubscribed".equals(localStUserSettingInfo.settingItem.get())) {
          ((List)localObject1).addAll(getOneTimeSubscribeList(localStUserSettingInfo, SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE));
        }
        if ("setting.sysMsgSubscribed".equals(localStUserSettingInfo.settingItem.get()))
        {
          localArrayList2.addAll(getOneTimeSubscribeList(localStUserSettingInfo, SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE));
          continue;
          return localArrayList1;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramJSONObject)
    {
      QMLog.e("SubscribePermissionSettingFragment", "getSetting, InvalidProtocolBufferMicroException:", paramJSONObject);
    }
    for (;;)
    {
      if (paramJSONObject.size() > 0)
      {
        localArrayList1.add(getTitleSubscribeItemModel("允许发送内容更新、活动更新等消息"));
        localArrayList1.addAll(paramJSONObject);
      }
      if (((List)localObject1).size() > 0)
      {
        localArrayList1.add(getTitleSubscribeItemModel("允许发送一次以下消息"));
        localArrayList1.addAll((Collection)localObject1);
      }
      if (localArrayList2.size() > 0)
      {
        localArrayList1.add(getTitleSubscribeItemModel("允许多次发送以下消息"));
        localArrayList1.addAll(localArrayList2);
      }
    }
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString);
    MiniFragmentLauncher.start(paramContext, localIntent, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
  }
  
  private void onLongTermSubscribeChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel)
  {
    this.authState.setAuthState("setting.appMsgSubscribed", paramBoolean, new SubscribePermissionSettingFragment.8(this, paramInt, paramBoolean, paramSubscribeItemModel));
  }
  
  private void onOneTimeSubscribeChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    INTERFACE.StSubscribeMessage localStSubscribeMessage = paramSubscribeItemModel.getStSubscribeMessage();
    PBInt32Field localPBInt32Field = localStSubscribeMessage.authState;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localPBInt32Field.set(i);
      localArrayList.add(localStSubscribeMessage);
      this.authState.updateOnceSubMsgSetting(paramString, paramBoolean, localArrayList, new SubscribePermissionSettingFragment.7(this, paramInt, paramBoolean, paramSubscribeItemModel));
      return;
    }
  }
  
  private void requestAuthList()
  {
    showProgressDialog();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthListForSubscribe(this.appId, new SubscribePermissionSettingFragment.3(this));
  }
  
  private void setChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel)
  {
    getActivity().runOnUiThread(new SubscribePermissionSettingFragment.9(this, paramSubscribeItemModel, paramBoolean, paramInt));
  }
  
  private void showProgressDialog()
  {
    getActivity().runOnUiThread(new SubscribePermissionSettingFragment.5(this));
  }
  
  private void showSubscribeList(List<SubscribeItemModel> paramList)
  {
    getActivity().runOnUiThread(new SubscribePermissionSettingFragment.6(this, paramList));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_subscribe_permission_setting_layout, null);
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
    paramBundle = (TextView)paramView.findViewById(R.id.ivTitleBtnLeft);
    TextView localTextView = (TextView)paramView.findViewById(R.id.ivTitleName);
    paramBundle.setText("返回");
    localTextView.setText("设置");
    paramBundle.setOnClickListener(this.onClickListener);
    this.subscribeRecyclerView = ((RecyclerView)paramView.findViewById(R.id.subscribe_recycler_view));
    paramView = LoginManager.getInstance().getAccount();
    this.authState = new AuthState(getContext(), this.appId, paramView);
    if (this.authState == null)
    {
      QMLog.e("SubscribePermissionSettingFragment", "getAuthorizeCenter(appId), authorizeCenter is null?!");
      return;
    }
    requestAuthList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */