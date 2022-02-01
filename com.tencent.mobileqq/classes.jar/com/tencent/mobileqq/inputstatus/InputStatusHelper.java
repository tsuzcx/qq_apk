package com.tencent.mobileqq.inputstatus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class InputStatusHelper
  implements ILifeCycleHelper
{
  private static final String c = "InputStatusHelper";
  public long a = 5000L;
  public long b;
  private boolean d = true;
  private Handler e;
  private InputStatusPushManager f;
  private BaseChatPie g;
  private String h = "";
  private boolean i = false;
  private InputStatusObserver j;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private TextWatcher n = new InputStatusHelper.1(this);
  private Runnable o = new InputStatusHelper.2(this);
  
  public InputStatusHelper(BaseChatPie paramBaseChatPie)
  {
    this.g = paramBaseChatPie;
  }
  
  private void a(int paramInt)
  {
    if ((m()) && (n()) && (h())) {
      try
      {
        this.k = paramInt;
        long l1 = Long.parseLong(this.g.ah.b);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.g.d.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(paramInt, l1);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(c, 1, localException, new Object[0]);
      }
    }
  }
  
  private Handler f()
  {
    if (this.e == null) {
      this.e = new Handler(Looper.getMainLooper());
    }
    return this.e;
  }
  
  private InputStatusPushManager g()
  {
    if (this.f == null)
    {
      Manager localManager = this.g.d.getManager(QQManagerFactory.AIO_INPUT_STATUS_MANAGER);
      if ((localManager instanceof InputStatusPushManager)) {
        this.f = ((InputStatusPushManager)localManager);
      }
    }
    return this.f;
  }
  
  private boolean h()
  {
    BaseChatPie localBaseChatPie = this.g;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof LimitChatPie))) {
      return j();
    }
    return i();
  }
  
  private boolean i()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.b().b(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.a;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(c, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean j()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.b().b(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.b;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(c, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private void k()
  {
    if ((this.g != null) && (n()) && (h())) {
      try
      {
        long l1 = Long.parseLong(this.g.ah.b);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.g.d.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(2, l1);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(c, 1, localException, new Object[0]);
      }
    }
  }
  
  private boolean l()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.g.d.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    return (localStatus != AppRuntime.Status.away) && (localStatus != AppRuntime.Status.busy) && (localStatus != AppRuntime.Status.dnd) && (localStatus != AppRuntime.Status.invisiable);
  }
  
  private boolean m()
  {
    if ((this.g instanceof LimitChatPie)) {
      return true;
    }
    return l();
  }
  
  private boolean n()
  {
    BaseChatPie localBaseChatPie = this.g;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof LimitChatPie))) {
      return true;
    }
    return this.d;
  }
  
  public void a()
  {
    if (!this.m)
    {
      this.m = true;
      if ((n()) && (h())) {
        f().postDelayed(this.o, 1000L);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    boolean bool = this.i;
    if (!bool) {
      this.g.a(bool, this.h);
    }
  }
  
  void a(boolean paramBoolean, String paramString)
  {
    BaseChatPie localBaseChatPie = this.g;
    this.i = paramBoolean;
    if (!paramBoolean) {
      paramString = this.h;
    }
    localBaseChatPie.a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.i = false;
    this.g.a(this.i, this.h);
    if (g() != null) {
      g().a();
    }
  }
  
  public void c()
  {
    f().removeCallbacks(this.o);
    if ((n()) && (h())) {
      try
      {
        long l1 = Long.parseLong(this.g.ah.b);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.g.d.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(2, l1);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(c, 1, localException, new Object[0]);
      }
    }
  }
  
  public void d()
  {
    this.m = false;
    this.l = false;
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    this.i = false;
    this.k = 0;
    d();
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      if (g() != null) {
        g().onDestroy();
      }
      Object localObject = this.g;
      if (localObject != null)
      {
        if (((BaseChatPie)localObject).Y != null) {
          this.g.Y.removeTextChangedListener(this.n);
        }
        this.g.d.removeObserver(this.j);
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.o);
        this.e = null;
      }
      k();
      return;
    }
    if ((this.g != null) && (h()))
    {
      if (this.j == null) {
        this.j = new InputStatusHelper.InnerInputStatusObserver(this, null);
      }
      this.g.d.addObserver(this.j);
      this.d = this.g.d.getVisibilityForInputStatus(true);
      if (n())
      {
        if (g() != null) {
          g().a(this.g);
        }
        this.g.Y.addTextChangedListener(this.n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHelper
 * JD-Core Version:    0.7.0.1
 */