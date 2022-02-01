package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.MobileQQ;

final class VipGrayConfigHelper$1
  implements Runnable
{
  public void run()
  {
    int i = VipGrayConfigHelper.a().get();
    String str;
    AtomicInteger localAtomicInteger;
    Object localObject;
    AtomicReference localAtomicReference;
    if (i >= 0)
    {
      if (i >= VipGrayConfigHelper.a().size()) {
        return;
      }
      str = (String)VipGrayConfigHelper.a().get(i);
      localAtomicInteger = (AtomicInteger)VipGrayConfigHelper.a().get(str);
      localObject = (AtomicInteger)VipGrayConfigHelper.b().get(str);
      int j;
      for (localAtomicReference = (AtomicReference)VipGrayConfigHelper.c().get(str);; localAtomicReference = (AtomicReference)VipGrayConfigHelper.c().get(str))
      {
        j = i;
        if (localAtomicInteger.get() < ((AtomicInteger)localObject).get()) {
          break;
        }
        i += 1;
        j = i;
        if (i >= VipGrayConfigHelper.a().size()) {
          break;
        }
        str = (String)VipGrayConfigHelper.a().get(i);
        localAtomicInteger = (AtomicInteger)VipGrayConfigHelper.a().get(str);
        localObject = (AtomicInteger)VipGrayConfigHelper.b().get(str);
      }
      VipGrayConfigHelper.a().set(j);
      if (j >= VipGrayConfigHelper.a().size()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Entry: ");
        localStringBuilder.append(str);
        localStringBuilder.append(", Case ");
        localStringBuilder.append(localAtomicInteger.get() + 1);
        localStringBuilder.append(" of ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d("VipGrayConfigHelper", 2, localStringBuilder.toString());
      }
    }
    try
    {
      localObject = (Intent)localAtomicReference.get();
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      MobileQQ.getContext().startActivity((Intent)localObject);
      localAtomicInteger.incrementAndGet();
      MobileQQ.getContext().getSharedPreferences("vipGrayConfigSp", 0).edit().putInt(str, localAtomicInteger.get()).apply();
      label336:
      if (QLog.isColorLevel()) {
        QLog.d("VipGrayConfigHelper", 2, "start background webview.");
      }
      return;
    }
    catch (Exception localException)
    {
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */