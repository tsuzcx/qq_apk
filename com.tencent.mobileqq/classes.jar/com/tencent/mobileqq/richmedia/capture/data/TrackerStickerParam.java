package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
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
  public float a;
  public int a;
  public PointF a;
  public SegmentKeeper a;
  public String a;
  public Map a;
  public float b;
  public int b;
  public float c;
  public float d;
  public float e;
  public float f;
  
  public TrackerStickerParam()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
  }
  
  public TrackerStickerParam(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2, String paramString, Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.c = paramFloat5;
    this.d = paramFloat6;
    this.e = paramFloat7;
    this.f = paramFloat8;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public static String a(ArrayList paramArrayList)
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
            localJSONArray.put(localTrackerStickerParam.a());
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
        SLog.a("TrackerStickerParam", "TrackList" + paramArrayList.toString());
      }
    }
  }
  
  public static ArrayList a(String paramString)
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
          localTrackerStickerParam.a(localJSONObject);
          localArrayList.add(localTrackerStickerParam);
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      SLog.a("TrackerStickerParam", "TrackList FromString" + paramString.toString());
    }
  }
  
  public static Map a(JSONArray paramJSONArray)
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
            localMotionInfo.jdField_a_of_type_Boolean = localJSONObject.getBoolean("isLost");
            localMotionInfo.jdField_a_of_type_Long = localJSONObject.getLong("frameTime");
            localMotionInfo.jdField_a_of_type_Float = ((float)localJSONObject.getDouble("motionX"));
            localMotionInfo.jdField_b_of_type_Float = ((float)localJSONObject.getDouble("motionY"));
            localMotionInfo.c = ((float)localJSONObject.getDouble("scaleP"));
            localMotionInfo.d = ((float)localJSONObject.getDouble("rotateP"));
            localHashMap.put(Long.valueOf(localMotionInfo.jdField_a_of_type_Long), localMotionInfo);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              SLog.a("TrackerStickerParam", "mapMotionFromJarray" + localJSONException.toString());
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static JSONArray a(Map paramMap)
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
          localJSONObject.put("motionX", ((TrackerStickerParam.MotionInfo)localObject).jdField_a_of_type_Float);
          localJSONObject.put("motionY", ((TrackerStickerParam.MotionInfo)localObject).jdField_b_of_type_Float);
          localJSONObject.put("isLost", ((TrackerStickerParam.MotionInfo)localObject).jdField_a_of_type_Boolean);
          localJSONObject.put("scaleP", ((TrackerStickerParam.MotionInfo)localObject).c);
          localJSONObject.put("rotateP", ((TrackerStickerParam.MotionInfo)localObject).d);
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          SLog.a("TrackerStickerParam", "motionMapToJarray" + localJSONException.toString());
        }
      }
    }
    return localJSONArray;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("centerPx", this.jdField_a_of_type_AndroidGraphicsPointF.x);
      localJSONObject1.put("centerPy", this.jdField_a_of_type_AndroidGraphicsPointF.y);
      localJSONObject1.put("scale", this.jdField_a_of_type_Float);
      localJSONObject1.put("rotate", this.jdField_b_of_type_Float);
      localJSONObject1.put("translateXValue", this.c);
      localJSONObject1.put("translateYValue", this.d);
      localJSONObject1.put("width", this.e);
      localJSONObject1.put("height", this.f);
      localJSONObject1.put("path", this.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("layerWidth", this.jdField_a_of_type_Int);
      localJSONObject1.put("layerHeight", this.jdField_b_of_type_Int);
      localJSONObject1.put("motionTrack", a(this.jdField_a_of_type_JavaUtilMap));
      JSONObject localJSONObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a();
      if (localJSONObject2 != null) {
        localJSONObject1.put("segmentdata", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      SLog.a("TrackerStickerParam", "toJSONObject" + localJSONException.toString());
    }
    return localJSONObject1;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramList);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsPointF == null) {
        this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
      }
      this.jdField_a_of_type_AndroidGraphicsPointF.x = ((float)paramJSONObject.getDouble("centerPx"));
      this.jdField_a_of_type_AndroidGraphicsPointF.y = ((float)paramJSONObject.getDouble("centerPy"));
      this.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("scale"));
      this.jdField_b_of_type_Float = ((float)paramJSONObject.getDouble("rotate"));
      this.c = ((float)paramJSONObject.getDouble("translateXValue"));
      this.d = ((float)paramJSONObject.getDouble("translateYValue"));
      this.e = ((float)paramJSONObject.getDouble("width"));
      this.f = ((float)paramJSONObject.getDouble("height"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("path");
      this.jdField_a_of_type_Int = paramJSONObject.getInt("layerWidth");
      this.jdField_b_of_type_Int = paramJSONObject.getInt("layerHeight");
      this.jdField_a_of_type_JavaUtilMap = a(paramJSONObject.getJSONArray("motionTrack"));
      if (paramJSONObject.has("segmentdata"))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramJSONObject.getJSONObject("segmentdata"));
        return;
      }
      SLog.a("TrackerStickerParam", "FromJSONObject error， segmentdata not exist!");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      SLog.a("TrackerStickerParam", "mapMotionFromJarray" + paramJSONObject.toString());
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DynamicStickerData{");
    localStringBuilder.append("centerP=").append(this.jdField_a_of_type_AndroidGraphicsPointF);
    localStringBuilder.append(", scale=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", rotate=").append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", translateX=").append(this.c);
    localStringBuilder.append(", translateY=").append(this.d);
    localStringBuilder.append(", width=").append(this.e);
    localStringBuilder.append(", height=").append(this.f);
    localStringBuilder.append(", layerWidth=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", layerHeight=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", path='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.toString();
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