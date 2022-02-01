package com.tencent.mobileqq.qcircle;

import aabe;
import adak;
import alml;
import alms;
import alpv;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import antf;
import anyu;
import asar;
import asvg;
import asvi;
import asvt;
import awlm;
import axaw;
import bapd;
import bape;
import bapf;
import bdll;
import bhlg;
import bhlj;
import blih;
import blpp;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class QCircleChatMsgListFragment
  extends QCircleBaseFragment
  implements alml, alpv, Handler.Callback, View.OnClickListener, asar, blih, blpp, Observer
{
  int jdField_a_of_type_Int = -1;
  public long a;
  public alms a;
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bapf(this);
  final anyu jdField_a_of_type_Anyu = new bape(this);
  private asvi jdField_a_of_type_Asvi;
  private asvt jdField_a_of_type_Asvt = new bapd(this);
  public DragFrameLayout a;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = "";
  List<MessageRecord> jdField_a_of_type_JavaUtilList;
  Map<String, RecentBaseData> jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  public View b;
  TopGestureLayout jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public List<RecentBaseData> b;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  int jdField_c_of_type_Int;
  private List<Long> jdField_c_of_type_JavaUtilList = new ArrayList();
  public boolean c;
  
  public QCircleChatMsgListFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = bhlg.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", paramInt2);
    startActivity(localIntent);
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    if (paramArrayList != null) {
      this.jdField_c_of_type_JavaUtilList.addAll(paramArrayList);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  private TopGestureLayout b()
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
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(adak.a((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(adak.a((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void c(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        try
        {
          localArrayList.add(Long.valueOf(localMessageRecord.senderuin));
        }
        catch (Exception localException) {}
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramList = (asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
      if (paramList != null) {
        paramList.a(localArrayList);
      }
    }
  }
  
  public int a()
  {
    return 2131561196;
  }
  
  public List<aabe> a()
  {
    return new ArrayList();
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      boolean bool1;
      if (localMessageRecord != null) {
        bool1 = false;
      }
      try
      {
        long l = Long.valueOf(localMessageRecord.senderuin).longValue();
        boolean bool2 = this.jdField_c_of_type_JavaUtilList.contains(Long.valueOf(l));
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        label89:
        RecentMatchChatListItem localRecentMatchChatListItem;
        break label89;
      }
      localRecentMatchChatListItem = new RecentMatchChatListItem(localMessageRecord);
      localRecentMatchChatListItem.mExtendFriendOnline = bool1;
      localRecentMatchChatListItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localArrayList.add(localRecentMatchChatListItem);
      this.jdField_a_of_type_Asvi.a(localMessageRecord.frienduin, true);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370052));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838779);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558926, null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_Alms = new alms(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 13);
      this.jdField_a_of_type_Alms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Alms);
      this.jdField_a_of_type_Alms.a(20);
      this.jdField_a_of_type_MqqOsMqqHandler = new bhlj(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new bhlj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramLayoutInflater = (asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(false);
      }
      return;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("QCircleChatMsgListFragment", 1, paramViewGroup, new Object[0]);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramRecentBaseData.getRecentUserUin())) {
      a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), 21);
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      axaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentMatchChatListItem)paramRecentBaseData, true);
    }
    a();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      paramList = new Message();
      paramList.what = 0;
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(paramList);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData != null)
        {
          boolean bool = TextUtils.equals(localRecentBaseData.getRecentUserUin(), paramString);
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
  
  public void b() {}
  
  public void b(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = b(paramList);
  }
  
  public int c()
  {
    return 0;
  }
  
  public String c()
  {
    return "QCircleChatMsgListFragment";
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    LinkedList localLinkedList = null;
    int i = 50;
    long l;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      b(this.jdField_a_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("QCircleChatMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      c(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 0;
        if (i > 50) {
          break label317;
        }
        j = i;
        label155:
        if ((this.jdField_c_of_type_Int <= j) || (this.jdField_c_of_type_Int > i)) {
          break label590;
        }
        j = this.jdField_c_of_type_Int;
      }
      break;
    }
    label187:
    label317:
    label331:
    label590:
    for (;;)
    {
      if (j > 50)
      {
        this.jdField_c_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("QCircleChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jdField_c_of_type_Int) }));
        }
        localLinkedList = new LinkedList();
        paramMessage = localLinkedList;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          paramMessage = localLinkedList;
          if (i > 0) {
            paramMessage = this.jdField_a_of_type_JavaUtilList.subList(0, j);
          }
        }
        paramMessage = a(paramMessage);
        if (paramMessage == null) {
          break label331;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        return false;
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        j = 50;
        break label155;
        this.jdField_c_of_type_Boolean = false;
        break label187;
      }
      l = System.currentTimeMillis();
      if ((this.jdField_c_of_type_Int > 0) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        int k = this.jdField_c_of_type_Int;
        int m = this.jdField_a_of_type_JavaUtilList.size();
        j = m - this.jdField_c_of_type_Int;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label520;
        }
        this.jdField_c_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("QCircleChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
        }
        paramMessage = a(this.jdField_a_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
        if (paramMessage == null) {
          break label530;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.jdField_c_of_type_Int = i;
        a(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QCircleChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
        this.jdField_c_of_type_Boolean = false;
        i = j;
        break label395;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {}
      for (paramMessage = localLinkedList;; paramMessage = this.jdField_a_of_type_JavaUtilList.subList(0, this.jdField_c_of_type_Int))
      {
        a(a(paramMessage));
        return false;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)
    {
      a();
      ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      ProfileActivity.b(getActivity(), localAllInOne, 1031);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_Asvi = ((asvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    getArguments();
    this.jdField_a_of_type_Int = 10008;
    this.jdField_a_of_type_JavaLangString = antf.aU;
    if (QLog.isDevelopLevel()) {
      QLog.i("QCircleChatMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      }
    }
    if (this.jdField_a_of_type_Alms != null) {
      this.jdField_a_of_type_Alms.b();
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
    a();
    this.jdField_b_of_type_Int = 0;
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
        this.jdField_a_of_type_Alms.a(false);
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
        this.jdField_a_of_type_Alms.a(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = b();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (awlm.a((MessageRecord)paramObject)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      a();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.QCircleChatMsgListFragment
 * JD-Core Version:    0.7.0.1
 */