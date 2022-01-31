package com.tencent.mobileqq.dating;

import abta;
import abtg;
import abti;
import ajim;
import ajit;
import ajlb;
import ajlm;
import alof;
import altm;
import alto;
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
import aphs;
import apht;
import aphu;
import apig;
import azqs;
import bdgc;
import bdgf;
import bhtv;
import bibb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
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
  implements ajim, ajlm, Handler.Callback, apig, bhtv, bibb, Observer
{
  public int a;
  public long a;
  public ajit a;
  altm jdField_a_of_type_Altm = new aphs(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aphu(this);
  public View a;
  public ViewStub a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  public RedTouch a;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseMsgBoxActivity.6(this);
  public String a;
  ArrayList<NearbyActivity.TabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List<RecentBaseData> a;
  public Map<String, RecentBaseData> a;
  public MqqHandler a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private List<MessageRecord> jdField_b_of_type_JavaUtilList;
  public MqqHandler b;
  public boolean b;
  public int c;
  public View c;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  private boolean f;
  
  public BaseMsgBoxActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
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
  
  public int a(List<RecentBaseData> paramList)
  {
    int j;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      j = i;
      if (!paramList.hasNext()) {
        break label57;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
      if (localRecentBaseData.mUnreadFlag != 1) {
        break label59;
      }
      i = localRecentBaseData.mUnreadNum + i;
    }
    label57:
    label59:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
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
    this.app.a().c(paramRecentBaseData.a(), this.jdField_a_of_type_Int);
    paramView = paramRecentBaseData.a();
    if (abti.c(paramView))
    {
      paramRecentBaseData = new Intent(this, SayHelloMsgListActivity.class);
      paramRecentBaseData.putExtra("uin", paramView);
      paramRecentBaseData.putExtra("uintype", this.jdField_a_of_type_Int);
      startActivity(paramRecentBaseData);
      if (this.jdField_d_of_type_Boolean) {}
      for (paramView = "1";; paramView = "0")
      {
        azqs.b(this.app, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_say_hi", 0, 0, "", "", paramView, "");
        return;
      }
    }
    paramString = (alto)this.app.getManager(51);
    if (paramString != null) {}
    for (paramBoolean = paramString.b(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean)
      {
        localIntent.putExtra("uintype", 0);
        paramString = bdgc.q(this.app, paramRecentBaseData.a());
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = bdgc.b(this.app, paramRecentBaseData.a(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        if (!this.jdField_d_of_type_Boolean) {
          break label353;
        }
        paramView = "1";
        label232:
        if (!(paramRecentBaseData instanceof RecentSayHelloListItem)) {
          break label365;
        }
        paramString = (RecentSayHelloListItem)paramRecentBaseData;
        if (paramString.commonId > 0) {
          azqs.b(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramString.commonId, 0, "", "", "", "");
        }
        paramString = this.app;
        if (paramRecentBaseData.a() != 1001) {
          break label359;
        }
      }
      label353:
      label359:
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        azqs.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "1", paramView, "");
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.a());
        localIntent.putExtra("NEARBY_MSG_REPORT_SOURCE", "4");
        break;
        paramView = "0";
        break label232;
      }
      label365:
      paramString = this.app;
      if (paramRecentBaseData.a() == 1001) {}
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        azqs.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "0", paramView, "");
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
        if (!abti.c(paramRecentBaseData.a())) {
          break label175;
        }
        ThreadManager.post(new BaseMsgBoxActivity.3(this, paramRecentBaseData.a(), paramRecentBaseData.a()), 8, null, false);
      }
    }
    for (;;)
    {
      if ((alof.ak.equals(paramRecentBaseData.a())) || (alof.aj.equals(paramRecentBaseData.a())))
      {
        azqs.b(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
        azqs.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      return;
      label175:
      this.jdField_b_of_type_JavaLangString = (paramRecentBaseData.a() + "_" + this.jdField_a_of_type_Int);
      ajlb.b(this.app, paramRecentBaseData.a(), this.jdField_a_of_type_Int);
      this.app.a().a(paramRecentBaseData.a(), this.jdField_a_of_type_Int, true, true);
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(0);
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
    return (this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 1);
  }
  
  public void b() {}
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List<MessageRecord> paramList) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561040);
    getWindow().setBackgroundDrawable(null);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("isFromNearby", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("mUnReadMsgNum", -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "BOX UIN:" + this.jdField_a_of_type_JavaLangString + "|BOX TYPE:" + this.jdField_a_of_type_Int);
    }
    if (!abti.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_JavaLangString = alof.H;
      this.jdField_a_of_type_Int = 1001;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131373555));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131365009));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365010);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365011));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365012));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131365754);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131558855, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    if (abti.c(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Ajit = new ajit(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 7);
      this.jdField_a_of_type_Ajit.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Ajit);
      this.jdField_a_of_type_MqqOsMqqHandler = new bdgf(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new bdgf(getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.app.addObserver(this.jdField_a_of_type_Altm);
      this.app.a().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_d_of_type_Boolean)
      {
        ArrayList localArrayList = (ArrayList)paramBundle.getSerializableExtra("tabs");
        if (localArrayList != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
        }
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("msgTabIndex", -1);
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131377363));
          NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new apht(this));
          findViewById(2131377364).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_b_of_type_Int);
          if (this.jdField_c_of_type_Int >= 0) {
            break label722;
          }
          ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, doOnCreate: msgBoxTabIndex=" + this.jdField_b_of_type_Int + ", count=" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return true;
      this.jdField_a_of_type_Ajit = new ajit(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 6);
      break;
      label722:
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_Altm);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_Ajit != null) {
      this.jdField_a_of_type_Ajit.b();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_Ajit != null) && ((alof.ab.equals(this.jdField_a_of_type_JavaLangString)) || (alof.H.equals(this.jdField_a_of_type_JavaLangString))))
    {
      QQMessageFacade.Message localMessage = this.app.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (localMessage != null) {
        this.app.a().a(this.jdField_a_of_type_Int, localMessage.time);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_d_of_type_Int = 0;
  }
  
  public void doOnStart()
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
        if ((this.e <= j) || (this.e > i)) {
          break label520;
        }
        j = this.e;
      }
      break;
    }
    label515:
    label520:
    for (;;)
    {
      if (j > 50)
      {
        this.f = true;
        label156:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "refresh_list|totalCount:" + i + ",curCount:" + this.e + ",loadCount:" + j);
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
        this.e = i;
        a(paramMessage);
        return false;
        i = this.jdField_b_of_type_JavaUtilList.size();
        break;
        j = 50;
        break label124;
        this.f = false;
        break label156;
      }
      l1 = System.currentTimeMillis();
      if ((this.e > 0) && (this.jdField_b_of_type_JavaUtilList != null))
      {
        int k = this.e;
        j = this.jdField_b_of_type_JavaUtilList.size() - this.e;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label505;
        }
        this.f = true;
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
        this.e = i;
        a(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("Q.msg_box", 2, "loadNextPageData cost time:" + (l2 - l1));
        return false;
        label505:
        this.f = false;
        i = j;
        break label366;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.jdField_a_of_type_Ajit.a(false);
      }
      for (;;)
      {
        this.jdField_d_of_type_Int = paramInt;
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
        this.jdField_a_of_type_Ajit.a(true);
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
    if (((abti.a(paramObservable.istroop) == 1010) && (this.jdField_a_of_type_Int == 1010)) || ((abti.a(paramObservable.istroop) == 1001) && (this.jdField_a_of_type_Int == 1001))) {
      bool = true;
    }
    for (;;)
    {
      runOnUiThread(new BaseMsgBoxActivity.5(this, bool));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity
 * JD-Core Version:    0.7.0.1
 */