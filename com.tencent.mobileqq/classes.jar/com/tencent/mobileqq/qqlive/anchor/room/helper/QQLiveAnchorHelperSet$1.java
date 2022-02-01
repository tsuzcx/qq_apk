package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.Callback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;

class QQLiveAnchorHelperSet$1
  implements QQLiveAnchorSSO.Callback<QQLiveAnchorDataSet>
{
  QQLiveAnchorHelperSet$1(QQLiveAnchorHelperSet paramQQLiveAnchorHelperSet, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, IQQLiveAnchorRoomSet paramIQQLiveAnchorRoomSet) {}
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    QQLiveAnchorHelperSet.a(this.d, this.a, this.b, paramQQLiveAnchorDataSet, this.c);
    QQLiveAnchorHelperSet.a(this.d, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperSet.1
 * JD-Core Version:    0.7.0.1
 */