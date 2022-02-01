package com.tencent.mobileqq.transfile.impl;

import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

public class ScribblePicUploadProcessorImpl
  implements IScribblePicUploadProcessor
{
  public BaseTransProcessor createProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    return new ScribblePicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
  }
  
  public Class<?> getProcessorClazz()
  {
    return ScribblePicUploadProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.impl.ScribblePicUploadProcessorImpl
 * JD-Core Version:    0.7.0.1
 */