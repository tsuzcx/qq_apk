package com.tencent.mobileqq.transfile.impl;

import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

public class ScribblePicDownloadProcessorImpl
  implements IScribblePicDownloadProcessor
{
  public BaseTransProcessor createProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    return new ScribblePicDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
  }
  
  public Class<?> getProcessorClazz()
  {
    return ScribblePicDownloadProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.impl.ScribblePicDownloadProcessorImpl
 * JD-Core Version:    0.7.0.1
 */