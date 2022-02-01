package com.tencent.mobileqq.studyroom.utils;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$updateLaunchStep$1
  implements Runnable
{
  StudyRoomQShadowLauncher$updateLaunchStep$1(StudyRoomQShadowLauncher paramStudyRoomQShadowLauncher, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Function0 paramFunction0) {}
  
  public final void run()
  {
    int i = this.a;
    int j = 1;
    Object localObject;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                StudyRoomQShadowLauncher.b(this.this$0, 100);
                if (StudyRoomQShadowLauncher.h(this.this$0) != null) {
                  StudyRoomQShadowLauncher.g(this.this$0).a();
                }
                StudyRoomQShadowLauncher.j(this.this$0).onEnterComplete();
                localObject = StudyRoomQShadowLauncher.a(this.this$0);
                if (localObject != null) {
                  ((CountDownLatch)localObject).countDown();
                }
              }
            }
            else if (StudyRoomQShadowLauncher.h(this.this$0) != null) {
              StudyRoomQShadowLauncher.g(this.this$0).a();
            }
          }
          else
          {
            if (StudyRoomQShadowLauncher.s(this.this$0)) {
              i = 60;
            } else {
              i = 30;
            }
            StudyRoomQShadowLauncher.b(this.this$0, i);
          }
        }
        else
        {
          if (StudyRoomQShadowLauncher.s(this.this$0)) {
            i = 50;
          } else {
            i = 10;
          }
          StudyRoomQShadowLauncher.b(this.this$0, i);
        }
      }
    }
    else if (this.b != -1) {
      StudyRoomQShadowLauncher.r(this.this$0);
    }
    if ((!StudyRoomQShadowLauncher.t(this.this$0)) && (StudyRoomQShadowLauncher.u(this.this$0) != null))
    {
      localObject = (CharSequence)this.c;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        StudyRoomQShadowLauncher.n(this.this$0).setText((CharSequence)this.c);
      }
      localObject = (CharSequence)this.d;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        StudyRoomQShadowLauncher.o(this.this$0).setText((CharSequence)this.d);
      }
      localObject = (CharSequence)this.e;
      i = j;
      if (localObject != null) {
        if (((CharSequence)localObject).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i == 0)
      {
        StudyRoomQShadowLauncher.q(this.this$0).setVisibility(8);
        StudyRoomQShadowLauncher.p(this.this$0).setText((CharSequence)this.e);
        StudyRoomQShadowLauncher.p(this.this$0).setOnClickListener((View.OnClickListener)new StudyRoomQShadowLauncher.updateLaunchStep.1.4(this));
        StudyRoomQShadowLauncher.p(this.this$0).setVisibility(0);
        return;
      }
      StudyRoomQShadowLauncher.p(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.updateLaunchStep.1
 * JD-Core Version:    0.7.0.1
 */