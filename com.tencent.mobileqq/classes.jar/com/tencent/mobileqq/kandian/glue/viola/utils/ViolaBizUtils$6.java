package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$6
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$6(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty())
    {
      ViolaBizUtils.a(this.a, this.b, paramList, this.c, 0, "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(ViolaBizUtils.a, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.6
 * JD-Core Version:    0.7.0.1
 */