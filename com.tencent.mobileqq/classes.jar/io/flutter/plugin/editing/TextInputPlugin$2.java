package io.flutter.plugin.editing;

class TextInputPlugin$2
  implements TextInputPlugin.MinMax
{
  public void inspect(double paramDouble1, double paramDouble2)
  {
    boolean bool = this.val$isAffine;
    double d1 = 1.0D;
    if (!bool)
    {
      arrayOfDouble = this.val$matrix;
      d1 = 1.0D / (arrayOfDouble[3] * paramDouble1 + arrayOfDouble[7] * paramDouble2 + arrayOfDouble[15]);
    }
    double[] arrayOfDouble = this.val$matrix;
    double d2 = (arrayOfDouble[0] * paramDouble1 + arrayOfDouble[4] * paramDouble2 + arrayOfDouble[12]) * d1;
    paramDouble1 = (arrayOfDouble[1] * paramDouble1 + arrayOfDouble[5] * paramDouble2 + arrayOfDouble[13]) * d1;
    arrayOfDouble = this.val$minMax;
    if (d2 < arrayOfDouble[0]) {
      arrayOfDouble[0] = d2;
    } else if (d2 > arrayOfDouble[1]) {
      arrayOfDouble[1] = d2;
    }
    arrayOfDouble = this.val$minMax;
    if (paramDouble1 < arrayOfDouble[2])
    {
      arrayOfDouble[2] = paramDouble1;
      return;
    }
    if (paramDouble1 > arrayOfDouble[3]) {
      arrayOfDouble[3] = paramDouble1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.editing.TextInputPlugin.2
 * JD-Core Version:    0.7.0.1
 */