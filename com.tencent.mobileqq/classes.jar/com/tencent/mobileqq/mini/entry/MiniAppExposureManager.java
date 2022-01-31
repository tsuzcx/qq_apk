package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class MiniAppExposureManager
  implements Manager
{
  public static final String TAG = "MiniAppExposureManager";
  private int desktopPullDownState = 1;
  private Map<String, MiniAppExposureManager.BaseExposureReport> duplicateItemMap = new HashMap();
  private List<MiniAppExposureManager.BaseExposureReport> reportItemList = new ArrayList();
  
  public MiniAppExposureManager(QQAppInterface paramQQAppInterface) {}
  
  public static String getAppType(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
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
    QLog.d("MiniAppExposureManager", 2, "onDestroy");
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
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager
 * JD-Core Version:    0.7.0.1
 */