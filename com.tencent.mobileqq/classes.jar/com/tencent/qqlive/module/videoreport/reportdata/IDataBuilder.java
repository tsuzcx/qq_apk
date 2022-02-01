package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.Nullable;

public abstract interface IDataBuilder
{
  @Nullable
  public abstract FinalData build(PathData paramPathData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder
 * JD-Core Version:    0.7.0.1
 */