import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPDecoder;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageTypeOptHelper;", "", "()V", "SUFFIX_SHARPP", "", "getSUFFIX_SHARPP", "()Ljava/lang/String;", "SUFFIX_WEBP", "getSUFFIX_WEBP", "TAG", "getTAG", "TYPE_SHARPP", "getTYPE_SHARPP", "TYPE_WEBP", "getTYPE_WEBP", "converToOptImageUrl", "", "imageRequest", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "originUrl", "convertBackToOriginUrl", "url", "originType", "convertToOptTypeUrl", "convertUrlToOtherType", "type", "decodeSharpP", "Landroid/graphics/Bitmap;", "filePath", "getTpType", "isSharpP", "", "isWebp", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pux
{
  @NotNull
  private static final String a = "RIJImageSharpHelper";
  public static final pux a;
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
    jdField_a_of_type_Pux = new pux();
    jdField_a_of_type_JavaLangString = "RIJImageSharpHelper";
  }
  
  @Nullable
  public final Bitmap a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    SharpPDecoder localSharpPDecoder = new SharpPDecoder();
    int i = localSharpPDecoder.parseHeader(paramString);
    if (i != 0) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "status: " + i);
    }
    for (;;)
    {
      return null;
      i = localSharpPDecoder.getSharpPType();
      if ((3 != i) && (4 != i)) {
        try
        {
          paramString = localSharpPDecoder.decodeSharpP2PNG2(paramString, 4, 1000);
          return paramString;
        }
        catch (UnsatisfiedLinkError paramString)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "sharpP so link error, missing native method.");
          paramString.printStackTrace();
        }
      }
    }
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"fmt=gif", false, 2, null)) {}
    do
    {
      return paramString;
      if (puu.a.f()) {
        return a(paramString, c);
      }
    } while ((!puu.a.g()) || (!bkdi.a((Context)BaseApplicationImpl.context)));
    return a(paramString, b);
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "type");
    Object localObject = bkgj.a(paramString1);
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
  
  public final void a(@NotNull tdw paramtdw, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramtdw, "imageRequest");
    Intrinsics.checkParameterIsNotNull(paramString, "originUrl");
    try
    {
      paramtdw.c = b(paramString);
      paramtdw.a = new URL(a(paramString));
      return;
    }
    catch (Exception paramtdw)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramtdw.getMessage());
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
    paramString = bkgj.a(paramString);
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
    Object localObject = bkgj.a(paramString1);
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
    paramString1 = bkgj.a(paramString1, "tp");
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "URLUtil.deleteParameter(url, \"tp\")");
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pux
 * JD-Core Version:    0.7.0.1
 */