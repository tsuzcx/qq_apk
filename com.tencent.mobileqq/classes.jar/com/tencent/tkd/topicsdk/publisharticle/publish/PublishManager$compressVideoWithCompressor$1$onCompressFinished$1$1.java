package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideoWithCompressor$1$onCompressFinished$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideoWithCompressor$1$onCompressFinished$1$1(PublishManager.compressVideoWithCompressor.1.onCompressFinished.1 param1, String paramString1, String paramString2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.this$0.$succeed)
    {
      TLog.a("PublishManager", "压缩成功");
      VideoInfo localVideoInfo = this.this$0.this$0.b;
      String str = this.this$0.$outPath;
      if (str == null) {
        str = "";
      }
      localVideoInfo.setCompressPath(str);
    }
    else
    {
      TLog.a("PublishManager", "压缩失败");
    }
    this.this$0.this$0.b.setFileMd5(this.$md5);
    this.this$0.this$0.b.setFileSha1(this.$sha1);
    int i;
    if (((CharSequence)this.this$0.this$0.b.getCompressPath()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.this$0.this$0.b.setFileSize(new File(this.this$0.this$0.b.getCompressPath()).length());
    }
    PublishManager.b(PublishManager.a, this.this$0.this$0.c, this.this$0.this$0.a, this.this$0.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressVideoWithCompressor.1.onCompressFinished.1.1
 * JD-Core Version:    0.7.0.1
 */