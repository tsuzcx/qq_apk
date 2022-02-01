package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.statistics.ReportController;

public class SearchReportUtil
{
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    ReportController.b(null, "dc00898", "", "", "0X800BA49", "0X800BA49", paramInt1, 0, String.valueOf(paramInt2), "", paramString1, paramString2);
  }
  
  public static void a(ISearchResultPositionModel paramISearchResultPositionModel)
  {
    a(paramISearchResultPositionModel.ah, paramISearchResultPositionModel.z(), paramISearchResultPositionModel.g(), String.valueOf(paramISearchResultPositionModel.d()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchReportUtil
 * JD-Core Version:    0.7.0.1
 */