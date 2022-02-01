package com.tencent.mobileqq.config.business;

import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

class QIMFilterConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMFilterConfigProcessor$1(QIMFilterConfigProcessor paramQIMFilterConfigProcessor) {}
  
  public void a(String paramString)
  {
    VideoFilterTools.a(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMFilterConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */