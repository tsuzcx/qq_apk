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
  public static final VideoCropPresenter.Companion a;
  private int jdField_a_of_type_Int;
  @Nullable
  private DisplayItem jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
  private VideoTrimmer jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecMergeVideoTrimmer;
  private VideoCropContract.IView jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropContract$IView;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter$Companion = new VideoCropPresenter.Companion(null);
  }
  
  public VideoCropPresenter(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new DisplayItem(new Media(MediaType.VIDEO));
    paramString.getMedia().setFilePath(a());
    MediaMetadataRetriever localMediaMetadataRetriever = MmrExtensionsKt.a(new MediaMetadataRetriever(), a());
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
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem = paramString;
    }
  }
  
  private final void d()
  {
    VideoTrimmer localVideoTrimmer = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecMergeVideoTrimmer;
    if (localVideoTrimmer != null) {
      localVideoTrimmer.a();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecMergeVideoTrimmer = new VideoTrimmer();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final DisplayItem a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropContract$IView = ((VideoCropContract.IView)null);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DisplayItem localDisplayItem = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
    if (localDisplayItem != null)
    {
      localDisplayItem.setStartMergeTime(paramInt1);
      localDisplayItem.setEndMergeTime(paramInt2);
    }
  }
  
  public void a(@NotNull VideoCropContract.IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramIView, "view");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropContract$IView = paramIView;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @RequiresApi(18)
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    d();
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropContract$IView;
    if (localObject != null) {
      ((VideoCropContract.IView)localObject).a(true);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
    if (localObject != null) {
      ThreadManagerKt.c((Function0)new VideoCropPresenter.startVideoCrop.1(this, (DisplayItem)localObject, l));
    }
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c()
  {
    TLog.b("VideoCropPresenter", "View stop video crop.");
    VideoTrimmer localVideoTrimmer = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecMergeVideoTrimmer;
    if (localVideoTrimmer != null) {
      localVideoTrimmer.a();
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPresenter
 * JD-Core Version:    0.7.0.1
 */