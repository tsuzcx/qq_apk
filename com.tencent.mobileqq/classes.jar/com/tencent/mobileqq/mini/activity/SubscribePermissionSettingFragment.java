package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.Builder;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.SubscribeViewType;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.InteractiveListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class SubscribePermissionSettingFragment
  extends PublicBaseFragment
{
  public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
  public static final String TAG = "SubscribePermissionSettingFragment";
  private SubscribePermissionAdapter adapter;
  private String appId;
  private AuthorizeCenter authorizeCenter;
  private final SubscribePermissionAdapter.InteractiveListener interactiveListener = new SubscribePermissionSettingFragment.2(this);
  private RecyclerView.LayoutManager layoutManager;
  private MiniAppInterface miniAppInterface;
  private final View.OnClickListener onClickListener = new SubscribePermissionSettingFragment.1(this);
  private QQProgressDialog qqProgressDialog;
  private List<SubscribeItemModel> subscribeItemList = null;
  private RecyclerView subscribeRecyclerView;
  
  private void dismissProgressDialog()
  {
    getBaseActivity().runOnUiThread(new SubscribePermissionSettingFragment.4(this));
  }
  
  private SubscribeItemModel getLongTermSubscribe(INTERFACE.StUserSettingInfo paramStUserSettingInfo)
  {
    if (paramStUserSettingInfo.authState.get() != 0)
    {
      SubscribeItemModel.Builder localBuilder = new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE).setContent(paramStUserSettingInfo.desc.get());
      int i = paramStUserSettingInfo.authState.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return localBuilder.setIsChecked(bool).build();
    }
    return null;
  }
  
  private List<SubscribeItemModel> getOneTimeSubscribeList(INTERFACE.StUserSettingInfo paramStUserSettingInfo, SubscribeItemModel.SubscribeViewType paramSubscribeViewType)
  {
    ArrayList localArrayList = new ArrayList();
    paramStUserSettingInfo = paramStUserSettingInfo.subItems.get();
    int i = 0;
    while (i < paramStUserSettingInfo.size())
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramStUserSettingInfo.get(i);
      if (localStSubscribeMessage.authState.get() != 0)
      {
        SubscribeItemModel.Builder localBuilder = new SubscribeItemModel.Builder().setViewType(paramSubscribeViewType).setContent(localStSubscribeMessage.example.title.get());
        int j = localStSubscribeMessage.authState.get();
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        localArrayList.add(localBuilder.setIsChecked(bool).setStSubscribeMessage(localStSubscribeMessage).build());
      }
      i += 1;
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
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSetting-getAuthList suc, ret:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("SubscribePermissionSettingFragment", 1, ((StringBuilder)localObject).toString());
      paramJSONObject = paramJSONObject.opt("authList");
      if (!(paramJSONObject instanceof byte[]))
      {
        QLog.e("SubscribePermissionSettingFragment", 1, "getSetting-getAuthList failed, obj type error");
        return localArrayList1;
      }
      localObject = new INTERFACE.StGetAuthListRsp();
      try
      {
        ((INTERFACE.StGetAuthListRsp)localObject).mergeFrom((byte[])paramJSONObject);
        paramJSONObject = ((INTERFACE.StGetAuthListRsp)localObject).settings.get();
        localObject = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        Iterator localIterator = paramJSONObject.iterator();
        while (localIterator.hasNext())
        {
          INTERFACE.StUserSettingInfo localStUserSettingInfo = (INTERFACE.StUserSettingInfo)localIterator.next();
          if ("setting.appMsgSubscribed".equals(localStUserSettingInfo.settingItem.get()))
          {
            SubscribeItemModel localSubscribeItemModel = getLongTermSubscribe(localStUserSettingInfo);
            if (localSubscribeItemModel != null) {
              ((List)localObject).add(localSubscribeItemModel);
            }
          }
          if ("setting.onceMsgSubscribed".equals(localStUserSettingInfo.settingItem.get())) {
            localArrayList2.addAll(getOneTimeSubscribeList(localStUserSettingInfo, SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE));
          }
          if ("setting.sysMsgSubscribed".equals(localStUserSettingInfo.settingItem.get())) {
            localArrayList3.addAll(getOneTimeSubscribeList(localStUserSettingInfo, SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE));
          }
        }
        if (((List)localObject).size() > 0)
        {
          localArrayList1.add(getTitleSubscribeItemModel(HardCodeUtil.a(2131694153)));
          localArrayList1.addAll((Collection)localObject);
        }
        if (localArrayList2.size() > 0)
        {
          localArrayList1.add(getTitleSubscribeItemModel(HardCodeUtil.a(2131694151)));
          localArrayList1.addAll(localArrayList2);
        }
        if (localArrayList3.size() > 0)
        {
          localArrayList1.add(getTitleSubscribeItemModel("允许多次发送以下消息"));
          localArrayList1.addAll(localArrayList3);
        }
        this.authorizeCenter.updateAuthList(null, paramJSONObject);
        this.authorizeCenter.setAuthorizeSynchronized();
        return localArrayList1;
      }
      catch (InvalidProtocolBufferMicroException paramJSONObject)
      {
        QLog.e("SubscribePermissionSettingFragment", 1, "getSetting, InvalidProtocolBufferMicroException:", paramJSONObject);
        return localArrayList1;
      }
    }
    QLog.e("SubscribePermissionSettingFragment", 1, "getSetting-getAuthList failed");
    return localArrayList1;
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_APP_ID", paramString);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForMini.class, SubscribePermissionSettingFragment.class);
  }
  
  private void onLongTermSubscribeChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel)
  {
    this.authorizeCenter.setAuthorize("setting.appMsgSubscribed", paramBoolean, new SubscribePermissionSettingFragment.8(this, paramInt, paramBoolean, paramSubscribeItemModel));
  }
  
  private void onOneTimeSubscribeChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    INTERFACE.StSubscribeMessage localStSubscribeMessage = paramSubscribeItemModel.getStSubscribeMessage();
    PBInt32Field localPBInt32Field = localStSubscribeMessage.authState;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localPBInt32Field.set(i);
    localArrayList.add(localStSubscribeMessage);
    this.authorizeCenter.updateOnceSubMsgSetting(paramString, paramBoolean, localArrayList, new SubscribePermissionSettingFragment.7(this, paramInt, paramBoolean, paramSubscribeItemModel));
  }
  
  private void requestAuthList()
  {
    showProgressDialog();
    MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new SubscribePermissionSettingFragment.3(this));
  }
  
  private void setChecked(int paramInt, boolean paramBoolean, SubscribeItemModel paramSubscribeItemModel)
  {
    new Handler(Looper.getMainLooper()).post(new SubscribePermissionSettingFragment.9(this, paramSubscribeItemModel, paramBoolean, paramInt));
  }
  
  private void showProgressDialog()
  {
    getBaseActivity().runOnUiThread(new SubscribePermissionSettingFragment.5(this));
  }
  
  private void showSubscribeList(List<SubscribeItemModel> paramList)
  {
    getBaseActivity().runOnUiThread(new SubscribePermissionSettingFragment.6(this, paramList));
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131559395, null);
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
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle == null)
    {
      QLog.e("SubscribePermissionSettingFragment", 1, "onViewCreated error! intent == null");
      getBaseActivity().finish();
      return;
    }
    this.appId = paramBundle.getStringExtra("EXTRA_APP_ID");
    if ((!TextUtils.isEmpty(this.appId)) && (this.miniAppInterface != null))
    {
      paramBundle = (TextView)paramView.findViewById(2131369202);
      TextView localTextView = (TextView)paramView.findViewById(2131369249);
      paramBundle.setText(HardCodeUtil.a(2131707931));
      localTextView.setText(HardCodeUtil.a(2131707941));
      paramBundle.setOnClickListener(this.onClickListener);
      this.subscribeRecyclerView = ((RecyclerView)paramView.findViewById(2131378079));
      this.authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
      if (this.authorizeCenter == null)
      {
        QLog.e("SubscribePermissionSettingFragment", 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
        return;
      }
      requestAuthList();
      return;
    }
    paramView = new StringBuilder();
    paramView.append("onViewCreated error! appId: ");
    paramView.append(this.appId);
    paramView.append(" miniAppInterface: ");
    paramView.append(this.miniAppInterface);
    QLog.e("SubscribePermissionSettingFragment", 1, paramView.toString());
    getBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */