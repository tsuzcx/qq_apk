package com.tencent.mobileqq.richmedia.capture.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowCaptureParam
  implements Serializable
{
  public String audioPath;
  public String backgroundPath;
  public int comparedActivityId;
  public int comparedLevel;
  public long duration;
  public String foregroundPath;
  public boolean showLink;
  public String vid;
  public String videoPath;
  
  public static FollowCaptureParam parseFromJson(JSONObject paramJSONObject)
  {
    FollowCaptureParam localFollowCaptureParam = new FollowCaptureParam();
    if (paramJSONObject.has("videoPath")) {}
    try
    {
      localFollowCaptureParam.videoPath = paramJSONObject.getString("videoPath");
      if (!paramJSONObject.has("audioPath")) {}
    }
    catch (JSONException localJSONException7)
    {
      try
      {
        localFollowCaptureParam.audioPath = paramJSONObject.getString("audioPath");
        if (!paramJSONObject.has("duration")) {}
      }
      catch (JSONException localJSONException7)
      {
        try
        {
          localFollowCaptureParam.duration = paramJSONObject.getLong("duration");
          if (!paramJSONObject.has("backgroundPath")) {}
        }
        catch (JSONException localJSONException7)
        {
          try
          {
            localFollowCaptureParam.backgroundPath = paramJSONObject.getString("backgroundPath");
            if (!paramJSONObject.has("foregroundPath")) {}
          }
          catch (JSONException localJSONException7)
          {
            try
            {
              localFollowCaptureParam.foregroundPath = paramJSONObject.getString("foregroundPath");
              if (!paramJSONObject.has("vid")) {}
            }
            catch (JSONException localJSONException7)
            {
              try
              {
                localFollowCaptureParam.vid = paramJSONObject.getString("vid");
                if (!paramJSONObject.has("comparedLevel")) {}
              }
              catch (JSONException localJSONException7)
              {
                try
                {
                  localFollowCaptureParam.comparedLevel = paramJSONObject.getInt("comparedLevel");
                  if (!paramJSONObject.has("comparedActivityId")) {}
                }
                catch (JSONException localJSONException7)
                {
                  try
                  {
                    for (;;)
                    {
                      localFollowCaptureParam.comparedActivityId = paramJSONObject.getInt("comparedActivityId");
                      if (paramJSONObject.has("showLink")) {}
                      try
                      {
                        localFollowCaptureParam.showLink = paramJSONObject.getBoolean("showLink");
                        return localFollowCaptureParam;
                      }
                      catch (JSONException paramJSONObject)
                      {
                        paramJSONObject.printStackTrace();
                      }
                      localJSONException1 = localJSONException1;
                      localJSONException1.printStackTrace();
                      continue;
                      localJSONException2 = localJSONException2;
                      localJSONException2.printStackTrace();
                      continue;
                      localJSONException3 = localJSONException3;
                      localJSONException3.printStackTrace();
                      continue;
                      localJSONException4 = localJSONException4;
                      localJSONException4.printStackTrace();
                      continue;
                      localJSONException5 = localJSONException5;
                      localJSONException5.printStackTrace();
                      continue;
                      localJSONException6 = localJSONException6;
                      localJSONException6.printStackTrace();
                    }
                    localJSONException7 = localJSONException7;
                    localJSONException7.printStackTrace();
                  }
                  catch (JSONException localJSONException8)
                  {
                    for (;;)
                    {
                      localJSONException8.printStackTrace();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localFollowCaptureParam;
  }
  
  public static JSONObject parseToJson(FollowCaptureParam paramFollowCaptureParam)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("videoPath", paramFollowCaptureParam.videoPath);
    }
    catch (JSONException localJSONException7)
    {
      try
      {
        localJSONObject.put("audioPath", paramFollowCaptureParam.audioPath);
      }
      catch (JSONException localJSONException7)
      {
        try
        {
          localJSONObject.put("duration", paramFollowCaptureParam.duration);
        }
        catch (JSONException localJSONException7)
        {
          try
          {
            localJSONObject.put("backgroundPath", paramFollowCaptureParam.backgroundPath);
          }
          catch (JSONException localJSONException7)
          {
            try
            {
              localJSONObject.put("foregroundPath", paramFollowCaptureParam.foregroundPath);
            }
            catch (JSONException localJSONException7)
            {
              try
              {
                localJSONObject.put("vid", paramFollowCaptureParam.vid);
              }
              catch (JSONException localJSONException7)
              {
                try
                {
                  localJSONObject.put("comparedLevel", paramFollowCaptureParam.comparedLevel);
                }
                catch (JSONException localJSONException7)
                {
                  try
                  {
                    for (;;)
                    {
                      localJSONObject.put("comparedActivityId", paramFollowCaptureParam.comparedActivityId);
                      try
                      {
                        localJSONObject.put("showLink", paramFollowCaptureParam.showLink);
                        return localJSONObject;
                      }
                      catch (JSONException paramFollowCaptureParam)
                      {
                        paramFollowCaptureParam.printStackTrace();
                      }
                      localJSONException1 = localJSONException1;
                      localJSONException1.printStackTrace();
                      continue;
                      localJSONException2 = localJSONException2;
                      localJSONException2.printStackTrace();
                      continue;
                      localJSONException3 = localJSONException3;
                      localJSONException3.printStackTrace();
                      continue;
                      localJSONException4 = localJSONException4;
                      localJSONException4.printStackTrace();
                      continue;
                      localJSONException5 = localJSONException5;
                      localJSONException5.printStackTrace();
                      continue;
                      localJSONException6 = localJSONException6;
                      localJSONException6.printStackTrace();
                      continue;
                      localJSONException7 = localJSONException7;
                      localJSONException7.printStackTrace();
                    }
                  }
                  catch (JSONException localJSONException8)
                  {
                    for (;;)
                    {
                      localJSONException8.printStackTrace();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam
 * JD-Core Version:    0.7.0.1
 */