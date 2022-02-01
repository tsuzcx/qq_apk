package com.tencent.mobileqq.ecshop.redpoint;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

public class RedPointInfo
{
  public int mBeginTime;
  public int mDelaySeconds;
  public int mEndTime;
  public int mRedType;
  public String mRedUrl;
  public int mTabId;
  public int mTashId;
  
  @NonNull
  public RedPointInfo parse(qq_ad.QQAdGetRsp.RedPointInfo paramRedPointInfo)
  {
    boolean bool = paramRedPointInfo.begin_time.has();
    int j = 0;
    if (bool) {
      i = paramRedPointInfo.begin_time.get();
    } else {
      i = 0;
    }
    this.mBeginTime = i;
    if (paramRedPointInfo.task_id.has()) {
      i = paramRedPointInfo.task_id.get();
    } else {
      i = 0;
    }
    this.mTashId = i;
    if (paramRedPointInfo.tab_id.has()) {
      i = paramRedPointInfo.tab_id.get();
    } else {
      i = 0;
    }
    this.mTabId = i;
    if (paramRedPointInfo.end_time.has()) {
      i = paramRedPointInfo.end_time.get();
    } else {
      i = 0;
    }
    this.mEndTime = i;
    if (paramRedPointInfo.delay_second.has()) {
      i = paramRedPointInfo.delay_second.get();
    } else {
      i = 0;
    }
    this.mDelaySeconds = i;
    int i = j;
    if (paramRedPointInfo.red_type.has()) {
      i = paramRedPointInfo.red_type.get();
    }
    this.mRedType = i;
    if (paramRedPointInfo.red_url.has()) {
      paramRedPointInfo = paramRedPointInfo.red_url.get();
    } else {
      paramRedPointInfo = "";
    }
    this.mRedUrl = paramRedPointInfo;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedPointInfo{mTashId=");
    localStringBuilder.append(this.mTashId);
    localStringBuilder.append(", mTabId=");
    localStringBuilder.append(this.mTabId);
    localStringBuilder.append(", mBeginTime=");
    localStringBuilder.append(this.mBeginTime);
    localStringBuilder.append(", mEndTime=");
    localStringBuilder.append(this.mEndTime);
    localStringBuilder.append(", mDelaySeconds=");
    localStringBuilder.append(this.mDelaySeconds);
    localStringBuilder.append(", mRedType=");
    localStringBuilder.append(this.mRedType);
    localStringBuilder.append(", mRedUrl='");
    localStringBuilder.append(this.mRedUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.redpoint.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */