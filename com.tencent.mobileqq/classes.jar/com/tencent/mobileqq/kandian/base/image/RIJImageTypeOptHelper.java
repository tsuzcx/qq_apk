package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig.DefaultImpls;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/RIJImageTypeOptHelper;", "", "()V", "SUFFIX_SHARPP", "", "getSUFFIX_SHARPP", "()Ljava/lang/String;", "SUFFIX_WEBP", "getSUFFIX_WEBP", "TAG", "getTAG", "TYPE_SHARPP", "getTYPE_SHARPP", "TYPE_WEBP", "getTYPE_WEBP", "converToOptImageUrl", "", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "originUrl", "convertBackToOriginUrl", "url", "originType", "convertToOptTypeUrl", "convertUrlToOtherType", "type", "decodeSharpP", "Landroid/graphics/Bitmap;", "filePath", "width", "", "height", "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "getTpType", "isSharpP", "", "isWebp", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJImageTypeOptHelper
{
  public static final RIJImageTypeOptHelper a = new RIJImageTypeOptHelper();
  @NotNull
  private static final String b = "RIJImageSharpHelper";
  @NotNull
  private static final String c = "sharp";
  @NotNull
  private static final String d = "webp";
  @NotNull
  private static final String e = "tp=sharp";
  @NotNull
  private static final String f = "tp=webp";
  
  @Nullable
  public final Bitmap a(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return IRIJImageOptConfig.DefaultImpls.a((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class), paramString, paramInt1, paramInt2, paramBitmap, null, 16, null);
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"fmt=gif", false, 2, null)) {
      return paramString;
    }
    if (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).useWebp()) {
      return a(paramString, d);
    }
    String str = paramString;
    if (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).useSharpP())
    {
      str = paramString;
      if (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isSharpPAvailable()) {
        str = a(paramString, c);
      }
    }
    return str;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "type");
    Object localObject = URLUtil.a(paramString1);
    if (((Map)localObject).containsKey("tp"))
    {
      localObject = (String)((Map)localObject).get("tp");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tp=");
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tp=");
      localStringBuilder.append(paramString2);
      return StringsKt.replace$default(paramString1, (String)localObject, localStringBuilder.toString(), false, 4, null);
    }
    if (((Map)localObject).size() > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("&tp=");
      ((StringBuilder)localObject).append(paramString2);
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("?tp=");
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
  }
  
  public final void a(@NotNull ImageRequest paramImageRequest, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "imageRequest");
    Intrinsics.checkParameterIsNotNull(paramString, "originUrl");
    try
    {
      paramImageRequest.w = c(paramString);
      paramImageRequest.a = new URL(a(paramString));
      return;
    }
    catch (Exception paramImageRequest)
    {
      QLog.d(b, 1, paramImageRequest.getMessage());
    }
  }
  
  @NotNull
  public final BitmapFactory.Options b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return ((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).decodeSharpPInBounds(paramString);
  }
  
  @NotNull
  public final String b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "originType");
    Object localObject2 = URLUtil.a(paramString1);
    Object localObject1 = paramString1;
    if (((Map)localObject2).containsKey("tp"))
    {
      localObject2 = (String)((Map)localObject2).get("tp");
      if (!d.equals(localObject2))
      {
        localObject1 = paramString1;
        if (!c.equals(localObject2)) {}
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)paramString2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tp=");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("tp=");
          ((StringBuilder)localObject2).append(paramString2);
          return StringsKt.replace$default(paramString1, (String)localObject1, ((StringBuilder)localObject2).toString(), false, 4, null);
        }
        localObject1 = URLUtil.a(paramString1, "tp");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "URLUtil.deleteParameter(url, \"tp\")");
      }
    }
    return localObject1;
  }
  
  @Nullable
  public final String c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = URLUtil.a(paramString);
    if (paramString.containsKey("tp")) {
      return (String)paramString.get("tp");
    }
    return "";
  }
  
  public final boolean d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    return StringsKt.contains$default((CharSequence)paramString, (CharSequence)e, false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper
 * JD-Core Version:    0.7.0.1
 */