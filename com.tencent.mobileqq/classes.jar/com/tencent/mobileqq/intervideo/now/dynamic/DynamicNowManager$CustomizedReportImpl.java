package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;

class DynamicNowManager$CustomizedReportImpl
  extends CustomizedReport
{
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    NowDataReporter localNowDataReporter = PluginManagerInterfaceImpl.a().a();
    if (localNowDataReporter != null) {
      localNowDataReporter.a(paramBundle);
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.CustomizedReportImpl
 * JD-Core Version:    0.7.0.1
 */