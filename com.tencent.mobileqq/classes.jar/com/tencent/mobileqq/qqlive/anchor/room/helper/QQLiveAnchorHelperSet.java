package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorHelperSet
{
  private boolean a = false;
  
  private void a(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, QQLiveAnchorDataSet paramQQLiveAnchorDataSet, IQQLiveAnchorRoomSet paramIQQLiveAnchorRoomSet)
  {
    try
    {
      paramQQLiveAnchorRoomInfo.roomAttr = new QQLiveAnchorDataRoomAttr(paramQQLiveAnchorDataRoomAttr);
      QQLiveAnchorSSOHelper.a(paramQQLiveAnchorDataRoomAttr, paramQQLiveAnchorRoomInfo);
      paramIQQLiveAnchorRoomSet.a(paramQQLiveAnchorDataSet);
      if (!paramQQLiveAnchorDataSet.isSuccess)
      {
        paramIQQLiveAnchorRoomSet.a(new QQLiveErrorMsg(paramQQLiveAnchorDataSet.errorMsg));
        return;
      }
    }
    catch (Throwable paramQQLiveAnchorRoomInfo)
    {
      QLog.e("QQLiveAnchor_Set", 1, paramQQLiveAnchorRoomInfo, new Object[0]);
    }
  }
  
  public void a(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, IQQLiveAnchorRoomSet paramIQQLiveAnchorRoomSet)
  {
    if (this.a)
    {
      QLog.e("QQLiveAnchor_Set", 1, "setting, ignore");
      return;
    }
    this.a = true;
    try
    {
      paramIQQLiveAnchorRoomSet.c();
      QQLiveAnchorSSO.a(paramIQQLiveSDK, QQLiveAnchorSSOHelper.a(paramQQLiveAnchorRoomInfo, paramQQLiveAnchorDataRoomAttr), new QQLiveAnchorHelperSet.1(this, paramQQLiveAnchorRoomInfo, paramQQLiveAnchorDataRoomAttr, paramIQQLiveAnchorRoomSet));
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveAnchor_Set", 1, paramIQQLiveSDK, new Object[0]);
      this.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperSet
 * JD-Core Version:    0.7.0.1
 */