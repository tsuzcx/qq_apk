package com.tencent.qqmini.sdk.core.auth.ui;

import android.app.Activity;
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
import android.widget.TextView;
import bgmu;
import bhib;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.PermissionManager;
import com.tencent.qqmini.sdk.core.auth.PermissionParser;
import com.tencent.qqmini.sdk.core.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.core.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.ui.MiniFragmentActivity;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.util.List;

public class PermissionSettingFragment
  extends MiniBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_NAME = "key_name";
  private static final String TAG = PermissionSettingFragment.class.getName();
  public static boolean hasCancel;
  private PermissionListAdapter adapter;
  String appId;
  AuthState authState;
  TextView leftBtnView;
  private ListView mPermissionListView;
  private TextView mPermissionNoneTextView;
  private ProgressDialog mProgress;
  private TextView miniAppNameDesc;
  TextView titleView;
  
  private void initPermissionParser(Context paramContext)
  {
    LocalPermissionParser localLocalPermissionParser = new LocalPermissionParser(paramContext);
    paramContext = new RemotePermissionParser(paramContext);
    PermissionManager.g().startParse(new PermissionParser[] { localLocalPermissionParser, paramContext });
  }
  
  private void initSettingUI(String paramString)
  {
    List localList;
    if (this.authState != null)
    {
      localList = this.authState.getAuthStateList(6);
      this.adapter = new PermissionListAdapter(getActivity(), this);
      if ((localList == null) || (localList.size() <= 0)) {
        break label125;
      }
      this.mPermissionListView.setVisibility(0);
      if (!TextUtils.isEmpty(paramString))
      {
        this.miniAppNameDesc.setVisibility(0);
        this.miniAppNameDesc.setText("允许\"" + paramString + "\"使用我的");
      }
      this.adapter.setScopeList(localList);
    }
    for (;;)
    {
      this.mPermissionListView.setAdapter(this.adapter);
      return;
      localList = null;
      break;
      label125:
      this.mPermissionNoneTextView.setText(paramString + "未使用你任何信息");
      this.mPermissionNoneTextView.setVisibility(0);
    }
  }
  
  public static void launch(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    bhib.a(paramActivity, localIntent, MiniFragmentActivity.class, PermissionSettingFragment.class);
  }
  
  public static void launchForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    bhib.a(paramActivity, localIntent, MiniFragmentActivity.class, PermissionSettingFragment.class, paramInt);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = (String)paramCompoundButton.getTag();
    if (!TextUtils.isEmpty(str))
    {
      if ((!paramBoolean) && (!hasCancel))
      {
        hasCancel = true;
        bgmu localbgmu = new bgmu(getActivity(), 2131755761);
        localbgmu.setContentView(2131559342);
        localbgmu.a("权限设置").a("关闭授权后可能会影响使用小程序的部分功能，请确认").b("关闭授权", Color.parseColor("#5B6B92"), new PermissionSettingFragment.3(this, str, paramBoolean)).a("取消", Color.parseColor("#000000"), new PermissionSettingFragment.2(this, paramCompoundButton));
        localbgmu.show();
      }
    }
    else {
      return;
    }
    this.adapter.changeChecked(str, paramBoolean);
    this.authState.setAuthState(str, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368613) {
      getActivity().finish();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initPermissionParser(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559357, null);
    if (DisplayUtil.isImmersiveSupported) {
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
    this.leftBtnView = ((TextView)paramView.findViewById(2131368613));
    this.titleView = ((TextView)paramView.findViewById(2131368659));
    this.leftBtnView.setText("返回");
    this.titleView.setText("设置");
    this.leftBtnView.setOnClickListener(this);
    this.mPermissionListView = ((ListView)paramView.findViewById(2131371695));
    this.mPermissionNoneTextView = ((TextView)paramView.findViewById(2131371696));
    this.miniAppNameDesc = ((TextView)paramView.findViewById(2131370619));
    this.authState = MiniAppEnv.g().getAuthSate(this.appId);
    if (this.authState == null)
    {
      QMLog.e(TAG, "getAuthorizeCenter(appId), authState is null?!");
      return;
    }
    if (this.authState.isSynchronized())
    {
      initSettingUI(paramBundle);
      return;
    }
    if (this.mProgress == null) {
      this.mProgress = new ProgressDialog(getActivity());
    }
    this.mProgress.setMessage("正在获取权限信息，请稍候...");
    this.mProgress.show();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(this.appId, new PermissionSettingFragment.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */