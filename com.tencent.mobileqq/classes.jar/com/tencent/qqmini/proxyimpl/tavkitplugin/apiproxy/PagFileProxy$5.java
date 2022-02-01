package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import org.json.JSONObject;

class PagFileProxy$5
  implements ObjConvector.JsonToObjConvector<TAVStickerImageItem>
{
  PagFileProxy$5(PagFileProxy paramPagFileProxy, TAVSticker paramTAVSticker) {}
  
  public TAVStickerImageItem a(JSONObject paramJSONObject)
  {
    return ObjConvector.a(paramJSONObject, this.jdField_a_of_type_ComTencentTavstickerModelTAVSticker.getStickerImageItems());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFileProxy.5
 * JD-Core Version:    0.7.0.1
 */