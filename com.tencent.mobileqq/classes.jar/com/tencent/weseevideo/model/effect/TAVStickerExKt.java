package com.tencent.weseevideo.model.effect;

import android.os.Bundle;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "extraFontId", "Lcom/tencent/tavsticker/model/TAVSticker;", "getExtraFontId", "(Lcom/tencent/tavsticker/model/TAVSticker;)Ljava/lang/String;", "setExtraFontId", "(Lcom/tencent/tavsticker/model/TAVSticker;Ljava/lang/String;)V", "extraMaterialId", "getExtraMaterialId", "setExtraMaterialId", "extraStickerType", "getExtraStickerType", "setExtraStickerType", "extraSubCategory", "getExtraSubCategory", "setExtraSubCategory", "reportLocation", "getReportLocation", "reportStickerType", "", "getReportStickerType", "(Lcom/tencent/tavsticker/model/TAVSticker;)I", "reportTextColor", "getReportTextColor", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class TAVStickerExKt
{
  @Nullable
  public static final String getExtraFontId(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraFontId");
    return paramTAVSticker.getExtraBundle().getString("key_extra_text_font_id");
  }
  
  @Nullable
  public static final String getExtraMaterialId(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraMaterialId");
    return paramTAVSticker.getExtraBundle().getString("key_extra_material_id");
  }
  
  @Nullable
  public static final String getExtraStickerType(@Nullable TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker = paramTAVSticker.getExtraBundle();
      if (paramTAVSticker != null) {
        return paramTAVSticker.getString("key_extra_sticker_type");
      }
    }
    return null;
  }
  
  @Nullable
  public static final String getExtraSubCategory(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraSubCategory");
    return paramTAVSticker.getExtraBundle().getString("key_extra_sub_category");
  }
  
  @NotNull
  public static final String getReportLocation(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$reportLocation");
    StringBuilder localStringBuilder = new StringBuilder().append('(');
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(paramTAVSticker.getCenterX());
    localObject = String.format("%.3f", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    localStringBuilder = localStringBuilder.append((String)localObject).append(',');
    localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(paramTAVSticker.getCenterY());
    paramTAVSticker = String.format("%.3f", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(paramTAVSticker, "java.lang.String.format(format, *args)");
    return paramTAVSticker + ')';
  }
  
  public static final int getReportStickerType(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$reportStickerType");
    if (Intrinsics.areEqual(getExtraStickerType(paramTAVSticker), "sticker_plaintext")) {
      return 1;
    }
    if (Intrinsics.areEqual(getExtraStickerType(paramTAVSticker), "sticker_art_text")) {
      return 2;
    }
    return 0;
  }
  
  @Nullable
  public static final String getReportTextColor(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$reportTextColor");
    String str = getExtraStickerType(paramTAVSticker);
    if (str != null)
    {
      if ((Intrinsics.areEqual(str, "sticker_plaintext") ^ true)) {
        return "";
      }
    }
    else {
      return "";
    }
    paramTAVSticker = paramTAVSticker.getStickerTextItems();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVSticker, "stickerTextItems");
    paramTAVSticker = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)paramTAVSticker);
    if (paramTAVSticker != null) {
      return Integer.toHexString(paramTAVSticker.getTextColor());
    }
    return "";
  }
  
  public static final void setExtraFontId(@NotNull TAVSticker paramTAVSticker, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraFontId");
    paramTAVSticker.getExtraBundle().putString("key_extra_text_font_id", paramString);
  }
  
  public static final void setExtraMaterialId(@NotNull TAVSticker paramTAVSticker, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraMaterialId");
    paramTAVSticker.getExtraBundle().putString("key_extra_material_id", paramString);
  }
  
  public static final void setExtraStickerType(@Nullable TAVSticker paramTAVSticker, @Nullable String paramString)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker = paramTAVSticker.getExtraBundle();
      if (paramTAVSticker != null) {
        paramTAVSticker.putString("key_extra_sticker_type", paramString);
      }
    }
  }
  
  public static final void setExtraSubCategory(@NotNull TAVSticker paramTAVSticker, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "$this$extraSubCategory");
    paramTAVSticker.getExtraBundle().putString("key_extra_sub_category", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.TAVStickerExKt
 * JD-Core Version:    0.7.0.1
 */