package com.tencent.mobileqq.studyroom.config;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class StudyRoomConfBean
{
  public JSONObject a = new JSONObject();
  
  public boolean a()
  {
    JSONObject localJSONObject = this.a.optJSONObject("plugin");
    if (localJSONObject != null) {
      return localJSONObject.optInt("preload", 0) == 1;
    }
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "StudyRoomConfBean{data=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.config.StudyRoomConfBean
 * JD-Core Version:    0.7.0.1
 */