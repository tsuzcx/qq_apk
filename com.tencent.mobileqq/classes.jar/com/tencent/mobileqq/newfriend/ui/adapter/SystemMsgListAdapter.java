package com.tencent.mobileqq.newfriend.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.msg.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.MayKnowBannerMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSysEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabGuideMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder.ContactBindedHolder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.ContactMatchHolder;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder.MayKnowRecommendHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder.NewFriendBaseHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder.MyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendFillAcademicInfoBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendMoreInfoBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder.NewFriendSildeTabHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder.NewFriendSubTitleHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabGuideBuilder.NewFriendTabInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabInfoBuilder.NewFriendTabInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder;
import com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.PhoneContactAddHolder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SystemMsgListAdapter
  extends SystemMsgListBaseAdapter
  implements Handler.Callback, DecodeTaskCompletionListener, INewFriendListener, IIconListener, SwipListView.SwipListListener
{
  public XListView a;
  Handler b = null;
  protected Runnable c = new SystemMsgListAdapter.2(this);
  private int f;
  private boolean g = true;
  private IFaceDecoder h;
  private AppInterface i;
  private Context j;
  private List<NewFriendBaseBuilder> k = new ArrayList();
  private Hashtable<String, Bitmap> l = new Hashtable();
  private NewFriendServiceImpl m;
  private ContactBindedBuilder n;
  private FlingHandler o;
  private ConcurrentLinkedQueue<Long> p = new ConcurrentLinkedQueue();
  private TabLayoutStatus q = new TabLayoutStatus();
  
  public SystemMsgListAdapter(Context paramContext, AppInterface paramAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    super(paramSystemMsgListView);
    this.f = paramInt;
    this.j = paramContext;
    this.i = paramAppInterface;
    this.a = paramXListView;
    this.h = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.h.setDecodeTaskCompletionListener(this);
    this.m = ((NewFriendServiceImpl)this.i.getRuntimeService(INewFriendService.class, ""));
    this.b = new Handler(Looper.getMainLooper(), this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).addListener(this, this.i);
    this.m.addListener(this);
    this.o = paramFlingHandler;
    this.m.reSetLastSysMsgTotalCount(0);
  }
  
  private NewFriendBaseBuilder a(NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    if ((paramNewFriendMessage instanceof ContactMatchMessage)) {
      return new ContactMatchBuilder(this.j, this.i, this, paramNewFriendMessage);
    }
    Object localObject1;
    if ((paramNewFriendMessage instanceof ContactBindedMessage))
    {
      localObject1 = this.n;
      if (localObject1 == null)
      {
        paramNewFriendMessage = new ContactBindedBuilder(this.j, this.i, this, paramNewFriendMessage);
        this.n = ((ContactBindedBuilder)paramNewFriendMessage);
        return paramNewFriendMessage;
      }
      ((NewFriendBaseBuilder)localObject1).a(paramNewFriendMessage);
      return localObject1;
    }
    Object localObject2;
    if ((paramNewFriendMessage instanceof FriendSystemMessage))
    {
      paramNewFriendMessage = new SystemMsgItemBuilder(this.j, this.i, this, paramNewFriendMessage);
      localObject2 = (SystemMsgItemBuilder)paramNewFriendMessage;
      localObject1 = paramNewFriendMessage;
      if (((SystemMsgItemBuilder)localObject2).a != 0L)
      {
        this.p.add(Long.valueOf(((SystemMsgItemBuilder)localObject2).a));
        return paramNewFriendMessage;
      }
    }
    else
    {
      if ((paramNewFriendMessage instanceof NewFriendSubTitleMessage)) {
        return new NewFriendSubTitleBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendMoreInfoMessage)) {
        return new NewFriendMoreInfoBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsg)) {
        return new NewFriendBindContactGuideBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsgV2)) {
        return new NewFriendBindContactGuideBuilderV2(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof PhoneContactAddMessage)) {
        return new PhoneContactAddBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof QIMFollowMessage)) {
        return new QIMFollowerAddBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof QIMNotifyAddFriendMsg)) {
        return new QIMNotifyAddFriendBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendVerifyBlockedMsg)) {
        return new NewFriendVerifyBlockedBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendSysEmptyMessage)) {
        return new NewFriendSysEmptyBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendTabEmptyMessage))
      {
        paramNewFriendMessage = new NewFriendTabEmptyBuilder(this.j, this.i, this, paramNewFriendMessage);
        boolean bool = d(paramInt);
        ((NewFriendTabEmptyBuilder)paramNewFriendMessage).a(bool);
        return paramNewFriendMessage;
      }
      if ((paramNewFriendMessage instanceof MayKnowBannerMessage)) {
        return new NewFriendFillAcademicInfoBuilder(this.j, this.i, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendSlideTabMessage))
      {
        localObject2 = new NewFriendSlideTabBuilder(this.j, this.i, this, paramNewFriendMessage);
        Handler localHandler = this.b;
        localObject1 = localObject2;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, paramNewFriendMessage));
          return localObject2;
        }
      }
      else
      {
        if ((paramNewFriendMessage instanceof NewFriendTabGuideMessage)) {
          return new NewFriendTabGuideBuilder(this.j, this.i, this, paramNewFriendMessage);
        }
        localObject1 = null;
      }
    }
    return localObject1;
  }
  
  private void a(NewFriendSlideTabMessage paramNewFriendSlideTabMessage)
  {
    if ((paramNewFriendSlideTabMessage != null) && (paramNewFriendSlideTabMessage.a != null) && (paramNewFriendSlideTabMessage.a.size() != 0))
    {
      paramNewFriendSlideTabMessage = paramNewFriendSlideTabMessage.a;
      if (this.e != null) {
        this.e.a(paramNewFriendSlideTabMessage, m());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
    }
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    Bitmap localBitmap;
    if ((paramContactBindedHolder.r != null) && (paramContactBindedHolder.r.length() > 0))
    {
      localBitmap = (Bitmap)this.l.get(paramContactBindedHolder.r);
      if (localBitmap != null) {
        paramContactBindedHolder.h.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.s != null) && (paramContactBindedHolder.s.length() > 0))
    {
      localBitmap = (Bitmap)this.l.get(paramContactBindedHolder.s);
      if (localBitmap != null) {
        paramContactBindedHolder.i.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.t != null) && (paramContactBindedHolder.t.length() > 0))
    {
      localBitmap = (Bitmap)this.l.get(paramContactBindedHolder.t);
      if (localBitmap != null) {
        paramContactBindedHolder.j.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.u != null) && (paramContactBindedHolder.u.length() > 0))
    {
      localBitmap = (Bitmap)this.l.get(paramContactBindedHolder.u);
      if (localBitmap != null) {
        paramContactBindedHolder.k.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.v != null) && (paramContactBindedHolder.v.length() > 0))
    {
      localBitmap = (Bitmap)this.l.get(paramContactBindedHolder.v);
      if (localBitmap != null) {
        paramContactBindedHolder.l.setImageBitmap(localBitmap);
      }
    }
  }
  
  private void c(int paramInt)
  {
    ThreadManager.postImmediately(new SystemMsgListAdapter.1(this, paramInt), null, true);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (!p())
    {
      this.q.d();
      c();
    }
    if ((NetworkUtil.isNetSupport(this.j)) && (b(paramInt2))) {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).loadConnectionsTabData(this.i, paramInt1, this.q.a);
    }
  }
  
  private boolean d(int paramInt)
  {
    if (this.e != null) {
      return this.e.d(paramInt);
    }
    return false;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.h.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.h.isPausing()) {
      this.h.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return BaseImageUtil.k();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TabLayoutStatus localTabLayoutStatus = this.q;
    if (localTabLayoutStatus != null)
    {
      localTabLayoutStatus.b = paramInt2;
      localTabLayoutStatus.a = paramInt1;
    }
  }
  
  public void a(long paramLong)
  {
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void a(NewFriendBaseBuilder paramNewFriendBaseBuilder)
  {
    List localList = this.k;
    if ((localList != null) && (localList.size() > 0)) {
      this.k.remove(paramNewFriendBaseBuilder);
    }
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectionTabSelected tabId : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", position =");
      localStringBuilder.append(paramInt2);
      QLog.i("SystemMsgListAdapter", 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2);
    if (this.e != null) {
      this.e.setStickHeadSelection(paramInt2);
    }
    a(0L);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.p.size() > 0)
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong != null) && (localLong.longValue() == paramLong))
        {
          bool = true;
          break label70;
        }
      }
    }
    boolean bool = false;
    label70:
    if (bool) {
      c();
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isMayKnowConnectionsUserClosed(this.i);
    boolean bool1 = true;
    if (paramInt == 23) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      if (!bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void bR_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 200L);
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public void c()
  {
    a(400L);
  }
  
  public IFaceDecoder d()
  {
    return this.h;
  }
  
  public void e()
  {
    int i2 = this.a.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.a.getChildAt(i1).getTag();
      if ((localObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder))
      {
        SystemMsgItemBuilder.a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject, this, this.i);
      }
      else if ((localObject instanceof ContactMatchBuilder.ContactMatchHolder))
      {
        localObject = (ContactMatchBuilder.ContactMatchHolder)localObject;
        ((ContactMatchBuilder.ContactMatchHolder)localObject).w.setImageBitmap(a(11, ((ContactMatchBuilder.ContactMatchHolder)localObject).D));
      }
      else if ((localObject instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder))
      {
        localObject = (MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject;
        ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).w.setImageBitmap(a(1, ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).D));
      }
      else if ((localObject instanceof PhoneContactAddBuilder.PhoneContactAddHolder))
      {
        localObject = (PhoneContactAddBuilder.PhoneContactAddHolder)localObject;
        ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).w.setImageBitmap(a(11, ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).D));
      }
      else if ((localObject instanceof ContactBindedBuilder.ContactBindedHolder))
      {
        localObject = (ContactBindedBuilder.ContactBindedHolder)localObject;
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).r != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).r.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).h.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).r));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).s != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).s.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).i.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).s));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).t != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).t.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).j.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).t));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).u != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).u.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).k.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).u));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).v != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).v.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).l.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).v));
        }
      }
      else if ((localObject instanceof NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder))
      {
        localObject = (NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject;
        ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).w.setImageBitmap(a(1, ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).D));
      }
      i1 += 1;
    }
  }
  
  public void f()
  {
    this.h.cancelPendingRequests();
    this.h.pause();
  }
  
  public void g()
  {
    if (this.h.isPausing()) {
      this.h.resume();
    }
  }
  
  public int getCount()
  {
    return this.k.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.k.size())) {
      return this.k.get(paramInt);
    }
    return new Object();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = ((NewFriendBaseBuilder)getItem(paramInt)).a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void h()
  {
    this.a.setOnScrollListener(null);
    this.m.reSetLastSysMsgTotalCount(0);
    this.m.removeListener(this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).removeListener(this, this.i);
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.k.clear();
    this.h.setDecodeTaskCompletionListener(null);
    this.h.destory();
    NewFriendNotifyPokeMsgHelper.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      c(m());
    } else if (paramMessage.what == 2) {
      notifyDataSetChanged();
    } else if (paramMessage.what == 3) {
      a((NewFriendSlideTabMessage)paramMessage.obj);
    }
    return false;
  }
  
  public void hideMenuPop() {}
  
  public int i()
  {
    int i1 = this.a.getFirstVisiblePosition();
    if (i1 == 0) {
      return 0;
    }
    return i1 - 1;
  }
  
  public void i_(int paramInt)
  {
    c();
  }
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    Object localObject = this.o;
    if ((localObject != null) && ((localObject instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)localObject;
      if (((FlingGestureHandler)localObject).mTopLayout != null) {
        ((FlingGestureHandler)localObject).mTopLayout.setInterceptTouchFlag(paramBoolean ^ true);
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.a.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.a.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.a.isShown()))
    {
      int i1 = this.a.getFirstVisiblePosition();
      while ((i1 <= this.a.getLastVisiblePosition()) && (i1 < getCount()))
      {
        localObject = (NewFriendBaseBuilder)getItem(i1);
        if ((localObject instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localObject).d();
        }
        i1 += 1;
      }
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.c);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.a.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.a.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.a.isShown()))
    {
      int i1 = this.a.getFirstVisiblePosition();
      while ((i1 <= this.a.getLastVisiblePosition()) && (i1 < getCount()))
      {
        localObject = (NewFriendBaseBuilder)getItem(i1);
        if ((localObject instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localObject).c();
        }
        i1 += 1;
      }
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.c);
      this.a.postDelayed(this.c, 1000L);
    }
  }
  
  public void l()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResume firstVisible: ");
      ((StringBuilder)localObject1).append(this.a.getFirstVisiblePosition());
      ((StringBuilder)localObject1).append(" lastvisible: ");
      ((StringBuilder)localObject1).append(this.a.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if ((getCount() > 0) && (this.a.isShown()))
    {
      this.a.removeCallbacks(this.c);
      localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject2 = new ArrayList();
      int i1 = this.a.getFirstVisiblePosition();
      while ((i1 <= this.a.getLastVisiblePosition()) && (i1 < getCount()))
      {
        Object localObject3 = (NewFriendBaseBuilder)getItem(i1);
        if ((localObject3 instanceof MayKnowRecommendBuilder))
        {
          localObject3 = (MayKnowRecommendBuilder)localObject3;
          ((ArrayList)localObject1).add(((MayKnowRecommendBuilder)localObject3).f());
          localArrayList1.add(((MayKnowRecommendBuilder)localObject3).e());
          localArrayList2.add(Integer.valueOf(((MayKnowRecommendBuilder)localObject3).g()));
          localArrayList3.add(((MayKnowRecommendBuilder)localObject3).h());
        }
        else if ((localObject3 instanceof NewFriendSlideTabBuilder))
        {
          localObject3 = ((NewFriendSlideTabBuilder)localObject3).c();
          if (localObject3 != null) {
            ((ArrayList)localObject2).addAll((Collection)localObject3);
          }
        }
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendFrdExpose exp_uins: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" exp_reasons:");
        ((StringBuilder)localObject2).append(localArrayList1);
        ((StringBuilder)localObject2).append(" exp_positions:");
        ((StringBuilder)localObject2).append(localArrayList2);
        ((StringBuilder)localObject2).append(" algh_ids:");
        ((StringBuilder)localObject2).append(localArrayList3);
        QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommendExpose(this.i, m(), (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 0);
    }
  }
  
  public int m()
  {
    TabLayoutStatus localTabLayoutStatus = this.q;
    if (localTabLayoutStatus != null) {
      return localTabLayoutStatus.a;
    }
    return -1;
  }
  
  public int n()
  {
    TabLayoutStatus localTabLayoutStatus = this.q;
    if (localTabLayoutStatus != null) {
      return localTabLayoutStatus.b;
    }
    return -1;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public TabLayoutStatus o()
  {
    return this.q;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.l.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.a.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.a.getChildAt(paramInt1).getTag();
        if (paramString != null) {
          if ((paramString instanceof ContactBindedBuilder.ContactBindedHolder))
          {
            a((ContactBindedBuilder.ContactBindedHolder)paramString);
          }
          else if ((!(paramString instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)) && (!(paramString instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)) && (!(paramString instanceof NewFriendBindContactGuideBuilder.MyHolder)) && (!(paramString instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder)) && (!(paramString instanceof NewFriendTabInfoBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)) && (!(paramString instanceof NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)) && (!(paramString instanceof NewFriendTabGuideBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)))
          {
            paramString = (NewFriendBaseBuilder.NewFriendBaseHolder)paramString;
            if ((paramString.D != null) && (paramString.D.length() > 0))
            {
              paramBitmap = (Bitmap)this.l.get(paramString.D);
              if (paramBitmap != null) {
                paramString.w.setImageBitmap(paramBitmap);
              }
            }
          }
        }
        paramInt1 += 1;
      }
      this.l.clear();
    }
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getSizeSmall()) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public boolean p()
  {
    int i1 = m();
    Iterator localIterator = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getConnectionsTabInfoListLocal(this.i).iterator();
    while (localIterator.hasNext()) {
      if (((ConnectionsTabInfo)localIterator.next()).a == i1) {
        return true;
      }
    }
    return false;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.d = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */