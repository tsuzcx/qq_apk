package com.tencent.mobileqq.wink.editor.music.fragments;

import android.widget.TextView;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.StartPointSeekBar.OnSeekBarChangeListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment$initViews$1$1", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$OnSeekBarChangeListener;", "curValue", "", "getCurValue", "()I", "setCurValue", "(I)V", "interceptVolumeChange", "", "getInterceptVolumeChange", "()Z", "setInterceptVolumeChange", "(Z)V", "onProgressChanged", "", "bar", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "value", "onStartTrackingTouch", "seekbar", "onStopTrackingTouch", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicVolumeControlFragment$initViews$$inlined$apply$lambda$1
  implements StartPointSeekBar.OnSeekBarChangeListener
{
  private boolean b;
  private int c = -1;
  
  MusicVolumeControlFragment$initViews$$inlined$apply$lambda$1(MusicVolumeControlFragment paramMusicVolumeControlFragment) {}
  
  public void a(@Nullable StartPointSeekBar paramStartPointSeekBar)
  {
    this.b = true;
  }
  
  public void a(@Nullable StartPointSeekBar paramStartPointSeekBar, int paramInt)
  {
    if ((this.c >= 0) && (!this.b)) {
      MusicVolumeControlFragment.a(this.a).a(MusicVolumeControlFragment.a(this.a, paramInt), MusicVolumeControlViewModel.VolumeType.ORIGIN);
    }
    this.c = paramInt;
    paramStartPointSeekBar = (StartPointSeekBar)this.a.a(2131446067);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append('%');
    StartPointSeekBar.a(paramStartPointSeekBar, localStringBuilder.toString(), (TextView)this.a.a(2131448233));
  }
  
  public void b(@Nullable StartPointSeekBar paramStartPointSeekBar)
  {
    this.b = false;
    MusicVolumeControlFragment.a(this.a).a(MusicVolumeControlFragment.a(this.a, this.c), MusicVolumeControlViewModel.VolumeType.ORIGIN);
    MusicVolumeControlFragment.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.initViews..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */