package com.tencent.mobileqq.confess;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  long jdField_a_of_type_Long;
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new BaseMsgListFragment.4(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  protected BaseActivity a;
  final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BaseMsgListFragment.3(this);
  protected QQAppInterface a;
  final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new BaseMsgListFragment.2(this);
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  String jdField_a_of_type_JavaLangString = "";
  final List<RecentBaseData> jdField_a_of_type_JavaUtilList = new LinkedList();
  Map<String, RecentBaseData> jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  List<MessageRecord> jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List<RecentBaseData> jdField_c_of_type_JavaUtilList;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = true;
  
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
  
  public RecentBaseData a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.remove(0);
          return localRecentBaseData;
        }
      }
      Object localObject2 = null;
    }
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
  {
    return null;
  }
  
  protected void a()
  {
    if (this.leftView != null)
    {
      if (this.mLeftBackText == null) {
        return;
      }
      this.leftView.setVisibility(0);
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      TextView localTextView = this.leftView;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject != null)
      {
        int i = ((QQMessageFacade)localObject).b();
        localObject = HardCodeUtil.a(2131701256);
        if (i > 99)
        {
          String.format(Locale.getDefault(), "%s(99+)", new Object[] { HardCodeUtil.a(2131701259) });
          localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701254), new Object[] { HardCodeUtil.a(2131701257) });
        }
        else if (i <= 0)
        {
          HardCodeUtil.a(2131701261);
        }
        else
        {
          String.format(Locale.getDefault(), "%s(%s)", new Object[] { HardCodeUtil.a(2131701258), Integer.valueOf(i) });
          localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131701255), new Object[] { Integer.valueOf(i), HardCodeUtil.a(2131701260) });
        }
        localTextView.setContentDescription((CharSequence)localObject);
      }
    }
  }
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
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
        this.jdField_c_of_type_JavaUtilList.clear();
        if (paramList != null) {
          this.jdField_c_of_type_JavaUtilList.addAll(paramList);
        }
        paramList = new Message();
        paramList.what = 0;
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(0);
        this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(paramList);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
    }
  }
  
  protected boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    return (i != 0) && (i != 1);
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      do
      {
        RecentBaseData localRecentBaseData;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localRecentBaseData = (RecentBaseData)localIterator.next();
        } while (localRecentBaseData == null);
        bool1 = TextUtils.equals(localRecentBaseData.getRecentUserUin(), paramString);
      } while (!bool1);
      boolean bool1 = true;
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  protected void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  protected void b(List<MessageRecord> paramList) {}
  
  protected void c() {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131370153));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838739);
    }
    catch (Throwable paramViewGroup)
    {
      QLog.e("BaseMsgListFragment", 1, paramViewGroup, new Object[0]);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558896, null);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561021;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 50;
    long l;
    int k;
    int m;
    if (j != 0)
    {
      if (j != 1) {
        return false;
      }
      l = System.currentTimeMillis();
      k = this.jdField_c_of_type_Int;
      if (k > 0)
      {
        paramMessage = this.jdField_b_of_type_JavaUtilList;
        if (paramMessage != null)
        {
          m = paramMessage.size();
          j = m - this.jdField_c_of_type_Int;
          if (j <= 0) {
            return false;
          }
          if (j > 50)
          {
            this.jdField_c_of_type_Boolean = true;
          }
          else
          {
            this.jdField_c_of_type_Boolean = false;
            i = j;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
          }
          paramMessage = a(this.jdField_b_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
          if (paramMessage != null) {
            i = paramMessage.size();
          } else {
            i = 0;
          }
          this.jdField_c_of_type_Int = i;
          a(paramMessage);
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
      }
    }
    else
    {
      l = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      b(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      paramMessage = this.jdField_b_of_type_JavaUtilList;
      if (paramMessage == null) {
        i = 0;
      } else {
        i = paramMessage.size();
      }
      if (i <= 50) {
        j = i;
      } else {
        j = 50;
      }
      m = this.jdField_c_of_type_Int;
      k = j;
      if (m > j)
      {
        k = j;
        if (m <= i) {
          k = m;
        }
      }
      if (k > 50) {
        this.jdField_c_of_type_Boolean = true;
      } else {
        this.jdField_c_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
      LinkedList localLinkedList = new LinkedList();
      List localList = this.jdField_b_of_type_JavaUtilList;
      paramMessage = localLinkedList;
      if (localList != null)
      {
        paramMessage = localLinkedList;
        if (i > 0) {
          paramMessage = localList.subList(0, k);
        }
      }
      paramMessage = a(paramMessage);
      if (paramMessage != null) {
        i = paramMessage.size();
      } else {
        i = 0;
      }
      this.jdField_c_of_type_Int = i;
      a(paramMessage);
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)
    {
      b();
      a();
    }
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype", -1);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin", "");
    }
    if (!UinTypeUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Int = 1032;
      this.jdField_a_of_type_JavaLangString = AppConstants.CONFESS_UIN;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onPause()
  {
    super.onPause();
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean) {}
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString) {}
  
  public void onResume()
  {
    super.onResume();
    b();
    a();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (paramView != null) {
      paramView.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (paramView != null) {
      paramView.setInterceptTouchFlag(false);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    int i;
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt != 0) && (paramInt != 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
    }
    this.jdField_b_of_type_Int = paramInt;
    if ((paramInt == 0) && (this.jdField_b_of_type_Boolean))
    {
      paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler;
      if (paramAbsListView != null)
      {
        paramAbsListView.removeMessages(0);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
      }
    }
    if (i != 0)
    {
      paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler;
      if (paramAbsListView != null) {
        paramAbsListView.sendEmptyMessage(1);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollRLFlag(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (getBaseActivity() == null) {
      return;
    }
    getBaseActivity().runOnUiThread(new BaseMsgListFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment
 * JD-Core Version:    0.7.0.1
 */