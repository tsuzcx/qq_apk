package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DCAIOPreviewProgressive$ProgressiveData
  extends DataAdapter
{
  private boolean a;
  private long b;
  private long c;
  private long d;
  private boolean e = false;
  
  public HashMap<String, String> a(String paramString)
  {
    long l1 = this.b;
    paramString = null;
    if (l1 != 0L)
    {
      if (this.d == 0L) {
        return null;
      }
      if (QLog.isColorLevel()) {
        paramString = new StringBuilder();
      }
      HashMap localHashMap = new HashMap();
      long l2;
      StringBuilder localStringBuilder;
      if (this.a)
      {
        localHashMap.put("is_progressive", "progressive");
        localHashMap.put("view_count", "1");
        if (this.e)
        {
          localHashMap.put("failure", "1");
        }
        else
        {
          l1 = this.c;
          l2 = this.b;
          if (l1 > l2) {
            localHashMap.put("to_dp", String.valueOf(l1 - l2));
          }
          l1 = this.d;
          l2 = this.b;
          if ((l1 > l2) && (l1 > this.c)) {
            localHashMap.put("to_large", String.valueOf(l1 - l2));
          }
        }
        if (QLog.isColorLevel())
        {
          paramString.append("progressive:\n");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_dp:");
          localStringBuilder.append(String.valueOf(this.c - this.b));
          localStringBuilder.append("\n");
          paramString.append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_large:");
          localStringBuilder.append(String.valueOf(this.d - this.b));
          paramString.append(localStringBuilder.toString());
          QLog.i(DataCollector.a, 2, paramString.toString());
          return localHashMap;
        }
      }
      else
      {
        localHashMap.put("is_progressive", "baseline");
        localHashMap.put("view_count", "1");
        if (this.e)
        {
          localHashMap.put("failure", "1");
        }
        else
        {
          l1 = this.d;
          l2 = this.b;
          if (l1 > l2) {
            localHashMap.put("to_large", String.valueOf(l1 - l2));
          }
        }
        if (QLog.isColorLevel())
        {
          paramString.append("baseline:\n");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_large:");
          localStringBuilder.append(String.valueOf(this.d - this.b));
          paramString.append(localStringBuilder.toString());
          QLog.i(DataCollector.a, 2, paramString.toString());
        }
      }
      return localHashMap;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive.ProgressiveData
 * JD-Core Version:    0.7.0.1
 */