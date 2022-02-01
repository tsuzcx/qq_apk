package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryCallback;

class EmoticonPanelServiceImpl$1
  implements QueryCallback<EmoticonPackage>
{
  EmoticonPanelServiceImpl$1(EmoticonPanelServiceImpl paramEmoticonPanelServiceImpl, String paramString) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      URLDrawable.removeMemoryCacheByUrl(this.val$key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonPanelServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */