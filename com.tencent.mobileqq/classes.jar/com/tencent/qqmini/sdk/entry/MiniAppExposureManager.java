package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniAppExposureManager
{
  public static final String TAG = "MiniAppExposureManager";
  private int desktopPullDownState = 1;
  private Map<String, MiniAppExposureManager.BaseExposureReport> duplicateItemMap = new HashMap();
  private List<MiniAppExposureManager.BaseExposureReport> reportItemList = new ArrayList();
  
  public static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    String str2 = "0";
    String str1 = str2;
    if (paramMiniAppInfo != null)
    {
      str1 = str2;
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        str1 = "1";
      }
    }
    return str1;
  }
  
  public void addReportItem(MiniAppExposureManager.BaseExposureReport paramBaseExposureReport)
  {
    this.reportItemList.add(paramBaseExposureReport);
  }
  
  public void clear()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
  }
  
  public int getDesktopPullDownState()
  {
    return this.desktopPullDownState;
  }
  
  public Map<String, MiniAppExposureManager.BaseExposureReport> getDuplicateItemMap()
  {
    return this.duplicateItemMap;
  }
  
  public List<MiniAppExposureManager.BaseExposureReport> getReportItemList()
  {
    return this.reportItemList;
  }
  
  public void onDestroy()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
    QMLog.d("MiniAppExposureManager", "onDestroy");
  }
  
  public void putReportDataToMap(String paramString, MiniAppExposureManager.BaseExposureReport paramBaseExposureReport)
  {
    this.duplicateItemMap.put(paramString, paramBaseExposureReport);
  }
  
  public void setDesktopPullDownState(int paramInt)
  {
    this.desktopPullDownState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager
 * JD-Core Version:    0.7.0.1
 */