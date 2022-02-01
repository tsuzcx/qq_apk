package com.tencent.mobileqq.matchchat;

import acnh;
import aici;
import alfv;
import algc;
import alje;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anvi;
import aryc;
import aslm;
import aslo;
import aslz;
import asmj;
import asru;
import aweo;
import awud;
import awue;
import awuf;
import awug;
import awuh;
import awui;
import bdla;
import bhde;
import blfe;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
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

public class MatchChatMsgListFragment
  extends IphoneTitleBarFragment
  implements alfv, alje, Handler.Callback, View.OnClickListener, aryc, blfe, AbsListView.OnScrollListener, Observer
{
  int jdField_a_of_type_Int = -1;
  public long a;
  public algc a;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new awud(this);
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new awuh(this);
  public View a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final anvi jdField_a_of_type_Anvi = new awug(this);
  private aslo jdField_a_of_type_Aslo;
  private aslz jdField_a_of_type_Aslz = new awue(this);
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  public BaseActivity a;
  public QQAppInterface a;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = "";
  List<MessageRecord> jdField_a_of_type_JavaUtilList;
  Map<String, RecentBaseData> jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  public List<RecentBaseData> b;
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private List<Long> jdField_c_of_type_JavaUtilList = new ArrayList();
  public boolean c;
  boolean d = true;
  volatile boolean e = false;
  private boolean f;
  
  public MatchChatMsgListFragment()
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
  
  private Set<Long> a(List<MessageRecord> paramList)
  {
    HashSet localHashSet = new HashSet();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        try
        {
          localHashSet.add(Long.valueOf(localMessageRecord.senderuin));
        }
        catch (Exception localException) {}
      }
    }
    return localHashSet;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext.startActivity(awui.a(paramContext));
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    boolean bool;
    String str;
    int i;
    do
    {
      return;
      bool = paramBundle.getBoolean("key_matchchat_from_notification", false);
      str = paramBundle.getString("key_matchchat_from_notification_uin", "");
      i = paramBundle.getInt("key_matchchat_from_notification_type", 1044);
    } while ((!bool) || (TextUtils.isEmpty(str)));
    a(str, i, 21);
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    if (paramLayoutInflater == null) {
      return;
    }
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561130, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams() == null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298799));
      localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131298274);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561133, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() != null) {
        break;
      }
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298275));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = ContactUtils.getDateNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", paramInt2);
    localIntent.putExtra("key_limitchat_enter_type", aici.g);
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
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(acnh.a((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(acnh.a((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698618));
    setRightButton(2131698622, new awuf(this));
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      ImageView localImageView = (ImageView)paramView.findViewById(2131368381);
      if (localImageView != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localImageView.setImageDrawable(asmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      }
      paramView = (TextView)paramView.findViewById(16908308);
    } while (paramView == null);
    paramView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
  }
  
  private void c(List<MessageRecord> paramList)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.e) || (l - this.jdField_b_of_type_Long > 180000L))
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
      if ((!localArrayList.isEmpty()) && (((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localArrayList)))
      {
        this.jdField_b_of_type_Long = l;
        this.e = false;
      }
    }
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
      this.jdField_a_of_type_Aslo.a(localMessageRecord.frienduin, true);
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
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
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
      awui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentMatchChatListItem)paramRecentBaseData, true);
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
      a();
      ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = b(paramList);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131370221));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838912);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558961, null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_Algc = new algc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 13);
      this.jdField_a_of_type_Algc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Algc);
      this.jdField_a_of_type_Algc.a(20);
      this.jdField_a_of_type_MqqOsMqqHandler = new bhde(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new bhde(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      c();
      a(paramLayoutInflater);
      c(this.jdField_b_of_type_AndroidViewView);
      paramLayoutInflater = (aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(false);
      }
      return;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("MatchChatMsgListFragment", 1, paramViewGroup, new Object[0]);
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561131;
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
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      b(this.jdField_a_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
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
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jdField_c_of_type_Int) }));
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
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
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
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
        this.jdField_c_of_type_Boolean = false;
        i = j;
        break label395;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_Aslo = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype", -1);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin", "");
    }
    if (!acnh.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Int = 1044;
      this.jdField_a_of_type_JavaLangString = AppConstants.MATCH_CHAT_UIN;
    }
    a(paramBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
    }
    if (this.jdField_a_of_type_Algc != null) {
      this.jdField_a_of_type_Algc.b();
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
        this.jdField_a_of_type_Algc.a(false);
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
        this.jdField_a_of_type_Algc.a(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
    if (!this.f) {
      this.f = asru.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (aweo.a(paramObservable)) {}
    }
    label108:
    while (!(paramObject instanceof RecentUser))
    {
      return;
      boolean bool2;
      if ((!this.e) && (!TextUtils.isEmpty(paramObservable.senderuin)) && (!paramObservable.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        long l = Long.valueOf(paramObservable.senderuin).longValue();
        bool2 = this.e;
        if (a(this.jdField_a_of_type_JavaUtilList).contains(Long.valueOf(l))) {
          break label108;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.e = (bool1 | bool2);
        a();
        return;
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment
 * JD-Core Version:    0.7.0.1
 */