package com.tencent.mobileqq.kandian.biz.ugc.mycolumn;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.mvp.ListModel.LoadDataFromNetworkCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MyColumnModel$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    MyColumnModel.a(this.b, false);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      MyColumnModel.a(this.b, this.a, paramArrayOfByte, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
    }
    this.a.a(false, true, 0, new ArrayList(), null, paramInt, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.mycolumn.MyColumnModel.1
 * JD-Core Version:    0.7.0.1
 */