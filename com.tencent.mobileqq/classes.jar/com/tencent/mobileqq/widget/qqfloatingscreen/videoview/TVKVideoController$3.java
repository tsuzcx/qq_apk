package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

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
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        ((AudioManager)((Context)TVKVideoController.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        if (TVKVideoController.a(this.a) != null) {
          TVKVideoController.a(this.a).play();
        }
        TVKVideoController.a(this.a, 4);
        return;
        if (TVKVideoController.a(this.a) != null) {
          TVKVideoController.a(this.a).pause();
        }
        TVKVideoController.a(this.a, 6);
      } while (TVKVideoController.a(this.a) == null);
      TVKVideoController.a(this.a).onVideoStop();
      return;
    } while (TVKVideoController.a(this.a) == null);
    TVKVideoController.a(this.a).setMute(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.3
 * JD-Core Version:    0.7.0.1
 */