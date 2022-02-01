package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.MiniAioEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.fragment.TransparentWebFragment;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.fragment.NowLiteWebViewFragment;
import com.tencent.mobileqq.intervideo.now.dynamic.MiniAioInterfaceImpl;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.litelivesdk.utils.ui.DeviceManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NowUIJs
  extends LiteUIJs
{
  private static final String TAG = "NowUIJs";
  private Context context;
  private CustomWebView customWebView;
  private MiniAioInterfaceImpl miniAioInterface;
  IMiniMsgUnreadCallback miniMsgUnreadCallback = new NowUIJs.1(this);
  private RoomBizContext roomBizContext;
  
  public NowUIJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
    this.context = paramContext;
    this.miniAioInterface = new MiniAioInterfaceImpl();
  }
  
  public NowUIJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter, RoomBizContext paramRoomBizContext)
  {
    super(paramContext, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
    this.context = paramContext;
    this.roomBizContext = paramRoomBizContext;
    this.miniAioInterface = new MiniAioInterfaceImpl();
  }
  
  private int getSourceFromMqq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      paramString = Uri.parse(paramString);
      try
      {
        paramString = paramString.getQueryParameter("fromid");
        if (paramString != null)
        {
          int i = Integer.parseInt(paramString);
          return i;
        }
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  private void mqqOpenUrl(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("p");
    if (TextUtils.isEmpty(paramMap)) {}
    for (;;)
    {
      return;
      try
      {
        paramMap = new JSONObject(paramMap);
        paramMap = paramMap.optString("url");
        if (!TextUtils.isEmpty(paramMap))
        {
          openNewWebViewPage(paramMap);
          return;
        }
      }
      catch (JSONException paramMap) {}
    }
  }
  
  private void notifyWeb(int paramInt)
  {
    Object localObject = new MiniAioEvent("updateUnreadCount", paramInt).a();
    localObject = "javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + ((JSONObject)localObject).toString() + ");";
    this.customWebView.callJs((String)localObject);
  }
  
  private void openNewWebViewPage(String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("file://")))
    {
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fragmentClass", NowLiteWebViewFragment.class);
      this.mContext.startActivity(localIntent);
    }
    do
    {
      return;
      if (!paramString.startsWith("mqq://")) {
        break;
      }
      paramString = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, paramString);
    } while (paramString == null);
    paramString.a();
    return;
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      this.mContext.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NowUIJs", 1, "start activity error, e =" + paramString.toString());
    }
  }
  
  @NewJavascriptInterface
  public void isNowLite(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("callback");
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramMap)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("isNowLite", true);
      this.customWebView.callJs(paramMap, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("NowUIJs", 1, "isNowLite, JSONException =" + localJSONException.toString());
      }
    }
  }
  
  @NewJavascriptInterface
  public void miniAIO(Map<String, String> paramMap)
  {
    if (this.miniAioInterface == null) {}
    label248:
    do
    {
      return;
      try
      {
        paramMap = new JSONObject((String)paramMap.get("p"));
        if (paramMap.has("action"))
        {
          paramMap = paramMap.getString("action");
          if (!"init".equals(paramMap)) {
            continue;
          }
          paramMap = new Bundle();
          localObject = this.roomBizContext.getEnterRoomInfo();
          paramMap.putLong("roomid", ((EnterRoomInfo)localObject).roomId);
          paramMap.putInt("roomType", ((EnterRoomInfo)localObject).roomType);
          localObject = ((EnterRoomInfo)localObject).extData;
          j = 0;
          i = j;
          if (localObject != null) {
            if (!((Bundle)localObject).containsKey("source")) {
              break label248;
            }
          }
        }
      }
      catch (JSONException paramMap)
      {
        for (;;)
        {
          try
          {
            Object localObject;
            i = Integer.parseInt(((Bundle)localObject).getString("source"));
            paramMap.putInt("fromid", i);
            paramMap.putInt("offsetX", DeviceManager.a(this.context, 41.0F));
            this.miniAioInterface.a(this.context, paramMap, this.miniMsgUnreadCallback);
            this.miniAioInterface.onForeground();
            return;
            paramMap = paramMap;
            QLog.e("NowUIJs", 1, "miniAIO json error: " + paramMap);
            paramMap = "";
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int j;
            QLog.e("NowUIJs", 1, "miniAIO get source error: " + localNumberFormatException);
            i = j;
            continue;
          }
          int i = getSourceFromMqq(localNumberFormatException.getString("mqqschema"));
        }
      }
    } while (!"open".equals(paramMap));
    this.miniAioInterface.a();
  }
  
  @NewJavascriptInterface
  public void openActivityUrl(Map<String, String> paramMap)
  {
    openUrl(paramMap);
  }
  
  @NewJavascriptInterface
  public void openDialog(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    while (!TextUtils.equals("0", (String)paramMap.get("from"))) {
      return;
    }
    DialogUtil.a(this.context, 231, HardCodeUtil.a(2131694571), HardCodeUtil.a(2131694569), HardCodeUtil.a(2131694570), null, null, new NowUIJs.2(this)).show();
  }
  
  @NewJavascriptInterface
  public void openTransparentWebview(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    if (TextUtils.isEmpty(paramMap)) {}
    while (!(this.mContext instanceof FragmentActivity)) {
      return;
    }
    TransparentWebFragment.a(((FragmentActivity)this.mContext).getSupportFragmentManager(), paramMap);
  }
  
  @NewJavascriptInterface
  public void openUrl(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("url");
    if (TextUtils.isEmpty(str1))
    {
      mqqOpenUrl(paramMap);
      return;
    }
    Uri.parse(str1);
    String str2 = (String)paramMap.get("target");
    paramMap = (String)paramMap.get("no_history");
    try
    {
      i = Integer.valueOf(str2).intValue();
      switch (i)
      {
      case 0: 
      default: 
        return;
      }
      openNewWebViewPage(str1);
      return;
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        Log.e("NowUIJs", "illegal target");
        int i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs
 * JD-Core Version:    0.7.0.1
 */