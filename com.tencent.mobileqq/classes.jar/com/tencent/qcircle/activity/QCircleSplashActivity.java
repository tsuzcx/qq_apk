package com.tencent.qcircle.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.ArrayList;

public class QCircleSplashActivity
  extends Activity
  implements SimpleEventReceiver
{
  private static String a = "ASDynamicEngine_qicrlce-app";
  private ASEnterBean b;
  private boolean c;
  
  private void a()
  {
    Object localObject = getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("KEY_AS_ENTER_BEAN")))
    {
      this.b = ((ASEnterBean)((Bundle)localObject).getSerializable("KEY_AS_ENTER_BEAN"));
      localObject = this.b;
      if (localObject == null) {
        return;
      }
      int i = ((ASEnterBean)localObject).getLoadAction();
      if (i != 1001)
      {
        if (i == 1002) {
          c();
        }
      }
      else {
        b();
      }
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleSplashActivity#start success,time cost:");
      localStringBuilder.append(System.currentTimeMillis() - this.b.getStartTime());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    ASEngineEnterEvent localASEngineEnterEvent = new ASEngineEnterEvent("qcircle-app");
    localASEngineEnterEvent.setCallBackResult(true);
    localASEngineEnterEvent.setLoadCost(String.valueOf(System.currentTimeMillis() - this.b.getStartTime()));
    SimpleEventBus.getInstance().dispatchEvent(localASEngineEnterEvent);
  }
  
  private void b()
  {
    a(true);
    QCircleSchemeLauncher.a(this, new QCircleSchemeBean().setSchemeAction(this.b.getSchemeAction()).setAttrs(this.b.getAttrs()).setByteAttrs(this.b.getByteAttrs()));
  }
  
  private void c()
  {
    a(true);
    if (this.c) {
      return;
    }
    QLog.d(a, 1, "QCircleSplashActivity.dealStartAndInstall#first start by activity");
    QCircleSchemeLauncher.a(this, new QCircleSchemeBean().setSchemeAction(this.b.getSchemeAction()).setAttrs(this.b.getAttrs()).setByteAttrs(this.b.getByteAttrs()));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ASEngineEnterEvent.class);
    return localArrayList;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    QCircleBlockCheckListBlock.tryInjectBlockLooperListener();
    a();
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ASEngineEnterEvent))
    {
      paramSimpleBaseEvent = (ASEngineEnterEvent)paramSimpleBaseEvent;
      if (!paramSimpleBaseEvent.getBusinessKey().equals("qcircle-app")) {
        return;
      }
      this.c = paramSimpleBaseEvent.isCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.activity.QCircleSplashActivity
 * JD-Core Version:    0.7.0.1
 */