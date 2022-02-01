package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class WebSsoJsPlugin
  extends BaseJsPlugin
  implements WadlCmdListener
{
  private int jdField_a_of_type_Int = 0;
  SparseArray<RequestEvent> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public WebSsoJsPlugin()
  {
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  private int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("WebSsoJsPlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public HashSet<String> getFilterCmds()
  {
    WadlCommConfig localWadlCommConfig = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
    if (localWadlCommConfig != null) {
      return localWadlCommConfig.a();
    }
    return GameCenterUtil.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("mini_seq", -1);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    RequestEvent localRequestEvent = (RequestEvent)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    if (localRequestEvent == null) {
      return;
    }
    paramIntent = paramJSONObject;
    if (paramJSONObject == null) {
      paramIntent = new JSONObject();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("cmd", paramString);
      paramJSONObject.put("ret", paramLong);
      paramJSONObject.put("rsp", paramIntent);
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    if (paramLong == 0L)
    {
      localRequestEvent.ok(paramJSONObject);
      return;
    }
    localRequestEvent.fail(paramJSONObject, "");
  }
  
  @JsEvent({"requestWebSSO"})
  public void requestWebSSO(RequestEvent paramRequestEvent)
  {
    label150:
    try
    {
      Object localObject1 = a(paramRequestEvent);
      if (localObject1 == null) {
        break label150;
      }
      JSONObject localJSONObject = ((JSONObject)localObject1).getJSONObject("data");
      localObject1 = localJSONObject.getString("webssoCmdId");
      localJSONObject = localJSONObject.getJSONObject("webssoReq");
      Object localObject2 = getFilterCmds();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (((HashSet)localObject2).contains(localObject1)))
      {
        int i = a();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramRequestEvent);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("mini_seq", i);
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso((String)localObject1, localJSONObject, (Bundle)localObject2);
        return;
      }
      paramRequestEvent.fail(HardCodeUtil.a(2131716369));
      return;
    }
    catch (Throwable localThrowable)
    {
      label126:
      break label126;
    }
    paramRequestEvent.fail(HardCodeUtil.a(2131716368));
    if (QLog.isColorLevel()) {
      QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WebSsoJsPlugin
 * JD-Core Version:    0.7.0.1
 */