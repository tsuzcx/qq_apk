package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dualsim.common.OrderCheckResult;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class KCWraper
{
  private static SharedPreferences a()
  {
    return MobileQQ.getContext().getSharedPreferences("CUKingCardFile_sdk", 4);
  }
  
  protected static Pair<Boolean, Integer> a()
  {
    SharedPreferences localSharedPreferences = a();
    return new Pair(Boolean.valueOf(localSharedPreferences.getBoolean("kingCard", false)), Integer.valueOf(localSharedPreferences.getInt("kingCardProduct", 0)));
  }
  
  protected static void a(boolean paramBoolean)
  {
    a().edit().putBoolean("supportActivationView", paramBoolean).apply();
  }
  
  protected static boolean a(@NonNull String paramString, @NonNull OrderCheckResult paramOrderCheckResult)
  {
    Object localObject = a();
    int i = -1;
    boolean bool;
    if (((SharedPreferences)localObject).getInt("kingCardProduct", -1) != paramOrderCheckResult.product)
    {
      localObject = ((SharedPreferences)localObject).edit().putInt("kingCardProduct", paramOrderCheckResult.product);
      if (paramOrderCheckResult.kingcard > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((SharedPreferences.Editor)localObject).putBoolean("kingCard", bool).apply();
    }
    localObject = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(paramString);
    paramString = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    int j = paramString.getInt("kingCardSdk", -1);
    localObject = VasUtil.a().getKingCardManager();
    if (paramOrderCheckResult.kingcard != 0) {
      if (paramOrderCheckResult.kingcard == 1)
      {
        if (paramOrderCheckResult.product == 90155946) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    if (j != i)
    {
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((IKingCardManager)localObject).setKingCardState(bool);
      paramString.edit().putInt("kingCardSdk", i).putInt("toast_version", 0).putInt("popup_version_v2", 0).commit();
      return true;
    }
    return false;
  }
  
  protected static boolean c()
  {
    return a().getBoolean("supportActivationView", false);
  }
  
  String a()
  {
    return "KC.KCWraper";
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    if (paramCallback != null)
    {
      if (paramBoolean)
      {
        ThreadManager.getUIHandler().post(new KCWraper.1(this, paramCallback));
        return;
      }
      paramCallback.a(false, false, 0);
    }
  }
  
  void a(Runnable paramRunnable)
  {
    a("tryLoad : disable kingcard");
  }
  
  protected final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a(), 2, paramString);
    }
  }
  
  boolean a()
  {
    a("isReady : disable kingcard");
    return false;
  }
  
  boolean a(Activity paramActivity)
  {
    return false;
  }
  
  boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraper
 * JD-Core Version:    0.7.0.1
 */