package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class CustomizeStrategyFactory
  implements Handler.Callback, IQWalletConfigService.ConfigUpdateListener, ICustomizeStrategyFactory
{
  public static byte[] a = new byte[0];
  public static float d = 1.0F;
  private static volatile CustomizeStrategyFactory f;
  public boolean b = true;
  public IQWalletConfigService c;
  public boolean e = false;
  private SparseArray<CustomizeStrategyFactory.HBCustomizeStrategy> g = new SparseArray(5);
  private QQLruCache<String, InterfaceRedPkgElem> h = new CustomizeStrategyFactory.1(this, 1020, 30, 10000);
  private Handler i;
  private HashMap<Object, ICustomizeStrategyFactory.OnCustomizeListener> j;
  private boolean k = false;
  private byte[] l = new byte[0];
  private boolean m = false;
  
  public CustomizeStrategyFactory()
  {
    f();
    this.j = new HashMap(8);
    this.i = new Handler(Looper.getMainLooper(), this);
    d = MobileQQ.getContext().getResources().getDisplayMetrics().density;
  }
  
  private CustomizeStrategyFactory.HBCustomizeStrategy a(int paramInt, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCustomizeStrategy type =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("CustomizeStrategyFactory", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (CustomizeStrategyFactory.HBCustomizeStrategy)this.g.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (2 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.VIPHBStrategy(paramBaseQQAppInterface);
    } else if (1 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.ThemeCustomizeStrategy(paramBaseQQAppInterface);
    } else if (4 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.ThemeAnimStrategy(paramBaseQQAppInterface);
    } else if (5 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.SkinRedPacketStrategy(paramBaseQQAppInterface);
    } else if (6 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.VoiceResStrategy(paramBaseQQAppInterface);
    } else if (7 == paramInt) {
      paramBaseQQAppInterface = new CustomizeStrategyFactory.PanelStrategy(paramBaseQQAppInterface);
    } else {
      paramBaseQQAppInterface = null;
    }
    this.g.append(paramInt, paramBaseQQAppInterface);
    return paramBaseQQAppInterface;
  }
  
  private void b(RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo != null) && (paramRedPacketInfo.g) && (paramRedPacketInfo.h != null))
    {
      if (TextUtils.isEmpty(paramRedPacketInfo.h.a)) {
        return;
      }
      paramRedPacketInfo = new CustomizeStrategyFactory.3(this, paramRedPacketInfo);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ThreadManager.post(paramRedPacketInfo, 5, null, true);
        return;
      }
      paramRedPacketInfo.run();
    }
  }
  
  public static CustomizeStrategyFactory d()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new CustomizeStrategyFactory();
        }
      }
      finally {}
    }
    return f;
  }
  
  private void f()
  {
    ThreadManager.post(new CustomizeStrategyFactory.2(this), 5, null, true);
  }
  
  public RedPacketInfo a(BaseQQAppInterface paramBaseQQAppInterface, RedPacketInfo paramRedPacketInfo, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    if ((paramRedPacketInfo != null) && (paramOnCustomizeListener != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRedPacketInfo.type);
      if (paramRedPacketInfo.type == 5)
      {
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.skinType);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.skinId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.bigAnimId);
      }
      else
      {
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramRedPacketInfo.templateId);
        if ((paramRedPacketInfo.type == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.d)))
        {
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramRedPacketInfo.d);
        }
      }
      paramRedPacketInfo.k = ((StringBuilder)localObject).toString();
      paramBaseQQAppInterface = a(paramRedPacketInfo.type, paramBaseQQAppInterface);
      if (paramBaseQQAppInterface == null) {
        return paramRedPacketInfo;
      }
      localObject = (InterfaceRedPkgElem)this.h.get(paramRedPacketInfo.k);
      if (localObject == null)
      {
        this.j.put(paramRedPacketInfo, paramOnCustomizeListener);
        paramBaseQQAppInterface.a(paramRedPacketInfo);
        return paramRedPacketInfo;
      }
      paramBaseQQAppInterface.a(paramRedPacketInfo, (InterfaceRedPkgElem)localObject);
      return paramRedPacketInfo;
    }
    return null;
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if ((this.i != null) && (paramRedPacketInfo != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyCustomizeFinish-type:");
        ((StringBuilder)localObject).append(paramRedPacketInfo.type);
        ((StringBuilder)localObject).append(" isAnimation:");
        ((StringBuilder)localObject).append(paramRedPacketInfo.g);
        QLog.d("CustomizeStrategyFactory", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramRedPacketInfo.type == 2) && (paramRedPacketInfo.g) && (!paramRedPacketInfo.j))
      {
        b(paramRedPacketInfo);
        return;
      }
      Object localObject = this.i.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramRedPacketInfo;
      this.i.sendMessage((Message)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setInAIO isInAIO=");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(",refreshListView=");
      ((StringBuilder)???).append(this.k);
      QLog.d("CustomizeStrategyFactory", 2, ((StringBuilder)???).toString());
    }
    if (paramBoolean)
    {
      this.b = false;
      synchronized (a)
      {
        a.notifyAll();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLockFlag lockFlag");
          localStringBuilder.append(this.b);
          QLog.d("CustomizeStrategyFactory", 2, localStringBuilder.toString());
        }
        if (this.k)
        {
          this.k = false;
          ??? = QWalletHelperImpl.getAppRuntime();
          if ((??? instanceof BaseQQAppInterface))
          {
            ??? = ((BaseQQAppInterface)???).getHandler(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getChatActivityClass());
            if (??? != null)
            {
              ((MqqHandler)???).sendEmptyMessage(12);
              return;
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    HashMap localHashMap = this.j;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRefreshListView refreshListView=");
      localStringBuilder.append(paramBoolean);
      QLog.d("CustomizeStrategyFactory", 2, localStringBuilder.toString());
    }
    this.k = paramBoolean;
  }
  
  public void c()
  {
    b();
    ??? = this.h;
    if (??? != null) {
      ((QQLruCache)???).evictAll();
    }
    ??? = this.g;
    if (??? != null)
    {
      int i1 = ((SparseArray)???).size();
      int n = 0;
      while (n < i1)
      {
        ((CustomizeStrategyFactory.HBCustomizeStrategy)this.g.valueAt(n)).a();
        n += 1;
      }
      this.g.clear();
    }
    synchronized (this.l)
    {
      if (this.c != null) {
        this.c.unRegisterUpdateListener("redPack", this);
      }
      this.m = true;
      this.b = true;
      this.i = null;
      f = null;
      this.e = false;
      this.k = false;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      RedPacketInfo localRedPacketInfo = (RedPacketInfo)paramMessage.obj;
      ICustomizeStrategyFactory.OnCustomizeListener localOnCustomizeListener = (ICustomizeStrategyFactory.OnCustomizeListener)this.j.remove(localRedPacketInfo);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage info type=");
        paramMessage.append(localRedPacketInfo.type);
        paramMessage.append("| listener=");
        paramMessage.append(localOnCustomizeListener);
        paramMessage.append("| templateId=");
        paramMessage.append(localRedPacketInfo.templateId);
        paramMessage.append("| content=");
        paramMessage.append(localRedPacketInfo.d);
        paramMessage.append("| info=");
        paramMessage.append(localRedPacketInfo);
        paramMessage.append("|");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("CustomizeStrategyFactory", 2, paramMessage.toString());
      }
      if (!this.h.containsKey(localRedPacketInfo.k))
      {
        paramMessage = null;
        if (localRedPacketInfo.type == 2)
        {
          paramMessage = new VipRedPkgElem(localRedPacketInfo.k);
          paramMessage.a(localRedPacketInfo);
        }
        else if ((localRedPacketInfo.type != 1) && (localRedPacketInfo.type != 4))
        {
          if (localRedPacketInfo.type == 5)
          {
            if (localRedPacketInfo.skinType == 1)
            {
              paramMessage = new SkinRedPkgElem(localRedPacketInfo.k);
              paramMessage.a(localRedPacketInfo);
              localRedPacketInfo.icon = paramMessage.b(localRedPacketInfo);
            }
            else if ((localRedPacketInfo.skinType != 2) && (localRedPacketInfo.skinType != 4))
            {
              if (localRedPacketInfo.skinType == 3)
              {
                paramMessage = new BigAnimRedPkgElem(localRedPacketInfo.k);
                paramMessage.a(localRedPacketInfo);
              }
            }
            else
            {
              paramMessage = new ResPathRedPkgElem(localRedPacketInfo.k);
              paramMessage.a(localRedPacketInfo);
            }
          }
          else if (localRedPacketInfo.type == 6)
          {
            paramMessage = new VoiceResElem(localRedPacketInfo.k);
            paramMessage.a(localRedPacketInfo);
          }
          else if (localRedPacketInfo.type == 7)
          {
            paramMessage = new PanelRedPkgElem(localRedPacketInfo.k);
            paramMessage.a(localRedPacketInfo);
          }
        }
        else
        {
          paramMessage = new ThemeRedPkgElem(localRedPacketInfo.k);
          paramMessage.a(localRedPacketInfo);
        }
        if ((paramMessage != null) && (paramMessage.a())) {
          this.h.put(localRedPacketInfo.k, paramMessage);
        }
      }
      if (localOnCustomizeListener != null) {
        localOnCustomizeListener.a(localRedPacketInfo.type, localRedPacketInfo);
      }
    }
    return false;
  }
  
  public void onUpdate(String paramString1, String paramString2, ConfigInfo paramConfigInfo)
  {
    paramString1 = this.h;
    if (paramString1 == null) {
      return;
    }
    paramString1 = paramString1.snapshot().entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (InterfaceRedPkgElem)((Map.Entry)paramString1.next()).getValue();
      if (((paramString2 instanceof SkinRedPkgElem)) || ((paramString2 instanceof BigAnimRedPkgElem))) {
        paramString1.remove();
      }
    }
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).onUpdate(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */