package com.tencent.mobileqq.mini.out.activity;

import adpn;
import alud;
import android.app.Activity;
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
import bdjz;
import bety;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public class PermissionSettingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_NAME = "key_name";
  private static final String TAG = PermissionSettingFragment.class.getName();
  public static boolean hasCancel;
  private PermissionListAdapter adapter;
  String appId;
  AuthorizeCenter authorizeCenter;
  private boolean autoReSet;
  TextView leftBtnView;
  private ListView mPermissionListView;
  private TextView mPermissionNoneTextView;
  private bety mProgress;
  MiniAppInterface miniAppInterface;
  private TextView miniAppNameDesc;
  TextView titleView;
  
  private void initSettingUI(String paramString)
  {
    List localList;
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo;
    if (this.authorizeCenter != null)
    {
      localList = this.authorizeCenter.getAuthorizeList(6);
      this.adapter = new PermissionListAdapter(getActivity(), this);
      Iterator localIterator = localList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)localIterator.next();
      } while (!"scope.getPhoneNumber".equals(localAuthorizeInfo.scopeName));
    }
    for (;;)
    {
      if (localAuthorizeInfo != null) {
        localList.remove(localAuthorizeInfo);
      }
      if ((localList != null) && (localList.size() > 0))
      {
        this.mPermissionListView.setVisibility(0);
        if (!TextUtils.isEmpty(paramString))
        {
          this.miniAppNameDesc.setVisibility(0);
          this.miniAppNameDesc.setText(String.format(alud.a(2131694417), new Object[] { paramString }));
        }
        this.adapter.setScopeList(localList);
      }
      for (;;)
      {
        this.mPermissionListView.setAdapter(this.adapter);
        return;
        localList = null;
        break;
        this.mPermissionNoneTextView.setText(paramString + alud.a(2131708327));
        this.mPermissionNoneTextView.setVisibility(0);
      }
      localAuthorizeInfo = null;
    }
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString);
    adpn.a(paramContext, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class);
  }
  
  public static void launchForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    adpn.a(paramActivity, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class, paramInt);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.autoReSet) {
      this.autoReSet = false;
    }
    String str;
    do
    {
      return;
      str = (String)paramCompoundButton.getTag();
    } while (TextUtils.isEmpty(str));
    PermissionSettingFragment.2 local2 = new PermissionSettingFragment.2(this, str, paramBoolean, paramCompoundButton);
    if ((!paramBoolean) && (!hasCancel))
    {
      hasCancel = true;
      bdjz localbdjz = new bdjz(getActivity(), 2131755801);
      localbdjz.setContentView(2131558942);
      localbdjz.setTitle(alud.a(2131708325)).setMessage(alud.a(2131708318)).setPositiveButton(alud.a(2131708323), Color.parseColor("#5B6B92"), new PermissionSettingFragment.4(this, str, paramBoolean, local2)).setNegativeButton(alud.a(2131708320), Color.parseColor("#000000"), new PermissionSettingFragment.3(this, paramCompoundButton));
      localbdjz.show();
      return;
    }
    this.adapter.changeChecked(str, paramBoolean);
    this.authorizeCenter.setAuthorize(str, paramBoolean, local2);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368624) {
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559312, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
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
    paramBundle = getActivity().getIntent().getStringExtra("key_name");
    if ((TextUtils.isEmpty(this.appId)) || (this.miniAppInterface == null))
    {
      getActivity().finish();
      return;
    }
    this.leftBtnView = ((TextView)paramView.findViewById(2131368624));
    this.titleView = ((TextView)paramView.findViewById(2131368670));
    this.leftBtnView.setText(alud.a(2131708316));
    this.titleView.setText(alud.a(2131708330));
    this.leftBtnView.setOnClickListener(this);
    this.mPermissionListView = ((ListView)paramView.findViewById(2131371715));
    this.mPermissionNoneTextView = ((TextView)paramView.findViewById(2131371716));
    this.miniAppNameDesc = ((TextView)paramView.findViewById(2131370638));
    this.authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
    if (this.authorizeCenter == null)
    {
      QLog.e(TAG, 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
      return;
    }
    if (this.authorizeCenter.isAuthorizeSynchronized())
    {
      initSettingUI(paramBundle);
      return;
    }
    if (this.mProgress == null) {
      this.mProgress = new bety(getActivity());
    }
    this.mProgress.a(super.getResources().getString(2131695057));
    this.mProgress.show();
    MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new PermissionSettingFragment.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */