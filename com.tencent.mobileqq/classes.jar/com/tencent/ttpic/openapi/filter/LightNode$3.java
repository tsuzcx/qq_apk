package com.tencent.ttpic.openapi.filter;

import android.util.Log;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class LightNode$3
  implements LightAssetListener
{
  LightNode$3(LightNode paramLightNode) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    Log.d("LightNode", "OnAssetProcessing: " + paramHashMap);
    if (LightNode.access$200(this.this$0) != null) {
      LightNode.access$200(this.this$0).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    Log.d("LightNode", "OnLoadAssetError: " + paramInt);
    if (LightNode.access$200(this.this$0) != null) {
      LightNode.access$200(this.this$0).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LightNode.3
 * JD-Core Version:    0.7.0.1
 */