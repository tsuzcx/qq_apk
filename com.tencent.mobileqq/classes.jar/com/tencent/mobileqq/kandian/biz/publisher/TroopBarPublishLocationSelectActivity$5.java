package com.tencent.mobileqq.kandian.biz.publisher;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopBarPublishLocationSelectActivity$5
  extends ProtoUtils.AppProtocolObserver
{
  TroopBarPublishLocationSelectActivity$5(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, LocationListCallback paramLocationListCallback, Bundle paramBundle) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.b.a(paramArrayOfByte, this.c);
      return;
    }
    paramArrayOfByte = this.d;
    QQToast.makeText(paramArrayOfByte, 1, paramArrayOfByte.getString(2131894039, new Object[] { Integer.valueOf(paramInt) }), 0).show(this.d.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity.5
 * JD-Core Version:    0.7.0.1
 */