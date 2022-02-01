package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISmallEmoticonInfoService
  extends QRouteApi
{
  public abstract ISmallEmoticonInfo createSmallEmoticonInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService
 * JD-Core Version:    0.7.0.1
 */