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
    if (this.val$directionX == 1) {
      if (this.val$count[0] <= 0)
      {
        this.cancelXY[0] = 1;
        if (this.val$directionY != 1) {
          break label202;
        }
        if (this.val$count[1] > 0) {
          break label178;
        }
        this.cancelXY[1] = 1;
      }
    }
    for (;;)
    {
      if ((this.cancelXY[1] == 1) && (this.cancelXY[0] == 1))
      {
        TouchController.access$000(this.this$0).cancel();
        cancel();
      }
      float f1 = this.val$count[0];
      float f2 = TouchController.access$100(this.this$0);
      TouchController.access$200(this.this$0, 0.0F, f1 * f2);
      return;
      this.cancelXY[0] = 0;
      this.val$count[0] -= 3;
      break;
      if (this.val$count[0] >= 0)
      {
        this.cancelXY[0] = 1;
        break;
      }
      this.cancelXY[0] = 0;
      this.val$count[0] += 3;
      break;
      label178:
      this.cancelXY[1] = 0;
      this.val$count[1] -= 3;
      continue;
      label202:
      if (this.val$count[1] >= 0)
      {
        this.cancelXY[1] = 1;
      }
      else
      {
        this.cancelXY[1] = 0;
        this.val$count[1] += 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController.1
 * JD-Core Version:    0.7.0.1
 */