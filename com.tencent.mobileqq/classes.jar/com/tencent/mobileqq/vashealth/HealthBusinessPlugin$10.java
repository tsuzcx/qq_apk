package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$10
  implements SeekBar.OnSeekBarChangeListener
{
  HealthBusinessPlugin$10(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    int i = paramSeekBar.getMax();
    paramSeekBar = this.a.e.keySet().iterator();
    while (paramSeekBar.hasNext())
    {
      Object localObject = (String)paramSeekBar.next();
      localObject = (ISuperPlayer)this.a.d.get(localObject);
      if ((localObject != null) && (paramBoolean) && (i != 0)) {
        ((ISuperPlayer)localObject).seekTo((int)(((ISuperPlayer)localObject).getDurationMs() * paramInt / i));
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.10
 * JD-Core Version:    0.7.0.1
 */