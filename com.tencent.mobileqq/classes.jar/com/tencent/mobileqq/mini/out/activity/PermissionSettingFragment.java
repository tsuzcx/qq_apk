package com.tencent.mobileqq.mini.out.activity;

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
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PermissionSettingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_NAME = "key_name";
  private static final String TAG = PermissionSettingFragment.class.getName();
  public static boolean hasCancel = false;
  private PermissionListAdapter adapter;
  String appId;
  AuthorizeCenter authorizeCenter;
  private boolean autoReSet = false;
  TextView leftBtnView;
  private ListView mPermissionListView;
  private TextView mPermissionNoneTextView;
  private QQProgressDialog mProgress;
  MiniAppInterface miniAppInterface;
  private TextView miniAppNameDesc;
  TextView titleView;
  
  private void initSettingUI(String paramString)
  {
    Object localObject;
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo;
    if (this.authorizeCenter != null)
    {
      localObject = this.authorizeCenter.getAuthorizeList(6);
      this.adapter = new PermissionListAdapter(getActivity(), this, new PermissionSettingFragment.2(this));
      if (localObject != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)localIterator.next();
        } while (!"scope.getPhoneNumber".equals(localAuthorizeInfo.scopeName));
      }
    }
    for (;;)
    {
      if (localAuthorizeInfo != null) {
        ((List)localObject).remove(localAuthorizeInfo);
      }
      localObject = new ArrayList((Collection)localObject);
      int i;
      if (needShowSubMsgPermissionItem((List)localObject))
      {
        i = 0;
        label121:
        if (i < ((List)localObject).size())
        {
          localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)((List)localObject).get(i);
          if ("setting.appMsgSubscribed".equals(localAuthorizeInfo.scopeName)) {
            ((List)localObject).remove(localAuthorizeInfo);
          }
        }
        else
        {
          ((List)localObject).add(new AuthorizeCenter.AuthorizeInfo("setting.appMsgSubscribed", 1));
        }
      }
      else
      {
        if (((List)localObject).size() <= 0) {
          break label269;
        }
        this.mPermissionListView.setVisibility(0);
        if (!TextUtils.isEmpty(paramString))
        {
          this.miniAppNameDesc.setVisibility(0);
          this.miniAppNameDesc.setText(String.format(HardCodeUtil.a(2131694178), new Object[] { paramString }));
        }
        this.adapter.setScopeList((List)localObject);
      }
      for (;;)
      {
        this.mPermissionListView.setAdapter(this.adapter);
        return;
        localObject = null;
        break;
        i += 1;
        break label121;
        label269:
        this.mPermissionNoneTextView.setText(paramString + HardCodeUtil.a(2131707919));
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
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class);
  }
  
  public static void launchForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class, paramInt);
  }
  
  private boolean needShowSubMsgPermissionItem(List<AuthorizeCenter.AuthorizeInfo> paramList)
  {
    boolean bool = false;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (!"setting.appMsgSubscribed".equals(((AuthorizeCenter.AuthorizeInfo)paramList.get(i)).scopeName)) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((this.authorizeCenter.isOnceSubMaintain()) || (i != 0) || (this.authorizeCenter.isSystemSubscribeMaintain())) {
        bool = true;
      }
      return bool;
      i += 1;
      break;
    }
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
    PermissionSettingFragment.3 local3 = new PermissionSettingFragment.3(this, str, paramBoolean, paramCompoundButton);
    if ((!paramBoolean) && (!hasCancel))
    {
      hasCancel = true;
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755842);
      localQQCustomDialog.setContentView(2131559084);
      localQQCustomDialog.setTitle(HardCodeUtil.a(2131707917)).setMessage(HardCodeUtil.a(2131707910)).setPositiveButton(HardCodeUtil.a(2131707915), Color.parseColor("#5B6B92"), new PermissionSettingFragment.5(this, str, paramBoolean, local3)).setNegativeButton(HardCodeUtil.a(2131707912), Color.parseColor("#000000"), new PermissionSettingFragment.4(this, paramCompoundButton));
      localQQCustomDialog.show();
      return;
    }
    this.adapter.changeChecked(str, paramBoolean);
    this.authorizeCenter.setAuthorize(str, paramBoolean, local3);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369487) {
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559513, null);
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
    this.leftBtnView = ((TextView)paramView.findViewById(2131369487));
    this.titleView = ((TextView)paramView.findViewById(2131369534));
    this.leftBtnView.setText(HardCodeUtil.a(2131707908));
    this.titleView.setText(HardCodeUtil.a(2131707922));
    this.leftBtnView.setOnClickListener(this);
    this.mPermissionListView = ((ListView)paramView.findViewById(2131372874));
    this.mPermissionNoneTextView = ((TextView)paramView.findViewById(2131372876));
    this.miniAppNameDesc = ((TextView)paramView.findViewById(2131371766));
    this.authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
    if (this.authorizeCenter == null)
    {
      QLog.e(TAG, 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
      return;
    }
    if (this.mProgress == null) {
      this.mProgress = new QQProgressDialog(getActivity());
    }
    this.mProgress.a(super.getResources().getString(2131694671));
    this.mProgress.show();
    MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new PermissionSettingFragment.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */