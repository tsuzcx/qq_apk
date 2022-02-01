package com.tencent.mobileqq.qqlive.anchor.room;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPush;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class QQLiveAnchorRoomCallback
  implements IQQLiveAnchorRoomCallbackRegister, IQQLiveAnchorRoomThirdPushCallback
{
  protected CopyOnWriteArrayList<IQQLiveAnchorRoomCallback> a = new CopyOnWriteArrayList();
  protected CopyOnWriteArrayList<IQQLiveAnchorRoomThirdPush> b = new CopyOnWriteArrayList();
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (n())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  private boolean n()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public void a()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.Pv3ks4PFgbmIujhIIhxoa29YDh0(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.V78-NEVrmcqRgAouS99VmLF013Y(this, paramInt, paramString));
  }
  
  public void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState1, QQLiveAnchorRoomState paramQQLiveAnchorRoomState2)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.lD1CFSw_AQju3xUrJb9OIWEZf-I(this, paramQQLiveAnchorRoomState1, paramQQLiveAnchorRoomState2));
  }
  
  public void a(IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    if (!this.a.contains(paramIQQLiveAnchorRoomCallback))
    {
      this.a.add(paramIQQLiveAnchorRoomCallback);
      if ((paramIQQLiveAnchorRoomCallback instanceof IQQLiveAnchorRoomThirdPush)) {
        this.b.add((IQQLiveAnchorRoomThirdPush)paramIQQLiveAnchorRoomCallback);
      }
    }
  }
  
  public void a(QQLiveAnchorDataAuth paramQQLiveAnchorDataAuth)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.x1ITODiFSkZnvkBKgtPqo4RfF0Q(this, paramQQLiveAnchorDataAuth));
  }
  
  public void a(QQLiveAnchorDataCheckPermission paramQQLiveAnchorDataCheckPermission)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.iTSKZA-sj9f2TRpGiX76ldi0ZB0(this, paramQQLiveAnchorDataCheckPermission));
  }
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.b9omZ6613ObbhTwBK5mMyLgVcso(this, paramQQLiveAnchorDataEnter));
  }
  
  public void a(QQLiveAnchorDataFastResume paramQQLiveAnchorDataFastResume)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.j20pxUgM139hnI0kUaEbLREExsg(this, paramQQLiveAnchorDataFastResume));
  }
  
  public void a(QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.dZ5xe9CNO1T2IClaQ1_chCSCs2c(this, paramQQLiveAnchorDataInit));
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.hSMWI2pLlrJ8gyf5fuecg6yNks8(this, paramQQLiveAnchorDataPrepare));
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.f8LjC6HWRe3i5R4S05q7cHAsf7I(this, paramQQLiveAnchorDataPublishStream));
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.ZsW4KhjB3j2d4OeWsAyWNy7UWh0(this, paramQQLiveAnchorDataPullInfo));
  }
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.8XQBd0ZdUwYfg2V6wBB5N-LPslU(this, paramQQLiveAnchorDataPushInfo));
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.2NJhq6LrxP_yKuxas_pe_TWFils(this, paramQQLiveAnchorDataSet));
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.CgDBQLegqLX42PVMZZNiNHWVafs(this, paramQQLiveAnchorDataThirdPushCheck));
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.bR7xYj_krugJJLaEE3Cl-qqERWo(this, paramQQLiveErrorMsg));
  }
  
  public void b()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.2Im7dWxUWC7CCXYEYmTtJT5l8CE(this));
  }
  
  public void b(IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    this.a.remove(paramIQQLiveAnchorRoomCallback);
    if ((paramIQQLiveAnchorRoomCallback instanceof IQQLiveAnchorRoomThirdPush)) {
      this.b.remove((IQQLiveAnchorRoomThirdPush)paramIQQLiveAnchorRoomCallback);
    }
  }
  
  public void c()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.RxZ1XkHBYnGZzdcUnknS2pm1bt8(this));
  }
  
  public void d()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.nstLOJkBkBmXg-GZRJCj4355Jxw(this));
  }
  
  public void e()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.pYFuf2JqAKXIJnN1Ph6_FzQNVRc(this));
  }
  
  public void f()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.esQ4LOQIhQkqRmj99fqAmH7IEac(this));
  }
  
  public void g()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public void h()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.vCLR-ETZdLltDC8llNt52EtKZGI(this));
  }
  
  public void i()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.6QB-qWJw7FKfjjlSiY2SBFAZQek(this));
  }
  
  public void j()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.zyrQAbX8-3KmcQi1mfyI7kAHvjM(this));
  }
  
  public void k()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.pQmd8Y0CZselSHe-mOEDtP6d7zA(this));
  }
  
  public void l()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.LOf-rDp4pm0Pg87PuO_z7EN_xFY(this));
  }
  
  public void m()
  {
    a(new -..Lambda.QQLiveAnchorRoomCallback.Y0HcNLgK4kzQRKQbsrTHsgCxHjo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoomCallback
 * JD-Core Version:    0.7.0.1
 */