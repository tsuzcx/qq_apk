package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StudyRoomJsPlugin
  extends WebViewPlugin
{
  private static String[] a = { "\\", "/", ":", "*", "?", "\"", "<", ">", "|", "&", "=" };
  private final TroopMemberApiClient b = TroopMemberApiClient.a();
  
  public StudyRoomJsPlugin()
  {
    this.mPluginNameSpace = "studyroom";
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (!b(paramArrayOfString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      paramArrayOfString = "";
      HashMap localHashMap = new HashMap();
      if (localJSONObject.has("event")) {
        paramArrayOfString = localJSONObject.getString("event");
      }
      if ((!TextUtils.isEmpty(paramArrayOfString)) && (!a(paramArrayOfString)))
      {
        if (localJSONObject.has("data"))
        {
          localJSONObject = localJSONObject.getJSONObject("data");
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = localJSONObject.getString(str1);
            if ((!a(str1)) && (!a(str2)))
            {
              localHashMap.put(str1, str2);
            }
            else
            {
              QLog.e("StudyRoomJsPlugin", 1, "handleReportRequest: param contain special words.");
              return;
            }
          }
        }
        ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent(paramArrayOfString, localHashMap);
        return;
      }
      QLog.e("StudyRoomJsPlugin", 1, "handleReportRequest: report event is invalid.");
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
      QLog.e("StudyRoomJsPlugin", 1, "handleReportRequest: json error.");
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = a;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(localObject[i]))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("specialWordCheck: contain special word[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.e("StudyRoomJsPlugin", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1)) {
      return true;
    }
    QLog.e("StudyRoomJsPlugin", 2, "args is null");
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("studyroom".equals(paramString2))
    {
      if ("predownload".equals(paramString3))
      {
        this.b.n();
        return true;
      }
      if ("report".equals(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.b.e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.StudyRoomJsPlugin
 * JD-Core Version:    0.7.0.1
 */