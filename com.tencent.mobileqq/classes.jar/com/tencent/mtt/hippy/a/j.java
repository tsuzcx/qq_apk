package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import java.io.File;
import java.util.Locale;

public class j
{
  private HippyGlobalConfigs a;
  private String b;
  
  public j(HippyGlobalConfigs paramHippyGlobalConfigs, String paramString)
  {
    this.a = paramHippyGlobalConfigs;
    this.b = paramString;
  }
  
  public String a()
  {
    return String.format(Locale.US, "ws://%s/debugger-live-reload", new Object[] { this.b });
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return String.format(Locale.US, "http://%s/%s?platform=android&dev=%s&hot=%s&minify=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
  }
  
  public void a(a parama, String paramString, File paramFile)
  {
    HippyHttpRequest localHippyHttpRequest = new HippyHttpRequest();
    localHippyHttpRequest.setUrl(paramString);
    this.a.getHttpAdapter().sendRequest(localHippyHttpRequest, new j.1(this, parama, paramFile, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.j
 * JD-Core Version:    0.7.0.1
 */