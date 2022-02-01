package com.tencent.mobileqq.qqgamepub.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService.GameBaseInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGameGrayTipsView
  extends FrameLayout
  implements View.OnClickListener, SimpleEventReceiver
{
  LinearLayout a;
  LinearLayout b;
  LinearLayout c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private QQGameMsgInfo g = new QQGameMsgInfo();
  private boolean h;
  private boolean i;
  private boolean j;
  private long k;
  
  public QQGameGrayTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQGameGrayTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGameGrayTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    int m;
    if (this.j) {
      m = 2130840523;
    } else {
      m = 2130840506;
    }
    this.f.setBackgroundDrawable(getContext().getResources().getDrawable(m));
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131624919, this);
    this.c = ((LinearLayout)findViewById(2131437468));
    this.d = ((TextView)findViewById(2131448776));
    this.e = ((ImageView)findViewById(2131436601));
    this.f = ((ImageView)findViewById(2131436600));
    this.a = ((LinearLayout)findViewById(2131437564));
    this.b = ((LinearLayout)findViewById(2131437572));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    setId(2131442588);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    Object localObject = getResources().getString(2131892960);
    if (!TextUtils.isEmpty(paramQQGameMsgInfo.desc)) {
      localObject = paramQQGameMsgInfo.desc;
    }
    this.d.setText(String.format(getResources().getString(2131892911), new Object[] { localObject }));
    paramQQGameMsgInfo = this.d;
    localObject = getResources();
    int m;
    if (this.j) {
      m = 2131167349;
    } else {
      m = 2131167348;
    }
    paramQQGameMsgInfo.setTextColor(((Resources)localObject).getColor(m));
  }
  
  private void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (paramBoolean)
    {
      this.b.setVisibility(8);
      this.e.setBackgroundDrawable(getContext().getResources().getDrawable(2130840521));
      this.a.setPadding(UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()), UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()));
      return;
    }
    this.b.setVisibility(0);
    int m;
    if (this.j) {
      m = 2130840517;
    } else {
      m = 2130840516;
    }
    this.e.setBackgroundDrawable(getContext().getResources().getDrawable(m));
    this.a.setPadding(UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()), UIUtils.a(28.0F, getResources()), UIUtils.a(3.0F, getResources()));
  }
  
  private boolean a(QQGameSubscribeBusEvent paramQQGameSubscribeBusEvent)
  {
    String str = this.g.gameAppId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQGameSubscribeBusEvent.subscribeInfo.appid.get());
    localStringBuilder.append("");
    return str.equals(localStringBuilder.toString());
  }
  
  private void b()
  {
    post(new QQGameGrayTipsView.1(this));
  }
  
  private void c()
  {
    Object localObject = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.5F, 1.0F });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.5F, 1.0F });
    localObject = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
    ((ObjectAnimator)localObject).addListener(new QQGameGrayTipsView.2(this));
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).start();
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePub_GameGrayTipsView", 2, "refreshUi...isAnimating just return");
      }
      return;
    }
    if (paramQQGameMsgInfo == null)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.j = paramBoolean2;
    this.g = paramQQGameMsgInfo;
    a();
    a(paramQQGameMsgInfo);
    a(paramBoolean1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUi...info:");
      localStringBuilder.append(paramQQGameMsgInfo);
      localStringBuilder.append(",isSubscribed:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",isNightMode:");
      localStringBuilder.append(paramBoolean2);
      QLog.i("QQGamePub_GameGrayTipsView", 2, localStringBuilder.toString());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QQGameSubscribeBusEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
    if (2131437564 == paramView.getId())
    {
      ((IQQGameSubscribeService)localObject).putToGameInfoMap(this.g.gameAppId, new IQQGameSubscribeService.GameBaseInfo(this.g.gameAppId, this.g.desc, this.h));
      ((IQQGameSubscribeService)localObject).enterSingleGameMsgPage(MobileQQ.sMobileQQ, this.g.gameAppId, 1);
    }
    else if (2131437572 == paramView.getId())
    {
      if ((!this.h) && (!this.i))
      {
        if (Math.abs(System.currentTimeMillis() - this.k) >= 1000L) {
          if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(getContext(), 1, getResources().getString(2131892950), 0).show();
          } else {
            this.k = ((IQQGameSubscribeService)localObject).reqSetSubscribeStatus(this.g.gameAppId, 1, 1);
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick:");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(",mGameInfo:");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(",isAnimating:");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append(",can not click");
        QLog.i("QQGamePub_GameGrayTipsView", 1, ((StringBuilder)localObject).toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    try
    {
      Object localObject;
      if ((paramSimpleBaseEvent instanceof QQGameSubscribeBusEvent))
      {
        localObject = (QQGameSubscribeBusEvent)paramSimpleBaseEvent;
        int m = ((QQGameSubscribeBusEvent)localObject).eventType;
        if (m == 4)
        {
          if ((a((QQGameSubscribeBusEvent)localObject)) && (((QQGameSubscribeBusEvent)localObject).seq == this.k) && (!this.h)) {
            b();
          }
        }
        else if ((m == 5) && (a((QQGameSubscribeBusEvent)localObject)) && (!this.h)) {
          a(true);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveEvent...");
        ((StringBuilder)localObject).append(paramSimpleBaseEvent);
        QLog.i("QQGamePub_GameGrayTipsView", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramSimpleBaseEvent)
    {
      QLog.e("QQGamePub_GameGrayTipsView", 1, paramSimpleBaseEvent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView
 * JD-Core Version:    0.7.0.1
 */