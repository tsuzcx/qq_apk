package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class BridgeModule$16
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  BridgeModule$16(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    BridgeModule.access$1600(this.b, 0L, paramList, this.a, 0, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.16
 * JD-Core Version:    0.7.0.1
 */