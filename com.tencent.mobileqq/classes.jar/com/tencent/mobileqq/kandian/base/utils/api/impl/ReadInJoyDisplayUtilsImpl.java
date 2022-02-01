package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyDisplayUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDisplayUtils;", "()V", "configImage", "", "imageView", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "picUrl", "Ljava/net/URL;", "context", "Landroid/content/Context;", "blackPlaceHolder", "", "getDisplayDuration", "", "duration", "", "getReadinjoyFeedsBigPictureSize", "Landroid/util/Pair;", "getReadinjoyFeedsSmallPictureSize", "shouldShowPlaceHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyDisplayUtilsImpl
  implements IReadInJoyDisplayUtils
{
  public void configImage(@Nullable KandianUrlImageView paramKandianUrlImageView, @Nullable URL paramURL, @Nullable Context paramContext)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramContext);
  }
  
  public void configImage(@Nullable KandianUrlImageView paramKandianUrlImageView, @Nullable URL paramURL, @Nullable Context paramContext, boolean paramBoolean)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramContext, paramBoolean);
  }
  
  @Nullable
  public String getDisplayDuration(int paramInt)
  {
    return ReadInJoyDisplayUtils.a(paramInt);
  }
  
  @Nullable
  public Pair<Integer, Integer> getReadinjoyFeedsBigPictureSize()
  {
    return ReadInJoyDisplayUtils.e();
  }
  
  @Nullable
  public Pair<Integer, Integer> getReadinjoyFeedsSmallPictureSize()
  {
    return ReadInJoyDisplayUtils.a();
  }
  
  public boolean shouldShowPlaceHolder(@Nullable Context paramContext, @Nullable URL paramURL)
  {
    return ReadInJoyDisplayUtils.a(paramContext, paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ReadInJoyDisplayUtilsImpl
 * JD-Core Version:    0.7.0.1
 */