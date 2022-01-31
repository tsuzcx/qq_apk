package com.tencent.mobileqq.dating;

import abwj;
import abwm;
import abwn;
import abwo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class BaseMsgBoxActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IFlingSwitch, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, Observer
{
  public int a;
  public long a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abwn(this);
  public View a;
  public ViewStub a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public RecentAdapter a;
  public DragFrameLayout a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new abwj(this);
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  public String a;
  public List a;
  public Map a;
  public MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private List jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  private int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  
  public BaseMsgBoxActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
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
  
  protected List a(List paramList)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramView = paramRecentBaseData.a();
    if (MsgProxyUtils.c(paramView))
    {
      paramRecentBaseData = new Intent(this, SayHelloMsgListActivity.class);
      paramRecentBaseData.putExtra("uin", paramView);
      paramRecentBaseData.putExtra("uintype", this.jdField_a_of_type_Int);
      startActivity(paramRecentBaseData);
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_say_hi", 0, 0, "", "", "", "");
      return;
    }
    paramString = (FriendsManager)this.app.getManager(50);
    if (paramString != null) {}
    for (paramBoolean = paramString.b(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean)
      {
        localIntent.putExtra("uintype", 0);
        paramString = ContactUtils.q(this.app, paramRecentBaseData.a());
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = ContactUtils.b(this.app, paramRecentBaseData.a(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        if (!(paramRecentBaseData instanceof RecentSayHelloListItem)) {
          break label300;
        }
        paramView = (RecentSayHelloListItem)paramRecentBaseData;
        if (paramView.p > 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramView.p, 0, "", "", "", "");
        }
        paramString = this.app;
        if (paramRecentBaseData.a() != 1001) {
          break label294;
        }
      }
      label294:
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramView, "1", "", "");
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.a());
        break;
      }
      label300:
      paramString = this.app;
      if (paramRecentBaseData.a() == 1001) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramView, "0", "", "");
        return;
      }
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      int i = this.app.a().a(paramRecentBaseData.a(), paramRecentBaseData.a());
      this.app.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramRecentBaseData.a(), this.app.getCurrentAccountUin());
      if (i > 0)
      {
        if (!MsgProxyUtils.c(paramRecentBaseData.a())) {
          break label174;
        }
        ThreadManager.post(new abwm(this, paramRecentBaseData.a(), paramRecentBaseData.a()), 8, null, false);
      }
    }
    for (;;)
    {
      if ((AppConstants.af.equals(paramRecentBaseData.a())) || (AppConstants.ae.equals(paramRecentBaseData.a())))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      return;
      label174:
      this.jdField_b_of_type_JavaLangString = (paramRecentBaseData.a() + "_" + this.jdField_a_of_type_Int);
      RecentUtil.b(this.app, paramRecentBaseData.a(), this.jdField_a_of_type_Int);
      this.app.a().a(paramRecentBaseData.a(), this.jdField_a_of_type_Int, true, true);
    }
  }
  
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
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramList;
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      a();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1);
  }
  
  public void b() {}
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List paramList) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970416);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "BOX UIN:" + this.jdField_a_of_type_JavaLangString + "|BOX TYPE:" + this.jdField_a_of_type_Int);
    }
    if (!MsgProxyUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_JavaLangString = AppConstants.G;
      this.jdField_a_of_type_Int = 1001;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131370453));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131370449));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370450);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370451));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370452));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130968792, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    if (MsgProxyUtils.c(this.jdField_a_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 7);; this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && ((AppConstants.X.equals(this.jdField_a_of_type_JavaLangString)) || (AppConstants.G.equals(this.jdField_a_of_type_JavaLangString))))
    {
      QQMessageFacade.Message localMessage = this.app.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (localMessage != null) {
        this.app.a().a(this.jdField_a_of_type_Int, localMessage.time);
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_b_of_type_Int = 0;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 50;
    long l1;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l1 = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilList = this.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      b(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "cloneMsgBoxList cost time: " + (System.currentTimeMillis() - l1));
      }
      if (this.jdField_b_of_type_JavaUtilList == null)
      {
        i = 0;
        if (i > 50) {
          break label292;
        }
        j = i;
        label124:
        if ((this.jdField_c_of_type_Int <= j) || (this.jdField_c_of_type_Int > i)) {
          break label520;
        }
        j = this.jdField_c_of_type_Int;
      }
      break;
    }
    label515:
    label520:
    for (;;)
    {
      if (j > 50)
      {
        this.d = true;
        label156:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "refresh_list|totalCount:" + i + ",curCount:" + this.jdField_c_of_type_Int + ",loadCount:" + j);
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
          break label306;
        }
      }
      label292:
      label306:
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        return false;
        i = this.jdField_b_of_type_JavaUtilList.size();
        break;
        j = 50;
        break label124;
        this.d = false;
        break label156;
      }
      l1 = System.currentTimeMillis();
      if ((this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_JavaUtilList != null))
      {
        int k = this.jdField_c_of_type_Int;
        j = this.jdField_b_of_type_JavaUtilList.size() - this.jdField_c_of_type_Int;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label505;
        }
        this.d = true;
        label366:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "loadNextPageData|totalCount:" + this.jdField_b_of_type_JavaUtilList.size() + ",loadCount:" + i);
        }
        paramMessage = a(this.jdField_b_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
        if (paramMessage == null) {
          break label515;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("Q.msg_box", 2, "loadNextPageData cost time:" + (l2 - l1));
        return false;
        label505:
        this.d = false;
        i = j;
        break label366;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramObservable.senderuin))) {}
    }
    else
    {
      return;
    }
    paramObject = paramObservable.senderuin + "_" + paramObservable.istroop;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "update key:" + paramObject + "|mDelItemKey:" + this.jdField_b_of_type_JavaLangString);
    }
    if (paramObject.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    boolean bool;
    if (((MsgProxyUtils.a(paramObservable.istroop) == 1010) && (this.jdField_a_of_type_Int == 1010)) || ((MsgProxyUtils.a(paramObservable.istroop) == 1001) && (this.jdField_a_of_type_Int == 1001))) {
      bool = true;
    }
    for (;;)
    {
      runOnUiThread(new abwo(this, bool));
      return;
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        paramObject = new ArrayList(this.jdField_b_of_type_JavaUtilList).iterator();
        for (;;)
        {
          if (paramObject.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramObject.next();
            if (paramObservable.frienduin.equals(localMessageRecord.senderuin))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg_box", 2, "needRefresh update,uin:" + paramObservable.frienduin + ",type:" + paramObservable.istroop);
                bool = true;
                break;
              }
              bool = true;
              break;
            }
          }
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity
 * JD-Core Version:    0.7.0.1
 */