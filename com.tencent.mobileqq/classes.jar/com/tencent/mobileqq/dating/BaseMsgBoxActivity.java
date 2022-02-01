package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.NearbyActivityHelper;
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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils;
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.INearbyTabBuilder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public static final int LOAD_COUNT_PER_PAGE = 50;
  public static final int MSG_LOAD_NEXT_PAGE = 1;
  public static final int MSG_REFRESH_LIST_GLOBAL = 0;
  private static final int MSG_REFRESH_LIST_UI = 0;
  private static final int MSG_REFRESH_NEARBY_UNREAD = 1;
  protected static final String TAG = "Q.msg_box";
  protected boolean isFromNearby = false;
  protected boolean isFromQQNearby = false;
  AvatarObserver mAvatarObserver = new BaseMsgBoxActivity.1(this);
  ImageView mBottomBarIcon;
  TextView mBottomBarText;
  protected int mBoxMsgType = -1;
  protected String mBoxUIN = "";
  private int mCurItemCount;
  String mDelItemKey = "";
  DragFrameLayout mDragHost;
  View mEmptyTipLayout;
  View mFooterView;
  FriendListObserver mFriendListObserver = new BaseMsgBoxActivity.2(this);
  TopGestureLayout mGestureLayout;
  private boolean mHasMore = false;
  boolean mHasOneWayMsg = false;
  boolean mInitUI = false;
  long mInitUITime;
  protected boolean mIsNeedShowRedDot = false;
  ViewStub mLoadingView;
  private List<MessageRecord> mMRListData;
  View mMsgBar;
  protected int mMsgBoxTabIndex = -1;
  Map<String, RecentBaseData> mMsgItemCache;
  FPSSwipListView mMsgList;
  protected RedTouch mMsgTabRedTouch = null;
  boolean mNeedRefreshList = false;
  String mOneWayBoxUin = "";
  RecentAdapter mRecentAdapter;
  List<RecentBaseData> mRecentListData;
  private RedpointObserver mRedpointObserver = new BaseMsgBoxActivity.8(this);
  MqqHandler mRefreshHandler;
  private int mScrollState = 0;
  TabBarView mTabBarView;
  ArrayList<INearbyTabInfo> mTabInfos = new ArrayList();
  private TabLayoutCompat mTabLayout;
  private Handler.Callback mUICallback = new BaseMsgBoxActivity.5(this);
  MqqHandler mUIHandler;
  protected int mUnReadMsgNum = -1;
  private Runnable nearbyDelayInitUnReadMsg = new BaseMsgBoxActivity.7(this);
  
  private TopGestureLayout getGestureLayout()
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
  
  private String getNickname(RecentBaseData paramRecentBaseData)
  {
    if ((this.isFromNearby) && (MiniCardManagerUtils.a(paramRecentBaseData.getRecentUserUin()))) {
      return MiniCardManagerUtils.b(paramRecentBaseData.getRecentUserUin()).nick.get();
    }
    return ContactUtils.h(this.app, paramRecentBaseData.getRecentUserUin());
  }
  
  private void updateNearbyTabRedDot(RedDotTextView paramRedDotTextView)
  {
    ThreadManager.getUIHandler().postDelayed(new BaseMsgBoxActivity.9(this, paramRedDotTextView), 1000L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.isFromQQNearby = paramBundle.getBooleanExtra("isFromQQNearby", false);
    ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).setNearbyVersion(this.isFromQQNearby);
    if (this.isFromQQNearby)
    {
      setContentView(2131625510);
      ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).initStatusBar(this);
    }
    else
    {
      setContentView(2131627524);
    }
    getWindow().setBackgroundDrawable(null);
    this.mBoxMsgType = paramBundle.getIntExtra("uintype", -1);
    this.mBoxUIN = paramBundle.getStringExtra("uin");
    this.isFromNearby = paramBundle.getBooleanExtra("isFromNearby", false);
    this.mUnReadMsgNum = paramBundle.getIntExtra("mUnReadMsgNum", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BOX UIN:");
      ((StringBuilder)localObject).append(this.mBoxUIN);
      ((StringBuilder)localObject).append("|BOX TYPE:");
      ((StringBuilder)localObject).append(this.mBoxMsgType);
      QLog.d("Q.msg_box", 2, ((StringBuilder)localObject).toString());
    }
    if (!UinTypeUtil.c(this.mBoxUIN, this.mBoxMsgType))
    {
      this.mBoxUIN = AppConstants.LBS_HELLO_UIN;
      this.mBoxMsgType = 1001;
    }
    this.mLoadingView = ((ViewStub)findViewById(2131442441));
    Object localObject = this.mLoadingView;
    if (localObject == null)
    {
      QLog.e("Q.msg_box", 1, "mLoadingView is null finish");
      finish();
      return false;
    }
    ((ViewStub)localObject).setVisibility(0);
    this.mMsgList = ((FPSSwipListView)findViewById(2131431626));
    this.mMsgBar = findViewById(2131431627);
    this.mBottomBarIcon = ((ImageView)this.mMsgBar.findViewById(2131431628));
    this.mBottomBarText = ((TextView)this.mMsgBar.findViewById(2131431629));
    this.mEmptyTipLayout = findViewById(2131432522);
    this.mDragHost = DragFrameLayout.a(this);
    this.mDragHost.a(this, false);
    this.mFooterView = getLayoutInflater().inflate(2131624518, null);
    this.mMsgList.addFooterView(this.mFooterView);
    this.mMsgList.setRightIconMenuListener(this);
    this.mMsgList.setOnScrollListener(this);
    if (UinTypeUtil.c(this.mBoxUIN)) {
      this.mRecentAdapter = new RecentAdapter(this, this.app, this.mMsgList, this, 7);
    } else {
      this.mRecentAdapter = new RecentAdapter(this, this.app, this.mMsgList, this, 6);
    }
    this.mRecentAdapter.a(this.mDragHost);
    this.mMsgList.setAdapter(this.mRecentAdapter);
    this.mRefreshHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    this.mUIHandler = new CustomHandler(getMainLooper(), this.mUICallback);
    this.mMsgItemCache = new ConcurrentHashMap();
    this.mRecentListData = new ArrayList();
    this.app.addObserver(this.mFriendListObserver);
    this.app.addObserver(this.mAvatarObserver);
    this.app.getMessageFacade().addObserver(this);
    if (QLog.isColorLevel()) {
      this.mInitUITime = System.currentTimeMillis();
    }
    if (this.isFromQQNearby)
    {
      this.mTabLayout = ((TabLayoutCompat)findViewById(2131446755));
      localObject = paramBundle.getIntegerArrayListExtra("tabTypes");
      ArrayList localArrayList = paramBundle.getStringArrayListExtra("tabNames");
      ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).buildTabByConfig((ArrayList)localObject, localArrayList, this, this.mTabLayout);
    }
    if ((this.isFromNearby) && (!this.isFromQQNearby)) {
      initNearbyTabs(paramBundle);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getUIHandler().removeCallbacks(this.nearbyDelayInitUnReadMsg);
    Object localObject = this.mRefreshHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.mUIHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    removeObserver(this.mFriendListObserver);
    removeObserver(this.mAvatarObserver);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.app != null) {
      this.app.removeObserver(this.mRedpointObserver);
    }
    localObject = this.mRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    if (this.isFromQQNearby) {
      ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).setNearbyVersion(false);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.mDragHost;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    if ((this.app != null) && (this.mRecentAdapter != null) && ((AppConstants.DATE_UIN.equals(this.mBoxUIN)) || (AppConstants.LBS_HELLO_UIN.equals(this.mBoxUIN))))
    {
      localObject = this.app.getMessageFacade().getLastMessage(this.mBoxUIN, this.mBoxMsgType);
      if (localObject != null) {
        this.app.getConversationFacade().a(this.mBoxMsgType, ((com.tencent.imcore.message.Message)localObject).time);
      }
    }
    if (this.isFromQQNearby) {
      ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).setNearbyVersion(false);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    refreshListGlobal();
    this.mScrollState = 0;
    if (this.isFromQQNearby) {
      ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).setNearbyVersion(true);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.mGestureLayout = getGestureLayout();
  }
  
  protected void doRefreshUI(List<RecentBaseData> paramList)
  {
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      localObject = ((MqqHandler)localObject).obtainMessage(0);
      ((android.os.Message)localObject).what = 0;
      ((android.os.Message)localObject).obj = paramList;
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.sendMessage((android.os.Message)localObject);
      this.mNeedRefreshList = false;
    }
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = this.mGestureLayout;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public int getUnReadMsgNum(List<RecentBaseData> paramList)
  {
    int j = 0;
    int i = 0;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if (localRecentBaseData.mUnreadFlag == 1) {
          i += localRecentBaseData.mUnreadNum;
        }
      }
    }
    return j;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 50;
    long l1;
    int k;
    if (j != 0)
    {
      if (j != 1) {
        return false;
      }
      l1 = System.currentTimeMillis();
      k = this.mCurItemCount;
      if (k > 0)
      {
        paramMessage = this.mMRListData;
        if (paramMessage != null)
        {
          j = paramMessage.size() - this.mCurItemCount;
          if (j <= 0) {
            return false;
          }
          if (j > 50)
          {
            this.mHasMore = true;
          }
          else
          {
            this.mHasMore = false;
            i = j;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("loadNextPageData|totalCount:");
            paramMessage.append(this.mMRListData.size());
            paramMessage.append(",loadCount:");
            paramMessage.append(i);
            QLog.d("Q.msg_box", 2, paramMessage.toString());
          }
          paramMessage = makeRecetBaseData(this.mMRListData.subList(0, k - 1 + 1 + i));
          if (paramMessage != null) {
            i = paramMessage.size();
          } else {
            i = 0;
          }
          this.mCurItemCount = i;
          doRefreshUI(paramMessage);
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        paramMessage = new StringBuilder();
        paramMessage.append("loadNextPageData cost time:");
        paramMessage.append(l2 - l1);
        QLog.d("Q.msg_box", 2, paramMessage.toString());
        return false;
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      this.mMRListData = this.app.getMessageProxy(this.mBoxMsgType).b(this.mBoxUIN, this.mBoxMsgType);
      preProcessMessageList(this.mMRListData);
      if (QLog.isDevelopLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("cloneMsgBoxList cost time: ");
        paramMessage.append(System.currentTimeMillis() - l1);
        QLog.d("Q.msg_box", 4, paramMessage.toString());
      }
      paramMessage = this.mMRListData;
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
      int m = this.mCurItemCount;
      k = j;
      if (m > j)
      {
        k = j;
        if (m <= i) {
          k = m;
        }
      }
      if (k > 50) {
        this.mHasMore = true;
      } else {
        this.mHasMore = false;
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("refresh_list|totalCount:");
        paramMessage.append(i);
        paramMessage.append(",curCount:");
        paramMessage.append(this.mCurItemCount);
        paramMessage.append(",loadCount:");
        paramMessage.append(k);
        QLog.d("Q.msg_box", 2, paramMessage.toString());
      }
      LinkedList localLinkedList = new LinkedList();
      List localList = this.mMRListData;
      paramMessage = localLinkedList;
      if (localList != null)
      {
        paramMessage = localLinkedList;
        if (i > 0) {
          paramMessage = localList.subList(0, k);
        }
      }
      paramMessage = makeRecetBaseData(paramMessage);
      if (paramMessage != null) {
        i = paramMessage.size();
      } else {
        i = 0;
      }
      this.mCurItemCount = i;
      doRefreshUI(paramMessage);
    }
    return false;
  }
  
  protected void initNearbyTabs(Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)paramIntent.getSerializableExtra("tabs");
    if (localArrayList != null)
    {
      this.mTabInfos.clear();
      this.mTabInfos.addAll(localArrayList);
    }
    this.mMsgBoxTabIndex = paramIntent.getIntExtra("msgTabIndex", -1);
    if (this.mTabInfos.size() > 0)
    {
      int i = this.mMsgBoxTabIndex;
      if ((i >= 0) && (i < this.mTabInfos.size()))
      {
        this.mTabBarView = ((TabBarView)findViewById(2131446735));
        NearbyActivityHelper.a(this, this.mTabBarView, this.mTabInfos);
        this.mTabBarView.setOnTabChangeListener(new BaseMsgBoxActivity.3(this));
        findViewById(2131446736).setVisibility(0);
        this.mTabBarView.setVisibility(0);
        this.mTabBarView.setSelectedTab(this.mMsgBoxTabIndex, false);
        this.mMsgTabRedTouch = NearbyActivityHelper.a(this, this.mTabBarView, this.mTabInfos.size(), this.mMsgBoxTabIndex);
        if (this.mUnReadMsgNum < 0) {
          ThreadManager.getUIHandler().postDelayed(this.nearbyDelayInitUnReadMsg, 5000L);
        } else {
          ThreadManager.getUIHandler().post(this.nearbyDelayInitUnReadMsg);
        }
        this.app.addObserver(this.mRedpointObserver);
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("BaseMsgBoxActivity, doOnCreate: msgBoxTabIndex=");
      paramIntent.append(this.mMsgBoxTabIndex);
      paramIntent.append(", count=");
      paramIntent.append(this.mTabInfos.size());
      QLog.d("nearby.msgbox.tab", 2, paramIntent.toString());
    }
  }
  
  public void initQQNearbyTabs(int paramInt)
  {
    ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).initQQNearbyTabs(this, this.mTabLayout, this.mRedpointObserver, paramInt, this.mIsNeedShowRedDot, this.mUnReadMsgNum);
  }
  
  protected boolean isListViewScrolling()
  {
    int i = this.mScrollState;
    return (i != 0) && (i != 1);
  }
  
  protected List<RecentBaseData> makeRecetBaseData(List<MessageRecord> paramList)
  {
    return null;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.mDragHost.getMode() == -1) {
      refreshListGlobal();
    }
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    String str = paramRecentBaseData.getRecentUserUin();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onRecentBaseDataClick, uin=");
      paramView.append(str);
      QLog.i("Q.msg_box", 2, paramView.toString());
    }
    if (UinTypeUtil.c(str))
    {
      this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
      paramView = new Intent(this, SayHelloMsgListActivity.class);
      paramView.putExtra("uin", str);
      paramView.putExtra("uintype", this.mBoxMsgType);
      paramView.putExtra("isFromNearby", this.isFromNearby);
      startActivity(paramView);
      if (this.isFromNearby) {
        paramView = "1";
      } else {
        paramView = "0";
      }
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_say_hi", 0, 0, "", "", paramView, "");
      return;
    }
    paramView = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramView != null) {
      paramBoolean = paramView.n(str);
    } else {
      paramBoolean = false;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", str);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onRecentBaseDataClick, uin=");
      paramView.append(str);
      paramView.append(", isFriend=");
      paramView.append(paramBoolean);
      QLog.i("Q.msg_box", 2, paramView.toString());
    }
    if (paramBoolean)
    {
      localIntent.putExtra("uintype", 0);
    }
    else
    {
      localIntent.putExtra("uintype", paramRecentBaseData.getRecentUserType());
      localIntent.putExtra("NEARBY_MSG_REPORT_SOURCE", "4");
    }
    paramString = getNickname(paramRecentBaseData);
    paramView = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramView = ContactUtils.a(this.app, paramRecentBaseData.getRecentUserUin(), false);
    }
    localIntent.putExtra("uinname", paramView);
    startActivity(localIntent);
    if (this.isFromNearby) {
      paramView = "1";
    } else {
      paramView = "0";
    }
    if ((paramRecentBaseData instanceof RecentSayHelloListItem))
    {
      paramString = (RecentSayHelloListItem)paramRecentBaseData;
      if (paramString.commonId > 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramString.commonId, 0, "", "", "", "");
      }
      paramString = this.app;
      if (paramRecentBaseData.getRecentUserType() == 1001) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "1", paramView, "");
    }
    else
    {
      paramString = this.app;
      if (paramRecentBaseData.getRecentUserType() == 1001) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "0", paramView, "");
    }
    if (this.isFromNearby) {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMsgListItemClick(this.app, str);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      int i = this.app.getConversationFacade().a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      this.app.getMessageFacade().a(this.mBoxUIN, this.mBoxMsgType, paramRecentBaseData.getRecentUserUin(), this.app.getCurrentAccountUin());
      if (i > 0) {
        if (UinTypeUtil.c(paramRecentBaseData.getRecentUserUin()))
        {
          ThreadManager.post(new BaseMsgBoxActivity.4(this, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()), 8, null, false);
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(paramRecentBaseData.getRecentUserUin());
          paramString.append("_");
          paramString.append(this.mBoxMsgType);
          this.mDelItemKey = paramString.toString();
          RecentUtil.b(this.app, paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
          this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType, true, true);
        }
      }
      if ((AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramRecentBaseData.getRecentUserUin())) || (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramRecentBaseData.getRecentUserUin())))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void onRefreshRecentListData() {}
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.mGestureLayout;
    if (paramView != null) {
      paramView.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.mGestureLayout;
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
      this.mRecentAdapter.a(true);
    } else {
      this.mRecentAdapter.a(false);
    }
    this.mScrollState = paramInt;
    if ((paramInt == 0) && (this.mNeedRefreshList))
    {
      paramAbsListView = this.mRefreshHandler;
      if (paramAbsListView != null)
      {
        paramAbsListView.removeMessages(0);
        this.mRefreshHandler.sendEmptyMessage(0);
      }
    }
    if (i != 0)
    {
      paramAbsListView = this.mRefreshHandler;
      if (paramAbsListView != null) {
        paramAbsListView.sendEmptyMessage(1);
      }
    }
  }
  
  protected void preProcessMessageList(List<MessageRecord> paramList) {}
  
  protected void refreshListGlobal()
  {
    MqqHandler localMqqHandler = this.mRefreshHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.mRefreshHandler.sendEmptyMessage(0);
    }
  }
  
  public void setMsgTabRedTouch(RedTouch paramRedTouch)
  {
    this.mMsgTabRedTouch = paramRedTouch;
    if (this.mUnReadMsgNum < 0)
    {
      ThreadManager.getUIHandler().postDelayed(this.nearbyDelayInitUnReadMsg, 5000L);
      return;
    }
    ThreadManager.getUIHandler().post(this.nearbyDelayInitUnReadMsg);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (this.mInitUI)
      {
        if (TextUtils.isEmpty(paramObservable.senderuin)) {
          return;
        }
        paramObject = new StringBuilder();
        paramObject.append(paramObservable.senderuin);
        paramObject.append("_");
        paramObject.append(paramObservable.istroop);
        paramObject = paramObject.toString();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("update key:");
          ((StringBuilder)localObject).append(paramObject);
          ((StringBuilder)localObject).append("|mDelItemKey:");
          ((StringBuilder)localObject).append(this.mDelItemKey);
          QLog.d("Q.msg_box", 2, ((StringBuilder)localObject).toString());
        }
        if (paramObject.equals(this.mDelItemKey))
        {
          this.mDelItemKey = "";
          return;
        }
        int i = UinTypeUtil.e(paramObservable.istroop);
        boolean bool2 = true;
        boolean bool1;
        if (i == 1010)
        {
          bool1 = bool2;
          if (this.mBoxMsgType == 1010) {}
        }
        else if ((UinTypeUtil.e(paramObservable.istroop) == 1001) && (this.mBoxMsgType == 1001))
        {
          bool1 = bool2;
        }
        else
        {
          paramObject = this.mMRListData;
          if ((paramObject != null) && (paramObject.size() > 0))
          {
            paramObject = new ArrayList(this.mMRListData).iterator();
            while (paramObject.hasNext())
            {
              localObject = (MessageRecord)paramObject.next();
              if (paramObservable.frienduin.equals(((MessageRecord)localObject).senderuin))
              {
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break label352;
                }
                paramObject = new StringBuilder();
                paramObject.append("needRefresh update,uin:");
                paramObject.append(paramObservable.frienduin);
                paramObject.append(",type:");
                paramObject.append(paramObservable.istroop);
                QLog.d("Q.msg_box", 2, paramObject.toString());
                bool1 = bool2;
                break label352;
              }
            }
          }
          bool1 = false;
        }
        label352:
        runOnUiThread(new BaseMsgBoxActivity.6(this, bool1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity
 * JD-Core Version:    0.7.0.1
 */