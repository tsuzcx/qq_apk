package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import java.util.List;
import java.util.Map;

class PreloadImgApiImpl$2
  implements IPreloadService.OnGetPathListener
{
  PreloadImgApiImpl$2(PreloadImgApiImpl paramPreloadImgApiImpl, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    List localList = (List)PreloadImgApiImpl.access$100(this.b).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip"))
    {
      PreloadImgApiImpl.access$200(this.b, this.a, paramPathResult.url, paramPathResult.folderPath, localList);
      return;
    }
    if (paramPathResult.url.endsWith(".png")) {
      PreloadImgApiImpl.access$300(this.b, this.a, paramPathResult.url, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.2
 * JD-Core Version:    0.7.0.1
 */