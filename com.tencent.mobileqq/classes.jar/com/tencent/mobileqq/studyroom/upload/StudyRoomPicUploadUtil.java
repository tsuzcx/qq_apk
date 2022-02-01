package com.tencent.mobileqq.studyroom.upload;

import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StudyRoomPicUploadUtil
{
  private static Map<String, IStudyRoomPicUploader> a = new ConcurrentHashMap();
  
  public static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null) {
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("status", paramBundle.getString("status"));
      localJSONObject.put("downloadUrl", paramBundle.getString("downloadUrl"));
      localJSONObject.put("thumbUrl", paramBundle.getString("thumbUrl"));
      localJSONObject.put("downloadProgress", paramBundle.getInt("downloadProgress"));
      localJSONObject.put("errorCode", paramBundle.getInt("errorCode"));
      localJSONObject.put("errorMsg", paramBundle.getString("errorMsg"));
      return localJSONObject;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return localJSONObject;
  }
  
  private static void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("localPath", "");
    a.remove(paramBundle);
  }
  
  public static void a(Bundle paramBundle, int paramInt)
  {
    paramBundle.putString("status", "progress");
    paramBundle.putInt("downloadProgress", paramInt);
  }
  
  public static void a(Bundle paramBundle, int paramInt, String paramString, boolean paramBoolean)
  {
    paramBundle.putString("status", "failed");
    paramBundle.putInt("errorCode", paramInt);
    paramBundle.putString("errorMsg", paramString);
    if (paramBoolean) {
      a(paramBundle);
    }
  }
  
  public static void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramBundle.putString("status", "success");
    paramBundle.putString("downloadUrl", paramString1);
    paramBundle.putString("thumbUrl", paramString2);
    a(paramBundle);
  }
  
  public static void a(String paramString)
  {
    paramString = (IStudyRoomPicUploader)a.remove(paramString);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public static void a(String paramString, StudyRoomPicUploader paramStudyRoomPicUploader)
  {
    a.put(paramString, paramStudyRoomPicUploader);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("status");
    return ("failed".equals(paramBundle)) || ("success".equals(paramBundle));
  }
  
  public static boolean a(String paramString)
  {
    return a.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil
 * JD-Core Version:    0.7.0.1
 */