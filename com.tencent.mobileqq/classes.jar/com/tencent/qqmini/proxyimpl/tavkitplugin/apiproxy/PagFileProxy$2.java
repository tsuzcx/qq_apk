package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import org.json.JSONObject;

class PagFileProxy$2
  implements ObjConvector.JsonToObjConvector<TAVStickerTextItem>
{
  PagFileProxy$2(PagFileProxy paramPagFileProxy, TAVSticker paramTAVSticker) {}
  
  public TAVStickerTextItem a(JSONObject paramJSONObject)
  {
    return ObjConvector.a(paramJSONObject, this.a.getStickerTextItems());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFileProxy.2
 * JD-Core Version:    0.7.0.1
 */