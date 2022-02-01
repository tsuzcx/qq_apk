package com.tencent.qapmsdk.dropframe;

import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;

public abstract interface IDropFrameListener
  extends IBaseListener
{
  public abstract void onMetaGet(DropFrameResultMeta paramDropFrameResultMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.IDropFrameListener
 * JD-Core Version:    0.7.0.1
 */