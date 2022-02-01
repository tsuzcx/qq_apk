package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopVideoManager
  implements Manager
{
  public Map<String, Integer> a = new ConcurrentHashMap();
  protected Handler b;
  QQAppInterface c = null;
  
  public TroopVideoManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.b = new Handler(Looper.getMainLooper());
    b();
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.a.get(String.valueOf(paramString));
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Integer)this.a.get(str)).intValue() == 1)
      {
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(";");
      }
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1).toString();
      SharePreferenceUtils.a(this.c.getApp(), "TroopVideoNotify", (String)localObject);
      return;
    }
    SharePreferenceUtils.a(this.c.getApp(), "TroopVideoNotify", "");
  }
  
  public void a(long paramLong)
  {
    Integer localInteger = (Integer)this.a.get(String.valueOf(paramLong));
    int j = 0;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    boolean bool = this.c.getAVNotifyCenter().d(paramLong);
    if ((bool) && (i == 0)) {
      j = 1;
    } else if (bool) {
      j = i;
    }
    this.a.put(String.valueOf(paramLong), Integer.valueOf(j));
    if (j != i) {
      a();
    }
  }
  
  public void b()
  {
    Object localObject = SharePreferenceUtils.a(this.c.getApp(), "TroopVideoNotify");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          this.a.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (a(paramString) == 1)
    {
      this.a.put(paramString, Integer.valueOf(2));
      a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopVideoManager
 * JD-Core Version:    0.7.0.1
 */