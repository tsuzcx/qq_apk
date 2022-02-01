package com.tencent.mobileqq.relationx.icebreaking;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOIceBreakShow
  implements Handler.Callback, AIOIceBreakView.OnIceImageClickListener
{
  private static int a;
  private int b = -1;
  private BaseChatPie c;
  private Context d;
  private LinearLayout e;
  private IceBreakingMng f;
  private int g = -1;
  private String h;
  private MqqWeakReferenceHandler i;
  private MqqWeakReferenceHandler j;
  private AIOFooterViewDetector k;
  private boolean l = false;
  private List<IStickerRecEmoticon> m = null;
  private int n = 0;
  private boolean o = false;
  private ValueAnimator p;
  private ValueAnimator.AnimatorUpdateListener q = new AIOIceBreakShow.2(this);
  private Animator.AnimatorListener r = new AIOIceBreakShow.3(this);
  
  public AIOIceBreakShow(BaseChatPie paramBaseChatPie, Context paramContext, String paramString)
  {
    this.c = paramBaseChatPie;
    this.d = paramContext;
    this.h = paramString;
    this.f = ((IceBreakingMng)this.c.d.getManager(QQManagerFactory.ICE_BREAKING_MNG));
    this.i = new MqqWeakReferenceHandler(this.c.j().getLooper(), this);
    this.j = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    a = AIOUtils.b(150.0F, this.d.getResources());
    this.k = this.c.aV;
  }
  
  private void a(int paramInt, String paramString)
  {
    this.j.removeCallbacksAndMessages(null);
    this.j.postDelayed(new AIOIceBreakShow.RemoveRunnable(this, paramInt, paramString), this.f.e * 1000L);
  }
  
  private void b(int paramInt, String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new AIOIceBreakShow.1(this, paramInt, paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("show needAnim: %s, mState: %s, mIceBreakType: %s, mIsAIOPanelOpen: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.b), Integer.valueOf(this.g), Boolean.valueOf(this.l) }));
    }
    int i1 = this.b;
    if ((i1 != 1) && (i1 != -1)) {
      return;
    }
    if (this.g == -1) {
      return;
    }
    if (this.e == null)
    {
      localObject1 = this.m;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bind data pic urls: ");
          ((StringBuilder)localObject1).append(this.m);
          QLog.d("AIOIceBreakShow", 2, ((StringBuilder)localObject1).toString());
        }
        this.e = new AIOIceBreakView(this.d);
        if (this.g == 2) {
          ((AIOIceBreakView)this.e).setShowCmShow(false);
        }
        ((AIOIceBreakView)this.e).a(this.c, this.m, this.n);
        this.e.setTag(2131427975, Integer.valueOf(this.g));
        ((AIOIceBreakView)this.e).setOnIceImageClickListener(this);
      }
      else
      {
        QLog.d("AIOIceBreakShow", 1, "rec mRecEmotionList is empty!");
        return;
      }
    }
    if (this.l)
    {
      this.b = 1;
      return;
    }
    if (this.o)
    {
      localObject1 = this.p;
      if (localObject1 != null)
      {
        ((ValueAnimator)localObject1).cancel();
        g();
      }
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.c.d, "ice_break", true);
    Object localObject1 = (AIOShortcutBarHelper)this.c.q(52);
    if (localObject1 != null) {
      try
      {
        ((AIOShortcutBarHelper)localObject1).d(6);
      }
      catch (Exception localException)
      {
        QLog.d("AIOIceBreakShow", 1, "show notifyAIOIceBreakViewShowingStatus exception ", localException);
      }
    }
    e();
    this.b = 0;
    if (paramBoolean)
    {
      if (this.p == null)
      {
        this.p = new ValueAnimator();
        this.p.setDuration(300L);
        this.p.addUpdateListener(this.q);
        this.p.addListener(this.r);
        this.p.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject2 = PropertyValuesHolder.ofInt("height", new int[] { 0, a });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 100 });
      this.k.a(3, 0);
      this.k.a(0, false, "icebreak_showFooter", 0);
      this.p.setValues(new PropertyValuesHolder[] { localObject2, localPropertyValuesHolder });
      this.e.setAlpha(0.0F);
      this.p.start();
    }
    else
    {
      this.k.a(3, a);
      this.k.a(a, false, "icebreak_showFooter", 0);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("real show duration = ");
      ((StringBuilder)localObject2).append(this.f.e);
      QLog.d("AIOIceBreakShow", 2, ((StringBuilder)localObject2).toString());
    }
    a(this.c.ah.a, this.c.ah.b);
    b(this.c.ah.a, this.c.ah.b);
    Object localObject2 = this.c.d;
    if (this.g == 0) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X8009B95", "0X8009B95", i1, 0, "", "", "", "");
    localObject2 = this.e;
    ((AIOIceBreakView)localObject2).a((View)localObject2, "imp", new StickerRecData());
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("hide needAnim: %s, mState: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.b) }));
    }
    if (this.b != 0) {
      return;
    }
    if (this.o)
    {
      localObject = this.p;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).cancel();
        g();
      }
    }
    if (paramBoolean)
    {
      if (this.p == null)
      {
        this.p = new ValueAnimator();
        this.p.setDuration(300L);
        this.p.addUpdateListener(this.q);
        this.p.addListener(this.r);
        this.p.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject = PropertyValuesHolder.ofInt("height", new int[] { a, 0 });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 100, 0 });
      this.p.setValues(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
      this.b = 1;
      this.p.start();
      return;
    }
    Object localObject = this.e;
    if ((localObject != null) && (((LinearLayout)localObject).getParent() != null))
    {
      this.e.setVisibility(8);
      this.k.a(3, 0);
      this.k.a(0, false, "icebreak_showFooter", 0);
      if (d()) {
        this.c.j(196608);
      }
      this.e = null;
    }
    this.b = 1;
  }
  
  private boolean d()
  {
    if (this.e.getParent() != null)
    {
      ViewParent localViewParent = this.e.getParent();
      ViewGroup localViewGroup = null;
      if ((localViewParent instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localViewParent;
      }
      if ((localViewGroup != null) && (localViewGroup.getId() == 2131428029)) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    Object localObject1 = this.c.U;
    if (localObject1 != null)
    {
      if (this.e == null) {
        return;
      }
      localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getLastVisiblePosition() - ((ListView)localObject1).getFirstVisiblePosition());
      int i3 = 0;
      int i2;
      if (localObject1 != null)
      {
        localObject2 = new Rect();
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        int i1 = ((Rect)localObject2).bottom;
        if (((View)localObject1).getId() == 2131428029) {
          i1 = ((Rect)localObject2).top;
        }
        localObject1 = this.c.bl().findViewById(2131435809);
        localObject2 = new Rect();
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        i2 = i3;
        if (((Rect)localObject2).top - i1 <= a) {
          i2 = 1;
        }
      }
      else
      {
        i2 = i3;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOIceBreakShow", 2, "locate itemView == null");
          i2 = i3;
        }
      }
      localObject1 = this.c.aV;
      if (this.e.getParent() != null)
      {
        if (!(d() ^ i2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOIceBreakShow", 2, "don't need to relocate");
          }
          return;
        }
        ((ViewGroup)this.e.getParent()).removeView(this.e);
      }
      Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      if ((this.g == 2) && (this.c.bl().findViewById(2131445368) != null)) {
        ((FrameLayout.LayoutParams)localObject2).setMargins(((FrameLayout.LayoutParams)localObject2).leftMargin, ((FrameLayout.LayoutParams)localObject2).topMargin, ((FrameLayout.LayoutParams)localObject2).rightMargin, ((FrameLayout.LayoutParams)localObject2).bottomMargin + ViewUtils.dip2px(10.0F));
      }
      if (i2 != 0)
      {
        ((AIOFooterViewDetector)localObject1).a(this.e, (FrameLayout.LayoutParams)localObject2);
        this.c.j(196608);
        if (QLog.isColorLevel()) {
          QLog.d("AIOIceBreakShow", 2, "locate to ListView");
        }
      }
      else
      {
        ((FrameLayout)this.c.bl().findViewById(2131440610)).addView(this.e, (ViewGroup.LayoutParams)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("AIOIceBreakShow", 2, "locate to ContentView");
        }
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("remove mState: %s", new Object[] { Integer.valueOf(this.b) }));
    }
    int i1 = this.b;
    if ((i1 != 0) && (i1 != 1)) {
      return;
    }
    Object localObject = this.e;
    if ((localObject != null) && (((LinearLayout)localObject).getParent() != null))
    {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
      this.k.a(3, 0);
      this.k.b();
      this.e = null;
    }
    this.b = 2;
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.c.d, "ice_break", false);
    localObject = (AIOShortcutBarHelper)this.c.q(52);
    if (localObject != null) {
      ((AIOShortcutBarHelper)localObject).d(7);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, "restore");
    }
    LinearLayout localLinearLayout = this.e;
    if (localLinearLayout != null)
    {
      localLinearLayout.setAlpha(1.0F);
      this.e.scrollTo(0, 0);
      if (this.b == 0)
      {
        this.e.setVisibility(0);
        return;
      }
      this.e.setVisibility(8);
    }
  }
  
  public void a()
  {
    if ((this.b == 0) && (!this.o)) {
      e();
    }
  }
  
  public void a(View paramView)
  {
    if (IceBreakingUtil.d(this.c.ah.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchChat Ice show");
      }
      paramView = this.c;
      if ((paramView instanceof LimitChatPie)) {
        ((LimitChatPie)paramView).bH();
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.4(this));
      return;
    }
    if (IceBreakingUtil.e(this.c.ah.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove QCircleChat Ice show");
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.5(this));
      return;
    }
    if (IceBreakingUtil.f(this.c.ah.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove Game Ice show");
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.6(this));
    }
  }
  
  public void a(List<IStickerRecEmoticon> paramList, int paramInt)
  {
    int i1 = this.f.a(this.h, this.c.ah.a);
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("updateShow, newType = %s, oldType = %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.g) }));
    }
    if (i1 == this.g) {
      return;
    }
    if (i1 != -1)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.g = i1;
        this.m = paramList;
        this.n = paramInt;
        paramList = this.i.obtainMessage(0, 1, 0);
        this.i.sendMessage(paramList);
        return;
      }
      QLog.d("AIOIceBreakShow", 1, "update show but hotPicList is empty!");
      return;
    }
    this.g = i1;
    this.m = paramList;
    this.n = paramInt;
    this.i.sendEmptyMessage(2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOIceBreakShow", 2, String.format("onAIOPanelChanged isShow = %s, mIsAIOPanelOpen = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.l) }));
    }
    if ((this.l ^ paramBoolean))
    {
      this.l = paramBoolean;
      Message localMessage;
      if (this.l)
      {
        if ((this.b == 0) && (!this.o))
        {
          this.i.removeMessages(0);
          this.i.removeMessages(1);
          localMessage = this.i.obtainMessage(1, 0, 0);
          this.i.sendMessage(localMessage);
        }
      }
      else if ((this.b == 1) && (!this.o))
      {
        this.i.removeMessages(0);
        this.i.removeMessages(1);
        if (((this.c instanceof GameMsgChatPie)) && (this.f.s(this.h))) {
          localMessage = this.i.obtainMessage(1, 0, 0);
        } else {
          localMessage = this.i.obtainMessage(0, 0, 0);
        }
        this.i.sendMessage(localMessage);
      }
    }
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    f();
    this.i.removeCallbacksAndMessages(null);
    this.j.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, "show sprite (normal) onDestroy.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        f();
        return false;
      }
      if (paramMessage.arg1 == 1)
      {
        c(true);
        return false;
      }
      c(false);
      return false;
    }
    if (paramMessage.arg1 == 1)
    {
      b(true);
      return false;
    }
    b(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow
 * JD-Core Version:    0.7.0.1
 */