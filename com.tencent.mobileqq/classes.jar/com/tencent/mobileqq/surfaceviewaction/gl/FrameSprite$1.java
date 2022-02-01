package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class FrameSprite$1
  implements Runnable
{
  FrameSprite$1(FrameSprite paramFrameSprite, Context paramContext, SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        long l = System.currentTimeMillis();
        j = 0;
        i = 0;
        Object localObject;
        if ((i < FrameSprite.a(this.this$0).length) && (!FrameSprite.a(this.this$0)))
        {
          localObject = new Texture(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, FrameSprite.a(this.this$0)[i]);
          FrameSprite.a(this.this$0, i, (Texture)localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("FrameSprite: read time = ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          QLog.d("FrameSprite", 2, ((StringBuilder)localObject).toString());
        }
        l = System.currentTimeMillis();
        i = j;
        if ((i < FrameSprite.a(this.this$0).length) && (!FrameSprite.a(this.this$0))) {
          if ((!FrameSprite.b(this.this$0)) || (i % 2 == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("FrameSprite: deode:");
              ((StringBuilder)localObject).append(i);
              QLog.d("FrameSprite", 2, ((StringBuilder)localObject).toString());
            }
            localObject = this.this$0;
            if (!FrameSprite.b(this.this$0)) {
              break label464;
            }
            j = i / 2;
            FrameSprite.a((FrameSprite)localObject, j);
            if ((!FrameSprite.c(this.this$0)) && ((i == this.this$0.g - 1) || (i == FrameSprite.a(this.this$0).length - 1)))
            {
              if ((FrameSprite.a(this.this$0) == 20) && ((int)(System.currentTimeMillis() - l) / this.this$0.g > 50))
              {
                this.this$0.e(10);
                FrameSprite.a(this.this$0, true);
                if (QLog.isColorLevel()) {
                  QLog.d("FrameSprite", 2, "mIsHalf = true");
                }
                this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new FrameSprite.1.1(this));
              }
              this.this$0.aO_();
            }
            if (FrameSprite.a(this.this$0) != null)
            {
              j = FrameSprite.a(this.this$0).size();
              int k = this.this$0.g;
              if (j < k) {}
            }
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FrameSprite: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.d("FrameSprite", 2, localStringBuilder.toString());
        }
      }
      try
      {
        Thread.sleep(16L);
      }
      catch (InterruptedException localInterruptedException) {}
      i += 1;
      continue;
      return;
      continue;
      label464:
      int j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1
 * JD-Core Version:    0.7.0.1
 */