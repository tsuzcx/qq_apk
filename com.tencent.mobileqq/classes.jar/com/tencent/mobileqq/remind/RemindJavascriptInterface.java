package com.tencent.mobileqq.remind;

import agsa;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
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
  private static String a;
  protected Activity a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "remind";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remindSuccess : " + paramString);
    }
    boolean bool1 = RemindHelper.a(RemindHelper.a(paramString, "isNew"));
    boolean bool2 = RemindHelper.a(RemindHelper.a(paramString, "isInsert"));
    RemindHelper.a(paramString, "title");
    RemindHelper.a(RemindHelper.a(paramString, "startDate")).longValue();
    RemindHelper.a(RemindHelper.a(paramString, "endDate")).longValue();
    if (bool1)
    {
      paramString = "0";
      if (!bool2) {
        break label180;
      }
    }
    label180:
    for (String str = "0";; str = "1")
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createAndAddReport  r2: " + str + " r3: " + paramString);
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Updata_clock", 0, 0, str, paramString, "", "");
      return;
      paramString = "1";
      break;
    }
  }
  
  public void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    long l = RemindHelper.a(RemindHelper.a(paramString, "currentDate")).longValue();
    RemindHelper.a(this.jdField_a_of_type_AndroidAppActivity, l * 1000L, new agsa(this), paramJsBridgeListener);
  }
  
  public void b(String paramString)
  {
    Object localObject2 = this.mRuntime.a();
    Object localObject1 = "";
    String str3 = "";
    Object localObject3 = new StringBuilder();
    if (localObject2 != null) {
      localObject1 = ((CustomWebView)localObject2).getUrl();
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
        localObject1 = localObject2;
      }
      String str1;
      long l1;
      long l2;
      long l3;
      String str2;
      int i;
      label408:
      for (;;)
      {
        str1 = str3;
        localObject2 = localObject1;
      }
    }
    catch (Exception localException1)
    {
      do
      {
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramString))
            {
              str1 = URLEncoder.encode(paramString, "utf-8");
              localObject2 = localObject1;
            }
            ((StringBuilder)localObject3).append("p=").append(str1);
            ((StringBuilder)localObject3).append("&j=").append((String)localObject2);
            l1 = VACDReportUtil.a(null, "qqwallet", "insertCalendar", "invoke", ((StringBuilder)localObject3).toString(), 0, null);
            if (!TextUtils.isEmpty(paramString)) {
              continue;
            }
            VACDReportUtil.endReport(l1, "parseUrl", null, -1, "json is empty");
            return;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localException1 = localException1;
          str1 = str3;
          localObject2 = localObject1;
          if (QLog.isDevelopLevel())
          {
            localException1.printStackTrace();
            str1 = str3;
            localObject2 = localObject1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "createCalendar : " + paramString);
        }
        localObject1 = null;
        try
        {
          paramString = new JSONObject(paramString);
          localObject2 = paramString.optString("title");
          l2 = paramString.optLong("startDate");
          l3 = paramString.optLong("endDate");
          str1 = paramString.optString("remark");
          str2 = paramString.optString("address");
          str3 = paramString.optString("callback");
          localObject3 = paramString.optJSONArray("reminds");
          paramString = (String)localObject1;
          if (localObject3 != null)
          {
            paramString = (String)localObject1;
            if (((JSONArray)localObject3).length() > 0)
            {
              localObject1 = new int[((JSONArray)localObject3).length()];
              i = 0;
              for (;;)
              {
                paramString = (String)localObject1;
                if (i >= ((JSONArray)localObject3).length()) {
                  break;
                }
                localObject1[i] = ((JSONArray)localObject3).getInt(i);
                i += 1;
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label408;
          }
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "JSONException " + paramString.getMessage());
          }
          VACDReportUtil.endReport(l1, "parseUrl", null, -1, "JsonException");
          return;
        }
        if ((l2 < 1L) || (l3 < 1L))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "params error.");
          }
          VACDReportUtil.endReport(l1, "parseUrl", null, -1, "params error.");
          return;
        }
        VACDReportUtil.a(l1, null, "parseUrl", null, 0, null);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "startTime : " + TimeHelper.a(1000L * l2) + " endTime : " + TimeHelper.a(1000L * l3));
        }
        i = RemindHelper.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject2, 1000L * l2, 1000L * l3, str1, str2, paramString);
        VACDReportUtil.endReport(l1, "insert", null, i, null);
        if (!TextUtils.isEmpty(str3)) {
          super.callJs(str3, new String[] { "{\"retCode\":" + i + "}" });
        }
      } while (i != 0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addByRecevierReport");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Rec_ckl_add", 0, 0, "", "", "", "");
      return;
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteRemindSuccess");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Delete_clock", 0, 0, "", "", "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindMsgReport".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "remindMsgReport : " + paramVarArgs[0]);
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Obj_clock", 0, 0, RemindHelper.a(paramVarArgs[0], "entranceType"), RemindHelper.a(paramVarArgs[0], "role"), "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindAioReport".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "remindAioReport");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Clock_card_clk", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */