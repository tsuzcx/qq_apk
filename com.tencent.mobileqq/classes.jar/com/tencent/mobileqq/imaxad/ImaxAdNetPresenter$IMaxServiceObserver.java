package com.tencent.mobileqq.imaxad;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.c2s.imax.IMaxService.RspBody;

public class ImaxAdNetPresenter$IMaxServiceObserver
  extends ProtoUtils.AppProtocolObserver
{
  int a = 0;
  
  public ImaxAdNetPresenter$IMaxServiceObserver(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new IMaxService.RspBody();
    if (QLog.isColorLevel()) {
      QLog.i("ImaxAdNetPresenter", 2, "errorCode == " + paramInt);
    }
    if (paramInt == 0) {}
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImaxAdNetPresenter", 2, "ignore ad report success");
        }
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.has()) && (paramBundle.int32_ret.get() == 0) && (this.a == 3)) {
          Toast.makeText(BaseApplication.getContext(), "操作成功", 0).show();
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ImaxAdNetPresenter", 2, "ignore ad report fail");
      }
    } while (this.a != 3);
    Toast.makeText(BaseApplication.getContext(), "操作失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdNetPresenter.IMaxServiceObserver
 * JD-Core Version:    0.7.0.1
 */