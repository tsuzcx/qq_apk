package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class QCircleRFWApiImpl
  implements IQCircleRFWApi
{
  private static final String TAG = "QCircleConfigApiImpl";
  private static RFWMultiDownloadHelper sMultiDownloadHelper = new RFWMultiDownloadHelper();
  
  static
  {
    sMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png", QCircleDownloadConfig.a()));
    sMultiDownloadHelper.start();
  }
  
  public void checkExceptionWhetherCauseByQCircle(String paramString)
  {
    QLog.e("QCircleConfigApiImpl", 1, "checkExceptionWhetherCauseByQCircle");
    ASDynamicEngine.c(paramString);
  }
  
  public String getDefaultSavePath(String paramString)
  {
    return RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).getDefaultSavePath(paramString);
  }
  
  public Typeface getTypeface(Context paramContext, String paramString)
  {
    return RFWTypefaceUtil.a(paramContext, paramString);
  }
  
  public String getUniKeyFromUrl(String paramString)
  {
    return QCircleFeedPicLoader.getUniKeyFromUrl(paramString);
  }
  
  public void setNumberTypeface(TextView paramTextView, boolean paramBoolean)
  {
    RFWTypefaceUtil.a(paramTextView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleRFWApiImpl
 * JD-Core Version:    0.7.0.1
 */