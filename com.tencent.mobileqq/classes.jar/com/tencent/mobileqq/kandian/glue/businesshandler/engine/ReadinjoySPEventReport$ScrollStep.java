package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

public class ReadinjoySPEventReport$ScrollStep
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  float[] jdField_a_of_type_ArrayOfFloat;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  float[] jdField_b_of_type_ArrayOfFloat;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  
  public String a()
  {
    double d1 = this.g;
    Double.isNaN(d1);
    int j = this.h;
    double d2 = j;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = this.jdField_a_of_type_Long;
    Double.isNaN(d2);
    d2 = 1000.0D * d1 / d2;
    Object localObject = this.jdField_a_of_type_ArrayOfFloat;
    float f1 = localObject[0];
    int k = this.i;
    double d3 = f1 / k;
    double d4 = localObject[1] / j;
    localObject = this.b;
    double d5 = localObject[0] / k;
    double d6 = localObject[1] / j;
    localObject = new StringBuilder();
    if (this.jdField_a_of_type_Int == 1) {
      j = 0;
    } else {
      j = 1;
    }
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d2) }));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d4) }));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d3) }));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d6) }));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.format("%.2f", new Object[] { Double.valueOf(d5) }));
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollStep
 * JD-Core Version:    0.7.0.1
 */