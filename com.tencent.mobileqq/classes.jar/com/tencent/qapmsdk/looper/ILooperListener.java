package com.tencent.qapmsdk.looper;

import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.LooperMeta;

public abstract interface ILooperListener
  extends IBaseListener
{
  public abstract void onMetaGet(LooperMeta paramLooperMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.ILooperListener
 * JD-Core Version:    0.7.0.1
 */