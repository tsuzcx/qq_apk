package com.tencent.qqmini.proxyimpl;

import bgok;
import bgor;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOEntryPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AIOEntryPlugin";
  
  public void hideMiniAIOEntrance(bgok parambgok)
  {
    bgor.a(new AIOEntryPlugin.2(this, parambgok));
  }
  
  public void showMiniAIOEntrance(bgok parambgok)
  {
    try
    {
      bgor.a(new AIOEntryPlugin.1(this, new JSONObject(parambgok.b), parambgok));
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin
 * JD-Core Version:    0.7.0.1
 */