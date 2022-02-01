package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
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
  private Map<String, MiniAppExposureManager.BaseExposureReport> duplicateItemMap = new HashMap();
  private List<MiniAppExposureManager.BaseExposureReport> reportItemList = new ArrayList();
  private List<MiniAppExposureManager.BaseExposureReport> searchItemList = new ArrayList();
  
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
  
  public void addSearchItemAndCheckReport(MiniAppExposureManager.BaseExposureReport paramBaseExposureReport)
  {
    this.searchItemList.add(paramBaseExposureReport);
    if (searchReportCheck()) {
      submitSearchReportData();
    }
  }
  
  public void clear()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
  }
  
  public void clearSearchItemData()
  {
    this.searchItemList.clear();
  }
  
  public Map<String, MiniAppExposureManager.BaseExposureReport> getDuplicateItemMap()
  {
    return this.duplicateItemMap;
  }
  
  public List<MiniAppExposureManager.BaseExposureReport> getReportItemList()
  {
    return this.reportItemList;
  }
  
  public List<MiniAppExposureManager.BaseExposureReport> getSearchItemList()
  {
    return this.searchItemList;
  }
  
  public void onDestroy()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
    QLog.d("MiniAppExposureManager", 2, "onDestroy");
  }
  
  public void putReportDataToMap(String paramString, MiniAppExposureManager.BaseExposureReport paramBaseExposureReport)
  {
    if (this.duplicateItemMap.get(paramString) == null) {
      this.duplicateItemMap.put(paramString, paramBaseExposureReport);
    }
  }
  
  public boolean searchReportCheck()
  {
    return this.searchItemList.size() >= 20;
  }
  
  public void submitSearchReportData()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(getSearchItemList());
    MiniProgramLpReportDC04239.exposureReport(localArrayList);
    clearSearchItemData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager
 * JD-Core Version:    0.7.0.1
 */