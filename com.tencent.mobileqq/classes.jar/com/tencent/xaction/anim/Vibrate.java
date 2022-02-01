package com.tencent.xaction.anim;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Vibrate;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "pattern", "", "getPattern", "()[J", "setPattern", "([J)V", "repeat", "", "getRepeat", "()I", "setRepeat", "(I)V", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "setVibrator", "(Landroid/os/Vibrator;)V", "doFrameUpdate", "", "animTime", "", "end", "play", "preStart", "view", "Landroid/view/View;", "startVibrator", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Vibrate
  extends BaseAnim
{
  @Nullable
  private long[] pattern;
  private int repeat = -1;
  @Nullable
  private Vibrator vibrator;
  
  public void doFrameUpdate(float paramFloat) {}
  
  public void end()
  {
    super.end();
    Vibrator localVibrator = this.vibrator;
    if (localVibrator != null) {
      localVibrator.cancel();
    }
  }
  
  @Nullable
  public final long[] getPattern()
  {
    return this.pattern;
  }
  
  public final int getRepeat()
  {
    return this.repeat;
  }
  
  @Nullable
  public final Vibrator getVibrator()
  {
    return this.vibrator;
  }
  
  public void play()
  {
    super.play();
    startVibrator();
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    if (this.vibrator == null)
    {
      paramView = paramView.getContext().getSystemService("vibrator");
      if (paramView != null)
      {
        this.vibrator = ((Vibrator)paramView);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
    }
  }
  
  public final void setPattern(@Nullable long[] paramArrayOfLong)
  {
    this.pattern = paramArrayOfLong;
  }
  
  public final void setRepeat(int paramInt)
  {
    this.repeat = paramInt;
  }
  
  public final void setVibrator(@Nullable Vibrator paramVibrator)
  {
    this.vibrator = paramVibrator;
  }
  
  public final void startVibrator()
  {
    Object localObject = this.vibrator;
    if (localObject != null)
    {
      if (this.pattern != null)
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((Vibrator)localObject).vibrate(this.pattern, this.repeat);
        return;
      }
      if (Build.VERSION.SDK_INT > 25)
      {
        localObject = VibrationEffect.createOneShot(getDuration(), -1);
        Vibrator localVibrator = this.vibrator;
        if (localVibrator == null) {
          Intrinsics.throwNpe();
        }
        localVibrator.vibrate((VibrationEffect)localObject);
        return;
      }
      localObject = this.vibrator;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Vibrator)localObject).vibrate(getDuration());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Vibrate
 * JD-Core Version:    0.7.0.1
 */