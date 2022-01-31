package com.tencent.mobileqq.microapp.apkg;

import org.json.JSONObject;

public final class q
{
  public static q a(JSONObject paramJSONObject)
  {
    q localq = new q();
    if (paramJSONObject == null)
    {
      if (paramJSONObject != null) {
        break label38;
      }
      label16:
      if (paramJSONObject != null) {
        break label50;
      }
    }
    for (;;)
    {
      if (paramJSONObject != null) {
        break label62;
      }
      return localq;
      paramJSONObject.optInt("request", 60000);
      break;
      label38:
      paramJSONObject.optInt("connectSocket", 60000);
      break label16;
      label50:
      paramJSONObject.optInt("uploadFile", 60000);
    }
    label62:
    paramJSONObject.optInt("downloadFile", 60000);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.q
 * JD-Core Version:    0.7.0.1
 */