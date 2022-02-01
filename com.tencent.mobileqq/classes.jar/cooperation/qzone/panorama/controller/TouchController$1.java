package cooperation.qzone.panorama.controller;

import java.util.Timer;
import java.util.TimerTask;

class TouchController$1
  extends TimerTask
{
  private int[] cancelXY = { 0, 0 };
  
  TouchController$1(TouchController paramTouchController, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void run()
  {
    if (this.val$directionX == 1)
    {
      arrayOfInt = this.val$count;
      if (arrayOfInt[0] <= 0)
      {
        this.cancelXY[0] = 1;
      }
      else
      {
        this.cancelXY[0] = 0;
        arrayOfInt[0] -= 3;
      }
    }
    else
    {
      arrayOfInt = this.val$count;
      if (arrayOfInt[0] >= 0)
      {
        this.cancelXY[0] = 1;
      }
      else
      {
        this.cancelXY[0] = 0;
        arrayOfInt[0] += 3;
      }
    }
    if (this.val$directionY == 1)
    {
      arrayOfInt = this.val$count;
      if (arrayOfInt[1] <= 0)
      {
        this.cancelXY[1] = 1;
      }
      else
      {
        this.cancelXY[1] = 0;
        arrayOfInt[1] -= 3;
      }
    }
    else
    {
      arrayOfInt = this.val$count;
      if (arrayOfInt[1] >= 0)
      {
        this.cancelXY[1] = 1;
      }
      else
      {
        this.cancelXY[1] = 0;
        arrayOfInt[1] += 3;
      }
    }
    int[] arrayOfInt = this.cancelXY;
    if ((arrayOfInt[1] == 1) && (arrayOfInt[0] == 1))
    {
      TouchController.access$000(this.this$0).cancel();
      cancel();
    }
    float f1 = this.val$count[0];
    float f2 = TouchController.access$100(this.this$0);
    TouchController.access$200(this.this$0, 0.0F, f1 * f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController.1
 * JD-Core Version:    0.7.0.1
 */