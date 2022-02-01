package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import mqq.app.AppRuntime;

public class PttTransProcessorHelperImpl
  implements IPttTransProcessorHelper
{
  public boolean checkIsJsPttClass(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    return (paramIHttpCommunicatorListener != null) && (((paramIHttpCommunicatorListener instanceof JSPttUploadProcessor)) || ((paramIHttpCommunicatorListener instanceof JSPttDownloadProcessor)));
  }
  
  public BaseTransProcessor createPttTransProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mFileType == 327696) {
      return new PttSliceUploadProcessor(paramBaseTransFileController, paramTransferRequest);
    }
    if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000) && (paramTransferRequest.mUinType != 1026))
    {
      if (paramTransferRequest.mIsUp)
      {
        if (paramTransferRequest.mFileType == 2) {
          return new C2CPttUploadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 32) {
          return new JSPttUploadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
      }
      else
      {
        if (paramTransferRequest.mFileType == 2) {
          return new C2CPttDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 32) {
          return new JSPttDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 33) {
          return new PAAudioPttDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
      }
    }
    else if (paramTransferRequest.mIsUp)
    {
      if (paramTransferRequest.mFileType == 2) {
        return new GroupPttUploadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
    }
    else if (paramTransferRequest.mFileType == 2) {
      return new GroupPttDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
    }
    return null;
  }
  
  public Class getC2CPttDownloadProcessorClass()
  {
    return C2CPttDownloadProcessor.class;
  }
  
  public Class getC2CPttUpProcessorClass()
  {
    return C2CPttUploadProcessor.class;
  }
  
  public Class getGroupPttDownloadProcessorClass()
  {
    return GroupPttDownloadProcessor.class;
  }
  
  public Class getGroupPttUpProcessorClass()
  {
    return GroupPttUploadProcessor.class;
  }
  
  public Class getJSPttDownloadProcessorClass()
  {
    return JSPttDownloadProcessor.class;
  }
  
  public Class getJSPttUpProcessorClass()
  {
    return JSPttUploadProcessor.class;
  }
  
  public Class getPAAudioDownloadProcessorClass()
  {
    return PAAudioPttDownloadProcessor.class;
  }
  
  public String getPAAudioPttPath(AppRuntime paramAppRuntime, String paramString)
  {
    return PAAudioPttDownloadProcessor.getPttPath(paramAppRuntime, paramString);
  }
  
  public Class getSlicePttUpProcessorClass()
  {
    return PttSliceUploadProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.PttTransProcessorHelperImpl
 * JD-Core Version:    0.7.0.1
 */