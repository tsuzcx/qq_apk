package com.tencent.mobileqq.qqlive.api.impl.anchor;

import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.qphone.base.util.QLog;

class QQLiveModuleAnchorImpl$1
  implements ExitRoomCallback
{
  QQLiveModuleAnchorImpl$1(QQLiveModuleAnchorImpl paramQQLiveModuleAnchorImpl) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveSDK_anchor", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl.1
 * JD-Core Version:    0.7.0.1
 */