package com.tencent.mobileqq.studyroom.config;

import android.support.annotation.NonNull;
import org.json.JSONObject;

public class StudyRoomConfBean
{
  public JSONObject a = new JSONObject();
  
  public boolean a()
  {
    JSONObject localJSONObject = this.a.optJSONObject("plugin");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localJSONObject != null)
    {
      bool1 = bool2;
      if (localJSONObject.optInt("preload", 0) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StudyRoomConfBean{data=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.config.StudyRoomConfBean
 * JD-Core Version:    0.7.0.1
 */