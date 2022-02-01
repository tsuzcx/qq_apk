package com.tencent.mobileqq.richmedia.capture.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class FilterProviderView$FilterBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
    {
      CaptureVideoFilterManager.a().b();
      FilterProviderView.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "FilterProviderView FilterBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FilterProviderView.FilterBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */