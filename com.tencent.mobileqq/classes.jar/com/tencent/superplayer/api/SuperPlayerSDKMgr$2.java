package com.tencent.superplayer.api;

import com.tencent.superplayer.config.ConfigManager.OnConfigCallback;
import com.tencent.superplayer.utils.CodecReuseHelper;
import com.tencent.tmediacodec.TCodecManager;

final class SuperPlayerSDKMgr$2
  implements ConfigManager.OnConfigCallback
{
  public void onConfigPulled()
  {
    TCodecManager.getInstance().getReusePolicy().eraseType = CodecReuseHelper.get().getEraseType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr.2
 * JD-Core Version:    0.7.0.1
 */