package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent;

public class TPRichMediaFeatureData$TPRichMediaFeatureContent
{
  private String mContent = "";
  private long mEndTimeMs = -1L;
  private long mStartTimeMs = -1L;
  
  TPRichMediaFeatureData$TPRichMediaFeatureContent(TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent paramTPNativeRichMediaFeatureContent)
  {
    this.mStartTimeMs = paramTPNativeRichMediaFeatureContent.getStartTimeMs();
    this.mEndTimeMs = paramTPNativeRichMediaFeatureContent.getEndTimeMs();
    this.mContent = paramTPNativeRichMediaFeatureContent.getContent();
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public long getEndTimeMs()
  {
    return this.mEndTimeMs;
  }
  
  public long getStartTimeMs()
  {
    return this.mStartTimeMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData.TPRichMediaFeatureContent
 * JD-Core Version:    0.7.0.1
 */