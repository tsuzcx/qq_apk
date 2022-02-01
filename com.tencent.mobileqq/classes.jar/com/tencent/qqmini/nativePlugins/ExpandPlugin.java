package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class ExpandPlugin
  extends BaseJsPlugin
{
  private static final Map<String, Integer> a = new HashMap();
  
  static
  {
    a.put("水瓶座", Integer.valueOf(1));
    a.put("双鱼座", Integer.valueOf(2));
    a.put("白羊座", Integer.valueOf(3));
    a.put("金牛座", Integer.valueOf(4));
    a.put("双子座", Integer.valueOf(5));
    a.put("巨蟹座", Integer.valueOf(6));
    a.put("狮子座", Integer.valueOf(7));
    a.put("处女座", Integer.valueOf(8));
    a.put("天秤座", Integer.valueOf(9));
    a.put("水瓶座", Integer.valueOf(10));
    a.put("射手座", Integer.valueOf(11));
    a.put("摩羯座", Integer.valueOf(12));
  }
  
  @JsEvent({"openExpandChat"})
  private void openExpandChat(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      Object localObject1 = ((JSONObject)localObject2).optString("uin");
      int i = ((JSONObject)localObject2).optInt("matchRelationSource", -1);
      localObject2 = ((JSONObject)localObject2).optString("signature");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i >= 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("accost_type", 163);
        localBundle.putString("match_uin", (String)localObject1);
        localBundle.putInt("matchRelationSource", i);
        localBundle.putByteArray("sig", Base64.decode((String)localObject2, 0));
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyOpenAio", localBundle);
        if ((localObject1 != null) && (((EIPCResult)localObject1).isSuccess()))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
        return;
      }
      paramRequestEvent.fail("Invalid params!");
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  @JsEvent({"getExpandUserInfo"})
  public void getExpandUserInfo(RequestEvent paramRequestEvent)
  {
    QLog.d("ExpandPlugin", 2, "[getExpandUserInfo] start");
    QIPCClientHelper.getInstance().callServer("ExpandFlutterIPCServer", "getExpandUserInfo", null, new ExpandPlugin.1(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.ExpandPlugin
 * JD-Core Version:    0.7.0.1
 */