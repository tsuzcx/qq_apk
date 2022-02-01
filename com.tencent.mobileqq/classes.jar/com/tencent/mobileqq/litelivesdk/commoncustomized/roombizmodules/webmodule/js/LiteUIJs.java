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
    Object localObject = (String)paramMap.get("url");
    Uri.parse((String)localObject);
    String str = (String)paramMap.get("target");
    paramMap = (String)paramMap.get("no_history");
    label260:
    try
    {
      i = Integer.valueOf(str).intValue();
    }
    catch (Exception paramMap)
    {
      int i;
      label54:
      break label54;
    }
    Log.e("LiteUIJs", "illegal target");
    i = 1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")) && (!((String)localObject).startsWith("file://")))
        {
          if (((String)localObject).startsWith("mqq://"))
          {
            paramMap = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, (String)localObject);
            if (paramMap == null) {
              break label260;
            }
            paramMap.a();
            return;
          }
          try
          {
            paramMap = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
            paramMap.setFlags(268435456);
            this.mContext.startActivity(paramMap);
            return;
          }
          catch (Exception paramMap)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("start activity error, e =");
            ((StringBuilder)localObject).append(paramMap.toString());
            QLog.e("LiteUIJs", 1, ((StringBuilder)localObject).toString());
            return;
          }
        }
        paramMap = new Intent(this.mContext, QQBrowserActivity.class);
        paramMap.putExtra("url", (String)localObject);
        paramMap.putExtra("fragmentClass", LiteLiveWebViewFragment.class);
        paramMap.addFlags(268435456);
        this.mContext.startActivity(paramMap);
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
    }
    catch (Exception paramMap)
    {
      int i;
      label32:
      break label32;
    }
    QLog.e("LiteUIJs", 1, "illegal target");
    i = 1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http://")) || (str.startsWith("https://")) || (str.startsWith("file://"))))
      {
        paramMap = new Intent(this.mContext, QQBrowserActivity.class);
        paramMap.putExtra("url", str);
        paramMap.putExtra("fragmentClass", LiteLiveWebViewFragment.class);
        paramMap.addFlags(268435456);
        this.mContext.startActivity(paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs
 * JD-Core Version:    0.7.0.1
 */