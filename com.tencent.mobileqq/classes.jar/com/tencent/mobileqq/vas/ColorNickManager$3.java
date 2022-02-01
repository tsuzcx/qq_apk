package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.qphone.base.util.QLog;

class ColorNickManager$3
  extends EmotionJsonDownloadListener
{
  ColorNickManager$3(ColorNickManager paramColorNickManager) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "emotion onJsonComplete id = " + paramEmoticonPackage.epId + " resultCode = " + paramInt);
    }
    if (this.a.a != null) {
      this.a.a.sendEmptyMessage(257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.3
 * JD-Core Version:    0.7.0.1
 */