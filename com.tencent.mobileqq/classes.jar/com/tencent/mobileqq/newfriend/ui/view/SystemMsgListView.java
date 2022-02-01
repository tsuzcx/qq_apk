package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.observer.NewFriendCardObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder.NewFriendSildeTabHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, IPhoneContactListener, Observer
{
  public static final int d = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRequestForSetting();
  private ListviewScrollStatus A;
  private SparseArray<ListviewScrollStatus> B = new SparseArray();
  private SparseArray<Boolean> C = new SparseArray();
  private TabLayoutCompat.OnTabSelectedListener D = new SystemMsgListView.2(this);
  private NewFriendVerificationObserver E = new SystemMsgListView.7(this);
  private NewFriendCardObserver F = new SystemMsgListView.8(this);
  private final int G = 0;
  private int H;
  private AbsListView.OnScrollListener I = new SystemMsgListView.9(this);
  public boolean e = false;
  Handler f = new SystemMsgListView.1(this);
  FriendObserver g = new SystemMsgListView.4(this);
  NewFriendListObserver h = new SystemMsgListView.5(this);
  DiscussionObserver i = new SystemMsgListView.6(this);
  NewFriendMessageObserver j = new SystemMsgListView.MessageObserverForSystemMsgListView(this);
  int k = -1;
  float l = 0.0F;
  private RelativeLayout m;
  private TextView n;
  private SwipListView o;
  private View p;
  private QQProgressDialog q;
  private Context r;
  private SystemMsgListAdapter s;
  private NewFriendServiceImpl t;
  private FlingHandler u;
  private int v;
  private ViewGroup w;
  private ViewGroup x;
  private ViewGroup y;
  private ThemeTabLayout z;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.r = paramContext;
    this.u = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("EntranceId", 0);
    this.s = new SystemMsgListAdapter(this.r, this.b, this.o, this, i1, this.u);
    this.o.setAdapter(this.s);
    j();
    this.A = new ListviewScrollStatus(23, 0, 0);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getMayKnowLoadConnectionBizTypeFirstLoad())
    {
      Object localObject = this.C.get(paramInt1);
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        return ((Boolean)localObject).booleanValue();
      }
      this.C.put(paramInt1, Boolean.valueOf(true));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    boolean bool = (NewFriendBaseBuilder)this.s.getItem(paramInt) instanceof NewFriendSlideTabBuilder;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      this.k = paramInt;
      localObject1 = this.o.getChildAt(0);
      if ((localObject1 != null) && (!this.y.isShown()))
      {
        this.y.setVisibility(0);
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder))
        {
          localObject2 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2;
          if ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).a != null) && (this.z != null))
          {
            float f1 = ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).a.getScrollPositionOffset();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("visable position: scrollposOffset = ");
              ((StringBuilder)localObject2).append(f1);
              QLog.d("Q.newfriendSystemMsgListView", 2, ((StringBuilder)localObject2).toString());
            }
            this.l = f1;
            this.z.setScrollPosition(f1);
          }
        }
        this.A.b = this.o.getFirstVisiblePosition();
        this.A.c = ((View)localObject1).getTop();
        int i2 = this.B.size();
        paramInt = i1;
        while (paramInt < i2)
        {
          localObject2 = (ListviewScrollStatus)this.B.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((ListviewScrollStatus)localObject2).b = this.o.getFirstVisiblePosition();
            ((ListviewScrollStatus)localObject2).c = ((View)localObject1).getTop();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      i1 = this.k;
      if (i1 <= -1)
      {
        this.y.setVisibility(4);
        return;
      }
      if (paramInt > i1)
      {
        this.y.setVisibility(0);
        return;
      }
      if (this.y.isShown())
      {
        this.y.setVisibility(4);
        if (((NewFriendBaseBuilder)this.s.getItem(paramInt + 1) instanceof NewFriendSlideTabBuilder))
        {
          localObject1 = this.o.getChildAt(1);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).getTag();
            if ((localObject1 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder))
            {
              localObject1 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("invisable position: scrollposOffset = ");
                ((StringBuilder)localObject2).append(this.z.getScrollPositionOffset());
                QLog.d("Q.newfriendSystemMsgListView", 2, ((StringBuilder)localObject2).toString());
              }
              if ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).a != null) && (this.z != null)) {
                ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).a.setScrollPosition(this.z.getScrollPositionOffset());
              }
            }
          }
        }
      }
    }
  }
  
  private void m()
  {
    this.b.addObserver(this.i, true);
    this.b.addObserver(this.h);
    this.b.addObserver(this.g);
    this.b.addObserver(this.j);
    this.b.addObserver(this.E);
    this.b.addObserver(this.F);
    ((IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
  }
  
  private void n()
  {
    this.b.removeObserver(this.i);
    this.b.removeObserver(this.h);
    this.b.removeObserver(this.g);
    this.b.removeObserver(this.j);
    this.b.removeObserver(this.E);
    this.b.removeObserver(this.F);
    ((IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
  }
  
  private void o()
  {
    super.setContentView(2131627874);
    this.m = ((RelativeLayout)findViewById(2131437304));
    this.w = ((ViewGroup)findViewById(2131445649));
    this.n = ((TextView)findViewById(2131447463));
    this.x = ((ViewGroup)findViewById(2131432580));
    this.o = ((SwipListView)findViewById(2131446715));
    this.p = findViewById(2131439340);
    this.v = getResources().getDimensionPixelSize(2131298137);
    this.y = ((ViewGroup)findViewById(2131445648));
    this.z = ((ThemeTabLayout)findViewById(2131446755));
    a(this.z);
    this.w.setVisibility(4);
    this.y.setVisibility(4);
  }
  
  private void setFloatingTab(int paramInt)
  {
    if ((NewFriendActivity)this.r != null)
    {
      Object localObject = this.s;
      if (localObject == null) {
        return;
      }
      if ((paramInt >= 0) && (paramInt < ((SystemMsgListAdapter)localObject).getCount()))
      {
        localObject = this.s.getItem(paramInt);
        if ((paramInt == 0) && (((localObject instanceof NewFriendBindContactGuideBuilder)) || ((localObject instanceof NewFriendBindContactGuideBuilderV2))))
        {
          this.y.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendVerifyBlockedBuilder))
        {
          this.y.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendSysEmptyBuilder))
        {
          this.y.setVisibility(4);
          return;
        }
        if ((localObject instanceof NewFriendSubTitleBuilder))
        {
          this.y.setVisibility(4);
          return;
        }
        if (paramInt + 1 >= this.s.getCount()) {
          return;
        }
        e(paramInt);
        return;
      }
      this.y.setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged state: ");
      localStringBuilder.append(paramInt);
      QLog.i("Q.newfriendSystemMsgListView", 2, localStringBuilder.toString());
    }
    i();
    this.s.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 222) && (paramInt1 != 223) && (paramInt1 != 224) && (paramInt1 != 225) && (paramInt1 != 226) && (paramInt1 != 227) && (paramInt1 != 228) && (paramInt1 != 229) && (paramInt1 != 221) && (paramInt1 != 231))
    {
      Object localObject;
      if (paramInt1 == 230)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("REQ_CODE_BIND_NUMBER resultCode: ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", src: ");
          ((StringBuilder)localObject).append(15);
          QLog.i("BindMsgConstant", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt2 == -1) {
          this.s.c();
        }
      }
      else if (paramInt1 == d)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.s.getCount() > 0) {
          localObject = this.s.getItem(0);
        } else {
          localObject = null;
        }
        if (((localObject instanceof NewFriendBindContactGuideBuilderV2)) && (((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true))) {
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.b, -1, 2, null);
        }
      }
    }
    else
    {
      this.s.c();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(long paramLong) {}
  
  public void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    this.t = ((NewFriendServiceImpl)this.b.getRuntimeService(INewFriendService.class, ""));
    ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
    o();
    i();
    a(paramIntent);
    m();
    this.o.setDragEnable(true);
    this.o.setOnScrollListener(this.I);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839577);
      return;
    }
    paramView.setBackgroundResource(2130852374);
  }
  
  public void a(String paramString)
  {
    if (!((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
    {
      String str = this.b.getPreferences().getString("systemmsg_addFriendCount", "");
      boolean bool = TextUtils.isEmpty(str);
      int i3 = 0;
      String[] arrayOfString;
      if (bool) {
        arrayOfString = new String[0];
      } else {
        arrayOfString = str.split(":");
      }
      if (arrayOfString.length >= 3) {
        return;
      }
      int i4 = arrayOfString.length;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= i4) {
          break;
        }
        if (TextUtils.equals(arrayOfString[i1], paramString))
        {
          i2 = 1;
          break;
        }
        i1 += 1;
      }
      if (i2 != 0)
      {
        paramString = str;
      }
      else
      {
        if (arrayOfString.length != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString);
          paramString = localStringBuilder.toString();
        }
        i1 = arrayOfString.length;
      }
      this.b.getPreferences().edit().putString("systemmsg_addFriendCount", paramString).commit();
    }
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    ThemeTabLayout localThemeTabLayout = this.z;
    if (localThemeTabLayout != null)
    {
      localThemeTabLayout.b();
      this.z.a(this.D);
      this.z.a(paramArrayList, paramInt);
      this.z.setOnTabSelectedListener(this.D);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.s.g();
    if (this.s.m() == 23) {
      this.s.k();
    }
    this.s.a(0L);
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    if (this.s.m() == 23) {
      this.s.j();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  public boolean d(int paramInt)
  {
    Object localObject = this.C.get(paramInt);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void e()
  {
    super.e();
    this.s.f();
    ((INewFriendVerificationService)this.b.getRuntimeService(INewFriendVerificationService.class, "")).leaveNewFriend();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  public void f()
  {
    super.f();
    n();
    this.t.markAllDataReaded();
    this.B.clear();
    this.C.clear();
    SystemMsgListAdapter localSystemMsgListAdapter = this.s;
    if (localSystemMsgListAdapter != null) {
      localSystemMsgListAdapter.h();
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).clearStructMsgMap();
    ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void i()
  {
    this.t.updateBindContactGuideState();
    if (this.t.isShowContactGuide())
    {
      this.o.setOverscrollHeader(getResources().getDrawable(2130852228));
      ReportController.b(this.b, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.o.setOverscrollHeader(null);
  }
  
  public void j()
  {
    try
    {
      if (this.s.getCount() > 0)
      {
        this.m.setVisibility(0);
        this.p.setVisibility(8);
        return;
      }
      this.p.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k()
  {
    if (this.q == null) {
      this.q = new QQProgressDialog(this.r, getTitleBarHeight());
    }
    this.q.a(this.r.getString(2131916272));
    this.q.show();
  }
  
  void l()
  {
    QQProgressDialog localQQProgressDialog = this.q;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.q.dismiss();
    }
    this.q = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445649)
    {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity)this.r);
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.s.getCount())) {
      this.o.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.z != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setStickHeadSelection position : ");
        localStringBuilder.append(paramInt);
        QLog.i("Q.newfriendSystemMsgListView", 2, localStringBuilder.toString());
      }
      this.z.a(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.b.runOnUiThread(new SystemMsgListView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */