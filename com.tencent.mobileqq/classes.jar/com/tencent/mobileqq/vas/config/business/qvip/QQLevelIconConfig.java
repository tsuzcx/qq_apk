package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.res.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.Serializable;
import mqq.app.MobileQQ;

public class QQLevelIconConfig
  implements Serializable
{
  public String mExpiredNotifyPaymentText;
  public boolean mIsEnableGuide = true;
  public boolean mIsNotifyPayment = true;
  public String mNotifyPaymentText;
  
  public QQLevelIconConfig()
  {
    Resources localResources = MobileQQ.getContext().getResources();
    this.mNotifyPaymentText = localResources.getString(2131914227);
    this.mExpiredNotifyPaymentText = localResources.getString(2131914226);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLevelIconConfig{mIsEnableGuide=");
    localStringBuilder.append(this.mIsEnableGuide);
    localStringBuilder.append(", mIsNotifyPayment=");
    localStringBuilder.append(this.mIsNotifyPayment);
    localStringBuilder.append(", mNotifyPaymentText='");
    localStringBuilder.append(this.mNotifyPaymentText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExpiredNotifyPaymentText='");
    localStringBuilder.append(this.mExpiredNotifyPaymentText);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconConfig
 * JD-Core Version:    0.7.0.1
 */