package com.tencent.richmediabrowser.model.video;

import android.graphics.drawable.Drawable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class VideoData
  extends RichMediaBaseData
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new VideoData.1();
  public Drawable coverDrawable;
  public String coverUrl;
  public int errorCode;
  public String errorDescription;
  public boolean isAutoPlay = false;
  public boolean isMutePlay = false;
  public VideoPlayParam videoPlayParam;
  
  public int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.video.VideoData
 * JD-Core Version:    0.7.0.1
 */