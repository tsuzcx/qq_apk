package com.tencent.tkd.comment.publisher.qq.bridge;

import android.os.Bundle;
import android.text.Editable;
import org.json.JSONObject;

public abstract interface QQReportBridge
{
  public static final QQReportBridge EMPTY = new QQReportBridge.1();
  
  public abstract void asyncReport(Bundle paramBundle);
  
  public abstract void fillR5OnDeliver(JSONObject paramJSONObject, Editable paramEditable);
  
  public abstract int getCommentLevel();
  
  public abstract long getConsumeTime();
  
  public abstract int getEntry();
  
  public abstract int getFolderStatus();
  
  public abstract String getReportVersion();
  
  public abstract int getScene();
  
  public abstract void report(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge
 * JD-Core Version:    0.7.0.1
 */