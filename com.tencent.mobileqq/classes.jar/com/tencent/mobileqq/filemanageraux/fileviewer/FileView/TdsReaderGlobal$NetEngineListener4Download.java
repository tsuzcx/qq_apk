package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class TdsReaderGlobal$NetEngineListener4Download
  implements INetEngineListener
{
  private final IHostInterface.IDownloadListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private TdsReaderGlobal$NetEngineListener4Download(String paramString, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener = paramIDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    if (paramNetResp.mResult == 3) {}
    label74:
    label80:
    for (;;)
    {
      return;
      boolean bool;
      if (paramNetResp.mResult == 0)
      {
        bool = true;
        if (!bool) {
          break label74;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener == null) {
          break label80;
        }
        if (bool) {
          this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, paramNetResp.mTotalFileLen, 1.0F);
        }
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadFinished(this.jdField_a_of_type_JavaLangString, bool, i);
        return;
        bool = false;
        break;
        i = paramNetResp.mErrCode;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L)
    {
      float f = (float)paramLong1 / (float)paramLong2;
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, paramLong2, f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.NetEngineListener4Download
 * JD-Core Version:    0.7.0.1
 */