package com.tencent.ttpic.openapi.filter;

public class VideoFilterListExtension
{
  private static VideoFilterListExtension.CreateExternalFiltersListener createExternalFiltersListener;
  
  public static VideoFilterListExtension.CreateExternalFiltersListener getCreateExternalFiltersListener()
  {
    return createExternalFiltersListener;
  }
  
  public static void setCreateExternalFiltersListener(VideoFilterListExtension.CreateExternalFiltersListener paramCreateExternalFiltersListener)
  {
    createExternalFiltersListener = paramCreateExternalFiltersListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterListExtension
 * JD-Core Version:    0.7.0.1
 */