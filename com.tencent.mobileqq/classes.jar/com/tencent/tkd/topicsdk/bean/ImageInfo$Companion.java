package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/ImageInfo$Companion;", "", "()V", "serialVersionUID", "", "parseFromDisplayItem", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ImageInfo$Companion
{
  @NotNull
  public final ImageInfo a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.setFilePath(paramDisplayItem.getMedia().getFilePath());
    localImageInfo.setWidth(paramDisplayItem.getMedia().getWidth());
    localImageInfo.setHeight(paramDisplayItem.getMedia().getHeight());
    localImageInfo.setSize(paramDisplayItem.getMedia().getSize());
    return localImageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.ImageInfo.Companion
 * JD-Core Version:    0.7.0.1
 */