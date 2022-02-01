package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.common.MmrExtensionsKt;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.SavePicTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$updateDisplayItemInfo$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePage$updateDisplayItemInfo$1(DisplayItem paramDisplayItem)
  {
    super(0);
  }
  
  public final void invoke()
  {
    for (;;)
    {
      try
      {
        Object localObject3 = new MediaMetadataRetriever();
        Object localObject1 = MmrExtensionsKt.a((MediaMetadataRetriever)localObject3, this.$item.getRealPath());
        if (localObject1 == null) {
          break label363;
        }
        int j = Build.VERSION.SDK_INT;
        i = 0;
        if (j >= 17)
        {
          localObject3 = ((MediaMetadataRetriever)localObject3).extractMetadata(24);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "mmr.extractMetadata(Medi…ADATA_KEY_VIDEO_ROTATION)");
          j = Integer.parseInt((String)localObject3);
          if (j == 90) {
            break label358;
          }
          if (j == 270) {
            break label358;
          }
        }
        else
        {
          TLog.d("PublishArticleFragment", "checkAndSetExifResolution can't get rotation...");
        }
        localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "extractMetadata(MediaMet…METADATA_KEY_VIDEO_WIDTH)");
        j = Integer.parseInt((String)localObject3);
        localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "extractMetadata(MediaMet…ETADATA_KEY_VIDEO_HEIGHT)");
        int k = Integer.parseInt((String)localObject3);
        if (i != 0)
        {
          this.$item.getMedia().setWidth(k);
          this.$item.getMedia().setHeight(j);
        }
        else
        {
          this.$item.getMedia().setWidth(j);
          this.$item.getMedia().setHeight(k);
        }
        localObject3 = ((MediaMetadataRetriever)localObject1).getFrameAtTime();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(TopicSDKHelperKt.c());
        ((StringBuilder)localObject4).append(System.currentTimeMillis());
        ((StringBuilder)localObject4).append(".jpg");
        localObject4 = ((StringBuilder)localObject4).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "firstFrame");
        new SavePicTask((Bitmap)localObject3, (String)localObject4).a();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("更新displayItem信息, coverPath = ");
        ((StringBuilder)localObject3).append((String)localObject4);
        TLog.d("PublishArticleFragment", ((StringBuilder)localObject3).toString());
        this.$item.setCoverPath((String)localObject4);
        this.$item.getMedia().setSize(FileUtils.a.a(this.$item.getRealPath()));
        ((MediaMetadataRetriever)localObject1).release();
        localObject1 = Unit.INSTANCE;
        if (localObject1 == null)
        {
          ThreadManagerKt.a((Function0)PublishArticlePage.updateDisplayItemInfo.1.2.1.INSTANCE);
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        TLog.b("PublishArticleFragment", (Throwable)localRuntimeException);
      }
      return;
      label358:
      int i = 1;
      continue;
      label363:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.updateDisplayItemInfo.1
 * JD-Core Version:    0.7.0.1
 */