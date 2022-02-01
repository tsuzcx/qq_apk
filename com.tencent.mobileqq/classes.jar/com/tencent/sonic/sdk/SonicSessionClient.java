package com.tencent.sonic.sdk;

import android.os.Bundle;
import java.util.HashMap;

public abstract class SonicSessionClient
{
  private SonicSession session;
  
  public void bindSession(SonicSession paramSonicSession)
  {
    this.session = paramSonicSession;
  }
  
  public void clearHistory() {}
  
  public void clientReady()
  {
    if (this.session != null) {
      this.session.onClientReady();
    }
  }
  
  public void getDiffData(SonicDiffDataCallback paramSonicDiffDataCallback)
  {
    if (this.session != null) {
      this.session.onWebReady(paramSonicDiffDataCallback);
    }
  }
  
  public abstract void loadDataWithBaseUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadDataWithBaseUrlAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, String> paramHashMap);
  
  public abstract void loadUrl(String paramString, Bundle paramBundle);
  
  public void pageFinish(String paramString)
  {
    if (this.session != null) {
      this.session.onClientPageFinished(paramString);
    }
  }
  
  public Object requestResource(String paramString)
  {
    if (this.session != null) {
      return this.session.onClientRequestResource(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionClient
 * JD-Core Version:    0.7.0.1
 */