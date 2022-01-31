package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bbsh;
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
    int i = bbsh.a().get();
    if ((i < 0) || (i >= bbsh.a().size())) {}
    for (;;)
    {
      return;
      String str = (String)bbsh.a().get(i);
      AtomicInteger localAtomicInteger = (AtomicInteger)bbsh.a().get(str);
      Object localObject = (AtomicInteger)bbsh.b().get(str);
      for (AtomicReference localAtomicReference = (AtomicReference)bbsh.c().get(str); localAtomicInteger.get() >= ((AtomicInteger)localObject).get(); localAtomicReference = (AtomicReference)bbsh.c().get(str))
      {
        i += 1;
        j = i;
        if (i >= bbsh.a().size()) {
          break label175;
        }
        str = (String)bbsh.a().get(i);
        localAtomicInteger = (AtomicInteger)bbsh.a().get(str);
        localObject = (AtomicInteger)bbsh.b().get(str);
      }
      int j = i;
      label175:
      bbsh.a().set(j);
      if (j >= bbsh.a().size()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */