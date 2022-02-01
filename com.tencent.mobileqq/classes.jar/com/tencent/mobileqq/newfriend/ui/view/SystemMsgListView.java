package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.observer.NewFriendCardObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder.NewFriendSildeTabHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, IPhoneContactListener, Observer
{
  public static final int a;
  float jdField_a_of_type_Float = 0.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new SystemMsgListView.1(this);
  private SparseArray<ListviewScrollStatus> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ListviewScrollStatus jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new SystemMsgListView.6(this);
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new SystemMsgListView.4(this);
  private NewFriendServiceImpl jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl;
  private NewFriendCardObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendCardObserver = new SystemMsgListView.8(this);
  NewFriendListObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver = new SystemMsgListView.5(this);
  NewFriendMessageObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver = new SystemMsgListView.MessageObserverForSystemMsgListView(this);
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver = new SystemMsgListView.7(this);
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TabLayoutCompat.OnTabSelectedListener jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener = new SystemMsgListView.2(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new SystemMsgListView.9(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  private SparseArray<Boolean> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private final int d = 0;
  private int e;
  
  static
  {
    jdField_a_of_type_Int = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRequestForSetting();
  }
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter);
    i();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus = new ListviewScrollStatus(23, 0, 0);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getMayKnowLoadConnectionBizTypeFirstLoad())
    {
      Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        return ((Boolean)localObject).booleanValue();
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, Boolean.valueOf(true));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    if ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter;
      if (localObject == null) {
        return;
      }
      if ((paramInt >= 0) && (paramInt < ((SystemMsgListAdapter)localObject).getCount()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getItem(paramInt);
        if ((paramInt == 0) && (((localObject instanceof NewFriendBindContactGuideBuilder)) || ((localObject instanceof NewFriendBindContactGuideBuilderV2))))
        {
          this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendVerifyBlockedBuilder))
        {
          this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendSysEmptyBuilder))
        {
          this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendSubTitleBuilder))
        {
          this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          return;
        }
        if (paramInt + 1 >= this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getCount()) {
          return;
        }
        f(paramInt);
        return;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
    }
  }
  
  private void f(int paramInt)
  {
    boolean bool = (NewFriendBaseBuilder)this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getItem(paramInt) instanceof NewFriendSlideTabBuilder;
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      this.jdField_b_of_type_Int = paramInt;
      localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
      if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder))
        {
          localObject2 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2;
          if ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null))
          {
            float f = ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("visable position: scrollposOffset = ");
              ((StringBuilder)localObject2).append(f);
              QLog.d("Q.newfriendSystemMsgListView", 2, ((StringBuilder)localObject2).toString());
            }
            this.jdField_a_of_type_Float = f;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(f);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus.jdField_c_of_type_Int = ((View)localObject1).getTop();
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = i;
        while (paramInt < j)
        {
          localObject2 = (ListviewScrollStatus)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((ListviewScrollStatus)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
            ((ListviewScrollStatus)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      i = this.jdField_b_of_type_Int;
      if (i <= -1)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if (paramInt > i)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      if (this.jdField_c_of_type_AndroidViewViewGroup.isShown())
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        if (((NewFriendBaseBuilder)this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getItem(paramInt + 1) instanceof NewFriendSlideTabBuilder))
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).getTag();
            if ((localObject1 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder))
            {
              localObject1 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("invisable position: scrollposOffset = ");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
                QLog.d("Q.newfriendSystemMsgListView", 2, ((StringBuilder)localObject2).toString());
              }
              if ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)) {
                ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
              }
            }
          }
        }
      }
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendCardObserver);
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendCardObserver);
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561513);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370141));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377262));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366277));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378198));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371896);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131297486);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377261));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131378236));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged state: ");
      localStringBuilder.append(paramInt);
      QLog.i("Q.newfriendSystemMsgListView", 2, localStringBuilder.toString());
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 222) && (paramInt1 != 223) && (paramInt1 != 224) && (paramInt1 != 225) && (paramInt1 != 226) && (paramInt1 != 227) && (paramInt1 != 228) && (paramInt1 != 229) && (paramInt1 != 221) && (paramInt1 != 231))
    {
      Object localObject;
      if (paramInt1 == 230)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("REQ_CODE_BIND_NUMBER resultCode: ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", src: ");
          ((StringBuilder)localObject).append(15);
          QLog.i("BindMsgConstant", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt2 == -1) {
          this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.c();
        }
      }
      else if (paramInt1 == jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getCount() > 0) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getItem(0);
        } else {
          localObject = null;
        }
        if (((localObject instanceof NewFriendBindContactGuideBuilderV2)) && (((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true))) {
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.jdField_a_of_type_ComTencentCommonAppAppInterface, -1, 2, null);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.c();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(long paramLong) {}
  
  public void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl = ((NewFriendServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, ""));
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130850578);
  }
  
  public void a(String paramString)
  {
    if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
    {
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().getString("systemmsg_addFriendCount", "");
      boolean bool = TextUtils.isEmpty(str);
      int k = 0;
      String[] arrayOfString;
      if (bool) {
        arrayOfString = new String[0];
      } else {
        arrayOfString = str.split(":");
      }
      if (arrayOfString.length >= 3) {
        return;
      }
      int m = arrayOfString.length;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (TextUtils.equals(arrayOfString[i], paramString))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0)
      {
        paramString = str;
      }
      else
      {
        if (arrayOfString.length != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString);
          paramString = localStringBuilder.toString();
        }
        i = arrayOfString.length;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().edit().putString("systemmsg_addFriendCount", paramString).commit();
    }
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    ThemeTabLayout localThemeTabLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
    if (localThemeTabLayout != null)
    {
      localThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void b(int paramInt) {}
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.f();
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.b() == 23) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.i();
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.a(0L);
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.b() == 23) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.h();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.e();
    ((INewFriendVerificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendVerificationService.class, "")).leaveNewFriend();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  public void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markAllDataReaded();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    SystemMsgListAdapter localSystemMsgListAdapter = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter;
    if (localSystemMsgListAdapter != null) {
      localSystemMsgListAdapter.g();
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).clearStructMsgMap();
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.updateBindContactGuideState();
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.isShowContactGuide())
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130850433));
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718766));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void k()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377262)
    {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity)this.jdField_a_of_type_AndroidContentContext);
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListAdapter.getCount())) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setStickHeadSelection position : ");
        localStringBuilder.append(paramInt);
        QLog.i("Q.newfriendSystemMsgListView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new SystemMsgListView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */