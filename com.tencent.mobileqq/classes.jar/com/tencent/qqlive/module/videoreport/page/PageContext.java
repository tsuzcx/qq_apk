package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.data.DataEntity;

class PageContext
{
  final int pageStep;
  final DataEntity refPageData;
  
  PageContext(int paramInt, DataEntity paramDataEntity)
  {
    this.pageStep = paramInt;
    this.refPageData = paramDataEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageContext
 * JD-Core Version:    0.7.0.1
 */