package com.tencent.mobileqq.kandian.biz.video.danmaku.model;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJDanmakuModel$requestData$1
  implements Runnable
{
  RIJDanmakuModel$requestData$1(RIJDanmakuModel paramRIJDanmakuModel, String paramString) {}
  
  public final void run()
  {
    RIJDanmakuHandler localRIJDanmakuHandler = RIJDanmakuModel.a(this.this$0);
    RIJDanmakuModel localRIJDanmakuModel = this.this$0;
    String str = this.a;
    int i = RIJDanmakuModel.b(localRIJDanmakuModel);
    int j = RIJDanmakuModel.b(this.this$0);
    localRIJDanmakuHandler.a(localRIJDanmakuModel, str, i, RIJDanmakuModel.c(this.this$0) + j, RIJDanmakuModel.d(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel.requestData.1
 * JD-Core Version:    0.7.0.1
 */