package com.tencent.qqmini.sdk.core.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdyn;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$14
  implements Runnable
{
  MiniAppVideoPlayer$14(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    int n = 0;
    if (this.this$0.D) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localActivity = (Activity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    this.this$0.c = true;
    MiniAppVideoPlayer.e(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.d(this.this$0).setVisibility(0);
    if (this.this$0.jdField_a_of_type_Bdii != null) {}
    MiniAppVideoPlayer.a(this.this$0, ((CoverVideoView)this.this$0.getParent()).getLayoutParams());
    if (this.this$0.getParent().getParent() != null)
    {
      MiniAppVideoPlayer.d(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
    }
    int j;
    int k;
    int i;
    if (MiniAppVideoPlayer.a(this.this$0) != null)
    {
      j = MiniAppVideoPlayer.a(this.this$0).getVideoWidth();
      k = MiniAppVideoPlayer.a(this.this$0).getVideoHeight();
      if (j != 0)
      {
        i = k;
        if (k != 0) {}
      }
      else
      {
        j = MiniAppVideoPlayer.f(this.this$0);
        i = MiniAppVideoPlayer.g(this.this$0);
      }
      if ((MiniAppVideoPlayer.h(this.this$0) == 0) || (MiniAppVideoPlayer.h(this.this$0) == 180))
      {
        if (j >= i) {
          break label526;
        }
        i = 0;
      }
    }
    for (;;)
    {
      j = bdyn.b(this.this$0.getContext());
      k = bdyn.a(this.this$0.getContext());
      int m;
      label296:
      label300:
      Object localObject;
      if (i != 0)
      {
        m = j;
        if (i == 0) {
          break label442;
        }
        if (this.this$0.jdField_a_of_type_Bdii != null) {
          break label447;
        }
        localObject = new RelativeLayout.LayoutParams(m, k);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        label349:
        localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
        if (i == 0) {
          break label489;
        }
        if (this.this$0.d != -90)
        {
          i = n;
          if (this.this$0.d != 270) {}
        }
        else
        {
          i = 8;
        }
      }
      for (;;)
      {
        localActivity.setRequestedOrientation(i);
        MiniAppVideoPlayer.a(this.this$0, localActivity);
        MiniAppVideoPlayer.j(this.this$0);
        MiniAppVideoPlayer.g(this.this$0);
        return;
        if (j <= i) {
          break label526;
        }
        i = 0;
        break;
        m = k;
        break label296;
        label442:
        k = j;
        break label300;
        label447:
        localObject = new FrameLayout.LayoutParams(m, k);
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label349;
        label489:
        if ((this.this$0.d == 180) || (this.this$0.d == -180)) {
          i = 9;
        } else {
          i = 1;
        }
      }
      label526:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.14
 * JD-Core Version:    0.7.0.1
 */