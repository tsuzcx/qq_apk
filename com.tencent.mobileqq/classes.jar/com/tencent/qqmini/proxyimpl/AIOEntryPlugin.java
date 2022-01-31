package com.tencent.qqmini.proxyimpl;

import bgkd;
import bgkk;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOEntryPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AIOEntryPlugin";
  
  public void hideMiniAIOEntrance(bgkd parambgkd)
  {
    bgkk.a(new AIOEntryPlugin.2(this, parambgkd));
  }
  
  public void showMiniAIOEntrance(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new AIOEntryPlugin.1(this, new JSONObject(parambgkd.b), parambgkd));
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin
 * JD-Core Version:    0.7.0.1
 */