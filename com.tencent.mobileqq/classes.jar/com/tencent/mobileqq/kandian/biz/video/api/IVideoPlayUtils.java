package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "calculateVideoPartSize", "", "timeSec", "", "duration", "fileSize", "getThumbUrl", "Ljava/net/URL;", "thumbPath", "", "makeErrorText", "model", "what", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPlayUtils
  extends QRouteApi
{
  public static final int AIO_PREVIEW_TIME_SECS = 8;
  public static final int AUTO_SCROLL_OFFSET_DP = 175;
  public static final long BUSI_LOADING_DELAY = 5000L;
  @NotNull
  public static final String BUSI_TYPE_KANDIAN_PLATFORM = "bus_type_kandian_feeds";
  @NotNull
  public static final String BUS_TYPE_FULL_SCREEN = "bus_type_full_screen";
  @NotNull
  public static final String BUS_TYPE_KANDIAN_FEEDS = "bus_type_kandian_feeds";
  public static final IVideoPlayUtils.Companion Companion = IVideoPlayUtils.Companion.a;
  @NotNull
  public static final String KEY_BUS_TYPE = "shouq_bus_type";
  @NotNull
  public static final String SERVER_TYPE_AIO_SHORT_VIDEO = "20160518";
  @NotNull
  public static final String SERVER_TYPE_KANDIAN_VIDEO = "20160519";
  public static final int SERVER_TYPE_KANDIAN_VIDEO_INT = 20160519;
  public static final long UI_LOADING_DELAY = 1200L;
  
  public abstract long calculateVideoPartSize(int paramInt1, int paramInt2, int paramInt3);
  
  @Nullable
  public abstract URL getThumbUrl(@Nullable String paramString);
  
  @Nullable
  public abstract String makeErrorText(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils
 * JD-Core Version:    0.7.0.1
 */