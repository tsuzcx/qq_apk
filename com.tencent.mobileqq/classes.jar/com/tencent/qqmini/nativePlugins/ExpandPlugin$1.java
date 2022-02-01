package com.tencent.qqmini.nativePlugins;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import org.json.JSONObject;

class ExpandPlugin$1
  implements EIPCResultCallback
{
  ExpandPlugin$1(ExpandPlugin paramExpandPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("ExpandPlugin", 2, "[doGetUserExpandProfile] onCallback");
    if (paramEIPCResult.data == null)
    {
      this.a.fail();
      return;
    }
    paramEIPCResult = paramEIPCResult.data.getString("data");
    if (TextUtils.isEmpty(paramEIPCResult))
    {
      this.a.fail("empty data!");
      return;
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramEIPCResult).optJSONObject("infos");
      if (localJSONObject2 == null)
      {
        this.a.fail("empty infos!");
        return;
      }
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject1 = localJSONObject2.optJSONObject("base_info");
      String str;
      if (localObject1 != null)
      {
        paramEIPCResult = ((JSONObject)localObject1).optString("nick");
        str = localJSONObject2.optString("avatar");
        int i = ((JSONObject)localObject1).optInt("gender");
        localObject1 = ((JSONObject)localObject1).optString("constellation");
        localJSONObject1.put("nick", paramEIPCResult);
        localJSONObject1.put("avatar", str);
        localJSONObject1.put("gender", i);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramEIPCResult = (Integer)ExpandPlugin.a().get(localObject1);
          if (paramEIPCResult != null) {
            localJSONObject1.put("constellation", paramEIPCResult);
          }
        }
      }
      paramEIPCResult = localJSONObject2.optJSONObject("expand_info");
      if (paramEIPCResult != null)
      {
        str = paramEIPCResult.optString("declarationa");
        localObject1 = paramEIPCResult.optString("voice_url");
        long l = paramEIPCResult.optLong("voice_duration");
        Object localObject2 = paramEIPCResult.optString("voice_color");
        paramEIPCResult = "";
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramEIPCResult = new StringBuilder();
          paramEIPCResult.append("#");
          paramEIPCResult.append((String)localObject2);
          paramEIPCResult = String.format("%08X", new Object[] { Integer.valueOf(Color.parseColor(paramEIPCResult.toString()) & 0xFFFFFFFF) });
          localObject2 = new StringBuilder("#");
          ((StringBuilder)localObject2).append(paramEIPCResult.substring(2));
          ((StringBuilder)localObject2).append(paramEIPCResult.substring(0, 2));
          paramEIPCResult = ((StringBuilder)localObject2).toString();
        }
        localJSONObject1.put("declaration", str);
        localJSONObject1.put("voice", localObject1);
        localJSONObject1.put("voiceDuration", l);
        localJSONObject1.put("voiceColor", paramEIPCResult);
      }
      paramEIPCResult = localJSONObject2.optJSONArray("selected_pic");
      if (paramEIPCResult != null) {
        localJSONObject1.put("pictureWallPictures", paramEIPCResult);
      }
      this.a.ok(localJSONObject1);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      this.a.fail(paramEIPCResult.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.ExpandPlugin.1
 * JD-Core Version:    0.7.0.1
 */