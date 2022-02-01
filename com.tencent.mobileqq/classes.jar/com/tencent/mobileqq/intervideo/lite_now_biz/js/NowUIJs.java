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
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
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
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = Uri.parse(paramString);
    try
    {
      paramString = paramString.getQueryParameter("fromid");
      if (paramString == null) {
        return 0;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private void mqqOpenUrl(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("p");
    if (TextUtils.isEmpty(paramMap)) {
      return;
    }
    try
    {
      paramMap = new JSONObject(paramMap);
      paramMap = paramMap.optString("url");
      if (TextUtils.isEmpty(paramMap)) {
        return;
      }
      openNewWebViewPage(paramMap);
      return;
    }
    catch (JSONException paramMap) {}
  }
  
  private void notifyWeb(int paramInt)
  {
    Object localObject = new MiniAioEvent("updateUnreadCount", paramInt).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:mqq.dispatchEvent(\"miniAIOEvent\",");
    localStringBuilder.append(((JSONObject)localObject).toString());
    localStringBuilder.append(");");
    localObject = localStringBuilder.toString();
    this.customWebView.callJs((String)localObject);
  }
  
  private void openNewWebViewPage(String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://")))
    {
      if (paramString.startsWith("mqq://"))
      {
        paramString = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, paramString);
        if (paramString == null) {
          return;
        }
        paramString.a();
        return;
      }
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.setFlags(268435456);
        this.mContext.startActivity(paramString);
        return;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start activity error, e =");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NowUIJs", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    Object localObject = new Intent(this.mContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("fragmentClass", NowLiteWebViewFragment.class);
    ((Intent)localObject).addFlags(268435456);
    this.mContext.startActivity((Intent)localObject);
  }
  
  @NewJavascriptInterface
  public void isNowLite(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("callback");
    if (!TextUtils.isEmpty(paramMap))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("isNowLite", true);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNowLite, JSONException =");
        localStringBuilder.append(localJSONException.toString());
        QLog.e("NowUIJs", 1, localStringBuilder.toString());
      }
      this.customWebView.callJs(paramMap, new String[] { localJSONObject.toString() });
    }
  }
  
  @NewJavascriptInterface
  public void miniAIO(Map<String, String> paramMap)
  {
    if (this.miniAioInterface == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2;
    try
    {
      localObject2 = new JSONObject((String)paramMap.get("p"));
      paramMap = (Map<String, String>)localObject1;
      if (((JSONObject)localObject2).has("action")) {
        paramMap = ((JSONObject)localObject2).getString("action");
      }
    }
    catch (JSONException paramMap)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("miniAIO json error: ");
      ((StringBuilder)localObject2).append(paramMap);
      QLog.e("NowUIJs", 1, ((StringBuilder)localObject2).toString());
      paramMap = (Map<String, String>)localObject1;
    }
    if ("init".equals(paramMap))
    {
      paramMap = new Bundle();
      localObject1 = this.roomBizContext.getEnterRoomInfo();
      paramMap.putLong("roomid", ((EnterRoomInfo)localObject1).roomId);
      paramMap.putInt("roomType", ((EnterRoomInfo)localObject1).roomType);
      localObject1 = ((EnterRoomInfo)localObject1).extData;
      int j = 0;
      int i = j;
      if (localObject1 != null) {
        if (((Bundle)localObject1).containsKey("source")) {
          try
          {
            i = Integer.parseInt(((Bundle)localObject1).getString("source"));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("miniAIO get source error: ");
            ((StringBuilder)localObject2).append(localNumberFormatException);
            QLog.e("NowUIJs", 1, ((StringBuilder)localObject2).toString());
            i = j;
          }
        } else {
          i = getSourceFromMqq(localNumberFormatException.getString("mqqschema"));
        }
      }
      paramMap.putInt("fromid", i);
      paramMap.putInt("offsetX", DeviceManager.a(this.context, 41.0F));
      this.miniAioInterface.a(this.context, paramMap, this.miniMsgUnreadCallback);
      this.miniAioInterface.onForeground();
      return;
    }
    if ("open".equals(paramMap)) {
      this.miniAioInterface.a();
    }
  }
  
  @NewJavascriptInterface
  public void openActivityUrl(Map<String, String> paramMap)
  {
    openUrl(paramMap);
  }
  
  @NewJavascriptInterface
  public void openDialog(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (TextUtils.equals("0", (String)paramMap.get("from"))) {
      DialogUtil.a(this.context, 231, HardCodeUtil.a(2131694537), HardCodeUtil.a(2131694535), HardCodeUtil.a(2131694536), null, null, new NowUIJs.2(this)).show();
    }
  }
  
  @NewJavascriptInterface
  public void openTransparentWebview(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    if (TextUtils.isEmpty(paramMap)) {
      return;
    }
    if ((this.mContext instanceof FragmentActivity)) {
      TransparentWebFragment.a(((FragmentActivity)this.mContext).getSupportFragmentManager(), paramMap);
    }
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
    }
    catch (Exception paramMap)
    {
      int i;
      label69:
      break label69;
    }
    Log.e("NowUIJs", "illegal target");
    i = 1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      openNewWebViewPage(str1);
    }
  }
  
  @NewJavascriptInterface
  public void showConfirmDialog(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("text");
    String str2 = (String)paramMap.get("title");
    paramMap = DialogUtil.a(this.context, 0, str2, str1, new NowUIJs.3(this, paramMap), null);
    paramMap.setCancelable(false);
    paramMap.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs
 * JD-Core Version:    0.7.0.1
 */