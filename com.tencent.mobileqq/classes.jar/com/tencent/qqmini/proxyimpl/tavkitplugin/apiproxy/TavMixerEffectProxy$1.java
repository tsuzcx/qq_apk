package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import org.json.JSONObject;

class TavMixerEffectProxy$1
  implements ObjConvector.ObjToJsonConvector<BaseEffectNode>
{
  TavMixerEffectProxy$1(TavMixerEffectProxy paramTavMixerEffectProxy) {}
  
  public JSONObject a(BaseEffectNode paramBaseEffectNode)
  {
    return ObjConvector.a(paramBaseEffectNode, TavObjPool.a().a(paramBaseEffectNode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffectProxy.1
 * JD-Core Version:    0.7.0.1
 */