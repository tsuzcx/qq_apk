package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneApiProxy;

class SimpleDebugFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  SimpleDebugFragment$3(SimpleDebugFragment paramSimpleDebugFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).setShowQzoneInSimpleUI(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment.3
 * JD-Core Version:    0.7.0.1
 */