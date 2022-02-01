package com.tencent.mobileqq.flashshow.widgets.fault;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;

class FSFaultHintView$1
  implements RFWDownloader.RFWDownloadListener
{
  FSFaultHintView$1(FSFaultHintView paramFSFaultHintView, ImageView paramImageView) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath =");
      localStringBuilder.append(paramString);
      QLog.d("FSFaultHintView", 1, localStringBuilder.toString());
      this.b.getMainHandler().post(new FSFaultHintView.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSFaultHintView.1
 * JD-Core Version:    0.7.0.1
 */