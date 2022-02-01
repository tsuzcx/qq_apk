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
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return String.format(Locale.US, "http://%s/%s?platform=android&dev=%s&hot=%s&minify=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
  }
  
  public String a()
  {
    return String.format(Locale.US, "ws://%s/debugger-live-reload", new Object[] { this.b });
  }
  
  public void a(a parama, boolean paramBoolean, String paramString1, String paramString2, File paramFile)
  {
    paramString1 = a(paramString1, paramString2, paramBoolean, false, false);
    paramString2 = new HippyHttpRequest();
    paramString2.setUrl(paramString1);
    this.a.getHttpAdapter().sendRequest(paramString2, new j.1(this, parama, paramFile, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.j
 * JD-Core Version:    0.7.0.1
 */