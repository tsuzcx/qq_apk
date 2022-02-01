package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;

public abstract interface VideoFilterListExtension$CreateExternalFiltersListener
{
  public abstract VideoFilterBase createBigHeadFilter(VideoMaterial paramVideoMaterial);
  
  public abstract BuckleFaceFilter createBuckleFaceFilter(VideoMaterial paramVideoMaterial);
  
  public abstract VideoFilterBase createNonFit2DFilter(VideoMaterial paramVideoMaterial);
  
  public abstract StaticStickerFilter createPanoramicFilter(StickerItem paramStickerItem, String paramString);
  
  public abstract void createQQGestureVideoFilterList(VideoMaterial paramVideoMaterial, List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterListExtension.CreateExternalFiltersListener
 * JD-Core Version:    0.7.0.1
 */