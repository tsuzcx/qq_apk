package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.page.PageUtils;

class FinalDataUtils
{
  static void appendPageInfo(@NonNull FinalData paramFinalData, @NonNull PathData paramPathData)
  {
    paramFinalData.put("cur_pg", PageUtils.getPageInfo(paramPathData.getPage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.FinalDataUtils
 * JD-Core Version:    0.7.0.1
 */