package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

final class ObjConvector$8
  implements ObjConvector.ObjToJsonConvector
{
  public JSONObject a(@NotNull Object paramObject)
  {
    return ObjConvector.a(paramObject, TavObjPool.a().a(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.ObjConvector.8
 * JD-Core Version:    0.7.0.1
 */