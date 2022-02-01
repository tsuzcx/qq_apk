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
  final List<RecentBaseData> a = new LinkedList();
  protected QQAppInterface b;
  protected BaseActivity c;
  int d = -1;
  String e = "";
  LinearLayout f;
  View g;
  FPSSwipListView h;
  DragFrameLayout i;
  TopGestureLayout j;
  RecentAdapter k;
  Map<String, RecentBaseData> l;
  boolean m = false;
  boolean n = false;
  long o;
  int p = 0;
  MqqHandler q;
  MqqHandler r;
  List<MessageRecord> s;
  List<RecentBaseData> t;
  boolean u = false;
  int v;
  boolean w = true;
  final AvatarObserver x = new BaseMsgListFragment.2(this);
  final FriendListObserver y = new BaseMsgListFragment.3(this);
  final Handler.Callback z = new BaseMsgListFragment.4(this);
  
  private TopGestureLayout f()
  {
    ViewGroup localViewGroup = (ViewGroup)this.c.getWindow().getDecorView();
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
      Object localObject = this.b.getMessageFacade();
      if (localObject != null)
      {
        int i1 = ((QQMessageFacade)localObject).w();
        localObject = HardCodeUtil.a(2131899266);
        if (i1 > 99)
        {
          String.format(Locale.getDefault(), "%s(99+)", new Object[] { HardCodeUtil.a(2131899269) });
          localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131899264), new Object[] { HardCodeUtil.a(2131899267) });
        }
        else if (i1 <= 0)
        {
          HardCodeUtil.a(2131899271);
        }
        else
        {
          String.format(Locale.getDefault(), "%s(%s)", new Object[] { HardCodeUtil.a(2131899268), Integer.valueOf(i1) });
          localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131899265), new Object[] { Integer.valueOf(i1), HardCodeUtil.a(2131899270) });
        }
        localTextView.setContentDescription((CharSequence)localObject);
      }
    }
  }
  
  protected void a(List<RecentBaseData> paramList)
  {
    if (this.r != null) {
      synchronized (this.a)
      {
        Iterator localIterator = this.t.iterator();
        while (localIterator.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
          if (localRecentBaseData != null) {
            this.a.add(localRecentBaseData);
          }
        }
        this.t.clear();
        if (paramList != null) {
          this.t.addAll(paramList);
        }
        paramList = new Message();
        paramList.what = 0;
        this.r.removeMessages(0);
        this.r.sendMessage(paramList);
        this.n = false;
        return;
      }
    }
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Iterator localIterator = this.t.iterator();
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
    return null;
  }
  
  protected void b()
  {
    MqqHandler localMqqHandler = this.q;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(0);
      this.q.sendEmptyMessage(0);
    }
  }
  
  public RecentBaseData c()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)this.a.remove(0);
          return localRecentBaseData;
        }
      }
      Object localObject2 = null;
    }
  }
  
  protected void c(List<MessageRecord> paramList) {}
  
  protected void d() {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.w = ThemeUtil.isDefaultOrDIYTheme(false);
    this.h = ((FPSSwipListView)this.mContentView.findViewById(2131437317));
    try
    {
      this.h.setBackgroundResource(2130838958);
    }
    catch (Throwable paramViewGroup)
    {
      QLog.e("BaseMsgListFragment", 1, paramViewGroup, new Object[0]);
    }
    this.i = DragFrameLayout.a(this.c);
    this.i.a(this, false);
    this.f = new LinearLayout(this.c);
    this.f.setOrientation(1);
    this.f.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.h.addHeaderView(this.f, 0);
    this.g = paramLayoutInflater.inflate(2131624518, null);
    this.g.setVisibility(8);
    this.h.addFooterView(this.g);
    this.h.setRightIconMenuListener(this);
    this.h.setOnScrollListener(this);
    this.k = new RecentAdapter(this.c, this.b, this.h, this, 11);
    this.k.a(this.i);
    this.h.setAdapter(this.k);
    this.k.a(16);
    this.q = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    this.r = new CustomHandler(this.c.getMainLooper(), this.z);
    this.l = new ConcurrentHashMap();
    this.t = new ArrayList();
    this.b.addObserver(this.y, true);
    this.b.addObserver(this.x, true);
    this.b.getMessageFacade().addObserver(this);
    if (QLog.isColorLevel()) {
      this.o = System.currentTimeMillis();
    }
  }
  
  protected boolean e()
  {
    int i1 = this.p;
    return (i1 != 0) && (i1 != 1);
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = this.j;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627362;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i2 = paramMessage.what;
    int i1 = 50;
    long l1;
    int i3;
    int i4;
    if (i2 != 0)
    {
      if (i2 != 1) {
        return false;
      }
      l1 = System.currentTimeMillis();
      i3 = this.v;
      if (i3 > 0)
      {
        paramMessage = this.s;
        if (paramMessage != null)
        {
          i4 = paramMessage.size();
          i2 = i4 - this.v;
          if (i2 <= 0) {
            return false;
          }
          if (i2 > 50)
          {
            this.u = true;
          }
          else
          {
            this.u = false;
            i1 = i2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(i4), Integer.valueOf(i1) }));
          }
          paramMessage = b(this.s.subList(0, i3 - 1 + 1 + i1));
          if (paramMessage != null) {
            i1 = paramMessage.size();
          } else {
            i1 = 0;
          }
          this.v = i1;
          a(paramMessage);
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
        return false;
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      this.s = this.b.getMessageProxy(this.d).b(this.e, this.d);
      if (this.s == null) {
        this.s = new ArrayList();
      }
      c(this.s);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      paramMessage = this.s;
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
      i4 = this.v;
      i3 = i2;
      if (i4 > i2)
      {
        i3 = i2;
        if (i4 <= i1) {
          i3 = i4;
        }
      }
      if (i3 > 50) {
        this.u = true;
      } else {
        this.u = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(this.v) }));
      }
      LinkedList localLinkedList = new LinkedList();
      List localList = this.s;
      paramMessage = localLinkedList;
      if (localList != null)
      {
        paramMessage = localLinkedList;
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
      this.v = i1;
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
    if (this.i.getMode() == -1)
    {
      b();
      a();
    }
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getBaseActivity();
    this.b = ((QQAppInterface)this.c.getAppInterface());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("uintype", -1);
      this.e = paramBundle.getString("uin", "");
    }
    if (!UinTypeUtil.c(this.e, this.d))
    {
      this.d = 1032;
      this.e = AppConstants.CONFESS_UIN;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.d), this.e }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.q.removeCallbacksAndMessages(null);
    this.r.removeCallbacksAndMessages(null);
    Object localObject = this.b;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.y);
      this.b.removeObserver(this.x);
      if (this.b.getMessageFacade() != null) {
        this.b.getMessageFacade().deleteObserver(this);
      }
    }
    localObject = this.k;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onPause()
  {
    super.onPause();
    DragFrameLayout localDragFrameLayout = this.i;
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
    this.p = 0;
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.j;
    if (paramView != null) {
      paramView.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.j;
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
      this.k.a(true);
    } else {
      this.k.a(false);
    }
    this.p = paramInt;
    if ((paramInt == 0) && (this.n))
    {
      paramAbsListView = this.q;
      if (paramAbsListView != null)
      {
        paramAbsListView.removeMessages(0);
        this.q.sendEmptyMessage(0);
      }
    }
    if (i1 != 0)
    {
      paramAbsListView = this.q;
      if (paramAbsListView != null) {
        paramAbsListView.sendEmptyMessage(1);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.j = f();
    TopGestureLayout localTopGestureLayout = this.j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment
 * JD-Core Version:    0.7.0.1
 */