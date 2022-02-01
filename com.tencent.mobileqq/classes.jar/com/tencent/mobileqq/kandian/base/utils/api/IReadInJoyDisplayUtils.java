package com.tencent.mobileqq.kandian.base.utils.api;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDisplayUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "configImage", "", "imageView", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "picUrl", "Ljava/net/URL;", "context", "Landroid/content/Context;", "blackPlaceHolder", "", "getDisplayDuration", "", "duration", "", "getReadinjoyFeedsBigPictureSize", "Landroid/util/Pair;", "getReadinjoyFeedsSmallPictureSize", "shouldShowPlaceHolder", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyDisplayUtils
  extends QRouteApi
{
  public static final IReadInJoyDisplayUtils.Companion Companion = IReadInJoyDisplayUtils.Companion.a;
  @NotNull
  public static final String ELLIPSIZE_END_CHAR = "…";
  
  public abstract void configImage(@Nullable KandianUrlImageView paramKandianUrlImageView, @Nullable URL paramURL, @Nullable Context paramContext);
  
  public abstract void configImage(@Nullable KandianUrlImageView paramKandianUrlImageView, @Nullable URL paramURL, @Nullable Context paramContext, boolean paramBoolean);
  
  @Nullable
  public abstract String getDisplayDuration(int paramInt);
  
  @Nullable
  public abstract Pair<Integer, Integer> getReadinjoyFeedsBigPictureSize();
  
  @Nullable
  public abstract Pair<Integer, Integer> getReadinjoyFeedsSmallPictureSize();
  
  public abstract boolean shouldShowPlaceHolder(@Nullable Context paramContext, @Nullable URL paramURL);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
 * JD-Core Version:    0.7.0.1
 */