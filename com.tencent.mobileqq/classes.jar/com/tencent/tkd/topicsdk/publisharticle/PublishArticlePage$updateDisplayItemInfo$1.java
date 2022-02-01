package com.tencent.tkd.topicsdk.publisharticle;

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
    for (int i = 0;; i = 1) {
      for (;;)
      {
        int k;
        try
        {
          Object localObject3 = new MediaMetadataRetriever();
          Object localObject1 = MmrExtensionsKt.a((MediaMetadataRetriever)localObject3, this.$item.getRealPath());
          if (localObject1 == null) {
            break label333;
          }
          int j;
          if (Build.VERSION.SDK_INT >= 17)
          {
            localObject3 = ((MediaMetadataRetriever)localObject3).extractMetadata(24);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "mmr.extractMetadata(Medi…ADATA_KEY_VIDEO_ROTATION)");
            j = Integer.parseInt((String)localObject3);
            if ((j == 90) || (j == 270)) {
              break;
            }
            localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "extractMetadata(MediaMet…METADATA_KEY_VIDEO_WIDTH)");
            j = Integer.parseInt((String)localObject3);
            localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "extractMetadata(MediaMet…ETADATA_KEY_VIDEO_HEIGHT)");
            k = Integer.parseInt((String)localObject3);
            if (i != 0)
            {
              this.$item.getMedia().setWidth(k);
              this.$item.getMedia().setHeight(j);
              localObject3 = ((MediaMetadataRetriever)localObject1).getFrameAtTime();
              String str = TopicSDKHelperKt.b() + System.currentTimeMillis() + ".jpg";
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "firstFrame");
              new SavePicTask((Bitmap)localObject3, str).a();
              TLog.d("PublishArticleFragment", "更新displayItem信息, coverPath = " + str);
              this.$item.setCoverPath(str);
              this.$item.getMedia().setSize(FileUtils.a.a(this.$item.getRealPath()));
              ((MediaMetadataRetriever)localObject1).release();
              localObject1 = Unit.INSTANCE;
              if (localObject1 != null) {
                return;
              }
              ThreadManagerKt.a((Function0)PublishArticlePage.updateDisplayItemInfo.1.2.1.INSTANCE);
            }
          }
          else
          {
            TLog.d("PublishArticleFragment", "checkAndSetExifResolution can't get rotation...");
            continue;
          }
          this.$item.getMedia().setWidth(j);
        }
        catch (RuntimeException localRuntimeException)
        {
          TLog.a("PublishArticleFragment", (Throwable)localRuntimeException);
          return;
        }
        this.$item.getMedia().setHeight(k);
        continue;
        label333:
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.updateDisplayItemInfo.1
 * JD-Core Version:    0.7.0.1
 */