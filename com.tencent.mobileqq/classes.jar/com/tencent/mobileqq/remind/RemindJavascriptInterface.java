package com.tencent.mobileqq.remind;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RemindJavascriptInterface
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  private static String b = "remind";
  protected Activity a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remindSuccess : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = RemindHelper.b(RemindHelper.a(paramString, "isNew"));
    boolean bool2 = RemindHelper.b(RemindHelper.a(paramString, "isInsert"));
    RemindHelper.a(paramString, "title");
    RemindHelper.a(RemindHelper.a(paramString, "startDate")).longValue();
    RemindHelper.a(RemindHelper.a(paramString, "endDate")).longValue();
    if (bool1) {
      paramString = "0";
    } else {
      paramString = "1";
    }
    if (bool2) {
      str = "0";
    } else {
      str = "1";
    }
    if (QLog.isColorLevel())
    {
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createAndAddReport  r2: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" r3: ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    ReportController.b(null, "CliOper", "", "", "Time_reminder", "Updata_clock", 0, 0, str, paramString, "", "");
  }
  
  public void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    long l = RemindHelper.a(RemindHelper.a(paramString, "currentDate")).longValue();
    RemindHelper.a(this.a, l * 1000L, new RemindJavascriptInterface.1(this), paramJsBridgeListener);
  }
  
  public void b(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    Object localObject6 = new StringBuilder();
    String str = "";
    Object localObject3;
    if (localObject1 != null) {
      localObject3 = ((CustomWebView)localObject1).getUrl();
    } else {
      localObject3 = "";
    }
    Object localObject4 = localObject3;
    Object localObject5;
    try
    {
      boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
      localObject1 = localObject3;
      if (!bool)
      {
        localObject4 = localObject3;
        localObject1 = URLEncoder.encode((String)localObject3, "utf-8");
      }
      localObject4 = localObject1;
      localObject3 = str;
      localObject5 = localObject1;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject4 = localObject1;
        localObject3 = URLEncoder.encode(paramString, "utf-8");
        localObject5 = localObject1;
      }
    }
    catch (Exception localException)
    {
      localObject3 = str;
      localObject5 = localObject4;
      if (QLog.isDevelopLevel())
      {
        localException.printStackTrace();
        localObject5 = localObject4;
        localObject3 = str;
      }
    }
    ((StringBuilder)localObject6).append("p=");
    ((StringBuilder)localObject6).append((String)localObject3);
    ((StringBuilder)localObject6).append("&j=");
    ((StringBuilder)localObject6).append((String)localObject5);
    long l1 = VACDReportUtil.a(null, "qqwallet", "insertCalendar", "invoke", ((StringBuilder)localObject6).toString(), 0, null);
    if (TextUtils.isEmpty(paramString))
    {
      VACDReportUtil.endReport(l1, "parseUrl", null, -1, "json is empty");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("createCalendar : ");
      ((StringBuilder)localObject3).append(paramString);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = null;
    try
    {
      paramString = new JSONObject(paramString);
      localObject4 = paramString.optString("title");
      long l2 = paramString.optLong("startDate");
      long l3 = paramString.optLong("endDate");
      localObject5 = paramString.optString("remark");
      str = paramString.optString("address");
      localObject3 = paramString.optString("callback");
      localObject6 = paramString.optJSONArray("reminds");
      paramString = (String)localObject2;
      int i;
      if (localObject6 != null)
      {
        paramString = (String)localObject2;
        if (((JSONArray)localObject6).length() > 0)
        {
          localObject2 = new int[((JSONArray)localObject6).length()];
          i = 0;
          for (;;)
          {
            paramString = (String)localObject2;
            if (i >= ((JSONArray)localObject6).length()) {
              break;
            }
            localObject2[i] = ((JSONArray)localObject6).getInt(i);
            i += 1;
          }
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (l2 >= 1L) && (l3 >= 1L))
      {
        VACDReportUtil.a(l1, null, "parseUrl", null, 0, null);
        if (QLog.isColorLevel())
        {
          localObject2 = b;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("startTime : ");
          ((StringBuilder)localObject6).append(TimeHelper.d(l2 * 1000L));
          ((StringBuilder)localObject6).append(" endTime : ");
          ((StringBuilder)localObject6).append(TimeHelper.d(l3 * 1000L));
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject6).toString());
        }
        i = RemindHelper.a(this.a, (String)localObject4, l2 * 1000L, l3 * 1000L, (String)localObject5, str, paramString);
        VACDReportUtil.endReport(l1, "insert", null, i, null);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramString = new StringBuilder();
          paramString.append("{\"retCode\":");
          paramString.append(i);
          paramString.append("}");
          super.callJs((String)localObject3, new String[] { paramString.toString() });
        }
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "addByRecevierReport");
          }
          ReportController.b(null, "CliOper", "", "", "Time_reminder", "Rec_ckl_add", 0, 0, "", "", "", "");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "params error.");
      }
      VACDReportUtil.endReport(l1, "parseUrl", null, -1, "params error.");
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("JSONException ");
        ((StringBuilder)localObject3).append(paramString.getMessage());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      VACDReportUtil.endReport(l1, "parseUrl", null, -1, "JsonException");
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "REMIND", "calendar" };
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("REMIND".equals(paramString2)) && ("createTimePicker".equals(paramString3)))
    {
      a(paramVarArgs[0], paramJsBridgeListener);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("addEvent".equals(paramString3)))
    {
      b(paramVarArgs[0]);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindSuccess".equals(paramString3)))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindDelete".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "deleteRemindSuccess");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Delete_clock", 0, 0, "", "", "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindMsgReport".equals(paramString3)))
    {
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = b;
        paramString1 = new StringBuilder();
        paramString1.append("remindMsgReport : ");
        paramString1.append(paramVarArgs[0]);
        QLog.d(paramJsBridgeListener, 2, paramString1.toString());
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Obj_clock", 0, 0, RemindHelper.a(paramVarArgs[0], "entranceType"), RemindHelper.a(paramVarArgs[0], "role"), "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindAioReport".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "remindAioReport");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Clock_card_clk", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = this.mRuntime.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */