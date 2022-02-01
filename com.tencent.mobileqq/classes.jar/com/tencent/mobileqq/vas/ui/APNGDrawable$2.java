package com.tencent.mobileqq.vas.ui;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/image/URLDrawable;", "invoke"}, k=3, mv={1, 1, 16})
final class APNGDrawable$2
  extends Lambda
  implements Function0<URLDrawable>
{
  APNGDrawable$2(String paramString1, ApngOptions paramApngOptions, String paramString2)
  {
    super(0);
  }
  
  @Nullable
  public final URLDrawable invoke()
  {
    return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.$urlStr, this.$options, this.$filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.APNGDrawable.2
 * JD-Core Version:    0.7.0.1
 */