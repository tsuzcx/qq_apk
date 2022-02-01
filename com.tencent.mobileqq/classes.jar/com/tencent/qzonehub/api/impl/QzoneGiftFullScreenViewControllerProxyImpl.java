package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController;

public class QzoneGiftFullScreenViewControllerProxyImpl
  implements IQzoneGiftFullScreenViewControllerProxy
{
  public IQzoneGiftFullScreenViewController getQzoneGiftFullScreenViewController(Activity paramActivity)
  {
    return new QzoneGiftFullScreenViewController(paramActivity);
  }
  
  public boolean isSupportMagicface()
  {
    return QzoneGiftFullScreenViewController.isSupportMagicface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneGiftFullScreenViewControllerProxyImpl
 * JD-Core Version:    0.7.0.1
 */