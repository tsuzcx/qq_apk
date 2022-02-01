package com.tencent.rmonitor.base.config.impl;

import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public abstract interface IConfigParser
{
  public abstract boolean a(JSONObject paramJSONObject, @NotNull RMonitorConfig paramRMonitorConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.IConfigParser
 * JD-Core Version:    0.7.0.1
 */