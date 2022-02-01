package com.tencent.mobileqq.qqgift.countdown;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.utils.QQGiftSpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class CountDownController
{
  private static final byte[] d = new byte[1];
  private String a;
  private Timer b = null;
  private final TimerInfo c = new TimerInfo();
  private final Map<String, CountDownInfo> e = new ConcurrentHashMap();
  private final MutableLiveData<TimerInfo> f = new MutableLiveData();
  
  public CountDownController(String paramString)
  {
    this.a = paramString;
  }
  
  private void e()
  {
    synchronized (d)
    {
      this.b = new Timer();
      h();
      this.b.schedule(new CountDownController.2(this), 1000L, 1000L);
      return;
    }
  }
  
  private void f()
  {
    synchronized (d)
    {
      if (this.b != null)
      {
        this.b.cancel();
        this.b.purge();
      }
      return;
    }
  }
  
  private void g()
  {
    String str1 = QQGiftSpUtil.a(MobileQQ.sMobileQQ, j());
    try
    {
      this.e.clear();
      JSONObject localJSONObject = new JSONObject(str1);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        long l = localJSONObject.optLong(str2);
        if (l > 0L)
        {
          CountDownInfo localCountDownInfo = new CountDownInfo(Integer.parseInt(str2), 1L + l, l);
          this.e.put(str2, localCountDownInfo);
        }
        else
        {
          localIterator.remove();
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CountDownControl", 1, localException, new Object[0]);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initCountDownMapFromSp] ");
        localStringBuilder.append(str1);
        QLog.i("CountDownControl", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void h()
  {
    if (this.e.size() == 0)
    {
      f();
      if (QLog.isColorLevel()) {
        QLog.i("CountDownControl", 2, "[onTimerUpdate] mCountDownInfoMap is empty");
      }
      return;
    }
    MutableLiveData localMutableLiveData = c();
    if (localMutableLiveData != null)
    {
      Iterator localIterator = this.e.values().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        CountDownInfo localCountDownInfo = (CountDownInfo)localIterator.next();
        int j;
        if (localCountDownInfo.b > 1L)
        {
          localCountDownInfo.b -= 1L;
          j = i;
        }
        else
        {
          localIterator.remove();
          j = 1;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onTimerUpdate] countDownInfo:");
          localStringBuilder.append(localCountDownInfo);
          localStringBuilder.append(",updateData:");
          localStringBuilder.append(localMutableLiveData);
          QLog.i("CountDownControl", 2, localStringBuilder.toString());
          i = j;
        }
      }
      if (i != 0) {
        i();
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        localMutableLiveData.setValue(this.c);
        return;
      }
      localMutableLiveData.postValue(this.c);
    }
  }
  
  private void i()
  {
    if (this.e.size() > 0)
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          localJSONObject.put((String)localEntry.getKey(), ((CountDownInfo)localEntry.getValue()).c);
          QQGiftSpUtil.a(MobileQQ.sMobileQQ, j(), localJSONObject.toString());
        }
        catch (Exception localException)
        {
          QLog.e("CountDownControl", 1, localException, new Object[0]);
        }
      }
    }
    QQGiftSpUtil.b(MobileQQ.sMobileQQ, j());
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_count_down_gift");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    ThreadManagerV2.executeOnSubThread(new CountDownController.1(this));
  }
  
  public void a(int paramInt, long paramLong)
  {
    CountDownInfo localCountDownInfo = new CountDownInfo(paramInt, paramLong + 1L, paramLong);
    this.e.put(String.valueOf(paramInt), localCountDownInfo);
    i();
    f();
    e();
  }
  
  public void b()
  {
    f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[exitRoom] key:");
      localStringBuilder.append(this.a);
      QLog.i("CountDownControl", 2, localStringBuilder.toString());
    }
  }
  
  public MutableLiveData<TimerInfo> c()
  {
    return this.f;
  }
  
  public Map<String, CountDownInfo> d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.countdown.CountDownController
 * JD-Core Version:    0.7.0.1
 */