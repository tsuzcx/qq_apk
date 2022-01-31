package com.tencent.mobileqq.jsp;

import adwc;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkPicBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class DocxApiPlugin
  extends WebViewPlugin
{
  public DocxApiPlugin()
  {
    this.mPluginNameSpace = "docx";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("docx".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if ((!"readyToInsertImageCallBack".equals(paramString3)) || (paramVarArgs.length > 1)) {
        break label177;
      }
    }
    label177:
    while ((!"getDocxImageIndex".equals(paramString3)) || (paramVarArgs.length > 1))
    {
      try
      {
        if (paramVarArgs.length == 1)
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getString("attachmentId");
          paramString1 = paramString1.getString("localpath");
          paramString2 = this.mRuntime.a();
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "回调id = " + paramJsBridgeListener + " localPath = " + paramString1);
          }
          if ((paramString2 != null) && ((paramString2 instanceof TeamWorkDocEditBrowserActivity))) {
            ThreadManager.postImmediately(new adwc(this, paramString2, paramString1, paramJsBridgeListener), null, false);
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        while (!QLog.isDevelopLevel()) {}
        QLog.d("DocxApiPlugin", 4, "readyToInsertImageCallBack failed:" + paramJsBridgeListener);
        return false;
      }
      return false;
    }
    for (;;)
    {
      try
      {
        if (paramVarArgs.length != 1) {
          break;
        }
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = new ArrayList();
        if (!paramString1.has("currentImageIndex")) {
          break label511;
        }
        i = paramString1.getInt("currentImageIndex");
        if (paramString1.has("imageList"))
        {
          paramString1 = paramString1.getJSONArray("imageList");
          if (paramString1 != null)
          {
            j = 0;
            if (j < paramString1.length())
            {
              paramJsBridgeListener.add((String)paramString1.get(j));
              j += 1;
              continue;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkDocEditBrowserActivity", 2, " index = " + i + " urls.size = " + paramJsBridgeListener.size());
        }
        paramString1 = this.mRuntime.a();
        if ((paramString1 == null) || (!(paramString1 instanceof TeamWorkDocEditBrowserActivity)) || (i == -1)) {
          break;
        }
        paramString2 = new ArrayList();
        int j = 0;
        if (j < paramJsBridgeListener.size())
        {
          paramString3 = new PicInfo();
          paramString3.a = ((String)paramJsBridgeListener.get(j));
          paramString3.b = ((String)paramJsBridgeListener.get(j));
          paramString2.add(paramString3);
          j += 1;
          continue;
        }
        paramJsBridgeListener = new Intent(paramString1, TeamWorkPicBrowserActivity.class);
        paramJsBridgeListener.putExtra("intent_param_index", i);
        paramJsBridgeListener.putExtra("intent_param_pic_infos", paramString2);
        paramJsBridgeListener.addFlags(536870912);
        paramString1.startActivity(paramJsBridgeListener);
        return false;
      }
      catch (Exception paramJsBridgeListener) {}
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("DocxApiPlugin", 4, "getDocxImageList failed:" + paramJsBridgeListener);
      return false;
      label511:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin
 * JD-Core Version:    0.7.0.1
 */