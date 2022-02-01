package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class LiteUIJs
  extends UIJavascriptInterface
{
  private static final String TAG = "LiteUIJs";
  
  public LiteUIJs(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  @NewJavascriptInterface
  public void openUrl(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("url");
    Uri.parse(str1);
    String str2 = (String)paramMap.get("target");
    paramMap = (String)paramMap.get("no_history");
    try
    {
      i = Integer.valueOf(str2).intValue();
      switch (i)
      {
      }
    }
    catch (Exception paramMap)
    {
      do
      {
        do
        {
          for (;;)
          {
            Log.e("LiteUIJs", "illegal target");
            int i = 1;
          }
        } while (TextUtils.isEmpty(str1));
        if ((str1.startsWith("http://")) || (str1.startsWith("https://")) || (str1.startsWith("file://")))
        {
          paramMap = new Intent(this.mContext, QQBrowserActivity.class);
          paramMap.putExtra("url", str1);
          paramMap.putExtra("fragmentClass", LiteLiveWebViewFragment.class);
          paramMap.addFlags(268435456);
          this.mContext.startActivity(paramMap);
          return;
        }
        if (!str1.startsWith("mqq://")) {
          break;
        }
        paramMap = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, str1);
      } while (paramMap == null);
      paramMap.a();
      return;
      try
      {
        paramMap = new Intent("android.intent.action.VIEW", Uri.parse(str1));
        paramMap.setFlags(268435456);
        this.mContext.startActivity(paramMap);
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("LiteUIJs", 1, "start activity error, e =" + paramMap.toString());
      }
    }
  }
  
  @NewJavascriptInterface
  public void openUrlInHost(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("url");
    paramMap = (String)paramMap.get("target");
    try
    {
      i = Integer.parseInt(paramMap);
      switch (i)
      {
      }
    }
    catch (Exception paramMap)
    {
      do
      {
        for (;;)
        {
          QLog.e("LiteUIJs", 1, "illegal target");
          int i = 1;
        }
      } while ((TextUtils.isEmpty(str)) || ((!str.startsWith("http://")) && (!str.startsWith("https://")) && (!str.startsWith("file://"))));
      paramMap = new Intent(this.mContext, QQBrowserActivity.class);
      paramMap.putExtra("url", str);
      paramMap.putExtra("fragmentClass", LiteLiveWebViewFragment.class);
      paramMap.addFlags(268435456);
      this.mContext.startActivity(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs
 * JD-Core Version:    0.7.0.1
 */