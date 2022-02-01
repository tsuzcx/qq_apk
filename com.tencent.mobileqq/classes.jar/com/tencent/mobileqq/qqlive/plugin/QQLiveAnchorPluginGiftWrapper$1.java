package com.tencent.mobileqq.qqlive.plugin;

import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorPluginGiftWrapper$1
  implements IQQGiftEngineAnimationListener
{
  QQLiveAnchorPluginGiftWrapper$1(QQLiveAnchorPluginGiftWrapper paramQQLiveAnchorPluginGiftWrapper) {}
  
  public void onAnimationEnd(GiftAnimData paramGiftAnimData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationEnd, data: ");
      localStringBuilder.append(paramGiftAnimData.toString());
      QLog.d("QQLiveAnchor_GiftWrapper", 1, localStringBuilder.toString());
    }
  }
  
  public void onAnimationStart(GiftAnimData paramGiftAnimData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationStart, data: ");
      localStringBuilder.append(paramGiftAnimData.toString());
      QLog.d("QQLiveAnchor_GiftWrapper", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.QQLiveAnchorPluginGiftWrapper.1
 * JD-Core Version:    0.7.0.1
 */