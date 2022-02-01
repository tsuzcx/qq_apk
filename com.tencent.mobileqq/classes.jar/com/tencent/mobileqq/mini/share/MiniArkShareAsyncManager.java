package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class MiniArkShareAsyncManager
{
  private static final String TAG = "MiniArkShareAsyncManage [miniappArkShare]";
  
  public static void performChangeArkShareImageUrl(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    MiniAppCmdUtil.getInstance().changeShareImageUrl(paramString, new MiniArkShareAsyncManager.1(paramCmdCallback));
  }
  
  public static void performUploadArkShareImage(String paramString, IMiniCallback paramIMiniCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mLocalPath = paramString;
        localTransferRequest.mCommandId = 62;
        localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
        localTransferRequest.mPeerUin = "0";
        localTransferRequest.mSelfUin = String.valueOf(CommonDataAdapter.a().a());
        localTransferRequest.mFileType = 24;
        localTransferRequest.mRichTag = "miniAppArkShareUploadPicHit";
        paramString = new Bdh_extinfo.CommFileExtReq();
        paramString.uint32_action_type.set(0);
        paramString.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
        localTransferRequest.mExtentionInfo = paramString.toByteArray();
        paramString = new MiniArkShareAsyncTransProcessorHandler(ThreadManagerV2.getFileThreadLooper(), paramIMiniCallback);
        paramString.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        if (((QQAppInterface)localObject).getRuntimeService(ITransFileController.class) != null)
        {
          ((ITransFileController)((QQAppInterface)localObject).getRuntimeService(ITransFileController.class)).addHandle(paramString);
          ((ITransFileController)((QQAppInterface)localObject).getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
        }
      }
    }
    else
    {
      QLog.e("MiniArkShareAsyncManage [miniappArkShare]", 2, "performUploadArkShareImage empty local image path");
      if (paramIMiniCallback != null) {
        try
        {
          paramIMiniCallback.onCallbackResult(false, new Bundle());
          return;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager
 * JD-Core Version:    0.7.0.1
 */