package com.tencent.qqmini.proxyimpl.tavkitplugin;

import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavProxyManager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class SendMsgTavEvent
  extends BaseTavEvent
{
  private Object a;
  
  SendMsgTavEvent(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject.has("className"))
    {
      a(paramJSONObject.getString("className"));
      return;
    }
    if (paramJSONObject.has("tavobject"))
    {
      paramJSONObject = a(paramJSONObject);
      this.a = TavObjPool.a().a(paramJSONObject);
      a(TavProxyManager.a(this.a.getClass().getName()));
      return;
    }
    throw new RuntimeException("send msg but no object");
  }
  
  @Nullable
  public Object a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent
 * JD-Core Version:    0.7.0.1
 */