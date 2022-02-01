package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public abstract class NowOnliveGallayCallback
  extends ProtoUtils.TroopProtocolObserver
{
  public static final String TAG = "NowOnliveGallayCallback";
  
  public abstract void onGetNowOnliveGallay(int paramInt, List<NowLiveGallary.RspBody.PhotoInfo> paramList);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null)
    {
      onGetNowOnliveGallay(-1, null);
      return;
    }
    try
    {
      paramBundle = new NowLiveGallary.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle.photo_info_list.get();
      onGetNowOnliveGallay(paramBundle.errCode.get(), paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("getNowOnliveGallary exception, e:");
        paramBundle.append(paramArrayOfByte.getStackTrace());
        QLog.d("NowOnliveGallayCallback", 2, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.handler.NowOnliveGallayCallback
 * JD-Core Version:    0.7.0.1
 */