package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdvk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class VipGrayConfigHelper$1
  implements Runnable
{
  public void run()
  {
    int i = bdvk.a().get();
    if ((i < 0) || (i >= bdvk.a().size())) {}
    for (;;)
    {
      return;
      String str = (String)bdvk.a().get(i);
      AtomicInteger localAtomicInteger = (AtomicInteger)bdvk.a().get(str);
      Object localObject = (AtomicInteger)bdvk.b().get(str);
      for (AtomicReference localAtomicReference = (AtomicReference)bdvk.c().get(str); localAtomicInteger.get() >= ((AtomicInteger)localObject).get(); localAtomicReference = (AtomicReference)bdvk.c().get(str))
      {
        i += 1;
        j = i;
        if (i >= bdvk.a().size()) {
          break label175;
        }
        str = (String)bdvk.a().get(i);
        localAtomicInteger = (AtomicInteger)bdvk.a().get(str);
        localObject = (AtomicInteger)bdvk.b().get(str);
      }
      int j = i;
      label175:
      bdvk.a().set(j);
      if (j >= bdvk.a().size()) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipGrayConfigHelper", 2, "Entry: " + str + ", Case " + (localAtomicInteger.get() + 1) + " of " + ((AtomicInteger)localObject).get());
      }
      try
      {
        localObject = (Intent)localAtomicReference.get();
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
        localAtomicInteger.incrementAndGet();
        BaseApplicationImpl.getApplication().getSharedPreferences("vipGrayConfigSp", 0).edit().putInt(str, localAtomicInteger.get()).apply();
        label317:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VipGrayConfigHelper", 2, "start background webview.");
        return;
      }
      catch (Exception localException)
      {
        break label317;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */