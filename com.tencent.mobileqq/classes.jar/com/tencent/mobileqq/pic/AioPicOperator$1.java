package com.tencent.mobileqq.pic;

import awdu;
import com.tencent.image.URLDrawable;

public class AioPicOperator$1
  implements Runnable
{
  public AioPicOperator$1(awdu paramawdu, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (this.a.getStatus() == 2) {
      this.a.restartDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioPicOperator.1
 * JD-Core Version:    0.7.0.1
 */