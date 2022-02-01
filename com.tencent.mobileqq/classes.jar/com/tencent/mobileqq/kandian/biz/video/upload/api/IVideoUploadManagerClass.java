package com.tencent.mobileqq.kandian.biz.video.upload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVideoUploadManagerClass
  extends QRouteApi
{
  public abstract Class getManagerClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.upload.api.IVideoUploadManagerClass
 * JD-Core Version:    0.7.0.1
 */