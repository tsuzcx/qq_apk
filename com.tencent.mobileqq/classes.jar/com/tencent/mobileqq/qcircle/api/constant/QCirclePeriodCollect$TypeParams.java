package com.tencent.mobileqq.qcircle.api.constant;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCirclePeriodCollect$TypeParams
{
  private boolean hasRecordRealLoad = false;
  private boolean isPurelyMemCache = false;
  private final ArrayList<Pair<String, Long>> mPeriodList = new ArrayList();
  private String state;
  
  boolean filterPageLoaded(String paramString)
  {
    if (paramString.equals("page_loaded")) {
      if (!this.hasRecordRealLoad) {
        this.hasRecordRealLoad = true;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public void record(String paramString1, String paramString2)
  {
    if (QCirclePeriodCollect.access$000()) {
      return;
    }
    if (filterPageLoaded(paramString2)) {
      return;
    }
    paramString2 = new Pair(paramString2, Long.valueOf(System.currentTimeMillis()));
    this.mPeriodList.add(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record type:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",period:");
    localStringBuilder.append((String)paramString2.first);
    localStringBuilder.append(",start :");
    localStringBuilder.append(paramString2.second);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(((Long)paramString2.second).longValue() - QCirclePeriodCollect.access$100());
    localStringBuilder.append("ms");
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  public void setState(String paramString)
  {
    if (!TextUtils.isEmpty(this.state)) {
      return;
    }
    if ("get_page_cache_rsp".equals(paramString)) {
      this.state = "2";
    } else if ("get_page_net_rsp".equals(paramString)) {
      this.state = "3";
    } else if (TextUtils.isEmpty(paramString)) {
      this.state = "1";
    }
    paramString = new StringBuilder();
    paramString.append("setState state:");
    paramString.append(this.state);
    QLog.d("QCirclePeriodCollect", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect.TypeParams
 * JD-Core Version:    0.7.0.1
 */