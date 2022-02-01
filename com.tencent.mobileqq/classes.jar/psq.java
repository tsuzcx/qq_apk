import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageTypeOptHelper;", "", "()V", "SUFFIX_SHARPP", "", "getSUFFIX_SHARPP", "()Ljava/lang/String;", "SUFFIX_WEBP", "getSUFFIX_WEBP", "TAG", "getTAG", "TYPE_SHARPP", "getTYPE_SHARPP", "TYPE_WEBP", "getTYPE_WEBP", "converToOptImageUrl", "", "imageRequest", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "originUrl", "convertBackToOriginUrl", "url", "originType", "convertToOptTypeUrl", "convertUrlToOtherType", "type", "decodeSharpP", "Landroid/graphics/Bitmap;", "filePath", "width", "", "height", "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "getTpType", "isSharpP", "", "isWebp", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class psq
{
  @NotNull
  private static final String a = "RIJImageSharpHelper";
  public static final psq a;
  @NotNull
  private static final String b = "sharp";
  @NotNull
  private static final String c = "webp";
  @NotNull
  private static final String d = "tp=sharp";
  @NotNull
  private static final String e = "tp=webp";
  
  static
  {
    jdField_a_of_type_Psq = new psq();
    jdField_a_of_type_JavaLangString = "RIJImageSharpHelper";
  }
  
  @Nullable
  public final Bitmap a(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return new psr().a(paramString, paramInt1, paramInt2, Bitmap.Config.ARGB_8888, paramBitmap);
  }
  
  @NotNull
  public final BitmapFactory.Options a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return new psr().a(paramString);
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"fmt=gif", false, 2, null)) {}
    do
    {
      return paramString;
      if (psn.a.f()) {
        return a(paramString, c);
      }
    } while ((!psn.a.g()) || (!bjkq.a((Context)BaseApplicationImpl.context)));
    return a(paramString, b);
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "type");
    Object localObject = bjnd.a(paramString1);
    if (((Map)localObject).containsKey("tp"))
    {
      localObject = (String)((Map)localObject).get("tp");
      return StringsKt.replace$default(paramString1, "tp=" + (String)localObject, "tp=" + paramString2, false, 4, null);
    }
    if (((Map)localObject).size() > 0) {
      return paramString1 + "&tp=" + paramString2;
    }
    return paramString1 + "?tp=" + paramString2;
  }
  
  public final void a(@NotNull syo paramsyo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramsyo, "imageRequest");
    Intrinsics.checkParameterIsNotNull(paramString, "originUrl");
    try
    {
      paramsyo.c = b(paramString);
      paramsyo.a = new URL(a(paramString));
      return;
    }
    catch (Exception paramsyo)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramsyo.getMessage());
    }
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    return StringsKt.contains$default((CharSequence)paramString, (CharSequence)d, false, 2, null);
  }
  
  @Nullable
  public final String b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = bjnd.a(paramString);
    if (paramString.containsKey("tp")) {
      return (String)paramString.get("tp");
    }
    return "";
  }
  
  @NotNull
  public final String b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "originType");
    Object localObject = bjnd.a(paramString1);
    String str = paramString1;
    if (((Map)localObject).containsKey("tp"))
    {
      localObject = (String)((Map)localObject).get("tp");
      if (!c.equals(localObject))
      {
        str = paramString1;
        if (!b.equals(localObject)) {}
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)paramString2)) {
          break label129;
        }
        str = StringsKt.replace$default(paramString1, "tp=" + (String)localObject, "tp=" + paramString2, false, 4, null);
      }
    }
    return str;
    label129:
    paramString1 = bjnd.a(paramString1, "tp");
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "URLUtil.deleteParameter(url, \"tp\")");
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psq
 * JD-Core Version:    0.7.0.1
 */