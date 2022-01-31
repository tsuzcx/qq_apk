package com.tencent.mobileqq.confess;

import abrn;
import abro;
import abrp;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class BaseMsgListFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IFlingSwitch, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, Observer
{
  int jdField_a_of_type_Int = -1;
  public long a;
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abrp(this);
  public View a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public RecentAdapter a;
  public DragFrameLayout a;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new abro(this);
  public QQAppInterface a;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  String jdField_a_of_type_JavaLangString = "";
  final List jdField_a_of_type_JavaUtilList = new LinkedList();
  Map jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  List jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  int c;
  public List c;
  public boolean c;
  boolean d = true;
  
  public BaseMsgListFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  protected int a()
  {
    return 2130970289;
  }
  
  public RecentBaseData a()
  {
    RecentBaseData localRecentBaseData = null;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.remove(0);
      }
      return localRecentBaseData;
    }
  }
  
  protected List a(List paramList)
  {
    return null;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.e.findViewById(2131364184));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130968792, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 11);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(16);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = paramInt;
        if ((paramInt == 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
        {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
        }
        if ((i == 0) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
          break;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(List paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
          if (localRecentBaseData != null) {
            this.jdField_a_of_type_JavaUtilList.add(localRecentBaseData);
          }
        }
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      }
      paramList = new Message();
      paramList.what = 0;
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(paramList);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)
    {
      c();
      b();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData != null)
        {
          boolean bool = TextUtils.equals(localRecentBaseData.a(), paramString);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      return false;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.f == null)) {}
    TextView localTextView;
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.f.setVisibility(8);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (localObject == null);
    int i = ((QQMessageFacade)localObject).b();
    Object localObject = "返回，消息";
    String str;
    if (i > 99)
    {
      str = String.format(Locale.getDefault(), "%s(99+)", new Object[] { "消息" });
      localObject = String.format(Locale.getDefault(), "返回，99+%s", new Object[] { "条未读" });
    }
    for (;;)
    {
      localTextView.setText(str);
      localTextView.setContentDescription((CharSequence)localObject);
      return;
      if (i <= 0)
      {
        str = "消息";
      }
      else
      {
        str = String.format(Locale.getDefault(), "%s(%s)", new Object[] { "消息", Integer.valueOf(i) });
        localObject = String.format(Locale.getDefault(), "返回，%s%s", new Object[] { Integer.valueOf(i), "条未读" });
      }
    }
  }
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List paramList) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  public void d() {}
  
  public boolean d()
  {
    return super.d();
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 50;
    long l;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      b(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (this.jdField_b_of_type_JavaUtilList == null)
      {
        i = 0;
        if (i > 50) {
          break label304;
        }
        j = i;
        label142:
        if ((this.jdField_c_of_type_Int <= j) || (this.jdField_c_of_type_Int > i)) {
          break label522;
        }
        j = this.jdField_c_of_type_Int;
      }
      break;
    }
    label517:
    label522:
    for (;;)
    {
      if (j > 50)
      {
        this.jdField_c_of_type_Boolean = true;
        label174:
        if (QLog.isColorLevel()) {
          QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jdField_c_of_type_Int) }));
        }
        LinkedList localLinkedList = new LinkedList();
        paramMessage = localLinkedList;
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          paramMessage = localLinkedList;
          if (i > 0) {
            paramMessage = this.jdField_b_of_type_JavaUtilList.subList(0, j);
          }
        }
        paramMessage = a(paramMessage);
        if (paramMessage == null) {
          break label318;
        }
      }
      label304:
      label318:
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        return false;
        i = this.jdField_b_of_type_JavaUtilList.size();
        break;
        j = 50;
        break label142;
        this.jdField_c_of_type_Boolean = false;
        break label174;
      }
      l = System.currentTimeMillis();
      if ((this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_JavaUtilList != null))
      {
        int k = this.jdField_c_of_type_Int;
        int m = this.jdField_b_of_type_JavaUtilList.size();
        j = m - this.jdField_c_of_type_Int;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label507;
        }
        this.jdField_c_of_type_Boolean = true;
        label382:
        if (QLog.isColorLevel()) {
          QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
        }
        paramMessage = a(this.jdField_b_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
        if (paramMessage == null) {
          break label517;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
        label507:
        this.jdField_c_of_type_Boolean = false;
        i = j;
        break label382;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype", -1);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin", "");
    }
    if (!MsgProxyUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Int = 1032;
      this.jdField_a_of_type_JavaLangString = AppConstants.aE;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    b();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().runOnUiThread(new abrn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment
 * JD-Core Version:    0.7.0.1
 */