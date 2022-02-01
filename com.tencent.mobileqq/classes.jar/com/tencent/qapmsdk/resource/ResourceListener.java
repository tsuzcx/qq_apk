package com.tencent.qapmsdk.resource;

import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.SceneMeta;

public abstract interface ResourceListener
  extends IBaseListener
{
  public abstract void onMetaGet(SceneMeta paramSceneMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceListener
 * JD-Core Version:    0.7.0.1
 */