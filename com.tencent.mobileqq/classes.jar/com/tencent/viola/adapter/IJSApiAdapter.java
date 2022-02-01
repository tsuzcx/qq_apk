package com.tencent.viola.adapter;

import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public abstract interface IJSApiAdapter
{
  public abstract void invoke(String paramString, JSONObject paramJSONObject, IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.adapter.IJSApiAdapter
 * JD-Core Version:    0.7.0.1
 */