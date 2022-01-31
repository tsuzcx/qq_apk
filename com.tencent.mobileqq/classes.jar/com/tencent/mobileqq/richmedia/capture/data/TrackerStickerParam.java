package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackerStickerParam
{
  private static final String KEY_SEGMENTS_DATA = "segmentdata";
  public PointF centerP;
  public float height;
  public int layerHeight;
  public int layerWidth;
  public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
  public Map<Long, TrackerStickerParam.MotionInfo> mapMotionTrack = new HashMap();
  public String path;
  public float rotate;
  public float scale;
  public float translateXValue;
  public float translateYValue;
  public float width;
  
  public TrackerStickerParam() {}
  
  public TrackerStickerParam(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2, String paramString, Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    this.centerP = new PointF(paramFloat1, paramFloat2);
    this.scale = paramFloat3;
    this.rotate = paramFloat4;
    this.translateXValue = paramFloat5;
    this.translateYValue = paramFloat6;
    this.width = paramFloat7;
    this.height = paramFloat8;
    this.path = paramString;
    this.layerWidth = paramInt1;
    this.layerHeight = paramInt2;
    this.mapMotionTrack = paramMap;
  }
  
  public static ArrayList<TrackerStickerParam> FromString(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("TrackList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam();
          localTrackerStickerParam.FromJson(localJSONObject);
          localArrayList.add(localTrackerStickerParam);
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      SLog.e("TrackerStickerParam", "TrackList FromString" + paramString.toString());
    }
  }
  
  public static String ToJsonString(ArrayList<TrackerStickerParam> paramArrayList)
  {
    JSONArray localJSONArray = null;
    Object localObject = localJSONArray;
    if (paramArrayList != null)
    {
      localObject = localJSONArray;
      if (paramArrayList.size() > 0)
      {
        localObject = new JSONObject();
        localJSONArray = new JSONArray();
        int i = 0;
        while (i < paramArrayList.size())
        {
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)paramArrayList.get(i);
          if (localTrackerStickerParam != null) {
            localJSONArray.put(localTrackerStickerParam.toJSONObject());
          }
          i += 1;
        }
      }
    }
    try
    {
      ((JSONObject)localObject).put("TrackList", localJSONArray);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException paramArrayList)
    {
      for (;;)
      {
        SLog.e("TrackerStickerParam", "TrackList" + paramArrayList.toString());
      }
    }
  }
  
  public static Map<Long, TrackerStickerParam.MotionInfo> mapMotionFromJarray(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
            TrackerStickerParam.MotionInfo localMotionInfo = new TrackerStickerParam.MotionInfo(false, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
            localMotionInfo.isLost = localJSONObject.getBoolean("isLost");
            localMotionInfo.frameTime = localJSONObject.getLong("frameTime");
            localMotionInfo.x = ((float)localJSONObject.getDouble("motionX"));
            localMotionInfo.y = ((float)localJSONObject.getDouble("motionY"));
            localMotionInfo.scale = ((float)localJSONObject.getDouble("scaleP"));
            localMotionInfo.rotate = ((float)localJSONObject.getDouble("rotateP"));
            localHashMap.put(Long.valueOf(localMotionInfo.frameTime), localMotionInfo);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              SLog.e("TrackerStickerParam", "mapMotionFromJarray" + localJSONException.toString());
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static JSONArray motionMapToJarray(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        Long localLong = (Long)((Map.Entry)localObject).getKey();
        localObject = (TrackerStickerParam.MotionInfo)((Map.Entry)localObject).getValue();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("frameTime", localLong);
          localJSONObject.put("motionX", ((TrackerStickerParam.MotionInfo)localObject).x);
          localJSONObject.put("motionY", ((TrackerStickerParam.MotionInfo)localObject).y);
          localJSONObject.put("isLost", ((TrackerStickerParam.MotionInfo)localObject).isLost);
          localJSONObject.put("scaleP", ((TrackerStickerParam.MotionInfo)localObject).scale);
          localJSONObject.put("rotateP", ((TrackerStickerParam.MotionInfo)localObject).rotate);
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          SLog.e("TrackerStickerParam", "motionMapToJarray" + localJSONException.toString());
        }
      }
    }
    return localJSONArray;
  }
  
  public void FromJson(JSONObject paramJSONObject)
  {
    try
    {
      if (this.centerP == null) {
        this.centerP = new PointF(0.0F, 0.0F);
      }
      this.centerP.x = ((float)paramJSONObject.getDouble("centerPx"));
      this.centerP.y = ((float)paramJSONObject.getDouble("centerPy"));
      this.scale = ((float)paramJSONObject.getDouble("scale"));
      this.rotate = ((float)paramJSONObject.getDouble("rotate"));
      this.translateXValue = ((float)paramJSONObject.getDouble("translateXValue"));
      this.translateYValue = ((float)paramJSONObject.getDouble("translateYValue"));
      this.width = ((float)paramJSONObject.getDouble("width"));
      this.height = ((float)paramJSONObject.getDouble("height"));
      this.path = paramJSONObject.getString("path");
      this.layerWidth = paramJSONObject.getInt("layerWidth");
      this.layerHeight = paramJSONObject.getInt("layerHeight");
      this.mapMotionTrack = mapMotionFromJarray(paramJSONObject.getJSONArray("motionTrack"));
      if (paramJSONObject.has("segmentdata"))
      {
        this.mSegmentKeeper.fromJSONObject(paramJSONObject.getJSONObject("segmentdata"));
        return;
      }
      SLog.e("TrackerStickerParam", "FromJSONObject error， segmentdata not exist!");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      SLog.e("TrackerStickerParam", "mapMotionFromJarray" + paramJSONObject.toString());
    }
  }
  
  public boolean isShow(long paramLong)
  {
    return this.mSegmentKeeper.isInSegment(paramLong);
  }
  
  public void setSegmentList(List<Pair<Long, Long>> paramList)
  {
    this.mSegmentKeeper.setSegmentList(paramList);
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("centerPx", this.centerP.x);
      localJSONObject1.put("centerPy", this.centerP.y);
      localJSONObject1.put("scale", this.scale);
      localJSONObject1.put("rotate", this.rotate);
      localJSONObject1.put("translateXValue", this.translateXValue);
      localJSONObject1.put("translateYValue", this.translateYValue);
      localJSONObject1.put("width", this.width);
      localJSONObject1.put("height", this.height);
      localJSONObject1.put("path", this.path);
      localJSONObject1.put("layerWidth", this.layerWidth);
      localJSONObject1.put("layerHeight", this.layerHeight);
      localJSONObject1.put("motionTrack", motionMapToJarray(this.mapMotionTrack));
      JSONObject localJSONObject2 = this.mSegmentKeeper.toJSONObject();
      if (localJSONObject2 != null) {
        localJSONObject1.put("segmentdata", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      SLog.e("TrackerStickerParam", "toJSONObject" + localJSONException.toString());
    }
    return localJSONObject1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DynamicStickerData{");
    localStringBuilder.append("centerP=").append(this.centerP);
    localStringBuilder.append(", scale=").append(this.scale);
    localStringBuilder.append(", rotate=").append(this.rotate);
    localStringBuilder.append(", translateX=").append(this.translateXValue);
    localStringBuilder.append(", translateY=").append(this.translateYValue);
    localStringBuilder.append(", width=").append(this.width);
    localStringBuilder.append(", height=").append(this.height);
    localStringBuilder.append(", layerWidth=").append(this.layerWidth);
    localStringBuilder.append(", layerHeight=").append(this.layerHeight);
    localStringBuilder.append(", path='").append(this.path).append('\'');
    String str = this.mSegmentKeeper.toString();
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    for (;;)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append(",segments=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam
 * JD-Core Version:    0.7.0.1
 */