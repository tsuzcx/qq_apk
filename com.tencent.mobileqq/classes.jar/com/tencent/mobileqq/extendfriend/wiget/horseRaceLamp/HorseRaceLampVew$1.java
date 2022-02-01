package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class HorseRaceLampVew$1
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
      int k = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297315);
      int m = (int)DisplayUtils.a(this.this$0.getContext(), HorseRaceLampVew.a(this.this$0));
      j = 0;
      while (j < HorseRaceLampVew.b(this.this$0))
      {
        HorseRaceLampVew.a(this.this$0).add(new RaceLine(j, i, k, m));
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
        localObject = new Tag(HorseRaceLampVew.a(this.this$0).a(i));
        ((Tag)localObject).a(HorseRaceLampVew.c(this.this$0));
        j = HorseRaceLampVew.b(this.this$0);
        ((RaceLine)HorseRaceLampVew.a(this.this$0).get(i % j)).a((Tag)localObject);
        i += 1;
      }
      i = 0;
      while (i < HorseRaceLampVew.a(this.this$0).size())
      {
        ((RaceLine)HorseRaceLampVew.a(this.this$0).get(i)).a();
        i += 1;
      }
      i = 0;
      if (i < HorseRaceLampVew.a(this.this$0).size())
      {
        localObject = ((RaceLine)HorseRaceLampVew.a(this.this$0).get(i)).a();
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            Tag localTag = (Tag)((ArrayList)localObject).get(j);
            View localView = HorseRaceLampVew.a(this.this$0).a(this.this$0.getContext(), localTag.a, this.this$0);
            localView.setTag(localTag);
            localView.setOnClickListener(new HorseRaceLampVew.1.1(this));
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