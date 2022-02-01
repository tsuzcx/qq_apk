package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.shortvideo.AioShortVideoSendOperator;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

public class ShortVideoFactoryImpl
  implements IShortVideoFactory
{
  public IShortVideoOperator getAioShortVideoSendOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null) {
      return new AioShortVideoSendOperator();
    }
    return new AioShortVideoSendOperator(paramBaseQQAppInterface);
  }
  
  public BaseTransProcessor getC2CProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp) {
      if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 9))
      {
        if (paramTransferRequest.mFileType == 20) {
          return new ShortVideoForwardProcessor(paramBaseTransFileController, paramTransferRequest);
        }
      }
      else {
        return new ShortVideoUploadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
    }
    return null;
  }
  
  public BaseTransProcessor getProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000)) {
      return getC2CProcessor(paramBaseTransFileController, paramTransferRequest);
    }
    return getTroopProcessor(paramBaseTransFileController, paramTransferRequest);
  }
  
  public Class getShortVideoForwardProcessorClass()
  {
    return ShortVideoForwardProcessor.class;
  }
  
  public Class getShortVideoUploadProcessorClass()
  {
    return ShortVideoUploadProcessor.class;
  }
  
  public BaseTransProcessor getTroopProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp) {
      if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 9))
      {
        if (paramTransferRequest.mFileType == 20) {
          return new ShortVideoForwardProcessor(paramBaseTransFileController, paramTransferRequest);
        }
      }
      else {
        return new ShortVideoUploadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.impl.ShortVideoFactoryImpl
 * JD-Core Version:    0.7.0.1
 */