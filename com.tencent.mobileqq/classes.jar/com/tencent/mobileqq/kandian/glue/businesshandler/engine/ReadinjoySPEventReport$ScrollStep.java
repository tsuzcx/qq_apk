package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

public class ReadinjoySPEventReport$ScrollStep
{
  int a;
  long b;
  long c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  float[] l;
  float[] m;
  
  public String a()
  {
    double d1 = this.i;
    Double.isNaN(d1);
    int n = this.j;
    double d2 = n;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = this.b;
    Double.isNaN(d2);
    d2 = 1000.0D * d1 / d2;
    Object localObject = this.l;
    float f1 = localObject[0];
    int i1 = this.k;
    double d3 = f1 / i1;
    double d4 = localObject[1] / n;
    localObject = this.m;
    double d5 = localObject[0] / i1;
    double d6 = localObject[1] / n;
    localObject = new StringBuilder();
    if (this.a == 1) {
      n = 0;
    } else {
      n = 1;
    }
    ((StringBuilder)localObject).append(n);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollStep
 * JD-Core Version:    0.7.0.1
 */