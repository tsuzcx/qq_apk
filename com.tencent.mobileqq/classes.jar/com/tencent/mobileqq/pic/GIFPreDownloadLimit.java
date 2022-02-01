package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class GIFPreDownloadLimit
{
  public long a;
  public long b;
  private long c = -1L;
  private long d = -1L;
  private long e = -1L;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public GIFPreDownloadLimit()
  {
    a();
  }
  
  private void a()
  {
    this.a = (PicPreDownloadUtils.b("gifWifiPreDownloadLimit", 1000L) * 1024L * 1024L);
    this.b = (PicPreDownloadUtils.b("gifXgPreDownloadLimit", 32L) * 1024L * 1024L);
    if (QLog.isColorLevel()) {
      QLog.d("GIFPreDownloadLimit", 2, new Object[] { "initConfig, gifWifiPreDownloadLimit=", Long.valueOf(this.a), " gifXgPreDownloadLimit=", Long.valueOf(this.b) });
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean1)
    {
      if (!this.h)
      {
        this.h = true;
        j = 4;
      }
      else
      {
        j = -1;
      }
      k = j;
      if (paramBoolean2)
      {
        k = j;
        if (!this.f)
        {
          this.f = true;
          k = 2;
          break label113;
        }
      }
    }
    else
    {
      if (!this.i)
      {
        this.i = true;
        j = 3;
      }
      else
      {
        j = -1;
      }
      k = j;
      if (paramBoolean2)
      {
        k = j;
        if (!this.g)
        {
          this.g = true;
          k = 1;
          break label113;
        }
      }
    }
    int j = k;
    int k = -1;
    label113:
    String str;
    if (j > 0)
    {
      if (paramBoolean1) {
        str = "gifWifiFirstFlag";
      } else {
        str = "gifXgFirstFlag";
      }
      PicPreDownloadUtils.a(str, 1L);
      ReportController.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", j, 0, "", "", "", "");
    }
    if (k > 0)
    {
      if (paramBoolean1) {
        str = "gifWifiOverFlag";
      } else {
        str = "gifXgOverFlag";
      }
      PicPreDownloadUtils.a(str, 1L);
      ReportController.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", k, 0, "", "", "", "");
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean1) {
      str = "Wifi";
    } else {
      str = "XG";
    }
    localHashMap.put("NetworkType", str);
    if (paramBoolean2) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("OverLimit", str);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AioGifPreDownload", true, -1L, paramLong, localHashMap, null);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    boolean bool = false;
    if (paramMessageForPic == null) {
      return false;
    }
    if ((paramMessageForPic.mNotPredownloadReason == -11) || (paramMessageForPic.mNotPredownloadReason == 2)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(MessageForPic paramMessageForPic, boolean paramBoolean, int paramInt)
  {
    if (paramMessageForPic == null) {
      return (paramBoolean) && (paramInt == 6);
    }
    return (PicBusUtil.a(paramMessageForPic.imageType)) && (paramInt == 6);
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    long l = this.c;
    boolean bool2 = true;
    if ((l < 0L) || (this.d < 0L) || (this.e < 0L))
    {
      this.c = PicPreDownloadUtils.b("gifWifiPreDownloadFlow", 0L);
      this.d = PicPreDownloadUtils.b("gifXgPreDownloadFlow", 0L);
      this.e = PicPreDownloadUtils.b("gifPreDownloadTimestamp", 0L);
      if (this.e == 0L) {
        this.e = System.currentTimeMillis();
      }
      if (PicPreDownloadUtils.b("gifWifiOverFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.f = bool1;
      if (PicPreDownloadUtils.b("gifXgOverFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.g = bool1;
      if (PicPreDownloadUtils.b("gifWifiFirstFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.h = bool1;
      if (PicPreDownloadUtils.b("gifXgFirstFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.i = bool1;
    }
    if (!a(this.e, System.currentTimeMillis()))
    {
      this.c = 0L;
      this.d = 0L;
      this.e = System.currentTimeMillis();
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
    }
    if (paramBoolean)
    {
      if (this.c > this.a)
      {
        bool1 = bool2;
        break label279;
      }
    }
    else if (this.d > this.b)
    {
      bool1 = bool2;
      break label279;
    }
    boolean bool1 = false;
    label279:
    if (!bool1) {
      b(paramBoolean, paramLong);
    }
    a(paramBoolean, bool1, paramLong);
    return bool1;
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.c += paramLong;
    } else {
      this.d += paramLong;
    }
    PicPreDownloadUtils.a("gifWifiPreDownloadFlow", this.c);
    PicPreDownloadUtils.a("gifXgPreDownloadFlow", this.d);
    PicPreDownloadUtils.a("gifPreDownloadTimestamp", this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.GIFPreDownloadLimit
 * JD-Core Version:    0.7.0.1
 */