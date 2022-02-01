package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class QZoneHelperImpl
  implements IQZoneHelper
{
  public void preloadHippy()
  {
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).preDownload();
  }
  
  public void startQCircleHippyActivity(Context paramContext, Intent paramIntent)
  {
    QPublicFragmentActivity.start(paramContext, paramIntent, QCircleHippyFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneHelperImpl
 * JD-Core Version:    0.7.0.1
 */