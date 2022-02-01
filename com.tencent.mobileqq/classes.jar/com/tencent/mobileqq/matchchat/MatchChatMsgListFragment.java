package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
  implements Handler.Callback, View.OnClickListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IFlingSwitch, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, Observer
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new MatchChatMsgListFragment.1(this);
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new MatchChatMsgListFragment.9(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MatchChatMsgListFragment.8(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new MatchChatMsgListFragment.7(this);
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new MatchChatMsgListFragment.2(this);
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private AdvancedTipsBar jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = "";
  List<MessageRecord> jdField_a_of_type_JavaUtilList;
  Map<String, RecentBaseData> jdField_a_of_type_JavaUtilMap;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  List<RecentBaseData> jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  private List<Long> jdField_c_of_type_JavaUtilList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  boolean d = true;
  volatile boolean e = false;
  private boolean f = false;
  
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
    paramContext.startActivity(MatchChatMsgUtil.a(paramContext));
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
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561224, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams() == null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298886));
      localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131298360);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561227, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() != null) {
        break;
      }
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298361));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131368603);
    Object localObject1;
    Object localObject2;
    Bitmap localBitmap;
    if (localImageView != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((IFaceDecoder)localObject2).setDecodeTaskCompletionListener(new MatchChatMsgListFragment.4(this, (String)localObject1, localImageView));
      localBitmap = ((IFaceDecoder)localObject2).getBitmapFromCacheFrom(1, (String)localObject1, 6);
      if (localBitmap != null) {
        break label153;
      }
      if (((IFaceDecoder)localObject2).isPausing()) {
        break label170;
      }
      ((IFaceDecoder)localObject2).requestDecodeFace((String)localObject1, 1, true);
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ImageUtil.c();
      }
      localImageView.setImageDrawable((Drawable)localObject2);
      paramView = (TextView)paramView.findViewById(16908308);
      if (paramView == null) {
        break;
      }
      paramView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      return;
      label153:
      localObject1 = new BitmapDrawable(getResources(), localBitmap);
      continue;
      label170:
      localObject1 = null;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", paramInt2);
    localIntent.putExtra("key_limitchat_enter_type", 6);
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
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void b(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "message_page");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("MatchChatMsgListFragment", 1, "reportDaTongRegister");
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698920));
    setRightButton(2131698924, new MatchChatMsgListFragment.3(this));
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
      if ((!localArrayList.isEmpty()) && (((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localArrayList)))
      {
        this.jdField_b_of_type_Long = l;
        this.e = false;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698914));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839417));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setButtonText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698915));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.a().setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167041));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setCloseListener(new MatchChatMsgListFragment.5(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setOnClickListener(new MatchChatMsgListFragment.6(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar);
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Long > 0L)
    {
      int i = (int)((SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long) / 1000L);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", i + "");
      ExpandReportUtils.a("exit#message_page#view", true, -1L, -1L, localHashMap, true, true);
      this.jdField_c_of_type_Long = 0L;
    }
  }
  
  private void f()
  {
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
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
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(localMessageRecord.frienduin, true);
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
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
      MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentMatchChatListItem)paramRecentBaseData, true);
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
      ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 1);
  }
  
  protected boolean a(String paramString)
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
  
  protected void b() {}
  
  protected void b(List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = b(paramList);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131370493));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838980);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559002, null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 13);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(20);
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      c();
      d();
      a(paramLayoutInflater);
      a(this.jdField_b_of_type_AndroidViewView);
      paramLayoutInflater = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(false);
      }
      b(this.mContentView);
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
    return 2131561225;
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
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null);
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype", -1);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin", "");
    }
    if (!UinTypeUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    e();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    f();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    ExpandReportUtils.a("expose#message_page#view", true, -1L, -1L, null, true, true);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
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
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
    if (!this.f) {
      this.f = SignalBombHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (LimitChatUtil.a(paramObservable)) {}
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