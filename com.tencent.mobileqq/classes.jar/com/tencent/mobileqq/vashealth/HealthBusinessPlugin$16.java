package com.tencent.mobileqq.vashealth;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$16
  implements ISuperPlayer.OnCompletionListener
{
  HealthBusinessPlugin$16(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "Completion video000");
    }
    Iterator localIterator = this.a.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (ISuperPlayer)this.a.l.get(localObject1);
      if ((localObject2 != null) && (localObject2 == paramISuperPlayer))
      {
        ((ISuperPlayer)localObject2).seekTo(0);
        ((ISuperPlayer)localObject2).pause();
        localObject1 = (FrameLayout)this.a.m.get(localObject1);
        localObject2 = (SeekBar)((FrameLayout)localObject1).findViewById(2131445496);
        TextView localTextView1 = (TextView)((FrameLayout)localObject1).findViewById(2131442521);
        TextView localTextView2 = (TextView)((FrameLayout)localObject1).findViewById(2131442520);
        ((FrameLayout)localObject1).post(new HealthBusinessPlugin.16.1(this, (ImageView)((FrameLayout)localObject1).findViewById(2131442519), (SeekBar)localObject2, localTextView1, localTextView2, (ImageView)((FrameLayout)localObject1).findViewById(2131442518), (TextView)((FrameLayout)localObject1).findViewById(2131442517)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.16
 * JD-Core Version:    0.7.0.1
 */