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
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQGameMsgInfo jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo = new QQGameMsgInfo();
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean;
  
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
    int i;
    if (this.jdField_c_of_type_Boolean) {
      i = 2130840211;
    } else {
      i = 2130840194;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(getContext().getResources().getDrawable(i));
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131559164, this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370261));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379902));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369514));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369513));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370314));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370322));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    setId(2131374421);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    Object localObject = getResources().getString(2131695226);
    if (!TextUtils.isEmpty(paramQQGameMsgInfo.desc)) {
      localObject = paramQQGameMsgInfo.desc;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131695178), new Object[] { localObject }));
    paramQQGameMsgInfo = this.jdField_a_of_type_AndroidWidgetTextView;
    localObject = getResources();
    int i;
    if (this.jdField_c_of_type_Boolean) {
      i = 2131166506;
    } else {
      i = 2131166505;
    }
    paramQQGameMsgInfo.setTextColor(((Resources)localObject).getColor(i));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(getContext().getResources().getDrawable(2130840209));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()), UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int i;
    if (this.jdField_c_of_type_Boolean) {
      i = 2130840205;
    } else {
      i = 2130840204;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(getContext().getResources().getDrawable(i));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(UIUtils.a(8.0F, getResources()), UIUtils.a(3.0F, getResources()), UIUtils.a(28.0F, getResources()), UIUtils.a(3.0F, getResources()));
  }
  
  private boolean a(QQGameSubscribeBusEvent paramQQGameSubscribeBusEvent)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId;
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
    localObject = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
    ((ObjectAnimator)localObject).addListener(new QQGameGrayTipsView.2(this));
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).start();
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Boolean)
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
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo = paramQQGameMsgInfo;
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
    if (2131370314 == paramView.getId())
    {
      ((IQQGameSubscribeService)localObject).putToGameInfoMap(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId, new IQQGameSubscribeService.GameBaseInfo(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.desc, this.jdField_a_of_type_Boolean));
      ((IQQGameSubscribeService)localObject).enterSingleGameMsgPage(MobileQQ.sMobileQQ, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId, 1);
    }
    else if (2131370322 == paramView.getId())
    {
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) >= 1000L) {
          if (!AppNetConnInfo.isNetSupport()) {
            QQToast.a(getContext(), 1, getResources().getString(2131695216), 0).a();
          } else {
            this.jdField_a_of_type_Long = ((IQQGameSubscribeService)localObject).reqSetSubscribeStatus(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId, 1, 1);
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo);
        ((StringBuilder)localObject).append(",mGameInfo:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject).append(",isAnimating:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
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
        int i = ((QQGameSubscribeBusEvent)localObject).eventType;
        if (i == 4)
        {
          if ((a((QQGameSubscribeBusEvent)localObject)) && (((QQGameSubscribeBusEvent)localObject).seq == this.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean)) {
            b();
          }
        }
        else if ((i == 5) && (a((QQGameSubscribeBusEvent)localObject)) && (!this.jdField_a_of_type_Boolean)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView
 * JD-Core Version:    0.7.0.1
 */