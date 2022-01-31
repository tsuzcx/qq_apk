package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdrb;
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
    int i = bdrb.a().get();
    if ((i < 0) || (i >= bdrb.a().size())) {}
    for (;;)
    {
      return;
      String str = (String)bdrb.a().get(i);
      AtomicInteger localAtomicInteger = (AtomicInteger)bdrb.a().get(str);
      Object localObject = (AtomicInteger)bdrb.b().get(str);
      for (AtomicReference localAtomicReference = (AtomicReference)bdrb.c().get(str); localAtomicInteger.get() >= ((AtomicInteger)localObject).get(); localAtomicReference = (AtomicReference)bdrb.c().get(str))
      {
        i += 1;
        j = i;
        if (i >= bdrb.a().size()) {
          break label175;
        }
        str = (String)bdrb.a().get(i);
        localAtomicInteger = (AtomicInteger)bdrb.a().get(str);
        localObject = (AtomicInteger)bdrb.b().get(str);
      }
      int j = i;
      label175:
      bdrb.a().set(j);
      if (j >= bdrb.a().size()) {
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