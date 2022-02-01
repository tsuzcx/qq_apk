package com.tencent.mobileqq.flashshow.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.flashshow.bean.FSSchemeBean;
import com.tencent.mobileqq.flashshow.launcher.FSSchemeLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class FSSplashActivity
  extends Activity
  implements SimpleEventReceiver
{
  public static String a = "ASDynamicEngine_flash-show-app";
  private boolean b;
  private long c;
  
  private void a()
  {
    Object localObject = getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("KEY_AS_ENTER_BEAN")))
    {
      localObject = (ASEnterBean)((Bundle)localObject).getSerializable("KEY_AS_ENTER_BEAN");
      if (localObject == null) {
        return;
      }
      this.c = ((ASEnterBean)localObject).getStartTime();
      int i = ((ASEnterBean)localObject).getLoadAction();
      if (i != 1001)
      {
        if (i == 1002) {
          b((ASEnterBean)localObject);
        }
      }
      else {
        a((ASEnterBean)localObject);
      }
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FSSplashActivity#start success,time cost:");
      localStringBuilder.append(System.currentTimeMillis() - ((ASEnterBean)localObject).getStartTime());
      QLog.d(str, 1, localStringBuilder.toString());
      return;
    }
    QLog.d(a, 1, "dispatchEnterPage failed no data");
    a(false, false);
  }
  
  private void a(ASEnterBean paramASEnterBean)
  {
    a(true, false);
    c(paramASEnterBean);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ASEngineEnterEvent localASEngineEnterEvent = new ASEngineEnterEvent("flash-show-app");
    localASEngineEnterEvent.setCallBackResult(true);
    if (!paramBoolean1) {
      localASEngineEnterEvent.setResultCode(3);
    }
    localASEngineEnterEvent.setHasPreload(paramBoolean2);
    if (this.c > 0L) {
      localASEngineEnterEvent.setLoadCost(String.valueOf(System.currentTimeMillis() - this.c));
    }
    SimpleEventBus.getInstance().dispatchEvent(localASEngineEnterEvent);
  }
  
  private void b(ASEnterBean paramASEnterBean)
  {
    a(true, true);
    c(paramASEnterBean);
  }
  
  private void c(ASEnterBean paramASEnterBean)
  {
    if (this.b)
    {
      QLog.d(a, 1, "user cancel loading");
      return;
    }
    FSSchemeBean localFSSchemeBean = new FSSchemeBean();
    localFSSchemeBean.setAttrs(paramASEnterBean.getAttrs());
    localFSSchemeBean.setSchemeAction(paramASEnterBean.getSchemeAction());
    FSSchemeLauncher.a(this, localFSSchemeBean);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
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
      if (!paramSimpleBaseEvent.getBusinessKey().equals("flash-show-app")) {
        return;
      }
      this.b = paramSimpleBaseEvent.isCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.activity.FSSplashActivity
 * JD-Core Version:    0.7.0.1
 */