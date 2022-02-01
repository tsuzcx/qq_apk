package com.tencent.mobileqq.inputstatus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class InputStatusPushManager
  implements Manager
{
  private static final String a = "InputStatusPushManager";
  private QQAppInterface b;
  private WeakReference<BaseChatPie> c;
  private Handler d;
  private boolean e = false;
  private Runnable f = new InputStatusPushManager.1(this);
  
  public InputStatusPushManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private boolean b()
  {
    WeakReference localWeakReference = this.c;
    if ((localWeakReference != null) && ((localWeakReference.get() instanceof LimitChatPie))) {
      return d();
    }
    return c();
  }
  
  private boolean c()
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
      QLog.e(a, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean d()
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
      QLog.e(a, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private Handler e()
  {
    if (this.d == null) {
      this.d = new Handler(Looper.getMainLooper());
    }
    return this.d;
  }
  
  private InputStatusHelper f()
  {
    if (this.c.get() != null) {
      return (InputStatusHelper)((BaseChatPie)this.c.get()).q(16);
    }
    return null;
  }
  
  void a()
  {
    e().removeCallbacks(this.f);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("receive fromUin =");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("，toUin，timeStamp =");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("，interval =");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("，showTime =");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("，eventType = ");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("，statusText =");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (b()))
    {
      e().removeCallbacks(this.f);
      if (f() != null)
      {
        f().a = (paramInt1 * 1000);
        f().b = paramLong3;
      }
      localObject1 = ((BaseChatPie)this.c.get()).ah.b;
      localObject2 = ((BaseChatPie)this.c.get()).d.getCurrentAccountUin();
      if ((TextUtils.equals((CharSequence)localObject1, String.valueOf(paramLong1))) && (TextUtils.equals((CharSequence)localObject2, String.valueOf(paramLong2))))
      {
        boolean bool;
        if (paramInt3 != 2) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool)
        {
          localObject1 = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            if (paramInt3 == 1) {
              paramInt1 = 2131903745;
            } else {
              paramInt1 = 2131903746;
            }
            localObject1 = HardCodeUtil.a(paramInt1);
          }
          e().postDelayed(this.f, paramInt2 * 1000);
        }
        else
        {
          localObject1 = "";
        }
        if (f() != null) {
          f().a(bool, (String)localObject1);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.c = new WeakReference(paramBaseChatPie);
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusPushManager
 * JD-Core Version:    0.7.0.1
 */