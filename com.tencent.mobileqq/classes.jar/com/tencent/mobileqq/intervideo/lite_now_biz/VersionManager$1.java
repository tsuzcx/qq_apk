package com.tencent.mobileqq.intervideo.lite_now_biz;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;

class VersionManager$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  VersionManager$1(VersionManager paramVersionManager, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    VersionManager.a(this.c, paramInt, paramArrayOfByte, paramBundle, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.1
 * JD-Core Version:    0.7.0.1
 */