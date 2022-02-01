package com.tencent.mobileqq.mini.out.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.BaseActivity;
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
  private static final String TAG = "com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment";
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
    Object localObject1 = this.authorizeCenter;
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = ((AuthorizeCenter)localObject1).getAuthorizeList(6);
    } else {
      localObject1 = null;
    }
    this.adapter = new PermissionListAdapter(getBaseActivity(), this, new PermissionSettingFragment.2(this));
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        localObject2 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (AuthorizeCenter.AuthorizeInfo)localIterator.next();
      } while (!"scope.getPhoneNumber".equals(((AuthorizeCenter.AuthorizeInfo)localObject2).scopeName));
      if (localObject2 != null) {
        ((List)localObject1).remove(localObject2);
      }
      localObject1 = new ArrayList((Collection)localObject1);
      if (needShowSubMsgPermissionItem((List)localObject1))
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (AuthorizeCenter.AuthorizeInfo)((List)localObject1).get(i);
          if ("setting.appMsgSubscribed".equals(((AuthorizeCenter.AuthorizeInfo)localObject2).scopeName))
          {
            ((List)localObject1).remove(localObject2);
            break;
          }
          i += 1;
        }
        ((List)localObject1).add(new AuthorizeCenter.AuthorizeInfo("setting.appMsgSubscribed", 1));
      }
      if (((List)localObject1).size() > 0)
      {
        this.mPermissionListView.setVisibility(0);
        if (!TextUtils.isEmpty(paramString))
        {
          this.miniAppNameDesc.setVisibility(0);
          this.miniAppNameDesc.setText(String.format(HardCodeUtil.a(2131891765), new Object[] { paramString }));
        }
        this.adapter.setScopeList((List)localObject1);
      }
      else
      {
        localObject1 = this.mPermissionNoneTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905751));
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.mPermissionNoneTextView.setVisibility(0);
      }
      this.mPermissionListView.setAdapter(this.adapter);
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
    boolean bool2 = true;
    if (paramList != null)
    {
      i = 0;
      while (i < paramList.size())
      {
        if ("setting.appMsgSubscribed".equals(((AuthorizeCenter.AuthorizeInfo)paramList.get(i)).scopeName))
        {
          i = 1;
          break label54;
        }
        i += 1;
      }
    }
    int i = 0;
    label54:
    boolean bool1 = bool2;
    if (!this.authorizeCenter.isOnceSubMaintain())
    {
      bool1 = bool2;
      if (i == 0)
      {
        if (this.authorizeCenter.isSystemSubscribeMaintain()) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.autoReSet)
    {
      this.autoReSet = false;
      return;
    }
    String str = (String)paramCompoundButton.getTag();
    if (!TextUtils.isEmpty(str))
    {
      PermissionSettingFragment.3 local3 = new PermissionSettingFragment.3(this, str, paramBoolean, paramCompoundButton);
      if ((!paramBoolean) && (!hasCancel))
      {
        hasCancel = true;
        QQCustomDialog localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131953338);
        localQQCustomDialog.setContentView(2131624611);
        localQQCustomDialog.setTitle(HardCodeUtil.a(2131905749)).setMessage(HardCodeUtil.a(2131905745)).setPositiveButton(HardCodeUtil.a(2131905748), Color.parseColor("#5B6B92"), new PermissionSettingFragment.5(this, str, paramBoolean, local3)).setNegativeButton(HardCodeUtil.a(2131898212), Color.parseColor("#000000"), new PermissionSettingFragment.4(this, paramCompoundButton));
        localQQCustomDialog.show();
        return;
      }
      this.adapter.changeChecked(str, paramBoolean);
      this.authorizeCenter.setAuthorize(str, paramBoolean, local3);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436180) {
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131625353, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getBaseActivity().getAppInterface();
    if ((paramBundle instanceof MiniAppInterface)) {
      this.miniAppInterface = ((MiniAppInterface)paramBundle);
    }
    this.appId = getBaseActivity().getIntent().getStringExtra("key_appid");
    paramBundle = getBaseActivity().getIntent().getStringExtra("key_name");
    if ((!TextUtils.isEmpty(this.appId)) && (this.miniAppInterface != null))
    {
      this.leftBtnView = ((TextView)paramView.findViewById(2131436180));
      this.titleView = ((TextView)paramView.findViewById(2131436227));
      this.leftBtnView.setText(HardCodeUtil.a(2131901576));
      this.titleView.setText(HardCodeUtil.a(2131905753));
      this.leftBtnView.setOnClickListener(this);
      this.mPermissionListView = ((ListView)paramView.findViewById(2131439973));
      this.mPermissionNoneTextView = ((TextView)paramView.findViewById(2131439975));
      this.miniAppNameDesc = ((TextView)paramView.findViewById(2131438736));
      this.authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
      if (this.authorizeCenter == null)
      {
        QLog.e(TAG, 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
        return;
      }
      if (this.mProgress == null) {
        this.mProgress = new QQProgressDialog(getBaseActivity());
      }
      this.mProgress.a(super.getResources().getString(2131892324));
      this.mProgress.show();
      MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new PermissionSettingFragment.1(this, paramBundle));
      return;
    }
    getBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */