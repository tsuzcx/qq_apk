package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class PlayOperationViewModelImpl$33
  extends ProtoUtils.TroopProtocolObserver
{
  PlayOperationViewModelImpl$33(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bundle = [");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      QQToast.a(this.a.mBinding.getContext(), 1, HardCodeUtil.a(2131707384), 1).a();
      return;
    }
    paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ret_code: ");
    paramArrayOfByte.append(paramBundle.ret_code.get());
    paramArrayOfByte.append(", err_msg: ");
    paramArrayOfByte.append(paramBundle.err_msg.get().toStringUtf8());
    QLog.i("PlayOperationViewModel", 1, paramArrayOfByte.toString());
    paramInt = paramBundle.ret_code.get();
    paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
    if (paramInt != 0)
    {
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        paramBundle = this.a.mBinding.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArrayOfByte);
        QQToast.a(paramBundle, 1, localStringBuilder.toString(), 1).a();
        return;
      }
      QQToast.a(this.a.mBinding.getContext(), 1, HardCodeUtil.a(2131707292), 1).a();
      return;
    }
    paramArrayOfByte = this.a;
    PlayOperationViewModelImpl.access$1700(paramArrayOfByte, PlayOperationViewModelImpl.access$1402(paramArrayOfByte, PlayOperationViewModelImpl.access$1400(paramArrayOfByte) ^ true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.33
 * JD-Core Version:    0.7.0.1
 */