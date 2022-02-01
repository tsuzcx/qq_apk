package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class EditItemInfoFactory
{
  static HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("str", Integer.valueOf(0));
    a.put("img", Integer.valueOf(1));
    a.put("video", Integer.valueOf(2));
    a.put("voice", Integer.valueOf(3));
  }
  
  public static EditItemInfoBase a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static EditItemInfoBase a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getString("type");
      localObject = (Integer)a.get(localObject);
      if (localObject == null) {
        return null;
      }
      int i = ((Integer)localObject).intValue();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return null;
            }
            return new AudioInfo(paramJSONObject);
          }
          return new VideoInfo(paramJSONObject);
        }
        return new ImageInfo(paramJSONObject);
      }
      paramJSONObject = new TextInfo(paramJSONObject);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory
 * JD-Core Version:    0.7.0.1
 */