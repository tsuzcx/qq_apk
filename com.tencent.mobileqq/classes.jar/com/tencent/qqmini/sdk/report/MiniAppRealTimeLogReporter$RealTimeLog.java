package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.ArrayList;
import org.json.JSONArray;

public class MiniAppRealTimeLogReporter$RealTimeLog
{
  public int curLogContentSize;
  public JSONArray filterMsg;
  public ArrayList<RealTimeLogItem> logitems = new ArrayList();
  public int page;
  
  public MiniAppRealTimeLogReporter$RealTimeLog(int paramInt)
  {
    this.page = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter.RealTimeLog
 * JD-Core Version:    0.7.0.1
 */