package com.tencent.mobileqq.richmediabrowser.qqfloatingscreen;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TVKVideoController$3
  implements MediaFocusManager.OnMediaFocusChangeListener
{
  TVKVideoController$3(TVKVideoController paramTVKVideoController) {}
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TVKVideoController", 4, new Object[] { "onFocusChange focusType:", Integer.valueOf(paramInt) });
    }
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 1) {
          return;
        }
        ((AudioManager)((Context)TVKVideoController.d(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        if (TVKVideoController.c(this.a) != null) {
          TVKVideoController.c(this.a).play();
        }
        TVKVideoController.b(this.a, 4);
        return;
      }
      if (TVKVideoController.c(this.a) != null) {
        TVKVideoController.c(this.a).pause();
      }
      TVKVideoController.b(this.a, 6);
      if (TVKVideoController.e(this.a) != null) {
        TVKVideoController.e(this.a).onVideoStop();
      }
    }
    else if (TVKVideoController.c(this.a) != null)
    {
      TVKVideoController.c(this.a).setMute(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController.3
 * JD-Core Version:    0.7.0.1
 */