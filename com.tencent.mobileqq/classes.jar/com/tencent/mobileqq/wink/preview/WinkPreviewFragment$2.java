package com.tencent.mobileqq.wink.preview;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.render.player.IPlayer;

class WinkPreviewFragment$2
  implements SeekBar.OnSeekBarChangeListener
{
  WinkPreviewFragment$2(WinkPreviewFragment paramWinkPreviewFragment) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      d1 /= 1000.0D;
      double d2 = WinkPreviewFragment.b(this.a).d();
      Double.isNaN(d2);
      long l = (d2 * d1);
      WinkPreviewFragment.c(this.a).a(l);
      WinkPreviewFragment.a(this.a).setProgress(paramInt);
      WinkPreviewFragment.d(this.a).setText(WinkPreviewFragment.a(this.a, l));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar.getLayoutParams().height = ViewUtils.dpToPx(4.0F);
    paramSeekBar.requestLayout();
    WinkPreviewFragment.e(this.a).b();
    WinkPreviewFragment.f(this.a).setVisibility(0);
    WinkPreviewFragment.g(this.a).setVisibility(8);
    paramSeekBar = WinkPreviewFragment.i(this.a);
    WinkPreviewFragment localWinkPreviewFragment = this.a;
    paramSeekBar.setText(WinkPreviewFragment.a(localWinkPreviewFragment, WinkPreviewFragment.h(localWinkPreviewFragment).d()));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar.getLayoutParams().height = ViewUtils.dpToPx(2.0F);
    paramSeekBar.requestLayout();
    WinkPreviewFragment.j(this.a).a();
    WinkPreviewFragment.g(this.a).setVisibility(8);
    WinkPreviewFragment.f(this.a).setVisibility(8);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.preview.WinkPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */