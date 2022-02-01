package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import org.json.JSONArray;
import org.json.JSONObject;

class UiApiPlugin$21
  implements PopupMenuDialog.OnClickActionListener
{
  UiApiPlugin$21(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id - 1;
    paramMenuItem = null;
    Object localObject1 = null;
    try
    {
      Object localObject2 = this.a.optString("callback");
      JSONArray localJSONArray = this.a.optJSONArray("list");
      if (localJSONArray != null)
      {
        if (i >= localJSONArray.length()) {
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.c.callJs((String)localObject2, new String[] { String.valueOf(i + 1) });
          return;
        }
        localObject2 = localJSONArray.optJSONObject(i);
        i = ((JSONObject)localObject2).optInt("target");
        paramMenuItem = (PopupMenuDialog.MenuItem)localObject1;
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jumpUrl");
          paramMenuItem = (PopupMenuDialog.MenuItem)localObject1;
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          j = i;
          if (!bool) {
            break label191;
          }
          return;
        }
        catch (Exception localException1) {}
      }
      else
      {
        return;
      }
    }
    catch (Exception localException2)
    {
      i = 0;
      localObject1 = paramMenuItem;
      int j = i;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showPopupMenu Exception: ");
        ((StringBuilder)localObject1).append(localException2.getMessage());
        QLog.e("UiApiPlugin", 2, ((StringBuilder)localObject1).toString());
        j = i;
        localObject1 = paramMenuItem;
      }
      label191:
      if (j != 0)
      {
        if (j != 1) {
          return;
        }
        paramMenuItem = new Bundle();
        Object localObject3 = this.b;
        if ((localObject3 instanceof BasePluginActivity))
        {
          localObject3 = new Intent(((BasePluginActivity)localObject3).getOutActivity(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtras(paramMenuItem);
          ((Intent)localObject3).putExtra("url", (String)localObject1);
          ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject3).setFlags(0);
          this.b.startActivity((Intent)localObject3);
          return;
        }
        localObject3 = new Intent((Context)localObject3, localObject3.getClass());
        ((Intent)localObject3).putExtras(paramMenuItem);
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject3).setFlags(0);
        this.b.startActivity((Intent)localObject3);
        return;
      }
      this.c.mRuntime.a().loadUrl((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.21
 * JD-Core Version:    0.7.0.1
 */