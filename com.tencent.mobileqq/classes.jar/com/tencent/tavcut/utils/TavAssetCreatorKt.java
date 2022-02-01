package com.tencent.tavcut.utils;

import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "createURLAsset", "Lcom/tencent/tav/asset/URLAsset;", "filePath", "lib_tavcut_release"}, k=2, mv={1, 1, 16})
public final class TavAssetCreatorKt
{
  @Nullable
  public static final URLAsset a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setDataSource(paramString);
    ArrayList localArrayList = ExtractorUtils.getMediaFormats(localAssetExtractor);
    Intrinsics.checkExpressionValueIsNotNull(localArrayList, "ExtractorUtils.getMediaFormats(assetExtractor)");
    localAssetExtractor.release();
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new URLAsset(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.TavAssetCreatorKt
 * JD-Core Version:    0.7.0.1
 */