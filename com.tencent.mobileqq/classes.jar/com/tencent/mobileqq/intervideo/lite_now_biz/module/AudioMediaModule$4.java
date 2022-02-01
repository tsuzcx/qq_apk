package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.permission.PermissionCallback;
import java.util.List;

class AudioMediaModule$4
  implements PermissionCallback
{
  AudioMediaModule$4(AudioMediaModule paramAudioMediaModule) {}
  
  public void a(List<String> paramList, int paramInt)
  {
    AudioMediaModule.a(this.a).i("AudioMediaModule", "requestMicPermission: permission denied.", new Object[0]);
    AudioMediaModule.f(this.a);
    AudioMediaModule.a(this.a, null);
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    AudioMediaModule.a(this.a).i("AudioMediaModule", "requestMicPermission: permission grated.", new Object[0]);
    AudioMediaModule.a(this.a, null);
    paramArrayOfString = this.a;
    AudioMediaModule.b(paramArrayOfString, AudioMediaModule.e(paramArrayOfString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.4
 * JD-Core Version:    0.7.0.1
 */