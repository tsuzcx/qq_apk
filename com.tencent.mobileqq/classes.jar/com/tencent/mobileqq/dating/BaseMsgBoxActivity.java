package com.tencent.mobileqq.dating;

import Override;
import acmw;
import acnf;
import acnh;
import alfv;
import algc;
import alik;
import alje;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anvi;
import anvk;
import aocm;
import arxn;
import arxo;
import arxp;
import arxq;
import aryc;
import aydj;
import bdla;
import bhde;
import blfe;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
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
  implements alfv, alje, Handler.Callback, aryc, blfe, AbsListView.OnScrollListener, Observer
{
  public int a;
  public long a;
  public algc a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new arxp(this);
  public View a;
  public ViewStub a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new arxn(this);
  private aocm jdField_a_of_type_Aocm = new arxq(this);
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  public RedTouch a;
  public TabBarView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseMsgBoxActivity.6(this);
  public String a;
  public ArrayList<NearbyTabInfo> a;
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
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
  
  private String a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_d_of_type_Boolean) && (aydj.a(paramRecentBaseData.getRecentUserUin()))) {
      return aydj.a(paramRecentBaseData.getRecentUserUin()).nick.get();
    }
    return ContactUtils.getDateNickName(this.app, paramRecentBaseData.getRecentUserUin());
  }
  
  private void a(RedDotTextView paramRedDotTextView)
  {
    ThreadManager.getUIHandler().postDelayed(new BaseMsgBoxActivity.8(this, paramRedDotTextView), 1000L);
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
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)paramIntent.getSerializableExtra("tabs");
    if (localArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("msgTabIndex", -1);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378400));
      NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new arxo(this));
      findViewById(2131378401).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_b_of_type_Int);
      if (this.jdField_c_of_type_Int >= 0) {
        break label251;
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_a_of_type_Aocm);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, doOnCreate: msgBoxTabIndex=" + this.jdField_b_of_type_Int + ", count=" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return;
      label251:
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
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
    paramView = paramRecentBaseData.getRecentUserUin();
    if (acnh.b(paramView))
    {
      this.app.getMessageFacade().setReaded(paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      paramRecentBaseData = new Intent(this, SayHelloMsgListActivity.class);
      paramRecentBaseData.putExtra("uin", paramView);
      paramRecentBaseData.putExtra("uintype", this.jdField_a_of_type_Int);
      startActivity(paramRecentBaseData);
      if (this.jdField_d_of_type_Boolean) {}
      for (paramView = "1";; paramView = "0")
      {
        bdla.b(this.app, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_say_hi", 0, 0, "", "", paramView, "");
        return;
      }
    }
    paramString = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramString != null) {}
    for (paramBoolean = paramString.b(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean)
      {
        localIntent.putExtra("uintype", 0);
        paramString = a(paramRecentBaseData);
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = ContactUtils.getBuddyName(this.app, paramRecentBaseData.getRecentUserUin(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        if (!this.jdField_d_of_type_Boolean) {
          break label367;
        }
        paramView = "1";
        label240:
        if (!(paramRecentBaseData instanceof RecentSayHelloListItem)) {
          break label381;
        }
        paramString = (RecentSayHelloListItem)paramRecentBaseData;
        if (paramString.commonId > 0) {
          bdla.b(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramString.commonId, 0, "", "", "", "");
        }
        paramString = this.app;
        if (paramRecentBaseData.getRecentUserType() != 1001) {
          break label374;
        }
      }
      label367:
      label374:
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        bdla.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "1", paramView, "");
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.getRecentUserType());
        localIntent.putExtra("NEARBY_MSG_REPORT_SOURCE", "4");
        break;
        paramView = "0";
        break label240;
      }
      label381:
      paramString = this.app;
      if (paramRecentBaseData.getRecentUserType() == 1001) {}
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        bdla.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "0", paramView, "");
        return;
      }
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      int i = this.app.getConversationFacade().a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      this.app.getMessageFacade().removeMsgFromMsgBox(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramRecentBaseData.getRecentUserUin(), this.app.getCurrentAccountUin());
      if (i > 0)
      {
        if (!acnh.b(paramRecentBaseData.getRecentUserUin())) {
          break label177;
        }
        ThreadManager.post(new BaseMsgBoxActivity.3(this, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()), 8, null, false);
      }
    }
    for (;;)
    {
      if ((AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramRecentBaseData.getRecentUserUin())) || (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramRecentBaseData.getRecentUserUin())))
      {
        bdla.b(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
        bdla.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      return;
      label177:
      this.jdField_b_of_type_JavaLangString = (paramRecentBaseData.getRecentUserUin() + "_" + this.jdField_a_of_type_Int);
      alik.b(this.app, paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int);
      this.app.getMessageFacade().setReaded(paramRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_Int, true, true);
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(List<RecentBaseData> paramList)
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561228);
    getWindow().setBackgroundDrawable(null);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("isFromNearby", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("mUnReadMsgNum", -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "BOX UIN:" + this.jdField_a_of_type_JavaLangString + "|BOX TYPE:" + this.jdField_a_of_type_Int);
    }
    if (!acnh.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_JavaLangString = AppConstants.LBS_HELLO_UIN;
      this.jdField_a_of_type_Int = 1001;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131374400));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131365414));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365415);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365416));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365417));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366172);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131558961, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    if (acnh.b(this.jdField_a_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_Algc = new algc(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 7);; this.jdField_a_of_type_Algc = new algc(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 6))
    {
      this.jdField_a_of_type_Algc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Algc);
      this.jdField_a_of_type_MqqOsMqqHandler = new bhde(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new bhde(getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.app.addObserver(this.jdField_a_of_type_Anvi);
      this.app.getMessageFacade().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_d_of_type_Boolean) {
        a(paramBundle);
      }
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_Anvi);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aocm);
    }
    if (this.jdField_a_of_type_Algc != null) {
      this.jdField_a_of_type_Algc.b();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_Algc != null) && ((AppConstants.DATE_UIN.equals(this.jdField_a_of_type_JavaLangString)) || (AppConstants.LBS_HELLO_UIN.equals(this.jdField_a_of_type_JavaLangString))))
    {
      QQMessageFacade.Message localMessage = this.app.getMessageFacade().getLastMessage(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (localMessage != null) {
        this.app.getConversationFacade().a(this.jdField_a_of_type_Int, localMessage.time);
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
      this.jdField_b_of_type_JavaUtilList = this.app.getMessageProxy(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
        this.jdField_a_of_type_Algc.a(false);
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
        this.jdField_a_of_type_Algc.a(true);
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
    if (((acnh.a(paramObservable.istroop) == 1010) && (this.jdField_a_of_type_Int == 1010)) || ((acnh.a(paramObservable.istroop) == 1001) && (this.jdField_a_of_type_Int == 1001))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity
 * JD-Core Version:    0.7.0.1
 */