package com.tencent.mobileqq.troop.navigatebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class BaseAioMsgNavigateBar
  extends AioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  public static long b = 2147483647L;
  protected String N = null;
  protected INavigateBar O;
  protected Object P;
  protected boolean Q;
  protected String R;
  protected Object S;
  protected String T;
  protected String U = "";
  protected boolean c = false;
  protected long d = b;
  protected int e = 0;
  public AtomicBoolean f = new AtomicBoolean(false);
  protected View g;
  protected ImageView h;
  protected URLThemeImageView i;
  protected boolean j = false;
  protected View k;
  protected TextView l;
  protected TextView m;
  protected int n = -1;
  protected long o = 0L;
  protected long p = 0L;
  protected Object q = null;
  protected boolean r = false;
  protected List<Long> s = new ArrayList();
  protected float t = 0.0F;
  protected int u = 0;
  protected int v = 0;
  protected Animation w = null;
  protected Animation x = null;
  protected Animation y = null;
  protected boolean z = false;
  
  public static int a(RelativeLayout paramRelativeLayout, int... paramVarArgs)
  {
    int i1 = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int i4 = 0;
    int i3;
    for (int i2 = 0; i1 < paramVarArgs.length; i2 = i3)
    {
      View localView = paramRelativeLayout.findViewById(paramVarArgs[i1]);
      int i5 = i4;
      i3 = i2;
      if (localView != null) {
        if (localView.getVisibility() != 0)
        {
          i5 = i4;
          i3 = i2;
        }
        else
        {
          int i6 = localView.getBottom();
          i5 = i4;
          i3 = i2;
          if (i6 >= i2)
          {
            i5 = paramVarArgs[i1];
            i3 = i6;
          }
        }
      }
      i1 += 1;
      i4 = i5;
    }
    return i4;
  }
  
  protected int a(int... paramVarArgs)
  {
    return a(this.G, paramVarArgs);
  }
  
  protected void a()
  {
    this.c = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInit: Uin = ");
    ((StringBuilder)localObject).append(this.F.b);
    ((StringBuilder)localObject).append(", uinType = ");
    ((StringBuilder)localObject).append(this.F.a);
    ((StringBuilder)localObject).append(", mUnreadCount = ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(", mTroopLastReadSeq:");
    ((StringBuilder)localObject).append(this.d);
    QLog.d("Navigate.BaseAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    localObject = new DisplayMetrics();
    ((Activity)this.E).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.u = ((DisplayMetrics)localObject).heightPixels;
    this.v = ((int)this.E.getResources().getDimension(2131298724));
    this.w = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.x = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.w.setDuration(500L);
    this.x.setDuration(500L);
    this.w.setAnimationListener(this);
    this.x.setAnimationListener(this);
    this.y = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.y.setDuration(500L);
    this.y.setFillAfter(true);
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" createNavigateBar navigateType ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" wording = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" tag = ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(" senderUin = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, ((StringBuilder)localObject).toString());
    }
    if (this.G == null) {
      return;
    }
    if (this.k == null) {
      try
      {
        this.k = LayoutInflater.from(this.E).inflate(2131626652, null);
        this.k.setVisibility(8);
      }
      catch (Exception paramString1)
      {
        paramObject = new StringBuilder();
        paramObject.append("mNavitigationBarContainer, inflate error: ");
        paramObject.append(paramString1.getMessage());
        QLog.e("Navigate.BaseAioMsgNavigateBar", 2, paramObject.toString());
        return;
      }
    }
    if (this.G.indexOfChild(this.k) == -1)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.E, 18.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      this.G.addView(this.k, (ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    int i1 = a(new int[] { 2131448070, 2131442214, 2131442350, 2131442345 });
    if (i1 > 0) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, i1);
    }
    if (this.g == null) {
      this.g = this.k.findViewById(2131447879);
    }
    this.k.setBackgroundResource(17170445);
    this.g.setTag(paramObject);
    this.m = ((TextView)this.g.findViewById(2131447884));
    this.l = ((TextView)this.g.findViewById(2131447883));
    this.h = ((ImageView)this.g.findViewById(2131447880));
    this.m.setText(ContactUtils.b(this.D, this.F.b, paramString2));
    this.l.setText(paramString1);
    this.l.setVisibility(0);
    a(paramString2);
    this.g.setBackgroundResource(2130844969);
    this.l.setTextColor(this.E.getResources().getColor(2131167005));
    this.m.setTextColor(this.E.getResources().getColor(2131167005));
    this.h.setBackgroundResource(2130853377);
    this.g.setOnClickListener(this);
    this.O.a(paramInt, this.m, this.l, this.h, this.R);
  }
  
  public void a(long paramLong)
  {
    if (paramLong > this.d)
    {
      int i1 = this.e;
      if (i1 > 0) {
        this.e = (i1 - 1);
      }
    }
    l();
  }
  
  protected void a(BaseAioMsgNavigateBarDelegate.Entity paramEntity)
  {
    if (this.n != 102) {
      return;
    }
    this.Q = paramEntity.a();
    this.R = paramEntity.b();
    if (this.Q)
    {
      g();
      return;
    }
    q();
  }
  
  protected void a(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.l.getLayoutParams();
    if (this.i == null) {
      this.i = ((URLThemeImageView)this.g.findViewById(2131447881));
    }
    if (this.O.a(this.n, this.i, paramString)) {
      return;
    }
    if ((this.n != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.U)) && (this.i.getVisibility() == 0))
      {
        this.U = paramString;
        this.i.setImageDrawable(FaceDrawable.getFaceDrawable(this.D, 1, paramString));
        return;
      }
      this.i.setVisibility(0);
      Object localObject1 = (LinearLayout.LayoutParams)this.i.getLayoutParams();
      if (this.F.a == 3000)
      {
        int i1 = DisplayUtil.a(this.E, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i1;
        ((LinearLayout.LayoutParams)localObject1).width = i1;
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(this.E, 2.5F), DisplayUtil.a(this.E, 2.5F), 0, DisplayUtil.a(this.E, 2.5F));
      }
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (FriendsManager)this.D.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = (HotChatManager)this.D.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.F.b)) && (localObject1 != null) && (!((FriendsManager)localObject1).n(paramString)))
      {
        this.i.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.D, 200, paramString, true));
      }
      else if (this.n == 22)
      {
        localObject2 = this.g.getTag();
        boolean bool = localObject2 instanceof AioAgent.Message;
        Object localObject3 = null;
        localObject1 = localObject3;
        if (bool)
        {
          long l1 = ((AioAgent.Message)localObject2).c;
          localObject1 = this.D.getMessageFacade().b(this.F.b, this.F.a, l1, 0L);
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localObject2 = (MessageRecord)((List)localObject1).get(0);
          } else {
            localObject2 = null;
          }
          localObject1 = localObject3;
          if (localObject2 != null)
          {
            localObject1 = localObject3;
            if (AnonymousChatHelper.c((MessageRecord)localObject2))
            {
              localObject1 = this.E.getResources().getDrawable(2130844765);
              localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.g((MessageRecord)localObject2).d), (Drawable)localObject1, (Drawable)localObject1);
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = FaceDrawable.getFaceDrawable(this.D, 1, paramString);
        }
        this.i.setImageDrawable((Drawable)localObject2);
      }
      else
      {
        this.i.setImageDrawable(FaceDrawable.getFaceDrawable(this.D, 1, paramString));
      }
      if (this.F.a == 3000) {
        localLayoutParams.leftMargin = DisplayUtil.a(this.E, 7.0F);
      }
    }
    else
    {
      ViewUtils.setVisible(this.i, 4);
      if (this.F.a == 3000) {
        localLayoutParams.leftMargin = DisplayUtil.a(this.E, 14.0F);
      }
    }
    if (this.F.a == 3000) {
      this.l.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (!e()) {
        return;
      }
      List localList = this.s;
      int i1 = 0;
      try
      {
        Object localObject;
        while (i1 < paramList.size())
        {
          localObject = (ChatMessage)paramList.get(i1);
          this.s.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
          this.s.remove(Long.valueOf(((ChatMessage)localObject).uniseq));
          i1 += 1;
        }
        i1 = this.s.size();
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("removeMsgSeqOnScoll, sizeAfterRemove = ");
          paramList.append(i1);
          QLog.d("Navigate.BaseAioMsgNavigateBar", 2, paramList.toString());
        }
        if (i1 != 0)
        {
          paramList = (AioAgent.Message)this.g.getTag();
          if ((paramList != null) && ((paramList.g) || (paramList.h)))
          {
            if (paramList.g) {
              this.l.setText(this.E.getString(2131916248));
            } else {
              this.l.setText(this.E.getString(2131916264));
            }
          }
          else
          {
            Resources localResources;
            if ((paramList != null) && (paramList.e == 17))
            {
              localObject = this.l;
              localResources = this.E.getResources();
              if (i1 > 99) {
                paramList = "99+";
              } else {
                paramList = Integer.valueOf(i1);
              }
              ((TextView)localObject).setText(localResources.getString(2131892032, new Object[] { paramList }));
            }
            else if ((paramList != null) && (paramList.e == 100))
            {
              localObject = this.m;
              localResources = this.E.getResources();
              if (i1 > 99) {
                paramList = "99+";
              } else {
                paramList = Integer.valueOf(i1);
              }
              ((TextView)localObject).setText(localResources.getString(2131897526, new Object[] { paramList }));
            }
          }
        }
        else
        {
          this.z = false;
          q();
        }
        return;
      }
      finally {}
    }
  }
  
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUninit, Uin = ");
    ((StringBuilder)localObject).append(this.F.b);
    QLog.d("Navigate.BaseAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    this.c = false;
    if (this.k != null)
    {
      localObject = this.g;
      if (localObject != null)
      {
        ((View)localObject).clearAnimation();
        this.k.setVisibility(8);
        localObject = (ViewGroup)this.k.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.k);
        }
      }
    }
    this.O.b();
  }
  
  protected void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideMsgNavigateBarInternal, type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, ((StringBuilder)localObject).toString());
    }
    if (this.M)
    {
      this.j = false;
      if (paramInt == 0)
      {
        this.n = -1;
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "hideMsgNavigateBarInternal, type = NavConstants.TYPE_ALL_MSG");
        }
      }
      else if (i())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "hideMsgNavigateBarInternal, type != NavConstants.TYPE_ALL_MSG");
        }
        if ((this.z) && (!this.D.getMessageFacade().p().f(this.F.b, this.F.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "needNavigate && !app.getMessageFacade().getTroopMessageManager()");
          }
          setChanged();
          notifyObservers(this.g.getTag());
        }
        l();
        return;
      }
      if ((this.g != null) && (this.x != null))
      {
        localObject = this.k;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          this.g.clearAnimation();
          this.g.startAnimation(this.x);
        }
      }
    }
  }
  
  protected abstract void c();
  
  public void c(int paramInt)
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "hideMsgNavigateBarByNavigateType ");
    }
    ThreadManager.getUIHandler().post(new BaseAioMsgNavigateBar.4(this, paramInt));
  }
  
  protected abstract void cA_();
  
  protected abstract void d();
  
  public boolean d(int paramInt)
  {
    return this.O.b(paramInt);
  }
  
  public abstract boolean e();
  
  public View f()
  {
    return this.k;
  }
  
  protected void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" notifyUI mFIsShow = ");
      localStringBuilder.append(this.Q);
      localStringBuilder.append(" sessionInfo = ");
      localStringBuilder.append(this.F);
      QLog.d("Navigate.BaseAioMsgNavigateBar", 1, localStringBuilder.toString());
    }
    if ((this.F != null) && (!TextUtils.isEmpty(this.F.b)) && (!this.F.b.equals(this.N))) {}
  }
  
  protected abstract void h();
  
  public abstract boolean i();
  
  public boolean j()
  {
    View localView = this.k;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  public void k()
  {
    if ((this.g != null) && (this.k.getVisibility() == 0))
    {
      AioAgent.Message localMessage = (AioAgent.Message)this.g.getTag();
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onScroll] tag: ");
        if (localMessage == null) {
          localObject = "null";
        } else {
          localObject = localMessage.toString();
        }
        localStringBuilder.append((String)localObject);
        QLog.d("Navigate.BaseAioMsgNavigateBar", 2, localStringBuilder.toString());
      }
      if (localMessage != null)
      {
        long l2 = localMessage.c;
        long l1 = l2;
        if (localMessage.d != 0L)
        {
          localObject = this.D.getMessageFacade().a(this.F.b, this.F.a, localMessage.d);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i1 = this.J.getFirstVisiblePosition();
          localObject = (ChatMessage)this.I.getItem(i1);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            q();
          }
        }
      }
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "[showNavigateBarIfNeeded]");
    }
    if (!i())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.BaseAioMsgNavigateBar", 2, " !isNeedToShowNavigateBar");
      }
      return;
    }
    c();
    BaseAioMsgNavigateBar.1 local1 = new BaseAioMsgNavigateBar.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  protected void m()
  {
    this.c = true;
    this.P = null;
    ??? = (TroopManager)this.D.getManager(QQManagerFactory.TROOP_MANAGER);
    if (??? != null)
    {
      ??? = ((TroopManager)???).f(this.F.b);
      if ((??? != null) && (((TroopInfo)???).hasOrgs())) {
        this.r = true;
      }
    }
    long l1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (e())
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("prepareShowNavigateBar isMulNavigateMode = ");
        ((StringBuilder)???).append(e());
        ((StringBuilder)???).append("mIsOrgTroop");
        ((StringBuilder)???).append(this.r);
        QLog.d("Navigate.BaseAioMsgNavigateBar", 2, ((StringBuilder)???).toString());
      }
      if (this.r)
      {
        ??? = this.D.getMessageFacade().getLastMessage(this.F.b, this.F.a);
        if (??? != null)
        {
          l1 = ((com.tencent.imcore.message.Message)???).shmsgseq;
          long l2 = this.p;
          ??? = this.D;
          localObject2 = this.F.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(l1 - l2);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)???, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, (String)localObject2, "", "", localStringBuilder.toString());
        }
      }
      if ((!ListUtils.a(this.s)) && (this.J != null) && (this.I != null))
      {
        localObject2 = (ChatMessage)this.I.getItem(this.J.getFirstVisiblePosition());
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      int i1;
      synchronized (this.s)
      {
        l1 = AioAgent.Message.a(this.n, ((ChatMessage)localObject2).shmsgseq, ((ChatMessage)localObject2).uniseq);
        i1 = this.s.size() - 1;
        if (i1 >= 0)
        {
          if (l1 > ((Long)this.s.get(i1)).longValue()) {
            break label871;
          }
          if ((this.p == ((Long)this.s.get(i1)).longValue()) && (i1 < this.s.size() - 1)) {
            this.p = ((Long)this.s.get(i1 + 1)).longValue();
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[prepareShowNavigateBar] navigateSeq = ");
            ((StringBuilder)localObject2).append(this.p);
            ((StringBuilder)localObject2).append(" msgSeq = ");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(" mMulNativigateSeqList.remove(i) =  ");
            ((StringBuilder)localObject2).append(this.s.get(i1));
            QLog.d("Navigate.BaseAioMsgNavigateBar", 2, ((StringBuilder)localObject2).toString());
          }
          this.s.remove(i1);
          break label871;
        }
      }
      this.N = this.F.b;
      l1 = b;
      ??? = n();
      if (??? != null) {
        l1 = ((MessageRecord)???).shmsgseq;
      }
      BaseAioMsgNavigateBarDelegate.Entity localEntity = this.O.a(this.n, this.s, this.p, this.q, l1, this.d, this.e);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" prepareShowNavigateBar, navigateType = ");
        localStringBuilder.append(this.n);
        localStringBuilder.append(", navigateSeq = ");
        localStringBuilder.append(this.p);
        localStringBuilder.append("， mMulNativigateSeqList.size = ");
        localStringBuilder.append(ListUtils.b(this.s));
        localStringBuilder.append(", firstMsgSeq = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLastReadSeq = ");
        localStringBuilder.append(this.d);
        localStringBuilder.append(", unreadCount = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", entity = ");
        if (localEntity == null) {
          ??? = "null";
        } else {
          ??? = localEntity.toString();
        }
        localStringBuilder.append((String)???);
        QLog.d("Navigate.BaseAioMsgNavigateBar", 2, localStringBuilder.toString());
      }
      if (localEntity == null)
      {
        this.Q = false;
        return;
      }
      if ((e()) && (ListUtils.a(this.s))) {
        this.Q = false;
      } else {
        this.Q = localEntity.a();
      }
      this.R = localEntity.b();
      this.S = localEntity.c();
      this.T = localEntity.d();
      this.P = localEntity.e();
      return;
      label871:
      i1 -= 1;
    }
  }
  
  @Nullable
  protected MessageRecord n()
  {
    if ((this.I != null) && (this.J != null)) {
      return (MessageRecord)this.I.getItem(this.J.getFirstVisiblePosition());
    }
    return null;
  }
  
  protected void o()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showMsgNavigateBarInternal ， mNavitigationBarContainer = ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.k;
    if (localObject == null) {
      return;
    }
    this.z = false;
    if (((View)localObject).getVisibility() == 8)
    {
      localObject = this.g;
      if ((localObject != null) && (this.w != null))
      {
        this.t = 0.0F;
        ((View)localObject).clearAnimation();
        this.g.startAnimation(this.w);
        this.k.setVisibility(0);
        this.g.setVisibility(0);
        this.O.a(this.n, this.g.getTag(), this.R);
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.D != null) && (this.k != null) && (this.F != null) && (this.g != null))
    {
      if (paramAnimation == null) {
        return;
      }
      this.D.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
      if (paramAnimation.equals(this.x))
      {
        this.k.setVisibility(8);
        this.g.setVisibility(8);
        if ((this.z) && (!this.D.getMessageFacade().p().f(this.F.b, this.F.a)))
        {
          setChanged();
          notifyObservers(this.g.getTag());
        }
      }
      this.c = false;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.D != null) && (this.k != null) && (this.F != null) && (this.g != null))
    {
      if (paramAnimation == null) {
        return;
      }
      if ((paramAnimation.equals(this.x)) && (this.z) && (!this.D.getMessageFacade().p().f(this.F.b, this.F.a)))
      {
        setChanged();
        notifyObservers(this.g.getTag());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Navigate.BaseAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    else {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131428152: 
      case 2131434528: 
      case 2131447879: 
        h();
        break;
      case 2131427931: 
        q();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "showMsgNavigateBar");
    }
    ThreadManager.getUIHandler().post(new BaseAioMsgNavigateBar.2(this));
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.BaseAioMsgNavigateBar", 2, "hideMsgNavigateBar ");
    }
    ThreadManager.getUIHandler().post(new BaseAioMsgNavigateBar.3(this));
  }
  
  public int r()
  {
    return this.n;
  }
  
  protected boolean s()
  {
    return this.Q;
  }
  
  protected long t()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */