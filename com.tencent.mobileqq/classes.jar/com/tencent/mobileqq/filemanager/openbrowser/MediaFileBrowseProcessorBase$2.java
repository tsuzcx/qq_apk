package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadListener;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;
import com.tencent.qphone.base.util.QLog;

class MediaFileBrowseProcessorBase$2
  implements IFileVideoDownloadListener
{
  MediaFileBrowseProcessorBase$2(MediaFileBrowseProcessorBase paramMediaFileBrowseProcessorBase, BaseVideoBiz paramBaseVideoBiz, long paramLong, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.d.d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadProgressUpdate: callback = null , ctxId[");
      localStringBuilder.append(this.a.a());
      localStringBuilder.append("] ");
      QLog.i("MediaFileBrowseProcessorBase", 2, localStringBuilder.toString());
      return;
    }
    paramInt1 = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    this.d.d.a(this.b, this.c, 269484035, paramInt1, paramLong2, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.d.d == null)
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadProgressUpdate: error, id[");
      paramString.append(this.b);
      paramString.append("] ");
      QLog.i("MediaFileBrowseProcessorBase", 2, paramString.toString());
      return;
    }
    this.d.d.a(this.b, this.c, 269484034, 2, paramString, false);
  }
  
  public void a(String paramString)
  {
    if (this.d.d == null)
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadFinish callback = null , id[");
      paramString.append(this.b);
      paramString.append("] ");
      QLog.i("MediaFileBrowseProcessorBaseXOXO", 2, paramString.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----------> notify download finish:");
    localStringBuilder.append(this.b);
    QLog.i("MediaFileBrowseProcessorBase", 1, localStringBuilder.toString());
    this.d.d.a(this.b, this.c, 269484034, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase.2
 * JD-Core Version:    0.7.0.1
 */