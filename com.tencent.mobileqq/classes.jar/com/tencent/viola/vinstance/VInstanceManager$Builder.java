package com.tencent.viola.vinstance;

import android.app.Application;
import java.util.List;
import org.json.JSONObject;

public class VInstanceManager$Builder
{
  Application application;
  boolean isBlockingMode;
  JSONObject param;
  PreconditionAdapter preconditionAdapter;
  List<Precondition> preconditions;
  String serviceJsUrl;
  
  public Builder application(Application paramApplication)
  {
    this.application = paramApplication;
    return this;
  }
  
  public Builder isBlockingMode(boolean paramBoolean)
  {
    this.isBlockingMode = paramBoolean;
    return this;
  }
  
  public Builder param(JSONObject paramJSONObject)
  {
    this.param = paramJSONObject;
    return this;
  }
  
  public Builder preconditionAdapter(PreconditionAdapter paramPreconditionAdapter)
  {
    this.preconditionAdapter = paramPreconditionAdapter;
    return this;
  }
  
  public Builder preconditions(List<Precondition> paramList)
  {
    this.preconditions = paramList;
    return this;
  }
  
  public Builder serviceJsUrl(String paramString)
  {
    this.serviceJsUrl = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceManager.Builder
 * JD-Core Version:    0.7.0.1
 */