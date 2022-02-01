package com.tencent.qzonehub.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.IQzoneGiftFullScreenViewController;

@QAPI(process={"all"})
public abstract interface IQzoneGiftFullScreenViewControllerProxy
  extends QRouteApi
{
  public abstract IQzoneGiftFullScreenViewController getQzoneGiftFullScreenViewController(Activity paramActivity);
  
  public abstract boolean isSupportMagicface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy
 * JD-Core Version:    0.7.0.1
 */