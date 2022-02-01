package com.tencent.mobileqq.qcircle.api.impl;

import android.os.Bundle;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.beans.QCircleSchemeBean;

public class QCircleNativeFrameApiImpl
  implements IQCircleNativeFrameApi
{
  public void enterNativePage(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = (ASEnterBean)paramBundle.getSerializable("data");
      if (paramBundle == null) {
        return;
      }
      paramBundle = new QCircleSchemeBean().setSchemeAction(paramBundle.getSchemeAction()).setAttrs(paramBundle.getAttrs()).setByteAttrs(paramBundle.getByteAttrs());
      QCircleSchemeLauncher.a(RFApplication.getApplication(), paramBundle);
    }
  }
  
  public boolean isNewLayerMode()
  {
    return QCircleConfigHelper.bg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleNativeFrameApiImpl
 * JD-Core Version:    0.7.0.1
 */