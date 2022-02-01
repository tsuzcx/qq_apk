package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.DeviceMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/IDeviceInfoListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onBeforeReport", "", "meta", "Lcom/tencent/rmonitor/base/meta/DeviceMeta;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IDeviceInfoListener
  extends IBaseListener
{
  public abstract void onBeforeReport(@Nullable DeviceMeta paramDeviceMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IDeviceInfoListener
 * JD-Core Version:    0.7.0.1
 */