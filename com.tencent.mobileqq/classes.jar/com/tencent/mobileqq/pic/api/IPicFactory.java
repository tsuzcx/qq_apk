package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;

@QAPI(process={"all"})
public abstract interface IPicFactory
  extends QRouteApi
{
  public abstract BaseCache getCache(AppInterface paramAppInterface, DBDelayManager paramDBDelayManager);
  
  public abstract ProtocolDownloader getChatImageDownloader(BaseApplication paramBaseApplication, String paramString);
  
  public abstract BaseTransProcessor getProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicFactory
 * JD-Core Version:    0.7.0.1
 */