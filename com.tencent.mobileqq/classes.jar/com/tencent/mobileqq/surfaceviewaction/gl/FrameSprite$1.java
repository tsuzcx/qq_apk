package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import bcry;
import bcsl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite$1
  implements Runnable
{
  public FrameSprite$1(bcry parambcry, Context paramContext, SpriteGLView paramSpriteGLView) {}
  
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
        if ((i < bcry.a(this.this$0).length) && (!bcry.a(this.this$0)))
        {
          localObject = new bcsl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, bcry.a(this.this$0)[i]);
          bcry.a(this.this$0, i, (bcsl)localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: read time = " + (System.currentTimeMillis() - l));
        }
        l = System.currentTimeMillis();
        i = j;
        if ((i < bcry.a(this.this$0).length) && (!bcry.a(this.this$0)))
        {
          if ((!bcry.b(this.this$0)) || (i % 2 == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FrameSprite", 2, "FrameSprite: deode:" + i);
            }
            localObject = this.this$0;
            if (bcry.b(this.this$0))
            {
              j = i / 2;
              bcry.a((bcry)localObject, j);
              if ((!bcry.c(this.this$0)) && ((i == this.this$0.g - 1) || (i == bcry.a(this.this$0).length - 1)))
              {
                if ((bcry.a(this.this$0) == 20) && ((int)(System.currentTimeMillis() - l) / this.this$0.g > 50))
                {
                  this.this$0.e(10);
                  bcry.a(this.this$0, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("FrameSprite", 2, "mIsHalf = true");
                  }
                  this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new FrameSprite.1.1(this));
                }
                this.this$0.ax_();
              }
              if (bcry.a(this.this$0) != null)
              {
                j = bcry.a(this.this$0).size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1
 * JD-Core Version:    0.7.0.1
 */