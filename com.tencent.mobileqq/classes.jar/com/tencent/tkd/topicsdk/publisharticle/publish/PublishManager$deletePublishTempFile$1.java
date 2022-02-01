package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$deletePublishTempFile$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishManager$deletePublishTempFile$1()
  {
    super(0);
  }
  
  public final void invoke()
  {
    try
    {
      TLog.b("PublishManager", "deletePublishTempFile");
      File localFile = new File(TopicSDKHelperKt.e());
      FileUtils.a(FileUtils.a, localFile, false, 2, null);
      return;
    }
    catch (Exception localException)
    {
      TLog.b("PublishManager", "deletePublishTempFile exception", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.deletePublishTempFile.1
 * JD-Core Version:    0.7.0.1
 */