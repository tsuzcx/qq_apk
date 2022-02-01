package com.tencent.mtt.abtestsdk.listener;

import org.json.JSONObject;

public abstract interface OnUpdateExperimentsListener
{
  public abstract void updateExperimentsFailed(int paramInt, String paramString);
  
  public abstract void updateExperimentsSucceed(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener
 * JD-Core Version:    0.7.0.1
 */