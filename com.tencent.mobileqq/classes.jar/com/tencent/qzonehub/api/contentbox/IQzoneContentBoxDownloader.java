package com.tencent.qzonehub.api.contentbox;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneContentBoxDownloader
  extends QRouteApi
{
  public static final String PROTOCAL_QZONE_CONTENT_BOX = "qzonecontentboxdownloader";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.IQzoneContentBoxDownloader
 * JD-Core Version:    0.7.0.1
 */