package com.tencent.mobileqq.vashealth.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={"all"})
public abstract interface IPathTraceManager
  extends IRuntimeService
{
  public abstract int getEngineWorkingMode();
  
  public abstract Entity getLastUnCompletedTrace();
  
  public abstract Entity getPathTrace();
  
  public abstract int getRunningStatus();
  
  public abstract boolean isRunning();
  
  public abstract boolean pathTraceDelete(Long paramLong);
  
  public abstract boolean pathTraceEnd(long paramLong);
  
  public abstract void pathTracePause();
  
  public abstract JSONObject pathTraceQuery();
  
  public abstract void pathTraceResume();
  
  public abstract void pathTraceUpload(long paramLong, String paramString);
  
  public abstract JSONObject queryPathData(String paramString);
  
  public abstract void registerWebViewPlug(WebViewPlugin paramWebViewPlugin);
  
  public abstract void setIgnoreSpeed(boolean paramBoolean);
  
  public abstract void setIsMute(boolean paramBoolean);
  
  public abstract void startLocation(int paramInt);
  
  public abstract void startPathTrace(JSONObject paramJSONObject);
  
  public abstract void stopLocation(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.IPathTraceManager
 * JD-Core Version:    0.7.0.1
 */