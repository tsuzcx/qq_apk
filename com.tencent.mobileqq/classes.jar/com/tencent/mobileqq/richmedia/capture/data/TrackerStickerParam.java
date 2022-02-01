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
      Object localObject;
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam();
          localTrackerStickerParam.FromJson((JSONObject)localObject);
          localArrayList.add(localTrackerStickerParam);
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TrackList FromString");
      ((StringBuilder)localObject).append(paramString.toString());
      SLog.e("TrackerStickerParam", ((StringBuilder)localObject).toString());
    }
  }
  
  public static String ToJsonString(ArrayList<TrackerStickerParam> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)paramArrayList.get(i);
        if (localTrackerStickerParam != null) {
          ((JSONArray)localObject).put(localTrackerStickerParam.toJSONObject());
        }
        i += 1;
      }
      try
      {
        localJSONObject.put("TrackList", localObject);
      }
      catch (JSONException paramArrayList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TrackList");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        SLog.e("TrackerStickerParam", ((StringBuilder)localObject).toString());
      }
      return localJSONObject.toString();
    }
    return null;
  }
  
  public static Map<Long, TrackerStickerParam.MotionInfo> mapMotionFromJarray(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          localObject = new TrackerStickerParam.MotionInfo(false, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
          ((TrackerStickerParam.MotionInfo)localObject).isLost = localJSONObject.getBoolean("isLost");
          ((TrackerStickerParam.MotionInfo)localObject).frameTime = localJSONObject.getLong("frameTime");
          ((TrackerStickerParam.MotionInfo)localObject).x = ((float)localJSONObject.getDouble("motionX"));
          ((TrackerStickerParam.MotionInfo)localObject).y = ((float)localJSONObject.getDouble("motionY"));
          ((TrackerStickerParam.MotionInfo)localObject).scale = ((float)localJSONObject.getDouble("scaleP"));
          ((TrackerStickerParam.MotionInfo)localObject).rotate = ((float)localJSONObject.getDouble("rotateP"));
          localHashMap.put(Long.valueOf(((TrackerStickerParam.MotionInfo)localObject).frameTime), localObject);
        }
        catch (JSONException localJSONException)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mapMotionFromJarray");
          ((StringBuilder)localObject).append(localJSONException.toString());
          SLog.e("TrackerStickerParam", ((StringBuilder)localObject).toString());
        }
        i += 1;
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("motionMapToJarray");
          ((StringBuilder)localObject).append(localJSONException.toString());
          SLog.e("TrackerStickerParam", ((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mapMotionFromJarray");
      localStringBuilder.append(paramJSONObject.toString());
      SLog.e("TrackerStickerParam", localStringBuilder.toString());
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
      if (localJSONObject2 != null)
      {
        localJSONObject1.put("segmentdata", localJSONObject2);
        return localJSONObject1;
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJSONObject");
      localStringBuilder.append(localJSONException.toString());
      SLog.e("TrackerStickerParam", localStringBuilder.toString());
    }
    return localJSONObject1;
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
    localStringBuilder.append(this.translateXValue);
    localStringBuilder.append(", translateY=");
    localStringBuilder.append(this.translateYValue);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", layerWidth=");
    localStringBuilder.append(this.layerWidth);
    localStringBuilder.append(", layerHeight=");
    localStringBuilder.append(this.layerHeight);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam
 * JD-Core Version:    0.7.0.1
 */