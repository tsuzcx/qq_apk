package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.MD5;
import com.tencent.tkd.topicsdk.common.SHA1Util;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideo$1$1(PublishManager.compressVideo.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str1 = MD5.a(new File(this.this$0.a.getFilePath()));
    Object localObject = "";
    if (str1 == null) {
      str1 = "";
    }
    String str2 = SHA1Util.a(this.this$0.a.getFilePath());
    if (str2 != null) {
      localObject = str2;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SHA1Util.getSHA1(videoInfo.filePath) ?: \"\"");
    ThreadManagerKt.a((Function0)new PublishManager.compressVideo.1.1.1(this, str1, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressVideo.1.1
 * JD-Core Version:    0.7.0.1
 */