package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.UITools;

class AudioMediaModule$5
  implements DialogInterface.OnClickListener
{
  AudioMediaModule$5(AudioMediaModule paramAudioMediaModule) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UITools.a((Activity)AudioMediaModule.a(this.a));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.5
 * JD-Core Version:    0.7.0.1
 */