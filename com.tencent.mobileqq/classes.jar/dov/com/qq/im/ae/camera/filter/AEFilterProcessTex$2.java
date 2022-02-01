package dov.com.qq.im.ae.camera.filter;

import android.util.Log;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AEFilterProcessTex$2
  implements LightAssetListener
{
  AEFilterProcessTex$2(AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    Log.d("AEFilterProcessTex", "OnAssetProcessing: " + paramHashMap);
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    Log.d("AEFilterProcessTex", "OnLoadAssetError: " + paramInt);
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2
 * JD-Core Version:    0.7.0.1
 */