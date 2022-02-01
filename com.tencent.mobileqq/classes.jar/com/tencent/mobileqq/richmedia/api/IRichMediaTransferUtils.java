package com.tencent.mobileqq.richmedia.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.IRichMediaIpSaver;

@QAPI(process={"all"})
public abstract interface IRichMediaTransferUtils
  extends QRouteApi
{
  public static final boolean NEW_STORE_FLAG = true;
  
  public abstract IRichMediaIpSaver createRichMediaIpSaver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.api.IRichMediaTransferUtils
 * JD-Core Version:    0.7.0.1
 */