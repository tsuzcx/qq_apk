package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TreasureCardJsPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "treasureCard";
  public static final String TAG = "TreasureCardJsPlugin";
  
  public TreasureCardJsPlugin()
  {
    super("treasureCard");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="clearSimCache")
  public void clearSimCache(String paramString)
  {
    try
    {
      boolean bool = VasUtil.a(this.mRuntime.c()).getVasFtManager().clearCacheAndRequest();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("request", bool);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("treasureCard");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" request:");
        localStringBuilder.append(localJSONObject);
        QLog.d("TreasureCardJsPlugin", 2, localStringBuilder.toString());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|from", method="freeTrafficCardModel")
  public void freeTrafficCardModel(String paramString1, String paramString2)
  {
    try
    {
      IVasFTManager localIVasFTManager = VasUtil.a(this.mRuntime.c()).getVasFtManager();
      JSONObject localJSONObject = localIVasFTManager.obtainCardInfo(paramString2).toJson();
      localJSONObject.put("cardStates", localIVasFTManager.obtainCardState(paramString2));
      super.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|from", method="tcardModel")
  public void tcardModel(String paramString1, String paramString2)
  {
    try
    {
      IVasFTManager localIVasFTManager = VasUtil.a(this.mRuntime.c()).getVasFtManager();
      JSONObject localJSONObject = localIVasFTManager.obtainCardInfo(paramString2).toJson();
      localJSONObject.put("mobileCardStates", localIVasFTManager.treasureCardState(paramString2));
      super.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin
 * JD-Core Version:    0.7.0.1
 */