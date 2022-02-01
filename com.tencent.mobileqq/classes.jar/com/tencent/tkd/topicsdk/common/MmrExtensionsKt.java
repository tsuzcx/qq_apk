package com.tencent.tkd.topicsdk.common;

import android.media.MediaMetadataRetriever;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "setDataResourceSafely", "Landroid/media/MediaMetadataRetriever;", "filePath", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class MmrExtensionsKt
{
  @Nullable
  public static final MediaMetadataRetriever a(@NotNull MediaMetadataRetriever paramMediaMetadataRetriever, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaMetadataRetriever, "$this$setDataResourceSafely");
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    try
    {
      paramMediaMetadataRetriever.setDataSource(paramString);
      return paramMediaMetadataRetriever;
    }
    catch (IOException paramMediaMetadataRetriever)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e: ");
      localStringBuilder.append(paramMediaMetadataRetriever);
      Log.e("MmrExtensions", localStringBuilder.toString());
      return null;
    }
    catch (FileNotFoundException paramMediaMetadataRetriever)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e: ");
      localStringBuilder.append(paramMediaMetadataRetriever);
      Log.e("MmrExtensions", localStringBuilder.toString());
      return null;
    }
    catch (IllegalArgumentException paramMediaMetadataRetriever)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e: ");
      localStringBuilder.append(paramMediaMetadataRetriever);
      Log.e("MmrExtensions", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.MmrExtensionsKt
 * JD-Core Version:    0.7.0.1
 */