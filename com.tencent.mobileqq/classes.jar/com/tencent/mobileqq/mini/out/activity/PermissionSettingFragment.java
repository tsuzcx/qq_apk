package com.tencent.mobileqq.mini.out.activity;

import aevv;
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
import anni;
import bgpa;
import biau;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
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
  private biau mProgress;
  MiniAppInterface miniAppInterface;
  private TextView miniAppNameDesc;
  private FormSimpleItem subMsgPermissionItem;
  TextView titleView;
  
  private void initSettingUI(String paramString)
  {
    List localList;
    Object localObject;
    if (this.authorizeCenter != null)
    {
      localList = this.authorizeCenter.getAuthorizeList(6);
      this.adapter = new PermissionListAdapter(getActivity(), this);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (AuthorizeCenter.AuthorizeInfo)localIterator.next();
        } while (!"scope.getPhoneNumber".equals(((AuthorizeCenter.AuthorizeInfo)localObject).scopeName));
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localList.remove(localObject);
      }
      localObject = new ArrayList(localList);
      if (((List)localObject).size() > 0)
      {
        this.mPermissionListView.setVisibility(0);
        if (!TextUtils.isEmpty(paramString))
        {
          this.miniAppNameDesc.setVisibility(0);
          this.miniAppNameDesc.setText(String.format(anni.a(2131693681), new Object[] { paramString }));
        }
        this.adapter.setScopeList((List)localObject);
      }
      for (;;)
      {
        this.mPermissionListView.setAdapter(this.adapter);
        if (!needShowSubMsgPermissionItem(localList)) {
          break label270;
        }
        this.subMsgPermissionItem.setVisibility(0);
        this.subMsgPermissionItem.a(true);
        this.subMsgPermissionItem.setLeftText(anni.a(2131693683));
        this.subMsgPermissionItem.setOnClickListener(new PermissionSettingFragment.2(this));
        return;
        localList = null;
        break;
        this.mPermissionNoneTextView.setText(paramString + anni.a(2131706704));
        this.mPermissionNoneTextView.setVisibility(0);
      }
      label270:
      this.subMsgPermissionItem.setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString);
    aevv.a(paramContext, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class);
  }
  
  public static void launchForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    aevv.a(paramActivity, localIntent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class, paramInt);
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
      if ((this.authorizeCenter.isOnceSubMaintain()) || (i != 0)) {
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
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      String str = (String)paramCompoundButton.getTag();
      if (!TextUtils.isEmpty(str))
      {
        PermissionSettingFragment.3 local3 = new PermissionSettingFragment.3(this, str, paramBoolean, paramCompoundButton);
        if ((!paramBoolean) && (!hasCancel))
        {
          hasCancel = true;
          bgpa localbgpa = new bgpa(getActivity(), 2131755823);
          localbgpa.setContentView(2131559009);
          localbgpa.setTitle(anni.a(2131706702)).setMessage(anni.a(2131706695)).setPositiveButton(anni.a(2131706700), Color.parseColor("#5B6B92"), new PermissionSettingFragment.5(this, str, paramBoolean, local3)).setNegativeButton(anni.a(2131706697), Color.parseColor("#000000"), new PermissionSettingFragment.4(this, paramCompoundButton));
          localbgpa.show();
        }
        else
        {
          this.adapter.changeChecked(str, paramBoolean);
          this.authorizeCenter.setAuthorize(str, paramBoolean, local3);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368947) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559403, null);
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
    paramBundle = getActivity().getIntent().getStringExtra("key_name");
    if ((TextUtils.isEmpty(this.appId)) || (this.miniAppInterface == null))
    {
      getActivity().finish();
      return;
    }
    this.leftBtnView = ((TextView)paramView.findViewById(2131368947));
    this.titleView = ((TextView)paramView.findViewById(2131368994));
    this.leftBtnView.setText(anni.a(2131706693));
    this.titleView.setText(anni.a(2131706707));
    this.leftBtnView.setOnClickListener(this);
    this.mPermissionListView = ((ListView)paramView.findViewById(2131372289));
    this.mPermissionNoneTextView = ((TextView)paramView.findViewById(2131372290));
    this.miniAppNameDesc = ((TextView)paramView.findViewById(2131371192));
    this.subMsgPermissionItem = ((FormSimpleItem)paramView.findViewById(2131378001));
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
      this.mProgress = new biau(getActivity());
    }
    this.mProgress.a(super.getResources().getString(2131694135));
    this.mProgress.show();
    MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new PermissionSettingFragment.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */