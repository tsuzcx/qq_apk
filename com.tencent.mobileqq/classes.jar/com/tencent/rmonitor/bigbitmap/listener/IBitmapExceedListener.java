package com.tencent.rmonitor.bigbitmap.listener;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.bigbitmap.datainfo.ExceedBitmapInfo;
import java.util.List;

public abstract interface IBitmapExceedListener
  extends IBaseListener
{
  public abstract void a(List<ExceedBitmapInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.listener.IBitmapExceedListener
 * JD-Core Version:    0.7.0.1
 */