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
    int i = this.jdField_a_of_type_Int;
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
                if (StudyRoomQShadowLauncher.b(this.this$0) != null) {
                  StudyRoomQShadowLauncher.a(this.this$0).a();
                }
                StudyRoomQShadowLauncher.a(this.this$0).onEnterComplete();
                localObject = StudyRoomQShadowLauncher.a(this.this$0);
                if (localObject != null) {
                  ((CountDownLatch)localObject).countDown();
                }
              }
            }
            else if (StudyRoomQShadowLauncher.b(this.this$0) != null) {
              StudyRoomQShadowLauncher.a(this.this$0).a();
            }
          }
          else
          {
            if (StudyRoomQShadowLauncher.d(this.this$0)) {
              i = 60;
            } else {
              i = 30;
            }
            StudyRoomQShadowLauncher.b(this.this$0, i);
          }
        }
        else
        {
          if (StudyRoomQShadowLauncher.d(this.this$0)) {
            i = 50;
          } else {
            i = 10;
          }
          StudyRoomQShadowLauncher.b(this.this$0, i);
        }
      }
    }
    else if (this.jdField_b_of_type_Int != -1) {
      StudyRoomQShadowLauncher.b(this.this$0);
    }
    if ((!StudyRoomQShadowLauncher.e(this.this$0)) && (StudyRoomQShadowLauncher.c(this.this$0) != null))
    {
      localObject = (CharSequence)this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        StudyRoomQShadowLauncher.a(this.this$0).setText((CharSequence)this.jdField_a_of_type_JavaLangString);
      }
      localObject = (CharSequence)this.jdField_b_of_type_JavaLangString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        StudyRoomQShadowLauncher.b(this.this$0).setText((CharSequence)this.jdField_b_of_type_JavaLangString);
      }
      localObject = (CharSequence)this.c;
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
        StudyRoomQShadowLauncher.a(this.this$0).setVisibility(8);
        StudyRoomQShadowLauncher.a(this.this$0).setText((CharSequence)this.c);
        StudyRoomQShadowLauncher.a(this.this$0).setOnClickListener((View.OnClickListener)new StudyRoomQShadowLauncher.updateLaunchStep.1.4(this));
        StudyRoomQShadowLauncher.a(this.this$0).setVisibility(0);
        return;
      }
      StudyRoomQShadowLauncher.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.updateLaunchStep.1
 * JD-Core Version:    0.7.0.1
 */