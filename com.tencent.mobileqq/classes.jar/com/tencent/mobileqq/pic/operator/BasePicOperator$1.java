package com.tencent.mobileqq.pic.operator;

import com.tencent.image.URLDrawable;

class BasePicOperator$1
  implements Runnable
{
  BasePicOperator$1(BasePicOperator paramBasePicOperator, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (this.a.getStatus() == 2) {
      this.a.restartDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BasePicOperator.1
 * JD-Core Version:    0.7.0.1
 */