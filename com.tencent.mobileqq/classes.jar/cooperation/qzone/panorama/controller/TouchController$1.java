package cooperation.qzone.panorama.controller;

import bfyk;
import java.util.Timer;
import java.util.TimerTask;

public class TouchController$1
  extends TimerTask
{
  private int[] jdField_b_of_type_ArrayOfInt = { 0, 0 };
  
  public TouchController$1(bfyk parambfyk, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_ArrayOfInt[0] <= 0)
      {
        this.jdField_b_of_type_ArrayOfInt[0] = 1;
        if (this.jdField_b_of_type_Int != 1) {
          break label202;
        }
        if (this.jdField_a_of_type_ArrayOfInt[1] > 0) {
          break label178;
        }
        this.jdField_b_of_type_ArrayOfInt[1] = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ArrayOfInt[1] == 1) && (this.jdField_b_of_type_ArrayOfInt[0] == 1))
      {
        bfyk.a(this.this$0).cancel();
        cancel();
      }
      float f1 = this.jdField_a_of_type_ArrayOfInt[0];
      float f2 = bfyk.a(this.this$0);
      bfyk.a(this.this$0, 0.0F, f1 * f2);
      return;
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[0] -= 3;
      break;
      if (this.jdField_a_of_type_ArrayOfInt[0] >= 0)
      {
        this.jdField_b_of_type_ArrayOfInt[0] = 1;
        break;
      }
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[0] += 3;
      break;
      label178:
      this.jdField_b_of_type_ArrayOfInt[1] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] -= 3;
      continue;
      label202:
      if (this.jdField_a_of_type_ArrayOfInt[1] >= 0)
      {
        this.jdField_b_of_type_ArrayOfInt[1] = 1;
      }
      else
      {
        this.jdField_b_of_type_ArrayOfInt[1] = 0;
        this.jdField_a_of_type_ArrayOfInt[1] += 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController.1
 * JD-Core Version:    0.7.0.1
 */