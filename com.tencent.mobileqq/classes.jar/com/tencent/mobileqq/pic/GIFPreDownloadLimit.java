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
  private boolean a;
  public long b;
  private boolean b;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private long e = -1L;
  
  public GIFPreDownloadLimit()
  {
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = (PicPreDownloadUtils.a("gifWifiPreDownloadLimit", 1000L) * 1024L * 1024L);
    this.jdField_b_of_type_Long = (PicPreDownloadUtils.a("gifXgPreDownloadLimit", 32L) * 1024L * 1024L);
    if (QLog.isColorLevel()) {
      QLog.d("GIFPreDownloadLimit", 2, new Object[] { "initConfig, gifWifiPreDownloadLimit=", Long.valueOf(this.jdField_a_of_type_Long), " gifXgPreDownloadLimit=", Long.valueOf(this.jdField_b_of_type_Long) });
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean1)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        i = 4;
      }
      else
      {
        i = -1;
      }
      j = i;
      if (paramBoolean2)
      {
        j = i;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          j = 2;
          break label113;
        }
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        i = 3;
      }
      else
      {
        i = -1;
      }
      j = i;
      if (paramBoolean2)
      {
        j = i;
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          j = 1;
          break label113;
        }
      }
    }
    int i = j;
    int j = -1;
    label113:
    String str;
    if (i > 0)
    {
      if (paramBoolean1) {
        str = "gifWifiFirstFlag";
      } else {
        str = "gifXgFirstFlag";
      }
      PicPreDownloadUtils.a(str, 1L);
      ReportController.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", i, 0, "", "", "", "");
    }
    if (j > 0)
    {
      if (paramBoolean1) {
        str = "gifWifiOverFlag";
      } else {
        str = "gifXgOverFlag";
      }
      PicPreDownloadUtils.a(str, 1L);
      ReportController.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", j, 0, "", "", "", "");
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
      return (paramBoolean) && (paramInt == 5);
    }
    return (PicBusUtil.a(paramMessageForPic.imageType)) && (paramInt == 5);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.jdField_c_of_type_Long += paramLong;
    } else {
      this.jdField_d_of_type_Long += paramLong;
    }
    PicPreDownloadUtils.a("gifWifiPreDownloadFlow", this.jdField_c_of_type_Long);
    PicPreDownloadUtils.a("gifXgPreDownloadFlow", this.jdField_d_of_type_Long);
    PicPreDownloadUtils.a("gifPreDownloadTimestamp", this.e);
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    long l = this.jdField_c_of_type_Long;
    boolean bool2 = true;
    if ((l < 0L) || (this.jdField_d_of_type_Long < 0L) || (this.e < 0L))
    {
      this.jdField_c_of_type_Long = PicPreDownloadUtils.a("gifWifiPreDownloadFlow", 0L);
      this.jdField_d_of_type_Long = PicPreDownloadUtils.a("gifXgPreDownloadFlow", 0L);
      this.e = PicPreDownloadUtils.a("gifPreDownloadTimestamp", 0L);
      if (this.e == 0L) {
        this.e = System.currentTimeMillis();
      }
      if (PicPreDownloadUtils.a("gifWifiOverFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_a_of_type_Boolean = bool1;
      if (PicPreDownloadUtils.a("gifXgOverFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_b_of_type_Boolean = bool1;
      if (PicPreDownloadUtils.a("gifWifiFirstFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_c_of_type_Boolean = bool1;
      if (PicPreDownloadUtils.a("gifXgFirstFlag", 0L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_d_of_type_Boolean = bool1;
    }
    if (!a(this.e, System.currentTimeMillis()))
    {
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      this.e = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
    }
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_Long > this.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        break label279;
      }
    }
    else if (this.jdField_d_of_type_Long > this.jdField_b_of_type_Long)
    {
      bool1 = bool2;
      break label279;
    }
    boolean bool1 = false;
    label279:
    if (!bool1) {
      a(paramBoolean, paramLong);
    }
    a(paramBoolean, bool1, paramLong);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.GIFPreDownloadLimit
 * JD-Core Version:    0.7.0.1
 */