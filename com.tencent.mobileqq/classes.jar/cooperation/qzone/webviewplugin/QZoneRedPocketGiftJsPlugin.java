package cooperation.qzone.webviewplugin;

import amtj;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
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
  
  private void handleSendRedPocketGift(WebViewPlugin paramWebViewPlugin, bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str1;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        l = paramVarArgs.optLong("uin");
        str1 = paramVarArgs.optString("payKey");
        localObject = paramVarArgs.optString("nickName");
        this.sendRedPocketGiftCallback = paramVarArgs.optString("callback");
        if (l == 0L)
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "uin error , uin " + l);
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "payKey error , paykey = " + str1);
          return;
        }
      }
      catch (Exception paramWebViewPlugin)
      {
        onJSCallBack(this.sendRedPocketGiftCallback, null, amtj.a(2131711409), -1);
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.getMessage());
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
      Object localObject = QZoneHelper.UserInfo.getInstance();
      String str2 = ((TicketManager)parambgve.a().getManager(2)).getSkey(parambgve.a().getAccount());
      int i = QZoneHelper.generateRequestCode(paramWebViewPlugin, parambgve, 8);
      QZoneHelper.forwardToRedPocket(parambgve.a(), (QZoneHelper.UserInfo)localObject, str2, l, paramVarArgs, str1, i);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!"sendRedPocketGift".equals(paramString3)) {
      return false;
    }
    RemoteHandleManager.getInstance().addWebEventListener(this);
    handleSendRedPocketGift(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      onJSCallBack(this.sendRedPocketGiftCallback, null, amtj.a(2131711407), 0);
      return;
    }
    onJSCallBack(this.sendRedPocketGiftCallback, null, amtj.a(2131711410), -1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onJSCallBack(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    JSONObject localJSONObject;
    if (this.parentPlugin != null)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramInt = -1;
        paramString3 = amtj.a(2131711408);
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("data", paramString2);
      localJSONObject.put("message", paramString3);
      this.parentPlugin.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        if (paramBundle.getBundle("data") != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QZoneRedPocketGiftJsPlugin", 2, "call js function,bundle is empty");
      return;
    } while (!"cmd.qzoneSendRedPocketGift".equals(paramString));
    if (TextUtils.isEmpty(this.sendRedPocketGiftCallback))
    {
      onJSCallBack(this.sendRedPocketGiftCallback, null, amtj.a(2131711406), -1);
      return;
    }
    onJSCallBack(this.sendRedPocketGiftCallback, null, amtj.a(2131711411), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneRedPocketGiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */