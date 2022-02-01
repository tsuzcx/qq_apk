package com.tencent.tkd.topicsdk.widget.videocrop;

import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.common.MmrExtensionsKt;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.merge.VideoTrimmer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropPresenter;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropContract$IPresenter;", "originVideoPath", "", "(Ljava/lang/String;)V", "<set-?>", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "displayItem", "getDisplayItem", "()Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "hasCancelVideoTrim", "", "maxVideoLength", "", "getMaxVideoLength", "()I", "setMaxVideoLength", "(I)V", "minVideoLength", "getMinVideoLength", "setMinVideoLength", "getOriginVideoPath", "()Ljava/lang/String;", "videoTrimmer", "Lcom/tencent/tkd/topicsdk/videoprocess/mediacodec/merge/VideoTrimmer;", "view", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropContract$IView;", "attachView", "", "detachView", "resetTrimmer", "setRangeTime", "startTime", "endTime", "startVideoCrop", "stopVideoCrop", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCropPresenter
  implements VideoCropContract.IPresenter
{
  public static final VideoCropPresenter.Companion a = new VideoCropPresenter.Companion(null);
  private int b;
  private int c;
  private VideoCropContract.IView d;
  @Nullable
  private DisplayItem e;
  private VideoTrimmer f;
  private boolean g;
  @NotNull
  private final String h;
  
  public VideoCropPresenter(@NotNull String paramString)
  {
    this.h = paramString;
    paramString = new DisplayItem(new Media(MediaType.VIDEO));
    paramString.getMedia().setFilePath(g());
    MediaMetadataRetriever localMediaMetadataRetriever = MmrExtensionsKt.a(new MediaMetadataRetriever(), g());
    if (localMediaMetadataRetriever != null)
    {
      String str = localMediaMetadataRetriever.extractMetadata(18);
      Intrinsics.checkExpressionValueIsNotNull(str, "extractMetadata(MediaMet…METADATA_KEY_VIDEO_WIDTH)");
      int j = Integer.parseInt(str);
      str = localMediaMetadataRetriever.extractMetadata(19);
      Intrinsics.checkExpressionValueIsNotNull(str, "extractMetadata(MediaMet…ETADATA_KEY_VIDEO_HEIGHT)");
      int k = Integer.parseInt(str);
      int i;
      if (Build.VERSION.SDK_INT >= 17)
      {
        str = localMediaMetadataRetriever.extractMetadata(24);
        Intrinsics.checkExpressionValueIsNotNull(str, "extractMetadata(MediaMet…ADATA_KEY_VIDEO_ROTATION)");
        i = Integer.parseInt(str);
      }
      else
      {
        i = 0;
      }
      if ((i != 90) && (i != 270))
      {
        paramString.getMedia().setHeight(k);
        paramString.getMedia().setWidth(j);
      }
      else
      {
        paramString.getMedia().setHeight(j);
        paramString.getMedia().setWidth(k);
      }
      localMediaMetadataRetriever.release();
      this.e = paramString;
    }
  }
  
  private final void h()
  {
    VideoTrimmer localVideoTrimmer = this.f;
    if (localVideoTrimmer != null) {
      localVideoTrimmer.a();
    }
    this.f = new VideoTrimmer();
  }
  
  public void a()
  {
    this.d = ((VideoCropContract.IView)null);
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DisplayItem localDisplayItem = this.e;
    if (localDisplayItem != null)
    {
      localDisplayItem.setStartMergeTime(paramInt1);
      localDisplayItem.setEndMergeTime(paramInt2);
    }
  }
  
  public void a(@NotNull VideoCropContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.d = paramIView;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  @Nullable
  public final DisplayItem d()
  {
    return this.e;
  }
  
  @RequiresApi(18)
  public void e()
  {
    this.g = false;
    h();
    long l = System.currentTimeMillis();
    Object localObject = this.d;
    if (localObject != null) {
      ((VideoCropContract.IView)localObject).a(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ThreadManagerKt.c((Function0)new VideoCropPresenter.startVideoCrop.1(this, (DisplayItem)localObject, l));
    }
  }
  
  public void f()
  {
    TLog.b("VideoCropPresenter", "View stop video crop.");
    VideoTrimmer localVideoTrimmer = this.f;
    if (localVideoTrimmer != null) {
      localVideoTrimmer.a();
    }
    this.g = true;
  }
  
  @NotNull
  public String g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPresenter
 * JD-Core Version:    0.7.0.1
 */