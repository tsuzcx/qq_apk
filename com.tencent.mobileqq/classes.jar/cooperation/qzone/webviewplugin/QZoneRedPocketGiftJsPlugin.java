package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class QZoneRedPocketGiftJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = "QZoneRedPocketGiftJsPlugin";
  private String sendRedPocketGiftCallback;
  
  private void handleSendRedPocketGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        long l = paramVarArgs.optLong("uin");
        String str1 = paramVarArgs.optString("payKey");
        Object localObject = paramVarArgs.optString("nickName");
        this.sendRedPocketGiftCallback = paramVarArgs.optString("callback");
        if (l == 0L)
        {
          paramWebViewPlugin = new StringBuilder();
          paramWebViewPlugin.append("uin error , uin ");
          paramWebViewPlugin.append(l);
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.toString());
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          paramWebViewPlugin = new StringBuilder();
          paramWebViewPlugin.append("payKey error , paykey = ");
          paramWebViewPlugin.append(str1);
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.toString());
          return;
        }
        if (TextUtils.isEmpty(this.sendRedPocketGiftCallback))
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "callback is empty.");
          return;
        }
        paramVarArgs = (String[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramVarArgs = String.valueOf(l);
        }
        RemoteHandleManager.getInstance().getSender().setRedKeyData(l, str1);
        localObject = QZoneHelper.UserInfo.getInstance();
        String str2 = ((TicketManager)paramPluginRuntime.b().getManager(2)).getSkey(paramPluginRuntime.b().getAccount());
        int i = QZoneHelperProxyImpl.generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 8);
        QZoneHelper.forwardToRedPocket(paramPluginRuntime.d(), (QZoneHelper.UserInfo)localObject, str2, l, paramVarArgs, str1, i);
        return;
      }
      catch (Exception paramWebViewPlugin)
      {
        onJSCallBack(this.sendRedPocketGiftCallback, null, HardCodeUtil.a(2131909848), -1);
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.getMessage());
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("Qzone".equals(paramString2)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ("sendRedPocketGift".equals(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        handleSendRedPocketGift(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte != 8) {
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      onJSCallBack(this.sendRedPocketGiftCallback, null, HardCodeUtil.a(2131909846), 0);
      return;
    }
    onJSCallBack(this.sendRedPocketGiftCallback, null, HardCodeUtil.a(2131909849), -1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onJSCallBack(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.parentPlugin != null)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramInt = -1;
        paramString3 = HardCodeUtil.a(2131909847);
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", paramInt);
        localJSONObject.put("data", paramString2);
        localJSONObject.put("message", paramString3);
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      this.parentPlugin.callJs(paramString1, new String[] { localJSONObject.toString() });
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      if (paramBundle.getBundle("data") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneRedPocketGiftJsPlugin", 2, "call js function,bundle is empty");
        }
        return;
      }
      if ("cmd.qzoneSendRedPocketGift".equals(paramString))
      {
        if (TextUtils.isEmpty(this.sendRedPocketGiftCallback))
        {
          onJSCallBack(this.sendRedPocketGiftCallback, null, HardCodeUtil.a(2131909845), -1);
          return;
        }
        onJSCallBack(this.sendRedPocketGiftCallback, null, HardCodeUtil.a(2131909850), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneRedPocketGiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */