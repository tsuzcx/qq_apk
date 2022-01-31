package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import aqiz;
import aqjb;
import aqjc;
import aqjd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HorseRaceLampVew$1
  implements Runnable
{
  HorseRaceLampVew$1(HorseRaceLampVew paramHorseRaceLampVew) {}
  
  public void run()
  {
    if (!HorseRaceLampVew.a(this.this$0))
    {
      int j = this.this$0.getWidth();
      QLog.i("HorseRaceLampVew + horserace", 2, "INIT WIDH : " + j);
      HorseRaceLampVew.a(this.this$0);
      int i = j;
      if (j == 0)
      {
        i = ((WindowManager)this.this$0.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        QLog.e("HorseRaceLampVew + horserace", 2, "INIT WIDH in screen Width: " + i);
      }
      int k = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297165);
      int m = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297169);
      j = 0;
      while (j < 4)
      {
        HorseRaceLampVew.a(this.this$0).add(new aqjb(j, i, k, m));
        j += 1;
      }
      if (HorseRaceLampVew.a(this.this$0) == null)
      {
        QLog.e("HorseRaceLampVew + horserace", 2, "Adapter null ");
        return;
      }
      i = 0;
      Object localObject;
      while (i < HorseRaceLampVew.a(this.this$0).a())
      {
        localObject = new aqjc(HorseRaceLampVew.a(this.this$0).a(i));
        ((aqjb)HorseRaceLampVew.a(this.this$0).get(i % 4)).a((aqjc)localObject);
        i += 1;
      }
      i = 0;
      while (i < HorseRaceLampVew.a(this.this$0).size())
      {
        ((aqjb)HorseRaceLampVew.a(this.this$0).get(i)).a();
        i += 1;
      }
      i = 0;
      if (i < HorseRaceLampVew.a(this.this$0).size())
      {
        localObject = ((aqjb)HorseRaceLampVew.a(this.this$0).get(i)).a();
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            aqjc localaqjc = (aqjc)((ArrayList)localObject).get(j);
            View localView = HorseRaceLampVew.a(this.this$0).a(this.this$0.getContext(), localaqjc.a, this.this$0);
            localView.setTag(localaqjc);
            localView.setOnClickListener(new aqiz(this));
            this.this$0.addView(localView);
            localView.setVisibility(4);
            j += 1;
          }
        }
      }
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.1
 * JD-Core Version:    0.7.0.1
 */