package com.tencent.rmonitor.base.reporter.uvreport;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UVEventReport
  extends Handler
{
  public static List a = new ArrayList();
  
  public UVEventReport(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void b()
  {
    int i;
    do
    {
      try
      {
        Object localObject1 = new JSONArray();
        i = 0;
        Object localObject2 = a.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((JSONArray)localObject1).put(((Iterator)localObject2).next());
          i = 1;
          continue;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("event", "uv_event");
          ((JSONObject)localObject2).put("process_name", AppInfo.a(BaseInfo.app));
          ((JSONObject)localObject2).put("opened_plugs", localObject1);
          ((JSONObject)localObject2).put("plugin", 1000);
          localObject1 = new ReportData(0, "UV_EVENT", true, 1L, 1L, (JSONObject)localObject2, true, false, BaseInfo.userMeta.uin);
          ReporterMachine.a.a((ReportData)localObject1, new UVEventReport.1(this));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Logger.b.a("UVEventReport", localJSONException);
        return;
      }
    } while (i != 0);
  }
  
  private void c()
  {
    b();
    sendEmptyMessageDelayed(1, 3600000L);
  }
  
  public void a()
  {
    sendEmptyMessageDelayed(1, 30000L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.uvreport.UVEventReport
 * JD-Core Version:    0.7.0.1
 */