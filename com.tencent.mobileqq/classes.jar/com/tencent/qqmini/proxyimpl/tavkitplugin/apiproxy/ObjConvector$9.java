package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import org.json.JSONObject;

final class ObjConvector$9
  implements ObjConvector.JsonToObjConvector<E>
{
  ObjConvector$9(Class paramClass) {}
  
  public E b(JSONObject paramJSONObject)
  {
    paramJSONObject = ObjConvector.a(paramJSONObject);
    if ((paramJSONObject != null) && (this.a.isAssignableFrom(paramJSONObject.getClass()))) {
      return paramJSONObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.ObjConvector.9
 * JD-Core Version:    0.7.0.1
 */