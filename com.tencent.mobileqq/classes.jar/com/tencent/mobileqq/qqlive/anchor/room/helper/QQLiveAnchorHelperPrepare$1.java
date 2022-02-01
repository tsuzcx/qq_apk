package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.Callback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;

class QQLiveAnchorHelperPrepare$1
  implements QQLiveAnchorSSO.Callback<QQLiveAnchorDataPrepare>
{
  QQLiveAnchorHelperPrepare$1(QQLiveAnchorHelperPrepare paramQQLiveAnchorHelperPrepare, Activity paramActivity, IQQLiveSDK paramIQQLiveSDK, IQQLiveAnchorRoomPrepare paramIQQLiveAnchorRoomPrepare) {}
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    QQLiveAnchorHelperPrepare.a(this.d, this.a, this.b, this.c, paramQQLiveAnchorDataPrepare);
    QQLiveAnchorHelperPrepare.a(this.d, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperPrepare.1
 * JD-Core Version:    0.7.0.1
 */