package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
  private int loadClickCgiState = 0;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
    return false;
  }
  
  private void reportCgi302Fail(int paramInt, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("173\t");
    localStringBuilder.append(getLoadTime());
    Log.i("gdtReportPlugin", localStringBuilder.toString());
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {
      paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());
    } else {
      paramInt = 0;
    }
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 1, getLoadTime(), paramInt);
  }
  
  private void reportCgi302Success()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("172\t");
    localStringBuilder.append(getLoadTime());
    Log.i("gdtReportPlugin", localStringBuilder.toString());
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 0, getLoadTime(), 0L);
  }
  
  private void reportLoadFailTime(int paramInt, Map<String, Object> paramMap)
  {
    this.loadFinishTime = SystemClock.elapsedRealtime();
    int i;
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {
      i = Math.abs(((Integer)paramMap.get("errorCode")).intValue());
    } else {
      i = 0;
    }
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, paramInt, getLoadTime(), i);
    paramMap = new StringBuilder();
    paramMap.append(paramInt + 120);
    paramMap.append("\t");
    paramMap.append(getLoadTime());
    Log.i("gdtReportPlugin", paramMap.toString());
  }
  
  private void reportLoadSuccessTime()
  {
    this.loadFinishTime = SystemClock.elapsedRealtime();
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, 0, getLoadTime(), 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("120\t");
    localStringBuilder.append(getLoadTime());
    Log.i("gdtReportPlugin", localStringBuilder.toString());
  }
  
  private void reportStayTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("129\t");
    localStringBuilder.append(getLoadTime());
    Log.i("gdtReportPlugin", localStringBuilder.toString());
    RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2005, 0, getStayTime(), 0L);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    if ("gdtReportPlugin".equals(paramString)) {
      return 2L;
    }
    return super.getWebViewEventByNameSpace(paramString);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (this.mRuntime.a().getIntent().getBooleanExtra("needGdtLandingPageReport", false))
    {
      int i = this.state;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              if (paramLong == 8589934593L)
              {
                this.state = 4;
                reportStayTime();
                this.loadStartTime = SystemClock.elapsedRealtime();
              }
              else if (paramLong == 8589934597L)
              {
                this.state = 4;
                reportStayTime();
              }
            }
          }
          else if (paramLong == 8589934597L)
          {
            reportStayTime();
            this.state = 4;
          }
        }
        else if (paramLong == 8589934594L)
        {
          this.state = 2;
          reportLoadSuccessTime();
        }
        else if (paramLong == 8589934595L)
        {
          this.state = 3;
          reportLoadFailTime(1, paramMap);
        }
        else if (paramLong == 8589934601L)
        {
          this.state = 4;
          reportLoadFailTime(94, paramMap);
          reportStayTime();
        }
        else if (paramLong == 8589934597L)
        {
          this.state = 4;
          reportLoadFailTime(95, paramMap);
          reportStayTime();
        }
      }
      else if (paramLong == 8589934593L)
      {
        if ((isClickCgiUrlForTool(paramString)) && (this.loadClickCgiState == 0)) {
          this.loadClickCgiState = 1;
        }
        List localList = (List)this.mRuntime.a().getIntent().getSerializableExtra("FeedDataCookie");
        if ((localList != null) && (localList.size() == 1)) {
          this.feedDataCookie = ((Map)localList.get(0));
        }
        this.loadStartTime = SystemClock.elapsedRealtime();
        this.state = 1;
      }
      if (this.loadClickCgiState == 1) {
        if ((paramLong == 8589934593L) && (this.state == 1) && (!isClickCgiUrlForTool(paramString)))
        {
          reportCgi302Success();
          this.loadClickCgiState = 2;
        }
        else if ((isClickCgiUrlForTool(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
        {
          this.loadClickCgiState = 2;
          reportCgi302Fail(1, paramMap);
        }
      }
      paramString = new QZoneClickReport.ReportInfo();
      paramString.actionType = String.valueOf(478);
      if (paramLong == 8589934599L)
      {
        paramString.subactionType = String.valueOf(2);
        QZoneClickReport.report(this.mRuntime.a().getAccount(), paramString, true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.GDTReportPlugin
 * JD-Core Version:    0.7.0.1
 */