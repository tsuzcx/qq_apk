package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.MD5;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1$2
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideo$1$2(PublishManager.compressVideo.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = MD5.a(new File(this.this$0.a.getFilePath()));
    if (str != null) {}
    for (;;)
    {
      ThreadManagerKt.a((Function0)new PublishManager.compressVideo.1.2.1(this, str));
      return;
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressVideo.1.2
 * JD-Core Version:    0.7.0.1
 */