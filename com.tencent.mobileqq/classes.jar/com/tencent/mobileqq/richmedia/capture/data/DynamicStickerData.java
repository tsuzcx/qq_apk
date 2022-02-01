package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicStickerData
{
  public static final String KEY_SEGMENTS_DATA = "segmentdata";
  public static final String TAG = "DynamicSticker";
  public PointF centerP;
  public String data;
  public int decodeFlag;
  public float height;
  public int layerHeight;
  public int layerWidth;
  public GifDecoder mGifDecoder;
  public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
  public Map<Long, TrackerStickerParam.MotionInfo> mapMotionTrack = new HashMap();
  public String path;
  public float rotate = 0.0F;
  public float scale = 1.0F;
  public float translateX = 0.0F;
  public float translateY = 0.0F;
  public int type;
  public float width;
  
  public boolean isShow(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isshow:");
    localStringBuilder.append(paramLong);
    SLog.d("DynamicSticker", localStringBuilder.toString());
    return this.mSegmentKeeper.isInSegment(paramLong);
  }
  
  public void setSegmentList(List<Pair<Long, Long>> paramList)
  {
    this.mSegmentKeeper.setSegmentList(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DynamicStickerData{");
    localStringBuilder.append("centerP=");
    localStringBuilder.append(this.centerP);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.scale);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(", translateX=");
    localStringBuilder.append(this.translateX);
    localStringBuilder.append(", translateY=");
    localStringBuilder.append(this.translateY);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", layerWidth=");
    localStringBuilder.append(this.layerWidth);
    localStringBuilder.append(", layerHeight=");
    localStringBuilder.append(this.layerHeight);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append(", decodeFlag=");
    localStringBuilder.append(this.decodeFlag);
    localStringBuilder.append(", mGifDecoder=");
    localStringBuilder.append(this.mGifDecoder);
    String str = this.mSegmentKeeper.toString();
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    else
    {
      localStringBuilder.append(",segments=null");
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData
 * JD-Core Version:    0.7.0.1
 */