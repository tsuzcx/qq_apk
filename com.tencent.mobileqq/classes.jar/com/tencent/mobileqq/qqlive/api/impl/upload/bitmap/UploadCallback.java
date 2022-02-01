package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import org.json.JSONObject;

public abstract interface UploadCallback
{
  public static final int ERR_EMPTY_RSP = -2;
  public static final int ERR_IO = -1;
  public static final int ERR_JSON_ERR = -3;
  
  public abstract void onResponse(int paramInt, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadCallback
 * JD-Core Version:    0.7.0.1
 */