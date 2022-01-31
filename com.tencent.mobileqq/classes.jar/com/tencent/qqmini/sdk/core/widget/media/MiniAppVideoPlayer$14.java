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
import bglv;
import bgmf;
import bgmq;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
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
      } while (this.this$0.a == null);
      localActivity = (Activity)this.this$0.a.get();
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    this.this$0.c = true;
    MiniAppVideoPlayer.e(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.d(this.this$0).setVisibility(0);
    Object localObject;
    int j;
    int k;
    int i;
    if (this.this$0.b != null)
    {
      localObject = (bglv)this.this$0.b.get();
      if (localObject != null)
      {
        MiniAppVideoPlayer.d(this.this$0, bgmf.a((bglv)localObject).b());
        MiniAppVideoPlayer.e(this.this$0, bgmf.a((bglv)localObject).a());
        bgmq.a((bglv)localObject).b(8);
        bgmq.a((bglv)localObject).a(8);
      }
      MiniAppVideoPlayer.a(this.this$0, ((CoverVideoView)this.this$0.getParent()).getLayoutParams());
      if (this.this$0.getParent().getParent() != null)
      {
        MiniAppVideoPlayer.f(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
        ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
      }
      if (MiniAppVideoPlayer.a(this.this$0) == null) {
        break label604;
      }
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
      if ((MiniAppVideoPlayer.h(this.this$0) != 0) && (MiniAppVideoPlayer.h(this.this$0) != 180)) {
        break label504;
      }
      if (j >= i) {
        break label604;
      }
      i = 0;
    }
    for (;;)
    {
      label339:
      j = DisplayUtil.getRealHeight(this.this$0.getContext());
      k = DisplayUtil.getScreenWidth(this.this$0.getContext());
      int m;
      if (i != 0)
      {
        m = j;
        label368:
        if (i == 0) {
          break label520;
        }
        label372:
        if (this.this$0.b != null) {
          break label525;
        }
        localObject = new RelativeLayout.LayoutParams(m, k);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        label421:
        localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
        if (i == 0) {
          break label567;
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
        localObject = null;
        break;
        label504:
        if (j <= i) {
          break label604;
        }
        i = 0;
        break label339;
        m = k;
        break label368;
        label520:
        k = j;
        break label372;
        label525:
        localObject = new FrameLayout.LayoutParams(m, k);
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label421;
        label567:
        if ((this.this$0.d == 180) || (this.this$0.d == -180)) {
          i = 9;
        } else {
          i = 1;
        }
      }
      label604:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.14
 * JD-Core Version:    0.7.0.1
 */