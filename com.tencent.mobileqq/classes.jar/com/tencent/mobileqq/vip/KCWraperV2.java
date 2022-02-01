package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKcActivationViewer;
import dualsim.common.IKingCardInterface;
import dualsim.common.OrderCheckResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import tmsdk.common.KcSdkShellManager;

public class KCWraperV2
  extends KCWraper
{
  public AtomicBoolean a = new AtomicBoolean(false);
  
  private void a(Context paramContext, File paramFile)
  {
    ThreadManager.post(new KCWraperV2.1(this, paramFile, paramContext), 5, null, false);
  }
  
  private void a(OrderCheckResult paramOrderCheckResult)
  {
    if (paramOrderCheckResult != null) {
      localObject1 = paramOrderCheckResult.toString();
    } else {
      localObject1 = "result == null";
    }
    a((String)localObject1);
    if (paramOrderCheckResult == null) {
      return;
    }
    Object localObject1 = VasUtil.d();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((AppInterface)localObject1).getAccount();
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    int i = 1;
    if (!bool1)
    {
      boolean bool2 = a((String)localObject1, paramOrderCheckResult);
      Object localObject2 = paramOrderCheckResult.phoneNum;
      if (paramOrderCheckResult.operator == 1)
      {
        IVasDepTemp localIVasDepTemp = (IVasDepTemp)QRoute.api(IVasDepTemp.class);
        if (paramOrderCheckResult.kingcard == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localIVasDepTemp.guanjiaReport((String)localObject1, (String)localObject2, bool1, paramOrderCheckResult.product, "");
        localObject2 = (IVasDepTemp)QRoute.api(IVasDepTemp.class);
        long l = Long.parseLong((String)localObject1);
        if (paramOrderCheckResult.kingcard != 1) {
          i = 0;
        }
        ((IVasDepTemp)localObject2).reportKCLP(l, i);
      }
      if (bool2)
      {
        paramOrderCheckResult = ((TicketManager)VasUtil.d().getManager(2)).getSkey((String)localObject1);
        ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).sendGetBaseVipInfoReq(paramOrderCheckResult, (String)localObject1);
      }
    }
    else
    {
      QLog.e("KC.TMSManager", 1, "tmsQuery can't get uin");
    }
  }
  
  String a()
  {
    return "KC.KCWraperV2";
  }
  
  void a(ViewGroup paramViewGroup)
  {
    Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
    if (localObject != null)
    {
      localObject = ((IKingCardInterface)localObject).generateActivationView(paramViewGroup.getContext());
      if (localObject != null)
      {
        paramViewGroup.addView(((IKcActivationViewer)localObject).getWebView());
        ((IKcActivationViewer)localObject).startLoad();
        return;
      }
      QLog.e("KC.TMSManager", 1, "activationViewer == null");
    }
    QLog.e("KC.TMSManager", 1, "kingCardInterface == null");
  }
  
  public void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    ThreadManager.post(new KCWraperV2.2(this, paramCallback, paramBoolean), 5, null, false);
  }
  
  void a(Runnable paramRunnable)
  {
    a("load jar");
    if (this.a.get()) {
      return;
    }
    Context localContext = VasUtil.c().getApplicationContext();
    File localFile = new File(TMSManager.b().a(localContext));
    if (!localFile.exists())
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      a(false);
      return;
    }
    a(localContext, localFile);
  }
  
  boolean a(Activity paramActivity)
  {
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).startKingCardActivationFragment();
    return true;
  }
  
  boolean b()
  {
    if (this.a.get()) {
      return true;
    }
    if (!new File(TMSManager.b().a(VasUtil.c().getApplicationContext())).exists()) {
      return false;
    }
    try
    {
      synchronized (this.a)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a(), 1, "wait load");
        }
        this.a.wait(500L);
        if (QLog.isColorLevel()) {
          QLog.e(a(), 1, "wait end");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      QLog.e(a(), 1, localInterruptedException, new Object[0]);
      return this.a.get();
    }
  }
  
  boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("KC.TMSManager", 1, "supportActivationView == true");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2
 * JD-Core Version:    0.7.0.1
 */