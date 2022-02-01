package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GDTReportPlugin
  extends WebViewPlugin
{
  static final int BEFORE_LOADING = 0;
  static final int BEFORE_LOAD_CLICK_CGI = 0;
  static final int FINISH_LOAD_CLICK_CGI = 2;
  public static final String GDT_CLICK_CGI_HOST = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com";
  static final int LOADING = 1;
  static final int LOADING_CLICK_CGI = 1;
  static final int LOAD_FAIL = 3;
  static final int LOAD_SUCCESS = 2;
  public static final String PLUGIN_NAMESPACE = "gdtReportPlugin";
  static final int REPORT_FINISH = 4;
  private Map<Integer, String> feedDataCookie;
  private int loadClickCgiState;
  private long loadFinishTime;
  private long loadStartTime;
  private int state = 0;
  
  public GDTReportPlugin()
  {
    this.mPluginNameSpace = "gdtReportPlugin";
  }
  
  private long getLoadTime()
  {
    return SystemClock.elapsedRealtime() - this.loadStartTime;
  }
  
  private long getStayTime()
  {
    return SystemClock.elapsedRealtime() - this.loadFinishTime;
  }
  
  public static boolean isClickCgiUrlForTool(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getHost();
        String[] arrayOfString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private void reportCgi302Fail(int paramInt, Map<String, Object> paramMap)
  {
    Log.i("gdtReportPlugin", "173\t" + getLoadTime());
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; paramInt = 0)
    {
      RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 1, getLoadTime(), paramInt);
      return;
    }
  }
  
  private void reportCgi302Success()
  {
    Log.i("gdtReportPlugin", "172\t" + getLoadTime());
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 0, getLoadTime(), 0L);
  }
  
  private void reportLoadFailTime(int paramInt, Map<String, Object> paramMap)
  {
    this.loadFinishTime = SystemClock.elapsedRealtime();
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (int i = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; i = 0)
    {
      RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, paramInt, getLoadTime(), i);
      Log.i("gdtReportPlugin", paramInt + 120 + "\t" + getLoadTime());
      return;
    }
  }
  
  private void reportLoadSuccessTime()
  {
    this.loadFinishTime = SystemClock.elapsedRealtime();
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, 0, getLoadTime(), 0L);
    Log.i("gdtReportPlugin", "120\t" + getLoadTime());
  }
  
  private void reportStayTime()
  {
    Log.i("gdtReportPlugin", "129\t" + getLoadTime());
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2005, 0, getStayTime(), 0L);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (this.mRuntime.a().getIntent().getBooleanExtra("needGdtLandingPageReport", false)) {
      switch (this.state)
      {
      default: 
        if (this.loadClickCgiState == 1)
        {
          if ((paramLong != 8589934593L) || (this.state != 1) || (isClickCgiUrlForTool(paramString))) {
            break label402;
          }
          reportCgi302Success();
          this.loadClickCgiState = 2;
        }
        break;
      }
    }
    for (;;)
    {
      paramString = new QZoneClickReport.ReportInfo();
      paramString.actionType = String.valueOf(478);
      if (paramLong == 8589934599L)
      {
        paramString.subactionType = String.valueOf(2);
        QZoneClickReport.report(this.mRuntime.a().getAccount(), paramString, true);
      }
      return false;
      if (paramLong != 8589934593L) {
        break;
      }
      if ((isClickCgiUrlForTool(paramString)) && (this.loadClickCgiState == 0)) {
        this.loadClickCgiState = 1;
      }
      List localList = (List)this.mRuntime.a().getIntent().getSerializableExtra("FeedDataCookie");
      if ((localList != null) && (localList.size() == 1)) {
        this.feedDataCookie = ((Map)localList.get(0));
      }
      this.loadStartTime = SystemClock.elapsedRealtime();
      this.state = 1;
      break;
      if (paramLong == 8589934594L)
      {
        this.state = 2;
        reportLoadSuccessTime();
        break;
      }
      if (paramLong == 8589934595L)
      {
        this.state = 3;
        reportLoadFailTime(1, paramMap);
        break;
      }
      if (paramLong == 8589934601L)
      {
        this.state = 4;
        reportLoadFailTime(94, paramMap);
        reportStayTime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      reportLoadFailTime(95, paramMap);
      reportStayTime();
      break;
      if (paramLong != 8589934597L) {
        break;
      }
      reportStayTime();
      this.state = 4;
      break;
      if (paramLong == 8589934593L)
      {
        this.state = 4;
        reportStayTime();
        this.loadStartTime = SystemClock.elapsedRealtime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      reportStayTime();
      break;
      label402:
      if ((isClickCgiUrlForTool(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
      {
        this.loadClickCgiState = 2;
        reportCgi302Fail(1, paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.GDTReportPlugin
 * JD-Core Version:    0.7.0.1
 */