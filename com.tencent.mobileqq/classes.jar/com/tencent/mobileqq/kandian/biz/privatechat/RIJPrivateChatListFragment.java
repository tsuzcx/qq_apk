package com.tencent.mobileqq.kandian.biz.privatechat;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentAdapter.ShowUpStateListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentItemRIJPrivateItemData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport.R5Builder;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatReportImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/RIJPrivateChatListFragment;", "Lcom/tencent/mobileqq/fragment/IphoneTitleBarFragment;", "Ljava/util/Observer;", "Lcom/tencent/mobileqq/activity/recent/OnRecentUserOpsListener;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "emptyContentLayout", "Landroid/view/View;", "privateChatAdapter", "Lcom/tencent/mobileqq/activity/recent/RecentAdapter;", "privateChatListView", "Lcom/tencent/widget/XListView;", "reportImp", "Lcom/tencent/mobileqq/kandian/biz/privatechat/api/impl/RIJPrivateChatReportImpl;", "doOnCreateView", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getContentLayoutId", "", "getRIJUserInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "uin", "", "getRecentData", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "initListView", "initStatusBar", "initTitleBar", "isTransparent", "", "onClick", "v", "data", "", "onCreate", "onDestroy", "onLoadUserInfoFailed", "errMsg", "onLoadUserInfoSucceed", "userInfo", "onMenuItemClick", "menuItem", "r4", "onRecentBaseDataClick", "uinName", "needRefresh", "onRecentBaseDataDelete", "onResume", "onViewCreated", "view", "refreshEmptyContentLayout", "refreshPrivateChatList", "reportItemClick", "update", "o", "Ljava/util/Observable;", "arg", "updateAvatar", "updateNickName", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPrivateChatListFragment
  extends IphoneTitleBarFragment
  implements OnRecentUserOpsListener, IReadInJoyUserInfoModule.RefreshUserInfoCallBack, Observer
{
  public static final RIJPrivateChatListFragment.Companion a = new RIJPrivateChatListFragment.Companion(null);
  private QQAppInterface b;
  private RIJPrivateChatReportImpl c = new RIJPrivateChatReportImpl();
  private XListView d;
  private View e;
  private RecentAdapter f;
  
  private final RecentBaseData a(String paramString)
  {
    paramString = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatAdapter");
    }
    localObject1 = ((RecentAdapter)localObject1).j().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof RecentBaseData))
      {
        localObject2 = (RecentBaseData)localObject2;
        if (TextUtils.equals((CharSequence)((RecentBaseData)localObject2).getRecentUserUin(), paramString)) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private final void a()
  {
    Object localObject = getQBaseActivity();
    if (localObject != null)
    {
      localObject = ((QBaseActivity)localObject).getString(2131915469);
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    setTitle((CharSequence)localObject);
    localObject = this.vg;
    if (localObject != null) {
      ((NavBarCommon)localObject).changeBg(true);
    }
    b();
  }
  
  private final void a(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10013))
    {
      IRIJPrivateChatReport.R5Builder localR5Builder = new IRIJPrivateChatReport.R5Builder();
      RIJPrivateChatReportImpl localRIJPrivateChatReportImpl = this.c;
      Object localObject = RIJQQAppInterfaceUtil.d();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJQQAppInterfaceUtil.getAccount()");
      localR5Builder = localR5Builder.a((String)localObject);
      localObject = paramRecentBaseData.getRecentUserUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "data.recentUserUin");
      localR5Builder = localR5Builder.b((String)localObject).a(15);
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getConversationFacade();
        if (localObject != null)
        {
          i = ((ConversationFacade)localObject).a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
          break label118;
        }
      }
      int i = 0;
      label118:
      localRIJPrivateChatReportImpl.reportData("0X800BD0D", localR5Builder.b(i).a());
    }
  }
  
  private final void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    RecentBaseData localRecentBaseData = a(paramString);
    if (localRecentBaseData != null)
    {
      paramString = paramReadInJoyUserInfo.nick;
      if (paramString == null) {
        paramString = " ";
      }
      localRecentBaseData.mTitleName = paramString;
    }
  }
  
  private final ReadInJoyUserInfo b(String paramString)
  {
    if (paramString != null)
    {
      paramString = StringsKt.toLongOrNull(paramString);
      if (paramString != null)
      {
        l = paramString.longValue();
        break label23;
      }
    }
    long l = 0L;
    label23:
    if (l == 0L) {
      return null;
    }
    return ReadInJoyUserInfoModule.a(l, null);
  }
  
  private final void b()
  {
    if ((getActivity() instanceof QBaseActivity))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        RIJAppSetting.a((QBaseActivity)localFragmentActivity);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
    }
  }
  
  private final void b(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = a(paramString);
    if ((paramString instanceof RecentItemRIJPrivateItemData))
    {
      paramString = (RecentItemRIJPrivateItemData)paramString;
      paramString.avatarUrl = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
      paramReadInJoyUserInfo = new StringBuilder();
      paramReadInJoyUserInfo.append("[updateAvatar] avatarUrl = ");
      paramReadInJoyUserInfo.append(paramString.avatarUrl);
      QLog.i("RIJPrivateChatListFragment", 1, paramReadInJoyUserInfo.toString());
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.mContentView.findViewById(2131444861);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContentView.findViewByI…id.rij_private_chat_list)");
    this.d = ((XListView)localObject1);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatListView");
    }
    ((XListView)localObject1).setVisibility(0);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatListView");
    }
    ((XListView)localObject1).addFooterView(View.inflate((Context)getActivity(), 2131624518, null));
    localObject1 = (Context)getActivity();
    Object localObject2 = this.b;
    XListView localXListView = this.d;
    if (localXListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatListView");
    }
    this.f = new RecentAdapter((Context)localObject1, (QQAppInterface)localObject2, localXListView, (OnRecentUserOpsListener)this, 16);
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatAdapter");
    }
    ((RecentAdapter)localObject1).a((RecentAdapter.ShowUpStateListener)new RIJPrivateChatListFragment.initListView.1(this));
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatListView");
    }
    localObject2 = this.f;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("privateChatAdapter");
    }
    ((XListView)localObject1).setAdapter((ListAdapter)localObject2);
    localObject1 = this.mContentView.findViewById(2131432502);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContentView.findViewByI….id.empty_content_layout)");
    this.e = ((View)localObject1);
  }
  
  private final void d()
  {
    List localList = RIJPrivateChatServiceImpl.Companion.a().getRecentDataList((IReadInJoyUserInfoModule.RefreshUserInfoCallBack)this);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[refreshPrivateChatList] size = ");
      ((StringBuilder)localObject).append(localList.size());
      QLog.i("RIJPrivateChatListFragment", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = getActivity();
    if (localObject != null) {
      ((FragmentActivity)localObject).runOnUiThread((Runnable)new RIJPrivateChatListFragment.refreshPrivateChatList.1(this, localList));
    }
  }
  
  private final void e()
  {
    List localList = RIJPrivateChatServiceImpl.Companion.a().getRecentDataList((IReadInJoyUserInfoModule.RefreshUserInfoCallBack)this);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[refreshEmptyContentLayout] dataList size = ");
      ((StringBuilder)localObject).append(localList.size());
      QLog.i("RIJPrivateChatListFragment", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = getActivity();
    if (localObject != null) {
      ((FragmentActivity)localObject).runOnUiThread((Runnable)new RIJPrivateChatListFragment.refreshEmptyContentLayout.1(this, localList));
    }
  }
  
  protected void doOnCreateView(@Nullable LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    c();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131626097;
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void onClick(@Nullable View paramView, @Nullable Object paramObject) {}
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = RIJQQAppInterfaceUtil.b();
    paramBundle = this.b;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getMessageFacade();
      if (paramBundle != null) {
        paramBundle.addObserver((Observer)this);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      if (localObject != null) {
        ((QQMessageFacade)localObject).deleteObserver((Observer)this);
      }
    }
  }
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadUserInfoFailed] uin = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString2);
    QLog.i("RIJPrivateChatListFragment", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      ThreadManager.getUIHandler().post((Runnable)new RIJPrivateChatListFragment.onLoadUserInfoSucceed.1(this, paramString, paramReadInJoyUserInfo));
    }
  }
  
  public void onMenuItemClick(@Nullable String paramString1, @Nullable RecentBaseData paramRecentBaseData, @Nullable String paramString2)
  {
    boolean bool = Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[3]));
    RIJPrivateChatServiceImpl localRIJPrivateChatServiceImpl1 = null;
    paramString2 = null;
    if (bool)
    {
      localRIJPrivateChatServiceImpl1 = RIJPrivateChatServiceImpl.Companion.a();
      if (paramRecentBaseData != null) {
        paramString1 = paramRecentBaseData.getRecentUserUin();
      } else {
        paramString1 = null;
      }
      if (paramRecentBaseData != null) {
        paramString2 = Integer.valueOf(paramRecentBaseData.getRecentUserType());
      }
      localRIJPrivateChatServiceImpl1.updateRecentDataIsTop(paramString1, paramString2, true);
    }
    else if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[2])))
    {
      RIJPrivateChatServiceImpl localRIJPrivateChatServiceImpl2 = RIJPrivateChatServiceImpl.Companion.a();
      if (paramRecentBaseData != null) {
        paramString1 = paramRecentBaseData.getRecentUserUin();
      } else {
        paramString1 = null;
      }
      paramString2 = localRIJPrivateChatServiceImpl1;
      if (paramRecentBaseData != null) {
        paramString2 = Integer.valueOf(paramRecentBaseData.getRecentUserType());
      }
      localRIJPrivateChatServiceImpl2.updateRecentDataIsTop(paramString1, paramString2, false);
    }
    d();
  }
  
  public void onRecentBaseDataClick(@Nullable View paramView, @Nullable RecentBaseData paramRecentBaseData, @Nullable String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.getRecentUserType() == 10013)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
      paramView = this.b;
      if (paramView != null) {
        paramView = paramView.getRecentUserProxy();
      } else {
        paramView = null;
      }
      if (paramView != null) {
        paramView = paramView.b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      } else {
        paramView = null;
      }
      Activity localActivity = (Activity)getActivity();
      QQAppInterface localQQAppInterface = this.b;
      paramString = b(paramRecentBaseData.getRecentUserUin());
      if (paramString != null)
      {
        paramString = paramString.nick;
        if (paramString != null) {}
      }
      else
      {
        paramString = " ";
      }
      RecentUtil.a(localActivity, localQQAppInterface, paramView, paramString, paramBoolean, 4, paramRecentBaseData, localBundle, null);
    }
    a(paramRecentBaseData);
  }
  
  public void onRecentBaseDataDelete(@Nullable RecentBaseData paramRecentBaseData, @Nullable String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramString = (RecentUser)null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentItemRIJPrivateItemData))
    {
      paramString = ((RecentItemRIJPrivateItemData)paramRecentBaseData).e();
      i = paramRecentBaseData.mPosition;
    }
    if (paramString != null)
    {
      RecentUtil.a(this.b, paramString, i);
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("[onRecentBaseDataDelete], selectedUser = ");
      paramRecentBaseData.append(paramString);
      paramRecentBaseData.append(", position = ");
      paramRecentBaseData.append(i);
      QLog.i("RIJPrivateChatListFragment", 1, paramRecentBaseData.toString());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView.setFitsSystemWindows(true);
  }
  
  public void update(@Nullable Observable paramObservable, @Nullable Object paramObject)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.RIJPrivateChatListFragment
 * JD-Core Version:    0.7.0.1
 */