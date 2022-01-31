package com.tencent.thumbplayer.api;

public class TPTrackInfo
{
  public static final int TP_MEDIA_TRACK_TYPE_AUDIO = 2;
  public static final int TP_MEDIA_TRACK_TYPE_SUBTITLE = 3;
  public static final int TP_MEDIA_TRACK_TYPE_UNKNOW = 0;
  public static final int TP_MEDIA_TRACK_TYPE_VIDEO = 1;
  public boolean isExclusive;
  public boolean isInternal;
  public boolean isSelected;
  public String name;
  public int trackType;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TPTrackInfo))) {
      return false;
    }
    return (this.name.equals(((TPTrackInfo)paramObject).name)) && (this.trackType == ((TPTrackInfo)paramObject).trackType);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getTrackType()
  {
    return this.trackType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPTrackInfo
 * JD-Core Version:    0.7.0.1
 */