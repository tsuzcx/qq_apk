package com.tencent.mobileqq.config.business.qvip;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.Serializable;

public class QQLevelIconConfig
  implements Serializable
{
  public String mExpiredNotifyPaymentText;
  public boolean mIsEnableGuide = true;
  public boolean mIsNotifyPayment = true;
  public String mNotifyPaymentText;
  
  public QQLevelIconConfig()
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.mNotifyPaymentText = localResources.getString(2131715897);
    this.mExpiredNotifyPaymentText = localResources.getString(2131715896);
  }
  
  public String toString()
  {
    return "QQLevelIconConfig{mIsEnableGuide=" + this.mIsEnableGuide + ", mIsNotifyPayment=" + this.mIsNotifyPayment + ", mNotifyPaymentText='" + this.mNotifyPaymentText + '\'' + ", mExpiredNotifyPaymentText='" + this.mExpiredNotifyPaymentText + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig
 * JD-Core Version:    0.7.0.1
 */