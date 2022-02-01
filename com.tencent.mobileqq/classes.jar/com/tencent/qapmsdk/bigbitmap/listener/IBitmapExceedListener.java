package com.tencent.qapmsdk.bigbitmap.listener;

import android.support.annotation.Nullable;
import com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.qapmsdk.common.reporter.IPluginReport;
import java.util.List;

public abstract interface IBitmapExceedListener
{
  public abstract void onBitmapExceed(List<ExceedBitmapInfo> paramList);
  
  public abstract void setReporter(@Nullable IPluginReport paramIPluginReport);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.listener.IBitmapExceedListener
 * JD-Core Version:    0.7.0.1
 */