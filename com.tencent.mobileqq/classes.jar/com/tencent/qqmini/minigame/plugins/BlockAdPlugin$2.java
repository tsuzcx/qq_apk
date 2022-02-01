package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$2
  implements AdProxy.IBlockAdListener
{
  BlockAdPlugin$2(BlockAdPlugin paramBlockAdPlugin, RequestEvent paramRequestEvent, BlockAdInfo paramBlockAdInfo) {}
  
  public void onADClicked()
  {
    QMLog.i("BlockAdPlugin", "onADClicked");
  }
  
  public void onADClosed()
  {
    QMLog.i("BlockAdPlugin", "onADClosed");
  }
  
  public void onADExposure()
  {
    QMLog.i("BlockAdPlugin", "onADExposure");
  }
  
  public void onADReceive(int paramInt1, int paramInt2, int paramInt3)
  {
    QMLog.i("BlockAdPlugin", "onADReceive");
    Object localObject = this.val$adInfo;
    if (localObject == null) {
      return;
    }
    ((BlockAdInfo)localObject).setRealWidth(paramInt2);
    this.val$adInfo.setRealHeight(paramInt3);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", "load");
      ((JSONObject)localObject).put("adUnitId", this.val$adInfo.getAdUnitId());
      ((JSONObject)localObject).put("compId", this.val$adInfo.getCompId());
      ((JSONObject)localObject).put("realAdNum", paramInt1);
      ((JSONObject)localObject).put("realWidth", this.val$adInfo.getRealWidth());
      ((JSONObject)localObject).put("realHeight", this.val$adInfo.getRealHeight());
      BlockAdPlugin.access$200(this.this$0, this.val$req, (JSONObject)localObject, "onBlockAdStateChange");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", "resize");
      ((JSONObject)localObject).put("compId", this.val$adInfo.getCompId());
      ((JSONObject)localObject).put("width", paramInt2);
      ((JSONObject)localObject).put("height", paramInt3);
      BlockAdPlugin.access$200(this.this$0, this.val$req, (JSONObject)localObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BlockAdPlugin", "informJs success", localJSONException);
    }
  }
  
  public void onNoAD(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNoAD, errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QMLog.i("BlockAdPlugin", localStringBuilder.toString());
    BlockAdPlugin.access$100(this.this$0, this.val$req, paramInt, paramString, this.val$adInfo.getCompId(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */