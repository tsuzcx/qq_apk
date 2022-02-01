package io.flutter.plugin.editing;

class TextInputPlugin$2
  implements TextInputPlugin.MinMax
{
  TextInputPlugin$2(TextInputPlugin paramTextInputPlugin, boolean paramBoolean, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2) {}
  
  public void inspect(double paramDouble1, double paramDouble2)
  {
    boolean bool = this.val$isAffine;
    double d1 = 1.0D;
    double d2;
    if (bool)
    {
      d2 = (this.val$matrix[0] * paramDouble1 + this.val$matrix[4] * paramDouble2 + this.val$matrix[12]) * d1;
      paramDouble1 = d1 * (this.val$matrix[1] * paramDouble1 + this.val$matrix[5] * paramDouble2 + this.val$matrix[13]);
      if (d2 >= this.val$minMax[0]) {
        break label145;
      }
      this.val$minMax[0] = d2;
      label93:
      if (paramDouble1 >= this.val$minMax[2]) {
        break label168;
      }
      this.val$minMax[2] = paramDouble1;
    }
    label145:
    label168:
    while (paramDouble1 <= this.val$minMax[3])
    {
      return;
      d1 = 1.0D / (this.val$matrix[3] * paramDouble1 + this.val$matrix[7] * paramDouble2 + this.val$matrix[15]);
      break;
      if (d2 <= this.val$minMax[1]) {
        break label93;
      }
      this.val$minMax[1] = d2;
      break label93;
    }
    this.val$minMax[3] = paramDouble1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin.2
 * JD-Core Version:    0.7.0.1
 */