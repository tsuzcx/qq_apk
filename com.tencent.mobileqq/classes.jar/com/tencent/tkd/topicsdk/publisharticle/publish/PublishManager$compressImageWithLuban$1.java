package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.imagecompress.OnCompressListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$compressImageWithLuban$1", "Lcom/tencent/tkd/topicsdk/imagecompress/OnCompressListener;", "onError", "", "e", "", "onStart", "onSuccess", "file", "Ljava/io/File;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$compressImageWithLuban$1
  implements OnCompressListener
{
  PublishManager$compressImageWithLuban$1(ImageInfo paramImageInfo, Function0 paramFunction0, PublishStage paramPublishStage, GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo) {}
  
  public void a()
  {
    TLog.a("PublishManager", "图片开始压缩");
  }
  
  public void a(@Nullable File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("图片压缩成功, 压缩前 size:");
    long l1 = this.a.getSize();
    long l2 = 1024;
    ((StringBuilder)localObject).append(l1 / l2);
    ((StringBuilder)localObject).append("kb, ");
    ((StringBuilder)localObject).append("压缩后 size:");
    if (paramFile != null) {
      l1 = paramFile.length();
    } else {
      l1 = 0L;
    }
    ((StringBuilder)localObject).append(l1 / l2);
    ((StringBuilder)localObject).append("kb");
    TLog.a("PublishManager", ((StringBuilder)localObject).toString());
    ImageInfo localImageInfo = this.a;
    if (paramFile != null)
    {
      localObject = paramFile.getAbsolutePath();
      if (localObject != null) {}
    }
    else
    {
      localObject = localImageInfo.getFilePath();
    }
    localImageInfo.setFilePath((String)localObject);
    if (paramFile != null) {
      l1 = paramFile.length();
    } else {
      l1 = localImageInfo.getSize();
    }
    localImageInfo.setSize(l1);
    boolean bool;
    if (paramFile != null) {
      bool = true;
    } else {
      bool = false;
    }
    localImageInfo.setHasCompressed(bool);
    PublishManager.a.a();
    this.b.invoke();
  }
  
  public void a(@Nullable Throwable paramThrowable)
  {
    TLog.d("PublishManager", "图片压缩失败");
    TopicSDKHelperKt.a("图片压缩失败");
    PublishManager.a(PublishManager.a, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressImageWithLuban.1
 * JD-Core Version:    0.7.0.1
 */