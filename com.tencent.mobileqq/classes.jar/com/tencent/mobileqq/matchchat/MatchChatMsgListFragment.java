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
  final Handler.Callback A = new MatchChatMsgListFragment.8(this);
  private View B;
  private View C;
  private Object D = new Object();
  private AdvancedTipsBar E;
  private List<Long> F = new ArrayList();
  private long G = 0L;
  private IExpandManager H;
  private ExpandObserver I = new MatchChatMsgListFragment.1(this);
  QQAppInterface a;
  BaseActivity b;
  int c = -1;
  String d = "";
  LinearLayout e;
  View f;
  FPSSwipListView g;
  DragFrameLayout h;
  TopGestureLayout i;
  RecentAdapter j;
  Map<String, RecentBaseData> k;
  boolean l = false;
  boolean m = false;
  long n;
  int o = 0;
  MqqHandler p;
  MqqHandler q;
  List<MessageRecord> r;
  List<RecentBaseData> s;
  boolean t = false;
  int u;
  boolean v = true;
  volatile boolean w = false;
  long x;
  final AvatarObserver y = new MatchChatMsgListFragment.6(this);
  final FriendListObserver z = new MatchChatMsgListFragment.7(this);
  
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
    int i1 = paramBundle.getInt("key_matchchat_from_notification_type", 1044);
    if ((bool) && (!TextUtils.isEmpty(str))) {
      a(str, i1, 21);
    }
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    if (paramLayoutInflater == null) {
      return;
    }
    Resources localResources = this.b.getResources();
    this.B = paramLayoutInflater.inflate(2131627433, this.e, false);
    if ((LinearLayout.LayoutParams)this.B.getLayoutParams() == null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131299612));
      localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131299069);
      this.e.addView(this.B, localLayoutParams);
    }
    else
    {
      this.e.addView(this.B);
    }
    this.B.setOnClickListener(this);
    this.C = paramLayoutInflater.inflate(2131627436, this.e, false);
    if ((LinearLayout.LayoutParams)this.C.getLayoutParams() == null)
    {
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131299070));
      this.e.addView(this.C, paramLayoutInflater);
      return;
    }
    this.e.addView(this.C);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131435219);
    if (localImageView != null)
    {
      String str = this.a.getCurrentAccountUin();
      Object localObject2 = null;
      IFaceDecoder localIFaceDecoder = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
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
        localObject2 = ImageUtil.j();
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    paramView = (TextView)paramView.findViewById(16908308);
    if (paramView != null) {
      paramView.setText(this.a.getCurrentNickname());
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.b, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = ContactUtils.h(this.a, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.a(this.a, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", paramInt2);
    localIntent.putExtra("key_limitchat_enter_type", 6);
    startActivity(localIntent);
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    this.F.clear();
    if (paramArrayList != null) {
      this.F.addAll(paramArrayList);
    }
    paramArrayList = this.p;
    if (paramArrayList != null)
    {
      paramArrayList.removeMessages(2);
      this.p.sendEmptyMessage(2);
    }
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
  
  private Set<Long> d(List<MessageRecord> paramList)
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
  
  private void d()
  {
    setTitle(this.b.getString(2131897003));
    setRightButton(2131897007, new MatchChatMsgListFragment.2(this));
  }
  
  private List<MessageRecord> e(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i1 = paramList.size() - 1;
    while (i1 >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i1)))) {
        localArrayList.add(paramList.get(i1));
      } else {
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i1)));
      }
      i1 -= 1;
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void e()
  {
    if (this.E == null)
    {
      this.E = new AdvancedTipsBar(this.b);
      this.E.setTipsText(this.b.getString(2131896997));
      this.E.setTipsIcon(this.b.getResources().getDrawable(2130839453));
      this.E.setButtonText(this.b.getString(2131896998));
      this.E.getButton().setBackgroundColor(0);
      this.E.getButton().setTextColor(this.b.getResources().getColor(2131168002));
      this.E.b(true);
      this.E.f();
      this.E.setCloseListener(new MatchChatMsgListFragment.4(this));
      this.E.setOnClickListener(new MatchChatMsgListFragment.5(this));
      this.E.setVisibility(8);
      this.e.addView(this.E);
    }
  }
  
  private void f()
  {
    if (this.G > 0L)
    {
      int i1 = (int)((SystemClock.elapsedRealtime() - this.G) / 1000L);
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("");
      localHashMap.put("duration", localStringBuilder.toString());
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("exit#message_page#view", true, -1L, -1L, localHashMap, true, true);
      this.G = 0L;
    }
  }
  
  private void f(List<MessageRecord> paramList)
  {
    long l1 = SystemClock.elapsedRealtime();
    ArrayList localArrayList;
    if ((this.w) || (l1 - this.x > 180000L))
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
      if ((!localArrayList.isEmpty()) && (((IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localArrayList)))
      {
        this.x = l1;
        this.w = false;
      }
      return;
    }
  }
  
  private TopGestureLayout g()
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.getWindow().getDecorView();
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
  
  private void h()
  {
    IExpandHandler localIExpandHandler = (IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localIExpandHandler != null) {
      localIExpandHandler.a(this.a.getCurrentAccountUin(), false);
    }
  }
  
  protected void a()
  {
    MqqHandler localMqqHandler = this.p;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.p.sendEmptyMessage(0);
    }
  }
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.q != null) {
      synchronized (this.D)
      {
        this.s.clear();
        if (paramList != null) {
          this.s.addAll(paramList);
        }
        paramList = new Message();
        paramList.what = 0;
        this.q.removeMessages(0);
        this.q.sendMessage(paramList);
        this.m = false;
        return;
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Iterator localIterator = this.s.iterator();
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
  
  protected List<RecentBaseData> b(List<MessageRecord> paramList)
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
          long l1 = Long.valueOf(localMessageRecord.senderuin).longValue();
          boolean bool2 = this.F.contains(Long.valueOf(l1));
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
        localRecentMatchChatListItem.a(this.a, this.b);
        localArrayList.add(localRecentMatchChatListItem);
        this.H.a(localMessageRecord.frienduin, true);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  protected void b() {}
  
  protected void c(List<MessageRecord> paramList)
  {
    this.r = e(paramList);
  }
  
  protected boolean c()
  {
    int i1 = this.o;
    return (i1 != 0) && (i1 != 1);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.v = ThemeUtil.isDefaultOrDIYTheme(false);
    this.g = ((FPSSwipListView)this.mContentView.findViewById(2131437317));
    try
    {
      this.g.setBackgroundResource(2130838959);
    }
    catch (Throwable paramViewGroup)
    {
      QLog.e("MatchChatMsgListFragment", 1, paramViewGroup, new Object[0]);
    }
    this.h = DragFrameLayout.a(this.b);
    this.h.a(this, false);
    this.e = new LinearLayout(this.b);
    this.e.setOrientation(1);
    this.e.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.g.addHeaderView(this.e, 0);
    this.f = paramLayoutInflater.inflate(2131624518, null);
    this.f.setVisibility(8);
    this.g.addFooterView(this.f);
    this.g.setRightIconMenuListener(this);
    this.g.setOnScrollListener(this);
    this.j = new RecentAdapter(this.b, this.a, this.g, this, 13);
    this.j.a(this.h);
    this.g.setAdapter(this.j);
    this.j.a(20);
    this.p = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    this.q = new CustomHandler(this.b.getMainLooper(), this.A);
    this.k = new ConcurrentHashMap();
    this.s = new ArrayList();
    this.a.addObserver(this.z, true);
    this.a.addObserver(this.y, true);
    this.a.getMessageFacade().addObserver(this);
    if (QLog.isColorLevel()) {
      this.n = System.currentTimeMillis();
    }
    d();
    e();
    a(paramLayoutInflater);
    a(this.B);
    paramLayoutInflater = (IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(false);
    }
    b(this.mContentView);
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = this.i;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627434;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i2 = paramMessage.what;
    paramMessage = null;
    int i1 = 50;
    Object localObject;
    long l1;
    int i3;
    int i4;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MatchChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
        }
        localObject = this.r;
        if (localObject != null) {
          paramMessage = ((List)localObject).subList(0, this.u);
        }
        a(b(paramMessage));
        return false;
      }
      l1 = System.currentTimeMillis();
      i3 = this.u;
      if (i3 > 0)
      {
        paramMessage = this.r;
        if (paramMessage != null)
        {
          i4 = paramMessage.size();
          i2 = i4 - this.u;
          if (i2 <= 0) {
            return false;
          }
          if (i2 > 50)
          {
            this.t = true;
          }
          else
          {
            this.t = false;
            i1 = i2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(i4), Integer.valueOf(i1) }));
          }
          paramMessage = b(this.r.subList(0, i3 - 1 + 1 + i1));
          if (paramMessage != null) {
            i1 = paramMessage.size();
          } else {
            i1 = 0;
          }
          this.u = i1;
          a(paramMessage);
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
        return false;
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      this.r = this.a.getMessageFacade().a(this.d, this.c, null);
      if (this.r == null) {
        this.r = new ArrayList();
      }
      c(this.r);
      if (QLog.isDevelopLevel()) {
        QLog.d("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      f(this.r);
      paramMessage = this.r;
      if (paramMessage == null) {
        i1 = 0;
      } else {
        i1 = paramMessage.size();
      }
      if (i1 <= 50) {
        i2 = i1;
      } else {
        i2 = 50;
      }
      i4 = this.u;
      i3 = i2;
      if (i4 > i2)
      {
        i3 = i2;
        if (i4 <= i1) {
          i3 = i4;
        }
      }
      boolean bool;
      if (i3 > 50) {
        bool = true;
      } else {
        bool = false;
      }
      this.t = bool;
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(this.u) }));
      }
      localObject = new LinkedList();
      List localList = this.r;
      paramMessage = (Message)localObject;
      if (localList != null)
      {
        paramMessage = (Message)localObject;
        if (i1 > 0) {
          paramMessage = localList.subList(0, i3);
        }
      }
      paramMessage = b(paramMessage);
      if (paramMessage != null) {
        i1 = paramMessage.size();
      } else {
        i1 = 0;
      }
      this.u = i1;
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
    if (this.h.getMode() == -1)
    {
      a();
      ((IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442440)
    {
      AllInOne localAllInOne = new AllInOne(this.a.getCurrentAccountUin(), 0);
      ProfileActivity.a(getActivity(), localAllInOne, 1031);
      ReportController.b(this.a, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.G = SystemClock.elapsedRealtime();
    this.b = getBaseActivity();
    this.a = ((QQAppInterface)this.b.getAppInterface());
    this.a.addObserver(this.I);
    this.H = ((IExpandManager)this.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.c = paramBundle.getInt("uintype", -1);
      this.d = paramBundle.getString("uin", "");
    }
    if (!UinTypeUtil.c(this.d, this.c))
    {
      this.c = 1044;
      this.d = AppConstants.MATCH_CHAT_UIN;
    }
    a(paramBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.c), this.d }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.p.removeCallbacksAndMessages(null);
    this.q.removeCallbacksAndMessages(null);
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.z);
      this.a.removeObserver(this.y);
      this.a.removeObserver(this.I);
      if (this.a.getMessageFacade() != null) {
        this.a.getMessageFacade().deleteObserver(this);
      }
    }
    localObject = this.j;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    f();
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onPause()
  {
    super.onPause();
    DragFrameLayout localDragFrameLayout = this.h;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
    f();
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
      MatchChatMsgUtil.a(this.a, (RecentMatchChatListItem)paramRecentBaseData, true);
    }
    a();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    h();
    this.o = 0;
    this.G = SystemClock.elapsedRealtime();
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_page#view", true, -1L, -1L, null, true, true);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.i;
    if (paramView != null) {
      paramView.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.i;
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
    int i1;
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt != 0) && (paramInt != 1)) {
      this.j.a(true);
    } else {
      this.j.a(false);
    }
    this.o = paramInt;
    if ((paramInt == 0) && (this.m))
    {
      paramAbsListView = this.p;
      if (paramAbsListView != null)
      {
        paramAbsListView.removeMessages(0);
        this.p.sendEmptyMessage(0);
      }
    }
    if (i1 != 0)
    {
      paramAbsListView = this.p;
      if (paramAbsListView != null) {
        paramAbsListView.sendEmptyMessage(1);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.i = g();
    TopGestureLayout localTopGestureLayout = this.i;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollRLFlag(false);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(paramObservable)) {
        return;
      }
      if ((!this.w) && (!TextUtils.isEmpty(paramObservable.senderuin)) && (!paramObservable.senderuin.equals(this.a.getCurrentAccountUin())))
      {
        long l1 = Long.valueOf(paramObservable.senderuin).longValue();
        boolean bool = this.w;
        this.w = (d(this.r).contains(Long.valueOf(l1)) ^ true | bool);
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