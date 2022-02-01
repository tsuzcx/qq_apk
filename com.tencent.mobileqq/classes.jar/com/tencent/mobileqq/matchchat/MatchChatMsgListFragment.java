package com.tencent.mobileqq.matchchat;

import android.content.Context;
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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
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
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new MatchChatMsgListFragment.8(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MatchChatMsgListFragment.7(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new MatchChatMsgListFragment.6(this);
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private IExpandManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager;
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new MatchChatMsgListFragment.1(this);
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
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (paramList.hasNext()) {
        localMessageRecord = (MessageRecord)paramList.next();
      }
      try
      {
        localHashSet.add(Long.valueOf(localMessageRecord.senderuin));
      }
      catch (Exception localException) {}
      return localHashSet;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext.startActivity(MatchChatMsgUtil.a(paramContext));
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool = paramBundle.getBoolean("key_matchchat_from_notification", false);
    String str = paramBundle.getString("key_matchchat_from_notification_uin", "");
    int i = paramBundle.getInt("key_matchchat_from_notification_type", 1044);
    if ((bool) && (!TextUtils.isEmpty(str))) {
      a(str, i, 21);
    }
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    if (paramLayoutInflater == null) {
      return;
    }
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561085, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams() == null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298890));
      localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131298355);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561088, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams() == null)
    {
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298356));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, paramLayoutInflater);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131368343);
    if (localImageView != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = null;
      IFaceDecoder localIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localIFaceDecoder.setDecodeTaskCompletionListener(new MatchChatMsgListFragment.3(this, str, localImageView));
      Object localObject1 = localIFaceDecoder.getBitmapFromCacheFrom(1, str, 6);
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        if (!localIFaceDecoder.isPausing())
        {
          localIFaceDecoder.requestDecodeFace(str, 1, true);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ImageUtil.e();
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    paramView = (TextView)paramView.findViewById(16908308);
    if (paramView != null) {
      paramView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
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
    paramArrayList = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramArrayList != null)
    {
      paramArrayList.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      } else {
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
      i -= 1;
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void b(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    VideoReport.setPageId(paramView, "message_page");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0AND0Y11VZ3PFHQD");
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    QLog.i("MatchChatMsgListFragment", 1, "reportDaTongRegister");
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698999));
    setRightButton(2131699003, new MatchChatMsgListFragment.2(this));
  }
  
  private void c(List<MessageRecord> paramList)
  {
    long l = SystemClock.elapsedRealtime();
    ArrayList localArrayList;
    if ((this.e) || (l - this.jdField_b_of_type_Long > 180000L))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramList = paramList.iterator();
      }
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (paramList.hasNext()) {
        localMessageRecord = (MessageRecord)paramList.next();
      }
      try
      {
        localArrayList.add(Long.valueOf(localMessageRecord.senderuin));
      }
      catch (Exception localException) {}
      if ((!localArrayList.isEmpty()) && (((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localArrayList)))
      {
        this.jdField_b_of_type_Long = l;
        this.e = false;
      }
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698993));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839273));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setButtonText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698994));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.a().setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.a().setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167064));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setCloseListener(new MatchChatMsgListFragment.4(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAdvancedTipsBar.setOnClickListener(new MatchChatMsgListFragment.5(this));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localHashMap.put("duration", localStringBuilder.toString());
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("exit#message_page#view", true, -1L, -1L, localHashMap, true, true);
      this.jdField_c_of_type_Long = 0L;
    }
  }
  
  private void f()
  {
    IExpandHandler localIExpandHandler = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localIExpandHandler != null) {
      localIExpandHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
  }
  
  protected List<RecentBaseData> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
          label92:
          RecentMatchChatListItem localRecentMatchChatListItem;
          break label92;
        }
        localRecentMatchChatListItem = new RecentMatchChatListItem(localMessageRecord);
        localRecentMatchChatListItem.mExtendFriendOnline = bool1;
        localRecentMatchChatListItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localArrayList.add(localRecentMatchChatListItem);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a(localMessageRecord.frienduin, true);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  protected void a()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
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
  }
  
  protected boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    return (i != 0) && (i != 1);
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
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
  
  protected void b() {}
  
  protected void b(List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = b(paramList);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131370153));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838740);
    }
    catch (Throwable paramViewGroup)
    {
      QLog.e("MatchChatMsgListFragment", 1, paramViewGroup, new Object[0]);
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
    paramLayoutInflater = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(false);
    }
    b(this.mContentView);
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
    return 2131561086;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    paramMessage = null;
    int i = 50;
    Object localObject;
    long l;
    int k;
    int m;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MatchChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
        }
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null) {
          paramMessage = ((List)localObject).subList(0, this.jdField_c_of_type_Int);
        }
        a(a(paramMessage));
        return false;
      }
      l = System.currentTimeMillis();
      k = this.jdField_c_of_type_Int;
      if (k > 0)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilList;
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
            QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
          }
          paramMessage = a(this.jdField_a_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
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
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
      }
    }
    else
    {
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
      paramMessage = this.jdField_a_of_type_JavaUtilList;
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
      boolean bool;
      if (k > 50) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
      localObject = new LinkedList();
      List localList = this.jdField_a_of_type_JavaUtilList;
      paramMessage = (Message)localObject;
      if (localList != null)
      {
        paramMessage = (Message)localObject;
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
      a();
      ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374277)
    {
      AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      ProfileActivity.a(getActivity(), localAllInOne, 1031);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    e();
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onPause()
  {
    super.onPause();
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
    e();
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramRecentBaseData.getRecentUserUin())) {
      a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), 21);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentMatchChatListItem)paramRecentBaseData, true);
    }
    a();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    f();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_page#view", true, -1L, -1L, null, true, true);
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
  
  public void onStop()
  {
    super.onStop();
    ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(paramObservable)) {
        return;
      }
      if ((!this.e) && (!TextUtils.isEmpty(paramObservable.senderuin)) && (!paramObservable.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        long l = Long.valueOf(paramObservable.senderuin).longValue();
        boolean bool = this.e;
        this.e = (a(this.jdField_a_of_type_JavaUtilList).contains(Long.valueOf(l)) ^ true | bool);
      }
      a();
      return;
    }
    if ((paramObject instanceof RecentUser)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment
 * JD-Core Version:    0.7.0.1
 */