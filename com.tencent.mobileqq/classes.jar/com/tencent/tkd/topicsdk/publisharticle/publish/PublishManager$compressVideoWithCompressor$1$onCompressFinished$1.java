package com.tencent.tkd.topicsdk.publisharticle.publish;

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
final class PublishManager$compressVideoWithCompressor$1$onCompressFinished$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideoWithCompressor$1$onCompressFinished$1(PublishManager.compressVideoWithCompressor.1 param1, String paramString, boolean paramBoolean)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str1 = MD5.a(new File(this.$outPath));
    Object localObject = "";
    if (str1 == null) {
      str1 = "";
    }
    String str2 = SHA1Util.a(this.$outPath);
    if (str2 != null) {
      localObject = str2;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SHA1Util.getSHA1(outPath) ?: \"\"");
    ThreadManagerKt.a((Function0)new PublishManager.compressVideoWithCompressor.1.onCompressFinished.1.1(this, str1, (String)localObject));
    PublishManager.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressVideoWithCompressor.1.onCompressFinished.1
 * JD-Core Version:    0.7.0.1
 */