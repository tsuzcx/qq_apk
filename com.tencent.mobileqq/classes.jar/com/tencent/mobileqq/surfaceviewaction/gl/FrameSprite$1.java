package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import bdyh;
import bdyu;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite$1
  implements Runnable
{
  public FrameSprite$1(bdyh parambdyh, Context paramContext, SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        long l = System.currentTimeMillis();
        i = 0;
        Object localObject;
        if ((i < bdyh.a(this.this$0).length) && (!bdyh.a(this.this$0)))
        {
          localObject = new bdyu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, bdyh.a(this.this$0)[i]);
          bdyh.a(this.this$0, i, (bdyu)localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: read time = " + (System.currentTimeMillis() - l));
        }
        l = System.currentTimeMillis();
        i = j;
        if ((i < bdyh.a(this.this$0).length) && (!bdyh.a(this.this$0)))
        {
          if ((!bdyh.b(this.this$0)) || (i % 2 == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FrameSprite", 2, "FrameSprite: deode:" + i);
            }
            localObject = this.this$0;
            if (bdyh.b(this.this$0))
            {
              j = i / 2;
              bdyh.a((bdyh)localObject, j);
              if ((!bdyh.c(this.this$0)) && ((i == this.this$0.g - 1) || (i == bdyh.a(this.this$0).length - 1)))
              {
                if ((bdyh.a(this.this$0) == 20) && ((int)(System.currentTimeMillis() - l) / this.this$0.g > 50))
                {
                  this.this$0.e(10);
                  bdyh.a(this.this$0, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("FrameSprite", 2, "mIsHalf = true");
                  }
                  this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new FrameSprite.1.1(this));
                }
                this.this$0.aJ_();
              }
              if (bdyh.a(this.this$0) != null)
              {
                j = bdyh.a(this.this$0).size();
                int k = this.this$0.g;
                if (j >= k)
                {
                  try
                  {
                    Thread.sleep(16L);
                  }
                  catch (InterruptedException localInterruptedException) {}
                  continue;
                }
              }
            }
            else
            {
              j = i;
              continue;
            }
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: " + QLog.getStackTraceString(localException));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1
 * JD-Core Version:    0.7.0.1
 */