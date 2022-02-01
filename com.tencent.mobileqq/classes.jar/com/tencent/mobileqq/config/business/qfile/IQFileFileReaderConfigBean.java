package com.tencent.mobileqq.config.business.qfile;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFileFileReaderConfigBean
  extends QRouteApi
{
  public abstract boolean getIsShowReaderBar();
  
  public abstract void setIsShowReaderBar(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean
 * JD-Core Version:    0.7.0.1
 */